-	script	::CastleTrial	-1,{
OnStart:
	set dupvar(.rid), getcharid(3, dupvar(.nic$));
	set dupvar(.cid), getcharid(0, dupvar(.nic$));
	attachrid dupvar(.rid);
	set @act_cas_tri$, strnpcinfo(2);
	killmonsterall "this";
	for (set .@i, 0; .@i < 3; ++.@i) {
		set .@are_bas, 4 * .@i;
		for (; .@j < dupele(.are_mob_bous, .@i); ++.@j) {
			set .@are_mob_bas, 2 * .@j;
			areamonster 
				"this", 
				dupele(.are, .@are_bas + 0), 
				dupele(.are, .@are_bas + 1), 
				dupele(.are, .@are_bas + 2), 
				dupele(.are, .@are_bas + 3), 
				"--ja--", 
				dupele(.are_mobs, .@are_mob_bas + 0), 
				dupele(.are_mobs, .@are_mob_bas + 1), 
				strnpcinfo(0) + "::OnTrashMobDead";
		}
	}
	set .@fix_mobs_siz, getarraysize(dupvar(.fix_mobs)) / 3;
	for (set .@i, 0; .@i < .@fix_mobs_siz; ++.@i) {
		set .@fix_mob_bas, 3 * .@i;
		monster 
			"this", 
			dupele(.fix_mobs, .@fix_mob_bas + 0), 
			dupele(.fix_mobs, .@fix_mob_bas + 1), 
			"--ja--", 
			dupele(.fix_mobs, .@fix_mob_bas + 2), 
			1, 
			strnpcinfo(0) + "::OnFixedMobDead";
	}
	set dupvar(.tim_rem), dupele(.tim_pois, 0) * 60;
	announce dupvar(.cas_nam$) + "で砦の試練が開始されました。", 0;
	initnpctimer;
	end;
OnAbort:
	specialeffect2 EF_TEMP_FAIL, AREA, strcharinfo(0, dupvar(.cid));
	announce "挑戦者が攻略を断念しました、試練を中止します。", 0x9, 0xff0000;
	callsub Stop;
OnFixedMobDead:
OnTrashMobDead:
	if (!getmapmobs("this", strnpcinfo(0) + "::OnFixedMobDead") &&
		getmapmobs("this", strnpcinfo(0) + "::OnTrashMobDead") <= 10
	) {
		killmonsterall "this";
		set .@exi_nam$, "CastleExit#" + strnpcinfo(2);
		specialeffect EF_BASH, AREA, .@exi_nam$;
		disablenpc .@exi_nam$;
		set .@bos_mobs_siz, getarraysize(dupvar(.bos_mobs)) / 3;
		for (set .@i, 0; .@i < .@bos_mobs_siz; ++.@i) {
			set .@bos_mob_bas, 3 * .@i;
			monster 
				"this", 
				dupele(.bos_mobs, .@bos_mob_bas + 0), 
				dupele(.bos_mobs, .@bos_mob_bas + 1), 
				"--ja--", 
				dupele(.bos_mobs, .@bos_mob_bas + 2), 
				1, 
				strnpcinfo(0) + "::OnBossMobDead";
		}
		announce "最深部にボスモンスターが出現しました。", 0x9, 0x00ffff;
	}
	end;
OnBossMobDead:
	if (!getmapmobs("this", strnpcinfo(0) + "::OnBossMobDead")) {
		monster 
			"this", 
			dupele(.rew, 0), 
			dupele(.rew, 1), 
			"--ja--", 
			dupele(.rew, 2), 
			1, 
			strnpcinfo(0) + "::OnRewardOpen";
		blockeffect EF_POTIONPILLAR, $@mobid[0];
	}
	end;
OnRewardOpen:
	if (isactive(dupvar(.rid))) {
		attachrid dupvar(.rid);
		set dupvar(CAPTURED), 1;
		set CASTLE_TRIAL_RETRY, 0;
		specialeffect2 EF_TEMP_OK, AREA, strcharinfo(0, dupvar(.cid));
	}
	announce "おめでとうございます、砦の攻略に成功しました！！", 0x9, 0x00ffff;
	callsub Stop;
OnTimer1000:
	if (isactive(dupvar(.rid))) {
		set dupvar(.tim_rem), dupvar(.tim_rem) - 1;
		if (dupvar(.tim_rem)) {
			set .@tim_pois_siz, getarraysize(dupvar(.tim_pois));
			for (set .@i, 1; .@i < .@tim_pois_siz; ++.@i) {
				set .@tim_poi, dupele(.tim_pois, .@i);
				if (dupvar(.tim_rem) == .@tim_poi * 60) {
					announce "タイムリミットまで残り" + .@tim_poi + "分です。", 0x9, 0xff0000;
					break;
				}
			}
			initnpctimer;
		} else {
			specialeffect2 EF_TEMP_FAIL, AREA, strcharinfo(0, dupvar(.cid));
			announce "タイムオーバーです、砦の攻略に失敗しました。", 0x9, 0xff0000;
			callsub Stop;
		}
	} else {
		announce "挑戦者がログアウトしました、試練を中止します。", 0x9, 0xff0000;
		callsub Stop;
	}
	end;
Stop:
	stopnpctimer;
	killmonsterall "this";
	if (isactive(dupvar(.rid))) {
		attachrid dupvar(.rid);
		set @act_cas_tri$, "";
	}
	sleep 5000;
	set .@exi_nam$, "CastleExit#" + strnpcinfo(2);
	if (checknpcoption(OPTION_INVISIBLE, .@exi_nam$)) {
		enablenpc .@exi_nam$;
		specialeffect EF_SUMMONSLAVE, AREA, .@exi_nam$;
	}
	sleep 5000;
	announce dupvar(.cas_nam$) + "で砦の試練が終了しました。", 0;
	set dupvar(.nic$), "";
}



aldeg_cas01,0,0,0	duplicate(CastleTrial)	CastleTrial#aldeg_cas01	-1
aldeg_cas02,0,0,0	duplicate(CastleTrial)	CastleTrial#aldeg_cas02	-1
aldeg_cas03,0,0,0	duplicate(CastleTrial)	CastleTrial#aldeg_cas03	-1
aldeg_cas04,0,0,0	duplicate(CastleTrial)	CastleTrial#aldeg_cas04	-1
aldeg_cas05,0,0,0	duplicate(CastleTrial)	CastleTrial#aldeg_cas05	-1

aldeg_cas01,227,12,0	warp	CastleExit#aldeg_cas01	1,1,alde_gld,48,83
aldeg_cas02,202,8,0	warp	CastleExit#aldeg_cas02	1,1,alde_gld,95,249
aldeg_cas03,197,38,0	warp	CastleExit#aldeg_cas03	1,1,alde_gld,142,85
aldeg_cas04,28,210,0	warp	CastleExit#aldeg_cas04	1,1,alde_gld,239,242
aldeg_cas05,37,111,0	warp	CastleExit#aldeg_cas05	1,1,alde_gld,264,90

-	script	CastleTrialInit#aldeg_cas01	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ルイーナ 砦1";
	setarray dupvar(.cen_xy, .@tar$), 63, 58;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 11, 181, 65, 253;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1213, 30,
		1686, 30,
		1717, 30,
		1386, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 45, 32, 121, 107;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1983, 30,
		1982, 30,
		1984, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 176, 127, 235, 181;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1850, 30,
		1981, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		212, 174, 1087;
	setarray dupvar(.bos_mobs, .@tar$), 
		215,  23, 1850,
		215,  24, 1850,
		215,  25, 1850,
		216,  23, 1850,
		216,  24, 1190,
		216,  25, 1850,
		217,  23, 1850,
		217,  24, 1850,
		217,  25, 1850;
	setarray dupvar(.rew, .@tar$), 
		216,  24, 1325;
}

