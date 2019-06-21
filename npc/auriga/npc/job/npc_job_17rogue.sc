//====================================================================
//Ragnarok Online Rogue jobchange script
//
//�@�� CHANGE_RG
//	1	�ʐڎ���
//	2	�ʐڎ����N���A
//	3	�A�C�e�����W�P
//	4	�A�C�e�����W�Q
//	5	�A�C�e�����W�R
//	6	�A�C�e�����W�S
//	7	�A�C�e�����W�N���A
//	8	�A���g�j�IJr.
//	9	�w���}���\��Jr.		//������
//	10	�A���K��Jr.		//������
//	11	�z���O����Jr.		//������
//	12	�A���g�j�IJr.�Ď���
//	13	�w���}���\��Jr.�Ď���	//������
//	14	�A���K��Jr.�Ď���	//������
//	15	�z���O����Jr.�Ď���	//������
//	16	�ŏI�����N���A
//====================================================================

//==========================================
// �����\������ѓ]�E
//------------------------------------------

in_rogue,363,122,4	script	���[�O�M���h��	747,{
	if(Upper == UPPER_HIGH) {
		mes "[�}�L]";
		mes "����H���񂽁A";
		mes "�̂Ɏ��Ɖ�������Ɩ��������H";
		next;
		mes "[�}�L]";
		mes "�c�c";
		mes "���������A���ԈႦ���݂������ˁB";
		mes "�ς��ˁc�c";
		next;
		mes "[�}�L]";
		mes "���������ԈႦ��Ȃ�Ă߂�����";
		mes "�����񂾂��ǂˁc�c";
		mes "�܁A�C�����ċA��ȁB";
		close;
	}
	if(Job == Job_Rogue) {
		mes "[�}�L]";
		mes "����A�v���Ԃ�`";
		mes "�M���h����̎d���͍��͖�����B";
		next;
		mes "[�}�L]";
		mes "���C�ł���Ă邩���H";
		mes "�����������猾���Ă����B";
		next;
		mes "[�}�L]";
		mes "�������������A";
		mes "��[�Y��Ȃ��ł�`�H";
		mes "�ӂӂ�";
		close;
	}
	if(Job != Job_Thief) {
		mes "[�}�L]";
		mes "��H";
		mes "���̗p�H";
		mes "���镨�Ȃ�Ă����ɂ͂Ȃ���`";
		close;
	}
	if(JobLevel < 40) {
		mes "[�}�L]";
		mes "���[�O�̓V�[�t��JobLv��";
		mes "40�ȏ�̃��c�������Ȃ��񂾁B";
		mes "���񂽂̂悤�ȂЂ�����ɂ�";
		mes "�܂�������B";
		mes "���������b���Ă����ŁB";
		close;
	}
	if(SkillPoint) {
		mes "[���[�O�M���h��]";
		mes "�X�L���|�C���g���c���Ă�����";
		mes "�]�E�ł��Ȃ��˂��B";
		mes "�S������Ă�����Ⴂ�B";
		close;
	}
	switch(CHANGE_RG) {
	case 0:
		mes "[���[�O�M���h��]";
		mes "�ȂɁH����ȂƂ���܂�";
		mes "���̗p���ŗ����̂��B";
		mes "���[�O�ɂȂ肽�����Ă���" +(Sex? "�Z": "�o")+ "���񂩁B";
		next;
		mes "[���[�O�M���h��]";
		mes "��Ă��ꂵ����B";
		mes "�������̓��[�O�M���h��";
		mes "�u�}�L�v���Ă񂾁B";
		mes "���񂽖��O�́H";
		next;
		mes "[�}�L]";
		mes "����H" +strcharinfo(0)+ "���ƁH";
		mes "�������O����Ȃ����B";
		next;
		mes "[�}�L]";
		mes "�Ƃ���ŁA�܂��Ȃ�ł����";
		mes "�Ƃ���ɗ����̂����H";
		mes "���������琳���ɓ����Ă���Ă�";
		mes "����C�C���c�݂��������ǁB";
		next;
		mes "[�}�L]";
		mes "�ł��A���ł�����Ȃӂ���";
		mes "�Ȃ�ł�����ł������Ă������";
		mes "���ԂȂ���B";
		mes "���[�O�M���h�̊O�ł͐g�̈��S��";
		mes "���ӂ��ȁB";
		next;
		mes "[�}�L]";
		mes "���āA���񂽂݂ǂ��날�肻������";
		mes "���������Ƃ��ɓ���e�X�g�ł�";
		mes "�󂯂Ă��炨�����B";
		next;
		mes "[�}�L]";
		mes "����A����Ȃɋْ����Ȃ��ŁB";
		mes "�葱������Ă�Ԃɂ�����";
		mes "�������������炳�B";
		set CHANGE_RG,1;
		break;
	case 1:
		mes "[�}�L]";
		mes "�܂������ˁB";
		mes "�ْ����Ȃ��ł�����x����Ă݂āB";
		mes "�����A�͂��߂��B";
		break;
	case 2:
		mes "[�}�L]";
		mes "�u�X�~�X���g�v�̂Ƃ��ɍs���ȁB";
		mes "�z�̃e�X�g�͂�����Ɩ��c�c";
		mes "�W���S�������炳�c�c";
		mes "���i�����������Ăˁc�c(�Ђ��Ђ�)";
		next;
		mes "[�}�L]";
		mes "�ԈႦ��Ƒ�ς���B";
		mes "�Ƃɂ�������΂��āI";
		close;
	default:	//3�`15�̂Ƃ�
		mes "[�}�L]";
		mes "����΂��āI";
		mes "(�����@��������)";
		next;
		mes "[�}�L]";
		mes "�t�t�c�c����ł܂��ׂ��₷���c�c";
		mes "���c�c�����Ȃ�ł��Ȃ���I";
		mes "�A�n�n�c�c�A�n�n�c�c�n�c�c";
		close;
	case 16:
		set .@itemid,(JobLevel >= 50)? 1220: 1219;
		mes "[�}�L]";
		mes "��������΂�������Ȃ����I";
		mes "��J�������낤�`";
		mes "����]�E�����Ă���B";
		next;
		nude;
		jobchange Job_Rogue;
		set CHANGE_RG,0;
		mes "[�}�L]";
		mes "���߂łƂ��I";
		mes "����΂����˂�";
		mes "���ꂩ��͎��R�ɐ�����񂾂�I";
		mes "�ӂӁc�c";
		next;
		mes "[�}�L]";
		mes "���A�ł�������Ă�����B";
		mes "�����̎��R��厖�Ɏv���Ȃ�A";
		mes "�l�̎��R�����d���Ă��Ȃ���";
		mes "�Ȃ�Ȃ����Ă��Ƃ�B";
		mes "���ꂶ��`�ˁ`�`";
		getitem .@itemid,1;
		close;
	}
	//�ʐڂ�������
	next;
	if(select("�킩����","������Ƃ܂��Ă���")==2) {
		mes "[�}�L]";
		mes "�����A���Ꮐ�����Ă�����Ⴂ�B";
		close;
	}
	mes "[�}�L]";
	mes "����A���ꂶ��͂��߂܂���B";
	next;
	mes "[�}�L]";
	mes "���ꂩ������o������";
	mes "�悭�����Đ��������̂�I��łˁB";
	next;
	switch(rand(3)) {
	case 0:
		mes "[�}�L]";
		mes "1.";
		mes "���[�O�̃X�L���u�g���l���h���C�u�v";
		mes "���o���邽�߂ɕK�v�ȃX�L���́H";
		next;
		if(select("�n�C�f�B���O","�X�e�B�[��","��𗦌���","�o�b�V��")==1)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "2.";
		mes "���[�O�̃X�L��";
		mes "�u�R���p���V�����f�B�X�J�E���g�v";
		mes "�̊������́A���l�́u�f�B�X�J�E���g�v";
		mes "Lv10��艽%�������B";
		next;
		if(select("3 %","2 %","1 %","0 %")==3)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "3.";
		mes "�X�L���u�X�e�B�[���R�C���v�̔\�͂́H";
		next;
		if(select("�v���C���[����A�C�e���𓐂�","�����X�^�[����A�C�e���𓐂�","�����X�^�[����Zeny�𓐂�","�v���C���[����Zeny�𓐂�")==3)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "4.";
		mes "�V�[�t�n�ŏK���ł���X�L���ŁA";
		mes "�f�������Ɍ�ނ���X�L����";
		mes "���Ƃ������B";
		next;
		if(select("�o�b�N�_�b�V��","�ً}���","�o�b�N�X�^�u","�o�b�N�X�e�b�v")==4)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "5.";
		mes "�X�L���u�X�g���b�v�w�����vLv5";
		mes "���K�����邱�ƂŐV���ɏo������";
		mes "�X�L���́H";
		next;
		if(select("�C���x�i��","�g���l���h���C�u","�x�m���X�v���b�V���[","�X�g���b�v�V�[���h")==4)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "6.";
		mes "���̒��ŁA���̖͂ڂ𓐂��";
		mes "�ړ�����X�L���́H";
		next;
		if(select("�n�C�f�B���O","�o�b�N�X�e�b�v","�g���l���h���C�u","���܂�")==3)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "7.";
		mes "���̒��ŁA�����U���̖�������";
		mes "�グ�Ă����J�[�h�́H";
		next;
		if(select("�A���h��","�t�@�~���A�[�J�[�h","�}�~�[�J�[�h","�}���i�J�[�h")==3)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "8.";
		mes "���̒��ŁA�o�h���J�[�h";
		mes "(�Α�����20%�ǉ��_���[�W)";
		mes "���h��������ōU������̂�";
		mes "�K���Ă��郂���X�^�[�́H";
		next;
		if(select("�o�h��","�f�r���`","�G���_�[�E�B���[","�o�t�H���b�g")==3)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "9.";
		mes "�Z���Ń_�u���A�^�b�N��";
		mes "���������ꍇ��SP����ʂ́H";
		next;
		if(select("15","�p�b�V�u�Ȃ̂� 0","�p�b�V�u�Ȃ̂� 10�ŌŒ�","54")==2)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "10.";
		mes "�C�Y���[�h�_���W�����Ō��ʂ�";
		mes "�������镐��͎��̂����ǂꂩ�B";
		next;
		if(select("�E�C���h �}�C���S�[�V��","�A�C�X �}�C���S�[�V��","�A�[�X �}�C���S�[�V��","�t�@�C�A �}�C���S�[�V��")==1)
			set .@point,.@point+10;
		break;
	case 1:
		mes "[�}�L]";
		mes "1.";
		mes "�X���b�g�̑����O���f�B�E�X�𗎂Ƃ�";
		mes "�����X�^�[�͎��̂����ǂꂩ�B";
		next;
		if(select("���","�y�R�y�R","�f�U�[�g�E���t","�R�{���h")==4)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "2.";
		mes "�\�P�b�g�̂���}�C���S�[�V����";
		mes "�ǂ̃����X�^�[���瓾���邩�B";
		next;
		if(select("�z�[�l�b�g","�f�U�[�g�E���t","�}���I�l�b�g","�~�X�g")==1)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "3.";
		mes "�|�[�V�����𐻑����邱�Ƃ��ł���";
		mes "�E�Ƃ́H";
		next;
		if(select("���l","�A���P�~�X�g","�u���b�N�X�~�X","�v���[�X�g")==2)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "4.";
		mes "���̒��Ń��[�O���g�����Ƃ�";
		mes "�ł��Ȃ�����́H";
		next;
		if(select("�p�|","�N���X�{�E","�O���f�B�E�X","�J�^�[��")==4)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "5.";
		mes "�z�[�h�̑����͉����B";
		next;
		if(select("������","�Α���","������","�n����")==4)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "6.";
		mes "���̒��ŁA�y�b�g�ɂ��邱�Ƃ�";
		mes "�ł��Ȃ������X�^�[�́H";
		next;
		if(select("�|�|����","�N���[�~�[","�I�[�N�E�H���A�[","�|�C�Y���X�|�A")==2)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "7.";
		mes "�Α����Z������Ԍ��ʓI��";
		mes "�����X�^�[��I�тȂ����B";
		next;
		if(select("�Z���S�u����","���C�X�S�u����","�t���C���S�u����","�n���}�[�S�u����")==4)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "8.";
		mes "���̒��ŁA�M���h�Ԃ̖����X�́H";
		next;
		if(select("�v�����e��","�A���f�o����","�A���x���^","�t�F�C����")==3)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "9.";
		mes "���̒��ŁA�n�[�u�𗎂Ƃ�";
		mes "�����X�^�[��I�ׁB";
		next;
		if(select("�ΐF��","���F��","����","�P����")==3)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "10.";
		mes "���̒��ŁA�A���f�b�h�ł͂Ȃ�";
		mes "�����X�^�[��I�ׁB";
		next;
		if(select("�]���r","���K���h��","�t�@�~���A�[","�J�[���b�c�o�[�O")==3)
			set .@point,.@point+10;
		break;
	case 2:
		mes "[�}�L]";
		mes "1.";
		mes "�V�[�t�́u��𗦌���v�X�L��";
		mes "���}�X�^�[�������㏸����FLEE�́H";
		next;
		if(select("30","40","160","20")==1)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "2.";
		mes "���̒��ŁA�n�C�f�B���O��";
		mes "�N���[�L���O�����j�郂���X�^�[�́H";
		next;
		if(select("���[���e�[��","�A���S�X","�}�~�[","�\���W���[�X�P���g��")==2)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "3.";
		mes "���̒��ŁA���[�O�M���h������";
		mes "���̒n���𓚂���B";
		next;
		if(select("�R���h","�R�R���r�[�`","�t�@���X���䓇","�����N")==3)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "4.";
		mes "�V�[�t�M���h������X�́H";
		next;
		if(select("�R���h","���e�B�G","�A���x���^","�����N")==4)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "5.";
		mes "DEX�Ɗ֌W�Ȃ��J�[�h�́H";
		next;
		if(select("���b�J�[�J�[�h","�}�~�[�J�[�h","�[�����J�[�h","�h���b�v�X�J�[�h")==2)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "6.";
		mes "���[�O�̓����𓚂���B";
		next;
		if(select("�����ꂽ�g�̂��Ȃ�","�����ꂽ���@��","�����ꂽ������������","�����ꂽ�U����"))	//�ǂ������
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "7.";
		mes "�V�[�t���烍�[�O�ɂȂ邽�߂�";
		mes "JobLv�Œ�l�͂������B";
		next;
		if(select("30","41","40","50")==3)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "8.";
		mes "������߂�ɂ͂ǂ��ɍs���Ηǂ����B";
		next;
		if(select("�����N 7�����������̓�","�v�����e�� 7�����������̓�","�����N 5�����������̓�","�v�����e�� 1�����������̓�")==2)
			set .@point,.@point+10;
		mes "[�}�L]";
		mes "9.";
		mes "�m�[�r�X���V�[�t�ɂȂ�ꍇ";
		mes "�K�v�ɂȂ邫�̂��̖��O�́H";
		next;
		if(select("�g�̖уx�g�x�g�L�m�R","�Ԗуx�g�x�g�L�m�R","�g�̖іԃL�m�R","�g�V�C�^�P")) {	//������2�Ȃ̂œ��ꏈ��
			if(@menu == 1 || @menu == 3)
				set .@point,.@point+10;
		}
		mes "[�}�L]";
		mes "10.";
		mes "��r�I���[�O�Ɗ֌W�̖����J�[�h�́H";
		next;
		if(select("�E�B�X�p�[�J�[�h","�G���_�[�E�B���[�J�[�h","�[�����J�[�h","�}�[�^�[�J�[�h")==2)
			set .@point,.@point+10;
		break;
	}
	mes "[�}�L]";
	mes "�ӂ��c�c";
	mes "�����ꂳ��B";
	next;
	mes "[�}�L]";
	mes "��c�c�_���́c�c";
	mes .@point+ "�_���B";
	if(.@point < 90) {
		mes "���߂��B";
		mes "����Ȃ񂶂Ⴭ�[�O�Ƃ���";
		mes "����Ă����Ȃ���B";
		mes "�������������W�߂Ă��痈�ȁB";
		close;
	}
	mes "�ց`";
	mes "�Ȃ��Ȃ��݂ǂ��낪";
	mes "���邶��Ȃ��[�B";
	next;
	mes "[�}�L]";
	mes "���āA���ꂩ�炪�{�Ԃ�B";
	mes "�u�X�~�X���g�v�����̃e�X�g��";
	mes "�S�����B";
	mes "�C�����ȁA�z�͏W���S��������";
	mes "���Ȃ�C�����c�c";
	set CHANGE_RG,2;
	close;
}


//==========================================
// �ꎟ�����i���i���D�j
//------------------------------------------

in_rogue,376,23,2	script	�X�~�X���g	57,{
	switch(CHANGE_RG) {
	case 0:
	case 1:
		mes "[�X�~�X���g]";
		mes "�Ђ��ӂ��݂��c�c�c�c�c";
		mes "����悪�c�c";
		mes "�����N�c�c�Q�t�F���c�c�R���h�c�c";
		next;
		mes "[�X�~�X���g]";
		mes "�����ɂ��c�c";
		next;
		mes "[�X�~�X���g]";
		mes "����H���O�͂Ȃ񂾁H";
		mes "�]�E�������Ȃ瑼�̃��c�Ɍ����I";
		next;
		mes "[�X�~�X���g]";
		mes "�c�c�������c�c";
		close;
	case 2:
		mes "[�X�~�X���g]";
		mes "���[�O�M���h�ɗ������Ƃ�";
		mes "���}����B";
		mes "������A���[�O�ɂȂ邽�߂�";
		mes "��{�I�ȃe�X�g�����B";
		next;
		mes "[�X�~�X���g]";
		mes "�����A�e�X�g�̑O�ɗp�ӂ���";
		mes "���炢�������̂�����B";
		next;
		mes "[�X�~�X���g]";
		mes "���Ɨ������邩�班������";
		mes "�p�ӂ���񂾁B";
		mes "�I���B���[�O�M���h�����{������";
		mes "�d�����n�߂Ď��v���o���Ȃ����";
		mes "�Ȃ�Ȃ��B";
		mes "�ł͎��̕��������ė����B";
		next;
		mes "[�X�~�X���g]";
		mes "�܂��A�M���h�o�^��^FF333310000Zeny^000000��";
		switch(rand(4)) {
			case 0:
				set CHANGE_RG,3;
				mes "�X�P���{�[�� 10��";
				mes "�n�[�u 6��";
				next;
				mes "[�X�~�X���g]";
				mes "�S�҂̒� 10��";
				mes "�S�҂̉� 10��";
				break;
			case 1:
				set CHANGE_RG,4;
				mes "�΃n�[�u 10��";
				mes "���ɂ̂����� 10��";
				next;
				mes "[�X�~�X���g]";
				mes "�ւ̗� 10��";
				mes "�K���b�g 10��";
				break;
			case 2:
				set CHANGE_RG,5;
				mes "���n�[�u 10��";
				mes "�������� 10��";
				next;
				mes "[�X�~�X���g]";
				mes "�o�b�^�̑� 10��";
				mes "���܂̑��̗� 10��";
				break;
			case 4:		//�䎌������
				set CHANGE_RG,6;
				mes "���Ȃ��̔� 5��";
				mes "�󂫃r�� 5��";
				mes "�S�z�� 5��";
				mes "��̐S�� 5��";
				mes "�ԃn�[�u 5��";
				next;
				mes "[�X�~�X���g]";
				mes "�b�̔� 5��";
				mes "�C�G���[�W�F���X�g�[�� 5��";
				mes "��������̉� 5��";
				mes "�T�\���̐K�� 5��";
				mes "�T���̂����� 5��";
				mes "�������̃G�T 5��";
				mes "���ꂩ��c�c";
				next;
				mes "[�X�~�X���g]";
				mes "�Ȗ� 5��";
				mes "�N���[�o�[ 5��";
				mes "���̉H�� 5��";
				mes "���̂� 5��";
				mes "������̗� 5��";
				mes "�^�k�L�؂̗t 5��";
				break;
		}
		mes "����c�c���Ɓc�c";
		next;
		mes "[�X�~�X���g]";
		mes "���ꂭ�炢�ɂ��Ă������B";
		if(CHANGE_RG == 6) {	//�䎌������
			mes "��H�����������āH";
			mes "�c�C�ɂ���ȁB";
		}
		mes "�ł͑S�������Ă���܂������B";
		close;
	case 3:
	case 4:
	case 5:
	case 6:
		switch(CHANGE_RG) {
			case 3:
				setarray .@need,932,510,957,958;
				setarray .@amount,10,6,10,10;
				break;
			case 4:
				setarray .@need,511,964,926,910;
				cleararray .@amount,10,4;
				break;
			case 5:
				setarray .@need,508,935,940,948;
				cleararray .@amount,10,4;
				break;
			case 6:
				setarray .@need,915,713,1002,953,507,919,715,913,904,942,528,914,705,916,917,908,845;
				cleararray .@amount,5,17;
				break;
		}
		for(set .@i,0; .@i<getarraysize(.@need); set .@i,.@i+1) {
			if(countitem(.@need[.@i]) < .@amount[.@i] || Zeny < 10000)
				break;
		}
		if(.@i < getarraysize(.@need)) {
			mes "[�X�~�X���g]";
			mes "��c�c����Ȃ���������B";
			mes "���𗊂񂾂�������x�����B";
			next;
			mes "[�X�~�X���g]";
			mes "�M���h�o�^��^FF333310000Zeny^000000";
			next;
			mes "[�X�~�X���g]";
			if(CHANGE_RG < 6) {
				for(set .@i,0; .@i<4; set .@i,.@i+1)
					mes getitemname(.@need[.@i])+ " " +.@amount[.@i]+ "��";
			}
			else {
				mes "���Ȃ��̔� 5��";
				mes "�󂫃r�� 5��";
				mes "�S�z�� 5��";
				mes "��̐S�� 5��";
				mes "�ԃn�[�u 5��";
				next;
				mes "�b�̔� 5��";
				mes "�C�G���[�W�F���X�g�[�� 5��";
				mes "��������̉� 5��";
				mes "�T�\���̐K�� 5��";
				mes "�T���̂����� 5��";
				mes "�������̃G�T 5��";
				next;
				mes "�Ȗ� 5��";
				mes "�N���[�o�[ 5��";
				mes "���̉H�� 5��";
				mes "���̂� 5��";
				mes "������̗� 5��";
				mes "�^�k�L�؂̗t 5��";
			}
			mes "���B����ł͑҂��Ă���B";
			close;
		}
		mes "[�X�~�X���g]";
		mes "�܂��A�M���h�o�^��^FF333310000Zeny^000000��";
		set Zeny,Zeny-10000;
		for(set .@i,0; .@i<getarraysize(.@need); set .@i,.@i+1)
			delitem .@need[.@i],.@amount[.@i];
		switch(CHANGE_RG) {
			case 3:
				mes "�X�P���{�[�� 10��";
				mes "�n�[�u 6��";
				mes "�悵�悵�c�c";
				next;
				mes "�S�҂̒� 10��";
				mes "�S�҂̉� 10��";
				mes "�ӂށc�c�������B";
				break;
			case 4:
				mes "�΃n�[�u 10��";
				mes "���ɂ̂����� 10��";
				next;
				mes "�ւ̗� 10��";
				mes "�K���b�g 10��";
				mes "�悵�A�S������ȁB";
				break;
			case 5:
				mes "���n�[�u 10��";
				mes "�������� 10��";
				next;
				mes "�o�b�^�̑� 10��";
				mes "���܂̑��̗� 10��";
				mes "�悵�A�S������ȁB";
				break;
			case 6:
				mes "���Ȃ��̔� 5��";
				mes "�󂫃r�� 5��";
				mes "�S�z�� 5��";
				mes "��̐S�� 5��";
				mes "�ԃn�[�u 5��";
				next;
				mes "�b�̔� 5��";
				mes "�C�G���[�W�F���X�g�[�� 5��";
				mes "��������̉� 5��";
				mes "�T�\���̐K�� 5��";
				mes "�T���̂����� 5��";
				mes "�������̃G�T 5��";
				next;
				mes "�Ȗ� 5��";
				mes "�N���[�o�[ 5��";
				mes "���̉H�� 5��";
				mes "���̂� 5��";
				mes "������̗� 5��";
				mes "�^�k�L�؂̗t 5��";
				mes "�c�c";
				//�䎌������
				next;
				mes "[�X�~�X���g]";
				mes "�悭���ꂾ���̕���";
				mes "�W�߂ė���ꂽ�ȁB";
				mes "����͖J�����B�Ƃ��Ă����Ȃ����B";
				getitem 1097,1;
				break;
		}
		set CHANGE_RG,7;
		next;
		mes "[�X�~�X���g]";
		mes "�悵�A������Ə������邩��";
		mes "�҂��Ă���B";
		mes "�܂��b�������Ă���B";
		mes "���̃e�X�g�́c�c�Ɓc�c";
		close;
	case 7:
		mes "[�X�~�X���g]";
		mes "���̃e�X�g�̒S���́c�c";
		mes "�N���������c�c";
		next;
		mes "[�X�~�X���g]";
		mes "�����c�c���c�������ȁB";
		next;
		switch(rand(1)) {
			case 0:		//�A���g�j�IJr
				set CHANGE_RG,8;
				mes "[�X�~�X���g]";
				mes "�A���g�j�IJr.�������B";
				mes "�A���g�j�I����̑��q���B";
				mes "������m���Ă��邩�H";
				mes "�e�����񂪉��̎��s��������";
				mes "�m��Ȃ����A�Ȃ�ł�����_����";
				mes "����炵���c�c";
				next;
				mes "[�X�~�X���g]";
				mes "�����̃t�F�C�����o�g����";
				mes "�R�R���r�[�`�̋󂫉Ƃ��g����";
				mes "��炵�Ă���B";
				mes "���܂ɊO�ő������c�������";
				mes "�o�čs���Ė\���炵���c�c";
				next;
				mes "[�X�~�X���g]";
				mes "�_�o���������܂���Ă���";
				mes "�߂Â����c�ɂ͗e�͂Ȃ��i�C�t��";
				mes "������炵���c�c";
				mes "�I�������̃M���h�}�X�^�[��";
				mes "�h�����Đ����ɐ�������";
				mes "���[�O�M���h�ɓ��ꂽ�炵���B";
				next;
				mes "[�X�~�X���g]";
				mes "����ȃ��c�����A�r�O�͗ǂ���";
				mes "�d���͑����B���ɑ��Z��";
				mes "���ӂ������ȁc�c";
				next;
				mes "[�X�~�X���g]";
				mes "�܂��A�q�����D��������";
				mes "���̘b�ŋC�ɓ������";
				mes "�F�X�����Ă��炦��Ǝv���B";
				next;
				mes "[�X�~�X���g]";
				mes "���A�ꉞ���c�ɋ߂Â������t��";
				mes "�����Ă����B";
				mes "^3333FF�A���g�j�I�͐��B�i���󂷂̂�^000000";
				mes "^3333FF�D���ł͂Ȃ�^000000";
				mes "���B�C������B";
				close;
			case 1:		//�w���}���\��Jr
				set CHANGE_RG,9;
				//������
				close;
			case 2:		//�A���K��Jr
				set CHANGE_RG,10;
				//������
				close;
			case 3:		//�z���O����Jr
				set CHANGE_RG,11;
				//������
				close;
		}
	case 8:
		mes "[�X�~�X���g]";
		mes "�Ȃ񂾁A�ꏊ�ł��Y�ꂽ���H";
		mes "���x�͂������胁�����Ă����񂾁B";
		next;
		mes "[�X�~�X���g]";
		mes "��������R���h�̕��̍��l�A";
		mes "�R�R���r�[�`�ɂ��錚���B";
		mes "�A���g�j�IJr.�ɉ�B";
		mes "�����t��";
		mes "^3333FF�A���g�j�I�͐��B�i���󂷂̂�^000000";
		mes "^3333FF�D���ł͂Ȃ�^000000";
		close;
	case 9:
		//������
		close;
	case 10:
		//������
		close;
	case 11:
		//������
		close;
	case 12:
		mes "[�X�~�X���g]";
		mes "�����ɂ͂����p�͖������낤�H";
		close;
	}
}


//==========================================
// �񎟎����i���[�O�K��j
//------------------------------------------

cmd_fild04,304,180,0	script	roguewarp0401	45,1,1,{
	mes "[�@]";
	mes "�N��!?";
	mes "�����ɉ��̂悤���I";
	next;
	for(set .@i,0; .@i<4; set .@i,.@i+1) {
		switch(.@i) {
			case 0: setarray .@word$,"�A���e�B�I�j�I��","�A���K����","�A���g�j�I��","�z���O������"; 			break;
			case 1: setarray .@word$,"���B���i��","���B�i��","���B���i��","���B�i"; 					break;
			case 2: setarray .@word$,"�󂷂��Ƃ�","�󂷂̂�","�������Ƃ�","�����̂�"; 					break;
			case 3: setarray .@word$,"�D�ނ悤��","�D����������Ȃ�","�D���ł͂Ȃ�","�D���ł���","�D����","�D�܂Ȃ�"; 	break;
		}
		set .@ret[.@i],select(.@word$[0],.@word$[1],.@word$[2],.@word$[3],.@word$[4],.@word$[5]);
		if(.@i == 0)
			mes "["+strcharinfo(0)+"]";
		mes .@word$[.@ret[.@i]-1];	//�I���������ڂ����b�Z�[�W�Ƃ��ďo��
	}
	next;
	if(.@ret[0] == 3 && .@ret[1] == 2 && .@ret[2] == 2 && .@ret[3] == 3) {
		mes "--�J�`����--";
		mes "�J�M���J�����B";
		close2;
		warp "in_rogue",164,106;
		end;
	}
	mes "[�@]";
	mes "�������ɂ����I";
	close;
}

cmd_fild07,355,286,0	warp	roguewarp0402	1,1,in_rogue,247,126

cmd_fild09,106,195,0	script	roguewarp0403	45,1,1,{
	mes "[�@]";
	mes "�N��!?";
	mes "�����ɉ��̂悤���I";
	next;
	for(set .@i,0; .@i<4; set .@i,.@i+1) {
		switch(.@i) {
			case 0: setarray .@word$,"�����̕���","�A���K����","�A���S����","���S�[�����X��"; 	break;
			case 1: setarray .@word$,"���B���i��","���B�����","���B�p�i��","���B�i����"; 		break;
			case 2: setarray .@word$,"������","���̂���","�Ԃ�����","�@����","���������"; 	break;
			case 3: setarray .@word$,"���Ȃ�","������","������","�Ȃ�����",""; 			break;
		}
		set .@ret[.@i],select(.@word$[0],.@word$[1],.@word$[2],.@word$[3],.@word$[4]);
		if(.@i == 0)
			mes "["+strcharinfo(0)+"]";
		mes .@word$[.@ret[.@i]-1];	//�I���������ڂ����b�Z�[�W�Ƃ��ďo��
	}
	next;
	if(.@ret[0] == 2 && .@ret[1] == 3 && .@ret[2] == 2 && .@ret[3] == 1) {
		mes "--�J�`����--";
		mes "�J�M���J�����B";
		close2;
		warp "in_rogue",244,25;
		end;
	}
	mes "[�@]";
	mes "�������ɂ����I";
	close;
}

cmd_fild09,335,143,0	script	roguewarp0404	45,1,1,{
	mes "[�@]";
	mes "�N��!?";
	mes "�����ɉ��̂悤���I";
	next;
	for(set .@i,0; .@i<4; set .@i,.@i+1) {
		switch(.@i) {
			case 0: setarray .@word$,"�����̕���","�A���K����","�A���S����","���S�[�����X��"; 	break;
			case 1: setarray .@word$,"���B���i��","���B�����","���B�p�i��","���B�i����"; 		break;
			case 2: setarray .@word$,"�C������","���B����","�󂵂�","�����","���̂���"; 		break;
			case 3: setarray .@word$,"���Ȃ�","������","������","�Ȃ�����",""; 			break;
		}
		set .@ret[.@i],select(.@word$[0],.@word$[1],.@word$[2],.@word$[3],.@word$[4]);
		if(.@i == 0)
			mes "["+strcharinfo(0)+"]";
		mes .@word$[.@ret[.@i]-1];	//�I���������ڂ����b�Z�[�W�Ƃ��ďo��
	}
	next;
	if(.@ret[0] == 1 && .@ret[1] == 3 && .@ret[2] == 5 && .@ret[3] == 1) {
		mes "--�J�`����--";
		mes "�J�M���J�����B";
		close2;
		warp "in_rogue",169,34;
		end;
	}
	mes "[�@]";
	mes "�������ɂ����I";
	close;
}

in_rogue,161,103,0		warp	roguewarp0501	1,1,cmd_fild04,302,177
in_rogue,247,122,0		warp	roguewarp0502	1,1,cmd_fild07,349,285
in_rogue,244,21,0		warp	roguewarp0503	1,1,cmd_fild09,106,191
in_rogue,172,34,0		warp	roguewarp0504	1,1,cmd_fild09,341,143

in_rogue,270,130,0		script	roguewarp6001	45,1,1,{
	mes "�J�M���������Ă���B";
	mes "���������킹��Ƃ��낪";
	mes "����悤���B";
	next;
	input .@val;
	if(.@val == 3019) {
		mes "[�w���}���\��Jr.]";
		mes "�p�X���[�h�ς�����B";
	}
	else if(.@val != 0)
		mes "�����N����Ȃ�";
	close;
}

//==============================================================
in_rogue,177,109,2	script	�A���g�j�I Jr	88,{
	if(Job == Job_Rogue) {
		mes "[�A���g�j�IJr.]";
		mes "�����܂ŉ����ɁH";
		mes "��������������x��ł����ȁB";
		close;
	}
	switch(CHANGE_RG) {
	default:
		mes "[�A���g�j�IJr.]";
		mes "�ȂɁI";
		mes "���[�O�M���h���痈���񂶂�";
		mes "�Ȃ��̂��I";
		mes "���߂��c�c";
		mes "����ȁI�c�c����ȁI";
		next;
		mes "[�A���g�j�IJr.]";
		mes "���O���䂪�ꑰ�ɍ��݂�";
		mes "����z���낤�I";
		mes "�I���͎��ʂ킯�ɂ͂����Ȃ��B";
		mes "������������Ȃ����";
		mes "�I�������O���I";
		close;
	case 8:
	case 9:		//�A���g�j�I�ȊO�������Ȃ̂łƂ肠����9�`11�������Ă���
	case 10:
	case 11:
		mes "[�A���g�j�IJr.]";
		mes "���[�O�M���h���痈���l���B";
		next;
		mes "[�A���g�j�IJr.]";
		mes "���[�O�ɂȂ肽���ė����̂����H";
		mes "����Ȃ狳���Ă������B";
		next;
		mes "[�A���g�j�IJr.]";
		mes "�I���B���[�O��^3333FF���҂͔���";
		mes "��҂ɂ�����^000000���Ƃ��厖���B";
		mes "����ă����X�^�[�ƑΛ����鎞��";
		mes "����Ȃ�̐g�̂��Ȃ���������B";
		next;
		mes "[�A���g�j�IJr.]";
		mes "�����X�^�[�ł���͂�";
		mes "�ア���̂ɂ͐ϋɓI�ɍU��";
		mes "�������̂���͓�����Ƃ����̂�";
		mes "�������B";
		next;
		mes "[�A���g�j�IJr.]";
		mes "�����A���̌����ɂ���������";
		mes "^3333FF���[�O�M���h�܂Œʂ��Ă���n�����H^000000";
		mes "��ʂ�A�����ɂ��ǂ���Ă݂�B";
		mes "���O�̎��X�L���ł��܂����Ȃ��񂾁B";
		next;
		if(select("�o������","��߂�")==2) {
			mes "[�A���g�j�IJr.]";
			mes "�I���͖Z�����B";
			mes "���O�̏�k�ɕt�������Ă�";
			mes "�q�}�͂Ȃ��񂾁B";
			close;
		}
		mes "[�A���g�j�IJr.]";
		mes "���s���J��Ԃ���";
		mes "�M���h�̑�����������Ȃ�H";
		close2;
		set CHANGE_RG,12;
		warp "in_rogue",15,105;
		end;
	case 12:
	case 13:	//�A���g�j�I�ȊO�������Ȃ̂łƂ肠����13�`15�������Ă���
	case 14:
	case 15:
		mes "[�A���g�j�IJr.]";
		mes "����c�c�c�O���B";
		mes "�����ǃI���͉�������Ȃ��B";
		mes "�����ŗ�������B";
		next;
		if(select("�o������","��߂�")==2) {
			mes "[�A���g�j�IJr.]";
			mes "�I���͖Z�����B";
			mes "���O�͓]�E������肪";
			mes "����̂��H";
			close;
		}
		mes "[�A���g�j�IJr.]";
		mes "�ł͑��낤�A�������F��B";
		close2;
		warp "in_rogue",15,105;
		end;
	}
}

//==============================================================
in_rogue,272,135,2	script	�w���}���\�� Jr	85,{
	if(Job == Job_Rogue) {
		//������
		close;
	}
	switch(CHANGE_RG) {
	default:
		mes "[�w���}���\��Jr.]";
		mes "����H���̗p���I";
		mes "���[�O�M���h���痈���z����";
		mes "�Ȃ��ȁI";
		mes "�ق�A�o�čs���c�c";
		next;
		mes "[�w���}���\��Jr.]";
		mes "���O�c�c���O���䂪�ꑰ��";
		mes "���ޔy���I";
		mes "�܂��Ă���c�c���ɂ����Ȃ��I";
		mes "�ǂ����s���I";
		mes "�s���Ȃ��ƃI�������O��!!!!";
		close;
	case 9:
		//������
		set CHANGE_RG,13;
		close;
	case 13:
		//������
		close;
	}
}

