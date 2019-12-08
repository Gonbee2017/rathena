// [GonBee]
// パーティーBOT機能のレジストリ用関数を定義する。

#include "pybot_internal.hpp"

namespace pybot {

// -----------------------------------------------------------------------------
// レジストリ用関数の定義

// DBからカート自動補充アイテムをクリアする関数を作る。
registry_t<int,int>::clear_func // 作った関数。
clear_cart_auto_get_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_cart_auto_get_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBから距離ポリシーをクリアする関数を作る。
registry_t<int,distance_policy>::clear_func // 作った関数。
clear_distance_policy_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_distance_policy` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBから武具一式をクリアする関数を作る。
registry_t<int,equipset_t>::clear_func // 作った関数。
clear_equipset_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_equipset` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBから優先モンスターをクリアする関数を作る。
registry_t<int>::clear_func // 作った関数。
clear_first_mob_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_first_mob` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBから優先スキルをクリアする関数を作る。
registry_t<int,e_skill>::clear_func // 作った関数。
clear_first_skill_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_first_skill` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBからグレートモンスターをクリアする関数を作る。
registry_t<int>::clear_func // 作った関数。
clear_great_mob_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_great_mob` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBから無視アイテムをクリアする関数を作る。
registry_t<int>::clear_func // 作った関数。
clear_ignore_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_ignore_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBから無視モンスターをクリアする関数を作る。
registry_t<int>::clear_func // 作った関数。
clear_ignore_mob_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_ignore_mob` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBからジャーナルをクリアする関数を作る。
registry_t<int,coords_t>::clear_func // 作った関数。
clear_journal_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_journal` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBから武器属性付与をクリアする関数を作る。
registry_t<int,e_element>::clear_func // 作った関数。
clear_kew_element_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_kew_element` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBから制限スキルをクリアする関数を作る。
registry_t<e_skill,int>::clear_func // 作った関数。
clear_limit_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_limit_skill` "
			"WHERE `char_id` = " , construct<sql_param>(cid)
		);
	};
}

// DBから通常攻撃ポリシーをクリアする関数を作る。
registry_t<int,normal_attack_policy>::clear_func // 作った関数。
clear_normal_attack_policy_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_normal_attack_policy` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBから非無視アイテムをクリアする関数を作る。
registry_t<int>::clear_func // 作った関数。
clear_not_ignore_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_not_ignore_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBから演奏スキルをクリアする関数を作る。
registry_t<int,play_skill>::clear_func // 作った関数。
clear_play_skill_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_play_skill` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBからHP回復アイテムをクリアする関数を作る。
registry_t<int,int>::clear_func // 作った関数。
clear_recover_hp_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_recover_hp_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBからSP回復アイテムをクリアする関数を作る。
registry_t<int,int>::clear_func // 作った関数。
clear_recover_sp_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_recover_sp_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBから拒否スキルをクリアする関数を作る。
registry_t<e_skill>::clear_func // 作った関数。
clear_reject_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_reject_skill` "
			"WHERE `char_id` = " , construct<sql_param>(cid)
		);
	};
}

// DBから売却アイテムをクリアする関数を作る。
registry_t<int>::clear_func // 作った関数。
clear_sell_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_sell_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBからスキル武具一式をクリアする関数を作る。
registry_t<e_skill,equipset_t>::clear_func // 作った関数。
clear_skill_equipset_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_skill_equipset` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBからスキル無視モンスターをクリアする関数を作る。
registry_t<int>::clear_func // 作った関数。
clear_skill_ignore_mob_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_skill_ignore_mob` "
			"WHERE `char_id` = "  , construct<sql_param>(cid)
		);
	};
}