-	script	CastleTrialInit#aldeg_cas02	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ルイーナ 砦2";
	setarray dupvar(.cen_xy, .@tar$), 71, 266;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 16, 160, 95, 213;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1735, 30,
		1736, 30,
		1505, 30,
		1371, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 49, 8, 125, 89;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1370, 30,
		1374, 30,
		1295, 15;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 174, 130, 221, 191;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1754, 15,
		1713, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		218, 188, 1150;
	setarray dupvar(.bos_mobs, .@tar$), 
		213,  24, 1754,
		214,  23, 1754,
		214,  24, 1685,
		214,  25, 1754,
		215,  24, 1754;
	setarray dupvar(.rew, .@tar$), 
		214,  24, 1327;
}

-	script	CastleTrialInit#aldeg_cas03	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ルイーナ 砦3";
	setarray dupvar(.cen_xy, .@tar$), 120, 58;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 33, 210, 118, 291;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1386, 30,
		1405, 30,
		1884, 30,
		1780, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 58, 56, 127, 123;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1672, 30,
		1678, 30,
		1618, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 174, 144, 220, 187;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1289, 30,
		1717, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		192, 179, 1147;
	setarray dupvar(.bos_mobs, .@tar$), 
		205,  32, 1289,
		206,  31, 1289,
		206,  32, 1688,
		206,  33, 1289,
		207,  32, 1289;
	setarray dupvar(.rew, .@tar$), 
		206,  32, 1329;
}

-	script	CastleTrialInit#aldeg_cas04	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ルイーナ 砦4";
	setarray dupvar(.cen_xy, .@tar$), 256, 259;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 153, 7, 203, 101;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1665, 30,
		1664, 30,
		1667, 30,
		1666, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 22, 62, 77, 125;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1735, 30,
		1736, 30,
		1617, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 104, 159, 166, 235;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1268, 30,
		1622, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		136, 214, 1583;
	setarray dupvar(.bos_mobs, .@tar$), 
		 35, 217, 1268,
		 35, 218, 1268,
		 35, 219, 1268,
		 36, 217, 1268,
		 36, 218, 1623,
		 36, 219, 1268,
		 37, 217, 1268,
		 37, 218, 1268,
		 37, 219, 1268;
	setarray dupvar(.rew, .@tar$), 
		 36, 218, 1331;
}

-	script	CastleTrialInit#aldeg_cas05	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ルイーナ 砦5";
	setarray dupvar(.cen_xy, .@tar$), 242, 69;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 144, 38, 226, 107;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1390, 30,
		1769, 30,
		1770, 30,
		1201, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 8, 176, 65, 231;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1295, 15,
		1735, 30,
		1736, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 128, 190, 167, 233;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1302, 15,
		1148, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		156, 220, 1150;
	setarray dupvar(.bos_mobs, .@tar$), 
		 27, 102, 1302,
		 28, 101, 1302,
		 28, 102, 1389,
		 28, 103, 1302,
		 29, 102, 1302;
	setarray dupvar(.rew, .@tar$), 
		 28, 102, 1333;
}



gefg_cas01,0,0,0	duplicate(CastleTrial)	CastleTrial#gefg_cas01	-1
gefg_cas02,0,0,0	duplicate(CastleTrial)	CastleTrial#gefg_cas02	-1
gefg_cas03,0,0,0	duplicate(CastleTrial)	CastleTrial#gefg_cas03	-1
gefg_cas04,0,0,0	duplicate(CastleTrial)	CastleTrial#gefg_cas04	-1
gefg_cas05,0,0,0	duplicate(CastleTrial)	CastleTrial#gefg_cas05	-1

gefg_cas01,198,191,0	warp	CastleExit#gefg_cas01	1,1,gef_fild13,214,75
gefg_cas02,168,169,0	warp	CastleExit#gefg_cas02	1,1,gef_fild13,308,240
gefg_cas03,234,156,0	warp	CastleExit#gefg_cas03	1,1,gef_fild13,143,240
gefg_cas04,183,178,0	warp	CastleExit#gefg_cas04	1,1,gef_fild13,193,278
gefg_cas05,194,171,0	warp	CastleExit#gefg_cas05	1,1,gef_fild13,305,87

-	script	CastleTrialInit#gefg_cas01	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ブリトニア 砦";
	setarray dupvar(.cen_xy, .@tar$), 179, 88;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 11, 135, 100, 195;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1865, 30,
		1371, 30,
		1297, 30,
		1132, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 32, 8, 91, 85;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1198, 15,
		1702, 15,
		1864, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 170, 12, 210, 53;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1870, 15,
		1700, 15;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		190, 52, 1038;
	setarray dupvar(.bos_mobs, .@tar$), 
		197, 182, 1870,
		198, 181, 1870,
		198, 182, 1765,
		198, 183, 1870,
		199, 182, 1870;
	setarray dupvar(.rew, .@tar$), 
		198, 182, 1335;
}

-	script	CastleTrialInit#gefg_cas02	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ブリトニア 砦2";
	setarray dupvar(.cen_xy, .@tar$), 312, 266;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 18, 121, 141, 182;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1388, 15,
		1657, 30,
		1869, 30,
		1693, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 10, 12, 81, 69;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1702, 15,
		1703, 15,
		1371, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 148, 10, 185, 49;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1700, 15,
		1701, 15;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		150, 46, 1418;
	setarray dupvar(.bos_mobs, .@tar$), 
		175, 178, 1700,
		176, 177, 1700,
		176, 178, 1768,
		176, 179, 1700,
		177, 178, 1700;
	setarray dupvar(.rew, .@tar$), 
		176, 178, 1337;
}

-	script	CastleTrialInit#gefg_cas03	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ブリトニア 砦3";
	setarray dupvar(.cen_xy, .@tar$), 86, 237;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 11, 156, 131, 291;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1401, 30,
		1203, 15,
		1204, 15,
		1205, 15;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 90, 14, 165, 93;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1370, 30,
		1374, 30,
		1382, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 210, 10, 267, 75;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1268, 30,
		1507, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		212, 26, 1157;
	setarray dupvar(.bos_mobs, .@tar$), 
		244, 166, 1268,
		244, 167, 1268,
		244, 168, 1268,
		245, 166, 1268,
		245, 167, 1039,
		245, 168, 1268,
		246, 166, 1268,
		246, 167, 1268,
		246, 168, 1268;
	setarray dupvar(.rew, .@tar$), 
		245, 167, 1339;
}

-	script	CastleTrialInit#gefg_cas04	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ブリトニア 砦4";
	setarray dupvar(.cen_xy, .@tar$), 189, 311;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 10, 143, 54, 229;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1390, 30,
		1202, 30,
		1200, 30,
		1377, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 16, 8, 75, 81;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1702, 15,
		1371, 30,
		1655, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 140, 32, 179, 67;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1755, 15,
		1701, 15;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		178, 66, 1658;
	setarray dupvar(.bos_mobs, .@tar$), 
		173, 178, 1755,
		174, 177, 1755,
		174, 178, 1630,
		174, 179, 1755,
		175, 178, 1755;
	setarray dupvar(.rew, .@tar$), 
		174, 178, 1341;
}

