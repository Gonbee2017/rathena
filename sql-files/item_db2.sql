#
# Table structure for table `item_db2`
#

DROP TABLE IF EXISTS `item_db2`;
CREATE TABLE `item_db2` (
  `id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `name_english` varchar(50) NOT NULL DEFAULT '',
  `name_japanese` varchar(50) NOT NULL DEFAULT '',
  `type` tinyint(2) unsigned NOT NULL DEFAULT '0',
  `price_buy` mediumint(8) unsigned DEFAULT NULL,
  `price_sell` mediumint(8) unsigned DEFAULT NULL,
  `weight` smallint(5) unsigned NOT NULL DEFAULT '0',
  `attack` smallint(5) unsigned DEFAULT NULL,
  `defence` smallint(5) unsigned DEFAULT NULL,
  `range` tinyint(2) unsigned DEFAULT NULL,
  `slots` tinyint(2) unsigned DEFAULT NULL,
  `equip_jobs` bigint(20) unsigned DEFAULT NULL,
  `equip_upper` tinyint(2) unsigned DEFAULT NULL,
  `equip_genders` tinyint(1) unsigned DEFAULT NULL,
  `equip_locations` mediumint(7) unsigned DEFAULT NULL,
  `weapon_level` tinyint(1) unsigned DEFAULT NULL,
  `equip_level` tinyint(3) unsigned DEFAULT NULL,
  `refineable` tinyint(1) unsigned DEFAULT NULL,
  `view` smallint(5) unsigned DEFAULT NULL,
  `script` text,
  `equip_script` text,
  `unequip_script` text,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UniqueAegisName` (`name_english`)
) ENGINE=MyISAM;

# Items Additional Database
#
# Structure of Database:
#REPLACE INTO `item_db2` VALUES ( ID,'AegisName','Name',Type,Buy,Sell,Weight,ATK,DEF,Range,Slots,Job,Class,Gender,Loc,wLV,eLV,Refineable,View,'Script','OnEquip_Script','OnUnequip_Script');
#
# THQ Quest Items
#=============================================================
#REPLACE INTO `item_db2` VALUES (7950,'THG_Membership','THG Membership',3,NULL,10,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
#REPLACE INTO `item_db2` VALUES (7951,'Token_Bag','Token Bag',3,NULL,10,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
#REPLACE INTO `item_db2` VALUES (1998,'Jeramiah''s_Jur','Jeramiah''s Jur',3,NULL,10,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
#REPLACE INTO `item_db2` VALUES (1999,'Zed''s_Staff','Zed''s Staff',3,NULL,10,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

# Official Event Items that had their Effects removed after the event was completed
#REPLACE INTO `item_db2` VALUES (585,'Wurst','Brusti',11,2,NULL,40,NULL,NULL,NULL,NULL,0xFFFFFFFF,7,2,NULL,NULL,NULL,NULL,NULL,'itemheal rand(15,20),0; itemskill "PR_MAGNIFICAT",3;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (679,'Gold_Pill','Pilule',0,5000,NULL,300,NULL,NULL,NULL,NULL,0xFFFFFFFF,7,2,NULL,NULL,NULL,NULL,NULL,'percentheal 50,50;',NULL,NULL);

#REPLACE INTO `item_db2` VALUES (2681,'Republic_Ring','Republic Anniversary Ring',4,20,NULL,100,NULL,0,NULL,0,0xFFFFFFFF,7,2,136,NULL,0,0,0,'bonus bAllStats,3;',NULL,NULL);

#REPLACE INTO `item_db2` VALUES (5134,'Pumpkin_Hat','Pumpkin-Head',4,20,NULL,200,NULL,2,NULL,0,0xFFFFFFFF,7,2,256,NULL,0,1,206,'bonus2 bSubRace,RC_Demon,5;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (5136,'Santa''s_Hat_','Louise''s Santa Hat',4,20,NULL,100,NULL,3,NULL,0,0xFFFFFFFF,7,2,256,NULL,0,1,20,'bonus bMdef,1; bonus bLuk,1; bonus3 bAutoSpellWhenHit,"AL_HEAL",3,50; bonus3 bAutoSpellWhenHit,"AL_BLESSING",10,50;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (5145,'Carnival_Joker_Jester','Carnival Jester',4,10,NULL,100,NULL,0,NULL,0,0xFFFFFFFF,7,2,256,NULL,0,1,89,'bonus bAllStats,3;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (5147,'Baseball_Cap','Baseball Cap',4,0,NULL,200,NULL,3,NULL,0,0xFFFFFFFF,7,2,256,NULL,0,1,216,'bonus2 bExpAddRace,RC_Boss,50; bonus2 bExpAddRace,RC_NonBoss,50;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (5201,'Party_Hat_B','2nd Anniversary Party Hat',4,20,NULL,300,NULL,3,NULL,0,0xFFFFFFFF,7,2,256,NULL,0,1,144,'bonus bAllStats,3;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (5202,'Pumpkin_Hat_','Pumpkin Hat',4,20,NULL,200,NULL,2,NULL,0,0xFFFFFFFF,7,2,256,NULL,0,1,206,'bonus bAllStats,2; bonus2 bSubRace,RC_Demon,5; bonus3 bAddMonsterDropItem,529,RC_DemiHuman,1500;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (5204,'Event_Pierrot_Nose','Rudolf''s Red Nose',4,20,NULL,100,NULL,0,NULL,0,0xFFFFFFFF,7,2,1,NULL,0,0,49,'bonus2 bResEff,Eff_Blind,3000; bonus2 bAddMonsterDropItem,12130,30;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (5264,'Aussie_Flag_Hat','Australian Flag Hat',4,20,NULL,500,NULL,4,NULL,0,0xFFFFFFFF,7,2,256,NULL,0,1,304,'bonus bAllStats,2;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (5356,'Pumpkin_Hat_H','Pumpkin Hat',4,20,NULL,200,NULL,2,NULL,0,0xFFFFFFFF,7,2,256,NULL,0,1,206,'bonus bAllStats,2; bonus2 bSubRace,RC_Demon,5; bonus2 bMagicAddRace,RC_Demon,5;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (5811,'Santa_Beard','Santa Beard',4,20,NULL,100,NULL,5,NULL,0,0xFFFFFFFF,7,2,1,NULL,0,0,25,'bonus2 bSubRace,RC_Brute,5;',NULL,NULL);

