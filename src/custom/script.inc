// Copyright (c) rAthena Dev Teams - Licensed under GNU GPL
// For more information, see LICENCE in the main folder

/**
 * Custom Script Commands
 * Place the body of custom script commands in this file.
 * Format:
 *	BUILDIN_FUNC(command_name)
 *	{
 *		<code>;
 *	}
 **/

//BUILDIN_FUNC(example)
//{
//	ShowInfo("buildin_example: It works!\n");
//	script_pushint(st,1);
//	return 0;
//}

// [GonBee]
// スキルポイントを増やす。
// i ポイント数。
// ? キャラクターID。
BUILDIN_FUNC(addskillpoint) {
	map_session_data* sd;
	if (script_charid2sd(3, sd)) {
		sd->status.skill_point += script_getnum(st, 2);
		clif_updatestatus(sd, SP_SKILLPOINT);
	}
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// MVPの周回を進める。
BUILDIN_FUNC(advancemvpround) {
	map_session_data* sd;
	if (script_rid2sd(sd)) pybot::advance_mvp_round(sd->status.char_id);
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// ブロックにエフェクトを表示する。
// i タイプ。
// i ブロックID。
BUILDIN_FUNC(blockeffect) {
	int typ = script_getnum(st, 2);
	if (typ <= EF_NONE ||
		typ >= EF_MAX
	) {
		ShowError("buildin_mobeffect: unsupported effect id %d\n", typ);
		return SCRIPT_CMD_FAILURE;
	}
	block_list* bl = map_id2bl(script_getnum(st, 3));
	if (bl) clif_specialeffect(bl, typ, AREA);
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// NPCのオプションをチェックする。
// i      オプション。
// 戻り値 結果。
BUILDIN_FUNC(checknpcoption) {
	int res = 0;
	npc_data* nd;
	if (script_hasdata(st, 3)) nd = npc_name2id(script_getstr(st, 3));
	else nd = map_id2nd(st->oid);
	if (nd) res = bool(nd->sc.option & script_getnum(st, 2));
	script_pushint(st, res);
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// カードを変換する。
// i      カードのアイテムID。
// 戻り値 変換したカードのアイテムIDの。
BUILDIN_FUNC(convertcard) {
	script_pushint(st, pybot::convert_card(script_getnum(st, 2)));
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// ダミーモンスターを出現させる。
// s マップ名。
// i x座標。
// i y座標。
// s 名前。
// v モンスターID。
// i 数。
// ? イベント。
// ? 消滅するまでの時間(ミリ秒)。省略なら60000。
BUILDIN_FUNC(dummymonster) {
	const char* mapn = script_getstr(st,2);
	int x = script_getnum(st,3);
	int y = script_getnum(st,4);
	const char* str = script_getstr(st,5);
	int class_;
	if (script_isstring(st, 6))	class_ = mobdb_searchname(script_getstr(st, 6));
	else class_ = script_getnum(st, 6);
	int amount = script_getnum(st,7);
	const char* event = "PyBotDummy::OnDead";
	if (script_hasdata(st, 8)) {
		event = script_getstr(st, 8);
		check_event(st, event);
	}
	int timeout = 60000;
	if (script_hasdata(st,9)) timeout = script_getnum(st, 9);
	t_tick tick = gettick();

	if (class_ >= 0 &&
		!mobdb_checkid(class_)
	) {
		ShowWarning("buildin_monster: Attempted to spawn non-existing monster class %d\n", class_);
		return SCRIPT_CMD_FAILURE;
	}
	map_session_data* sd = map_id2sd(st->rid);
	int16 m = script_mapname2mapid(st, mapn);
	for(int i = 0; i < amount; i++) {
		mob_data* md = mob_once_spawn_sub(&sd->bl, m, x, y, str, class_, event, SZ_SMALL, AI_NONE);
		if (md) {
			md->special_state.ai = AI_SPHERE;
			mob_spawn(md, false);
			int add_mod = MD_NOCAST_SKILL | MD_KNOCKBACK_IMMUNE;
			int del_mod = MD_CANMOVE | MD_LOOTER | MD_CANATTACK;
			sc_start4(NULL, &md->bl, SC_MODECHANGE, 100, 1, 0, add_mod, del_mod, timeout);
		}
	}
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// 複製NPC毎に個別の配列の要素を参照する。
// v 参照する配列の接頭辞。
// i 参照する要素のインデックス。
// ? NPC名。
// 戻り値 参照した変数。
BUILDIN_FUNC(dupele) {
	std::string pre_nam;
	script_data* pre = script_getdata(st, 2);
	if (data_isreference(pre)) pre_nam = reference_getname(pre);
	else if (data_isstring(pre)) pre_nam = conv_str(st, pre);
	else {
		ShowError("buildin_dupvar: not a variable or string\n");
		script_reportdata(pre);
		script_pushnil(st);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	std::stringstream var_nam;
	if (is_string_variable(pre_nam.c_str()))
		var_nam << pre_nam.substr(0, pre_nam.length() - 1);
	else var_nam << pre_nam;
	int ind = script_getnum(st, 3);
	npc_data* nd;
	if (script_hasdata(st, 4)) nd = npc_name2id(script_getstr(st, 4));
	else nd = map_id2nd(st->oid);
	if (nd) {
		const char* npc_id = std::strchr(nd->name, '#');
		if (npc_id) var_nam << "_" << (npc_id + 1);
		if (is_string_variable(pre_nam.c_str())) var_nam << '$';
		if (!nd->u.scr.script->local.vars)
			nd->u.scr.script->local.vars = i64db_alloc(DB_OPT_RELEASE_DATA);
		int64 var_uid = reference_uid(add_str(var_nam.str().c_str()), ind);
		push_val2(st->stack, C_NAME, var_uid, &nd->u.scr.script->local);
	} else script_pushnil(st);
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// 複製NPC毎に個別の変数を参照する。
// v 参照する変数の接頭辞。
// ? NPC名。
// 戻り値 参照した変数。
BUILDIN_FUNC(dupvar) {
	std::string pre_nam;
	script_data* pre = script_getdata(st, 2);
	if (data_isreference(pre)) pre_nam = reference_getname(pre);
	else if (data_isstring(pre)) pre_nam = conv_str(st, pre);
	else {
		ShowError("buildin_dupvar: not a variable or string\n");
		script_reportdata(pre);
		script_pushnil(st);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	std::stringstream var_nam;
	if (is_string_variable(pre_nam.c_str()))
		var_nam << pre_nam.substr(0, pre_nam.length() - 1);
	else var_nam << pre_nam;
	npc_data* nd;
	if (script_hasdata(st, 3)) nd = npc_name2id(script_getstr(st, 3));
	else nd = map_id2nd(st->oid);
	if (nd) {
		const char* npc_id = std::strchr(nd->name, '#');
		if (npc_id) var_nam << "_" << (npc_id + 1);
		if (is_string_variable(pre_nam.c_str())) var_nam << '$';
		if (!nd->u.scr.script->local.vars)
			nd->u.scr.script->local.vars = i64db_alloc(DB_OPT_RELEASE_DATA);
		int64 var_uid = reference_uid(add_str(var_nam.str().c_str()), 0);
		push_val2(st->stack, C_NAME, var_uid, &nd->u.scr.script->local);
	} else script_pushnil(st);
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// インデックスで指定された武具を装備する。
// i インデックス。
// i 装備箇所。
// ? キャラクターID。
// 戻り値 成否。
BUILDIN_FUNC(equip2) {
	map_session_data* sd;
	if (!script_charid2sd(4, sd)) {
		script_pushint(st,0);
		return SCRIPT_CMD_FAILURE;
	}
	int inv_ind = script_getnum(st, 2);
	int equ_pos_ord = script_getnum(st, 3) - 1;
	equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(equ_pos_ord));
	if (!equip_index_check(equ_ind)) {
		ShowError("buildin_equip2: Invalid equip pos order %d\n", equ_pos_ord);
		script_pushint(st,0);
		return SCRIPT_CMD_FAILURE;
	}
	int equ_pos = equip_bitmask[equ_ind];
	item *itm = &sd->inventory.u.items_inventory[inv_ind];
	if (itm->equip &&
		!pc_unequipitem(sd, inv_ind, 1)
	) {
		ShowError("buildin_equip2: Cann't unequip %d\n", inv_ind);
		script_pushint(st,0);
		return SCRIPT_CMD_FAILURE;
	}
	if (!pc_equipitem(sd, inv_ind, equ_pos)) {
		ShowError("buildin_equip2: Item %d(%d) cannot be equipped\n", inv_ind, equ_pos);
		script_pushint(st,0);
		return SCRIPT_CMD_FAILURE;
	}
	script_pushint(st,1);
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// モンスター名からモンスターIDを検索する。
// s モンスター名。
// 戻り値 モンスターID。見つからなかったら0。
BUILDIN_FUNC(findmobdb) {
	script_pushint(st, pybot::find_mobdb(script_getstr(st, 2)));
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// 日本語のマップ名を取得する。。
// s 英語のマップ名。
// 戻り値 日本語のマップ名。
BUILDIN_FUNC(getmapnamejapanese) {
	script_pushstrcopy(st, pybot::get_map_name_japanese(script_getstr(st, 2)).c_str());
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// チームメンバーのリストを取得する。
// r アカウントIDの配列。
// r キャラクターIDの配列。
// r 名前の配列。
// 戻り値 メンバーの数。
BUILDIN_FUNC(getmemberlist) {
	script_data* rids = script_getdata(st, 2);
	if (!data_isreference(rids)) {
		ShowError("script:querymvpranking: not a variable\n");
		script_reportdata(rids);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	script_data* cids = script_getdata(st, 3);
	if (!data_isreference(cids)) {
		ShowError("script:querymvpranking: not a variable\n");
		script_reportdata(cids);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	script_data* cnams = script_getdata(st, 4);
	if (!data_isreference(cnams)) {
		ShowError("script:querymvpranking: not a variable\n");
		script_reportdata(cnams);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	script_data* cclas = script_getdata(st, 5);
	if (!data_isreference(cclas)) {
		ShowError("script:querymvpranking: not a variable\n");
		script_reportdata(cclas);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	map_session_data* sd;
	int siz = 0;
	if (!is_string_variable(reference_getname(rids)) &&
		!is_string_variable(reference_getname(cids)) &&
		is_string_variable(reference_getname(cnams)) &&
		!is_string_variable(reference_getname(cclas)) &&
		script_rid2sd(sd)
	) {
		auto mem_lis = pybot::get_member_list(sd);
		uint32 rids_ind = reference_getindex(rids);
		uint32 cids_ind = reference_getindex(cids);
		uint32 cnams_ind = reference_getindex(cnams);
		uint32 cclas_ind = reference_getindex(cclas);
		for (auto mem_inf : *mem_lis) {
			set_reg(
				st,
				sd,
				reference_uid(reference_getid(rids), rids_ind++),
				reference_getname(rids),
				(void*)__64BPRTSIZE(mem_inf->account_id),
				reference_getref(rids)
			);
			set_reg(
				st,
				sd,
				reference_uid(reference_getid(cids), cids_ind++),
				reference_getname(cids),
				(void*)__64BPRTSIZE(mem_inf->char_id),
				reference_getref(cids)
			);
			set_reg(
				st,
				sd,
				reference_uid(reference_getid(cnams), cnams_ind++),
				reference_getname(cnams),
				(void*)(mem_inf->char_name.c_str()),
				reference_getref(cnams)
			);
			set_reg(
				st,
				sd,
				reference_uid(reference_getid(cclas), cclas_ind++),
				reference_getname(cclas),
				(void*)__64BPRTSIZE(mem_inf->class_),
				reference_getref(cclas)
			);
		}
		siz = mem_lis->size();
	}
	script_pushint(st, siz);
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// ペットIDを取得する。
// 戻り値 取得したペットID。
BUILDIN_FUNC(getpetid) {
	int pid = 0;
	map_session_data* sd;
	if (script_rid2sd(sd) &&
		sd->pd
	) pid = sd->pd->pet.pet_id;
	script_pushint(st, pid);
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// ペットの親密度を取得する。
// 戻り値 取得したペットの親密度。
BUILDIN_FUNC(getpetintimate) {
	int int_ = 0;
	map_session_data* sd;
	if (script_rid2sd(sd) &&
		sd->pd
	) int_ = sd->pd->pet.intimate;
	script_pushint(st, int_);
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// アカウントがアクティブかを判定する。
// i キャラクターID。
// 戻り値 結果。
BUILDIN_FUNC(isactive) {
	script_pushint(st, bool(map_id2sd(script_getnum(st, 2))));
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// PCがMVPを獲得したことがあるかを判定する。
// i モンスターID。
// 戻り値 結果。
BUILDIN_FUNC(pchasacquiredmvp) {
	map_session_data* sd;
	script_pushint(
		st,
		script_rid2sd(sd) &&
			pybot::pc_has_acquired_mvp(sd->status.char_id, script_getnum(st, 2))
	);
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// 秒を書く。
// i 秒。
// 戻り値 書いた秒。
BUILDIN_FUNC(printseconds) {
	script_pushstrcopy(st, pybot::print_tick(t_tick(script_getnum(st, 2) + 1) * 1000).c_str());
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// MVPランキングを照会する。
// r 職業の配列。
// i 最大行数。
// r 照会したキャラクター名の配列。
// r 照会した職業の配列。
// r 照会した周回数の配列。
// r 照会したモンスター数の配列。
// 戻り値 照会した行数。
BUILDIN_FUNC(querymvpranking) {
	script_data* jobs = script_getdata(st, 2);
	if (!data_isreference(jobs)) {
		ShowError("script:querymvpranking: not a variable\n");
		script_reportdata(jobs);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	script_data* que_cnams = script_getdata(st, 4);
	if (!data_isreference(que_cnams)) {
		ShowError("script:querymvpranking: not a variable\n");
		script_reportdata(que_cnams);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	script_data* que_jobs = script_getdata(st, 5);
	if (!data_isreference(que_jobs)) {
		ShowError("script:querymvpranking: not a variable\n");
		script_reportdata(que_jobs);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	script_data* que_rous = script_getdata(st, 6);
	if (!data_isreference(que_rous)) {
		ShowError("script:querymvpranking: not a variable\n");
		script_reportdata(que_rous);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	script_data* que_mobss = script_getdata(st, 7);
	if (!data_isreference(que_mobss)) {
		ShowError("script:querymvpranking: not a variable\n");
		script_reportdata(que_mobss);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	map_session_data* sd;
	int siz = 0;
	if (!is_string_variable(reference_getname(jobs)) &&
		is_string_variable(reference_getname(que_cnams)) &&
		!is_string_variable(reference_getname(que_jobs)) &&
		!is_string_variable(reference_getname(que_rous)) &&
		!is_string_variable(reference_getname(que_mobss)) &&
		script_rid2sd(sd)
	) {
		std::vector<e_job> jobs2;
		int jobs_siz = script_array_highest_key(st, sd, reference_getname(jobs), reference_getref(jobs));
		uint32 jobs_ind = reference_getindex(jobs);
		for (int i = 0; i < jobs_siz; ++i) {
			void* job_val = get_val2(st, reference_uid(reference_getid(jobs), jobs_ind++), reference_getref(jobs));
			script_removetop(st, -1, 0);
			jobs2.push_back(e_job(int(__64BPRTSIZE(job_val))));
		}
		auto mvp_ran = pybot::query_mvp_ranking(jobs2, script_getnum(st, 3));
		uint32 que_cnams_ind = reference_getindex(que_cnams);
		uint32 que_jobs_ind = reference_getindex(que_jobs);
		uint32 que_rous_ind = reference_getindex(que_rous);
		uint32 que_mobss_ind = reference_getindex(que_mobss);
		for (auto mvp_sta : *mvp_ran) {
			set_reg(
				st,
				sd,
				reference_uid(reference_getid(que_cnams), que_cnams_ind++),
				reference_getname(que_cnams),
				(void*)(mvp_sta->char_name.c_str()),
				reference_getref(que_cnams)
			);
			set_reg(
				st,
				sd,
				reference_uid(reference_getid(que_jobs), que_jobs_ind++),
				reference_getname(que_jobs),
				(void*)__64BPRTSIZE(mvp_sta->job),
				reference_getref(que_jobs)
			);
			set_reg(
				st,
				sd,
				reference_uid(reference_getid(que_rous), que_rous_ind++),
				reference_getname(que_rous),
				(void*)__64BPRTSIZE(mvp_sta->round),
				reference_getref(que_rous)
			);
			set_reg(
				st,
				sd,
				reference_uid(reference_getid(que_mobss), que_mobss_ind++),
				reference_getname(que_mobss),
				(void*)__64BPRTSIZE(mvp_sta->mobs),
				reference_getref(que_mobss)
			);
		}
		siz = mvp_ran->size();
	}
	script_pushint(st, siz);
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// MVPの統計を照会する。
// r 周回数。
// r モンスター数。
BUILDIN_FUNC(querymvpstats) {
	script_data* rou = script_getdata(st, 2);
	if (!data_isreference(rou)) {
		ShowError("script:querymvpstats: not a variable\n");
		script_reportdata(rou);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	script_data* mobs = script_getdata(st, 3);
	if (!data_isreference(mobs)) {
		ShowError("script:querymvpstats: not a variable\n");
		script_reportdata(mobs);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		int rou2 = 0;
		int mobs2 = 0;
		auto mvp_sta = pybot::query_mvp_stats(sd->status.char_id);
		if (mvp_sta) {
			rou2 = mvp_sta->round;
			mobs2 = mvp_sta->mobs;
		}
		if (!is_string_variable(reference_getname(rou)))
			set_reg(
				st,
				sd,
				reference_getuid(rou),
				reference_getname(rou),
				(void*)__64BPRTSIZE(rou2),
				reference_getref(rou)
			);
		if (!is_string_variable(reference_getname(mobs)))
			set_reg(
				st,
				sd,
				reference_getuid(mobs),
				reference_getname(mobs),
				(void*)__64BPRTSIZE(mobs2),
				reference_getref(mobs)
			);
	}
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// インベントリにあるカードのアイテムIDを配列に設定する。
// r アイテムIDの配列。
BUILDIN_FUNC(setcardlist) {
	script_data* nids = script_getdata(st, 2);
	if (!data_isreference(nids)) {
		ShowError("script:setcardlist: not a variable\n");
		script_reportdata(nids);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	map_session_data* sd;
	if (!is_string_variable(reference_getname(nids)) &&
		script_rid2sd(sd)
	) {
		uint32 nids_ind = reference_getindex(nids);
		for (int i = 0; i < MAX_INVENTORY; ++i) {
			item* itm = &sd->inventory.u.items_inventory[i];
			if (itm->nameid) {
				item_data* idb = sd->inventory_data[i];
				if (idb->type == IT_CARD) {
					set_reg(
						st,
						sd,
						reference_uid(reference_getid(nids), nids_ind++),
						reference_getname(nids),
						(void*)__64BPRTSIZE(itm->nameid),
						reference_getref(nids)
					);
				}
			}
		}
	}
	return SCRIPT_CMD_SUCCESS;
}

// [GonBee]
// Aurigaスクリプトとの互換性のために、以下の関数を定義する。
BUILDIN_FUNC(allowuseitem) {
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(areakillmonster) {
	const char* map_nam = script_getstr(st, 2);
	int m = script_mapname2mapid(st, map_nam);
	if (m < 0) return SCRIPT_CMD_SUCCESS;
	int x0 = script_getnum(st, 3);
	int y0 = script_getnum(st, 4);
	int x1 = script_getnum(st, 5);
	int y1 = script_getnum(st, 6);
	map_foreachinarea(buildin_killmonsterall_sub, m, x0, y0, x1, y1, BL_MOB);
	return SCRIPT_CMD_SUCCESS;
}
static int buildin_misceffect_sub(struct block_list *bl,va_list ap)
{
	map_session_data* sd = (map_session_data*)(bl);
	int typ = va_arg(ap,int);
	clif_misceffect(&sd->bl, typ);
	return 0;
}
BUILDIN_FUNC(areamisceffect) {
	const char* map_nam = script_getstr(st, 2);
	int m = script_mapname2mapid(st, map_nam);
	if (m < 0) return SCRIPT_CMD_SUCCESS;
	int x0 = script_getnum(st, 3);
	int y0 = script_getnum(st, 4);
	int x1 = script_getnum(st, 5);
	int y1 = script_getnum(st, 6);
	int typ = script_getnum(st, 7);
	map_foreachinarea(buildin_misceffect_sub, m, x0, y0, x1, y1, BL_PC, typ);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(areamobuseskill2) {
	block_list center;
	center.m = script_mapname2mapid(st, script_getstr(st, 2));
	if (center.m < 0 ) {
		ShowError("areamobuseskill: invalid map name.\n");
		return SCRIPT_CMD_SUCCESS;
	}
	int x0 = script_getnum(st, 3);
	int y0 = script_getnum(st, 4);
	int x1 = script_getnum(st, 5);
	int y1 = script_getnum(st, 6);
	center.x = (x0 + x1) / 2;
	center.y = (y0 + y1) / 2;
	int rx = abs(center.x - x0);
	int ry = abs(center.y - y0);
	int range = max(rx, ry);
	int mobid = script_getnum(st, 7);
	script_data* data = script_getdata(st, 8);
	get_val(st, data);
	int skill_id = (data_isstring(data) ? skill_name2id(script_getstr(st, 8)) : script_getnum(st ,8));
	int skill_lv = script_getnum(st, 9);
	skill_lv = min(skill_lv, battle_config.mob_max_skilllvl);
	int casttime = script_getnum(st, 10);
	int cancel = script_getnum(st, 11);
	int emotion = script_getnum(st, 12);
	int target = script_getnum(st, 13);
	map_foreachinallrange(buildin_mobuseskill_sub, &center, range, BL_MOB, mobid, skill_id, skill_lv, casttime, cancel, emotion, target);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(areasetcell) {
	const char* map_nam = script_getstr(st, 2);
	int m = script_mapname2mapid(st, map_nam);
	if (m < 0) return SCRIPT_CMD_SUCCESS;
	int x0 = script_getnum(st, 3);
	int y0 = script_getnum(st, 4);
	int x1 = script_getnum(st, 5);
	int y1 = script_getnum(st, 6);
	int typ = script_getnum(st, 7);

	for (int y = y0; y <= y1; ++y) {
		for (int x = x0; x <= x1; ++x) {
			map_setcell(m, x, y, CELL_WALKABLE, !typ);
			clif_changemapcell(0, m, x, y, typ, ALL_SAMEMAP);
		}
	}
	return SCRIPT_CMD_SUCCESS;
}
static int buildin_soundeffect_sub(struct block_list *bl,va_list ap)
{
	map_session_data* sd = (map_session_data*)(bl);
	const char* nam = va_arg(ap,const char*);
	int typ = va_arg(ap,int);
	int interval = va_arg(ap,int);
	clif_soundeffect(sd, bl, nam, typ, interval);
	return 0;
}
BUILDIN_FUNC(areasoundeffect) {
	const char* map_nam = script_getstr(st, 2);
	int m = script_mapname2mapid(st, map_nam);
	if (m < 0) return SCRIPT_CMD_SUCCESS;
	int x0 = script_getnum(st, 3);
	int y0 = script_getnum(st, 4);
	int x1 = script_getnum(st, 5);
	int y1 = script_getnum(st, 6);
	const char* nam = script_getstr(st, 7);
	int typ = script_getnum(st, 8);
	int interval = 0;
	if (script_hasdata(st, 9)) interval = script_getnum(st, 9);
	map_foreachinarea(buildin_soundeffect_sub, m, x0, y0, x1, y1, BL_PC, nam, typ, interval);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(checkdead) {
	script_pushint(st,pc_isdead(map_id2sd(st->rid)));
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(checkitemblank) {
	int slos = 0;
	map_session_data* sd;
	if (script_rid2sd(sd)) slos = pc_inventoryblank(sd);
	script_pushint(st, slos);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(checkquest2) {
	map_session_data* sd;
	if (!script_rid2sd(sd)) return SCRIPT_CMD_FAILURE;
	int qid = script_getnum(st, 2);
	int res = 0;
	int i;
	ARR_FIND(0, sd->num_quests, i, sd->quest_log[i].quest_id == qid);
	if (i < sd->num_quests) {
		quest* que = &sd->quest_log[i];
		if(que->state == 2) res |= 0x08; // クエスト達成済み
		else {
			res |= 0x05; // クエスト受注済み+討伐数クリア
			if(que->time < (unsigned int)(std::time(NULL))) res |= 0x02; // 時間制限クリア
			quest_db* qdb = quest_search(qid);
			ARR_FIND(0, qdb->objectives_count, i, que->count[i] >= qdb->objectives[i].count);
			if (i == qdb->objectives_count) res &= ~0x04; // 討伐数未クリア
		}
	}
	script_pushint(st, res);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(chgquest) {
	return buildin_changequest(st);
}
BUILDIN_FUNC(compquest) {
	return buildin_completequest(st);
}
BUILDIN_FUNC(delequip2) {
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
		if (equip_index_check(equ_ind)) {
			int inv_ind = pc_checkequip(sd, equip_bitmask[equ_ind]);
			if (inv_ind >= 0) {
				pc_unequipitem(sd, inv_ind, 3);
				pc_delitem(sd, inv_ind, 1, 0, 2, LOG_TYPE_SCRIPT);
			}
		}
	}
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(delquest) {
	return buildin_erasequest(st);
}
BUILDIN_FUNC(distance2) {
	map_session_data* sd = map_id2sd(script_getnum(st, 2));
	npc_data* nd = npc_name2id(script_getstr(st, 3));
	if (!nd) nd = map_id2nd(st->oid);
	int dis = -1;
	if(sd &&
		nd &&
		sd->bl.m == nd->bl.m
	) dis = distance_bl(&sd->bl, &nd->bl);
	push_val(st->stack, C_INT, dis);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(downrefitem2) {
	int res = 0;
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
		if (equip_index_check(equ_ind)) {
			int inv_ind = pc_checkequip(sd, equip_bitmask[equ_ind]);
			if (inv_ind >= 0) {
				item* itm = &sd->inventory.u.items_inventory[inv_ind];
				item_data* idb = sd->inventory_data[inv_ind];
				int equ = itm->equip;
				log_pick_pc(sd, LOG_TYPE_SCRIPT, -1, itm);
				pc_unequipitem(sd, inv_ind, 2);
				int amo = 1;
				if (script_hasdata(st, 3)) amo = script_getnum(st, 3);
				itm->refine = cap_value(itm->refine - amo, 0, MAX_REFINE);
				clif_refine(sd->fd, 2, inv_ind, itm->refine);
				clif_delitem(sd, inv_ind, 1, 3);
				log_pick_pc(sd, LOG_TYPE_SCRIPT, 1, itm);
				clif_additem(sd, inv_ind, 1, 0);
				pc_equipitem(sd, inv_ind, equ);
				clif_misceffect(&sd->bl, 2);
				achievement_update_objective(sd, AG_REFINE_FAIL, 1, itm->refine);
				res = itm->refine;
			}
		}
	}
	script_pushint(st, res);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(dropitem) {
	const char* map_nam = script_getstr(st, 2);
	int m = script_mapname2mapid(st, map_nam);
	if (m < 0) return SCRIPT_CMD_SUCCESS;
	int x = script_getnum(st, 3);
	int y = script_getnum(st, 4);
	int nid = 0;
	if (script_isstring(st, 5)) {
		item_data* idb = itemdb_searchname(script_getstr(st, 5));
		if(idb) nid = idb->nameid;

	} else nid = script_getnum(st, 5);
	if (nid <= 0) return SCRIPT_CMD_SUCCESS;
	int amo = script_getnum(st, 6);
	int tic = script_getnum(st, 7);
	int lim = 0;
	if (script_hasdata(st, 8)) lim = script_getnum(st, 8);
	item itm = {};
	itm.nameid = nid;
	if (lim) itm.expire_time = (unsigned int)(time(NULL) + lim);
	battle_config.flooritem_lifetime += tic;
	map_addflooritem(&itm, amo, m, x, y, 0, 0, 0, 0, 0, 0);
	battle_config.flooritem_lifetime -= tic;
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(equippeditem) {
	int equ_id = script_getnum(st, 2);
	map_session_data* sd = NULL;
	if (script_hasdata(st, 3)) sd = map_nick2sd(script_getstr(st, 3), false);
	else script_rid2sd(sd);
	if (sd) {
		for (int i = 0; i < EQI_MAX; ++i) {
			int equ_ind = sd->equip_index[i];
			if (equ_ind < 0) continue;
			item* equ_itm = &sd->inventory.u.items_inventory[equ_ind];
			if (equ_itm->nameid == equ_id) {
				script_pushint(st, 1);
				return SCRIPT_CMD_SUCCESS;
			}
		}
	}
	script_pushint(st, 0);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(failedrefitem2) {
	int res = 0;
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
		if (equip_index_check(equ_ind)) {
			int inv_ind = pc_checkequip(sd, equip_bitmask[equ_ind]);
			if (inv_ind >= 0) {
				item* itm = &sd->inventory.u.items_inventory[inv_ind];
				itm->refine = 0;
				pc_unequipitem(sd, inv_ind, 3);

				int ntf = 1;
				if (script_hasdata(st, 3)) ntf = script_getnum(st, 3);
				if (ntf) clif_refine(sd->fd, 1, inv_ind, itm->refine);

				pc_delitem(sd, inv_ind, 1, 0, 2, LOG_TYPE_SCRIPT);

				if (ntf) clif_misceffect(&sd->bl, 2);

				achievement_update_objective(sd, AG_REFINE_FAIL, 1, 1);
				res = 1;
			}
		}
	}
	script_pushint(st, res);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(failedremovecards2) {
	int i=-1,c,cardflag=0;

	TBL_PC* sd;
	int typefail;

	if( !script_rid2sd(sd) )
		return SCRIPT_CMD_SUCCESS;

	equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
	typefail = script_getnum(st,3);

	if (equip_index_check(equ_ind))
		i=pc_checkequip(sd,equip_bitmask[equ_ind]);

	if (i < 0 || !sd->inventory_data[i])
		return SCRIPT_CMD_SUCCESS;

	if(itemdb_isspecial(sd->inventory.u.items_inventory[i].card[0]))
		return SCRIPT_CMD_SUCCESS;

	for( c = sd->inventory_data[i]->slot - 1; c >= 0; --c ) {
		if( sd->inventory.u.items_inventory[i].card[c] && itemdb_type(sd->inventory.u.items_inventory[i].card[c]) == IT_CARD ) {
			cardflag = 1;

			if(typefail == 2) {// add cards to inventory, clear
				unsigned char flag = 0;
				struct item item_tmp;

				memset(&item_tmp,0,sizeof(item_tmp));

				item_tmp.nameid   = sd->inventory.u.items_inventory[i].card[c];
				item_tmp.identify = 1;

				if((flag=pc_additem(sd,&item_tmp,1,LOG_TYPE_SCRIPT))){
					clif_additem(sd,0,0,flag);
					map_addflooritem(&item_tmp,1,sd->bl.m,sd->bl.x,sd->bl.y,0,0,0,0,0);
				}
			}
		}
	}

	if(cardflag == 1) {
		if(typefail == 0 || typefail == 2){	// destroy the item
			pc_delitem(sd,i,1,0,2,LOG_TYPE_SCRIPT);
		}else if(typefail == 1){ // destroy the card
			unsigned char flag = 0, j;
			struct item item_tmp;

			memset(&item_tmp,0,sizeof(item_tmp));

			item_tmp.nameid      = sd->inventory.u.items_inventory[i].nameid;
			item_tmp.identify    = 1;
			item_tmp.refine      = sd->inventory.u.items_inventory[i].refine;
			item_tmp.attribute   = sd->inventory.u.items_inventory[i].attribute;
			item_tmp.expire_time = sd->inventory.u.items_inventory[i].expire_time;
			item_tmp.bound       = sd->inventory.u.items_inventory[i].bound;

			for (j = sd->inventory_data[i]->slot; j < MAX_SLOTS; j++)
				item_tmp.card[j]=sd->inventory.u.items_inventory[i].card[j];
			
			for (j = 0; j < MAX_ITEM_RDM_OPT; j++){
				item_tmp.option[j].id=sd->inventory.u.items_inventory[i].option[j].id;
				item_tmp.option[j].value=sd->inventory.u.items_inventory[i].option[j].value;
				item_tmp.option[j].param=sd->inventory.u.items_inventory[i].option[j].param;
			}

			pc_delitem(sd,i,1,0,2,LOG_TYPE_SCRIPT);

			if((flag=pc_additem(sd,&item_tmp,1,LOG_TYPE_SCRIPT))){
				clif_additem(sd,0,0,flag);
				map_addflooritem(&item_tmp,1,sd->bl.m,sd->bl.x,sd->bl.y,0,0,0,0,0);
			}
		}
		clif_misceffect(&sd->bl,2);
	}
	return SCRIPT_CMD_SUCCESS;
}
static int buildin_getareamobs_sub(block_list *bl, va_list ap) {
	const char* eve = va_arg(ap, char*);
	int mob_id = va_arg(ap, int);
	mob_data* md = (mob_data *)(bl);
	return md->status.hp > 0 &&
		((eve &&
				strcmp(md->npc_event, eve) == 0
			) || (mob_id &&
				md->mob_id == mob_id
			)
		);
}
BUILDIN_FUNC(getareamobs) {
	const char* map_nam = script_getstr(st, 2);
	int m = script_mapname2mapid(st, map_nam);
	if (m < 0) {
		script_pushint(st, 0);
		return SCRIPT_CMD_SUCCESS;
	}
	int x0 = script_getnum(st, 3);
	int y0 = script_getnum(st, 4);
	int x1 = script_getnum(st, 5);
	int y1 = script_getnum(st, 6);
	const char* eve = NULL;
	int mob_id = 0;
	if (script_hasdata(st, 7)) {
		script_data* data = script_getdata(st, 7);
		if (data_isstring(data)) eve = conv_str(st, data);
		else mob_id = conv_num(st, data);
	}
	script_pushint(st, map_foreachinarea(buildin_getareamobs_sub, m, x0, y0, x1, y1, BL_MOB, eve, mob_id));
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(getbaseclass) {
	int job = script_getnum(st, 2);
	int cla = pc_jobid2mapid(job);
	int sex = pc_jobid2sex(job);
	int typ = 0;
	if (script_hasdata(st, 3)) typ = script_getnum(st, 3);
	int bas_cla;
	if (typ == 2) bas_cla = cla & MAPID_UPPERMASK;
	else bas_cla = cla & MAPID_BASEMASK;
	script_pushint(st, pc_mapid2jobid(bas_cla, sex));
	return SCRIPT_CMD_SUCCESS;
}
static int buildin_getmapmobs_sub(block_list *bl, va_list ap) {
	const char* eve = va_arg(ap, char*);
	int mob_id = va_arg(ap, int);
	mob_data* md = (mob_data *)(bl);
	return md->status.hp > 0 &&
		((eve &&
				strcmp(md->npc_event, eve) == 0
			) || (mob_id &&
				md->mob_id == mob_id
			)
		);
}
BUILDIN_FUNC(getequipcardcnt2)
{
	int i=-1,j;
	TBL_PC *sd;
	int count;

	if( !script_rid2sd(sd) )
		return SCRIPT_CMD_SUCCESS;

	equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
	if (equip_index_check(equ_ind))
		i=pc_checkequip(sd,equip_bitmask[equ_ind]);

	if (i < 0 || !sd->inventory_data[i]) {
		script_pushint(st,0);
		return SCRIPT_CMD_SUCCESS;
	}

	if(itemdb_isspecial(sd->inventory.u.items_inventory[i].card[0]))
	{
		script_pushint(st,0);
		return SCRIPT_CMD_SUCCESS;
	}

	count = 0;
	for( j = 0; j < sd->inventory_data[i]->slot; j++ )
		if( sd->inventory.u.items_inventory[i].card[j] && itemdb_type(sd->inventory.u.items_inventory[i].card[j]) == IT_CARD )
			count++;

	script_pushint(st,count);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(getequipid2) {
	int res = 0;
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
		if (equip_index_check(equ_ind)) {
			int inv_ind = pc_checkequip(sd, equip_bitmask[equ_ind]);
			if (inv_ind >= 0) res = sd->inventory.u.items_inventory[inv_ind].nameid;
		}
	}
	script_pushint(st, res);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(getequipisenableref2) {
	int res = 0;
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
		if (equip_index_check(equ_ind)) {
			int inv_ind = pc_checkequip(sd, equip_bitmask[equ_ind]);
			if (inv_ind >= 0)
				res = !sd->inventory_data[inv_ind]->flag.no_refine &&
					!sd->inventory.u.items_inventory[inv_ind].expire_time;
		}
	}
	script_pushint(st, res);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(getequipisequiped2) {
	int res = 0;
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
		if (equip_index_check(equ_ind))
			res = pc_checkequip(sd, equip_bitmask[equ_ind]) >= 0;
	}
	script_pushint(st, res);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(getequipisidentify) {
	int res = 0;
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
		if (equip_index_check(equ_ind)) {
			int inv_ind = pc_checkequip(sd, equip_bitmask[equ_ind]);
			if (inv_ind >= 0) res = sd->inventory.u.items_inventory[inv_ind].identify;
		}
	}
	script_pushint(st, res);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(getequipname2) {
	std::stringstream out;
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
		if (equip_index_check(equ_ind)) {
			int inv_ind = pc_checkequip(sd, equip_bitmask[equ_ind]);
			if (inv_ind >= 0) out << sd->inventory_data[inv_ind]->jname;
			else out << "(未装備@" << pybot::get_equip_pos_name(equ_ind) << ")";
		}
	}
	script_pushstrcopy(st, out.str().c_str());
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(getequippercentrefinery2) {
	int res = 0;
	bool enr = false;
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
		if (equip_index_check(equ_ind)) {
			int inv_ind = pc_checkequip(sd, equip_bitmask[equ_ind]);
			if (inv_ind >= 0) {
				item* itm = &sd->inventory.u.items_inventory[inv_ind];
				if (itm->refine < MAX_REFINE) {
					item_data* idb = sd->inventory_data[inv_ind];
					refine_type typ = REFINE_TYPE_SHADOW;
					if (idb->type != IT_SHADOWGEAR)	typ = refine_type(idb->wlv);
					if (script_hasdata(st, 3)) enr = script_getnum(st, 3);
					res = status_get_refine_chance(typ, itm->refine, enr);
				}
			}
		}
	}
	script_pushint(st, res);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(getequiprefinerycnt2) {
	int res = 0;
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
		if (equip_index_check(equ_ind)) {
			int inv_ind = pc_checkequip(sd, equip_bitmask[equ_ind]);
			if (inv_ind >= 0) res = sd->inventory.u.items_inventory[inv_ind].refine;
		}
	}
	script_pushint(st, res);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(getequipweaponlv2) {
	int res = 0;
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
		if (equip_index_check(equ_ind)) {
			int inv_ind = pc_checkequip(sd, equip_bitmask[equ_ind]);
			if (inv_ind >= 0) res = sd->inventory_data[inv_ind]->wlv;
		}
	}
	script_pushint(st, res);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(getmapmobs) {
	const char* map_nam = script_getstr(st, 2);
	int m = script_mapname2mapid(st, map_nam);
	if (m < 0) {
		script_pushint(st, 0);
		return SCRIPT_CMD_SUCCESS;
	}
	const char* eve = NULL;
	int mob_id = 0;
	if (script_hasdata(st, 3)) {
		script_data* data = script_getdata(st, 3);
		if (data_isstring(data)) eve = conv_str(st, data);
		else mob_id = conv_num(st, data);
	}
	script_pushint(st, map_foreachinmap(buildin_getmapmobs_sub, m, BL_MOB, eve, mob_id));
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(getmapname) {
	struct block_list *bl = NULL;
	TBL_PC *sd = NULL;
	if (script_nick2sd(2,sd)) bl = &sd->bl;
	if (bl) script_pushstr(st, map_getmapdata(bl->m)->name);
	else script_pushnil(st);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(getmdmapname) {
	return buildin_instance_mapname(st);
}
BUILDIN_FUNC(getmdnpcname) {
	return buildin_instance_npcname(st);
}
BUILDIN_FUNC(getonlinepartymember) {
	int par_id = 0;
	if (script_hasdata(st, 2)) par_id = script_getnum(st, 2);
	if (!par_id) {
		map_session_data* sd;
		if (script_rid2sd(sd)) par_id = sd->status.party_id;
	}
	int cou = 0;
	if (par_id) {
		party_data* pd = party_search(par_id);
		if (pd) {
			for (int i = 0; i < MAX_PARTY; ++i) {
				if (pd->party.member[i].online) ++cou;
			}
		}
	}
	script_pushint(st, cou);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(getrepairableitemcount) {
	int bro_equ_cou = 0;
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		for(int i = 0; i < MAX_INVENTORY; ++i)
			bro_equ_cou += bool(sd->inventory.u.items_inventory[i].attribute);
	}
	push_val(st->stack, C_INT, bro_equ_cou);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(getwaitingpcid) {
	script_data* rid = script_getdata(st, 2);
	if (!data_isreference(rid)) {
		ShowError("script:getwaitingpcid: not a variable\n");
		script_reportdata(rid);
		st->state = END;
		return SCRIPT_CMD_FAILURE;// not a variable
	}
	map_session_data *sd = NULL;
	if (not_server_variable(*reference_getname(rid))) {
		if (!script_rid2sd(sd)) return SCRIPT_CMD_SUCCESS;
	}
	npc_data* nd = NULL;
	if (script_hasdata(st, 3)) nd = npc_name2id(script_getstr(st, 3));
	if (!nd) nd = map_id2nd(st->oid);
	if (nd) {
		chat_data* cd = map_id2cd(nd->chat_id);
		if(cd &&
			cd->users >= 1 &&
			!is_string_variable(reference_getname(rid))
		) set_reg(
			st,
			sd,
			reference_getuid(rid),
			reference_getname(rid),
			(void*)__64BPRTSIZE(cd->usersd[0]->bl.id),
			reference_getref(rid)
		);
	}
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(mdcreate) {
	return buildin_instance_create(st);
}
BUILDIN_FUNC(mdenter) {
	return buildin_instance_enter(st);
}
BUILDIN_FUNC(npcskillsupport) {
	int kid = script_getnum(st, 2);
	int hea = script_getnum(st, 3);
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		block_list* sbl = &sd->bl;
		if (script_hasdata(st, 4)) {
			npc_data* nd = npc_name2id(script_getstr(st, 4));
			if (nd) sbl = &nd->bl;
		}
		block_list* tbl = &sd->bl;
		if (script_hasdata(st, 5)) {
			npc_data* nd = npc_name2id(script_getstr(st, 5));
			if (nd) tbl = &nd->bl;
		}
		clif_skill_nodamage(sbl, tbl, kid, hea, 1);
	}
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(openbook) {
	map_session_data *sd;
	if (script_rid2sd(sd)) {
		int bk_id = script_getnum(st, 2);
		int pag = 1;
		if (script_hasdata(st, 3)) pag = script_getnum(st, 3);
		clif_readbook(sd->fd, bk_id, pag);
	}
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(printarray) {
	script_data* arr = script_getdata(st, 2);
	if (!data_isreference(arr)) {
		ShowError("script:getwaitingpcid: not a variable\n");
		script_reportdata(arr);
		st->state = END;
		return SCRIPT_CMD_FAILURE;
	}
	const char* arr_nam = reference_getname(arr);
	map_session_data* sd = NULL;
	if (not_server_variable(*arr_nam)) {
		if (!script_rid2sd(sd)) return SCRIPT_CMD_SUCCESS;
	}
	const char* sep = ":";
	if (script_hasdata(st, 3)) sep = script_getstr(st, 3);
	int arr_siz = script_array_highest_key(st, sd, arr_nam, reference_getref(arr));
	std::stringstream out;
	uint32 ind = reference_getindex(arr);
	for (int i = 0; i < arr_siz; ++i) {
		if (i) out << sep;
		void* val = get_val2(st, reference_uid(reference_getid(arr), ind++), reference_getref(arr));
		script_removetop(st, -1, 0);
		if (is_string_variable(arr_nam)) out << (const char*)val;
		else out << int(__64BPRTSIZE(val));
	}
	script_pushstrcopy(st, out.str().c_str());
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(repairitem) {
	return buildin_repairall(st);
}
BUILDIN_FUNC(sc_ison) {
	map_session_data* sd;
	if (!script_charid2sd(4, sd)) return SCRIPT_CMD_FAILURE;
	int id = script_getnum(st, 2);
	if (id <= SC_NONE ||
		id >= SC_MAX
	) {
		ShowWarning("script.inc:sc_ison: Invalid status type given (%d).\n", id);
		script_pushint(st, 0);
		return SCRIPT_CMD_SUCCESS;
	}
	script_pushint(st, sd->sc.count && sd->sc.data[id]);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(sc_start3) {
	int typ = script_getnum(st, 2);
	int val1 = script_getnum(st, 3);
	int val2 = script_getnum(st, 4);
	int val3 = script_getnum(st, 5);
	int val4 = script_getnum(st, 6);
	int tic = script_getnum(st, 7);
	int fla = script_getnum(st, 8);
	int id;
	if (script_hasdata(st, 9)) id = script_getnum(st, 9);
	else id = st->rid;
	block_list* bl = map_id2bl(id);
	if (bl &&
		!status_isdead(bl)
	) status_change_start(bl, bl, sc_type(typ), 0, val1, val2, val3, val4, tic, fla);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(strstr) {
	return buildin_compare(st);
}
BUILDIN_FUNC(substr2) {
	const char* str = script_getstr(st, 2);
	int beg = script_getnum(st, 3);
	int len = script_getnum(st, 4);
	int str_len = std::strlen(str);
	if (beg < 0) beg += str_len;
	if (beg + len > str_len) len = str_len - beg;
	char* res;
	if(beg >= 0 &&
		beg < str_len &&
		len > 0
	) {
		res = (char*)(aMalloc(len + 1));
		std::memcpy(res, str + beg, len);
	} else res = (char*)(aMalloc(1));
	res[len] = '\0';
	script_pushstr(st, res);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(successrefitem2) {
	int res = 0;
	map_session_data* sd;
	if (script_rid2sd(sd)) {
		equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
		if (equip_index_check(equ_ind)) {
			int inv_ind = pc_checkequip(sd, equip_bitmask[equ_ind]);
			if (inv_ind >= 0) {
				item* itm = &sd->inventory.u.items_inventory[inv_ind];
				if (itm->refine < MAX_REFINE) {
					int equ = itm->equip;
					log_pick_pc(sd, LOG_TYPE_SCRIPT, -1, itm);
					++itm->refine;
					pc_unequipitem(sd, inv_ind, 2);

					int ntf = 1;
					if (script_hasdata(st, 3)) ntf = script_getnum(st, 3);
					if (ntf) clif_refine(sd->fd, 0, inv_ind, itm->refine);

					clif_delitem(sd, inv_ind, 1, 3);
					log_pick_pc(sd, LOG_TYPE_SCRIPT, 1, itm);
					clif_additem(sd, inv_ind, 1, 0);
					pc_equipitem(sd, inv_ind, equ);

					if (ntf) clif_misceffect(&sd->bl, 3);

					item_data* idb = sd->inventory_data[inv_ind];
					achievement_update_objective(sd, AG_REFINE_SUCCESS, 2, idb->wlv, itm->refine);
					if (itm->refine == MAX_REFINE &&
						itm->card[0] == CARD0_FORGE &&
						sd->status.char_id == MakeDWord(itm->card[2], itm->card[3])
					) {
						if (idb->wlv == 1) pc_addfame(sd, battle_config.fame_refine_lv1);
						else if (idb->wlv == 2) pc_addfame(sd, battle_config.fame_refine_lv2);
						else if (idb->wlv == 3) pc_addfame(sd, battle_config.fame_refine_lv3);
					}
				}
				res = itm->refine;
			}
		}
	}
	script_pushint(st, res);
	return SCRIPT_CMD_SUCCESS;
}
BUILDIN_FUNC(successremovecards2) {
	int i=-1,c,cardflag=0;

	TBL_PC* sd;

	if( !script_rid2sd(sd) )
		return SCRIPT_CMD_SUCCESS;

	equip_index equ_ind = equip_index(pybot::equip_pos_order_to_index(script_getnum(st, 2) - 1));
	if (equip_index_check(equ_ind))
		i=pc_checkequip(sd,equip_bitmask[equ_ind]);

	if (i < 0 || !sd->inventory_data[i]) {
		return SCRIPT_CMD_SUCCESS;
	}

	if(itemdb_isspecial(sd->inventory.u.items_inventory[i].card[0]))
		return SCRIPT_CMD_SUCCESS;

	for( c = sd->inventory_data[i]->slot - 1; c >= 0; --c ) {
		if( sd->inventory.u.items_inventory[i].card[c] && itemdb_type(sd->inventory.u.items_inventory[i].card[c]) == IT_CARD ) {// extract this card from the item
			unsigned char flag = 0;
			struct item item_tmp;
			memset(&item_tmp,0,sizeof(item_tmp));
			cardflag = 1;
			item_tmp.nameid   = sd->inventory.u.items_inventory[i].card[c];
			item_tmp.identify = 1;

			if((flag=pc_additem(sd,&item_tmp,1,LOG_TYPE_SCRIPT))){	// get back the cart in inventory
				clif_additem(sd,0,0,flag);
				map_addflooritem(&item_tmp,1,sd->bl.m,sd->bl.x,sd->bl.y,0,0,0,0,0);
			}
		}
	}

	if(cardflag == 1) {//if card was remove remplace item with no card
		unsigned char flag = 0, j;
		struct item item_tmp;
		memset(&item_tmp,0,sizeof(item_tmp));

		item_tmp.nameid      = sd->inventory.u.items_inventory[i].nameid;
		item_tmp.identify    = 1;
		item_tmp.refine      = sd->inventory.u.items_inventory[i].refine;
		item_tmp.attribute   = sd->inventory.u.items_inventory[i].attribute;
		item_tmp.expire_time = sd->inventory.u.items_inventory[i].expire_time;
		item_tmp.bound       = sd->inventory.u.items_inventory[i].bound;

		for (j = sd->inventory_data[i]->slot; j < MAX_SLOTS; j++)
			item_tmp.card[j]=sd->inventory.u.items_inventory[i].card[j];
		
		for (j = 0; j < MAX_ITEM_RDM_OPT; j++){
			item_tmp.option[j].id=sd->inventory.u.items_inventory[i].option[j].id;
			item_tmp.option[j].value=sd->inventory.u.items_inventory[i].option[j].value;
			item_tmp.option[j].param=sd->inventory.u.items_inventory[i].option[j].param;
		}

		pc_delitem(sd,i,1,0,3,LOG_TYPE_SCRIPT);
		if((flag=pc_additem(sd,&item_tmp,1,LOG_TYPE_SCRIPT))){	//chk if can be spawn in inventory otherwise put on floor
			clif_additem(sd,0,0,flag);
			map_addflooritem(&item_tmp,1,sd->bl.m,sd->bl.x,sd->bl.y,0,0,0,0,0);
		}

		clif_misceffect(&sd->bl,3);
	}
	return SCRIPT_CMD_SUCCESS;
}