-	script	CastleTrialInit#gefg_cas05	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ブリトニア 砦5";
	setarray dupvar(.cen_xy, .@tar$), 294, 65;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 6, 130, 112, 206;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1707, 15,
		1208, 30,
		1301, 30,
		1869, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 36, 15, 95, 77;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1705, 15,
		1706, 15,
		1307, 15;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 148, 14, 207, 73;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1867, 30,
		1704, 15;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		190, 16, 1046;
	setarray dupvar(.bos_mobs, .@tar$), 
		193, 183, 1867,
		193, 184, 1867,
		193, 185, 1867,
		194, 183, 1867,
		194, 184, 1708,
		194, 185, 1867,
		195, 183, 1867,
		195, 184, 1867,
		195, 185, 1867;
	setarray dupvar(.rew, .@tar$), 
		194, 184, 1343;
}



payg_cas01,0,0,0	duplicate(CastleTrial)	CastleTrial#payg_cas01	-1
payg_cas02,0,0,0	duplicate(CastleTrial)	CastleTrial#payg_cas02	-1
payg_cas03,0,0,0	duplicate(CastleTrial)	CastleTrial#payg_cas03	-1
payg_cas04,0,0,0	duplicate(CastleTrial)	CastleTrial#payg_cas04	-1
payg_cas05,0,0,0	duplicate(CastleTrial)	CastleTrial#payg_cas05	-1

payg_cas01,149,139,0	warp	CastleExit#payg_cas01	1,1,pay_gld,121,233
payg_cas02,39,10,0	warp	CastleExit#payg_cas02	1,1,pay_gld,295,116
payg_cas03,267,276,0	warp	CastleExit#payg_cas03	1,1,pay_gld,317,293
payg_cas04,271,21,0	warp	CastleExit#payg_cas04	1,1,pay_gld,140,160
payg_cas05,45,46,0	warp	CastleExit#payg_cas05	1,1,pay_gld,198,264

-	script	CastleTrialInit#payg_cas01	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "チュンリム湖 砦1";
	setarray dupvar(.cen_xy, .@tar$), 107, 270;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 193, 43, 243, 135;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1654, 30,
		1405, 30,
		1206, 30,
		1216, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 64, 12, 135, 61;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1678, 30,
		1717, 30,
		1386, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 11, 112, 55, 147;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1289, 15,
		1672, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		53, 119, 1147;
	setarray dupvar(.bos_mobs, .@tar$), 
		138, 139, 1289,
		139, 138, 1289,
		139, 139, 1312,
		139, 140, 1289,
		140, 139, 1289;
	setarray dupvar(.rew, .@tar$), 
		139, 139, 1345;
}

-	script	CastleTrialInit#payg_cas02	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "チュンリム湖 砦2";
	setarray dupvar(.cen_xy, .@tar$), 272, 128;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 186, 16, 277, 88;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1296, 30,
		1299, 30,
		1774, 30,
		1321, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 6, 222, 83, 293;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1713, 30,
		1716, 30,
		1262, 15;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 244, 240, 289, 292;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1259, 15,
		1376, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		255, 247, 1059;
	setarray dupvar(.bos_mobs, .@tar$), 
		37, 25, 1259,
		38, 24, 1259,
		38, 25, 1719,
		38, 26, 1259,
		39, 25, 1259;
	setarray dupvar(.rew, .@tar$), 
		38, 25, 1347;
}

-	script	CastleTrialInit#payg_cas03	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "チュンリム湖 砦3";
	setarray dupvar(.cen_xy, .@tar$), 351, 293;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 219, 21, 283, 91;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1717, 30,
		1310, 30,
		1319, 30,
		1306, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 12, 4, 65, 85;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1783, 15,
		1678, 30,
		1381, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 6, 244, 51, 289;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1283, 15,
		1672, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		29, 288, 1115;
	setarray dupvar(.bos_mobs, .@tar$), 
		268, 265, 1283,
		269, 264, 1283,
		269, 265, 1785,
		269, 266, 1283,
		270, 265, 1283;
	setarray dupvar(.rew, .@tar$), 
		269, 265, 1349;
}

-	script	CastleTrialInit#payg_cas04	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "チュンリム湖 砦4";
	setarray dupvar(.cen_xy, .@tar$), 135, 74;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 216, 150, 271, 276;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1318, 30,
		1200, 30,
		1154, 30,
		1652, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 6, 230, 79, 289;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1098, 30,
		1769, 30,
		1770, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 12, 10, 61, 49;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1366, 30,
		1837, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		16, 31, 1086;
	setarray dupvar(.bos_mobs, .@tar$), 
		270, 28, 1366,
		270, 29, 1366,
		270, 30, 1366,
		271, 28, 1366,
		271, 29, 1511,
		271, 30, 1366,
		272, 28, 1366,
		272, 29, 1366,
		272, 30, 1366;
	setarray dupvar(.rew, .@tar$), 
		271, 29, 1351;
}

-	script	CastleTrialInit#payg_cas05	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "チュンリム湖 砦5";
	setarray dupvar(.cen_xy, .@tar$), 223, 285;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 14, 222, 77, 285;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1753, 30,
		1382, 30,
		1416, 30,
		1773, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 218, 222, 293, 288;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1374, 30,
		1866, 30,
		1752, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 238, 6, 291, 45;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1379, 30,
		1370, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		254, 41, 1492;
	setarray dupvar(.bos_mobs, .@tar$), 
		31, 31, 1379,
		31, 32, 1379,
		31, 33, 1379,
		32, 31, 1379,
		32, 32, 1871,
		32, 33, 1379,
		33, 31, 1379,
		33, 32, 1379,
		33, 33, 1379;
	setarray dupvar(.rew, .@tar$), 
		32, 32, 1353;
}



prtg_cas01,0,0,0	duplicate(CastleTrial)	CastleTrial#prtg_cas01	-1
prtg_cas02,0,0,0	duplicate(CastleTrial)	CastleTrial#prtg_cas02	-1
prtg_cas03,0,0,0	duplicate(CastleTrial)	CastleTrial#prtg_cas03	-1
prtg_cas04,0,0,0	duplicate(CastleTrial)	CastleTrial#prtg_cas04	-1
prtg_cas05,0,0,0	duplicate(CastleTrial)	CastleTrial#prtg_cas05	-1

prtg_cas01,205,205,0	warp	CastleExit#prtg_cas01	1,1,prt_gld,134,65
prtg_cas02,173,177,0	warp	CastleExit#prtg_cas02	1,1,prt_gld,240,128
prtg_cas03,6,230,0	warp	CastleExit#prtg_cas03	1,1,prt_gld,153,137
prtg_cas04,274,8,0	warp	CastleExit#prtg_cas04	1,1,prt_gld,111,240
prtg_cas05,260,266,0	warp	CastleExit#prtg_cas05	1,1,prt_gld,208,240

-	script	CastleTrialInit#prtg_cas01	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ヴァルキリーレルム 砦1";
	setarray dupvar(.cen_xy, .@tar$), 102, 94;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 20, 6, 103, 85;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1317, 30,
		1515, 30,
		1206, 30,
		1777, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 144, 62, 201, 120;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1259, 15,
		1310, 30,
		1381, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 72, 129, 160, 207;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1319, 30,
		1283, 15;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		126, 163, 1159;
	setarray dupvar(.bos_mobs, .@tar$), 
		196, 197, 1283,
		197, 196, 1283,
		197, 197, 1252,
		197, 198, 1283,
		198, 197, 1283;
	setarray dupvar(.rew, .@tar$), 
		197, 197, 1355;
}

