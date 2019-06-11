// [GonBee]
// パーティーBOT機能のレジストリ用関数を定義する。

#include "pybot_internal.hpp"

namespace pybot {

// -----------------------------------------------------------------------------
// レジストリ用関数の定義

// DBからカート自動補充アイテムを削除する関数を作る。
registry_t<int>::save_func // 作った関数。
delete_cart_auto_get_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid) {
		ses->execute(
			"DELETE FROM `pybot_cart_auto_get_item` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `nameid` = " , construct<sql_param>(nid)
		);
	};
}

// DBから距離ポリシーを削除する関数を作る。
registry_t<int,distance_policy>::save_func // 作った関数。
delete_distance_policy_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, distance_policy* dis_pol) {
		ses->execute(
			"DELETE FROM `pybot_distance_policy` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `mob_id` = " , construct<sql_param>(mid)
		);
	};
}

// DBから装備セットを削除する関数を作る。
registry_t<int,equipset_t>::save_func // 作った関数。
delete_equipset_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, equipset_t* equ_set) {
		ses->execute(
			"DELETE FROM `pybot_equipset` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `mob_id` = " , construct<sql_param>(mid)
		);
	};
}

// DBからグレートモンスターを削除する関数を作る。
registry_t<int>::save_func // 作った関数。
delete_great_mob_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int mid) {
		ses->execute(
			"DELETE FROM `pybot_great_mob` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `mob_id` =  " , construct<sql_param>(mid)
		);
	};
}

// DBから無視アイテムを削除する関数を作る。
registry_t<int>::save_func // 作った関数。
delete_ignore_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid) {
		ses->execute(
			"DELETE FROM `pybot_ignore_item` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `nameid` = " , construct<sql_param>(nid)
		);
	};
}

// DBから制限スキルを削除する関数を作る。
registry_t<int,int>::save_func // 作った関数。
delete_limit_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int kid, int* klv) {
		ses->execute(
			"DELETE FROM `pybot_limit_skill` "
			"WHERE"
			" `char_id` = " , construct<sql_param>(cid), " AND"
			" `skill_id` = ", construct<sql_param>(kid)
		);
	};
}

// DBから通常攻撃ポリシーを削除する関数を作る。
registry_t<int,normal_attack_policy>::save_func // 作った関数。
delete_normal_attack_policy_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, normal_attack_policy* nor_att_pol) {
		ses->execute(
			"DELETE FROM `pybot_normal_attack_policy` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `mob_id` = " , construct<sql_param>(mid)
		);
	};
}

// DBから演奏スキルを削除する関数を作る。
registry_t<int,play_skill>::save_func // 作った関数。
delete_play_skill_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, play_skill* pla_ski) {
		ses->execute(
			"DELETE FROM `pybot_play_skill` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `mob_id` = " , construct<sql_param>(mid)
		);
	};
}

// DBからHP回復アイテムを削除する関数を作る。
registry_t<int,int>::save_func // 作った関数。
delete_recover_hp_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid, int* thr) {
		ses->execute(
			"DELETE FROM `pybot_recover_hp_item` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `nameid` = " , construct<sql_param>(nid)
		);
	};
}

// DBからSP回復アイテムを削除する関数を作る。
registry_t<int,int>::save_func // 作った関数。
delete_recover_sp_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid, int* thr) {
		ses->execute(
			"DELETE FROM `pybot_recover_sp_item` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `nameid` = " , construct<sql_param>(nid)
		);
	};
}

// DBから拒否スキルを削除する関数を作る。
registry_t<int>::save_func // 作った関数。
delete_reject_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int kid) {
		ses->execute(
			"DELETE FROM `pybot_reject_skill` "
			"WHERE"
			" `char_id` = " , construct<sql_param>(cid), " AND"
			" `skill_id` = ", construct<sql_param>(kid)
		);
	};
}

// DBから売却アイテムを削除する関数を作る。
registry_t<int>::save_func // 作った関数。
delete_sell_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid) {
		ses->execute(
			"DELETE FROM `pybot_sell_item` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `nameid` = " , construct<sql_param>(nid)
		);
	};
}

