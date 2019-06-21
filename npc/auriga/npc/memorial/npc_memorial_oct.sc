//= Auriga Script ==============================================================
// Ragnarok Online Octpus Cave Script	by refis
//==============================================================================

//============================================================
// �_���W��������NPC
//------------------------------------------------------------
mal_dun01,151,235,5	script	�q�g�f	551,{
	if(getpartyleader(getcharid(1)) != strcharinfo(0)) {
		mes "[�q�g�f]";
		mes "���̐�͗�������֎~���B";
		mes "�ǂ����Ă��ʂ肽���Ƃ����̂��H";
		mes "�Ȃ�΁A�p�[�e�B�[���[�_�[��";
		mes "�A��ė���̂��I";
		close;
	}
	mes "[�q�g�f]";
	mes "���͊��X�������A�ɑ�������";
	mes "�Ď����Ă���q�g�f���B";
	mes "���̐�͗�������֎~�����I";
	while(1) {
		next;
		switch(select("�b�𕷂�","���A�ɓ��肽��","�����Ԃ�")) {
		case 1:
			mes "[�q�g�f]";
			mes "�Ȃ�ŗ�������֎~�����āH";
			mes "����͂ȁA�������q�g�f�̃A�C�h��";
			mes "�q�g�f���삳���f�v���悤�Ƃ���";
			mes "�s�͂��҂����A�ɐ���ł��邩�炾�I";
			next;
			mes "[�q�g�f]";
			mes "���킢�����Ɂc�c";
			mes "�q�g�f���삳���";
			mes "�Ђǂ����т��Ă���c�c�B";
			mes "�������Ȃ��B";
			mes "�^�R���ɃO���O�������ɂ����Ȃ��";
			mes "���|�ȊO�̂Ȃɂ��̂ł��Ȃ��I";
			next;
			mes "["+ strcharinfo(0) +"]";
			mes "�q�g�f���삳��͑��v�ł����H";
			next;
			mes "[�q�g�f]";
			mes "���ށA�ŋ߂͗��������Ă�����";
			mes "�����ɑ��̎푰�Ɖ���Ƃ�";
			mes "�|�����Ă���悤���B";
			next;
			mes "[�q�g�f]";
			mes "������A�L�~�����l�Ԃɂ�";
			mes "��킹��킯�ɂ͂����Ȃ��̂��I";
			next;
			mes "[�q�g�f]";
			mes "�������A�����I";
			mes "�������^�R!!";
			mes "�ԂԂƂ茾�𒝂�Ȃ���";
			mes "�q�g�f���삳��Ɏ���o���₪���āI";
			mes "�S�����邳�����c���B";
			next;
			mes "[�q�g�f]";
			mes "�������q�g�f�́A���c�𒦂炵�߂�";
			mes "������x�ƁA�q�g�f���삳���";
			mes "����o���Ȃ��Ɛ��킹��܂�";
			mes "���̓��A���瓦�����͂��Ȃ��̂��I";
			next;
			mes "[�q�g�f]";
			mes "�c�c�����A";
			mes "�����L�~���^�R�̃��c��";
			mes "���炵�߂Ă����Ƃ����̂Ȃ�";
			mes "���A�ɓ����Ă��������B";
			next;
			mes "[�q�g�f]";
			mes "�������A��l�ł̓_�����B";
			mes "�K��������";
			mes "�p�[�e�B�[��g��ł���񂾁B";
			mes "��l�ł͊댯������ȁB";
			next;
			mes "[�q�g�f]";
			mes "���Ȃ݂Ɏ������A�̓�������J����ɂ�";
			mes "�F�X�Ə������K�v���B";
			mes "^0000ff���ׁ̈A��������J���鎖��";
			mes "��P�T�ԂɈ�x�����ł��Ȃ��B^000000";
			mes "�������A�����������Ԃ��J�������A��";
			mes "���ꂷ�鎖�͉\�����B";
			break;
		case 2:
			if(checkquest2(71835)) {
				if(!(checkquest2(71835)&0x2)) {
					mes "[�q�g�f]";
					mes "������ʂ肽���̂��H";
					mes "�������A����^0000ff�\�A���̓��A^000000�̓�����";
					mes "�J���邱�Ƃ��ł��Ȃ��B";
					mes "�����҂��Ă���B";
					mes "�����A�N�����Ԃ��������J���Ă���Ȃ�";
					mes "���ɂ���ʘH����ʂ�邼�B";
					close;
				}
				delquest 71835;
			}
			mes "[�q�g�f]";
			mes "�������B���A�ɓ��肽���̂��B";
			mes "�������A�̓�������J����ɂ�";
			mes "�F�X�Ə������K�v���B";
			mes "^0000ff���ׁ̈A��������J���鎖��";
			mes "��P�T�ԂɈ�x�����ł��Ȃ��B^000000";
			next;
			mes "[�q�g�f]";
			mes "��x�J����Ɨ��p�̗L����";
			mes "�����̉ۂɊւ�炸�A��������邩��";
			mes "�C��t���Ă���B";
			mes "�ł́A��������J���Ă��ǂ����H";
			next;
			if(select("�͂�","������") == 2) {
				mes "[�q�g�f]";
				mes "�������B�ł͓s���̗ǂ�����";
				mes "�܂��A�b�������Ă���B";
				close;
			}
			mdcreate "Octopus Cave";
			setquest 71835;
			mes "[�q�g�f]";
			mes "�p�[�e�B�[����";
			mes strcharinfo(1)+ "��";
			mes "�p�[�e�B�[���[�_�[��";
			mes strcharinfo(0);
			mes "���ȁB";
			next;
			mes "[�q�g�f]";
			mes "�悵�A^0000ff�\�A���̓��A^000000�̓������J���邼�B";
			mes "���̉��ɂ���ʘH����";
			mes "���A�ɓ�����";
			mes "���ɐ��ރ^�R�̃��c��";
			mes "���炵�߂Ă���I";
			close;
		case 3:
			mes "[�q�g�f]";
			mes "�����v��Ȃ��ł���B";
			mes "���̐�͊댯�Ȃ̂��B";
			close;
		}
	}
	end;
}

