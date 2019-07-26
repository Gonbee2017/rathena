// [GonBee]
// パーティーBOT機能のAIにおけるスキル使用ハンドラを定義する。

#include "pybot_internal.hpp"

namespace pybot {

// -----------------------------------------------------------------------------
// AIのスキル使用ハンドラの定義

// チャージアローを使う。
AI_SKILL_USE_FUNC(AC_CHARGEARROW) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			bot->skill_ratio(kid, klv, ene) > 0 &&
			!ene->has_knockback_immune() &&
			ene->is_casting() &&
			!ene->is_hiding() &&
			!ene->is_long_weapon_immune() &&
			ene->ud()->skill_id == NC_SELFDESTRUCTION;
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// 集中力向上を使う。
AI_SKILL_USE_FUNC(AC_CONCENTRATION) {
	if (bot->sc_rest(SC_CONCENTRATE) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// ダブルストレイフィングを使う。
AI_SKILL_USE_FUNC(AC_DOUBLE) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) >= 100
	) bot->use_skill_block(kid, klv, tar_ene);
}

// アローシャワーを使う。
AI_SKILL_USE_FUNC(AC_SHOWER) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene)) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_splash(tar_ene, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					bot->skill_ratio(kid, klv, ene) >= 100 &&
					!ene->is_summoned();
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_xy(kid, klv, tar_ene->bl()->x, tar_ene->bl()->y);
	}
}

// エンジェラスを使う。
AI_SKILL_USE_FUNC(AL_ANGELUS) {
	if (bot->sc_rest(SC_ANGELUS) <= bot->get_skill_tail(kid) &&
		!bot->is_magic_immune()
	) bot->use_skill_self(kid, klv);
}

// ブレッシングを使う。
AI_SKILL_USE_FUNC(AL_BLESSING) {
	block_if* mem = pybot::find_if(ALL_RANGE(members), [this, kid] (block_if* mem) -> bool {
		return !mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->is_magic_immune() &&
			!mem->reject_skills()->find(kid) &&
			mem->sc_rest(SC_BLESSING) <= bot->get_skill_tail(kid) &&
			!mem->sc()->data[SC_CHANGEUNDEAD];
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// ブレッシングを使って呪いと石化を治癒する。
AI_SKILL_USE_FUNC_T(AL_BLESSING, cure) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [kid] (block_if* mem) -> bool {
		return !mem->is_hiding() &&
			!mem->is_magic_immune() &&
			!mem->reject_skills()->find(kid) &&
			!mem->sc()->data[SC_CHANGEUNDEAD] &&
			(mem->sc()->data[SC_CURSE] ||
				mem->sc()->opt1 == OPT1_STONE
			);
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// ブレッシングを使って呪いをかける。
AI_SKILL_USE_FUNC_T(AL_BLESSING, curse) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			!ene->has_status_immune() &&
			!ene->is_hiding() &&
			!ene->is_magic_immune() &&
			(ene->is_undead() ||
				ene->race() == RC_DEMON
			) && !ene->sc()->data[SC_BLESSING];
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// シグナムクルシスを使う。
AI_SKILL_USE_FUNC(AL_CRUCIS) {
	int cou = std::count_if(ALL_RANGE(enemies), [] (block_if* ene) -> bool {
		return ene->is_berserk() &&
			!ene->is_summoned() &&
			(ene->is_undead() ||
				ene->race() == RC_DEMON
			) && !ene->sc()->data[SC_SIGNUMCRUCIS];
	});
	if (cou >= bot->get_skill_monsters()) bot->use_skill_self(kid, klv);
}

// キュアーを使う。
AI_SKILL_USE_FUNC(AL_CURE) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [kid] (block_if* mem) -> bool {
		return !mem->is_hiding() &&
			!mem->reject_skills()->find(kid) &&
			(mem->sc()->data[SC_BLIND] ||
				mem->sc()->data[SC_CONFUSION] ||
				mem->sc()->data[SC_SILENCE]
			);
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// 速度減少を使う。
AI_SKILL_USE_FUNC(AL_DECAGI) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			!ene->has_status_immune() &&
			!ene->is_hiding() &&
			!ene->is_magic_immune() &&
			!ene->sc()->data[SC_SPEEDUP1] &&
			(ene->sc()->data[SC_ADRENALINE] ||
				ene->sc()->data[SC_INCREASEAGI] ||
				ene->sc()->data[SC_TWOHANDQUICKEN]
			) && !ene->sc()->data[SC_DECREASEAGI];
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// ヒールでアンデッドを攻撃する。
AI_SKILL_USE_FUNC_T(AL_HEAL, attack) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		tar_ene->is_undead()
	) bot->use_skill_block(kid, klv, tar_ene);
}

// アクアベネディクタを使う。
AI_SKILL_USE_FUNC(AL_HOLYWATER) {
	if (map_getcellp(map_getmapdata(bot->bl()->m), bot->bl()->x, bot->bl()->y, CELL_CHKWATER))
		bot->use_skill_self(kid, klv);
}

// 速度増加を使う。
AI_SKILL_USE_FUNC(AL_INCAGI) {
	block_if* mem = pybot::find_if(ALL_RANGE(members), [this, kid] (block_if* mem) -> bool {
		return !mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->is_magic_immune() &&
			!mem->reject_skills()->find(kid) &&
			mem->sc_rest(SC_INCREASEAGI) <= bot->get_skill_tail(kid) &&
			!mem->sc()->data[SC_QUAGMIRE] &&
			!mem->sc()->data[SC_CHANGEUNDEAD];
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// ニューマを使う。
AI_SKILL_USE_FUNC(AL_PNEUMA) {
	if (bot->distance_policy_value() == DPV_AWAY &&
		!bot->sc()->data[SC_PNEUMA] &&
		bot->is_best_pos()
	) {
		block_if* ene = pybot::find_if(ALL_RANGE(enemies), [] (block_if* ene) -> bool {
			return ene->has_long_weapon_skill() ||
				ene->is_long_range_attacker();
		});
		if (ene &&
			!skill_check_unit_range(bot->bl(), bot->bl()->x, bot->bl()->y, kid, klv)
		) bot->use_skill_xy(kid, klv, bot->bl()->x, bot->bl()->y);
	}
}

// リザレクションを使う。
AI_SKILL_USE_FUNC(ALL_RESURRECTION) {
	block_if* mem = pybot::find_if(ALL_RANGE(members), [this, kid, klv] (block_if* mem) -> bool {
		return bot->can_reach_block(mem) &&
			mem->is_dead() &&
			!mem->reject_skills()->find(ALL_RESURRECTION);
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// アシッドテラーを使う。
AI_SKILL_USE_FUNC(AM_ACIDTERROR) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) >= 100 &&
		tar_ene->is_great(leader) &&
		!tar_ene->is_long_weapon_immune()
	) bot->use_skill_block(kid, klv, tar_ene);
}

// バーサークピッチャーを使う。
AI_SKILL_USE_FUNC(AM_BERSERKPITCHER) {
	block_if* mem = pybot::find_if(ALL_RANGE(members), [kid] (block_if* mem) -> bool {
		return mem->normal_attack_policy_value() == NAPV_CONTINUOUS &&
			!mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->reject_skills()->find(kid) &&
			!mem->sc()->data[SC_ASPDPOTION0] &&
			!mem->sc()->data[SC_ASPDPOTION1] &&
			!mem->sc()->data[SC_ASPDPOTION2] &&
			!mem->sc()->data[SC_ASPDPOTION3];
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// コールホムンクルスを使う。
AI_SKILL_USE_FUNC(AM_CALLHOMUN) {
	if (bot->homun()->exists() &&
		!bot->homun()->is_active() &&
		!bot->homun()->is_dead() &&
		bot->find_inventory(item_key(bot->homun()->hd()->homunculusDB->foodID)) != INT_MIN
	) bot->use_skill_self(kid, klv);
}

// バイオプラントを使う。
AI_SKILL_USE_FUNC(AM_CANNIBALIZE) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_used_tick(kid, 60 * 1000) &&
		tar_ene->is_great(leader)
	) bot->use_skill_xy(kid, klv, tar_ene->bl()->x, tar_ene->bl()->y);
}

// ポーションピッチャーを使ってSPを回復する。
AI_SKILL_USE_FUNC_T(AM_POTIONPITCHER, sp) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [kid] (block_if* mem) -> bool {
		return !mem->check_sp(1) &&
			!mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->is_invincible() &&
			!mem->reject_skills()->find(kid) &&
			!mem->sc()->data[SC_BERSERK];
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// 安息を使う。
AI_SKILL_USE_FUNC(AM_REST) {
	if (bot->homun()->is_active() &&
		bot->homun()->hd()->homunculus.hunger <= 25 &&
		bot->find_inventory(item_key(bot->homun()->hd()->homunculusDB->foodID)) == INT_MIN
	) bot->use_skill_self(kid, klv);
}

// リザレクションホムンクルスを使う。
AI_SKILL_USE_FUNC(AM_RESURRECTHOMUN) {
	if (bot->homun()->exists() &&
		!bot->homun()->is_active() &&
		bot->homun()->is_dead()
	) bot->use_skill_self(kid, klv);
}

// エンチャントポイズンを使う。
AI_SKILL_USE_FUNC(AS_ENCHANTPOISON) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [this, kid, klv] (block_if* mem) -> bool {
		block_if* tar_ene = mem->target_enemy();
		return !mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->reject_skills()->find(kid) &&
			mem->sc_rest(SC_ENCPOISON) <= bot->get_skill_tail(kid) &&
			pc_checkequip(mem->sd(), EQP_WEAPON) >= 0 &&
			tar_ene &&
			mem->attack_element_ratio(tar_ene, ELE_POISON) >= 100 &&
			mem->attack_element_ratio(tar_ene, ELE_POISON) >= mem->weapon_attack_element_ratio(tar_ene);
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// ポイズンリアクトを使う。
AI_SKILL_USE_FUNC(AS_POISONREACT) {
	if (bot->sc_rest(SC_POISONREACT) <= bot->get_skill_tail(kid) &&
		bot->target_enemy()->element() == ELE_POISON
	) bot->use_skill_self(kid, klv);
}

// ソウルブレイカーを使う。
AI_SKILL_USE_FUNC(ASC_BREAKER) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene)
	) bot->use_skill_block(kid, klv, tar_ene);
}

// エンチャントデッドリーポイズンを使う。
AI_SKILL_USE_FUNC(ASC_EDP) {
	if (bot->distance_policy_value() == DPV_CLOSE &&
		bot->sc_rest(SC_EDP) <= bot->get_skill_tail(kid) &&
		bot->target_enemy()->is_great(leader)
	) bot->use_skill_self(kid, klv);
}

// 寒いジョークを使う。
AI_SKILL_USE_FUNC(BA_FROSTJOKER) {
	if (bot->check_skill_used_tick(kid, skill_get_delay(kid, klv) * 2)) {
		int cou = std::count_if(ALL_RANGE(enemies), [] (block_if* ene) -> bool {
			return ene->is_freezable();
		});
		if (cou >= bot->get_skill_monsters()) bot->use_skill_self(kid, klv);
	}
}

// アドリブを使う。
AI_SKILL_USE_FUNC(BD_ADAPTATION) {
	if (bot->is_solo()) bot->use_skill_self(kid, klv);
}

// アドレナリンラッシュを使う。
AI_SKILL_USE_FUNC(BS_ADRENALINE) {
	if (bot->sc_rest(SC_ADRENALINE) <= bot->get_skill_tail(kid) &&
		!bot->sc()->data[SC_ADRENALINE2] &&
		!bot->sc()->data[SC_DECREASEAGI] &&
		!bot->sc()->data[SC_QUAGMIRE]
	) bot->use_skill_self(kid, klv);
}

// フルアドレナリンラッシュを使う。
AI_SKILL_USE_FUNC(BS_ADRENALINE2) {
	if (bot->sc_rest(SC_ADRENALINE2) <= bot->get_skill_tail(kid) &&
		!bot->sc()->data[SC_DECREASEAGI] &&
		!bot->sc()->data[SC_QUAGMIRE]
	) bot->use_skill_self(kid, klv);
}

// ハンマーフォールを使う。
AI_SKILL_USE_FUNC(BS_HAMMERFALL) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_skill_used_tick(kid, 2500)
	) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_layout(bot, tar_ene, kid, klv, [] (block_if* ene) -> bool {
				return !ene->has_status_immune() &&
					!ene->is_paralysis();
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_xy(kid, klv, tar_ene->bl()->x, tar_ene->bl()->y);
	}
}

// マキシマイズパワー状態になる。
AI_SKILL_USE_FUNC_T(BS_MAXIMIZE, activate) {
	if (bot->normal_attack_policy_value() == NAPV_CONTINUOUS &&
		!bot->sc()->data[SC_MAXIMIZEPOWER]
	) bot->use_skill_self(kid, klv);
}

// マキシマイズパワー状態を解除する。
AI_SKILL_USE_FUNC_T(BS_MAXIMIZE, deactivate) {
	if (bot->sc()->data[SC_MAXIMIZEPOWER] &&
		(bot->battle_mode() == BM_NONE ||
			!bot->check_sp(1)
		)
	) bot->use_skill_self(kid, klv);
}

// オーバートラストを使う。
AI_SKILL_USE_FUNC(BS_OVERTHRUST) {
	if (!bot->sc()->data[SC_MAXOVERTHRUST] &&
		bot->sc_rest(SC_OVERTHRUST) <= bot->get_skill_tail(kid)
	) bot->use_skill_self(kid, klv);
}

// 武器修理を使う。
AI_SKILL_USE_FUNC(BS_REPAIRWEAPON) {
	static std::array<int,4> MAT_IDS = {
		ITEMID_IRON_ORE,
		ITEMID_IRON,
		ITEMID_STEEL,
		ITEMID_ORIDECON_STONE
	};

	int itm_ind;
	block_if* mem = pybot::find_if(ALL_RANGE(members), [this, kid, &itm_ind] (block_if* mem) -> bool {
		if (!mem->reject_skills()->find(kid) &&
			!mem->is_walking()
		) {
			for (itm_ind = 0;; ++itm_ind) {
				itm_ind = mem->find_broken_equip(itm_ind);
				if (itm_ind == INT_MIN) break;
				item_data* idb = mem->sd()->inventory_data[itm_ind];
				int mat_id;
				if (idb->type == IT_WEAPON) mat_id = MAT_IDS[idb->wlv - 1];
				else mat_id = ITEMID_STEEL;
				if (bot->find_inventory(item_key(mat_id)) != INT_MIN) return true;
			}
		}
		return false;
	});
	if (mem) {
		int mem_id = mem->bl()->id;
		bot->use_skill_block(kid, klv, mem, true, [itm_ind, mem_id] (ai_t* ai, void* fun) {
			ai->bot->sd()->menuskill_val = mem_id;
			skill_repairweapon(ai->bot->sd(), itm_ind);
		});
	}
}

// ウェポンパーフェクションを使う。
AI_SKILL_USE_FUNC(BS_WEAPONPERFECT) {
	if (bot->sc_rest(SC_WEAPONPERFECTION) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// 私を縛らないでを使う。
AI_SKILL_USE_FUNC(CG_LONGINGFREEDOM) {
	if (bot->is_ensemble() &&
		(bot->sc()->data[SC_DANCING]->val1 & 0xFFFF) != CG_MOONLIT &&
		!bot->sc()->data[SC_LONGING]
	) bot->use_skill_self(kid, klv);
}

// 連柱崩撃を使う。
AI_SKILL_USE_FUNC(CH_CHAINCRUSH) {
	if (bot->collect_spirits(2)) bot->use_skill_self(kid, klv);
}

// 猛虎硬爬山を使う。
AI_SKILL_USE_FUNC(CH_PALMSTRIKE) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) > 0 &&
		tar_ene->has_knockback_immune()
	) bot->use_skill_block(kid, klv, tar_ene);
}

// 練気功を使う。
AI_SKILL_USE_FUNC(CH_SOULCOLLECT) {
	if (bot->sd()->spiritball < 4) bot->use_skill_self(kid, klv);
}

// 伏虎拳を使う。
AI_SKILL_USE_FUNC(CH_TIGERFIST) {
	if (bot->collect_spirits(1)) bot->use_skill_self(kid, klv);
}

// オートガードを使う。
AI_SKILL_USE_FUNC(CR_AUTOGUARD) {
	if (bot->sc_rest(SC_AUTOGUARD) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// ディフェンダー状態になる。
AI_SKILL_USE_FUNC_T(CR_DEFENDER, activate) {
	if (!bot->sc()->data[SC_DEFENDER]) {
		block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this] (block_if* ene) -> bool {
			return ene->is_great(leader) &&
				ene->has_long_weapon_skill();
		});
		if (ene) bot->use_skill_self(kid, klv);
	}
}

// ディフェンダー状態を解除する。
AI_SKILL_USE_FUNC_T(CR_DEFENDER, deactivate) {
	if (bot->sc()->data[SC_DEFENDER]) {
		block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this] (block_if* ene) -> bool {
			return ene->is_great(leader) &&
				ene->has_long_weapon_skill();
		});
		if (!ene) bot->use_skill_self(kid, klv);
	}
}

// ディボーションを使う。
AI_SKILL_USE_FUNC(CR_DEVOTION) {
	if (bot->party_id()) {
		int cou = min(klv, MAX_DEVOTION);
		int i;
		ARR_FIND(0, cou, i, !bot->sd()->devotion[i]);
		if (i < cou) {
			block_if* mem = pybot::find_if(ALL_RANGE(members), [this, kid] (block_if* mem) -> bool {
				return mem->party_id() == bot->party_id() &&
					mem != bot &&
					(mem->sd()->class_ & MAPID_UPPERMASK) != MAPID_CRUSADER &&
					!mem->is_dead() &&
					!mem->is_hiding() &&
					!mem->is_invincible() &&
					!mem->reject_skills()->find(kid) &&
					mem->sc_rest(SC_DEVOTION) <= bot->get_skill_tail(kid);
			});
			if (mem) bot->use_skill_block(kid, klv, mem);
		}
	}
}

// フルケミカルチャージを使う。
AI_SKILL_USE_FUNC(CR_FULLPROTECTION) {
	static const std::array<skill_use_func,4> CP_FUNS = {
		AI_SKILL_USE_DEF(cp)(EQP_WEAPON  , SC_CP_WEAPON, &enemy_if::has_unequip_weapon_skill),
		AI_SKILL_USE_DEF(cp)(EQP_SHIELD  , SC_CP_SHIELD, &enemy_if::has_unequip_shield_skill),
		AI_SKILL_USE_DEF(cp)(EQP_ARMOR   , SC_CP_ARMOR , &enemy_if::has_unequip_armor_skill ),
		AI_SKILL_USE_DEF(cp)(EQP_HEAD_TOP, SC_CP_HELM  , &enemy_if::has_unequip_helm_skill  ),
	};
	for (skill_use_func cp_fun : CP_FUNS) cp_fun(this, kid, klv);
}

// グランドクロスを使う。
AI_SKILL_USE_FUNC(CR_GRANDCROSS) {
	if (bot->check_hp(3) ||
		bot->sc()->data[SC_BENEDICTIO]
	) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_layout(bot, bot, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					bot->skill_ratio(kid, klv, ene) > 0 &&
					!ene->is_summoned();
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_self(kid, klv);
	}
}

// 効果的なグランドクロスを使う。
AI_SKILL_USE_FUNC_T(CR_GRANDCROSS, effective) {
	if (bot->check_hp(3) ||
		bot->sc()->data[SC_BENEDICTIO]
	) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_layout(bot, bot, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					bot->skill_ratio(kid, klv, ene) > 100 &&
					!ene->is_summoned();
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_self(kid, klv);
	}
}

// プロヴィデンスを使う。
AI_SKILL_USE_FUNC(CR_PROVIDENCE) {
	block_if* mem = pybot::find_if(ALL_RANGE(members), [this, kid] (block_if* mem) -> bool {
		return mem != bot &&
			!mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->is_magic_immune() &&
			!mem->reject_skills()->find(kid) &&
			mem->sc_rest(SC_PROVIDENCE) <= bot->get_skill_tail(kid);
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// リフレクトシールドを使う。
AI_SKILL_USE_FUNC(CR_REFLECTSHIELD) {
	if (bot->sc_rest(SC_REFLECTSHIELD) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// 魂状態でシールドブーメランを使う。
AI_SKILL_USE_FUNC_T(CR_SHIELDBOOMERANG, spirit) {
	if (bot->sc()->data[SC_SPIRIT]) {
		block_if* tar_ene = bot->target_enemy();
		if (bot->check_skill_range_block(kid, klv, tar_ene) &&
			bot->check_use_skill(kid, klv, tar_ene)
		) bot->use_skill_block(kid, klv, tar_ene);
	}
}

// シュリンクを使う。
AI_SKILL_USE_FUNC(CR_SHRINK) {
	if (bot->sc_rest(SC_SHRINK) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// スピアクイッケンを使う。
AI_SKILL_USE_FUNC(CR_SPEARQUICKEN) {
	if (!bot->sc()->data[SC_DECREASEAGI] &&
		!bot->sc()->data[SC_QUAGMIRE] &&
		bot->sc_rest(SC_SPEARQUICKEN) <= bot->get_skill_tail(kid)
	) bot->use_skill_self(kid, klv);
}

// スクリームを使う。
AI_SKILL_USE_FUNC(DC_SCREAM) {
	if (bot->check_skill_used_tick(kid, skill_get_delay(kid, klv) * 2)) {
		int cou = std::count_if(ALL_RANGE(enemies), [] (block_if* ene) -> bool {
			return !ene->has_status_immune() &&
				!ene->is_paralysis();
		});
		if (cou >= bot->get_skill_monsters()) bot->use_skill_self(kid, klv);
	}
}

// 魅惑のウィンクを使う。
AI_SKILL_USE_FUNC(DC_WINKCHARM) {
	block_if* ene = pybot::find_if(ALL_RRANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			ene != enemies.front() &&
			status_get_lv(ene->bl()) < status_get_lv(bot->bl()) &&
			ene->check_skill_used_tick(kid, 2500) &&
			!ene->has_status_immune() &&
			!ene->is_summoned();
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// アジャストメントを使う。
AI_SKILL_USE_FUNC(GS_ADJUSTMENT) {
	if (bot->target_enemy()->is_great(leader) &&
		bot->sc_rest(SC_ADJUSTMENT) <= bot->get_skill_tail(kid) &&
		bot->collect_coins(2)
	) bot->use_skill_self(kid, klv);
}

// ブルズアイを使う。
AI_SKILL_USE_FUNC(GS_BULLSEYE) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) >= 100 &&
		tar_ene->race() & (RC_BRUTE | RC_DEMIHUMAN) &&
		bot->collect_coins(1)
	) bot->use_skill_block(kid, klv, tar_ene);
}

// クラッカーを使って詠唱を邪魔する。
AI_SKILL_USE_FUNC(GS_CRACKER) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			bot->skill_ratio(kid, klv, ene) > 0 &&
			!ene->has_status_immune() &&
			ene->is_casting() &&
			!ene->is_long_weapon_immune();
	});
	if (ene &&
		bot->collect_coins(1)
	) bot->use_skill_block(kid, klv, ene);
}

// デスペラードを使う。
AI_SKILL_USE_FUNC(GS_DESPERADO) {
	int cou = std::count_if(ALL_RANGE(enemies),
		sift_block_layout(bot, bot, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
			return bot->check_use_skill(kid, klv, ene) &&
				bot->skill_ratio(kid, klv, ene) >= 100 &&
				!ene->is_summoned() &&
				!skill_unit_exists_block(ene, skill_unit_key_map{SKILL_UNIT_KEY(SA_LANDPROTECTOR)});
		})
	);
	if (cou >= bot->get_skill_monsters()) bot->use_skill_self(kid, klv);
}

// ディスアームを使う。
AI_SKILL_USE_FUNC(GS_DISARM) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			bot->check_use_skill(kid, klv, ene) &&
			bot->skill_ratio(kid, klv, ene) > 0 &&
			ene->check_skill_used_tick(kid, 2500) &&
			!ene->has_status_immune() &&
			!ene->sc()->data[SC_STRIPWEAPON];
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// ダストを使う。
AI_SKILL_USE_FUNC(GS_DUST) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			bot->skill_ratio(kid, klv, ene) > 0 &&
			!ene->has_knockback_immune() &&
			ene->is_casting() &&
			!ene->is_hiding() &&
			ene->ud()->skill_id == NC_SELFDESTRUCTION;
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// フライングを使う。
AI_SKILL_USE_FUNC(GS_FLING) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) > 0 &&
		tar_ene->def() + tar_ene->def2() >= 100 &&
		tar_ene->def() < 100 &&
		!tar_ene->has_status_immune() &&
		!tar_ene->sc()->data[GS_FLING] &&
		bot->collect_coins(5)
	) bot->use_skill_block(kid, klv, tar_ene);
}

// ピアーシングショットを使う。
AI_SKILL_USE_FUNC(GS_PIERCINGSHOT) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) >= 100 &&
		tar_ene->check_skill_used_tick(kid, 2500) &&
		!tar_ene->has_status_immune() &&
		!tar_ene->sc()->data[SC_BLEEDING]
	) bot->use_skill_block(kid, klv, tar_ene);
}