//==============================================================
in_rogue,244,39,5	script	�A���K�� Jr	99,{
	if(Job == Job_Rogue) {
		mes "[�A���K��Jr.]";
		mes "����H���̗p���H";
		mes "��������������x��ł����Ȃ����B";
		close;
	}
	switch(CHANGE_RG) {
	default:
		mes "[�A���K��Jr.]";
		mes "�ȁc�c�ȂɁI";
		mes "���Ȃ��̓��[�O�M���h����";
		mes "�����҂ł͂Ȃ��ȁI";
		mes "�������ɍs��!!";
		next;
		mes "[�A���K��Jr.]";
		mes "���Ȃ����䂪�ꑰ�ɍ��݂�����";
		mes "�҂��c�c�I";
		mes "���͂܂����ʂ킯�ɂ����Ȃ��B";
		mes "�ǂ����ɍs���Ȃ��̂Ȃ��";
		mes "�������Ȃ����I";
		close;
	case 10:
		//������
		set CHANGE_RG,14;
		close;
	case 14:
		//������
		close;
	}
}

//==============================================================
in_rogue,160,34,2	script	�z���O���� Jr	85,{
	if(Job == Job_Rogue) {
		mes "[�A���g�j�IJr.]";
		mes "�悤�A���̗p�����H";
		mes "��������������x��ł����Ȃ�B";
		close;
	}
	switch(CHANGE_RG) {
	default:
		mes "[�z���O����Jr.]";
		mes "�I";
		mes "���O�́c�c�Ȃ񂾁I";
		mes "���[�O�M���h���痈���z����";
		mes "�Ȃ��ȁI";
		next;
		mes "[�z���O����Jr.]";
		mes "���������I";
		next;
		mes "[�z���O����Jr.]";
		mes "�����ɏo�čs���I";
		next;
		mes "[�z���O����Jr.]";
		mes "���O�������̈ꑰ�ɍ��݂�����";
		mes "�z���H";
		mes "�������I���͂����Ŏ��ʂ킯�ɂ�";
		mes "�����Ȃ��B";
		mes "�o�čs���I�����Ȃ���";
		mes "�I�������O���I";
		close;
	case 11:
		//������
		set CHANGE_RG,15;
		close;
	case 15:
		//������
		close;
	}
}