//============================================================
// �_���W��������NPC
//------------------------------------------------------------
mal_dun01,153,237,5	script	�s�v�c�ȒʘH	844,{
	mes "�]�؂̔łӂ����ꂽ";
	mes "�@���A�ɂȂ��铹������B";
	mes "�@�̌��Ԃ��������";
	mes "�@��ɐi�߂������]";
	next;
	if(select("��ɐi��","�����Ԃ�") == 2) {
		mes "�]���Ȃ��́A�������ꂽ�ʘH��";
		mes "�@�w���������]";
		close;
	}
	switch(mdenter("Octopus Cave")) {
	case 0:	// �G���[�Ȃ�
		announce strcharinfo(1)+ " �p�[�e�B�[��" +strcharinfo(0)+ "���\�A���̓��A�ɓ��ꂵ���I",0x9,0x00ff99;
		end;
	default:	// ���̑��G���[
		mes "[�q�g�f]";
		mes "�ł�񂶂�Ȃ��B";
		mes "�p�[�e�B���[�_�[��";
		mes "�܂��葱�����I���Ă��Ȃ���";
		mes "����̏��������B";
		mes "���������܂񂾁B";
		close;
	}
}

//============================================================
// �\�A���̓��A
//------------------------------------------------------------
1@cash,199,99,0	script	oct_enter	139,4,4,{
	hideonnpc;
	donpcevent getmdnpcname("oct_foot_4")+"::OnStart";
	donpcevent getmdnpcname("oct_mob_con")+"::OnStart";
	initnpctimer;
	end;
OnTimer1000:
	announce "���̃^�R : �N���I�@�����m�炸���̓꒣��ɓ����ė���Ƃ́I",0x9,0x00ff99;
	end;
OnTimer4000:
	announce "���̃^�R : �����������铴�A�̓�����͕��Ă��邩��A��������Ă����ʂ��B",0x9,0x00ff99;
	end;
OnTimer7000:
	announce "���̃^�R : ���̎q�������̂�������ɂȂ�ȁA���n�n�n�n!!",0x9,0x00ff99;
	stopnpctimer;
	end;
}