// ガトリングフィーバー状態になる。
AI_SKILL_USE_FUNC_T(GS_GATLINGFEVER, activate) {
	if (!bot->sc()->data[SC_GATLINGFEVER] &&
		bot->is_best_pos()
	) bot->use_skill_self(kid, klv);
}

// ガトリングフィーバー状態を解除する。
AI_SKILL_USE_FUNC_T(GS_GATLINGFEVER, deactivate) {
	if (bot->sc()->data[SC_GATLINGFEVER] &&
		(bot->battle_mode() == BM_NONE ||
			!bot->is_best_pos()
		)
	) bot->use_skill_self(kid, klv);
}

// フリップザコインを使う。
AI_SKILL_USE_FUNC(GS_GLITTERING) {
	bot->collect_coins(bot->check_skill(kid));
}

// グラウンドドリフトを使う。
AI_SKILL_USE_FUNC(GS_GROUNDDRIFT) {
	block_if* tar_ene = bot->target_enemy();
	int amm_ind = bot->sd()->equip_index[EQI_AMMO];
	if (amm_ind >= 0) {
		item* amm_itm = &bot->sd()->inventory.u.items_inventory[amm_ind];
		if ((amm_itm->nameid == ITEMID_LIGHTNING_SPHERE ||
				amm_itm->nameid == ITEMID_FREEZING_SPHERE
			) && bot->check_skill_range_block(kid, klv, tar_ene)
		) {
			int cou = std::count_if(ALL_RANGE(enemies),
				sift_block_layout(bot, tar_ene, kid, klv, [this, kid, klv, amm_itm] (block_if* ene) -> bool {
					return bot->check_use_skill(kid, klv, ene) &&
						bot->skill_ratio(kid, klv, ene) >= 100 &&
						!ene->is_paralysis() &&
						!skill_unit_exists_block(ene, skill_unit_key_map{SKILL_UNIT_KEY(SA_LANDPROTECTOR)});
				})
			);
			if (cou >= bot->get_skill_monsters()) bot->use_skill_xy(kid, klv, tar_ene->bl()->x, tar_ene->bl()->y);
		}
	}
}

// インクリージングアキュラシーを使う。
AI_SKILL_USE_FUNC(GS_INCREASING) {
	if (bot->sc_rest(SC_INCREASING) <= bot->get_skill_tail(kid) &&
		bot->collect_coins(4)
	) bot->use_skill_self(kid, klv);
}

// マッドネスキャンセラー状態になる。
AI_SKILL_USE_FUNC_T(GS_MADNESSCANCEL, activate) {
	if (!bot->sc()->data[SC_MADNESSCANCEL] &&
		bot->is_best_pos() &&
		bot->target_enemy()->is_great(leader) &&
		bot->collect_coins(1)
	) bot->use_skill_self(kid, klv);
}

// マッドネスキャンセラー状態を解除する。
AI_SKILL_USE_FUNC_T(GS_MADNESSCANCEL, deactivate) {
	if (bot->sc()->data[SC_MADNESSCANCEL] &&
		(bot->battle_mode() == BM_NONE ||
			!bot->is_best_pos() ||
			!bot->target_enemy()->is_great(leader)
		)
	) bot->use_skill_self(kid, klv);
}

// マジカルバレットを使う。
AI_SKILL_USE_FUNC(GS_MAGICALBULLET) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->attack_element_ratio(tar_ene, ELE_GHOST) > 100 &&
		bot->collect_coins(1)
	) bot->use_skill_block(kid, klv, tar_ene);
}

