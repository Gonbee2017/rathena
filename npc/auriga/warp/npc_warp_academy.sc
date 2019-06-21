//============================================================
// Auriga Script
//------------------------------------------------------------
// Ragnarok Online -- �`���҃A�J�f�~�[          by Pneuma
//
// -----------------------------------------------------------

//============================================================
// WARP

// 2010/05/04�ȍ~�A���Ə���̂݊m�F���b�Z�[�W���o��WP�ɂ��Ă�
// �R�����g�A�E�g���A�ʓr�����ɃX�N���v�g�Ƃ��Ēǉ����܂����B

// ------------------------------------------------------------------------------
//�G���g�����X�̋������z�[��
//ac_en_hall,54,13,0		warp	acwarp003	1,1,ac_cl_hall,167,22
//ac_cl_hall,167,19,0		warp	acwarp004	1,1,ac_en_hall,57,13

// ------------------------------------------------------------------------------
//�G���g�����X�̐}����
//ac_en_hall,143,13,0		warp	acwarp005	1,1,ac_library,32,58
ac_library,29,58,0		warp	acwarp006	1,1,ac_en_hall,140,13

// ------------------------------------------------------------------------------
//�������z�[���̋�����1F
//ac_cl_hall,167,72,0		warp	acwarp018	1,1,ac_cl_area,73,156
//ac_cl_area,76,156,0		warp	acwarp019	1,1,ac_cl_hall,167,69

// ------------------------------------------------------------------------------
//��t�̋�����1F
//ac_cl_area,35,133,0		warp	acwarp020	2,2,ac_cl_room,43,19

// ------------------------------------------------------------------------------
//������1F�̎��K��
//ac_cl_area,35,176,0		warp	acwarp021	2,2,ac_cl_room,152,21
//ac_cl_room,152,18,0		warp	acwarp022	1,1,ac_cl_area,38,176

// ------------------------------------------------------------------------------
//������1F�̋�����2F
//ac_cl_area,30,185,0		warp	acwarp023	2,2,ac_cl_area,67,74
//ac_cl_area,71,74,0		warp	acwarp024	1,1,ac_cl_area,36,185
//ac_cl_area,30,125,0		warp	acwarp025	2,2,ac_cl_area,67,14
//ac_cl_area,71,14,0		warp	acwarp026	1,1,ac_cl_area,36,125

// ------------------------------------------------------------------------------
//�}���ٓ�����̐}���ْ���
ac_library,52,58,0		warp	acwarp006	1,1,ac_library,98,58
ac_library,95,58,0		warp	acwarp007	1,1,ac_library,49,58

// ------------------------------------------------------------------------------
//�}���ْ����̐}���ٓ���̕���
ac_library,103,64,0		warp	acwarp008	1,1,ac_library,103,96
ac_library,103,93,0		warp	acwarp009	1,1,ac_library,103,61
ac_library,115,64,0		warp	acwarp010	1,1,ac_library,115,95
ac_library,115,93,0		warp	acwarp011	1,1,ac_library,115,61

// ------------------------------------------------------------------------------
//�}���ْ����̐}���ٓ����̕���
ac_library,103,51,0		warp	acwarp012	1,1,ac_library,103,19
ac_library,103,22,0		warp	acwarp013	1,1,ac_library,103,54
ac_library,115,51,0		warp	acwarp014	1,1,ac_library,115,19
ac_library,115,22,0		warp	acwarp015	1,1,ac_library,115,54

// ------------------------------------------------------------------------------
//�}���ْ����̐}���ٓ��E�̕���
ac_library,122,57,0		warp	acwarp016	1,1,ac_library,164,110
ac_library,161,110,0	warp	acwarp017	1,1,ac_library,119,57

// ------------------------------------------------------------------------------
//���K���i�C�݁j
ac_prac_01,225,25,0		warp	acpracwp01		3,2,ac_cl_area,53,181
//���K���i���j
ac_prac_02,108,27,0		warp	acpracwp02		1,1,ac_cl_area,53,181
//���K���i�����j
ac_prac_03,29,343,0		warp	acpracwp03		1,1,ac_cl_area,53,181
//���K���i�Y�z�j
ac_prac_04,261,255,0	warp	acpracwp04		1,1,ac_cl_area,53,181
//���K���i�����j
ac_prac_05,51,170,0		warp	acpracwp05		1,3,ac_cl_area,53,181
//���ʎ��i�΁j
ac_spec_01,283,28,0		warp	acpracwp05		1,3,ac_cl_area,53,181
//���ʎ��i�p�Ёj
ac_spec_02,118,59,0		warp	acpracwp06		1,3,ac_cl_area,53,181
ac_spec_02,185,70,0		warp	acpracwp07		1,3,ac_spec_02,181,141
ac_spec_02,185,141,0	warp	acpracwp08		1,1,ac_spec_02,180,70
ac_spec_02,106,125,0	warp	acpracwp09		1,1,ac_spec_02,73,174
ac_spec_02,83,174,0		warp	acpracwp10		1,1,ac_spec_02,110,125
ac_spec_02,15,144,0		warp	acpracwp11		1,1,ac_spec_02,77,68
ac_spec_02,81,68,0		warp	acpracwp12		1,1,ac_spec_02,19,144
//���ʎ��i�n�����j
ac_spec_03,105,78		warp	acpracwp13		1,1,ac_cl_area,53,181

