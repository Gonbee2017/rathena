function	script	MVPRanking	{
	mes "-偉大な^4040FF" + getarg(0) + "^000000たちの";
	mes "　栄誉をここに讃える。-";
	next;
	set .@ran_siz, 
		querymvpranking(
			getarg(1), 
			10, 
			.@ran_nams$, 
			.@ran_jobs, 
			.@ran_rous, 
			.@ran_mobss
		);
	mes "------ " + strnpcinfo(1) + " ------";
	for (set .@i, 0; .@i < getarg(2); ++.@i) {
		if (.@i < .@ran_siz) {
			set .@ran_nam$, .@ran_nams$[.@i];
			set .@ran_rou, .@ran_rous[.@i];
			set .@ran_mobs, .@ran_mobss[.@i];
		} else {
			set .@ran_nam$, "------";
			set .@ran_rou, 0;
			set .@ran_mobs, 0;
		}
		mes sprintf("#%02d ", .@i + 1) + 
			sprintf("%02d.", .@ran_rou + 1) + 
			sprintf("%02d ", .@ran_mobs) + 
			"^4040FF" + .@ran_nam$ + "^000000";
	}
	close;
}

prontera,216,82,0	script	ナイト#MVPRanking_Kight	111,{
	setarray .@jobs, JOB_KNIGHT, JOB_LORD_KNIGHT;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,216,72,0	script	ウィザード#MVPRanking_Wizard	111,{
	setarray .@jobs, JOB_WIZARD, JOB_HIGH_WIZARD;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,216,60,0	script	ハンター#MVPRanking_Hunter	111,{
	setarray .@jobs, JOB_HUNTER, JOB_SNIPER;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,216,48,0	script	ブラックスミス#MVPRanking_Smith	111,{
	setarray .@jobs, JOB_BLACKSMITH, JOB_WHITESMITH;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,224,82,0	script	アサシン#MVPRanking_Assassin	111,{
	setarray .@jobs, JOB_ASSASSIN, JOB_ASSASSIN_CROSS;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,224,72,0	script	プリースト#MVPRanking_Priest	111,{
	setarray .@jobs, JOB_PRIEST, JOB_HIGH_PRIEST;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,224,60,0	script	クルセイダー#MVPRanking_Crusader	111,{
	setarray .@jobs, JOB_CRUSADER, JOB_PALADIN;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,224,48,0	script	セージ#MVPRanking_Sage	111,{
	setarray .@jobs, JOB_SAGE, JOB_PROFESSOR;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,252,82,0	script	バード・ダンサー#MVPRanking_BardDancer	111,{
	setarray .@jobs, JOB_BARD, JOB_DANCER, JOB_CLOWN, JOB_GYPSY;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,252,72,0	script	アルケミスト#MVPRanking_Alchemist	111,{
	setarray .@jobs, JOB_ALCHEMIST, JOB_CREATOR;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,252,60,0	script	ローグ#MVPRanking_Rogue	111,{
	setarray .@jobs, JOB_ROGUE, JOB_STALKER;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,252,48,0	script	モンク#MVPRanking_Monk	111,{
	setarray .@jobs, JOB_MONK, JOB_CHAMPION;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,260,82,0	script	拳聖#MVPRanking_StarGladiator	111,{
	setarray .@jobs, JOB_STAR_GLADIATOR;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,260,72,0	script	ソウルリンカー#MVPRanking_SoulLinker	111,{
	setarray .@jobs, JOB_SOUL_LINKER;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,260,60,0	script	特殊一次職#MVPRanking_Rogue	111,{
	setarray .@jobs, JOB_SUPER_NOVICE, JOB_NINJA, JOB_GUNSLINGER, JOB_TAEKWON;
	callfunc "MVPRanking", strnpcinfo(1), .@jobs, 5;
}

prontera,260,48,0	script	総合#MVPRanking_Monk	111,{
	setarray .@jobs, -1;
	callfunc "MVPRanking", "勇者", .@jobs, 10;
}
