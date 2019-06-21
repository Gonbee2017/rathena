//= Auriga Script ==============================================================
// Ragnarok Online GvG Script - Britoniah Guild 4	by Blaze
//==============================================================================

//============================================================
// GvG���C������
//------------------------------------------------------------
gefg_cas04,0,0,0	script	#AgitExe_B4	-1,{
OnAgitStart:
	callfunc "AgitEmperium",174,177,1;
	end;
OnAgitBreak:
	callfunc "AgitBreak","B4";
	end;
OnAgitEliminate:
	callfunc "AgitEmperium",174,177,0;
	end;
OnAgitEnd:
	callfunc "AgitEnd";
	end;
OnGuildBreak:
	callfunc "AgitGiveUp","B4";
	end;
OnAgitSummon:
	areamonster "gefg_cas04",0,0,0,0,"--ja--",1117,10;
	areamonster "gefg_cas04",0,0,0,0,"--ja--",1263,11;
	areamonster "gefg_cas04",0,0,0,0,"--ja--",1102,10;
	areamonster "gefg_cas04",0,0,0,0,"--ja--",1130,10;
	areamonster "gefg_cas04",0,0,0,0,"--ja--",1140,20;
	areamonster "gefg_cas04",0,0,0,0,"--ja--",1163,9;
	areamonster "gefg_cas04",0,0,0,0,"--ja--",1275,1;
	areamonster "gefg_cas04",0,0,0,0,"--ja--",1219,1;
	areamonster "gefg_cas04",0,0,0,0,"--ja--",1150,1;
	areamonster "gefg_cas04",0,0,0,0,"--ja--",1159,1;
	monster "gefg_cas04",174,177,"--ja--",1203,1;
	monster "gefg_cas04",174,177,"--ja--",1087,1;
	monster "gefg_cas04",174,177,"--ja--",1213,10;
	monster "gefg_cas04",174,177,"--ja--",1189,10;
	end;
}

//============================================================
// ��
//------------------------------------------------------------
gefg_cas04,0,0,0	script	#AgitTreasure_B4	-1,{
OnClock0000:
	if(.treasure_id[0] == 0) {
		setarray .treasure_id,1340,1341;
		setarray .treasure_x,115,116,116,115,113,114,115,116,117,118,118,118,118,118,118,117,116,115,114,113,113,113,113,113;
		setarray .treasure_y,119,119,118,118,121,121,121,121,121,121,120,119,118,117,116,116,116,116,116,116,117,118,119,120;
	}
	callfunc "AgitTreasure",.treasure_id,.treasure_x,.treasure_y;
	end;
OnKilled:
	// dummy event
	end;
}

//============================================================
// �M���h�t���b�O
//------------------------------------------------------------
-	script	#GldFlag_B4a	{
	callfunc "AgitEmblemFlag",0,"gefg_cas04",168,43;
	close;
OnAgitInit:
OnFlagEmb_B4:
	flagemblem getcastledata("gefg_cas04",1);
	end;
}
gef_fild07,330,171,2	duplicate(#GldFlag_B4a)	�M���h�t���b�O#B4a01	722
gef_fild13,190,283,3	duplicate(#GldFlag_B4a)	�M���h�t���b�O#B4a02	722
gef_fild13,199,274,3	duplicate(#GldFlag_B4a)	�M���h�t���b�O#B4a03	722

-	script	#GldFlag_B4b	{
	end;
OnAgitInit:
OnFlagEmb_B4:
	flagemblem getcastledata("gefg_cas04",1);
	end;
}
//geffen,127,130,7		duplicate(#GldFlag_B4b)	�M���h�t���b�O#B4b01	722
//gefg_cas04,24,157,4	duplicate(#GldFlag_B4b)	�M���h�t���b�O#B4b02	722
//gefg_cas04,35,158,4	duplicate(#GldFlag_B4b)	�M���h�t���b�O#B4b03	722
//gefg_cas04,44,184,4	duplicate(#GldFlag_B4b)	�M���h�t���b�O#B4b04	722
//gefg_cas04,51,184,4	duplicate(#GldFlag_B4b)	�M���h�t���b�O#B4b05	722
//gefg_cas04,39,212,7	duplicate(#GldFlag_B4b)	�M���h�t���b�O#B4b06	722
//gefg_cas04,29,212,1	duplicate(#GldFlag_B4b)	�M���h�t���b�O#B4b07	722
//gefg_cas04,24,73,1	duplicate(#GldFlag_B4b)	�M���h�t���b�O#B4b08	722
//gefg_cas04,35,73,4	duplicate(#GldFlag_B4b)	�M���h�t���b�O#B4b09	722

//============================================================
// �J�v���E��
//------------------------------------------------------------
gefg_cas04,59,70,3	script	�J�v���E��::AgitKafra_B4	117,{
	callfunc "AgitKafra",15;
	close;
OnAgitInit:
	if(getcastledata("gefg_cas04",9) == 0)
		hideonnpc;
	end;
}

//============================================================
// ����
//------------------------------------------------------------
gefg_cas04,73,46,3	script	�P���o�[��	55,{
	callfunc "AgitSteward","B4",.guardian_id,.guardian_x,.guardian_y,116,123;
	close;
OnAgitInit:
	setarray .guardian_id,	1285,	1285,	1287,	1287,	1287,	1286,	1286,	1286;
	setarray .guardian_x,	53,	31,	49,	29,	147,	57,	160,	148;
	setarray .guardian_y,	191,	178,	220,	46,	65,	46,	50,	189;
	for(set .@i,0; .@i < 8; set .@i,.@i+1) {
		if(getcastledata("gefg_cas04",.@i+10))
			callguardian "gefg_cas04",.guardian_x[.@i],.guardian_y[.@i],"--ja--",.guardian_id[.@i],1,"",.@i+1;
	}
	end;
}

//============================================================
// �}�X�^�[���[���̃X�C�b�`
//------------------------------------------------------------
gefg_cas04,116,123,0	script	#AgitMaster_B4	111,{
	callfunc "AgitMaster",73,47;
	close;
}

//============================================================
// �M���h�_���W�����ւ̃X�C�b�`
//------------------------------------------------------------
gefg_cas04,58,75,0	script	#AgitDungeon_B4	111,{
	callfunc "AgitDungeon","gld_dun04",268,108;
	close;
}

//============================================================
// �}�X�^�[���[������
//------------------------------------------------------------
gefg_cas04,116,119,0	script	#AgitBanWarp_B4	139,6,6,{
	callfunc "AgitBanWarp","geffen",120,38;
	close;
}