// DBから掛け直し時間をクリアする関数を作る。
registry_t<e_skill,int>::clear_func // 作った関数。
clear_skill_tail_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_skill_tail` "
			"WHERE `char_id` = " , construct<sql_param>(cid)
		);
	};
}

// DBから倉庫補充アイテムをクリアする関数を作る。
registry_t<int,int>::clear_func // 作った関数。
clear_storage_get_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_storage_get_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBから倉庫格納アイテムをクリアする関数を作る。
registry_t<int>::clear_func // 作った関数。
clear_storage_put_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_storage_put_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBからチームをクリアする関数を作る。
registry_t<int,team_t>::clear_func // 作った関数。
clear_team_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses) {
		ses->execute(
			"DELETE FROM `pybot_team` "
			"WHERE `leader_char_id` = ", construct<sql_param>(cid)
		);
	};
}

// DBからカート自動補充アイテムを削除する関数を作る。
registry_t<int,int>::save_func // 作った関数。
delete_cart_auto_get_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid, int* amo) {
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

// DBから武具一式を削除する関数を作る。
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

// DBから優先モンスターを削除する関数を作る。
registry_t<int>::save_func // 作った関数。
delete_first_mob_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int mid) {
		ses->execute(
			"DELETE FROM `pybot_first_mob` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `mob_id` =  " , construct<sql_param>(mid)
		);
	};
}

// DBから優先スキルを削除する関数を作る。
registry_t<int,e_skill>::save_func // 作った関数。
delete_first_skill_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, e_skill* kid) {
		ses->execute(
			"DELETE FROM `pybot_first_skill` "
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

// DBから無視モンスターを削除する関数を作る。
registry_t<int>::save_func // 作った関数。
delete_ignore_mob_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int mid) {
		ses->execute(
			"DELETE FROM `pybot_ignore_mob` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `mob_id` =  " , construct<sql_param>(mid)
		);
	};
}

// DBからジャーナルを削除する関数を作る。
registry_t<int,coords_t>::save_func // 作った関数。
delete_journal_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int m, coords_t* mem) {
		auto map = find_map_data(id_maps, m);
		if (map) {
			ses->execute(
				"DELETE FROM `pybot_journal` "
				"WHERE"
				" `char_id` = ", construct<sql_param>(cid), " AND"
				" `map` = "    , construct<sql_param>(map->name_english.c_str())
			);
		}
	};
}

// DBから武器属性付与を削除する関数を作る。
registry_t<int,e_element>::save_func // 作った関数。
delete_kew_element_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int m, e_element* ele) {
		auto map = find_map_data(id_maps, m);
		if (map) {
			ses->execute(
				"DELETE FROM `pybot_kew_element` "
				"WHERE"
				" `char_id` = ", construct<sql_param>(cid                      ), " AND"
				" `map` = "    , construct<sql_param>(map->name_english.c_str())
			);
		}
	};
}

// DBから制限スキルを削除する関数を作る。
registry_t<e_skill,int>::save_func // 作った関数。
delete_limit_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, e_skill kid, int* klv) {
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

// DBから非無視アイテムを削除する関数を作る。
registry_t<int>::save_func // 作った関数。
delete_not_ignore_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid) {
		ses->execute(
			"DELETE FROM `pybot_not_ignore_item` "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `nameid` = " , construct<sql_param>(nid)
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
registry_t<e_skill>::save_func // 作った関数。
delete_reject_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, e_skill kid) {
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

// DBからスキル武具一式を削除する関数を作る。
registry_t<e_skill,skill_equipset>::save_func // 作った関数。
delete_skill_equipset_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, e_skill kid, skill_equipset* equ_set) {
		ses->execute(
			"DELETE FROM `pybot_skill_equipset` "
			"WHERE"
			" `char_id` = "  , construct<sql_param>(cid), " AND"
			" `skill_id` = " , construct<sql_param>(kid)
		);
	};
}

// DBからスキル無視モンスターを削除する関数を作る。
registry_t<int>::save_func // 作った関数。
delete_skill_ignore_mob_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int kim) {
		ses->execute(
			"DELETE FROM `pybot_skill_ignore_mob` "
			"WHERE"
			" `char_id` = "  , construct<sql_param>(cid                ), " AND"
			" `skill_id` = " , construct<sql_param>(SKILL_FROM_KIM(kim))
		);
	};
}

// DBから掛け直し時間を削除する関数を作る。
registry_t<e_skill,int>::save_func // 作った関数。
delete_skill_tail_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, e_skill kid, int* dur) {
		ses->execute(
			"DELETE FROM `pybot_skill_tail` "
			"WHERE"
			" `char_id` = " , construct<sql_param>(cid), " AND"
			" `skill_id` = ", construct<sql_param>(kid)
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

// DBからチームを削除する関数を作る。
registry_t<int,team_t>::save_func // 作った関数。
delete_team_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int tea_num, team_t* tea) {
		ses->execute(
			"DELETE FROM `pybot_team` "
			"WHERE"
			" `leader_char_id` = ", construct<sql_param>(cid    ), " AND"
			" `team_number` = "   , construct<sql_param>(tea_num)
		);
	};
}

// DBにカート自動補充アイテムを挿入する関数を作る。
registry_t<int,int>::save_func // 作った関数。
insert_cart_auto_get_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid, int* amo) {
		ses->execute(
			"INSERT INTO `pybot_cart_auto_get_item` "
			"VALUES"
			"(", construct<sql_param>(cid ), ","
			" ", construct<sql_param>(nid ), ","
			" ", construct<sql_param>(*amo), ")"
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
			"VALUES"
			"(", construct<sql_param>(cid                ), ","
			" ", construct<sql_param>(mid                ), ","
			" ", construct<sql_param>(int(dis_pol->value)), ")"
		);
	};
}

// DBに武具一式を挿入する関数を作る。
registry_t<int,equipset_t>::save_func // 作った関数。
insert_equipset_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, equipset_t* equ_set) {
		for (auto esi : equ_set->items) {
			ses->execute(
				"INSERT INTO `pybot_equipset` "
				"VALUES"
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

// DBに優先モンスターを挿入する関数を作る。
registry_t<int>::save_func // 作った関数。
insert_first_mob_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int mid) {
		ses->execute(
			"INSERT INTO `pybot_first_mob` "
			"VALUES"
			"(", construct<sql_param>(cid), ","
			" ", construct<sql_param>(mid), ")"
		);
	};
}

// DBに優先スキルを挿入する関数を作る。
registry_t<int,e_skill>::save_func // 作った関数。
insert_first_skill_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, e_skill* kid) {
		ses->execute(
			"INSERT INTO `pybot_first_skill` "
			"VALUES"
			"(", construct<sql_param>(cid ), ","
			" ", construct<sql_param>(mid ), ","
			" ", construct<sql_param>(*kid), ")"
		);
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
			"VALUES"
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
			"VALUES"
			"(", construct<sql_param>(cid), ","
			" ", construct<sql_param>(nid), ")"
		);
	};
}

// DBに無視モンスターを挿入する関数を作る。
registry_t<int>::save_func // 作った関数。
insert_ignore_mob_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int mid) {
		ses->execute(
			"INSERT INTO `pybot_ignore_mob` "
			"VALUES"
			"(", construct<sql_param>(cid), ","
			" ", construct<sql_param>(mid), ")"
		);
	};
}

// DBにジャーナルを挿入する関数を作る。
registry_t<int,coords_t>::save_func // 作った関数。
insert_journal_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int m, coords_t* mem) {
		auto map = find_map_data(id_maps, m);
		if (map) {
			ses->execute(
				"INSERT INTO `pybot_journal` "
				"VALUES"
				"(", construct<sql_param>(cid                      ), ","
				" ", construct<sql_param>(map->name_english.c_str()), ","
				" ", construct<sql_param>(mem->x                   ), ","
				" ", construct<sql_param>(mem->y                   ), ")"
			);
		}
	};
}

// DBに武器属性付与を挿入する関数を作る。
registry_t<int,e_element>::save_func // 作った関数。
insert_kew_element_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int m, e_element* ele) {
		auto map = find_map_data(id_maps, m);
		if (map) {
			ses->execute(
				"INSERT INTO `pybot_kew_element` "
				"VALUES"
				"(", construct<sql_param>(cid                      ), ","
				" ", construct<sql_param>(map->name_english.c_str()), ","
				" ", construct<sql_param>(*ele                     ), ")"
			);
		}
	};
}

// DBに制限スキルを挿入する関数を作る。
registry_t<e_skill,int>::save_func // 作った関数。
insert_limit_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, e_skill kid, int* klv) {
		ses->execute(
			"INSERT INTO `pybot_limit_skill` "
			"VALUES"
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
			"VALUES"
			"(", construct<sql_param>(cid                    ), ","
			" ", construct<sql_param>(mid                    ), ","
			" ", construct<sql_param>(int(nor_att_pol->value)), ")"
		);
	};
}

// DBに非無視アイテムを挿入する関数を作る。
registry_t<int>::save_func // 作った関数。
insert_not_ignore_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int nid) {
		ses->execute(
			"INSERT INTO `pybot_not_ignore_item` "
			"VALUES"
			"(", construct<sql_param>(cid), ","
			" ", construct<sql_param>(nid), ")"
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
			"VALUES"
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
			"VALUES"
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
			"VALUES"
			"(", construct<sql_param>(cid ), ","
			" ", construct<sql_param>(nid ), ","
			" ", construct<sql_param>(*thr), ")"
		);
	};
}

// DBに拒否スキルを挿入する関数を作る。
registry_t<e_skill>::save_func // 作った関数。
insert_reject_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, e_skill kid) {
		ses->execute(
			"INSERT INTO `pybot_reject_skill` "
			"VALUES"
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
			"VALUES"
			"(", construct<sql_param>(cid), ","
			" ", construct<sql_param>(nid), ")"
		);
	};
}

// DBにスキル武具一式を挿入する関数を作る。
registry_t<e_skill,skill_equipset>::save_func // 作った関数。
insert_skill_equipset_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, e_skill kid, skill_equipset* equ_set) {
		for (auto esi : equ_set->items) {
			ses->execute(
				"INSERT INTO `pybot_skill_equipset` "
				"VALUES"
				"(", construct<sql_param>(cid              ), ","
				" ", construct<sql_param>(kid              ), ","
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

// DBにスキル無視モンスターを挿入する関数を作る。
registry_t<int>::save_func // 作った関数。
insert_skill_ignore_mob_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int kim) {
		ses->execute(
			"INSERT INTO `pybot_skill_ignore_mob` "
			"VALUES"
			"(", construct<sql_param>(cid                ), ","
			" ", construct<sql_param>(SKILL_FROM_KIM(kim)), ","
			" ", construct<sql_param>(MOB_FROM_KIM(kim)  ), ")"
		);
	};
}

// DBに掛け直し時間を挿入する関数を作る。
registry_t<e_skill,int>::save_func // 作った関数。
insert_skill_tail_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, e_skill kid, int* dur) {
		ses->execute(
			"INSERT INTO `pybot_skill_tail` "
			"VALUES"
			"(", construct<sql_param>(cid ), ","
			" ", construct<sql_param>(kid ), ","
			" ", construct<sql_param>(*dur), ")"
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
			"VALUES"
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
			"VALUES"
			"(", construct<sql_param>(cid), ","
			" ", construct<sql_param>(nid), ")"
		);
	};
}

// DBにチームを挿入する関数を作る。
registry_t<int,team_t>::save_func // 作った関数。
insert_team_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int tea_num, team_t* tea) {
		for (int i = 0; i < tea->members.size(); ++i) {
			auto mem = tea->members[i];
			ses->execute(
				"INSERT INTO `pybot_team` "
				"VALUES"
				"(", construct<sql_param>(cid         ), ","
				" ", construct<sql_param>(tea_num     ), ","
				" ", construct<sql_param>(i           ), ","
				" ", construct<sql_param>(mem->char_id), ")"
			);
		}
	};
}

// DBからカート自動補充アイテムをロードする関数を作る。
registry_t<int,int>::load_func // 作った関数。
load_cart_auto_get_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int,int>* reg) {
		int nid;
		int amo;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("nameid", nid), "`,"
			" `", construct<sql_column>("amount", amo), "` "
			"FROM `pybot_cart_auto_get_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(nid, initialize<int>(amo));
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