#REPLACE INTO `item_db2` VALUES (11702,'Moon_Cookie','Moon Cookie',11,0,NULL,10,NULL,NULL,NULL,NULL,0xFFFFFFFF,7,2,NULL,NULL,NULL,NULL,NULL,'sc_end SC_Poison; sc_end SC_Silence; sc_end SC_Blind; sc_end SC_Confusion; sc_end SC_Curse; sc_end SC_Hallucination; itemskill "AL_BLESSING",7;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (12131,'Lucky_Potion','Lucky Potion',0,2,NULL,100,NULL,NULL,NULL,NULL,0xFFFFFFFF,7,2,NULL,NULL,NULL,NULL,NULL,'sc_start SC_LUKFood,180000,15;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (12143,'Red_Can','Red Can',2,50000,NULL,300,NULL,NULL,NULL,NULL,0xFFFFFFFF,7,2,NULL,NULL,NULL,NULL,NULL,'percentheal 25,25;',NULL,NULL);
#Event effect: Summon monster? Probably Rice_Cake. x_x
#REPLACE INTO `item_db2` VALUES (12199,'Rice_Scroll','Rice Scroll',2,0,NULL,0,NULL,NULL,NULL,NULL,0xFFFFFFFF,7,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
#REPLACE INTO `item_db2` VALUES (12200,'Event_Cake','Event Cake',2,20,NULL,50,NULL,NULL,NULL,NULL,0xFFFFFFFF,7,2,NULL,NULL,NULL,NULL,NULL,'itemskill "PR_MAGNIFICAT",3;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (12238,'New_Year_Rice_Cake_1','New Year Rice Cake',0,20,NULL,100,NULL,NULL,NULL,NULL,0xFFFFFFFF,7,2,NULL,NULL,NULL,NULL,NULL,'percentheal 20,15; sc_start SC_STRFood,1200000,3; sc_start SC_INTFood,1200000,3; sc_start SC_LUKFood,1200000,3; sc_start SC_SpeedUp1,5000,0;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (12239,'New_Year_Rice_Cake_2','New Year Rice Cake',0,20,NULL,100,NULL,NULL,NULL,NULL,0xFFFFFFFF,7,2,NULL,NULL,NULL,NULL,NULL,'percentheal 20,15; sc_start SC_DEXFood,1200000,3; sc_start SC_AGIFood,1200000,3; sc_start SC_VITFood,1200000,3; sc_start SC_SpeedUp1,5000,0;',NULL,NULL);

# iRO St. Patrick's Day Event 2008
#=============================================================
#REPLACE INTO `item_db2` VALUES (12715,'Black_Treasure_Chest','Black Treasure Chest',2,0,NULL,200,NULL,NULL,NULL,NULL,0xFFFFFFFF,7,2,NULL,NULL,NULL,NULL,NULL,'callfunc "F_08stpattyseventbox";',NULL,NULL);