-	script	CastleTrialInit#prtg_cas02	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ヴァルキリーレルム 砦2";
	setarray dupvar(.cen_xy, .@tar$), 216, 89;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 13, 153, 85, 234;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1315, 30,
		1376, 30,
		1310, 30,
		1513, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 42, 20, 101, 87;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1670, 30,
		1716, 30,
		1283, 15;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 166, 22, 205, 61;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1259, 15,
		1677, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		184,  40, 1251;
	setarray dupvar(.bos_mobs, .@tar$), 
		157, 174, 1259,
		158, 173, 1259,
		158, 174, 1885,
		158, 175, 1259,
		159, 174, 1259;
	setarray dupvar(.rew, .@tar$), 
		158, 174, 1357;
}

-	script	CastleTrialInit#prtg_cas03	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ヴァルキリーレルム 砦3";
	setarray dupvar(.cen_xy, .@tar$), 160, 168;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 157, 7, 206, 82;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1866, 30,
		1752, 30,
		1753, 30,
		1504, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 5, 43, 86, 119;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1865, 30,
		1507, 30,
		1505, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 134, 172, 195, 235;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1219, 30,
		1379, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		139, 233, 1038;
	setarray dupvar(.bos_mobs, .@tar$), 
		 16, 220, 1219,
		 16, 221, 1219,
		 16, 222, 1219,
		 17, 220, 1219,
		 17, 221, 1373,
		 17, 222, 1219,
		 18, 220, 1219,
		 18, 221, 1219,
		 18, 222, 1219;
	setarray dupvar(.rew, .@tar$), 
		 17, 221, 1359;
}

-	script	CastleTrialInit#prtg_cas04	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ヴァルキリーレルム 砦4";
	setarray dupvar(.cen_xy, .@tar$), 94, 224;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 22, 9, 94, 60;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1203, 15,
		1204, 15,
		1205, 15,
		1676, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 6, 224, 61, 291;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1678, 30,
		1675, 30,
		1679, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 236, 223, 281, 277;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1219, 30,
		1677, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		247, 249, 1492;
	setarray dupvar(.bos_mobs, .@tar$), 
		289,  12, 1219,
		289,  13, 1219,
		289,  14, 1219,
		290,  12, 1219,
		290,  13, 1734,
		290,  14, 1219,
		291,  12, 1219,
		291,  13, 1219,
		291,  14, 1219;
	setarray dupvar(.rew, .@tar$), 
		290,  13, 1361;
}

-	script	CastleTrialInit#prtg_cas05	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ヴァルキリーレルム 砦5";
	setarray dupvar(.cen_xy, .@tar$), 225, 224;
	setarray dupvar(.tim_pois, .@tar$), 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 7, 230, 85, 279;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1698, 30,
		1774, 30,
		1699, 30,
		1297, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 194, 10, 285, 95;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1864, 30,
		1865, 30,
		1132, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 8, 2, 73, 75;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1098, 30,
		1681, 15;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		 48,  18, 1112;
	setarray dupvar(.bos_mobs, .@tar$), 
		265, 265, 1098,
		265, 266, 1098,
		265, 267, 1098,
		266, 265, 1098,
		266, 266, 1272,
		266, 267, 1098,
		267, 265, 1098,
		267, 266, 1098,
		267, 267, 1098;
	setarray dupvar(.rew, .@tar$), 
		266, 266, 1363;
}



schg_cas01,0,0,0	duplicate(CastleTrial)	CastleTrial#schg_cas01	-1
schg_cas02,0,0,0	duplicate(CastleTrial)	CastleTrial#schg_cas02	-1
schg_cas03,0,0,0	duplicate(CastleTrial)	CastleTrial#schg_cas03	-1
schg_cas04,0,0,0	duplicate(CastleTrial)	CastleTrial#schg_cas04	-1
schg_cas05,0,0,0	duplicate(CastleTrial)	CastleTrial#schg_cas05	-1

schg_cas01,119,284,0	warp	CastleExit#schg_cas01	1,1,sch_gld,293,100
schg_cas02,148,197,0	warp	CastleExit#schg_cas02	1,1,sch_gld,288,252
schg_cas03,315,202,0	warp	CastleExit#schg_cas03	1,1,sch_gld,97,196
schg_cas04,120,283,0	warp	CastleExit#schg_cas04	1,1,sch_gld,137,90
schg_cas05,120,283,0	warp	CastleExit#schg_cas05	1,1,sch_gld,71,315

-	script	CastleTrialInit#schg_cas01	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ニダヴェリール 砦1";
	setarray dupvar(.cen_xy, .@tar$), 295, 75;
	setarray dupvar(.tim_pois, .@tar$), 60, 45, 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 126, 4, 229, 151;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1716, 60,
		1208, 60,
		1376, 60,
		1259, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 16, 4, 113, 151;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1713, 60,
		1677, 60,
		1670, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 76, 160, 163, 307;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1720, 30,
		1638, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		208, 76, 1630,
		28, 37, 1719;
	setarray dupvar(.bos_mobs, .@tar$), 
		119, 272, 1720,
		120, 271, 1720,
		120, 272, 1650,
		120, 273, 1720,
		121, 272, 1720;
	setarray dupvar(.rew, .@tar$), 
		120, 272, 1938;
}

-	script	CastleTrialInit#schg_cas02	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ニダヴェリール 砦2";
	setarray dupvar(.cen_xy, .@tar$), 262, 274;
	setarray dupvar(.tim_pois, .@tar$), 60, 45, 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 221, 33, 370, 124;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1701, 30,
		1703, 30,
		1713, 60,
		1371, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 232, 127, 348, 235;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1755, 30,
		1700, 30,
		1702, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 155, 108, 229, 227;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1637, 60,
		1755, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		232, 59, 1765,
		334, 228, 1685;
	setarray dupvar(.bos_mobs, .@tar$), 
		162, 193, 1637,
		162, 194, 1637,
		162, 195, 1637,
		163, 193, 1637,
		163, 194, 1751,
		163, 195, 1637,
		164, 193, 1637,
		164, 194, 1637,
		164, 195, 1637;
	setarray dupvar(.rew, .@tar$), 
		163, 194, 1939;
}

-	script	CastleTrialInit#schg_cas03	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ニダヴェリール 砦3";
	setarray dupvar(.cen_xy, .@tar$), 77, 159;
	setarray dupvar(.tim_pois, .@tar$), 60, 45, 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 296, 249, 379, 338;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1219, 60,
		1098, 60,
		1672, 60,
		1678, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 182, 230, 294, 338;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1829, 30,
		1830, 30,
		1289, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 183, 177, 347, 227;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1839, 30,
		1638, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		376, 252, 1190,
		243, 309, 1511;
	setarray dupvar(.bos_mobs, .@tar$), 
		341, 202, 1839,
		342, 201, 1839,
		342, 202, 1648,
		342, 203, 1839,
		343, 202, 1839;
	setarray dupvar(.rew, .@tar$), 
		342, 202, 1940;
}