1@cash,3,3,0		script	oct_foot_4	139,{
OnStart:
	hideonnpc getmdnpcname("oct_foot_exit1");
	hideonnpc getmdnpcname("oct_foot_exit2");
	hideonnpc getmdnpcname("oct_foot_exit3");
	hideonnpc getmdnpcname("oct_foot_exit4");
	hideonnpc getmdnpcname("oct_boss_warp");
	hideonnpc getmdnpcname("oct_exit2");
	donpcevent getmdnpcname("oct_foot1")+"::OnStart";
	donpcevent getmdnpcname("oct_foot2")+"::OnStart";
	donpcevent getmdnpcname("oct_foot3")+"::OnStart";
	donpcevent getmdnpcname("oct_foot4")+"::OnStart";

	set .@mdmap$,getmdmapname("1@cash");
	set .@event$,getmdnpcname("oct_foot_4")+"::OnKilled";
	monster .@mdmap$,20,114,"���̃^�R�̑�",2193,1,.@event$;
	monster .@mdmap$,88,190,"���̃^�R�̑�",2193,1,.@event$;
	monster .@mdmap$,307,215,"���̃^�R�̑�",2193,1,.@event$;
	monster .@mdmap$,372,131,"���̃^�R�̑�",2193,1,.@event$;
	end;
OnKilled:
	set .count,getmapmobs(getmdmapname("1@cash"),getmdnpcname("oct_foot_4")+"::OnKilled");
	if(.count > 0) {
		announce "���̃^�R : �ɂ���������!!�@���̂�`�I�@������!!�@���̎c��̑��ŕK�����Ƃ߂邼�I",0x9,0x00ff99;
		end;
	}
	initnpctimer;
	donpcevent getmdnpcname("oct_boss_con")+"::OnStart";
	announce "���̃^�R : ���̂ꂢ�A���̑��ɂ悭��!!�@���������ʂ�!!",0x9,0x00ff99;
	hideoffnpc getmdnpcname("oct_boss_warp");
	mapwarp getmdmapname("1@cash"),getmdmapname("1@cash"),197,107;
	end;
OnTimer210000:
	set .@mdmap$,getmdmapname("1@cash");
	if(getmapmobs(.@mdmap$,getmdnpcname("oct_foot_4")+"::OnKilled1") <= 0)
		monster .@mdmap$,20,114,"���̃^�R�̑�",2193,1,getmdnpcname("oct_foot_4")+"::OnKilled1";
	if(getmapmobs(.@mdmap$,getmdnpcname("oct_foot_4")+"::OnKilled2") <= 0)
		monster .@mdmap$,88,190,"���̃^�R�̑�",2193,1,getmdnpcname("oct_foot_4")+"::OnKilled2";
	if(getmapmobs(.@mdmap$,getmdnpcname("oct_foot_4")+"::OnKilled3") <= 0)
		monster .@mdmap$,307,215,"���̃^�R�̑�",2193,1,getmdnpcname("oct_foot_4")+"::OnKilled3";
	if(getmapmobs(.@mdmap$,getmdnpcname("oct_foot_4")+"::OnKilled4") <= 0)
		monster .@mdmap$,372,131,"���̃^�R�̑�",2193,1,getmdnpcname("oct_foot_4")+"::OnKilled4";
	initnpctimer;
	end;
OnKilled1:
OnKilled2:
OnKilled3:
OnKilled4:
	end;
}

1@cash,20,114,0		script	oct_foot1	139,6,6,{
OnStart:
	set .@mdmap$,getmdmapname("1@cash");
	set .@event$,getmdnpcname("oct_mob_con")+"::OnKilled1";
	areamonster .@mdmap$,31,93,41,103,"�q���^�R",2192,3,.@event$;
	areamonster .@mdmap$,38,89,42,93,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,36,74,42,80,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,38,57,42,61,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,47,35,59,47,"�q���^�R",2192,5,.@event$;
	areamonster .@mdmap$,65,29,75,39,"�q���^�R",2192,5,.@event$;
	areamonster .@mdmap$,82,25,86,29,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,106,27,110,31,"�q���^�R",2192,1,.@event$;
	areamonster .@mdmap$,122,27,126,31,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,131,28,141,38,"�q���^�R",2192,5,.@event$;
	areamonster .@mdmap$,139,36,149,46,"�q���^�R",2192,2,.@event$;
	end;
OnTouch:
	hideonnpc getmdnpcname("oct_foot1");
	announce "���̃^�R : �q��������A����Ă��܂�!!",0x9,"0xffff00";
	initnpctimer;
	end;
OnTimer5000:
	set .@mdmap$,getmdmapname("1@cash");
	set .@event$,getmdnpcname("oct_mob_con")+"::OnKilled1";
	announce "���̃^�R : ���̐��ӋC�ȓz��𒦂炵�߂Ă��B",0x9,"0xffff00";
	areamonster .@mdmap$,15,109,25,119,"�q���^�R",2192,3,.@event$;
	areamonster .@mdmap$,15,109,25,119,"�q���^�R",2192,3,.@event$;
	end;
OnTimer30000:
	stopnpctimer;
	//hideoffnpc getmdnpcname("oct_foot_exit1");
	end;
}

