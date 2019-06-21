//====================================================================
//Ragnarok Online Hunter jobchange script
//
//�@�� CHANGE_HT
//	1	�V�F�����̎���
//	2	�V�F�����̎���N���A
//	3	�A�C�e�����W�P
//	4	�A�C�e�����W�Q
//	5	�A�C�e�����W�R
//	6	�A�C�e�����W�S
//	7	�A�C�e�����W�T
//	8	�A�C�e�����W�U
//	9	�A�C�e�����W�V
//	10	�M���h�}�X�^�[�|�葺
//	11	�M���h�}�X�^�[�����{
//	12	�퓬����
//	13	�퓬������
//	14	�퓬�����N���A
//	15	�d�����-�����N���A
//
//�@�� $@ht_tester$ -> �퓬�������풆�̃L������
//====================================================================

//==========================================
// �����\������ѓ]�E
//------------------------------------------

//pay_fild10,148,252,4	script	�n���^�[�M���h�֌W��	98,{
//	mes "[�n���^�[�M���h��]";
//	mes "����ɂ��́B";
//	mes "�n���^�[�M���h�ւ��p�ł�����";
//	mes "�������ē����܂��B";
//	next;
//	if(select("�A��čs���Ă�������","���ɗp�͂���܂���")==2) {
//		mes "[�n���^�[�M���h��]";
//		mes "����ł͂܂��B";
//		close;
//	}
//	mes "[�n���^�[�M���h��]";
//	mes "�͂��A����ł͂��ē����܂��B";
//	close2;
//	warp "in_hunter",100,18;
//	end;
//}

pay_fild10,148,252,3	script	�ē���	837,{
	mes "==============�ē�==============";
	mes "�n���^�[�]�E����";
	mes "�V���o���c�o���h���a����";
	mes "^FF0000�t�B�Q��^000000�Ɉړ����܂����B";
	next;
	mes "�t�B�Q���H�����V���ɊJ�ʂ����̂ŁA";
	mes "��s�D�𗘗p����";
	mes "�t�B�Q���Ɉړ����邱�Ƃ��ł��܂��B";
	next;
	mes "�]�E�������󂯂���X��";
	mes "^FF0000�t�B�Q��^000000��^FF0000�E��^000000��";
	mes "�ړ]�����]�E���܂ŗ��Ă��������B";
	next;
	mes "^844200�i��ԉ��ɂ����������Ă���j^000000";
	mes "�c�c�t�@���R���Ǘ��҂��ꏏ�ɍs�����B";
	close;
}