-	script	CastleTrialInit#schg_cas04	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ニダヴェリール 砦4";
	setarray dupvar(.cen_xy, .@tar$), 139, 111;
	setarray dupvar(.tim_pois, .@tar$), 60, 45, 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 126, 4, 229, 151;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1366, 60,
		1675, 60,
		1837, 60,
		1714, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 16, 4, 113, 151;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1833, 30,
		1268, 60,
		1673, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 76, 160, 163, 307;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1634, 60,
		1831, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		208, 76, 1623,
		28, 37, 1734;
	setarray dupvar(.bos_mobs, .@tar$), 
		119, 271, 1634,
		119, 272, 1634,
		119, 273, 1634,
		120, 271, 1634,
		120, 272, 1832,
		120, 273, 1634,
		121, 271, 1634,
		121, 272, 1634,
		121, 273, 1634;
	setarray dupvar(.rew, .@tar$), 
		120, 272, 1941;
}

-	script	CastleTrialInit#schg_cas05	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ニダヴェリール 砦5";
	setarray dupvar(.cen_xy, .@tar$), 58, 315;
	setarray dupvar(.tim_pois, .@tar$), 60, 45, 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 126, 4, 229, 151;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1706, 30,
		1707, 30,
		1864, 60,
		1865, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 16, 4, 113, 151;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1704, 30,
		1705, 30,
		1983, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 76, 160, 163, 307;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1870, 30,
		1639, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		208, 76, 1768,
		28, 37, 1708;
	setarray dupvar(.bos_mobs, .@tar$), 
		119, 272, 1870,
		120, 271, 1870,
		120, 272, 1651,
		120, 273, 1870,
		121, 272, 1870;
	setarray dupvar(.rew, .@tar$), 
		120, 272, 1942;
}



arug_cas01,0,0,0	duplicate(CastleTrial)	CastleTrial#arug_cas01	-1
arug_cas02,0,0,0	duplicate(CastleTrial)	CastleTrial#arug_cas02	-1
arug_cas03,0,0,0	duplicate(CastleTrial)	CastleTrial#arug_cas03	-1
arug_cas04,0,0,0	duplicate(CastleTrial)	CastleTrial#arug_cas04	-1
arug_cas05,0,0,0	duplicate(CastleTrial)	CastleTrial#arug_cas05	-1

arug_cas01,88,200,0	warp	CastleExit#arug_cas01	1,1,aru_gld,158,272
arug_cas02,72,244,0	warp	CastleExit#arug_cas02	1,1,aru_gld,83,47
arug_cas03,142,312,0	warp	CastleExit#arug_cas03	1,1,aru_gld,68,155
arug_cas04,142,312,0	warp	CastleExit#arug_cas04	1,1,aru_gld,299,345
arug_cas05,142,312,0	warp	CastleExit#arug_cas05	1,1,aru_gld,292,107

-	script	CastleTrialInit#arug_cas01	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ヴァルフレイヤ 砦1";
	setarray dupvar(.cen_xy, .@tar$), 156, 275;
	setarray dupvar(.tim_pois, .@tar$), 60, 45, 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 231, 22, 311, 256;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1701, 30,
		1703, 30,
		1713, 60,
		1388, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 154, 22, 228, 260;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1754, 30,
		1700, 30,
		1702, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 55, 22, 151, 233;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1755, 30,
		1637, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		308, 190, 1765,
		210, 234, 1685;
	setarray dupvar(.bos_mobs, .@tar$), 
		87, 220, 1755,
		88, 219, 1755,
		88, 220, 1649,
		88, 221, 1755,
		89, 220, 1755;
	setarray dupvar(.rew, .@tar$), 
		88, 220, 1943;
}

-	script	CastleTrialInit#arug_cas02	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ヴァルフレイヤ 砦2";
	setarray dupvar(.cen_xy, .@tar$), 69, 45;
	setarray dupvar(.tim_pois, .@tar$), 60, 45, 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 8, 17, 139, 219;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1307, 30,
		1319, 60,
		1259, 30,
		1283, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 140, 17, 271, 219;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1833, 30,
		1673, 60,
		1675, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 12, 225, 183, 375;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1831, 30,
		1634, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		34, 168, 1312,
		246, 168, 1785;
	setarray dupvar(.bos_mobs, .@tar$), 
		89, 256, 1831,
		90, 255, 1831,
		90, 256, 1646,
		90, 257, 1831,
		91, 256, 1831;
	setarray dupvar(.rew, .@tar$), 
		90, 256, 1944;
}

-	script	CastleTrialInit#arug_cas03	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ヴァルフレイヤ 砦3";
	setarray dupvar(.cen_xy, .@tar$), 69, 137;
	setarray dupvar(.tim_pois, .@tar$), 60, 45, 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 44, 40, 137, 179;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1707, 30,
		1706, 30,
		1148, 60,
		1198, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 138, 40, 227, 179;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1704, 30,
		1867, 60,
		1302, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 110, 181, 173, 321;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1639, 60,
		1705, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		66, 172, 1373,
		212, 150, 1039;
	setarray dupvar(.bos_mobs, .@tar$), 
		141, 293, 1639,
		141, 294, 1639,
		141, 295, 1639,
		142, 293, 1639,
		142, 294, 1873,
		142, 295, 1639,
		143, 293, 1639,
		143, 294, 1639,
		143, 295, 1639;
	setarray dupvar(.rew, .@tar$), 
		142, 294, 1945;
}

-	script	CastleTrialInit#arug_cas04	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ヴァルフレイヤ 砦4";
	setarray dupvar(.cen_xy, .@tar$), 290, 363;
	setarray dupvar(.tim_pois, .@tar$), 60, 45, 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 44, 40, 137, 179;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1830, 30,
		1867, 60,
		1219, 60,
		1507, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 138, 40, 227, 179;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1829, 30,
		1268, 60,
		1702, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 110, 181, 173, 321;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1839, 30,
		1636, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		66, 172, 1389,
		212, 150, 1871;
	setarray dupvar(.bos_mobs, .@tar$), 
		141, 294, 1839,
		142, 293, 1839,
		142, 294, 1647,
		142, 295, 1839,
		143, 294, 1839;
	setarray dupvar(.rew, .@tar$), 
		142, 294, 1946;
}

-	script	CastleTrialInit#arug_cas05	-1,{
OnInit:
	set .@tar$, "CastleTrial#" + strnpcinfo(2);
	set dupvar(.cas_nam$, .@tar$), "ヴァルフレイヤ 砦5";
	setarray dupvar(.cen_xy, .@tar$), 284, 104;
	setarray dupvar(.tim_pois, .@tar$), 60, 45, 30, 20, 15, 10, 5, 3, 2, 1;
	setarray .@are[getarraysize(.@are)], 44, 40, 137, 179;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1716, 60,
		1714, 60,
		1717, 60,
		1319, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 138, 40, 227, 179;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1713, 60,
		1671, 60,
		1679, 60;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	setarray .@are[getarraysize(.@are)], 110, 181, 173, 321;
	setarray .@are_mobs[getarraysize(.@are_mobs)], 
		1636, 60,
		1720, 30;
	set .@are_mob_bous[getarraysize(.@are_mob_bous)], getarraysize(.@are_mobs) / 2;
	copyarray dupvar(.are, .@tar$), .@are, getarraysize(.@are);
	copyarray dupvar(.are_mobs, .@tar$), .@are_mobs, getarraysize(.@are_mobs);
	copyarray dupvar(.are_mob_bous, .@tar$), .@are_mob_bous, getarraysize(.@are_mob_bous);
	setarray dupvar(.fix_mobs, .@tar$), 
		66, 172, 1885,
		212, 150, 1719;
	setarray dupvar(.bos_mobs, .@tar$), 
		141, 293, 1636,
		141, 294, 1636,
		141, 295, 1636,
		142, 293, 1636,
		142, 294, 1779,
		142, 295, 1636,
		143, 293, 1636,
		143, 294, 1636,
		143, 295, 1636;
	setarray dupvar(.rew, .@tar$), 
		142, 294, 2945;
}



