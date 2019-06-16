// [GonBee]
// パーティーBOT機能の外部から参照される関数を定義する。

#include "pybot_internal.hpp"

namespace pybot {

// -----------------------------------------------------------------------------
// 外部から参照される関数の定義
	
// MVPの周回を進める。
void advance_mvp_round(
	int cid // キャラクターID。
) {
	sql_session::open([cid] (sql_session* ses) {
		ses->execute(
			"UPDATE `pybot_mvp_stats` "
			"SET"
			" `round` = `round` + 1,"
			" `mobs` = 0 "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		ses->execute(
			"DELETE FROM `pybot_mvp` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	});
}

// ベースレベル倍率を計算する。
double // 計算した倍率。
base_level_rate(
	block_list* bl, // ブロックリスト。
	mob_data* md    // モンスターデータ。
) {
	double pc_rat = status_get_lv(bl) / 20.;
	int mob_lv = status_get_lv(&md->bl);
	if (mob_is_pure_flora(md)) mob_lv = 1;
	double mob_rat = mob_lv / 20.;
	return std::max(std::max(pc_rat, 1.) * std::max(mob_rat, 1.), 2.);
}

// Botが武具を鑑定する。
// Botではないなら何もしない。
// すでに鑑定済みなら何もしない。
// アイテム鑑定を使用可能であれば何も消費せずに鑑定する。
// 所持アイテムかカートに拡大鏡があればそれを消費して鑑定する。
// アイテム鑑定を使用不可、かつ拡大鏡がなければ何もしない。
void bot_identify_equip(
	int cid,
	item* itm
) {
	block_if* bot = find_map_data(all_bots, cid);
	if (bot) bot->identify_equip(itm);
}

// キャラクターIDがBotかを判定する。
bool // 結果。
char_is_bot(
	int cid // キャラクターID。
) {
	return find_map_data(all_bots, cid);
}

// カードを別のカードに変換する。
int // 変換したカードID。
convert_card(
	int car_id // カードID。
) {
	return card_converter::instance->convert(car_id);
}

// パーティーBOT機能を終了する。
void do_final() {
	delete_timer(ai_timer, ai_t::timer_func);
}

// パーティーBOT機能を初期化する。
void do_init() {
	load_maps();
	update_fever();
	skill_mobs::instance = construct<skill_mobs>();
	card_converter::instance = construct<card_converter>();
	add_timer_func_list(ai_t::timer_func, "pybot_ai");
	ai_timer = add_timer_interval(
		gettick() + battle_config.pybot_think_time,
		ai_t::timer_func,
		0,
		0,
		battle_config.pybot_think_time
	);
}

// 装備部位順序を装備インデックスに変換する。
equip_index // 変換した装備インデックス。変換できなければINT_MIN。
equip_pos_order_to_index(
	int ord // 装備部位順序。
) {
	equip_index ind = equip_index(INT_MIN);
	if (ord >= 0 &&
		ord < EPO2EQI_TABLE.size()
	) ind = EPO2EQI_TABLE[ord];
	return ind;
}

// ドロップアイテムが無視アイテムかを判定する。
bool // 結果。
flooritem_to_be_ignored(
	map_session_data* sd, // セッションデータ。
	flooritem_data* fit   // ドロップアイテム。
) {
	auto lea = find_map_data(all_leaders, sd->status.char_id);
	if (!lea) {
		lea = construct<leader_t>(sd);
		all_leaders[lea->char_id()] = lea;
	}
	return lea->ignore_items()->find(fit->item.nameid) &&
		!fit->item.card[0] &&
		!fit->item.refine;
}

// 装備部位名を取得する。
const char* get_equip_pos_name(equip_index equ_ind) {
	return EQUIP_POS_NAME_TABLE[equ_ind].c_str();
}

// Botのリーダーを取得する。
map_session_data* // 取得したリーダー。
                  // Botではないか、リーダーがログアウトしているならnullptr。
get_leader(
	int cid // キャラクターID。
) {
	block_if* bot = find_map_data(all_bots, cid);
	map_session_data* lea = nullptr;
	if (bot) lea = map_id2sd(bot->leader()->account_id());
	return lea;
}

// 現在のマップの初期位置を取得する。
block_list* // 取得した位置。
get_map_initial_position(
	map_session_data* sd // セッションデータ。
) {
	auto pos = find_map_data(map_initial_positions, sd->status.char_id);
	if (pos) return pos.get();
	else return &sd->bl;
}

// ジョブレベル倍率を計算する。
double // 計算した倍率。
job_level_rate(
	map_session_data* sd, // セッションデータ。
	block_list* bl        // ブロックリスト。
) {
	double pc_rat = std::min(int(sd->status.job_level), 50) / 10.;
	double mob_rat = status_get_lv(bl) / 20.;
	return std::max(std::max(pc_rat, 1.) * std::max(mob_rat, 1.), 2.);
}

// 文字が全角文字の最初のバイトかを判定する。
bool // 結果。
letter_is_jlead(
	uint8_t let // バイト。
) {
    return (let >= 0x80 &&
            let <= 0x9f
        ) || (let >= 0xe0 &&
            let <= 0xfc
        );
}

// マップ倍率を取得する。
double // 取得した倍率。
map_rate(
	int m // マップID。
) {
	return find_map_data(fever_rates, m, 100) / 100.;
}

// PCがMVPを獲得したことを記録する。
// 血塗られた古木の枝、または砦の試練で出現させたモンスターの場合は記録しない。
void pc_acquired_mvp(
	int cid,     // キャラクターID。
	mob_data* md // モンスターデータ。
) {
	std::string eve(md->npc_event);
	if (eve.substr(0, BLOODY_DEAD_BRANCH_NPC_NAME.length()) != BLOODY_DEAD_BRANCH_NPC_NAME &&
		eve.substr(0, CASTLE_TRIAL_NPC_NAME.length()) != CASTLE_TRIAL_NPC_NAME
	) {
		sql_session::open([cid, md] (sql_session* ses) {
			ses->execute(
				"INSERT INTO `pybot_mvp` "
				"(`char_id`,"
				" `mob_id`) "
				"SELECT"
				" ", construct<sql_param>(cid       ), ","
				" ", construct<sql_param>(md->mob_id), " "
				"FROM dual "
				"WHERE NOT EXISTS("
					"SELECT * "
					"FROM `pybot_mvp` "
					"WHERE"
					" `char_id` = ", construct<sql_param>(cid       ), " AND"
					" `mob_id` = " , construct<sql_param>(md->mob_id), ")"
			);
			int mobs;
			ses->execute(
				"SELECT ", construct<sql_column>("COUNT(*)", mobs), " "
				"FROM `pybot_mvp` "
				"WHERE `char_id` = ", construct<sql_param>(cid)
			);
			ses->next_row();
			ses->execute(
				"INSERT INTO `pybot_mvp_stats`"
				"(`char_id`,"
				" `round`,"
				" `mobs`) "
				"VALUES"
				"(", construct<sql_param>(cid), ","
				" ", construct<sql_param>(0), ","
				" ", construct<sql_param>(mobs), ") "
				"ON DUPLICATE KEY UPDATE `mobs` = ", construct<sql_param>(mobs)
			);
		});
	}
}

// PCがドロップアイテムを拾えるかを判定する。
bool // 結果。
pc_can_takeitem(
	map_session_data* sd, // セッションデータ。
	flooritem_data* fit   // ドロップアイテム。
) {
	now = gettick();
	auto can_take = [sd] (int get_charid, t_tick get_tick) -> bool	{
		if (!get_charid ||
			get_charid == sd->status.char_id ||
			DIFF_TICK(now, get_tick) >= 0
		) return true;
		map_session_data* get_sd = map_charid2sd(get_charid);
		if (!get_sd) return true;
		return get_sd->status.party_id == sd->status.party_id;
	};
	return can_take(fit->first_get_charid, fit->first_get_tick) ||
		can_take(fit->second_get_charid, fit->second_get_tick) ||
		can_take(fit->third_get_charid, fit->third_get_tick);
}

// PCがMVPを獲得したことがあるかを判定する。
bool // 結果。
pc_has_acquired_mvp(
	int cid,
	int mid
) {
	bool res = false;
	sql_session::open([cid, mid, &res] (sql_session* ses) {
		int cou;
		ses->execute(
			"SELECT ", construct<sql_column>("COUNT(*)", cou), " "
			"FROM `pybot_mvp` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `mob_id` = ", construct<sql_param>(mid)
		);
		res = ses->next_row() &&
			cou;
	});
	return res;
}

// MVPランキングを照会する。
std::shared_ptr<std::vector<std::shared_ptr<mvp_stats>>> // 照会したMVPランキング。
query_mvp_ranking(
	const std::vector<e_job>& jobs, // 職業のベクタ。
	int lim                         // 最大行数。
) {
	auto res = initialize<std::vector<ptr<mvp_stats>>>();
	if (jobs.size() == 1 &&
		jobs.front() == -1
	) {
		sql_session::open([lim, &res] (sql_session* ses) {
			char nam[NAME_LENGTH];
			int cla;
			int rou;
			int mobs;
			ses->execute(
				"SELECT"
				" ", construct<sql_column>("`char`.`name`"            , nam ), ","
				" ", construct<sql_column>("`char`.`class`"           , cla ), ","
				" ", construct<sql_column>("`pybot_mvp_stats`.`round`", rou ), ","
				" ", construct<sql_column>("`pybot_mvp_stats`.`mobs`" , mobs), " "
				"FROM"
				" `char`,"
				" `pybot_mvp_stats` "
				"WHERE `char`.`char_id` = `pybot_mvp_stats`.`char_id` "
				"ORDER BY"
				" `pybot_mvp_stats`.`round` DESC,"
				" `pybot_mvp_stats`.`mobs` DESC "
				"LIMIT ", construct<sql_param>(lim)
			);
			while (ses->next_row())
				res->push_back(initialize<mvp_stats>(nam, e_job(cla), rou, mobs));
		});
	} else {
		std::vector<std::string> job_strs;
		std::transform(
			ALL_RANGE(jobs),
			pybot::back_inserter(job_strs),
			[] (e_job job) -> std::string {return print(job);}
		);
		std::string job_lis = concatinate_strings(ALL_RANGE(job_strs), ", ");
		sql_session::open([lim, &res, &job_lis] (sql_session* ses) {
			char nam[NAME_LENGTH];
			int cla;
			int rou;
			int mobs;
			ses->execute(
				"SELECT"
				" ", construct<sql_column>("`char`.`name`"            , nam ), ","
				" ", construct<sql_column>("`char`.`class`"           , cla ), ","
				" ", construct<sql_column>("`pybot_mvp_stats`.`round`", rou ), ","
				" ", construct<sql_column>("`pybot_mvp_stats`.`mobs`" , mobs), " "
				"FROM"
				" `char`,"
				" `pybot_mvp_stats` "
				"WHERE"
				" `char`.`class` IN (", job_lis, ") AND"
				" `char`.`char_id` = `pybot_mvp_stats`.`char_id` "
				"ORDER BY"
				" `pybot_mvp_stats`.`round` DESC,"
				" `pybot_mvp_stats`.`mobs` DESC "
				"LIMIT ", construct<sql_param>(lim)
			);
			while (ses->next_row())
				res->push_back(initialize<mvp_stats>(nam, e_job(cla), rou, mobs));
		});
	}
	return res;
}

// MVP統計を照会する。
std::shared_ptr<mvp_stats> // 照会したMVP統計。
query_mvp_stats(
	int cid // キャラクターID。
) {
	ptr<mvp_stats> res;
	sql_session::open([cid, &res] (sql_session* ses) {
		char nam[NAME_LENGTH];
		int cla;
		int rou;
		int mobs;
		ses->execute(
			"SELECT"
			" ", construct<sql_column>("`char`.`name`", nam), ","
			" ", construct<sql_column>("`char`.`class`", cla), ","
			" ", construct<sql_column>("`pybot_mvp_stats`.`round`", rou), ","
			" ", construct<sql_column>("`pybot_mvp_stats`.`mobs`", mobs), " "
			"FROM"
			" `char`,"
			" `pybot_mvp_stats` "
			"WHERE"
			" `char`.`char_id` = ", construct<sql_param>(cid), " AND"
			" `char`.`char_id` = `pybot_mvp_stats`.`char_id`"
		);
		if (ses->next_row())
			res = initialize<mvp_stats>(nam, e_job(cla), rou, mobs);
	});
	return res;
}

// Botが戦闘中に武具一式をリロードする。
void reload_equipset_in_battle(
	int cid // キャラクターID。
) {
	block_if* bot = find_map_data(all_bots, cid);
	if (bot) bot->last_reloaded_equipset_tick() = 0;
}

// 現在のマップの初期位置を設定する。
void set_map_initial_position(
	map_session_data* sd // セッションデータ。
) {
	auto pos = find_map_data(map_initial_positions, sd->status.char_id);
	if (!pos) {
		pos = initialize<block_list>(sd->bl);
		map_initial_positions[sd->status.char_id] = pos;
	} else if (pos->m != sd->bl.m) *pos = sd->bl;

}

// スキルがランドプロテクター上に設置可能かを判定する。
bool // 結果。
skill_is_layable_on_lp(
	e_skill kid // スキルID。
) {
	return KEY_EXISTS(LAYABLE_ON_LP_SKILLS, kid);
}

}