// DBから倉庫補充アイテムを削除する関数を作る。
registry_t<int,int>::save_func // 作った関数。
delete_storage_get_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid, int* amo) {
		ses->execute(
			"DELETE FROM `pybot_storage_get_item` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `nameid` = " , construct<sql_param>(nid)
		);
	};
}

// DBから倉庫格納アイテムを削除する関数を作る。
registry_t<int>::save_func // 作った関数。
delete_storage_put_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid) {
		ses->execute(
			"DELETE FROM `pybot_storage_put_item` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `nameid` = " , construct<sql_param>(nid)
		);
	};
}

// DBにカート自動補充アイテムを挿入する関数を作る。
registry_t<int>::save_func // 作った関数。
insert_cart_auto_get_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid) {
		ses->execute(
			"INSERT INTO `pybot_cart_auto_get_item` "
			"VALUES "
			"(", construct<sql_param>(cid ), ","
			" ", construct<sql_param>(nid ), ")"
		);
	};
}

// DBに距離ポリシーを挿入する関数を作る。
registry_t<int,distance_policy>::save_func // 作った関数。
insert_distance_policy_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, distance_policy* dis_pol) {
		ses->execute(
			"INSERT INTO `pybot_distance_policy` "
			"VALUES "
			"(", construct<sql_param>(cid                ), ","
			" ", construct<sql_param>(mid                ), ","
			" ", construct<sql_param>(int(dis_pol->value)), ")"
		);
	};
}

// DBに装備セットを挿入する関数を作る。
registry_t<int,equipset_t>::save_func // 作った関数。
insert_equipset_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, equipset_t* equ_set) {
		for (auto esi : equ_set->items) {
			ses->execute(
				"INSERT INTO `pybot_equipset` "
				"VALUES "
				"(", construct<sql_param>(cid              ), ","
				" ", construct<sql_param>(mid              ), ","
				" ", construct<sql_param>(esi->order       ), ","
				" ", construct<sql_param>(esi->equip       ), ","
				" ", construct<sql_param>(esi->key->nameid ), ","
				" ", construct<sql_param>(esi->key->card[0]), ","
				" ", construct<sql_param>(esi->key->card[1]), ","
				" ", construct<sql_param>(esi->key->card[2]), ","
				" ", construct<sql_param>(esi->key->card[3]), ")"
			);
		}
	};
}

// DBにグレートモンスターを挿入する関数を作る。
registry_t<int>::save_func // 作った関数。
insert_great_mob_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int mid) {
		ses->execute(
			"INSERT INTO `pybot_great_mob` "
			"VALUES "
			"(", construct<sql_param>(cid), ","
			" ", construct<sql_param>(mid), ")"
		);
	};
}

// DBに無視アイテムを挿入する関数を作る。
registry_t<int>::save_func // 作った関数。
insert_ignore_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid) {
		ses->execute(
			"INSERT INTO `pybot_ignore_item` "
			"VALUES "
			"(", construct<sql_param>(cid), ","
			" ", construct<sql_param>(nid), ")"
		);
	};
}

// DBに制限スキルを挿入する関数を作る。
registry_t<int,int>::save_func // 作った関数。
insert_limit_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int kid, int* klv) {
		ses->execute(
			"INSERT INTO `pybot_limit_skill` "
			"VALUES "
			"(", construct<sql_param>(cid ), ","
			" ", construct<sql_param>(kid ), ","
			" ", construct<sql_param>(*klv), ")"
		);
	};
}

// DBに通常攻撃ポリシーを挿入する関数を作る。
registry_t<int,normal_attack_policy>::save_func // 作った関数。
insert_normal_attack_policy_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, normal_attack_policy* nor_att_pol) {
		ses->execute(
			"INSERT INTO `pybot_normal_attack_policy` "
			"VALUES "
			"(", construct<sql_param>(cid                    ), ","
			" ", construct<sql_param>(mid                    ), ","
			" ", construct<sql_param>(int(nor_att_pol->value)), ")"
		);
	};
}

// DBに演奏スキルを挿入する関数を作る。
registry_t<int,play_skill>::save_func // 作った関数。
insert_play_skill_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, play_skill* pla_ski) {
		ses->execute(
			"INSERT INTO `pybot_play_skill` "
			"VALUES "
			"(", construct<sql_param>(cid                   ), ","
			" ", construct<sql_param>(mid                   ), ","
			" ", construct<sql_param>(int(pla_ski->skill_id)), ")"
		);
	};
}