-	script	::CastlePriestess	-1,{
	if (@act_cas_tri$ == "") {
		if (!CASTLE_TRIAL_INTRODUCTION) callsub Introduce;
		if (BaseLevel < 99) {
			mes "[" + dupvar(.pri_nam$) + "]";
			mes "…………";
			close;
			end;
		}
		if (dupvar(CASTLE_TRIAL_PROG) == 0) callsub Require;
		if (dupvar(CASTLE_TRIAL_PROG) == 1) callsub Pass;
		if (dupvar(CASTLE_TRIAL_PROG) == 2) callsub Complete;
		if (dupvar(CASTLE_TRIAL_PROG) == 2) callsub Trial;
		if (dupvar(CASTLE_TRIAL_PROG) == 3) callsub TrialGuildDungeon;
	} else callsub Abort;
	callsub Bye;
OnInit:
	initnpctimer;
	end;
OnTouch:
	specialeffect EF_MAP_GHOST;
	end;
OnTimer5000:
//	set .@inv, checknpcoption(OPTION_INVISIBLE);
//	if (isnight()) {
//		if (.@inv) {
//			enablenpc;
//			specialeffect EF_MAP_GHOST;
//		}
		specialeffect EF_CHEMICALBODY;
//	} else if (!.@inv) disablenpc;
	initnpctimer;
	end;
Introduce:
	mes "-見知らぬ少女がこちらをじっと";
	mes "　見つめている。-";
	next;
	select("あ、あの……");
	mes "[？]";
	mes "……";
	next;
	mes "-姿がおぼろげで、たまにうっすらと";
	mes "　透けて見えるときがある。-";
	next;
	select("君は一体……");
	if (BaseLevel < 99) {
		mes "[？]";
		mes "…………";
		close;
		end;
	}
	mes "[？]";
	mes "私は^4040FF" + dupvar(.pri_nam$) + "^000000です。";
	next;
//	mes "[" + dupvar(.pri_nam$) + "]";
//	mes "実は……私はもう死んでいます。";
//	mes "遠い昔にこの世を去りました。";
//	next;
//	mes "[" + dupvar(.pri_nam$) + "]";
//	mes "死してなおこうして霊体となり";
//	mes "現世にとどまっているのは";
//	mes "ある使命をまっとうするためです。";
//	next;
//	select("どんな使命なの？");
//	mes "[" + dupvar(.pri_nam$) + "]";
//	mes "私が天に召されようかという";
//	mes "今際の際のまさにその時";
//	mes "我が主^4040FF" + dupvar(.god_nam$) + "^000000が現れ";
//	mes "こう告げられました……";
//	next;
//	mes "　";
//	mes "　^404040-忠実なる我がしもべよ-^000000";
//	mes "　";
//	mes "　^404040-汝のなすべきをなせ-^000000";
//	next;
//	mes "　";
//	mes "　^404040-永劫不滅の魂を以て-^000000";
//	mes "　";
//	mes "　^404040-大いなる使命を果たせ-^000000";
//	next;
//	mes "　";
//	mes "　^404040-彼の砦にて運命は待つ-^000000";
//	mes "　";
//	mes "　^404040-力ある者に道を開け-^000000";
//	next;
	mes "[" + dupvar(.pri_nam$) + "]";
	mes "……私の使命は見所のある冒険者を";
	mes "^4040FF砦の試練^000000へと導くことです。";
	next;
	select("^4040FF砦の試練^000000って？");
	mes "[" + dupvar(.pri_nam$) + "]";
	mes "砦にモンスターたちを召喚します。";
	mes "挑戦者はそれらのほぼすべてを";
	mes "倒さなくてはなりません。";
	next;
	mes "[" + dupvar(.pri_nam$) + "]";
	mes "また砦には貴重な宝が隠されており";
	mes "その回収も攻略の条件です。";
	next;
	mes "[" + dupvar(.pri_nam$) + "]";
	mes "終了後に再び私に申請すれば";
	mes "^FF4040何度でも^000000繰り返し挑戦できます。";
	mes "ただし……";
	next;
	mes "[" + dupvar(.pri_nam$) + "]";
	mes "失敗した場合は制限時間が終わるまで";
	mes "^FF4040再挑戦はできません^000000。";
	next;
//	mes "[" + dupvar(.pri_nam$) + "]";
//	mes "ご覧の通り、私の霊体としての存在は";
//	mes "とても不安定なのです……";
//	mes "日中は霊力が弱まるために姿を現すこと";
//	mes "すらできません。";
//	next;
//	mes "[" + dupvar(.pri_nam$) + "]";
//	mes "ですから私が冒険者を^4040FF砦の試練^000000に";
//	mes "案内できるのは^FF4040夜のあいだ^000000だけ";
//	mes "ということにご留意ください……";
//	next;
	set CASTLE_TRIAL_INTRODUCTION, 1;
	return;
Require:
	set .@req_mvps_siz, getarraysize(dupvar(.req_mvps));
	querymvpstats .@rou, .@mobs;
	if (!.@rou) {
		for (set .@i, 0; .@i < .@req_mvps_siz; ++.@i) {
			set .@req_mvp, dupele(.req_mvps, .@i);
			if (!pchasacquiredmvp(.@req_mvp)) {
				set .@not_acq, 1;
				break;
			}
		}
	}
	if (.@not_acq) {
		mes "[" + dupvar(.pri_nam$) + "]";
		mes "^4040FF砦の試練^000000はとても厳しいものです。";
		mes "並大抵の冒険者では突破することは";
		mes "叶いません。";
		next;
		mes "[" + dupvar(.pri_nam$) + "]";
		mes "そこで、まずはあなたがこの試練に";
		mes "挑戦できる段階にあるかどうかを";
		mes "確かめさせてもらいます。";
		next;
		mes "[" + dupvar(.pri_nam$) + "]";
		mes "以下のMVPをすべて獲得できれば";
		mes "あなたの力を認めましょう。";
		next;
		mes "------ 必要なMVP ------";
		setarray .@vals$, "未獲得", "獲得済み";
		setarray .@cols$, "^FF4040", "^4040FF";
		for (set .@i, 0; .@i < .@req_mvps_siz; ++.@i) {
			set .@req_mvp, dupele(.req_mvps, .@i);
			set .@acq, pchasacquiredmvp(.@req_mvp);
			mes .@cols$[.@acq] + strmobinfo(2, .@req_mvp) + " " + .@vals$[.@acq] + "^000000";
		}
		next;
	} else set dupvar(CASTLE_TRIAL_PROG), 1;
	return;
Pass:
	mes "[" + dupvar(.pri_nam$) + "]";
	mes "なるほど……どうやら必要なMVPを";
	mes "すべて獲得しているようですね。";
	mes "あなたのような気骨のある冒険者に";
	mes "出会えたのは久しぶりです。";
	next;
	mes "[" + dupvar(.pri_nam$) + "]";
	mes "あなたであれば挑戦者として";
	mes "不足はありません。";
	mes "今度はこの城にある5つの砦で";
	mes "その力を示してください。";
	next;
	set dupvar(CASTLE_TRIAL_PROG), 2;
	return;
Complete:
	set .@cas_maps_siz, getarraysize(dupvar(.cas_maps$));
	for (set .@i, 0; .@i < .@cas_maps_siz; ++.@i) {
		set .@cas_map$, dupele(.cas_maps$, .@i);
		if (!getd("CAPTURED_" + .@cas_map$)) {
			set .@not_com, 1;
			break;
		}
	}
	if (!.@not_com) {
		mes "[" + dupvar(.pri_nam$) + "]";
		mes "おお……とうとうこの城にある";
		mes "すべての砦を攻略したのですね。";
		mes "あなたのような冒険者が現れるのを";
		mes "どれほど待ち望んだことか……";
		next;
		mes "[" + dupvar(.pri_nam$) + "]";
		mes "今こそあなたが^4040FFギルドダンジョン^000000に";
		mes "足を踏み入れることを許しましょう。";
		next;
		mes "[" + dupvar(.pri_nam$) + "]";
		mes "^4040FFギルドダンジョン^000000には^4040FF神器^000000と呼ばれる";
		mes "強力な武具の秘密が隠されていると";
		mes "言われています……";
		next;
		mes "[" + dupvar(.pri_nam$) + "]";
		mes "すべての試練を突破できたあなたなら";
		mes "必ずや^4040FF神器^000000を手に入れられる";
		mes "はずです。";
		next;
		set dupvar(CASTLE_TRIAL_PROG), 3;
	}
	return;
TrialGuildDungeon:
	mes "[" + dupvar(.pri_nam$) + "]";
	mes "何をお望みですか？";
	next;
	switch (select("^4040FF砦の試練^000000を受ける", "^4040FFギルドダンジョン^000000に入る", "やめる")) {
	case 1: callsub Trial; break;
	case 2: callsub GuildDungeon; break;
	}
	return;
Trial:
	set .@now_secs, gettimetick(2);
	if (CASTLE_TRIAL_RETRY <= .@now_secs) {
		mes "[" + dupvar(.pri_nam$) + "]";
		mes "どの砦に挑戦しますか？";
		next;
		set .@cas_maps_siz, getarraysize(dupvar(.cas_maps$));
		setarray .@vals$, "未攻略", "攻略済み";
		setarray .@cols$, "^FF4040", "^4040FF";
		for (set .@i, 0; .@i < .@cas_maps_siz; ++.@i) {
			set .@cas_map$, dupele(.cas_maps$, .@i);
			set .@cap, getd("CAPTURED_" + .@cas_map$);
			set .@cas_tri$, "CastleTrial#" + .@cas_map$;
			set .@cas_nam$, dupvar(.cas_nam$, .@cas_tri$);
			set .@cas_nams$[.@i], .@cas_nam$;
			set .@cas_lis$[.@i], .@cols$[.@cap] + .@cas_nam$ + " " + .@vals$[.@cap] + "^000000";
		}
		set .@cas_lis$[.@i], "やめる";
		set .@cas_ind, select(printarray(.@cas_lis$)) - 1;
		if (.@cas_ind < .@cas_maps_siz) {
			set .@cas_nam$, .@cas_nams$[.@cas_ind];
			set .@cas_tri$, "CastleTrial#" + dupele(.cas_maps$, .@cas_ind);
			if (dupvar(.nic$, .@cas_tri$) == "") {
				mes "[" + dupvar(.pri_nam$) + "]";
				mes "^4040FF" + .@cas_nam$ + "^000000ですね。";
				mes "わかりました。";
				next;
				set .@tim_lim, dupele(.tim_pois, 0, .@cas_tri$);
				mes "------ ^4040FF砦の試練^000000 ------";
				mes "^FF4040" + .@tim_lim + "分^000000以内に砦のモンスターを";
				mes "^FF404010匹以下まで^000000倒してください。";
				mes "最後に^FF4040宝箱^000000を開ければ終了です。";
				next;
				mes "------ ^4040FF砦の試練^000000 ------";
				mes "なお^FF4040制限時間をオーバー^000000したり";
				mes "^FF4040ログアウト^000000したりすると^FF4040失格^000000に";
				mes "なりますのでご注意ください。";
				next;
				mes "[" + dupvar(.pri_nam$) + "]";
				mes "それでは始めますよ。";
				mes "準備はよろしいですか？";
				next;
				if (select("はい", "いいえ") == 1) {
					if (dupvar(.nic$, .@cas_tri$) == "") {
						
						// アトミック
						set CASTLE_TRIAL_RETRY, gettimetick(2) + .@tim_lim * 60;
						set dupvar(.nic$, .@cas_tri$), strcharinfo(0);
						donpcevent .@cas_tri$ + "::OnStart";
						soundeffect "se_btg_forward.wav", 0;
						viewpoint 
							1, 
							dupele(.cen_xy, 0, .@cas_tri$), 
							dupele(.cen_xy, 1, .@cas_tri$), 
							1, 
							0xff0000;
						
						mes "[" + dupvar(.pri_nam$) + "]";
						mes "これより^4040FF砦の試練^000000スタートです！";
						mes "一刻も早く^4040FF" + .@cas_nam$ + "^000000へ。";
						mes "ご武運をお祈りします。";
						close;
					} else callsub Wait, .@cas_nam$;
				}
			} else callsub Wait, .@cas_nam$;
		}
	} else {
		mes "------ ^4040FF砦の試練^000000 ------";
		mes "再挑戦できるようになるまで";
		mes "あと^FF4040" + printseconds(CASTLE_TRIAL_RETRY - .@now_secs) + "^000000です。";
		next;
	}
	return;
GuildDungeon:
	warp dupvar(.gui_dun$), dupele(.gui_dun_xy, 0), dupele(.gui_dun_xy, 1);
	end;
Wait:
	mes "------ ^4040FF砦の試練^000000 ------";
	mes "現在^4040FF" + getarg(0) + "^000000では";
	mes "他のプレイヤーが挑戦中です。";
	mes "終了までお待ちください。";
	next;
	return;
Abort:
	set .@cas_tri$, "CastleTrial#" + @act_cas_tri$;
	set .@cas_nam$, dupvar(.cas_nam$, .@cas_tri$);
	mes "[" + dupvar(.pri_nam$) + "]";
	mes "^4040FF" + .@cas_nam$ + "^000000の攻略を";
	mes "断念するのですか？";
	next;
	if (select("はい", "いいえ") == 1) {
		donpcevent .@cas_tri$ + "::OnAbort";
		viewpoint 2, 0, 0, 1, 0xFF0000;
		mes "[" + dupvar(.pri_nam$) + "]";
		mes "仕方がありませんね……";
		mes "今回はこれで終了とします。";
		close;
	}
	return;
Bye:
	mes "[" + dupvar(.pri_nam$) + "]";
	mes "あなたに^4040FF" + dupvar(.god_nam$) + "^000000様の";
	mes "ご加護がありますように。";
	close;
}



