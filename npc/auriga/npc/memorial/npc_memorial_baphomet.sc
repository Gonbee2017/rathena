//= Auriga Script ==============================================================
// Ragnarok Online Sealed Shrine Script	by refis
//- Registry -------------------------------------------------------------------
// BAPHO_1QUE -> 0�`7
//==============================================================================

//============================================================
// ��^�}�W�F�X�e�B�b�N�S�[�g����NPC
//------------------------------------------------------------
prt_monk,261,91,3	script	�u���b�N�n���h	826,{
	mes "[�u���b�N�n���h]";
	mes "�Ȃ񂾂��O�́H";
	mes "�I���ɗp�ł�����̂��H";
	next;
	mes "[�u���b�N�n���h]";
	mes "�C���m�ł��Ȃ����";
	mes "�I���ɗp��������Ă̂��H";
	next;
	if(checkquest2(3043)) {
		mes "[�u���b�N�n���h]";
		mes "�c�c���āA�Ȃ񂾂��O���B";
		mes "�ޗ��͂�����";
		mes "�����Ă����񂾂낤�ȁH";
		next;
		if(countitem(6004) < 1 || countitem(2256) < 1 || countitem(7799) < 30 || countitem(7798) < 50 || Zeny < 990000) {
			mes "[�u���b�N�n���h]";
			mes "�t���c�c�c�c";
			mes "�����ł��ĂȂ��悤���ȁB";
			next;
			mes "[�u���b�N�n���h]";
			mes "������x�ޗ��������Ă��B";
			next;
			mes "[�u���b�N�n���h]";
			mes "^0000FF���ꂽ�o�t�H���b�g�l�`1��^000000�A";
			mes "^0000FF�}�W�F�X�e�B�b�N�S�[�g[0]1��^000000�A";
			mes "^0000FF�ł̌�����30��^000000�A^0000FF�ł̔j��50��^000000";
			mes "�����āI";
			mes "�̐S�Ȑ���^0000FF990,000^000000Zeny���B";
			mes "��������o���Ă����I";
			close;
		}
		mes "[�u���b�N�n���h]";
		mes "�t���c�c�c�c";
		mes "�����ł��Ă���悤���ȁB";
		mes "�񂶂�A�ޗ��������ɂ�����";
		mes "������Ƒ҂��Ă���B";
		next;
		mes "[�u���b�N�n���h]";
		mes "�c�c";
		next;
		mes "[�u���b�N�n���h]";
		mes "�c�c�c�c";
		next;
		mes "[�u���b�N�n���h]";
		mes "�c�c�c�c�c�c";
		misceffect 101;
		next;
		delitem 6004,1;
		delitem 2256,1;
		delitem 7799,30;
		delitem 7798,50;
		set Zeny,Zeny-990000;
		delquest 3043;
		getitem 5374,1;
		mes "[�u���b�N�n���h]";
		mes "�����A����Ŋ������I";
		mes "�n�b�n�b�n�A����Ȃ��Ă�������B";
		mes "�����O�͊������āA";
		mes "�܂𗬂������Ȃقǂ��ꂵ���񂾂�H";
		next;
		mes "[�u���b�N�n���h]";
		mes "�܁A�厖�Ɏg���Ă����B";
		mes "���Ⴀ�ȁI";
		close;
	}
	if(countitem(6004) < 1 || !checkquest2(3042)) {
		mes "[�u���b�N�n���h]";
		mes "�p���Ȃ���Θb������ȁI";
		mes "�I���͏C���m�p�̑�����";
		mes "����Ă�񂾁B";
		mes "�ɂ���ˁ[�񂾂��H";
		mes "����������!?";
		close;
	}
	switch(select("���ꂽ�o�t�H���b�g�l�`�ɂ���","��b����߂�")) {
	case 1:
		mes "[�u���b�N�n���h]";
		mes "�Ȃɂ�!?";
		mes "���̐l�`����ɓ��ꂽ���ƁH";
		mes "�ق��c�c";
		mes "�����͘r�Ɏ��M������悤����˂����B";
		next;
		mes "[�u���b�N�n���h]";
		mes "�킩���Ă�킩���Ă�B";
		mes "���̂������񂩂�l�`�������Ă�����";
		mes "�����ė����̂���H";
		next;
		mes "[�u���b�N�n���h]";
		mes "�������낤�B";
		mes "�������̕s�C���Ȑl�`��";
		mes "�L�Ӌ`�ȕ��ɕς��Ă���B";
		next;
		mes "[�u���b�N�n���h]";
		mes "���̋���Ȋp�����������A";
		mes "�f���炵����������Ă�邩�炳�I";
		mes "�������A�o�t�H���b�g��";
		mes "�p���[�����߂ĂȁB";
		next;
		mes "[�u���b�N�n���h]";
		mes "�ʏ́A^0000FF��^�}�W�F�X�e�B�b�N�S�[�g^000000�B";
		mes "���ʂ̃}�W�F�X�e�B�b�N�S�[�g�Ƃ�";
		mes "�����Ⴄ�I";
		mes "�ō��̑㕨���B";
		next;
		mes "[�u���b�N�n���h]";
		mes "�������邽�߂̍ޗ��̒���";
		mes "��ԑ厖�ȕ�������";
		mes "���ꂽ�o�t�H���b�g�l�`�I";
		mes "�ǂ����H�@����Ăق����̂��H";
		mes "�ޗ����m�肽�����H�@�ǂ�����H";
		next;
		if(select("�~����","����Ȃ�")==2) {
			//������
			mes "[�u���b�N�n���h]";
			mes "�p���Ȃ���Θb������ȁI";
			mes "�I���͏C���m�p�̑�����";
			mes "����Ă�񂾁B";
			mes "�ɂ���ˁ[�񂾂��H";
			mes "����������!?";
			close;
		}
		mes "[�u���b�N�n���h]";
		mes "�t�b�t�b�t�c�c";
		mes "���낤�A����͂����`�����X���B";
		mes "���O�͌����Ȕ��f�������ȁB";
		mes "�ł͍ޗ��������Ă��B";
		next;
		mes "[�u���b�N�n���h]";
		mes "^0000FF���ꂽ�o�t�H���b�g�l�`1��^000000�A";
		mes "^0000FF�}�W�F�X�e�B�b�N�S�[�g[0]1��^000000�A";
		mes "^0000FF�ł̌�����30��^000000�A^0000FF�ł̔j��50��^000000";
		mes "�����āI";
		mes "�̐S�Ȑ���^0000FF990,000^000000Zeny���B";
		mes "��������o���Ă����I";
		next;
		mes "[�u���b�N�n���h]";
		mes "�}�W�F�X�e�B�b�N�S�[�g�́A";
		mes "�v�����e���̖��{�̐X�ɂ���";
		mes "����������̃o�t�H���b�g����";
		mes "��ɓ������B";
		mes "�����Ĉł̌����ƈł̌��Ђ�";
		mes "���������N�̌��g�����ɓ���͂��B";
		next;
		mes "[�u���b�N�n���h]";
		mes "���̐^�̃o�t�H���b�g���|����";
		mes "���͂�����ȒP�Ȃ͂����B";
		mes "�t�b�t�b�t�c�c";
		mes "���������瑁���ޗ��������Ă����I";
		chgquest 3042,3043;
		close;
	case 2:
		//������
		mes "[�u���b�N�n���h]";
		mes "�p���Ȃ���Θb������ȁI";
		mes "�I���͏C���m�p�̑�����";
		mes "����Ă�񂾁B";
		mes "�ɂ���ˁ[�񂾂��H";
		mes "����������!?";
		close;
	}
}