1@cash,16,117,0		warp	oct_foot_exit1	2,2,1@cash,198,99

1@cash,88,190,0	script	oct_foot2	139,6,6,{
OnStart:
	set .@mdmap$,getmdmapname("1@cash");
	set .@event$,getmdnpcname("oct_mob_con")+"::OnKilled2";
	areamonster .@mdmap$,136,110,146,120,"�q���^�R",2192,5,.@event$;
	areamonster .@mdmap$,133,102,139,108,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,120,90,130,100,"�q���^�R",2192,3,.@event$;
	areamonster .@mdmap$,112,89,116,93,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,102,88,106,92,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,88,89,92,93,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,72,102,78,108,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,72,118,78,124,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,81,129,89,137,"�q���^�R",2192,3,.@event$;
	areamonster .@mdmap$,90,140,96,146,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,96,157,102,163,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,91,177,101,187,"�q���^�R",2192,5,.@event$;
	end;
OnTouch:
	hideonnpc getmdnpcname("oct_foot2");
	announce "���̃^�R : �q��������A����Ă��܂�!!",0x9,"0xffff00";
	initnpctimer;
	end;
OnTimer5000:
	set .@mdmap$,getmdmapname("1@cash");
	set .@event$,getmdnpcname("oct_mob_con")+"::OnKilled2";
	announce "���̃^�R : ���̐��ӋC�ȓz��𒦂炵�߂Ă��B",0x9,"0xffff00";
	areamonster .@mdmap$,83,185,93,195,"�q���^�R",2192,3,.@event$;
	areamonster .@mdmap$,83,185,93,195,"�q���^�R",2192,3,.@event$;
	end;
OnTimer30000:
	stopnpctimer;
	//hideoffnpc getmdnpcname("oct_foot_exit2");
	end;
}

1@cash,77,193,0		warp	oct_foot_exit2	2,2,1@cash,198,99

1@cash,307,215,0	script	oct_foot3	139,6,6,{
OnStart:
	set .@mdmap$,getmdmapname("1@cash");
	set .@event$,getmdnpcname("oct_mob_con")+"::OnKilled3";
	areamonster .@mdmap$,297,207,305,215,"�q���^�R",2192,3,.@event$;
	areamonster .@mdmap$,289,200,299,210,"�q���^�R",2192,3,.@event$;
	areamonster .@mdmap$,289,184,295,190,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,290,164,296,170,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,291,149,297,155,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,297,135,305,143,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,298,121,306,129,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,298,102,306,110,"�q���^�R",2192,3,.@event$;
	areamonster .@mdmap$,278,100,282,104,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,259,102,261,104,"�q���^�R",2192,1,.@event$;
	end;
OnTouch:
	hideonnpc getmdnpcname("oct_foot3");
	announce "���̃^�R : �q��������A����Ă��܂�!!",0x9,"0xffff00";
	initnpctimer;
	end;
OnTimer5000:
	set .@mdmap$,getmdmapname("1@cash");
	set .@event$,getmdnpcname("oct_mob_con")+"::OnKilled3";
	announce "���̃^�R : ���̐��ӋC�ȓz��𒦂炵�߂Ă��B",0x9,"0xffff00";
	areamonster .@mdmap$,302,210,312,220,"�q���^�R",2192,3,.@event$;
	areamonster .@mdmap$,302,210,312,220,"�q���^�R",2192,3,.@event$;
	end;
OnTimer30000:
	stopnpctimer;
	//hideoffnpc getmdnpcname("oct_foot_exit3");
	end;
}

1@cash,312,214,0	warp	oct_foot_exit3	2,2,1@cash,198,99