alde_gld,186,157,4	duplicate(CastlePriestess)	不思議な少女#alde_gld	124,14,14
gef_fild13,173,235,4	duplicate(CastlePriestess)	不思議な少女#gef_fild13	124,14,14
pay_gld,227,177,4	duplicate(CastlePriestess)	不思議な少女#pay_gld	124,14,14
prt_gld,160,95,4	duplicate(CastlePriestess)	不思議な少女#prt_gld	124,14,14
sch_gld,218,86,4	duplicate(CastlePriestess)	不思議な少女#sch_gld	124,14,14
aru_gld,213,202,4	duplicate(CastlePriestess)	不思議な少女#aru_gld	914,14,14

-	script	CastlePriestessInit#alde_gld	-1,{
OnInit:
	set .@tar$, "不思議な少女#" + strnpcinfo(2);
	set dupvar(.pri_nam$, .@tar$), "ルイーナの巫女";
	set dupvar(.god_nam$, .@tar$), "オーディン";
	setarray dupvar(.req_mvps, .@tar$), 
		1190, 1087, 
		1685, 1150, 
		1688, 1147, 
		1623, 1583, 
		1389;
	setarray dupvar(.cas_maps$, .@tar$), 
		"aldeg_cas01", 
		"aldeg_cas02", 
		"aldeg_cas03", 
		"aldeg_cas04",
		"aldeg_cas05";
	set dupvar(.gui_dun$, .@tar$), "gld_dun02";
	setarray dupvar(.gui_dun_xy, .@tar$), 175, 112;
}