// -----------------------------------------------------------------------------
// �m�F���b�Z�[�W�t��WARP

ac_cl_area,71,74,0	script	#������2F_warp1	45,1,1,{/* 52554 */
	if(!(AC_HINT_01 & 0x1)){
		mes "[�C���t�H���[�V����]";
		mes "�]���̐��^FF0000������1F^000000�ł��]";
		mes "�]���̂܂ܐi�݂܂����H�]";
		next;
		if(select("�͂�","������")==2){
			mes "�]�����~�܂����]";
			close;
		}
		mes "[�C���t�H���[�V����]";
		mes "�]^FF0000������1F^000000�ֈړ����܂��]";
		close2;
		set AC_HINT_01, AC_HINT_01 | 0x1;
	}
	warp "ac_cl_area",36,185;
	end;
}

ac_cl_area,71,14,0	script	#������2F_warp2	45,1,1,{/* 52555 */
	if(!(AC_HINT_01 & 0x1)){
		mes "[�C���t�H���[�V����]";
		mes "�]���̐��^FF0000������1F^000000�ł��]";
		mes "�]���̂܂ܐi�݂܂����H�]";
		next;
		if(select("�͂�","������")==2){
			mes "�]�����~�܂����]";
			close;
		}
		mes "[�C���t�H���[�V����]";
		mes "�]^FF0000������1F^000000�ֈړ����܂��]";
		close2;
		set AC_HINT_01, AC_HINT_01 | 0x1;
	}
	warp "ac_cl_area",36,125;
	end;
}

ac_cl_room,152,18,0	script	#���K��_warp1	45,1,1,{/* 52556 */
	if(!(AC_HINT_01 & 0x2)){
		mes "[�C���t�H���[�V����]";
		mes "�]���̐��^FF0000������1F^000000�ł��]";
		mes "�]���̂܂ܐi�݂܂����H�]";
		next;
		if(select("�͂�","������")==2){
			mes "�]�����~�܂����]";
			close;
		}
		mes "[�C���t�H���[�V����]";
		mes "�]^FF0000������1F^000000�ֈړ����܂��]";
		close2;
		set AC_HINT_01, AC_HINT_01 | 0x2;
	}
	warp "ac_cl_area",38,176;
	end;
}

ac_cl_area,30,185,0	script	#������1F_warp1	45,1,1,{/* 52557 */
	if(!(AC_HINT_01 & 0x4)){
		mes "[�C���t�H���[�V����]";
		mes "�]���̐��^FF0000������2F^000000�ł��]";
		mes "�]���̂܂ܐi�݂܂����H�]";
		next;
		if(select("�͂�","������")==2){
			mes "�]�����~�܂����]";
			close;
		}
		mes "[�C���t�H���[�V����]";
		mes "�]^FF0000������2F^000000�ֈړ����܂��]";
		close2;
		set AC_HINT_01, AC_HINT_01 | 0x4;
	}
	warp "ac_cl_area",67,74;
	end;
}

ac_cl_area,35,176,0	script	#������1F_warp2	45,1,1,{/* 52558 */
	if(!(AC_HINT_01 & 0x8)){
		mes "[�C���t�H���[�V����]";
		mes "�]���̐��^FF0000���K��^000000�ł��]";
		mes "�]���̂܂ܐi�݂܂����H�]";
		next;
		if(select("�͂�","������")==2){
			mes "�]�����~�܂����]";
			close;
		}
		mes "[�C���t�H���[�V����]";
		mes "�]^FF0000���K��^000000�ֈړ����܂��]";
		close2;
		set AC_HINT_01, AC_HINT_01 | 0x8;
	}
	warp "ac_cl_room",152,21;
	end;
}

ac_cl_area,35,133,0	script	#������1F_warp3	45,1,1,{/* 52559 */
	if(!(AC_HINT_01 & 0x10)){
		mes "[�C���t�H���[�V����]";
		mes "�]���̐��^FF0000��t�E�u�K��^000000�ł��]";
		mes "�]���̂܂ܐi�݂܂����H�]";
		next;
		if(select("�͂�","������")==2){
			mes "�]�����~�܂����]";
			close;
		}
		mes "[�C���t�H���[�V����]";
		mes "�]^FF0000��t�E�u�K��^000000�ֈړ����܂��]";
		close2;
		set AC_HINT_01, AC_HINT_01 | 0x10;
	}
	warp "ac_cl_room",43,19;
	end;
}

