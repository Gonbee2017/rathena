// [GonBee]
// パーティーBOT機能のグローバルな定数と変数を定義する。

#include "pybot_internal.hpp"

namespace pybot {

// -----------------------------------------------------------------------------
// 定数の定義

// 不明を示すシンボル。
const std::string UNKNOWN_SYMBOL = "？";

// AIにおけるホムンクルススキル使用手続きのマップ。
const std::unordered_map<
	homun_mapid,                     // ホムンクルスのマップID。
	ptr<ai_t::skill_use_proc_vector> // スキル使用手続きのベクタ。
> AI_HOMUN_SKILL_USE_PROCS = {
	{MAPID_AMISTR, initialize<ai_t::skill_use_proc_vector>(
		AI_SKILL_USE_PROC  (HAMI_CASTLE         ,  1,  0, BMF_COMBAT, PF_FALSE, WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC  (HAMI_DEFENCE        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC  (HAMI_BLOODLUST      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {MAPID_FILIR, initialize<ai_t::skill_use_proc_vector>(
		AI_SKILL_USE_PROC  (HFLI_SPEED          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_TRUE , 0),
		AI_SKILL_USE_PROC  (HFLI_FLEET          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC  (HFLI_MOON           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5)
	)}, {MAPID_LIF, initialize<ai_t::skill_use_proc_vector>(
		AI_SKILL_USE_PROC  (HLIF_HEAL           ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC  (HLIF_AVOID          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC  (HLIF_CHANGE         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {MAPID_VANILMIRTH, initialize<ai_t::skill_use_proc_vector>(
		AI_SKILL_USE_PROC_T(HVAN_CHAOTIC, master,  3,  3, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T(HVAN_CHAOTIC, self  ,  4,  4, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC  (HVAN_CAPRICE        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5)
	)},
};

// AIにおけるアイテム使用手続きのベクタ。
const std::vector<
	ai_t::item_use_proc // アイテム使用手続き。
> AI_ITEM_USE_PROCS = {
	AI_ITEM_USE_PROC     (REINS_OF_MOUNT                              ),
	AI_ITEM_USE_PROC_AMMO(QUIVER                 , ARROW              ),
	AI_ITEM_USE_PROC_AMMO(IRON_ARROW_QUIVER      , IRON_ARROW         ),
	AI_ITEM_USE_PROC_AMMO(STEEL_ARROW_QUIVER     , STEEL_ARROW        ),
	AI_ITEM_USE_PROC_AMMO(ORIDECON_ARROW_QUIVER  , ORIDECON_ARROW     ),
	AI_ITEM_USE_PROC_AMMO(FIRE_ARROW_QUIVER      , FIRE_ARROW         ),
	AI_ITEM_USE_PROC_AMMO(SILVER_ARROW_QUIVER    , SILVER_ARROW       ),
	AI_ITEM_USE_PROC_AMMO(WIND_ARROW_QUIVER      , ARROW_OF_WIND      ),
	AI_ITEM_USE_PROC_AMMO(STONE_ARROW_QUIVER     , STONE_ARROW        ),
	AI_ITEM_USE_PROC_AMMO(CRYSTAL_ARROW_QUIVER   , CRYSTAL_ARROW      ),
	AI_ITEM_USE_PROC_AMMO(SHADOW_ARROW_QUIVER    , ARROW_OF_SHADOW    ),
	AI_ITEM_USE_PROC_AMMO(IMMATERIAL_ARROW_QUIVER, IMMATERIAL_ARROW   ),
	AI_ITEM_USE_PROC_AMMO(RUSTY_ARROW_QUIVER     , RUSTY_ARROW        ),
	AI_ITEM_USE_PROC_AMMO(LIGHTNING_SPHERE_PACK  , LIGHTNING_SPHERE   ),
	AI_ITEM_USE_PROC_AMMO(BLIND_SPHERE_PACK      , BLIND_SPHERE       ),
	AI_ITEM_USE_PROC_AMMO(POISON_SPHERE_PACK     , POISON_SPHERE      ),
	AI_ITEM_USE_PROC_AMMO(FREEZING_SPHERE_PACK   , FREEZING_SPHERE    ),
	AI_ITEM_USE_PROC_AMMO(FLARE_SPHERE_PACK      , FIRE_SPHERE        ),
	AI_ITEM_USE_PROC_AMMO(CARTRIDGE              , BULLET             ),
	AI_ITEM_USE_PROC_AMMO(BLOOD_CARTRIDGE        , BLOODY_SHELL       ),
	AI_ITEM_USE_PROC_AMMO(SILVER_CARTRIDGE       , SILVER_BULLET      ),
	AI_ITEM_USE_PROC_AMMO(HOLY_ARROW_QUIVER      , HOLY_ARROW         ),
	AI_ITEM_USE_PROC     (GREEN_HERB                                  ),
	AI_ITEM_USE_PROC     (GREEN_POTION                                ),
	AI_ITEM_USE_PROC     (HOLY_WATER                                  ),
	AI_ITEM_USE_PROC     (PANACEA                                     ),
	AI_ITEM_USE_PROC_D   (TOM_YUM_GOONG          , PANACEA            ),
	AI_ITEM_USE_PROC_D   (ROYAL_JELLY            , PANACEA            ),
	AI_ITEM_USE_PROC_D   (CHOCOLATE_DRINK        , PANACEA            ),
	AI_ITEM_USE_PROC     (CAVIAR_PANCAKE                              ),
	AI_ITEM_USE_PROC_D   (JAM_PANCAKE            , CAVIAR_PANCAKE     ),
	AI_ITEM_USE_PROC_D   (HONEY_PANCAKE          , CAVIAR_PANCAKE     ),
	AI_ITEM_USE_PROC_D   (SOUR_CREAM_PANCAKE     , CAVIAR_PANCAKE     ),
	AI_ITEM_USE_PROC_D   (MUSHROOM_PANCAKE       , CAVIAR_PANCAKE     ),
	AI_ITEM_USE_PROC     (BRAGI_POTION                                ),
	AI_ITEM_USE_PROC     (LEAF_OF_YGGDRASIL                           ),
	AI_ITEM_USE_PROC     (HP_INCREASE_POTIONL                         ),
	AI_ITEM_USE_PROC_D   (HP_INCREASE_POTIONM    , HP_INCREASE_POTIONL),
	AI_ITEM_USE_PROC_D   (HP_INCREASE_POTIONS    , HP_INCREASE_POTIONL),
	AI_ITEM_USE_PROC     (SP_INCREASE_POTIONL                         ),
	AI_ITEM_USE_PROC_D   (SP_INCREASE_POTIONM    , SP_INCREASE_POTIONL),
	AI_ITEM_USE_PROC_D   (SP_INCREASE_POTIONS    , SP_INCREASE_POTIONL),
	AI_ITEM_USE_PROC     (RESIST_FIRE                                 ),
	AI_ITEM_USE_PROC     (RESIST_WATER                                ),
	AI_ITEM_USE_PROC     (RESIST_EARTH                                ),
	AI_ITEM_USE_PROC     (RESIST_WIND                                 ),
	AI_ITEM_USE_PROC_ASPD(BERSERK_POTION                              ),
	AI_ITEM_USE_PROC_ASPD(AWAKENING_POTION                            ),
	AI_ITEM_USE_PROC_ASPD(CONCENTRATION_POTION                        ),
	AI_ITEM_USE_PROC     (POISON_BOTTLE                               ),
	AI_ITEM_USE_PROC     (ENRICH_CELERMINE_JUICE                      ),
	AI_ITEM_USE_PROC     (ORLEANS_FULL_COURSE                         ),
	AI_ITEM_USE_PROC     (STR_DISH10                                  ),
	AI_ITEM_USE_PROC     (AGI_DISH10                                  ),
	AI_ITEM_USE_PROC     (VIT_DISH10                                  ),
	AI_ITEM_USE_PROC     (INT_DISH10                                  ),
	AI_ITEM_USE_PROC     (DEX_DISH10                                  ),
	AI_ITEM_USE_PROC     (LUK_DISH10                                  ),
};

// AIにおけるメンバースキル使用手続きのマップ。
const std::unordered_map<
	e_job,                           // 職業。
	ptr<ai_t::skill_use_proc_vector> // スキル使用手続きのベクタ。
> AI_MEMBER_SKILL_USE_PROCS = {
	{JOB_ACOLYTE, initialize<ai_t::skill_use_proc_vector>(
		AI_SKILL_USE_PROC_HEAL  (1                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_PNEUMA                                      ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (2                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, cure                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_CURE                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (3                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_BLESSING                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_INCAGI                                      ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_ANGELUS                                     ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC_D     (AL_RUWACH, MG_SIGHT                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_DECAGI                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, curse                             ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AL_CRUCIS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (AL_HEAL, attack                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC_DT    (AL_HOLYLIGHT, SM_BASH, effective               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 4),
		AI_SKILL_USE_PROC_HEAL  (4                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC       (AL_HOLYWATER                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 4)
	)}, {JOB_ALCHEMIST, initialize<ai_t::skill_use_proc_vector>(				 	 
		AI_SKILL_USE_PROC       (AM_CALLHOMUN                                   ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AM_REST                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AM_RESURRECTHOMUN                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_CP    (WEAPON, WEAPON, WEAPON, weapon                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_CP    (SHIELD, SHIELD, SHIELD, shield                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_CP    (ARMOR, ARMOR, ARMOR, armor                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_CP    (HELM, HEAD_TOP, HELM, helm                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_PP_HP (1                                              ,  4,  4, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (2                                              ,  4,  4, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (3                                              ,  1,  1, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (3                                              ,  2,  2, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (3                                              ,  3,  3, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AM_CANNIBALIZE                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (AM_DEMONSTRATION, WZ_FIREPILLAR                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MC_LOUD                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AM_BERSERKPITCHER                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (AM_POTIONPITCHER, sp                           ,  5,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MC_CARTREVOLUTION                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MC_MAMMONITE                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AM_ACIDTERROR                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_ARCHER, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC       (AC_CHARGEARROW                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CONCENTRATION                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_SHOWER                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_DOUBLE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5)
	)}, {JOB_ASSASSIN, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC_T     (TF_HIDING, deactivate                          ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (AS_VENOMKNIFE, TF_THROWSTONE, first_attack     ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_THROWSTONE, first_attack                    ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (AS_VENOMKNIFE, TF_THROWSTONE, crush            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_THROWSTONE, crush                           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (TF_DETOXIFY                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_HIDING, activate                            ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AS_POISONREACT                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AS_ENCHANTPOISON                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TF_STEAL                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_POISON                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_SPRINKLESAND                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_D     (AS_GRIMTOOTH, SM_BASH                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (AS_SONICBLOW, SM_BASH                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (TF_PICKSTONE                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_ASSASSIN_CROSS, initialize<ai_t::skill_use_proc_vector>(			 	 
		AI_SKILL_USE_PROC_T     (TF_HIDING, deactivate                          ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (AS_VENOMKNIFE, TF_THROWSTONE, first_attack     ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_THROWSTONE, first_attack                    ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (AS_VENOMKNIFE, TF_THROWSTONE, crush            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_THROWSTONE, crush                           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (TF_DETOXIFY                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_HIDING, activate                            ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (ASC_EDP                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AS_POISONREACT                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AS_ENCHANTPOISON                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (ASC_METEORASSAULT, SM_MAGNUM                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TF_STEAL                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_POISON                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_SPRINKLESAND                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_D     (AS_GRIMTOOTH, SM_BASH                          ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (AS_SONICBLOW, SM_BASH                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (ASC_BREAKER                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (TF_PICKSTONE                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_BARD, initialize<ai_t::skill_use_proc_vector>(						 	 
		AI_SKILL_USE_PROC       (BD_ADAPTATION                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CHARGEARROW                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CONCENTRATION                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (BA_FROSTJOKER                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_SHOWER                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (BA_MUSICALSTRIKE, AC_DOUBLE                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (AC_DOUBLE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5)
	)}, {JOB_BLACKSMITH, initialize<ai_t::skill_use_proc_vector>(				 	 
		AI_SKILL_USE_PROC_T     (BS_MAXIMIZE, deactivate                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (BS_REPAIRWEAPON                                ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (BS_ADRENALINE2                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (BS_ADRENALINE                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MC_LOUD                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (BS_OVERTHRUST                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (BS_WEAPONPERFECT                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (BS_MAXIMIZE, activate                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MC_CARTREVOLUTION                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (BS_HAMMERFALL                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MC_MAMMONITE                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_CHAMPION, initialize<ai_t::skill_use_proc_vector>(
		AI_SKILL_USE_PROC       (MO_CHAINCOMBO                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (MO_COMBOFINISH                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (CH_TIGERFIST                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (CH_CHAINCRUSH                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_T     (MO_EXTREMITYFIST, combo                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MO_STEELBODY                                   ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (1                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_PNEUMA                                      ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (2                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, cure                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_CURE                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MO_BALKYOUNG                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (MO_FINGEROFFENSIVE, TF_THROWSTONE, first_attack,  1,  1, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (MO_FINGEROFFENSIVE, TF_THROWSTONE, crush       ,  1,  1, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (3                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MO_EXPLOSIONSPIRITS                            ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AL_BLESSING                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_INCAGI                                      ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_ANGELUS                                     ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC_D     (AL_RUWACH, MG_SIGHT                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_DECAGI                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, curse                             ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AL_CRUCIS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MO_ABSORBSPIRITS                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MO_BODYRELOCATION                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MO_BLADESTOP                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_TRUE , 3),
		AI_SKILL_USE_PROC       (MO_EXTREMITYFIST                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 3),
		AI_SKILL_USE_PROC       (MO_INVESTIGATE                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (CH_PALMSTRIKE                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (MO_FINGEROFFENSIVE                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 5),
		AI_SKILL_USE_PROC_DT    (CH_SOULCOLLECT, MO_CALLSPIRITS, ready          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (MO_CALLSPIRITS, ready                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (AL_HEAL, attack                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC_DT    (AL_HOLYLIGHT, SM_BASH, effective               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 4),
		AI_SKILL_USE_PROC_HEAL  (4                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC       (CH_SOULCOLLECT                                 ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MO_CALLSPIRITS                                 ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_HOLYWATER                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 4)
	)}, {JOB_CLOWN, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC       (CG_LONGINGFREEDOM                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (BD_ADAPTATION                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CHARGEARROW                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CONCENTRATION                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (BA_FROSTJOKER                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_SHOWER                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (CG_ARROWVULCAN, AC_DOUBLE                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (BA_MUSICALSTRIKE, AC_DOUBLE                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (AC_DOUBLE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5)
	)}, {JOB_CREATOR, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC       (AM_CALLHOMUN                                   ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AM_REST                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AM_RESURRECTHOMUN                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (CR_FULLPROTECTION                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_CP    (WEAPON, WEAPON, WEAPON, weapon                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_CP    (SHIELD, SHIELD, SHIELD, shield                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_CP    (ARMOR, ARMOR, ARMOR, armor                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_CP    (HELM, HEAD_TOP, HELM, helm                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPP   (1                                              , 10,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (1                                              ,  4,  4, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_SPP   (2                                              , 10,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (2                                              ,  4,  4, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_SPP   (3                                              ,  1,  5, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_SPP   (3                                              ,  6,  9, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (3                                              ,  1,  1, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (3                                              ,  2,  2, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (3                                              ,  3,  3, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AM_CANNIBALIZE                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (AM_DEMONSTRATION, WZ_FIREPILLAR                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MC_LOUD                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AM_BERSERKPITCHER                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (AM_POTIONPITCHER, sp                           ,  5,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MC_CARTREVOLUTION                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MC_MAMMONITE                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (CR_ACIDDEMONSTRATION, AM_ACIDTERROR            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AM_ACIDTERROR                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_CRUSADER, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC_T     (CR_DEFENDER, deactivate                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (CR_SHIELDCHARGE, AC_CHARGEARROW                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (1                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (CR_DEFENDER, activate                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (2                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SM_PROVOKE                                     ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC_DT    (CR_SHIELDBOOMERANG, TF_THROWSTONE, first_attack,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (SM_PROVOKE, first_attack                       ,  1,  1, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (SM_PROVOKE, TF_THROWSTONE, crush               ,  1,  1, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (CR_SHIELDBOOMERANG, TF_THROWSTONE, crush       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (SM_BASH, disturb                               ,  6,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_CURE                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (3                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SM_AUTOBERSERK                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (CR_AUTOGUARD                                   ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (CR_REFLECTSHIELD                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (CR_SHRINK                                      ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (CR_DEVOTION                                    ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (CR_PROVIDENCE                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (CR_SPEARQUICKEN                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_ENDURE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_TRUE , AF_TRUE , 3),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, enchant                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (CR_GRANDCROSS, effective                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, effective                           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (CR_GRANDCROSS                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_MAGNUM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_DT    (CR_HOLYCROSS, SM_BASH, effective               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_T     (SM_BASH, effective                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (CR_HOLYCROSS, SM_BASH                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (SM_BASH                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_T     (CR_SHIELDBOOMERANG, spirit                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (CR_DEVOTION                                    ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_HEAL  (4                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4)
	)}, {JOB_DANCER, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC       (BD_ADAPTATION                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CHARGEARROW                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CONCENTRATION                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (DC_SCREAM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_SHOWER                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (DC_WINKCHARM                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_D     (DC_THROWARROW, AC_DOUBLE                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (AC_DOUBLE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5)
	)}, {JOB_GUNSLINGER, initialize<ai_t::skill_use_proc_vector>(				 	 
		AI_SKILL_USE_PROC_T     (GS_MADNESSCANCEL, deactivate                   ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (GS_GATLINGFEVER, deactivate                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (GS_DUST                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (GS_CRACKER                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (GS_ADJUSTMENT                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 3),
		AI_SKILL_USE_PROC       (GS_INCREASING                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (GS_GATLINGFEVER, activate                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (GS_MADNESSCANCEL, activate                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (GS_GROUNDDRIFT                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 3),
		AI_SKILL_USE_PROC       (GS_DESPERADO                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (GS_SPREADATTACK, AC_SHOWER                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (GS_DISARM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (GS_FLING                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (GS_PIERCINGSHOT                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 3),
		AI_SKILL_USE_PROC       (GS_TRACKING                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 5),
		AI_SKILL_USE_PROC       (GS_BULLSEYE                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 5),
		AI_SKILL_USE_PROC       (GS_MAGICALBULLET                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (GS_FULLBUSTER, AC_DOUBLE                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (GS_RAPIDSHOWER, AC_DOUBLE                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (GS_TRIPLEACTION                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (GS_GLITTERING                                  ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_GYPSY, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC       (CG_LONGINGFREEDOM                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (BD_ADAPTATION                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CHARGEARROW                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CONCENTRATION                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (DC_SCREAM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_SHOWER                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (DC_WINKCHARM                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 3),
		AI_SKILL_USE_PROC_D     (CG_ARROWVULCAN, AC_DOUBLE                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (DC_THROWARROW, AC_DOUBLE                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (AC_DOUBLE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5)
	)}, {JOB_HIGH_PRIEST, initialize<ai_t::skill_use_proc_vector>(				 	 
		AI_SKILL_USE_PROC_HEAL  (1                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_PNEUMA                                      ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (HP_ASSUMPTIO, primary                          ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (2                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PR_REDEMPTIO                                   ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (ALL_RESURRECTION                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PR_STRECOVERY                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, cure                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_CURE                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PR_SANCTUARY                                   ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_HEAL  (3                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PR_SLOWPOISON                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_SAFETYWALL                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (HP_ASSUMPTIO, not_primary                      ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (PR_BENEDICTIO                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_MAGNIFICAT                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (AL_BLESSING                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_INCAGI                                      ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_ANGELUS                                     ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (PR_GLORIA                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PR_ASPERSIO                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_IMPOSITIO                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PR_KYRIE                                       ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_SUFFRAGIUM                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC_D     (AL_RUWACH, MG_SIGHT                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_DECAGI                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_MAGNUS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (PR_TURNUNDEAD                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, curse                             ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (PR_STRECOVERY, blind                           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AL_CRUCIS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PR_LEXDIVINA                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_LEXAETERNA                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (AL_HEAL, attack                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC_DT    (AL_HOLYLIGHT, SM_BASH, effective               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 4),
		AI_SKILL_USE_PROC_HEAL  (4                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC       (PR_SUFFRAGIUM                                  ,  1,  1, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_HOLYWATER                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 4)
	)}, {JOB_HIGH_WIZARD, initialize<ai_t::skill_use_proc_vector>(				 	 
		AI_SKILL_USE_PROC       (WZ_FROSTNOVA                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FIREWALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (WZ_ICEWALL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FROSTDIVER                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_STONECURSE                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (HW_GANBANTEIN                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (MG_SAFETYWALL                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_ENERGYCOAT                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_SIGHT                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (WZ_QUAGMIRE                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (WZ_FIREPILLAR                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (WZ_METEOR                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (WZ_VERMILION, MG_THUNDERSTORM                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_HEAVENDRIVE, MG_THUNDERSTORM                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_STORMGUST                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (WZ_STORMGUST, freeze                           ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (HW_GRAVITATION                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_JUPITEL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_WATERBALL, MG_FIREBOLT                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBOLT                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_LIGHTNINGBOLT, MG_FIREBOLT                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_EARTHSPIKE, MG_FIREBOLT                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_COLDBOLT, MG_FIREBOLT                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (HW_NAPALMVULCAN, MG_NAPALMBEAT                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (MG_SOULSTRIKE, MG_NAPALMBEAT                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_DT    (WZ_WATERBALL, MG_FIREBOLT, compromise          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (MG_FIREBOLT, compromise                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_LIGHTNINGBOLT, MG_FIREBOLT, compromise      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (WZ_EARTHSPIKE, MG_FIREBOLT, compromise         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_COLDBOLT, MG_FIREBOLT, compromise           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (HW_MAGICCRASHER, MG_NAPALMBEAT                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_NAPALMBEAT                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_HUNTER, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC       (HT_POWER                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CHARGEARROW                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (HT_ANKLESNARE                                  ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (HT_CLAYMORETRAP, HT_LANDMINE                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (HT_BLASTMINE, HT_LANDMINE                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (HT_LANDMINE                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (HT_FREEZINGTRAP                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (HT_SANDMAN                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CONCENTRATION                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (HT_DETECTING                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (HT_BLITZBEAT, MC_CARTREVOLUTION                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_SHOWER                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_DOUBLE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (HT_REMOVETRAP                                  ,  1,  0, BMF_NONE  , PF_ALL  , WF_ALL  , AF_FALSE, 0)
	)}, {JOB_KNIGHT, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC_D     (KN_SPEARSTAB, AC_CHARGEARROW                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SM_PROVOKE                                     ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC_DT    (KN_SPEARBOOMERANG, TF_THROWSTONE, first_attack ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (SM_PROVOKE, first_attack                       ,  1,  1, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (SM_PROVOKE, TF_THROWSTONE, crush               ,  1,  1, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (KN_SPEARBOOMERANG, TF_THROWSTONE, crush        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (SM_BASH, disturb                               ,  6,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SM_AUTOBERSERK                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (KN_ONEHAND                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (KN_TWOHANDQUICKEN                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_ENDURE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_TRUE , AF_TRUE , 3),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, enchant                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (KN_AUTOCOUNTER                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_TRUE , 1),
		AI_SKILL_USE_PROC_DT    (KN_BOWLINGBASH, MC_CARTREVOLUTION, effective   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_DT    (KN_BRANDISHSPEAR, MC_CARTREVOLUTION, effective ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, effective                           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (KN_BOWLINGBASH, MC_CARTREVOLUTION              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (KN_BRANDISHSPEAR, MC_CARTREVOLUTION            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_MAGNUM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (KN_CHARGEATK                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC       (KN_PIERCE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (SM_BASH                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5)
	)}, {JOB_LORD_KNIGHT, initialize<ai_t::skill_use_proc_vector>(				 	 
		AI_SKILL_USE_PROC_D     (KN_SPEARSTAB, AC_CHARGEARROW                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (LK_BERSERK                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SM_PROVOKE                                     ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC_DT    (KN_SPEARBOOMERANG, TF_THROWSTONE, first_attack ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (SM_PROVOKE, first_attack                       ,  1,  1, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (SM_PROVOKE, TF_THROWSTONE, crush               ,  1,  1, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (KN_SPEARBOOMERANG, TF_THROWSTONE, crush        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (SM_BASH, disturb                               ,  6,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (LK_HEADCRUSH                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SM_AUTOBERSERK                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (LK_PARRYING                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (KN_ONEHAND                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (KN_TWOHANDQUICKEN                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (LK_AURABLADE                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (LK_CONCENTRATION                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (SM_ENDURE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_TRUE , AF_TRUE , 3),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, enchant                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (KN_AUTOCOUNTER                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_TRUE , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (KN_BOWLINGBASH, MC_CARTREVOLUTION              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (KN_BRANDISHSPEAR, MC_CARTREVOLUTION            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, effective                           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_MAGNUM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (KN_CHARGEATK                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC       (LK_JOINTBEAT                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (LK_SPIRALPIERCE                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 5),
		AI_SKILL_USE_PROC       (KN_PIERCE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (SM_BASH                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5)
	)}, {JOB_MAGE, initialize<ai_t::skill_use_proc_vector>(						 	 
		AI_SKILL_USE_PROC       (MG_FIREWALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FROSTDIVER                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_STONECURSE                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_SAFETYWALL                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_ENERGYCOAT                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_SIGHT                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBOLT                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_LIGHTNINGBOLT, MG_FIREBOLT                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_COLDBOLT, MG_FIREBOLT                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_SOULSTRIKE, MG_NAPALMBEAT                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (MG_FIREBOLT, compromise                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_LIGHTNINGBOLT, MG_FIREBOLT, compromise      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_COLDBOLT, MG_FIREBOLT, compromise           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_NAPALMBEAT                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_MERCHANT, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC       (MC_LOUD                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MC_CARTREVOLUTION                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MC_MAMMONITE                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_MONK, initialize<ai_t::skill_use_proc_vector>(
		AI_SKILL_USE_PROC       (MO_CHAINCOMBO                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (MO_COMBOFINISH                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_T     (MO_EXTREMITYFIST, combo                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MO_STEELBODY                                   ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (1                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_PNEUMA                                      ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (2                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, cure                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_CURE                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MO_BALKYOUNG                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (MO_FINGEROFFENSIVE, first_attack               ,  1,  1, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (MO_FINGEROFFENSIVE, crush                      ,  1,  1, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (3                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MO_EXPLOSIONSPIRITS                            ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AL_BLESSING                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_INCAGI                                      ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_ANGELUS                                     ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC_D     (AL_RUWACH, MG_SIGHT                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_DECAGI                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, curse                             ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AL_CRUCIS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MO_ABSORBSPIRITS                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MO_BODYRELOCATION                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MO_BLADESTOP                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_TRUE , 3),
		AI_SKILL_USE_PROC       (MO_EXTREMITYFIST                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 3),
		AI_SKILL_USE_PROC       (MO_INVESTIGATE                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (MO_FINGEROFFENSIVE                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 5),
		AI_SKILL_USE_PROC_T     (MO_CALLSPIRITS, ready                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (AL_HEAL, attack                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC_DT    (AL_HOLYLIGHT, SM_BASH, effective               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 4),
		AI_SKILL_USE_PROC_HEAL  (4                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC       (MO_CALLSPIRITS                                 ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_HOLYWATER                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 4)
	)}, {JOB_NINJA, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC       (NJ_KIRIKAGE                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_SHADOWJUMP                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_TATAMIGAESHI                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_HYOUSYOURAKU                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_NEN                                         ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_BUNSINJYUTSU                                ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_UTSUSEMI                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_KASUMIKIRI                                  ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (NJ_KAENSIN                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (NJ_SUITON                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (NJ_BAKUENRYU                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (NJ_RAIGEKISAI                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (NJ_KAMAITACHI                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (NJ_HUUMA, MC_CARTREVOLUTION                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (NJ_ZENYNAGE, MC_MAMMONITE                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (NJ_ISSEN                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_DT    (NJ_KOUENKA, SM_BASH, effective                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HUUJIN, SM_BASH, effective                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HYOUSENSOU, SM_BASH, effective              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (NJ_KOUENKA, compromise                         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HUUJIN, NJ_KOUENKA, compromise              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HYOUSENSOU, NJ_KOUENKA, compromise          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (NJ_SYURIKEN, AC_DOUBLE                         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (NJ_KUNAI, AC_DOUBLE                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5)
	)}, {JOB_NOVICE, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC_T     (NV_TRICKDEAD, deactivate                       ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_T     (NV_TRICKDEAD, activate                         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0), 
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (NV_FIRSTAID                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 1)
	)}, {JOB_PALADIN, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC_T     (PA_GOSPEL, deactivate                          ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (CR_DEFENDER, deactivate                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (CR_SHIELDCHARGE, AC_CHARGEARROW                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (1                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (CR_DEFENDER, activate                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (2                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SM_PROVOKE                                     ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC_DT    (CR_SHIELDBOOMERANG, TF_THROWSTONE, first_attack,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (SM_PROVOKE, first_attack                       ,  1,  1, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (SM_PROVOKE, TF_THROWSTONE, crush               ,  1,  1, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (CR_SHIELDBOOMERANG, TF_THROWSTONE, crush       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (SM_BASH, disturb                               ,  6,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_CURE                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (3                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SM_AUTOBERSERK                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (CR_AUTOGUARD                                   ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (CR_REFLECTSHIELD                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (CR_SHRINK                                      ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (CR_DEVOTION                                    ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (CR_PROVIDENCE                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (PA_GOSPEL, activate                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (CR_SPEARQUICKEN                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PA_SACRIFICE                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_ENDURE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_TRUE , AF_TRUE , 3),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, enchant                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (CR_GRANDCROSS, effective                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, effective                           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (CR_GRANDCROSS                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_MAGNUM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_DT    (CR_HOLYCROSS, SM_BASH, effective               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_T     (SM_BASH, effective                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (PA_SHIELDCHAIN, SM_BASH                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (CR_HOLYCROSS, SM_BASH                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (SM_BASH                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_T     (CR_SHIELDBOOMERANG, spirit                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (PA_PRESSURE, ASC_BREAKER                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (CR_DEVOTION                                    ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_HEAL  (4                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4)
	)}, {JOB_PRIEST, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC_HEAL  (1                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_PNEUMA                                      ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (2                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PR_REDEMPTIO                                   ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (ALL_RESURRECTION                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PR_STRECOVERY                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, cure                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_CURE                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PR_SANCTUARY                                   ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_HEAL  (3                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PR_SLOWPOISON                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_SAFETYWALL                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (PR_BENEDICTIO                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_MAGNIFICAT                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (AL_BLESSING                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_INCAGI                                      ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_ANGELUS                                     ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (PR_GLORIA                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PR_ASPERSIO                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_IMPOSITIO                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PR_KYRIE                                       ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_SUFFRAGIUM                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC_D     (AL_RUWACH, MG_SIGHT                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_DECAGI                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_MAGNUS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (PR_TURNUNDEAD                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, curse                             ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (PR_STRECOVERY, blind                           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AL_CRUCIS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PR_LEXDIVINA                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_LEXAETERNA                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (AL_HEAL, attack                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC_DT    (AL_HOLYLIGHT, SM_BASH, effective               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 4),
		AI_SKILL_USE_PROC_HEAL  (4                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC       (PR_SUFFRAGIUM                                  ,  1,  1, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_HOLYWATER                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 4)
	)}, {JOB_PROFESSOR, initialize<ai_t::skill_use_proc_vector>(				 	 
		AI_SKILL_USE_PROC       (SA_LANDPROTECTOR                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (PF_FOGWALL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (SA_DISPELL, cure                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (SA_DISPELL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (PF_SPIDERWEB                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SA_MAGICROD                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SA_SPELLBREAKER                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (PF_HPCONVERSION                                ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PF_SOULCHANGE                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (MG_FIREWALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FROSTDIVER                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_STONECURSE                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_SAFETYWALL                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_ENERGYCOAT                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_SIGHT                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SA_VOLCANO                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_VIOLENTGALE                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_DELUGE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_AUTOSPELL                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SA_FLAMELAUNCHER                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_LIGHTNINGLOADER                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_SEISMICWEAPON                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_FROSTWEAPON                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (PF_DOUBLECASTING                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBOLT                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_LIGHTNINGBOLT, MG_FIREBOLT                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_COLDBOLT, MG_FIREBOLT                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_SOULSTRIKE, MG_NAPALMBEAT                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (MG_FIREBOLT, compromise                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_LIGHTNINGBOLT, MG_FIREBOLT, compromise      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_COLDBOLT, MG_FIREBOLT, compromise           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_NAPALMBEAT                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PF_MEMORIZE                                    ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_ROGUE, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC_D     (RG_RAID, SM_MAGNUM                             ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_KIRIKAGE                                    ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_HIDING, deactivate                          ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (CR_SHIELDCHARGE, AC_CHARGEARROW                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CHARGEARROW                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (1                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (2                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (ALL_RESURRECTION                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (3                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (CR_SHIELDBOOMERANG, TF_THROWSTONE, first_attack,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_THROWSTONE, first_attack                    ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (CR_SHIELDBOOMERANG, TF_THROWSTONE, crush       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_THROWSTONE, crush                           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (HT_CLAYMORETRAP, HT_LANDMINE                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (HT_BLASTMINE, HT_LANDMINE                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (HT_LANDMINE                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (HT_FREEZINGTRAP                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FIREWALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FROSTDIVER                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_TATAMIGAESHI                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_HYOUSYOURAKU                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (TF_DETOXIFY                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_KASUMIKIRI                                  ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (TF_HIDING, activate                            ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, enchant                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (NJ_KAENSIN                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (CR_GRANDCROSS                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (KN_BOWLINGBASH, MC_CARTREVOLUTION              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_MAGNUM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_SHOWER                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_MAGNUS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_METEOR                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (NJ_BAKUENRYU                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (WZ_VERMILION, MG_THUNDERSTORM                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (NJ_RAIGEKISAI                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (NJ_KAMAITACHI                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_HEAVENDRIVE, MG_THUNDERSTORM                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_STORMGUST                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (WZ_STORMGUST, freeze                           ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (WZ_JUPITEL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (PR_TURNUNDEAD                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_STEAL                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (RG_STEALCOIN                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (RG_STRIPWEAPON                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 3),
		AI_SKILL_USE_PROC       (RG_STRIPSHIELD                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 3),
		AI_SKILL_USE_PROC       (TF_POISON                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_SPRINKLESAND                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TK_JUMPKICK                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC       (KN_CHARGEATK                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC_D     (NJ_ZENYNAGE, MC_MAMMONITE                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MC_MAMMONITE                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (RG_BACKSTAP                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (CR_HOLYCROSS, SM_BASH                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (SM_BASH                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (AC_DOUBLE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (WZ_WATERBALL, MG_FIREBOLT                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBOLT                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_KOUENKA, SM_BASH, effective                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_LIGHTNINGBOLT, MG_FIREBOLT                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HUUJIN, SM_BASH, effective                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_EARTHSPIKE, MG_FIREBOLT                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_COLDBOLT, MG_FIREBOLT                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HYOUSENSOU, SM_BASH, effective              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_SOULSTRIKE, MG_NAPALMBEAT                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (AL_HEAL, attack                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC_DT    (AL_HOLYLIGHT, SM_BASH, effective               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 4),
		AI_SKILL_USE_PROC_DT    (WZ_WATERBALL, MG_FIREBOLT, compromise          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (MG_FIREBOLT, compromise                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (NJ_KOUENKA, compromise                         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_LIGHTNINGBOLT, MG_FIREBOLT, compromise      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HUUJIN, NJ_KOUENKA, compromise              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (WZ_EARTHSPIKE, MG_FIREBOLT, compromise         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_COLDBOLT, MG_FIREBOLT, compromise           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HYOUSENSOU, NJ_KOUENKA, compromise          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_HEAL  (4                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC       (TF_PICKSTONE                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_SAGE, initialize<ai_t::skill_use_proc_vector>(						 	 
		AI_SKILL_USE_PROC       (SA_LANDPROTECTOR                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_T     (SA_DISPELL, cure                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (SA_DISPELL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (SA_MAGICROD                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SA_SPELLBREAKER                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (MG_FIREWALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FROSTDIVER                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_STONECURSE                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_SAFETYWALL                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_ENERGYCOAT                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_SIGHT                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SA_VOLCANO                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_VIOLENTGALE                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_DELUGE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_AUTOSPELL                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SA_FLAMELAUNCHER                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_LIGHTNINGLOADER                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_SEISMICWEAPON                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_FROSTWEAPON                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBOLT                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_LIGHTNINGBOLT, MG_FIREBOLT                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_COLDBOLT, MG_FIREBOLT                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_SOULSTRIKE, MG_NAPALMBEAT                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (MG_FIREBOLT, compromise                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_LIGHTNINGBOLT, MG_FIREBOLT, compromise      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_COLDBOLT, MG_FIREBOLT, compromise           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_NAPALMBEAT                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_SNIPER, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC       (HT_POWER                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CHARGEARROW                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (HT_ANKLESNARE                                  ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (HT_CLAYMORETRAP, HT_LANDMINE                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (HT_BLASTMINE, HT_LANDMINE                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (HT_LANDMINE                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (HT_FREEZINGTRAP                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (HT_SANDMAN                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SN_WINDWALK                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_CONCENTRATION                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SN_SIGHT                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (HT_DETECTING                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (HT_BLITZBEAT, MC_CARTREVOLUTION                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SN_SHARPSHOOTING                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_SHOWER                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_DOUBLE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (SN_FALCONASSAULT, SM_BASH                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (HT_REMOVETRAP                                  ,  1,  0, BMF_NONE  , PF_ALL  , WF_ALL  , AF_FALSE, 0)
	)}, {JOB_SOUL_LINKER, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC_SPIRIT(SL_ALCHEMIST, MAPID_ALCHEMIST                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPIRIT(SL_MONK, MAPID_MONK                            ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPIRIT(SL_STAR, MAPID_STAR_GLADIATOR                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPIRIT(SL_SAGE, MAPID_SAGE                            ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPIRIT(SL_CRUSADER, MAPID_CRUSADER                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPIRIT(SL_SUPERNOVICE, MAPID_SUPER_NOVICE             ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPIRIT(SL_KNIGHT, MAPID_KNIGHT                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPIRIT(SL_WIZARD, MAPID_WIZARD                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPIRIT(SL_PRIEST, MAPID_PRIEST                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPIRIT(SL_BARDDANCER, MAPID_BARDDANCER                ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPIRIT(SL_ROGUE, MAPID_ROGUE                          ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPIRIT(SL_ASSASIN, MAPID_ASSASSIN                     ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPIRIT(SL_BLACKSMITH, MAPID_BLACKSMITH                ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPIRIT(SL_HUNTER, MAPID_HUNTER                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC_SPIRIT(SL_SOULLINKER, MAPID_SOUL_LINKER               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (TK_DODGE                                       ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_RUN                                         ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SL_KAAHI                                       ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SL_KAITE                                       ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SL_KAIZEL                                      ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SL_KAUPE                                       ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SL_SKE                                         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SL_SKA                                         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SL_SWOO                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  2,  2, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  3,  3, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  4,  4, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  5,  5, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  6,  6, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  7,  7, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SL_SMA                                         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SL_STIN                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SL_STUN                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_STALKER, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC_D     (RG_RAID, SM_MAGNUM                             ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_KIRIKAGE                                    ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_HIDING, deactivate                          ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (CR_SHIELDCHARGE, AC_CHARGEARROW                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CHARGEARROW                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (1                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (ST_PRESERVE                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (2                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (ALL_RESURRECTION                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (3                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (CR_SHIELDBOOMERANG, TF_THROWSTONE, first_attack,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_THROWSTONE, first_attack                    ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (CR_SHIELDBOOMERANG, TF_THROWSTONE, crush       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_THROWSTONE, crush                           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (HT_CLAYMORETRAP, HT_LANDMINE                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (HT_BLASTMINE, HT_LANDMINE                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (HT_LANDMINE                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (HT_FREEZINGTRAP                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FIREWALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FROSTDIVER                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_TATAMIGAESHI                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_HYOUSYOURAKU                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (TF_DETOXIFY                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (ST_REJECTSWORD                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (NJ_KASUMIKIRI                                  ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (TF_HIDING, activate                            ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, enchant                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (NJ_KAENSIN                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (CR_GRANDCROSS                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (KN_BOWLINGBASH, MC_CARTREVOLUTION              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_MAGNUM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_SHOWER                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_MAGNUS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_METEOR                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (NJ_BAKUENRYU                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (WZ_VERMILION, MG_THUNDERSTORM                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (NJ_RAIGEKISAI                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (NJ_KAMAITACHI                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_HEAVENDRIVE, MG_THUNDERSTORM                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_STORMGUST                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (WZ_STORMGUST, freeze                           ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (WZ_JUPITEL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (PR_TURNUNDEAD                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_STEAL                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (RG_STEALCOIN                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (ST_FULLSTRIP                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (RG_STRIPWEAPON                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 3),
		AI_SKILL_USE_PROC       (RG_STRIPSHIELD                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 3),
		AI_SKILL_USE_PROC       (TF_POISON                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_SPRINKLESAND                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TK_JUMPKICK                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC       (KN_CHARGEATK                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC_D     (NJ_ZENYNAGE, MC_MAMMONITE                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MC_MAMMONITE                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (RG_BACKSTAP                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (CR_HOLYCROSS, SM_BASH                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (SM_BASH                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (AC_DOUBLE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (WZ_WATERBALL, MG_FIREBOLT                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBOLT                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_KOUENKA, SM_BASH, effective                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_LIGHTNINGBOLT, MG_FIREBOLT                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HUUJIN, SM_BASH, effective                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_EARTHSPIKE, MG_FIREBOLT                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_COLDBOLT, MG_FIREBOLT                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HYOUSENSOU, SM_BASH, effective              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_SOULSTRIKE, MG_NAPALMBEAT                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (AL_HEAL, attack                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC_DT    (AL_HOLYLIGHT, SM_BASH, effective               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 4),
		AI_SKILL_USE_PROC_DT    (WZ_WATERBALL, MG_FIREBOLT, compromise          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (MG_FIREBOLT, compromise                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (NJ_KOUENKA, compromise                         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_LIGHTNINGBOLT, MG_FIREBOLT, compromise      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HUUJIN, NJ_KOUENKA, compromise              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (WZ_EARTHSPIKE, MG_FIREBOLT, compromise         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_COLDBOLT, MG_FIREBOLT, compromise           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HYOUSENSOU, NJ_KOUENKA, compromise          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (TF_PICKSTONE                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_STAR_GLADIATOR, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC_D     (TK_STORMKICK, TK_COUNTER                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (TK_TURNKICK, TK_COUNTER                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (TK_COUNTER                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (TK_DOWNKICK, TK_COUNTER                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (TK_READYSTORM, TK_READYCOUNTER                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (TK_READYTURN, TK_READYCOUNTER                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (TK_READYCOUNTER                                ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (TK_READYDOWN, TK_READYCOUNTER                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (TK_DODGE                                       ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SG_SUN_COMFORT                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SG_MOON_COMFORT                                ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SG_STAR_COMFORT                                ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_RUN                                         ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SG_FUSION                                      ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SG_SUN_WARM                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (SG_MOON_WARM, SG_SUN_WARM                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (SG_STAR_WARM, SG_SUN_WARM                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  2,  2, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  3,  3, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  4,  4, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  5,  5, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  6,  6, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  7,  7, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_JUMPKICK                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_SUPER_NOVICE, initialize<ai_t::skill_use_proc_vector>(				 	 
		AI_SKILL_USE_PROC_T     (TF_HIDING, deactivate                          ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (1                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_PNEUMA                                      ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (2                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, cure                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_CURE                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (3                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (TF_DETOXIFY                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SM_PROVOKE                                     ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (SM_PROVOKE, first_attack                       ,  1,  1, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (SM_PROVOKE, TF_THROWSTONE, crush               ,  1,  1, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FIREWALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FROSTDIVER                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_STONECURSE                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_SAFETYWALL                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (AC_CONCENTRATION                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_BLESSING                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_INCAGI                                      ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_ANGELUS                                     ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC_T     (TF_HIDING, activate                            ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MG_SIGHT                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (AL_RUWACH, MG_SIGHT                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_ENDURE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_TRUE , AF_TRUE , 3),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, enchant                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AL_DECAGI                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_MAGNUM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, curse                             ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AL_CRUCIS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_STEAL                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_POISON                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MC_MAMMONITE                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_BASH                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (MG_FIREBOLT                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_LIGHTNINGBOLT, MG_FIREBOLT                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_COLDBOLT, MG_FIREBOLT                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_SOULSTRIKE, MG_NAPALMBEAT                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (MG_FIREBOLT, compromise                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_LIGHTNINGBOLT, MG_FIREBOLT, compromise      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_COLDBOLT, MG_FIREBOLT, compromise           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_NAPALMBEAT                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (AL_HEAL, attack                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC_DT    (AL_HOLYLIGHT, SM_BASH, effective               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 4),
		AI_SKILL_USE_PROC_HEAL  (4                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC       (AL_HOLYWATER                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 4)
	)}, {JOB_SWORDMAN, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC       (SM_PROVOKE                                     ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (SM_PROVOKE, first_attack                       ,  1,  1, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (SM_PROVOKE, TF_THROWSTONE, crush               ,  1,  1, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (SM_BASH, disturb                               ,  6,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (SM_AUTOBERSERK                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_ENDURE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_TRUE , AF_TRUE , 3),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, enchant                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_MAGNUM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_BASH                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5)
	)}, {JOB_TAEKWON, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC_D     (TK_STORMKICK, TK_COUNTER                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (TK_TURNKICK, TK_COUNTER                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (TK_COUNTER                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (TK_DOWNKICK, TK_COUNTER                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (TK_READYSTORM, TK_READYCOUNTER                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (TK_READYTURN, TK_READYCOUNTER                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (TK_READYCOUNTER                                ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_D     (TK_READYDOWN, TK_READYCOUNTER                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (TK_DODGE                                       ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_RUN                                         ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  2,  2, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  3,  3, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  4,  4, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  5,  5, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  6,  6, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  7,  7, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_JUMPKICK                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_THIEF, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC_T     (TF_HIDING, deactivate                          ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_THROWSTONE, first_attack                    ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_THROWSTONE, crush                           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (TF_DETOXIFY                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_HIDING, activate                            ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TF_STEAL                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_POISON                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_SPRINKLESAND                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_PICKSTONE                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_WHITESMITH, initialize<ai_t::skill_use_proc_vector>(				 	 
		AI_SKILL_USE_PROC_T     (BS_MAXIMIZE, deactivate                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (BS_REPAIRWEAPON                                ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (BS_ADRENALINE2                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (BS_ADRENALINE                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (WS_CARTBOOST                                   ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MC_LOUD                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (BS_OVERTHRUST                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (BS_WEAPONPERFECT                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (WS_OVERTHRUSTMAX                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (WS_MELTDOWN                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (BS_MAXIMIZE, activate                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MC_CARTREVOLUTION                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (BS_HAMMERFALL                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_D     (WS_CARTTERMINATION, MC_MAMMONITE               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MC_MAMMONITE                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_WIZARD, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC       (WZ_FROSTNOVA                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FIREWALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (WZ_ICEWALL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FROSTDIVER                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_STONECURSE                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (WZ_QUAGMIRE                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_SAFETYWALL                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_ENERGYCOAT                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_SIGHT                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (WZ_FIREPILLAR                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (WZ_METEOR                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (WZ_VERMILION, MG_THUNDERSTORM                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_HEAVENDRIVE, MG_THUNDERSTORM                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_STORMGUST                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (WZ_STORMGUST, freeze                           ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (WZ_JUPITEL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_WATERBALL, MG_FIREBOLT                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBOLT                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_LIGHTNINGBOLT, MG_FIREBOLT                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_EARTHSPIKE, MG_FIREBOLT                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_COLDBOLT, MG_FIREBOLT                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_SOULSTRIKE, MG_NAPALMBEAT                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_DT    (WZ_WATERBALL, MG_FIREBOLT, compromise          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (MG_FIREBOLT, compromise                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_LIGHTNINGBOLT, MG_FIREBOLT, compromise      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (WZ_EARTHSPIKE, MG_FIREBOLT, compromise         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_COLDBOLT, MG_FIREBOLT, compromise           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_NAPALMBEAT                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)},
};

// AIにおけるメンバー一時スキル使用手続きのベクタ。
const ai_t::skill_use_proc_vector AI_MEMBER_TEMPORARY_SKILL_USE_PROCS = {
	AI_SKILL_USE_PROC_T     (TF_HIDING, deactivate                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
	AI_SKILL_USE_PROC       (LK_BERSERK                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC       (AL_CURE                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_DT    (ITM_TOMAHAWK, TF_THROWSTONE, first_attack,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_T     (TF_THROWSTONE, first_attack              ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_DT    (ITM_TOMAHAWK, TF_THROWSTONE, crush       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_T     (TF_THROWSTONE, crush                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_HEAL  (3                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC       (TF_DETOXIFY                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_T     (TF_HIDING, activate                      ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 3),
	AI_SKILL_USE_PROC       (WZ_FROSTNOVA                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC       (MG_FROSTDIVER                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
	AI_SKILL_USE_PROC       (MG_STONECURSE                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC       (MG_SIGHT                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
	AI_SKILL_USE_PROC_T     (SM_MAGNUM, enchant                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
	AI_SKILL_USE_PROC       (SM_MAGNUM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
	AI_SKILL_USE_PROC       (WZ_METEOR                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
	AI_SKILL_USE_PROC       (MG_FIREBALL                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
	AI_SKILL_USE_PROC       (TF_STEAL                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
	AI_SKILL_USE_PROC       (TF_POISON                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
	AI_SKILL_USE_PROC       (MG_FIREBOLT                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
	AI_SKILL_USE_PROC_D     (MG_COLDBOLT, MG_FIREBOLT                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
	AI_SKILL_USE_PROC_T     (MG_FIREBOLT, compromise                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
	AI_SKILL_USE_PROC_DT    (MG_COLDBOLT, MG_FIREBOLT, compromise     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
	AI_SKILL_USE_PROC       (KN_PIERCE                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
	AI_SKILL_USE_PROC       (SM_BASH                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
	AI_SKILL_USE_PROC       (TF_PICKSTONE                             ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 1),
	AI_SKILL_USE_PROC_HEAL  (4                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4)
};

// 味方スキルアドバンテージのマップ。
const std::unordered_map<e_skill,int> ALLY_SKILL_ADVANTAGES = {
	{MG_SAFETYWALL     ,   60},
	{PR_SANCTUARY      ,    2},
	{AL_PNEUMA         ,   50},
	{WZ_QUAGMIRE       ,  -20},
	{SA_VOLCANO        ,    1},
	{SA_DELUGE         ,    1},
	{SA_VIOLENTGALE    ,    1},
	{SA_LANDPROTECTOR  ,  100},
	{BD_LULLABY        ,   30},
	{BD_RICHMANKIM     ,   30},
	{BD_ETERNALCHAOS   ,   30},
	{BD_DRUMBATTLEFIELD,   30},
	{BD_RINGNIBELUNGEN ,   30},
	{BD_ROKISWEIL      ,   30},
	{BD_INTOABYSS      ,   30},
	{BD_SIEGFRIED      ,   30},
	{BA_DISSONANCE     ,   10},
	{BA_WHISTLE        ,   20},
	{BA_ASSASSINCROSS  ,   20},
	{BA_POEMBRAGI      ,   20},
	{BA_APPLEIDUN      ,   20},
	{DC_UGLYDANCE      ,   20},
	{DC_HUMMING        ,   10},
	{DC_DONTFORGETME   ,   20},
	{DC_FORTUNEKISS    ,   20},
	{DC_SERVICEFORYOU  ,   20},
	{PA_GOSPEL         , 1000},
	{HP_BASILICA       , 3000},
	{CG_MOONLIT        , 2000},
	{PF_FOGWALL        ,   40},
	{NJ_SUITON         ,    1},
};

// 矢/弾タイプ名のテーブル。
const std::array<
	std::string,  // 矢/弾タイプ名。
	MAX_AMMO_TYPE // 矢/弾タイプの数。
> AMMO_TYPE_NAME_TABLE = {
	UNKNOWN_SYMBOL,
	"矢"            ,            
	"投げナイフ"    ,    
	"銃弾"          ,          
	"弾丸"          ,          
	"グレネード"    ,    
	"手裏剣"        ,        
	"苦無"          ,          
	"キャノンボール",
	"投擲"          ,          
};

// 防具タイプ名のテーブル。
const std::array<
	std::string, // 防具タイプ名。
	EPO_MAX      // 装備部位順序の数。
> ARMOR_TYPE_NAME_TABLE = {
	"兜"          ,
	"鎧"          ,
	"盾"          ,
	UNKNOWN_SYMBOL,
	"肩にかける物",
	"靴"          ,
	"アクセサリー",
	"アクセサリー",
	"兜"          ,
	"兜"          ,
	"兜"          ,
	"兜"          ,
	"兜"          ,
	"肩にかける物",
	"矢/弾"       ,
};

// 寒いジョークを使用したときの発言のベクタ。
const std::vector<std::string> BA_FROSTJOKER_MESSAGES = {
	"ぶるぶるっ…ストームナイトさんストーブないの？",
	"牛族団のアジトは狭くてもう、ぎゅうぎゅうです",
	"念矢がもうねーんや！",
	"ピッキの目が光った！ピッキーん！！",
	"「どれ行く？」「船長！」",
	"「このウォーグは誰の？」「俺ンジャー！」",
	"アーチャーが矢を切らした。あちゃー!!!!!",
	"ジョークばっかりで演奏力がニブルヘイム!!",
	"夜でもヒルスリオン！",
	"風邪引いた！ゲフェンゲフェンっ！",
	"実は……ワンダラーになりたかったの……えへっ♪",
	"夏が俺サマーをよんでるぜ。",
	"スティール！おまえのハート1個獲得。",
	"鴨が葱背負ってきた、ウェルカモ。",
	"俺に触れるとヤケドするぜ！･･･って凍るんかい！",
	"ゼロピーの「ピー」は放送禁止用語です。",
	"教皇は今日来ない。",
	"イジドル買います！ 1＄で！",
	"ネペンテスが寝てんです！",
	"「君、本気で言ってる？」「マジです。バードですが」",
	"ウエポンパーへっくしょん！！",
	"導火線のお店！ ガジョマート！",
	"ごめんThe Sign！",
	"ヤカンが無い!! 万事キュウス!!",
	"俺だって俺だってこんなの言いたくねえよ！",
	"カタコンベで狩りしてると肩こんべ！",
	"ジョークが効かない！？ そんなパサナッ！！",
	"あっ!!前髪で前がみえない!!",
	"『深淵の騎士が禁煙』の記事。",
	"髪型をモヒカンにされた。もう悲観するしかない。",
	"俺が後100人いれば地球温暖化は防げるな！",
	"先生びっくりセンセーショナル。",
	"オットーが近くに沸いた。おっとー危ない。",
	"フェンの様子がフェンだ！",
	"モロクではいつもロクなことがない！",
	"紅茶を飲みティー。",
	"クモを食べるとスッパイダー！",
	"盗蟲が孵る途中。",
	"ポリンがポリンにポーリン（フォーリン）ラブ！",
	"ジャワイに行くんジャワイ。",
	"ロッカーと踊ろっかー。",
	"残影ですが今後ぅ貴公の鉄拳は見切りま指弾！！",
	"時計塔なら北の街にあるでばらん！！",
	"内股を打っちまった～！",
	"バンダナの出番だな！",
	"虎のふりしてトラブル！",
	"カートで殴られ、カーッとなる。",
	"ポーションを落とした、ポション！",
	"よーし、養子になろう。",
	"嫁の行動が読めん。",
	"ダンサーが段差で転んだんさー。",
	"サボテンがイラついている ムカー!!",
	"空はきれいでスカイ？",
	"仏の顔もサンドマン!!",
	"靴下を発掘した!!",
	"ホードの心の叫び「み、水ー！」",
	"おもちをお持ち帰り。",
	"アルミ缶の上にあるみかん！",
	"石はおいしい～",
	"板前さん、そこに居たまえ！",
	"馬はウマ～い。",
	"カレーは辛え！",
	"切手を切って♪",
	"教会に行くのは今日かい？",
	"コーディネートはこうでねぇと。",
	"このカレンダーは彼んだー",
	"猿が去る。",
	"誰も電話に出んわ。",
	"トイレに行っといれ。",
	"ナイスなイス。",
	"内容がないよー",
	"ブドウをひとつぶどう？",
	"布団がふっ飛んだ！",
	"メガネに目がねぇ。",
	"屋根はやーね。",
	"シャレを言うのはやめなしゃれ！",
	"ダジャレを言うのはだれじゃ～！",
	"今日の宴会はこの店でエンカイ？",
	"飲みすぎは肝臓にいカンゾウ。",
	"これは何の皿だ？サラダの皿だ！",
	"和尚が二人で、おしょうがツー。",
	"「隣の家にかこいが出来たってね」「かっこいー」",
	"「隣の空き地にへいが出来たってね」「へぇー」",
	"そのクレヨン、僕にくれよん。",
	"魚が驚いた。 ギョッ！",
	"「殺気がする！」「何、いつから!?」「さっきから」",
	"「時計が止まった」「ほっとけい」",
	"忍者は全部で何人じゃ？",
	"「本が１０冊ある」「あ、本当だ」",
	"壁に耳あり障子にメアリー",
	"「運動場へ行ってもいい？」「うん、どうじょ」",
	"「あなた、何歳？」「うるさい！」",
	"ぼっちゃんが池に落ちた。「ぼっちゃん」",
	"シャベルが喋る！",
	"妖怪に用かい？",
	"土管がドカん!!",
	"パンダのパンだ。",
	"このカッターどこでかったー？",
	"ソーダうまそーだー",
	"メジャーをそんなに伸ばしたら、ダメジャー！",
	"サメは泳ぎがとってもジョーズ！",
	"胡椒で故障！",
	"鯖を食べてサバイバル!!",
	"画家ががっかり!",
	"革は買わない。",
	"俺のカフェオレ～!",
	"蘭はいらん!!",
	"試験管を持つ試験官！",
	"鍵が見つからん……キィ～～～！",
	"このキャベツ虫がついてる。 キャー別のに変えて！",
	"クレヨンをくれよん。",
	"もなか食べようと思ったら、もうなかった～",
	"本が沈んでる……ぶっく、ぶっく！",
	"りんごがおぼれてる！ あっぷる、あっぷる!!",
	"ラブレター、やぶられたー！",
	"立派なスリッパ!!",
	"ベランダに植えたラベンダー",
};

// 戦闘モードフラグのテーブル。
const std::array<
	battle_mode_flags, // 戦闘モードのフラグ。
	BM_MAX             // 戦闘モード数。
> BATTLE_MODE_FLAG_TABLE = {
	BMF_NONE,
	BMF_TAUNT,
	BMF_ASSIST,
};

// @Botのサブコマンド説明のベクタ。
const std::vector<ptr<subcommand_desc>> BOT_SUBCMD_DESCS = {
	SUBCMD_DESC   (Bot, Attack                     , a   ,
		"------ Attack (a) サブコマンド ------\n"
		"モンスターを攻撃する。\n"
		"入力例 [@bot attack]\n"
		"特定のモンスターを攻撃する。\n"
		"入力例 [@bot attack プパ]\n"
	), SUBCMD_DESC(Bot, Cart                       , c   ,
		"------ Cart (c) サブコマンド ------\n"
		"カートのアイテムを一覧表示する。\n"
		"入力例 [@bot cart クリエ]\n"
	), SUBCMD_DESC(Bot, CartAutoGet                , cag ,
		"------ CartAutoGet (cag) サブコマンド ------\n"
		"カート自動補充アイテムを一覧表示する。\n"
		"入力例 [@bot cartautoget クリエ]\n"
		"カート自動補充アイテムを登録する。\n"
		"入力例 [@bot cartautoget クリエ ファイアーボトル]\n"
		"カート自動補充アイテムの登録を抹消する。\n"
		"入力例 [@bot cartautoget クリエ アシッドボトル]\n"
	), SUBCMD_DESC(Bot, CartAutoGetClear           ,     ,
		"------ CartAutoGetClear サブコマンド ------\n"
		"カート自動補充アイテムをクリアする。\n"
		"入力例 [@bot cartautogetclear クリエ]\n"
	), SUBCMD_DESC(Bot, CartAutoGetTransport       , cagt,
		"------ CartAutoGetTransport (cagt) サブコマンド ------\n"
		"カート自動補充アイテムを転送する。\n"
		"入力例 [@bot cartautogettransport クリエ スミス]\n"
	), SUBCMD_DESC(Bot, CartGet                    , cg  ,
		"------ CartGet (cg) サブコマンド ------\n"
		"カートからアイテムの全個数を取り出す。\n"
		"入力例 [@bot cartget クリエ ブルージェムストーン]\n"
		"カートからアイテムの特定個数を取り出す。\n"
		"入力例 [@bot cartget クリエ ブルージェムストーン 5]\n"
	), SUBCMD_DESC(Bot, CartPut                    , cp  ,
		"------ CartPut (cp) サブコマンド ------\n"
		"カートにアイテムの全個数を入れる。\n"
		"入力例 [@bot cartput クリエ ブルージェムストーン]\n"
		"カートにアイテムの特定個数を入れる。\n"
		"入力例 [@bot cartput クリエ ブルージェムストーン 5]\n"
	), SUBCMD_DESC(Bot, Equip                      , e   ,
		"------ Equip (e) サブコマンド ------\n"
		"武具を装備する。\n"
		"入力例 [@bot equip アサクロ \"スティレット [|] <+6>\"]\n"
		"武具の装備を解除する。\n"
		"入力例 [@bot equip アサクロ ブリーフ]\n"
		"すべての武具の装備を解除する。\n"
		"入力例 [@bot equip アサクロ]\n"
	), SUBCMD_DESC(Bot, EquipIdentifyAll           , eia ,
		"------ EquipIdentifyAll (eia) サブコマンド ------\n"
		"未鑑定の武具を鑑定する。\n"
		"入力例 [@bot equipidentifyall]\n"
	), SUBCMD_DESC(Bot, EquipRepairAll             , era ,
		"------ EquipRepairAll (era) サブコマンド ------\n"
		"破損した武具を修理する。\n"
		"入力例 [@bot equiprepairall]\n"
	), SUBCMD_DESC(Bot, EquipSet                   , es  ,
		"------ EquipSet (es) サブコマンド ------\n"
		"武具一式を一覧表示する。\n"
		"入力例 [@bot equipset アサクロ]\n"
		"武具一式を登録する。\n"
		"入力例 [@bot equipset アサクロ 基本]\n"
		"武具一式の登録を抹消する。\n"
		"入力例 [@bot equipset アサクロ 不死属性]\n"
	), SUBCMD_DESC(Bot, EquipSetClear              ,     ,
		"------ EquipSetClear サブコマンド ------\n"
		"武具一式をクリアする。\n"
		"入力例 [@bot equipsetclear アサクロ]\n"
	), SUBCMD_DESC(Bot, EquipSetLoad               , esl ,
		"------ EquipSetLoad (esl) サブコマンド ------\n"
		"武具一式をロードする。\n"
		"入力例 [@bot equipsetload アサクロ 地属性]\n"
	), SUBCMD_DESC(Bot, EquipSetTransport          , est ,
		"------ EquipSetTransport (est) サブコマンド ------\n"
		"武具一式を転送する。\n"
		"入力例 [@bot equipsettransport アサクロ チェイス]\n"
	), SUBCMD_DESC(Bot, Help                       , h   ,
		"------ Help (h) サブコマンド ------\n"
		"サブコマンドの説明を表示する。\n"
		"入力例 [@bot help login]\n"
	), SUBCMD_DESC(Bot, HoldMonsters               , hm  ,
		"------ HoldMonsters (hm) サブコマンド ------\n"
		"抱えることのできるモンスター数を設定する。\n"
		"入力例 [@bot holdmonsters クラウン 1]\n"
	), SUBCMD_DESC(Bot, HomunsKill                 , hk  ,
		"------ HomunsKill (hk) サブコマン     ド ------\n"
		"ホムンクルスのスキルを一覧表示する。\n"
		"入力例 [@bot homunskill クリエ]\n"
		"ホムンクルスがスキルを最高レベルで使用する。\n"
		"入力例 [@bot homunskill クリエ 治癒の手]\n"
		"ホムンクルスがスキルを特定レベルで使用する。\n"
		"入力例 [@bot homunskill クリエ カオティックベネディクション 3]\n"
	), SUBCMD_DESC(Bot, HomunsKillLimit            , hkl ,
		"------ HomunsKillLimit (hkl) サブコマンド ------\n"
		"ホムンクルスがスキルのレベルを制限する。\n"
		"入力例 [@bot homunskilllimit クリエ メンタルチェンジ 0]\n"
		"ホムンクルスがスキルのレベル制限を解除する。\n"
		"入力例 [@bot homunskilllimit クリエ メンタルチェンジ]\n"
	), SUBCMD_DESC(Bot, HomunsKillUp               , hku ,
		"------ HomunsKillUp (hku) サブコマンド ------\n"
		"ホムンクルスがスキルのレベルを上げる。\n"
		"入力例 [@bot homunskillup クリエ メンタルチェンジ]\n"
	), SUBCMD_DESC(Bot, HomunStatus                , hs  ,
		"------ HomunStatus (hs) サブコマンド ------\n"
		"ホムンクルスのステータスを表示する。\n"
		"入力例 [@bot homunstatus クリエ]\n"
	), SUBCMD_DESC(Bot, Item                       , i   ,
		"------ Item (i) サブコマンド ------\n"
		"所持アイテムを一覧表示する。\n"
		"入力例 [@bot item ハイプリ]\n"
		"アイテムを使用する。\n"
		"入力例 [@bot item ハイプリ 青ポーション]\n"
	), SUBCMD_DESC(Bot, ItemCount                  , ic  ,
		"------ ItemCount (ic) サブコマンド ------\n"
		"すべてのアイテムの集計を一覧表示する。\n"
		"入力例 [@bot itemcount]\n"
		"任意のアイテムの集計を一覧表示する。\n"
		"入力例 [@bot itemcount ゼロピー リンゴ 綿毛]\n"
	), SUBCMD_DESC(Bot, ItemDrop                   , id  ,
		"------ ItemDrop (id) サブコマンド ------\n"
		"アイテムの全個数をドロップする。\n"
		"入力例 [@bot itemdrop ハイプリ イグドラシルの葉]\n"
		"アイテムの特定個数をドロップする。\n"
		"入力例 [@bot itemdrop ハイプリ イグドラシルの葉 2]\n"
	), SUBCMD_DESC(Bot, ItemIgnore                 , ii  ,
		"------ ItemIgnore (ii) サブコマンド ------\n"
		"無視アイテムを一覧表示する。\n"
		"入力例 [@bot itemignore]\n"
		"無視アイテムを登録する。\n"
		"入力例 [@bot itemignore \"レザージャケット [1]\"]\n"
		"無視アイテムの登録を抹消する。\n"
		"入力例 [@bot itemignore ブリーフ]\n"
	), SUBCMD_DESC(Bot, ItemIgnoreClear            ,     ,
		"------ ItemIgnoreClear サブコマンド ------\n"
		"無視アイテムをクリアする。\n"
		"入力例 [@bot itemignoreclear]\n"
	), SUBCMD_DESC(Bot, ItemIgnoreImport           , iii ,
		"------ ItemIgnoreImport (iii) サブコマンド ------\n"
		"無視アイテムを取り込む。\n"
		"入力例 [@bot itemignoreimport チャンプ]\n"
	), SUBCMD_DESC(Bot, ItemRecoverHp              , irh ,
		"------ ItemRecoverHp (irh) サブコマンド ------\n"
		"HP回復アイテムを一覧表示する。\n"
		"入力例 [@bot itemrecoverhp アサクロ]\n"
		"HP回復アイテムを登録する。\n"
		"入力例 [@bot itemrecoverhp アサクロ 赤ポーション 50]\n"
		"HP回復アイテムの登録を抹消する。\n"
		"入力例 [@bot itemrecoverhp アサクロ 白ポーション]\n"
	), SUBCMD_DESC(Bot, ItemRecoverHpClear         ,     ,
		"------ ItemRecoverHpClear サブコマンド ------\n"
		"HP回復アイテムをクリアする。\n"
		"入力例 [@bot itemrecoverhpclear アサクロ]\n"
	), SUBCMD_DESC(Bot, ItemRecoverHpTransport     , irht,
		"------ ItemRecoverHpTransport (iht) サブコマンド ------\n"
		"HP回復アイテムを転送する。\n"
		"入力例 [@bot itemrecoverhptransport アサクロ チェイス]\n"
	), SUBCMD_DESC(Bot, ItemRecoverSp              , irs ,
		"------ ItemRecoverSp (is) サブコマンド ------\n"
		"SP回復アイテムを一覧表示する。\n"
		"入力例 [@bot itemrecoversp ハイプリ]\n"
		"SP回復アイテムを登録する。\n"
		"入力例 [@bot itemrecoversp ハイプリ 青ポーション 25]\n"
		"SP回復アイテムの登録を抹消する。\n"
		"入力例 [@bot itemrecoversp ハイプリ イチゴ]\n"
	), SUBCMD_DESC(Bot, ItemRecoverSpClear         ,     ,
		"------ ItemRecoverSpClear サブコマンド ------\n"
		"SP回復アイテムをクリアする。\n"
		"入力例 [@bot itemrecoverspclear ハイプリ]\n"
	), SUBCMD_DESC(Bot, ItemRecoverSpTransport     , irst,
		"------ ItemRecoverSpTransport (ist) サブコマンド ------\n"
		"SP回復アイテムを転送する。\n"
		"入力例 [@bot itemrecoversptransport ハイプリ チャンプ]\n"
	), SUBCMD_DESC(Bot, ItemSell                   , is  ,
		"------ ItemSell (is) サブコマンド ------\n"
		"売却アイテムを一覧表示する。\n"
		"入力例 [@bot itemsell]\n"
		"売却アイテムを登録する。\n"
		"入力例 [@bot itemsell \"ボウ [3]\"]\n"
		"売却アイテムの登録を抹消する。\n"
		"入力例 [@bot itemsell \"ハット [1]\"]\n"
	), SUBCMD_DESC(Bot, ItemSellAll                , isa ,
		"------ ItemSellAll (isa) サブコマンド ------\n"
		"アイテムを売却する。\n"
		"入力例 [@bot itemsellall]\n"
	), SUBCMD_DESC(Bot, ItemSellClear              ,     ,
		"------ ItemSellClear サブコマンド ------\n"
		"売却アイテムをクリアする。\n"
		"入力例 [@bot itemsellclear]\n"
	), SUBCMD_DESC(Bot, ItemSellImport             , isi ,
		"------ ItemSellImport (isi) サブコマンド ------\n"
		"売却アイテムを取り込む。\n"
		"入力例 [@bot itemsellimport スミス]\n"
	), SUBCMD_DESC(Bot, LogIn                      , li  ,
		"------ LogIn (li) サブコマンド ------\n"
		"Botをログインさせる。\n"
		"入力例 [@bot login acuser acpass アサクロ]\n"
	), SUBCMD_DESC(Bot, LogOut                     , lo  ,
		"------ LogOut (lo) サブコマンド ------\n"
		"Botをログアウトさせる。\n"
		"入力例 [@bot logout アサクロ]\n"
	), SUBCMD_DESC(Bot, Loot                       , l   ,
		"------ Loot (l) サブコマンド ------\n"
		"ドロップアイテムを拾うようにする。\n"
		"入力例 [@bot loot クリエ]\n"
		"ドロップアイテムを拾わないようにする。\n"
		"入力例 [@bot loot クリエ]\n"
	), SUBCMD_DESC(Bot, Memo                       , m   ,
		"------ Memo (m) サブコマンド ------\n"
		"現在の位置をメモする。\n"
		"入力例 [@bot memo ハイプリ]\n"
	), SUBCMD_DESC(Bot, MonsterGreat               , mg  ,
		"------ MonsterGreat (mg) サブコマンド ------\n"
		"グレートモンスターを一覧表示する。\n"
		"入力例 [@bot monstergreat]\n"
		"グレートモンスターを登録する。\n"
		"入力例 [@bot monstergreat モンスター]\n"
		"グレートモンスターの登録を抹消する。\n"
		"入力例 [@bot monstergreat モロクの現身（天使型）]\n"
	), SUBCMD_DESC(Bot, MonsterGreatClear          ,     ,
		"------ MonsterGreatClear サブコマンド ------\n"
		"グレートモンスターをクリアする。\n"
		"入力例 [@bot monstergreatclear]\n"
	), SUBCMD_DESC(Bot, MonsterGreatImport         , mgi ,
		"------ MonsterGreatImport (mgi) サブコマンド ------\n"
		"グレートモンスターを取り込む。\n"
		"入力例 [@bot monstergreatimport チェイス]\n"
	), SUBCMD_DESC(Bot, PetEquip                   , pe  ,
		"------ PetEquip (pe) サブコマンド ------\n"
		"ペットがアクセサリーを装備する。\n"
		"入力例 [@bot petequip クリエ]\n"
		"ペットがアクセサリーの装備を解除する。\n"
		"入力例 [@bot petequip クリエ]\n"
	), SUBCMD_DESC(Bot, PetStatus                  , ps  ,
		"------ PetStatus (ps) サブコマンド ------\n"
		"ペットのステータスを表示する。\n"
		"入力例 [@bot petstatus クリエ]\n"
	), SUBCMD_DESC(Bot, PolicyDistance             , pd  ,
		"------ PolicyDistance (pd) サブコマンド ------\n"
		"距離ポリシーを一覧表示する。\n"
		"入力例 [@bot policydistance ハイプリ]\n"
		"距離ポリシーを登録する。\n"
		"入力例 [@bot policydistance ハイプリ 基本 近接]\n"
		"距離ポリシーの登録を抹消する。\n"
		"入力例 [@bot policydistance ハイプリ グレート]\n"
	), SUBCMD_DESC(Bot, PolicyDistanceClear        ,     ,
		"------ PolicyDistanceClear サブコマンド ------\n"
		"距離ポリシーをクリアする。\n"
		"入力例 [@bot policydistanceclear ハイプリ]\n"
	), SUBCMD_DESC(Bot, PolicyDistanceTransport    , pdt  ,
		"------ PolicyDistanceTransport (pdt) サブコマンド ------\n"
		"距離ポリシーを転送する。\n"
		"入力例 [@bot policydistancetransport ハイプリ チャンプ]\n"
	), SUBCMD_DESC(Bot, PolicyNormalAttack         , pn  ,
		"------ PolicyNormalAttack (pn) サブコマンド ------\n"
		"通常攻撃ポリシーを一覧表示する。\n"
		"入力例 [@bot policynormalattack ハイプリ]\n"
		"通常攻撃ポリシーを登録する。\n"
		"入力例 [@bot policynormalattack ハイプリ 基本 連続]\n"
		"通常攻撃ポリシーの登録を抹消する。\n"
		"入力例 [@bot policynormalattack ハイプリ グレート]\n"
	), SUBCMD_DESC(Bot, PolicyNormalAttackClear    ,     ,
		"------ PolicyNormalAttackClear サブコマンド ------\n"
		"通常攻撃ポリシーをクリアする。\n"
		"入力例 [@bot policynormalattackclear ハイプリ]\n"
	), SUBCMD_DESC(Bot, PolicyNormalAttackTransport, pdt  ,
		"------ PolicyNormalAttackTransport (pdt) サブコマンド ------\n"
		"通常攻撃ポリシーを転送する。\n"
		"入力例 [@bot policynormalattacktransport ハイプリ チャンプ]\n"
	), SUBCMD_DESC(Bot, sKill                      , k   ,
		"------ sKill (k) サブコマンド ------\n"
		"スキルを一覧表示する。\n"
		"入力例 [@bot skill ハイプリ]\n"
		"自己スキルを最高レベルで使用する。\n"
		"入力例 [@bot skill ハイプリ マグニフィカート]\n"
		"自己スキルを特定レベルで使用する。\n"
		"入力例 [@bot skill ウルリン 暖かい風 3]\n"
		"ターゲットスキルを最高レベルで使用する。\n"
		"入力例 [@bot skill ハイプリ アスムプティオ アサクロ]\n"
		"ターゲットスキルを特定レベルで使用する。\n"
		"入力例 [@bot skill ハイプリ ヒール アサクロ 3]\n"
	), SUBCMD_DESC(Bot, sKillAutoSpell             , kas ,
		"------ sKillAutoSpell (kas) サブコマンド ------\n"
		"オートスペルで選択する魔法を設定する。\n"
		"入力例 [@bot skillautospell プロフェ ファイアーボルト]\n"
		"オートスペルで自由に魔法を選択するようにする。\n"
		"入力例 [@bot skillautospell プロフェ]\n"
	), SUBCMD_DESC(Bot, sKillFirst                  , kf  ,
		"------ sKillFirst (kf) サブコマンド ------\n"
		"優先スキルを一覧表示する。\n"
		"入力例 [@bot skillfirst ハイウィズ]\n"
		"優先スキルを登録する。\n"
		"入力例 [@bot skillfirst ハイウィズ 堕ちた大神官ヒバム ストームガスト]\n"
		"優先スキルの登録を抹消する。\n"
		"入力例 [@bot skillfirst ハイウィズ 堕ちた大神官ヒバム]\n"
	), SUBCMD_DESC(Bot, sKillFirstClear            ,     ,
		"------ sKillRejectClear サブコマンド ------\n"
		"優先スキルをsKillFirstClear。\n"
		"入力例 [@bot skillfirstclear ハイウィズ]\n"
	), SUBCMD_DESC(Bot, sKillFirstTransport        , kft ,
		"------ sKillFirstTransport (kft) サブコマンド ------\n"
		"優先スキルを転送する。\n"
		"入力例 [@bot skillfirsttransport ハイウィズ ハイウィズ2]\n"
	), SUBCMD_DESC(Bot, sKillLimit                 , kl  ,
		"------ sKillLimit (kl) サブコマンド ------\n"
		"スキルのレベルを制限する。\n"
		"入力例 [@bot skilllimit ハイプリ エンジェラス 0]\n"
		"スキルのレベル制限を解除する。\n"
		"入力例 [@bot skilllimit ハイプリ エンジェラス]\n"
	), SUBCMD_DESC(Bot, sKillLowRate               , klr ,
		"------ sKillLowRate (klr) サブコマンド ------\n"
		"低ダメージ倍率を設定する。\n"
		"入力例 [@bot skilllowrate プロフェ 50]\n"
	), SUBCMD_DESC(Bot, sKillMonsters              , km  ,
		"------ sKillMonsters (km) サブコマンド ------\n"
		"範囲スキルの発動条件となるモンスター数を設定する。\n"
		"入力例 [@bot skillmonsters ハイプリ 1]\n"
	), SUBCMD_DESC(Bot, sKillPlay                  , kp  ,
		"------ sKillPlay (kp) サブコマンド ------\n"
		"演奏スキルを一覧表示する。\n"
		"入力例 [@bot skillplay クラウン]\n"
		"演奏スキルを登録する。\n"
		"入力例 [@bot skillplay クラウン 基本 夕陽のアサシンクロス]\n"
		"演奏スキルの登録を抹消する。\n"
		"入力例 [@bot skillplay クラウン 休息]\n"
	), SUBCMD_DESC(Bot, sKillPlayClear             ,     ,
		"------ sKillPlayClear サブコマンド ------\n"
		"演奏スキルをクリアする。\n"
		"入力例 [@bot skillplayclear クラウン]\n"
	), SUBCMD_DESC(Bot, sKillPlayTransport         , kpt ,
		"------ sKillPlayTransport (kpt) サブコマンド ------\n"
		"演奏スキルを転送する。\n"
		"入力例 [@bot skillplaytransport クラウン ジプシー]\n"
	), SUBCMD_DESC(Bot, sKillReject                , kr  ,
		"------ sKillReject (kr) サブコマンド ------\n"
		"拒否スキルを一覧表示する。\n"
		"入力例 [@bot skillreject]\n"
		"拒否スキルを登録する。\n"
		"入力例 [@bot skillreject クラウン アスペルシオ]\n"
		"拒否スキルの登録を抹消する。\n"
		"入力例 [@bot skillreject クラウン イムポシティオマヌス]\n"
	), SUBCMD_DESC(Bot, sKillRejectClear           ,     ,
		"------ sKillRejectClear サブコマンド ------\n"
		"拒否スキルをクリアする。\n"
		"入力例 [@bot skillrejectclear クラウン]\n"
	), SUBCMD_DESC(Bot, sKillRejectTransport       , krt ,
		"------ sKillRejectTransport (krt) サブコマンド ------\n"
		"拒否スキルを転送する。\n"
		"入力例 [@bot skillrejecttransport クラウン ジプシー]\n"
	), SUBCMD_DESC(Bot, sKillSevenWind             , ksw ,
		"------ sKillSevenWind (ksw) サブコマンド ------\n"
		"暖かい風で選択する属性を設定する。\n"
		"入力例 [@bot skillsevenwind テコン 火属性]\n"
		"暖かい風で自由に属性を選択するようにする。\n"
		"入力例 [@bot skillsevenwind テコン]\n"
	), SUBCMD_DESC(Bot, sKillTail                  , kt  ,
		"------ sKillTail (kt) サブコマンド ------\n"
		"掛け直し時間を一覧表示する。\n"
		"入力例 [@bot skilltail ハイプリ]\n"
		"掛け直し時間を登録する。\n"
		"入力例 [@bot skilltail ハイプリ アスムプティオ 5000]\n"
		"掛け直し時間の登録を抹消する。\n"
		"入力例 [@bot skilltail ハイプリ アスムプティオ]\n"
	), SUBCMD_DESC(Bot, sKillTailClear            ,     ,
		"------ sKillTailClear サブコマンド ------\n"
		"掛け直し時間をクリアする。\n"
		"入力例 [@bot skilltailclear ハイプリ]\n"
	), SUBCMD_DESC(Bot, sKillTailTransport        , ktt ,
		"------ sKillTailTransport (ktt) サブコマンド ------\n"
		"掛け直し時間を転送する。\n"
		"入力例 [@bot skilltailtransport ハイプリ ハイプリ2]\n"
	), SUBCMD_DESC(Bot, sKillUp                    , ku  ,
		"------ sKillUp (ku) サブコマンド ------\n"
		"スキルのレベルを上げる。\n"
		"入力例 [@bot skillup ハイプリ メイス修練]\n"
	), SUBCMD_DESC(Bot, Status                     , s   ,
		"------ Status (s) サブコマンド ------\n"
		"ステータスを表示する。\n"
		"入力例 [@bot status アサクロ]\n"
	), SUBCMD_DESC(Bot, StatusUp                   , su  ,
		"------ StatusUp (su) サブコマンド ------\n"
		"ステータスに1ポイントを割り振る。\n"
		"入力例 [@bot statusup アサクロ str]\n"
		"ステータスに特定ポイントを割り振る。\n"
		"入力例 [@bot statusup アサクロ agi 5]\n"
	), SUBCMD_DESC(Bot, StorageGet                 , sg  ,
		"------ StorageGet (sg) サブコマンド ------\n"
		"倉庫補充アイテムを一覧表示する。\n"
		"入力例 [@bot storageget クリエ]\n"
		"倉庫補充アイテムを登録する。\n"
		"入力例 [@bot storageget クリエ 白ポーション 100]\n"
		"倉庫補充アイテムの登録を抹消する。\n"
		"入力例 [@bot storageget クリエ 白ポーション]\n"
	), SUBCMD_DESC(Bot, StorageGetAll              , sga ,
		"------ StorageGetAll (sga) サブコマンド ------\n"
		"倉庫からアイテムを取り出す。\n"
		"入力例 [@bot storagegetall]\n"
	), SUBCMD_DESC(Bot, StorageGetClear            ,     ,
		"------ StorageGetClear サブコマンド ------\n"
		"倉庫補充アイテムをクリアする。\n"
		"入力例 [@bot storagegetclear クリエ]\n"
	), SUBCMD_DESC(Bot, StorageGetTransport        , sgt ,
		"------ StorageGetTransport (sgt) サブコマンド ------\n"
		"倉庫補充アイテムを転送する。\n"
		"入力例 [@bot storagegettransport クリエ スミス]\n"
	), SUBCMD_DESC(Bot, StoragePut                 , sp  ,
		"------ StoragePut (sp) サブコマンド ------\n"
		"倉庫格納アイテムを一覧表示する。\n"
		"入力例 [@bot storageput]\n"
		"倉庫格納アイテムを登録する。\n"
		"入力例 [@bot storageput 白ハーブ]\n"
		"倉庫格納アイテムの登録を抹消する。\n"
		"入力例 [@bot storageput 蝶の羽]\n"
	), SUBCMD_DESC(Bot, StoragePutAll              , spa ,
		"------ StoragePutAll (spa) サブコマンド ------\n"
		"倉庫にアイテムを入れる。\n"
		"入力例 [@bot storageputall]\n"
	), SUBCMD_DESC(Bot, StoragePutClear            ,     ,
		"------ StoragePutClear サブコマンド ------\n"
		"倉庫格納アイテムをクリアする。\n"
		"入力例 [@bot storageputclear]\n"
	), SUBCMD_DESC(Bot, StoragePutImport           , spi ,
		"------ StoragePutImport (spi) サブコマンド ------\n"
		"倉庫格納アイテムを取り込む。\n"
		"入力例 [@bot storageputimport チェイス]\n"
	), SUBCMD_DESC(Bot, sUmmon                     , u   ,
		"------ sUmmon (u) サブコマンド ------\n"
		"すべてのBotを引き寄せる。\n"
		"入力例 [@bot summon]\n"
		"任意のBotを引き寄せる。\n"
		"入力例 [@bot summon クラウン プロフェ ハイプリ]\n"
	), SUBCMD_DESC(Bot, Team                       , t   ,
		"------ Team (t) サブコマンド ------\n"
		"メンバーを一覧表示する。\n"
		"入力例 [@bot team]\n"
	), SUBCMD_DESC(Bot, TeamLogIn                  , tli ,
		"------ TeamLogIn (tli) サブコマンド ------\n"
		"0番のチームをログインさせる。\n"
		"入力例 [@bot teamlogin]\n"
		"特定の番号のチームをログインさせる。\n"
		"入力例 [@bot teamlogin 3]\n"
	), SUBCMD_DESC(Bot, TeamLogOut                 , tlo ,
		"------ TeamLogOut (tlo) サブコマンド ------\n"
		"チームをログアウトさせる。\n"
		"入力例 [@bot teamlogout]\n"
	), SUBCMD_DESC(Bot, TeamNumber                 , tn  ,
		"------ TeamNumber (tn) サブコマンド ------\n"
		"チームの一覧を表示する。\n"
		"入力例 [@bot teamnumber]\n"
		"チームを登録する。\n"
		"入力例 [@bot teamnumber 3]\n"
		"チームを抹消する。\n"
		"入力例 [@bot teamnumber 3]\n"
	), SUBCMD_DESC(Bot, TeamOrder                  , to  ,
		"------ TeamOrder (to) サブコマンド ------\n"
		"メンバーの順番を変更する。\n"
		"入力例 [@bot teamorder クリエ アサクロ ハイプリ]\n"
	), SUBCMD_DESC(Bot, TeamPassive                , tp  ,
		"------ TeamPassive (tp) サブコマンド ------\n"
		"モンスターに反応しないようにする。\n"
		"入力例 [@bot teampassive]\n"
		"Botがモンスターに反応するようにする。\n"
		"入力例 [@bot teampassive]\n"
	), SUBCMD_DESC(Bot, TeamRush                   , tr  ,
		"------ TeamRush (tr) サブコマンド ------\n"
		"ラッシュモードになる。\n"
		"入力例 [@bot teamrush]\n"
		"ラッシュモードを解除する。\n"
		"入力例 [@bot teamrush]\n"
	), SUBCMD_DESC(Bot, TeamStay                   , ts  ,
		"------ TeamStay (ts) サブコマンド ------\n"
		"その場で待機するようにする。\n"
		"入力例 [@bot teamstay]\n"
		"リーダーを追いかけるようにする。\n"
		"入力例 [@bot teamstay]\n"
	), SUBCMD_DESC(Bot, TradeItem                  , ti  ,
		"------ TradeItem (ti) サブコマンド ------\n"
		"アイテムの全個数を取引に追加する。\n"
		"入力例 [@bot tradeitem ブルージェムストーン]\n"
		"アイテムの特定個数を取引に追加する。\n"
		"入力例 [@bot tradeitem ブルージェムストーン 3]\n"
	), SUBCMD_DESC(Bot, TradeZeny                  , tz  ,
		"------ TradeZeny (tz) サブコマンド ------\n"
		"所持金の全額を取引に追加する。\n"
		"入力例 [@bot tradezeny]\n"
		"所持金の特定額を取引に追加する。\n"
		"入力例 [@bot tradezeny 5000]\n"
	), SUBCMD_DESC(Bot, Warp                       , w   ,
		"------ Warp (w) サブコマンド ------\n"
		"ワープ位置を一覧表示する。\n"
		"入力例 [@bot warp ハイプリ]\n"
		"ワープポータルを開く。\n"
		"入力例 [@bot warp ハイプリ prt_fild08]\n"
	),
};

// @Botのサブコマンド手続きのベクタ。
const std::vector<ptr<subcommand_proc>> BOT_SUBCMD_PROCS = {
	SUBCMD_PROC(Bot, Attack                     , a   ),
	SUBCMD_PROC(Bot, Cart                       , c   ),
	SUBCMD_PROC(Bot, CartAutoGet                , cag ),
	SUBCMD_PROC(Bot, CartAutoGetClear           ,     ),
	SUBCMD_PROC(Bot, CartAutoGetTransport       , cagt),
	SUBCMD_PROC(Bot, CartGet                    , cg  ),
	SUBCMD_PROC(Bot, CartPut                    , cp  ),
	SUBCMD_PROC(Bot, Equip                      , e   ),
	SUBCMD_PROC(Bot, EquipIdentifyAll           , eia ),
	SUBCMD_PROC(Bot, EquipRepairAll             , era ),
	SUBCMD_PROC(Bot, EquipSet                   , es  ),
	SUBCMD_PROC(Bot, EquipSetClear              ,     ),
	SUBCMD_PROC(Bot, EquipSetLoad               , esl ),
	SUBCMD_PROC(Bot, EquipSetTransport          , est ),
	SUBCMD_PROC(Bot, Help                       , h   ),
	SUBCMD_PROC(Bot, HoldMonsters               , hm  ),
	SUBCMD_PROC(Bot, HomunsKill                 , hk  ),
	SUBCMD_PROC(Bot, HomunsKillLimit            , hkl ),
	SUBCMD_PROC(Bot, HomunsKillUp               , hku ),
	SUBCMD_PROC(Bot, HomunStatus                , hs  ),
	SUBCMD_PROC(Bot, Item                       , i   ),
	SUBCMD_PROC(Bot, ItemCount                  , ic  ),
	SUBCMD_PROC(Bot, ItemDrop                   , id  ),
	SUBCMD_PROC(Bot, ItemIgnore                 , ii  ),
	SUBCMD_PROC(Bot, ItemIgnoreClear            ,     ),
	SUBCMD_PROC(Bot, ItemIgnoreImport           , iii ),
	SUBCMD_PROC(Bot, ItemRecoverHp              , irh ),
	SUBCMD_PROC(Bot, ItemRecoverHpClear         ,     ),
	SUBCMD_PROC(Bot, ItemRecoverHpTransport     , irht),
	SUBCMD_PROC(Bot, ItemRecoverSp              , irs ),
	SUBCMD_PROC(Bot, ItemRecoverSpClear         ,     ),
	SUBCMD_PROC(Bot, ItemRecoverSpTransport     , irst),
	SUBCMD_PROC(Bot, ItemSell                   , is  ),
	SUBCMD_PROC(Bot, ItemSellAll                , isa ),
	SUBCMD_PROC(Bot, ItemSellClear              ,     ),
	SUBCMD_PROC(Bot, ItemSellImport             , isi ),
	SUBCMD_PROC(Bot, LogIn                      , li  ),
	SUBCMD_PROC(Bot, LogOut                     , lo  ),
	SUBCMD_PROC(Bot, Loot                       , l   ),
	SUBCMD_PROC(Bot, Memo                       , m   ),
	SUBCMD_PROC(Bot, MonsterGreat               , mg  ),
	SUBCMD_PROC(Bot, MonsterGreatClear          ,     ),
	SUBCMD_PROC(Bot, MonsterGreatImport         , mgi ),
	SUBCMD_PROC(Bot, PetEquip                   , pe  ),
	SUBCMD_PROC(Bot, PetStatus                  , ps  ),
	SUBCMD_PROC(Bot, PolicyDistance             , pd  ),
	SUBCMD_PROC(Bot, PolicyDistanceClear        ,     ),
	SUBCMD_PROC(Bot, PolicyDistanceTransport    , pdt ),
	SUBCMD_PROC(Bot, PolicyNormalAttack         , pna ),
	SUBCMD_PROC(Bot, PolicyNormalAttackClear    ,     ),
	SUBCMD_PROC(Bot, PolicyNormalAttackTransport, pnat),
	SUBCMD_PROC(Bot, sKill                      , k   ),
	SUBCMD_PROC(Bot, sKillLimit                 , kl  ),
	SUBCMD_PROC(Bot, sKillAutoSpell             , kas ),
	SUBCMD_PROC(Bot, sKillFirst                 , kf  ),
	SUBCMD_PROC(Bot, sKillFirstClear            ,     ),
	SUBCMD_PROC(Bot, sKillFirstTransport        , kft ),
	SUBCMD_PROC(Bot, sKillLowRate               , klr ),
	SUBCMD_PROC(Bot, sKillMonsters              , km  ),
	SUBCMD_PROC(Bot, sKillSevenWind             , ksw ),
	SUBCMD_PROC(Bot, sKillPlay                  , kp  ),
	SUBCMD_PROC(Bot, sKillPlayClear             ,     ),
	SUBCMD_PROC(Bot, sKillPlayTransport         , kpt ),
	SUBCMD_PROC(Bot, sKillReject                , kr  ),
	SUBCMD_PROC(Bot, sKillRejectClear           ,     ),
	SUBCMD_PROC(Bot, sKillRejectTransport       , krt ),
	SUBCMD_PROC(Bot, sKillTail                  , kt  ),
	SUBCMD_PROC(Bot, sKillTailClear             ,     ),
	SUBCMD_PROC(Bot, sKillTailTransport         , ktt ),
	SUBCMD_PROC(Bot, sKillUp                    , ku  ),
	SUBCMD_PROC(Bot, Status                     , s   ),
	SUBCMD_PROC(Bot, StatusUp                   , su  ),
	SUBCMD_PROC(Bot, StorageGet                 , sg  ),
	SUBCMD_PROC(Bot, StorageGetAll              , sga ),
	SUBCMD_PROC(Bot, StorageGetClear            ,     ),
	SUBCMD_PROC(Bot, StorageGetTransport        , sgt ),
	SUBCMD_PROC(Bot, StoragePut                 , sp  ),
	SUBCMD_PROC(Bot, StoragePutAll              , spa ),
	SUBCMD_PROC(Bot, StoragePutClear            ,     ),
	SUBCMD_PROC(Bot, StoragePutImport           , spi ),
	SUBCMD_PROC(Bot, sUmmon                     , u   ),
	SUBCMD_PROC(Bot, Team                       , t   ),
	SUBCMD_PROC(Bot, TeamLogIn                  , tli ),
	SUBCMD_PROC(Bot, TeamLogOut                 , tlo ),
	SUBCMD_PROC(Bot, TeamNumber                 , tn  ),
	SUBCMD_PROC(Bot, TeamOrder                  , to  ),
	SUBCMD_PROC(Bot, TeamPassive                , tp  ),
	SUBCMD_PROC(Bot, TeamRush                   , tr  ),
	SUBCMD_PROC(Bot, TeamStay                   , ts  ),
	SUBCMD_PROC(Bot, TradeItem                  , ti  ),
	SUBCMD_PROC(Bot, TradeZeny                  , tz  ),
	SUBCMD_PROC(Bot, Warp                       , w   ),
};

// 装備の破損を示すタグ。
const std::string BROKEN_EQUIP_TAG = "破損";

// カード名の接尾辞。
const std::string CARD_NAME_POSTFIX = "カード";

// 砦の試練のNPC名。
const std::string CASTLE_TRIAL_NPC_NAME = "CastleTrial";

// 警戒を示すタグ。
const std::string CAUTION_TAG = "警戒";

// 衣装装備の接頭辞。
const std::string COSTUME_PREFIX = "[衣装] ";

// デフォルト距離ポリシー値のマップ。
const std::unordered_map<
	e_job,                 // 職業。
	distance_policy_values // 距離ポリシー値。
> DEFAULT_DISTANCE_POLICY_VALUES = {
	{JOB_NOVICE        , DPV_CLOSE},
	{JOB_SWORDMAN      , DPV_CLOSE},
	{JOB_MAGE          , DPV_AWAY },
	{JOB_ARCHER        , DPV_AWAY },
	{JOB_ACOLYTE       , DPV_AWAY },
	{JOB_MERCHANT      , DPV_CLOSE},
	{JOB_THIEF         , DPV_CLOSE},
	{JOB_KNIGHT        , DPV_CLOSE},
	{JOB_PRIEST        , DPV_AWAY },
	{JOB_WIZARD        , DPV_AWAY },
	{JOB_BLACKSMITH    , DPV_CLOSE},
	{JOB_HUNTER        , DPV_AWAY },
	{JOB_ASSASSIN      , DPV_CLOSE},
	{JOB_CRUSADER      , DPV_CLOSE},
	{JOB_MONK          , DPV_CLOSE},
	{JOB_SAGE          , DPV_AWAY },
	{JOB_ROGUE         , DPV_CLOSE},
	{JOB_ALCHEMIST     , DPV_CLOSE},
	{JOB_BARD          , DPV_AWAY },
	{JOB_DANCER        , DPV_AWAY },
	{JOB_SUPER_NOVICE  , DPV_CLOSE},
	{JOB_GUNSLINGER    , DPV_AWAY },
	{JOB_NINJA         , DPV_CLOSE},
	{JOB_LORD_KNIGHT   , DPV_CLOSE},
	{JOB_HIGH_PRIEST   , DPV_AWAY },
	{JOB_HIGH_WIZARD   , DPV_AWAY },
	{JOB_WHITESMITH    , DPV_CLOSE},
	{JOB_SNIPER        , DPV_AWAY },
	{JOB_ASSASSIN_CROSS, DPV_CLOSE},
	{JOB_PALADIN       , DPV_CLOSE},
	{JOB_CHAMPION      , DPV_CLOSE},
	{JOB_PROFESSOR     , DPV_AWAY },
	{JOB_STALKER       , DPV_CLOSE},
	{JOB_CREATOR       , DPV_CLOSE},
	{JOB_CLOWN         , DPV_AWAY },
	{JOB_GYPSY         , DPV_AWAY },
	{JOB_TAEKWON       , DPV_CLOSE},
	{JOB_STAR_GLADIATOR, DPV_CLOSE},
	{JOB_SOUL_LINKER   , DPV_AWAY },
};

// デフォルト通常攻撃ポリシー値のマップ。
const std::unordered_map<
	e_job,                      // 職業。
	normal_attack_policy_values // 通常攻撃ポリシー値。
> DEFAULT_NORMAL_ATTACK_POLICY_VALUES = {
	{JOB_NOVICE        , NAPV_CONTINUOUS},
	{JOB_SWORDMAN      , NAPV_CONTINUOUS},
	{JOB_MAGE          , NAPV_SINGLE    },
	{JOB_ARCHER        , NAPV_CONTINUOUS},
	{JOB_ACOLYTE       , NAPV_SINGLE    },
	{JOB_MERCHANT      , NAPV_CONTINUOUS},
	{JOB_THIEF         , NAPV_CONTINUOUS},
	{JOB_KNIGHT        , NAPV_CONTINUOUS},
	{JOB_PRIEST        , NAPV_SINGLE    },
	{JOB_WIZARD        , NAPV_SINGLE    },
	{JOB_BLACKSMITH    , NAPV_CONTINUOUS},
	{JOB_HUNTER        , NAPV_CONTINUOUS},
	{JOB_ASSASSIN      , NAPV_CONTINUOUS},
	{JOB_CRUSADER      , NAPV_CONTINUOUS},
	{JOB_MONK          , NAPV_CONTINUOUS},
	{JOB_SAGE          , NAPV_SINGLE    },
	{JOB_ROGUE         , NAPV_CONTINUOUS},
	{JOB_ALCHEMIST     , NAPV_CONTINUOUS},
	{JOB_BARD          , NAPV_SINGLE    },
	{JOB_DANCER        , NAPV_SINGLE    },
	{JOB_SUPER_NOVICE  , NAPV_CONTINUOUS},
	{JOB_GUNSLINGER    , NAPV_CONTINUOUS},
	{JOB_NINJA         , NAPV_CONTINUOUS},
	{JOB_LORD_KNIGHT   , NAPV_CONTINUOUS},
	{JOB_HIGH_PRIEST   , NAPV_SINGLE    },
	{JOB_HIGH_WIZARD   , NAPV_SINGLE    },
	{JOB_WHITESMITH    , NAPV_CONTINUOUS},
	{JOB_SNIPER        , NAPV_CONTINUOUS},
	{JOB_ASSASSIN_CROSS, NAPV_CONTINUOUS},
	{JOB_PALADIN       , NAPV_CONTINUOUS},
	{JOB_CHAMPION      , NAPV_CONTINUOUS},
	{JOB_PROFESSOR     , NAPV_SINGLE    },
	{JOB_STALKER       , NAPV_CONTINUOUS},
	{JOB_CREATOR       , NAPV_CONTINUOUS},
	{JOB_CLOWN         , NAPV_SINGLE    },
	{JOB_GYPSY         , NAPV_SINGLE    },
	{JOB_TAEKWON       , NAPV_CONTINUOUS},
	{JOB_STAR_GLADIATOR, NAPV_CONTINUOUS},
	{JOB_SOUL_LINKER   , NAPV_SINGLE    },
};

// デフォルトの低ダメージ倍率。
const int DEFAULT_SKILL_LOW_RATE = 100;

// デフォルトの範囲スキルの発動条件となるモンスター数。
const int DEFAULT_SKILL_MONSTERS = 3;

// 距離ポリシー値名のテーブル。
const std::array<
	std::string, // 距離ポリシー値名。
	DPV_MAX      // 距離ポリシー値の数。
> DISTANCE_POLICY_VALUE_NAME_TABLE = {
	UNKNOWN_SYMBOL,
	"近接"        ,
	"遠隔"        ,
};

// ダブルフィーバーマップの数。
const int DOUBLE_FEVER_MAPS_SIZE = 2;

// 属性名のテーブル。
const std::array<
	std::string, // 属性名。
	10           // 属性の数。
> ELEMENT_NAME_TABLE = {
	"無属性"  ,
	"水属性"  ,
	"地属性"  ,
	"火属性"  ,
	"風属性"  ,
	"毒属性"  ,
	"聖属性"  ,
	"闇属性"  ,
	"念属性"  ,
	"不死属性",
};

// 属性場スキルユニットキーのマップ。
const skill_unit_key_map ELEMENTAL_SKILL_UNIT_KEYS = {
	SKILL_UNIT_KEY(NJ_KAENSIN),
	SKILL_UNIT_KEY(NJ_SUITON),
	SKILL_UNIT_KEY(SA_DELUGE),
	SKILL_UNIT_KEY(SA_LANDPROTECTOR),
	SKILL_UNIT_KEY(SA_VIOLENTGALE),
	SKILL_UNIT_KEY(SA_VOLCANO),
};

// 敵スキルアドバンテージのマップ。
const std::unordered_map<e_skill,int> ENEMY_SKILL_ADVANTAGES = {
	{MG_SAFETYWALL   ,    60},
	{AL_PNEUMA       ,    50},
	{WZ_QUAGMIRE     ,   -20},
	{AM_DEMONSTRATION, -1000},
	{AS_VENOMDUST    ,    -1},
	{SA_LANDPROTECTOR,   100},
	{NPC_EVILLAND    ,  -100},
};

// 装備部位の順序を装備部位のインデックスに変換するテーブル。
const std::array<
	equip_index, // 装備部位のインデックス。
	EPO_MAX      // 装備部位の順序の数。
> EPO2EQI_TABLE {
	EQI_HEAD_TOP        ,
	EQI_ARMOR           ,   
	EQI_HAND_L          ,	 
	EQI_HAND_R          ,
	EQI_GARMENT         ,
	EQI_SHOES           ,
	EQI_ACC_L           ,
	EQI_ACC_R           ,
	EQI_HEAD_MID        ,
	EQI_HEAD_LOW        ,
	EQI_COSTUME_HEAD_TOP,
	EQI_COSTUME_HEAD_MID,
	EQI_COSTUME_HEAD_LOW,
	EQI_COSTUME_GARMENT ,
	EQI_AMMO            ,
};

// 装備部位名のテーブル。
const std::array<
	std::string, // 装備部位名。
	EQI_MAX      // 装備部位の数。
> EQUIP_POS_NAME_TABLE = {
	"左ア"   ,
	"右ア"   ,
	"足"     ,
	"肩"     ,
	"頭下"   ,
	"頭中"   ,
	"頭上"   ,
	"体"     ,
	"左手"   ,
	"右手"   ,
	"衣頭上" ,
	"衣頭中" ,
	"衣頭下" ,
	"衣肩"   ,
	"矢/弾"  ,
	"影体"   ,
	"影右手" ,
	"影左手" ,
	"影足"   ,
	"影右ア" ,
	"影左ア" ,
};

// 名声付きであることを示すオフセット。
const int FAME_OFFSET = 30000;

// 名声付きであることを示すタグ。
const std::string FAME_TAG = "名声付き";

// フィーバー倍率のキー。
const std::string FEVER_RATE_KEY = "FEVER_RATE";

// グレート状態変化タイプのセット。
const sc_type_set GREAT_SC_TYPES = {
	SC_ADRENALINE,
	SC_REFLECTSHIELD,
	SC_SPEEDUP1,
	SC_TWOHANDQUICKEN,
};

// ギルド倉庫利用料。
const int GUILD_STORAGE_FEE = 200;

// ホムンクルススキルによるアイコン名のマップ。
const std::unordered_map<
	sc_type,    // 状態変化のタイプ。
	std::string // アイコン名。
> HOMUN_ICON_NAMES = {
	{SC_AVOID    , "緊急回避"          },
	{SC_BLOODLUST, "ブラッドラスト"    },
	{SC_CHANGE   , "メンタルチェンジ"  },
	{SC_DEFENCE  , "ディフェンス"      },
	{SC_FLEET    , "フリットムーブ"    },
	{SC_SPEED    , "オーバードスピード"},
};

// アイコン名のテーブル。
const std::array<
	std::string, // アイコン名
	EFST_MAX     // アイコンの数。
> ICON_NAME_TABLE = {
	"プロボック",
	"インデュア",
	"ツーハンドクイッケン",
	"集中力向上",
	"ハイディング",
	"クローキング",
	"武器属性付与",
	"ポイズンリアクト",
	"クァグマイア",
	"エンジェラス",
	"ブレッシング",
	"シグナムクルシス",
	"速度増加",
	"速度減少",
	"スローポイズン",
	"イムポシティオマヌス",
	"サフラギウム",
	"武器属性付与",
	"鎧属性付与",
	"キリエエレイソン",
	"マグニフィカート",
	"グロリア",
	"レックスエーテルナ",
	"アドレナリンラッシュ",
	"ウェポンパーフェクション",
	"オーバートラスト",
	"マキシマイズパワー",
	"騎乗中",
	"ファルコンマスタリー",
	"死んだふり",
	"ラウドボイス",
	"エナジーコート",
	"鎧破壊状態",
	"武器破壊状態",
	"幻覚状態",
	"重量50%以上",
	"重量90%以上",
	"攻撃速度増加",
	"攻撃速度増加",
	"攻撃速度増加",
	UNKNOWN_SYMBOL,
	"移動速度増加",
	"移動速度増加",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"武器解除状態",
	"盾解除状態",
	"鎧解除状態",
	"兜解除状態",
	"ケミカルウェポンチャージ",
	"ケミカルシールドチャージ",
	"ケミカルアーマーチャージ",
	"ケミカルヘルムチャージ",
	"オートガード",
	"リフレクトシールド",
	UNKNOWN_SYMBOL,
	"プロヴィデンス",
	"ディフェンダー",
	UNKNOWN_SYMBOL,
	"武器属性付与",
	"オートスペル",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"スピアクイッケン",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"金剛",
	"阿修羅覇凰拳",
	UNKNOWN_SYMBOL,
	"武器属性付与",
	"武器属性付与",
	"武器属性付与",
	"武器属性付与",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"鎧属性付与",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"パリイング",
	UNKNOWN_SYMBOL,
	"テンションリラックス",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"アスムプティオ",
	UNKNOWN_SYMBOL,
	"ジェムストーンの消費なしで",
	UNKNOWN_SYMBOL,
	"エンチャントデッドリーポイズン",
	"トゥルーサイト",
	"ウィンドウォーク",
	"メルトダウン",
	"カートブースト",
	UNKNOWN_SYMBOL,
	"リジェクトソード",
	"マリオネットコントロール",
	"マリオネットコントロール",
	UNKNOWN_SYMBOL,
	"出血状態",
	"ジョイントビート",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"ママ、パパ大好き",
	UNKNOWN_SYMBOL,
	"オートバーサーク",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"フェオリチャギの構え",
	UNKNOWN_SYMBOL,
	"ネリョチャギの構え",
	UNKNOWN_SYMBOL,
	"トルリョチャギの構え",
	UNKNOWN_SYMBOL,
	"アプチャオルリギの構え",
	UNKNOWN_SYMBOL,
	"落法",
	UNKNOWN_SYMBOL,
	"スパート",
	"武器属性付与",
	"フルアドレナリンラッシュ",
	"武器属性付与",
	UNKNOWN_SYMBOL,
	"[SP]Atk上昇",
	"[SP]Matk上昇",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"カイゼル",
	"カアヒ",
	"カウプ",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"ワンハンドクイッケン",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"太陽の安楽",
	"月の安楽",
	"星の安楽",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"プリザーブ",
	"チェイスウォーク",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"ダブルキャスティング",
	UNKNOWN_SYMBOL,
	"オーバートラストマックス",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"運命のタロットカード",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"シュリンク",
	"サイトブラスター",
	UNKNOWN_SYMBOL,
	"クローズコンファイン",
	"クローズコンファイン",
	UNKNOWN_SYMBOL,
	"マッドネスキャンセラー",
	"ガトリングフィーバー",
	"楽しい状態",
	"空蝉",
	"影分身",
	"念",
	"アジャストメント",
	"インクリージングアキュラシー",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"騎乗中",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"料理",
	"料理",
	"料理",
	"料理",
	"料理",
	"料理",
	"料理",
	"料理",
	"料理",
	"獲得経験値増加",
	"[SP]生命保険証",
	"ドロップ率増加",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"[SP]Str増加",
	"[SP]Agi増加",
	"[SP]Vit増加",
	"[SP]Dex増加",
	"[SP]Int増加",
	"[SP]Luk増加",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"スローキャスト",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"致命的な傷",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"移動速度増加",
	"物理防御力増加ポーション",
	"魔法防御力増加ポーション",
	"回復力増加ポーション",
	"小型生命水",
	"中型生命水",
	"研磨剤",
	"歓迎のさかずき",
	"ディファンダン",
	"メンタルポーション",
	"テチョンダン",
	"SP消費量減少ポーション",
	UNKNOWN_SYMBOL,
	"鎧属性変更スクロール",
	UNKNOWN_SYMBOL,
	"ヘルの権能",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"獲得経験値増加",
	"吹け！春風！",
	"天使の守護",
	UNKNOWN_SYMBOL,
	"[SP]ブラギポーション",
	UNKNOWN_SYMBOL,
	"リフレッシュ",
	"ジャイアントグロース",
	"ストーンハードスキン",
	"バイタリティアクティベーション",
	"ファイティングスピリット",
	"アバンダンス",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"クローキングエクシード",
	"ハルシネーションウォーク",
	UNKNOWN_SYMBOL,
	"レノヴァティオ",
	"ウェポンブロッキング",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"エクスピアティオ",
	"ポイズニングウェポン",
	"トキシン",
	"パラライズ",
	"ベナムブリード",
	"マジックマッシュルーム",
	"デスハート",
	"パイアレクシア",
	"オブリビオンカース",
	"リーチエンド",
	UNKNOWN_SYMBOL,
	"氷結状態",
	"フィアーブリーズ",
	UNKNOWN_SYMBOL,
	"マーシュオブアビス",
	"リコグナイズドスペル",
	"ステイシス状態",
	"ウォーグ騎乗中",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"アクセラレーション",
	"ホバーリング",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"タオグンカスクロール",
	"ミストレススクロール",
	"オークヒーロースクロール",
	"オークロードスクロール",
	UNKNOWN_SYMBOL,
	"オーバーヒート状態",
	"シェイプシフト",
	"インフラレッドスキャン",
	"マグネティックフィールド状態",
	"ニュートラルバリアー",
	UNKNOWN_SYMBOL,
	"ステルスフィールド",
	UNKNOWN_SYMBOL,
	"マヌクの豪気",
	"マヌクの意志",
	"ピンギキュラの果実ジャム",
	"ルシオラヴェスパのハチ蜜",
	"リプロデュース",
	"マヌクの信念",
	"コルヌスの涙",
	"Str増加スクロール",
	"Int増加スクロール",
	"[SP]レジストウィンドポーション",
	"フォースオブバンガード",
	UNKNOWN_SYMBOL,
	"オートシャドウスペル",
	"シャドウフォーム",
	UNKNOWN_SYMBOL,
	"[SP]HP増加ポーション",
	"[SP]SP増加ポーション",
	"シールドスペルLv3",
	"ボディペインティング",
	"イクシードブレイク",
	"アドラムス",
	"[SP]レジストファイアーポーション",
	"インビジビリティ",
	"デッドリーインフェクト",
	"バンディング",
	UNKNOWN_SYMBOL,
	"[SP]レジストアースポーション",
	"マスカレード：エナベーション",
	"マスカレード：グルーミー",
	"潜龍昇天",
	"マスカレード：イグノアランス",
	"マスカレード：レイジーネス",
	"閃電歩",
	"アカラジェ",
	"マスカレード：アンラッキー",
	UNKNOWN_SYMBOL,
	"呪縛陣状態",
	"マスカレード：ウィークネス",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"アクセサリー解除状態",
	UNKNOWN_SYMBOL,
	"教皇のクッキー",
	UNKNOWN_SYMBOL,
	"点穴-球-",
	"点穴-反-",
	"点穴-活-",
	UNKNOWN_SYMBOL,
	"スイングダンス",
	"恋人たちの為のシンフォニー",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"循環する自然の音",
	"冷凍状態",
	"メランコリー",
	"マナの歌",
	UNKNOWN_SYMBOL,
	"ダンスウィズウォーグ",
	"風車に向かって突撃",
	"エコーの歌",
	"ハーモナイズ",
	"ストライキング",
	"ウォーマー",
	"月明かりのセレナーデ",
	"狂乱状態",
	UNKNOWN_SYMBOL,
	"アナライズ",
	"レーラズの霧",
	"メロディーオブシンク",
	"ビヨンドオブウォークライ",
	"エンドレスハミングボイス",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"カートブースト",
	UNKNOWN_SYMBOL,
	"ソーントラップ",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"精神衝撃状態",
	UNKNOWN_SYMBOL,
	"サクラメント",
	"[SP]アスムプティオ",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"腹痛状態",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"HP増加ポーション",
	"SP増加ポーション",
	"濃縮ホワイトポーションZ",
	"ビタタ500",
	"濃縮サラマインジュース",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"バキュームエクストリーム状態",
	"サベージの丸焼き",
	"カクテルウォーグブラッド",
	"ミノタウロスのカルビ",
	"シロマアイスティー",
	"ドロセラのハーブ煮",
	"プティットのしっぽ麺",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"モーラベリー",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"ペインキラー",
	"迅速な命の水",
	"活性化ポーション",
	"再生の光",
	"オーバードブースト",
	UNKNOWN_SYMBOL,
	"オーディンの力",
	"スタイルチェンジ",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"マグマフロー",
	"グラニティックアーマー",
	"パイロクラスティック",
	"火山灰状態",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"魔法キャンデー",
	UNKNOWN_SYMBOL,
	"騎乗中",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"マクロディレイ",
	UNKNOWN_SYMBOL,
	"サポート魔法",
	UNKNOWN_SYMBOL,
	"クラッシュストライク",
	"変身中",
	"座る",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"マクロ",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"回復不能状態",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"[SP]Def固定",
	"[SP]Mdef固定",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"明鏡止水",
	"[SP]ASPD強化ポーション",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"応援爆竹",
	UNKNOWN_SYMBOL,
	"[SP]レジストコールドポーション",
	UNKNOWN_SYMBOL,
	"幻術_-影踏み-",
	"幻術_-虚無の影-",
	"幻術_-分身-",
	"幻術_-残月-",
	"古代精霊のお守り",
	"幻術_-朧幻想-",
	"幻術_-紅月-",
	UNKNOWN_SYMBOL,
	"戦闘薬",
	"高級戦闘薬",
	"レッドブースター",
	UNKNOWN_SYMBOL,
	"ミスティックパウダー",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"神妙な命の水",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"ふんだんなの花つの",
	"守護の光",
	"力の加護",
	"魔法の盾",
	"聖なる力",
	"不思議な力",
	"ステータス増加",
	"守護の力",
	"HPSP増加",
	UNKNOWN_SYMBOL,
	"攻撃力増加",
	"霜巨人の血",
	"ゴーレムの核",
	"妖精の涙（スタン）",
	"妖精の涙（石化）",
	"妖精の涙（凍結）",
	"妖精の涙（睡眠）",
	"妖精の涙（呪い）",
	"妖精の涙（沈黙）",
	"妖精の涙（暗黒）",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"ヒーロータイム",
	"ヒーローパワーチャージ",
	"キノコフリーク",
	"小人化",
	UNKNOWN_SYMBOL,
	"リディアの応援",
	"ロキの応援",
	"ケイオスの応援",
	"未精製エネルギー",
	"精製されたエネルギー",
	"高純度エネルギー",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"フェンリルの力",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"フリッグの歌",
	"オフェルトリウム",
	"テレキネシスインテンス",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"フルスロットル",
	"リバウンド",
	"アンリミット",
	"キングスグレイス",
	"MAX_ATK",
	"MIN_ATK",
	"MAX_MATK",
	"MIN_MATK",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"ダーククロー",
	"No_Text",
	"No_Text",
	"No_Text",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"永久霜",
	"獄炎呪",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"No_Text",
	"No_Text",
	"No_Text",
	"No_Text",
	"No_Text",
	"No_Text",
	"No_Text",
	"No_Text",
	"No_Text",
	"No_Text",
	"ボザのコップ",
	"バインド状態",
	"エターナルチェーン",
	UNKNOWN_SYMBOL,
	"烙印状態",
	"リモート爆弾",
	UNKNOWN_SYMBOL,
	"プラチナムアルター",
	"ヒートバレル",
	"アンチマテリアルブラスト",
	UNKNOWN_SYMBOL,
	"ソードクラン",
	"アークワンドクラン",
	"ゴールデンメイスクラン",
	"クロスボウクラン",
	"闇の王冠",
	"光の王冠",
	"霧の王冠",
	"劫火の加護",
	"霧氷の加護",
	"劈風の加護",
	"豊穣の加護",
	"死の呪い",
	"竜の眷属",
	"邪眼の呪い",
	"黄昏",
	"端午の節句",
	"ヒートバレルペナルティ",
	UNKNOWN_SYMBOL,
	"台湾イベントバフ",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"スペアリブ",
	"No_Text",
	"月の加護",
	"火の加護",
	"水の加護",
	"木の加護",
	"金の加護",
	"里の加護",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"ジャンピングクラン",
	"サポート魔法",
	"リリーフポーション",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"皇帝への献身",
	"魔力空間",
	"ガチャドラの加護",
	"ガチャドラの加護",
	"ガチャドラの加護",
	"ガチャドラの加護",
	"ガチャドラの加護",
	"ガチャドラの加護",
	"ガチャドラの加護",
	"ガチャドラの加護",
	"ガチャドラの加護",
	"ガチャドラの加護",
	"ガチャドラの加護",
	"ガチャドラの加護",
	"ガチャドラの加護",
	"ガチャドラの加護",
	"ガチャドラの加護",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"生存者の証",
	"生存者の証",
	"生存者の証",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"石化状態",
	"凍結状態",
	"スタン状態",
	"睡眠状態",
	UNKNOWN_SYMBOL,
	"石化進行中",
	"発火状態",
	"ホワイトインプリズン状態",
	"毒状態",
	"呪い状態",
	"沈黙状態",
	"混乱状態",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"猛毒状態",
	"恐怖状態",
	UNKNOWN_SYMBOL,
	"うずくまる",
	"イヌハッカシャワー",
	UNKNOWN_SYMBOL,
	"マタタビの根っこ",
	"武器属性付与",
	"武器属性付与",
	"武器属性付与",
	"武器属性付与",
	"武器属性付与",
	"武器属性付与",
	"武器属性付与",
	"武器属性付与",
	"武器属性付与",
	"武器属性付与",
	"無属性攻撃耐性",
	"水属性攻撃耐性",
	"地属性攻撃耐性",
	"火属性攻撃耐性",
	"風属性攻撃耐性",
	"毒属性攻撃耐性",
	"聖属性攻撃耐性",
	"闇属性攻撃耐性",
	"念属性攻撃耐性",
	"不死属性攻撃耐性",
	"タロウの傷",
	"アクラウスダッシュ",
	"マグロシールド",
	"エビ三昧",
	"新鮮なエビ",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"ベルカナの増幅",
	"ライゾの増幅",
	"スリサズの増幅",
	"ハガラズの増幅",
	"イスの増幅",
	"エイシルの増幅",
	"ウルズの増幅",
	"かくれる",
	UNKNOWN_SYMBOL,
	"カルーニャミルク",
	"バジル",
	"にゃん魂",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"警戒",
	UNKNOWN_SYMBOL,
	"ニャングラス",
	"チャタリング",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"グルーミング",
	"エビパーティー",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"マジカルバレット",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"劫火の加護",
	"霧氷の加護",
	"劈風の加護",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"プロンテラ軍丸薬",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"死の呪い",
	"闇の王冠",
	"光の王冠",
	"霧の王冠",
	"魔力空間",
	"皇帝への献身",
	"竜の眷属",
	"邪眼の呪い",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
};

// IDの接頭辞。
const char ID_PREFIX = '#';

// インデックスの接頭辞。
const char INDEX_PREFIX = '$';

// 職業ごとの最大Bot数のマップ。
const std::unordered_map<
	e_job, // 職業。
	int    // 最大Bot数。
> JOB_BOT_LIMITS = {
	{JOB_NOVICE        , 1},
	{JOB_SWORDMAN      , 1},
	{JOB_MAGE          , 1},
	{JOB_ARCHER        , 1},
	{JOB_ACOLYTE       , 1},
	{JOB_MERCHANT      , 1},
	{JOB_THIEF         , 1},
	{JOB_KNIGHT        , 2},
	{JOB_PRIEST        , 2},
	{JOB_WIZARD        , 2},
	{JOB_BLACKSMITH    , 2},
	{JOB_HUNTER        , 2},
	{JOB_ASSASSIN      , 2},
	{JOB_CRUSADER      , 2},
	{JOB_MONK          , 2},
	{JOB_SAGE          , 2},
	{JOB_ROGUE         , 2},
	{JOB_ALCHEMIST     , 2},
	{JOB_BARD          , 2},
	{JOB_DANCER        , 2},
	{JOB_SUPER_NOVICE  , 2},
	{JOB_GUNSLINGER    , 2},
	{JOB_NINJA         , 2},
	{JOB_NOVICE_HIGH   , 3},
	{JOB_SWORDMAN_HIGH , 3},
	{JOB_MAGE_HIGH     , 3},
	{JOB_ARCHER_HIGH   , 3},
	{JOB_ACOLYTE_HIGH  , 3},
	{JOB_MERCHANT_HIGH , 3},
	{JOB_THIEF_HIGH    , 3},
	{JOB_LORD_KNIGHT   , 4},
	{JOB_HIGH_PRIEST   , 4},
	{JOB_HIGH_WIZARD   , 4},
	{JOB_WHITESMITH    , 4},
	{JOB_SNIPER        , 4},
	{JOB_ASSASSIN_CROSS, 4},
	{JOB_PALADIN       , 4},
	{JOB_CHAMPION      , 4},
	{JOB_PROFESSOR     , 4},
	{JOB_STALKER       , 4},
	{JOB_CREATOR       , 4},
	{JOB_CLOWN         , 4},
	{JOB_GYPSY         , 4},
	{JOB_TAEKWON       , 2},
	{JOB_STAR_GLADIATOR, 3},
	{JOB_SOUL_LINKER   , 3},
};

// ランドプロテクター上に設置可能なスキルのセット。
const skill_id_set LAYABLE_ON_LP_SKILLS = {
	AL_PNEUMA,
	HW_GRAVITATION,
	MG_SAFETYWALL,
	PF_FOGWALL,
	WZ_QUAGMIRE,
};

// アイテムの種類の名前のテーブル。
const std::array<std::string,IT_MAX> ITEM_TYPE_NAME_TABLE = {
	"回復"              , // IT_HEALING      = 0
	UNKNOWN_SYMBOL      , // IT_UNKNOWN      = 1
	"使用"              , // IT_USABLE       = 2
	"その他"            , // IT_ETC          = 3
	"防具"              , // IT_ARMOR        = 4
	"武器"              , // IT_WEAPON       = 5
	"カード"            , // IT_CARD         = 6
	"ペットの卵"        , // IT_PETEGG       = 7
	"ペットアクセサリー", // IT_PETARMOR     = 8
	UNKNOWN_SYMBOL      , // IT_UNKNOWN2     = 9
	"矢/弾"             , // IT_AMMO         = 10
	"消費"              , // IT_DELAYCONSUME = 11
	UNKNOWN_SYMBOL      , // IT_SHADOWGEAR   = 12
	UNKNOWN_SYMBOL      ,
	UNKNOWN_SYMBOL      ,
	UNKNOWN_SYMBOL      ,
	UNKNOWN_SYMBOL      ,
	UNKNOWN_SYMBOL      ,
	"スペシャルアイテム", // IT_CASH         = 18
};

// アイテムの種類のオフセット。
const int ITEM_TYPE_OFFSET = 100;

// メタモンスター名のマップ。
const std::unordered_map<
	meta_mobs,  // メタモンスター。
	std::string // メタモンスター名。
> META_MONSTER_NAMES = {
	{MM_REST       , "休息"      },
	{MM_BACKUP     , "予備"      },
	{MM_BASE       , "基本"      },
	{MM_BOSS       , "ボス"      },
	{MM_GREAT      , "グレート"  },
	{MM_FLORA      , "フローラ型"},
	{MM_SP_DECLINE4, "SP低下4"   },
	{MM_SP_DECLINE3, "SP低下3"   },
	{MM_SP_DECLINE2, "SP低下2"   },
	{MM_SP_DECLINE1, "SP低下1"   },
	{MM_HP_DECLINE4, "HP低下4"   },
	{MM_HP_DECLINE3, "HP低下3"   },
	{MM_HP_DECLINE2, "HP低下2"   },
	{MM_HP_DECLINE1, "HP低下1"   },
};

// モンスタークラス名のテーブル。
const std::array<
	std::string, // モンスタークラス名。
	CLASS_MAX    // モンスタークラス数。
> MOB_CLASS_NAME_TABLE = {
	"通常"        ,
	"ボス"        ,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
};

// モンスターが使用すると近接になるスキルのセット。
const skill_id_set MOB_SHORT_SKILLS = {
	AC_SHOWER,
	AM_DEMONSTRATION,
};

// 通常攻撃ポリシー値名のテーブル。
const std::array<
	std::string, // 通常攻撃ポリシー値名。
	NAPV_MAX     // 通常攻撃ポリシー値の数。
> NORMAL_ATTACK_POLICY_VALUE_NAME_TABLE = {
	UNKNOWN_SYMBOL,
	"連続"        ,
	"単発"        ,
};

// ペット用アクセサリータイプ名。
const std::string PET_ACCESSORY_TYPE_NAME = "ペット用アクセサリー";

// 装備一個あたりの修理代。
const int REPAIR_COST = 5000;

// 修理工NPCの名前。
const std::string REPAIRMAN_NAME = "修理工";

// 種族名のテーブル。
const std::array<
	std::string, // 種族名。
	10           // 種族数。
> RACE_NAME_TABLE = {
	"無形"  ,
	"不死形",
	"動物形",
	"植物形",
	"昆虫形",
	"魚貝形",
	"悪魔形",
	"人間形",
	"天使形",
	"竜形"  ,
};

// サイズ名のテーブル。
const std::array<
	std::string, // サイズ名。
	3            // サイズ数。
> SIZE_NAME_TABLE = {
	"小型",
	"中型",
	"大型",
};

// SQLデータタイプのマップ。
const std::unordered_map<
	std::type_index, // 型のインデックス。
	SqlDataType      // SQLデータタイプ。
> SQL_DATA_TYPES = {
	{std::type_index(typeid(int8_t))                  , SQLDT_INT8     },
	{std::type_index(typeid(int16_t))                 , SQLDT_INT16    },
	{std::type_index(typeid(int32_t))                 , SQLDT_INT32    },
	{std::type_index(typeid(int64_t))                 , SQLDT_INT64    },
	{std::type_index(typeid(uint8_t))                 , SQLDT_UINT8    },
	{std::type_index(typeid(uint16_t))                , SQLDT_UINT16   },
	{std::type_index(typeid(bool))                    , SQLDT_UINT8    },
	{std::type_index(typeid(uint32_t))                , SQLDT_UINT32   },
	{std::type_index(typeid(uint64_t))                , SQLDT_UINT64   },
	{std::type_index(typeid(char))                    , SQLDT_CHAR     },
	{std::type_index(typeid(short))                   , SQLDT_SHORT    },
	{std::type_index(typeid(int))                     , SQLDT_INT      },
	{std::type_index(typeid(long))                    , SQLDT_LONG     },
	{std::type_index(typeid(long long))               , SQLDT_LONGLONG },
	{std::type_index(typeid(unsigned char))           , SQLDT_UCHAR    },
	{std::type_index(typeid(unsigned short))          , SQLDT_USHORT   },
	{std::type_index(typeid(unsigned int))            , SQLDT_UINT     },
	{std::type_index(typeid(unsigned long))           , SQLDT_ULONG    },
	{std::type_index(typeid(unsigned long long))      , SQLDT_ULONGLONG},
	{std::type_index(typeid(float))                   , SQLDT_FLOAT    },
	{std::type_index(typeid(double))                  , SQLDT_DOUBLE   },
	{std::type_index(typeid(char*))                   , SQLDT_STRING   },
	{std::type_index(typeid(const int8_t))            , SQLDT_INT8     },
	{std::type_index(typeid(const int16_t))           , SQLDT_INT16    },
	{std::type_index(typeid(const int32_t))           , SQLDT_INT32    },
	{std::type_index(typeid(const int64_t))           , SQLDT_INT64    },
	{std::type_index(typeid(const uint8_t))           , SQLDT_UINT8    },
	{std::type_index(typeid(const uint16_t))          , SQLDT_UINT16   },
	{std::type_index(typeid(const bool))              , SQLDT_UINT8    },
	{std::type_index(typeid(const uint32_t))          , SQLDT_UINT32   },
	{std::type_index(typeid(const uint64_t))          , SQLDT_UINT64   },
	{std::type_index(typeid(const char))              , SQLDT_CHAR     },
	{std::type_index(typeid(const short))             , SQLDT_SHORT    },
	{std::type_index(typeid(const int))               , SQLDT_INT      },
	{std::type_index(typeid(const long))              , SQLDT_LONG     },
	{std::type_index(typeid(const long long))         , SQLDT_LONGLONG },
	{std::type_index(typeid(const unsigned char))     , SQLDT_UCHAR    },
	{std::type_index(typeid(const unsigned short))    , SQLDT_USHORT   },
	{std::type_index(typeid(const unsigned int))      , SQLDT_UINT     },
	{std::type_index(typeid(const unsigned long))     , SQLDT_ULONG    },
	{std::type_index(typeid(const unsigned long long)), SQLDT_ULONGLONG},
	{std::type_index(typeid(const float))             , SQLDT_FLOAT    },
	{std::type_index(typeid(const double))            , SQLDT_DOUBLE   },
	{std::type_index(typeid(const char*))             , SQLDT_STRING   },

	{std::type_index(typeid(e_skill))                 , SQLDT_INT      },
	{std::type_index(typeid(const e_skill))           , SQLDT_INT      },
	{std::type_index(typeid(equip_pos))               , SQLDT_INT      },
	{std::type_index(typeid(const equip_pos))         , SQLDT_INT      },
	{std::type_index(typeid(equip_pos_orders))        , SQLDT_INT      },
	{std::type_index(typeid(const equip_pos_orders))  , SQLDT_INT      },
	{std::type_index(typeid(time_t))                  , SQLDT_UINT32   },
	{std::type_index(typeid(const time_t))            , SQLDT_UINT32   },
};

// 製造武器の星を示すタグ。
const std::string STAR_FORGED_TAG = "星";

// ステータスタイプをステータスパラメータに変換するテーブル。
const std::array<
	_sp,   // ステータスパラメータ。
	ST_MAX // ステータスタイプ数。
> ST2SP_TABLE = {
	SP_STR,
	SP_AGI,
	SP_VIT,
	SP_INT,
	SP_DEX,
	SP_LUK,
};

// ステータスタイプ名のテーブル。
const std::array<
	std::string, // ステータスタイプ名。
	ST_MAX       // ステータスタイプ数。
> STATUS_TYPE_NAME_TABLE = {
	"Str",
	"Agi",
	"Vit",
	"Int",
	"Dex",
	"Luk",
};

// 倉庫利用料。
const int STORAGE_FEE = 100;

// 倉庫タイプ名のテーブル。
const std::array<
	std::string, // 倉庫タイプ名。
	4            // 倉庫タイプ数。
> STORAGE_TYPE_NAME_TABLE = {
	"所持アイテム",
	"カート",
	"倉庫",
	"ギルド倉庫",
};

// 召喚スキルのセット。
const skill_id_set SUMMON_SKILLS = {
	NPC_CALLSLAVE,
	NPC_SUMMONMONSTER,
	NPC_SUMMONSLAVE,
};

// 最大チーム数。
const int TEAM_MAX = 100;

// 鎧解除スキルのセット。
const skill_id_set UNEQUIP_ARMOR_SKILLS = {
	AM_ACIDTERROR,
	CR_ACIDDEMONSTRATION,
	NPC_ARMORBRAKE,
	RG_STRIPARMOR,
	ST_FULLSTRIP,
};

// 兜解除スキルのセット。
const skill_id_set UNEQUIP_HELM_SKILLS = {
	NPC_HELMBRAKE,
	RG_STRIPHELM,
	ST_FULLSTRIP,
};

// 盾解除スキルのセット。
const skill_id_set UNEQUIP_SHIELD_SKILLS = {
	NPC_SHIELDBRAKE,
	RG_STRIPSHIELD,
	ST_FULLSTRIP,
};

// 武器解除スキルのセット。
const skill_id_set UNEQUIP_WEAPON_SKILLS = {
	AM_DEMONSTRATION,
	CR_ACIDDEMONSTRATION,
	NPC_WEAPONBRAKER,
	RG_STRIPWEAPON,
	ST_FULLSTRIP,
};

// 有用なスキルのセット。
const skill_id_set USEFULL_SKILLS = {
	SM_BASH,
	SM_MAGNUM,
	MG_SAFETYWALL,
	MG_SOULSTRIKE,
	MG_COLDBOLT,
	MG_FROSTDIVER,
	MG_STONECURSE,
	MG_FIREBALL,
	MG_FIREWALL,
	MG_FIREBOLT,
	MG_LIGHTNINGBOLT,
	MG_THUNDERSTORM,
	AL_PNEUMA,
	AL_TELEPORT,
	AL_HEAL,
	AL_INCAGI,
	AL_DECAGI,
	MC_MAMMONITE,
	AC_CONCENTRATION,
	AC_DOUBLE,
	AC_SHOWER,
	TF_HIDING,
	KN_PIERCE,
	KN_BRANDISHSPEAR,
	KN_SPEARSTAB,
	KN_SPEARBOOMERANG,
	KN_TWOHANDQUICKEN,
	KN_BOWLINGBASH,
	PR_LEXDIVINA,
	PR_TURNUNDEAD,
	PR_LEXAETERNA,
	WZ_FIREPILLAR,
	WZ_SIGHTRASHER,
	WZ_METEOR,
	WZ_JUPITEL,
	WZ_VERMILION,
	WZ_WATERBALL,
	WZ_FROSTNOVA,
	WZ_STORMGUST,
	WZ_EARTHSPIKE,
	WZ_HEAVENDRIVE,
	WZ_QUAGMIRE,
	BS_HAMMERFALL,
	BS_ADRENALINE,
	BS_MAXIMIZE,
	HT_SKIDTRAP,
	HT_LANDMINE,
	HT_ANKLESNARE,
	HT_SHOCKWAVE,
	HT_SANDMAN,
	HT_FLASHER,
	HT_FREEZINGTRAP,
	HT_BLASTMINE,
	HT_CLAYMORETRAP,
	AS_SONICBLOW,
	AS_GRIMTOOTH,
	AS_VENOMDUST,
	AS_SPLASHER,
	AC_CHARGEARROW,
	NPC_SELFDESTRUCTION,
	NPC_SUICIDE,
	RG_STRIPWEAPON,
	RG_STRIPSHIELD,
	RG_STRIPARMOR,
	RG_STRIPHELM,
	RG_INTIMIDATE,
	AM_DEMONSTRATION,
	AM_ACIDTERROR,
	CR_REFLECTSHIELD,
	CR_HOLYCROSS,
	CR_GRANDCROSS,
	SA_LANDPROTECTOR,
	SA_DISPELL,
	NPC_DARKSTRIKE,
	NPC_DARKTHUNDER,
	NPC_STOP,
	NPC_WEAPONBRAKER,
	NPC_ARMORBRAKE,
	NPC_HELMBRAKE,
	NPC_SHIELDBRAKE,
	NPC_CHANGEUNDEAD,
	PF_SPIDERWEB,
	NPC_BLEEDING,
	NPC_EVILLAND,
	NPC_SLOWCAST,
	NPC_WIDECURSE,
	NPC_VAMPIRE_GIFT,
	NPC_LEX_AETERNA,
	RG_CLOSECONFINE,
};

// 武器タイプ名のテーブル。
const std::array<
	std::string,    // 武器タイプ名。
	MAX_WEAPON_TYPE // 武器タイプ名の数。
> WEAPON_TYPE_NAME_TABLE = {
	"素手"          ,
	"短剣"          ,
	"片手剣"        ,
	"両手剣"        ,
	"片手槍"        ,
	"両手槍"        ,
	"片手斧"        ,
	"両手斧"        ,
	"鈍器"          ,
	"両手鈍器"      ,
	"片手杖"        ,
	"弓"            ,
	"爪"            ,
	"楽器"          ,
	"鞭"            ,
	"本"            ,
	"カタール"      ,
	"ハンドガン"    ,
	"ライフル"      ,
	"ガトリングガン",
	"ショットガン"  ,
	"グレネードガン",
	"風魔"          ,
	"両手杖"        ,
};

// -----------------------------------------------------------------------------
// 変数の定義

// AIのタイマー。
int ai_timer;

// 全Botのマップ。
std::unordered_map<
	int,      // キャラクターID。
	block_if* // Bot。
> all_bots;

// 全リーダーのマップ。
std::unordered_map<
	int,          // キャラクターID。
	ptr<block_if> // リーダー。
> all_leaders;

// Bot死亡チックのマップ。
std::unordered_map<
	int,   // キャラクターID。
	t_tick // 死亡チック。
> bot_dead_ticks;

// フィーバー倍率のマップ。
std::unordered_map<
	int, // マップID。
	int  // 倍率。
> fever_rates;

// マップIDをキーとするマップのマップ。
std::unordered_map<
	int,           // マップID。
	ptr<pybot_map> // マップ。
> id_maps;

// 現在マップ初期位置のマップ。
std::unordered_map<
	int,            // キャラクターID。
	ptr<block_list> // 位置。
> map_initial_positions;

// 現在チック。
t_tick now;

// 種類をキーとするマップのベクタのマップ。
std::unordered_map<
	int, // 種類。
	std::vector<
		ptr<pybot_map> // マップ。
	>    // マップのベクタ。
> type_maps;

}