-	script	CastlePriestessInit#gef_fild13	-1,{
OnInit:
	set .@tar$, "不思議な少女#" + strnpcinfo(2);
	set dupvar(.pri_nam$, .@tar$), "ブリトニアの巫女";
	set dupvar(.god_nam$, .@tar$), "オーディン";
	setarray dupvar(.req_mvps, .@tar$), 
		1038, 
		1768, 1418, 
		1039, 1157, 
		1630, 1658, 
		1708, 1046;
	setarray dupvar(.cas_maps$, .@tar$), 
		"gefg_cas01", 
		"gefg_cas02", 
		"gefg_cas03", 
		"gefg_cas04",
		"gefg_cas05";
	set dupvar(.gui_dun$, .@tar$), "gld_dun04";
	setarray dupvar(.gui_dun_xy, .@tar$), 110, 25;
}

-	script	CastlePriestessInit#pay_gld	-1,{
OnInit:
	set .@tar$, "不思議な少女#" + strnpcinfo(2);
	set dupvar(.pri_nam$, .@tar$), "チュンリム湖の巫女";
	set dupvar(.god_nam$, .@tar$), "オーディン";
	setarray dupvar(.req_mvps, .@tar$), 
		1312, 1147,
		1719, 1059,
		1785, 1115,
		1511, 1086,
		1871, 1492;
	setarray dupvar(.cas_maps$, .@tar$), 
		"payg_cas01", 
		"payg_cas02", 
		"payg_cas03", 
		"payg_cas04",
		"payg_cas05";
	set dupvar(.gui_dun$, .@tar$), "gld_dun01";
	setarray dupvar(.gui_dun_xy, .@tar$), 119, 19;
}

-	script	CastlePriestessInit#prt_gld	-1,{
OnInit:
	set .@tar$, "不思議な少女#" + strnpcinfo(2);
	set dupvar(.pri_nam$, .@tar$), "ヴァルキリーレルムの巫女";
	set dupvar(.god_nam$, .@tar$), "オーディン";
	setarray dupvar(.req_mvps, .@tar$), 
		1252, 1159, 
		1885, 1251, 
		1373, 1038,
		1734, 1492,
		1272, 1112;
	setarray dupvar(.cas_maps$, .@tar$), 
		"prtg_cas01", 
		"prtg_cas02", 
		"prtg_cas03", 
		"prtg_cas04",
		"prtg_cas05";
	set dupvar(.gui_dun$, .@tar$), "gld_dun03";
	setarray dupvar(.gui_dun_xy, .@tar$), 42, 35;
}

-	script	CastlePriestessInit#sch_gld	-1,{
OnInit:
	set .@tar$, "不思議な少女#" + strnpcinfo(2);
	set dupvar(.pri_nam$, .@tar$), "ニダヴェリールの巫女";
	set dupvar(.god_nam$, .@tar$), "オーディン";
	setarray dupvar(.req_mvps, .@tar$), 
		1650, 1719, 1630, 
		1751, 1685, 
		1648, 1511, 1190, 
		1832, 1734, 1623, 
		1651, 1708, 1768;
	setarray dupvar(.cas_maps$, .@tar$), 
		"schg_cas01", 
		"schg_cas02", 
		"schg_cas03", 
		"schg_cas04",
		"schg_cas05";
	set dupvar(.gui_dun$, .@tar$), "schg_dun01";
	setarray dupvar(.gui_dun_xy, .@tar$), 200, 129;
}

-	script	CastlePriestessInit#aru_gld	-1,{
OnInit:
	set .@tar$, "不思議な少女#" + strnpcinfo(2);
	set dupvar(.pri_nam$, .@tar$), "ヴァルフレイヤの巫女";
	set dupvar(.god_nam$, .@tar$), "フレイヤ";
	setarray dupvar(.req_mvps, .@tar$), 
		1649, 1685,
		1646, 1312, 1785,
		1874, 1373, 1039,
		1647, 1389, 1871,
		1779, 1885, 1719;
	setarray dupvar(.cas_maps$, .@tar$), 
		"arug_cas01",
		"arug_cas02",
		"arug_cas03",
		"arug_cas04",
		"arug_cas05";
	set dupvar(.gui_dun$, .@tar$), "arug_dun01";
	setarray dupvar(.gui_dun_xy, .@tar$), 200, 12;
}



//prt_gld,166,39,2	script	見張り番	105,{
//	if (isnight()) {
//		emotion ET_HUK;
//		mes "[兵士]";
//		mes "(ビクッ！)";
//		next;
//		mes "[兵士]";
//		mes "……";
//		next;
//		mes "[兵士]";
//		mes "なんだ……お化けかと思った。";
//		mes "びっくりさせないでくれよ。";
//		next;
//		mes "[兵士]";
//		mes "なあ、あんた。";
//		mes "ちょっとそこの広場を見てきて";
//		mes "くれないか？";
//		mes "さっきから妙な気配がするんだ……";
//		next;
//		mes "[兵士]";
//		mes "自分で行けって？";
//		mes "お 俺は自分の持ち場があるから……";
//		close;
//	} else {
//		mes "[兵士]";
//		mes "おい、あんた";
//		mes "例の噂は知ってるか？";
//		next;
//		if (select("知ってる", "知らない") == 1) {
//			mes "[兵士]";
//			mes "俺はこう見えてこの手の話が";
//			mes "大の苦手でね。";
//			next;
//			mes "[兵士]";
//			mes "夜一人でトイレに行けなく";
//			mes "なっちゃったよ……トホホ。";
//			close;
//		} else {
//			mes "[兵士]";
//			mes "出るらしいんだよ。";
//			mes "夜に……幽霊が……";
//			next;
//			mes "[兵士]";
//			mes "南の広場のあたりに女がポツンと";
//			mes "立ってるそうだ……";
//			next;
//			mes "[兵士]";
//			mes "声をかけても何も答えずにじっと";
//			mes "こっちを見てるだけ……";
//			next;
//			mes "[兵士]";
//			mes "そして朝になると姿が薄れてフッと";
//			mes "跡形もなく消えちまうらしい……";
//			next;
//			mes "[兵士]";
//			mes "まあ、俺もこの目で確かめたわけじゃ";
//			mes "ないんだけどさ……気味悪いだろ？";
//			next;
//			mes "[兵士]";
//			mes "あぁ……やだなぁ……";
//			close;
//		}
//	}
//}
