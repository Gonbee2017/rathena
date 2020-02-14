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
	CS_ENTER;
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
	CS_ENTER;
	block_if* bot = find_map_data(all_bots, cid);
	if (bot) bot->identify_equip(itm);
}

// レベル倍率を計算する。
double // 計算した倍率。
calculate_level_rate(
	block_list* bl, // ブロックリスト。
	mob_data* md    // モンスターデータ。
) {
	CS_ENTER;
	int lv = status_get_lv(bl);
	if (md &&
		mob_is_pure_flora(md)
	) lv = 1;
	double rat = (lv + 1) / 20.;
	rat *= rat;
	return std::max(rat, 2.);
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
	CS_ENTER;
	return card_converter::instance->convert(car_id);
}

// パーティーBOT機能を終了する。
void do_final() {
	delete_timer(ai_timer, ai_t::timer_func);
}

// パーティーBOT機能を初期化する。
void do_init() {
	CS_ENTER;
	initialize_sc_types();
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

// モンスターデータを探す。
int // 見つかったモンスターID。見つからなかったら0。
find_mobdb(
	const std::string& nam // モンスター名。
) {
	CS_ENTER;
	using ele_lis = std::list<ptr<command_element>>;
	using ele_lis_lis = std::list<ptr<ele_lis>>;
	using str_lis = std::vector<std::string>;

	auto eles = initialize<ele_lis>(initialize<command_element>(CET_LITERAL, nam));
	eles = command_parse_tokens<ele_lis>(ALL_RANGE(*eles), "|", false, true);
	eles = command_parse_blocks<ele_lis>(ALL_RANGE(*eles), "<", ">", false, true);
	auto tag_blos = command_collect_blocks<ele_lis_lis>(ALL_RANGE(*eles), "<", ">", true);
	if (tag_blos->size() > 1) return 0;

	bool cau = false;
	if (!tag_blos->empty()) {
		auto tag_toks = command_collect_tokens<ele_lis_lis>(ALL_RANGE(*tag_blos->front()), "|", true);
		auto tag_strs = command_print_all<str_lis>(ALL_RANGE(*tag_toks));
		for (const std::string& tag_str : *tag_strs) {
			if (tag_str == CAUTION_TAG) {
				cau = true;
				continue;
			}
		}
	}

	auto pay_eles = initialize<ele_lis>();
	for (auto ele : *eles) {
		if (ele->type == CET_OPEN) break;
		pay_eles->push_back(ele);
	}
	std::string pay_str = trim(command_print(ALL_RANGE(*pay_eles)), " \t");

	int mid = parse_id(pay_str);
	if (mid) {
		if (mid == INT_MIN ||
			!mob_db(mid)
		) mid = 0;
	} else {
		meta_mobs met_mob = find_map_key(META_MONSTER_NAMES, pay_str);
		if (met_mob) return met_mob;
		int rac_ind = find_name(RACE_NAME_TABLE, pay_str);
		if (rac_ind != INT_MIN) return MM_RACE + rac_ind;
		int ele_ind = find_name(ELEMENT_NAME_TABLE, pay_str);
		if (ele_ind != INT_MIN) return MM_ELEMENT + ele_ind;
		int siz_ind = find_name(SIZE_NAME_TABLE, pay_str);
		if (siz_ind != INT_MIN) return MM_SIZE + siz_ind;
		uint16 mids[256];
		std::string pay_str_lc = lowercase(pay_str);
		int cou = mobdb_searchname_array2(pay_str_lc.c_str(), mids, 256);
		for (int i = 0; i < cou; i++) {
			struct mob_db* mdb = mob_db(mids[i]);
			if (mdb &&
				lowercase(mdb->jname) == pay_str_lc
			) {
				mid = mids[i];
				break;
			}
		}
	}
	if (mid &&
		cau
	) mid += MM_CAUTION;
	return mid;
}

// ドロップアイテムが無視アイテムかを判定する。
bool // 結果。
flooritem_to_be_ignored(
	map_session_data* sd, // リーダーのセッションデータ。
	flooritem_data* fit   // ドロップアイテム。
) {
	CS_ENTER;
	block_if* lea = ensure_leader(sd);
	return lea->flooritem_to_be_ignored(fit);
}

// 装備部位名を取得する。
const char* get_equip_pos_name(equip_index equ_ind) {
	return EQUIP_POS_NAME_TABLE[equ_ind].c_str();
}

// 最後に枝召喚したIDを取得する。
int // 取得したID。
get_last_summoned_id(
	map_session_data* sd // リーダーのセッションデータ。
) {
	CS_ENTER;
	return ensure_leader(sd)->last_summoned_id();
}

// 現在のマップの初期位置を取得する。
block_list* // 取得した位置。
get_map_initial_position(
	map_session_data* sd // セッションデータ。
) {
	CS_ENTER;
	auto pos = find_map_data(map_initial_positions, sd->status.char_id);
	if (pos) return pos.get();
	else return &sd->bl;
}

// 日本語のマップ名を取得する。
std::string // 取得した日本語のマップ名。
get_map_name_japanese(
	int mid // マップID。
) {
	CS_ENTER;
	std::string nam_jap;
	auto map = find_map_data(id_maps, mid);
	if (map) nam_jap = map->name_japanese;
	return nam_jap;
}

// 日本語のマップ名を取得する。
std::string // 取得した日本語のマップ名。
get_map_name_japanese(
	const std::string& nam_eng // 英語のマップ名。
) {
	CS_ENTER;
	return get_map_name_japanese(map_mapindex2mapid(mapindex_name2id(nam_eng.c_str())));
}

// Botのチームリーダーを取得する。
map_session_data* // 取得したリーダー。
                  // Botではないか、リーダーがログアウトしているならnullptr。
get_team_leader(
	int cid // キャラクターID。
) {
	CS_ENTER;
	block_if* bot = find_map_data(all_bots, cid);
	map_session_data* lea = nullptr;
	if (bot) lea = map_id2sd(bot->leader()->account_id());
	return lea;
}

// チームメンバーのリストを取得する。
std::shared_ptr<std::vector<std::shared_ptr<member_info>>> // 取得したリスト。
get_team_member_list(
	map_session_data* sd // チームリーダーのセッションデータ。
) {
	CS_ENTER;
	block_if* lea = ensure_leader(sd);
	auto lis = initialize<std::vector<std::shared_ptr<member_info>>>();
	for (block_if* mem : lea->members())
		lis->push_back(initialize<member_info>(
			mem->account_id(),
			mem->char_id(),
			mem->name(),
			e_job(mem->sd()->status.class_)
		));
	return lis;
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
	CS_ENTER;
	double rat = 0.;
	map_data* mpd = map_getmapdata(m);
	if (mpd->instance_id) rat = 2.;
	else rat = find_map_data(fever_rates, m, 100) / 100.;
	return rat;
}

// PCがMVPを獲得したことを記録する。
// 血塗られた古木の枝、または砦の試練で出現させたモンスターの場合は記録しない。
void pc_acquired_mvp(
	map_session_data* sd, // セッションデータ。
	mob_data* md          // モンスターデータ。
) {
	CS_ENTER;
	if (mob_is_normal_mvp(md)) {
		sql_session::open([sd, md] (sql_session* ses) {
			ses->execute(
				"REPLACE INTO `pybot_mvp` "
				"VALUES"
				"(", construct<sql_param>(sd->status.char_id), ","
				" ", construct<sql_param>(md->mob_id        ), ")"
			);
			int mobs;
			ses->execute(
				"SELECT ", construct<sql_column>("COUNT(*)", mobs), " "
				"FROM `pybot_mvp` "
				"WHERE `char_id` = ", construct<sql_param>(sd->status.char_id)
			);
			ses->next_row();
			ses->execute(
				"INSERT INTO `pybot_mvp_stats` "
				"VALUES"
				"(", construct<sql_param>(sd->status.char_id), ","
				" ", construct<sql_param>(0), ","
				" ", construct<sql_param>(mobs), ") "
				"ON DUPLICATE KEY UPDATE `mobs` = ", construct<sql_param>(mobs)
			);
		});
	}
}

// モンスターが通常のMVPモンスターであるかを判定する。
bool // 結果。
mob_is_normal_mvp(
	mob_data* md // モンスターデータ。
) {
	std::string eve(md->npc_event);
	return status_has_mode(&md->status, MD_MVP) &&
		eve.substr(0, PYBOT_DUMMY_NPC_NAME.length()) != PYBOT_DUMMY_NPC_NAME &&
		eve.substr(0, CASTLE_TRIAL_NPC_NAME.length()) != CASTLE_TRIAL_NPC_NAME;
}

// Botの最大拾得率をオーバーするかを判定する。
bool // 結果。
over_loot(
	int cid,    // キャラクターID。
	int wei_inc // 重量の増分。
) {
	bool res = false;
	block_if* bot = find_map_data(all_bots, cid);
	if (bot) res = bot->over_loot(wei_inc);
	return res;
}

// PCがドロップアイテムを拾えるかを判定する。
bool // 結果。
pc_can_takeitem(
	map_session_data* sd, // セッションデータ。
	flooritem_data* fit   // ドロップアイテム。
) {
	CS_ENTER;
	now = gettick();
	struct party_data *p = NULL;
	if (sd->status.party_id)
		p = party_search(sd->status.party_id);
	if (fit->first_get_charid > 0 && fit->first_get_charid != sd->status.char_id) {
		struct map_session_data *first_sd = map_charid2sd(fit->first_get_charid);
		if (DIFF_TICK(now,fit->first_get_tick) < 0) {
			if (!(p && p->party.item&1 &&
				first_sd && first_sd->status.party_id == sd->status.party_id
				))
				return false;
		}
		else if (fit->second_get_charid > 0 && fit->second_get_charid != sd->status.char_id) {
			struct map_session_data *second_sd = map_charid2sd(fit->second_get_charid);
			if (DIFF_TICK(now, fit->second_get_tick) < 0) {
				if (!(p && p->party.item&1 &&
					((first_sd && first_sd->status.party_id == sd->status.party_id) ||
					(second_sd && second_sd->status.party_id == sd->status.party_id))
					))
					return false;
			}
			else if (fit->third_get_charid > 0 && fit->third_get_charid != sd->status.char_id){
				struct map_session_data *third_sd = map_charid2sd(fit->third_get_charid);
				if (DIFF_TICK(now,fit->third_get_tick) < 0) {
					if(!(p && p->party.item&1 &&
						((first_sd && first_sd->status.party_id == sd->status.party_id) ||
						(second_sd && second_sd->status.party_id == sd->status.party_id) ||
						(third_sd && third_sd->status.party_id == sd->status.party_id))
						))
						return false;
				}
			}
		}
	}
	return true;
}

// PCがMVPを獲得したことがあるかを判定する。
bool // 結果。
pc_has_acquired_mvp(
	int cid,
	int mid
) {
	CS_ENTER;
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

// チックを書く。
std::string // 書いたチック。
print_tick(
	t_tick tic // チック。
) {
	std::stringstream out;
	t_tick secs     = tic  / 1000;
	t_tick secs_rem = secs %   60;
	t_tick mins     = secs /   60;
	t_tick mins_rem = mins %   60;
	t_tick hous     = mins /   60;
	if (hous)     out << hous     << "時間";
	if (mins_rem) out << mins_rem << "分";
	out               << secs_rem << "秒";
	return out.str();
}

// Zenyを書く。
std::string // 
print_zeny(
	int zen // Zeny。
) {
	std::vector<int> fies;
	do {
		div_t qr = std::div(zen, 1000);
		zen = qr.quot;
		fies.push_back(qr.rem);
	} while (zen);
	std::stringstream out;
	for (int i = 0; i < fies.size(); ++i) {
		if (i) out << "," << std::setw(3) << std::setfill('0');
		else out << std::setw(0);
		out << fies[fies.size() - i - 1];
	}
	return out.str();
}

// ジャーナル情報を照会する。
std::shared_ptr<std::vector<std::shared_ptr<journal_info>>> // 照会したジャーナル情報のベクタ。
query_journal_infos(
	map_session_data* sd, // リーダーのセッションデータ。
	nation_types nat_typ, // 国の種類。
	map_types map_typ     // マップの種類。
) {
	CS_ENTER;
	auto res = initialize<std::vector<ptr<journal_info>>>();
	block_if* lea = ensure_leader(sd);
	lea->journals()->iterate([nat_typ, map_typ, res] (int m, coords_t* xy) -> bool {
		auto map = find_map_data(id_maps, m);
		if (map) {
			if (map->nation_type == nat_typ &&
				map->map_type == map_typ
			) res->push_back(initialize<journal_info>(
				m,
				xy->x,
				xy->y,
				map->name_english,
				map->name_japanese
			));
		}
		return true;
	});
	std::sort(ALL_RANGE(*res), [](const ptr<journal_info>& lmi, const ptr<journal_info>& rmi) -> bool {
		return lmi->name_english < rmi->name_english;
	});
	return res;
}

// MVPランキングを照会する。
std::shared_ptr<std::vector<std::shared_ptr<mvp_stats>>> // 照会したMVPランキング。
query_mvp_ranking(
	const std::vector<e_job>& jobs, // 職業のベクタ。
	int lim                         // 最大行数。
) {
	CS_ENTER;
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
	CS_ENTER;
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

// Botが武具一式をリロードする。
void reload_equipset(
	int cid // キャラクターID。
) {
	CS_ENTER;
	block_if* bot = find_map_data(all_bots, cid);
	if (bot) bot->last_reloaded_equipset_tick() = 0;
}

// 最後に枝召喚したIDを設定する。
void set_last_summoned_id(
	map_session_data* sd, // セッションデータ。
	int bid               // 枝召喚したモンスターのID。
) {
	CS_ENTER;
	ensure_leader(sd)->last_summoned_id() = bid;
}

// 現在のマップの初期位置を設定する。
void set_map_initial_position(
	map_session_data* sd // セッションデータ。
) {
	CS_ENTER;
	auto pos = find_map_data(map_initial_positions, sd->status.char_id);
	if (!pos) {
		pos = initialize<block_list>();
		map_initial_positions[sd->status.char_id] = pos;
	}
	if (pos->m != sd->bl.m) {
		*pos = sd->bl;
		if (!char_is_bot(sd->status.char_id) &&
			!map_getmapflag(sd->bl.m, MF_NOMEMO) &&
			!map_getmapflag(sd->bl.m, MF_NOWARPTO)
		) {
			block_if* lea = ensure_leader(sd);
			if (!lea->journals()->find(sd->bl.m)) {
				auto map = find_map_data(id_maps, sd->bl.m);
				if (map) show_client(sd->fd, print(
					"「", map->name_japanese, " (", map->name_english, ")」のジャーナルを取得しました。"
				));
			}
			lea->journals()->register_(sd->bl.m, initialize<coords_t>(sd->bl.x, sd->bl.y));
		}
	}
}

// スキルがランドプロテクター上に設置可能かを判定する。
bool // 結果。
skill_is_layable_on_lp(
	e_skill kid // スキルID。
) {
	return KEY_EXISTS(LAYABLE_ON_LP_SKILLS, kid);
}

// 2バイト目が色指定エスケープの全角文字を含む文字列を置き換える。
std::string unescape(const std::string& tex) {
	CS_ENTER;
	std::stringstream out;
	for (int i = 0; i < tex.length();) {
		int j;
		for (j = 0; j < ESCAPING_TABLE.size(); ++j) {
			const auto& val = ESCAPING_TABLE[j];
			const std::string& x = val.first;
			if (x.length() <= tex.length() - i &&
				x == tex.substr(i, x.length())
			) {
				out << val.second;
				i += x.length();
				break;
			}
		}
		if (j == ESCAPING_TABLE.size()) {
			char let = tex[i++];
			out << let;
			if (letter_is_jlead(let)) out << tex[i++];
		}
	}
	return out.str();
}

// フィーバーに関する情報を更新する。
void update_fever() {
	CS_ENTER;
	fever_rates.clear();
	sql_session::open([] (sql_session* ses) {
		int fev_rat = 2;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("value", fev_rat), "` "
			"FROM `global_acc_reg_num` "
			"WHERE"
			" `account_id` = ", construct<sql_param>(1                     ), " AND"
			" `key` = "       , construct<sql_param>(FEVER_RATE_KEY.c_str()), " AND"
			" `index` = "     , construct<sql_param>(0                     )
		);
		ses->next_row();
		int dou_fev_rat = fev_rat * 2;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("value", dou_fev_rat), "` "
			"FROM `global_acc_reg_num` "
			"WHERE"
			" `account_id` = ", construct<sql_param>(1                     ), " AND"
			" `key` = "       , construct<sql_param>(FEVER_RATE_KEY.c_str()), " AND"
			" `index` = "     , construct<sql_param>(1                     )
		);
		ses->next_row();
		int nat_typ;
		int map_typ;
		int siz;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("nation_type", nat_typ), "`,"
			" `", construct<sql_column>("map_type"   , map_typ), "`,"
			" `", construct<sql_column>("size"       , siz    ), "` "
			"FROM `pybot_fever_size`"
		);
		std::vector<fever_size> sizs;
		while (ses->next_row())
			sizs.push_back(fever_size{nation_types(nat_typ), map_types(map_typ), siz});
		std::vector<int> fev_ids;
		for (const fever_size& siz : sizs) {
			int typ = NATION_MAP_TYPE(siz.nation_type, siz.map_type);
			auto& maps = type_maps[typ];
			for (int i = 0; i < siz.size; ++i) {
				if (i >= maps.size()) break;
				for (;;) {
					auto map = maps[rnd() % maps.size()];
					if (map->fever_type != FT_NONE &&
						!KEY_EXISTS(fever_rates, map->id)
					) {
						fever_rates[map->id] = fev_rat;
						fev_ids.push_back(map->id);
						break;
					}
				}
			}
		}

		if (fev_ids.size() >= DOUBLE_FEVER_MAPS_SIZE) {
			std::sort(ALL_RANGE(fev_ids), [](int lid, int rid) -> bool {
				auto lmap = id_maps.at(lid);
				auto rmap = id_maps.at(rid);
				return lmap->average_level > rmap->average_level;
			});
			std::unordered_set<int> dou_fev_ids;
			while (dou_fev_ids.size() < DOUBLE_FEVER_MAPS_SIZE) {
				int ind = rnd() % fev_ids.size();
				int id = fev_ids[ind];
				auto map = id_maps.at(id);
				if ((ind < DOUBLE_FEVER_MAPS_SIZE ||
						map->fever_type == FT_MVP
					) && !KEY_EXISTS(dou_fev_ids, id)
				) {
					fever_rates[id] = dou_fev_rat;
					dou_fev_ids.insert(id);
				}
			}

		}

		ses->execute("TRUNCATE `pybot_fever_rate`");
		for (auto& fev_rat_val : fever_rates) {
			int id = fev_rat_val.first;
			int rat = fev_rat_val.second;
			auto map = id_maps.at(id);
			ses->execute(
				"INSERT INTO `pybot_fever_rate` "
				"VALUES "
				"(", construct<sql_param>(map->name_english.c_str()), ","
				" ", construct<sql_param>(rat                      ), ")"
			);
		}
	});
}

// -----------------------------------------------------------------------------
// 外部から参照される定数の定義

// キャッシュ経験値の登録名。
const std::string CASH_EXP = "CASH_EXP";

// 拡張スキルポイントの登録名。
const std::string EXTRA_SKILL_POINT = "EXTRA_SKILL_POINT";

// 拡張ステータスポイントの登録名。
const std::string EXTRA_STATUS_POINT = "EXTRA_STATUS_POINT";

// MVPマニアのメンバー強化の登録名。
const std::string MVP_MANIA_ENHANCE = "MVP_MANIA_ENHANCE";

// PyBot用ダミーNPC名。
const std::string PYBOT_DUMMY_NPC_NAME = "PyBotDummy";

}