// DBにHP回復アイテムを挿入する関数を作る。
registry_t<int,int>::save_func // 作った関数。
insert_recover_hp_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid, int* thr) {
		ses->execute(
			"INSERT INTO `pybot_recover_hp_item` "
			"VALUES "
			"(", construct<sql_param>(cid ), ","
			" ", construct<sql_param>(nid ), ","
			" ", construct<sql_param>(*thr), ")"
		);
	};
}

// DBにSP回復アイテムを挿入する関数を作る。
registry_t<int,int>::save_func // 作った関数。
insert_recover_sp_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid, int* thr) {
		ses->execute(
			"INSERT INTO `pybot_recover_sp_item` "
			"VALUES "
			"(", construct<sql_param>(cid ), ","
			" ", construct<sql_param>(nid ), ","
			" ", construct<sql_param>(*thr), ")"
		);
	};
}

// DBに拒否スキルを挿入する関数を作る。
registry_t<int>::save_func // 作った関数。
insert_reject_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int kid) {
		ses->execute(
			"INSERT INTO `pybot_reject_skill` "
			"VALUES "
			"(", construct<sql_param>(cid), ","
			" ", construct<sql_param>(kid), ")"
		);
	};
}

// DBに売却アイテムを挿入する関数を作る。
registry_t<int>::save_func // 作った関数。
insert_sell_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid) {
		ses->execute(
			"INSERT INTO `pybot_sell_item` "
			"VALUES "
			"(", construct<sql_param>(cid), ","
			" ", construct<sql_param>(nid), ")"
		);
	};
}

// DBに倉庫補充アイテムを挿入する関数を作る。
registry_t<int,int>::save_func // 作った関数。
insert_storage_get_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid, int* amo) {
		ses->execute(
			"INSERT INTO `pybot_storage_get_item` "
			"VALUES "
			"(", construct<sql_param>(cid ), ","
			" ", construct<sql_param>(nid ), ","
			" ", construct<sql_param>(*amo), ")"
		);
	};
}

// DBに倉庫格納アイテムを挿入する関数を作る。
registry_t<int>::save_func // 作った関数。
insert_storage_put_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid) {
		ses->execute(
			"INSERT INTO `pybot_storage_put_item` "
			"VALUES "
			"(", construct<sql_param>(cid ), ","
			" ", construct<sql_param>(nid ), ")"
		);
	};
}

// DBからカート自動補充アイテムをロードする関数を作る。
registry_t<int>::load_func // 作った関数。
load_cart_auto_get_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int>* reg) {
		int nid;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("nameid", nid), "` "
			"FROM `pybot_cart_auto_get_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(nid);
	};
}

// DBから距離ポリシーをロードする関数を作る。
registry_t<int,distance_policy>::load_func // 作った関数。
load_distance_policy_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, registry_t<int,distance_policy>* reg) {
		int mid;
		int val;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("mob_id", mid), "`,"
			" `", construct<sql_column>("value" , val), "` "
			"FROM `pybot_distance_policy` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row())
			reg->register_(mid, construct<distance_policy>(mid, distance_policy_values(val)));
	};
}

// DBから装備セットをロードする関数を作る。
registry_t<int,equipset_t>::load_func // 作った関数。
load_equipset_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, registry_t<int,equipset_t>* reg) {
		int mid;
		int ord;
		int equ;
		uint16_t nid;
		uint16_t car[MAX_SLOTS];
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("mob_id", mid   ), "`,"
			" `", construct<sql_column>("order" , ord   ), "`,"
			" `", construct<sql_column>("equip" , equ   ), "`,"
			" `", construct<sql_column>("nameid", nid   ), "`,"
			" `", construct<sql_column>("card0" , car[0]), "`,"
			" `", construct<sql_column>("card1" , car[1]), "`,"
			" `", construct<sql_column>("card2" , car[2]), "`,"
			" `", construct<sql_column>("card3" , car[3]), "` "
			"FROM `pybot_equipset` "
			"WHERE `char_id` = ", construct<sql_param>(cid), " "
			"ORDER BY"
			" `mob_id`,"
			" `order`"
		);
		ptr<equipset_t> equ_set;
		auto flu = [reg, &equ_set] () {
			if (equ_set) reg->register_(equ_set->mob_id, equ_set);
		};
		while (ses->next_row()) {
			if (!equ_set ||
				mid != equ_set->mob_id
			) {
				flu();
				equ_set = construct<equipset_t>(mid);
			}
			auto ik = construct<item_key>(nid, car);
			auto ei = initialize<equipset_item>(equip_pos_orders(ord), equip_pos(equ), ik);
			equ_set->items.push_back(ei);
		}
		flu();
	};
}