// DBから武具一式をロードする関数を作る。
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
			ik->identify = 1;
			auto ei = initialize<equipset_item>(equip_pos_orders(ord), equip_pos(equ), ik);
			equ_set->items.push_back(ei);
		}
		flu();
	};
}

// DBから優先モンスターをロードする関数を作る。
registry_t<int>::load_func // 作った関数。
load_first_mob_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int>* reg) {
		int mid;
		ses->execute(
			"SELECT `", construct<sql_column>("mob_id", mid), "` "
			"FROM `pybot_first_mob` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(mid);
	};
}

// DBから優先スキルをロードする関数を作る。
registry_t<int,e_skill>::load_func // 作った関数。
load_first_skill_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, registry_t<int,e_skill>* reg) {
		int mid;
		e_skill kid;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("mob_id"  , mid), "`,"
			" `", construct<sql_column>("skill_id", kid), "` "
			"FROM `pybot_first_skill` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row())
			reg->register_(mid, initialize<e_skill>(kid));
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

// DBから無視モンスターをロードする関数を作る。
registry_t<int>::load_func // 作った関数。
load_ignore_mob_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int>* reg) {
		int mid;
		ses->execute(
			"SELECT `", construct<sql_column>("mob_id", mid), "` "
			"FROM `pybot_ignore_mob` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(mid);
	};
}