# iRO Valentine's Day Event 2009
#=============================================================
#REPLACE INTO `item_db2` VALUES (12742,'Valentine_Gift_Box_M','Valentine Gift Box',2,10,NULL,0,NULL,NULL,NULL,NULL,0xFFFFFFFF,7,2,NULL,NULL,NULL,NULL,NULL,'getitem 7946,1;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (12743,'Valentine_Gift_Box_F','Valentine Gift Box',2,10,NULL,0,NULL,NULL,NULL,NULL,0xFFFFFFFF,7,2,NULL,NULL,NULL,NULL,NULL,'getitem 7947,1;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (12744,'Chocolate_Box','Chocolate Box',2,10,NULL,0,NULL,NULL,NULL,NULL,0xFFFFFFFF,7,2,NULL,NULL,NULL,NULL,NULL,'getitem 558,1;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (14466,'Valentine''s_Emblem_Box','Valentine''s Emblem Box',2,10,NULL,0,NULL,NULL,NULL,NULL,0xFFFFFFFF,7,2,NULL,NULL,NULL,NULL,NULL,'getitem 5817,1;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (7946,'Gold_Ring_Of_Valentine','Gold Ring Of Valentine',3,10,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
#REPLACE INTO `item_db2` VALUES (7947,'Silver_Ring_Of_Valentine','Silver Ring Of Valentine',3,10,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
#REPLACE INTO `item_db2` VALUES (7948,'Box','Box',3,10,NULL,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
#REPLACE INTO `item_db2` VALUES (5817,'Valentine''s_Emblem','Valentine''s Emblem',4,10,NULL,0,NULL,3,NULL,0,0xFFFFFFFF,7,2,136,NULL,0,0,0,'bonus bAtkRate,3; bonus bMatkRate,3; bonus bAllStats,2; bonus bFlee,10; bonus bAspd,1; bonus bMdef,3; bonus2 bSkillAtk,"AL_HEAL",10; bonus2 bSkillHeal,"AL_HEAL",10; bonus2 bSkillHeal,"AM_POTIONPITCHER",10; bonus2 bAddItemHealRate,IG_Potion,10;',NULL,NULL);

# iRO Halloween Event 2009
#=============================================================
#REPLACE INTO `item_db2` VALUES (5668,'Weird_Pumpkin_Hat','Weird Pumpkin Hat',4,20,NULL,0,NULL,5,NULL,0,0xFFFFFFFF,7,2,256,NULL,0,1,206,'bonus bMdef,5; bonus2 bAddMonsterDropItem,12192,2500;',NULL,NULL);
#REPLACE INTO `item_db2` VALUES (6298,'Crushed_Pumpkin','Crushed Pumpkin',3,0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
#REPLACE INTO `item_db2` VALUES (6299,'Worn_Fabric','Worn Fabric',3,0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

# Old Tuxedo and Wedding Dress, will display the outfit when worn.
#==================================================================
#REPLACE INTO `item_db2` VALUES (2338,'Wedding_Dress','Wedding Dress',4,43000,NULL,500,NULL,0,NULL,0,0xFFFFFFFE,7,0,16,NULL,0,1,0,NULL,'setoption Option_Wedding,1;','setoption Option_Wedding,0;');
#REPLACE INTO `item_db2` VALUES (7170,'Tuxedo','Tuxedo',4,43000,NULL,10,NULL,0,NULL,0,0xFFFFFFFE,7,1,16,NULL,0,1,0,NULL,'setoption Option_Wedding,1;','setoption Option_Wedding,0;');

