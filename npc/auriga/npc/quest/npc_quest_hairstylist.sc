//=============================================================================
// Ragnarok Online Hairstylist Etc Script   2005-06-13     by AthenaWiki
//=============================================================================

alberta_in,55,142,7	script	�w�A�[�f�U�C�i�[	91,{
	mes "[�x���j�J]";
	mes "��������Ⴂ�܂��B";
	mes "������͐��E�I�ȃw�A�[�f�U�C�i�[";
	mes "�x���j�J�̃r���[�e�B�[�T�����ł��B";
	mes "���ققفc�c";
	next;
	mes "[�x���j�J]";
	mes "���^��ς��ɂ�����������";
	mes "�̂ł��傤�H";
	mes "�����A�ǂ����������";
	mes "���������������B";
	mes "���āA�ǂ��������܂��傤���H";
	next;
	switch (select("�w�A�[�X�^�C��������","�w�A�[�X�^�C����ς���","�b����߂�")) {
	case 1:
		mes "[�x���j�J]";
		mes "�w�A�[�X�^�C����19��ނ������܂��B";
		mes "�ǂ�����������܂��傤���H";
		mes "1����19�܂ł̂���]�̔��^�̔ԍ���";
		mes "����������Ă��������B";
		mes "���Ɍ������ԍ����������";
		mes "0�����I�щ������B";
		next;
		input .@hair;
		if(.@hair==0) {
			mes "[�x���j�J]";
			mes "����������܂������H";
			mes "�����ɂȂ肽�����^��";
			mes "�������܂�����A���ł�";
			mes "�����������Ă��������ˁB";
			close;
		}
		if(.@hair<0 || .@hair>19) {
			mes "[�x���j�J]";
			mes "����A���̔ԍ��̔��^�͂������܂���B";
			mes "1����19�܂ł̒�����";
			mes "���I�щ������B";
			close;
		}
		if(Sex) {
			switch(.@hair) {
			case 1:
				cutin "hair_m_01",4;
				mes "[�x���j�J]";
				mes "�u���񂾐U��v�X�^�C���ł��ˁI";
				mes "�i�₩�ł̂т₩�Ȃ̂������ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 2:
				cutin "hair_m_02",4;
				mes "[�x���j�J]";
				mes "�u���茕�C���v�X�^�C���ł��ˁI";
				mes "�L���Ȍ��m�̔��^�Ɏ��Ă��܂��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 3:
				cutin "hair_m_03",4;
				mes "[�x���j�J]";
				mes "�u�i�p�[���r�[�g�v�X�^�C���ł��ˁI";
				mes "���m�̗͂��������锯�^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 4:
				cutin "hair_m_04",4;
				mes "[�x���j�J]";
				mes "�u�_�u���X�g���C�t�B���O�v�X�^�C���ł��ˁI";
				mes "�S�����炩�Ɍ����锯�^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 5:
				cutin "hair_m_05",4;
				mes "[�x���j�J]";
				mes "�u�G���W�F���X�v�X�^�C���ł��ˁI";
				mes "���Â��ő����Ȋ��������锯�^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 6:
				cutin "hair_m_06",4;
				mes "[�x���j�J]";
				mes "�u�v�b�V���J�[�g�v�X�^�C���ł��ˁI";
				mes "���������J�[�g�����`�[�t�ɂ���";
				mes "���^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 7:
				cutin "hair_m_07",4;
				mes "[�x���j�J]";
				mes "�u�C���x�i���v�X�^�C���ł��ˁI";
				mes "���ƂȂ��ŁX�������^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 8:
				cutin "hair_m_08",4;
				mes "[�x���j�J]";
				mes "�u�{�E�����O�o�b�V���v";
				mes "�X�^�C���ł��ˁI";
				mes "��x�U������Ή��l����";
				mes "����Ă��܂������Ȕ��^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 9:
				cutin "hair_m_09",4;
				mes "[�x���j�J]";
				mes "�u�x�i���_�X�g�v�X�^�C���ł��ˁI";
				mes "�댯�Ȗ��͂�������X�^�C���ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 10:
				cutin "hair_m_10",4;
				mes "[�x���j�J]";
				mes "�u�^�[���A���f�b�h�v�X�^�C���ł��ˁI";
				mes "������ނ������Ȋ��������锯�^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 11:
				cutin "hair_m_11",4;
				mes "[�x���j�J]";
				mes "�u�h���S�m���W�[�v�X�^�C���ł��ˁI";
				mes "���������`�[�t�ɂ������^�ł��ˁB";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 12:
				cutin "hair_m_12",4;
				mes "[�x���j�J]";
				mes "�u���C�X�C���v�X�^�C���ł��ˁI";
				mes "�d�����Ȋ��������锯�^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 13:
				cutin "hair_m_13",4;
				mes "[�x���j�J]";
				mes "�u�T���_�[�X�g�[���v�X�^�C���ł��ˁI";
				mes "�܂��Ɉ�Ȃ̂悤�Ȕ��^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 14:
				cutin "hair_m_14",4;
				mes "[�x���j�J]";
				mes "�u�A���R�[���v�X�^�C���ł��ˁI";
				mes "�̂��̂��ė~�����Ȃ锯�^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 15:
				cutin "hair_m_15",4;
				mes "[�x���j�J]";
				mes "�u�O�����g�D�[�X�v�X�^�C���ł��ˁI";
				mes "���Ǝh���肻���Ȕ��^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 16:
				cutin "hair_m_16",4;
				mes "[�x���j�J]";
				mes "�u�u���b�c�r�[�g�v�X�^�C���ł��ˁI";
				mes "5�񂭂炢�����������Ă������Ȕ��^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 17:
				cutin "hair_m_17",4;
				mes "[�x���j�J]";
				mes "�u�z�Δ����v�X�^�C���ł��ˁI";
				mes "�F��ȃ��m�𔭌��ł������Ȕ��^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 18:
				cutin "hair_m_18",4;
				mes "[�x���j�J]";
				mes "�u�t�@�C�A�s���[�v�X�^�C���ł��ˁI";
				mes "���������������锯�^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 19:
				cutin "hair_m_19",4;
				mes "[�x���j�J]";
				mes "�u���C���e�����v�X�^�C���ł��ˁI";
				mes "�����������鎞�ɂӂ��킵��";
				mes "���^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			}
		}
		else {
			switch(.@hair) {
			case 1:
				cutin "hair_f_01",4;
				mes "[�x���j�J]";
				mes "�u���}�蓖�v�X�^�C���ł��ˁI";
				mes "�v�킸�i�f�i�f�������Ȃ�";
				mes "���^���Ǝv���܂��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 2:
				cutin "hair_f_02",4;
				mes "[�x���j�J]";
				mes "�u�o�b�V���v�X�^�C���ł��ˁI";
				mes "�B�ꂽ�����͂��������锯�^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 3:
				cutin "hair_f_03",4;
				mes "[�x���j�J]";
				mes "�u�t���X�g�_�C�o�[�v�X�^�C���ł��ˁI";
				mes "�₽���̒��ɂ�����������������";
				mes "���^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 4:
				cutin "hair_f_04",4;
				mes "[�x���j�J]";
				mes "�u�A���[�V�����[�v�X�^�C���ł��ˁI";
				mes "�����Ȋ��������锯�^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 5:
				cutin "hair_f_05",4;
				mes "[�x���j�J]";
				mes "�u�q�[���v�X�^�C���ł��ˁI";
				mes "�S��������銴���̃X�^�C���ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 6:
				cutin "hair_f_06",4;
				mes "[�x���j�J]";
				mes "�u�I�X�J�݁v�X�^�C���ł��ˁI";
				mes "���^���㏸�������Ȕ��^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 7:
				cutin "hair_f_07",4;
				mes "[�x���j�J]";
				mes "�u�_�u���A�^�b�N�v�X�^�C���ł��ˁI";
				mes "���΂₭���������Ȃ�悤�Ȕ��^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 8:
				cutin "hair_f_08",4;
				mes "[�x���j�J]";
				mes "�u�O�����A�v�X�^�C���ł��ˁI";
				mes "�C�����Đ_���ȕ��͋C���Y�����^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 9:
				cutin "hair_f_09",4;
				mes "[�x���j�J]";
				mes "�uSP�񕜗͌���v�X�^�C���ł��ˁI";
				mes "���_�͂����銴�������锯�^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 10:
				cutin "hair_f_10",4;
				mes "[�x���j�J]";
				mes "�u�t�H�[�}�V�[�v�X�^�C���ł��ˁI";
				mes "�Ȃ񂾂��̂̏������肻���Ȕ��^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 11:
				cutin "hair_f_11",4;
				mes "[�x���j�J]";
				mes "�u�O�����h�N���X�v�X�^�C���ł��ˁI";
				mes "�����M�������Ă����Ȕ��^�ł��ˁB";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 12:
				cutin "hair_f_12",4;
				mes "[�x���j�J]";
				mes "�u�N���[���X�L���v�X�^�C���ł��ˁI";
				mes "�ǂ����Ō����悤�Ȕ��^�ł��ˁB";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 13:
				cutin "hair_f_13",4;
				mes "[�x���j�J]";
				mes "�u�C�D�v�X�^�C���ł��ˁI";
				mes "���Ă���Ɨ������݂����Ȕ��^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 14:
				cutin "hair_f_14",4;
				mes "[�x���j�J]";
				mes "�u�T�[�r�X�t�H�[���[�v";
				mes "�X�^�C���ł��ˁI";
				mes "�D�������͋C���Y�����^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 15:
				cutin "hair_f_15",4;
				mes "[�x���j�J]";
				mes "�u�I�[�g�J�E���^�[�v�X�^�C���ł��ˁI";
				mes "�ނ�݂ɋߕt���Δ������ꂻ����";
				mes "���^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 16:
				cutin "hair_f_16",4;
				mes "[�x���j�J]";
				mes "�u�A���N���X�l�A�v�X�^�C���ł��ˁI";
				mes "�Ђ��������ē����ɂ������Ȕ��^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 17:
				cutin "hair_f_17",4;
				mes "[�x���j�J]";
				mes "�u�n���}�[�t�H�[���v�X�^�C���ł��ˁI";
				mes "������Ƃ���ʑf�G�Ȕ��^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 18:
				cutin "hair_f_18",4;
				mes "[�x���j�J]";
				mes "�u���s�e���T���_�[�v�X�^�C���ł��ˁI";
				mes "�s���b�Ƃ��Ă���₩�Ȕ��^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			case 19:
				cutin "hair_f_19",4;
				mes "[�x���j�J]";
				mes "�u�o�C�I�����g�Q�C���v�X�^�C���ł���";
				mes "�I";
				mes "����镗�̂悤�ɗ��������^�ł��B";
				mes "�ǂ��ł��H���C�ɏ����܂������H";
				close;
			}
		}
	case 2:
		if(BaseLevel < 60) {
			mes "[�x���j�J]";
			mes "����A���q�l�B";
			mes "���̃X�^�C������Ԃ��������ł���B";
			mes "���^�ł͂Ȃ���������A�����W�����";
			mes "�݂Ă͂������ł��傤���B";
			close;
		}
		if(countitem(973) < 3 || countitem(974) < 3 || countitem(901) < 100 || countitem(1094) < 100 ||
							countitem(1020) < 100 || countitem(7152) < 100 || Zeny < 99800) {
			mes "[�x���j�J]";
			mes "�w�A�[�X�^�C����ς��邽�߂ɂ�";
			mes "�������������Ă��������Ȃ��Ă�";
			mes "�Ȃ�Ȃ����̂��������܂��B";
			mes "���ꂩ��\���グ�܂���";
			mes "���X�A��ނ������̂�";
			mes "���ӂ��Ă��������������B";
			next;
			mes "[�x���j�J]";
			mes "�܂��ޗ��́A���a��3�A������3��";
			mes "�s�b�O�e�[�����{��100��";
			mes "�Z���s�b�O�e�[�����{��100��";
			mes "������100�A�����̔�100��";
			mes "��₩�Ȕ�100�ɂȂ�܂��B";
			next;
			mes "[�x���j�J]";
			mes "�����Ď萔���Ƃ���";
			mes "99,800�[�j�[��";
			mes "���������Ă���܂��B";
			next;
			mes "[�x���j�J]";
			mes "���p�ӂ��ł��܂�����";
			mes "���ł����������������B";
			mes "�ł͂��҂����Ă���܂��B";
			mes "���قققفB";
			close;
		}
		mes "[�x���j�J]";
		mes "�w�A�J�b�g����̂ł���!!";
		mes "����Ǝ��̏o�Ԃ���c";
		mes "�����A�ǂ̔��^�ɂ���́H";
		mes "�����I��ł��傤�����I";
		next;
		input .@hair;
		if(.@hair==0) break;
		if(.@hair<0 || .@hair>19) {
			mes "[�x���j�J]";
			mes "����A���̔ԍ��̔��^�͂������܂���B";
			mes "1����19�܂ł̒����炨�I�щ������B";
			close;
		}
		mes "[�x���j�J]";
		mes "�킩������B";
		mes "�킽���ɔC���āc�I";
		next;
		setlook 1,.@hair;
		delitem 973,3;
		delitem 974,3;
		delitem 901,100;
		delitem 1094,100;
		delitem 1020,100;
		delitem 7152,100;
		set Zeny,Zeny-99800;
		mes "[�x���j�J]";
		mes "�����A�I�������";
		mes "�ǂ��H�C�ɓ������H";
		close;
	case 3:
		break;
	}
	mes "[�x���j�J]";
	mes "�l�ɂ͒N�ɂł��������Ȃ錠����";
	mes "����܂��B";
	mes "�������ɂ��������̔��^��";
	mes "�����Ă������������ł��B";
	close;
}

alberta,33,141,7	script	���Q���e�t	87,{
	mes "[�`���[���[�@�r�V�F��]";
	mes "�w�C�I";
	mes "����ȂƂ���܂ł��O�����m�D���ˁI";
	mes "�䂱���́u�^�̔��Ƃ͉����I�v";
	mes "���ꂪ�킩��҂Ȃ̂��I";
	next;
	switch (select("�����Ă�l�ł����H","�^�̔������ɂ���������","�c�c")) {
	case 1:
		mes "[�`���[���[�@�r�V�F��]";
		mes "�w�C�I";
		mes "���̓Y�o�����e�t���B";
		mes "���E�𗷂��Đl�X�ɔ����v���[���g";
		mes "���邱�Ƃ𐶂������Ƃ��Ă���I";
		mes "�Ƃ���ŁA���̊X�Ƀw�A�[�f�U�C�i�[";
		mes "�����̂��Ă��鏬���������炵���ȁB";
		next;
		mes "[�`���[���[�@�r�V�F��]";
		mes "������Ɨl�q�����Ă݂���A";
		mes "�q�͎����̍D���Ȕ��^�𗊂�ł����B";
		mes "�����`���I";
		mes "����ł͂�����̂���I";
		mes "���܂��΂��Ƃ�������Ȃ����`�ł�";
		mes "�����ʂ�ɂ��Ă��܂��Ă���B";
		next;
		mes "[�`���[���[�@�r�V�F��]";
		mes "����������؂�Z�p���S�R���n���ˁI";
		mes "����ł͔��e�t�Ƃ͌����Ȃ��B";
		mes "���͐؂�Ηǂ����Ă��񂶂�Ȃ��B";
		mes "�܂������C�ɓ����ˁB";
		next;
		mes "[�`���[���[�@�r�V�F��]";
		mes "�������O������������v���[���g";
		mes "���Ă��炢������΁A���ł�";
		mes "�����Ă��ꂽ�܂��B";
		mes "���ʂɔ������d�グ�Ă�邼�B";
		mes "����Ȃ��ق炵�����e�t��";
		mes "�C���Ă͂�����B";
		close;
	case 2:
		if(BaseLevel < 60) {
			mes "[�`���[���[�@�r�V�F��]";
			mes "�w�C�I";
			mes "���̌|�p�I�ȃZ���X�Ɍ��킹���";
			mes "���O�Ɉ�Ԃ悭���������`��";
			mes "���̂��̃X�^�C�����B";
			mes "���̌������ƂɊԈႢ�͂Ȃ��B";
			close;
		}
		if(Zeny<199800) {
			mes "[�`���[���[�@�r�V�F��]";
			mes "�w�C�I";
			mes "���̕��͉����v��Ȃ��B";
			mes "�Ƃɂ����[�j�[���I";
			mes "����炠�̏���������������";
			mes "���Ƃ����Ă���݂��������c�c";
			mes "���A���₱�����̂��Ƃ��B";
			next;
			mes "[�`���[���[�@�r�V�F��]";
			mes "199,800�[�j�[��";
			mes "�N�ɂł����𕪂��Ă��B";
			mes "���h�Ɏv���I";
			close;
		}
		mes "[�`���[���[�@�r�V�F��]";
		mes "�悵�A�萔���Ƃ���";
		mes "199,800�[�j�[�����炤�B";
		mes "���̋U�Ҕ��e�t�ɂ��܂������";
		mes "�͂邩�ɗǂ����낤�B";
		next;
		if(select("���肢���܂�","����ς��߂܂�")==2) {
			mes "[�`���[���[�@�r�V�F��]";
			mes "�t���I�D���ɂ���I";
			mes "�^�̔������͐E�l�̎肩��";
			mes "���܂��̂��Ƃ����^����";
			mes "�����m�邱�ƂɂȂ�c�c";
			close;
		}
		mes "[�`���[���[�@�r�V�F��]";
		mes "�w�C�I";
		mes "�����񂶂�`�Ȃ����I";
		next;
		nude;
		mes "[�`���[���[�@�r�V�F��]";
		mes "�t�I�I�I�I�I";
		mes "�n�C�[�[�b�I";
		next;
		mes "[�`���[���[�@�r�V�F��]";
		mes "�t�I�����I";
		mes "�g�D�A�[�I";
		mes "�f�C���@�I";
		next;
		mes "[�`���[���[�@�r�V�F��]";
		mes "����!!�@���h���A���h!!";
		mes "�N�ɂ��t���ė���Ȃ�";
		mes "���̃X�^�C���I";
		mes "���n�n�n�n�n�n!!";
		setlook 1,rand(1,19);
		setlook 6,rand(9);
		set Zeny,Zeny-199800;
		close;
	case 3:
		mes "[�`���[���[�@�r�V�F��]";
		mes "�u�^�̔��Ƃ͉����v���킩��񏬖���";
		mes "�w�A�[�X�^�C����ς��Ă��炢��";
		mes "�s���҂����c�c";
		mes "���܂�ɂ����킢�����c�c";
		mes "���킢�������������I";
		mes "�S�t�b�Q�t�b�c�c";
		close;
	}
}

lhz_in02,100,143,2	script	�w�A�f�U�C�i�[	122,{
	mes "[�v�����X�E�V���~]";
	mes "�_�̏j�����󂯂��A";
	mes "�w�A�f�U�C�i�[�E�̋M���q�A";
	mes "�v�����X�E�V���~�B";
	mes "���Ȃ��̂��̃I�[�N�̂悤�Ȗт��A";
	mes "�����Ȏ肳�΂��Ŕ������d���Ă�";
	mes "��Ղ̔��e�t�A���ꂪ�܂��Ɏ��ł��B";
	next;
	mes "[�v�����X�E�V���~]";
	mes "�����A���Ȃ��̗v�]�𕷂��܂��傤�B";
	next;
	switch(select("�w�A�X�^�C��������","�w�A�X�^�C����ς���","��b��؂�グ��")) {
	case 1:
		mes "[�v�����X�E�V���~]";
		mes "�����f�U�C�������ŐV��";
		mes "�w�A�X�^�C�������܂����H";
		next;
		mes "[�v�����X�E�V���~]";
		mes "�ŐV�̃w�A�X�^�C���́A";
		mes "20�ԁ`23�Ԃł��B";
		mes "�������w�A�X�^�C����";
		mes "�ԍ�����͂��Ă��������B";
		mes "�L�����Z������ꍇ�́A";
		mes "0����͂��Ă��������B";
		next;
		input .@hair;
		if(.@hair==0) {
			mes "[�v�����X�E�V���~]";
			mes "�����ł����A�c�O�ł��B";
			mes "��Ղ�̌��������Ȃ�����A";
			mes "�܂����z�����������B";
			close;
		}
		if(.@hair<20 || .@hair>23) {
			mes "[�v�����X�E�V���~]";
			mes "�ނށH";
			mes "20�`23�̔ԍ�����͂��Ă��������B";
			close;
		}
		if(Sex) {
			switch(.@hair) {
			case 20:
				cutin "hair_m_20",4;
				mes "[�v�����X�E�V���~]";
				mes "�����^4A4AFF�v�e�B�b�g�X�^�C��^000000�ł��ˁB";
				mes "��������D��Ɍ������X�^�C���ŁA";
				mes "���̖�S��ł��B";
				close;
			case 21:
				cutin "hair_m_21",4;
				mes "[�v�����X�E�V���~]";
				mes "^4A4AFF�G�N�X�L���[�V���i�[�X�^�C��^000000�ł��ˁB";
				mes "�ѐ�𔪕��ɔ�΂��A";
				mes "��b���v�킹��悤�Ȗ쐫�I��";
				mes "�a�V�ȃX�^�C���ł��B";
				close;
			case 22:
				cutin "hair_m_22",4;
				mes "[�v�����X�E�V���~]";
				mes "�t�t�A����͂Ȃ��Ȃ����ڂ������I";
				mes "�����^4A4AFF�v�����X�X�^�C��^000000�ł��B";
				next;
				mes "[�v�����X�E�V���~]";
				mes "�����܂Ŏ��R�ɁA����i�ɁA";
				mes "�@�ׂȋZ�p��K�v�Ƃ���";
				mes "�V���[�v�ȃX�^�C���ł��B";
				mes "���̃v�����X�E�V���~�̂悤�ɁA";
				mes "�M���q�Ɏd���ďグ�܂��傤�I";
				close;
			case 23:
				cutin "hair_m_23",4;
				mes "[�v�����X�E�V���~]";
				mes "�����^4A4AFF�f�r�A�X�X�^�C��^000000�ł��B";
				mes "�Z�߂Ō�����⊠��グ�Ă���A";
				mes "�������ς�Ƃ��ĎႢ�C���[�W��";
				mes "���o���܂��B";
				next;
				mes "[�v�����X�E�V���~]";
				mes "�C�ɓ���܂������H";
				close;
			}
		}
		else {
			switch(.@hair) {
			case 20:
				cutin "hair_f_20",4;
				mes "[�v�����X�E�V���~]";
				mes "^4A4AFF�X�v�����O���r�b�g�X�^�C��^000000�ł��ˁB";
				mes "�����������R�ɐ��炵�A";
				mes "�O���͂��ł��ő����Ă���܂��B";
				mes "���邭�N�炩�ȃC���[�W��^���܂��B";
				mes "�C�ɓ���܂������H";
				close;
			case 21:
				cutin "hair_f_21",4;
				mes "[�v�����X�E�V���~]";
				mes "�����^4A4AFF�n�[�s�[�X�^�C��^000000�ł��B";
				mes "�O���ɂ��J�[�������A";
				mes "���͖ѐ���y���܂Ƃ߂��������A";
				mes "�i�₩�ȃC���[�W��^���܂��B";
				close;
			case 22:
				cutin "hair_f_22",4;
				mes "[�v�����X�E�V���~]";
				mes "�����^4A4AFF���f���[�T�X�^�C��^000000�ł��B";
				mes "�����O���ɒ��˂����A��������";
				mes "�N�[���ȃC���[�W�����o���܂��B";
				close;
			case 23:
				cutin "hair_f_23",4;
				mes "[�v�����X�E�V���~]";
				mes "�����^4A4AFF�C�V�X�X�^�C��^000000�ł��B";
				mes "���T�C�h���ۂ������A";
				mes "�����Ɨc�������o���܂��B";
				close;
			}
		}
	case 2:
		if(baselevel < 60) {
			mes "[�v�����X�E�V���~]";
			mes "���A�v�����X�E�V���~�́A";
			mes "���̃w�A�X�^�C����������";
			mes "�������Ă������邨�q�l�ɂ̂�";
			mes "�T�[�r�X�����Ă��܂��B";
			next;
			mes "[�v�����X�E�V���~]";
			mes "�c�O�ł����A���q�l�ɂ͂܂�";
			mes "���̎���������Ȃ��悤�ł��B";
			mes "�Z���X�𖁂��Ă���A";
			mes "�܂����炵�Ă��������B";
			close;
		}
		if(countitem(973) < 3 || countitem(974) < 3 || countitem(901) < 100 || countitem(1094) < 100 ||
							countitem(1020) < 100 || countitem(1060) < 100 || countitem(7152) < 100 || Zeny < 99800) {
			mes "[�v�����X�E�V���~]";
			mes "���Ȃ����肤�w�A�X�^�C����";
			mes "����ɂ́A���ꂩ�猾���ޗ���";
			mes "�����Ă��Ă��������B";
			next;
			mes "[�v�����X�E�V���~]";
			mes "���a��3�A������3�A";
			mes "�s�b�O�e�[�����{��100�A";
			mes "�Z���s�b�O�e�[�����{��100�A";
			mes "������100�A���F�̔�100�A";
			mes "��₩�Ȕ�100�A";
			mes "������99,800Zeny�ł��B";
			next;
			mes "[�v�����X�E�V���~]";
			mes "����炷�ׂĂ̏������ł��܂�����A";
			mes "^4A4AFF�v�����X�E�V���~�̊��^000000��";
			mes "���������܂��傤�B";
			close;
		}
		mes "[�v�����X�E�V���~]";
		mes "�w�A�X�^�C���̕ύX�ɂ́A";
		mes "���ꂩ�猾���ޗ����K�v�ł��B";
		next;
		mes "[�v�����X�E�V���~]";
		mes "���a��3�A������3�A";
		mes "�s�b�O�e�[�����{��100�A";
		mes "�Z���s�b�O�e�[�����{��100�A";
		mes "������100�A���F�̔�100�A";
		mes "��₩�Ȕ�100�A";
		mes "������99,800Zeny�ł��B";
		next;
		mes "[�v�����X�E�V���~]";
		mes "�����̍ޗ��𒸂��܂����A";
		mes "��낵���ł��ˁH";
		next;
		if(select("�͂�","�������c�c")==2) {
			mes "[�v�����X�E�V���~]";
			mes "�����f�U�C�������w�A�X�^�C����";
			mes "�C�ɓ���Ȃ��Ƃł��c�c�H";
			mes "�����c�c���̌|�p��";
			mes "�������邱�Ƃ��ł��Ȃ��Ȃ�āc�c";
			mes "���Ȃ��͂��̏�Ȃ��s�K�ł��ˁB";
			close;
		}
		mes "[�v�����X�E�V���~]";
		mes "�ł́A���q�l����]����w�A�X�^�C����";
		mes "�ԍ�������������Ă��������B";
		mes "�v�����X�E�V���~�́A������";
		mes "���q�l�����]�����܂���B";
		next;
		mes "[�v�����X�E�V���~]";
		if(Sex) {
			mes "20�ԁA�v�e�B�b�g�X�^�C��";
			mes "21�ԁA�G�N�X�L���[�V���i�[�X�^�C��";
			mes "22�ԁA�v�����X�X�^�C��";
			mes "23�ԁA�f�r�A�X�X�^�C��";
		}
		else {
			mes "20�ԁA�X�v�����O���r�b�g�X�^�C��";
			mes "21�ԁA�n�[�s�[�X�^�C��";
			mes "22�ԁA���f���[�T�X�^�C��";
			mes "23�ԁA�C�V�X�X�^�C��";
		}
		mes "�ł��B";
		next;
		input .@hair;
		if(.@hair == 0) {
			mes "[�v�����X�E�V���~]";
			mes "�������܂����B";
			close;
		}
		if(.@hair < 20 || .@hair > 23) {
			mes "[�v�����X�E�V���~]";
			mes "20�`23�̔ԍ�����͂��Ă��������B";
			close;
		}
		cutin "hair_" +((Sex)? "m": "f")+ "_" +((.@hair < 10)? "0": "")+.@hair+ "",4;
		mes "[�v�����X�E�V���~]";
		mes "���q�l����]����w�A�X�^�C���́A";
		mes "22�Ԃł��ˁB";
		mes "�ł́A��낵���ł����H";
		next;
		if(select("�͂�","�������c�c")==2) {
			mes "[�v�����X�E�V���~]";
			mes "�ԍ����ԈႦ�܂������H";
			mes "������x�m�F���Ă��������B";
			close;
		}
		mes "[�v�����X�E�V���~]";
		mes "����ł́A�n�߂܂��B";
		mes "���̊�Ղ̗͂��c�c!!";
		next;
		mes "-�T�N�T�N�T�N�T�N-";
		mes "-�`���L�`���L�`���L�`���L-";
		mes "-�T�N�T�N�T�N�T�N-";
		mes "-�`���L�`���L�`���L�`���L-";
		next;
		mes "-�T�N�T�N�T�N�T�N-";
		mes "-�`���L�`���L�`���L�`���L-";
		mes "-�E�B�B�B�B�B�B�B�B-";
		next;
		delitem 973,3;
		delitem 974,3;
		delitem 901,100;
		delitem 1094,100;
		delitem 1020,100;
		delitem 1060,100;
		delitem 7152,100;
		set Zeny,Zeny-99800;
		setlook 1,.@hair;
		setlook 6,rand(9);
		mes "[�v�����X�E�V���~]";
		mes "�ł��܂����B";
		mes "������!!�@�����_�t��!!";
		mes "�v�����X�E�V���~�̊�ՁA";
		mes "�������ł��傤���H";
		mes (Sex)? "�j�O���オ��܂����ˁI": "�ƂĂ��Y��ɂȂ�܂����ˁI"; //����������
		close;
	case 3:
		mes "[�v�����X�E�V���~]";
		mes "�����f�U�C�������w�A�X�^�C����";
		mes "�C�ɓ���Ȃ��Ƃł��c�c�H";
		mes "�����c�c���̌|�p��";
		mes "�������邱�Ƃ��ł��Ȃ��Ȃ�āc�c";
		mes "���Ȃ��͂��̏�Ȃ��s�K�ł��ˁB";
		close;
	}
}

lhz_in02,91,155,4	script	���K�����e�t	862,{
	emotion 23;
	mes "[���K�����e�t]";
	mes "���񂵂�A�悢����c�c";
	next;
	mes "[���K�����e�t]";
	mes "���A���́c�c��������Ⴂ�I";
	mes "�ǂ����������p���ł��傤�H";
	mes "���A���H�@�����ɂ��́H";
	next;
	mes "[���K�����e�t]";
	mes "���A�w�A�X�^�C���ɂ��Ă��ȁH";
	next;
	switch(select("���Ȃ��́H","�w�A�X�^�C����ς�����","�v�����X�E�V���~�ɂ���")) {
	case 1:
		mes "[���K�����e�t]";
		mes "���H�@���H";
		mes "�΂͔閧�ł���I";
		next;
		mes "[���K�����e�t]";
		mes "���A�΂͕����ĂȂ����āH";
		mes "����ƁA���l�͎��́c�c";
		mes "���`��A���������!!";
		next;
		mes "[���K�����e�t]";
		mes "�L���[�I�@����Ȃ��Ƃ��Ă���";
		mes "�搶�ɓ{��ꂿ�Ⴄ�I";
		mes "�U��ł���������d�����Ȃ�������!!";
		close;
	case 2:
		if(BaseLevel < 60) {
			mes "[���K�����e�t]";
			mes "�����H";
			mes "���A�_���ł��患�c�c";
			next;
			mes "[���K�����e�t]";
			mes "��ςȂ��ƂɂȂ����Ⴄ��H";
			close;
		}
		if(Zeny < 250000) {
			mes "[���K�����e�t]";
			mes "�t�t�t�A���͂܂����K�������ǁA";
			mes "����`��ƕ׋����Ă�񂾂���ˁB";
			mes "�ޗ���250,000Zeny��";
			mes "�����Ă�����A�w�A�X�^�C���ƁA";
			mes "���ߕt�����T�[�r�X�����Ⴄ��B";
			next;
			mes "[���K�����e�t]";
			mes "�搶�͊�����`�҂ŁA";
			mes "���ɑS�R���K�����Ă���Ȃ����ǁA";
			mes "�S�R���i�b�V���O!!";
			mes "���̎��͂𔭊����āA";
			mes "���Ȃ������Ⴆ��悤�ɂ��Ă����܂�!!";
			close;
		}
		mes "[���K�����e�t]";
		mes "���悢����K���`!!�@���b�z�`�I";
		mes "�w�A�X�^�C���̕ύX�ƁA";
		mes "���ߕt�����T�[�r�X�����Ⴄ�ˁB";
		mes "�ޗ���250,000Zeny��";
		mes "�����邯�ǁA�������ȁH";
		mes "���ꂶ��A������`�H";
		next;
		if(select("�w�A�X�^�C����I��","��߂�")==2) {
			mes "[���K�����e�t]";
			mes "�������A���ł�߂�̂����H";
			mes "���̘r��M�p���ĂȂ���!?";
			mes "������Ƃ�����Ɓ`�`�`!!";
			close;
		}
		mes "[���K�����e�t]";
		mes "���ꂶ��A��]����w�A�X�^�C����";
		mes "1�`23�̔ԍ��œ��͂��ĂˁB";
		mes "�������ꍇ�́A0����͂��ĂˁB";
		next;
		input .@hair;
		if(.@hair == 0) {
			mes "[���K�����e�t]";
			mes "�K�[���c�c���A�M�p����ĂȂ��H";
			close;
		}
		if(.@hair < 0 || .@hair > 23) {
			mes "[���K�����e�t]";
			mes "������Ƃ�����ƁI";
			mes "1�`23�����Ă΁I";
			close;
		}
		cutin "hair_" +((Sex)? "m": "f")+ "_" +((.@hair < 10)? "0": "")+.@hair+ "",4;
		mes "[���K�����e�t]";
		mes "����ł����񂾂ˁH";
		next;
		if(select("����","���Ȃ�")==2) {
			mes "[���K�����e�t]";
			mes "�����`���Ł`�H";
			close;
		}
		mes "[���K�����e�t]";
		mes "�悧����������!!";
		mes "�񂶂Ⴂ����!!";
		next;
		mes "[���K�����e�t]";
		mes "�����A���K���K�I";
		mes "����M���Ă��傤�����I";
		next;
		nude;
		mes "[���K�����e�t]";
		mes "�Ƃ�����������႟����������!!";
		next;
		mes "[���K�����e�t]";
		mes "�Ă��I�@�₟�I�@�͂��I";
		next;
		mes "[���K�����e�t]";
		mes "���킟���Ƃ��ƁA��΂��c�c";
		mes "�������A�������I";
		next;
		mes "[���K�����e�t]";
		mes "���ꂡ�����I";
		next;
		mes "[���K�����e�t]";
		mes "��������������!!!!";
		next;
		mes "[���K�����e�t]";
		mes "�n�@�n�@�c�c";
		next;
		setlook 1,rand(1,23);
		setlook 6,rand(9);
		set Zeny,Zeny-250000;
		mes "[���K�����e�t]";
		mes "�ŁA�ł������!!";
		mes "���H�@��]�����w�A�X�^�C����";
		mes "�Ⴄ�ł����āH";
		mes "����ȁ`�C�̂����ł���I";
		next;
		emotion 30;
		mes "[���K�����e�t]";
		mes "�����A���K�ł��Ă悩�����B";
		mes "�܂���낵����!!";
		close;
	case 3:
		mes "[���K�����e�t]";
		mes "�����ƁA���l�͂��Ȃ��݂����ł���H";
		mes "���̂���Ȃ��Ƃ��c�c�H";
		mes "�͂�!!�@�܂������Ȃ��c�c";
		mes "�搶��_���Ă��!?";
		mes "���킟�c�c";
		close;
	}
}
lhz_in02,100,134,2	script	���ߕt���t	850,{
	mes "[���ߕt���t���T]";
	mes "��������Ⴂ�܂��I";
	mes "����A��" +((Sex)? "�Z": "�o")+ "����I�Ȃ��Ȃ�";
	mes "�f�G�ȃw�A�X�^�C���ˁI";
	mes "�Y��ɐ��߂�΁A";
	mes "�����Ƒf�G�ɂȂ�񂶂�Ȃ��H";
	while(1) {
		next;
		switch(select("������߂�","���ߕt���̐����𕷂�","��߂�")) {
		case 1:
			mes "[���ߕt���t���T]";
			mes "�������˂��c�c";
			mes "���F���D�������H";
			mes "�h��ȐF�H�@�����������F�H";
			mes "�Z�N�V�[�ȐF�H�@�_�炩���F�H";
			setarray .@color,8,1,2,3,4,5,6,7;
			setarray .@item,975,976,981,980,979,978,982,983;
			while(1) {
				next;
				set .@num,select("��","��","��","��","��","��","��","��","���̂܂܂ł���")-1;
				if(.@num==8) {
					mes "[���ߕt���t���T]";
					mes "����A���߂Ă݂Ȃ��̂����H";
					mes "���̐F���������Ǝv�����ǂ˂��B";
					close;
				}
				if(getlook(6) == .@color[.@num]) {
					mes "[���ߕt���t���T]";
					mes "����c�c����͍�";
					mes "���߂Ă�F����Ȃ��̂����H";
					mes "�܂������Ă��Ȃ����A";
					mes "���ߒ����K�v�͂Ȃ���B";
					continue;
				}
				if(countitem(.@item[.@num]) < 1) {
					mes "[���ߕt���t���T]";
					mes "����H�@" +getitemname(.@item[.@num])+ "���Ȃ��悤���ˁB";
					close;
				}
				if(Zeny < 1000) {
					mes "[���ߕt���t���T]";
					mes "���ߕt�������́A1,000Zeny����B";
					close;
				}
				set Zeny,Zeny-1000;
				delitem .@item[.@num],1;
				setlook 6,.@color[.@num];
				mes "[���ߕt���t���T]";
				mes "�ӂӁA�Y��ɐ��܂����悤���ˁH";
				mes "�C����ς������Ȃ�����A";
				mes "�܂���������Ⴂ�I";
				close;
			}
		case 2:
			mes "[���ߕt���t���T]";
			mes "�C����ς��������ɂ́A";
			mes "������߂Ă݂Ă͂ǂ������H";
			next;
			mes "[���ߕt���t���T]";
			mes "���ߕt����1,000Zeny��";
			mes "��]����F�̐���1�ŁA";
			mes "�����ɐ��߂Ă������I";
			continue;
		case 3:
			mes "[���ߕt���t���T]";
			mes "�l�Ԃ̊���́A������Ƃ������Ƃ�";
			mes "�ǂ����������Ȃ���񂾂�B";
			mes "�C���]���ɔ�����߂�̂��A";
			mes "���܂ɂ͗ǂ����񂾂�B";
			close;
		}
	}
}