// DBからジャーナルをロードする関数を作る。
registry_t<int,coords_t>::load_func // 作った関数。
load_journal_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int,coords_t>* reg) {
		char map[12];
		int x;
		int y;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("map", map), "`,"
			" `", construct<sql_column>("x"  , x  ), "`,"
			" `", construct<sql_column>("y"  , y  ), "` "
			"FROM `pybot_journal` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) {
			int ind = mapindex_name2id(map);
			if (ind) reg->register_(map_mapindex2mapid(ind), initialize<coords_t>(x, y));
		}
	};
}

// DBから武器属性付与をロードする関数を作る。
registry_t<int,e_element>::load_func // 作った関数。
load_kew_element_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int,e_element>* reg) {
		char map[12];
		e_element ele;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("map"    , map), "`,"
			" `", construct<sql_column>("element", ele), "` "
			"FROM `pybot_kew_element` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) {
			int ind = mapindex_name2id(map);
			if (ind) reg->register_(map_mapindex2mapid(ind), initialize<e_element>(ele));
		}
	};
}

// DBから制限スキルをロードする関数を作る。
registry_t<e_skill,int>::load_func // 作った関数。
load_limit_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<e_skill,int>* reg) {
		e_skill kid;
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

// DBから非無視アイテムをロードする関数を作る。
registry_t<int>::load_func // 作った関数。
load_not_ignore_item_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<int>* reg) {
		int nid;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("nameid", nid), "` "
			"FROM `pybot_not_ignore_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(nid);
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
			" `", construct<sql_column>("nameid"   , nid), "`,"
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
			" `", construct<sql_column>("nameid"   , nid), "`,"
			" `", construct<sql_column>("threshold", thr), "` "
			"FROM `pybot_recover_sp_item` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(nid, initialize<int>(thr));
	};
}