// DBからグレートモンスターをロードする関数を作る。
registry_t<int>::load_func // 作った関数。
load_great_mob_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int>* reg) {
		int mid;
		ses->execute(
			"SELECT `", construct<sql_column>("mob_id", mid), "` "
			"FROM `pybot_great_mob` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(mid);
	};
}

// DBから無視アイテムをロードする関数を作る。
registry_t<int>::load_func // 作った関数。
load_ignore_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int>* reg) {
		int nid;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("nameid", nid), "` "
			"FROM `pybot_ignore_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(nid);
	};
}

// DBから制限スキルをロードする関数を作る。
registry_t<int,int>::load_func // 作った関数。
load_limit_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int,int>* reg) {
		int kid;
		int klv;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("skill_id", kid), "`,"
			" `", construct<sql_column>("skill_lv", klv), "` "
			"FROM `pybot_limit_skill` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(kid, initialize<int>(klv));
	};
}

// DBから通常攻撃ポリシーをロードする関数を作る。
registry_t<int,normal_attack_policy>::load_func // 作った関数。
load_normal_attack_policy_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, registry_t<int,normal_attack_policy>* reg) {
		int mid;
		int val;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("mob_id", mid), "`,"
			" `", construct<sql_column>("value" , val), "` "
			"FROM `pybot_normal_attack_policy` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row())
			reg->register_(mid, construct<normal_attack_policy>(mid, normal_attack_policy_values(val)));
	};
}

// DBから演奏スキルをロードする関数を作る。
registry_t<int,play_skill>::load_func // 作った関数。
load_play_skill_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, registry_t<int,play_skill>* reg) {
		int mid;
		int kid;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("mob_id"   , mid), "`,"
			" `", construct<sql_column>("skill_id" , kid), "` "
			"FROM `pybot_play_skill` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row())
			reg->register_(mid, construct<play_skill>(mid, e_skill(kid)));
	};
}

// DBからHP回復アイテムをロードする関数を作る。
registry_t<int,int>::load_func // 作った関数。
load_recover_hp_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int,int>* reg) {
		int nid;
		int thr;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("nameid", nid), "`,"
			" `", construct<sql_column>("threshold", thr), "` "
			"FROM `pybot_recover_hp_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(nid, initialize<int>(thr));
	};
}

// DBからSP回復アイテムをロードする関数を作る。
registry_t<int,int>::load_func // 作った関数。
load_recover_sp_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int,int>* reg) {
		int nid;
		int thr;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("nameid", nid), "`,"
			" `", construct<sql_column>("threshold", thr), "` "
			"FROM `pybot_recover_sp_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(nid, initialize<int>(thr));
	};
}

// DBから拒否スキルをロードする関数を作る。
registry_t<int>::load_func // 作った関数。
load_reject_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int>* reg) {
		e_skill kid;
		ses->execute(
			"SELECT `", construct<sql_column>("skill_id", *(int*)(&kid)), "` "
			"FROM `pybot_reject_skill` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(kid);
	};
}

// DBから売却アイテムをロードする関数を作る。
registry_t<int>::load_func // 作った関数。
load_sell_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int>* reg) {
		int nid;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("nameid", nid), "` "
			"FROM `pybot_sell_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(nid);
	};
}

// DBから倉庫補充アイテムをロードする関数を作る。
registry_t<int,int>::load_func // 作った関数。
load_storage_get_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int,int>* reg) {
		int nid;
		int amo;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("nameid", nid), "`,"
			" `", construct<sql_column>("amount", amo), "` "
			"FROM `pybot_storage_get_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(nid, initialize<int>(amo));
	};
}