// トラッキングを使う。
AI_SKILL_USE_FUNC(GS_TRACKING) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) >= 100 &&
		tar_ene->flee() - bot->hit() > 25
	) bot->use_skill_block(kid, klv, tar_ene);
}

// トリプルアクションを使う。
AI_SKILL_USE_FUNC(GS_TRIPLEACTION) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) >= 100 &&
		bot->collect_coins(1)
	) bot->use_skill_block(kid, klv, tar_ene);
}

// アスムプティオを先頭のメンバーに使う。
AI_SKILL_USE_FUNC_T(HP_ASSUMPTIO, primary) {
	block_if* pri_mem = members.front();
	if (!pri_mem->is_dead() &&
		!pri_mem->is_hiding() &&
		!pri_mem->is_magic_immune() &&
		pri_mem->is_primary() &&
		!pri_mem->reject_skills()->find(kid) &&
		pri_mem->sc_rest(SC_ASSUMPTIO) <= bot->get_skill_tail(kid) &&
		!pri_mem->sc()->data[SC_KAITE] &&
		!pri_mem->sc()->data[SC_KYRIE]
	) bot->use_skill_block(kid, klv, pri_mem);
}

// アスムプティオを先頭のメンバー以外に使う。
AI_SKILL_USE_FUNC_T(HP_ASSUMPTIO, not_primary) {
	block_if* mem = pybot::find_if(ALL_RANGE(members), [this, kid] (block_if* mem) -> bool {
		return !mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->is_magic_immune() &&
			!mem->is_primary() &&
			!mem->reject_skills()->find(kid) &&
			mem->sc_rest(SC_ASSUMPTIO) <= bot->get_skill_tail(kid) &&
			!mem->sc()->data[SC_KAITE] &&
			!mem->sc()->data[SC_KYRIE];
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// アンクルスネアを使う。
AI_SKILL_USE_FUNC(HT_ANKLESNARE) {
	block_if* ene = pybot::find_if(ALL_RRANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return ene->is_walking() &&
			bot->check_skill_range_xy(kid, klv, ene->ud()->to_x, ene->ud()->to_y) &&
			!skill_check_unit_range(bot->bl(), ene->ud()->to_x, ene->ud()->to_y, kid, klv) &&
			!skill_check_unit_range2(bot->bl(), ene->ud()->to_x, ene->ud()->to_y, kid, klv, false);
	});
	if (ene) bot->use_skill_xy(kid, klv, ene->ud()->to_x, ene->ud()->to_y);
}

// ディテクティングを使う。
AI_SKILL_USE_FUNC(HT_DETECTING) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			ene->is_hiding();
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// フリージングトラップを使う。
AI_SKILL_USE_FUNC(HT_FREEZINGTRAP) {
	block_if* ene = pybot::find_if(ALL_RRANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return ene->is_walking() &&
			bot->check_skill_range_xy(kid, klv, ene->ud()->to_x, ene->ud()->to_y) &&
			ene->is_freezable() &&
			!skill_check_unit_range(bot->bl(), ene->ud()->to_x, ene->ud()->to_y, kid, klv) &&
			!skill_check_unit_range2(bot->bl(), ene->ud()->to_x, ene->ud()->to_y, kid, klv, false);
	});
	if (ene) bot->use_skill_xy(kid, klv, ene->ud()->to_x, ene->ud()->to_y);
}

// ランドマインを使う。
AI_SKILL_USE_FUNC(HT_LANDMINE) {
	block_if* ene = pybot::find_if(ALL_RRANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return ene->is_walking() &&
			bot->check_skill_range_xy(kid, klv, ene->ud()->to_x, ene->ud()->to_y) &&
			bot->skill_ratio(kid, klv, ene) > 100 &&
			!skill_check_unit_range(bot->bl(), ene->ud()->to_x, ene->ud()->to_y, kid, klv) &&
			!skill_check_unit_range2(bot->bl(), ene->ud()->to_x, ene->ud()->to_y, kid, klv, false);
	});
	if (ene) bot->use_skill_xy(kid, klv, ene->ud()->to_x, ene->ud()->to_y);
}

// ビーストストレイフィングを使う。
AI_SKILL_USE_FUNC(HT_POWER) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) >= 100 &&
		(tar_ene->race() == RC_BRUTE ||
			tar_ene->race() == RC_INSECT
		)
	) bot->use_skill_block(kid, klv, tar_ene);
}

// リムーブトラップを使う。
AI_SKILL_USE_FUNC(HT_REMOVETRAP) {
	skill_unit* my_tra;
	yield_bl_func fin_my_tra = [this, &my_tra] (block_list* bl) -> int {
		skill_unit* kun = (skill_unit*)bl;
		if (skill_get_inf2(kun->group->skill_id) & INF2_TRAP &&
			kun->group->src_id == bot->bl()->id
		) {
			my_tra = kun;
			return 1;
		}
		return 0;
	};
	if (map_foreachinshootrange(
			callback_yield_bl,
			&leader->center(),
			battle_config.pybot_around_distance,
			BL_SKILL,
			&fin_my_tra
		)
	) bot->use_skill_bl(kid, klv, &my_tra->bl);
}

// サンドマンを使う。
AI_SKILL_USE_FUNC(HT_SANDMAN) {
	block_if* ene = pybot::find_if(ALL_RRANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return ene->is_walking() &&
			bot->check_skill_range_xy(kid, klv, ene->ud()->to_x, ene->ud()->to_y) &&
			!ene->has_status_immune() &&
			!skill_check_unit_range(bot->bl(), ene->ud()->to_x, ene->ud()->to_y, kid, klv) &&
			!skill_check_unit_range2(bot->bl(), ene->ud()->to_x, ene->ud()->to_y, kid, klv, false);
	});
	if (ene) bot->use_skill_xy(kid, klv, ene->ud()->to_x, ene->ud()->to_y);
}

// ガンバンテインを使う。
AI_SKILL_USE_FUNC(HW_GANBANTEIN) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_attack(tar_ene) &&
		tar_ene->is_great(leader) &&
		(tar_ene->sc()->data[SC_PNEUMA] ||
			tar_ene->sc()->data[SC_SAFETYWALL]
		)
	) bot->use_skill_xy(kid, klv, tar_ene->bl()->x, tar_ene->bl()->y);
}

// グラビテーションフィールドを使う。
AI_SKILL_USE_FUNC(HW_GRAVITATION) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene)) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_layout(bot, tar_ene, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					!ene->is_paralysis() &&
					!ene->is_summoned() &&
					!ene->sc()->data[SC_GRAVITATION];
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_xy(kid, klv, tar_ene->bl()->x, tar_ene->bl()->y);
	}
}

// オートカウンターを使う。
AI_SKILL_USE_FUNC(KN_AUTOCOUNTER) {
	block_if* tar_ene = bot->target_enemy();
	if (!bot->check_hp(3) &&
		!bot->sc()->data[SC_AUTOCOUNTER] &&
		bot->attacked_enemies().size() == 1 &&
		bot->attacked_enemies().front() == tar_ene
	) {
		int sel_dir = unit_getdir(bot->bl());
		int tar_dir = map_calc_dir(bot->bl(), tar_ene->bl()->x, tar_ene->bl()->y);
		int dis = distance_bl(bot->bl(), tar_ene->bl());
		if (!dis ||
			(!map_check_dir(sel_dir, tar_dir) &&
				dis <= bot->attack_range() + 1
			)
		) bot->use_skill_self(kid, klv);
	}
}

// チャージアタックを使う。
AI_SKILL_USE_FUNC(KN_CHARGEATK) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->distance_policy_value() == DPV_CLOSE &&
		!bot->check_attack_range(tar_ene) &&
		bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		tar_ene->has_knockback_immune()
	) bot->use_skill_block(kid, klv, tar_ene);
}

// ワンハンドクイッケンを使う。
AI_SKILL_USE_FUNC(KN_ONEHAND) {
	if (!bot->sc()->data[SC_DECREASEAGI] &&
		bot->sc_rest(SC_ONEHAND) <= bot->get_skill_tail(kid) &&
		!bot->sc()->data[SC_QUAGMIRE]
	) bot->use_skill_self(kid, klv);
}

// ピアースを使う。
AI_SKILL_USE_FUNC(KN_PIERCE) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) > 0 &&
		tar_ene->size_() != SZ_SMALL
	) bot->use_skill_block(kid, klv, tar_ene);
}

// ツーハンドクイッケンを使う。
AI_SKILL_USE_FUNC(KN_TWOHANDQUICKEN) {
	if (!bot->sc()->data[SC_DECREASEAGI] &&
		!bot->sc()->data[SC_QUAGMIRE] &&
		bot->sc_rest(SC_TWOHANDQUICKEN) <= bot->get_skill_tail(kid)
	) bot->use_skill_self(kid, klv);
}

// オーラブレイドを使う。
AI_SKILL_USE_FUNC(LK_AURABLADE) {
	if (bot->sc_rest(SC_AURABLADE) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// バーサークを使う。
AI_SKILL_USE_FUNC(LK_BERSERK) {
	if (!bot->check_hp(1) &&
		!bot->sc()->data[SC_BERSERK]
	) bot->use_skill_self(kid, klv);
}

// コンセントレイションを使う。
AI_SKILL_USE_FUNC(LK_CONCENTRATION) {
	if (bot->sc_rest(SC_CONCENTRATION) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// ヘッドクラッシュを使う。
AI_SKILL_USE_FUNC(LK_HEADCRUSH) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			bot->skill_ratio(kid, klv, ene) > 0 &&
			ene->check_skill_used_tick(kid, 2500) &&
			!ene->has_status_immune() &&
			!ene->is_hiding() &&
			!ene->sc()->data[SC_BLEEDING] &&
			ene->target_battler() &&
			ene->target_battler()->battle_index() > bot->battle_index();
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// ジョイントビートを使う。
AI_SKILL_USE_FUNC(LK_JOINTBEAT) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			bot->skill_ratio(kid, klv, ene) > 0 &&
			ene->check_skill_used_tick(kid, 2500) &&
			!ene->has_status_immune() &&
			!ene->is_hiding() &&
			!ene->is_summoned() &&
			!ene->sc()->data[SC_JOINTBEAT];
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// パリイングを使う。
AI_SKILL_USE_FUNC(LK_PARRYING) {
	if (bot->sc_rest(SC_PARRYING) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// スパイラルピアースを使う。
AI_SKILL_USE_FUNC(LK_SPIRALPIERCE) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) > 0 &&
		!tar_ene->has_status_immune() &&
		!tar_ene->sc()->data[SC_STOP] &&
		tar_ene->size_() != SZ_BIG
	) bot->use_skill_block(kid, klv, tar_ene);
}

// カートレボリューションを使う。
AI_SKILL_USE_FUNC(MC_CARTREVOLUTION) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		!tar_ene->is_hiding()
	) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_splash(tar_ene, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					bot->skill_ratio(kid, klv, ene) > 0 &&
					!ene->is_summoned();
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_block(kid, klv, tar_ene);
	}
}

// 効果的なカートレボリューションを使う。
AI_SKILL_USE_FUNC_T(MC_CARTREVOLUTION, effective) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		!tar_ene->is_hiding()
	) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_splash(tar_ene, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					bot->skill_ratio(kid, klv, ene) > 100 &&
					!ene->is_summoned();
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_block(kid, klv, tar_ene);
	}
}

// ラウドボイスを使う。
AI_SKILL_USE_FUNC(MC_LOUD) {
	if (bot->sc_rest(SC_LOUD) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// メマーナイトを使う。
AI_SKILL_USE_FUNC(MC_MAMMONITE) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) >= 100 &&
		tar_ene->is_great(leader)
	) bot->use_skill_block(kid, klv, tar_ene);
}

// エナジーコートを使う。
AI_SKILL_USE_FUNC(MG_ENERGYCOAT) {
	if (bot->sc_rest(SC_ENERGYCOAT) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// ファイアーボールを使う。
AI_SKILL_USE_FUNC(MG_FIREBALL) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene)) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_splash(tar_ene, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					bot->skill_ratio(kid, klv, ene) > 100 &&
					!ene->is_summoned();
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_block(kid, klv, tar_ene);
	}
}

// ファイアーボルトを使う。
AI_SKILL_USE_FUNC(MG_FIREBOLT) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) > 100 &&
		bot->use_magicpower()
	) bot->use_skill_block(kid, klv, tar_ene);
}

// ダメージ倍率が低くてもファイアーボルトを使う。
AI_SKILL_USE_FUNC_T(MG_FIREBOLT, compromise) {
	static std::vector<e_skill> ATT_MAGS = {
		MG_FIREBOLT,
		MG_COLDBOLT,
		MG_LIGHTNINGBOLT,
		WZ_EARTHSPIKE,
		WZ_WATERBALL,
	};
	block_if* tar_ene = bot->target_enemy();
	int rat = bot->skill_ratio(kid, klv, tar_ene);
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		rat >= 50
	) {
		bool max = true;
		for (e_skill mag : ATT_MAGS) {
			int mag_klv = bot->check_skill(mag);
			int mag_rat = bot->skill_ratio(mag, mag_klv, tar_ene);
			if (mag_klv &&
				(rat < mag_rat ||
					(rat == mag_rat &&
						klv < mag_klv
					)
				)
			) {
				max = false;
				break;
			}
		}
		if (max &&
			bot->use_magicpower()
		) bot->use_skill_block(kid, klv, tar_ene);
	}
}

// ファイアーウォールを使う。
AI_SKILL_USE_FUNC(MG_FIREWALL) {
	static const skill_unit_key_map KEYS = {
		SKILL_UNIT_KEY(kid),
		SKILL_UNIT_KEY(SA_LANDPROTECTOR),
		SKILL_UNIT_KEY(SA_VIOLENTGALE),
		SKILL_UNIT_KEY(WZ_ICEWALL),
	};
	if (bot->check_skill_used_tick(kid, 2500)) {
		pos_t pos;
		block_if* ene = pybot::find_if(ALL_RRANGE(enemies), [this, kid, klv, &pos] (block_if* ene) -> bool {
			if (bot->attack_element_ratio(ene, ELE_FIRE) > 0 &&
				ene->attacked_battlers().empty() &&
				!ene->has_knockback_immune() &&
				!ene->is_magic_immune() &&
				ene->is_short_range_attacker() &&
				!ene->is_undead() &&
				ene->is_walking() &&
				ene->walk_target_battler() &&
				!ene->walk_target_battler()->is_primary() &&
				ene->walk_target_battler()->distance_policy_value() == DPV_AWAY &&
				ene->walkpath_length() >= 3 * 2
			) {
				pos_t mid_pos = ene->walkpath_pos(ene->walkpath_length() / 2);
				if (bot->check_skill_range_xy(kid, klv, mid_pos.x, mid_pos.y) &&
					!skill_unit_exists_xy(ene->bl()->m,	mid_pos.x, mid_pos.y, KEYS)
				) {
					pos = mid_pos;
					return true;
				}
			}
			return false;
		});
		if (pos.advantage != INT_MIN) bot->use_skill_xy(kid, klv, pos.x, pos.y);
	}
}

