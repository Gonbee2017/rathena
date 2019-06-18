// [GonBee]
// パーティーBOT機能のAIにおける主な関数を定義する。

#include "pybot_internal.hpp"

namespace pybot {

// -----------------------------------------------------------------------------
// AIの定義

// AIのタイマーハンドラ。
TIMER_FUNC(ai_t::timer_func) {
	now = gettick();
	for (auto lea_val_ite = all_leaders.begin(); lea_val_ite != all_leaders.end();) {
		auto lea = lea_val_ite->second;
		if (map_id2sd(lea->account_id())) {
			try {
				ai_t ai;
				ai.leader_main(lea.get());
			} catch (std::runtime_error& err) {
				show_error(err.what());
			}
			++lea_val_ite;
		} else all_leaders.erase(lea_val_ite++);
	}
	return 0;
}

// リーダーAIのメイン。
void ai_t::leader_main(
	block_if* lea // リーダー。
) {
	leader = lea;
	leader_organize();
	leader_collect();
	leader_target();
	leader_battler();
	leader_pet();
}

// リーダーが編成する。
void ai_t::leader_organize() {
	if (leader->bl()->m != leader->center().m) leader->stay() = false;
	if (!leader->stay()) leader->center() = *leader->bl();
	for (block_if* mem : leader->members()) {
		if (mem != leader ||
			(mem->bl()->m == leader->center().m &&
				check_distance_bl(mem->bl(), &leader->center(), AREA_SIZE) &&
				mem->can_reach_bl(&leader->center(), false)
			)
		) members.push_back(mem);
	}
	leader->sp_suppliable() = false;
	for (block_if* mem : members) {
		if (mem->is_dead()) mem->skill_used_ticks().clear();
		battlers.push_back(mem);
		if (mem->homun()->exists()) {
			if (mem->homun()->is_active()) {
				battlers.push_back(mem->homun().get());
				homuns.push_back(mem->homun().get());
			} else mem->homun()->skill_used_ticks().clear();
		}
		if (mem->pet()->is_active()) {
			pets.push_back(mem->pet().get());
			blocks[mem->pet()->bl()->id] = mem->pet().get();
		}
		leader->sp_suppliable() = leader->sp_suppliable() ||
			(!mem->is_dead() &&
				mem->check_skill(PF_SOULCHANGE) &&
				mem->check_skill(PF_HPCONVERSION)
			);
	}
	bool arr_wal_exi = wall_exists(&leader->center(), battle_config.pybot_around_distance);
	for (block_if* bat : battlers) {
		bat->around_wall_exists() = arr_wal_exi;
		bat->attacked_enemies().clear();
		bat->attacked_short_range_attacker() = nullptr;
		bat->attacked_long_range_attacker() = nullptr;
		bat->attacked_by_blower() = false;
		blocks[bat->bl()->id] = bat;
		distance_policy_values dis_pol_val = DPV_PENDING;
		normal_attack_policy_values nor_att_pol_val = NAPV_PENDING;
		bat->load_policy(MM_BASE, &dis_pol_val, &nor_att_pol_val);
		bat->distance_policy_value() = dis_pol_val;
		bat->normal_attack_policy_value() = nor_att_pol_val;
	}
	std::sort(ALL_RANGE(battlers), [this] (block_if* lbt, block_if* rbt) -> bool {
		if (lbt->is_dead() != rbt->is_dead()) return rbt->is_dead();
		if (lbt->distance_policy_value() != rbt->distance_policy_value())
			return lbt->distance_policy_value() < rbt->distance_policy_value();
		if (lbt->member_index() != rbt->member_index())
			return lbt->member_index() < rbt->member_index();
		return dynamic_cast<member_impl*>(lbt);
	});
	for (int i = 0; i < battlers.size(); ++i) battlers[i]->battle_index() = i;
}

// リーダーが集める。
void ai_t::leader_collect() {
	std::vector<mob_data*> ene_mds;
	std::vector<mob_data*> aly_mds;
	yield_bl_func yie_md = [this, &ene_mds, &aly_mds] (block_list* bl) -> int {
		mob_data* md = (mob_data*)(bl);
		if (!md->sc.data[SC_WINKCHARM]) {
			if (md->master_id &&
				find_block<member_impl>(md->master_id)
			) aly_mds.push_back(md);
			else if (KEY_EXISTS(leader->enemies(), bl->id) ||
				(!leader->passive() &&
					md->target_id &&
					find_block<battler_impl>(md->target_id)
				) || bl->id == leader->attack_target()
			) ene_mds.push_back(md);
		}
		return 0;
	};
	map_foreachinshootrange(
		callback_yield_bl,
		&leader->center(),
		AREA_SIZE,
		BL_MOB,
		&yie_md
	);
	leader->attack_target() = 0;
	std::vector<ptr<block_if>> enes;
	for (mob_data* md : ene_mds) {
		auto ene = find_map_data(leader->enemies(), md->bl.id);
		if (!ene) {
			ene = construct<enemy_t>(md);
			ene->has_knockback_skill()      = KEY_EXISTS(skill_mobs::instance->knockback     , md->mob_id);
			ene->has_layout_skill()         = KEY_EXISTS(skill_mobs::instance->layout        , md->mob_id);
			ene->has_long_skill()           = KEY_EXISTS(skill_mobs::instance->long_         , md->mob_id);
			ene->has_long_weapon_skill()    = KEY_EXISTS(skill_mobs::instance->long_weapon   , md->mob_id);
			ene->has_summon_skill()         = KEY_EXISTS(skill_mobs::instance->summon        , md->mob_id);
			ene->has_unequip_weapon_skill() = KEY_EXISTS(skill_mobs::instance->unequip_weapon, md->mob_id);
			ene->has_unequip_shield_skill() = KEY_EXISTS(skill_mobs::instance->unequip_shield, md->mob_id);
			ene->has_unequip_armor_skill()  = KEY_EXISTS(skill_mobs::instance->unequip_armor , md->mob_id);
			ene->has_unequip_helm_skill()   = KEY_EXISTS(skill_mobs::instance->unequip_helm  , md->mob_id);
			ene->has_usefull_skill()        = KEY_EXISTS(skill_mobs::instance->usefull       , md->mob_id);
		}
		enes.push_back(ene);
	}
	leader->enemies().clear();
	for (auto ene : enes) {
		leader->enemies()[ene->bl()->id] = ene;
		enemies.push_back(ene.get());
	}
	std::sort(
		enemies.begin(),
		enemies.end(),
		[this] (block_if* len, block_if* ren) -> bool {
			if (len->is_hiding() != ren->is_hiding())
				return ren->is_hiding();
			bool lpt = !battlers.empty() &&
				len->bl()->id == battlers.front()->ud()->target;
			bool rpt = !battlers.empty() &&
				ren->bl()->id == battlers.front()->ud()->target;
			if (lpt != rpt) return lpt;
			bool ltr = len->is_great(leader);
			bool rtr = ren->is_great(leader);
			if (ltr != rtr)	return ltr;
			if (len->has_summon_skill() != ren->has_summon_skill())
				return len->has_summon_skill();
			if (bool(len->md()->master_id) != bool(ren->md()->master_id))
				return ren->md()->master_id;
			if (len->md()->tdmg != ren->md()->tdmg) return len->md()->tdmg > ren->md()->tdmg;
			if (len->is_long_range_attacker() != ren->is_long_range_attacker())
				return ren->is_long_range_attacker();
			if (len->md()->db->lv != ren->md()->db->lv)
				return len->md()->db->lv > ren->md()->db->lv;
			int lpd = distance_client_bl(len->bl(), battlers.front()->bl());
			int rpd = distance_client_bl(ren->bl(), battlers.front()->bl());
			if (lpd != rpd) return lpd < rpd;
			return len->bl()->id < ren->bl()->id;
		}
	);
	for (block_if* ene : enemies) {
		ene->close_battlers().clear();
		for (block_if* bat : battlers) {
			if (ene->check_attack_range(bat) &&
				!bat->is_dead() &&
				!bat->is_hiding()
			) ene->close_battlers().push_back(bat);
		}
		block_if* tar_bat = find_block<battler_impl>(ene->md()->target_id);
		ene->target_battler() = tar_bat;
		if (tar_bat) {
			tar_bat->attacked_enemies().push_back(ene);
			if (ene->is_short_range_attacker()) {
				if (!tar_bat->attacked_short_range_attacker())
					tar_bat->attacked_short_range_attacker() = ene;
			} else if (!tar_bat->attacked_long_range_attacker())
				tar_bat->attacked_long_range_attacker() = ene;
			tar_bat->attacked_by_blower() |= ene->has_knockback_skill();
			tar_bat->attacked_by_detector() |= ene->has_detector();
		}
		ene->skill_target_battler() = find_block<battler_impl>(ene->ud()->skilltarget);
		ene->walk_target_battler() = find_block<battler_impl>(ene->ud()->target_to);
		ene->attacked_battlers().clear();
		blocks[ene->bl()->id] = ene;
	}
	std::vector<ptr<block_if>> aly_mobs;
	for (mob_data* md : aly_mds) {
		auto aly_mob = find_map_data(leader->ally_mobs(), md->bl.id);
		if (!aly_mob) aly_mob = construct<mob_t>(md);
		aly_mobs.push_back(aly_mob);
	}
	leader->ally_mobs().clear();
	for (auto aly_mob : aly_mobs) {
		leader->ally_mobs()[aly_mob->bl()->id] = aly_mob;
		ally_mobs.push_back(aly_mob.get());
		blocks[aly_mob->bl()->id] = aly_mob.get();
	}

	yield_bl_func yie_fit = [this] (block_list* bl) -> int	{
		flooritem_data* fit = (flooritem_data*)(bl);
		if (fit &&
			fit->item.nameid &&
			check_distance_client_bl(&fit->bl, &leader->center(), AREA_SIZE) &&
			(!leader->ignore_items()->find(fit->item.nameid) ||
				fit->item.card[0] ||
				fit->item.refine
			)
		) {
			flooritems.push_back(fit);
			return 1;
		}
		return 0;
	};
	map_foreachinshootrange(
		callback_yield_bl,
		&leader->center(),
		AREA_SIZE,
		BL_ITEM,
		&yie_fit
	);

	yield_bl_func yie_war_por = [this] (block_list* bl) -> int {
		npc_data* npc = (npc_data*)(bl);
		if (npc &&
			npc->subtype == NPCTYPE_WARP &&
			!(npc->sc.option & OPTION_INVISIBLE) &&
			check_distance_client_bl(&npc->bl, &leader->center(), AREA_SIZE)
		) {
			warp_portals.push_back(npc);
			return 1;
		}
		return 0;
	};
	map_foreachinshootrange(
		callback_yield_bl,
		&leader->center(),
		AREA_SIZE,
		BL_NPC,
		&yie_war_por
	);
}

// リーダーがターゲットを決める。
void ai_t::leader_target() {
	auto rel_pol = [] (
		block_if* bat,
		block_if* ene,
		distance_policy_values* dis_pol_val,
		normal_attack_policy_values* nor_att_pol_val
	) {
		bat->load_policy(ene->md()->mob_id, dis_pol_val, nor_att_pol_val);
		if (!bat->check_hp(4)) {
			if (!bat->check_hp(3)) {
				if (!bat->check_hp(2)) {
					if (!bat->check_hp(1)) {
						bat->load_policy(MM_HP_DECLINE1, dis_pol_val, nor_att_pol_val);
					}
					bat->load_policy(MM_HP_DECLINE2, dis_pol_val, nor_att_pol_val);
				}
				bat->load_policy(MM_HP_DECLINE3, dis_pol_val, nor_att_pol_val);
			}
			bat->load_policy(MM_HP_DECLINE4, dis_pol_val, nor_att_pol_val);
		}
		if (!bat->check_sp(4)) {
			if (!bat->check_sp(3)) {
				if (!bat->check_sp(2)) {
					if (!bat->check_sp(1)) {
						bat->load_policy(MM_SP_DECLINE1, dis_pol_val, nor_att_pol_val);
					}
					bat->load_policy(MM_SP_DECLINE2, dis_pol_val, nor_att_pol_val);
				}
				bat->load_policy(MM_SP_DECLINE3, dis_pol_val, nor_att_pol_val);
			}
			bat->load_policy(MM_SP_DECLINE4, dis_pol_val, nor_att_pol_val);
		}
		if (ene->is_flora()) bat->load_policy(MM_FLORA, dis_pol_val, nor_att_pol_val);
		if (ene->is_great(bat->leader())) bat->load_policy(MM_GREAT, dis_pol_val, nor_att_pol_val);
		if (ene->is_boss()) bat->load_policy(MM_BOSS, dis_pol_val, nor_att_pol_val);
		bat->load_policy(MM_RACE + ene->race(), dis_pol_val, nor_att_pol_val);
		bat->load_policy(MM_ELEMENT + ene->element(), dis_pol_val, nor_att_pol_val);
		bat->load_policy(MM_SIZE + ene->size_(), dis_pol_val, nor_att_pol_val);
		bat->load_policy(MM_BASE, dis_pol_val, nor_att_pol_val);
		if (*dis_pol_val == DPV_PENDING) *dis_pol_val = bat->default_distance_policy_value();
		if (*nor_att_pol_val == NAPV_PENDING) *nor_att_pol_val = bat->default_normal_attack_policy_value();
	};
	for (block_if* bat : battlers) {
		bat->target_enemy() = nullptr;
		bat->battle_mode() = BM_NONE;
		if (!enemies.empty() &&
			!bat->is_dead() &&
			bat->bl()->m == leader->center().m
		) {
			if (!bat->is_primary()) {
				for (block_if* ene : enemies) {
					distance_policy_values dis_pol_val = DPV_PENDING;
					normal_attack_policy_values nor_att_pol_val = NAPV_PENDING;
					rel_pol(bat, ene, &dis_pol_val, &nor_att_pol_val);
					if ((dis_pol_val == DPV_CLOSE ||
							nor_att_pol_val == NAPV_CONTINUOUS
						) && !ene->is_flora() &&
						ene->is_short_range_attacker() &&
						ene->target_battler() &&
						ene->target_battler()->battle_index() > bat->battle_index() &&
						ene->attacked_battlers().empty()
					) {
						bat->target_enemy() = ene;
						bat->battle_mode() = BM_TAUNT;
						bat->distance_policy_value() = dis_pol_val;
						bat->normal_attack_policy_value() = nor_att_pol_val;
						break;
					}
				}
			}
			if (!bat->target_enemy()) {
				bat->target_enemy() = enemies.front();
				distance_policy_values dis_pol_val = DPV_PENDING;
				normal_attack_policy_values nor_att_pol_val = NAPV_PENDING;
				rel_pol(bat, bat->target_enemy(), &dis_pol_val, &nor_att_pol_val);
				if ((battlers.front()->distance_policy_value() == DPV_AWAY ||
						bat->is_primary()
					) && (bat->target_enemy()->target_battler() ||
						!bat->target_enemy()->is_berserk()
					)
				) bat->battle_mode() = BM_TAUNT;
				else bat->battle_mode() = BM_ASSIST;
				bat->distance_policy_value() = dis_pol_val;
				bat->normal_attack_policy_value() = nor_att_pol_val;
			}
			if (bat->distance_policy_value() == DPV_CLOSE ||
				bat->normal_attack_policy_value() == NAPV_CONTINUOUS
			) bat->target_enemy()->attacked_battlers().push_back(bat);
		}
	}
}

// リーダーがバトラーのAIを呼ぶ。
void ai_t::leader_battler() {
	for (block_if* bat : battlers) {
		if (bat != leader &&
			bat != leader->homun().get()
		) {
			if (dynamic_cast<bot_impl*>(bat)) {
				try {bot_main(bat);} catch (const turn_end_exception&) {}
			} else if (dynamic_cast<homun_impl*>(bat)) {
				try {homun_main(bat);} catch (const turn_end_exception&) {}
			}
		}
	}
}

// リーダーがペットのAIを呼ぶ。
void ai_t::leader_pet() {
	for (block_if* pet : pets) {
		try {pet_main(pet);} catch (const turn_end_exception&) {}
	}
}

// BotのAIのメイン。
void ai_t::bot_main(
	block_if* bot_ // Bot。
) {
	battler = bot = bot_;
	bot_dialog();
	bot_dead();
	bot_lost();
	bot_emotion();
	bot_stand();
	bot_cast_cancel();
	bot_walk_end();
	bot_cast_end();
	bot_cart_auto_get();
	bot_reload_equipset();
	bot_use_item();
	bot_pickup_flooritem();
	bot_positioning();
	bot_follow();
	bot_attack();
	bot_play_skill();
	bot_use_skill();
	bot_rest();
}

// Botが対話する。
void ai_t::bot_dialog() {
	pc_close_npc(bot->sd(), 2);
	if (pc_cant_act(bot->sd())) throw turn_end_exception();
}

// Botが死亡している。
void ai_t::bot_dead() {
	t_tick& dea_tic = bot_dead_ticks[bot->char_id()];
	if (bot->is_dead()) {
		bot->walk_end_func() = bot->cast_end_func() = nullptr;
		if (!dea_tic) dea_tic = now;
		if (!bot_restart_tick(bot->char_id()) &&
			!leader->is_dead()
		) bot->respawn();
		throw turn_end_exception();
	} else dea_tic = 0;
}

// Botがリーダーを見失う。
void ai_t::bot_lost() {
	block_list* cen = &leader->center();
	if ((bot->bl()->m != cen->m ||
			!check_distance_bl(bot->bl(), cen, AREA_SIZE) ||
			!bot->can_reach_bl(cen, false)
		) && bot->teleport(cen)
	) throw turn_end_exception();
}

// Botがエモーションを表示する。
void ai_t::bot_emotion() {
	if (DIFF_TICK(now, bot->last_emotion_tick()) >= 2500) {
		int typ = INT_MIN;
		if (bot->find_broken_equip() != INT_MIN) typ = ET_HELP;
		else if (bot->sc()->data[SC_WEIGHT90]) typ = ET_CRY;
		else if (bot->sc()->data[SC_WEIGHT50]) typ = ET_OHNO;
		else if (bot->sp_ratio() < 25) typ = ET_KEK;
		else if (bot->sp_ratio() < 50) typ = ET_PROFUSELY_SWEAT;
		if (typ != INT_MIN) {
			clif_emotion(bot->bl(), typ);
			bot->last_emotion_tick() = now;
		}
	}
}

// Botが立つ。
void ai_t::bot_stand() {
	if (bot->battle_mode() != BM_NONE &&
		bot->is_sit()
	) bot->stand();
}

// Botが詠唱をキャンセルする。
void ai_t::bot_cast_cancel() {
	int cas_can_lv = bot->check_skill(SA_CASTCANCEL);
	if (cas_can_lv &&
		bot->is_casting() &&
		skill_get_inf(bot->ud()->skill_id) & INF_ATTACK_SKILL &&
		!map_id2bl(bot->ud()->skilltarget)
	) bot->use_skill_self(SA_CASTCANCEL, cas_can_lv);
}

// Botが歩き終わる。
void ai_t::bot_walk_end() {
	ai_t::done_func fun = bot->walk_end_func();
	if (fun) {
		if (bot->is_walking()) throw turn_end_exception();
		bot->walk_end_func() = nullptr;
		fun(this, &fun);
	}
}

// Botが唱え終わる。
void ai_t::bot_cast_end() {
	ai_t::done_func fun = bot->cast_end_func();
	if (fun) {
		if (!bot->can_act()) throw turn_end_exception();
		bot->cast_end_func() = nullptr;
		fun(this, &fun);
	}
}

// Botがカートからアイテムを補充する。
void ai_t::bot_cart_auto_get() {
	if (bot->is_carton()) {
		auto inv_con = construct<inventory_context>(bot->sd());
		auto car_con = construct<cart_context>(bot->sd());
		bot->cart_auto_get_items()->iterate(
			[this, inv_con, car_con] (int nid) -> bool {
				if (inv_con->find(nid) == INT_MIN) {
					int car_ind = car_con->find(nid);
					if (car_ind != INT_MIN) {
						item* itm = car_con->at(car_ind);
						if (inv_con->add(itm, 1)) car_con->delete_(car_ind, 1);
					}
				}
				return true;
			}
		);
	}
}

// Botが武具一式をリロードする。
void ai_t::bot_reload_equipset() {
	equip_pos equ = equip_pos(0);
	if (bot->battle_mode() == BM_NONE) {
		if (bot->last_reloaded_equipset_tick()) {
			bot->load_equipset(MM_REST, &equ);
			bot->last_reloaded_equipset_tick() = 0;
		}
	} else if (DIFF_TICK(now, bot->last_reloaded_equipset_tick()) >= battle_config.pybot_reload_equipset_cool_time) {
		int pre_mid = 0;
		for (block_if* ene : enemies) {
			if (ene->md()->mob_id == pre_mid) continue;
			bot->load_equipset(MM_CAUTION + ene->md()->mob_id, &equ);
			pre_mid = ene->md()->mob_id;
		}
		block_if* tar_ene = bot->target_enemy();
		bot->load_equipset(tar_ene->md()->mob_id, &equ);
		if (!bot->check_hp(4)) {
			if (!bot->check_hp(3)) {
				if (!bot->check_hp(2)) {
					if (!bot->check_hp(1)) {
						bot->load_equipset(MM_HP_DECLINE1, &equ);
					}
					bot->load_equipset(MM_HP_DECLINE2, &equ);
				}
				bot->load_equipset(MM_HP_DECLINE3, &equ);
			}
			bot->load_equipset(MM_HP_DECLINE4, &equ);
		}
		if (!bot->check_sp(4)) {
			if (!bot->check_sp(3)) {
				if (!bot->check_sp(2)) {
					if (!bot->check_sp(1)) {
						bot->load_equipset(MM_SP_DECLINE1, &equ);
					}
					bot->load_equipset(MM_SP_DECLINE2, &equ);
				}
				bot->load_equipset(MM_SP_DECLINE3, &equ);
			}
			bot->load_equipset(MM_SP_DECLINE4, &equ);
		}
		if (tar_ene->is_flora()) bot->load_equipset(MM_FLORA, &equ);
		if (tar_ene->is_great(leader)) bot->load_equipset(MM_GREAT, &equ);
		if (tar_ene->is_boss()) bot->load_equipset(MM_BOSS, &equ);
		bot->load_equipset(MM_RACE + tar_ene->race(), &equ);
		bot->load_equipset(MM_ELEMENT + tar_ene->element(), &equ);
		bot->load_equipset(MM_SIZE + tar_ene->size_(), &equ);
		bot->load_equipset(MM_BASE, &equ);
		bot->load_equipset(MM_BACKUP, &equ);
		bot->last_reloaded_equipset_tick() = now;
	}
}

// Botがアイテムを使う。
void ai_t::bot_use_item() {
	using itm_val_t = std::pair<int,int*>;
	if (!battler->is_paralysis()) {
		auto inv_con = construct<inventory_context>(bot->sd());
		auto use_hea = [this, &inv_con] (registry_t<int,int>* itms, int rat) {
			std::vector<itm_val_t> itm_vals;
			itms->copy(std::back_inserter(itm_vals));
			std::sort(ALL_RANGE(itm_vals), [] (itm_val_t lval, itm_val_t rval) -> bool {
				return *lval.second < *rval.second;
			});
			for (itm_val_t itm_val : itm_vals) {
				int nid = itm_val.first;
				int thr = *itm_val.second;
				if (thr > rat) {
					int inv_ind = inv_con->find(nid);
					if (inv_ind != INT_MIN) bot->use_item(inv_ind);
				}
			}
		};
		try {
			for (const item_use_proc& itm_use_pro : AI_ITEM_USE_PROCS) {
				int inv_ind = inv_con->find(itm_use_pro.nameid);
				if (inv_ind != INT_MIN) itm_use_pro.func(this, inv_ind);
			}
			if (bot->battle_mode() != BM_NONE) {
				if (!bot->sc()->data[SC_BERSERK])
					use_hea(bot->recover_hp_items().get(), bot->hp_ratio());
				use_hea(bot->recover_sp_items().get(), bot->sp_ratio());
			}
		} catch (const item_used_exception&) {}
	}
}

// Botがドロップアイテムを拾う。
void ai_t::bot_pickup_flooritem() {
	if (bot->loot()->get() &&
		bot->battle_mode() != BM_TAUNT &&
		!bot->sc()->data[SC_WEIGHT90] &&
		pc_inventoryblank(bot->sd())
	) {
		flooritem_data* nea_fit = nullptr;
		int nea_dis;
		for (flooritem_data* fit : flooritems) {
			const TimerData* td = get_timer(fit->cleartimer);
			if (td &&
				td->func
			) {
				int dis = distance_client_bl(&fit->bl, bot->bl());
				int wei = itemdb_weight(fit->item.nameid) * fit->item.amount;
				int rem = bot->sd()->max_weight - bot->sd()->weight;
				if ((!nea_fit ||
						dis < nea_dis
					) && pc_can_takeitem(bot->sd(), fit) &&
					away_warp_portals(fit->bl.x, fit->bl.y) &&
					bot->can_reach_bl(&fit->bl) &&
					wei <= rem
				) {
					nea_fit = fit;
					nea_dis = dis;
				}
			}
		}
		if (nea_fit) {
			int gre_lv = bot->check_skill(BS_GREED);
			if (gre_lv &&
				(bot->sc()->cant.cast ||
					!bot->can_use_skill(BS_GREED, gre_lv) ||
					!bot->check_sp(2)
				)
			) gre_lv = 0;
			int ran = gre_lv ? 0 : 1;
			if (bot->is_sit()) bot->stand();
			if (bot->can_move() &&
				!bot->walk_bl(&nea_fit->bl, ran) &&
				bot->can_act()
			) {
				if (gre_lv) bot->use_skill_self(BS_GREED, gre_lv);
				if (pc_takeitem(bot->sd(), nea_fit)) bot->act_end();
			}
			throw turn_end_exception();
		}
	}
}

// Botが位置取る。
void ai_t::bot_positioning() {
	battler_positioning();
}

// Botが中心についていく。
void ai_t::bot_follow() {
	int ran = int(bot->member_index() < leader->member_index()) + bot->member_index();
	if (bot->battle_mode() == BM_NONE &&
		!bot->is_walking() &&
		!bot->check_range_bl(bot->bl(), &leader->center(), ran)
	) {
		if (bot->is_sit()) bot->stand();
		else if (bot->can_move()) bot->walk_bl(&leader->center(), ran);
		throw turn_end_exception();
	}
}

// Botが攻撃する。
void ai_t::bot_attack() {
	 if (pc_can_attack(bot->sd(), 0)) battler_attack();
}

// Botが演奏スキルを使う。
void ai_t::bot_play_skill() {
	if ((bot->sd()->class_ & MAPID_UPPERMASK) == MAPID_BARDDANCER &&
		!bot->is_walking() &&
		!bot->sc()->cant.cast &&
		bot->can_act() &&
		!bot->is_paralysis() &&
		!bot->sc()->data[SC_DANCING]
	) {
		e_skill kid = e_skill(0);
		if (bot->battle_mode() != BM_NONE) {
			int pre_mid = 0;
			for (block_if* ene : enemies) {
				if (ene->md()->mob_id == pre_mid) continue;
				bot->load_play_skill(MM_CAUTION + ene->md()->mob_id, &kid);
				pre_mid = ene->md()->mob_id;
			}
			block_if* tar_ene = bot->target_enemy();
			bot->load_play_skill(tar_ene->md()->mob_id, &kid);
			if (!bot->check_hp(4)) {
				if (!bot->check_hp(3)) {
					if (!bot->check_hp(2)) {
						if (!bot->check_hp(1)) {
							bot->load_play_skill(MM_HP_DECLINE1, &kid);
						}
						bot->load_play_skill(MM_HP_DECLINE2, &kid);
					}
					bot->load_play_skill(MM_HP_DECLINE3, &kid);
				}
				bot->load_play_skill(MM_HP_DECLINE4, &kid);
			}
			if (!bot->check_sp(4)) {
				if (!bot->check_sp(3)) {
					if (!bot->check_sp(2)) {
						if (!bot->check_sp(1)) {
							bot->load_play_skill(MM_SP_DECLINE1, &kid);
						}
						bot->load_play_skill(MM_SP_DECLINE2, &kid);
					}
					bot->load_play_skill(MM_SP_DECLINE3, &kid);
				}
				bot->load_play_skill(MM_SP_DECLINE4, &kid);
			}
			if (tar_ene->is_flora()) bot->load_play_skill(MM_FLORA, &kid);
			if (tar_ene->is_great(leader)) bot->load_play_skill(MM_GREAT, &kid);
			if (tar_ene->is_boss()) bot->load_play_skill(MM_BOSS, &kid);
			bot->load_play_skill(MM_RACE + tar_ene->race(), &kid);
			bot->load_play_skill(MM_ELEMENT + tar_ene->element(), &kid);
			bot->load_play_skill(MM_SIZE + tar_ene->size_(), &kid);
			bot->load_play_skill(MM_BASE, &kid);
		} else bot->load_play_skill(MM_REST, &kid);
		if (kid) {
			int klv = battler->check_skill(kid);
			if (klv &&
				battler->can_use_skill(kid, klv) &&
				(!(skill_get_inf2(kid) & INF2_ENSEMBLE_SKILL) ||
					(bot->battle_mode() != BM_NONE &&
						(bot->distance_policy_value() == DPV_AWAY ||
							bot->check_attack(bot->target_enemy())
						)
					)
				) && (skill_get_inf2(kid) & INF2_ENSEMBLE_SKILL ||
					(bot->check_skill_used_tick(BD_ADAPTATION, 20 * 1000) &&
						bot->check_skill_used_tick(BD_ENCORE, 20 * 1000)
					)
				)
			) {
				bot->use_encore(kid);
				bot->use_skill_self(kid, klv);
			}
		}
	}
}

// Botがスキルを使う。
void ai_t::bot_use_skill() {
	battler_use_skill();
}

// Botが休息する。
void ai_t::bot_rest() {
	if (bot->battle_mode() == BM_NONE &&
		!bot->is_walking() &&
		bot->can_act()
	) {
		if (bot->hp() < bot->max_hp() ||
			bot->sp() < bot->max_sp()
		) {
			if (!bot->is_sit()) bot->sit();
		} else if (bot->is_sit()) bot->stand();
	}
}

// ホムンクルスAIのメイン。
void ai_t::homun_main(block_if* hom) {
	battler = homun = hom;
	homun_lost();
	homun_feed();
	homun_positioning();
	homun_follow();
	homun_attack();
	homun_use_skill();
}

// ホムンクルスが主人を見失う。
void ai_t::homun_lost() {
	block_list* mas_bl = homun->master()->bl();
	if ((homun->bl()->m != mas_bl->m ||
			!check_distance_bl(homun->bl(), mas_bl, AREA_SIZE) ||
			!homun->can_reach_block(homun->master(), false)
		) && homun->teleport(mas_bl)
	) throw turn_end_exception();
}

// ホムンクルスに餌を与える。
void ai_t::homun_feed() {
	if (homun->hd()->homunculus.hunger <= 25) {
		item_key foo_key(homun->hd()->homunculusDB->foodID);
		if (homun->master()->find_inventory(foo_key) != INT_MIN)
			hom_food(homun->master()->sd(), homun->hd());
	}
}

// ホムンクルスが位置取る。
void ai_t::homun_positioning() {
	battler_positioning();
}

// ホムンクルスが主人についていく。
void ai_t::homun_follow() {
	if (homun->battle_mode() == BM_NONE &&
		!homun->is_walking() &&
		homun->can_move() &&
		!homun->check_range_bl(homun->bl(), homun->master()->bl(), 3) &&
		homun->walk_bl(homun->master()->bl(), 3)
	) throw turn_end_exception();
}

// ホムンクルスが攻撃する。
void ai_t::homun_attack() {
	battler_attack();
}

// ホムンクルスがスキルを使う。
void ai_t::homun_use_skill() {
	battler_use_skill();
}

// ペットAIのメイン。
void ai_t::pet_main(block_if* pet_) {
	pet = pet_;
	pet_feed();
	pet_perform();
}

// ペットに餌を与える。
void ai_t::pet_feed() {
	if (pet->pd()->pet.hungry <= 25) {
		item_key foo_key(pet->pd()->get_pet_db()->FoodID);
		if (pet->master()->find_inventory(foo_key) == INT_MIN) {
			pet_menu(pet->master()->sd(), 3);
			throw turn_end_exception();
		}
		pet_menu(pet->master()->sd(), 1);
	}
}

// ペットが応援する。
void ai_t::pet_perform() {
	if (pet->master()->is_casting() &&
		pet->can_act()
	) {
		pet_menu(pet->master()->sd(), 2);
		pet->act_end();
	}
}

// バトラーが位置取る。
void ai_t::battler_positioning() {
	if (battler->battle_mode() != BM_NONE) {
		battler->is_best_pos() = false;
		block_if* att_ene = battler->attacked_short_range_attacker();
		if (!battler->is_primary() &&
			!battler->sc()->data[SC_WARM] &&
			att_ene
		) {
			if (att_ene->check_attack_range(battler) &&
				!battlers.front()->check_attack_range(att_ene) &&
				battler->can_move()
			) {
				pos_t esc_pos;
				iterate_corner_bl(battlers.front()->bl(), att_ene->attack_range(),
					[this, att_ene, &esc_pos] (int x, int y) -> bool
				{
					int dis = distance_client_blxy(att_ene->bl(), x, y);
					if (esc_pos.advantage == INT_MIN ||
						dis > esc_pos.value
					) esc_pos = pos_t(x, y, dis);
					return true;
				});
				if (esc_pos.advantage != INT_MIN &&
					battler->walk_xy(esc_pos.x, esc_pos.y)
				) throw turn_end_exception();
			}
		} else {
			pos_t bat_pos;
			if (battler->battle_mode() == BM_TAUNT)
				bat_pos = find_best_tanut_pos();
			else bat_pos = find_best_assist_pos();
			if (bat_pos.advantage == INT_MIN) {
				if (battler->teleport(&leader->center()))
					throw turn_end_exception();
			} else if (battler->can_move())
				battler->is_best_pos() = !battler->walk_xy(bat_pos.x, bat_pos.y);
		}
	}
}

// バトラーが攻撃する。
void ai_t::battler_attack() {
	if (battler->battle_mode() != BM_NONE &&
		!battler->is_walking()
	) {
		block_if* att_ene = nullptr;
		for (block_if* ene : enemies) {
			block_if* tar_bat = ene->target_battler();
			if (ene->is_short_range_attacker() &&
				tar_bat &&
				tar_bat->battle_index() > battler->battle_index() &&
				battler->check_attack_range(ene) &&
				battler->check_normal_attack(ene) &&
				battler->weapon_attack_element_ratio(ene) > 0
			) {
				att_ene = ene;
				break;
			}
		}
		block_if* tar_ene = battler->target_enemy();
		if (!att_ene &&
			(battler->normal_attack_policy_value() == NAPV_CONTINUOUS ||
				tar_ene->sc()->data[SC_KAUPE] ||
				tar_ene->sc()->data[SC_SAFETYWALL]
			) && battler->check_attack_range(tar_ene) &&
			battler->check_normal_attack(tar_ene)
		) att_ene = tar_ene;
		if (battler->is_attacking() &&
			(!att_ene ||
				battler->ud()->target != att_ene->bl()->id
			)
		) battler->stop_attacking();
		if (!battler->is_attacking() &&
			att_ene
		) battler->attack(
			att_ene,
			battler->normal_attack_policy_value() == NAPV_CONTINUOUS
		);
	}
}

// バトラーがスキルを使う。
void ai_t::battler_use_skill() {
	auto ite_sk_pros = [this] (const ai_t::skill_use_proc_vector* pros, bool tem = false) {
		for (const ai_t::skill_use_proc& sk_use_pro : *pros) {
			if (tem) {
				s_skill* sk = battler->skill(sk_use_pro.skill_id);
				if (!sk ||
					sk->flag != SKILL_FLAG_TEMPORARY
				) continue;
			}
			int klv = battler->check_skill(sk_use_pro.skill_id);
			if (klv < sk_use_pro.min_skill_lv) continue;
			if (sk_use_pro.max_skill_lv) klv = std::min(klv, sk_use_pro.max_skill_lv);
			int sp_rat = sk_use_pro.sp_rat;
			if (sp_rat > 4) sp_rat = sp_ratio_by_enemies();
			if (BATTLE_MODE_FLAG_TABLE[battler->battle_mode()] & sk_use_pro.battle_mode_flag &&
				(battler->is_primary() ? PF_TRUE : PF_FALSE) & sk_use_pro.primary_flag &&
				((sk_use_pro.walking_flag & WF_TRUE &&
						battler->is_walking()
					) || (sk_use_pro.walking_flag & WF_FALSE &&
						!battler->is_walking()
					) 
				) && ((sk_use_pro.attacked_flag & AF_TRUE &&
						(battler->attacked_short_range_attacker() ||
							battler->attacked_long_range_attacker()
						)
					) || (sk_use_pro.attacked_flag & AF_FALSE &&
						((!battler->attacked_short_range_attacker() &&
								!battler->attacked_long_range_attacker()
							) || !skill_get_castcancel(sk_use_pro.skill_id) ||
							battler->is_no_castcancel()
						)
					)
				) && battler->check_sp(sp_rat) &&
				battler->can_use_skill(sk_use_pro.skill_id, klv)
			) {
				// SHOW_DEBUG_VARIABLE(sk_use_pro.skill_id);
				//try {
					sk_use_pro.func(this, sk_use_pro.skill_id, klv);
				//} catch (const turn_end_exception& exc) {
				//	SHOW_DEBUG_VARIABLE(sk_use_pro.skill_id);
				//	throw exc;
				//}
			}
		}
	};

	if (!battler->sc()->cant.cast &&
		battler->can_act() &&
		!battler->is_paralysis()
	) {
		const ai_t::skill_use_proc_vector* pros = nullptr;
		if (dynamic_cast<member_impl*>(battler)) {
			int mem_cla = battler->sd()->status.class_;
			if (mem_cla >= JOB_NOVICE_HIGH &&
				mem_cla <= JOB_THIEF_HIGH
			) mem_cla -= 4001;
			pros = find_map_data(AI_MEMBER_SKILL_USE_PROCS, e_job(mem_cla)).get();
		} else if (dynamic_cast<homun_impl*>(battler)) 
			pros = find_map_data(AI_HOMUN_SKILL_USE_PROCS, battler->homun_mapid_()).get();
		if (pros) ite_sk_pros(pros);
		if (dynamic_cast<member_impl*>(battler)) ite_sk_pros(&AI_MEMBER_TEMPORARY_SKILL_USE_PROCS, true);
	}
}

// バトラーにとって座標が敵モンスターから離れているかを判定する。
// ただし先頭ではないバトラーで、かつターゲットされている敵モンスターは除く。
// また遠隔攻撃の敵モンスターも除く。
bool // 結果。
ai_t::away_enemies(
	int x, // X座標。
	int y  // Y座標。
) {
	bool res = true;
	if (battler->is_primary()) {
		block_if* tar_ene = battler->target_enemy();
		res = !check_distance_blxy(tar_ene->bl(), x, y, tar_ene->away_distance(leader));
	} else {
		for (block_if* ene : enemies) {
			if (check_distance_blxy(ene->bl(), x, y, ene->away_distance(leader)) &&
				ene->target_battler() != battler
			) {
				res = false;
				break;
			}
		}
	}
	return res;
}

// 座標が他のバトラーから離れているかを判定する。
bool // 結果。
ai_t::away_other_battlers(
	int x, // X座標。
	int y  // Y座標。
) {
	bool res = false;
	if (battler != leader) {
		for (int i = 0; i < battlers.size(); i++)	{
			block_if* oth_bat = battlers[i];
			if ((oth_bat == leader ||
					i < battler->battle_index()
				) && !oth_bat->is_walking() &&
				(!check_distance_client_blxy(oth_bat->bl(), x, y, battle_config.pybot_around_distance) ||
					!oth_bat->can_reach_xy(x, y)
				)
			) {
				res = true;
				break;
			}
		}
	}
	return res;
}

// 座標がワープポータルから離れているかを判定する。
bool // 結果。
ai_t::away_warp_portals(
	int x, // X座標。
	int y  // Y座標。
) {
	bool res = true;
	for (npc_data* war_por : warp_portals) {
		if (check_distance_blxy(&war_por->bl, x, y, 3)) {
			res = false;
			break;
		}
	}
	return res;
}

// 座標から他のバトラーに視線が通っているかを判定する。
bool // 結果。
ai_t::check_line_other_battlers(
	int x, // X座標。
	int y  // Y座標。
) {
	bool res = true;
	if (battler != leader) {
		for (int i = 0; i < battlers.size(); i++)	{
			block_if* oth_bat = battlers[i];
			if ((oth_bat == leader ||
					i < battler->battle_index()
				) && !oth_bat->is_walking() &&
				!oth_bat->check_line_xy(x, y)
			) {
				res = false;
				break;
			}
		}
	}
	return res;
}

// バトラーにとって座標がスタックするかを判定する。
bool // 結果。
ai_t::check_stuck(
	int x, // X座標。
	int y  // Y座標。
) {
	bool res = false;
	for (int i = 0; i < battlers.size(); i++)	{
		block_if* oth_bat = battlers[i];
		if ((oth_bat == leader ||
				oth_bat == leader->homun().get() ||
				i < battler->battle_index()
			) && oth_bat->bl()->x == x &&
			oth_bat->bl()->y == y
		) {
			res = true;
			break;
		}
	}
	return res;
}

// バトラーが遠隔に位置取る述語を作る。
yield_xy_func ai_t::find_away_pos_pred(pos_t& pos) {
	int max_rad = battle_config.pybot_around_distance;
	if (battler->normal_attack_policy_value() == NAPV_CONTINUOUS &&
		battler->attack_range() > 3
	) max_rad = battler->attack_range();
	return [this, &pos, max_rad] (int x, int y) -> bool {
		block_if* tar_ene = battler->target_enemy();
		pos_t wai_pos = tar_ene->waiting_position();
		if (check_distance_client_xy(x, y, wai_pos.x, wai_pos.y, max_rad) &&
			battler->can_reach_xy(x, y) &&
			tar_ene->check_line_xy(x, y) &&
			!check_stuck(x, y) &&
			!away_other_battlers(x, y) &&
			check_line_other_battlers(x, y) &&
			away_warp_portals(x, y) &&
			away_enemies(x, y)
		) {
			int adv = battler->skill_advantage(x, y);
			if (adv >= pos.advantage) {
				int dis = distance_client_blxy(battler->bl(), x, y);
				if (adv > pos.advantage ||
					dis < pos.value
				) pos = pos_t(x, y, dis, adv);
			}
		}
		return true;
	};
}

// バトラーにとって最高のアシスト位置を探す。
pos_t // 見つかった位置。見つからなかったらadvantageがINT_MIN。
ai_t::find_best_assist_pos() {
	pos_t pos;
	block_if* tar_ene = battler->target_enemy();
	block_if* tan = tar_ene->target_battler();
	if (battler->distance_policy_value() == DPV_CLOSE &&
		(!battler->sc()->data[SC_WARM] ||
			tar_ene->has_knockback_immune()
		) && (tar_ene->is_long_range_attacker() ||
			(!tar_ene->has_can_attack() ||
				tar_ene->is_flora() ||
				tar_ene->is_berserk() ||
				tar_ene->is_paralysis()
			) && (!tar_ene->is_great(leader) ||
				!battler->around_wall_exists() ||
				!tan ||
				!tan->attacked_by_blower() ||
				tan->is_wall_side()
			)
		)
	) {
		int max_rad = std::min(battler->attack_range(), battle_config.pybot_around_distance);
		pos_t wai_pos = tar_ene->waiting_position();
		for (int rad = 1; rad <= max_rad; ++rad)
			iterate_edge_xy(tar_ene->bl()->m, wai_pos.x, wai_pos.y, rad, find_close_pos_pred(pos));
	}
	if (pos.advantage == INT_MIN) pos = find_best_away_pos();
	return pos;
}

// バトラーにとって最高の遠隔位置を探す。
pos_t // 見つかった位置。見つからなかったらadvantageがINT_MIN。
ai_t::find_best_away_pos() {
	pos_t pos;
	int max_rad = battle_config.pybot_around_distance;
	if (battler->is_long_range_attacker() &&
		battler->normal_attack_policy_value() == NAPV_CONTINUOUS
	) max_rad = battler->attack_range();
	for (int rad = 1; rad <= max_rad; ++rad)
		iterate_edge_bl(battler->target_enemy()->bl(), rad, find_away_pos_pred(pos));
	return pos;
}

// バトラーにとって最高の挑発位置を探す。
pos_t // 見つかった位置。見つからなかったらadvantageがINT_MIN。
ai_t::find_best_tanut_pos() {
	pos_t pos;
	block_if* tar_ene = battler->target_enemy();
	if (battler->is_primary() &&
		tar_ene->is_short_range_attacker() &&
		!tar_ene->is_flora() &&
		tar_ene->is_great(leader) &&
		tar_ene->target_battler() == battler &&
		battler->attacked_by_blower() &&
		battler->around_wall_exists()
	) {
		for (int rad = 0; rad <= battle_config.pybot_around_distance; ++rad)
			iterate_edge_bl(leader->bl(), rad, find_wall_side_pos_pred(pos));
	} else if (battler->distance_policy_value() == DPV_CLOSE &&
		(!battler->sc()->data[SC_WARM] ||
			tar_ene->target_battler() != battler ||
			tar_ene->has_knockback_immune()
		)
	) {
		int max_rad = std::min(battler->attack_range(), battle_config.pybot_around_distance);
		pos_t wai_pos = tar_ene->waiting_position();
		for (int rad = 1; rad <= max_rad; ++rad)
			iterate_edge_xy(tar_ene->bl()->m, wai_pos.x, wai_pos.y, rad, find_close_pos_pred(pos));
	}
	if (pos.advantage == INT_MIN) pos = find_best_away_pos();
	return pos;
}

// バトラーが近接に位置取る述語を作る。
yield_xy_func ai_t::find_close_pos_pred(pos_t& pos) {
	return [this, &pos] (int x, int y) -> bool {
		block_if* tar_ene = battler->target_enemy();
		block_if* tan = tar_ene->target_battler();
		bool wai = !battler->check_attack_range(tar_ene) &&
			tar_ene->is_walking();
		bool bac = battler->is_short_range_attacker() &&
			battler->check_skill(RG_BACKSTAP) &&
			tan &&
			tan->battle_index() < battler->battle_index();
		pos_t wai_pos = tar_ene->waiting_position();
		if (battler->check_range_xy(x, y, wai_pos.x, wai_pos.y, battler->attack_range()) &&
			battler->can_reach_xy(x, y) &&
			tar_ene->check_line_xy(x, y) &&
			!check_stuck(x, y) &&
			!away_other_battlers(x, y) &&
			check_line_other_battlers(x, y) &&
			away_warp_portals(x, y)
		) {
			int adv = battler->skill_advantage(x, y);
			if (adv >= pos.advantage) {
				if (wai) {
					int dis = distance_client_blxy(tar_ene->bl(), x, y);
					if (adv > pos.advantage ||
						dis < pos.value
					) pos = pos_t(x, y, dis, adv);
				} else if (bac) {
					int dis = distance_client_blxy(tan->bl(), x, y);
					if (adv > pos.advantage ||
						dis > pos.value
					) pos = pos_t(x, y, dis, adv);
				} else {
					int dis = distance_client_blxy(battler->bl(), x, y);
					if (adv > pos.advantage ||
						dis < pos.value
					) pos = pos_t(x, y, dis, adv);
				}
			}
		}
		return true;
	};
}

// バトラーが壁際に位置取る述語を作る。
yield_xy_func ai_t::find_wall_side_pos_pred(pos_t& pos) {
	return [this, &pos] (int x, int y) -> bool {
		if (check_wall_side(battler->bl()->m, x, y) &&
			battler->can_reach_xy(x, y) &&
			!check_stuck(x, y) &&
			!away_other_battlers(x, y) &&
			check_line_other_battlers(x, y) &&
			away_warp_portals(x, y)
		) {
			int adv = battler->skill_advantage(x, y);
			if (adv >= pos.advantage) {
				int dis = distance_client_blxy(battler->bl(), x, y);
				if (pos.advantage == INT_MIN ||
					dis < pos.value
				) pos = pos_t(x, y, dis, adv);
			}
		}
		return true;
	};
}

// 敵モンスター数に連動するSP四分率を取得する。
int // 取得した四分率。
ai_t::sp_ratio_by_enemies() {
	return std::max(5 - int(enemies.size()), 1);
}

}