// DBから拒否スキルをロードする関数を作る。
registry_t<e_skill>::load_func // 作った関数。
load_reject_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<e_skill>* reg) {
		e_skill kid;
		ses->execute(
			"SELECT `", construct<sql_column>("skill_id", kid), "` "
			"FROM `pybot_reject_skill` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(kid);
	};
}

// DBからスキル武具一式をロードする関数を作る。
registry_t<e_skill,skill_equipset>::load_func // 作った関数。
load_skill_equipset_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, registry_t<e_skill,skill_equipset>* reg) {
		e_skill kid;
		int ord;
		int equ;
		uint16_t nid;
		uint16_t car[MAX_SLOTS];
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("skill_id", kid   ), "`,"
			" `", construct<sql_column>("order"   , ord   ), "`,"
			" `", construct<sql_column>("equip"   , equ   ), "`,"
			" `", construct<sql_column>("nameid"  , nid   ), "`,"
			" `", construct<sql_column>("card0"   , car[0]), "`,"
			" `", construct<sql_column>("card1"   , car[1]), "`,"
			" `", construct<sql_column>("card2"   , car[2]), "`,"
			" `", construct<sql_column>("card3"   , car[3]), "` "
			"FROM `pybot_skill_equipset` "
			"WHERE `char_id` = ", construct<sql_param>(cid), " "
			"ORDER BY"
			" `skill_id`,"
			" `order`"
		);
		ptr<skill_equipset> equ_set;
		auto flu = [reg, &equ_set] () {
			if (equ_set) reg->register_(equ_set->skill_id, equ_set);
		};
		while (ses->next_row()) {
			if (!equ_set ||
				kid != equ_set->skill_id
			) {
				flu();
				equ_set = initialize<skill_equipset>(kid);
			}
			auto ik = construct<item_key>(nid, car);
			ik->identify = 1;
			auto ei = initialize<equipset_item>(equip_pos_orders(ord), equip_pos(equ), ik);
			equ_set->items.push_back(ei);
		}
		flu();
	};
}