// DBから倉庫格納アイテムをロードする関数を作る。
registry_t<int>::load_func // 作った関数。
load_storage_put_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int>* reg) {
		int nid;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("nameid", nid), "` "
			"FROM `pybot_storage_put_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(nid);
	};
}

// DBの距離ポリシーを更新する関数を作る。
registry_t<int,distance_policy>::save_func // 作った関数。
update_distance_policy_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, distance_policy* dis_pol) {
		ses->execute(
			"UPDATE `pybot_distance_policy` "
			"SET"
			" `value` = ", construct<sql_param>(int(dis_pol->value)), " "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `mob_id` = " , construct<sql_param>(mid)
		);
	};
}

// DBの装備セットを更新する関数を作る。
registry_t<int,equipset_t>::save_func // 作った関数。
update_equipset_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, equipset_t* equ_set) {
		ses->execute(
			"DELETE FROM `pybot_equipset` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `mob_id` = " , construct<sql_param>(mid)
		);
		for (auto esi : equ_set->items) {
			ses->execute(
				"INSERT INTO `pybot_equipset` "
				"VALUES "
				"(", construct<sql_param>(cid              ), ","
				" ", construct<sql_param>(mid              ), ","
				" ", construct<sql_param>(esi->order       ), ","
				" ", construct<sql_param>(esi->equip       ), ","
				" ", construct<sql_param>(esi->key->nameid ), ","
				" ", construct<sql_param>(esi->key->card[0]), ","
				" ", construct<sql_param>(esi->key->card[1]), ","
				" ", construct<sql_param>(esi->key->card[2]), ","
				" ", construct<sql_param>(esi->key->card[3]), ")"
			);
		}
	};
}

// DBの制限スキルを更新する関数を作る。
registry_t<int,int>::save_func // 作った関数。
update_limit_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int kid, int* klv) {
		ses->execute(
			"UPDATE `pybot_limit_skill` "
			"SET `skill_lv` = ", construct<sql_param>(*klv), " "
			"WHERE"
			" `char_id` = " , construct<sql_param>(cid), " AND"
			" `skill_id` = ", construct<sql_param>(kid)
		);
	};
}

// DBの通常攻撃ポリシーを更新する関数を作る。
registry_t<int,normal_attack_policy>::save_func // 作った関数。
update_normal_attack_policy_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, normal_attack_policy* nor_att_pol) {
		ses->execute(
			"UPDATE `pybot_normal_attack_policy` "
			"SET"
			" `value` = ", construct<sql_param>(int(nor_att_pol->value)), " "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `mob_id` = " , construct<sql_param>(mid)
		);
	};
}

// DBの通常攻撃ポリシーを更新する関数を作る。
registry_t<int,play_skill>::save_func // 作った関数。
update_play_skill_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, play_skill* pla_ski) {
		ses->execute(
			"UPDATE `pybot_play_skill` "
			"SET"
			" `skill_id` = ", construct<sql_param>(int(pla_ski->skill_id)), " "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `mob_id` = " , construct<sql_param>(mid)
		);
	};
}

// DBのHP回復アイテムを更新する関数を作る。
registry_t<int,int>::save_func // 作った関数。
update_recover_hp_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid, int* thr) {
		ses->execute(
			"UPDATE `pybot_recover_hp_item` "
			"SET `threshold` = ", construct<sql_param>(*thr), " "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `nameid` = " , construct<sql_param>(nid)
		);
	};
}

// DBのSP回復アイテムを更新する関数を作る。
registry_t<int,int>::save_func // 作った関数。
update_recover_sp_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid, int* thr) {
		ses->execute(
			"UPDATE `pybot_recover_sp_item` "
			"SET `threshold` = ", construct<sql_param>(*thr), " "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `nameid` = " , construct<sql_param>(nid)
		);
	};
}

// DBの倉庫補充アイテムを更新する関数を作る。
registry_t<int,int>::save_func // 作った関数。
update_storage_get_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid, int* amo) {
		ses->execute(
			"UPDATE `pybot_storage_get_item` "
			"SET `amount` = ", construct<sql_param>(*amo), " "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `nameid` = " , construct<sql_param>(nid)
		);
	};
}

}