// フロストダイバーを使う。
AI_SKILL_USE_FUNC(MG_FROSTDIVER) {
	block_if* ene = pybot::find_if(ALL_RRANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			ene->attacked_battlers().empty() &&
			ene->is_freezable() &&
			!ene->is_hiding() &&
			ene->is_short_range_attacker() &&
			ene->target_battler() &&
			!ene->target_battler()->is_primary() &&
			ene->target_battler()->distance_policy_value() == DPV_AWAY;
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// ナパームビートを使う。
AI_SKILL_USE_FUNC(MG_NAPALMBEAT) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) >= 100
	) bot->use_skill_block(kid, klv, tar_ene);
}

// セイフティウォールを使う。
AI_SKILL_USE_FUNC(MG_SAFETYWALL) {
	block_if* pri_bat = battlers.front();
	block_if* tar_ene = pri_bat->target_enemy();
	if (!pri_bat->is_walking() &&
		!pri_bat->sc()->data[SC_SAFETYWALL] &&
		tar_ene &&
		((tar_ene->is_great(leader) &&
				bot->check_skill_used_tick(kid, 2500)
			) || bot->is_no_gemstone()
		) && tar_ene->target_battler() == pri_bat &&
		tar_ene->is_berserk()
	) bot->use_skill_xy(kid, klv, pri_bat->bl()->x, pri_bat->bl()->y);
}

// サイトを使う。
AI_SKILL_USE_FUNC(MG_SIGHT) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies),
		sift_block_splash(bot, kid, klv, [] (block_if* ene) -> bool {
			return ene->is_hiding();
		})
	);
	if (ene) bot->use_skill_self(kid, klv);
}

// ストーンカースを使う。
AI_SKILL_USE_FUNC(MG_STONECURSE) {
	block_if* ene = pybot::find_if(ALL_RRANGE(enemies), [this, kid] (block_if* ene) -> bool {
		return bot->attack_element_ratio(ene, ELE_EARTH) > 0 &&
			ene->attacked_battlers().empty() &&
			ene->check_skill_used_tick(kid, 2500) &&
			!ene->has_status_immune() &&
			!ene->is_hiding() &&
			!ene->is_magic_immune() &&
			!ene->is_paralysis() &&
			ene->is_short_range_attacker() &&
			ene->target_battler() &&
			!ene->target_battler()->is_primary() &&
			ene->target_battler()->distance_policy_value() == DPV_AWAY;
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// サンダーストームを使う。
AI_SKILL_USE_FUNC(MG_THUNDERSTORM) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene)) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_layout(bot, tar_ene, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					bot->skill_ratio(kid, klv, ene) > 100 &&
					!ene->is_summoned() &&
					!skill_unit_exists_block(ene, skill_unit_key_map{SKILL_UNIT_KEY(SA_LANDPROTECTOR)});
			})
		);
		if (cou >= bot->get_skill_monsters() &&
			bot->use_magicpower()
		) bot->use_skill_xy(kid, klv, tar_ene->bl()->x, tar_ene->bl()->y);
	}
}

// 気奪を使う。
AI_SKILL_USE_FUNC(MO_ABSORBSPIRITS) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		!bot->check_sp(3) &&
		tar_ene->check_skill_used_tick(kid, 5 * 1000) &&
		!tar_ene->has_status_immune() &&
		!tar_ene->is_hiding()
	) bot->use_skill_block(kid, klv, tar_ene);
}

// 寸勁を使う。
AI_SKILL_USE_FUNC(MO_BALKYOUNG) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		!tar_ene->is_hiding()
	) {
		block_if* ene = pybot::find_if(ALL_RANGE(enemies),
			sift_block_splash(tar_ene, kid, klv, [this, kid, klv, tar_ene] (block_if* ene) -> bool {
				return ene != tar_ene &&
					bot->skill_ratio(kid, klv, ene) > 0 &&
					!ene->has_status_immune() &&
					ene->is_casting();
			})
		);
		if (ene) bot->use_skill_block(kid, klv, tar_ene);
	}
}

// 白刃取りを使う。
AI_SKILL_USE_FUNC(MO_BLADESTOP) {
	block_if* tar_ene = bot->target_enemy();
	if (!bot->sc()->data[SC_BLADESTOP] &&
		!bot->sc()->data[SC_BLADESTOP_WAIT] &&
		bot->attacked_enemies().size() == 1 &&
		bot->attacked_enemies().front() == tar_ene &&
		!tar_ene->is_boss() &&
		bot->collect_spirits(1)
	) bot->use_skill_self(kid, klv);
}

// 残影を使う。
AI_SKILL_USE_FUNC(MO_BODYRELOCATION) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->distance_policy_value() == DPV_CLOSE &&
		!bot->check_attack_range(tar_ene) &&
		bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_attack(tar_ene) &&
		bot->sc()->data[SC_EXPLOSIONSPIRITS]
	) bot->use_skill_xy(kid, klv, tar_ene->bl()->x, tar_ene->bl()->y);
}

// 気功を使う。
AI_SKILL_USE_FUNC(MO_CALLSPIRITS) {
	if (bot->sd()->spiritball < bot->check_skill(MO_CALLSPIRITS))
		bot->use_skill_self(kid, klv);
}

// コンボに備えて気功を使う。
AI_SKILL_USE_FUNC_T(MO_CALLSPIRITS, ready) {
	int ned = 0;
	if (bot->check_skill(MO_COMBOFINISH)) ned += 1;
	if (bot->check_skill(CH_TIGERFIST)) ned += 1;
	if (bot->check_skill(CH_CHAINCRUSH)) ned += 2;
	if (ned > bot->sd()->spiritball) bot->use_skill_self(kid, klv);
}

// 連打掌を使う。
AI_SKILL_USE_FUNC(MO_CHAINCOMBO) {
	bot->use_skill_self(kid, klv);
}

// 猛龍拳を使う。
AI_SKILL_USE_FUNC(MO_COMBOFINISH) {
	if (bot->collect_spirits(1)) bot->use_skill_self(kid, klv);
}

// 爆裂波動を使う。
AI_SKILL_USE_FUNC(MO_EXPLOSIONSPIRITS) {
	if (bot->sc_rest(SC_EXPLOSIONSPIRITS) <= bot->get_skill_tail(kid) &&
		bot->collect_spirits(5)
	) bot->use_skill_self(kid, klv);
}

// 阿修羅覇凰拳を使う。
AI_SKILL_USE_FUNC(MO_EXTREMITYFIST) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->can_move() &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) >= 100 &&
		tar_ene->is_great(leader) &&
		!tar_ene->sc()->data[SC_FOGWALL] &&
		bot->collect_spirits(5)
	) bot->use_skill_block(kid, klv, tar_ene);
}

// 阿修羅覇凰拳をコンボで使う。
AI_SKILL_USE_FUNC_T(MO_EXTREMITYFIST, combo) {
	block_if* tar_ene = bot->target_enemy();
	if ((bot->sc()->data[SC_BLADESTOP] ||
			bot->sc()->data[SC_COMBO]
		) && bot->check_use_skill(kid, klv, tar_ene) &&
		tar_ene->is_great(leader) &&
		bot->skill_ratio(kid, klv, tar_ene) >= 100 &&
		!tar_ene->sc()->data[SC_FOGWALL]
	) {
		skill_condition req = skill_get_requirement(bot->sd(), kid, klv);
		if (bot->collect_spirits(req.spiritball))
			bot->use_skill_block(kid, klv, tar_ene);
	}
}

// 指弾を使う。
AI_SKILL_USE_FUNC(MO_FINGEROFFENSIVE) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->distance_policy_value() == DPV_AWAY &&
		bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) > 0 &&
		bot->collect_spirits(bot->check_skill(MO_CALLSPIRITS))
	) bot->use_skill_block(kid, klv, tar_ene);
}

// 指弾を使って氷を割る。
AI_SKILL_USE_FUNC_T(MO_FINGEROFFENSIVE, crush) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			bot->skill_ratio(kid, klv, ene) > 0 &&
			!ene->is_summoned() &&
			ene->sc()->data[SC_FREEZE] &&
			skill_unit_exists_block(ene, skill_unit_key_map{SKILL_UNIT_KEY(WZ_STORMGUST, BL_PC, 2)});
	});
	if (ene &&
		bot->collect_spirits(1)
	) bot->use_skill_block(kid, klv, ene);
}

// 指弾を使って挑発する。
AI_SKILL_USE_FUNC_T(MO_FINGEROFFENSIVE, first_attack) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			bot->check_use_taunt_skill(ene) &&
			bot->skill_ratio(kid, klv, ene) > 0 &&
			!ene->is_hiding() &&
			!ene->is_long_weapon_immune();
	});
	if (ene &&
		bot->collect_spirits(1)
	) bot->use_skill_block(kid, klv, ene);
}

// 発勁を使う。
AI_SKILL_USE_FUNC(MO_INVESTIGATE) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) > 0 &&
		tar_ene->def() + tar_ene->def2() >= 100 &&
		tar_ene->def() < 100 &&
		bot->collect_spirits(1)
	) bot->use_skill_block(kid, klv, tar_ene);
}

// 金剛を使う。
AI_SKILL_USE_FUNC(MO_STEELBODY) {
	block_if* tar_ene = bot->target_enemy();
	if (!bot->sc()->data[SC_STEELBODY] &&
		tar_ene->is_great(leader) &&
		tar_ene->target_battler() == bot &&
		bot->collect_spirits(5)
	) bot->use_skill_self(kid, klv);
}

// 龍炎陣を使う。
AI_SKILL_USE_FUNC(NJ_BAKUENRYU) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene)) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_layout(bot, tar_ene, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					bot->skill_ratio(kid, klv, ene) > 100 &&
					!ene->is_summoned() &&
					!skill_unit_exists_block(ene, skill_unit_key_map{SKILL_UNIT_KEY(SA_LANDPROTECTOR)});
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_self(kid, klv);
	}
}

// 影分身を使う。
AI_SKILL_USE_FUNC(NJ_BUNSINJYUTSU) {
	if (bot->sc_rest(SC_BUNSINJYUTSU) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// 氷柱落しを使う。
AI_SKILL_USE_FUNC(NJ_HYOUSYOURAKU) {
	int cou = std::count_if(ALL_RANGE(enemies),
		sift_block_layout(bot, bot, kid, klv, [] (block_if* ene) -> bool {
			return ene->attacked_battlers().empty() &&
				ene->is_freezable() &&
				!ene->is_hiding() &&
				ene->is_short_range_attacker() &&
				ene->target_battler() &&
				!ene->target_battler()->is_primary() &&
				ene->target_battler()->distance_policy_value() == DPV_AWAY;
		})
	);
	if (cou >= bot->get_skill_monsters()) bot->use_skill_self(kid, klv);
}

// 一閃を使う。
AI_SKILL_USE_FUNC(NJ_ISSEN) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_hp(3) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) >= 100 &&
		tar_ene->is_great(leader)
	) bot->use_skill_block(kid, klv, tar_ene);
}

// 火炎陣を使う。
AI_SKILL_USE_FUNC(NJ_KAENSIN) {
	if (bot->is_best_pos() &&
		!skill_unit_exists_block(bot, ELEMENTAL_SKILL_UNIT_KEYS)
	) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_layout(bot, bot, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->skill_ratio(kid, klv, ene) > 100 &&
					!ene->is_hiding() &&
					!ene->is_summoned() &&
					!skill_unit_exists_block(ene, ELEMENTAL_SKILL_UNIT_KEYS);
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_self(kid, klv);
	}
}

// 朔風を使う。
AI_SKILL_USE_FUNC(NJ_KAMAITACHI) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene)) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_path(bot, tar_ene, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					bot->skill_ratio(kid, klv, ene) > 100 &&
					!ene->is_summoned();
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_block(kid, klv, tar_ene);
	}
}

// 霞斬りを使う。
AI_SKILL_USE_FUNC(NJ_KASUMIKIRI) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->distance_policy_value() == DPV_CLOSE &&
		!bot->sc()->data[SC_HIDING] &&
		bot->check_skill_used_tick(NJ_KIRIKAGE, 2500) &&
		bot->check_skill_used_tick(NJ_SHADOWJUMP, 2500) &&
		bot->check_skill_used_tick(TF_HIDING, 2500) &&
		bot->check_attack_range(tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) > 0 &&
		!tar_ene->is_hiding() &&
		!bot->attacked_by_detector()
	) bot->use_skill_block(kid, klv, tar_ene);
}

// 影斬りを使う。
AI_SKILL_USE_FUNC(NJ_KIRIKAGE) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_attack_range(tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) > 0 &&
		bot->check_skill_used_tick(TF_HIDING, 1000)
	) bot->use_skill_block(kid, klv, tar_ene);
}

// ダメージ倍率が低くても紅炎華を使う。
AI_SKILL_USE_FUNC_T(NJ_KOUENKA, compromise) {
	static std::vector<e_skill> ATT_MAGS = {
		NJ_KOUENKA,
		NJ_HUUJIN,
		NJ_HYOUSENSOU,
	};
	block_if* tar_ene = bot->target_enemy();
	int rat = bot->skill_ratio(kid, klv, tar_ene);
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		rat >= 50
	) {
		bool max = true;
		for (e_skill mag : ATT_MAGS) {
			int mag_klv = bot->check_skill(mag);
			int mag_rat = bot->skill_ratio(mag, mag_klv, tar_ene);
			if (mag_klv &&
				(rat < mag_rat ||
					(rat == mag_rat &&
						klv < mag_klv
					)
				)
			) {
				max = false;
				break;
			}
		}
		if (max) bot->use_skill_block(kid, klv, tar_ene);
	}
}