// DBからスキル無視モンスターをロードする関数を作る。
registry_t<int>::load_func // 作った関数。
load_skill_ignore_mob_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, registry_t<int>* reg) {
		e_skill kid;
		int mid;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("skill_id", kid), "`,"
			" `", construct<sql_column>("mob_id"  , mid), "` "
			"FROM `pybot_skill_ignore_mob` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row())
			reg->register_(SKILL_IGNORE_MOB(kid, mid));
	};
}

// DBから掛け直し時間をロードする関数を作る。
registry_t<e_skill,int>::load_func // 作った関数。
load_skill_tail_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, registry_t<e_skill,int>* reg) {
		e_skill kid;
		int dur;
		ses->execute(
			"SELECT"
			" `", construct<sql_column>("skill_id", kid), "`,"
			" `", construct<sql_column>("duration", dur), "` "
			"FROM `pybot_skill_tail` "
			"WHERE `char_id` = ", construct<sql_param>(cid)
		);
		while (ses->next_row()) reg->register_(kid, initialize<int>(dur));
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

// DBからチームをロードする関数を作る。
registry_t<int,team_t>::load_func // 作った関数。
load_team_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, registry_t<int,team_t>* reg) {
		int tea_num;
		int mem_cid;
		char mem_nam[24];
		ses->execute(
			"SELECT"
			" t.`", construct<sql_column>("team_number"    , tea_num), "`,"
			" t.`", construct<sql_column>("member_char_id" , mem_cid), "`,"
			" c.`", construct<sql_column>("name"           , mem_nam), "` "
			"FROM"
			" `pybot_team` AS t,"
			" `char` AS c "
			"WHERE"
			" t.`leader_char_id` = ", construct<sql_param>(cid), " AND"
			" t.`member_char_id` = c.`char_id` "
			"ORDER BY"
			" t.`team_number`,"
			" t.`member_index`"
		);
		ptr<team_t> tea;
		while (ses->next_row()) {
			if (!tea ||
				tea_num != tea->tea_num
			) {
				tea = initialize<team_t>(tea_num);
				reg->register_(tea_num, tea);
			}
			tea->members.push_back(initialize<team_member>(mem_cid, std::string(mem_nam)));
		}
	};
}

// DBのカート自動補充アイテムを更新する関数を作る。
registry_t<int,int>::save_func // 作った関数。
update_cart_auto_get_item_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int nid, int* amo) {
		ses->execute(
			"UPDATE `pybot_cart_auto_get_item` "
			"SET `amount` = ", construct<sql_param>(*amo), " "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `nameid` = " , construct<sql_param>(nid)
		);
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
			"SET `value` = ", construct<sql_param>(int(dis_pol->value)), " "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `mob_id` = " , construct<sql_param>(mid)
		);
	};
}

