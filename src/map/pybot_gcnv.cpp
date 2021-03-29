// [GonBee]
// �p�[�e�B�[BOT�@�\�̃O���[�o���Ȓ萔�ƕϐ����`����B

#include "pybot_internal.hpp"

namespace pybot {

// -----------------------------------------------------------------------------
// �萔�̒�`

// AI�ɂ�����z�����N���X�X�L���g�p�葱���̃}�b�v�B
const std::unordered_map<
	homun_mapid,                     // �z�����N���X�̃}�b�vID�B
	ptr<ai_t::skill_use_proc_vector> // �X�L���g�p�葱���̃x�N�^�B
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

// AI�ɂ�����A�C�e���g�p�葱���̃x�N�^�B
const std::vector<
	ai_t::item_use_proc // �A�C�e���g�p�葱���B
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
	AI_ITEM_USE_PROC_AMMO(ELF_ARROW_QUIVER       , ELF_ARROW          ),
	AI_ITEM_USE_PROC_AMMO(HUNTING_ARROW_QUIVER   , HUNTING_ARROW      ),
	AI_ITEM_USE_PROC     (GREEN_HERB                                  ),
	AI_ITEM_USE_PROC     (GREEN_POTION                                ),
	AI_ITEM_USE_PROC_D   (ASAI_FRUIT             , GREEN_POTION       ),
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
	AI_ITEM_USE_PROC     (COATING_POTION                              ),
	AI_ITEM_USE_PROC     (BRAGI_POTION                                ),
	AI_ITEM_USE_PROC_D   (SATAY                  , LEAF_OF_YGGDRASIL  ),
	AI_ITEM_USE_PROC     (LEAF_OF_YGGDRASIL                           ),
	AI_ITEM_USE_PROC     (HP_INCREASE_POTIONL                         ),
	AI_ITEM_USE_PROC_D   (HP_INCREASE_POTIONM    , HP_INCREASE_POTIONL),
	AI_ITEM_USE_PROC_D   (HP_INCREASE_POTIONS    , HP_INCREASE_POTIONL),
	AI_ITEM_USE_PROC     (SP_INCREASE_POTIONL                         ),
	AI_ITEM_USE_PROC_D   (SP_INCREASE_POTIONM    , SP_INCREASE_POTIONL),
	AI_ITEM_USE_PROC_D   (SP_INCREASE_POTIONS    , SP_INCREASE_POTIONL),
	AI_ITEM_USE_PROC     (DIGEST_POTION                               ),
	AI_ITEM_USE_PROC     (RESIST_FIRE                                 ),
	AI_ITEM_USE_PROC     (RESIST_WATER                                ),
	AI_ITEM_USE_PROC     (RESIST_EARTH                                ),
	AI_ITEM_USE_PROC     (RESIST_WIND                                 ),
	AI_ITEM_USE_PROC     (ELEMENTAL_FIRE                              ),
	AI_ITEM_USE_PROC     (ELEMENTAL_WATER                             ),
	AI_ITEM_USE_PROC     (ELEMENTAL_EARTH                             ),
	AI_ITEM_USE_PROC     (ELEMENTAL_WIND                              ),
	AI_ITEM_USE_PROC     (WATER_OF_DARKNESS                           ),
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
	AI_ITEM_USE_PROC     (STRAWBERRY_CAKE                             ),
	AI_ITEM_USE_PROC     (PINEAPPLE_JUICE                             ),
	AI_ITEM_USE_PROC     (SPICY_SANDWICH                              ),
};

// AI�ɂ�����Bot�X�L���g�p�葱���̃}�b�v�B
const std::unordered_map<
	e_job,                           // �E�ƁB
	ptr<ai_t::skill_use_proc_vector> // �X�L���g�p�葱���̃x�N�^�B