// 念を使う。
AI_SKILL_USE_FUNC(NJ_NEN) {
	if (bot->sc_rest(SC_NEN) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// 雷撃砕を使う。
AI_SKILL_USE_FUNC(NJ_RAIGEKISAI) {
	if (!skill_unit_exists_block(bot, skill_unit_key_map{SKILL_UNIT_KEY(SA_LANDPROTECTOR)})) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_layout(bot, bot, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					bot->skill_ratio(kid, klv, ene) > 100 &&
					!ene->is_summoned();
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_self(kid, klv);
	}
}

// 影跳びを使う。
AI_SKILL_USE_FUNC(NJ_SHADOWJUMP) {
	if (bot->battle_mode() == BM_NONE ||
		bot->check_skill_used_tick(TF_HIDING, 1000)
	) bot->use_skill_xy(kid, klv, leader->center().x, leader->center().y);
}

// 水遁を使う。
AI_SKILL_USE_FUNC(NJ_SUITON) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->is_best_pos() &&
		bot->check_skill_range_block(kid, klv, tar_ene)
	) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_layout(bot, tar_ene, kid, klv, [] (block_if* ene) -> bool {
				return !ene->has_status_immune() &&
					!ene->is_hiding() &&
					!ene->is_magic_immune() &&
					!ene->sc()->data[SC_SUITON] &&
					!skill_unit_exists_block(ene, ELEMENTAL_SKILL_UNIT_KEYS);
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_xy(kid, klv, tar_ene->bl()->x, tar_ene->bl()->y);
	}
}

// 畳返しを使う。
AI_SKILL_USE_FUNC(NJ_TATAMIGAESHI) {
	if (!skill_unit_exists_block(bot, skill_unit_key_map{SKILL_UNIT_KEY(SA_LANDPROTECTOR)})) {
		block_if* ene = pybot::find_if(ALL_RANGE(enemies),
			sift_block_layout(bot, bot, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->skill_ratio(kid, klv, ene) > 0 &&
					!ene->has_knockback_immune() &&
					ene->is_casting() &&
					ene->ud()->skill_id == NC_SELFDESTRUCTION &&
					!skill_unit_exists_block(ene, skill_unit_key_map{SKILL_UNIT_KEY(SA_LANDPROTECTOR)});
			})
		);
		if (ene) bot->use_skill_self(kid, klv);
	}
}

// 空蝉を使う。
AI_SKILL_USE_FUNC(NJ_UTSUSEMI) {
	if (!bot->sc()->data[SC_BUNSINJYUTSU] &&
		bot->sc_rest(SC_UTSUSEMI) <= bot->get_skill_tail(kid)
	) bot->use_skill_self(kid, klv);
}

// 応急手当を使う。
AI_SKILL_USE_FUNC(NV_FIRSTAID) {
	if (!bot->check_hp(3)) bot->use_skill_self(kid, klv);
}

// 死んだふり状態になる。
AI_SKILL_USE_FUNC_T(NV_TRICKDEAD, activate) {
	if (!bot->check_hp(1) &&
		!bot->sc()->data[SC_TRICKDEAD]
	) bot->use_skill_self(kid, klv);
}

// 死んだふり状態を解除する。
AI_SKILL_USE_FUNC_T(NV_TRICKDEAD, deactivate) {
	if ((bot->battle_mode() == BM_NONE ||
			bot->check_hp(3)
		) && bot->sc()->data[SC_TRICKDEAD]
	) bot->use_skill_self(kid, klv);
}

// ゴスペル状態になる。
AI_SKILL_USE_FUNC_T(PA_GOSPEL, activate) {
	if (!bot->sc()->data[SC_GOSPEL] &&
		bot->check_hp(3) &&
		bot->is_best_pos() &&
		bot->target_enemy()->is_great(leader)
	) bot->use_skill_self(kid, klv);
}

// ゴスペル状態を解除する。
AI_SKILL_USE_FUNC_T(PA_GOSPEL, deactivate) {
	if (bot->sc()->data[SC_GOSPEL] &&
		(bot->battle_mode() == BM_NONE ||
			!bot->is_best_pos() ||
			!bot->target_enemy()->is_great(leader)
		) 
	) bot->use_skill_self(kid, klv);
}

// サクリファイスを使う。
AI_SKILL_USE_FUNC(PA_SACRIFICE) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->normal_attack_policy_value() == NAPV_CONTINUOUS &&
		bot->check_hp(3) &&
		bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) >= 100 &&
		tar_ene->is_great(leader) &&
		!tar_ene->is_hiding()
	) bot->use_skill_self(kid, klv);
}

// ダブルキャスティングを使う。
AI_SKILL_USE_FUNC(PF_DOUBLECASTING) {
	if (bot->sc_rest(SC_DOUBLECAST) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// ウォールオブフォグを使う。
AI_SKILL_USE_FUNC(PF_FOGWALL) {
	if (bot->distance_policy_value() == DPV_AWAY &&
		bot->check_skill_used_tick(kid, 20 * 1000 / 3) &&
		bot->is_best_pos() &&
		!bot->sc()->data[SC_FOGWALL] &&
		!bot->sc()->data[SC_VIOLENTGALE] &&
		!bot->sc()->data[SC_VOLCANO]
	) {
		block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this] (block_if* ene) -> bool {
			return ene->is_casting() &&
				mob_skill_is_long(e_skill(ene->ud()->skill_id), ene->ud()->skill_lv);
		});
		if (ene) bot->use_skill_xy(kid, klv, bot->bl()->x, bot->bl()->y);
	}
}

// 生命力変換を使う。
AI_SKILL_USE_FUNC(PF_HPCONVERSION) {
	if (bot->check_hp(2) &&
		!check_quad_ratio(bot->sp(), bot->max_sp(), 2)
	) bot->use_skill_self(kid, klv);
}

// メモライズを使う。
AI_SKILL_USE_FUNC(PF_MEMORIZE) {
	if (bot->sc_rest(SC_MEMORIZE) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// ソウルチェンジを使う。
AI_SKILL_USE_FUNC(PF_SOULCHANGE) {
	if (check_quad_ratio(bot->sp(), bot->max_sp(), 2) &&
		(bot->party_id() ||
			bot->guild_id()
		)
	) {
		block_if* bat = pybot::find_if(ALL_RRANGE(battlers), [this, kid] (block_if* bat) -> bool {
			return bat != bot &&
				((bot->party_id() &&
						bat->party_id() == bot->party_id()
					) || (bot->guild_id() &&
						bat->guild_id() == bot->guild_id()
					)
				) && !bat->is_dead() &&
				!bat->is_hiding() &&
				!bat->is_invincible() &&
				!bat->is_magic_immune() &&
				!bat->reject_skills()->find(kid) &&
				!check_quad_ratio(bat->sp(), bat->max_sp(), 1);
		});
		if (bat) bot->use_skill_block(kid, klv, bat);
	}
}

// スパイダーウェブを使う。
AI_SKILL_USE_FUNC(PF_SPIDERWEB) {
	block_if* ene = pybot::find_if(ALL_RRANGE(enemies), [this] (block_if* ene) -> bool {
		return ene != bot->target_enemy() &&
			!ene->has_knockback_immune() &&
			ene->is_great(leader) &&
			!ene->is_hiding() &&
			!ene->is_paralysis() &&
			!ene->sc()->data[SC_SPIDERWEB] &&
			!skill_unit_exists_block(ene, skill_unit_key_map{SKILL_UNIT_KEY(SA_LANDPROTECTOR)});
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// アスペルシオを使う。
AI_SKILL_USE_FUNC(PR_ASPERSIO) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [this, kid, klv] (block_if* mem) -> bool {
		block_if* tar_ene = mem->target_enemy();
		return !mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->reject_skills()->find(kid) &&
			mem->sc_rest(SC_ASPERSIO) <= bot->get_skill_tail(kid) &&
			pc_checkequip(mem->sd(), EQP_WEAPON) >= 0 &&
			tar_ene &&
			mem->attack_element_ratio(tar_ene, ELE_HOLY) >= 150 &&
			mem->attack_element_ratio(tar_ene, ELE_HOLY) - mem->weapon_attack_element_ratio(tar_ene) >= 50;
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// 聖体降福を使う。
AI_SKILL_USE_FUNC(PR_BENEDICTIO) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [this, kid] (block_if* mem) -> bool {
		return !mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->is_magic_immune() &&
			!mem->reject_skills()->find(kid) &&
			mem->sc_rest(SC_BENEDICTIO) <= bot->get_skill_tail(kid);
	});
	if (mem) bot->use_skill_xy(kid, klv, mem->bl()->x, mem->bl()->y);
}

// グロリアを使う。
AI_SKILL_USE_FUNC(PR_GLORIA) {
	if (!bot->is_magic_immune() &&
		bot->sc_rest(SC_GLORIA) <= bot->get_skill_tail(kid)
	) bot->use_skill_self(kid, klv);
}

// イムポシティオマヌスを使う。
AI_SKILL_USE_FUNC(PR_IMPOSITIO) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [this, kid] (block_if* mem) -> bool {
		return !mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->is_magic_immune() &&
			!mem->reject_skills()->find(kid) &&
			mem->sc_rest(SC_IMPOSITIO) <= bot->get_skill_tail(kid);
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// キリエエレイソンを使う。
AI_SKILL_USE_FUNC(PR_KYRIE) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [this, kid] (block_if* mem) -> bool {
		return !mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->is_magic_immune() &&
			!mem->reject_skills()->find(kid) &&
			!mem->sc()->data[SC_ASSUMPTIO] &&
			mem->sc_rest(SC_KYRIE) <= bot->get_skill_tail(kid);
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// レックスエーテルナを使う。
AI_SKILL_USE_FUNC(PR_LEXAETERNA) {
	if (bot->normal_attack_policy_value() == NAPV_SINGLE) {
		block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
			return bot->check_attack(ene) &&
				!ene->is_hiding() &&
				!ene->is_magic_immune() &&
				!ene->is_summoned() &&
				!ene->sc()->data[SC_AETERNA] &&
				!ene->sc()->data[SC_FREEZE] &&
				ene->sc()->opt1 != OPT1_STONE;
		});
		if (ene) bot->use_skill_block(kid, klv, ene);
	}
}

// レックスディビーナを使う。
AI_SKILL_USE_FUNC(PR_LEXDIVINA) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid] (block_if* ene) -> bool {
		return bot->check_attack(ene) &&
			ene->check_skill_used_tick(kid, 2500) &&
			!ene->has_status_immune() &&
			ene->has_usefull_skill() &&
			!ene->is_hiding() &&
			!ene->is_magic_immune() &&
			!ene->sc()->data[SC_SILENCE];
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// マグニフィカートを使う。
AI_SKILL_USE_FUNC(PR_MAGNIFICAT) {
	if (!bot->is_magic_immune() &&
		bot->sc_rest(SC_MAGNIFICAT) <= bot->get_skill_tail(kid)
	) bot->use_skill_self(kid, klv);
}

// マグヌスエクソシズムを使う。
AI_SKILL_USE_FUNC(PR_MAGNUS) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene)) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_layout(bot, tar_ene, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					!ene->is_summoned() &&
					(ene->is_undead() ||
						ene->race() == RC_DEMON
					) && !skill_unit_exists_block(ene, skill_unit_key_map{
						SKILL_UNIT_KEY(PR_MAGNUS),
						SKILL_UNIT_KEY(SA_LANDPROTECTOR)
					});
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_xy(kid, klv, tar_ene->bl()->x, tar_ene->bl()->y);
	}
}

// レディムプティオを使う。
AI_SKILL_USE_FUNC(PR_REDEMPTIO) {
	if (bot->party_id()) {
		int cou = std::count_if(ALL_RANGE(members), [this] (block_if* mem) -> bool {
			return mem->is_dead() &&
				mem->party_id() == bot->party_id();
		});
		if (cou >= 3) bot->use_skill_self(kid, klv);
	}
}

// サンクチュアリを使う。
AI_SKILL_USE_FUNC(PR_SANCTUARY) {
	static const skill_unit_key_map KEYS =
		{SKILL_UNIT_KEY(PR_SANCTUARY), SKILL_UNIT_KEY(SA_LANDPROTECTOR)};
	if (bot->is_best_pos() &&
		!skill_unit_exists_block(bot, KEYS)
	) {
		int cou = std::count_if(ALL_RANGE(members), [this, kid] (block_if* mem) -> bool {
			return (mem->distance_policy_value() == DPV_AWAY ||
					mem->is_long_range_attacker()
				) && !mem->check_hp(3) &&
				!mem->is_dead() &&
				!mem->is_invincible();
		});
		if (cou >= 3) bot->use_skill_xy(kid, klv, bot->bl()->x, bot->bl()->y);
	}
}

// スローポイズンを使う。
AI_SKILL_USE_FUNC(PR_SLOWPOISON) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [kid] (block_if* mem) -> bool {
		return !mem->is_hiding() &&
			!mem->is_magic_immune() &&
			!mem->reject_skills()->find(kid) &&
			!mem->sc()->data[SC_SLOWPOISON] &&
			(mem->sc()->data[SC_POISON] ||
				mem->sc()->data[SC_DPOISON]
			);
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// リカバリーを使う。
AI_SKILL_USE_FUNC(PR_STRECOVERY) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [kid] (block_if* mem) -> bool {
		return !mem->is_hiding() &&
			!mem->reject_skills()->find(kid) &&
			(mem->sc()->data[SC_FREEZE] ||
				mem->sc()->data[SC_SLEEP] ||
				mem->sc()->data[SC_STONE] ||
				mem->sc()->data[SC_STUN]
			);
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// リカバリーを使ってアンデッドモンスターを暗闇状態にする。
AI_SKILL_USE_FUNC_T(PR_STRECOVERY, blind) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			ene->check_skill_used_tick(kid, 2500) &&
			!ene->has_status_immune() &&
			!ene->is_hiding() &&
			ene->is_undead() &&
			!ene->sc()->data[SC_BLIND];
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// サフラギウムを使う。
AI_SKILL_USE_FUNC(PR_SUFFRAGIUM) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [this, kid] (block_if* mem) -> bool {
		return mem != bot &&
			(!mem->check_skill(HW_MAGICPOWER) ||
				(mem->is_casting() &&
					mem->ud()->skill_id == HW_MAGICPOWER
				) || (!mem->is_casting() &&
					mem->magicpower_is_active()
				)
			) && !mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->is_magic_immune() &&
			!mem->reject_skills()->find(kid) &&
			mem->sc_rest(SC_SUFFRAGIUM) <= bot->get_skill_tail(kid);
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// ターンアンデッドを使う。
AI_SKILL_USE_FUNC(PR_TURNUNDEAD) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			bot->check_use_skill(kid, klv, ene) &&
			ene->check_skill_used_tick(kid, 2500) &&
			!ene->has_status_immune() &&
			!ene->is_hiding() &&
			!ene->is_summoned() &&
			ene->is_undead();
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// バックスタブを使う。
AI_SKILL_USE_FUNC(RG_BACKSTAP) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) > 0
	) {
		int sel_dir = unit_getdir(bot->bl());
		int tar_dir = map_calc_dir(bot->bl(), tar_ene->bl()->x, tar_ene->bl()->y);
		if (distance_bl(bot->bl(), tar_ene->bl()) &&
			map_check_dir(sel_dir, tar_dir)
		) bot->use_skill_block(kid, klv, tar_ene);
	}
}

// スティールコインを使う。
AI_SKILL_USE_FUNC(RG_STEALCOIN) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			ene->check_skill_used_tick(kid, 2500) &&
			!ene->has_status_immune() &&
			!ene->is_hiding() &&
			!ene->is_summoned() &&
			!ene->md()->state.steal_coin_flag &&
			ene->race2() != RC2_TREASURE &&
			ene->md()->special_state.ai != AI_SPHERE &&
			!ene->sc()->data[SC_FREEZE] &&
			!ene->sc()->data[SC_STONE];
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// ストリップシールドを使う。
AI_SKILL_USE_FUNC(RG_STRIPSHIELD) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		tar_ene->check_skill_used_tick(ST_FULLSTRIP, 2500) &&
		tar_ene->check_skill_used_tick(kid, 2500) &&
		!tar_ene->is_hiding() &&
		!tar_ene->sc()->data[SC_STRIPSHIELD]
	) bot->use_skill_block(kid, klv, tar_ene);
}