1@cash,372,131,0	script	oct_foot4	139,6,6,{
OnStart:
	set .@mdmap$,getmdmapname("1@cash");
	set .@event$,getmdnpcname("oct_mob_con")+"::OnKilled4";
	areamonster .@mdmap$,361,121,369,129,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,361,105,371,115,"�q���^�R",2192,5,.@event$;
	areamonster .@mdmap$,361,91,369,99,"�q���^�R",2192,3,.@event$;
	areamonster .@mdmap$,362,70,368,76,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,362,59,368,62,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,353,42,361,50,"�q���^�R",2192,3,.@event$;
	areamonster .@mdmap$,344,34,352,42,"�q���^�R",2192,3,.@event$;
	areamonster .@mdmap$,316,25,328,37,"�q���^�R",2192,5,.@event$;
	areamonster .@mdmap$,304,26,308,30,"�q���^�R",2192,2,.@event$;
	areamonster .@mdmap$,274,27,282,35,"�q���^�R",2192,5,.@event$;
	areamonster .@mdmap$,255,34,265,44,"�q���^�R",2192,2,.@event$;
	end;
OnTouch:
	hideonnpc getmdnpcname("oct_foot4");
	announce "���̃^�R : �q��������A����Ă��܂�!!",0x9,"0xffff00";
	initnpctimer;
	end;
OnTimer5000:
	set .@mdmap$,getmdmapname("1@cash");
	set .@event$,getmdnpcname("oct_mob_con")+"::OnKilled4";
	announce "���̃^�R : ���̐��ӋC�ȓz��𒦂炵�߂Ă��B",0x9,"0xffff00";
	areamonster .@mdmap$,367,126,377,136,"�q���^�R",2192,3,.@event$;
	areamonster .@mdmap$,367,126,377,136,"�q���^�R",2192,3,.@event$;
	end;
OnTimer30000:
	stopnpctimer;
	//hideoffnpc getmdnpcname("oct_foot_exit4");
	end;
}

1@cash,370,139,0	warp	oct_foot_exit4	2,2,1@cash,198,99