// DBの優先スキルを更新する関数を作る。
registry_t<int,e_skill>::save_func // 作った関数。
update_first_skill_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int mid, e_skill* kid) {
		ses->execute(
			"UPDATE `pybot_first_skill` "
			"SET `skill_id` = ", construct<sql_param>(*kid), " "
			"WHERE"
			" `char_id` = ", construct<sql_param>(cid), " AND"
			" `mob_id` = " , construct<sql_param>(mid)
		);
	};
}

// DBの武具一式を更新する関数を作る。
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
				"VALUES"
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

// DBのジャーナルを更新する関数を作る。
registry_t<int,coords_t>::save_func // 作った関数。
update_journal_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int m, coords_t* xy) {
		auto map = find_map_data(id_maps, m);
		if (map) {
			ses->execute(
				"UPDATE `pybot_journal` "
				"SET"
				" `x` = ", construct<sql_param>(xy->x), ","
				" `y` = ", construct<sql_param>(xy->y), " "
				"WHERE"
				" `char_id` = ", construct<sql_param>(cid                      ), " AND"
				" `map` = "    , construct<sql_param>(map->name_english.c_str())
			);
		}
	};
}

// DBの武器属性付与を更新する関数を作る。
registry_t<int,e_element>::save_func // 作った関数。
update_kew_element_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, int m, e_element* ele) {
		auto map = find_map_data(id_maps, m);
		if (map) {
			ses->execute(
				"UPDATE `pybot_kew_element` "
				"SET `element` = ", construct<sql_param>(*ele), " "
				"WHERE"
				" `char_id` = ", construct<sql_param>(cid                      ), " AND"
				" `map` = "    , construct<sql_param>(map->name_english.c_str())
			);
		}
	};
}

// DBの制限スキルを更新する関数を作る。
registry_t<e_skill,int>::save_func // 作った関数。
update_limit_skill_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, e_skill kid, int* klv) {
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
			"SET `value` = ", construct<sql_param>(int(nor_att_pol->value)), " "
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
			"SET `skill_id` = ", construct<sql_param>(int(pla_ski->skill_id)), " "
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

// DBのスキル武具一式を更新する関数を作る。
registry_t<e_skill,skill_equipset>::save_func // 作った関数。
update_skill_equipset_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, e_skill kid, skill_equipset* equ_set) {
		ses->execute(
			"DELETE FROM `pybot_skill_equipset` "
			"WHERE"
			" `char_id` = "  , construct<sql_param>(cid), " AND"
			" `skill_id` = " , construct<sql_param>(kid)
		);
		for (auto esi : equ_set->items) {
			ses->execute(
				"INSERT INTO `pybot_skill_equipset` "
				"VALUES"
				"(", construct<sql_param>(cid              ), ","
				" ", construct<sql_param>(kid              ), ","
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

// DBの掛け直し時間を更新する関数を作る。
registry_t<e_skill,int>::save_func // 作った関数。
update_skill_tail_func(
	int cid // キャラクターID。
) {
	return [cid] (sql_session* ses, e_skill kid, int* dur) {
		ses->execute(
			"UPDATE `pybot_skill_tail` "
			"SET `duration` = ", construct<sql_param>(*dur), " "
			"WHERE"
			" `char_id` = " , construct<sql_param>(cid), " AND"
			" `skill_id` = ", construct<sql_param>(kid)
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

// DBのチームを更新する関数を作る。
registry_t<int,team_t>::save_func // 作った関数。
update_team_func(
	int cid // キャラクターID。              
) {
	return [cid] (sql_session* ses, int tea_num, team_t* tea) {
		ses->execute(
			"DELETE FROM `pybot_team` "
			"WHERE"
			" `leader_char_id` = ", construct<sql_param>(cid    ), " AND"
			" `team_number` = "   , construct<sql_param>(tea_num)
		);
		for (int i = 0; i < tea->members.size(); ++i) {
			auto mem = tea->members[i];
			ses->execute(
				"INSERT INTO `pybot_team` "
				"VALUES"
				"(", construct<sql_param>(cid         ), ","
				" ", construct<sql_param>(tea_num     ), ","
				" ", construct<sql_param>(i           ), ","
				" ", construct<sql_param>(mem->char_id), ")"
			);
		}
	};
}

}