//==========================================
// �O�������i�A�ҁj
//------------------------------------------

in_rogue,15,185,0	script	#RG_Test01	139,8,0,{
	if(CHANGE_RG != 12)
		end;
	if(getnpctimer(1,"RG_Timer") == 0)	//�^�C�}�[����~���Ă���n��
		initnpctimer "RG_Timer";
	monster "in_rogue",13,188,"--ja--",1394,1;
	monster "in_rogue",14,189,"--ja--",1394,1;
	monster "in_rogue",15,190,"--ja--",1394,1;
	monster "in_rogue",16,188,"--ja--",1394,1;
	monster "in_rogue",17,189,"--ja--",1394,1;
	monster "in_rogue",18,190,"--ja--",1394,1;
	end;
}

in_rogue,15,245,0	script	#RG_Test02	139,8,0,{
	if(CHANGE_RG != 12)
		end;
	monster "in_rogue",13,248,"--ja--",1393,1;
	monster "in_rogue",15,248,"--ja--",1393,1;
	monster "in_rogue",17,248,"--ja--",1393,1;
	end;
}

in_rogue,15,333,0	script	#RG_Test03	139,8,0,{
	if(CHANGE_RG != 12)
		end;
	monster "in_rogue",15,336,"--ja--",1394,3;
	end;
}