// ストリップウェポンを使う。
AI_SKILL_USE_FUNC(RG_STRIPWEAPON) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			ene->check_skill_used_tick(ST_FULLSTRIP, 2500) &&
			ene->check_skill_used_tick(kid, 2500) &&
			!ene->is_hiding() &&
			!ene->sc()->data[SC_STRIPWEAPON];
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// オートスペルを使う。
AI_SKILL_USE_FUNC(SA_AUTOSPELL) {
	if (bot->normal_attack_policy_value() == NAPV_CONTINUOUS) {
		block_if* tar_ene = bot->target_enemy();
		e_skill gre_spe_id = e_skill(0);
		int gre_rat;
		auto che_spe = [this, klv, tar_ene, &gre_spe_id, &gre_rat] (e_skill spe_id, int min_lv) {
			if (klv >= min_lv &&
				bot->check_skill(spe_id) &&
				(!bot->skill_auto_spell()->get() ||
					spe_id == bot->skill_auto_spell()->get()
				)
			) {
				int rat = bot->skill_ratio(spe_id, 1, tar_ene);
				if (!gre_spe_id ||
					rat > gre_rat
				) {
					gre_spe_id = spe_id;
					gre_rat = rat;
				}
			}
		};
		che_spe(MG_FIREBOLT, 2);
		che_spe(MG_LIGHTNINGBOLT, 2);
		che_spe(MG_COLDBOLT, 2);
		che_spe(MG_SOULSTRIKE, 5);
		che_spe(MG_FIREBALL, 8);
		che_spe(MG_FROSTDIVER, 10);
		che_spe(MG_NAPALMBEAT, 1);
		if (gre_spe_id) {
			status_change_entry* as_sce = bot->sc()->data[SC_AUTOSPELL];
			if (bot->sc_rest(SC_AUTOSPELL) <= bot->get_skill_tail(kid) ||
				(as_sce->val2 != gre_spe_id &&
					bot->skill_ratio(e_skill(as_sce->val2), 1, tar_ene) <= bot->get_skill_low_rate()
				)
			) bot->use_skill_self(kid, klv, true, [gre_spe_id] (ai_t* ai, void* fun) {
				skill_autospell(ai->bot->sd(), gre_spe_id);
			});
		}
	}
}

// デリュージを使う。
AI_SKILL_USE_FUNC(SA_DELUGE) {
	block_if* tar_ene = bot->target_enemy();
	if (!bot->sc()->data[SC_DELUGE] &&
		bot->attack_element_ratio(tar_ene, ELE_WATER) > 100 &&
		!skill_unit_exists_block(bot, skill_unit_key_map{SKILL_UNIT_KEY(SA_LANDPROTECTOR)})
	) bot->use_skill_xy(kid, klv, bot->bl()->x, bot->bl()->y);
}

// ディスペルを使う。
AI_SKILL_USE_FUNC(SA_DISPELL) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			ene->check_sc_types(GREAT_SC_TYPES) &&
			!ene->is_magic_immune() &&
			ene->is_boss() &&
			!ene->is_hiding();
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// ディスペルを使って麻痺、バーサークを治癒する。
AI_SKILL_USE_FUNC_T(SA_DISPELL, cure) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [this, kid] (block_if* mem) -> bool {
		return (mem == bot ||
				(bot->party_id() &&
					mem->party_id() == bot->party_id()
				) || (bot->guild_id() &&
					mem->guild_id() == bot->guild_id()
				)
			) && ((mem->check_skill(PR_STRECOVERY) &&
					mem->is_paralysis()
				) || (mem->sc()->data[SC_BERSERK] &&
					!mem->check_hp(2)
				)
			) && !mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->is_magic_immune() &&
			!mem->reject_skills()->find(kid);
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// フロストウェポンを使う。
AI_SKILL_USE_FUNC(SA_FROSTWEAPON) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [kid, klv] (block_if* mem) -> bool {
		block_if* tar_ene = mem->target_enemy();
		return !mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->reject_skills()->find(kid) &&
			!mem->sc()->data[SC_WATERWEAPON] &&
			pc_checkequip(mem->sd(), EQP_WEAPON) >= 0 &&
			tar_ene &&
			mem->attack_element_ratio(tar_ene, ELE_WATER) >= 150 &&
			mem->attack_element_ratio(tar_ene, ELE_WATER) - mem->weapon_attack_element_ratio(tar_ene) >= 50;
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// フレイムランチャーを使う。
AI_SKILL_USE_FUNC(SA_FLAMELAUNCHER) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [kid, klv] (block_if* mem) -> bool {
		block_if* tar_ene = mem->target_enemy();
		return !mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->reject_skills()->find(kid) &&
			!mem->sc()->data[SC_FIREWEAPON] &&
			pc_checkequip(mem->sd(), EQP_WEAPON) >= 0 &&
			tar_ene &&
			mem->attack_element_ratio(tar_ene, ELE_FIRE) >= 150 &&
			mem->attack_element_ratio(tar_ene, ELE_FIRE) - mem->weapon_attack_element_ratio(tar_ene) >= 50;
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// ランドプロテクターを使う。
AI_SKILL_USE_FUNC(SA_LANDPROTECTOR) {
	static const skill_unit_key_map KEYS = {SKILL_UNIT_KEY(SA_LANDPROTECTOR)};
	block_if* tar_ene = bot->target_enemy();
	if (tar_ene->is_great(leader) &&
		bot->is_best_pos() &&
		bot->check_attack(tar_ene) &&
		!skill_unit_exists_block(bot, KEYS)
	) {
		block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this] (block_if* ene) -> bool {
			return ene->has_layout_skill() &&
				ene->is_great(leader);
		});
		if (ene) bot->use_skill_xy(kid, klv, bot->bl()->x, bot->bl()->y);
	}
}

// ライトニングローダーを使う。
AI_SKILL_USE_FUNC(SA_LIGHTNINGLOADER) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [kid, klv] (block_if* mem) -> bool {
		block_if* tar_ene = mem->target_enemy();
		return !mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->reject_skills()->find(kid) &&
			!mem->sc()->data[SC_WINDWEAPON] &&
			pc_checkequip(mem->sd(), EQP_WEAPON) >= 0 &&
			tar_ene &&
			mem->attack_element_ratio(tar_ene, ELE_WIND) >= 150 &&
			mem->attack_element_ratio(tar_ene, ELE_WIND) - mem->weapon_attack_element_ratio(tar_ene) >= 50;
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// マジックロッドを使う。
AI_SKILL_USE_FUNC(SA_MAGICROD) {
	if (!bot->sc()->data[SC_MAGICROD]) {
		block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
			return !bot->is_magic_immune() &&
				ene->skill_target_battler() == bot;
		});
		if (ene) bot->use_skill_self(kid, klv);
	}
}