//============================================================
// �_���W��������NPC
//------------------------------------------------------------
monk_test,309,146,3	script	�C���m�p�g���b�N	412,{
	if(checkitemblank() < 5) {
		mes "�]�����A�C�e���̎�ސ���������";
		mes "�@�댯�ł��B";
		mes "�@5��ވȏ�̏����A�C�e����";
		mes "�@���炵�Ă���A";
		mes "�@�ēx�b�������Ă��������]";
		close;
	}
	cutin "ins_cata_pri_n",2;
	mes "[�C���m�p�g���b�N]";
	mes "���̐��̕��a���������ƂȂ��A";
	mes "�Ăю׈��ȋC�z���K��悤�Ƃ��Ă���B";
	mes "����͒N�̐ӔC�Ȃ̂��c�c";
	next;
	mes "[�C���m�p�g���b�N]";
	mes "�c�c�c�c�c�c";
	mes "����ȑ�ςȎ����Ƃ����̂Ɂc�c";
	mes "�����ɉ��̗p�ŗ����̂��ˁH";
	next;
	if(countitem(6004) > 0) {
		set .@str$,"^0000FF���ꂽ�o�t�H���b�g�l�`�ɂ���^000000";
	} else {
		set .@str$,"���ɗp�͂Ȃ��ł�";
	}
	switch(select("�����͉��ł����H","�����ɓ��肽���ł�",.@str$,"��b����߂�")) {
	case 1:
		mes "[�C���m�p�g���b�N]";
		mes "�n�n�n�A�{���ɒm��Ȃ��̂��ˁH";
		mes "�����́A�����N��ڎw���Ă���҂�";
		mes "�Z�𖁂��A�F��������ꏊ�A";
		mes "���J�s�g�[���i�C���@���B";
		next;
		mes "[�C���m�p�g���b�N]";
		mes "�����č��A�N�������Ă���";
		mes "���̏ꏊ�́c�c";
		mes "^0000FF���󂳂ꂽ�_�a^000000�ƌ�����ꏊ��";
		mes "�q�����Ă���c�c";
		next;
		mes "[�C���m�p�g���b�N]";
		mes "�N�����̐��ɐ����󂯂Ă����Ȃ�";
		mes "�����́A���̑�n���x�z���Ă����A";
		mes "����Ȉ����������Ă���̂��B";
		mes "�����Ď��͂��̏ꏊ���Ǘ����Ă���B";
		next;
		switch(select("���������ڂ��������Ă�������","��b����߂�")) {
		case 1:
			cutin "ins_cata_pri_n",2;
			mes "[�C���m�p�g���b�N]";
			mes "^FF0000�����o�t�H���b�g^000000�c�c";
			mes "���ꂪ���̈����̖����B";
			mes "�o�t�H���b�g�̖����炢��";
			mes "�������������邾�낤�H";
			next;
			mes "[�C���m�p�g���b�N]";
			mes "���̈�����ގ����邽�߂ɁA";
			mes "�������J�s�g�[���i�C���@�ł�";
			mes "�D�G�Ȗ`���҂������琬���A";
			mes "���̒��ɑ���o���Ă����̂��B";
			next;
			mes "[�C���m�p�g���b�N]";
			mes "���N�̖ڂ̑O�ɂ��镕��΂ɂ�";
			mes "�v��m��Ȃ��]���Ɠw�͂ŕ߂炦��";
			mes "�����o�t�H���b�g�����󂳂�Ă���B";
			next;
			mes "[�C���m�p�g���b�N]";
			mes "�������c�O�Ȏ��Ɂc�c";
			mes "���������N�̕����゠���肩��";
			mes "���̒��̂����鐶���ɉe����";
			mes "�o�n�߂Ă���B";
			mes "������񂱂̖����o�t�H���b�g�ɂ��ȁB";
			next;
			mes "[�C���m�p�g���b�N]";
			mes "�ŋߖ����o�t�H���b�g�𕕂����߂�͂�";
			mes "�キ�Ȃ��Ă��ĂȁA���̂܂܂���";
			mes "���󂪔j���A�����o�t�H���b�g��";
			mes "�������鋰�ꂪ����B";
			next;
			mes "�����Ŏ��͍Ăѕ���������邽��";
			mes "�N�̂悤�Ȗ`���҂�����";
			mes "�T���Ă���̂���B";
			mes "�����ʂ��H";
			mes "���̎׈��Ȕg�����B";
			break;
		case 2:
			cutin "ins_cata_pri_n",2;
			mes "[�C���m�p�g���b�N]";
			mes "���������̕��󂪔j��ꂻ���Ȃ̂��B";
			mes "�����Ŏ��͍Ăѕ���������邽��";
			mes "�N�̂悤�Ȗ`���҂�����";
			mes "�T���Ă���̂���B";
			mes "�����ʂ��H";
			mes "���̎׈��Ȕg�����B";
			break;
		}
		next;
		mes "[�C���m�p�g���b�N]";
		mes "�Ȃ̗͂𖁂��A�ǂ������̗͂�";
		mes "�����o�t�H���b�g�𕕈󂷂鎖��";
		mes "�g���ė~�����B";
		break;
	case 2:
		if(BaseLevel < 75) {
			mes "[�C���m�p�g���b�N]";
			mes "Lv75�ȏ�͂Ȃ���";
			mes "�����o�t�H���b�g�̗͂�";
			mes "�ς���ꂻ���ɂȂ��̂��c�c";
			next;
			mes "[�C���m�p�g���b�N]";
			mes "�c�O�����A�܂����Ă���";
			break;
		}
		mes "[�C���m�p�g���b�N]";
		mes "�ق��A���̐_�a�ɓ���";
		mes "������ނ��Ă����ƌ����̂�!?";
		next;
		if(checkquest2(3040)) {
			if(checkquest2(3040) & 0x2) {
				mes "[�C���m�p�g���b�N]";
				mes "�c�c�����A";
				mes "�悤�₭�N�̑̂ɂ������Ă���";
				mes "�􂢂̗͂���܂��Ă������c�c";
				mes "�ł͎��̗͂ł��̎׈��ȋC�z��";
				mes "���������Ă��񂺂悤";
				next;
				mes "[�C���m�p�g���b�N]";
				mes "^FF0000�k�A�@�@�@!!";
				mes "�p�g���N�p�g���J�p�g�������D�D�D�I^000000";
				misceffect 152,"";
				delquest 3040;
				if(checkquest2(3041)) delquest 3041;
				next;
				mes "[�C���m�p�g���b�N]";
				mes "�ӂ��`�A";
				mes "�I��������B";
				mes "����ł��Ȃ��ɂ������Ă����􂢂�";
				mes "�S�Ď�菜���ꂽ�B";
				mes "�����o���肪�o���邾�낤�B";
				break;
			}
			mes "[�C���m�p�g���b�N]";
			mes "�N�́c�c";
			mes "���ɂ����ɓ�������������ȁB";
			mes "�N�̑̂ɂ͂܂��􂢂�";
			mes "�c���Ă���悤���B";
			mes "����̒������s�����Ƃ��ł��Ȃ��B";
			mes "���������҂ĂΎ􂢂������邾�낤�B";
			break;
		}
		if(getonlinepartymember() < 2 || getpartyleader(getcharid(1)) != strcharinfo(0)) {
			mes "[�C���m�p�g���b�N]";
			mes "�C�����͕����邪�A";
			mes "�����͒N�ł������";
			mes "�ꏊ�ł͂Ȃ��̂��B";
			mes "�K��^FF00002�l�ȏ�̃p�[�e�B�[^000000��g�݁A";
			mes "���̃p�[�e�B�[�̑�\��";
			mes "���Ƙb�����鎑�i������B";
			next;
			mes "[�C���m�p�g���b�N]";
			mes "�p�[�e�B�[�̑�\�ɋ����o���";
			mes "���̃p�[�e�B�[�����o�[�ɂ�";
			mes "�����o��B";
			mes "����͏C���@�̕��j�Ȃ̂��B";
			mes "�䖝���Ă���B";
			break;
		}
		mdcreate "Sealed Shrine";
		mes "[�C���m�p�g���b�N]";
		mes "�p�[�e�B�[�����A";
		mes "^0000FF" +getpartyname(getcharid(1))+ "^000000�Łc�c";
		mes "���[�_�[��";
		mes "^FF0000" +getpartyleader(getcharid(1))+ "^000000���c�c";
		mes "�c�c�c�c�c�c";
		next;
		mes "[�C���m�p�g���b�N]";
		mes "�c�c���������B";
		mes "�N���������ɓ����悤";
		mes "������̕���𒲐����悤�B";
		next;
		mes "[�C���m�p�g���b�N]";
		mes "�������΂炭����΁A�N������";
		mes "������ʂ邱�Ƃ��ł���悤��";
		mes "�Ȃ������Ƃ��������B";
		next;
		mes "[�C���m�p�g���b�N]";
		mes "����������A�����ɂ���";
		mes "�Ւd�Ɏ���������̂��B";
		mes "��������Β��ɓ����悤�ɂȂ�B";
		next;
		mes "[�C���m�p�g���b�N]";
		mes "�܂��A�o���Ă����ė~�������Ƃ�����B";
		mes "�����Ɉ�x�ł����𓥂ݓ��ꂽ�҂́B";
		mes "^FF0000�o�t�H���b�g�̎�^000000��������B";
		mes "�����Ď􂢂�������܂ł�";
		mes "��؂��̓�����̕����";
		mes "�����蔲���邱�Ƃ��ł��Ȃ��Ȃ�B";
		next;
		mes "[�C���m�p�g���b�N]";
		mes "�����Ă�����I";
		mes "���̐_�a���ł͎􂢂̂����ŁA";
		mes "�ꕔ�̃X�L����A�C�e�����g���Ȃ��B";
		next;
		mes "[�C���m�p�g���b�N]";
		mes "^0000FF�e���|�[�g�A�Z�C�t�e�B�E�H�[��";
		mes "�A�X���v�e�B�I�A�A�u���J�^�u���A";
		mes "���f�B���v�e�B�I^000000�͎g���Ȃ��B";
		mes "�����^0000FF�n�C���[�]�C�X�g�J�[�h��";
		mes "�A�]�[�g^000000�̂悤�ȃ����X�^�[��";
		mes "�ϊ�������ʂ��������Ȃ��B";
		next;
		mes "[�C���m�p�g���b�N]";
		mes "�\�����ӂ���̂����B";
		break;
	case 3:
		if(checkquest2(3042) || checkquest2(3043)) {
			// ������
			mes "[�C���m�p�g���b�N]";
			mes "�C���@�̓�ɂ���A";
			mes "^0000FF�u���b�N�n���h^000000�ƌ����҂��B";
			mes "�ނȂ炻�̐l�`�����Ȃ��ɖ𗧂���";
			mes "�ς��Ă���邾�낤�B";
			mes "�������Ă݂�Ƃ����B";
			break;
		}
		if(countitem(6004) > 0) {
			mes "[�C���m�p�g���b�N]";
			mes "���A����́c�c!!";
			mes "������ƌ����Ă���I";
			mes "�c�c�c�c�ӂނ��c�c�I";
			next;
			mes "[�C���m�p�g���b�N]";
			mes "�ԈႢ�Ȃ��c�c";
			mes "����͂��̎׈��ȃo�t�H���b�g��";
			mes "���͂����߂�ꂽ�l�`�I";
			mes "��A�悭��ɓ��ꂽ�ȁc�c";
			next;
			mes "[�C���m�p�g���b�N]";
			mes "�Łc�c���̐l�`��";
			mes "�ǂ�������肾�H";
			mes "�c�c����͂ƂĂ��댯�ȑ㕨���B";
			next;
			mes "[�C���m�p�g���b�N]";
			mes "�c�c�����A";
			mes "�����𗧂Ă邱�Ƃ��o����";
			mes "�l������l����B";
			mes "�Љ�悤�c�c";
			next;
			mes "[�C���m�p�g���b�N]";
			mes "�C���@�̓�ɂ���A";
			mes "^0000FF�u���b�N�n���h^000000�ƌ����҂��B";
			mes "�ނȂ炻�̐l�`�����Ȃ��ɖ𗧂���";
			mes "�ς��Ă���邾�낤�B";
			mes "�������Ă݂�Ƃ����B";
			setquest 3042;
			break;
		}
	case 4:
		mes "[�C���m�p�g���b�N]";
		mes "�����A�p���Ȃ��̂��ˁB";
		mes "���Ɏ₵�����Ƃ��c�c";
		break;
	}
	close2;
	cutin "ins_cata_pri_n",255;
	end;
}

//============================================================
// �]��NPC
//------------------------------------------------------------
monk_test,306,151,3	script	�����	111,{
	if(countitem(6001) > 0)
		delitem 6001,countitem(6001);
	if(countitem(6002) > 0)
		delitem 6002,countitem(6002);
	mes "�]�傫�Ȋp��������";
	mes "�@�����̎p�����܂ꂽ����Ȑ΂��B";
	mes "�@�׈��Ȕg����������]";
	next;
	switch(select("�G���Ă݂�","��։�����")) {
	case 1:
		if(checkquest2(3040)) {
			if(checkquest2(3040) & 0x2) {
				cutin "ins_cata_pri_n",2;
				mes "[�C���m�p�g���b�N]";
				mes "�c�c�����A";
				mes "�悤�₭�N�̑̂ɂ������Ă���";
				mes "�􂢂̗͂���܂��Ă������c�c";
				mes "�ł͎��̗͂ł��̎׈��ȋC�z��";
				mes "���������Ă��񂺂悤";
				next;
				mes "[�C���m�p�g���b�N]";
				mes "^FF0000�k�A�@�@�@!!";
				mes "�p�g���N�p�g���J�p�g�������D�D�D�I^000000";
				misceffect 152,"";
				delquest 3040;
				if(checkquest2(3041)) delquest 3041;
				next;
				mes "[�C���m�p�g���b�N]";
				mes "�ӂ��`�A";
				mes "�I��������B";
				mes "����ł��Ȃ��ɂ������Ă����􂢂�";
				mes "�S�Ď�菜���ꂽ�B";
				mes "�����o���肪�o���邾�낤�B";
				close2;
				cutin "ins_cata_pri_n",255;
				end;
			}
			misceffect 152,"";
			mes "�]�w�悩�狭��ȏՌ���";
			mes "�@�̂ɓ`����Ă����I�]";
			next;
			cutin "ins_cata_pri_n",2;
			mes "[�C���m�p�g���b�N]";
			mes "�N�́c�c";
			mes "���ɂ����ɓ�������������ȁB";
			mes "�N�̑̂ɂ͂܂��􂢂�";
			mes "�c���Ă���悤���B";
			mes "���������҂ĂΎ􂢂������邾�낤�B";
			close2;
			cutin "ins_cata_pri_n",255;
			end;
		}
		switch(mdenter("Sealed Shrine")) {
		case 0:	// �G���[�Ȃ�
			announce "[" +strcharinfo(1)+ "] �p�[�e�B�[�� [" +strcharinfo(0)+ "] �� [Sealed Shrine] �ɓ��ꂵ�܂�",0x9,0x00FF99;
			setquest 3040;
			set BAPHO_1QUE,0;
			donpcevent getmdnpcname("BaphometControl1-1")+ "::OnStart";
			end;
		default:	// �G���[
			mes "�]�w�悩�狰�낵���C�z��";
			mes "�@�����Ƃ��B";
			mes "�@�������ɉ��̔������Ȃ��]";
			close;
		}
	case 2:
		mes "�]�����𗣂�悤�c�c�]";
		break;
	}
	close;
}