> AI_BOT_SKILL_USE_PROCS = {
	{JOB_ACOLYTE, initialize<ai_t::skill_use_proc_vector>(
		AI_SKILL_USE_PROC_D     (AL_RUWACH, MG_SIGHT                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (1                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_PNEUMA                                      ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (2                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, cure                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_CURE                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (3                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AL_BLESSING                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_INCAGI                                      ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_ANGELUS                                     ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 2),
		AI_SKILL_USE_PROC       (AL_DECAGI                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, curse                             ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AL_CRUCIS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (AL_HEAL, attack                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC_DT    (AL_HOLYLIGHT, SM_BASH, effective               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 4),
		AI_SKILL_USE_PROC_HEAL  (4                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC       (AL_HOLYWATER                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 4)
	)}, {JOB_ALCHEMIST, initialize<ai_t::skill_use_proc_vector>(				 	 
		AI_SKILL_USE_PROC       (AM_CALLHOMUN                                   ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AM_REST                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AM_RESURRECTHOMUN                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_CP    (WEAPON, WEAPON, WEAPON, weapon                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_CP    (SHIELD, SHIELD, SHIELD, shield                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_CP    (ARMOR, ARMOR, ARMOR, armor                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_CP    (HELM, HEAD_TOP, HELM, helm                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (AM_POTIONPITCHER, sp                           ,  5,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (1                                              ,  4,  4, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (1                                              ,  3,  3, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (1                                              ,  2,  2, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (1                                              ,  1,  1, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (2                                              ,  4,  4, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (2                                              ,  3,  3, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (2                                              ,  2,  2, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (2                                              ,  1,  1, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (3                                              ,  4,  4, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (3                                              ,  3,  3, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (3                                              ,  2,  2, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (3                                              ,  1,  1, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AM_CANNIBALIZE                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (AM_DEMONSTRATION, WZ_FIREPILLAR                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MC_LOUD                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AM_BERSERKPITCHER                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
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
		AI_SKILL_USE_PROC       (AS_ENCHANTPOISON                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TF_STEAL                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_POISON                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_SPRINKLESAND                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_D     (AS_SONICBLOW, SM_BASH                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (AS_GRIMTOOTH                                   ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 1),
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
		AI_SKILL_USE_PROC       (AS_ENCHANTPOISON                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TF_STEAL                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_D     (ASC_METEORASSAULT, SM_MAGNUM                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TF_POISON                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (TF_SPRINKLESAND                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_D     (AS_SONICBLOW, SM_BASH                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (ASC_BREAKER                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (AS_GRIMTOOTH                                   ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TF_PICKSTONE                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_BARD, initialize<ai_t::skill_use_proc_vector>(						 	 
		AI_SKILL_USE_PROC       (BD_ADAPTATION                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
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
		AI_SKILL_USE_PROC_D     (AL_RUWACH, MG_SIGHT                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
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
		AI_SKILL_USE_PROC       (AL_DECAGI                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, curse                             ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AL_CRUCIS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MO_ABSORBSPIRITS                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MO_BODYRELOCATION                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MO_BLADESTOP                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_TRUE , 3),
		AI_SKILL_USE_PROC       (MO_EXTREMITYFIST                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MO_INVESTIGATE                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (CH_PALMSTRIKE                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (MO_FINGEROFFENSIVE                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 5),
		AI_SKILL_USE_PROC_T     (AL_HEAL, attack                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC_DT    (AL_HOLYLIGHT, SM_BASH, effective               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 4),
		AI_SKILL_USE_PROC       (CH_SOULCOLLECT                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MO_CALLSPIRITS                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (4                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC       (AL_HOLYWATER                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 4)
	)}, {JOB_CLOWN, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC       (BD_ADAPTATION                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (CG_LONGINGFREEDOM                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CHARGEARROW                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CONCENTRATION                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (BA_FROSTJOKER                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_SHOWER                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (CG_ARROWVULCAN, AC_DOUBLE                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (BA_MUSICALSTRIKE, AC_DOUBLE                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (AC_DOUBLE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5)
	)}, {JOB_CREATOR, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC       (AM_CALLHOMUN                                   ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AM_REST                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AM_RESURRECTHOMUN                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (CR_FULLPROTECTION                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_CP    (WEAPON, WEAPON, WEAPON, weapon                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_CP    (SHIELD, SHIELD, SHIELD, shield                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_CP    (ARMOR, ARMOR, ARMOR, armor                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_CP    (HELM, HEAD_TOP, HELM, helm                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (AM_POTIONPITCHER, sp                           ,  5,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_SPP   (1                                              , 10,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_SPP   (1                                              ,  6,  9, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_SPP   (1                                              ,  1,  5, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (1                                              ,  4,  4, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (1                                              ,  3,  3, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (1                                              ,  2,  2, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (1                                              ,  1,  1, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_SPP   (2                                              , 10,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_SPP   (2                                              ,  6,  9, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_SPP   (2                                              ,  1,  5, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (2                                              ,  4,  4, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (2                                              ,  3,  3, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (2                                              ,  2,  2, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (2                                              ,  1,  1, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_SPP   (3                                              , 10,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_SPP   (3                                              ,  6,  9, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_SPP   (3                                              ,  1,  5, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (3                                              ,  4,  4, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (3                                              ,  3,  3, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (3                                              ,  2,  2, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_PP_HP (3                                              ,  1,  1, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AM_CANNIBALIZE                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (AM_DEMONSTRATION, WZ_FIREPILLAR                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MC_LOUD                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AM_BERSERKPITCHER                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
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
		AI_SKILL_USE_PROC       (CR_DEVOTION                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (CR_PROVIDENCE                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (CR_SPEARQUICKEN                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_ENDURE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
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
		AI_SKILL_USE_PROC_HEAL  (4                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4)
	)}, {JOB_DANCER, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC       (BD_ADAPTATION                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CHARGEARROW                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (AC_CONCENTRATION                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (DC_SCREAM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_SHOWER                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (DC_WINKCHARM                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_D     (DC_THROWARROW, AC_DOUBLE                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (AC_DOUBLE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5)
	)}, {JOB_GUNSLINGER, initialize<ai_t::skill_use_proc_vector>(				 	 
		AI_SKILL_USE_PROC       (GS_DUST                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (GS_CRACKER                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (GS_ADJUSTMENT                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (GS_INCREASING                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (GS_GATLINGFEVER                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (GS_MADNESSCANCEL                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
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
		AI_SKILL_USE_PROC       (BD_ADAPTATION                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (CG_LONGINGFREEDOM                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
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
		AI_SKILL_USE_PROC_D     (AL_RUWACH, MG_SIGHT                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
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
		AI_SKILL_USE_PROC       (PR_GLORIA                                      ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PR_ASPERSIO                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_IMPOSITIO                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PR_KYRIE                                       ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_SUFFRAGIUM                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 2),
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
		AI_SKILL_USE_PROC_T     (WZ_HEAVENDRIVE, exposure                       ,  1,  1, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_SIGHT                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (WZ_FROSTNOVA                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FIREWALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (WZ_ICEWALL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FROSTDIVER                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_STONECURSE                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (HW_GANBANTEIN                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 0),
		AI_SKILL_USE_PROC       (MG_SAFETYWALL                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_ENERGYCOAT                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_QUAGMIRE                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (WZ_FIREPILLAR                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (WZ_METEOR                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (WZ_VERMILION                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_HEAVENDRIVE, MG_THUNDERSTORM                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_STORMGUST                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (WZ_STORMGUST, freeze                           ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (HW_GRAVITATION                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (WZ_JUPITEL, MG_LIGHTNINGBOLT, crush            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (MG_LIGHTNINGBOLT, crush                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_WATERBALL                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_JUPITEL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBOLT                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_LIGHTNINGBOLT, MG_FIREBOLT                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_EARTHSPIKE, MG_FIREBOLT                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_COLDBOLT, MG_FIREBOLT                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (HW_NAPALMVULCAN, MG_NAPALMBEAT                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (MG_SOULSTRIKE, MG_NAPALMBEAT                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (WZ_WATERBALL, compromise                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (WZ_JUPITEL, compromise                         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
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
		AI_SKILL_USE_PROC       (SM_ENDURE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
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
		AI_SKILL_USE_PROC       (SM_ENDURE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, enchant                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (KN_AUTOCOUNTER                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_TRUE , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (KN_BOWLINGBASH, MC_CARTREVOLUTION              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (KN_BRANDISHSPEAR, MC_CARTREVOLUTION            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, effective                           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_MAGNUM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (KN_CHARGEATK                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC       (LK_JOINTBEAT                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_D     (LK_SPIRALPIERCE, SM_BASH                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (KN_PIERCE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (SM_BASH                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5)
	)}, {JOB_MAGE, initialize<ai_t::skill_use_proc_vector>(						 	 
		AI_SKILL_USE_PROC       (MG_SIGHT                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FIREWALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FROSTDIVER                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_STONECURSE                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_SAFETYWALL                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_ENERGYCOAT                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (MG_LIGHTNINGBOLT, crush                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
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
		AI_SKILL_USE_PROC_D     (AL_RUWACH, MG_SIGHT                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
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
		AI_SKILL_USE_PROC       (AL_DECAGI                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, curse                             ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AL_CRUCIS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MO_ABSORBSPIRITS                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MO_BODYRELOCATION                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MO_BLADESTOP                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_TRUE , 3),
		AI_SKILL_USE_PROC       (MO_EXTREMITYFIST                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (MO_INVESTIGATE                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (MO_FINGEROFFENSIVE                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 5),
		AI_SKILL_USE_PROC_T     (AL_HEAL, attack                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 4),
		AI_SKILL_USE_PROC_DT    (AL_HOLYLIGHT, SM_BASH, effective               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 4),
		AI_SKILL_USE_PROC       (MO_CALLSPIRITS                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_HEAL  (4                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4),
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
		AI_SKILL_USE_PROC_DT    (NJ_HUUJIN, MG_LIGHTNINGBOLT, crush             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
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
		AI_SKILL_USE_PROC_T     (PA_GOSPEL, deactivate                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
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
		AI_SKILL_USE_PROC       (CR_DEVOTION                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (CR_PROVIDENCE                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (CR_SPEARQUICKEN                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PA_SACRIFICE                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_ENDURE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, enchant                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (CR_GRANDCROSS, effective                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, effective                           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (CR_GRANDCROSS                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_MAGNUM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_DT    (CR_HOLYCROSS, SM_BASH, effective               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_T     (SM_BASH, effective                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (PA_SHIELDCHAIN, SM_BASH                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (CR_HOLYCROSS, SM_BASH                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC       (SM_BASH                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_T     (CR_SHIELDBOOMERANG, spirit                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_D     (PA_PRESSURE, ASC_BREAKER                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
		AI_SKILL_USE_PROC_HEAL  (4                                              ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4)
	)}, {JOB_PRIEST, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC_D     (AL_RUWACH, MG_SIGHT                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
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
		AI_SKILL_USE_PROC       (PR_GLORIA                                      ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PR_ASPERSIO                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_IMPOSITIO                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PR_KYRIE                                       ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_SUFFRAGIUM                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 2),
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
		AI_SKILL_USE_PROC       (MG_SIGHT                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
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
		AI_SKILL_USE_PROC       (SA_VOLCANO                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_VIOLENTGALE                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_DELUGE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_AUTOSPELL                                   ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SA_FLAMELAUNCHER                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SA_LIGHTNINGLOADER                             ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SA_SEISMICWEAPON                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SA_FROSTWEAPON                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PF_MINDBREAKER                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (MG_LIGHTNINGBOLT, crush                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
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
		AI_SKILL_USE_PROC_T     (WZ_HEAVENDRIVE, exposure                       ,  1,  1, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
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
		AI_SKILL_USE_PROC       (TF_STEAL                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (RG_STEALCOIN                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (CR_GRANDCROSS                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (KN_BOWLINGBASH, MC_CARTREVOLUTION              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_MAGNUM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_SHOWER                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_MAGNUS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_METEOR                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (NJ_BAKUENRYU                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (WZ_VERMILION                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (NJ_RAIGEKISAI                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (NJ_KAMAITACHI                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_HEAVENDRIVE, MG_THUNDERSTORM                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_STORMGUST                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (WZ_STORMGUST, freeze                           ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (WZ_JUPITEL, MG_LIGHTNINGBOLT, crush            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (MG_LIGHTNINGBOLT, crush                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HUUJIN, MG_LIGHTNINGBOLT, crush             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (PR_TURNUNDEAD                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
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
		AI_SKILL_USE_PROC       (WZ_WATERBALL                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_JUPITEL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
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
		AI_SKILL_USE_PROC_T     (WZ_WATERBALL, compromise                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
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
		AI_SKILL_USE_PROC       (MG_SIGHT                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
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
		AI_SKILL_USE_PROC       (SA_VOLCANO                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_VIOLENTGALE                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_DELUGE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SA_AUTOSPELL                                   ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SA_FLAMELAUNCHER                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SA_LIGHTNINGLOADER                             ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SA_SEISMICWEAPON                               ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SA_FROSTWEAPON                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (MG_LIGHTNINGBOLT, crush                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
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
		AI_SKILL_USE_PROC       (SL_SKE                                         ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SL_SKA                                         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (SL_SWOO                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SL_SMA                                         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SL_STIN                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SL_STUN                                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_STALKER, initialize<ai_t::skill_use_proc_vector>(					 	 
		AI_SKILL_USE_PROC_D     (RG_RAID, SM_MAGNUM                             ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (NJ_KIRIKAGE                                    ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (ST_CHASEWALK, deactivate                       ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (TF_HIDING, deactivate                          ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (ST_PRESERVE                                    ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC_T     (WZ_HEAVENDRIVE, exposure                       ,  1,  1, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
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
		AI_SKILL_USE_PROC       (ST_REJECTSWORD                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (NJ_KASUMIKIRI                                  ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (TF_HIDING, activate                            ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, enchant                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (NJ_KAENSIN                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TF_STEAL                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (RG_STEALCOIN                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (CR_GRANDCROSS                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (KN_BOWLINGBASH, MC_CARTREVOLUTION              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (SM_MAGNUM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (AC_SHOWER                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PR_MAGNUS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_METEOR                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (NJ_BAKUENRYU                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (WZ_VERMILION                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (NJ_RAIGEKISAI                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (NJ_KAMAITACHI                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_HEAVENDRIVE, MG_THUNDERSTORM                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_STORMGUST                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (WZ_STORMGUST, freeze                           ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (WZ_JUPITEL, MG_LIGHTNINGBOLT, crush            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (MG_LIGHTNINGBOLT, crush                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HUUJIN, MG_LIGHTNINGBOLT, crush             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (PR_TURNUNDEAD                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
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
		AI_SKILL_USE_PROC       (WZ_WATERBALL                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_JUPITEL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
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
		AI_SKILL_USE_PROC_T     (WZ_WATERBALL, compromise                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (MG_FIREBOLT, compromise                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (NJ_KOUENKA, compromise                         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_LIGHTNINGBOLT, MG_FIREBOLT, compromise      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HUUJIN, NJ_KOUENKA, compromise              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (WZ_EARTHSPIKE, MG_FIREBOLT, compromise         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_COLDBOLT, MG_FIREBOLT, compromise           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (NJ_HYOUSENSOU, NJ_KOUENKA, compromise          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (TF_PICKSTONE                                   ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (ST_CHASEWALK, activate                         ,  1,  0, BMF_NONE  , PF_ALL  , WF_ALL  , AF_ALL  , 1)
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
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TK_JUMPKICK                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)}, {JOB_SUPER_NOVICE, initialize<ai_t::skill_use_proc_vector>(				 	 
		AI_SKILL_USE_PROC_T     (TF_HIDING, deactivate                          ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_SIGHT                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC_D     (AL_RUWACH, MG_SIGHT                            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
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
		AI_SKILL_USE_PROC       (SM_ENDURE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
		AI_SKILL_USE_PROC_T     (SM_MAGNUM, enchant                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AL_DECAGI                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (TF_STEAL                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (SM_MAGNUM                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (MG_LIGHTNINGBOLT, crush                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (AL_BLESSING, curse                             ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
		AI_SKILL_USE_PROC       (AL_CRUCIS                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
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
		AI_SKILL_USE_PROC       (SM_ENDURE                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 3),
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
		AI_SKILL_USE_PROC       (TK_SEVENWIND                                   ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 1),
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
		AI_SKILL_USE_PROC_T     (WZ_HEAVENDRIVE, exposure                       ,  1,  1, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_SIGHT                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (WZ_FROSTNOVA                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FIREWALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (WZ_ICEWALL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_FROSTDIVER                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_STONECURSE                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
		AI_SKILL_USE_PROC       (WZ_QUAGMIRE                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC       (MG_SAFETYWALL                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_ENERGYCOAT                                  ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_FIREPILLAR                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
		AI_SKILL_USE_PROC       (PB_FIRST                                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (WZ_METEOR                                      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBALL                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC       (WZ_VERMILION                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_THUNDERSTORM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_HEAVENDRIVE, MG_THUNDERSTORM                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_STORMGUST                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (WZ_STORMGUST, freeze                           ,  1,  1, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
		AI_SKILL_USE_PROC_DT    (WZ_JUPITEL, MG_LIGHTNINGBOLT, crush            ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (MG_LIGHTNINGBOLT, crush                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_WATERBALL                                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (WZ_JUPITEL                                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_FIREBOLT                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_LIGHTNINGBOLT, MG_FIREBOLT                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (WZ_EARTHSPIKE, MG_FIREBOLT                     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_COLDBOLT, MG_FIREBOLT                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_D     (MG_SOULSTRIKE, MG_NAPALMBEAT                   ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
		AI_SKILL_USE_PROC_T     (WZ_WATERBALL, compromise                       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (WZ_JUPITEL, compromise                         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_T     (MG_FIREBOLT, compromise                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_LIGHTNINGBOLT, MG_FIREBOLT, compromise      ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (WZ_EARTHSPIKE, MG_FIREBOLT, compromise         ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC_DT    (MG_COLDBOLT, MG_FIREBOLT, compromise           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
		AI_SKILL_USE_PROC       (MG_NAPALMBEAT                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1)
	)},
};

// AI�ɂ�����Bot�ꎞ�X�L���g�p�葱���̃x�N�^(�㏈��)�B
const ai_t::skill_use_proc_vector AI_BOT_TEMPORARY_SKILL_POST_USE_PROCS = {
	AI_SKILL_USE_PROC       (TF_STEAL                                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
	AI_SKILL_USE_PROC       (SM_MAGNUM                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
	AI_SKILL_USE_PROC       (WZ_METEOR                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
	AI_SKILL_USE_PROC       (MG_FIREBALL                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
	AI_SKILL_USE_PROC       (TF_POISON                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
	AI_SKILL_USE_PROC       (KN_PIERCE                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
	AI_SKILL_USE_PROC       (SM_BASH                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 5),
	AI_SKILL_USE_PROC       (WZ_WATERBALL                             ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
	AI_SKILL_USE_PROC       (MG_FIREBOLT                              ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
	AI_SKILL_USE_PROC_D     (MG_COLDBOLT, MG_FIREBOLT                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
	AI_SKILL_USE_PROC_T     (WZ_WATERBALL, compromise                 ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
	AI_SKILL_USE_PROC_T     (MG_FIREBOLT, compromise                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
	AI_SKILL_USE_PROC_DT    (MG_COLDBOLT, MG_FIREBOLT, compromise     ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_FALSE, 1),
	AI_SKILL_USE_PROC_D     (HW_MAGICCRASHER, MG_NAPALMBEAT           ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 1),
	AI_SKILL_USE_PROC       (TF_PICKSTONE                             ,  1,  0, BMF_NONE  , PF_ALL  , WF_FALSE, AF_ALL  , 1),
	AI_SKILL_USE_PROC_HEAL  (4                                        ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 4)
};

// AI�ɂ�����Bot�ꎞ�X�L���g�p�葱���̃x�N�^(�O����)�B
const ai_t::skill_use_proc_vector AI_BOT_TEMPORARY_SKILL_PRE_USE_PROCS = {
	AI_SKILL_USE_PROC_T     (TF_HIDING, deactivate                       ,  1,  0, BMF_ALL   , PF_ALL  , WF_FALSE, AF_ALL  , 0),
	AI_SKILL_USE_PROC       (MG_SIGHT                                    ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 1),
	AI_SKILL_USE_PROC       (LK_BERSERK                                  ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC       (AL_CURE                                     ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_DT    (ITM_TOMAHAWK, TF_THROWSTONE, first_attack   ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_T     (TF_THROWSTONE, first_attack                 ,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_DT    (HW_MAGICCRASHER, TF_THROWSTONE, first_attack,  1,  0, BMF_COMBAT, PF_TRUE , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_DT    (ITM_TOMAHAWK, TF_THROWSTONE, crush          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_T     (TF_THROWSTONE, crush                        ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_DT    (HW_MAGICCRASHER, TF_THROWSTONE, crush       ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_HEAL  (3                                           ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC       (TF_DETOXIFY                                 ,  1,  0, BMF_ALL   , PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_T     (TF_HIDING, activate                         ,  1,  0, BMF_COMBAT, PF_FALSE, WF_FALSE, AF_ALL  , 3),
	AI_SKILL_USE_PROC       (WZ_FROSTNOVA                                ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC       (MG_FROSTDIVER                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 0),
	AI_SKILL_USE_PROC       (MG_STONECURSE                               ,  1,  0, BMF_COMBAT, PF_ALL  , WF_ALL  , AF_ALL  , 0),
	AI_SKILL_USE_PROC_T     (SM_MAGNUM, enchant                          ,  1,  0, BMF_COMBAT, PF_ALL  , WF_FALSE, AF_ALL  , 3),
};

// �����X�L���A�h�o���e�[�W�̃}�b�v(���u)�B
const std::unordered_map<e_skill,int> ALLY_SKILL_ADVANTAGES_AWAY = {
	{PR_SANCTUARY      ,    2},
	{AL_PNEUMA         ,  400},
	{SA_VOLCANO        ,    1},
	{SA_DELUGE         ,    1},
	{SA_VIOLENTGALE    ,    1},
	{SA_LANDPROTECTOR  , 2000},
	{BD_LULLABY        ,   40},
	{BD_RICHMANKIM     ,   40},
	{BD_ETERNALCHAOS   ,   40},
	{BD_DRUMBATTLEFIELD,   40},
	{BD_RINGNIBELUNGEN ,   40},
	{BD_ROKISWEIL      ,   40},
	{BD_INTOABYSS      ,   40},
	{BD_SIEGFRIED      ,   40},
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
	{PA_GOSPEL         ,  100},
	{HP_BASILICA       , 4000},
	{CG_MOONLIT        , 1000},
	{PF_FOGWALL        ,  200},
	{NJ_SUITON         ,    1},
};

// �����X�L���A�h�o���e�[�W�̃}�b�v(�ߐ�)�B
const std::unordered_map<e_skill,int> ALLY_SKILL_ADVANTAGES_CLOSE = {
	{MG_SAFETYWALL     ,  100},
};

// ��/�e��v������臒l�B
const int AMMO_REQUEST_THRESHOLD = 10;

// ��/�e�^�C�v���̃e�[�u���B
const std::array<
	std::string,  // ��/�e�^�C�v���B
	MAX_AMMO_TYPE // ��/�e�^�C�v�̐��B
> AMMO_TYPE_NAME_TABLE = {
	UNKNOWN_SYMBOL,
	"��"            ,            
	"�����i�C�t"    ,    
	"�e�e"          ,          
	"�e��"          ,          
	"�O���l�[�h"    ,    
	"�藠��"        ,        
	"�ꖳ"          ,          
	"�L���m���{�[��",
	"����"          ,          
};

// �h��^�C�v���̃e�[�u���B
const std::array<
	std::string, // �h��^�C�v���B
	EPO_MAX      // �������ʏ����̐��B
> ARMOR_TYPE_NAME_TABLE = {
	"��"          ,
	"�Z"          ,
	"��"          ,
	UNKNOWN_SYMBOL,
	"���ɂ����镨",
	"�C"          ,
	"�A�N�Z�T���[",
	"�A�N�Z�T���[",
	"��"          ,
	"��"          ,
	"��"          ,
	"��"          ,
	"��"          ,
	"���ɂ����镨",
	"��/�e"       ,
};

// �����W���[�N���g�p�����Ƃ��̔����̃x�N�^�B
const std::vector<std::string> BA_FROSTJOKER_MESSAGES = {
	"�Ԃ�Ԃ���c�X�g�[���i�C�g����X�g�[�u�Ȃ��́H",
	"�����c�̃A�W�g�͋����Ă����A���イ���イ�ł�",
	"�O������ˁ[���I",
	"�s�b�L�̖ڂ��������I�s�b�L�[��I�I",
	"�u�ǂ�s���H�v�u�D���I�v",
	"�u���̃E�H�[�O�͒N�́H�v�u�����W���[�I�v",
	"�A�[�`���[�����؂炵���B������[!!!!!",
	"�W���[�N�΂�����ŉ��t�͂��j�u���w�C��!!",
	"��ł��q���X���I���I",
	"���׈������I�Q�t�F���Q�t�F�����I",
	"���́c�c�����_���[�ɂȂ肽�������́c�c���ւ���",
	"�Ă����T�}�[�����ł邺�B",
	"�X�e�B�[���I���܂��̃n�[�g1�l���B",
	"�����K�w�����Ă����A�E�F���J���B",
	"���ɐG���ƃ��P�h���邺�I������ē���񂩂��I",
	"�[���s�[�́u�s�[�v�͕����֎~�p��ł��B",
	"���c�͍������Ȃ��B",
	"�C�W�h�������܂��I 1���ŁI",
	"�l�y���e�X���Q�Ă�ł��I",
	"�u�N�A�{�C�Ō����Ă�H�v�u�}�W�ł��B�o�[�h�ł����v",
	"�E�G�|���p�[�ւ��������I�I",
	"���ΐ��̂��X�I �K�W���}�[�g�I",
	"���߂�The Sign�I",
	"���J��������!! �����L���E�X!!",
	"�������ĉ������Ă���Ȃ̌��������˂���I",
	"�J�^�R���x�Ŏ�肵�Ă�ƌ�����ׁI",
	"�W���[�N�������Ȃ��I�H ����ȃp�T�i�b�I�I",
	"����!!�O���őO���݂��Ȃ�!!",
	"�w�[���̋R�m���։��x�̋L���B",
	"���^�����q�J���ɂ��ꂽ�B�����ߊς��邵���Ȃ��B",
	"������100�l����Βn�����g���͖h����ȁI",
	"�搶�т�����Z���Z�[�V���i���B",
	"�I�b�g�[���߂��ɕ������B�����Ɓ[��Ȃ��B",
	"�t�F���̗l�q���t�F�����I",
	"�����N�ł͂������N�Ȃ��Ƃ��Ȃ��I",
	"�g�������݃e�B�[�B",
	"�N����H�ׂ�ƃX�b�p�C�_�[�I",
	"��峂��z��r���B",
	"�|�������|�����Ƀ|�[�����i�t�H�[�����j���u�I",
	"�W�����C�ɍs����W�����C�B",
	"���b�J�[�Ɨx������[�B",
	"�c�e�ł������ィ�M���̓S���͌��؂�܎w�e�I�I",
	"���v���Ȃ�k�̊X�ɂ���ł΂��I�I",
	"���҂�ł����܂����`�I",
	"�o���_�i�̏o�Ԃ��ȁI",
	"�Ղ̂ӂ肵�ăg���u���I",
	"�J�[�g�ŉ����A�J�[�b�ƂȂ�B",
	"�|�[�V�����𗎂Ƃ����A�|�V�����I",
	"��[���A�{�q�ɂȂ낤�B",
	"�ł̍s�����ǂ߂�B",
	"�_���T�[���i���œ]�񂾂񂳁[�B",
	"�T�{�e�����C�����Ă��� ���J�[!!",
	"��͂��ꂢ�ŃX�J�C�H",
	"���̊���T���h�}��!!",
	"�C���𔭌@����!!",
	"�z�[�h�̐S�̋��сu�݁A���[�I�v",
	"���������������A��B",
	"�A���~�ʂ̏�ɂ���݂���I",
	"�΂͂��������`",
	"�O����A�����ɋ����܂��I",
	"�n�̓E�}�`���B",
	"�J���[�͐h���I",
	"�؎��؂��ā�",
	"����ɍs���͍̂��������H",
	"�R�[�f�B�l�[�g�͂����ł˂��ƁB",
	"���̃J�����_�[�͔ނ񂾁[",
	"��������B",
	"�N���d�b�ɏo���B",
	"�g�C���ɍs���Ƃ���B",
	"�i�C�X�ȃC�X�B",
	"���e���Ȃ���[",
	"�u�h�E���ЂƂԂǂ��H",
	"�z�c���ӂ���񂾁I",
	"���K�l�ɖڂ��˂��B",
	"�����͂�[�ˁB",
	"�V�����������̂͂�߂Ȃ����I",
	"�_�W�����������̂͂��ꂶ��`�I",
	"�����̉���͂��̓X�ŃG���J�C�H",
	"���݂����͊̑��ɂ��J���]�E�B",
	"����͉��̎M���H�T���_�̎M���I",
	"�a������l�ŁA�����傤���c�[�B",
	"�u�ׂ̉Ƃɂ��������o�������Ăˁv�u���������[�v",
	"�u�ׂ̋󂫒n�ɂւ����o�������Ăˁv�u�ւ��[�v",
	"���̃N�������A�l�ɂ�����B",
	"�����������B �M���b�I",
	"�u�E�C������I�v�u���A������!?�v�u����������v",
	"�u���v���~�܂����v�u�ق��Ƃ����v",
	"�E�҂͑S���ŉ��l����H",
	"�u�{���P�O������v�u���A�{�����v",
	"�ǂɎ������q�Ƀ��A���[",
	"�u�^����֍s���Ă������H�v�u����A�ǂ�����v",
	"�u���Ȃ��A���΁H�v�u���邳���I�v",
	"�ڂ�����񂪒r�ɗ������B�u�ڂ������v",
	"�V���x��������I",
	"�d���ɗp�����H",
	"�y�ǂ��h�J��!!",
	"�p���_�̃p�����B",
	"���̃J�b�^�[�ǂ��ł������[�H",
	"�\�[�_���܂��[���[",
	"���W���[������ȂɐL�΂�����A�_���W���[�I",
	"�T���͉j�����Ƃ��Ă��W���[�Y�I",
	"�Ӟ��Ō̏�I",
	"�I��H�ׂăT�o�C�o��!!",
	"��Ƃ���������!",
	"�v�͔���Ȃ��B",
	"���̃J�t�F�I���`!",
	"���͂����!!",
	"�����ǂ����������I",
	"�����������c�c�L�B�`�`�`�I",
	"���̃L���x�c�������Ă�B �L���[�ʂ̂ɕς��āI",
	"�N��������������B",
	"���Ȃ��H�ׂ悤�Ǝv������A�����Ȃ������`",
	"�{������ł�c�c�Ԃ����A�Ԃ����I",
	"��񂲂����ڂ�Ă�I �����Ղ�A�����Ղ�!!",
	"���u���^�[�A��Ԃ�ꂽ�[�I",
	"���h�ȃX���b�p!!",
	"�x�����_�ɐA�������x���_�[",
};

// �퓬���[�h�t���O�̃e�[�u���B
const std::array<
	battle_mode_flags, // �퓬���[�h�̃t���O�B
	BM_MAX             // �퓬���[�h���B
> BATTLE_MODE_FLAG_TABLE = {
	BMF_NONE,
	BMF_TAUNT,
	BMF_ASSIST,
};

// @Bot�̃T�u�R�}���h�����̃x�N�^�B
const std::vector<ptr<subcommand_desc>> BOT_SUBCMD_DESCS = {
	SUBCMD_DESC   (Bot, Attack                     , a    ,
		"------ Attack (a) �T�u�R�}���h ------\n"
		"�����X�^�[���U������B\n"
		"���͗� [@bot attack]\n"
		"����̃����X�^�[���U������B\n"
		"���͗� [@bot attack �v�p]\n"
	), SUBCMD_DESC(Bot, BufferEquipSet             , bes  ,
		"------ BufferEquipSet (bes) �T�u�R�}���h ------\n"
		"�o�b�t�@����ꎮ���ꗗ�\������B\n"
		"���͗� [@bot bufferequipset �A�T�N��]\n"
		"�o�b�t�@����ꎮ��o�^����B\n"
		"���͗� [@bot bufferequipset �A�T�N�� �W���͌���]\n"
		"�o�b�t�@����ꎮ�̓o�^�𖕏�����B\n"
		"���͗� [@bot bufferequipset �A�T�N�� ���푮���t�^(��)]\n"
	), SUBCMD_DESC(Bot, BufferEquipSetClear        ,      ,
		"------ BufferEquipSetClear �T�u�R�}���h ------\n"
		"�o�b�t�@����ꎮ���N���A����B\n"
		"���͗� [@bot bufferequipsetclear �A�T�N��]\n"
	), SUBCMD_DESC(Bot, BufferEquipSetLoad         , besl ,
		"------ BufferEquipSetLoad (besl) �T�u�R�}���h ------\n"
		"�o�b�t�@����ꎮ�����[�h����B\n"
		"���͗� [@bot bufferequipsetload �A�T�N�� �W���͌���\n"
	), SUBCMD_DESC(Bot, BufferEquipSetTransport    , best ,
		"------ BufferEquipSetTransport (best) �T�u�R�}���h ------\n"
		"�o�b�t�@����ꎮ��]������B\n"
		"���͗� [@bot bufferequipsettransport �A�T�N�� �`�F�C�X]\n"
	), SUBCMD_DESC(Bot, Cart                       , c    ,
		"------ Cart (c) �T�u�R�}���h ------\n"
		"�J�[�g�̃A�C�e�����ꗗ�\������B\n"
		"���͗� [@bot cart �N���G]\n"
	), SUBCMD_DESC(Bot, CartAutoGet                , cag  ,
		"------ CartAutoGet (cag) �T�u�R�}���h ------\n"
		"�J�[�g������[�A�C�e�����ꗗ�\������B\n"
		"���͗� [@bot cartautoget �N���G]\n"
		"�J�[�g������[�A�C�e����o�^����B\n"
		"���͗� [@bot cartautoget �N���G �t�@�C�A�[�{�g�� 1]\n"
		"�J�[�g������[�A�C�e���̓o�^�𖕏�����B\n"
		"���͗� [@bot cartautoget �N���G �A�V�b�h�{�g��]\n"
	), SUBCMD_DESC(Bot, CartAutoGetClear           ,      ,
		"------ CartAutoGetClear �T�u�R�}���h ------\n"
		"�J�[�g������[�A�C�e�����N���A����B\n"
		"���͗� [@bot cartautogetclear �N���G]\n"
	), SUBCMD_DESC(Bot, CartAutoGetTransport       , cagt ,
		"------ CartAutoGetTransport (cagt) �T�u�R�}���h ------\n"
		"�J�[�g������[�A�C�e����]������B\n"
		"���͗� [@bot cartautogettransport �N���G �X�~�X]\n"
	), SUBCMD_DESC(Bot, CartGet                    , cg   ,
		"------ CartGet (cg) �T�u�R�}���h ------\n"
		"�J�[�g����A�C�e���̑S�������o���B\n"
		"���͗� [@bot cartget �N���G �u���[�W�F���X�g�[��]\n"
		"�J�[�g����A�C�e���̓���������o���B\n"
		"���͗� [@bot cartget �N���G �u���[�W�F���X�g�[�� 5]\n"
	), SUBCMD_DESC(Bot, CartPut                    , cp   ,
		"------ CartPut (cp) �T�u�R�}���h ------\n"
		"�J�[�g�ɃA�C�e���̑S��������B\n"
		"���͗� [@bot cartput �N���G �u���[�W�F���X�g�[��]\n"
		"�J�[�g�ɃA�C�e���̓����������B\n"
		"���͗� [@bot cartput �N���G �u���[�W�F���X�g�[�� 5]\n"
	), SUBCMD_DESC(Bot, DistancemaX                , dx   ,
		"------ DistancemaX (dx) �T�u�R�}���h ------\n"
		"�����X�^�[�Ƃ̍ő勗����ݒ肷��B\n"
		"���͗� [@bot distancemax �h�i 5]\n"
	), SUBCMD_DESC(Bot, DistancemiN                , dn   ,
		"------ DistancemiN (dn) �T�u�R�}���h ------\n"
		"�����X�^�[�Ƃ̍ŏ�������ݒ肷��B\n"
		"���͗� [@bot distancemin �n�C�v�� 7]\n"
	), SUBCMD_DESC(Bot, Equip                      , e    ,
		"------ Equip (e) �T�u�R�}���h ------\n"
		"����𑕔�����B\n"
		"���͗� [@bot equip �A�T�N�� \"�X�e�B���b�g [|] <+6>\"]\n"
		"����̑�������������B\n"
		"���͗� [@bot equip �A�T�N�� �u���[�t]\n"
		"���ׂĂ̕���̑�������������B\n"
		"���͗� [@bot equip �A�T�N��]\n"
	), SUBCMD_DESC(Bot, EquipIdentifyAll           , eia  ,
		"------ EquipIdentifyAll (eia) �T�u�R�}���h ------\n"
		"���Ӓ�̕�������ׂĊӒ肷��B\n"
		"���͗� [@bot equipidentifyall]\n"
	), SUBCMD_DESC(Bot, EquipRepairAll             , era  ,
		"------ EquipRepairAll (era) �T�u�R�}���h ------\n"
		"�j��������������ׂďC������B\n"
		"���͗� [@bot equiprepairall]\n"
	), SUBCMD_DESC(Bot, EquipSet                   , es   ,
		"------ EquipSet (es) �T�u�R�}���h ------\n"
		"����ꎮ���ꗗ�\������B\n"
		"���͗� [@bot equipset �A�T�N��]\n"
		"����ꎮ��o�^����B\n"
		"���͗� [@bot equipset �A�T�N�� ��{]\n"
		"����ꎮ�̓o�^�𖕏�����B\n"
		"���͗� [@bot equipset �A�T�N�� �s������]\n"
	), SUBCMD_DESC(Bot, EquipSetClear              ,      ,
		"------ EquipSetClear �T�u�R�}���h ------\n"
		"����ꎮ���N���A����B\n"
		"���͗� [@bot equipsetclear �A�T�N��]\n"
	), SUBCMD_DESC(Bot, EquipSetLoad               , esl  ,
		"------ EquipSetLoad (esl) �T�u�R�}���h ------\n"
		"����ꎮ�����[�h����B\n"
		"���͗� [@bot equipsetload �A�T�N�� �n����]\n"
	), SUBCMD_DESC(Bot, EquipSetTransport          , est  ,
		"------ EquipSetTransport (est) �T�u�R�}���h ------\n"
		"����ꎮ��]������B\n"
		"���͗� [@bot equipsettransport �A�T�N�� �`�F�C�X]\n"
	), SUBCMD_DESC(Bot, Help                       , h    ,
		"------ Help (h) �T�u�R�}���h ------\n"
		"�T�u�R�}���h�̐�����\������B\n"
		"���͗� [@bot help login]\n"
	), SUBCMD_DESC(Bot, HoldMonsters               , hm   ,
		"------ HoldMonsters (hm) �T�u�R�}���h ------\n"
		"�����邱�Ƃ̂ł��郂���X�^�[����ݒ肷��B\n"
		"���͗� [@bot holdmonsters �N���E�� 1]\n"
	), SUBCMD_DESC(Bot, HomunsKill                 , hk   ,
		"------ HomunsKill (hk) �T�u�R�}���h ------\n"
		"�z�����N���X�̃X�L�����ꗗ�\������B\n"
		"���͗� [@bot homunskill �N���G]\n"
		"�z�����N���X���X�L�����ō����x���Ŏg�p����B\n"
		"���͗� [@bot homunskill �N���G �����̎�]\n"
		"�z�����N���X���X�L������背�x���Ŏg�p����B\n"
		"���͗� [@bot homunskill �N���G �J�I�e�B�b�N�x�l�f�B�N�V���� 3]\n"
	), SUBCMD_DESC(Bot, HomunsKillLimit            , hkl  ,
		"------ HomunsKillLimit (hkl) �T�u�R�}���h ------\n"
		"�z�����N���X���X�L���̃��x���𐧌�����B\n"
		"���͗� [@bot homunskilllimit �N���G �����^���`�F���W 0]\n"
		"�z�����N���X���X�L���̃��x����������������B\n"
		"���͗� [@bot homunskilllimit �N���G �����^���`�F���W]\n"
	), SUBCMD_DESC(Bot, HomunsKillUp               , hku  ,
		"------ HomunsKillUp (hku) �T�u�R�}���h ------\n"
		"�z�����N���X���X�L���̃��x�����グ��B\n"
		"���͗� [@bot homunskillup �N���G �����^���`�F���W]\n"
	), SUBCMD_DESC(Bot, HomunStatus                , hs   ,
		"------ HomunStatus (hs) �T�u�R�}���h ------\n"
		"�z�����N���X�̃X�e�[�^�X��\������B\n"
		"���͗� [@bot homunstatus �N���G]\n"
	), SUBCMD_DESC(Bot, Item                       , i    ,
		"------ Item (i) �T�u�R�}���h ------\n"
		"�����A�C�e�����ꗗ�\������B\n"
		"���͗� [@bot item �n�C�v��]\n"
		"�A�C�e�����g�p����B\n"
		"���͗� [@bot item �n�C�v�� �|�[�V����]\n"
	), SUBCMD_DESC(Bot, ItemCount                  , ic   ,
		"------ ItemCount (ic) �T�u�R�}���h ------\n"
		"���ׂẴA�C�e���̏W�v���ꗗ�\������B\n"
		"���͗� [@bot itemcount]\n"
		"�C�ӂ̃A�C�e���̏W�v���ꗗ�\������B\n"
		"���͗� [@bot itemcount �[���s�[ �����S �Ȗ�]\n"
	), SUBCMD_DESC(Bot, ItemDrop                   , id   ,
		"------ ItemDrop (id) �T�u�R�}���h ------\n"
		"�A�C�e���̑S�����h���b�v����B\n"
		"���͗� [@bot itemdrop �n�C�v�� �C�O�h���V���̗t]\n"
		"�A�C�e���̓�������h���b�v����B\n"
		"���͗� [@bot itemdrop �n�C�v�� �C�O�h���V���̗t 2]\n"
	), SUBCMD_DESC(Bot, ItemIgnore                 , ii   ,
		"------ ItemIgnore (ii) �T�u�R�}���h ------\n"
		"�����A�C�e�����ꗗ�\������B\n"
		"���͗� [@bot itemignore]\n"
		"�����A�C�e����o�^����B\n"
		"���͗� [@bot itemignore \"���U�[�W���P�b�g [1]\"]\n"
		"�����A�C�e���̓o�^�𖕏�����B\n"
		"���͗� [@bot itemignore �u���[�t]\n"
	), SUBCMD_DESC(Bot, ItemIgnoreClear            ,      ,
		"------ ItemIgnoreClear �T�u�R�}���h ------\n"
		"�����A�C�e�����N���A����B\n"
		"���͗� [@bot itemignoreclear]\n"
	), SUBCMD_DESC(Bot, ItemIgnoreHave             , iih  ,
		"------ ItemIgnoreHave (iih) �T�u�R�}���h ------\n"
		"�������Ă���A�C�e�������ׂĖ����A�C�e���Ƃ��ēo�^����B\n"
		"���͗� [@bot itemignorehave]\n"
	), SUBCMD_DESC(Bot, ItemIgnoreImport           , iii  ,
		"------ ItemIgnoreImport (iii) �T�u�R�}���h ------\n"
		"�����A�C�e������荞�ށB\n"
		"���͗� [@bot itemignoreimport �`�����v]\n"
	), SUBCMD_DESC(Bot, ItemNotIgnore              , ini  ,
		"------ ItemNotIgnore (ini) �T�u�R�}���h ------\n"
		"�񖳎��A�C�e�����ꗗ�\������B\n"
		"���͗� [@bot itemnotignore]\n"
		"�񖳎��A�C�e����o�^����B\n"
		"���͗� [@bot itemnotignore �G���j�E��]\n"
		"�񖳎��A�C�e���̓o�^�𖕏�����B\n"
		"���͗� [@bot itemnotignore \"�V���o�[���[�u [1]\"]\n"
	), SUBCMD_DESC(Bot, ItemNotIgnoreClear         ,      ,
		"------ ItemNotIgnoreClear �T�u�R�}���h ------\n"
		"�񖳎��A�C�e�����N���A����B\n"
		"���͗� [@bot itemnotignoreclear]\n"
	), SUBCMD_DESC(Bot, ItemNotIgnoreHave          , inih ,
		"------ ItemNotIgnoreHave (inih) �T�u�R�}���h ------\n"
		"�������Ă���A�C�e�������ׂĔ񖳎��A�C�e���Ƃ��ēo�^����B\n"
		"���͗� [@bot itemnotignorehave]\n"
	), SUBCMD_DESC(Bot, ItemNotIgnoreImport        , inii ,
		"------ ItemNotIgnoreImport (inii) �T�u�R�}���h ------\n"
		"�񖳎��A�C�e������荞�ށB\n"
		"���͗� [@bot itemnotignoreimport �`�F�C�X]\n"
	), SUBCMD_DESC(Bot, ItemNotsaVeMonster         , invm ,
		"------ ItemNotsaVeMonster (invm) �T�u�R�}���h ------\n"
		"�A�C�e����ߖ񃂃��X�^�[���ꗗ�\������B\n"
		"���͗� [@bot itemnotsavemonster �A�T�N��]\n"
		"�A�C�e����ߖ񃂃��X�^�[��o�^����B\n"
		"���͗� [@bot itemnotsavemonster �A�T�N�� ���W�X�g�t�@�C�A�[�|�[�V���� �J�[�T]\n"
		"�A�C�e����ߖ񃂃��X�^�[�̓o�^�𖕏�����B\n"
		"���͗� [@bot itemnotsavemonster �A�T�N�� ���|�[�V���� �h�����f�X]\n"
	), SUBCMD_DESC(Bot, ItemNotsaVeMonsterClear    ,      ,
		"------ ItemNotsaVeMonsterClear �T�u�R�}���h ------\n"
		"�A�C�e����ߖ񃂃��X�^�[���N���A����B\n"
		"���͗� [@bot itemnotsavemonsterclear �A�T�N��]\n"
	), SUBCMD_DESC(Bot, ItemNotsaVeMonsterTransport, invmt,
		"------ ItemNotsaVeMonsterTransport (invmt) �T�u�R�}���h ------\n"
		"�A�C�e����ߖ񃂃��X�^�[��]������B\n"
		"���͗� [@bot itemnotsavemonstertransport �A�T�N�� �`�F�C�X]\n"
	), SUBCMD_DESC(Bot, ItemRecoverHp              , irh  ,
		"------ ItemRecoverHp (irh) �T�u�R�}���h ------\n"
		"HP�񕜃A�C�e�����ꗗ�\������B\n"
		"���͗� [@bot itemrecoverhp �A�T�N��]\n"
		"HP�񕜃A�C�e����o�^����B\n"
		"���͗� [@bot itemrecoverhp �A�T�N�� �ԃ|�[�V���� 50]\n"
		"HP�񕜃A�C�e���̓o�^�𖕏�����B\n"
		"���͗� [@bot itemrecoverhp �A�T�N�� ���|�[�V����]\n"
	), SUBCMD_DESC(Bot, ItemRecoverHpClear         ,      ,
		"------ ItemRecoverHpClear �T�u�R�}���h ------\n"
		"HP�񕜃A�C�e�����N���A����B\n"
		"���͗� [@bot itemrecoverhpclear �A�T�N��]\n"
	), SUBCMD_DESC(Bot, ItemRecoverHpTransport     , irht ,
		"------ ItemRecoverHpTransport (iht) �T�u�R�}���h ------\n"
		"HP�񕜃A�C�e����]������B\n"
		"���͗� [@bot itemrecoverhptransport �A�T�N�� �`�F�C�X]\n"
	), SUBCMD_DESC(Bot, ItemRecoverSp              , irs  ,
		"------ ItemRecoverSp (is) �T�u�R�}���h ------\n"
		"SP�񕜃A�C�e�����ꗗ�\������B\n"
		"���͗� [@bot itemrecoversp �n�C�v��]\n"
		"SP�񕜃A�C�e����o�^����B\n"
		"���͗� [@bot itemrecoversp �n�C�v�� �|�[�V���� 25]\n"
		"SP�񕜃A�C�e���̓o�^�𖕏�����B\n"
		"���͗� [@bot itemrecoversp �n�C�v�� �C�`�S]\n"
	), SUBCMD_DESC(Bot, ItemRecoverSpClear         ,      ,
		"------ ItemRecoverSpClear �T�u�R�}���h ------\n"
		"SP�񕜃A�C�e�����N���A����B\n"
		"���͗� [@bot itemrecoverspclear �n�C�v��]\n"
	), SUBCMD_DESC(Bot, ItemRecoverSpTransport     , irst ,
		"------ ItemRecoverSpTransport (ist) �T�u�R�}���h ------\n"
		"SP�񕜃A�C�e����]������B\n"
		"���͗� [@bot itemrecoversptransport �n�C�v�� �`�����v]\n"
	), SUBCMD_DESC(Bot, ItemsaVeMonster            , ivm  ,
		"------ ItemsaVeMonster (ivm) �T�u�R�}���h ------\n"
		"�A�C�e���ߖ񃂃��X�^�[���ꗗ�\������B\n"
		"���͗� [@bot itemsavemonster �A�T�N��]\n"
		"�A�C�e���ߖ񃂃��X�^�[��o�^����B\n"
		"���͗� [@bot itemsavemonster �A�T�N�� ���W�X�g�t�@�C�A�[�|�[�V���� ��O���[�g]\n"
		"�A�C�e���ߖ񃂃��X�^�[�̓o�^�𖕏�����B\n"
		"���͗� [@bot itemsavemonster �A�T�N�� ���|�[�V���� ���]\n"
	), SUBCMD_DESC(Bot, ItemsaVeMonsterClear       ,      ,
		"------ ItemsaVeMonsterClear �T�u�R�}���h ------\n"
		"�A�C�e���ߖ񃂃��X�^�[���N���A����B\n"
		"���͗� [@bot itemsavemonsterclear �A�T�N��]\n"
	), SUBCMD_DESC(Bot, ItemsaVeMonsterTransport   , ivmt ,
		"------ ItemsaVeMonsterTransport (ivmt) �T�u�R�}���h ------\n"
		"�A�C�e���ߖ񃂃��X�^�[��]������B\n"
		"���͗� [@bot itemsavemonstertransport �A�T�N�� �`�F�C�X]\n"
	), SUBCMD_DESC(Bot, ItemSell                   , is   ,
		"------ ItemSell (is) �T�u�R�}���h ------\n"
		"���p�A�C�e�����ꗗ�\������B\n"
		"���͗� [@bot itemsell]\n"
		"���p�A�C�e����o�^����B\n"
		"���͗� [@bot itemsell \"�{�E [3]\"]\n"
		"���p�A�C�e���̓o�^�𖕏�����B\n"
		"���͗� [@bot itemsell \"�n�b�g [1]\"]\n"
	), SUBCMD_DESC(Bot, ItemSellAll                , isa  ,
		"------ ItemSellAll (isa) �T�u�R�}���h ------\n"
		"�o�^�ς݂̃A�C�e�������ׂĔ��p����B\n"
		"���͗� [@bot itemsellall]\n"
	), SUBCMD_DESC(Bot, ItemSellClear              ,      ,
		"------ ItemSellClear �T�u�R�}���h ------\n"
		"���p�A�C�e�����N���A����B\n"
		"���͗� [@bot itemsellclear]\n"
	), SUBCMD_DESC(Bot, ItemSellHave               , ish  ,
		"------ ItemSellHave (ish) �T�u�R�}���h ------\n"
		"�������Ă���A�C�e�������ׂĔ��p�A�C�e���Ƃ��ēo�^����B\n"
		"���͗� [@bot itemsellhave]\n"
	), SUBCMD_DESC(Bot, ItemSellImport             , isi  ,
		"------ ItemSellImport (isi) �T�u�R�}���h ------\n"
		"���p�A�C�e������荞�ށB\n"
		"���͗� [@bot itemsellimport �X�~�X]\n"
	), SUBCMD_DESC(Bot, JournalImport              , ji   ,
		"------ JournalImport (ji) �T�u�R�}���h ------\n"
		"�W���[�i������荞�ށB\n"
		"���͗� [@bot journalimport �A�T�N��]\n"
	), SUBCMD_DESC(Bot, LogIn                      , li   ,
		"------ LogIn (li) �T�u�R�}���h ------\n"
		"Bot�����O�C��������B\n"
		"���͗� [@bot login acuser acpass �A�T�N��]\n"
	), SUBCMD_DESC(Bot, LogOut                     , lo   ,
		"------ LogOut (lo) �T�u�R�}���h ------\n"
		"Bot�����O�A�E�g������B\n"
		"���͗� [@bot logout �A�T�N��]\n"
	), SUBCMD_DESC(Bot, Loot                       , l    ,
		"------ Loot (l) �T�u�R�}���h ------\n"
		"�h���b�v�A�C�e�����E���悤�ɂ���B\n"
		"���͗� [@bot loot �N���G]\n"
		"�h���b�v�A�C�e�����E��Ȃ��悤�ɂ���B\n"
		"���͗� [@bot loot �N���G]\n"
	), SUBCMD_DESC(Bot, LootLimit                  , ll   ,
		"------ LootLimit (ll) �T�u�R�}���h ------\n"
		"�h���b�v�A�C�e�����E����d�ʂ𐧌�����B\n"
		"���͗� [@bot lootlimit �X�~�X 70]\n"
	), SUBCMD_DESC(Bot, MapEquipSet                , mes  ,
		"------ MapEquipSet (mes) �T�u�R�}���h ------\n"
		"�}�b�v����ꎮ���ꗗ�\������B\n"
		"���͗� [@bot mapequipset �A�T�N��]\n"
		"�}�b�v����ꎮ��o�^����B\n"
		"���͗� [@bot mapequipset �A�T�N�� pay_dun00]\n"
		"�}�b�v����ꎮ�̓o�^�𖕏�����B\n"
		"���͗� [@bot mapequipset �A�T�N�� pay_dun01]\n"
	), SUBCMD_DESC(Bot, MapEquipSetClear           ,      ,
		"------ MapEquipSetClear �T�u�R�}���h ------\n"
		"�}�b�v����ꎮ���N���A����B\n"
		"���͗� [@bot mapequipsetclear �A�T�N��]\n"
	), SUBCMD_DESC(Bot, MapEquipSetLoad            , mesl ,
		"------ MapEquipSetLoad (mesl) �T�u�R�}���h ------\n"
		"�}�b�v����ꎮ�����[�h����B\n"
		"���͗� [@bot mapequipsetload �A�T�N�� pay_dun00\n"
	), SUBCMD_DESC(Bot, MapEquipSetTransport       , mest ,
		"------ MapEquipSetTransport (mest) �T�u�R�}���h ------\n"
		"�}�b�v����ꎮ��]������B\n"
		"���͗� [@bot mapequipsettransport �A�T�N�� �`�F�C�X]\n"
	), SUBCMD_DESC(Bot, Memo                       , m    ,
		"------ Memo (m) �T�u�R�}���h ------\n"
		"���݂̈ʒu����������B\n"
		"���͗� [@bot memo �n�C�v��]\n"
	), SUBCMD_DESC(Bot, MonsterFirst               , mf   ,
		"------ MonsterFirst (mf) �T�u�R�}���h ------\n"
		"�D�惂���X�^�[���ꗗ�\������B\n"
		"���͗� [@bot monsterfirst �N���G]\n"
		"�D�惂���X�^�[��o�^����B\n"
		"���͗� [@bot monsterfirst �N���G �^�i�g�X�̑���]\n"
		"�D�惂���X�^�[�̓o�^�𖕏�����B\n"
		"���͗� [@bot monsterfirst �N���G �^�i�g�X�̐�]]\n"
	), SUBCMD_DESC(Bot, MonsterFirstClear          ,      ,
		"------ MonsterFirstClear �T�u�R�}���h ------\n"
		"�D�惂���X�^�[���N���A����B\n"
		"���͗� [@bot monsterfirstclear �N���G]\n"
	), SUBCMD_DESC(Bot, MonsterFirstTransport      , mft  ,
		"------ MonsterFirstTransport (mft) �T�u�R�}���h ------\n"
		"�D�惂���X�^�[��]������B\n"
		"���͗� [@bot monsterfirsttransport �N���G �X�~�X]\n"
	), SUBCMD_DESC(Bot, MonsterGreat               , mg   ,
		"------ MonsterGreat (mg) �T�u�R�}���h ------\n"
		"�O���[�g�����X�^�[���ꗗ�\������B\n"
		"���͗� [@bot monstergreat]\n"
		"�O���[�g�����X�^�[��o�^����B\n"
		"���͗� [@bot monstergreat �i�n�g�Y�B�[�K�[]\n"
		"�O���[�g�����X�^�[�̓o�^�𖕏�����B\n"
		"���͗� [@bot monstergreat �����N�̌��g�i�V�g�^�j]\n"
	), SUBCMD_DESC(Bot, MonsterGreatClear          ,      ,
		"------ MonsterGreatClear �T�u�R�}���h ------\n"
		"�O���[�g�����X�^�[���N���A����B\n"
		"���͗� [@bot monstergreatclear]\n"
	), SUBCMD_DESC(Bot, MonsterGreatImport         , mgi  ,
		"------ MonsterGreatImport (mgi) �T�u�R�}���h ------\n"
		"�O���[�g�����X�^�[����荞�ށB\n"
		"���͗� [@bot monstergreatimport �`�F�C�X]\n"
	), SUBCMD_DESC(Bot, MonsterHighDef             , mhd  ,
		"------ MonsterHighDef (mhd) �T�u�R�}���h ------\n"
		"�����X�^�[�̍�Def��ݒ肷��B\n"
		"���͗� [@bot monsterhighdef �A�T�N�� 40]\n"
	), SUBCMD_DESC(Bot, MonsterHighDefVit          , mhdv ,
		"------ MonsterHighDefVit (mhdv) �T�u�R�}���h ------\n"
		"�����X�^�[�̍�DefVit��ݒ肷��B\n"
		"���͗� [@bot monsterhighdefvit �A�T�N�� 100]\n"
	), SUBCMD_DESC(Bot, MonsterHighFlee            , mhf  ,
		"------ MonsterHighFlee (mhf) �T�u�R�}���h ------\n"
		"�����X�^�[�̍�Flee��ݒ肷��B\n"
		"���͗� [@bot monsterhighflee �A�T�N�� 150]\n"
	), SUBCMD_DESC(Bot, MonsterHighHit             , mhh  ,
		"------ MonsterHighHit (mhh) �T�u�R�}���h ------\n"
		"�����X�^�[�̍�Hit��ݒ肷��B\n"
		"���͗� [@bot monsterhighhit �A�T�N�� 175]\n"
	), SUBCMD_DESC(Bot, MonsterHighLevel           , mhl  ,
		"------ MonsterHighLevel (mhl) �T�u�R�}���h ------\n"
		"�����X�^�[�̍����x����ݒ肷��B\n"
		"���͗� [@bot monsterhighlevel �A�T�N�� 120]\n"
	), SUBCMD_DESC(Bot, MonsterHighMdef            , mhmd ,
		"------ MonsterHighMdef (mhmd) �T�u�R�}���h ------\n"
		"�����X�^�[�̍�Mdef��ݒ肷��B\n"
		"���͗� [@bot monsterhighmdef �A�T�N�� 40]\n"
	), SUBCMD_DESC(Bot, MonsterIgnore              , mi   ,
		"------ MonsterIgnore (mi) �T�u�R�}���h ------\n"
		"���������X�^�[���ꗗ�\������B\n"
		"���͗� [@bot monsterignore �N���G]\n"
		"���������X�^�[��o�^����B\n"
		"���͗� [@bot monsterignore �N���G �����N�̌��g�i�����^�j]\n"
		"���������X�^�[�̓o�^�𖕏�����B\n"
		"���͗� [@bot monsterignore �N���G �����N�̌��g�i����^�j]\n"
	), SUBCMD_DESC(Bot, MonsterIgnoreClear         ,      ,
		"------ MonsterIgnoreClear �T�u�R�}���h ------\n"
		"���������X�^�[���N���A����B\n"
		"���͗� [@bot monsterignoreclear �N���G]\n"
	), SUBCMD_DESC(Bot, MonsterIgnoreTransport     , mit  ,
		"------ MonsterIgnoreTransport (mit) �T�u�R�}���h ------\n"
		"���������X�^�[��]������B\n"
		"���͗� [@bot monsterignoretransport �N���G �X�~�X]\n"
	), SUBCMD_DESC(Bot, Next                       , n    ,
		"------ Next (n) �T�u�R�}���h ------\n"
		"���̃y�[�W��\������B\n"
		"���͗� [@bot next]\n"
	), SUBCMD_DESC(Bot, PetEquip                   , pe   ,
		"------ PetEquip (pe) �T�u�R�}���h ------\n"
		"�y�b�g���A�N�Z�T���[�𑕔�����B\n"
		"���͗� [@bot petequip �N���G]\n"
		"�y�b�g���A�N�Z�T���[�̑�������������B\n"
		"���͗� [@bot petequip �N���G]\n"
	), SUBCMD_DESC(Bot, PetStatus                  , ps   ,
		"------ PetStatus (ps) �T�u�R�}���h ------\n"
		"�y�b�g�̃X�e�[�^�X��\������B\n"
		"���͗� [@bot petstatus �N���G]\n"
	), SUBCMD_DESC(Bot, PolicyDistance             , pd   ,
		"------ PolicyDistance (pd) �T�u�R�}���h ------\n"
		"�����|���V�[���ꗗ�\������B\n"
		"���͗� [@bot policydistance �n�C�v��]\n"
		"�����|���V�[��o�^����B\n"
		"���͗� [@bot policydistance �n�C�v�� ��{ �ߐ�]\n"
		"�����|���V�[�̓o�^�𖕏�����B\n"
		"���͗� [@bot policydistance �n�C�v�� �O���[�g]\n"
	), SUBCMD_DESC(Bot, PolicyDistanceClear        ,      ,
		"------ PolicyDistanceClear �T�u�R�}���h ------\n"
		"�����|���V�[���N���A����B\n"
		"���͗� [@bot policydistanceclear �n�C�v��]\n"
	), SUBCMD_DESC(Bot, PolicyDistanceTransport    , pdt  ,
		"------ PolicyDistanceTransport (pdt) �T�u�R�}���h ------\n"
		"�����|���V�[��]������B\n"
		"���͗� [@bot policydistancetransport �n�C�v�� �`�����v]\n"
	), SUBCMD_DESC(Bot, PolicyNormalAttack         , pn   ,
		"------ PolicyNormalAttack (pn) �T�u�R�}���h ------\n"
		"�ʏ�U���|���V�[���ꗗ�\������B\n"
		"���͗� [@bot policynormalattack �n�C�v��]\n"
		"�ʏ�U���|���V�[��o�^����B\n"
		"���͗� [@bot policynormalattack �n�C�v�� ��{ �A��]\n"
		"�ʏ�U���|���V�[�̓o�^�𖕏�����B\n"
		"���͗� [@bot policynormalattack �n�C�v�� �O���[�g]\n"
	), SUBCMD_DESC(Bot, PolicyNormalAttackClear    ,      ,
		"------ PolicyNormalAttackClear �T�u�R�}���h ------\n"
		"�ʏ�U���|���V�[���N���A����B\n"
		"���͗� [@bot policynormalattackclear �n�C�v��]\n"
	), SUBCMD_DESC(Bot, PolicyNormalAttackTransport, pdt  ,
		"------ PolicyNormalAttackTransport (pdt) �T�u�R�}���h ------\n"
		"�ʏ�U���|���V�[��]������B\n"
		"���͗� [@bot policynormalattacktransport �n�C�v�� �`�����v]\n"
	), SUBCMD_DESC(Bot, ShopPointCollect           , spc  ,
		"------ ShopPointCollect (spc) �T�u�R�}���h ------\n"
		"���ׂĂ�Bot����S�V���b�v�|�C���g���������B\n"
		"���͗� [@bot shoppointcollect]\n"
		"�����Bot����S�V���b�v�|�C���g���������B\n"
		"���͗� [@bot shoppointcollect �n�C�v��]\n"
		"�����Bot�������V���b�v�|�C���g���������B\n"
		"���͗� [@bot shoppointcollect �n�C�v�� 100]\n"
	), SUBCMD_DESC(Bot, sKill                      , k    ,
		"------ sKill (k) �T�u�R�}���h ------\n"
		"�X�L�����ꗗ�\������B\n"
		"���͗� [@bot skill �n�C�v��]\n"
		"���ȃX�L�����ō����x���Ŏg�p����B\n"
		"���͗� [@bot skill �n�C�v�� �}�O�j�t�B�J�[�g]\n"
		"���ȃX�L������背�x���Ŏg�p����B\n"
		"���͗� [@bot skill �E������ �g������ 3]\n"
		"�^�[�Q�b�g�X�L���������o�[�ɍō����x���Ŏg�p����B\n"
		"���͗� [@bot skill �n�C�v�� �A�X���v�e�B�I �A�T�N��]\n"
		"�^�[�Q�b�g�X�L���������o�[�ɓ��背�x���Ŏg�p����B\n"
		"���͗� [@bot skill �n�C�v�� �q�[�� �A�T�N�� 3]\n"
		"�^�[�Q�b�g�X�L���������X�^�[�ɍō����x���Ŏg�p����B\n"
		"���͗� [@bot skill �v���t�F �t�@�C�A�[�{���g monster]\n"
		"�^�[�Q�b�g�X�L���������X�^�[�ɓ��背�x���Ŏg�p����B\n"
		"���͗� [@bot skill �n�C�E�B�Y �X�g�[���K�X�g monster 1]\n"
	), SUBCMD_DESC(Bot, sKillBerserkRate           , kbr  ,
		"------ sKillBerserkRate (kbr) �T�u�R�}���h ------\n"
		"�o�[�T�[�N�̔���HP����ݒ肷��B\n"
		"���͗� [@bot skillberserkrate �h�i 25]\n"
	), SUBCMD_DESC(Bot, sKillEnchantWeapon         , kew  ,
		"------ sKillEnchantWeapon (kew) �T�u�R�}���h ------\n"
		"���푮���t�^���ꗗ�\������B\n"
		"���͗� [@bot skillenchantweapon �A�T�N��]\n"
		"���푮���t�^��o�^����B\n"
		"���͗� [@bot skillenchantweapon �A�T�N�� iz_dun00 ������]\n"
		"���푮���t�^�̓o�^�𖕏�����B\n"
		"���͗� [@bot skillenchantweapon �A�T�N�� iz_dun00]\n"
	), SUBCMD_DESC(Bot, sKillEnchantWeaponClear    ,      ,
		"------ sKillEnchantWeaponClear �T�u�R�}���h ------\n"
		"���푮���t�^���N���A����B\n"
		"���͗� [@bot skillenchantweaponclear �A�T�N��]\n"
	), SUBCMD_DESC(Bot, sKillEnchantWeaponTransport, kewt ,
		"------ sKillEnchantWeaponTransport (kewt) �T�u�R�}���h ------\n"
		"���푮���t�^��]������B\n"
		"���͗� [@bot skillenchantweapontransport �A�T�N�� �`�F�C�X]\n"
	), SUBCMD_DESC(Bot, sKillEquipSet              , kes  ,
		"------ sKillEquipSet (kes) �T�u�R�}���h ------\n"
		"�X�L������ꎮ���ꗗ�\������B\n"
		"���͗� [@bot skillequipset �h�i]\n"
		"�X�L������ꎮ��o�^����B\n"
		"���͗� [@bot skillequipset �h�i �{�E�����O�o�b�V��]\n"
		"�X�L������ꎮ�̓o�^�𖕏�����B\n"
		"���͗� [@bot skillequipset �h�i �X�p�C�����s�A�[�X]\n"
	), SUBCMD_DESC(Bot, sKillEquipSetClear         ,      ,
		"------ sKillEquipSetClear �T�u�R�}���h ------\n"
		"�X�L������ꎮ���N���A����B\n"
		"���͗� [@bot skillequipsetclear �h�i]\n"
	), SUBCMD_DESC(Bot, sKillEquipSetLoad          , kesl ,
		"------ sKillEquipSetLoad (kesl) �T�u�R�}���h ------\n"
		"�X�L������ꎮ�����[�h����B\n"
		"���͗� [@bot skillequipsetload �h�i �{�E�����O�o�b�V��\n"
	), SUBCMD_DESC(Bot, sKillEquipSetTransport     , kest ,
		"------ sKillEquipSetTransport (kest) �T�u�R�}���h ------\n"
		"�X�L������ꎮ��]������B\n"
		"���͗� [@bot skillequipsettransport �h�i �h�i2]\n"
	), SUBCMD_DESC(Bot, sKillFirst                 , kf   ,
		"------ sKillFirst (kf) �T�u�R�}���h ------\n"
		"�D��X�L�����ꗗ�\������B\n"
		"���͗� [@bot skillfirst �n�C�E�B�Y]\n"
		"�D��X�L����o�^����B\n"
		"���͗� [@bot skillfirst �n�C�E�B�Y ������_���q�o�� �X�g�[���K�X�g]\n"
		"�D��X�L���̓o�^�𖕏�����B\n"
		"���͗� [@bot skillfirst �n�C�E�B�Y ������_���q�o��]\n"
	), SUBCMD_DESC(Bot, sKillFirstClear            ,      ,
		"------ sKillRejectClear �T�u�R�}���h ------\n"
		"�D��X�L�����N���A����B\n"
		"���͗� [@bot skillfirstclear �n�C�E�B�Y]\n"
	), SUBCMD_DESC(Bot, sKillFirstTransport        , kft  ,
		"------ sKillFirstTransport (kft) �T�u�R�}���h ------\n"
		"�D��X�L����]������B\n"
		"���͗� [@bot skillfirsttransport �n�C�E�B�Y �n�C�E�B�Y2]\n"
	), SUBCMD_DESC(Bot, sKillIgnoreMonster         , kim  ,
		"------ sKillIgnoreMonster (kim) �T�u�R�}���h ------\n"
		"�X�L�����������X�^�[���ꗗ�\������B\n"
		"���͗� [@bot skillignoremonster �N���G]\n"
		"�X�L�����������X�^�[��o�^����B\n"
		"���͗� [@bot skillignoremonster �N���G �A�V�b�h�f�����X�g���[�V���� ������_���q�o��]\n"
		"�X�L�����������X�^�[�̓o�^�𖕏�����B\n"
		"���͗� [@bot skillignoremonster �N���G �A�V�b�h�f�����X�g���[�V���� ������_���q�o��]\n"
	), SUBCMD_DESC(Bot, sKillIgnoreMonsterClear    ,      ,
		"------ sKillIgnoreMonsterClear �T�u�R�}���h ------\n"
		"�X�L�����������X�^�[���N���A����B\n"
		"���͗� [@bot skillignoremonsterclear �N���G]\n"
	), SUBCMD_DESC(Bot, sKillIgnoreMonsterTransport, kimt ,
		"------ sKillIgnoreMonsterTransport (kimt) �T�u�R�}���h ------\n"
		"�X�L�����������X�^�[��]������B\n"
		"���͗� [@bot skillignoremonstertransport �N���G �N���G2]\n"
	), SUBCMD_DESC(Bot, sKillLimit                 , kl   ,
		"------ sKillLimit (kl) �T�u�R�}���h ------\n"
		"�X�L���̃��x���𐧌�����B\n"
		"���͗� [@bot skilllimit �n�C�v�� �G���W�F���X 0]\n"
		"�X�L���̃��x����������������B\n"
		"���͗� [@bot skilllimit �n�C�v�� �G���W�F���X]\n"
	), SUBCMD_DESC(Bot, sKillmaXCastTime           , kxct ,
		"------ sKillmaXCastTime (kxct) �T�u�R�}���h ------\n"
		"�g�p��������ő�̉r�����Ԃ�ݒ肷��B\n"
		"���͗� [@bot skillmaxcasttime �n�C�E�B�Y 500]\n"
	), SUBCMD_DESC(Bot, sKillmemBers               , kb   ,
		"------ sKillmemBers (kb) �T�u�R�}���h ------\n"
		"�͈̓X�L���̔��������ƂȂ郁���o�[����ݒ肷��B\n"
		"���͗� [@bot skillmembers �N���G 2]\n"
	), SUBCMD_DESC(Bot, sKillMonsters              , km   ,
		"------ sKillMonsters (km) �T�u�R�}���h ------\n"
		"�͈̓X�L���̔��������ƂȂ郂���X�^�[����ݒ肷��B\n"
		"���͗� [@bot skillmonsters �n�C�v�� 1]\n"
	), SUBCMD_DESC(Bot, sKillPlay                  , kp   ,
		"------ sKillPlay (kp) �T�u�R�}���h ------\n"
		"���t�X�L�����ꗗ�\������B\n"
		"���͗� [@bot skillplay �N���E��]\n"
		"���t�X�L����o�^����B\n"
		"���͗� [@bot skillplay �N���E�� ��{ �[�z�̃A�T�V���N���X]\n"
		"���t�X�L���̓o�^�𖕏�����B\n"
		"���͗� [@bot skillplay �N���E�� �x��]\n"
	), SUBCMD_DESC(Bot, sKillPlayClear             ,      ,
		"------ sKillPlayClear �T�u�R�}���h ------\n"
		"���t�X�L�����N���A����B\n"
		"���͗� [@bot skillplayclear �N���E��]\n"
	), SUBCMD_DESC(Bot, sKillPlayTransport         , kpt  ,
		"------ sKillPlayTransport (kpt) �T�u�R�}���h ------\n"
		"���t�X�L����]������B\n"
		"���͗� [@bot skillplaytransport �N���E�� �W�v�V�[]\n"
	), SUBCMD_DESC(Bot, sKillReject                , kr   ,
		"------ sKillReject (kr) �T�u�R�}���h ------\n"
		"���ۃX�L�����ꗗ�\������B\n"
		"���͗� [@bot skillreject]\n"
		"���ۃX�L����o�^����B\n"
		"���͗� [@bot skillreject �N���E�� �A�X�y���V�I]\n"
		"���ۃX�L���̓o�^�𖕏�����B\n"
		"���͗� [@bot skillreject �N���E�� �C���|�V�e�B�I�}�k�X]\n"
	), SUBCMD_DESC(Bot, sKillRejectClear           ,      ,
		"------ sKillRejectClear �T�u�R�}���h ------\n"
		"���ۃX�L�����N���A����B\n"
		"���͗� [@bot skillrejectclear �N���E��]\n"
	), SUBCMD_DESC(Bot, sKillRejectTransport       , krt  ,
		"------ sKillRejectTransport (krt) �T�u�R�}���h ------\n"
		"���ۃX�L����]������B\n"
		"���͗� [@bot skillrejecttransport �N���E�� �W�v�V�[]\n"
	), SUBCMD_DESC(Bot, sKillSafeCastTime          , ksct ,
		"------ sKillSafeCastTime (ksct) �T�u�R�}���h ------\n"
		"���S�ɉr���ł��鎞�Ԃ�ݒ肷��B\n"
		"���͗� [@bot skillsafecasttime �n�C�E�B�Y 500]\n"
	), SUBCMD_DESC(Bot, sKillSupplyHpRate          , kshr ,
		"------ sKillSupplyHpRate (kshr) �T�u�R�}���h ------\n"
		"HP�̋�����������HP����ݒ肷��B\n"
		"���͗� [@bot skillsupplyhprate �A�T�N�� 90]\n"
	), SUBCMD_DESC(Bot, sKillSupplySpRate          , kssr ,
		"------ sKillSupplySpRate (kssr) �T�u�R�}���h ------\n"
		"SP�̋�����������SP����ݒ肷��B\n"
		"���͗� [@bot skillsupplysprate �A�T�N�� 10]\n"
	), SUBCMD_DESC(Bot, sKillTail                  , kt   ,
		"------ sKillTail (kt) �T�u�R�}���h ------\n"
		"�|���������Ԃ��ꗗ�\������B\n"
		"���͗� [@bot skilltail �n�C�v��]\n"
		"�|���������Ԃ�o�^����B\n"
		"���͗� [@bot skilltail �n�C�v�� �A�X���v�e�B�I 5000]\n"
		"�|���������Ԃ̓o�^�𖕏�����B\n"
		"���͗� [@bot skilltail �n�C�v�� �A�X���v�e�B�I]\n"
	), SUBCMD_DESC(Bot, sKillTailClear             ,      ,
		"------ sKillTailClear �T�u�R�}���h ------\n"
		"�|���������Ԃ��N���A����B\n"
		"���͗� [@bot skilltailclear �n�C�v��]\n"
	), SUBCMD_DESC(Bot, sKillTailTransport         , ktt  ,
		"------ sKillTailTransport (ktt) �T�u�R�}���h ------\n"
		"�|���������Ԃ�]������B\n"
		"���͗� [@bot skilltailtransport �n�C�v�� �n�C�v��2]\n"
	), SUBCMD_DESC(Bot, sKillUp                    , ku   ,
		"------ sKillUp (ku) �T�u�R�}���h ------\n"
		"�X�L���̃��x�����グ��B\n"
		"���͗� [@bot skillup �n�C�v�� ���C�X�C��]\n"
	), SUBCMD_DESC(Bot, Status                     , s    ,
		"------ Status (s) �T�u�R�}���h ------\n"
		"�X�e�[�^�X��\������B\n"
		"���͗� [@bot status �A�T�N��]\n"
	), SUBCMD_DESC(Bot, StatusUp                   , su   ,
		"------ StatusUp (su) �T�u�R�}���h ------\n"
		"�X�e�[�^�X��1�|�C���g������U��B\n"
		"���͗� [@bot statusup �A�T�N�� str]\n"
		"�X�e�[�^�X�ɓ���|�C���g������U��B\n"
		"���͗� [@bot statusup �A�T�N�� agi 5]\n"
	), SUBCMD_DESC(Bot, StorageGet                 , sg   ,
		"------ StorageGet (sg) �T�u�R�}���h ------\n"
		"�q�ɕ�[�A�C�e�����ꗗ�\������B\n"
		"���͗� [@bot storageget �N���G]\n"
		"�q�ɕ�[�A�C�e����o�^����B\n"
		"���͗� [@bot storageget �N���G ���|�[�V���� 100]\n"
		"�q�ɕ�[�A�C�e���̓o�^�𖕏�����B\n"
		"���͗� [@bot storageget �N���G ���|�[�V����]\n"
	), SUBCMD_DESC(Bot, StorageGetAll              , sga  ,
		"------ StorageGetAll (sga) �T�u�R�}���h ------\n"
		"�o�^�ς݂̃A�C�e�������ׂđq�ɂ�����o���B\n"
		"���͗� [@bot storagegetall]\n"
	), SUBCMD_DESC(Bot, StorageGetClear            ,      ,
		"------ StorageGetClear �T�u�R�}���h ------\n"
		"�q�ɕ�[�A�C�e�����N���A����B\n"
		"���͗� [@bot storagegetclear �N���G]\n"
	), SUBCMD_DESC(Bot, StorageGetTransport        , sgt  ,
		"------ StorageGetTransport (sgt) �T�u�R�}���h ------\n"
		"�q�ɕ�[�A�C�e����]������B\n"
		"���͗� [@bot storagegettransport �N���G �X�~�X]\n"
	), SUBCMD_DESC(Bot, StoragePut                 , sp   ,
		"------ StoragePut (sp) �T�u�R�}���h ------\n"
		"�q�Ɋi�[�A�C�e�����ꗗ�\������B\n"
		"���͗� [@bot storageput]\n"
		"�q�Ɋi�[�A�C�e����o�^����B\n"
		"���͗� [@bot storageput ���n�[�u]\n"
		"�q�Ɋi�[�A�C�e���̓o�^�𖕏�����B\n"
		"���͗� [@bot storageput ���̉H]\n"
	), SUBCMD_DESC(Bot, StoragePutAll              , spa  ,
		"------ StoragePutAll (spa) �T�u�R�}���h ------\n"
		"�o�^�ς݂̃A�C�e�������ׂđq�ɂɓ����B\n"
		"���͗� [@bot storageputall]\n"
	), SUBCMD_DESC(Bot, StoragePutClear            ,      ,
		"------ StoragePutClear �T�u�R�}���h ------\n"
		"�q�Ɋi�[�A�C�e�����N���A����B\n"
		"���͗� [@bot storageputclear]\n"
	), SUBCMD_DESC(Bot, StoragePutHave             , sph  ,
		"------ StoragePutHave (sph) �T�u�R�}���h ------\n"
		"�������Ă���A�C�e�������ׂđq�Ɋi�[�A�C�e���Ƃ��ēo�^����B\n"
		"���͗� [@bot storageputhave]\n"
	), SUBCMD_DESC(Bot, StoragePutImport           , spi  ,
		"------ StoragePutImport (spi) �T�u�R�}���h ------\n"
		"�q�Ɋi�[�A�C�e������荞�ށB\n"
		"���͗� [@bot storageputimport �`�F�C�X]\n"
	), SUBCMD_DESC(Bot, sUmmon                     , u    ,
		"------ sUmmon (u) �T�u�R�}���h ------\n"
		"���ׂĂ�Bot�������񂹂�B\n"
		"���͗� [@bot summon]\n"
		"�C�ӂ�Bot�������񂹂�B\n"
		"���͗� [@bot summon �N���E�� �v���t�F �n�C�v��]\n"
	), SUBCMD_DESC(Bot, Team                       , t    ,
		"------ Team (t) �T�u�R�}���h ------\n"
		"�����o�[���ꗗ�\������B\n"
		"���͗� [@bot team]\n"
	), SUBCMD_DESC(Bot, TeamLogIn                  , tli  ,
		"------ TeamLogIn (tli) �T�u�R�}���h ------\n"
		"0�Ԃ̃`�[�������O�C��������B\n"
		"���͗� [@bot teamlogin]\n"
		"����̔ԍ��̃`�[�������O�C��������B\n"
		"���͗� [@bot teamlogin 3]\n"
	), SUBCMD_DESC(Bot, TeamLogOut                 , tlo  ,
		"------ TeamLogOut (tlo) �T�u�R�}���h ------\n"
		"�`�[�������O�A�E�g������B\n"
		"���͗� [@bot teamlogout]\n"
	), SUBCMD_DESC(Bot, TeamNumber                 , tn   ,
		"------ TeamNumber (tn) �T�u�R�}���h ------\n"
		"�`�[���̈ꗗ��\������B\n"
		"���͗� [@bot teamnumber]\n"
		"�`�[����o�^����B\n"
		"���͗� [@bot teamnumber 3]\n"
		"�`�[���𖕏�����B\n"
		"���͗� [@bot teamnumber 3]\n"
	), SUBCMD_DESC(Bot, TeamOrder                  , to   ,
		"------ TeamOrder (to) �T�u�R�}���h ------\n"
		"�����o�[�̏��Ԃ�ύX����B\n"
		"���͗� [@bot teamorder �N���G �A�T�N�� �n�C�v��]\n"
	), SUBCMD_DESC(Bot, TeamPassive                , tp   ,
		"------ TeamPassive (tp) �T�u�R�}���h ------\n"
		"�����X�^�[�ɔ������Ȃ��悤�ɂ���B\n"
		"���͗� [@bot teampassive]\n"
		"Bot�������X�^�[�ɔ�������悤�ɂ���B\n"
		"���͗� [@bot teampassive]\n"
	), SUBCMD_DESC(Bot, TeamRush                   , tr   ,
		"------ TeamRush (tr) �T�u�R�}���h ------\n"
		"�����X�^�[�������ɍU������B\n"
		"���͗� [@bot teamrush]\n"
		"�����X�^�[��S�͂ōU������B\n"
		"���͗� [@bot teamrush]\n"
		"���b�V�����[�h����������B\n"
		"���͗� [@bot teamrush]\n"
	), SUBCMD_DESC(Bot, TeamStay                   , ts   ,
		"------ TeamStay (ts) �T�u�R�}���h ------\n"
		"���̏�őҋ@����悤�ɂ���B\n"
		"���͗� [@bot teamstay]\n"
		"���[�_�[��ǂ�������悤�ɂ���B\n"
		"���͗� [@bot teamstay]\n"
	), SUBCMD_DESC(Bot, TradeItem                  , ti   ,
		"------ TradeItem (ti) �T�u�R�}���h ------\n"
		"�A�C�e���̑S��������ɒǉ�����B\n"
		"���͗� [@bot tradeitem �u���[�W�F���X�g�[��]\n"
		"�A�C�e���̓����������ɒǉ�����B\n"
		"���͗� [@bot tradeitem �u���[�W�F���X�g�[�� 3]\n"
	), SUBCMD_DESC(Bot, TradeZeny                  , tz   ,
		"------ TradeZeny (tz) �T�u�R�}���h ------\n"
		"�������̑S�z������ɒǉ�����B\n"
		"���͗� [@bot tradezeny]\n"
		"�������̓���z������ɒǉ�����B\n"
		"���͗� [@bot tradezeny 5000]\n"
	), SUBCMD_DESC(Bot, Warp                       , w    ,
		"------ Warp (w) �T�u�R�}���h ------\n"
		"���[�v�ʒu���ꗗ�\������B\n"
		"���͗� [@bot warp �n�C�v��]\n"
		"���[�v�|�[�^�����J���B\n"
		"���͗� [@bot warp �n�C�v�� prt_fild08]\n"
		"����̍��W�ւ̃��[�v�|�[�^�����J���B\n"
		"���͗� [@bot warp �n�C�v�� prt_fild08 100 200]\n"
	),
};

// @Bot�̃T�u�R�}���h�葱���̃x�N�^�B
const std::vector<ptr<subcommand_proc>> BOT_SUBCMD_PROCS = {
	SUBCMD_PROC(Bot, Attack                     , a    ),
	SUBCMD_PROC(Bot, BufferEquipSet             , bes  ),
	SUBCMD_PROC(Bot, BufferEquipSetClear        ,      ),
	SUBCMD_PROC(Bot, BufferEquipSetLoad         , besl ),
	SUBCMD_PROC(Bot, BufferEquipSetTransport    , best ),
	SUBCMD_PROC(Bot, Cart                       , c    ),
	SUBCMD_PROC(Bot, CartAutoGet                , cag  ),
	SUBCMD_PROC(Bot, CartAutoGetClear           ,      ),
	SUBCMD_PROC(Bot, CartAutoGetTransport       , cagt ),
	SUBCMD_PROC(Bot, CartGet                    , cg   ),
	SUBCMD_PROC(Bot, CartPut                    , cp   ),
	SUBCMD_PROC(Bot, DistancemaX                , dx   ),
	SUBCMD_PROC(Bot, DistancemiN                , dn   ),
	SUBCMD_PROC(Bot, Equip                      , e    ),
	SUBCMD_PROC(Bot, EquipIdentifyAll           , eia  ),
	SUBCMD_PROC(Bot, EquipRepairAll             , era  ),
	SUBCMD_PROC(Bot, EquipSet                   , es   ),
	SUBCMD_PROC(Bot, EquipSetClear              ,      ),
	SUBCMD_PROC(Bot, EquipSetLoad               , esl  ),
	SUBCMD_PROC(Bot, EquipSetTransport          , est  ),
	SUBCMD_PROC(Bot, Help                       , h    ),
	SUBCMD_PROC(Bot, HoldMonsters               , hm   ),
	SUBCMD_PROC(Bot, HomunsKill                 , hk   ),
	SUBCMD_PROC(Bot, HomunsKillLimit            , hkl  ),
	SUBCMD_PROC(Bot, HomunsKillUp               , hku  ),
	SUBCMD_PROC(Bot, HomunStatus                , hs   ),
	SUBCMD_PROC(Bot, Item                       , i    ),
	SUBCMD_PROC(Bot, ItemCount                  , ic   ),
	SUBCMD_PROC(Bot, ItemDrop                   , id   ),
	SUBCMD_PROC(Bot, ItemIgnore                 , ii   ),
	SUBCMD_PROC(Bot, ItemIgnoreClear            ,      ),
	SUBCMD_PROC(Bot, ItemIgnoreHave             , iih  ),
	SUBCMD_PROC(Bot, ItemIgnoreImport           , iii  ),
	SUBCMD_PROC(Bot, ItemNotIgnore              , ini  ),
	SUBCMD_PROC(Bot, ItemNotIgnoreClear         ,      ),
	SUBCMD_PROC(Bot, ItemNotIgnoreHave          , inih ),
	SUBCMD_PROC(Bot, ItemNotIgnoreImport        , inii ),
	SUBCMD_PROC(Bot, ItemNotsaVeMonster         , invm ),
	SUBCMD_PROC(Bot, ItemNotsaVeMonsterClear    ,      ),
	SUBCMD_PROC(Bot, ItemNotsaVeMonsterTransport, invmt),
	SUBCMD_PROC(Bot, ItemRecoverHp              , irh  ),
	SUBCMD_PROC(Bot, ItemRecoverHpClear         ,      ),
	SUBCMD_PROC(Bot, ItemRecoverHpTransport     , irht ),
	SUBCMD_PROC(Bot, ItemRecoverSp              , irs  ),
	SUBCMD_PROC(Bot, ItemRecoverSpClear         ,      ),
	SUBCMD_PROC(Bot, ItemRecoverSpTransport     , irst ),
	SUBCMD_PROC(Bot, ItemsaVeMonster            , ivm  ),
	SUBCMD_PROC(Bot, ItemsaVeMonsterClear       ,      ),
	SUBCMD_PROC(Bot, ItemsaVeMonsterTransport   , ivmt ),
	SUBCMD_PROC(Bot, ItemSell                   , is   ),
	SUBCMD_PROC(Bot, ItemSellAll                , isa  ),
	SUBCMD_PROC(Bot, ItemSellClear              ,      ),
	SUBCMD_PROC(Bot, ItemSellHave               , ish  ),
	SUBCMD_PROC(Bot, ItemSellImport             , isi  ),
	SUBCMD_PROC(Bot, JournalImport              , ji   ),
	SUBCMD_PROC(Bot, LogIn                      , li   ),
	SUBCMD_PROC(Bot, LogOut                     , lo   ),
	SUBCMD_PROC(Bot, Loot                       , l    ),
	SUBCMD_PROC(Bot, LootLimit                  , ll   ),
	SUBCMD_PROC(Bot, MapEquipSet                , mes  ),
	SUBCMD_PROC(Bot, MapEquipSetClear           ,      ),
	SUBCMD_PROC(Bot, MapEquipSetLoad            , mesl ),
	SUBCMD_PROC(Bot, MapEquipSetTransport       , mest ),
	SUBCMD_PROC(Bot, Memo                       , m    ),
	SUBCMD_PROC(Bot, MonsterFirst               , mf   ),
	SUBCMD_PROC(Bot, MonsterFirstClear          ,      ),
	SUBCMD_PROC(Bot, MonsterFirstTransport      , mft  ),
	SUBCMD_PROC(Bot, MonsterGreat               , mg   ),
	SUBCMD_PROC(Bot, MonsterGreatClear          ,      ),
	SUBCMD_PROC(Bot, MonsterGreatImport         , mgi  ),
	SUBCMD_PROC(Bot, MonsterHighDef             , mhd  ),
	SUBCMD_PROC(Bot, MonsterHighDefVit          , mhdv ),
	SUBCMD_PROC(Bot, MonsterHighFlee            , mhf  ),
	SUBCMD_PROC(Bot, MonsterHighHit             , mhh  ),
	SUBCMD_PROC(Bot, MonsterHighLevel           , mhl  ),
	SUBCMD_PROC(Bot, MonsterHighMdef            , mhmd ),
	SUBCMD_PROC(Bot, MonsterIgnore              , mi   ),
	SUBCMD_PROC(Bot, MonsterIgnoreClear         ,      ),
	SUBCMD_PROC(Bot, MonsterIgnoreTransport     , mit  ),
	SUBCMD_PROC(Bot, Next                       , n    ),
	SUBCMD_PROC(Bot, PetEquip                   , pe   ),
	SUBCMD_PROC(Bot, PetStatus                  , ps   ),
	SUBCMD_PROC(Bot, PolicyDistance             , pd   ),
	SUBCMD_PROC(Bot, PolicyDistanceClear        ,      ),
	SUBCMD_PROC(Bot, PolicyDistanceTransport    , pdt  ),
	SUBCMD_PROC(Bot, PolicyNormalAttack         , pna  ),
	SUBCMD_PROC(Bot, PolicyNormalAttackClear    ,      ),
	SUBCMD_PROC(Bot, PolicyNormalAttackTransport, pnat ),
	SUBCMD_PROC(Bot, ShopPointCollect           , spc  ),
	SUBCMD_PROC(Bot, sKill                      , k    ),
	SUBCMD_PROC(Bot, sKillBerserkRate           , kbr  ),
	SUBCMD_PROC(Bot, sKillEnchantWeapon         , kew  ),
	SUBCMD_PROC(Bot, sKillEnchantWeaponClear    ,      ),
	SUBCMD_PROC(Bot, sKillEnchantWeaponTransport, kewt ),
	SUBCMD_PROC(Bot, sKillEquipSet              , kes  ),
	SUBCMD_PROC(Bot, sKillEquipSetClear         ,      ),
	SUBCMD_PROC(Bot, sKillEquipSetLoad          , kesl ),
	SUBCMD_PROC(Bot, sKillEquipSetTransport     , kest ),
	SUBCMD_PROC(Bot, sKillFirst                 , kf   ),
	SUBCMD_PROC(Bot, sKillFirstClear            ,      ),
	SUBCMD_PROC(Bot, sKillFirstTransport        , kft  ),
	SUBCMD_PROC(Bot, sKillIgnoreMonster         , kim  ),
	SUBCMD_PROC(Bot, sKillIgnoreMonsterClear    ,      ),
	SUBCMD_PROC(Bot, sKillIgnoreMonsterTransport, kimt ),
	SUBCMD_PROC(Bot, sKillLimit                 , kl   ),
	SUBCMD_PROC(Bot, sKillmaXCastTime           , kxct ),
	SUBCMD_PROC(Bot, sKillmemBers               , kb   ),
	SUBCMD_PROC(Bot, sKillMonsters              , km   ),
	SUBCMD_PROC(Bot, sKillPlay                  , kp   ),
	SUBCMD_PROC(Bot, sKillPlayClear             ,      ),
	SUBCMD_PROC(Bot, sKillPlayTransport         , kpt  ),
	SUBCMD_PROC(Bot, sKillReject                , kr   ),
	SUBCMD_PROC(Bot, sKillRejectClear           ,      ),
	SUBCMD_PROC(Bot, sKillRejectTransport       , krt  ),
	SUBCMD_PROC(Bot, sKillSafeCastTime          , ksct ),
	SUBCMD_PROC(Bot, sKillSupplyHpRate          , kshr ),
	SUBCMD_PROC(Bot, sKillSupplySpRate          , kssr ),
	SUBCMD_PROC(Bot, sKillTail                  , kt   ),
	SUBCMD_PROC(Bot, sKillTailClear             ,      ),
	SUBCMD_PROC(Bot, sKillTailTransport         , ktt  ),
	SUBCMD_PROC(Bot, sKillUp                    , ku   ),
	SUBCMD_PROC(Bot, Status                     , s    ),
	SUBCMD_PROC(Bot, StatusUp                   , su   ),
	SUBCMD_PROC(Bot, StorageGet                 , sg   ),
	SUBCMD_PROC(Bot, StorageGetAll              , sga  ),
	SUBCMD_PROC(Bot, StorageGetClear            ,      ),
	SUBCMD_PROC(Bot, StorageGetTransport        , sgt  ),
	SUBCMD_PROC(Bot, StoragePut                 , sp   ),
	SUBCMD_PROC(Bot, StoragePutAll              , spa  ),
	SUBCMD_PROC(Bot, StoragePutClear            ,      ),
	SUBCMD_PROC(Bot, StoragePutHave             , sph  ),
	SUBCMD_PROC(Bot, StoragePutImport           , spi  ),
	SUBCMD_PROC(Bot, sUmmon                     , u    ),
	SUBCMD_PROC(Bot, Team                       , t    ),
	SUBCMD_PROC(Bot, TeamLogIn                  , tli  ),
	SUBCMD_PROC(Bot, TeamLogOut                 , tlo  ),
	SUBCMD_PROC(Bot, TeamNumber                 , tn   ),
	SUBCMD_PROC(Bot, TeamOrder                  , to   ),
	SUBCMD_PROC(Bot, TeamPassive                , tp   ),
	SUBCMD_PROC(Bot, TeamRush                   , tr   ),
	SUBCMD_PROC(Bot, TeamStay                   , ts   ),
	SUBCMD_PROC(Bot, TradeItem                  , ti   ),
	SUBCMD_PROC(Bot, TradeZeny                  , tz   ),
	SUBCMD_PROC(Bot, Warp                       , w    ),
};

// �����̔j���������^�O�B
const std::string BROKEN_EQUIP_TAG = "�j��";

// �J�[�h���̐ڔ����B
const std::string CARD_NAME_POSTFIX = "�J�[�h";

// �Ԃ̎�����NPC���B
const std::string CASTLE_TRIAL_NPC_NAME = "CastleTrial";

// �x���������^�O�B
const std::string CAUTION_TAG = "�x��";

// �ߑ������̐ړ����B
const std::string COSTUME_PREFIX = "[�ߑ�] ";

// �f�t�H���g�����|���V�[�l�̃}�b�v�B
const std::unordered_map<
	e_job,                 // �E�ƁB
	distance_policy_values // �����|���V�[�l�B
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

// �f�t�H���g�̏E�������B
const int DEFAULT_LOOT_LIMIT = 100;

// �f�t�H���g�̃����X�^�[�̍�Def�B
const int DEFAULT_MOB_HIGH_DEF = 40;

// �f�t�H���g�̃����X�^�[�̍�DefVit�B
const int DEFAULT_MOB_HIGH_DEF_VIT = 100;

// �f�t�H���g�̃����X�^�[�̍�Flee�B
const int DEFAULT_MOB_HIGH_FLEE = 150;

// �f�t�H���g�̃����X�^�[�̍�Hit�B
const int DEFAULT_MOB_HIGH_HIT = 175;

// �f�t�H���g�̃����X�^�[�̍����x���B
const int DEFAULT_MOB_HIGH_LEVEL = 100;

// �f�t�H���g�̃����X�^�[�̍�Mdef�B
const int DEFAULT_MOB_HIGH_MDEF = 40;

// �f�t�H���g�ʏ�U���|���V�[�l�̃}�b�v�B
const std::unordered_map<
	e_job,                      // �E�ƁB
	normal_attack_policy_values // �ʏ�U���|���V�[�l�B
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

// �f�t�H���g�̒�_���[�W�{���B
const int DEFAULT_SKILL_LOW_RATE = 100;

// �f�t�H���g�͈̔̓X�L���̔��������ƂȂ郁���o�[���B
const int DEFAULT_SKILL_MEMBERS = 3;

// �f�t�H���g�͈̔̓X�L���̔��������ƂȂ郂���X�^�[���B
const int DEFAULT_SKILL_MOBS = 3;

// �f�t�H���g��HP�̋�����������HP���B
const int DEFAULT_SUPPLY_HP_RATE = 100;

// �f�t�H���g��SP�̋�����������SP���B
const int DEFAULT_SUPPLY_SP_RATE = 25;

// �����|���V�[�l���̃e�[�u���B
const std::array<
	std::string, // �����|���V�[�l���B
	DPV_MAX      // �����|���V�[�l�̐��B
> DISTANCE_POLICY_VALUE_NAME_TABLE = {
	UNKNOWN_SYMBOL,
	"�ߐ�"        ,
	"���u"        ,
};

// �_�u���t�B�[�o�[�}�b�v�̐��B
const int DOUBLE_FEVER_MAPS_SIZE = 2;

// �������̃e�[�u���B
const std::array<
	std::string, // �������B
	10           // �����̐��B
> ELEMENT_NAME_TABLE = {
	"������"  ,
	"������"  ,
	"�n����"  ,
	"�Α���"  ,
	"������"  ,
	"�ő���"  ,
	"������"  ,
	"�ő���"  ,
	"�O����"  ,
	"�s������",
};

// ������X�L�����j�b�g�L�[�̃}�b�v�B
const skill_unit_key_map ELEMENTAL_SKILL_UNIT_KEYS = {
	SKILL_UNIT_KEY(NJ_KAENSIN      ),
	SKILL_UNIT_KEY(NJ_SUITON       ),
	SKILL_UNIT_KEY(SA_DELUGE       ),
	SKILL_UNIT_KEY(SA_LANDPROTECTOR),
	SKILL_UNIT_KEY(SA_VIOLENTGALE  ),
	SKILL_UNIT_KEY(SA_VOLCANO      ),
};

// �������ݒu�s�ȃX�L�����j�b�g�L�[�̃}�b�v�B
const skill_unit_key_map ELEMENTAL_UNLAYABLE_SKILL_UNIT_KEYS = {
	SKILL_UNIT_KEY(BD_LULLABY        ),
	SKILL_UNIT_KEY(BD_RICHMANKIM     ),
	SKILL_UNIT_KEY(BD_ETERNALCHAOS   ),
	SKILL_UNIT_KEY(BD_DRUMBATTLEFIELD),
	SKILL_UNIT_KEY(BD_RINGNIBELUNGEN ),
	SKILL_UNIT_KEY(BD_ROKISWEIL      ),
	SKILL_UNIT_KEY(BD_INTOABYSS      ),
	SKILL_UNIT_KEY(BD_SIEGFRIED      ),
	SKILL_UNIT_KEY(BA_DISSONANCE     ),
	SKILL_UNIT_KEY(BA_WHISTLE        ),
	SKILL_UNIT_KEY(BA_ASSASSINCROSS  ),
	SKILL_UNIT_KEY(BA_POEMBRAGI      ),
	SKILL_UNIT_KEY(BA_APPLEIDUN      ),
	SKILL_UNIT_KEY(DC_UGLYDANCE      ),
	SKILL_UNIT_KEY(DC_HUMMING        ),
	SKILL_UNIT_KEY(DC_DONTFORGETME   ),
	SKILL_UNIT_KEY(DC_FORTUNEKISS    ),
	SKILL_UNIT_KEY(DC_SERVICEFORYOU  ),
	SKILL_UNIT_KEY(PA_GOSPEL         ),
	SKILL_UNIT_KEY(HP_BASILICA       ),
	SKILL_UNIT_KEY(CG_MOONLIT        ),
};

// �G�X�L���A�h�o���e�[�W�̃}�b�v�B
const std::unordered_map<e_skill,int> ENEMY_SKILL_ADVANTAGES_AWAY = {
	{AL_PNEUMA       ,   100},
	{WZ_QUAGMIRE     ,   -20},
	{AM_DEMONSTRATION, -1000},
	{AS_VENOMDUST    ,    -1},
	{SA_LANDPROTECTOR,   200},
	{NPC_EVILLAND    ,  -100},
};

// �G�X�L���A�h�o���e�[�W�̃}�b�v�B
const std::unordered_map<e_skill,int> ENEMY_SKILL_ADVANTAGES_CLOSE = {
	{MG_SAFETYWALL   ,   100},
};

// �������ʂ̏����𑕔����ʂ̃C���f�b�N�X�ɕϊ�����e�[�u���B
const std::array<
	equip_index, // �������ʂ̃C���f�b�N�X�B
	EPO_MAX      // �������ʂ̏����̐��B
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

// �������ʖ��̃e�[�u���B
const std::array<
	std::string, // �������ʖ��B
	EQI_MAX      // �������ʂ̐��B
> EQUIP_POS_NAME_TABLE = {
	"���A"   ,
	"�E�A"   ,
	"��"     ,
	"��"     ,
	"����"   ,
	"����"   ,
	"����"   ,
	"��"     ,
	"����"   ,
	"�E��"   ,
	"�ߓ���" ,
	"�ߓ���" ,
	"�ߓ���" ,
	"�ߌ�"   ,
	"��/�e"  ,
	"�e��"   ,
	"�e�E��" ,
	"�e����" ,
	"�e��"   ,
	"�e�E�A" ,
	"�e���A" ,
};

// 2�o�C�g�ڂ��G�X�P�[�v�w�蕶���̑S�p�������܂ޕ������u�������邽�߂̃e�[�u���B
const std::vector<std::pair<std::string, std::string>> ESCAPING_TABLE = {
	{"�^", "�"},
};

// �\�I�X�L���̃Z�b�g�B
const skill_id_set EXPOSURE_SKILLS = {
	AL_RUWACH,
	MG_SIGHT ,
};

// �����t���ł��邱�Ƃ������I�t�Z�b�g�B
const int FAME_OFFSET = 30000;

// �����t���ł��邱�Ƃ������^�O�B
const std::string FAME_TAG = "�����t��";

// �t�B�[�o�[�{���̃L�[�B
const std::string FEVER_RATE_KEY = "FEVER_RATE";

// �O���[�g��ԕω��^�C�v�̃Z�b�g�B
const sc_type_set GREAT_SC_TYPES = {
	SC_ADRENALINE,
	SC_INCATKRATE,
	SC_INCFLEERATE,
	SC_INCHITRATE,
	SC_REFLECTSHIELD,
	SC_SPEEDUP1,
	SC_TWOHANDQUICKEN,
};

// �M���h�q�ɗ��p���B
const int GUILD_STORAGE_FEE = 200;

// �z�����N���X�X�L���ɂ��A�C�R�����̃}�b�v�B
const std::unordered_map<
	sc_type,    // ��ԕω��̃^�C�v�B
	std::string // �A�C�R�����B
> HOMUN_ICON_NAMES = {
	{SC_AVOID    , "�ً}���"          },
	{SC_BLOODLUST, "�u���b�h���X�g"    },
	{SC_CHANGE   , "�����^���`�F���W"  },
	{SC_DEFENCE  , "�f�B�t�F���X"      },
	{SC_FLEET    , "�t���b�g���[�u"    },
	{SC_SPEED    , "�I�[�o�[�h�X�s�[�h"},
};

// �A�C�R�����̃e�[�u���B
const std::array<
	std::string, // �A�C�R����
	EFST_MAX     // �A�C�R���̐��B
> ICON_NAME_TABLE = {
	"�v���{�b�N",
	"�C���f���A",
	"�c�[�n���h�N�C�b�P��",
	"�W���͌���",
	"�n�C�f�B���O",
	"�N���[�L���O",
	"���푮���t�^(��)",
	"�|�C�Y�����A�N�g",
	"�N�@�O�}�C�A",
	"�G���W�F���X",
	"�u���b�V���O",
	"�V�O�i���N���V�X",
	"���x����",
	"���x����",
	"�X���[�|�C�Y��",
	"�C���|�V�e�B�I�}�k�X",
	"�T�t���M�E��",
	"���푮���t�^(��)",
	"�Z�����t�^",
	"�L���G�G���C�\��",
	"�}�O�j�t�B�J�[�g",
	"�O�����A",
	"���b�N�X�G�[�e���i",
	"�A�h���i�������b�V��",
	"�E�F�|���p�[�t�F�N�V����",
	"�I�[�o�[�g���X�g",
	"�}�L�V�}�C�Y�p���[",
	"�R�撆",
	"�t�@���R���}�X�^���[",
	"���񂾂ӂ�",
	"���E�h�{�C�X",
	"�G�i�W�[�R�[�g",
	"�Z�j����",
	"����j����",
	"���o���",
	"�d��50%�ȏ�",
	"�d��90%�ȏ�",
	"�U�����x����",
	"�U�����x����",
	"�U�����x����",
	UNKNOWN_SYMBOL,
	"�ړ����x����",
	"�ړ����x����",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"����������",
	"���������",
	"�Z�������",
	"���������",
	"�P�~�J���E�F�|���`���[�W",
	"�P�~�J���V�[���h�`���[�W",
	"�P�~�J���A�[�}�[�`���[�W",
	"�P�~�J���w�����`���[�W",
	"�I�[�g�K�[�h",
	"���t���N�g�V�[���h",
	UNKNOWN_SYMBOL,
	"�v�����B�f���X",
	"�f�B�t�F���_�[",
	UNKNOWN_SYMBOL,
	"���푮���t�^",
	"�I�[�g�X�y��",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�X�s�A�N�C�b�P��",
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
	"����",
	"���C���e����",
	UNKNOWN_SYMBOL,
	"���푮���t�^(��)",
	"���푮���t�^(��)",
	"���푮���t�^(��)",
	"���푮���t�^(�n)",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�Z�����t�^(�s��)",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�p���C���O",
	UNKNOWN_SYMBOL,
	"�e���V���������b�N�X",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�A�X���v�e�B�I",
	UNKNOWN_SYMBOL,
	"�W�F���X�g�[���̏���Ȃ���",
	UNKNOWN_SYMBOL,
	"�G���`�����g�f�b�h���[�|�C�Y��",
	"�g�D���[�T�C�g",
	"�E�B���h�E�H�[�N",
	"�����g�_�E��",
	"�J�[�g�u�[�X�g",
	UNKNOWN_SYMBOL,
	"���W�F�N�g�\�[�h",
	"�}���I�l�b�g�R���g���[��",
	"�}���I�l�b�g�R���g���[��",
	UNKNOWN_SYMBOL,
	"�o�����",
	"�W���C���g�r�[�g",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�}�}�A�p�p��D��",
	UNKNOWN_SYMBOL,
	"�I�[�g�o�[�T�[�N",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�t�F�I���`���M�̍\��",
	UNKNOWN_SYMBOL,
	"�l�����`���M�̍\��",
	UNKNOWN_SYMBOL,
	"�g�������`���M�̍\��",
	UNKNOWN_SYMBOL,
	"�A�v�`���I�����M�̍\��",
	UNKNOWN_SYMBOL,
	"���@",
	UNKNOWN_SYMBOL,
	"�X�p�[�g",
	"���푮���t�^(��)",
	"�t���A�h���i�������b�V��",
	"���푮���t�^(�O)",
	UNKNOWN_SYMBOL,
	"[SP]Atk�㏸",
	"[SP]Matk�㏸",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�J�C�[��",
	"�J�A�q",
	"�J�E�v",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�����n���h�N�C�b�P��",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"���z�̈��y",
	"���̈��y",
	"���̈��y",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�v���U�[�u",
	"�`�F�C�X�E�H�[�N",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�_�u���L���X�e�B���O",
	UNKNOWN_SYMBOL,
	"�I�[�o�[�g���X�g�}�b�N�X",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�^���̃^���b�g�J�[�h",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�V�������N",
	"�T�C�g�u���X�^�[",
	UNKNOWN_SYMBOL,
	"�N���[�Y�R���t�@�C��",
	"�N���[�Y�R���t�@�C��",
	UNKNOWN_SYMBOL,
	"�}�b�h�l�X�L�����Z���[",
	"�K�g�����O�t�B�[�o�[",
	"�y�������",
	"���",
	"�e���g",
	"�O",
	"�A�W���X�g�����g",
	"�C���N���[�W���O�A�L�����V�[",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�R�撆",
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
	"����",
	"����",
	"����",
	"����",
	"����",
	"����",
	"����",
	"����",
	"����",
	"�l���o���l����",
	"[SP]�����ی���",
	"�h���b�v������",
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
	"[SP]Str����",
	"[SP]Agi����",
	"[SP]Vit����",
	"[SP]Dex����",
	"[SP]Int����",
	"[SP]Luk����",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�X���[�L���X�g",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�v���I�ȏ�",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�ړ����x����",
	"�����h��͑����|�[�V����",
	"���@�h��͑����|�[�V����",
	"�񕜗͑����|�[�V����",
	"���^������",
	"���^������",
	"������",
	"���}�̂�������",
	"�f�B�t�@���_��",
	"�����^���|�[�V����",
	"�e�`�����_��",
	"SP����ʌ����|�[�V����",
	UNKNOWN_SYMBOL,
	"�Z�����ύX�X�N���[��",
	UNKNOWN_SYMBOL,
	"�w���̌��\",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�l���o���l����",
	"�����I�t���I",
	"�V�g�̎��",
	UNKNOWN_SYMBOL,
	"[SP]�u���M�|�[�V����",
	UNKNOWN_SYMBOL,
	"���t���b�V��",
	"�W���C�A���g�O���[�X",
	"�X�g�[���n�[�h�X�L��",
	"�o�C�^���e�B�A�N�e�B�x�[�V����",
	"�t�@�C�e�B���O�X�s���b�g",
	"�A�o���_���X",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�N���[�L���O�G�N�V�[�h",
	"�n���V�l�[�V�����E�H�[�N",
	UNKNOWN_SYMBOL,
	"���m���@�e�B�I",
	"�E�F�|���u���b�L���O",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�G�N�X�s�A�e�B�I",
	"�|�C�Y�j���O�E�F�|��",
	"�g�L�V��",
	"�p�����C�Y",
	"�x�i���u���[�h",
	"�}�W�b�N�}�b�V�����[��",
	"�f�X�n�[�g",
	"�p�C�A���N�V�A",
	"�I�u���r�I���J�[�X",
	"���[�`�G���h",
	UNKNOWN_SYMBOL,
	"�X�����",
	"�t�B�A�[�u���[�Y",
	UNKNOWN_SYMBOL,
	"�}�[�V���I�u�A�r�X",
	"�����g��",
	"�X�e�C�V�X���",
	"�E�H�[�O�R�撆",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�A�N�Z�����[�V����",
	"�z�o�[�����O",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�^�I�O���J�X�N���[��",
	"�~�X�g���X�X�N���[��",
	"�I�[�N�q�[���[�X�N���[��",
	"�I�[�N���[�h�X�N���[��",
	UNKNOWN_SYMBOL,
	"�I�[�o�[�q�[�g���",
	"�V�F�C�v�V�t�g",
	"�C���t�����b�h�X�L����",
	"�}�O�l�e�B�b�N�t�B�[���h���",
	"�j���[�g�����o���A�[",
	UNKNOWN_SYMBOL,
	"�X�e���X�t�B�[���h",
	UNKNOWN_SYMBOL,
	"�}�k�N�̍��C",
	"�}�k�N�̈ӎu",
	"�s���M�L�����̉ʎ��W����",
	"���V�I�����F�X�p�̃n�`��",
	"���v���f���[�X",
	"�}�k�N�̐M�O",
	"�R���k�X�̗�",
	"Str�����X�N���[��",
	"Int�����X�N���[��",
	"[SP]���W�X�g�E�B���h�|�[�V����",
	"�t�H�[�X�I�u�o���K�[�h",
	UNKNOWN_SYMBOL,
	"�I�[�g�V���h�E�X�y��",
	"�V���h�E�t�H�[��",
	UNKNOWN_SYMBOL,
	"[SP]HP�����|�[�V����",
	"[SP]SP�����|�[�V����",
	"[SP]�������i�|�[�V����",
	"�{�f�B�y�C���e�B���O",
	"�C�N�V�[�h�u���C�N",
	"�A�h�����X",
	"[SP]���W�X�g�t�@�C�A�[�|�[�V����",
	"�C���r�W�r���e�B",
	"�f�b�h���[�C���t�F�N�g",
	"�o���f�B���O",
	UNKNOWN_SYMBOL,
	"[SP]���W�X�g�A�[�X�|�[�V����",
	"�}�X�J���[�h�F�G�i�x�[�V����",
	"�}�X�J���[�h�F�O���[�~�[",
	"�������V",
	"�}�X�J���[�h�F�C�O�m�A�����X",
	"�}�X�J���[�h�F���C�W�[�l�X",
	"�M�d��",
	"�A�J���W�F",
	"�}�X�J���[�h�F�A�����b�L�[",
	UNKNOWN_SYMBOL,
	"�����w���",
	"�}�X�J���[�h�F�E�B�[�N�l�X",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�A�N�Z�T���[�������",
	UNKNOWN_SYMBOL,
	"���c�̃N�b�L�[",
	UNKNOWN_SYMBOL,
	"�_��-��-",
	"�_��-��-",
	"�_��-��-",
	UNKNOWN_SYMBOL,
	"�X�C���O�_���X",
	"���l�����ׂ̈̃V���t�H�j�[",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�z���鎩�R�̉�",
	"�Ⓚ���",
	"�������R���[",
	"�}�i�̉�",
	UNKNOWN_SYMBOL,
	"�_���X�E�B�Y�E�H�[�O",
	"���ԂɌ������ēˌ�",
	"�G�R�[�̉�",
	"�n�[���i�C�Y",
	"�X�g���C�L���O",
	"�E�H�[�}�[",
	"��������̃Z���i�[�f",
	"�������",
	UNKNOWN_SYMBOL,
	"�A�i���C�Y",
	"���[���Y�̖�",
	"�����f�B�[�I�u�V���N",
	"�r�����h�I�u�E�H�[�N���C",
	"�G���h���X�n�~���O�{�C�X",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�J�[�g�u�[�X�g",
	UNKNOWN_SYMBOL,
	"�\�[���g���b�v",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"���_�Ռ����",
	UNKNOWN_SYMBOL,
	"�T�N�������g",
	"[SP]�A�X���v�e�B�I",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"���ɏ��",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"HP�����|�[�V����",
	"SP�����|�[�V����",
	"�Z�k�z���C�g�|�[�V����Z",
	"�r�^�^500",
	"�Z�k�T���}�C���W���[�X",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�o�L���[���G�N�X�g���[�����",
	"�T�x�[�W�̊ۏĂ�",
	"�J�N�e���E�H�[�O�u���b�h",
	"�~�m�^�E���X�̃J���r",
	"�V���}�A�C�X�e�B�[",
	"�h���Z���̃n�[�u��",
	"�v�e�B�b�g�̂����ۖ�",
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
	"���[���x���[",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�y�C���L���[",
	"�v���Ȗ��̐�",
	"�������|�[�V����",
	"�Đ��̌�",
	"�I�[�o�[�h�u�[�X�g",
	UNKNOWN_SYMBOL,
	"�I�[�f�B���̗�",
	"�X�^�C���`�F���W",
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
	"�}�O�}�t���[",
	"�O���j�e�B�b�N�A�[�}�[",
	"�p�C���N���X�e�B�b�N",
	"�ΎR�D���",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"���@�L�����f�[",
	UNKNOWN_SYMBOL,
	"�R�撆",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�}�N���f�B���C",
	UNKNOWN_SYMBOL,
	"�T�|�[�g���@",
	UNKNOWN_SYMBOL,
	"�N���b�V���X�g���C�N",
	"�ϐg��",
	"����",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�}�N��",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�񕜕s�\���",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"[SP]Def�Œ�",
	"[SP]Mdef�Œ�",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�����~��",
	"[SP]ASPD�����|�[�V����",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�������|",
	UNKNOWN_SYMBOL,
	"[SP]���W�X�g�R�[���h�|�[�V����",
	UNKNOWN_SYMBOL,
	"���p_-�e����-",
	"���p_-�����̉e-",
	"���p_-���g-",
	"���p_-�c��-",
	"�Ñ㐸��̂����",
	"���p_-�O���z-",
	"���p_-�g��-",
	UNKNOWN_SYMBOL,
	"�퓬��",
	"�����퓬��",
	"���b�h�u�[�X�^�[",
	UNKNOWN_SYMBOL,
	"�~�X�e�B�b�N�p�E�_�[",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�_���Ȗ��̐�",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�ӂ񂾂�Ȃ̉Ԃ�",
	"���̌�",
	"�͂̉���",
	"���@�̏�",
	"���Ȃ��",
	"�s�v�c�ȗ�",
	"�X�e�[�^�X����",
	"���̗�",
	"HPSP����",
	UNKNOWN_SYMBOL,
	"�U���͑���",
	"�����l�̌�",
	"�S�[�����̊j",
	"�d���̗܁i�X�^���j",
	"�d���̗܁i�Ή��j",
	"�d���̗܁i�����j",
	"�d���̗܁i�����j",
	"�d���̗܁i�􂢁j",
	"�d���̗܁i���فj",
	"�d���̗܁i�Í��j",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�q�[���[�^�C��",
	"�q�[���[�p���[�`���[�W",
	"�L�m�R�t���[�N",
	"���l��",
	UNKNOWN_SYMBOL,
	"���f�B�A�̉���",
	"���L�̉���",
	"�P�C�I�X�̉���",
	"�������G�l���M�[",
	"�������ꂽ�G�l���M�[",
	"�����x�G�l���M�[",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�t�F�������̗�",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�t���b�O�̉�",
	"�I�t�F���g���E��",
	"�e���L�l�V�X�C���e���X",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�t���X���b�g��",
	"���o�E���h",
	"�A�����~�b�g",
	"�L���O�X�O���C�X",
	"MAX_ATK",
	"MIN_ATK",
	"MAX_MATK",
	"MIN_MATK",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�_�[�N�N���[",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�i�v��",
	"������",
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
	"�{�U�̃R�b�v",
	"�o�C���h���",
	"�G�^�[�i���`�F�[��",
	UNKNOWN_SYMBOL,
	"������",
	"�����[�g���e",
	UNKNOWN_SYMBOL,
	"�v���`�i���A���^�[",
	"�q�[�g�o����",
	"�A���`�}�e���A���u���X�g",
	UNKNOWN_SYMBOL,
	"�\�[�h�N����",
	"�A�[�N�����h�N����",
	"�S�[���f�����C�X�N����",
	"�N���X�{�E�N����",
	"�ł̉���",
	"���̉���",
	"���̉���",
	"���΂̉���",
	"���X�̉���",
	"�����̉���",
	"�L���̉���",
	"���̎�",
	"�����ő�",
	"�׊�̎�",
	"����",
	"�[�߂̐ߋ�",
	"�q�[�g�o�����y�i���e�B",
	UNKNOWN_SYMBOL,
	"��p�C�x���g�o�t",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�X�y�A���u",
	UNKNOWN_SYMBOL,
	"���̉���",
	"�΂̉���",
	"���̉���",
	"�؂̉���",
	"���̉���",
	"���̉���",
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
	"�W�����s���O�N����",
	"�T�|�[�g���@",
	"�����[�t�|�[�V����",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�c��ւ̌��g",
	"���͋��",
	"�K�`���h���̉���",
	"�K�`���h���̉���",
	"�K�`���h���̉���",
	"�K�`���h���̉���",
	"�K�`���h���̉���",
	"�K�`���h���̉���",
	"�K�`���h���̉���",
	"�K�`���h���̉���",
	"�K�`���h���̉���",
	"�K�`���h���̉���",
	"�K�`���h���̉���",
	"�K�`���h���̉���",
	"�K�`���h���̉���",
	"�K�`���h���̉���",
	"�K�`���h���̉���",
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
	"�����҂̏�",
	"�����҂̏�",
	"�����҂̏�",
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
	"�Ή����",
	"�������",
	"�X�^�����",
	"�������",
	UNKNOWN_SYMBOL,
	"�Ή��i�s��",
	"���Ώ��",
	"�z���C�g�C���v���Y�����",
	"�ŏ��",
	"�􂢏��",
	"���ُ��",
	"�������",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�ғŏ��",
	"���|���",
	UNKNOWN_SYMBOL,
	"�������܂�",
	"�C�k�n�b�J�V�����[",
	UNKNOWN_SYMBOL,
	"�}�^�^�r�̍�����",
	"���푮���t�^(��)",
	"���푮���t�^(��)",
	"���푮���t�^(�n)",
	"���푮���t�^(��)",
	"���푮���t�^(��)",
	"���푮���t�^(��)",
	"���푮���t�^(��)",
	"���푮���t�^(��)",
	"���푮���t�^(�O)",
	"���푮���t�^(�s��)",
	"�������U���ϐ�",
	"�������U���ϐ�",
	"�n�����U���ϐ�",
	"�Α����U���ϐ�",
	"�������U���ϐ�",
	"�ő����U���ϐ�",
	"�������U���ϐ�",
	"�ő����U���ϐ�",
	"�O�����U���ϐ�",
	"�s�������U���ϐ�",
	"�^���E�̏�",
	"�A�N���E�X�_�b�V��",
	"�}�O���V�[���h",
	"�G�r�O��",
	"�V�N�ȃG�r",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�x���J�i�̑���",
	"���C�]�̑���",
	"�X���T�Y�̑���",
	"�n�K���Y�̑���",
	"�C�X�̑���",
	"�G�C�V���̑���",
	"�E���Y�̑���",
	"�������",
	UNKNOWN_SYMBOL,
	"�J���[�j���~���N",
	"�o�W��",
	"�ɂ��",
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
	"�x��",
	UNKNOWN_SYMBOL,
	"�j�����O���X",
	"�`���^�����O",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�O���[�~���O",
	"�G�r�p�[�e�B�[",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�}�W�J���o���b�g",
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
	"���΂̉���",
	"���X�̉���",
	"�����̉���",
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	UNKNOWN_SYMBOL,
	"�v�����e���R�ۖ�",
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
	"���̎�",
	"�ł̉���",
	"���̉���",
	"���̉���",
	"���͋��",
	"�c��ւ̌��g",
	"�����ő�",
	"�׊�̎�",
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

// ID�̐ړ����B
const char ID_PREFIX = '#';

// �C���f�b�N�X�̐ړ����B
const char INDEX_PREFIX = '$';

// �E�Ƃ��Ƃ̍ő�Bot���̃}�b�v�B
const std::unordered_map<
	e_job, // �E�ƁB
	int    // �ő�Bot���B
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

// �����h�v���e�N�^�[��ɐݒu�\�ȃX�L���̃Z�b�g�B
const skill_id_set LAYABLE_ON_LP_SKILLS = {
	AL_PNEUMA,
	HW_GRAVITATION,
	MG_SAFETYWALL,
	PF_FOGWALL,
	WZ_QUAGMIRE,
};

// �A�C�e���̎�ނ̖��O�̃e�[�u���B
const std::array<std::string,IT_MAX> ITEM_TYPE_NAME_TABLE = {
	"��"              , // IT_HEALING      = 0
	UNKNOWN_SYMBOL      , // IT_UNKNOWN      = 1
	"�g�p"              , // IT_USABLE       = 2
	"���̑�"            , // IT_ETC          = 3
	"�h��"              , // IT_ARMOR        = 4
	"����"              , // IT_WEAPON       = 5
	"�J�[�h"            , // IT_CARD         = 6
	"�y�b�g�̗�"        , // IT_PETEGG       = 7
	"�y�b�g�A�N�Z�T���[", // IT_PETARMOR     = 8
	UNKNOWN_SYMBOL      , // IT_UNKNOWN2     = 9
	"��/�e"             , // IT_AMMO         = 10
	"����"              , // IT_DELAYCONSUME = 11
	UNKNOWN_SYMBOL      , // IT_SHADOWGEAR   = 12
	UNKNOWN_SYMBOL      ,
	UNKNOWN_SYMBOL      ,
	UNKNOWN_SYMBOL      ,
	UNKNOWN_SYMBOL      ,
	UNKNOWN_SYMBOL      ,
	"�X�y�V�����A�C�e��", // IT_CASH         = 18
};

// �A�C�e���̎�ނ̃I�t�Z�b�g�B
const int ITEM_TYPE_OFFSET = 100;

// ���^�����X�^�[���̃}�b�v�B
const std::unordered_map<
	meta_mobs,  // ���^�����X�^�[�B
	std::string // ���^�����X�^�[���B
> META_MONSTER_NAMES = {
	{MM_REST        , "�x��"        },
	{MM_BACKUP      , "�\��"        },
	{MM_BASE        , "��{"        },
	{MM_COMMON      , "���"        },
	{MM_BOSS        , "�{�X"        },
	{MM_NOT_GREAT   , "��O���[�g"  },
	{MM_GREAT       , "�O���[�g"    },
	{MM_FLORA       , "�t���[���^"  },
	{MM_HIGH_MDEF   , "��Mdef"      },
	{MM_HIGH_DEF    , "��Def"       },
	{MM_HIGH_DEF_VIT, "��DefVit"    },
	{MM_HIGH_FLEE   , "��Flee"      },
	{MM_HIGH_HIT    , "��Hit"       },
	{MM_HIGH_LEVEL  , "�����x��"    },
	{MM_SP_DECLINE4 , "SP�ቺ4"     },
	{MM_SP_DECLINE3 , "SP�ቺ3"     },
	{MM_SP_DECLINE2 , "SP�ቺ2"     },
	{MM_SP_DECLINE1 , "SP�ቺ1"     },
	{MM_HP_DECLINE4 , "HP�ቺ4"     },
	{MM_HP_DECLINE3 , "HP�ቺ3"     },
	{MM_HP_DECLINE2 , "HP�ቺ2"     },
	{MM_HP_DECLINE1 , "HP�ቺ1"     },
	{MM_MEMBER_DEAD , "�����o�[���S"},
};

// �����X�^�[���g�p����ƋߐڂɂȂ�X�L���̃Z�b�g�B
const skill_id_set MOB_SHORT_SKILLS = {
	AC_SHOWER,
	AM_DEMONSTRATION,
};

// �ʏ�U���|���V�[�l���̃e�[�u���B
const std::array<
	std::string, // �ʏ�U���|���V�[�l���B
	NAPV_MAX     // �ʏ�U���|���V�[�l�̐��B
> NORMAL_ATTACK_POLICY_VALUE_NAME_TABLE = {
	UNKNOWN_SYMBOL,
	"�A��"        ,
	"�P��"        ,
};

// 1�y�[�W�̍s���B
const int PAGE_LINES = 100;

// �p�X�X�L���̃Z�b�g�B
const skill_id_set PATH_SKILLS = {
	NJ_KAMAITACHI     ,
	NPC_ACIDBREATH    ,
	NPC_DARKNESSBREATH,
	NPC_FIREBREATH    ,
	NPC_ICEBREATH     ,
	NPC_THUNDERBREATH ,
	SN_SHARPSHOOTING  ,
};

// �y�b�g�p�A�N�Z�T���[�^�C�v���B
const std::string PET_ACCESSORY_TYPE_NAME = "�y�b�g�p�A�N�Z�T���[";

// �����������̏C����B
const int REPAIR_COST = 5000;

// �C���HNPC�̖��O�B
const std::string REPAIRMAN_NAME = "�C���H";

// �푰���̃e�[�u���B
const std::array<
	std::string, // �푰���B
	10           // �푰���B
> RACE_NAME_TABLE = {
	"���`"  ,
	"�s���`",
	"�����`",
	"�A���`",
	"�����`",
	"���L�`",
	"�����`",
	"�l�Ԍ`",
	"�V�g�`",
	"���`"  ,
};

// �T�C�Y���̃e�[�u���B
const std::array<
	std::string, // �T�C�Y���B
	3            // �T�C�Y���B
> SIZE_NAME_TABLE = {
	"���^",
	"���^",
	"��^",
};

// SQL�f�[�^�^�C�v�̃}�b�v�B
const std::unordered_map<
	std::type_index, // �^�̃C���f�b�N�X�B
	SqlDataType      // SQL�f�[�^�^�C�v�B
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

	{std::type_index(typeid(e_element))               , SQLDT_INT8     },
	{std::type_index(typeid(const e_element))         , SQLDT_INT8     },
	{std::type_index(typeid(e_skill))                 , SQLDT_INT      },
	{std::type_index(typeid(const e_skill))           , SQLDT_INT      },
	{std::type_index(typeid(equip_pos))               , SQLDT_INT      },
	{std::type_index(typeid(const equip_pos))         , SQLDT_INT      },
	{std::type_index(typeid(equip_pos_orders))        , SQLDT_INT      },
	{std::type_index(typeid(const equip_pos_orders))  , SQLDT_INT      },
	{std::type_index(typeid(quest_state))             , SQLDT_INT      },
	{std::type_index(typeid(const quest_state))       , SQLDT_INT      },
	{std::type_index(typeid(sc_type))                 , SQLDT_INT      },
	{std::type_index(typeid(const sc_type))           , SQLDT_INT      },
	{std::type_index(typeid(time_t))                  , SQLDT_UINT32   },
	{std::type_index(typeid(const time_t))            , SQLDT_UINT32   },
};

// ��������̐��������^�O�B
const std::string STAR_FORGED_TAG = "��";

// �X�e�[�^�X�^�C�v���X�e�[�^�X�p�����[�^�ɕϊ�����e�[�u���B
const std::array<
	_sp,   // �X�e�[�^�X�p�����[�^�B
	ST_MAX // �X�e�[�^�X�^�C�v���B
> ST2SP_TABLE = {
	SP_STR,
	SP_AGI,
	SP_VIT,
	SP_INT,
	SP_DEX,
	SP_LUK,
};

// �X�e�[�^�X�^�C�v���̃e�[�u���B
const std::array<
	std::string, // �X�e�[�^�X�^�C�v���B
	ST_MAX       // �X�e�[�^�X�^�C�v���B
> STATUS_TYPE_NAME_TABLE = {
	"Str",
	"Agi",
	"Vit",
	"Int",
	"Dex",
	"Luk",
};

// �q�ɗ��p���B
const int STORAGE_FEE = 100;

// �q�Ƀ^�C�v���̃e�[�u���B
const std::array<
	std::string, // �q�Ƀ^�C�v���B
	4            // �q�Ƀ^�C�v���B
> STORAGE_TYPE_NAME_TABLE = {
	"�����A�C�e��",
	"�J�[�g",
	"�q��",
	"�M���h�q��",
};

// �����X�L���̃Z�b�g�B
const skill_id_set SUMMON_SKILLS = {
	NPC_CALLSLAVE,
	NPC_SUMMONMONSTER,
	NPC_SUMMONSLAVE,
};

// �^�[�Q�b�g���Ă���G�����X�^�[���Ӗ����閼�O�B
const std::string TARGET_ENEMY_NAME = "monster";

// �ő�`�[�����B
const int TEAM_MAX = 100;

// ���݂̃}�b�v���Ӗ����閼�O�B
const std::string THIS_MAP_NAME = "this";

// �Z�����X�L���̃Z�b�g�B
const skill_id_set UNEQUIP_ARMOR_SKILLS = {
	AM_ACIDTERROR,
	CR_ACIDDEMONSTRATION,
	NPC_ARMORBRAKE,
	RG_STRIPARMOR,
	ST_FULLSTRIP,
};

// �������X�L���̃Z�b�g�B
const skill_id_set UNEQUIP_HELM_SKILLS = {
	NPC_HELMBRAKE,
	RG_STRIPHELM,
	ST_FULLSTRIP,
};

// �������X�L���̃Z�b�g�B
const skill_id_set UNEQUIP_SHIELD_SKILLS = {
	NPC_SHIELDBRAKE,
	RG_STRIPSHIELD,
	ST_FULLSTRIP,
};

// ��������X�L���̃Z�b�g�B
const skill_id_set UNEQUIP_WEAPON_SKILLS = {
	AM_DEMONSTRATION,
	CR_ACIDDEMONSTRATION,
	NPC_WEAPONBRAKER,
	RG_STRIPWEAPON,
	ST_FULLSTRIP,
};

// �L�p�ȃX�L���̃Z�b�g�B
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

// �E�H�[�^�[�{�[���X�L�����j�b�g�L�[�̃}�b�v�B
const skill_unit_key_map WATERBALL_SKILL_UNIT_KEYS = {
	SKILL_UNIT_KEY(NJ_SUITON),
	SKILL_UNIT_KEY(SA_DELUGE),
};

// ����^�C�v���̃e�[�u���B
const std::array<
	std::string,    // ����^�C�v���B
	MAX_WEAPON_TYPE // ����^�C�v���̐��B
> WEAPON_TYPE_NAME_TABLE = {
	"�f��"          ,
	"�Z��"          ,
	"�Ў茕"        ,
	"���茕"        ,
	"�Ў葄"        ,
	"���葄"        ,
	"�Ў蕀"        ,
	"���蕀"        ,
	"�݊�"          ,
	"����݊�"      ,
	"�Ў��"        ,
	"�|"            ,
	"��"            ,
	"�y��"          ,
	"��"            ,
	"�{"            ,
	"�J�^�[��"      ,
	"�n���h�K��"    ,
	"���C�t��"      ,
	"�K�g�����O�K��",
	"�V���b�g�K��"  ,
	"�O���l�[�h�K��",
	"����"          ,
	"�����"        ,
};

// -----------------------------------------------------------------------------
// �ϐ��̒�`

// AI�̃^�C�}�[�B
int ai_timer;

// �SBot�̃}�b�v�B
std::unordered_map<
	int,      // �L�����N�^�[ID�B
	block_if* // Bot�B
> all_bots;

// �S���[�_�[�̃}�b�v�B
std::unordered_map<
	int,          // �L�����N�^�[ID�B
	ptr<block_if> // ���[�_�[�B
> all_leaders;

// Bot���S�`�b�N�̃}�b�v�B
std::unordered_map<
	int,   // �L�����N�^�[ID�B
	t_tick // ���S�`�b�N�B
> bot_dead_ticks;

// �t�B�[�o�[�{���̃}�b�v�B
std::unordered_map<
	int, // �}�b�vID�B
	int  // �{���B
> fever_rates;

// �}�b�vID���L�[�Ƃ���}�b�v�̃}�b�v�B
std::unordered_map<
	int,           // �}�b�vID�B
	ptr<pybot_map> // �}�b�v�B
> id_maps;

// ���݃}�b�v�����ʒu�̃}�b�v�B
std::unordered_map<
	int,            // �L�����N�^�[ID�B
	ptr<block_list> // �ʒu�B
> map_initial_positions;

// ���݃`�b�N�B
t_tick now;

// �A�C�R�������L�[�Ƃ���X�e�[�^�X�ω��̃}�b�v�B
std::unordered_map<
	std::string, // �X�e�[�^�X���B
	sc_type      // �X�e�[�^�X�ω��B
> sc_types;

// ��ނ��L�[�Ƃ���}�b�v�̃x�N�^�̃}�b�v�B
std::unordered_map<
	int, // ��ށB
	std::vector<
		ptr<pybot_map> // �}�b�v�B
	>    // �}�b�v�̃x�N�^�B
> type_maps;

}