1@cash,15,15,0	script	oct_mob_con	139,{
OnStart:
	set .@mdmap$,getmdmapname("1@cash");

	monster .@mdmap$,32,94,"�q�h��",1068,1;
	monster .@mdmap$,41,101,"�q�h��",1068,1;
	monster .@mdmap$,35,78,"�q�h��",1068,1;
	monster .@mdmap$,35,62,"�q�h��",1068,1;
	monster .@mdmap$,49,54,"�q�h��",1068,1;
	monster .@mdmap$,70,28,"�q�h��",1068,1;
	monster .@mdmap$,83,22,"�q�h��",1068,1;
	monster .@mdmap$,99,23,"�q�h��",1068,1;
	monster .@mdmap$,115,23,"�q�h��",1068,1;
	monster .@mdmap$,132,25,"�q�h��",1068,1;

	monster .@mdmap$,100,185,"�q�h��",1068,1;
	monster .@mdmap$,92,178,"�q�h��",1068,1;
	monster .@mdmap$,92,162,"�q�h��",1068,1;
	monster .@mdmap$,70,121,"�q�h��",1068,1;
	monster .@mdmap$,70,105,"�q�h��",1068,1;
	monster .@mdmap$,105,85,"�q�h��",1068,1;
	monster .@mdmap$,121,84,"�q�h��",1068,1;

	monster .@mdmap$,292,209,"�q�h��",1068,1;
	monster .@mdmap$,303,206,"�q�h��",1068,1;
	monster .@mdmap$,290,163,"�q�h��",1068,1;
	monster .@mdmap$,299,150,"�q�h��",1068,1;
	monster .@mdmap$,308,141,"�q�h��",1068,1;
	monster .@mdmap$,308,125,"�q�h��",1068,1;
	monster .@mdmap$,295,97,"�q�h��",1068,1;
	monster .@mdmap$,279,97,"�q�h��",1068,1;

	monster .@mdmap$,370,111,"�q�h��",1068,1;
	monster .@mdmap$,370,110,"�q�h��",1068,1;
	monster .@mdmap$,371,96,"�q�h��",1068,1;
	monster .@mdmap$,371,80,"�q�h��",1068,1;
	monster .@mdmap$,367,55,"�q�h��",1068,1;
	monster .@mdmap$,343,29,"�q�h��",1068,1;
	monster .@mdmap$,327,24,"�q�h��",1068,1;
	monster .@mdmap$,311,22,"�q�h��",1068,1;
	monster .@mdmap$,295,22,"�q�h��",1068,1;
	monster .@mdmap$,279,22,"�q�h��",1068,1;

	areamonster .@mdmap$,20,57,60,97,"�X�^�|",1784,1;
	areamonster .@mdmap$,92,9,132,49,"�X�^�|",1784,1;
	areamonster .@mdmap$,79,128,119,168,"�X�^�|",1784,1;
	areamonster .@mdmap$,102,73,142,113,"�X�^�|",1784,1;
	areamonster .@mdmap$,273,158,313,198,"�X�^�|",1784,1;
	areamonster .@mdmap$,282,87,322,127,"�X�^�|",1784,1;
	areamonster .@mdmap$,345,54,385,94,"�X�^�|",1784,1;
	areamonster .@mdmap$,307,7,347,47,"�X�^�|",1784,1;
	end;
OnKilled1:
	set .count,getmapmobs(getmdmapname("1@cash"),getmdnpcname("oct_mob_con")+ "::OnKilled1");
	if(.count <= 0) {
		announce "�q���^�R : �ƁA���̂��݂܂���I����܂����I",0x9,0x00ff99;
		stopnpctimer;
		hideoffnpc getmdnpcname("oct_foot_exit1");
		hideonnpc getmdnpcname("oct_foot1");
	}
	end;
OnKilled2:
	set .count,getmapmobs(getmdmapname("1@cash"),getmdnpcname("oct_mob_con")+ "::OnKilled2");
	if(.count <= 0) {
		announce "�q���^�R : �ƁA���̂��݂܂���I����܂����I",0x9,0x00ff99;
		stopnpctimer;
		hideoffnpc getmdnpcname("oct_foot_exit2");
		hideonnpc getmdnpcname("oct_foot2");
	}
	end;
OnKilled3:
	set .count,getmapmobs(getmdmapname("1@cash"),getmdnpcname("oct_mob_con")+ "::OnKilled3");
	if(.count <= 0) {
		announce "�q���^�R : �ƁA���̂��݂܂���I����܂����I",0x9,0x00ff99;
		stopnpctimer;
		hideoffnpc getmdnpcname("oct_foot_exit3");
		hideonnpc getmdnpcname("oct_foot3");
	}
	end;
OnKilled4:
	set .count,getmapmobs(getmdmapname("1@cash"),getmdnpcname("oct_mob_con")+ "::OnKilled4");
	if(.count <= 0) {
		announce "�q���^�R : �ƁA���̂��݂܂���I����܂����I",0x9,0x00ff99;
		stopnpctimer;
		hideoffnpc getmdnpcname("oct_foot_exit4");
		hideonnpc getmdnpcname("oct_foot4");
	}
	end;
}

1@cash,45,53,0	script	oct_backattack1	139,3,3,{
	set .@mdmap$,getmdmapname("1@cash");
	monster .@mdmap$,39,59,"�q�h��",1068,1;
	monster .@mdmap$,40,59,"�q�h��",1068,1;
	monster .@mdmap$,41,59,"�q�h��",1068,1;
	monster .@mdmap$,47,50,"�q�h��",1068,1;
	monster .@mdmap$,48,50,"�q�h��",1068,1;
	monster .@mdmap$,49,50,"�q�h��",1068,1;
	monster .@mdmap$,41,53,"�q���^�R",2192,1;
	announce "�q���^�R : �˔j�����ĂȂ���̂��I",0x9,0x00ff99;
	hideonnpc;
	end;
}

1@cash,78,99,0	script	oct_backattack2	139,3,3,{
	initnpctimer;
	monster getmdmapname("1@cash"),71,105,"�q���^�R",2192,1;
	announce "�q���^�R : ������I�@������I",0x9,0x00ff99;
	hideonnpc;
	end;
OnTimer2000:
	monster getmdmapname("1@cash"),71,105,"�q���^�R",2192,1;
	announce "�q���^�R : �s���I�@�̐��𐮂�����O�ɒ@���I",0x9,0x00ff99;
	end;
OnTimer4000:
	monster getmdmapname("1@cash"),71,105,"�q���^�R",2192,1;
	announce "�q���^�R : ���Ԃ��Ȃ��B�}���ł������I",0x9,0x00ff99;
	end;
OnTimer6000:
	monster getmdmapname("1@cash"),71,105,"�q���^�R",2192,3;
	announce "�q���^�R : �S���ōU�����邼�I",0x9,0x00ff99;
	end;
OnTimer8000:
	monster getmdmapname("1@cash"),71,105,"�q���^�R",2192,1;
	announce "�q���^�R : �����[�I�x���ȁI",0x9,0x00ff99;
	stopnpctimer;
	end;
}

