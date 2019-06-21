//====================================================================
//Ragnarok Online Assassin jobchange script
//
//�@�� CHANGE_AS
//	1	�M�L����
//	2	�M�L�����N���A
//	3	���Z�����P
//	4	���Z�����Q
//	5	�ŏI�����N���A
//
//�@�� $@as_tester$ -> ���Z����҂̃L������
//     @as_step     -> �M���h�}�X�^�[�����p
//====================================================================

//==========================================
// ������t����ѓ]�E
//------------------------------------------

in_moc_16,19,33,4	script	�M���h��	55,{
	if(Upper == UPPER_HIGH) {
		mes "[�E�C�����]";
		mes "�ق��c�c�M�l�́c�c";
		mes "�����Ȃ�ʋC�z�������Ă���ȁB";
		next;
		mes "[�E�C�����]";
		mes "���������������邻�̋C�z�c�c";
		mes "�C�ɐH���ȁB";
		mes "�A��I";
		close;
	}
	if(Job == Job_Thief && SkillPoint) {
		mes "[�E�C�����]";
		mes "�X�L���|�C���g���c���Ă��Ă�";
		mes "�]�E�͂ł��Ȃ��B";
		mes "�F����ė���悤�ɁB";
		close;
	}
	mes "[�E�C�����]";
	mes "��c";
	mes "�������ɗ����H";
	mes "�c�c";
	next;
	if(Job == Job_Novice) {
		mes "[�E�C�����]";
		mes "�����c�m�[�r�X�B";
		mes "�����͋M�l�̂悤�Ȏ҂����ėǂ�";
		mes "�ꏊ�ł͂Ȃ��B��������c";
		close;
	}
	if(getbaseclass(Class) == CLASS_AL) {
		mes "[�E�C�����]";
		mes "�_�Ɏd����҂��������ɗ����H";
		mes "�����ɂ͋M�l�炪���߂�_�͂��Ȃ��B";
		mes "�A�邪�����c";
		close;
	}
	if(Job == Job_Assassin) {
		mes "[�x�e�����A�T�V���E�q���C]";
		mes "����c";
		mes "������ " +strcharinfo(0)+ " ���������c";
		next;
		mes "[�x�e�����A�T�V���E�q���C]";
		mes "�������������A���̓M���h�����";
		mes "�d���̗v���͖����B";
		mes "�C����ς�ł��Ă���B����΂��B";
		close;
	}
	if(Job != Job_Thief) {
		mes "[�E�C�����]";
		mes "�����d���ł������Ă����̂��H";
		mes "�����łȂ���Α��X�ɗ�������c";
		close;
	}
	if(JobLevel < 40) {
		mes "[�E�C�����]";
		mes "����c�M�l�͂܂��C���s�����ȁB";
		mes "�A�T�V���ɂȂ肽���̂Ȃ�A���Ȃ��Ƃ�";
		mes "�V�[�t�Ƃ��Ă̏C����������x�ς�";
		mes "�Ȃ���΂Ȃ�Ȃ��B";
		next;
		mes "[�E�C�����]";
		mes "����ł͂���Ȃ�C����ς��";
		mes "����߂��Ă���̂��c";
		mes "���m�ȓ]�E�����́AJobLv40�ȏ�";
		mes "�ł��邱�ƁB";
		close;
	}
	switch(CHANGE_AS) {
	default:
		mes "[�E�C�����]";
		mes "����c�V�[�t���c";
		mes "�V�[�t�Ƃ��đ����̏C����ς񂾂ȁB";
		mes "�ǂ����H�A�T�V���ɓ]�E��������";
		mes "�Ȃ����H";
		next;
		switch (select("���̂��߂ɗ���","�]�E�����́H","��������")) {
			case 1:
				mes "[�E�C�����]";
				mes "���ށc�v���Ԃ�̋q���B";
				mes "�悵�A��t�ɑ����Ă�낤�B";
				hideoffnpc "�M���h�֌W��#assassin1";
				hideonnpc "�M���h�֌W��#assassin2";
				close2;
				savepoint "in_moc_16",15,12;
				warp "in_moc_16",19,76;
				end;
			case 2:
				mes "[�E�C�����]";
				mes "�]�E�����́c";
				mes "��D�V�[�t�ł��邱��";
				mes "��DJobLv��40�ȏ�ł��邱��";
				mes "�O�D�M���h����̃e�X�g�Ƀp�X���邱��";
				mes "�̎O���B";
				next;
				mes "[�E�C�����]";
				mes "�V�[�t�ł��鐅���ȏ�̏C����";
				mes "�ς񂾎҂Ȃ�A�e�X�g���ȒP��";
				mes "�N���A���邱�Ƃ��\���B";
				close;
			case 3:
				mes "[�E�C�����]";
				mes "�������c�d���Ȃ��c";
				close;
		}
	case 4:
		mes "[�E�C�����]";
		mes "�C�����������c";
		mes "HP��SP���񕜂��Ă��B";
		mes "�͂��o���Ă�����x���킵��B";
		percentheal 100,100;
		next;
		mes "[�E�C�����]";
		mes "�Ƃ���Łc�C�₷��قǂ̂��̂��H";
		mes "���̒���ł��ǂ����c";
		mes "�܂������ł͂Ȃ����H";
		next;
		if(select("���v��","�������c���̋@��ɂ���")==1) {
			mes "[�E�C�����]";
			mes "�ӂށc�������c";
			mes "�撣���Ă݂�B";
			close2;
			warp "in_moc_16",19,76;
		}
		else {
			mes "[�E�C�����]";
			mes "�������c���ł��҂��Ă���B";
			next;
			mes "[�E�C�����]";
			mes "�����c�X�ɖ߂�����Z�[�u��";
			mes "�Y��Ȃ��悤�ɁB";
			mes "����c�c";
			close2;
		}
		set CHANGE_AS,2;
		end;
	case 5:
		if(countitem(1008) < 1) {
			mes "[�x�e�����A�T�V���E�q���C]";
			mes "�ށc�c���𕷂��Ԉ������";
			mes "�u���ȐS�v�������Ă��Ȃ��ȁB";
			next;
			mes "[�x�e�����A�T�V���E�q���C]";
			mes "�ǂ����ŗ��Ƃ��ł��������c�H";
			next;
			mes "[�x�e�����A�T�V���E�q���C]";
			mes "�M���h�}�X�^�[���C�Â��Ȃ�������";
			mes "���������Ă����I";
			next;
			mes "[�x�e�����A�T�V���E�q���C]";
			mes "���������炷���ɖ߂��Ă�����I";
			close;
		}
		if(SkillPoint) {
			mes "[�E�C�����]";
			mes "�X�L���|�C���g���c���Ă��Ă�";
			mes "�]�E�͂ł��Ȃ��B";
			mes "�F����ė���悤�ɁB";
			close;
		}
		mes "[�x�e�����A�T�V���E�q���C]";
		mes "�c���߂łƂ��B���悢��]�E���B";
		mes "���̑O�Ɂc�M���h�}�X�^�[��";
		mes "���߂����̂����Ă݂悤���c";
		next;
		mes "[�x�e�����A�T�V���E�q���C]";
		mes "�c�c�c";
		mes "�c�c";
		mes "�c";
		next;
		delitem 1008,1;
		mes "[�x�e�����A�T�V���E�q���C]";
		mes "���ށA�ǂ��ȁB";
		next;
		nude;
		jobchange Job_Assassin;
		set CHANGE_AS,0;
		mes "[�x�e�����A�T�V���E�q���C]";
		mes "�悵�I�A�T�V���Ƃ��Ă̓�������";
		mes "�����I��Ɏ����̐M�O���т�";
		mes "�����̂����B";
		mes "���܂ɂ͗V�тɂ����B�]�E���j�����B";
		close;
	}
}


//==========================================
// �ꎟ�����i�M�L�����j
//------------------------------------------

in_moc_16,21,91,2	script	�M���h�֌W��#assassin1	730,1,1,{
	end;
OnTouch:
	mes "[�A�T�V���E�J�C]";
	mes "����c�H";
	close2;
	misceffect 16;
	hideonnpc;
	hideoffnpc "�M���h�֌W��#assassin2";
	end;
}

in_moc_16,25,90,2	script	�M���h�֌W��#assassin2	730,2,2,{
	mes "[�A�T�V���E�J�C]";
	mes "�܂��߂��ɗ����B���͐l�̊������";
	mes "�b���悤�ɂ��Ă���B";
	mes "���͊�̌����Ȃ��Ƃ���Řb��";
	mes "�����̂����łˁc";
	mes "���Ɍ�납��b����������̂�";
	mes "�������c";
	close;