// サイズミックウェポンを使う。
AI_SKILL_USE_FUNC(SA_SEISMICWEAPON) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [kid, klv] (block_if* mem) -> bool {
		block_if* tar_ene = mem->target_enemy();
		return !mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->reject_skills()->find(kid) &&
			!mem->sc()->data[SC_EARTHWEAPON] &&
			pc_checkequip(mem->sd(), EQP_WEAPON) >= 0 &&
			tar_ene &&
			mem->attack_element_ratio(tar_ene, ELE_EARTH) >= 150 &&
			mem->attack_element_ratio(tar_ene, ELE_EARTH) - mem->weapon_attack_element_ratio(tar_ene) >= 50;
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// スペルブレイカーを使う。
AI_SKILL_USE_FUNC(SA_SPELLBREAKER) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [] (block_if* ene) -> bool {
		return ene->is_casting();
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// バイオレントゲイルを使う。
AI_SKILL_USE_FUNC(SA_VIOLENTGALE) {
	block_if* tar_ene = bot->target_enemy();
	if (!bot->sc()->data[SC_VIOLENTGALE] &&
		bot->attack_element_ratio(tar_ene, ELE_WIND) > 100 &&
		!skill_unit_exists_block(bot, skill_unit_key_map{SKILL_UNIT_KEY(SA_LANDPROTECTOR)})
	) bot->use_skill_xy(kid, klv, bot->bl()->x, bot->bl()->y);
}

// ボルケーノを使う。
AI_SKILL_USE_FUNC(SA_VOLCANO) {
	block_if* tar_ene = bot->target_enemy();
	if (!bot->sc()->data[SC_VOLCANO] &&
		bot->attack_element_ratio(tar_ene, ELE_FIRE) > 100 &&
		!skill_unit_exists_block(bot, skill_unit_key_map{SKILL_UNIT_KEY(SA_LANDPROTECTOR)})
	) bot->use_skill_xy(kid, klv, bot->bl()->x, bot->bl()->y);
}

// 太陽と月と星の融合を使う。
AI_SKILL_USE_FUNC(SG_FUSION) {
	if (bot->sc_rest(SC_FUSION) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// 月の安楽を使う。
AI_SKILL_USE_FUNC(SG_MOON_COMFORT) {
	if (bot->sc_rest(SC_MOON_COMFORT) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// 星の安楽を使う。
AI_SKILL_USE_FUNC(SG_STAR_COMFORT) {
	if (bot->sc_rest(SC_STAR_COMFORT) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// 太陽の安楽を使う。
AI_SKILL_USE_FUNC(SG_SUN_COMFORT) {
	if (bot->sc_rest(SC_SUN_COMFORT) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// 太陽の温もりを使う。
AI_SKILL_USE_FUNC(SG_SUN_WARM) {
	block_if* tar_ene = bot->target_enemy();
	if (!bot->sc()->data[SC_FUSION] &&
		bot->sc_rest(SC_WARM) <= bot->get_skill_tail(kid) &&
		tar_ene->has_knockback_immune()
	) bot->use_skill_self(kid, klv);
}

// カアヒを使う。
AI_SKILL_USE_FUNC(SL_KAAHI) {
	block_if* mem = pybot::find_if(ALL_RANGE(members), [this, kid] (block_if* mem) -> bool {
		return bot->can_ka(mem) &&
			!mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->reject_skills()->find(kid) &&
			mem->sc_rest(SC_KAAHI) <= bot->get_skill_tail(kid);
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// カイトを使う。
AI_SKILL_USE_FUNC(SL_KAITE) {
	block_if* mem = pybot::find_if(ALL_RANGE(members), [this, kid] (block_if* mem) -> bool {
		return bot->can_ka(mem) &&
			!mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->reject_skills()->find(kid) &&
			!mem->sc()->data[SC_ASSUMPTIO] &&
			mem->sc_rest(SC_KAITE) <= bot->get_skill_tail(kid);
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// カイゼルを使う。
AI_SKILL_USE_FUNC(SL_KAIZEL) {
	block_if* mem = pybot::find_if(ALL_RANGE(members), [this, kid] (block_if* mem) -> bool {
		return bot->can_ka(mem) &&
			!mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->reject_skills()->find(kid) &&
			mem->sc_rest(SC_KAIZEL) <= bot->get_skill_tail(kid);
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// カウプを使う。
AI_SKILL_USE_FUNC(SL_KAUPE) {
	block_if* mem = pybot::find_if(ALL_RANGE(members), [this, kid] (block_if* mem) -> bool {
		return bot->can_ka(mem) &&
			!mem->is_dead() &&
			!mem->is_hiding() &&
			!mem->reject_skills()->find(kid) &&
			!mem->sc()->data[SC_KAUPE];
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// エスカを使う。
AI_SKILL_USE_FUNC(SL_SKA) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [] (block_if* ene) -> bool {
		return !ene->is_hiding() &&
			ene->md()->mob_id != MOBID_EMPERIUM &&
			!ene->sc()->data[SC_SKA];
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// エスクを使う。
AI_SKILL_USE_FUNC(SL_SKE) {
	block_if* mob = pybot::find_if(ALL_RANGE(ally_mobs), [] (block_if* mob) -> bool {
		return !mob->sc()->data[SC_SKE];
	});
	if (mob) bot->use_skill_block(kid, klv, mob);
}

// エスマを使う。
AI_SKILL_USE_FUNC(SL_SMA) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) > 0 &&
		bot->sc()->data[SC_SMA]
	) bot->use_skill_block(kid, klv, tar_ene);
}

// エスティンを使う。
AI_SKILL_USE_FUNC(SL_STIN) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		tar_ene->size_() == SZ_SMALL
	) bot->use_skill_block(kid, klv, tar_ene);
}

// エストンを使う。
AI_SKILL_USE_FUNC(SL_STUN) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene)
	) bot->use_skill_block(kid, klv, tar_ene);
}

// エスウを使う。
AI_SKILL_USE_FUNC(SL_SWOO) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [] (block_if* ene) -> bool {
		return !ene->has_status_immune() &&
			!ene->is_hiding() &&
			ene->is_walking() &&
			!ene->sc()->data[SC_SWOO];
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// オートバーサーク状態になる。
AI_SKILL_USE_FUNC(SM_AUTOBERSERK) {
	if (!bot->sc()->data[SC_AUTOBERSERK]) bot->use_skill_self(kid, klv);
}

// バッシュを使う。
AI_SKILL_USE_FUNC(SM_BASH) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) > 0
	) bot->use_skill_block(kid, klv, tar_ene);
}

// 急所攻撃を使って詠唱を邪魔する。
AI_SKILL_USE_FUNC_T(SM_BASH, disturb) {
	if (bot->check_skill(SM_FATALBLOW)) {
		block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
			return bot->check_skill_range_block(kid, klv, ene) &&
				bot->skill_ratio(kid, klv, ene) > 0 &&
				!ene->has_status_immune() &&
				ene->is_casting();
		});
		if (ene) bot->use_skill_block(kid, klv, ene);
	}
}

// 効果的なバッシュを使う。
AI_SKILL_USE_FUNC_T(SM_BASH, effective) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->skill_ratio(kid, klv, tar_ene) > 100
	) bot->use_skill_block(kid, klv, tar_ene);
}

// インデュアを使う。
AI_SKILL_USE_FUNC(SM_ENDURE) {
	if (bot->sc_rest(SC_ENDURE) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// マグナムブレイクを使う。
AI_SKILL_USE_FUNC(SM_MAGNUM) {
	int cou = std::count_if(ALL_RANGE(enemies),
		sift_block_splash(bot, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
			return bot->check_use_skill(kid, klv, ene) &&
				bot->skill_ratio(kid, klv, ene) > 0 &&
				!ene->is_summoned();
		})
	);
	if (cou >= bot->get_skill_monsters()) bot->use_skill_self(kid, klv);
}

// 効果的なマグナムブレイクを使う。
AI_SKILL_USE_FUNC_T(SM_MAGNUM, effective) {
	int cou = std::count_if(ALL_RANGE(enemies),
		sift_block_splash(bot, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
			return bot->check_use_skill(kid, klv, ene) &&
				bot->skill_ratio(kid, klv, ene) > 100 &&
				!ene->is_summoned();
		})
	);
	if (cou >= bot->get_skill_monsters()) bot->use_skill_self(kid, klv);
}

// マグナムブレイクを使って強化する。
AI_SKILL_USE_FUNC_T(SM_MAGNUM, enchant) {
	if (bot->check_skill_range_block(kid, klv, bot->target_enemy()) &&
		!bot->sc()->data[SC_WATK_ELEMENT]
	) bot->use_skill_self(kid, klv);
}

// プロボックを使ってDefを下げる。
AI_SKILL_USE_FUNC(SM_PROVOKE) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_attack(tar_ene) &&
		tar_ene->can_be_provoke() &&
		tar_ene->check_skill_used_tick(kid, 2500) &&
		tar_ene->def() >= 50 &&
		tar_ene->def() < 100 &&
		(!tar_ene->sc()->data[SC_PROVOKE] ||
			tar_ene->sc()->data[SC_PROVOKE]->val1 < klv
		)
	) bot->use_skill_block(kid, klv, tar_ene);
}

// プロボックを使って挑発する。
AI_SKILL_USE_FUNC_T(SM_PROVOKE, first_attack) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			bot->check_use_taunt_skill(ene) &&
			ene->can_be_provoke() &&
			ene->check_skill_used_tick(kid, 2500);
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// トゥルーサイトを使う。
AI_SKILL_USE_FUNC(SN_SIGHT) {
	if (bot->sc_rest(SC_TRUESIGHT) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// シャープシューティングを使う。
AI_SKILL_USE_FUNC(SN_SHARPSHOOTING) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene)) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_path(bot, tar_ene, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					bot->skill_ratio(kid, klv, ene) >= 100 &&
					!ene->is_summoned();
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_block(kid, klv, tar_ene);
	}
}

// ウインドウォークを使う。
AI_SKILL_USE_FUNC(SN_WINDWALK) {
	if (!bot->is_magic_immune() &&
		!bot->sc()->data[SC_DECREASEAGI] &&
		!bot->sc()->data[SC_QUAGMIRE] &&
		bot->sc_rest(SC_WINDWALK) <= bot->get_skill_tail(kid)
	) bot->use_skill_self(kid, klv);
}

// フルストリップを使う。
AI_SKILL_USE_FUNC(ST_FULLSTRIP) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			ene->check_skill_used_tick(ST_FULLSTRIP, 2500) &&
			!ene->is_hiding() &&
			(!ene->sc()->data[SC_STRIPSHIELD] ||
				!ene->sc()->data[SC_STRIPWEAPON]
			);

	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// プリザーブを使う。
AI_SKILL_USE_FUNC(ST_PRESERVE) {
	if (bot->sc_rest(SC_PRESERVE) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// リジェクトソードを使う。
AI_SKILL_USE_FUNC(ST_REJECTSWORD) {
	if (bot->sc_rest(SC_REJECTSWORD) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// 解毒を使う。
AI_SKILL_USE_FUNC(TF_DETOXIFY) {
	block_if* mem = pybot::find_if(ALL_RRANGE(members), [kid] (block_if* mem) -> bool {
		return !mem->is_hiding() &&
			!mem->reject_skills()->find(kid) &&
			(mem->sc()->data[SC_POISON] ||
				mem->sc()->data[SC_DPOISON]
			) && !skill_unit_exists_block(mem, skill_unit_key_map{SKILL_UNIT_KEY(AS_VENOMDUST, BL_MOB)});
	});
	if (mem) bot->use_skill_block(kid, klv, mem);
}

// ハイディング状態になる。
AI_SKILL_USE_FUNC_T(TF_HIDING, activate) {
	if (!bot->sc()->data[SC_HIDING] &&
		bot->check_skill_used_tick(kid, 2500) &&
		bot->attacked_short_range_attacker() &&
		!bot->attacked_by_detector()
	) bot->use_skill_self(kid, klv);
}

// ハイディング状態を解除する。
AI_SKILL_USE_FUNC_T(TF_HIDING, deactivate) {
	if (bot->sc()->data[SC_HIDING] &&
		(bot->battle_mode() == BM_NONE ||
			bot->check_skill_used_tick(kid, 1000)
		)
	) bot->use_skill_self(kid, klv);
}

// 石拾いを使う。
AI_SKILL_USE_FUNC(TF_PICKSTONE) {
	int sto_amo = 0;
	int sto_ind = bot->find_inventory(item_key(ITEMID_STONE));
	if (sto_ind != INT_MIN) sto_amo = bot->sd()->inventory.u.items_inventory[sto_ind].amount;
	if (sto_amo < 9) bot->use_skill_self(kid, klv);
}

// インベナムを使う。
AI_SKILL_USE_FUNC(TF_POISON) {
	block_if* ene = pybot::find_if(ALL_RRANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			bot->skill_ratio(kid, klv, ene) > 0 &&
			ene->check_skill_used_tick(kid, 2500) &&
			!ene->has_status_immune() &&
			!ene->is_hiding() &&
			!ene->is_summoned() &&
			!ene->sc()->data[SC_DPOISON] &&
			!ene->sc()->data[SC_POISON];
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// 砂まきを使う。
AI_SKILL_USE_FUNC(TF_SPRINKLESAND) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			bot->skill_ratio(kid, klv, ene) > 0 &&
			ene->check_skill_used_tick(kid, 2500) &&
			!ene->has_status_immune() &&
			!ene->is_hiding() &&
			!ene->is_summoned() &&
			!ene->sc()->data[SC_BLIND];
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// スティールを使う。
AI_SKILL_USE_FUNC(TF_STEAL) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			ene->check_skill_used_tick(kid, 2500) &&
			!ene->is_hiding() &&
			!ene->is_summoned() &&
			ene->md()->state.steal_flag != UCHAR_MAX &&
			ene->race2() != RC2_TREASURE &&
			ene->md()->special_state.ai != AI_SPHERE;
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// 石投げを使って氷を割る。
AI_SKILL_USE_FUNC_T(TF_THROWSTONE, crush) {
	static const auto KEYS = skill_unit_key_map{SKILL_UNIT_KEY(WZ_STORMGUST, BL_PC, 2)};
	bool sel_sg = skill_unit_exists_block(bot, KEYS);
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv, sel_sg] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			bot->skill_ratio(kid, klv, ene) > 0 &&
			!ene->is_summoned() &&
			ene->sc()->data[SC_FREEZE] &&
			(sel_sg ||
				skill_unit_exists_block(ene, KEYS)
			);
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// 石投げを使って挑発する。
AI_SKILL_USE_FUNC_T(TF_THROWSTONE, first_attack) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return bot->check_skill_range_block(kid, klv, ene) &&
			bot->check_use_taunt_skill(ene) &&
			bot->skill_ratio(kid, klv, ene) > 0 &&
			!ene->is_hiding() &&
			!ene->is_long_weapon_immune();
	});
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// 落法を使う。
AI_SKILL_USE_FUNC(TK_DODGE) {
	if (bot->sc_rest(SC_DODGE) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// ティオアプチャギを使う。
AI_SKILL_USE_FUNC(TK_JUMPKICK) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->distance_policy_value() == DPV_CLOSE &&
		!bot->check_attack_range(tar_ene) &&
		bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_use_skill(kid, klv, tar_ene) &&
		bot->sc()->data[SC_SPURT]
	) bot->use_skill_block(kid, klv, tar_ene);
}

// アプチャオルリギの構えを使う。
AI_SKILL_USE_FUNC(TK_READYCOUNTER) {
	if (!bot->sc()->data[SC_READYCOUNTER] &&
		!bot->sc()->data[SC_READYDOWN] &&
		!bot->sc()->data[SC_READYSTORM] &&
		!bot->sc()->data[SC_READYTURN]
	) bot->use_skill_self(kid, klv);
}

// タイリギを使う。
AI_SKILL_USE_FUNC(TK_RUN) {
	if (bot->sd()->weapontype1 == W_FIST &&
		bot->sc_rest(SC_SPURT) <= bot->get_skill_tail(kid) &&
		!bot->ud()->state.running
	) {
		bot->use_skill_self(kid, klv, false);
		bot->use_skill_self(kid, klv);
	}
}

// 暖かい風を使う。
AI_SKILL_USE_FUNC(TK_SEVENWIND) {
	static const std::array<sc_type, 7> SCS = {
		SC_EARTHWEAPON,
		SC_WINDWEAPON,
		SC_WATERWEAPON,
		SC_FIREWEAPON,
		SC_GHOSTWEAPON,
		SC_SHADOWWEAPON,
		SC_ASPERSIO,
	};
	block_if* tar_ene = bot->target_enemy();
	if ((!bot->skill_seven_wind()->get() ||
			skill_get_ele(kid, klv) == bot->skill_seven_wind()->get()
		) && bot->sc_rest(SCS[klv - 1]) <= bot->get_skill_tail(kid) &&
		bot->check_attack(tar_ene)
	) {
		int gre_lv = INT_MIN;
		int gre_rat;
		int max_lv = bot->check_skill(kid);
		for (int lv = 1; lv <= max_lv; ++lv) {
			int rat = bot->skill_ratio(kid, lv, tar_ene);
			if (gre_lv == INT_MIN ||
				rat > gre_rat
			) {
				gre_lv = lv;
				gre_rat = rat;
			}
		}
		int att_rat = bot->weapon_attack_element_ratio(tar_ene);
		if (gre_lv == klv &&
			gre_rat > att_rat &&
			att_rat <= bot->get_skill_low_rate()
		) bot->use_skill_self(kid, klv);
	}
}

// アプチャオルリギを使う。
AI_SKILL_USE_FUNC(TK_COUNTER) {
	if (bot->combo_skill_id() == kid) bot->use_skill_self(kid, klv);
}

// カートブーストを使う。
AI_SKILL_USE_FUNC(WS_CARTBOOST) {
	if (bot->sc_rest(SC_CARTBOOST) <= bot->get_skill_tail(kid) &&
		!bot->sc()->data[SC_DECREASEAGI] &&
		!bot->sc()->data[SC_INCREASEAGI] &&
		!bot->sc()->data[SC_QUAGMIRE] &&
		!bot->sc()->data[SC_WINDWALK]
	) bot->use_skill_self(kid, klv);
}

// メルトダウンを使う。
AI_SKILL_USE_FUNC(WS_MELTDOWN) {
	if (bot->sc_rest(SC_MELTDOWN) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// オーバートラストマックスを使う。
AI_SKILL_USE_FUNC(WS_OVERTHRUSTMAX) {
	if (bot->sc_rest(SC_MAXOVERTHRUST) <= bot->get_skill_tail(kid)) bot->use_skill_self(kid, klv);
}

// アイスウォールを使う。
AI_SKILL_USE_FUNC(WZ_ICEWALL) {
	static const skill_unit_key_map KEYS = {
		SKILL_UNIT_KEY(WZ_ICEWALL),
		SKILL_UNIT_KEY(MG_FIREWALL),
		SKILL_UNIT_KEY(SA_LANDPROTECTOR),
		SKILL_UNIT_KEY(SA_VOLCANO),
	};
	if (bot->check_skill_used_tick(kid, 2500)) {
		pos_t pos;
		block_if* ene = pybot::find_if(ALL_RRANGE(enemies), [this, kid, klv, &pos] (block_if* ene) -> bool {
			if (ene->attacked_battlers().empty() &&
				ene->is_short_range_attacker() &&
				ene->is_walking() &&
				ene->walk_target_battler() &&
				!ene->walk_target_battler()->is_primary() &&
				ene->walk_target_battler()->distance_policy_value() == DPV_AWAY &&
				ene->walkpath_length() >= 3 * 2
			) {
				pos_t mid_pos = ene->walkpath_pos(ene->walkpath_length() / 2);
				if (bot->check_skill_range_xy(kid, klv, mid_pos.x, mid_pos.y) &&
					!skill_unit_exists_xy(ene->bl()->m,	mid_pos.x, mid_pos.y, KEYS)
				) {
					pos = mid_pos;
					return true;
				}
			}
			return false;
		});
		if (pos.advantage != INT_MIN) bot->use_skill_xy(kid, klv, pos.x, pos.y);
	}
}

// ファイアーピラーを使う。
AI_SKILL_USE_FUNC(WZ_FIREPILLAR) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies), [this, kid, klv] (block_if* ene) -> bool {
		return ene->is_walking() &&
			bot->check_skill_range_xy(kid, klv, ene->ud()->to_x, ene->ud()->to_y) &&
			bot->skill_ratio(kid, klv, ene) > 100 &&
			!skill_check_unit_range(bot->bl(), ene->ud()->to_x, ene->ud()->to_y, kid, klv) &&
			!skill_check_unit_range2(bot->bl(), ene->ud()->to_x, ene->ud()->to_y, kid, klv, false);
	});
	if (ene) bot->use_skill_xy(kid, klv, ene->ud()->to_x, ene->ud()->to_y);
}

// フロストノヴァを使う。
AI_SKILL_USE_FUNC(WZ_FROSTNOVA) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies),
		sift_block_splash(bot, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
			return ene->attacked_battlers().empty() &&
				ene->is_freezable() &&
				!ene->is_hiding();
		})
	);
	if (ene) bot->use_skill_self(kid, klv);
}

// ユピテルサンダーを使う。
AI_SKILL_USE_FUNC(WZ_JUPITEL) {
	block_if* ene = pybot::find_if(ALL_RANGE(enemies),
		sift_block_splash(bot, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
			return bot->check_skill_range_block(kid, klv, ene) &&
				ene->attacked_battlers().empty() &&
				!ene->is_summoned() &&
				ene->sc()->data[SC_FREEZE] &&
				!skill_unit_exists_block(ene, skill_unit_key_map{SKILL_UNIT_KEY(WZ_STORMGUST, BL_PC, 2)});
		})
	);
	if (ene) bot->use_skill_block(kid, klv, ene);
}

// メテオストームを使う。
AI_SKILL_USE_FUNC(WZ_METEOR) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene)) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_splash(tar_ene, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					bot->skill_ratio(kid, klv, ene) > 100 &&
					!ene->is_summoned() &&
					!skill_unit_exists_block(ene, skill_unit_key_map{SKILL_UNIT_KEY(SA_LANDPROTECTOR)});
			})
		);
		if (cou >= bot->get_skill_monsters() &&
			bot->use_magicpower()
		) bot->use_skill_xy(kid, klv, tar_ene->bl()->x, tar_ene->bl()->y);
	}
}