in_rogue,35,342,0	script	#RG_Test04	139,0,8,{
	if(CHANGE_RG != 12)
		end;
	monster "in_rogue",38,340,"--ja--",1393,1;
	monster "in_rogue",37,342,"--ja--",1893,1;
	monster "in_rogue",39,342,"--ja--",1423,1;
	monster "in_rogue",38,344,"--ja--",1393,1;
	end;
}

in_rogue,57,306,0	script	#RG_Test05	139,4,0,{
	if(CHANGE_RG != 12)
		end;
	monster "in_rogue",59,301,"--ja--",1438,1;
	end;
}

in_rogue,96,333,0	script	#RG_Test06	139,0,4,{
	if(CHANGE_RG != 12)
		end;
	monster "in_rogue",92,325,"--ja--",1438,1;
	end;
}

in_rogue,139,313,0	script	#RG_Test07	139,4,0,{
	if(CHANGE_RG != 12)
		end;
	monster "in_rogue",139,309,"--ja--",1893,1;
	end;
}

in_rogue,135,246,0	script	#RG_Test08	139,0,4,{
	if(CHANGE_RG != 12)
		end;
	monster "in_rogue",140,246,"--ja--",1394,1;
	monster "in_rogue",141,246,"--ja--",1394,1;
	monster "in_rogue",142,246,"--ja--",1394,1;
	monster "in_rogue",148,246,"--ja--",1394,1;
	monster "in_rogue",149,246,"--ja--",1394,1;
	monster "in_rogue",150,246,"--ja--",1394,1;
	end;
}