//============================================================
// ���󂳂ꂽ�_�a1F
//------------------------------------------------------------
1@cata,0,0,0	script	BaphometControl1-1	-1,{
OnStart:
	if(.flag > 0)
		end;
	set .flag,1;

	hideonnpc getmdnpcname("���p�Y�̍�#1F");
	hideonnpc getmdnpcname("BaphometGate");

	set .@num,rand(1,13);
	for(set .@i,1; .@i<13; set .@i,.@i+1) {
		if(.@num == .@i)
			hideonnpc getmdnpcname("���ꂩ���̕�#1F_"+.@i+"F");
		else
			hideonnpc getmdnpcname("���ꂩ���̕�#1F_"+.@i+"T");
	}
	for(set .@i,1; .@i<12; set .@i,.@i+1)
		hideonnpc getmdnpcname("�h��߂�����#"+.@i);

	areamonster getmdmapname("1@cata"),0,0,0,0,"�f�b�h���[���C�X",1291,40,getmdnpcname("BaphometControl1-1")+"::OnKilled1";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�J�[���b�c�o�[�O",1132,20,getmdnpcname("BaphometControl1-1")+"::OnKilled2";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�t���[���X�J��",1869,40,getmdnpcname("BaphometControl1-1")+"::OnKilled3";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�G���V�F���g�~�~�b�N",1699,30,getmdnpcname("BaphometControl1-1")+"::OnKilled4";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�]���r�}�X�^�[",1298,40,getmdnpcname("BaphometControl1-1")+"::OnKilled5";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�W�F�l�����X�P���g��",1290,40,getmdnpcname("BaphometControl1-1")+"::OnKilled6";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�E�B���h�S�[�X�g",1263,30,getmdnpcname("BaphometControl1-1")+"::OnKilled7";
	areamonster getmdmapname("1@cata"),0,0,0,0,"���[�h",1509,20,getmdnpcname("BaphometControl1-1")+"::OnKilled8";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�C�r���h���C�h",1117,30,getmdnpcname("BaphometControl1-1")+"::OnKilled9";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o���V�[",1867,10,getmdnpcname("BaphometControl1-1")+"::OnKilled10";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�_�[�N�C�����[�W����",1302,1,getmdnpcname("BaphometControl1-1")+"::OnKilled11";
	end;
OnKilled:
	killmonster getmdmapname("1@cata"),getmdnpcname("BaphometControl1-1")+"::OnKilled1";
	killmonster getmdmapname("1@cata"),getmdnpcname("BaphometControl1-1")+"::OnKilled2";
	killmonster getmdmapname("1@cata"),getmdnpcname("BaphometControl1-1")+"::OnKilled3";
	killmonster getmdmapname("1@cata"),getmdnpcname("BaphometControl1-1")+"::OnKilled4";
	killmonster getmdmapname("1@cata"),getmdnpcname("BaphometControl1-1")+"::OnKilled5";
	killmonster getmdmapname("1@cata"),getmdnpcname("BaphometControl1-1")+"::OnKilled6";
	killmonster getmdmapname("1@cata"),getmdnpcname("BaphometControl1-1")+"::OnKilled7";
	killmonster getmdmapname("1@cata"),getmdnpcname("BaphometControl1-1")+"::OnKilled8";
	killmonster getmdmapname("1@cata"),getmdnpcname("BaphometControl1-1")+"::OnKilled9";
	killmonster getmdmapname("1@cata"),getmdnpcname("BaphometControl1-1")+"::OnKilled10";
	killmonster getmdmapname("1@cata"),getmdnpcname("BaphometControl1-1")+"::OnKilled11";
	end;
OnKilled1:
	areamonster getmdmapname("1@cata"),0,0,0,0,"�f�b�h���[���C�X",1291,1,getmdnpcname("BaphometControl1-1")+"::OnKilled1";
	end;
OnKilled2:
	areamonster getmdmapname("1@cata"),0,0,0,0,"�J�[���b�c�o�[�O",1132,1,getmdnpcname("BaphometControl1-1")+"::OnKilled2";
	end;
OnKilled3:
	areamonster getmdmapname("1@cata"),0,0,0,0,"�t���[���X�J��",1869,1,getmdnpcname("BaphometControl1-1")+"::OnKilled3";
	end;
OnKilled4:
	areamonster getmdmapname("1@cata"),0,0,0,0,"�G���V�F���g�~�~�b�N",1699,1,getmdnpcname("BaphometControl1-1")+"::OnKilled4";
	end;
OnKilled5:
	areamonster getmdmapname("1@cata"),0,0,0,0,"�]���r�}�X�^�[",1298,1,getmdnpcname("BaphometControl1-1")+"::OnKilled5";
	end;
OnKilled6:
	areamonster getmdmapname("1@cata"),0,0,0,0,"�W�F�l�����X�P���g��",1290,1,getmdnpcname("BaphometControl1-1")+"::OnKilled6";
	end;
OnKilled7:
	areamonster getmdmapname("1@cata"),0,0,0,0,"�E�B���h�S�[�X�g",1263,1,getmdnpcname("BaphometControl1-1")+"::OnKilled7";
	end;
OnKilled8:
	areamonster getmdmapname("1@cata"),0,0,0,0,"���[�h",1509,1,getmdnpcname("BaphometControl1-1")+"::OnKilled8";
	end;
OnKilled9:
	areamonster getmdmapname("1@cata"),0,0,0,0,"�C�r���h���C�h",1117,1,getmdnpcname("BaphometControl1-1")+"::OnKilled9";
	end;
OnKilled10:
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o���V�[",1867,1,getmdnpcname("BaphometControl1-1")+"::OnKilled10";
	end;
OnKilled11:
	areamonster getmdmapname("1@cata"),0,0,0,0,"�_�[�N�C�����[�W����",1302,1,getmdnpcname("BaphometControl1-1")+"::OnKilled11";
	end;
}

1@cata,3,2,0	script	BaphometControl1-2	-1,{
OnStart:
	hideoffnpc getmdnpcname("�h��߂�����#1");
	hideoffnpc getmdnpcname("�h��߂�����#2");
	hideoffnpc getmdnpcname("�h��߂�����#3");
	hideoffnpc getmdnpcname("�h��߂�����#4");
	hideoffnpc getmdnpcname("�h��߂�����#5");
	hideoffnpc getmdnpcname("�h��߂�����#6");
	hideoffnpc getmdnpcname("�h��߂�����#7");
	hideoffnpc getmdnpcname("�h��߂�����#8");
	hideoffnpc getmdnpcname("�h��߂�����#9");
	hideoffnpc getmdnpcname("�h��߂�����#10");
	hideoffnpc getmdnpcname("�h��߂�����#11");
	hideoffnpc getmdnpcname("�h��߂�����#12");

	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1869,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1291,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1869,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1291,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1869,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1291,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1869,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1132,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1117,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1132,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1117,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1132,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1291,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1117,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1869,1,getmdnpcname("BaphometControl1-2")+"::OnKilled";
	end;

OnKilled:
	switch(rand(5)) {
	case 0: areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1869,1,getmdnpcname("BaphometControl1-2")+"::OnKilled"; break;
	case 1: areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1291,1,getmdnpcname("BaphometControl1-2")+"::OnKilled"; break;
	case 2: areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1132,1,getmdnpcname("BaphometControl1-2")+"::OnKilled"; break;
	case 3: areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1117,1,getmdnpcname("BaphometControl1-2")+"::OnKilled"; break;
	case 4: areamonster getmdmapname("1@cata"),0,0,0,0,"�o�t�H���b�g�̎g�k",1869,1,getmdnpcname("BaphometControl1-2")+"::OnKilled"; break;
	}
	getitem 6002,1;
	end;
}

1@cata,141,221,0	script	���ꂩ���̕�	844,3,3,{
	switch(BAPHO_1QUE) {
	case 0:
		mes "�]��΂��疭�ȋ�C��������c�c";
		next;
		mes "�]��΂Ɏ���������Ă݂��";
		mes "�@�����̐����S�ɒ��ڕ������Ă����]";
		next;
		misceffect 71,"";
		mes "[��΂̐�]";
		mes "^556B2F�c�c�c�c�c�c�c�c";
		mes "�����Ɓc�c�҂��Ă����c�c";
		mes "�N�����̂悤�Ȗ`���҂�";
		mes "�Ăт�����K��Ă��������c�c^000000";
		next;
		menu "�c�c�N�H",-;
		mes "[��΂̐�]";
		mes "^556B2F���͌N�����Ɠ������A";
		mes "�`���҂������c�c";
		mes "���͂��̂悤�ɍ�������";
		mes "���݂ɂȂ��Ă��܂������c�c^000000";
		next;
		mes "[��΂̐�]";
		mes "^556B2F�N�������C�t���Ă��邩������Ȃ����A";
		mes "������Ă��鎞�Ԃ����܂�Ȃ��B";
		mes "^FF0000���̈���^556B2F�͐��\�N�ԁA";
		mes "�͂𒙂߂���ł����B^000000";
		next;
		mes "[��΂̐�]";
		mes "^556B2F�́c�c���ƒ��Ԃ�����q����";
		mes "���̈�����n���ɂ���";
		mes "�Ւd�ɕ��󂵁A�����܂ł̒ʘH��";
		mes "�ǂ��ł������B^000000";
		next;
		mes "[��΂̐�]";
		mes "^556B2F���͎��ʒ��O�ɁA����y���_���g��";
		mes "�����̍��𐁂����݁A����Ȍ`����";
		mes "�������鎖���ł������A���̒��Ԃ�";
		mes "�S������ł��܂����c�c";
		mes "�����Ă����Ƒ҂��Ă����񂾁B";
		mes "�N�����̂悤�Ȗ`���҂��B^000000";
		next;
		menu "����҂��Ă����ƁH",-;
		mes "[��΂̐�]";
		mes "^556B2F���̈����c�c";
		mes "^FF0000�����o�t�H���b�g^556B2F�̗͂�";
		mes "��X�̗\�z��y���ɒ����A";
		mes "�����ł��j���قǂɐ������Ă���B";
		mes "���������ĕ�����s��Ȃ����";
		mes "���̕��󂪉������̂����Ԃ̖�肾�B";
		next;
		mes "^000000[��΂̐�]";
		mes "^556B2F�n���ւ̓������J���ɂ́A";
		mes "�܂����̍���";
		mes "���̉�������K�v������B";
		mes "���ꂪ�ł����������؂�J���A";
		mes "����̍Ē������s�����肾�B^000000";
		next;
		mes "[��΂̐�]";
		mes "^556B2F�܂����̎��̉��̂��߂ɁA";
		mes "���̃y���_���g��T���K�v������B";
		mes "�����̊K�w�ɂ́A��������";
		mes "���ꂩ���̕悪���݂��Ă���B";
		mes "���̒��̈�Ƀy���_���g������͂��B";
		mes "�F�Ŏ蕪�����ĒT���ė~�����B^000000";
		viewpoint 1,86,214,1,0x00FF00;
		viewpoint 1,200,209,2,0x00FF00;
		viewpoint 1,230,195,3,0x00FF00;
		viewpoint 1,118,182,4,0x00FF00;
		viewpoint 1,193,182,5,0x00FF00;
		viewpoint 1,253,156,6,0x00FF00;
		viewpoint 1,88,154,7,0x00FF00;
		viewpoint 1,127,116,8,0x00FF00;
		viewpoint 1,90,98,9,0x00FF00;
		viewpoint 1,188,84,10,0x00FF00;
		viewpoint 1,244,42,11,0x00FF00;
		viewpoint 1,127,32,12,0x00FF00;
		viewpoint 1,267,30,13,0x00FF00;
		next;
		mes "[��΂̐�]";
		mes "^556B2F�y���_���g����ɓ�������";
		mes "�p�[�e�B�[���[�_�[��";
		mes "���̃y���_���g�����̂Ƃ����";
		mes "�����Ă��ė~�����c�c";
		mes "�����A���Ԃ��Ȃ��I";
		mes "�}���ł���I^000000";
		viewpoint 1,141,221,14,0xFF89D7;
		set BAPHO_1QUE,1;
		close;
	case 1:
		mes "[��΂̐�]";
		mes "^556B2F�n���ւ̓������J���ɂ́A";
		mes "�܂����̍���";
		mes "���̉�������K�v������B";
		mes "���ꂪ�ł����������؂�J���A";
		mes "����̍Ē������s�����肾�B^000000";
		next;
		mes "[��΂̐�]";
		mes "^556B2F�܂����̎��̉��̂��߂ɁA";
		mes "���̃y���_���g��T���K�v������B";
		mes "�����̊K�w�ɂ́A��������";
		mes "���ꂩ���̕悪���݂��Ă���B";
		mes "���̒��̈�Ƀy���_���g������͂��B";
		mes "�F�Ŏ蕪�����ĒT���ė~�����B^000000";
		viewpoint 1,86,214,1,0x00FF00;
		viewpoint 1,200,209,2,0x00FF00;
		viewpoint 1,230,195,3,0x00FF00;
		viewpoint 1,118,182,4,0x00FF00;
		viewpoint 1,193,182,5,0x00FF00;
		viewpoint 1,253,156,6,0x00FF00;
		viewpoint 1,88,154,7,0x00FF00;
		viewpoint 1,127,116,8,0x00FF00;
		viewpoint 1,90,98,9,0x00FF00;
		viewpoint 1,188,84,10,0x00FF00;
		viewpoint 1,244,42,11,0x00FF00;
		viewpoint 1,127,32,12,0x00FF00;
		viewpoint 1,267,30,13,0x00FF00;
		next;
		mes "[��΂̐�]";
		mes "^556B2F�y���_���g����ɓ�������";
		mes "^0000FF�p�[�e�B�[���[�_�[��^556B2F";
		mes "���̃y���_���g�����̂Ƃ����";
		mes "�����Ă��ė~�����c�c";
		mes "�����A���Ԃ��Ȃ��I";
		mes "�}���ł���I^000000";
		viewpoint 1,141,221,14,0xFF89D7;
		close;
	case 2:
		if(getpartyleader(getcharid(1)) == strcharinfo(0)) {
			mes "[��΂̐�]";
			mes "^556B2F����Łc�c";
			mes "�y���_���g�͌����������H^000000";
			next;
			if(countitem(6003) < 1) {
				mes "^000000[��΂̐�]^777777";
				mes "�c�c�܂��������Ă��Ȃ��悤��";
				next;
				mes "^000000[��΂̐�]^777777";
				mes "�p�[�e�B�[�����o�[��";
				mes "�y���_���g���������Ă���Ȃ�";
				mes "�N���󂯎���ēn���Ă���";
				close;
			}
			viewpoint 2,86,214,1,0x00FF00;
			viewpoint 2,200,209,2,0x00FF00;
			viewpoint 2,230,195,3,0x00FF00;
			viewpoint 2,118,182,4,0x00FF00;
			viewpoint 2,193,182,5,0x00FF00;
			viewpoint 2,253,156,6,0x00FF00;
			viewpoint 2,88,154,7,0x00FF00;
			viewpoint 2,127,116,8,0x00FF00;
			viewpoint 2,90,98,9,0x00FF00;
			viewpoint 2,188,84,10,0x00FF00;
			viewpoint 2,244,42,11,0x00FF00;
			viewpoint 2,127,32,12,0x00FF00;
			viewpoint 2,267,30,13,0x00FF00;
			viewpoint 2,141,221,14,0xFF89D7;
			mes "[��΂̐�]";
			mes "^556B2F�����A���ꂾ�I";
			mes "���̃y���_���g�ɈႢ�Ȃ��I^000000";
			next;
			delitem 6003,1;
			hideoffnpc getmdnpcname("���p�Y�̍�#1F");
			hideonnpc getmdnpcname("���ꂩ���̕�");
			viewpoint 1,176,119,2,0xFF89D7;
			mes "[��΂̐�]";
			mes "^556B2F����ō���";
			mes "���̉������邱�Ƃ��ł���B";
			mes "�����̒����ɂ��鉊�̍Ւd��";
			mes "�N������҂��痈��Ƃ����B^000000";
			next;
			announce "���p�Y�̍� : �N�����̂������ŋ͂��Ȏ��Ԃ������̂����߂����Ƃ��ł����B�����̒����ɂ��鉊�̍Ւd�ŌN������҂��Ă���B",0x9,0xFFFF00;
			mes "�]�������Ă���������������";
			mes "�@�������Ȃ��Ă����c�c�]";
			close;
		}
	default:
		mes "[��΂̐�]";
		mes "^0000FF�N�����̑�\^556B2F�Ƙb���������B";
		mes "���̐l�B�͏����҂��Ă���B^000000";
		close;
	}
	end;

OnTouch:
	if(BAPHO_1QUE == 0) {
		mes "�]^556B2F�S�S�S�c�c";
		mes "�@�O�������c�c^000000�]";
		next;
		misceffect 322;
		mes "�]��΂��疭�ȋ�C��������c�c";
		mes "�@�����Ȑ��ł͂��邪�A";
		mes "�@�������Ă�ł���l��";
		mes "�@�C�����邪�c�c�H�]";
		close;
	}
	end;
}

1@cata,176,119,4	script	���p�Y�̍�#1F	411,{
	switch(BAPHO_1QUE) {
	case 2:
		cutin "ins_cata_champ_n",2;
		mes "[���p�Y�̍�]";
		mes "�N�����̂�������";
		mes "�͂��Ȏ��Ԃ���";
		mes "���̂����߂����Ƃ��ł����B";
		mes "�F�X�Ƙb�����������A�����ꂽ";
		mes "���Ԃ����܂�Ȃ��B";
		next;
		mes "[���p�Y�̍�]";
		mes "���̓��̂ɗ��܂�鎞�Ԃ�";
		mes "^0000FF��1���ԁc�c^000000";
		mes "�n����^FF0000�啕��Ւd^000000�ɍs�����߂ɂ�";
		mes "�������ꂩ��s���V������`����";
		mes "���Ȃ��Ƃ����Ȃ��B";
		next;
		mes "[���p�Y�̍�]";
		mes "�ł́A������N�����e����";
		mes "���ׂ����Ƃ�������邩��";
		mes "�悭�����Ăق����B";
		mes "�܂���ځA�����ɂ����̏�����";
		mes "���Ȃ�^0000FF�΂̐���^000000���W�߂邱�ƁB";
		next;
		mes "[���p�Y�̍�]";
		mes "��ڂ́A�n���ɓ��郁���o�[��";
		mes "�S��^0000FF�g�k�̏�^000000��g�ɕt���邱�Ƃ��B";
		next;
		cutin "ins_cata_champ_n",2;
		menu "�΂̐����Ƃ́H",-;
		mes "[���p�Y�̍�]";
		mes "�������悭�T���Ă݂�΁A";
		mes "�����鏊����h��߂�������";
		mes "������͂����B";
		mes "���̏����́A�o�t�H���b�g�̗͂�";
		mes "�}�������邽�߂ɐ��̏C���m������";
		mes "���_�g�[���̉΂ō�������̂��B";
		next;
		mes "[���p�Y�̍�]";
		mes "�n���̕��󂳂ꂽ����J�����߂ɂ́A";
		mes "���̗��_�̗͂���߂��Ă���A";
		mes "^0000FF�΂̐���^000000���K�v�Ȃ̂��B";
		mes "�܂��͏������� ^0000FF�΂̐���^000000��";
		mes "^FF000010��^000000�W�߂Ă���B";
		next;
		mes "[���p�Y�̍�]";
		mes "�ЂƂA�C��t���Ăق������Ƃ�����B";
		mes "�����͑I�΂ꂽ�p���҂ɂ̂�";
		mes "��������悤�ɂȂ��Ă���B";
		mes "�����I�΂ꂽ�҂łȂ��҂��G����";
		mes "��u�ɂ��đ�ςȂ��ƂɂȂ�B";
		next;
		mes "[���p�Y�̍�]";
		mes "���ꂩ��N�����̑�\�҂ЂƂ��";
		mes "�p���҂̈�����󂵂悤�B";
		mes "^0000FF�΂̐���^000000���W�߂�̂�";
		mes "��\�ЂƂ�ōs���̂��B";
		next;
		menu "�g�k�̏؂Ƃ́H",-;
		mes "[���p�Y�̍�]";
		mes "�����A���̗͂����ł̓o�t�H���b�g��";
		mes "�|�����Ƃ��ł��Ȃ������B";
		mes "�����؂�Ȃ��قǂ̖`���҂�����";
		mes "���������D���A����Ƃ̎v����";
		mes "�n���ɕ��󂷂邱�Ƃ��ł����̂��B";
		next;
		mes "[���p�Y�̍�]";
		mes "�����o�t�H���b�g�͐������������B";
		mes "�ǂ�ǂ񋭗͂ɂȂ閂�̗͂̂�����";
		mes "���̂܂ɂ���n��";
		mes "����������͂��߂��̂��B";
		next;
		mes "[���p�Y�̍�]";
		mes "�₪�Ďv�l�\�͂�������";
		mes "����������͂��߂��B";
		mes "�g�k�Ƃ������ŁA�o�t�H���b�g��";
		mes "�����Ȗl�ƂȂ��Ă���B";
		next;
		mes "[���p�Y�̍�]";
		mes "�g�k�����́A�o�t�H���b�g�̗͂𗘗p��";
		mes "���������̕�������葱���Ă���B";
		mes "�������Ă��郂���X�^�[���������B";
		next;
		mes "[���p�Y�̍�]";
		mes "�{�̂̎g�k�͕����Ƃ͈Ⴂ";
		mes "^0000FF�g�k�̏�^000000�ƌ������̂������Ă���B";
		mes "�{�̂�_���΁A�������肷�邱�Ƃ�";
		mes "�o���邾�낤�B";
		next;
		mes "[���p�Y�̍�]";
		mes "�N�����S����^0000FF�g�k�̏�^000000��";
		mes "��ɓ����K�v������B";
		mes "�܂��A��ԊȒP�ȕ��@��";
		mes "�ڂɉf���������X�^�[��";
		mes "�S�ē|�����Ƃ��낤�ȁB";
		next;
		menu "���͉�������΁H",-;
		if(getpartyleader(getcharid(1)) == strcharinfo(0)) {
			mes "[���p�Y�̍�]";
			mes "�N�͂��̃p�[�e�B�̑�\���ȁB";
			mes "�ł́A";
			mes "��������^0000FF�΂̐���^000000��";
			mes "10�W�߂Ă���̂��B";
			next;
			mes "[���p�Y�̍�]";
			mes "���ꂩ��N�Ɍp���҂̈��";
			mes "���󂷂�B";
			mes "^0000FF�΂̐���^000000�͌N��l��";
			mes "�W�߂Ȃ��Ă͂Ȃ�Ȃ��B";
			next;
			misceffect 152,"";
			mes "[���p�Y�̍�]";
			mes "���Ƃ�^0000FF�g�k�̏�^000000���K�v���B";
			mes "���Ԃ���Ⴄ���A�����Ń����X�^�[��";
			mes "�|���Ď�ɓ���Ă����񂾁B";
			next;
			mes "[���p�Y�̍�]";
			mes "�ł͏������������琺�������Ă���B";
			mes "�N�����̏������ł�����A";
			mes "���󂵂Ă������J��";
			mes "�V�����͂��߂�B";
			next;
			cutin "ins_cata_champ_n",2;
			mes "[���p�Y�̍�]";
			mes "�����͂������H";
			mes "�ł͍����畕�󂵂Ă������J��";
			mes "�V�����͂��߂�B";
			next;
			mes "[���p�Y�̍�]";
			mes "�J��Ԃ��ɂȂ邪�A";
			mes "�������̉����Ă����鎞�Ԃ�";
			mes "^0000FF��1����^000000�����Ȃ��B";
			mes "�e��1���Ԉȓ��ɖ������ʂ����Ă���B";
			viewpoint 1,267,210,1,0x00FF00;
			viewpoint 1,267,154,3,0x00FF00;
			viewpoint 1,157,139,4,0x00FF00;
			viewpoint 1,193,138,5,0x00FF00;
			viewpoint 1,193,102,6,0x00FF00;
			viewpoint 1,157,102,7,0x00FF00;
			viewpoint 1,113,112,8,0x00FF00;
			viewpoint 1,253,56,9,0x00FF00;
			viewpoint 1,239,56,10,0x00FF00;
			viewpoint 1,71,42,11,0x00FF00;
			viewpoint 1,155,14,12,0x00FF00;
			viewpoint 1,85,182,13,0x00FF00;
			set BAPHO_1QUE,3;
			initnpctimer;
			donpcevent getmdnpcname("BaphometControl1-2")+"::OnStart";
		} else {
			mes "[���p�Y�̍�]";
			mes "�N�̓o�t�H���b�g�̎g�k��|���A";
			mes "^0000FF�g�k�̏�^000000����ɓ����̂��B";
			next;
			mes "[���p�Y�̍�]";
			mes "�g�k�͌����ڂł͋�ʂ��t���Ȃ��B";
			mes "�ڂɉf���������X�^�[��";
			mes "�S�ē|���̂��������@���낤�B";
			next;
			mes "[���p�Y�̍�]";
			mes "�ł͏������������琺�������Ă���B";
			mes "�N�����̏������ł�����A";
			mes "���󂵂Ă������J��";
			mes "�V�����͂��߂�B";
			next;
			cutin "ins_cata_champ_n",2;
			mes "[���p�Y�̍�]";
			mes "�����͂������H";
			mes "�ł͍����畕�󂵂Ă������J��";
			mes "�V�����͂��߂�B";
			next;
			mes "[���p�Y�̍�]";
			mes "�J��Ԃ��ɂȂ邪�A";
			mes "�������̉����Ă����鎞�Ԃ�";
			mes "^0000FF��1����^000000�����Ȃ��B";
			mes "�e��1���Ԉȓ��ɖ������ʂ����Ă���B";
		}
		close2;
		cutin "ins_cata_champ_n",255;
		end;
	case 3:
		if(getpartyleader(getcharid(1)) != strcharinfo(0)) {
			cutin "ins_cata_champ_n",2;
			mes "[���p�Y�̍�]";
			mes "^0000FF�g�k�̏�^000000�͎�ɓ��ꂽ���H";
			next;
			if(countitem(6002) < 1) {
				mes "[���p�Y�̍�]";
				mes "�܂�����Ȃ����B";
				mes "�N���������镨��";
				mes "^0000FF�g�k�̏�^000000���B";
			} else {
				mes "[���p�Y�̍�]";
				mes "�c�c�悵�A�������낤�B";
				mes "�ł́A���̊F�̏�Ԃ�������x�m�F���A";
				mes "�������ł����玄�ɘb�������Ă���B";
			}
			close2;
			cutin "ins_cata_champ_n",255;
			end;
		}
		cutin "ins_cata_champ_n",2;
		mes "[���p�Y�̍�]";
		mes "^0000FF�΂̐���^00000010��";
		mes "^0000FF�g�k�̏�^000000�͏����ł������H";
		next;
		if((countitem(6001) < 10) || (countitem(6002) < 1)) {
			mes "[���p�Y�̍�]";
			mes "�܂�����Ȃ����B";
			mes "�N���������镨��";
			mes "^0000FF�΂̐���^000000 10��";
			mes "^0000FF�g�k�̏�^000000���B";
		} else {
			viewpoint 2,267,210,1,0x00FF00;
			viewpoint 2,267,210,2,0x00FF00;
			viewpoint 2,267,154,3,0x00FF00;
			viewpoint 2,157,139,4,0x00FF00;
			viewpoint 2,193,138,5,0x00FF00;
			viewpoint 2,193,102,6,0x00FF00;
			viewpoint 2,157,102,7,0x00FF00;
			viewpoint 2,113,112,8,0x00FF00;
			viewpoint 2,253,56,9,0x00FF00;
			viewpoint 2,239,56,10,0x00FF00;
			viewpoint 2,71,42,11,0x00FF00;
			viewpoint 2,155,14,12,0x00FF00;
			viewpoint 2,85,182,13,0x00FF00;
			delitem 6001,countitem(6001);
			set BAPHO_1QUE,4;
			mes "[���p�Y�̍�]";
			mes "�c�c�悵�A�������낤�B";
			mes "�ł́A���̊F�̏�Ԃ�������x�m�F���A";
			mes "�������ł����玄�ɘb�������Ă���B";
		}
		close2;
		cutin "ins_cata_champ_n",255;
		end;
	case 4:
		if(getpartyleader(getcharid(1)) != strcharinfo(0)) {
			cutin "ins_cata_champ_n",2;
			mes "[���p�Y�̍�]";
			mes "�c�c����͌N�����c�c";
			mes "�V���Ȏ���̉p�Y�̐킢���B";
			mes "������ŉ�����`�����@��T���Ă݂�B";
			next;
			mes "[���p�Y�̍�]";
			mes "�����A�s���񂾁I";
			mes "�`���҂�����I";
			close2;
			cutin "ins_cata_champ_n",255;
			end;
		}
		cutin "ins_cata_champ_n",2;
		mes "[���p�Y�̍�]";
		mes "�����͍ς񂾂��H";
		mes "�������������V�����I�����Ƃ��낾�B";
		mes "^0000FF�g�k�̏�^000000�͂����Ǝ����Ă��邩�H";
		mes "���ʂ�ɂ͐�ΕK�v������ȁB";
		next;
		setpartyinmap BAPHO_1QUE,5;
		hideonnpc getmdnpcname("���󖂖@�w#0");
		hideonnpc getmdnpcname("���󖂖@�w#2");
		hideonnpc getmdnpcname("���󖂖@�w#4");
		hideonnpc getmdnpcname("���󖂖@�w#8");
		hideonnpc getmdnpcname("���󖂖@�w#10");
		hideonnpc getmdnpcname("���p�Y�̍�#2F");
		hideoffnpc getmdnpcname("BaphometGate");
		donpcevent getmdnpcname("BaphometControl1-1")+"::OnKilled";
		mes "[���p�Y�̍�]";
		mes "�c�c�����^FF0000�啕��Ւd^000000�Ɍq����";
		mes "�傪�J�����B";
		mes "�ʒu�͂��̊K�̓쓌�̊p���B";
		next;
		mes "[���p�Y�̍�]";
		mes "�c�c����͌N�����c�c";
		mes "�V���Ȏ���̉p�Y�̐킢���B";
		mes "������ŉ�����`�����@��T���Ă݂�B";
		next;
		mes "[���p�Y�̍�]";
		mes "�����A�s���񂾁I";
		mes "�`���҂�����I";
		viewpoint 1,281,12,3,0xFF89D7;
		announce "���p�Y�̍� : �n���啕��Ւd�ɂ�������J�������B��̈�ԓ쓌�t�߂��B�}���I",0x9,0xFFFF00;
		close2;
		cutin "ins_cata_champ_n",255;
		end;
	case 5:
		cutin "ins_cata_champ_n",2;
		mes "[���p�Y�̍�]";
		mes "�Ȃɂ��{�T���Ƃ��Ă�I";
		mes "^FF0000�啕��Ւd^000000�ւ̖���J�����I";
		mes "��������Ă����񂾁B";
		mes "�����͂��̊K�̓쓌�̊p���I";
		viewpoint 1,281,12,3,0xFF89D7;
		close2;
		cutin "ins_cata_champ_n",255;
		end;
	default:
		cutin "ins_cata_champ_n",2;
		mes "[���p�Y�̍�]";
		mes "�c�c�N�Ƙb�����Ƃ͂ł��Ȃ�";
		close2;
		cutin "ins_cata_champ_n",255;
		end;
	}

OnTimer1800000:
	announce "���p�Y�̍� : ���Ԃ����܂�c���Ă��Ȃ��B�}���̂��I",0x9,0xFFFF00;
	end;

OnTimer2400000:
	announce "���p�Y�̍� : ���̂ƍ����ǂ�ǂ񗣂�悤�Ƃ��Ă���c�c�}���̂��B",0x9,0xFFFF00;
	end;

OnTimer3000000:
	announce "���p�Y�̍� : �S�Ă��I���Ă��܂����c�c�������҂��邵���Ȃ��̂��c�c",0x9,0xFFFF00;
	end;

OnTimer3050000:
	announce "���p�Y�̍� : ���s���B�����A�܂��`�����X�͂���B���o����ς�ōĒ��킷��񂾁I",0x9,0xFFFF00;
	end;

OnTimer3100000:
	announce "�啕��Ւd�̕���̉����Ɏ��s���܂����B",0x9,0xFF1094;
	end;

OnTimer3500000:
	mapwarp getmdmapname("1@cata"),"monk_test",310,150;
	stopnpctimer;
	end;
}

1@cata,281,12,0	script	BaphometGate	45,1,1,{
	if(countitem(6002) < 1) {
		mes "[���p�Y�̍�]";
		mes "�g�k�̏؂͂ǂ������H";
		mes "�g�k�̏؂������Ă��Ȃ���";
		mes "^FF0000�啕��Ւd^000000�֍s���Ȃ���";
		close;
	}
	delitem 6002,countitem(6002);
	warp getmdmapname("2@cata"),80,144;
	end;
}

1@cata,86,214,0	script	���ꂩ���̕�#1F_1T	844,{
	if(BAPHO_1QUE != 1) {
		mes "�]�|�ꂩ������΂̉��ɂ�";
		mes "�@�����Ȃ������]";
		close;
	}
	getitem 6003,1;
	setpartyinmap BAPHO_1QUE,2;
	mes "�]�|�ꂩ������΂̉���";
	mes "�@���鏬���������������]";
	next;
	mes "[" + strcharinfo(0) + "]";
	mes "���̃y���_���g�ɈႢ�Ȃ��B";
	close;
}

1@cata,86,214,0	script	���ꂩ���̕�#1F_1F	844,{
	mes "�]�|�ꂩ������΂̉��ɂ�";
	mes "�@�����Ȃ������]";
	close;
}

1@cata,200,209,0	duplicate(���ꂩ���̕�#1F_1T)	���ꂩ���̕�#1F_2T	844
1@cata,200,209,0	duplicate(���ꂩ���̕�#1F_1F)	���ꂩ���̕�#1F_2F	844
1@cata,230,195,0	duplicate(���ꂩ���̕�#1F_1T)	���ꂩ���̕�#1F_3T	844
1@cata,230,195,0	duplicate(���ꂩ���̕�#1F_1F)	���ꂩ���̕�#1F_3F	844
1@cata,118,182,0	duplicate(���ꂩ���̕�#1F_1T)	���ꂩ���̕�#1F_4T	844
1@cata,118,182,0	duplicate(���ꂩ���̕�#1F_1F)	���ꂩ���̕�#1F_4F	844
1@cata,193,182,0	duplicate(���ꂩ���̕�#1F_1T)	���ꂩ���̕�#1F_5T	844
1@cata,193,182,0	duplicate(���ꂩ���̕�#1F_1F)	���ꂩ���̕�#1F_5F	844
1@cata,253,156,0	duplicate(���ꂩ���̕�#1F_1T)	���ꂩ���̕�#1F_6T	844
1@cata,253,156,0	duplicate(���ꂩ���̕�#1F_1F)	���ꂩ���̕�#1F_6F	844
1@cata,88,154,0		duplicate(���ꂩ���̕�#1F_1T)	���ꂩ���̕�#1F_7T	844
1@cata,88,154,0		duplicate(���ꂩ���̕�#1F_1F)	���ꂩ���̕�#1F_7F	844
1@cata,127,116,0	duplicate(���ꂩ���̕�#1F_1T)	���ꂩ���̕�#1F_8T	844
1@cata,127,116,0	duplicate(���ꂩ���̕�#1F_1F)	���ꂩ���̕�#1F_8F	844
1@cata,90,98,0		duplicate(���ꂩ���̕�#1F_1T)	���ꂩ���̕�#1F_9T	844
1@cata,90,98,0		duplicate(���ꂩ���̕�#1F_1F)	���ꂩ���̕�#1F_9F	844
1@cata,188,84,0		duplicate(���ꂩ���̕�#1F_1T)	���ꂩ���̕�#1F_10T	844
1@cata,188,84,0		duplicate(���ꂩ���̕�#1F_1F)	���ꂩ���̕�#1F_10F	844
1@cata,244,42,0		duplicate(���ꂩ���̕�#1F_1T)	���ꂩ���̕�#1F_11T	844
1@cata,244,42,0		duplicate(���ꂩ���̕�#1F_1F)	���ꂩ���̕�#1F_11F	844
1@cata,127,32,0		duplicate(���ꂩ���̕�#1F_1T)	���ꂩ���̕�#1F_12T	844
1@cata,127,32,0		duplicate(���ꂩ���̕�#1F_1F)	���ꂩ���̕�#1F_12F	844
1@cata,267,30,0		duplicate(���ꂩ���̕�#1F_1T)	���ꂩ���̕�#1F_13T	844
1@cata,267,30,0		duplicate(���ꂩ���̕�#1F_1F)	���ꂩ���̕�#1F_13F	844

1@cata,267,210,0	script	�h��߂�����#1	844,{
	if(getpartyleader(getcharid(1)) == strcharinfo(0)) {
		if((BAPHO_1QUE == 3) && (countitem(6001) < 10)) {
			mes "�]�^���ԂɔR���オ��";
			mes "�@���܂���������";
			mes "�@����ȏ������h��߂��Ă���]";
			next;
			mes "�]���̈З͂Ɉ��|����A�v�킸";
			mes "�@�ジ���肵�����ɂȂ������A";
			mes "�@�E�C���o���ď����Ɏ��L�΂��]";
			next;
			misceffect 152,"";
			getitem 6001,1;
			mes "�]���p�Y�̍���������";
			mes "�@�p���҂̈󂪌��肾���A";
			mes "�@�������珬������������̕���";
			mes "�@�����Ă����]";
			hideonnpc strnpcinfo(0);
			close;
		} else {
			mes "�]����ȏ�΂̐�����";
			mes "�@�W�߂�K�v�͂Ȃ��������]";
			close;
		}
	} else {
		mes "�]�^���ԂɔR���オ��";
		mes "�@���܂���������";
		mes "�@����ȏ������h��߂��Ă���]";
		next;
		mes "[���̕s���̐�]";
		mes "^C71585���Ȃ��͌p���҂ł͂Ȃ��c�c";
		mes "���̕s��Ȃ���";
		mes "�_���Ȃ�΂̐�����";
		mes "�������ƂȂ���c�c^000000";
		misceffect 50,"";
		percentheal -50,0;
		close;
	}
}

1@cata,85,182,0		duplicate(�h��߂�����#1)	�h��߂�����#2	844
1@cata,267,154,0	duplicate(�h��߂�����#1)	�h��߂�����#3	844
1@cata,157,139,0	duplicate(�h��߂�����#1)	�h��߂�����#4	844
1@cata,193,138,0	duplicate(�h��߂�����#1)	�h��߂�����#5	844
1@cata,193,102,0	duplicate(�h��߂�����#1)	�h��߂�����#6	844
1@cata,157,102,0	duplicate(�h��߂�����#1)	�h��߂�����#7	844
1@cata,113,112,0	duplicate(�h��߂�����#1)	�h��߂�����#8	844
1@cata,253,56,0		duplicate(�h��߂�����#1)	�h��߂�����#9	844
1@cata,239,56,0		duplicate(�h��߂�����#1)	�h��߂�����#10	844
1@cata,71,42,0		duplicate(�h��߂�����#1)	�h��߂�����#11	844
1@cata,155,14,0		duplicate(�h��߂�����#1)	�h��߂�����#12	844

//============================================================
// ���󂳂ꂽ�_�a2F
//------------------------------------------------------------
2@cata,80,144,0	script	BaphometControl2-1	139,3,3,{
	if(getpartyleader(getcharid(1)) == strcharinfo(0)) {
		mes "[���p�Y�̍�]";
		mes "������^FF0000�啕��Ւd^000000���B";
		mes "�܂��͒����̍Ւd�Ɍ������Ă���I";
		viewpoint 0,79,65,4,0x00FF00;
		initnpctimer;
		hideonnpc getmdnpcname("BaphometControl2-1");
		close;
	}
	end;

OnTimer10000:
	announce "�����o�t�H���b�g : ������̂悤�Ȑl�Ԃǂ��c�c�܂�����ז�������肩�c�c",0x9,0xdb7093;
	end;
OnTimer14000:
	announce "�o�t�H���b�g�̎g�k : �l�Ԃ��I�@�ז��Ȑl�Ԃǂ����N�������I",0x9,0xFFFF00;
	end;
OnTimer18000:
	announce "�o�t�H���b�g�̎g�k : �l�ԃh�����E�Z�I�@�S��l�l�m�����j�ז��i���݃n�S�e�׃Z�I",0x9,0xFFFF00;
	end;
OnTimer22000:
	announce "�o�t�H���b�g�̎g�k : �e����̉�̂��}���I�@�Ԃ��Ȃ�����l�l���������ɂȂ�c�c",0x9,0xFFFF00;
	stopnpctimer;
	end;
}

2@cata,50,67,0	script	BaphometLeftSlave	139,5,5,{
	announce "�o�t�H���b�g�̎g�k : �l�ԃh�����E�Z�I�@�S��l�l�m�����j�ז��i���݃n�S�e���Z�I",0x9,0xFFFF00;
	monster getmdmapname("2@cata"),55,67,"�o�t�H���b�g�̎g�k",1869,1;
	monster getmdmapname("2@cata"),51,67,"�o�t�H���b�g�̎g�k",1291,1;
	monster getmdmapname("2@cata"),58,67,"�o�t�H���b�g�̎g�k",1292,1;
	monster getmdmapname("2@cata"),53,67,"�o�t�H���b�g�̎g�k",1291,1;
	monster getmdmapname("2@cata"),54,67,"�o�t�H���b�g�̎g�k",1869,1;
	monster getmdmapname("2@cata"),55,67,"�o�t�H���b�g�̎g�k",1291,1;
	monster getmdmapname("2@cata"),56,67,"�o�t�H���b�g�̎g�k",1117,1;
	monster getmdmapname("2@cata"),58,66,"�o�t�H���b�g�̎g�k",1869,1;
	monster getmdmapname("2@cata"),56,66,"�o�t�H���b�g�̎g�k",1117,1;
	monster getmdmapname("2@cata"),60,66,"�o�t�H���b�g�̎g�k",1132,1;
	monster getmdmapname("2@cata"),59,66,"�o�t�H���b�g�̎g�k",1117,1;
	monster getmdmapname("2@cata"),54,66,"�o�t�H���b�g�̎g�k",1132,1;
	monster getmdmapname("2@cata"),55,66,"�o�t�H���b�g�̎g�k",1292,1;
	monster getmdmapname("2@cata"),56,66,"�o�t�H���b�g�̎g�k",1132,1;
	monster getmdmapname("2@cata"),50,65,"�o�t�H���b�g�̎g�k",1867,1;
	monster getmdmapname("2@cata"),61,65,"�o�t�H���b�g�̎g�k",1292,1;
	hideonnpc getmdnpcname("BaphometLeftSlave");
	end;
}

2@cata,109,67,0	script	BaphometRightSlave	139,5,5,{
	announce "�o�t�H���b�g�̎g�k : �l�ԃh�����E�Z�I�@�S��l�l�m�����j�ז��i���݃n�S�e���Z�I",0x9,0xFFFF00;
	monster getmdmapname("2@cata"),105,67,"�o�t�H���b�g�̎g�k",1869,1;
	monster getmdmapname("2@cata"),104,67,"�o�t�H���b�g�̎g�k",1291,1;
	monster getmdmapname("2@cata"),107,67,"�o�t�H���b�g�̎g�k",1869,1;
	monster getmdmapname("2@cata"),106,67,"�o�t�H���b�g�̎g�k",1291,1;
	monster getmdmapname("2@cata"),102,67,"�o�t�H���b�g�̎g�k",1869,1;
	monster getmdmapname("2@cata"),103,67,"�o�t�H���b�g�̎g�k",1291,1;
	monster getmdmapname("2@cata"),103,67,"�o�t�H���b�g�̎g�k",1117,1;
	monster getmdmapname("2@cata"),109,66,"�o�t�H���b�g�̎g�k",1117,1;
	monster getmdmapname("2@cata"),108,66,"�o�t�H���b�g�̎g�k",1132,1;
	monster getmdmapname("2@cata"),101,66,"�o�t�H���b�g�̎g�k",1117,1;
	monster getmdmapname("2@cata"),106,66,"�o�t�H���b�g�̎g�k",1292,1;
	monster getmdmapname("2@cata"),102,66,"�o�t�H���b�g�̎g�k",1132,1;
	monster getmdmapname("2@cata"),104,66,"�o�t�H���b�g�̎g�k",1292,1;
	monster getmdmapname("2@cata"),103,66,"�o�t�H���b�g�̎g�k",1132,1;
	monster getmdmapname("2@cata"),109,65,"�o�t�H���b�g�̎g�k",1867,1;
	monster getmdmapname("2@cata"),108,65,"�o�t�H���b�g�̎g�k",1292,1;
	hideonnpc getmdnpcname("BaphometRightSlave");
	end;
}

2@cata,79,39,0	script	BaphometDownSlave	139,5,5,{
	announce "�o�t�H���b�g�̎g�k : �l�ԃh�����E�Z�I�@�S��l�l�m�����j�ז��i���݃n�S�e���Z�I",0x9,0xFFFF00;
	monster getmdmapname("2@cata"),78,41,"�o�t�H���b�g�̎g�k",1869,1;
	monster getmdmapname("2@cata"),79,42,"�o�t�H���b�g�̎g�k",1291,1;
	monster getmdmapname("2@cata"),78,46,"�o�t�H���b�g�̎g�k",1869,1;
	monster getmdmapname("2@cata"),81,41,"�o�t�H���b�g�̎g�k",1291,1;
	monster getmdmapname("2@cata"),81,42,"�o�t�H���b�g�̎g�k",1869,1;
	monster getmdmapname("2@cata"),79,43,"�o�t�H���b�g�̎g�k",1291,1;
	monster getmdmapname("2@cata"),77,40,"�o�t�H���b�g�̎g�k",1117,1;
	monster getmdmapname("2@cata"),79,41,"�o�t�H���b�g�̎g�k",1132,1;
	monster getmdmapname("2@cata"),79,42,"�o�t�H���b�g�̎g�k",1117,1;
	monster getmdmapname("2@cata"),79,43,"�o�t�H���b�g�̎g�k",1132,1;
	monster getmdmapname("2@cata"),79,48,"�o�t�H���b�g�̎g�k",1117,1;
	monster getmdmapname("2@cata"),78,49,"�o�t�H���b�g�̎g�k",1132,1;
	monster getmdmapname("2@cata"),78,41,"�o�t�H���b�g�̎g�k",1292,1;
	monster getmdmapname("2@cata"),74,42,"�o�t�H���b�g�̎g�k",1292,1;
	monster getmdmapname("2@cata"),72,48,"�o�t�H���b�g�̎g�k",1867,1;
	monster getmdmapname("2@cata"),72,38,"�o�t�H���b�g�̎g�k",1292,1;
	hideonnpc getmdnpcname("BaphometDownSlave");
	end;
}

2@cata,79,81,0	script	���󖂖@�w#0	844,{
	if(!checkquest2(3041) || checkquest2(3041) & 0x2) {
		if(checkquest2(3041) & 0x2)
			delquest 3041;
		misceffect 87;
		hideonnpc getmdnpcname("���󖂖@�w#0");
		areamobuseskill getmdmapname("2@cata"),74,76,84,86,1929,686,1,0,0,26,0;
		percentheal -50,0;
		sc_start Eff_Stone,20000,0;
		setquest 3041;
		announce "����Ւd�ɖ��͂���������A���󂪔������܂����B",0x9,0x87ceeb;
		mes "�]����Ւd�Ŗ��͂𒍓�����ƁA";
		mes "�@��܂�������Ւd�̗͂�";
		mes "�@�Ăі߂��Ă���̂�������ꂽ�]";
		next;
		mes "�]����������Ւd�Ŗ��͂�";
		mes "�@���Ղ������߁A";
		mes "�@������3����";
		mes "�@���͂𒍓��ł��Ȃ��Ȃ����]";
		close;
	}
	else {
		misceffect 193,"";
		percentheal -50,0;
		sc_start Eff_Stone,30000,0;
		mes "�]�܂�����Ւd�ŏ��Ղ������͂�";
		mes "�@�߂��Ă��Ă��Ȃ��B";
		mes "�@����Ւd�ɖ��͂͒D��ꂽ���A";
		mes "�@����̗͖͂߂��Ă��Ȃ��悤���]";
		close;
	}
	end;
}

2@cata,123,109,0	script	���󖂖@�w#2	844,{
	if(!checkquest2(3041) || checkquest2(3041) & 0x2) {
		if(checkquest2(3041) & 0x2)
			delquest 3041;
		misceffect 87;
		hideonnpc getmdnpcname("���󖂖@�w#2");
		areamobuseskill getmdmapname("2@cata"),118,104,128,119,1929,686,1,0,0,26,0;
		percentheal -50,0;
		sc_start Eff_Stone,20000,0;
		setquest 3041;
		announce "����Ւd�ɖ��͂���������A���󂪔������܂����B",0x9,0x87ceeb;
		mes "�]����Ւd�Ŗ��͂𒍓�����ƁA";
		mes "�@��܂�������Ւd�̗͂�";
		mes "�@�Ăі߂��Ă���̂�������ꂽ�]";
		next;
		mes "�]����������Ւd�Ŗ��͂�";
		mes "�@���Ղ������߁A";
		mes "�@������3����";
		mes "�@���͂𒍓��ł��Ȃ��Ȃ����]";
		close;
	}
	else {
		misceffect 193,"";
		percentheal -50,0;
		sc_start Eff_Stone,30000,0;
		mes "�]�܂�����Ւd�ŏ��Ղ������͂�";
		mes "�@�߂��Ă��Ă��Ȃ��B";
		mes "�@����Ւd�ɖ��͂͒D��ꂽ���A";
		mes "�@����̗͖͂߂��Ă��Ȃ��悤���]";
		close;
	}
	end;
}

2@cata,123,22,0	script	���󖂖@�w#4	844,{
	if(!checkquest2(3041) || checkquest2(3041) & 0x2) {
		if(checkquest2(3041) & 0x2)
			delquest 3041;
		misceffect 87;
		hideonnpc getmdnpcname("���󖂖@�w#4");
		areamobuseskill getmdmapname("2@cata"),118,17,128,27,1929,686,1,0,0,26,0;
		percentheal -50,0;
		sc_start Eff_Stone,20000,0;
		setquest 3041;
		announce "����Ւd�ɖ��͂���������A���󂪔������܂����B",0x9,0x87ceeb;
		mes "�]����Ւd�Ŗ��͂𒍓�����ƁA";
		mes "�@��܂�������Ւd�̗͂�";
		mes "�@�Ăі߂��Ă���̂�������ꂽ�]";
		next;
		mes "�]����������Ւd�Ŗ��͂�";
		mes "�@���Ղ������߁A";
		mes "�@������3����";
		mes "�@���͂𒍓��ł��Ȃ��Ȃ����]";
		close;
	}
	else {
		misceffect 193,"";
		percentheal -50,0;
		sc_start Eff_Stone,30000,0;
		mes "�]�܂�����Ւd�ŏ��Ղ������͂�";
		mes "�@�߂��Ă��Ă��Ȃ��B";
		mes "�@����Ւd�ɖ��͂͒D��ꂽ���A";
		mes "�@����̗͖͂߂��Ă��Ȃ��悤���]";
		close;
	}
	end;
}

2@cata,35,21,0	script	���󖂖@�w#8	844,{
	if(!checkquest2(3041) || checkquest2(3041) & 0x2) {
		if(checkquest2(3041) & 0x2)
			delquest 3041;
		misceffect 87;
		hideonnpc getmdnpcname("���󖂖@�w#8");
		areamobuseskill getmdmapname("2@cata"),30,16,40,26,1929,686,1,0,0,26,0;
		percentheal -50,0;
		sc_start Eff_Stone,20000,0;
		setquest 3041;
		announce "����Ւd�ɖ��͂���������A���󂪔������܂����B",0x9,0x87ceeb;
		mes "�]����Ւd�Ŗ��͂𒍓�����ƁA";
		mes "�@��܂�������Ւd�̗͂�";
		mes "�@�Ăі߂��Ă���̂�������ꂽ�]";
		next;
		mes "�]����������Ւd�Ŗ��͂�";
		mes "�@���Ղ������߁A";
		mes "�@������3����";
		mes "�@���͂𒍓��ł��Ȃ��Ȃ����]";
		close;
	}
	else {
		misceffect 193,"";
		percentheal -50,0;
		sc_start Eff_Stone,30000,0;
		mes "�]�܂�����Ւd�ŏ��Ղ������͂�";
		mes "�@�߂��Ă��Ă��Ȃ��B";
		mes "�@����Ւd�ɖ��͂͒D��ꂽ���A";
		mes "�@����̗͖͂߂��Ă��Ȃ��悤���]";
		close;
	}
	end;
}

2@cata,35,109,0	script	���󖂖@�w#10	844,{
	if(!checkquest2(3041) || checkquest2(3041) & 0x2) {
		if(checkquest2(3041) & 0x2)
			delquest 3041;
		misceffect 87;
		hideonnpc getmdnpcname("���󖂖@�w#10");
		areamobuseskill getmdmapname("2@cata"),30,104,40,114,1929,686,1,0,0,26,0;
		percentheal -50,0;
		sc_start Eff_Stone,20000,0;
		setquest 3041;
		announce "����Ւd�ɖ��͂���������A���󂪔������܂����B",0x9,0x87ceeb;
		mes "�]����Ւd�Ŗ��͂𒍓�����ƁA";
		mes "�@��܂�������Ւd�̗͂�";
		mes "�@�Ăі߂��Ă���̂�������ꂽ�]";
		next;
		mes "�]����������Ւd�Ŗ��͂�";
		mes "�@���Ղ������߁A";
		mes "�@������3����";
		mes "�@���͂𒍓��ł��Ȃ��Ȃ����]";
		close;
	}
	else {
		misceffect 193,"";
		percentheal -50,0;
		sc_start Eff_Stone,30000,0;
		mes "�]�܂�����Ւd�ŏ��Ղ������͂�";
		mes "�@�߂��Ă��Ă��Ȃ��B";
		mes "�@����Ւd�ɖ��͂͒D��ꂽ���A";
		mes "�@����̗͖͂߂��Ă��Ȃ��悤���]";
		close;
	}
	end;
}

2@cata,79,65,0	script	�啕��Ւd#ss	844,{
	if((BAPHO_1QUE == 5) && (getpartyleader(getcharid(1)) == strcharinfo(0))) {
		mes "�]���F�ɋP��";
		mes "�@����ȕ���Ւd�̉���";
		mes "�@���t�ɂ�����̐��܂������̋C�z��";
		mes "�@忂��Ă���c�c�]";
		next;
		mes "�]���ɂ�������������������";
		mes "�@���͋C���]";
		next;
		mes "�]����Ւd�̏����傫���h��o���A";
		mes "�@���̌������P���Ă���I�]";
		next;
		misceffect 92;
		misceffect 92;
		mes "[" +strcharinfo(0)+ "]";
		if(Sex)
			mes "�݂�ȁA�C������񂾁I";
		else
			mes "�݂�ȁA�C�����āI";
		mes "�������ߊ���Ă���!!";
		setpartyinmap BAPHO_1QUE,6;
		initnpctimer;
		hideonnpc getmdnpcname("�啕��Ւd#ss");
		close;
	}
	mes "�]���F�ɋP��";
	mes "�@����ȕ���Ւd�̉���";
	mes "�@���t�ɂ�����̐��܂������̋C�z��";
	mes "�@忂��Ă���c�c�]";
	next;
	mes "�]���ɂ�������������������";
	mes "�@���͋C���]";
	close;

OnTimer2000:
	announce "���p�Y�̍� : ��ς��I�@�啕��Ւd�̗͂��キ�Ȃ��Ă����c�c���̂܂܂ł͖����o�t�H���b�g���o�Ă���̂����Ԃ̖�肾�B",0x9,0xFFFF00;
	end;
OnTimer7000:
	announce "�����o�t�H���b�g : �t�t�t�c�c������x�ꂾ�A�l�Ԃǂ��B�����ɂ��O��ɂ͎����K���ł��낤�c�c",0x9,0xdb7093;
	end;
OnTimer12000:
	announce "�����o�t�H���b�g : �n�b�n�b�n�I�@�����ł͂��O��̍U���Ȃ񂼁A���̖��ɂ�������I�@��l���������󂯓���邪�����I",0x9,0xdb7093;
	donpcevent getmdnpcname("BaphometControl2-2")+"::OnStart";
	donpcevent getmdnpcname("BaphometControl2-3")+"::OnStart";
	stopnpctimer;
	end;
}

2@cata,80,63,4	script	���p�Y�̍�#2F	411,{
	cutin "ins_cata_champ_s",2;
	if(checkquest2(3041)) delquest 3041;
	mes "[���p�Y�̍�]";
	mes "�悭����Ă��ꂽ�B";
	mes "���̎q��������c�c";
	mes "�N�����́A���Ǝ��̒��Ԃ̊肢��";
	mes "�����Ă��ꂽ�c�c";
	mes "�{���ɂ��肪�Ƃ��c�c";
	next;
	mes "[���p�Y�̍�]";
	mes "�����A����őS�Ă�";
	mes "�I�����킯�ł͂Ȃ��c�c";
	mes "�������A�N�����̂悤�ȗ��h��";
	mes "�`���҂��������̒n�ɂ����";
	mes "���������ȏ�c�c";
	mes "���̖�ڂ������܂ł��낤�c�c";
	next;
	switch(select("�_�a�̊O�ɏo�����ł�","��b����߂�")) {
	case 1:
		mes "[���p�Y�̍�]";
		mes "�悩�낤�B";
		mes "�ł́A�N�����𖳎��ɂ�������";
		mes "�o���Ă����悤�B";
		next;
		mes "[���p�Y�̍�]";
		mes "����肢������񂾂��c�c";
		mes "�O�̃p�g���b�N�Ɉ��ۂ�`���Ăق����B";
		mes "�ł͎��̎q���B��c�c";
		mes "���ꂩ������ɋ�����";
		mes "���X�Ɛ����Ă����Ă���B";
		close2;
		set BAPHO_1QUE,0;
		cutin "ins_cata_champ_s",255;
		warp "monk_test",310,150;
		end;
	case 2:
		// ������
		mes "[���p�Y�̍�]";
		mes "�������B";
		mes "�����A�����ɒ������܂�";
		mes "���Ƃ͂ł��Ȃ����B";
		close2;
		cutin "ins_cata_champ_s",255;
		end;
	}
}

2@cata,3,3,0	script	BaphometControl2-2	-1,{
OnStart:
	donpcevent getmdnpcname("BaphometSlaveTimer")+"::OnStart";
	monster getmdmapname("2@cata"),79,64,"�����o�t�H���b�g",1929,1,getmdnpcname("BaphometControl2-2")+"::OnMyMobDead";
	end;

OnMyMobDead:
	setpartyinmap BAPHO_1QUE,7;
	announce "�����o�t�H���b�g : �O�I�I�I�I�H�H!!�@���A����Ȃ͂��ł́c�c�I�@�䂪�c�c���̉䂪�Ăђ�����̂悤�Ȑl�Ԃɂ����c�c���Ɓc�c!!",0x9,0xdb7093;
	hideoffnpc getmdnpcname("���p�Y�̍�#2F");
	hideonnpc getmdnpcname("BaphometDownSlave");
	hideonnpc getmdnpcname("BaphometLeftSlave");
	hideonnpc getmdnpcname("BaphometRightSlave");
	donpcevent getmdnpcname("BaphometTimer2")+"::OnClose";
	stopnpctimer getmdnpcname("BaphometSlaveTimer");
	hideonnpc;
	end;
}

2@cata,2,2,0	script	BaphometControl2-3	-1,{
OnStart:
	initnpctimer;
	end;

OnTimer8000:
	announce "���p�Y�̍� : �Q�Ă�ȁA���̎q��������B�����o�t�H���b�g�̖��G���͈ꎟ�I�Ȍ��ۂɂ����Ȃ��B",0x9,0xFFFF00;
	end;

OnTimer12000:
	announce "���p�Y�̍� : �����玄�����������̕���Ւd�ɍs���A���͂𒍓����A���������������̂��B",0x9,0xFFFF00;
	end;

OnTimer16000:
	announce "���p�Y�̍� : ���͂���������A���󂪍Ăї͂����߂������A�����o�t�H���b�g�̗͎͂�܂邾�낤�B",0x9,0xFFFF00;
	end;

OnTimer20000:
	announce "���p�Y�̍� : �������A���͂𒍓�����Ƃ��͕���̏��܂Ŗ����o�t�H���b�g��A��Ă����Ȃ���΂Ȃ�Ȃ��B�K�������o�t�H���b�g��U���Ȃ��畕������������Ȃ���΂����Ȃ��̂��B",0x9,0xFFFF00;
	end;

OnTimer24000:
	announce "���p�Y�̍� : �����o�t�H���b�g�̗͂����S�ɂȂ�܂ł���1���Ԃ����c���Ă��Ȃ��B���Ԃ��߂���ƕ���Ւd�͉��̖��ɂ������Ȃ��Ȃ�B",0x9,0xFFFF00;
	end;

OnTimer28000:
	announce "�����o�t�H���b�g : ���ʂ��I�@����ȕn��ȕ���ȂǁA���x�ł��ׂ��Ă��B��l���������Ă͕Ԃ��ʂ��I",0x9,0xdb7093;
	end;

OnTimer32000:
	announce "���p�Y�̍� : �z�̌��t�Ɏ���݂��ȁI�@�����̕���Ւd�̖��͂��キ�Ȃ��Ă����c�c�I�@�}���œz��U���o���A�����̕���Ւd�ɖ��͂𒍓�����̂��B",0x9,0xFFFF00;
	hideoffnpc getmdnpcname("���󖂖@�w#0");
	hideonnpc getmdnpcname("���󖂖@�w#2");
	hideonnpc getmdnpcname("���󖂖@�w#4");
	hideonnpc getmdnpcname("���󖂖@�w#8");
	hideonnpc getmdnpcname("���󖂖@�w#10");
	donpcevent getmdnpcname("BaphometTimer1")+"::OnStart";
	donpcevent getmdnpcname("BaphometTimer2")+"::OnStart";
	stopnpctimer;
	end;
}

2@cata,4,2,0	script	BaphometSlaveTimer	-1,{
OnStart:
	initnpctimer;
	end;

OnTimer300000:
	hideoffnpc getmdnpcname("BaphometDownSlave");
	hideoffnpc getmdnpcname("BaphometLeftSlave");
	hideoffnpc getmdnpcname("BaphometRightSlave");
	initnpctimer;
	end;
}

2@cata,3,1,0	script	BaphometTimer2	-1,{
OnStart:
	initnpctimer;
	end;

OnClose:
	stopnpctimer;
	hideonnpc getmdnpcname("���󖂖@�w#0");
	hideonnpc getmdnpcname("���󖂖@�w#2");
	hideonnpc getmdnpcname("���󖂖@�w#4");
	hideonnpc getmdnpcname("���󖂖@�w#8");
	hideonnpc getmdnpcname("���󖂖@�w#10");
	stopnpctimer getmdnpcname("BaphometTimer1");
	end;

OnTimer3600000:
	announce "�����o�t�H���b�g : �O�n�n�n�n�c�c���ꂩ��͕���Ւd���Ƃ��ł͉��}���邱�ƂȂǏo���ʁB��l��������҂������I",0x9,0xdb7093;
	end;

OnTimer3605000:
	announce "���p�Y�̍� : ����ȏ㕕��Ւd�̖��͂ł͖����o�t�H���b�g��}���鎖���ł��Ȃ��c�c���͂␬�����ׂ͂Ȃ��̂��c�c",0x9,0xFFFF00;
	donpcevent getmdnpcname("BaphometTimer2")+"::OnClose";
	end;
}

2@cata,3,2,0	script	BaphometTimer1	-1,{
OnStart:
	initnpctimer;
	end;

OnTimer70000:
	switch(rand(1,5)) {
	case 1:
		announce "���p�Y�̍� : �����̕���Ւd�̖��͂��キ�Ȃ��Ă����c�c�I�@�}���Œ����̕���Ւd�ɖ����o�t�H���b�g��U���o������ԂŖ��͂𒍓�����񂾁B",0x9,0xFFFF00;
		hideoffnpc getmdnpcname("���󖂖@�w#0");
		hideonnpc getmdnpcname("���󖂖@�w#2");
		hideonnpc getmdnpcname("���󖂖@�w#4");
		hideonnpc getmdnpcname("���󖂖@�w#8");
		hideonnpc getmdnpcname("���󖂖@�w#10");
		break;
	case 2:
		announce "���p�Y�̍� : �k�������ɂ��镕��Ւd�̖��͂��キ�Ȃ��Ă����B�}���Ŗk�������ɂ��镕��Ւd�ɖ����o�t�H���b�g��U���o������ԂŖ��͂𒍓�����񂾁B",0x9,0xFFFF00;
		hideonnpc getmdnpcname("���󖂖@�w#0");
		hideoffnpc getmdnpcname("���󖂖@�w#2");
		hideonnpc getmdnpcname("���󖂖@�w#4");
		hideonnpc getmdnpcname("���󖂖@�w#8");
		hideonnpc getmdnpcname("���󖂖@�w#10");
		break;
	case 3:
		announce "���p�Y�̍� : �쓌�����ɂ��镕��Ւd�̖��͂��キ�Ȃ��Ă����B�}���œ쓌�����ɂ��镕��Ւd�ɖ����o�t�H���b�g��U���o������ԂŖ��͂𒍓�����񂾁B",0x9,0xFFFF00;
		hideonnpc getmdnpcname("���󖂖@�w#0");
		hideonnpc getmdnpcname("���󖂖@�w#2");
		hideoffnpc getmdnpcname("���󖂖@�w#4");
		hideonnpc getmdnpcname("���󖂖@�w#8");
		hideonnpc getmdnpcname("���󖂖@�w#10");
		break;
	case 4:
		announce "���p�Y�̍� : �쐼�����ɂ��镕��Ւd�̖��͂��キ�Ȃ��Ă����B�}���œ쐼�����ɂ��镕��Ւd�ɖ����o�t�H���b�g��U���o������ԂŖ��͂𒍓�����񂾁B",0x9,0xFFFF00;
		hideonnpc getmdnpcname("���󖂖@�w#0");
		hideonnpc getmdnpcname("���󖂖@�w#2");
		hideonnpc getmdnpcname("���󖂖@�w#4");
		hideoffnpc getmdnpcname("���󖂖@�w#8");
		hideonnpc getmdnpcname("���󖂖@�w#10");
		break;
	case 5:
		announce "���p�Y�̍� : �k�������ɂ��镕��Ւd�̖��͂��キ�Ȃ��Ă����B�}���Ŗk�������ɂ��镕��Ւd�ɖ����o�t�H���b�g��U���o������ԂŖ��͂𒍓�����񂾁B",0x9,0xFFFF00;
		hideonnpc getmdnpcname("���󖂖@�w#0");
		hideonnpc getmdnpcname("���󖂖@�w#2");
		hideonnpc getmdnpcname("���󖂖@�w#4");
		hideonnpc getmdnpcname("���󖂖@�w#8");
		hideoffnpc getmdnpcname("���󖂖@�w#10");
	}
	initnpctimer;
	end;
}