REPLACE INTO `item_db2` VALUES (523, 'Holy_Water', '聖水', 0, 20, NULL, 30, NULL, NULL, NULL, NULL, 0xFFFFFFFF, 7, 2, NULL, NULL, NULL, NULL, NULL, '{ sc_end SC_Curse; sc_end SC_ChangeUndead; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (591, 'Caviar_Pancake', 'キャビアパンケーキ', 0, 0, NULL, 150, NULL, NULL, NULL, NULL, 0xFFFFFFFF, 7, 2, NULL, NULL, NULL, NULL, NULL, '{ itemheal rand(325,405),rand(40,60); sc_end SC_Poison; sc_end SC_Silence; sc_end SC_Blind; sc_end SC_Confusion; sc_end SC_Curse; sc_end SC_Hallucination; sc_end SC_Bleeding; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (592, 'Jam_Pancake', 'ジャムパンケーキ', 0, 0, NULL, 150, NULL, NULL, NULL, NULL, 0xFFFFFFFF, 7, 2, NULL, NULL, NULL, NULL, NULL, '{ itemheal rand(325,405),rand(40,60); sc_end SC_Poison; sc_end SC_Silence; sc_end SC_Blind; sc_end SC_Confusion; sc_end SC_Curse; sc_end SC_Hallucination; sc_end SC_Bleeding; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (593, 'Honey_Pancake', 'ハニーパンケーキ', 0, 0, NULL, 150, NULL, NULL, NULL, NULL, 0xFFFFFFFF, 7, 2, NULL, NULL, NULL, NULL, NULL, '{ itemheal rand(325,405),rand(40,60); sc_end SC_Poison; sc_end SC_Silence; sc_end SC_Blind; sc_end SC_Confusion; sc_end SC_Curse; sc_end SC_Hallucination; sc_end SC_Bleeding; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (594, 'Sour_Cream_Pancake', 'クリームパンケーキ', 0, 0, NULL, 150, NULL, NULL, NULL, NULL, 0xFFFFFFFF, 7, 2, NULL, NULL, NULL, NULL, NULL, '{ itemheal rand(325,405),rand(40,60); sc_end SC_Poison; sc_end SC_Silence; sc_end SC_Blind; sc_end SC_Confusion; sc_end SC_Curse; sc_end SC_Hallucination; sc_end SC_Bleeding; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (595, 'Mushroom_Pancake', 'マッシュルームパンケーキ', 0, 0, NULL, 150, NULL, NULL, NULL, NULL, 0xFFFFFFFF, 7, 2, NULL, NULL, NULL, NULL, NULL, '{ itemheal rand(325,405),rand(40,60); sc_end SC_Poison; sc_end SC_Silence; sc_end SC_Blind; sc_end SC_Confusion; sc_end SC_Curse; sc_end SC_Hallucination; sc_end SC_Bleeding; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (604, 'Branch_Of_Dead_Tree', '古木の枝', 2, 50, NULL, 50, NULL, NULL, NULL, NULL, 0xFFFFFFFF, 7, 2, NULL, NULL, NULL, NULL, NULL, '{ summon "--ja--",-1; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (678, 'Poison_Bottle', '毒薬の瓶', 2, 5000, NULL, 100, NULL, NULL, NULL, NULL, 0xFFFFFFFF, 7, 2, NULL, NULL, NULL, NULL, NULL, '{ if(Class==Job_Assassin_Cross) { sc_start SC_DPoison,60000,0; sc_start SC_ASPDPOTION3,60000,0; } else percentheal -100,-100; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (1191, 'Alca_Bringer', 'アルカブリンガー', 5, 20, NULL, 3400, 280, NULL, 2, 0, 0x00004082, 2, 2, 34, 3, 99, 1, 3, '{ bonus bAspd,(getrefine()/2); }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (1295, 'Blood_Tears_', 'ブラッディティアーズ', 5, 20, NULL, 1700, 120, NULL, 1, 3, 0x00001000, 2, 2, 34, 4, 55, 1, 16, '{ if(getrefine()>=9){ bonus3 bAutoSpell,"NPC_WIDEBLEEDING",2,30; } else bonus3 bAutoSpell,"NPC_WIDEBLEEDING",1,30; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (1297, 'Inverse_Scale_', 'インバーススケイル', 5, 20, NULL, 1500, 140, NULL, 1, 2, 0x00001000, 2, 2, 34, 4, 55, 1, 16, '{ bonus bAtkEle,Ele_Holy; bonus3 bAutoSpell,"NPC_DRAGONFEAR",1,30; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (1397, 'Bradium_Stonehammer_', 'ブラディウムハンマー', 5, 20, NULL, 2700, 210, NULL, 1, 2, 0x000444A2, 2, 2, 34, 4, 75, 1, 7, '{ bonus3 bAddEffOnSkill,"BS_HAMMERFALL",Eff_Stun,500+(200*getrefine()); }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (1530, 'Mjolnir', 'ミョルニール', 5, 20, NULL, 6000, 350, NULL, 1, 0, 0x000444A2, 7, 2, 2, 4, 95, 1, 8, '{ bonus bAtkEle,Ele_Wind; bonus bDex,50; bonus bStr,20; bonus bAspdRate,10; bonus3 bAutoSpell,"MG_THUNDERSTORM",10,100; autobonus "{ bonus bSplashRange,1; }",50,10000; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (1589, 'Legacy_Of_Dragon_', 'ドラゴンの遺産', 5, 20, NULL, 700, 130, NULL, 1, 2, 0x00410100, 7, 2, 2, 4, 70, 1, 15, '{ bonus bInt,3; bonus bIgnoreDefRace,RC_Dragon; bonus2 bSPGainRace,RC_Dragon,10; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (1599, 'Angra_Manyu', 'アーリマン', 5, 1, NULL, 10, 200, NULL, 2, 0, 0xFFFFFFFF, 7, 2, 2, 1, 1, 1, 8, '{ bonus bAllStats,50; bonus bBaseAtk,3800; bonus bMatkRate,200; bonus2 bHPDrainRate,1000,100; bonus2 bSPDrainRate,1000,20; bonus bHealPower,200; bonus2 bAddClass,Class_All,100; skill "WZ_STORMGUST",10; Skill "WZ_METEOR",10; Skill "WZ_VERMILION",10; skill "GM_SANDMAN",1; skill "TK_SEVENWIND",7; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (1636, 'Thorn_Staff', '茨の杖', 5, 20, NULL, 700, 60, NULL, 1, 0, 0x00018314, 2, 2, 2, 4, 75, 1, 10, '{ bonus bInt,3; bonus bDex,3; bonus bMatkRate,20; bonus2 bIgnoreMdefClassRate,Class_Normal,getrefine(); bonus2 bIgnoreMdefClassRate,Class_Boss,getrefine(); bonus bDelayRate,-(getrefine()*3/2); bonus bAtkEle,Ele_Dark; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (1662, 'Bone_Wand_', '骸骨の杖', 5, 20, NULL, 700, 40, NULL, 1, 2, 0x00818314, 7, 2, 2, 3, 24, 1, 10, '{ bonus bInt,4; bonus bAtkEle,Ele_Undead; bonus bMatkRate,15; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (1663, 'Staff_Of_Bordeaux_', 'スタッフオブオルド', 5, 20, NULL, 500, 30, NULL, 1, 2, 0x00010204, 2, 2, 2, 4, 50, 1, 10, '{ bonus bMatkRate,15; bonus bInt,2; bonus bDex,1; if(getskilllv("SA_DRAGONOLOGY")==5) { bonus bUseSPrate,-15; bonus bInt,3; } }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (1664, 'Thorn_Staff_', '茨の杖', 5, 20, NULL, 700, 60, NULL, 1, 1, 0x00018314, 2, 2, 2, 4, 75, 1, 10, '{ bonus bInt,3; bonus bDex,3; bonus bMatkRate,20; bonus2 bIgnoreMdefClassRate,Class_Normal,getrefine(); bonus2 bIgnoreMdefClassRate,Class_Boss,getrefine(); bonus bDelayRate,-(getrefine()*3/2); bonus bAtkEle,Ele_Dark; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (1665, 'Piercing_Staff_', 'スタッフオブピアーシング', 5, 20, NULL, 500, 80, NULL, 1, 2, 0x00018314, 2, 2, 2, 3, 70, 1, 10, '{ bonus bInt,4; bonus bMatkRate,15; bonus2 bIgnoreMdefClassRate,Class_Normal,10+getrefine(); bonus2 bIgnoreMdefClassRate,Class_Boss,10+getrefine(); }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (1666, 'Healing_Staff_', '治癒の杖', 5, 20, NULL, 400, 10, NULL, 1, 2, 0x00008110, 7, 2, 2, 3, 55, 1, 10, '{ bonus bAtkEle,Ele_Holy; bonus bMatkRate,15; bonus bHealPower,(getrefine()*3/2); }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2017, 'Divine_Cross_', 'ディバインクロス', 5, 20, NULL, 1500, 120, NULL, 1, 1, 0x00008100, 7, 2, 34, 4, 70, 1, 23, '{ bonus bAtkEle,Ele_Holy; bonus bMatkRate,15; bonus bDex,4; bonus2 bSubRace,RC_Demon,15; bonus2 bSubRace,RC_Undead,15; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2166, 'Exorcism_Bible_', '駆魔の聖書', 4, 20, NULL, 600, NULL, 5, NULL, 1, 0x00008100, 7, 2, 32, NULL, 50, 1, 5, '{ bonus bHPrecovRate,3; bonus bSPrecovRate,3; bonus bInt,1; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2199, 'Ahura_Mazda', 'アフラマズダー', 4, 1, NULL, 10, NULL, 100, NULL, 0, 0xFFFFFFFF, 7, 2, 32, NULL, 1, 1, 0, '{ bonus bAllStats,50; bonus bMdef,99; bonus bNoMagicDamage,100; bonus bShortWeaponDamageReturn,100; bonus2 bSubRace,RC_DemiHuman,95; bonus2 bSubRace,RC_Player,95; skill "CR_FULLPROTECTION",5; Skill "WZ_ESTIMATION",1; Skill "ST_FULLSTRIP",5; Skill "HW_MAGICPOWER",10; bonus bMaxHPRate,200; bonus bNoGemStone; bonus bSpeedRate,25; bonus bNoKnockback; }', '{ sc_start4 SC_ENDURE,60000,10,0,0,1; }', '{ sc_end SC_ENDURE; }');
REPLACE INTO `item_db2` VALUES (2383, 'Brynhild', 'ブリュンヒルデ', 4, 20, NULL, 400, NULL, 10, NULL, 0, 0xFFFFFFFF, 7, 2, 16, NULL, 94, 1, 0, '{ bonus bMdef,10; bonus bMaxHP,20*BaseLevel; bonus bMaxSP,5*BaseLevel; bonus2 bAddClass,Class_All,10; bonus bMatkRate,10; bonus bUnbreakableArmor; bonus bNoKnockback; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2410, 'Sleipnir', 'スレイプニール', 4, 20, NULL, 3500, NULL, 5, NULL, 0, 0xFFFFFFFF, 7, 2, 64, NULL, 94, 1, 0, '{ bonus bMdef,10; bonus bMaxHPrate,20; bonus bMaxSPrate,20; bonus bSPrecovRate,25; bonus bSpeedRate,25; bonus bInt,25; bonus bUnbreakableShoes; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2450, 'Vital_Tree_Shoes', 'セフィロトシューズ', 4, 20, NULL, 500, NULL, 4, NULL, 0, 0xFFFFFFFE, 63, 2, 64, NULL, 60, 1, 0, '{ bonus bVit,2; bonus bMdef,3; bonus bMaxHPrate,10; bonus bHPrecovRate,5; bonus2 bHPRegenRate,30,10000; bonus bHealpower2,5; bonus bAddItemHealRate,5; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2481, 'Rune_Boots', 'ルーンブーツ', 4, 20, NULL, 100, NULL, 5, NULL, 0, 0xFFFFFFFF, 63, 2, 64, NULL, 0, 1, 0, '{ .@a = readparam(bStr); .@b = readparam(bInt); bonus bBaseAtk,(.@a>=120)?(20):((.@a>=90)?(10):(0)); bonus bMatkRate,(.@b>=120)?(5):((.@b>=90)?(3):(0)); }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2486, 'Shadow_Walk_', 'シャドウウォーカー', 4, 20, NULL, 2000, NULL, 0, NULL, 1, 0xFFFFFFFE, 2, 2, 64, NULL, 75, 1, 0, '{ bonus bMdef,10; if(getskilllv("AS_CLOAKING")<2){ bonus5 bAutoSpellWhenHit,"AS_CLOAKING",2,100,BF_MAGIC,0; } else bonus5 bAutoSpellWhenHit,"AS_CLOAKING",getskilllv("AS_CLOAKING"),100,BF_MAGIC,0; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2487, 'Vital_Tree_Shoes_', 'セフィロトシューズ', 4, 20, NULL, 500, NULL, 4, NULL, 1, 0xFFFFFFFE, 63, 2, 64, NULL, 60, 1, 0, '{ bonus bVit,2; bonus bMdef,3; bonus bMaxHPrate,10; bonus bHPrecovRate,5; bonus2 bHPRegenRate,30,10000; bonus bHealpower2,5; bonus bAddItemHealRate,5; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2488, 'Fricco_Shoes_', 'フレイシューズ', 4, 30000, NULL, 500, NULL, 3, NULL, 1, 0xFFFFFFFE, 7, 2, 64, NULL, 65, 1, 0, '{ bonus bAgi,2; bonus2 bAddItemGroupHealRate,IG_Potion,20; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2489, 'Vidar''s_Boots_', 'ヴィダルのブーツ', 4, 30000, NULL, 650, NULL, 4, NULL, 1, 0xFFFFFFFE, 7, 2, 64, NULL, 65, 1, 0, '{ bonus bMaxHPrate,9; bonus bMaxSPrate,9; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2490, 'Rune_Boots_', 'ルーンブーツ', 4, 20, NULL, 100, NULL, 5, NULL, 1, 0xFFFFFFFF, 63, 2, 64, NULL, 0, 1, 0, '{ .@a = readparam(bStr); .@b = readparam(bInt); bonus bBaseAtk,(.@a>=120)?(20):((.@a>=90)?(10):(0)); bonus bMatkRate,(.@b>=120)?(5):((.@b>=90)?(3):(0)); }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2493, 'Goibne''s_Combat_Boots_', 'ゴヴニュの軍靴', 4, 30000, NULL, 700, NULL, 4, NULL, 1, 0xFFFFFFFE, 7, 2, 64, NULL, 54, 1, 0, '{ bonus bMdef,3; bonus bMaxHPrate,5; bonus bMaxSPrate,5; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2541, 'Asprika', 'アスプリカ', 4, 20, NULL, 400, NULL, 5, NULL, 0, 0xFFFFFFFF, 7, 2, 4, NULL, 94, 1, 0, '{ bonus bMdef,5; bonus3 bSubEle,Ele_Neutral,30,BF_SHORT; bonus3 bSubEle,Ele_Water,30,BF_SHORT; bonus3 bSubEle,Ele_Earth,30,BF_SHORT; bonus3 bSubEle,Ele_Fire,30,BF_SHORT; bonus3 bSubEle,Ele_Wind,30,BF_SHORT; bonus3 bSubEle,Ele_Poison,30,BF_SHORT; bonus3 bSubEle,Ele_Holy,30,BF_SHORT; bonus3 bSubEle,Ele_Dark,30,BF_SHORT; bonus3 bSubEle,Ele_Ghost,30,BF_SHORT; bonus3 bSubEle,Ele_Undead,30,BF_SHORT; bonus bFlee,30; skill "AL_TELEPORT",1; bonus bUnbreakableGarment; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2588, 'Ragamuffin_Cape_', 'ぼろマント', 4, 56000, NULL, 500, NULL, 1, NULL, 1, 0xFFFFFFFE, 7, 2, 4, NULL, 0, 1, 0, '{ bonus bUnbreakableGarment; bonus bMdef,10; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2599, 'Goibne''s_Shoulder_Arms_', 'ゴヴニュの肩飾り', 4, 30000, NULL, 700, NULL, 3, NULL, 1, 0xFFFFFFFE, 7, 2, 4, NULL, 54, 1, 0, '{ bonus bLongAtkDef,10; bonus bMdef,2; bonus bVit,1; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2630, 'Brysinggamen', 'ブリーシンガメン', 4, 20, NULL, 1500, NULL, 1, NULL, 1, 0xFFFFFFFF, 7, 2, 136, NULL, 94, 0, 0, '{ bonus bStr,6; bonus bAgi,6; bonus bVit,6; bonus bInt,10; bonus bLuk,10; bonus bMdef,5; bonus bHealPower,6; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2781, 'Aumdura''s_Grace', 'アウドムラの恩恵', 4, 0, NULL, 100, NULL, 1, NULL, 1, 0xFFFFFFFF, 63, 2, 136, NULL, 1, 0, 0, '{ bonus2 bExpAddClass,Class_All,5; bonus2 bSubClass,Class_All,-5; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2900, 'Morrigane''s_Belt_', 'モリガンのベルト', 4, 30000, NULL, 200, NULL, 0, NULL, 1, 0xFFFFFFFE, 7, 2, 136, NULL, 61, 0, 0, '{ bonus bBaseAtk,5; bonus bCritical,3; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2901, 'Morrigane''s_Pendant_', 'モリガンのペンダント', 4, 30000, NULL, 200, NULL, 0, NULL, 1, 0xFFFFFFFE, 7, 2, 136, NULL, 61, 0, 0, '{ bonus bStr,2; bonus bCritical,3; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2902, 'Morpheus''s_Ring_', 'モルフェウスの指輪', 4, 30000, NULL, 100, NULL, 0, NULL, 1, 0xFFFFFFFE, 7, 2, 136, NULL, 33, 0, 0, '{ bonus bInt,1; bonus bMaxSPrate,5; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2903, 'Morpheus''s_Armlet_', 'モルフェウスの腕輪', 4, 30000, NULL, 100, NULL, 0, NULL, 1, 0xFFFFFFFE, 7, 2, 136, NULL, 33, 0, 0, '{ bonus bInt,1; bonus bMaxSPrate,5; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2943, 'Critical_Ring_', 'クリティカルリング', 4, 75000, NULL, 100, NULL, 0, NULL, 1, 0xFFFFFFFE, 7, 2, 136, NULL, 40, 0, 0, '{ bonus bCritical,5; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (2494, 'Chrystal_Pumps_', 'ガラスの靴', 4, 20, NULL, 100, NULL, 0, NULL, 1, 0xFFFFFFFE, 7, 0, 64, NULL, 0, 1, 0, '{ bonus bMdef,10; bonus bLuk,5; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (4059, 'Soldier_Andre_Card', '兵隊アンドレカード', 6, 20, NULL, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 32, NULL, NULL, NULL, NULL, '{ bonus2 bSubRace,RC_Plant,30; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (12103, 'Bloody_Dead_Branch', '血塗られた古木の枝', 2, 10000, NULL, 200, NULL, NULL, NULL, NULL, 0xFFFFFFFF, 7, 2, NULL, NULL, NULL, NULL, NULL, '{ summon "--ja--",-3; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (12225, 'Sweet_Candy_Striper', '甘いスティックキャンディ', 2, 20, NULL, 50, NULL, NULL, NULL, NULL, 0xFFFFFFFF, 7, 2, NULL, NULL, NULL, NULL, NULL, '{ pet 1; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13073, 'Counter_Dagger_', 'カウンターダガー', 5, 120000, NULL, 550, 140, NULL, 1, 1, 0x00810204, 7, 2, 2, 4, 55, 1, 1, '{ bonus bCritical,90; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13082, 'Ivory_Knife_', 'アイボリーナイフ', 5, 20, NULL, 700, 130, NULL, 1, 3, 0x028F5EEE, 2, 2, 2, 3, 50, 1, 1, '{ bonus bAgi,2; bonus bAspdRate,3; bonus2 bAddEff,Eff_Bleeding,300; bonus3 bAutoSpell,"NPC_CRITICALWOUND",1,30; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13250, 'Shuriken', '手裏剣', 10, 4, NULL, 1, 10, NULL, NULL, NULL, 0x02000000, 7, 2, 32768, NULL, 1, NULL, 6, '{}', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13251, 'Nimbus_Shuriken', '雨雲の手裏剣', 10, 10, NULL, 1, 30, NULL, NULL, NULL, 0x02000000, 7, 2, 32768, NULL, 20, NULL, 6, '{}', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13252, 'Flash_Shuriken', '閃光の手裏剣', 10, 20, NULL, 1, 45, NULL, NULL, NULL, 0x02000000, 7, 2, 32768, NULL, 40, NULL, 6, '{}', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13253, 'Sharp_Leaf_Shuriken', '鋭刃の手裏剣', 10, 40, NULL, 1, 70, NULL, NULL, NULL, 0x02000000, 7, 2, 32768, NULL, 60, NULL, 6, '{}', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13254, 'Thorn_Needle_Shuriken', '刺針の手裏剣', 10, 100, NULL, 1, 100, NULL, NULL, NULL, 0x02000000, 7, 2, 32768, NULL, 80, NULL, 6, '{}', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13255, 'Kunai_Of_Icicle', '氷柱の苦無', 10, 10, NULL, 5, 30, NULL, NULL, NULL, 0x02000000, 7, 2, 32768, NULL, 1, NULL, 7, '{ bonus bAtkEle,Ele_Water; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13256, 'Kunai_Of_Black_Soil', '黒土の苦無', 10, 10, NULL, 5, 30, NULL, NULL, NULL, 0x02000000, 7, 2, 32768, NULL, 1, NULL, 7, '{ bonus bAtkEle,Ele_Earth; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13257, 'Kunai_Of_Furious_Wind', '狂風の苦無', 10, 10, NULL, 5, 30, NULL, NULL, NULL, 0x02000000, 7, 2, 32768, NULL, 1, NULL, 7, '{ bonus bAtkEle,Ele_Wind; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13258, 'Kunai_Of_Fierce_Flame', '烈火の苦無', 10, 10, NULL, 5, 30, NULL, NULL, NULL, 0x02000000, 7, 2, 32768, NULL, 1, NULL, 7, '{ bonus bAtkEle,Ele_Fire; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13259, 'Kunai_Of_Deadly_Poison', '猛毒の苦無', 10, 10, NULL, 5, 30, NULL, NULL, NULL, 0x02000000, 7, 2, 32768, NULL, 1, NULL, 7, '{ bonus bAtkEle,Ele_Poison; bonus2 bAddEff,Eff_Poison,500; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13435, 'Fire_Brand_', 'ファイアーブランド', 5, 20, NULL, 500, 100, NULL, 1, 3, 0x000654E2, 7, 2, 2, 4, 40, 1, 2, '{ bonus bAtkEle,Ele_Fire; skill "MG_FIREBOLT",3; bonus3 bAutoSpell,"MG_FIREBOLT",3,100; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13436, 'Ice_Falchon_', 'アイスファルシオン', 5, 20, NULL, 600, 100, NULL, 1, 3, 0x000654E2, 7, 2, 2, 4, 40, 1, 2, '{ bonus bAtkEle,Ele_Water; bonus2 bAddEff,Eff_Freeze,500; bonus2 bAddEff2,Eff_Freeze,10; skill "MG_COLDBOLT",3; bonus3 bAutoSpell,"MG_COLDBOLT",3,100; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (13437, 'Orcish_Sword_', 'オーキッシュソード', 5, 20, NULL, 800, 90, NULL, 1, 4, 0x000654E3, 7, 2, 2, 3, 5, 1, 2, '{ bonus bUnbreakableWeapon; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (16022, 'Nemesis_', 'ネメシス', 5, 20, NULL, 900, 120, NULL, 1, 2, 0x00008110, 7, 2, 2, 4, 60, 1, 8, '{ bonus bAtkEle,Ele_Holy; bonus2 bAddEle,Ele_Dark,10; bonus2 bAddRace,RC_Demon,10; bonus3 bAutoSpell,"AL_CRUCIS",1+getrefine(),100; autobonus "{ bonus bBaseAtk,50; }",10,20000,BF_WEAPON,"{ specialeffect2 EF_BLOODDRAIN; }"; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (16024, 'Quadrille_', 'カドリール', 5, 20, NULL, 900, 165, NULL, 1, 2, 0x00008110, 7, 2, 2, 4, 40, 1, 8, '{ bonus2 bAddRace,RC_Undead,10; bonus2 bAddRace,RC_DemiHuman,10; bonus2 bAddRace,RC_Player,10; bonus2 bAddEle,Ele_Earth,10; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (18115, 'Orc_Archer_Bow_', 'オークアーチャーの弓', 5, 20, NULL, 1600, 120, NULL, 5, 1, 0x000A0808, 7, 2, 34, 3, 65, 1, 11, '{ bonus2 bAddMonsterDropItem,1753,200; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (18594, 'Magni_Cap_', 'マグニキャップ', 4, 30000, NULL, 1000, NULL, 5, NULL, 1, 0xFFFFFFFE, 7, 2, 256, NULL, 65, 1, 250, '{ bonus bStr,2; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (18667, 'Cat_Lace_Hairband', '子猫のヘッドドレス', 4, 20, NULL, 500, NULL, 0, NULL, 1, 0xFFFFFFFE, 63, 2, 256, NULL, 60, 1, 816, '{ bonus bDelayRate,-5-5*(getrefine()>=7)-3*(getrefine()>=9); }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (18751, 'Lucky_Clover', 'ラッキークローバー', 4, 20, NULL, 100, NULL, 0, NULL, 0, 0xFFFFFFFF, 63, 2, 1, NULL, 50, 0, 571, '{ bonus bFlee2,2; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (21003, 'Muramasa_', '村正', 5, 20, NULL, 1000, 155, NULL, 1, 2, 0x00004082, 7, 2, 34, 4, 48, 1, 3, '{ bonus bCritical,30; bonus bAspdRate,8; bonus2 bAddEff2,Eff_Curse,10; }', '{}', '{}');
REPLACE INTO `item_db2` VALUES (21004, 'Alca_Bringer_', 'アルカブリンガー', 5, 20, NULL, 3400, 280, NULL, 2, 2, 0x00004082, 2, 2, 34, 3, 99, 1, 3, '{ bonus bAspd,(getrefine()/2); }', '{}', '{}');