in_rogue,199,218,0	script	#RG_Test09	139,0,8,{
	if(CHANGE_RG != 12)
		end;
	monster "in_rogue",157,218,"--ja--",1394,10;
	monster "in_rogue",157,218,"--ja--",1893,1;
	monster "in_rogue",157,218,"--ja--",1423,1;
	monster "in_rogue",157,218,"--ja--",1420,1;
	end;
}

in_rogue,86,187,0	script	#RG_Test10	139,0,8,{
	if(CHANGE_RG != 12)
		end;
	monster "in_rogue",88,190,"--ja--",1393,1;
	monster "in_rogue",88,187,"--ja--",1393,1;
	monster "in_rogue",88,184,"--ja--",1393,1;
	end;
}

in_rogue,225,187,0	script	#RG_Test11	139,0,8,{
	if(CHANGE_RG != 12)
		end;
	monster "in_rogue",232,191,"--ja--",1893,1;
	monster "in_rogue",233,190,"--ja--",1893,1;
	monster "in_rogue",234,189,"--ja--",1893,1;
	end;
}

in_rogue,252,320,0	script	#RG_Test12	139,0,8,{
	if(CHANGE_RG != 12)
		end;
	monster "in_rogue",252,319,"--ja--",1393,1;
	monster "in_rogue",252,321,"--ja--",1393,1;
	monster "in_rogue",252,319,"--ja--",1423,1;
	monster "in_rogue",252,321,"--ja--",1423,1;
	monster "in_rogue",257,320,"--ja--",1420,1;
	monster "in_rogue",248,320,"--ja--",1420,1;
	end;
}

//==============================================================
in_rogue,0,0,0	script	RG_Timer	-1,{
	end;
OnTimer30000:
	killmonster "in_rogue","All";
	//�����G���A���ɒN�����Ȃ��Ȃ�^�C�}�[�~�߂�
	if(getareausers("this",8,98,23,349) + getareausers("this",24,180,241,349) + getareausers("this",242,312,373,327) == 0)
		stopnpctimer;
	else
		initnpctimer;
	end;
}

//==============================================================
in_rogue,370,320,0	script	roguewarp6002	45,1,1,{
	set CHANGE_RG,16;
	warp "in_rogue",378,113;
	end;
}