OnTouch:
	if(CHANGE_AS != 1) {
		mes "[�A�T�V���E�J�C]";
		mes "�����c�]�E���ɗ����z���c";
		mes "�N�����߂Â��Ɣ�����̂��K����";
		mes "�Ȃ��Ă��Ăˁc";
		mes "�ӂށc�����܂ł���J�������ȁB";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�A�T�V���ւ̓]�E�ɂ���";
		mes "���������̂��H";
		next;
		if(select("������","����")==1) {
			mes "[�A�T�V���E�J�C]";
			mes "�悵�A�����ɓ]�E�\��������낤���B";
			mes "�����̗p���ɖ��O��JobLv��";
			mes "�����悤�ɁB";
		}
		else {
			mes "[�A�T�V���E�J�C]";
			mes "�ӂށc";
			mes "�c�c";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�{���ɁH";
			mes "�c�c";
			next;
			if(select("�͂�","����A�]�E������")==1) {
				mes "[�A�T�V���E�J�C]";
				mes "�Ȃ�o�čs���񂾁B";
				close2;
				warp "moc_fild16",206,229;
				end;
			}
			mes "[�A�T�V���E�J�C]";
			mes "�c�c";
			mes "�c�c��₩����!?";
			mes "�Ƃɂ����c�]�E����񂾂ȁH";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�����̓]�E�\������";
			mes "���O��JobLv�������Ă���B";
		}
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�ǂ�c " +strcharinfo(0)+ " �Ɓc";
		mes "JobLv�� " +JobLevel+ " �c";
		next;
		if(JobLevel >= 50) {
			mes "[�A�T�V���E�J�C]";
			mes "�ȂɁI 50 ���ƁI";
			mes "���O�c�����ȏC����ς񂾂ȁI";
			mes "�v�X�Ɏg����z�������ė�����";
			mes "��w������Ԃ��낤�c";
			mes "���A�Ƃ茾���B���������悤�ɁB";
		}
		else {
			mes "[�A�T�V���E�J�C]";
			mes "�ӂށc�������ȁB";
			mes "�ŋߊF�����������Ăˁc";
			mes "���A�Ƃ茾���B�Y��Ă���B";
		}
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�c�c";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�\�����ւ̍쐬���I��������B";
		mes "�ł͂�������ɁB";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�悵�A�s���B�K�^���F��B";
		close2;
		warp "in_moc_16",19,144;
		misceffect 16;
		hideonnpc;
		hideoffnpc "�M���h�֌W��#assassin1";
		end;
	}
	mes "[�A�T�V���E�J�C]";
	mes "�����c�����͏I��������H";
	next;
	mes "[�A�T�V���E�J�C]";
	mes "��c�M�L�ŗ��������āH";
	mes "�Ղ��c�������c�͂͂͂́I";
	next;
	mes "[�A�T�V���E�J�C]";
	mes "����c�v���Ԃ�ɖʔ���" +(Sex? "�z": "�o����");
	mes "���Ǝv���Ă��c";
	mes "�A�T�V���ɂȂ肽���Ȃ�A���ꂭ�炢";
	mes "�m���Ăē��R���낤�H�������c";
	next;
	mes "[�A�T�V���E�J�C]";
	mes "�c�͕͂͂����ɂ��c";
	next;
	mes "[�A�T�V���E�J�C]";
	mes "�����c�΂��Ă�ꍇ����Ȃ��ȁB";
	mes "�ӂӁc�q���g�ł������悤���H";
	next;
	switch (select("�͂�","�΂��ĂȂ��Ńq���g������","�q���g�Ȃǂ���Ȃ�")) {
	case 1:
		mes "[�A�T�V���E�J�C]";
		mes "�Ձc�͂͂͂͂́I";
		mes "����͂��΂����c";
		mes "�����ɂ��c���܂�΂킹�Ȃ��ł���I";
		next;
		mes "[����������]";
		mes "�c������";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�͂͂́c�����m��Ȃ��҂�";
		mes "�����Ԃ�Ɛ}�X�����ˁc";
		next;
		mes "[����������]";
		mes "�c�c";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�q���g���c";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�c";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�c�c";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�c�c�c�c";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�c�c�c�c�c�c";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�c�c�c�c�c�c�c�c";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�₾�ˁB";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�������c�u�͂��v�����āc";
		close;
	case 2:
		mes "[�A�T�V���E�J�C]";
		mes "�ӂށc�Ȃ�ӂ�\���Ă����Ȃ����c";
		mes "�܂��c�������ɒN�ł��߂��͂������B";
		mes "�΂��Ă��܂�B";
		mes "�����v���C�h�͎̂Ă�Ȃ�B";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�q���g�͏������B";
		mes "�A�T�V���ɂ��āA�ꌾ�񌾘b���B";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "����艴�B�́A�v���C�h������";
		mes "����΂Ȃ�Ȃ��B";
		mes "�u�����̉�v�A�T�V�����Ƃ����ȁB";
		mes "�����͉��B�̏o�Ԃ�����c";
		mes "���͂��̎���҂������B";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�����āc���ɂ͋߂��ɐe�����l�Ԃ�";
		mes "���҂����邪�A���B�͎d���������Ă�";
		mes "�ǓƂŐ�����B";
		mes "�����A�N�̗��l��F�B���Ђǂ��ڂ�";
		mes "�����A�������邱�ƂɂȂ�����c";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�����ĖY��邱�Ƃ͂ł��Ȃ����낤�B";
		mes "���̏d�݂��ꐶ���������Ȃ����";
		mes "�Ȃ�Ȃ��c";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�����₵�����A�Ȃ̓�����ނ̂�����";
		mes "������������Ȃ����낤�c";
		mes "�����ʂ�u�Ȃ̓��v�Ȃ񂾁B";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "���������邱�Ƃ͂��ꂭ�炢���c";
		close;
	case 3:
		mes "[�A�T�V���E�J�C]";
		mes "���ށc";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "���̐��_���B�v���C�h���̂Ă�悤��";
		mes "���Ƃ����Ă͂Ȃ�Ȃ��B";
		mes "���B�͒N���Ȃ�ƌ������ƁA";
		mes "�u�����̉�v�Ƃ��Ẵv���C�h������B";
		mes "�΂��Ă��܂Ȃ��c�����ɘl�т悤�c";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�ŋ߂͂��܂�ɂ��������y��";
		mes "�����Ăˁc�����̎d���Ɋւ���m����";
		mes "�u���Ă����Ƃ��Ă��A�A�T�V���Ƃ��Ă�";
		mes "�v���C�h��A���܂Őh�����ɓw�͂���";
		mes "�L���͂ǂ��ւ����Ă��܂����̂��c";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "�܂������c";
		next;
		mes "[�A�T�V���E�J�C]";
		mes "���񂽂̂ށB�A�T�V���ɂȂ��Ă�";
		mes "�v���C�h�͐�΂Ɏ̂Ă�Ȃ�I";
		next;
		if(select("�c��������","�c����")==2) {
			mes "[�A�T�V���E�J�C]";
			mes "�c���ꂾ�������Ă��킩��Ȃ����H";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�v���C�h����邱�Ƃ�����Ȃ�";
			mes "������ƂȂ̂��H";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "���l�̌C���Ȃ߂錢�ɂȂ�Ƃ����̂��I";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�o�čs���I�������ɂ��I";
			mes "���O�̂悤�ȓz�̓A�T�V���ɂȂ�";
			mes "���i�ȂǂȂ��I";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�����!!!!!";
			close2;
			warp "c_tower4",64,76;
			end;
		}
		mes "[�A�T�V���E�J�C]";
		mes "���ށB���̐Â��ȕԎ��ɁA���ӂ�";
		mes "���߂��Ă���ȁB";
		mes "����ł͂������̃q���g��^����B";
		break;
	}
	next;
	switch(rand(3)) {
		case 0:
			mes "[�A�T�V���E�J�C]";
			mes "�G���_�[�E�B���[�J�[�h���E������A";
			mes "�����ɖ��p�t��ɔ���B";
			mes "�z��͉��B�ɂ͗p�̖������̃J�[�h��";
			mes "�~�����邾�낤�B������INT���グ��";
			mes "���ʂ������Ă������c";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "���B�́A�h��������b����ׂ����B";
			mes "���܂ɁA���ɂ��d�����������āA���E��";
			mes "�ǂ��Ȃ����낤�ɂ��̂܂܏C��������";
			mes "�z������c�B�S��ł��g���Ă����";
			mes "�����̂��c�B�Ƃɂ����w�����݂�����";
			mes "�d�������͂��߂��B";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "��𗦑����X�L�����K������ƁA";
			mes "��i�K�オ�邲�Ƃɉ�𗦂��R";
			mes "�㏸����B";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�O�̂��ߌ������c�J�^�[���n�񕐊�";
			mes "(�W���}�_�n��/�W����/�J�^�[��)��";
			mes "���葕���̕��킾�B";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�����̊X�c���������ˁc";
			mes "�����̋��̃����N�ɍs���Ȃ��Ȃ���";
			mes "�����Ԃ�o������c";
			mes "�V�[�t�������̂�������̂悤�����A";
			mes "�C�������炩�Ȃ�̔N�����߂���";
			mes "�����񂾂ȁc";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "���������ƌ����΁A�V�[�t�̓]�E����";
			mes "�̎��_��̔E�э��݁A�g�̖іԃL�m�R";
			mes "�ƍg�̖уx�g�x�g�L�m�R�𓐂񂾎��c";
			mes "����͂킭�킭�����ȁc";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�����̓n�C�f�B���O��N���[�L���O��";
			mes "���j���Ă���B�����Ƃ��̐G�o��";
			mes "������̋��ꏊ��m��񂾂낤�ȁB";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�o�t�H���b�g�W���j�A�c�z�̃J�[�h";
			mes "���ʂ�AGI+3��CRI+1�̂͂����B";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "���B�A�T�V����AGI����ԗD��Ă��āA";
			mes "�}�X�^�[�����Job���d�l��10��";
			mes "�v���X�����B���ꂾ���������";
			mes "�債�����̂��낤�B";
			break;
		case 1:
			mes "[�A�T�V���E�J�C]";
			mes "�s��������O�[���̋r�̍��́A";
			mes "�O�[���̑����E���Ȃ킿�A���f�b�h";
			mes "���������̂܂܎��B";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "���܂Ŏg���Ă�������͉��Ȃ̂��c";
			mes "�_�}�X�J�X���H�X�e�B���b�g���H";
			mes "�}�C���S�[�V�����H�c";
			mes "������Ȃ���Ύ����̎���悭����";
			mes "���Ƃ��c";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�X���b�g�̑����J�^�[���́A";
			mes "�f�U�[�g�E���t�������Ă���B";
			mes "�悭�o���Ă����B";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�X���b�g�̑����W�����́A";
			mes "�y�̒��Ƀg���l�����@�郂���X�^�[��";
			mes "�����Ă���B";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "���͊^����肾�B";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�n���}�[�����S�u�����́A������";
			mes "�n�����������͂����c�B";
			mes "�n�����͉Α����Ɏア�B";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "���ꂽ����ɂ́A�b�艮�̖��O��";
			mes "�����Ă���B";
			break;
		case 2:
			mes "[�A�T�V���E�J�C]";
			mes "�܂��A�O�����g�D�[�X�̓J�^�[����";
			mes "�����������݂̂Ɏg����X�L�����B";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�|�C�Y���Ƃ������t�́u�Łv�̈Ӗ����B";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�_�u���A�^�b�N�́A���̍U����";
			mes "��x�؂�X�L�����B";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "���b�h�u���b�h�͉Α����ŁA";
			mes "�u���[�W�F���X�g�[���̓A�T�V���ɂ�";
			mes "�֌W�̂Ȃ��΂��B";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�G���_�[�E�B���[�͖��p�t�̂�炪";
			mes "�R�[���h�{���g�œ|���Ă���B";
			mes "�܂萅�����͉Α����ɋ����B";
			mes "�t�ɕ������ɂ͎ア�B";
			next;
			mes "[�A�T�V���E�J�C]";
			mes "�N���[�L���O�͕Ǎہc�܂�P�Z��";
			mes "����Ȃ���ΐl�ڂ𓐂ނ��Ƃ��\���B";
			mes "����X�L�������g���Ȃ���΂ȁB";
			break;
	}
	next;
	mes "[�A�T�V���E�J�C]";
	mes "�ӂ��c����Ȃ�ɑ�ς��ȁc";
	mes "������c";
	next;
	mes "[�A�T�V���E�J�C]";
	mes "�����猾����悤�ȃq���g��";
	mes "����ȂƂ��낾�B";
	mes "�قƂ�ǑS�Ă̖��ɂ��Ęb�������A";
	mes "�c��͂�����{�I�Ȃ��̂�����";
	mes "���v���낤�B�ł́A";
	mes "�u���������ҁv�̎������󂯂Ă����B";
	close2;
	warp "in_moc_16",19,144;
	hideonnpc;
	hideoffnpc "�M���h�֌W��#assassin1";
	end;
OnInit:
	hideonnpc;
	end;
}

//==============================================================
in_moc_16,19,154,0	script	����������	139,8,2,{
	switch(CHANGE_AS) {
	case 0:
		mes "[����������]";
		mes "��c���q���񂩁B";
		mes "�N�X�N�X�c�T���Ă����ʂ���B";
		mes "�{�N�͊��S�Ɏp���B���Ă��邩��ˁB";
		mes "���̒��x�͊�{����H";
		mes "�N�N�c";
		next;
		mes "[����������]";
		mes "����A���̖��O���������Ƃ����Ƃˁc";
		mes "�c�L���n�n�I�L�~�A�]�T���ˁ[�B";
		mes "�p�̌����Ȃ��{�N���|���Ȃ��̂����H";
		mes "�ǂ��Őn���L�~�̔w����_���Ă��邩";
		mes "�킩��Ȃ����Ă̂ɁB";
		next;
		if(select("���낵���c","���̈ʂ̎E�C�Ȃ畽�C����")==1) {
			mes "[����������]";
			mes "�ӂ�A�L�~���܂�Ȃ��z���ȁc";
			next;
			mes "[����������]";
			mes "�܂�Ȃ��z�Ƃ͘b�������Ȃ��ȁB";
		}
		else {
			mes "[����������]";
			mes "�ӂ�c�������B";
			next;
			mes "[����������]";
			mes "�c�c";
			next;
			mes "[����������]";
			mes "�����ˁA�b�𑱂��悤���B";
			next;
			mes "[����������]";
			mes "�{�N�͍��܂ŎE�C���J��Ԃ��Ă����B";
			mes "��͊��S�Ɍ��h���Ă���c";
			next;
			mes "[����������]";
			mes "�{�N�̓M���h�̌��Ƃ��đ��݂���g�B";
			mes "�E�C������̂̓{�N�����ǁA���߂�����";
			mes "�̂̓M���h�B";
			mes "�{�N�͂����̓���ɂ����Ȃ��B";
			mes "�����疼�O�Ȃ�ėv��Ȃ����낤�H";
			next;
			mes "[����������]";
			mes "�N�b�N�b�N�c";
			mes "�Ƃɂ����A���̖͂����z���A�T�V����";
			mes "�Ȃ���Ă��Ƃ��C�ɐH��Ȃ��񂾁B";
			mes "������{�N�ɔF�߂��邭�炢";
			mes "���ɂ������蓚���Ȃ���΂��߂���B";
			next;
			mes "[����������]";
			mes "�ӂӁc����ł͖����o���O��";
			mes "���₪��������󂯂悤���B";
			mes "�m�肽�����Ƃ𕷂��Ă݂ȁH";
		}
		while(1) {
			next;
			switch (select("�X�L���ɂ���","�X�e�[�^�X�ɂ���","�����\����")) {
			case 1:
				mes "[����������]";
				mes "����c�X�L�����c";
				mes "�X�L���̌��ʂ͐��E�̗����";
				mes "����ď������ς�邱�Ƃ����邪";
				mes "��{�I�ȍ\���Ƃ������̂����݂���";
				mes "���狳���Ă����悤���B";
				next;
				mes "[����������]";
				mes "�悸�u�J�^�[���C���v";
				mes "�����ʂ�ÎE�p����̃J�^�[����";
				mes "�g�p���鎞�̍U���͂��オ��B";
				mes "�܂��A�C���x���グ��Ƃ��̍U���͂�";
				mes "�オ���Ă����B";
				next;
				mes "[����������]";
				mes "�u����C���v�u�E��C���v";
				mes "�A�T�V���́A�e��Ɉ�ÂA";
				mes "���킹�ē�{�̕���𑕔�";
				mes "���邱�Ƃ��ł���B";
				mes "�������A�Ў�̎���舵����";
				mes "����Ȃ�A�U���͂��ቺ����B";
				next;
				mes "[����������]";
				mes "���̃X�L���͂���Ȍ��_��";
				mes "�C���ɂ���ĕ₤���߂̂��̂��B";
				mes "�u����C���v�́A�u�E��C���v��";
				mes "�Q���x���܂ŏK������Ίo������";
				mes "�悤�ɂȂ�B";
				next;
				mes "[����������]";
				mes "�u�\�j�b�N�u���[�v";
				mes "�f�����W�A������U�����B";
				mes "�����ȋZ�p��v���A�J�^�[���𑕔�";
				mes "�����ꍇ�݂̂ł���B";
				mes "����́u�J�^�[���C���v��4�i�K�܂�";
				mes "�C������Ίo�����邾�낤�B";
				next;
				mes "[����������]";
				mes "�u�O�����g�D�[�X�v";
				mes "�����Ȃ��G�ɍU�����ꂽ��ǂ����H";
				mes "���̋Z�̓V�[�t�ŏK���ł���u�n�C";
				mes "�f�B���O�v�𗘗p���A�p���B������Ԃ�";
				mes "�G���U�����邱�Ƃ��ł���B";
				next;
				mes "[����������]";
				mes "�C���x�������قǉ����̓G�ɍU��";
				mes "���邱�Ƃ��\���B";
				mes "�����͈͌��ʂ�����A�����̓G��";
				mes "����ɂ��Ȃ���΂Ȃ�Ȃ�����";
				mes "�g���B�����܂ł��u��ނ������v";
				mes "�����ǂȁB";
				next;
				mes "[����������]";
				mes "�A�T�V���ɂ����Ă̊�{�́u�ÎE�v";
				mes "�ł����āA�O�����g�D�[�X�͎p��";
				mes "�������Ƃ��O��ƂȂ�Z�Ȃ�����";
				mes "���Ȃ��Ƃ��u�N���[�L���O�v�C����";
				mes "�Q�K�v���B";
				next;
				mes "[����������]";
				mes "�u�N���[�L���O�v";
				mes "�n�C�f�B���O�̃��x�����Q�ȏ��";
				mes "������K���\�ɂȂ�B";
				mes "���{�N������Ă���悤�ɁA�p��";
				mes "�B�����܂܈ړ����ł���̂��B";
				mes "��ɕǂ̑��ɋ��Ȃ���΂Ȃ�Ȃ����ˁB";
				next;
				mes "[����������]";
				mes "�u�G���`�����g�|�C�Y���v";
				mes "����ɓł�h�肱�ދZ�p���B";
				mes "�ł�h��������͓��R�u�ő����v";
				mes "�������A���̏�ԂōU�������ꍇ";
				mes "���m���ő���͓łɐN�����B";
				next;
				mes "[����������]";
				mes "����Ɂu�x�i���X�v���b�V���[�v��";
				mes "�K������΁A����ɔ�Q��^����";
				mes "���Ƃ��ł��邾�낤�B";
				mes "�p�[�e�B�[�̕���ɂ��ł�h��";
				mes "���Ƃ��ł����B";
				mes "�L���Ɏg���Ă���B";
				next;
				mes "[����������]";
				mes "�u�|�C�Y�����A�N�g�v";
				mes "�ő����U���ɑ΂��āA��x����";
				mes "�����I�ɔ�������X�L�����B";
				mes "�����ɂ����ł͂Ȃ��A���l�ɂ�";
				mes "�g�p���邱�Ƃ��ł���B";
				next;
				mes "[����������]";
				mes "�u�G���`�����g�|�C�Y���v�C����";
				mes "�R�ȏ�ɂȂ�ΏK���\���B";
				next;
				mes "[����������]";
				mes "�u�x�i���_�X�g�v";
				mes "���b�h�W�F���X�g�[���������";
				mes "�w����n�тɓł��U�z����";
				mes "�Z�p���B�C���x�������قǁA";
				mes "�������Ԃ������Ȃ�B";
				next;
				mes "[����������]";
				mes "�u�G���`�����g�|�C�Y���v�C���T";
				mes "���x�����K�v���B";
				next;
				mes "[����������]";
				mes "�u�x�i���X�v���b�V���[�v";
				mes "�G���ŏ�ԂɂȂ��Ă��āA����";
				mes "HP���S����Ԃ���O���̓�";
				mes "�ȉ��Ɍ����Ă��鎞�Ɏg�p�ł��A";
				mes "�g�p����ƈ�莞�ԂőΏۂ�";
				mes "��������B";
				next;
				mes "[����������]";
				mes "���̎��A���ӂɂ��ł��T���U�炵�A";
				mes "�߂��ɋ�����̂̓_���[�W���󂯂�B";
				mes "�K��������A";
				mes "�u�|�C�Y�����A�N�g�v�T�ȏ�A";
				mes "�u�x�i���_�X�g�v�T�ȏ��";
				mes "�K�����K�v�ƂȂ�B";
				next;
				mes "[����������]";
				mes "�ȏオ�A�T�V���X�L���̑S�Ă��B";
				continue;
			case 2:
				mes "[����������]";
				mes "����c�X�e�[�^�X�ˁc";
				mes "�A�T�V���ɂƂ��Ĉ�ԏd�v�Ȕ\�͂�";
				mes "�Ȃ�ƌ����Ă��r�q���c";
				mes "���Ȃ킿AGI���낤�c";
				next;
				mes "[����������]";
				mes "�ÎE���ɓG�ɑ傫�Ȕ�Q��^����ɂ�";
				mes "�u�́v - STR���������邱�Ƃ�";
				mes "�ł��Ȃ����낤�B";
				next;
				mes "[����������]";
				mes "�}�����m���ɓ˂��A�ł������I��";
				mes "�G���d���߂�ɂ́u�N���e�B�J���v��";
				mes "���߂邱�Ƃ����A�u�^�v���Ȃ킿";
				mes "LUK�ɍ��E����邱�Ƃ��傫���B";
				next;
				mes "[����������]";
				mes "��T�ɂǂ�Ȓl�������Ƃ͌����Ȃ���";
				mes "�����͎Q�ƂɂȂ��������H";
				mes "���Ƃ͎����̐g���Ȃ��Ċw��ł���B";
				continue;
			case 3:
				mes "[����������]";
				mes "���Ⴀ�e�X�g���n�߂��B";
				mes "�I���肾�B";
				next;
				mes "[����������]";
				mes "10�⒆ 9��ȏ㐳������΍��i�B";
				mes "�ł��A�ǂ��ŊԈ�������͋����Ȃ��B";
				next;
				mes "[����������]";
				mes "�ӂӁc�n�߂��c";
				set CHANGE_AS,1;
			}
			break;	//while��������
		}
		break;	//�ŏ���switch��������
	case 1:
		mes "[����������]";
		mes "�ӂӁc�܂��������������̂����H";
		next;
		mes "[����������]";
		mes "��قǕ��a�ň��肵����炵��";
		mes "���Ȃ悤���ˁc";
		next;
		mes "[����������]";
		mes "�������i�ł��Ȃ��悤�Ȃ�A";
		mes "�A�T�V���ɂȂ�̂Ȃ��";
		mes "��߂��Ⴂ�ȁI";
		next;
		if(select("���}�ȓD�_�Ő����Ă䂭","�]�E�e�X�g�𑱂��Ă���")==1) {
			mes "[����������]";
			mes "�Ӂc�������ˁB";
			mes "�A�T�V���Ȃǖ������Ⴞ�߂��B";
			mes "��ɌǓƂȐ��E�𖡂키���Ƃ�";
			mes "�Ȃ邩��ˁB";
			next;
			mes "[����������]";
			mes "���A�O�ɂł悤�B";
			mes "�����č����ɕ�����������";
			mes "�A���Ăˁc";
			close2;
			warp "moc_fild16",206,241;
			end;
		}
		mes "[����������]";
		mes "�N�N�N�c";
		mes "���̌ǓƂȗ��A�{�N����������";
		mes "���Ă����B�n�ɉ�����鎞�܂łˁB";
		next;
		mes "[����������]";
		mes "���Ⴀ�e�X�g���n�߂��B";
		mes "�I���肾�B";
		next;
		mes "[����������]";
		mes "10�⒆ 9��ȏ㐳������΍��i�B";
		mes "�ł��A�ǂ��ŊԈ�������͋����Ȃ��B";
		next;
		mes "[����������]";
		mes "���x�������i����悤�ɁB";
		break;
	default:
		mes "[����������]";
		mes "�N�b�N�b�N�c";
		close;
	}
	//�M�L������������
	next;
	switch(rand(3)) {
	case 0:
		mes "[����������]";
		mes "1. �V�[�t�̉�𗦑����X�L����";
		mes "�ő�܂ŏC���������̑������l�́H";
		next;
		if(select("30","40","160","20")==1)
			set .@point,.@point+10;
		mes "[����������]";
		mes "2. ���̒��ŁA�n�C�f�B���O��";
		mes "���j�郂���X�^�[�́H";
		next;
		if(select("���[���e�[��","�A���h��","�}�~�[","�\���W���[�X�P���g��")==2)
			set .@point,.@point+10;
		mes "[����������]";
		mes "3. �A�T�V���̓񓁗���";
		mes "�������邱�Ƃ��ł��Ȃ��g�ݍ��킹�́H";
		next;
		if(select("�}�C���S�[�V�� + �O���f�B�E�X","�X�e�B���b�g + �}�C���S�[�V��","�J�^�[�� + �}�C���S�[�V��","�_�}�X�J�X + �X�e�B���b�g")==3)
			set .@point,.@point+10;
		mes "[����������]";
		mes "4. �V�[�t�]�E���Ɉ�ԋ߂��X�́H";
		next;
		if(select("�v�����e��","���e�B�G","�A���x���^","�����N")==4)
			set .@point,.@point+10;
		mes "[����������]";
		mes "5. AGI�Ɗ֌W�Ȃ��J�[�h�́H";
		next;
		if(select("�o�t�H���b�g�W���j�A�J�[�h","�E�B�X�p�[�J�[�h","����峃J�[�h","�Y��峃J�[�h")==2)
			set .@point,.@point+10;
		mes "[����������]";
		mes "6. �A�T�V�������̐E�Ƃ��";
		mes "�����Ă���_���q�ׂ�B";
		next;
		if(select("�����ꂽ�̏���","�����ꂽ���Z��","�����ꂽ�_���X��","�����ꂽ����")==4)
			set .@point,.@point+10;
		mes "[����������]";
		mes "7. JobLv50�̎��A�A�T�V����";
		mes "����AGI���d�l�́H";
		next;
		if(select("7","8","9","10")==4)
			set .@point,.@point+10;
		mes "[����������]";
		mes "8. �A�T�V���������ł��Ȃ�";
		mes "�A�C�e���́H";
		next;
		if(select("�V���N���[�u","�w����","�u�[�c","�u���[�`")==2)
			set .@point,.@point+10;
		mes "[����������]";
		mes "9. �m�[�r�X���V�[�t��";
		mes "�]�E����ەK�v�Ȃ��̂��́H";
		next;
		if(select("�g�̖уx�g�x�g�L�m�R","�Ԗуx�g�x�g�L�m�R","�g�̖іԃL�m�R","��уV�C�^�P")==3)
			set .@point,.@point+10;
		mes "[����������]";
		mes "10. ��r�I�A�T�V���ɂ�";
		mes "�֌W�̂Ȃ��J�[�h�́H";
		next;
		if(select("�E�B�X�p�[�J�[�h","�G���_�[�E�B���[�J�[�h","�\���W���[�X�P���g���J�[�h","�R�{���h�J�[�h")==2)
			set .@point,.@point+10;
		break;
	case 1:
		mes "[����������]";
		mes "1. �X���b�g�̑����J�^�[����";
		mes "�ǂ̃����X�^�[�����ɓ��邩�B";
		next;
		if(select("���","�y�R�y�R","�f�U�[�g�E���t","�݊�R�{���h")==3)
			set .@point,.@point+10;
		mes "[����������]";
		mes "2. �X���b�g�̑����W������";
		mes "�ǂ̃����X�^�[�����ɓ��邩�B";
		next;
		if(select("�}�[�e�B��","�f�U�[�g�E���t","�}���I�l�b�g","�~�X�g")==1)
			set .@point,.@point+10;
		mes "[����������]";
		mes "3. ��������𐻑����邱�Ƃ�";
		mes "�ł���E�Ƃ́H";
		next;
		if(select("���l","�u���b�N�X�~�X","�V�[�t","�v���[�X�g")==2)
			set .@point,.@point+10;
		mes "[����������]";
		mes "4. ���̒��ŃJ�^�[���n�ł͂Ȃ�";
		mes "����́H";
		next;
		if(select("�W���}�_�n��","�W����","�J�^�[��","�O���f�B�E�X")==4)
			set .@point,.@point+10;
		mes "[����������]";
		mes "5. �C�Y���[�h�_���W������";
		mes "�啔���̃����X�^�[�̑����́H";
		next;
		if(select("������","�Α���","������","�n����")==1)
			set .@point,.@point+10;
		mes "[����������]";
		mes "6. ���̒��ŃL���[�y�b�g�ɂ���";
		mes "���Ƃ��ł��Ȃ������X�^�[�́H";
		next;
		if(select("�|�|����","���b�_�t���b�O","�X���[�L�[","�|�C�Y���X�|�A")==2)
			set .@point,.@point+10;
		mes "[����������]";
		mes "7. �Α����Z�����ł����ʓI��";
		mes "�����X�^�[��I�ׁB";
		next;
		if(select("�Z���S�u����","���C�X�S�u����","���S�u����","�n���}�[�S�u����")==4)
			set .@point,.@point+10;
		mes "[����������]";
		mes "8. ���̒��Ŗ�������";
		mes "�J�^�[����I�тȂ����B";
		next;
		if(select("�����̃J�^�[��","����Ă邢�΂�̃J�^�[��","�f�X�i�C�t","���؂��")==4)
			set .@point,.@point+10;
		mes "[����������]";
		mes "9. �푰�̈Ⴄ�����X�^�[��I�ׁB";
		next;
		if(select("�|����","�}�X�^�[�����O","�S�[�X�g�����O","�X�|�A")==3)
			set .@point,.@point+10;
		mes "[����������]";
		mes "10. ���̒��ŃA���f�b�h�ł͂Ȃ�";
		mes "�����X�^�[�͂ǂꂩ�B";
		next;
		if(select("�h���C�N","���K���h��","�X�|�A","�J�[���b�c�o�[�O")==3)
			set .@point,.@point+10;
		break;
	case 2:
		mes "[����������]";
		mes "1. �O�����g�D�[�X���K������̂�";
		mes "�K�v�łȂ��X�L���́H";
		next;
		if(select("�N���[�L���O Lv 2","�\�j�b�N�u���[ Lv 5","�J�^�[���C�� Lv 4","�E��C�� Lv 2")==4)
			set .@point,.@point+10;
		mes "[����������]";
		mes "2. �G���`�����g�|�C�Y���́A�����";
		mes "������������X�L�����B";
		mes "���̒����炻�̑�����I�ׁB";
		next;
		if(select("�ő���","�n����","�ő���","������")==1)
			set .@point,.@point+10;
		mes "[����������]";
		mes "3. �E��C��Lv4�̌��ʂ́H";
		next;
		if(select("���~�����U���͂� 80% ��","���~�����U���͂� 90% ��","�U���͂� 90% ����","�U���͂� 108% ����")==2)
			set .@point,.@point+10;
		mes "[����������]";
		mes "4. �x�i���_�X�g�ɕK�v��";
		mes "�A�C�e���́H";
		next;
		if(select("���b�h�u���b�h","�u���[�W�F���X�g�[��","�C�G���[�W�F���X�g�[��","���b�h�W�F���X�g�[��")==4)
			set .@point,.@point+10;
		mes "[����������]";
		mes "5. �G���`�����g�|�C�Y��Lv5�܂�";
		mes "�C������ƏK�����\�ɂȂ�X�L���́H";
		next;
		if(select("�C���x�i��","�\�j�b�N�u���[","�x�i���X�v���b�V���[","�x�i���_�X�g")==4)
			set .@point,.@point+10;
		mes "[����������]";
		mes "6. ���̒��Ől�̖ڂ𓐂��";
		mes "�ړ����邱�Ƃ��ł���X�L���́H";
		next;
		if(select("�n�C�f�B���O","�o�b�N�X�e�b�v","�N���[�L���O","���܂�")==3)
			set .@point,.@point+10;
		mes "[����������]";
		mes "7. �x�i���X�v���b�V���[��";
		mes "�g�p�����łȂ����̂́H";
		next;
		if(select("�Ώۂ��łɂ������Ă��邱��","���b�h�W�F���X�g�[��","�Ώۂ�HP���S�̂�1/3�ȉ�")==1)
			set .@point,.@point+10;
		mes "[����������]";
		mes "8. ���̒��ŁA�o�h���J�[�h";
		mes "(�Α����Ώۂ�20%�ǉ��_���[�W)";
		mes "���h��������ōU�����鎞�A���";
		mes "���ʂ𔭊����郂���X�^�[��I�ׁB";
		next;
		if(select("�X�`�[���`�����`����","�f�r���`","�G���_�[�E�B���[","�o�t�H���b�g")==3)
			set .@point,.@point+10;
		mes "[����������]";
		mes "9. �Z���Ń_�u���A�^�b�N������";
		mes "���鎞�����SP�ʂ́H";
		next;
		if(select("15","0","10","54")==2)
			set .@point,.@point+10;
		mes "[����������]";
		mes "10. �C�Y���[�h�_���W������";
		mes "���ʓI�ȕ���͎��̂����ǂꂩ�B";
		next;
		if(select("�E�B���h�}�C���S�[�V��","�A�C�X�}�C���S�[�V��","�A�[�X�}�C���S�[�V��","�t�@�C�A�}�C���S�[�V��")==1)
			set .@point,.@point+10;
		break;
	}
	mes "[����������]";
	mes "�ǂ��������H���́B";
	next;
	mes "[����������]";
	mes "���āc�_���́c";
	mes .@point+ "�_�c";
	if(.@point < 90) {
		mes "�s���i�B�׋�������Ȃ��ˁB";
		next;
		mes "[����������]";
		mes "����Ȃ���ŃA�T�V���ɂȂ낤��";
		mes "�v�����̂����H";
		mes "�o�����Ă����ŁB";
		next;
		mes "[����������]";
		mes "�]�E�\�����̍쐬��S������";
		mes "�u�J�C�v�ɋ����Ƃ��ˁB";
		close2;
		warp "in_moc_16",19,76;
		end;
	}
	mes "�e�X�g�͍��i���B";
	next;
	mes "[����������]";
	mes "�܂����S����ȁB";
	mes "�e�X�g�͂܂����邩��ˁB";
	mes "���ɓ���Ύ��̃e�X�g��";
	mes "�҂��Ă���B";
	set CHANGE_AS,2;
	close;
}


//==========================================
// �񎟎����i���Z�P�j
//------------------------------------------

in_moc_16,19,162,0	script	�o���J�f�[	139,3,1,{
	switch(CHANGE_AS) {
	case 0:
	case 1:
		mes "[�o���J�f�[]";
		mes "�e�X�g���󂯂Ă��Ȃ����B";
		mes "��{�I�Ȓm���𖳎�����Ƃ́c";
		close2;
		warp "in_moc_16",19,76;
		end;
	case 2:
		mes "[�o���J�f�[]";
		mes strcharinfo(0)+ "�c";
		mes "�M�L�����͂悭�p�X�����c";
		next;
		mes "[�o���J�f�[]";
		mes "����c���̂܂ܓ]�E�����Ă�������";
		mes "�Ƃ��낾���A��{��m�炸�ɐ����Ă���";
		mes "�l�Ԃ����܂�ɂ������Ăˁc";
		next;
		mes "[�o���J�f�[]";
		mes "����莄�B�͎����S�����˂�";
		mes "�Ȃ�Ȃ��B�u�����̉�v�ł���";
		mes "�A�T�V�����Ƃ����ˁc";
		mes "�������B�̎��オ����B";
		mes "����܂ł͂Ђ�����҂�������񂾁c";
		next;
		mes "[�o���J�f�[]";
		mes "�ŋ߂��܂�ɂ����_�̕������z��";
		mes "�����B";
		next;
		mes "[�o���J�f�[]";
		mes "�A�T�V���Ƃ��Ă̎����S��A";
		mes "�̂��Ă������낤��J�͂ǂ���";
		mes "�Y�ꂽ�̂��c";
		next;
		mes "[�o���J�f�[]";
		mes "���������̂��c�c";
		next;
		mes "[�o���J�f�[]";
		mes "�����]�E������A�A�T�V���Ƃ��Ă�";
		mes "�����S��Y��Ă͂Ȃ�Ȃ��B";
		mes "�L�~�̎�ɂ�������ɐ����Ăˁc";
		next;
		mes "[�o���J�f�[]";
		mes "����ł͎����̐������n�߂�B";
		mes "�ÎE�̊�{�͐v���Ȕ��f�B";
		next;
		mes "[�o���J�f�[]";
		mes "���Ȃ킿�A�G�Ɩ����𑦍��ɔ���";
		mes "���Ȃ���΂Ȃ�Ȃ��B";
		mes "����āc";
		next;
		mes "[�o���J�f�[]";
		mes "�����̓��e�͑����̓G�̒���";
		mes "����Ă���";
		mes "�u�]�E�����p���{�v";
		mes "�Ƃ������I��œ|���B";
		next;
		mes "[�o���J�f�[]";
		mes "�u�]�E�����p���{�v�̐��͂U�́B";
		mes "�����p�̓z����������";
		mes "�C������񂾂ȁB";
		mes "�~�X������������܂����߂��炾�B";
		next;
		mes "[�o���J�f�[]";
		mes "�T�����őҋ@���Ă���΁A";
		mes "������ɑ����Ă������B";
		next;
		mes "[�o���J�f�[]";
		mes "�����͈�l���󂯂�̂������B";
		mes "��ɓ������҂�����ꍇ�́A";
		mes "���̎҂̎������I���܂őҋ@";
		mes "���Ă��炤�B�����ˁB";
		close;
	default:
		mes "[�o���J�f�[]";
		mes "���s���Ă����߂�ȁB";
		mes "�܂��c�c�����Ԃ��͎̂��R�����B";
		mes "�ǂ�����H";
		next;
		if(select("�܂����ꂩ�炾","�]�E��������߂�")==1) {
			mes "[�o���J�f�[]";
			mes "�ӂӁc�c";
			mes "������x������";
			mes "�u�]�E�����p���{�v";
			mes "���U�̓|���Ȃ���΂Ȃ�Ȃ��B";
			mes "����ł͌������F��B";
			close;
		}
		mes "[�o���J�f�[]";
		mes "�������B";
		mes "�悭�x��ł��痈�ȁB";
		close2;
		warp "in_moc_16",19,13;
		end;
	}
}

//==============================================================
in_moc_16,21,165,2	script	�]�E�����ē���::AS_ChatRoom	725,{
	end;
OnInit:
	waitingroom "�]�E������T��",10,"AS_ChatRoom::OnStart",1;
	end;
OnStart:
	disablewaitingroomevent;
	getwaitingpcid .@accid;
	if(attachrid(.@accid)) {
		set $@as_tester$,strcharinfo(0);	//����҂̖��O
		set CHANGE_AS,3;
		warp "in_moc_16",66,151;
		donpcevent "AS_Test2nd::OnStart";
	}
	else
		enablewaitingroomevent;
	end;
}

//==============================================================
in_moc_16,0,0,0	script	AS_Test2nd	-1,{
OnStart:
	set .count,6;
	disablenpc "#AS_Warp";
	monster "in_moc_16",62,161,"�]�E�����p���{",1002,1,"AS_Test2nd::OnKillOK"; 
	monster "in_moc_16",85,169,"�]�E�����p���{",1063,1,"AS_Test2nd::OnKillOK";
	monster "in_moc_16",88,152,"�]�E�����p���{",1002,1,"AS_Test2nd::OnKillOK";
	monster "in_moc_16",90,143,"�]�E�����p���{",1113,1,"AS_Test2nd::OnKillOK";
	monster "in_moc_16",74,167,"�]�E�����p���{",1031,1,"AS_Test2nd::OnKillOK";
	monster "in_moc_16",77,173,"�]�E�����p���{",1002,1,"AS_Test2nd::OnKillOK";
	monster "in_moc_16",62,161,"�]�E�����p�����X�^�[",1063,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",85,169,"�]�E�����p�����X�^�[",1031,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",79,174,"���Z�����p���{",1113,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",85,156,"�]�E�����p�����X�^�[",1063,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",74,171,"�]�E���������X�^�[",1002,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",68,173,"�]�E�����p�_�~�[",1113,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",65,158,"�퓬�����p���{",1002,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",60,158,"�]�E�����p���{",1113,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",64,169,"�]�E�����̎��̌��{",1002,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",71,173,"�]�E�������{",1063,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",77,172,"���Z�����p���{",1002,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",76,172,"�]�E�����p�T���v��",1063,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",75,172,"�]�E�����p�����X�^�[",1113,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",67,167,"���Z�����p���{",1063,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",86,170,"�]�E�����p���{",1031,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",86,171,"�]�E���{�p����",1002,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",86,173,"���Z�����p���{",1063,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",85,170,"�퓬���������X�^�[",1031,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",89,156,"���{",1002,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",89,156,"�}�E�����p���{",1113,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",89,156,"�퓬�����p���{",1063,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",89,156,"�������{�E�ҐE",1113,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",89,156,"�]�E�������{",1031,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",83,169,"�C�r���h���C�h",1002,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",63,158,"�h�b�y���Q���K�[",1063,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",63,157,"�]�E�������{",1002,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",64,159,"�퓬�����p���{",1002,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",63,159,"�]�E�����p���{",1063,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",63,159,"�|��]�E�p���{",1002,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",63,159,"���m�]�E�p���{",1002,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",83,148,"�D�_�]�E�p���{",1002,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",82,148,"�A�R���C�g�]�E�p���{",1002,1,"AS_Test2nd::OnKillNG";
	monster "in_moc_16",84,148,"���l�]�E�p���{",1002,1,"AS_Test2nd::OnKillNG";
	initnpctimer;
	end;
OnKillOK:
	set .count,.count-1;
	if(.count) {
		announce "�Ď���: �܂����c�撣��c",9;
		end;
	}
	stopnpctimer;
	announce "�Ď���: �悵�A�悭������c���i���I",9;
	announce "���: ���W 87 137 ���̓]�E��ւ̔����J���܂���",9;
	killmonster "in_moc_16","All";
	enablenpc "#AS_Warp";
	initnpctimer "AS_Test3rd";	//�O�������p�^�C�}�[�n��
	end;
OnKillNG:
	stopnpctimer;
	announce "�Ď���: " +$@as_tester$+ " !! �~�X�������ȁA�߂��Ă����B",9;
	areawarp "in_moc_16",60,136,93,177,"in_moc_16",19,161;
	killmonster "in_moc_16","All";
	enablewaitingroomevent "AS_ChatRoom";
	end;
OnTimer1000:
	announce "�Ď���: �����J�n��",9;
	end;
OnTimer2000:
	announce "�Ď���: �������Ƃ���A�����X�^�[�̖��O���u�]�E�����p���{�v�Ƃ����z������|���I",9;
	end;
OnTimer3000:
	announce "�Ď���: �����̖ړI�́A���v�����m�ɑΏۂ𔻕ʂ��邱�Ƃ��B",9;
	end;
OnTimer4000:
	announce "�Ď���: ����ł́A�������Ԃ��R���^����B���Ԃ̌o�߂͂P�����Ƃɓ`����B",9;
	end;
OnTimer5000:
	announce "�Ď���: �悵�c�X�^�[�g���B�c��R���I",9;
	end;
OnTimer65000:
	announce "�Ď���: �Q�����B�u�]�E�����p���{�v��|���I",9;
	end;
OnTimer125000:
	announce "�Ď���: �c��P���I",9;
	end;
OnTimer180000:
	announce "�Ď���: �����I�� 5 �b�O",9;
	end;
OnTimer181000:
	announce "�Ď���: �����I�� 4 �b�O",9;
	end;
OnTimer182000:
	announce "�Ď���: - 3 -",9;
	end;
OnTimer183000:
	announce "�Ď���: - 2 -",9;
	end;
OnTimer184000:
	announce "�Ď���: - 1 -",9;
	end;
OnTimer185000:
	announce "�Ď���: �I��",9;
	end;
OnTimer186000:
	announce "�Ď���: ���ԂɂȂ������N���A�ł��Ȃ��������c�B�܂����撣��B",9;
	areawarp "in_moc_16",60,136,93,177,"in_moc_16",19,161;
	end;
OnTimer189000:
	stopnpctimer;
	killmonster "in_moc_16","All";
	enablewaitingroomevent "AS_ChatRoom";
	end;
}

//==============================================================
in_moc_16,87,137,0	script	#AS_Warp	45,2,1,{
	stopnpctimer "AS_Test2nd";
	warp "in_moc_16",87,102;
	killmonster "in_moc_16","All";
	enablewaitingroomevent "AS_ChatRoom";
	end;
}

//==============================================================
in_moc_16,68,158,0	script	#AS_Abyss	139,0,0,{
	announce "�Ď���: " +$@as_tester$+ "�l�A���Ƃ����ɗ����܂����B",9;
	warp "in_moc_16",19,161;
	stopnpctimer "AS_Test2nd";
	killmonster "in_moc_16","All";
	enablewaitingroomevent "AS_ChatRoom";
	end;
}

in_moc_16,68,159,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,69,158,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,69,159,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,64,162,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,64,163,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,65,162,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,65,163,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,62,168,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,62,169,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,63,168,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,63,169,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,66,170,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,66,171,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,67,170,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,67,171,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,64,174,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,64,175,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,65,174,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,65,175,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,72,174,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,72,175,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,73,174,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,73,175,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,72,167,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,1
in_moc_16,73,167,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,1
in_moc_16,72,169,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,73,169,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,78,168,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,78,169,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,79,168,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,79,169,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,81,172,0		duplicate(#AS_Abyss)	���Ƃ���	139,1,0
in_moc_16,81,173,0		duplicate(#AS_Abyss)	���Ƃ���	139,1,0
in_moc_16,83,172,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,83,173,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,88,174,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,88,175,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,89,174,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,89,175,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,86,166,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,86,167,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,87,166,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,87,167,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,90,164,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,90,165,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,91,164,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,91,165,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,86,160,0		duplicate(#AS_Abyss)	���Ƃ���	139,2,0
in_moc_16,86,161,0		duplicate(#AS_Abyss)	���Ƃ���	139,2,0
in_moc_16,89,160,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,89,161,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,86,154,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,86,155,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,87,154,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,87,155,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,84,150,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,84,151,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,85,150,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,85,151,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,90,150,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,90,151,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,91,150,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,91,151,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0

in_moc_16,86,146,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,86,147,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,87,146,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0
in_moc_16,87,147,0		duplicate(#AS_Abyss)	���Ƃ���	139,0,0


//==========================================
// �O�������i���Z�Q�j
//------------------------------------------

in_moc_16,89,98,2	script	�_���e	118,5,1,{
	end;
OnTouch:
	if(CHANGE_AS != 4) {
		mes "[�_���e]";
		mes "���͂��̎��������Ă���";
		mes "�u�_���e�v�Ƃ����B";
		mes "���̎����Ō���̂́A���O��";
		mes "���\�͂��B";
		next;
		mes "[�_���e]";
		mes "�n�C�f�B���O��K�x�Ɏg��";
		mes "���Ƃ�������Ă���B";
		next;
		mes "[�_���e]";
		mes "�ړI�͔��Α��̓����́u�o���J�f�[�v";
		mes "�̂Ƃ���ɍs�����ƁB";
		mes "�����̃����X�^�[�̊Ԃ𔲂��āA";
		mes "���������܂ōs���񂾁B";
		mes "�|�����ɂȁB";
		next;
		mes "[�_���e]";
		mes "�r���ŋC����������A�����o�����ꍇ��";
		mes "�����֖߂��Ă��邱�ƂɂȂ�B";
		mes "����ł͊J�n���B�������F��B";
		set CHANGE_AS,4;
		donpcevent "AS_Test3rd::OnStart";
		close;
	}
	mes "[�_���e]";
	mes "����c�C���������݂������ȁB";
	mes "�悵�A�񕜂��Ă��B";
	percentheal 100,100;
	next;
	mes "[�_���e]";
	mes "�������A�C�������قǂ̂��̂��H";
	mes "�܂��]�E�����݂�̂͂������A";
	mes "�����Ȃ悤�Ȃ獡�̂����Ɍ����Ă���B";
	next;
	if(select("�Ē��킾","�܂������Ȃ悤���c")==1) {
		mes "[�_���e]";
		mes "�������撣���Ă���B";
		mes "�o���J�f�[�͋߂��ɂ���͂����B";
		close;
	}
	mes "[�_���e]";
	mes "�������c����ł͂܂����̋@��ɁB";
	next;
	mes "[�_���e]";
	mes "�X�ɋA������L�^����̂�";
	mes "�Y��Ȃ��悤�ɁB";
	close2;
	stopnpctimer "AS_Test3rd";
	set CHANGE_AS,2;
	announce "�_���e: " +$@as_tester$+ "���]�E��������߂��B���̎ғ���Ȃ����B",9;
	warp "in_moc_16",18,14;
	killmonster "in_moc_16","All";
	enablewaitingroomevent "AS_ChatRoom";
	end;
}

//==============================================================
in_moc_16,0,0,0	script	AS_Test3rd	-1,{
OnStart:
	monster "in_moc_16",81,77,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",82,77,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",83,77,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",84,77,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",85,77,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",86,77,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",87,77,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",88,77,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",89,77,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",90,77,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",75,56,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",77,56,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",79,56,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",81,56,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",83,56,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",85,56,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",90,56,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",92,56,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",94,56,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",96,56,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",98,56,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",100,56,"�}�~�[",1041,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",76,62,"�q�h��",1068,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",76,65,"�q�h��",1068,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",79,62,"�q�h��",1068,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",79,65,"�q�h��",1068,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",96,62,"�q�h��",1068,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",96,65,"�q�h��",1068,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",99,62,"�q�h��",1068,1,"AS_Test3rd::OnKilled";
	monster "in_moc_16",99,65,"�q�h��",1068,1,"AS_Test3rd::OnKilled";
	end;
OnKilled:
	announce "�_���e: �����X�^�[��|���Ă��܂�����",9;
	announce "�_���e: �ŏ������蒼�����B",9;
	areawarp "in_moc_16",64,46,111,105,"in_moc_16",87,102;
	killmonster "in_moc_16","All";
	enablewaitingroomevent "AS_ChatRoom";
	end;
OnTimer240000:
	stopnpctimer;
	areawarp "in_moc_16",60,136,93,177,"in_moc_16",19,161;
	areawarp "in_moc_16",64,46,111,105,"in_moc_16",19,161;
	killmonster "in_moc_16","All";
	enablewaitingroomevent "AS_ChatRoom";
	end;
}

//==============================================================
in_moc_16,87,48,1	script	�o���J�f�[	725,2,2,{
	end;
OnTouch:
	killmonster "in_moc_16","All";
	mes "[�o���J�f�[]";
	mes "�悵�A�����ȁI";
	mes "���悢��ŏI�������B";
	close2;
	stopnpctimer "AS_Test3rd";
	set @as_step,0;
	warp "in_moc_16",181,183;
	enablewaitingroomevent "AS_ChatRoom";
	end;
}


//==========================================
// �ŏI����
//------------------------------------------

in_moc_16,182,169,0	script	#���	45,1,1,{
	if(@as_step < 2) {
		set @as_step,@as_step+1;
		warp "in_moc_16",181,183;
		end;
	}
	announce "���: " +strcharinfo(0)+ "�l���M���h�}�X�^�[�̕����ɓ���܂���",9;
	hideonnpc "�q���C#AS";
	hideonnpc "�J�C#AS";
	hideonnpc "����������#AS";
	hideonnpc "�o���J�f�[#AS";
	hideonnpc "�Ď���#AS";
	hideonnpc "�_���e#AS";
	hideonnpc "�⍲���}���r�b�c#AS";
	savepoint "in_moc_16",167,110;
	warp "SavePoint",0,0;
	end;
}

//==============================================================
in_moc_16,167,110,0	script	�A�T�V�����{�ē�	139,3,1,{
	mes "[�M���h�}�X�^�[]";
	mes "�ӂށc�悭�����ȁB";
	mes "�����́u�M���h�}�X�^�[�̕����v";
	mes "�A�T�V���M���h�̍Ő[�����B";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "���̋��ꏊ���킩��Ȃ��悤�ɖ��{��";
	mes "�Ȃ��Ă���B";
	mes "�����Ď����ɂ��Ă����c";
	mes "���̏��܂ŗ��Ăق����B";
	mes "���܂ɐN���҂����邽�߂��̂悤��";
	mes "����ɂ����B";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "����ł͂܂���ŉ���c";
	close;
}

in_moc_16,170,90,0	script	�A�T�V�����{�ē�#AS	139,1,1,{
	mes "[�M���h�}�X�^�[]";
	mes "�����͓���g�񂾓����c";
	mes "����i�ނ悤�ɁB";
	close;
}

in_moc_16,160,85,0	duplicate(�A�T�V�����{�ē�#AS)	�A�T�V�����{�ē�	139,1,1

in_moc_16,180,101,0	script	�A�T�V�����{�ē�	139,1,1,{
	mes "[�M���h�}�X�^�[]";
	mes "�������ł͂Ȃ��Ǝv�����c";
	close;
}

in_moc_16,186,107,0	script	�A�T�V�����{�ē�	139,1,1,{
	mes "[�M���h�}�X�^�[]";
	mes "�������ł͂Ȃ��Ǝv�����c";
	close;
}

in_moc_16,149,95,0	script	�A�T�V�����{�ē�	139,1,1,{
	mes "[�M���h�}�X�^�[]";
	mes "���ށA���������̓��؂�";
	mes "���������悤���ȁB";
	close;
}

in_moc_16,149,95,0	script	�A�T�V�����{�ē�	139,0,0,{
	mes "[�M���h�}�X�^�[]";
	mes "�����ԋ߂Â����ȁB";
	mes "���O�̋C�z���������邼�B";
	close;
}

in_moc_16,175,89,0	script	�A�T�V�����{�ē�	139,1,1,{
	mes "[�M���h�}�X�^�[]";
	mes "�����͕⍲���̏��ɒʂ���B";
	mes "�����⍲���ɗp�ł�����̂��H";
	close;
}

in_moc_16,153,85,0	script	�A�T�V�����{�ē�	139,1,1,{
	mes "[�M���h�}�X�^�[]";
	mes "�����͓���g�񂾓����c";
	mes "�����߂�Ηǂ��B";
	mes "���Ŏז����ꂽ��������A";
	mes "��肱��Ői�ނ悤�ɁB";
	close;
}

//==============================================================
in_moc_16,186,81,0	script	�M���h�}�X�^�[�⍲��	55,{
	mes "[�⍲���}���r�b�c]";
	mes "���͓]�E�����ɂ͊ւ�肪";
	mes "����܂���B";
	mes "�]�E�ɂ��Ă͂�����ɂ���������";
	mes "�M���h�}�X�^�[�l�ɂ��˗����������B";
	close;
}

//==============================================================
in_moc_16,149,80,4	script	�M���h�}�X�^�[	106,1,1,{
	end;
OnTouch:
	mes "[�M���h�}�X�^�[]";
	mes "�ǂ������B�������G�ŋ�J���������ȁB";
	mes "��قǕ񍐏����オ���Ă������A";
	mes "�Ȃ��Ȃ�����������V�[�t���������ȁB";
	mes "���O�̂悤�ɒb�������ꂽ�z��";
	mes "�������y���݂��B";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "���āA���ꂩ�炢������������邪";
	mes "���O�����i�l���Ă���悤�ɓ�����";
	mes "�����Ηǂ�����A�y�ɂ��Ă���B";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "�܂��c�A�T�V���ɏd�v�Ȃ��Ƃ͉����H";
	next;
	switch (select("��苭����","�v���C�h(�����S)","�₦�Ԗ����C��")) {
	case 1:
		mes "[�M���h�}�X�^�[]";
		mes "��苭���͂Ƃ����΁c�m����";
		mes "�V�[�t�ɔ�׃A�T�V���͋����ƌ�����B";
		next;
		mes "[�M���h�}�X�^�[]";
		mes "�������A���̋����͉��̂��߂�";
		mes "�K�v�Ȃ̂��H�Ⴆ�Ε��Q�̂��߂��c";
		mes "����Ƃ����̉����̂��߂��H";
		next;
		mes "[�M���h�}�X�^�[]";
		mes "�A�T�V���̗͂���ɓ��ꂽ��";
		mes "�ǂ�ȗ������邾�낤���H";
		next;
		switch (select("���Q���ʂ�����","���ׂ������₷���Ȃ�","��葽���̏ꏊ�ɍs����")) {
			case 1:
				mes "[�M���h�}�X�^�[]";
				mes "���Q���c";
				mes "�����c��X�̂����Ă��͍���";
				mes "�Ƃ������̂������Ă���B";
				next;
				mes "[�M���h�}�X�^�[]";
				mes "��������X�͊���ɍ��E����邱�ƂȂ�";
				mes "�����ɉۂ���ꂽ�C���𒉎��ɐ��s";
				mes "���Ȃ���΂Ȃ�Ȃ��B";
				next;
				mes "[�M���h�}�X�^�[]";
				mes "�A�T�V���ɂȂ肽���Ί�����������Ƃ��B";
				break;
			case 2:
				mes "[�M���h�}�X�^�[]";
				mes "�c�������ɐ����Ă����ɂ͋����K�v";
				mes "�����c����̓A�T�V���Ƃ��Ă�";
				mes "�������ɖ]�ނׂ����̂ł͂Ȃ��B";
				break;
			case 3:
				mes "[�M���h�}�X�^�[]";
				mes "�ǂ��l�����B�F�X�ȏꏊ���o���A";
				mes "�ώ@���邱�Ƃ͔C���̐��������";
				mes "���߂邱�ƂɂȂ�B";
				next;
				mes "[�M���h�}�X�^�[]";
				mes "�������A�����璇�ԒB�ƂƂ͂����A";
				mes "�吨�ŗ�������悤�Ȃ��Ƃ͍T����";
				mes "�ق����B�ڗ����Ƃ͔����Ȃ����";
				mes "�Ȃ�Ȃ����炾�c";
				break;
		}
		break;
	case 2:
		mes "[�M���h�}�X�^�[]";
		mes "�v���C�h���c";
		mes "�����̎҂����������Ă������H";
		next;
		mes "[�M���h�}�X�^�[]";
		mes "�ӂ�c����͂ǂ����������������Ă��H";
		mes "���O���A�T�V���̉��Ɏ䂩�ꂽ����";
		mes "�m��Ȃ����c";
		next;
		mes "[�M���h�}�X�^�[]";
		mes "�z��̑啔���́A���鎞����";
		mes "�傫�ȋ�J�����ɂ��Ă����B";
		mes "������悭�킩��B";
		mes "�ł́A���O�ɂ͂Ȃ��v���C�h��";
		mes "�K�v�Ȃ̂��H";
		next;
		switch (select("��l�Ő�����ɂ͕K�v","���ׂ��̂��߂ɕK�v","�����ڂ��ǂ�����")) {
			case 1:
				mes "[�M���h�}�X�^�[]";
				mes "�����c��X�͌ǓƂȑ��݁c";
				mes "�ǂ��ɍ݂��Ă���Ɉ�l���B";
				next;
				mes "[�M���h�}�X�^�[]";
				mes "�������A��X�ɂ����ԂƂ������̂�";
				mes "����B���܂�[�����ꍞ�݉߂����";
				mes "�댯���܂Ƃ������A�ǂ��p�[�g�i�[";
				mes "������ΖړI�̒B������肽�₷��";
				mes "�Ȃ邾�낤�c";
				break;
			case 2:
				mes "[�M���h�}�X�^�[]";
				mes "�c�������ɐ����Ă����ɂ͋����K�v";
				mes "�����c����̓A�T�V���Ƃ��Ă�";
				mes "�������ɖ]�ނׂ����̂ł͂Ȃ��B";
				break;
			case 3:
				mes "[�M���h�}�X�^�[]";
				mes "�������ɂ�����邠�܂���̂�";
				mes "�{�������������c";
				mes "����Ȑ��_�̎ア�҂̓A�T�V��";
				mes "�Ƃ��Ăӂ��킵���Ȃ��B";
				break;
		}
		break;
	case 3:
		mes "[�M���h�}�X�^�[]";
		mes "�C�����c";
		mes "���O�͂��łɗ��h�ȃV�[�t��";
		mes "�����邪�A�������ďC����ςޗ��R��";
		mes "�����H";
		next;
		mes "[�M���h�}�X�^�[]";
		mes "�V�[�t�Ȃ炢�����炸�A�A�T�V����";
		mes "�Ȃ𗥂��Ď��ɐT�񂾍s�������˂�";
		mes "�Ȃ�Ȃ��B���܂ɁA�͂ɑ΂���~�]��";
		mes "�����A�����𐧌�ł��Ȃ��Ȃ��҂�";
		mes "����̂��c";
		next;
		mes "[�M���h�}�X�^�[]";
		mes "����ł͍��̉��ɖ����ł�����";
		mes "�C����ςނƂ����̂��H";
		next;
		switch (select("�Z�p","�ڕW","���_")) {
			case 1:
				mes "[�M���h�}�X�^�[]";
				mes "�Z�p�̓A�T�V���ɂȂ�΂�����x";
				mes "�g�ɂ����̂��B���ꎩ�̂�";
				mes "�ō��̉��l������킯�ł͂Ȃ��B";
				mes "�A�T�V���ɂȂ��Ă������ł��邩";
				mes "�킩��ʂ��B";
				break;
			case 2:
				mes "[�M���h�}�X�^�[]";
				mes "�������c�₦���V���ȖڕW���f����";
				mes "�̂͗ǂ����Ƃ��c�������c";
				mes "���̓A�T�V���ɂȂ邱�Ƃň�t�����A";
				mes "�����͕ς�邩������Ȃ����B";
				break;
			case 3:
				mes "[�M���h�}�X�^�[]";
				mes "�������ȁB��ɋ��łȐ��_�����̂�";
				mes "�d�v�Ȃ��Ƃ��B�g�̂Ƌ��ɐ��_�ʂ��b��";
				mes "�Ȃ���A�Ȃ��Ȃ����_�ʂ����߂�̂�";
				mes "����̂��B";
				next;
				mes "[�M���h�}�X�^�[]";
				mes "�A�T�V���Ƃ����E�Ƃ́A�Z�����ł͂Ȃ�";
				mes "���_�����ɕۂ��˂΂Ȃ�Ȃ��B";
				mes "����ł����̓������Z�p��]�����ƂȂ�";
				mes "�����ł��邩��ȁB";
				break;
		}
		break;
	}
	next;
	mes "[�M���h�}�X�^�[]";
	mes "���O�͂悭�l���Ă���ȁB";
	mes "���ɂ͉����l�����ɃA�T�V����";
	mes "�Ȃ낤�Ƃ����z�������łȁc";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "�����������z�炪�����N����";
	mes "��X�M���h�̊�ɓD��h��B";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "����͂��O�������邱�Ƃ����A";
	mes "��x�A�T�V���ɂȂ������x��";
	mes "�V�[�t�ɖ߂邱�Ƃ͂ł��Ȃ��B";
	mes "�A�T�V���Ƃ��Ă̋`���ƐӔC��";
	mes "���̌ジ���ƕ����Ă��炤���ƂɂȂ�B";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "���ꂩ��A�T�V���ɂȂ�����";
	mes "�܂��������邩�H";
	next;
	switch (select("�����ɐ퓬������","����҂l�X�̂Ƃ����","�A�T�V���ɂ��Ē��ׂ�")) {
	case 1:
		mes "[�M���h�}�X�^�[]";
		mes "�퓬���ƁH����ŁH";
		next;
		switch (select("��������������","�A�T�V���Ƃ��Ă̎����̋Z������","�V�[�t�ł͍s���ɂ����ꏊ�ɍs��")) {
			case 1:
				mes "[�M���h�}�X�^�[]";
				mes "���܂萬�����ł�Ɗ�b���ɂ݁A";
				mes "���ɐ��_�ʂ̏C�����a���ɂȂ�";
				mes "���낤�B��b���ł��Ă��Ȃ��ƙ�l��";
				mes "���Ԃɔ������x��邱�Ƃ�����B";
				mes "��u�̔��f�������ɂȂ�A�T�V��";
				mes "������b���ł߂�ׂ����B";
				break;
			case 2:
				mes "[�M���h�}�X�^�[]";
				mes "�����������̂͗ǂ����Ƃ��B";
				mes "�i�����������̔\�͂������̂�";
				mes "�ǂ����Ƃ����A�A�T�V���Ƃ��Ă�";
				mes "�S�\���͖Y���Ȃ�B";
				break;
			case 3:
				mes "[�M���h�}�X�^�[]";
				mes "�ǂ����Ƃ��B�V���Ȓn�֕�����";
				mes "�܂��V���Ȕ��������邾�낤�B";
				mes "�������A�A�T�V���ɂȂ��Ă�����";
				mes "�l�Ԃ̖{�����ς��Ƃ͌���Ȃ��B";
				next;
				mes "[�M���h�}�X�^�[]";
				mes "���߂͂��܂薳���������A��������";
				mes "�s���͈͂��L����̂��ǂ����낤�B";
				break;
		}
		break;
	case 2:
		mes "[�M���h�}�X�^�[]";
		mes "�N���҂��Ă���̂��H";
		next;
		switch (select("���ԒB��","�M���h���B��","���l��")) {
			case 1:
				mes "[�M���h�}�X�^�[]";
				mes "�������B�ނ�����O�̂��Ƃ�";
				mes "�䂪���̂悤�Ɋ�Ԃ��낤�B";
				mes "�ǓƂ̒��ł����Ԃ��v���S��";
				mes "�Y���Ȃ�B";
				break;
			case 2:
				mes "[�M���h�}�X�^�[]";
				mes "���������ɂ��钇�Ԃ��c�ǂ��ȁB";
				mes "�A�T�V���Ƃ��āA���Ԃ̉e�ƂȂ�";
				mes "�悭�����Ă�邱�Ƃ��B";
				break;
			case 3:
				mes "[�M���h�}�X�^�[]";
				mes "������l�̂��߂��ƁH";
				mes (Sex? "��": "�ޏ�")+ "�̉e�ƂȂ�A��Ɍ����Ƃ����̂��c";
				next;
				mes "[�M���h�}�X�^�[]";
				mes "�厖�ɂ��邱�Ƃ��c";
				mes "�����������A���̊Â�����X��";
				mes "�悤�ȐE�ɂ͖����ƂȂ�B";
				mes "���O�̐l�����B�����̖����悤�ɂȁc";
				break;
		}
		break;
	case 3:
		mes "[�M���h�}�X�^�[]";
		mes "�ǂ��p�����B";
		mes "�ǂ�Ȃ��Ƃ𒲂ׂ�H";
		next;
		switch (select("�A�T�V���Ɍ����Ă���ꏊ��","�M���h�̐����ɂ���","�A�T�V���Ŏ������グ����@��")) {
			case 1:
				mes "[�M���h�}�X�^�[]";
				mes "���̐��Ŋy�ȏꏊ�E�h���ꏊ��";
				mes "�������ɑ��݂���B";
				mes "�������A�T�V���Ƃ����̂͂ǂ��";
				mes "�����ł��C���𐋍s���邽�߂�";
				mes "�_��ɑΉ��ł��Ȃ���΂Ȃ�Ȃ��B";
				break;
			case 2:
				mes "[�M���h�}�X�^�[]";
				mes "�O�ɂ͑����̉�X�̒��Ԃ�����B";
				mes "�z�炩��w�Ԃ��Ƃ�����͂����B";
				next;
				mes "[�M���h�}�X�^�[]";
				mes "�����Ă����œ���m���ƌo����";
				mes "���ɓy���n��グ�A�M���h��";
				mes "���W�Ɋ�t���Ăق����B";
				mes "�����Ă��O��������x�̈��";
				mes "�B����΁A�t�ɉ��̎҂̖ʓ|��";
				mes "����@�����͂����B";
				break;
			case 3:
				mes "[�M���h�}�X�^�[]";
				mes "�c�A�T�V���͋��̂��߂�";
				mes "���݂���̂ł͂Ȃ��c";
				mes "���������A�T�V���̐Ӗ��Ƃ���";
				mes "���̂�ǂ��l����ׂ����B";
				break;
		}
		break;
	}
	next;
	mes "[�M���h�}�X�^�[]";
	mes "���O�Ƃ̉�b�͂Ȃ��Ȃ��y���������B";
	mes "�����̂��v���o������c";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "�ӂށc����ł͓z������W���邩�B";
	next;
	announce "�M���h�}�X�^�[: " +strcharinfo(0)+ "�̃A�T�V���]�E�����Ɋւ�����҂͎��̌��W������",9;
	mes "[�M���h�}�X�^�[]";
	mes strcharinfo(0)+ "��";
	mes "�A�T�V���]�E�����Ɋւ�����҂�";
	mes "���̌��W������";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "�����ɗ����I";
	next;
	hideoffnpc "�q���C#AS";
	hideoffnpc "�J�C#AS";
	hideoffnpc "����������#AS";
	hideoffnpc "�o���J�f�[#AS";
	hideoffnpc "�Ď���#AS";
	hideoffnpc "�_���e#AS";
	hideoffnpc "�⍲���}���r�b�c#AS";
	mes "[����������]";
	mes "���Ăтł����H";
	next;
	mes "[�M���h�}�X�^�[]";
	mes strcharinfo(0)+ "�̓]�E������";
	mes "�S�������҂̈ӌ��𕷂������Ăȁc�c";
	mes "�ǂ����H";
	next;
	mes "[����������]";
	mes "�����Ȃ�ǂ��ˁB�N�N�N�c";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "�u���������ҁv���O�͎^�����ȁB";
	mes "�q���C�́H";
	next;
	if(JobLevel >= 50) {
		mes "[�q���C]";
		mes "�ŋߌ������ň�ԍ���������";
		mes "�V�[�t�ł����B";
		next;
		mes "[�q���C]";
		mes "�^���ł��B";
		mes "����ł͎��͂���Ɏ��炵�܂��B";
		mes "�Ȃɖ߂�Ȃ���΂Ȃ�܂���̂Łc";
		mes "���A�}�X�^�[�c���̑���ɉ���";
		mes "�v���[���g�ł��^���Ă���Ă��������B";
		next;
		mes "[�M���h�}�X�^�[]";
		mes "���ށB�񑩂��悤�B";
	}
	else {
		mes "[�q���C]";
		mes "�܂���{�͂ł��Ă܂���B";
		mes "�^���ł��B";
		mes "����ł͂���Ɏ��炵�܂��B";
		mes "�Ȃɖ߂�Ȃ���΂Ȃ�܂���̂Łc";
		next;
		mes "[�M���h�}�X�^�[]";
		mes "���ށA�������Ă���B";
	}
	next;
	mes "[�M���h�}�X�^�[]";
	mes "�ł́u�Ď��ҁv���O�͂ǂ����H";
	next;
	hideonnpc "�q���C#AS";
	mes "[�Ď���]";
	mes "�ꉞ�ʉ߂����̂ō��i�����ł��B";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "���ށA�F�^���̂悤���ȁB";
	mes "�������̎҂ɂ��Ă͋C�ɓ������B";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "�����c�A�T�V���ɂ͌ǓƂƂ���";
	mes "�P�����ꐶ�ۂ�����B";
	mes "�����Ȃ������A�����Ă䂯�B";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "��c�b�������Ȃ����ȁB";
	if(JobLevel >= 50) {
		mes "�����Ɉȉ��̕��킪����B";
		mes "�W���� �J�^�[��";
		mes "�}�C���S�[�V�� �O���f�B�E�X";
		mes "�ȏ�S�Ď������p�������킾�B";
		next;
		switch(select("�W����","�J�^�[��","�}�C���S�[�V��","�O���f�B�E�X")) {
			case 0: getitem 1251,1; break;
			case 1: getitem 1253,1; break;
			case 2: getitem 1208,1; break;
			case 3: getitem 1220,1; break;
		}
		mes "[�M���h�}�X�^�[]";
		mes "��������Ώ\���Ƃ���";
		mes "������������ȁc";

	}
	else {
		mes "�܂��͂�����󂯎��B";
		next;
		switch(rand(4)) {
			case 0: getitem 1207,1; break;
			case 1: getitem 1219,1; break;
			case 2: getitem 1250,1; break;
			case 3: getitem 1252,1; break;
		}
	}
	set CHANGE_AS,5;
	next;
	savepoint "morocc",100,101;
	getitem 1008,1;
	mes "[�M���h�}�X�^�[]";
	mes "�ł́A���i�̈��^���邩��";
	mes "�����̃x�e�����A�T�V���E�q���C��";
	mes "���܂Ŗ߂�B";
	mes "�q���C�����ۂɓ]�E�������Ă����";
	mes "���낤�B";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "������ " +strcharinfo(0)+ " �c";
	mes "�ÎE�҂Ƃ��Ă̓�����܂�Ƃ��c";
	mes "���̐�₵���ǓƂȓ��ɂȂ낤�Ƃ�";
	mes "�Ȃ̈ӎu�����͖Y��ʂ悤�c";
	next;
	mes "[�M���h�}�X�^�[]";
	mes "�悵�A�F�߂��Ă悵�I";
	mes "���O��������܂Ŗ߂��Ă��B";
	hideonnpc "�J�C#AS";
	hideonnpc "����������#AS";
	hideonnpc "�o���J�f�[#AS";
	hideonnpc "�Ď���#AS";
	hideonnpc "�_���e#AS";
	hideonnpc "�⍲���}���r�b�c#AS";
	close2;
	warp "in_moc_16",17,19;
	end;
}

in_moc_16,156,87,2	script	�q���C#AS		55,{}
in_moc_16,156,85,2	script	�J�C#AS			730,{}
in_moc_16,156,83,2	script	����������#AS		106,{}
in_moc_16,156,81,2	script	�o���J�f�[#AS		725,{}
in_moc_16,156,79,2	script	�Ď���#AS		118,{}
in_moc_16,156,77,2	script	�_���e#AS		118,{}
in_moc_16,156,75,2	script	�⍲���}���r�b�c#AS	55,{}