1@cash,299,144,0	script	oct_backattack3	139,3,3,{
	set .@mdmap$,getmdmapname("1@cash");
	monster .@mdmap$,293,153,"�q���^�R",2192,1;
	monster .@mdmap$,294,152,"�q���^�R",2192,1;
	monster .@mdmap$,292,153,"�q���^�R",2192,1;
	monster .@mdmap$,293,151,"�q���^�R",2192,1;
	monster .@mdmap$,293,152,"�q���^�R?",2175,1;
	announce "�q���^�R : �������A���������낤�I",0x9,0x00ff99;
	hideonnpc;
	end;
}

1@cash,336,36,0	script	oct_backattack4	139,3,3,{
	set .@mdmap$,getmdmapname("1@cash");
	monster .@mdmap$,332,37,"�q���^�R",2192,1;
	monster .@mdmap$,332,36,"�q���^�R",2192,1;
	monster .@mdmap$,332,35,"�q���^�R",2192,1;
	monster .@mdmap$,332,34,"�q���^�R",2192,1;
	monster .@mdmap$,341,37,"�q���^�R",2192,1;
	monster .@mdmap$,341,36,"�q���^�R",2192,1;
	monster .@mdmap$,341,35,"�q���^�R",2192,1;
	monster .@mdmap$,341,34,"�q���^�R",2192,1;

	monster .@mdmap$,260,40,"�p�S�_�C�J",2175,1;
	monster .@mdmap$,260,41,"�p�S�_�C�J",2175,1;
	monster .@mdmap$,260,39,"�p�S�_�C�J",2175,1;
	monster .@mdmap$,259,40,"�p�S�_�C�J",2175,1;
	monster .@mdmap$,261,40,"�p�S�_�C�J",2175,1;
	announce "�q���^�R : ���ނ��p�S�_�I�@��Ăɂ������[�I",0x9,0x00ff99;
	initnpctimer;
	hideonnpc;
	end;
OnTimer5000:
	announce "�p�S�_�C�J : �����͒ʂ���I",0x9,0x00ff99;
	stopnpctimer;
	end;
}