ac_cl_area,30,125,0	script	#������1F_warp4	45,1,1,{/* 52560 */
	if(!(AC_HINT_01 & 0x20)){
		mes "[�C���t�H���[�V����]";
		mes "�]���̐��^FF0000������2F^000000�ł��]";
		mes "�]���̂܂ܐi�݂܂����H�]";
		next;
		if(select("�͂�","������")==2){
			mes "�]�����~�܂����]";
			close;
		}
		mes "[�C���t�H���[�V����]";
		mes "�]^FF0000������2F^000000�ֈړ����܂��]";
		close2;
		set AC_HINT_01, AC_HINT_01 | 0x20;
	}
	warp "ac_cl_area",67,14;
	end;
}

ac_cl_area,76,156,0	script	#������1F_warp5	45,1,1,{/* 52561 */
	if(!(AC_HINT_01 & 0x40)){
		mes "[�C���t�H���[�V����]";
		mes "�]���̐��^FF0000�������z�[��^000000�ł��]";
		mes "�]����E�h��Ȃǂ̔̔���";
		mes "�@�A�J�f�~�[���̃_���W����";
		mes "�@���K��������܂��]";
		mes "�]���̂܂ܐi�݂܂����H�]";
		next;
		if(select("�͂�","������")==2){
			mes "�]�����~�܂����]";
			close;
		}
		mes "[�C���t�H���[�V����]";
		mes "�]^FF0000�������z�[��^000000�ֈړ����܂��]";
		close2;
		set AC_HINT_01, AC_HINT_01 | 0x40;
	}
	warp "ac_cl_hall",167,69;
	end;
}

ac_cl_hall,167,72,0	script	#�����z�[��_warp1	45,1,1,{/* 52562 */
	if(!(AC_HINT_01 & 0x80)){
		mes "[�C���t�H���[�V����]";
		mes "�]���̐��^FF0000������1F^000000�ł��]";
		mes "�]���̂܂ܐi�݂܂����H�]";
		next;
		if(select("�͂�","������")==2){
			mes "�]�����~�܂����]";
			close;
		}
		mes "[�C���t�H���[�V����]";
		mes "�]^FF0000������1F^000000�ֈړ����܂��]";
		close2;
		set AC_HINT_01, AC_HINT_01 | 0x80;
	}
	warp "ac_cl_area",73,156;
	end;
}

ac_cl_hall,167,19,0	script	#�����z�[��_warp5	45,1,1,{/* 52563 */
	if(!(AC_HINT_01 & 0x100)){
		mes "[�C���t�H���[�V����]";
		mes "�]���̐��^FF0000�G���g�����X�z�[��^000000�ł��]";
		mes "�]���̂܂ܐi�݂܂����H�]";
		next;
		if(select("�͂�","������")==2){
			mes "�]�����~�܂����]";
			close;
		}
		mes "[�C���t�H���[�V����]";
		mes "�]^FF0000�G���g�����X�z�[��^000000�ֈړ����܂��]";
		close2;
		set AC_HINT_01, AC_HINT_01 | 0x100;
	}
	warp "ac_en_hall",57,13;
	end;
}

ac_en_hall,54,13,0	script	#�����_warp1	45,1,1,{/* 52564 */
	if(!(AC_HINT_01 & 0x200)){
		mes "[�C���t�H���[�V����]";
		mes "�]���̐��^FF0000�������z�[��^000000�ł��]";
		mes "�]���̂܂ܐi�݂܂����H�]";
		next;
		if(select("�͂�","������")==2){
			mes "�]�����~�܂����]";
			close;
		}
		mes "[�C���t�H���[�V����]";
		mes "�]^FF0000�������z�[��^000000�ֈړ����܂��]";
		close2;
		set AC_HINT_01, AC_HINT_01 | 0x200;
	}
	warp "ac_cl_hall",167,22;
	end;
}

ac_en_hall,97,7,0	script	#�����_warp2	45,1,1,{/* 52565 */
	switch(AC_SAVE_MAP){
	case 0: mes "�]�v�����e����"; break;
	case 1: mes "�]�C�Y���[�h��"; break;
	case 2: mes "�]�����N��"; break;
	case 3: mes "�]�A���x���^��"; break;
	case 4: mes "�]�Q�t�F����"; break;
	case 5: mes "�]�t�F�C������"; break;
	}
	mes "�X�ɖ߂�܂����H�]";
	next;
	if(select("�߂�","�߂�Ȃ�")==2){
		mes "�]�߂�̂���߂��]";
		close;
	}
	mes "[" +strcharinfo(0)+ "]";
	mes "(�X�ɖ߂낤)";
	close2;
	callfunc "AC_WarpTown",AC_SAVE_MAP;
	end;
}

ac_en_hall,143,13,0	script	#�����_warp3	45,1,1,{/* 52566 */
	if(!(AC_HINT_01 & 0x400)){
		mes "[�C���t�H���[�V����]";
		mes "�]���̐��^FF0000�}����^000000�ł��]";
		mes "�]���̂܂ܐi�݂܂����H�]";
		next;
		if(select("�͂�","������")==2){
			mes "�]�����~�܂����]";
			close;
		}
		mes "[�C���t�H���[�V����]";
		mes "�]^FF0000�}����^000000�ֈړ����܂��]";
		close2;
		set AC_HINT_01, AC_HINT_01 | 0x400;
	}
	warp "ac_library",32,58;
	end;
}