//==============================================================
//in_hunter,99,99,4	script	�n���^�[�M���h��	727,{
hu_in01,386,373,4	script	�n���^�[�M���h��	727,{
	if(Upper == UPPER_HIGH) {
		mes "[�n���^�[�E�V�F����]";
		mes "����A����ɂ��́I";
		mes "���C�ł������H";
		mes "�ȑO������Ă��炾����";
		mes "�o���܂���ˁc�c";
		next;
		mes "[�n���^�[�E�V�F����]";
		mes "����c�c�H";
		mes "���߂�Ȃ����A�l�Ⴂ������������H";
		next;
		mes "[�n���^�[�E�V�F����]";
		mes "�c�c";
		mes "�ǂ����ł�������悤�ȁc�c";
		next;
		mes "[�n���^�[�E�V�F����]";
		mes "���`��A�v���o���Ȃ��ł��ˁB";
		mes "�����l���ԈႦ��̂���";
		mes "�ƂĂ��߂��炵����ł����ǁc�c";
		mes "�Ƃɂ����A�ǂ�������߂�����";
		mes "���������ˁB";
		close;
	}
	if(Job == Job_Novice) {
		mes "[�n���^�[�M���h��]";
		mes "����A�m�[�r�X����c";
		mes "���̕ӂł͂��܂茩�����܂���˂��c�B";
		close;
	}
	if(Job == Job_Hunter) {
		mes "[�n���^�[�M���h��]";
		mes "���A" +strcharinfo(0)+ "����I";
		mes "���v���Ԃ�ł��`�B";
		mes "�����͂ǂ�Ȃ��p�ł����H";
		mes "�M���h����͂���Ƃ��������m��";
		mes "�o�Ă��܂��񂪁A�ǂ����������";
		mes "�Ȃ����Ă����Ă��������B";
		close;
	}
	if(Job != Job_Archer) {
		mes "[�n���^�[�M���h��]";
		mes "����A��������Ⴂ�܂��I";
		mes "�������ł��ˁ`�B";
		mes "������܂ŖK�˂ė��������";
		mes "�߂����菭�Ȃ��Ȃ�܂��āc�B";
		close;
	}
	switch(CHANGE_HT) {
	case 0:
		if(JobLevel < 40) {
			mes "[�n���^�[�M���h��]";
			mes "���c�܂��|�̈������\���ł�";
			mes "����܂���ˁc�B";
			mes "���Ȃ��Ƃ��A�n���^�[�ɂȂ�ɂ�";
			mes "�A�[�`���[�Ƃ��Ă̏C�������鐅���܂�";
			mes "�ς܂Ȃ���΂Ȃ�܂���B";
			next;
			mes "[�n���^�[�M���h��]";
			mes "�����������C����ς�ł��Ă��������B";
			mes "���m�ȓ]�E�����́A";
			mes "JobLv40�ȏ�ł��B";
			mes "������񂻂�ȏ�C�����Ă��������Ă�";
			mes "���Ȃ��ł���B";
			mes "����ł͎��ɂ�����鎞���y���݂�";
			mes "���Ă���܂��B";
			close;
		}
		if(SkillPoint) {
			mes "[�n���^�[�E�V�F����]";
			mes "�X�L���|�C���g���c���Ă���Ɠ]�E";
			mes "�ł��܂���B�S�ď����Ă���";
			mes "���������������B";
			close;
		}
		mes "[�n���^�[�M���h��]";
		mes "����A�A�[�`���[����ł��ˁB";
		mes "�����Ƃ���A�����ȌP���������";
		mes "���܂����ˁB";
		mes "�����āA�n���^�[�ւ̓]�E������]��";
		mes "�K�˂Ă��炵���̂ł��ˁH";
		next;
		switch(select("�͂��A���̂��߂ɗ��܂���","�]�E�������f���ɗ��܂���","�܂��]�E���܂���")) {
			case 1:
				mes "[�n���^�[�M���h��]";
				mes "�ւցA������ł��ˁ`�B";
				mes "����ł͎葱�����c�Ɓc";
				next;
				mes "[�n���^�[�M���h��]";
				mes "�܂��A�ŏ��ɖʐڂ����܂��B";
				mes "�y�ȋC�����œ����Ă��������ˁB";
				next;
				mes "���������c";
				next;
				mes "[�n���^�[�M���h��]";
				mes "�����A";
				mes "�\���x��܂����B";
				mes "���́u�V�F�����v�ƌ����܂��B";
				mes "����ł��Ċ������ł��I";
				next;
				mes "[�n���^�[�E�V�F����]";
				mes "�͂��A����ł͖ʐڂ��n�߂܂��`";
				next;
				if(select("���˂������܂�","�p���̓r���Ȃ̂ł܂����܂�")==2) {
					mes "[�n���^�[�E�V�F����]";
					mes "����ł́A�܂����ł�������������";
					mes "���������ˁB";
					close;
				}
				mes "[�n���^�[�E�V�F����]";
				mes "�ł́A�������b�����A�����܎����";
				mes "�����|���܂��B";
				mes "����ɓ����Ă�������Ηǂ��ł��B";
				next;
				mes "[�n���^�[�E�V�F����]";
				mes "�ǂ�ȍl�����������Ńn���^�[��";
				mes "��]�������m�邽�߂ł�����A�C���y��";
				mes "���ē����Ă��������ˁB";
				set CHANGE_HT,1;
				break;
			case 2:
				mes "[�n���^�[�M���h��]";
				mes "�]�E�����ł��B";
				mes "��D�A�[�`���[�ł��邱��";
				mes "��DJobLv��40�ȏ�ł��邱��";
				mes "�O�D�M���h����v�����ꂽ";
				mes "�@�@�A�C�e�����W�߂Ă��邱��";
				mes "�l�D�M���h�ōs�������ɍ��i���邱��";
				next;
				mes "[�n���^�[�M���h��]";
				mes "�A�[�`���[�ł�������ƏC����ς�ł�����";
				mes "�����ɂ͍��i�ł���͂��ł��B";
				close;
			case 3:
				mes "[�n���^�[�M���h��]";
				mes "����ł́A�܂����ł�������������";
				mes "���������ˁB";
				close;
		}
		break;
	case 1:
		mes "[�n���^�[�E�V�F����]";
		mes "�܂���������Ⴂ�܂����ˁI";
		mes "�ł͖ʐڂ���n�߂܂���`";
		mes "���x�̓V�F�����̖₢��";
		mes "�������蓚���Ă��������ˁI";
		break;
	case 2:
		mes "[�n���^�[�E�V�F����]";
		mes "����H";
		next;
		mes "[�n���^�[�E�V�F����]";
		mes "�f�[�����n���^�[�l���܂�����";
		mes "���Ȃ���ł����H";
		mes "�f�[�����n���^�[�l�͌�������";
		mes "�����ɂ�������Ⴂ�܂���B";
		next;
		mes "[�n���^�[�E�V�F����]";
		mes "�����]�E�����p���݂����ł��ˁ`";
		mes "�f�G�ȃn���^�[�ɂȂ肻���ł�����B";
		close;
	default:	//3�`9�̂Ƃ�
		mes "[�n���^�[�E�V�F����]";
		mes "������ɂ���������";
		mes "�f�[�����n���^�[�l�̌���";
		mes "�A�C�e���𑵂��Ď����Ă�����";
		mes "�ǂ���ł��B";
		next;
		mes "[�n���^�[�E�V�F����]";
		mes "�n���^�[�ɂȂ�Ƃ��́A�K���V�F������";
		mes "���ɗ��Ă��������ˁB";
		mes "���Ȃ��͂ƂĂ�" +(Sex? "�i�D�ǂ�": "�Y�킾")+ "����A";
		mes "�n���^�[�ɂȂ����p����΂�";
		mes "��������ł��B�ӂӁc";
		close;
	case 10:
	case 11:
	case 12:
	case 13:
	case 14:
		mes "[�n���^�[�E�V�F����]";
		mes "���[��c���ł͂Ȃ��A���֏o����";
		mes "�o�Ă�������M���h�}�X�^�[�l";
		mes "�ɂ��p�ł����H";
		next;
		mes "[�n���^�[�E�V�F����]";
		mes "���������Ƃ���ɂ��ƁA";
		mes "�t�F�C���������{���|�葺�̂ǂ��炩��";
		mes "����������͂��ł��B";
		mes "������֍s���Ă݂Ă��������ˁB";
		close;
	case 15:
		if(countitem(1007) < 1) {
			mes "[�n���^�[�E�V�F����]";
			mes "�͂��A�����ɍ��i���ꂽ�Ƃ����A����";
			mes "�󂯂Ă���܂����A��ł���u�d��v";
			mes "���������łȂ��ł��ˁB";
			next;
			mes "[�n���^�[�E�V�F����]";
			mes "���������ɂȂ������Ƃ�";
			mes "�M���h�}�X�^�[�ɂ͓����ɂ��Ă���";
			mes "�܂�����A�Ƃɂ����u�d��v��";
			mes "�����Ă��Ă��������ˁB";
			close;
		}
		if(Skillpoint) {
			mes "[�n���^�[�E�V�F����]";
			mes "�X�L���|�C���g���c���Ă���Ɠ]�E";
			mes "�ł��܂���B�S�ď����Ă���";
			mes "���������������B";
			close;
		}
		set .@itemid,(JobLevel >= 50)? 1718: 1710;
		mes "[�n���^�[�E�V�F����]";
		mes "���A�]�E�����ɍ��i����܂����ˁI";
		mes "���j���\���グ�܂��I";
		next;
		mes "[�n���^�[�E�V�F����]";
		mes "�����A����ł͑����n���^�[��";
		mes "�]�E�����Ă��������܂��B";
		next;
		delitem 1007,1;
		nude;
		jobchange Job_Hunter;
		set CHANGE_HT,0;
		mes "[�n���^�[�E�V�F����]";
		mes "���߂Ă��j���������܂��B";	
		mes "����A�n���^�[�̕������悭��������";
		mes "������Ⴂ�܂��ˁI";
		next;
		mes "[�n���^�[�E�V�F����]";
		mes "�n���^�[�Ƃ��Ēp���������Ȃ��s����";
		mes "���Ƌ��ɁA���R��������S��Y��";
		mes "�Ȃ��ł��������ˁI";
		next;
		getitem .@itemid,1;
		mes "[�n���^�[�E�V�F����]";
		mes "�����āA����͂��Ȃ��̓w�͂�";
		mes "�h�ӂ�\���č����グ����̂ł��B";
		close;
	}
	//�ʐڂ�������
	next;
	mes "[�n���^�[�E�V�F����]";
	mes "�ł͂����܂��B";
	next;
	mes "[�n���^�[�E�V�F����]";
	mes "���Ȃ��̓A�[�`���[�B�ǂ����Ɏ���";
	mes "�o���������̂ł����A�ǂ��ɍs������";
	mes "�ǂ���������܂���B";
	mes "���āA�ǂ����܂��傤�B";
	next;
	if(select("�ǂ����ǂ����Ƌ���ŕ������","�ʂ肩�������l�ɐ��������ĕ���","��l�ł�����������ĒT��")==2)
		set .@point,.@point+10;
	mes "[�n���^�[�E�V�F����]";
	mes "�������߂܂����B";
	mes "�\�O���g�����ɐ�������u�z�[�h�v��";
	mes "���������X�^�[����邱�Ƃɂ��܂����B";
	next;
	mes "[�n���^�[�E�V�F����]";
	mes "�����������̓t�F�C�����B";
	mes "�ǂ�����č����܂ōs���܂��傤���B";
	next;
	if(select("�v���[�X�g�l�ɗ���œ]�����Ă��炤","�J�v���E���𗘗p����","�F�B�ƕ����čs��")==3)
		set .@point,.@point+10;
	mes "[�n���^�[�E�V�F����]";
	mes "�߂��Ƀv���[�X�g�l���F�B�����܂���B";
	mes "�J�v���E���𗘗p���邱�Ƃɂ��܂�����";
	mes "����������܂���B�ǂ����܂��傤�B";
	next;
	if(select("�������","�K�v�̖����A�C�e���𔄂��Ă����ɂ���","�߂��̐X�Ŏ�������")==2)
		set .@point,.@point+10;
	mes "[�n���^�[�E�V�F����]";
	mes "�Ȃ�Ƃ��z�[�h�̂��鍻���ɓ���";
	mes "���܂����B";
	mes "�Ƃ��낪�z�[�h�����ɂ͏���";
	mes "�����̘r������Ȃ������悤�ł��c�B";
	next;
	mes "[�n���^�[�E�V�F����]";
	mes "�ǂ����܂����H";
	next;
	if(select("�u�̏ォ�牺�ɂ���z�[�h���U�����܂�","�X�Ɍ������܂�","�l������Ă���z�[�h���U������")==2)
		set .@point,.@point+10;
	mes "[�n���^�[�E�V�F����]";
	mes "������߁A�X�ɋA���Ă��܂����B";
	next;
	mes "[�n���^�[�E�V�F����]";
	mes "�C�����Ƒ̗͂����s��������";
	mes "���܂����B�񕜂̈˗������܂���";
	mes "�ǂ̂悤�ɗ��݂܂����H";
	next;
	if(select("��낵����΃q�[�������肢�ł��܂����H","�q�[����������","�q�[������")==1)
		set .@point,.@point+10;
	mes "[�n���^�[�E�V�F����]";
	mes "��H�������Ă����炢�̊Ԃɂ�";
	mes "�������A�C�e������ɓ����";
	mes "�܂����B�����A�i���𔄂�ɍL���";
	mes "�o�܂������A�����̘I�X��`���b�g";
	mes "���[�����J����Ă��܂��B";
	next;
	mes "[�n���^�[�E�V�F����]";
	mes "����ȏꍇ�A�A�C�e���𔄂�ɂ�";
	mes "�ǂ�����̂���ԗǂ��ł��傤���H";
	next;
	if(select("�F�ɕ�������悤�ɒm�点�Ȃ������","�`���b�g���[�����J���đ҂�","���߂Ă���l�����邩�T���Ă݂�")==3)
		set .@point,.@point+10;
	mes "[�n���^�[�E�V�F����]";
	mes "�������đ҂��Ă���ƁA�����";
	mes "����l������܂����B";
	mes "�ǂ��Ή����܂����H";
	next;
	if(select("�����̂����ƃA�C�e���������o��","�������ĕ�������","���̐l�ɓK�������������Ă�����")==3)
		set .@point,.@point+10;
	mes "[�n���^�[�E�V�F����]";
	mes "���x�͖��{�̐X�֏o�����܂����B";
	next;
	mes "[�n���^�[�E�V�F����]";
	mes "�����œ��ɖ������l�ɉ�܂����B";
	mes "�ǂ�����΂悢�ł��傤���B";
	next;
	if(select("���������Ă�����","�ړI�n�܂ňē����Ă�����","��������")==2)
		set .@point,.@point+10;
	mes "[�n���^�[�E�V�F����]";
	mes "���̐l�̓��ē������Ȃ������";
	mes "�����܂������A���̓r���ŒN����";
	mes "�܂����B�����A�i���𔄂�ɍL���";
	mes "�{�X�����X�^�[�Ɛ퓬���Ă��܂��B";
	next;
	mes "[�n���^�[�E�V�F����]";
	mes "�ǂ�����Ηǂ��ł��傤���B";
	next;
	if(select("�����ė~�����Ɨv������������x������","�Ƃɂ����U������","���̂܂܊X�ɋA��")==1)
		set .@point,.@point+10;
	mes "[�n���^�[�E�V�F����]";
	mes "���������A���̔�ꂪ�o�Ă��܂����B";
	mes "�X�֋A�낤�Ǝv���܂��B";
	next;
	mes "[�n���^�[�E�V�F����]";
	mes "����Ȏ��A���ɒ������A�C�e����";
	mes "�����Ă��܂��B";
	mes "�ǂ̂悤�ɂ��܂����H";
	next;
	if(select("�E���Ď����Ŏ����A��","�N�̕����T���Ă݂�","�ʂ�߂���")==2)
		set .@point,.@point+10;
	mes "[�n���^�[�E�V�F����]";
	mes "�͂��A�����l�ł����`�B";
	mes "����͈ȏ�ƂȂ�܂��B";
	next;
	if(.@point < 50) {
		mes "[�n���^�[�E�V�F����]";
		mes "���[��c������Ɠ���ł��c";
		mes "��{�I�ȐS�\�����ł��Ă��Ȃ����";
		mes "�n���^�[�ɂȂ��Ă����������Ƃ�";
		mes "�ł��܂���B";
		next;
		mes "[�n���^�[�E�V�F����]";
		mes "���̎��₪�ǂ�Ȃ��������A";
		mes "�悭�v���o���Ă�����x�l���Ă݂�";
		mes "���������B";
		mes "���R�ɑ΂���S������̂ɁA�l�Ƃ�";
		mes "�ڂ����͔��ɎQ�l�ɂȂ��ł��B";
		close;
	}
	set CHANGE_HT,2;
	if(.@point == 100) {
		mes "[�n���^�[�E�V�F����]";
		mes "�ǂ��ł��ˁA���̐S�\����";
		mes "�]�E�����ɗՂ�ł��������B";
		mes "�\���Ƀn���^�[�ɂȂ�f��������܂��B";
		next;
		mes "[�n���^�[�E�V�F����]";
		mes "����Ŗʐڂ͏I���܂��B";
		mes "������̋��ɂ�����ɁA�]�E�ɕK�v��";
		mes "�A�C�e����������Ă��������B";
		close;
	}
	mes "[�n���^�[�E�V�F����]";
	mes "�����C�ɂ����镔��������܂������A";
	mes "�ʐڂ̕��͂���ŏI���܂��B";
	mes "��ł�����x�A���̎�����v���o����";
	mes "�悭�l���Ă݂Ă��������B";
	next;
	mes "[�n���^�[�E�V�F����]";
	mes "�c��������������撣���āA";
	mes "�V�F�����ɗǂ����ʂ𕷂�����";
	mes "���������ˁB";
	close;
}


//==========================================
// �ꎟ�����i�A�C�e�����W�j
//------------------------------------------

//in_hunter,55,99,4	script	�n���^�[�M���h������t	732,{
hu_in01,382,382,4	script	�n���^�[�M���h������t	732,{
	switch(CHANGE_HT) {
	case 0:
	case 1:
		mes "[�f�[�����n���^�[]";
		mes "�n���^�[�ւ̓]�E�������󂯂������";
		mes "�܂���t���ς܂��Ă��������B";
		close;
	case 2:
		mes "[�n���^�[�M���h������t��]";
		mes "�悭���܂����B���̓n���^�[�M���h";
		mes "������t���u�f�[�����n���^�[�v";
		mes "�ƌ����܂��B";
		mes "�����O�� " +strcharinfo(0);
		mes "����ł��ˁH";
		next;
		if(select("�͂��A�����ł�","�Ⴂ�܂�(�t�t�c)")==2) {
			mes "[�f�[�����n���^�[]";
			mes "�ӂ����Ȃ��ł��������c�B";
			mes strcharinfo(0)+ "����ł���H";
			next;
			if(select("���c�����܂���","���͂�")==2) {
				mes "[�f�[�����n���^�[]";
				mes "��₩���ɗ����̂Ȃ�o�čs��";
				mes "�Ȃ����I�h�ӂ����߂Ă��b��";
				mes "���Ă���̂ɂ���ȑԓx������Ƃ́I";
				close2;
				//warp "pay_fild10",133,235;
				warp "hugel",208,223;
				end;
			}
		}
		mes "[�f�[�����n���^�[]";
		mes "�͂��A����ł͓]�E�����ɕK�v��";
		mes "�������m�点���܂��B";
		mes "�|��̍ޗ��ɂȂ���̂��W�߂Ă���";
		mes "���������B�����������s���ł��āc";
		mes "�����Ɓc���s�����Ă��镨�́c";
		next;
		switch(rand(7)) {
			case 0:
				mes "[�f�[�����n���^�[]";
				mes "���Ɏg����";
				mes "�u��������̉�v3��";
				mes "���������ɐڒ��܂Ƃ��Ďg����";
				mes "�u�ׂƂׂƂ���t�́v1��";
				mes "�����āc�u���܂̑��̗��v1�B";
				mes "�ȏ�ƂȂ�܂��B";
				set CHANGE_HT,3;
				break;
			case 1:		//���b�Z�[�W������
				mes "[�f�[�����n���^�[]";
				mes "�u�T���̂����ہv1��";
				mes "�u�n���l�Y�~�̐j�v2��";
				mes "�����āc�u�ǂ񂮂�v1�B";
				mes "�ȏ�ƂȂ�܂��B";
				set CHANGE_HT,4;
				break;
			case 2:		//���b�Z�[�W������
				mes "[�f�[�����n���^�[]";
				mes "�u�h�P�r�̊p�v3��";
				mes "�u���ꂽ���̂�����v3��";
				mes "�����āc�u�Ȗсv10�B";
				mes "�ȏ�ƂȂ�܂��B";
				set CHANGE_HT,5;
				break;
			case 3:		//���b�Z�[�W������
				mes "[�f�[�����n���^�[]";
				mes "�u���̂����΂��v3��";
				mes "�u�X�P���{�[���v5��";
				mes "�����āc�u�΃n�[�u�v3�B";
				mes "�ȏ�ƂȂ�܂��B";
				set CHANGE_HT,6;
				break;
			case 4:		//���b�Z�[�W������
				mes "[�f�[�����n���^�[]";
				mes "�u���n�[�u�v3��";
				mes "�u�؋��v5��";
				mes "�����āc�u�����T�̒܁v5�B";
				mes "�ȏ�ƂȂ�܂��B";
				set CHANGE_HT,7;
				break;
			case 5:		//���b�Z�[�W������
				mes "[�f�[�����n���^�[]";
				mes "�u���n�[�u�v9��";
				mes "�u峂̔�v9��";
				mes "�����āc�u��������v9�B";
				mes "�ȏ�ƂȂ�܂��B";
				set CHANGE_HT,8;
				break;
			case 6:		//���b�Z�[�W������
				mes "[�f�[�����n���^�[]";
				mes "�u�ł̉�v3��";
				mes "�u�b�̔�v3��";
				mes "�����āc�u�ԃn�[�u�v5�B";
				mes "�ȏ�ƂȂ�܂��B";
				set CHANGE_HT,9;
				break;
		}
		next;
		mes "[�f�[�����n���^�[]";
		mes "���ƁA�t�F�C�����̕��ɏo����";
		mes "�s����Ă���M���h�}�X�^�[�l��";
		mes "���������d�؂��Ă��܂�����A";
		mes "��x������������B";
		mes "����ł́A�S�đ����Ă���܂�";
		mes "���Ă��������B";
		close;
	default:	//3�`9�̂Ƃ�
		mes "[�f�[�����n���^�[]";
		mes "���[�Ɓc";
		next;
		switch(CHANGE_HT) {
			case 3:
				setarray .@need,913,938,948;
				setarray .@amount,3,1,1;
				break;
			case 4:
				setarray .@need,942,1027,1026;
				setarray .@amount,1,2,1;
				break;
			case 5:
				setarray .@need,1021,7032,914;
				setarray .@amount,3,3,10;
				break;
			case 6:
				setarray .@need,925,932,511;
				setarray .@amount,3,5,3;
				break;
			case 7:
				setarray .@need,509,1019,7030;
				setarray .@amount,3,5,5;
				break;
			case 8:
				setarray .@need,508,955,935;
				setarray .@amount,9,9,9;
				break;
			case 9:
				setarray .@need,937,919,507;
				setarray .@amount,3,3,5;
				break;
		}
		for(set .@i,0; .@i<3; set .@i,.@i+1) {	//�K�v�A�C�e���`�F�b�N
			if(countitem(.@need[.@i]) < .@amount[.@i]) {
				mes "[�f�[�����n���^�[]";
				mes "�܂��������ł��Ă��Ȃ��悤�ł��ˁB";
				mes "�K�v�ȕ��́c";
				for(set .@i,0; .@i<3; set .@i,.@i+1)
					mes "�u" +getitemname(.@need[.@i])+ "�v" +.@amount[.@i]+ "��";
				mes "�ł��B�S�đ����ė��Ă��������B";
				close;
			}
		}
		mes "[�f�[�����n���^�[]";
		mes "����A��������������S��";
		mes "�W�߂Ă���܂����ˁI";
		mes "���Ƃ̓t�F�C�����̕��֏o������";
		mes "�M���h�}�X�^�[�l�ɂ�������";
		mes "���̎����Ɉē����Ă����ł��傤�B";
		for(set .@i,0; .@i<3; set .@i,.@i+1)
			delitem .@need[.@i],.@amount[.@i];
		set CHANGE_HT,10+rand(2);
		close;
	case 10:
	case 11:
	case 12:
	case 13:
	case 14:
		mes "[�f�[�����n���^�[]";
		mes "�M���h�}�X�^�[�l���t�F�C���������{��";
		mes "�|�葺�ɍs�����̂͊m���ł��B";
		mes "�����T���Ă݂Ă��������[�B";
		close;
	case 15:
		mes "[�f�[�����n���^�[]";
		mes "�����A�����ɍ��i���܂������I";
		mes "�V�F�����̂Ƃ���֍s���Ă�����";
		mes "���������B";
		close;
	}
}


//==========================================
// �񎟎����i�퓬�����j
//------------------------------------------

-	script	�n���^�[�M���h�}�X�^�[	-1,{
	cutin "job_huntermaster",2;
	switch(CHANGE_HT) {
	case 0:
	case 1:
	case 2:
		mes "[�n���^�[]";
		mes "�ǂ�ȗp���ł����H";
		mes "���͏o���ɗ��Ă���̂ŖZ������ł��B";
		mes "�ǂ����\��Ȃ��ł��������B";
		close2;
		cutin "job_huntermaster",255;
		end;
	default:	//3�`9�̂Ƃ�
		mes "[�n���^�[�M���h�}�X�^�[]";
		mes "����H�A�[�`���[����";
		mes "�ǂ�ȗp�ŗ��܂������H";
		mes "���Ƀn���^�[�M���h����͘A�����󂯂�";
		mes "�܂��񂪁A���ԉߒ����ȗ����Ď�����";
		mes "�󂯂ɗ����킯�ł͂���܂����ˁH";
		next;
		mes "[�n���^�[�M���h�}�X�^�[]";
		mes "�܂��A�]�E�����ɕK�v�ȃA�C�e����";
		mes "�W�߁A�n���^�[�M���h�ɔ[�߂Ă���";
		mes "������ɗ��Ă��������B";
		close2;
		cutin "job_huntermaster",255;
		end;
	case 10:
	case 11:
		set .@num,strnpcinfo(2);
		if(CHANGE_HT != .@num) {	//�w��̃}�X�^�[�ƍ��v���Ȃ��Ƃ�
			mes "[�n���^�[]";
			mes "����H";
			mes "�]�E������]�Ȃ�n���^�[�M���h��";
			mes "���Ő\�����݂��ς܂��ė��Ă��������B";
			close2;
			cutin "job_huntermaster",255;
			end;
		}
		mes "[�n���^�[�M���h�}�X�^�[]";
		mes "����c�H�]�E�����ł����B";
		mes "����ł͎����̓��e��\���グ�܂��B";
		mes "�m�肽�����ڂ������Ă��������B";
		break;
	case 12:
	case 13:
		mes "[�n���^�[�M���h�}�X�^�[]";
		mes "����H�ȑO�ɓ]�E�������󂯂���";
		mes "�ł��ˁH";
		mes "�������ł����玎�����J�n���܂��B";
		mes "�����������Ƃ�����΂ǂ����B";
		break;
	case 14:
		mes "[�n���^�[�M���h�}�X�^�[]";
		mes "����A�����ɏI���Ė߂��Ă��܂����ˁB";
		mes "����ł́A�������I�������n���܂��B";
		mes "�n���^�[�M���h�̕��֖߂��Ă��������B";
		mes "���͂������������ł��邱�Ƃ��c����";
		mes "���܂�����c";
		next;
		mes "[�n���^�[�M���h�}�X�^�[]";
		mes "�����A����ł��B";
		mes "����ł͂���Łc";
		getitem 1007,1;
		set CHANGE_HT,15;
		close2;
		cutin "job_huntermaster",255;
		end;
	case 15:
		mes "[�n���^�[�M���h�}�X�^�[]";
		mes "�����n���^�[�ɂȂ肽���ł��傤�H";
		mes "�����n���^�[�ɂȂ鎞�A��ڎU��";
		mes "�����čs���܂����B";
		next;
		mes "[�n���^�[�M���h�}�X�^�[]";
		mes "�����n���^�[�M���h�ɋA���Ă݂Ȃ����[�B";
		close2;
		cutin "job_huntermaster",255;
		end;
	}
	//�퓬������������
	while(1) {
		next;
		switch (select("�����̓��e","�����̍��i����","���ӎ���","�������n�߂�")) {
		case 1:
			mes "[�n���^�[�M���h�}�X�^�[]";
			mes "���������ɂ��闎�Ƃ���������A";
			mes "���錈�߂�ꂽ�����X�^�[������";
			mes "���̂������̓��e�ł��B";
			next;
			mes "[�n���^�[�M���h�}�X�^�[]";
			mes "�n���^�[�ɂȂ邽�߂Ɉ�ԏd�v��";
			mes "�ڕW���ʔ\�͂ƁA�f����������";
			mes "���߂̂��̂ł��B";
			continue;
		case 2:
			mes "[�n���^�[�M���h�}�X�^�[]";
			mes "MAP��6����������n�܂�A";
			mes "�������ԓ��ɖڕW�����X�^�[��";
			mes "���ƁA";
			next;
			mes "[�n���^�[�M���h�}�X�^�[]";
			mes "�}�b�v�̒����ɒE�o�p�X�C�b�`��";
			mes "�o������̂ŁA�����������";
			mes "12�������ɒE�o����΃N���A�B";
			continue;
		case 3:
			mes "[�n���^�[�M���h�}�X�^�[]";
			mes "���ӎ����ł����c";
			mes "������O�̂��Ƃł����A";
			mes "���Ƃ����ɗ�����Ƃ܂��ŏ�����";
			mes "�n�߂Ȃ���΂Ȃ�܂���B";
			next;
			mes "[�n���^�[�M���h�}�X�^�[]";
			mes "��x�Ɉ�l���������󂯂邱�Ƃ�";
			mes "�Ȃ�܂��B";
			mes "����������̕��ɑ���ƁA�T������";
			mes "������͂��ł�����A�����O�̐l��";
			mes "�������ł�����`���b�g���[����";
			mes "�ҋ@���Ă��Ă��������B";
			next;
			mes "[�n���^�[�M���h�}�X�^�[]";
			mes "�O�̐l���E�����邩�A�N���A�����";
			mes "�`���b�g���[���őҋ@���̐l����";
			mes "���Ԃɓ��邱�Ƃ��ł��܂��B";
			mes "�܂��A�������̐l�����Ȃ���΁A";
			mes "�����ɊJ�n�ł��܂��B";
			continue;
		}
		break;
	}
	if(CHANGE_HT <= 11) {
		mes "[�n���^�[�M���h�}�X�^�[]";
		mes "�킩��܂����B�������ɑ�����";
		mes "�����܂��傤�B�����̒ʂ����";
		mes "���v�̂͂��ł��B";
		next;
		mes "[�n���^�[�M���h�}�X�^�[]";
		mes "���ƁA�M���h�����̂��߂�";
		mes "�����Ă��Ă����������ޗ�����";
		mes "������܂����̂ŁA�����������";
		mes "�]�E�����ɗՂ�ł��������B";
		getitem 1751,200;
		set CHANGE_HT,12;
		next;
		mes "[�n���^�[�M���h�}�X�^�[]";
		mes "����ł͌������F��܂��B";
	}
	else {
		mes "[�n���^�[�M���h�}�X�^�[]";
		mes "�킩��܂����B";
		mes "�����ɑ����Ă����܂��B";
		next;
		mes "[�n���^�[�M���h�}�X�^�[]";
		mes "����c�H��̖�͑O�ɓn���܂����B";
		mes "��x�ڂ͍����グ���܂���B";
		mes "�ł́A�n�߂܂��傤���B";
		next;
		if(select("�����܂�","������Ƒ҂��Ă��������B")==2) {
			mes "[�n���^�[�M���h�}�X�^�[]";
			mes "�����𐮂��Ă܂���������Ⴂ�B";
			close2;
			cutin "job_huntermaster",255;
			end;
		}
		mes "[�n���^�[�M���h�}�X�^�[]";
		mes "�悵�I���x�͍��i���Ă��������ˁI";
	}
	close2;
	cutin "job_huntermaster",255;
	savepoint "job_hunte",176,22;
	warp "SavePoint",0,0;
	end;
}

payon_in02,21,31,3	duplicate(�n���^�[�M���h�}�X�^�[)	�n���^�[#10	59
payon_in03,131,7,3	duplicate(�n���^�[�M���h�}�X�^�[)	�n���^�[#11	59

//==============================================================================
job_hunte,178,32,4	script	�ē���	107,5,2,{
OnTouch:
	if(CHANGE_HT != 13) {
		mes "[�ē���]";
		mes "�n���^�[�]�E������ւ悤�����B";
		next;
		mes "[�ē���]";
		mes "���̂��΂ɂ���T�����ɓ����";
		mes "�܂��Ȃ��������n�܂�B";
		next;
		mes "[�ē���]";
		mes "�J�n�ʒu����ړ����A";
		mes "�u�]�E�����p�����X�^�[�v�Ƃ������O��";
		mes "�W�I���S�ȏ�|���΁AMAP������";
		mes "����X�C�b�`��������悤�ɂȂ�B";
		next;
		mes "[�ē���]";
		mes "�X�C�b�`�������΁AMAP12��������";
		mes "�o�����E�o���邱�Ƃ��ł���B";
		mes "�������ԓ��ɖړI���������E�o";
		mes "���Ă���B";
		next;
		mes "[�ē���]";
		mes "�퓬�s�\�Ɋׂ�����A���Ƃ�����";
		mes "��������A�������Ԃ𒴉߂����ꍇ��";
		mes "���i�ƂȂ�ēx�������󂯂Ȃ����";
		mes "�Ȃ�Ȃ��B";
		next;
		mes "[�ē���]";
		mes "��̓M���h���x������Ă���͂��B";
		mes "������A�|�̂ݗp�ӂ��Ă�����";
		mes "�ǂ����낤�B";
		mes "�ł́A�p�ӂ��ł�����T������";
		mes "�������Ă���B";
		close;
	}
	percentheal 100,100;
	mes "[�ē���]";
	mes "���s�������c";
	mes "HP��SP���񕜂��Ă�낤�B";
	mes "���������Ȃ�o�������Ƃ�";
	mes "�\�����ǂ�����H";
	next;
	if(select("�܂��܂�����","��U������߂�")==1) {
		mes "[�ē���]";
		mes "�悵�A�撣���ė��h�ȃn���^�[��";
		mes "�Ȃ��Ăق����B";
		mes "�ł͍T�����ցB";
		mes "��ɓ������l�Ԃ������";
		mes "�����̎������I���܂�";
		mes "���̂܂ܑҋ@���Ă���B";
		close;
	}
	announce "�ē���: " +strcharinfo(0)+ "�l�̎����𒆒f�A���̕������Ă�������",9;
	mes "[�ē���]";
	mes "�ł̓t�F�C�����ɑ����Ă��B";
	mes "�܂��ȁB";
	close2;
	set CHANGE_HT,12;
	savepoint "payon",104,99;
	warp "SavePoint",0,0;
	end;
}

//==============================================================================
job_hunte,176,38,4	script	�n���^�[�]�E�T����::HT_ChatRoom	66,{
	end;
OnInit:
	waitingroom "�]�E������T��",10,"HT_ChatRoom::OnStart",1;
	end;
OnStart:
	disablewaitingroomevent;
	getwaitingpcid .@accid;
	if(attachrid(.@accid)) {
		set $@ht_tester$,strcharinfo(0);	//����҂̖��O
		set CHANGE_HT,13;
		donpcevent "HT_Center::OnStart";
		warp "job_hunte",90,68;
	}
	else
		enablewaitingroomevent;
	end;
}

//==============================================================================
job_hunte,0,0,0	script	HT_Center	-1,{
	end;
OnStart:
	set .count,4;
	hideonnpc "�X�C�b�`#HT_Test";
	hideonnpc "�E�o��#HT_Test";
	monster "job_hunte",54,73,"�]�E�����p�����X�^�[",1041,1,"HT_Center::OnKillOK";
	monster "job_hunte",54,73,"�]�E���������X�^�[",1002,1,"HT_Center::OnKillNG";
	monster "job_hunte",54,73,"�����X�^�[�T���v��",1002,1,"HT_Center::OnKillNG";
	monster "job_hunte",54,73,"�n���^�[�]�E�p���{",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",54,106,"�]�E���������X�^�[",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",54,106,"�n���^�[�����p���{",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",54,106,"�����߂Ȃ��ł�������",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",68,80,"�]�E�����p�����X�^�[",1015,1,"HT_Center::OnKillOK";
	monster "job_hunte",68,80,"�n���^�[�]�E�p�����X�^�[",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",72,103,"�]�E�����p�����X�^�[",1041,1,"HT_Center::OnKillNG";
	monster "job_hunte",72,103,"�]�E�����ǃ����X�^�[",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",72,103,"����Ȃ��ł�������",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",78,110,"�]�E���������X�^�[",1016,1,"HT_Center::OnKillNG";
	monster "job_hunte",78,110,"�]�E�����p�����X�^�[",1016,1,"HT_Center::OnKillNG";
	monster "job_hunte",78,110,"�n���^�[�]�E�p���{",1016,1,"HT_Center::OnKillNG";
	monster "job_hunte",79,94,"�]�E�����p�����X�^�[",1015,1,"HT_Center::OnKillOK";
	monster "job_hunte",79,94,"�n���^�[�]�E�p�����X�^�[",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",83,112,"�]�E�����ǃ����X�^�[",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",83,112,"�������Ă�������",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",89,129,"�]�E�����p�����X�^�[",1002,1,"HT_Center::OnKillOK";
	monster "job_hunte",89,129,"�]�E�����p�����X�^�[",1002,1,"HT_Center::OnKillNG";
	monster "job_hunte",90,91,"�]�E���������X�^�[",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",90,91,"�A�m���A��",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",90,91,"�]�E�����ǃ����X�^�[",1041,1,"HT_Center::OnKillNG";
	monster "job_hunte",90,92,"�]�E�����p�����X�^�[",1015,1,"HT_Center::OnKillOK";
	monster "job_hunte",93,101,"�]�E�����ǃ����X�^�[",1002,1,"HT_Center::OnKillNG";
	monster "job_hunte",108,102,"�]�E�����ǃ����X�^�[",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",108,102,"�]�E�����p�����X�^�[",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",108,102,"�E���Ȃ��ł�������",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",114,78,"�]�E�����p�����X�^�[",1015,1,"HT_Center::OnKillOK";
	monster "job_hunte",115,139,"�_�C��",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",115,139,"�t�B���b�v�A���[����",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",115,139,"�t�H�[��",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",115,139,"���b�N�X",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",125,69,"�]�E�����p�����X�^�[",1016,1,"HT_Center::OnKillOK";
	monster "job_hunte",125,69,"�]�E���������X�^�[",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",125,69,"�]�E�����p�����X�^�[",1015,1,"HT_Center::OnKillNG";
	monster "job_hunte",125,69,"�n���^�[�]�E�p���{",1015,1,"HT_Center::OnKillNG";
	initnpctimer;
	end;
OnKillOK:
	set .count,.count-1;
	if(.count) {
		announce "�����ē�: �܂����A�撣��I",9;
		end;
	}
	announce "�����ē�: �悵�A�ǂ�������B���Ƃ����ɋC�����AMAP�������̃X�C�b�`��T��",9;
	killmonster "job_hunte","All";
	hideoffnpc "�X�C�b�`#HT_Test";
	end;
OnKillNG:
	stopnpctimer;
	announce "�����ē�:  " +$@ht_tester$+ "����A�ԈႦ�܂����ˁB�܂����킵�Ă�������",9;
	areawarp "job_hunte",50,64,129,143,"job_hunte",176,22;
	killmonster "job_hunte","All";
	enablewaitingroomevent "HT_ChatRoom";
	end;
OnTimer1000:
	announce "�����ē�: ����ł͓]�E�������n�߂܂�",9;
	end;
OnTimer3000:
	announce "�����ē�: �u�]�E�����p�����X�^�[�v������I��œ|���Ă�������",9;
	end;
OnTimer5000:
	announce "�����ē�: �E�o�p�X�C�b�`�𑀍삷��΁AMAP12�������̏o�����J����܂�",9;
	end;
OnTimer7000:
	announce "�����ē�: �E�o�܂ł̐������Ԃ�3���ł�",9;
	end;
OnTimer9000:
	announce "�����ē�: 1���o�߂��Ƃɂ��m�点���܂��B����ł̓X�^�[�g�I",9;
	end;
OnTimer11000:
	announce "�����ē�:  ******�c�� 3 �� ******",9;
	end;
OnTimer71000:
	announce "�����ē�:  ******�c�� 2 �� ******",9;
	end;
OnTimer131000:
	announce "�����ē�:  ******�c�� 1 �� ******",9;
	end;
OnTimer161000:
	announce "�����ē�:  ******�c�� 30 �b ******",9;
	end;
OnTimer186000:
	announce "�����ē�:  �����I�� 5 �b�O. . . . .",9;
	end;
OnTimer187000:
	announce "�����ē�:  �����I�� 4 �b�O. . . .",9;
	end;
OnTimer188000:
	announce "�����ē�:  �����I�� 3 �b�O. . .",9;
	end;
OnTimer189000:
	announce "�����ē�:  �����I�� 2 �b�O. .",9;
	end;
OnTimer190000:
	announce "�����ē�:  �����I�� 1 �b�O.",9;
	end;
OnTimer191000:
	announce "�����ē�:  0",9;
	end;
OnTimer192000:
	announce "�����ē�:  �������Ԃ��߂��܂����B���̒�������҂����Ă��܂�",9;
	areawarp "job_hunte",50,64,129,143,"job_hunte",176,22;
	end;
OnTimer195000:
	stopnpctimer;
	killmonster "job_hunte","All";
	enablewaitingroomevent "HT_ChatRoom";
	end;
}

//==============================================================================
job_hunte,93,101,0		script	�X�C�b�`#HT_Test	723,1,1,{
OnTouch:
	mes "�E�o�p�X�C�b�`������A";
	mes "�{�^�����O������B";
	next;
	switch (select("�E�o","������","�Ď���")) {
	case 1:
		mes "�E�o�����J���܂���";
		announce "switch:  ## �E�o�����J���܂��� ##",9;
		hideoffnpc "�E�o��#HT_Test";
		close;
	case 2:
		mes "���삪��������܂���";
		announce "switch:  ## ���삪��������܂��� ##",9;
		close;
	case 3:
		mes "�T�����ɓ]������܂�";
		announce "switch:  ## �]�E���������f����܂��c�c ##",9;
		close2;
		stopnpctimer "HT_Center";
		warp "job_hunte",176,22;
		killmonster "job_hunte","All";
		enablewaitingroomevent "HT_ChatRoom";
		end;
	}
}

//==============================================================================
job_hunte,89,139,0		script	�E�o��#HT_Test	45,1,1,{
	stopnpctimer "HT_Center";
	set CHANGE_HT,14;
	savepoint "payon",104,99;
	if(rand(2))
		warp "payon_in02",17,31;
	else
		warp "payon_in03",128,7;
	killmonster "job_hunte","All";
	enablewaitingroomevent "HT_ChatRoom";
	end;
}

//==============================================================================
job_hunte,52,67,0	script	#HT_Abyss	139,0,1,{
	stopnpctimer "HT_Center";
	announce "�����ē�:  " +$@ht_tester$+ "�l�A���Ƃ����ɗ����܂����B",9;
	warp "job_hunte",176,22;
	killmonster "job_hunte","All";
	enablewaitingroomevent "HT_ChatRoom";
	end;
}

job_hunte,53,67,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,53,69,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,54,68,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,54,70,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,55,70,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1

job_hunte,59,66,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,59,67,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,61,66,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,61,67,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,68,67,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,69,67,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,68,69,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,69,69,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,76,66,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,76,67,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,77,66,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,77,67,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,82,68,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,82,69,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,83,68,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,83,69,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,96,66,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,96,67,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,97,66,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,97,67,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,100,68,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,100,69,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,101,68,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,101,69,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,107,66,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,107,67,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,109,66,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,109,67,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,117,68,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,117,69,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,119,68,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,119,69,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,124,66,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,124,67,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,125,66,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,125,67,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,126,70,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,126,71,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,127,70,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,127,71,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,124,78,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,124,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,125,78,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,125,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,126,82,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,126,83,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,127,82,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,127,83,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,126,86,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,126,87,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,127,86,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,127,87,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,125,96,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,125,97,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,127,96,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,127,97,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,126,107,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,127,107,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,126,109,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,127,109,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,124,119,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,125,119,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,124,121,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,125,121,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,126,126,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,126,127,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,127,126,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,127,127,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,124,130,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,124,131,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,125,130,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,125,131,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,126,138,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,2
job_hunte,127,138,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,2
job_hunte,126,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,127,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,120,138,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,120,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,121,138,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,121,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,116,140,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,116,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,117,140,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,117,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,112,140,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,112,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,113,140,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,113,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,120,138,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,120,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,121,138,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,121,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,106,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,107,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,106,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,107,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,99,138,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,99,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,101,138,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,101,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,82,138,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,82,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,83,138,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,83,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,78,140,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,78,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,79,140,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,79,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,72,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,73,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,72,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,73,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,62,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,63,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,64,140,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,64,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,62,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,52,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,53,139,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,54,140,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,54,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,52,141,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,52,133,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,53,133,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,52,135,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,53,135,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,52,122,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,53,122,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,54,120,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,54,121,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,52,120,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,54,109,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,55,109,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,54,111,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,55,111,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,53,101,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,1
job_hunte,53,103,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,55,101,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,55,103,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,54,92,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,54,93,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,55,92,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,55,93,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,52,90,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,52,91,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,53,90,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,53,91,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,52,86,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,52,87,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,53,86,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,53,87,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,54,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,55,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,54,81,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,55,81,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,82,78,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,82,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,83,78,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,83,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,78,80,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,78,81,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,79,80,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,79,81,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,74,78,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,74,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,75,78,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,75,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,66,78,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,66,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,67,78,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,67,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,64,81,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,65,81,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,64,83,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,65,83,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,66,88,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,66,89,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,67,88,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,67,89,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,64,92,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,64,93,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,65,92,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,65,93,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,66,100,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,66,101,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,67,100,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,67,101,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,64,106,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,64,107,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,65,106,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,65,107,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,64,112,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,64,113,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,65,112,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,65,113,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,66,116,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,66,117,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,67,116,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,67,117,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,66,120,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,66,121,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,67,120,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,67,121,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,64,128,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,64,129,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,65,128,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,65,129,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,68,126,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,68,127,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,69,126,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,69,127,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,75,128,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,75,129,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,77,128,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,77,129,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,82,126,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,82,127,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,83,126,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,83,127,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,96,128,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,96,129,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,97,128,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,97,129,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,100,126,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,100,127,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,101,126,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,101,127,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,106,128,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,106,129,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,107,128,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,107,129,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,112,126,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,112,127,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,113,126,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,113,127,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,114,118,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,114,119,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,115,118,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,115,119,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,114,114,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,114,115,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,115,114,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,115,115,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,112,110,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,112,111,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,113,110,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,113,111,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,112,103,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,113,103,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,112,105,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,113,105,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,114,96,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,114,97,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,115,96,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,115,97,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,112,90,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,112,91,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,113,90,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,113,91,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,114,84,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,114,85,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,115,84,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,115,85,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,114,80,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,114,81,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,115,80,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,115,81,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,110,78,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,110,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,111,78,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,111,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,104,78,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,104,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,105,78,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,105,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,101,80,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,101,81,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,103,80,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,103,81,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,94,78,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,94,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,95,78,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,95,79,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,76,114,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,76,115,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,77,114,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,77,115,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,80,110,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,80,111,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,81,110,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,81,111,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,82,116,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,82,117,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,83,116,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,83,117,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,86,114,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,86,115,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,87,114,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,87,115,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,82,100,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,82,101,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,83,100,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,83,101,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,76,94,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,76,95,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,77,94,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,77,95,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,78,92,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,78,93,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,79,92,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,79,93,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,86,92,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,86,93,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,87,92,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,87,93,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,90,96,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,90,97,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,91,96,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,91,97,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,99,94,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,99,95,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,100,93,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,101,93,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,101,95,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,102,90,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,102,91,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,103,90,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,103,91,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,102,98,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,102,99,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,103,98,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,103,99,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,106,104,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,106,105,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,107,104,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,107,105,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,102,116,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,102,117,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,103,116,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,103,117,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,76,98,0		duplicate(#HT_Abyss)	���Ƃ���	139,2,0
job_hunte,76,99,0		duplicate(#HT_Abyss)	���Ƃ���	139,2,0
job_hunte,78,101,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,3
job_hunte,79,101,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,3
job_hunte,81,104,0		duplicate(#HT_Abyss)	���Ƃ���	139,5,0
job_hunte,81,105,0		duplicate(#HT_Abyss)	���Ƃ���	139,5,0
job_hunte,86,106,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,87,106,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,87,104,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,90,108,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,6
job_hunte,91,108,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,6
job_hunte,92,114,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,92,115,0		duplicate(#HT_Abyss)	���Ƃ���	139,1,0
job_hunte,90,115,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0

job_hunte,94,98,0		duplicate(#HT_Abyss)	���Ƃ���	139,2,0
job_hunte,94,99,0		duplicate(#HT_Abyss)	���Ƃ���	139,2,0
job_hunte,96,102,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,4
job_hunte,97,102,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,4
job_hunte,94,108,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,95,108,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,1
job_hunte,96,106,0		duplicate(#HT_Abyss)	���Ƃ���	139,2,0
job_hunte,96,107,0		duplicate(#HT_Abyss)	���Ƃ���	139,2,0
job_hunte,98,109,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,2
job_hunte,99,109,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,2
job_hunte,99,106,0		duplicate(#HT_Abyss)	���Ƃ���	139,0,0
job_hunte,102,108,0		duplicate(#HT_Abyss)	���Ƃ���	139,4,0
job_hunte,102,109,0		duplicate(#HT_Abyss)	���Ƃ���	139,4,0


//==========================================
// �t�@���R�������^��
//------------------------------------------

//in_hunter,146,99,2	script	�t�@���R���Ǘ���	105,{
hu_in01,381,304,5	script	�t�@���R���Ǘ���	105,{
//	if(Job != Job_Hunter && Job != Job_Ranger) {
	if(BaseJob != Job_Hunter && Job != Job_Ranger) {
		mes "�o�J���`�I�t�@���R����";
		mes "�n���^�[�ƃX�i�C�p�[��";
		mes "�����W���[��p���I";
		close;
	}
	mes "[�t�@���R���Ǘ���]";
	mes "�t�@���R�����K�v���H";
	mes "��H 2500 zeny���I";
	next;
	if(select("���p����","��߂�")==2) {
		mes "[�t�@���R���Ǘ���]";
		mes "����! ���̂܂˂��B";
		mes "�����̌N�I";
		mes "��~����I��~�I";
		close;
	}
	if(checkfalcon()) {
		mes "[�t�@���R���Ǘ���]";
		mes "�N�ɂ͂����t�@���R����";
		mes "���邶��Ȃ����B";
		close;
	}
	if(Zeny < 2500) {
		mes "[�t�@���R���Ǘ���]";
		mes "����������Ȃ��I";
		close;
	}
	if(getskilllv(127) < 1) {
		//������
		close;
	}
	set Zeny,Zeny-2500;
	setfalcon;
	close;
}