1@cash,2,2,0	script	oct_boss_con	139,{
OnStart:
	donpcevent getmdnpcname("oct_boss_foot")+"::OnStart";
	monster getmdmapname("1@cash"),196,188,"���̃^�R",2194,1,getmdnpcname("oct_boss_con")+ "::OnKilled";
	initnpctimer;
	end;
OnTimer7000:
	switch(rand(3)) {
	case 0: announce "���̃^�R : ���ɒ��񂾎�����������Ă�낤�I",0x9,0xffff00; break;
	case 1: announce "���̃^�R : ���̑��͉��x�ł��h�邼!!",0x9,0x00ff99; break;
	case 2: announce "���̃^�R : �������������A���̃^�R�̖{�C�����Ă��!!",0x9,0xffff00; break;
	}
	end;
OnTimer14000:
	switch(rand(3)) {
	case 0: announce "���̃^�R : ���O����q�g�f���삳�񂪍D���Ȃ񂾂낤�H",0x9,0xffff00; break;
	case 1: announce "���̃^�R : �}�������ɏZ�ݒ������L�̘b�ł�����c�c����!������Ȃ�I",0x9,0xffff00; break;
	case 2: announce "���̃^�R : ���O����߂�����ɂ́A�ɂ��ڂ����Ă��炤�����Ȃ��悤���ȁB",0x9,0xffff00; break;
	}
	end;
OnTimer21000:
	switch(rand(3)) {
	case 0: announce "���̃^�R : ���^���Ԃɂ��Ă�񂶂�Ȃ��B������Ԃ��񂾁I",0x9,0xffff00; break;
	case 1: announce "���̃^�R : �q�g�f���삳��̃v���|�[�V�����͔���������B�܂��ɃX�^�[����B",0x9,0xffff00; break;
	case 2: announce "���̃^�R : ���Ƃ������œ|�ꂽ�Ƃ��Ă��A�K���܂��߂��Ă��邼�I",0x9,0xffff00; break;
	}
	end;
OnTimer28000:
	switch(rand(3)) {
	case 0: announce "���̃^�R : ���O�ɂ�������l�����邾�낤�H",0x9,0xffff00; break;
	case 1: announce "���̃^�R : ��������ȃ^�R���ƁH�@�^�R���������Ⴂ���Ȃ����Ă����̂��B",0x9,0xffff00; break;
	case 2: announce "���̃^�R : ���ʂʁc�c��߂남�O��I ���炩���Ƃ��������͉̂������I",0x9,0xffff00; break;
	}
	end;
OnTimer35000:
	switch(rand(3)) {
	case 0: announce "���̃^�R : �t�@�C�i���I�N�g�p�X�C�����[�W�����t�F�C���g!! ���ʂ͓��ɖ����B",0x9,0xffff00; break;
	case 1: announce "���̃^�R : �����c�c�����͒��q�������B�����������q�������c�c��������Ȏ��Ȃ��̂ɁB",0x9,0xffff00; break;
	case 2: announce "���̃^�R : �q�g�f���삳��A���ĂĂ��������B������ȂɊ撣���Ă܂�!!",0x9,0xffff00; break;
	}
	end;
OnTimer42000:
	switch(rand(3)) {
	case 0: announce "���̃^�R : �^�R�̑���8�{�����Ȃ��Ǝv���Ȃ�B���̑��͖������I",0x9,0xffff00; break;
	case 1: announce "���̃^�R : ���������A���������A�܂���Âɘb���������B",0x9,0xffff00; break;
	case 2: announce "���̃^�R : ���̑���|�������炢�Œ��q�ɏ��Ȃ�I",0x9,0xffff00; break;
	}
	end;
OnTimer49000:
	switch(rand(3)) {
	case 0: announce "���̃^�R : �������͂��o�Ȃ��B���ꂩ�A�n�`������I",0x9,0xffff00; break;
	case 1: announce "���̃^�R : �q�g�f���삳����D���Ȃ��ĂȂɂ������񂾁I",0x9,0xffff00; break;
	case 2: announce "���̃^�R : �q�g�f���삳��͉��̕����I",0x9,0xffff00; break;
	}
	initnpctimer;
	end;
OnKilled:
	announce "���̃^�R : ���������߂��c�I�@�����͂����܂łɂ��Ă��B���͊o���Ă���!!",0x9,0x00ff99;
	hideoffnpc getmdnpcname("oct_exit2");
	stopnpctimer getmdnpcname("oct_boss_foot");
	stopnpctimer;
	hideonnpc;
	end;
}

1@cash,4,4,0	script	oct_boss_foot	139,{
OnStart:
	initnpctimer;
	end;
OnTimer5000:
	announce "���̃^�R : �������镔���ւ̓�����������Ă������B",0x9,0x00ff99;
	end;
OnTimer10000:
	announce "���̃^�R : �悵�B���O�������o�ė��Đ킦�I",0x9,0xffff00;
	areamonster getmdmapname("1@cash"),184,173,214,203,"�q���^�R",2192,5;
	stopnpctimer;
	end;
}

1@cash,198,82,0	script	oct_exit	45,2,2,{
	mes "�|�\�A���̓��A�̊O�ɏo�܂����H�|";
	next;
	if(select("�O�ɏo�Ȃ�","�O�ɏo��") == 1) {
		close;
	}
	mes "�]�O�ɏo�܂����]";
	close2;
	warp "mal_dun01",153,233;
	end;
}

1@cash,190,208,0	duplicate(oct_exit)	oct_exit2	45,1,1

1@cash,193,84,0		warp	oct_door1	2,2,1@cash,151,48
1@cash,154,53,0		warp	oct_door2	2,2,1@cash,197,87
1@cash,187,99,0		warp	oct_door3	2,2,1@cash,148,128
1@cash,153,133,0	warp	oct_door4	2,2,1@cash,197,99
1@cash,209,100,0	warp	oct_door5	2,2,1@cash,250,111
1@cash,244,118,0	warp	oct_door6	2,2,1@cash,199,100
1@cash,209,83,0		warp	oct_door7	2,2,1@cash,252,46
1@cash,246,53,0		warp	oct_door8	2,2,1@cash,203,83
1@cash,198,116,0	warp	oct_boss_warp	2,2,1@cash,210,172
1@cash,206,168,0	warp	oct_boss_exit	2,2,1@cash,197,107