// クァグマイアを使う。
AI_SKILL_USE_FUNC(WZ_QUAGMIRE) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene) &&
		bot->check_skill_used_tick(kid, 5 * klv * 1000 / 3)
	) {
		block_if* ene = pybot::find_if(ALL_RANGE(enemies),
			sift_block_layout(bot, tar_ene, kid, klv, [this] (block_if* ene) -> bool {
				return !ene->is_hiding() &&
					!ene->is_magic_immune() &&
					!ene->sc()->data[SC_QUAGMIRE] &&
					(ene->is_great(leader) ||
						ene->sc()->data[SC_ADRENALINE] ||
						ene->sc()->data[SC_INCREASEAGI] ||
						ene->sc()->data[SC_TWOHANDQUICKEN]
					) && !skill_unit_exists_block(ene, skill_unit_key_map{SKILL_UNIT_KEY(WZ_QUAGMIRE)});
			})
		);
		if (ene) bot->use_skill_xy(kid, klv, tar_ene->bl()->x, tar_ene->bl()->y);
	}
}

// ストームガストを使う。
AI_SKILL_USE_FUNC(WZ_STORMGUST) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene)) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_layout(bot, tar_ene, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					bot->skill_ratio(kid, klv, ene) > 50 &&
					!ene->is_summoned() &&
					!skill_unit_exists_block(ene, skill_unit_key_map{SKILL_UNIT_KEY(SA_LANDPROTECTOR)});
			})
		);
		if (cou >= bot->get_skill_monsters() &&
			bot->use_magicpower()
		) bot->use_skill_xy(kid, klv, tar_ene->bl()->x, tar_ene->bl()->y);
	}
}

// ストームガストを使って凍結する。
AI_SKILL_USE_FUNC_T(WZ_STORMGUST, freeze) {
	block_if* tar_ene = bot->target_enemy();
	if (bot->check_skill_range_block(kid, klv, tar_ene)) {
		int cou = std::count_if(ALL_RANGE(enemies),
			sift_block_layout(bot, tar_ene, kid, klv, [this, kid, klv] (block_if* ene) -> bool {
				return bot->check_use_skill(kid, klv, ene) &&
					!ene->is_summoned() &&
					ene->is_freezable() &&
					!ene->is_paralysis() &&
					!skill_unit_exists_block(ene, skill_unit_key_map{SKILL_UNIT_KEY(SA_LANDPROTECTOR)});
			})
		);
		if (cou >= bot->get_skill_monsters()) bot->use_skill_xy(kid, klv, tar_ene->bl()->x, tar_ene->bl()->y);
	}
}

// ブラッドラストを使う。
AI_SKILL_USE_FUNC(HAMI_BLOODLUST) {
	if (!homun->sc()->data[SC_BLOODLUST]) homun->use_skill_self(kid, klv);
}

// キャッスリングを使う。
AI_SKILL_USE_FUNC(HAMI_CASTLE) {
	if (homun->master()->battle_index() > homun->battle_index() &&
		!homun->master()->attacked_enemies().empty() &&
		homun->attacked_enemies().empty() &&
		homun->check_skill_used_tick(kid, 2500)
	) homun->use_skill_self(kid, klv);
}

// ディフェンスを使う。
AI_SKILL_USE_FUNC(HAMI_DEFENCE) {
	if ((!homun->attacked_enemies().empty() ||
			!homun->master()->attacked_enemies().empty()
		) && !homun->sc()->data[SC_DEFENCE]
	) homun->use_skill_self(kid, klv);
}

// フリットムーブを使う。
AI_SKILL_USE_FUNC(HFLI_FLEET) {
	if (!homun->sc()->data[SC_FLEET]) homun->use_skill_self(kid, klv);
}

// ムーンライトを使う。
AI_SKILL_USE_FUNC(HFLI_MOON) {
	block_if* tar_ene = homun->target_enemy();
	if (homun->check_skill_range_block(kid, klv, tar_ene) &&
		homun->check_use_skill(kid, klv, tar_ene) &&
		homun->skill_ratio(kid, klv, tar_ene) > 0
	) homun->use_skill_block(kid, klv, tar_ene);
}

// オーバードスピードを使う。
AI_SKILL_USE_FUNC(HFLI_SPEED) {
	if (!homun->sc()->data[SC_SPEED]) homun->use_skill_self(kid, klv);
}

// 緊急回避を使う。
AI_SKILL_USE_FUNC(HLIF_AVOID) {
	if ((!homun->attacked_enemies().empty() ||
			!homun->master()->attacked_enemies().empty()
		) && !homun->sc()->data[SC_AVOID]
	) homun->use_skill_self(kid, klv);
}

// メンタルチェンジを使う。
AI_SKILL_USE_FUNC(HLIF_CHANGE) {
	if (!homun->sc()->data[SC_CHANGE]) homun->use_skill_self(kid, klv);
}

// 治癒の手(ヒール)を使う。
AI_SKILL_USE_FUNC(HLIF_HEAL) {
	if (!homun->master()->check_hp(3)) homun->use_skill_block(kid, klv, homun->master());
}

// カプリスを使う。
AI_SKILL_USE_FUNC(HVAN_CAPRICE) {
	block_if* tar_ene = homun->target_enemy();
	if (homun->check_skill_range_block(kid, klv, tar_ene) &&
		homun->check_use_skill(kid, klv, tar_ene)
	) {
		int tot_rat = 0;
		tot_rat += homun->attack_element_ratio(tar_ene, ELE_FIRE);
		tot_rat += homun->attack_element_ratio(tar_ene, ELE_WIND);
		tot_rat += homun->attack_element_ratio(tar_ene, ELE_EARTH);
		tot_rat += homun->attack_element_ratio(tar_ene, ELE_WATER);
		if (tot_rat / 4 >= 75) homun->use_skill_block(kid, klv, tar_ene);
	}
}

// カオティックベネディクションを使って主人のHPを回復する。
AI_SKILL_USE_FUNC_T(HVAN_CHAOTIC, master) {
	if (!homun->master()->check_hp(3)) homun->use_skill_self(kid, klv);
}

// カオティックベネディクションを使って自分のHPを回復する。
AI_SKILL_USE_FUNC_T(HVAN_CHAOTIC, self) {
	if (!homun->check_hp(3)) homun->use_skill_self(kid, klv);
}

// ケミカル○○チャージを使う関数を作る。
ai_t::skill_use_func // 作った関数。
AI_SKILL_USE_DEF(cp)(
	equip_pos equ,             // 装備部位。
	sc_type sc_typ,            // 状態変化のタイプ。
	bool&(enemy_if::*has_sk)() // 敵モンスターのスキル所持判定メンバ関数。
) {
	return [equ, sc_typ, has_sk] (ai_t* ai, e_skill kid, int klv) {
		if (equ & EQP_WEAPON) {
			block_if* mem = pybot::find_if(ALL_RRANGE(ai->members), [equ, sc_typ, ai, kid] (block_if* mem) -> bool {
				return !mem->is_dead() &&
					!mem->is_hiding() &&
					!mem->is_walking() &&
					!mem->reject_skills()->find(kid) &&
					mem->sc_rest(sc_typ) <= ai->bot->get_skill_tail(kid) &&
					(mem->sc()->data[SC_OVERTHRUST] ||
						mem->sc()->data[SC_MAXOVERTHRUST]
					) && !(mem->sd()->bonus.unbreakable_equip & equ) &&
					pc_checkequip(mem->sd(), equ) >= 0;
			});
			if (mem) ai->bot->use_skill_block(kid, klv, mem);
		}
		block_if* ene = pybot::find_if(ALL_RANGE(ai->enemies), [equ, sc_typ, has_sk, kid] (block_if* ene) -> bool {
			block_if* tar_bat = ene->target_battler();
			return (ene->*has_sk)() &&
				!ene->is_walking() &&
				tar_bat &&
				dynamic_cast<member_impl*>(tar_bat) &&
				!tar_bat->is_hiding() &&
				!tar_bat->is_walking() &&
				!tar_bat->reject_skills()->find(kid) &&
				!tar_bat->sc()->data[sc_typ] &&
				!(tar_bat->sd()->bonus.unbreakable_equip & equ) &&
				pc_checkequip(tar_bat->sd(), equ) >= 0;
		});
		if (ene) ai->bot->use_skill_block(kid, klv, ene->target_battler());
	};
}

// ヒールを使う関数を作る。
ai_t::skill_use_func // 作った関数。
AI_SKILL_USE_DEF(heal)(
	int hp_rat // HPの四分率。
) {
	return [hp_rat] (ai_t* ai, e_skill kid, int klv) {
		block_if* mem = pybot::find_if(ALL_RRANGE(ai->members), [hp_rat, ai, kid] (block_if* mem) -> bool {
			return !mem->check_hp(hp_rat) &&
				!mem->is_dead() &&
				!mem->is_hiding() &&
				!mem->is_invincible() &&
				!mem->is_magic_immune() &&
				!mem->reject_skills()->find(kid) &&
				!mem->sc()->data[SC_BERSERK] &&
				!mem->sc()->data[SC_CHANGEUNDEAD] &&
				!mem->sc()->data[SC_KAITE];
		});
		if (mem) {
			int jus_lv = 0;
			while (++jus_lv < klv) {
				int rec_hp = skill_calc_heal(ai->bot->bl(), mem->bl(), kid, jus_lv, true);
				if (mem->hp() + rec_hp >= mem->max_hp()) break;
			}
			ai->bot->use_skill_block(kid, jus_lv, mem);
		}
	};
}

// ポーションピッチャーを使ってHPを回復する関数を作る。
ai_t::skill_use_func // 作った関数。
AI_SKILL_USE_DEF(pp_hp)(
	int hp_rat // HPの四分率。
) {
	return [hp_rat] (ai_t* ai, e_skill kid, int klv) {
		block_if* bat = pybot::find_if(ALL_RRANGE(ai->battlers), [hp_rat, kid] (block_if* bat) -> bool {
			return (dynamic_cast<member_impl*>(bat) ||
					bat->is_primary()
				) && !bat->check_hp(hp_rat) &&
				!bat->is_dead() &&
				!bat->is_hiding() &&
				!bat->is_invincible() &&
				!bat->reject_skills()->find(kid) &&
				!bat->sc()->data[SC_BERSERK];
		});
		if (bat) ai->bot->use_skill_block(kid, klv, bat);
	};
}

// ○○の魂を使う関数を作る。
ai_t::skill_use_func // 作った関数。
AI_SKILL_USE_DEF(spirit)(
	e_mapid mid // マップID。
) {
	return [mid] (ai_t* ai, e_skill kid, int klv) {
		block_if* mem = pybot::find_if(ALL_RRANGE(ai->members), [mid, ai, kid] (block_if* mem) -> bool {
			return mem != ai->bot &&
				!mem->is_dead() &&
				!mem->is_hiding() &&
				!mem->reject_skills()->find(kid) &&
				mem->sc_rest(SC_SPIRIT) <= ai->bot->get_skill_tail(kid) &&
				(mem->sd()->class_ & MAPID_UPPERMASK) == mid;
		});
		if (mem) ai->bot->use_skill_block(kid, klv, mem);
	};
}

// スリムポーションピッチャーを使う関数を作る。
ai_t::skill_use_func // 作った関数。
AI_SKILL_USE_DEF(spp)(
	int hp_rat // HPの四分率。
) {
	return [hp_rat] (ai_t* ai, e_skill kid, int klv) {
		int cou = std::count_if(ALL_RANGE(ai->members),
			sift_block_layout(ai->bot, ai->bot, kid, klv, [hp_rat, kid] (block_if* mem) -> bool {
				return !mem->check_hp(hp_rat) &&
					!mem->is_dead() &&
					!mem->is_hiding() &&
					!mem->is_invincible() &&
					!mem->reject_skills()->find(kid) &&
					!mem->sc()->data[SC_BERSERK];
			})
		);
		if (cou >= 3) ai->bot->use_skill_xy(kid, klv, ai->bot->bl()->x, ai->bot->bl()->y);
	};
}

}
