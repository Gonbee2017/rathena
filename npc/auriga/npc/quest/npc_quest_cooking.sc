//==============================================================================
// Ragnarok Online Cooking Script     by Blaze
//
//   �� QUE_COOKING -> 0�`11
//==============================================================================

// �����ޗ����l
prontera,156,212,1		shop	�����ޗ����l	700,7454:-1,7456:-1,7482:-1,580:-1
geffen,196,111,3		shop	�����ޗ����l	85,7482:-1
payon,206,119,5		shop	�����ޗ����l	89,7455:-1
//morocc,120,97,5		shop	�����ޗ����l	86,7455:700,7453:700,7454:700,7456:1000,7452:1000
moc_ruins,115,123,5		shop	�����ޗ����l	86,7455:-1,7453:-1,7454:-1,7456:-1,7452:-1
alberta,167,135,5		shop	�����ޗ����l	712,579:-1
aldebaran,165,107,1		shop	�����ޗ����l	97,7456:-1,7452:-1,580:-1
xmas,152,137,5		shop	�����ޗ����l	83,7457:-1,577:-1
comodo,225,163,3		shop	�����ޗ����l	83,7455:-1,7453:-1,7454:-1,579:-1
yuno,130,173,3		shop	�����ޗ����l	83,7457:-1,7482:-1
amatsu,206,150,3		shop	�����ޗ����l	83,7453:-1,579:-1
gonryun,147,101,5		shop	�����ޗ����l	83,7452:-1,580:-1
umbala,102,154,3		shop	�����ޗ����l	83,7456:-1,577:-1
niflheim,209,180,5		shop	�����ޗ����l	83,581:-1
louyang,256,123,5		shop	�����ޗ����l	820,7454:-1,577:-1
ayothaya,203,178,3		shop	�����ޗ����l	83,7455:-1,577:-1
einbroch,224,207,5		shop	�����ޗ����l	83,7457:-1
lighthalzen,126,126,3	shop	�����ޗ����l	83,7456:-1,7452:-1

prt_castle,43,30,3	script	�V�������E�I�����A��	878,{
	if(getequipid2(1) != 5026) {
		if(Sex) {
			cutin "orleans_5",0;
			mes "[�V�������E�I�����A��]";
			mes "�c�c�c�c";
			next;
			emotion 6;
			mes "[�V�������E�I�����A��]";
			mes "���b�V���B";
			mes "���^�N�V�̉������āA";
			mes "����Ȋ�����Ă���̂ł����H";
			next;
			mes "[�V�������E�I�����A��]";
			mes "���^�N�V�̂��̃����N�Y�V���N�V���c�H";
			mes "����Ƃ��c�c";
			mes "�}�_���x���j�J�̃w�A�[�f�U�C���H";
			mes "����Ƃ��A�A���g�j�I��������A";
			mes "���̒������}�t���[�H";
			next;
			cutin "orleans_7",0;
			mes "[�V�������E�I�����A��]";
			mes "�܂����A���̃��K�l��";
			mes "���b�P���x���А��̃t���[������";
			mes "�����������ŁA���^�N�V�̊֐S��";
			mes "�������Ƃ��Ă�̂ł͂Ȃ��ł��傤�ˁH";
			mes "���b�V���͂���Ȃ�";
			mes "�ڂ������Ȃ��͂��ł��B";
			next;
			cutin "orleans_2",0;
			mes "[�V�������E�I�����A��]";
			mes "�c�c�c�c";
			next;
			cutin "orleans_4",0;
			mes "[�V�������E�I�����A��]";
			mes "�����c�c";
			mes "���b�V���̂����ŏW���ł��Ȃ��c�c";
			mes "���^�N�V�̃A�g���G����";
			mes "�o�čs���Ă��炦�܂��񂩁I";
			mes "�G�g�����[�A�A�f���[!!";
		}
		else {
			cutin "orleans_1",0;
			mes "[�V�������E�I�����A��]";
			mes "�����c�c�@�}�h���A�[���I";
			mes "�v�X�ɂ��ڂɂ�����܂��B";
			mes "���̔��e�͑��ς�炸�Łc�c";
			mes "���������Q�����Ē����Ă܂��B";
			next;
			cutin "orleans_2",0;
			mes "[�V�������E�I�����A��]";
			mes "���Ȃ��̑��ŔL������Ă���";
			mes "���炵���q�́A���Ȃ��̖��H";
			mes "�{���ɉ����ł��ˁB";
			next;
			switch(select("�c�c�H","���̖��ł�","�m��Ȃ��q���ł�")) {
			case 1:
				cutin "nyuang_3",2;
				emotion 2,"�L�������Ă���q#Cooking";
				mes "[�L�������Ă���q]";
				mes "�j���n�n�n�n�I�@�j���n�n�I";
				mes "�i�j���A�`�@�j���A�`�j";
				next;
				cutin "orleans_2",0;
				emotion 18;
				mes "[�V�������E�I�����A��]";
				mes "�����q�ł��c�c�B";
				mes "���ƂȂ������Ă��Ă��������B";
				break;
			case 2:
				cutin "nyuang_1",2;
				emotion 1,"�L�������Ă���q#Cooking";
				mes "[�L�������Ă���q]";
				mes "�c�c�j���A�H";
				mes "�i�j���A�`�j";
				next;
				cutin "orleans_2",0;
				emotion 3;
				mes "[�V�������E�I�����A��]";
				mes "���܂肨�o����ɂ͎��Ă��Ȃ����A";
				mes "���ƂȂ����ĉ��炵���ł��ˁB";
				mes "�����Ă���A���e�B�[�N�ȔL��";
				mes "���F�ɋP���Ă���悤�Ɍ����܂���B";
				break;
			case 3:
				cutin "nyuang_2",2;
				emotion 32,"�L�������Ă���q#Cooking";
				mes "[�L�������Ă���q]";
				mes "�j���n�n�n�B";
				mes "�i�j���A�`���j";
				next;
				cutin "orleans_3",0;
				emotion 19;
				mes "[�V�������E�I�����A��]";
				mes "���A���炵�܂����B";
				mes "�}�h���A�[���ɂƂ񂾂�������c�c�B";
				mes "�ǂ��̎q����������܂��񂪁A";
				mes "�����ɒǂ��o�����܂��B";
				break;
			}
			next;
			cutin "orleans_1",0;
			mes "[�V�������E�I�����A��]";
			mes "�c�c���āB";
			next;
			mes "[�V�������E�I�����A��]";
			mes "������x�����A�����Ē����܂��B";
			mes "���Ȃ��̎��]�ł���Ɠ����ɁA���i��";
			mes "�����Ȃ����Ԃ��炩�������鉀�|�ƁB";
			mes "�ō��̔������߂邽�߂ɖ`������";
			mes "�T���ƁA�V�������E�I�����A���ł��B";
			next;
			mes "[�V�������E�I�����A��]";
			mes "���^�N�V�͂ǂ����Ă��}�h���A�[����";
			mes "�Y����܂���B�Ⴆ�A���^�N�V��";
			mes "�ق�̏����ς�����悤�Ɍ����Ă��A";
			mes "�S�����͕ς��Ȃ��Ƃ������Ƃ�";
			mes "���������������܂����H";
			next;
			cutin "orleans_4",0;
			mes "[�V�������E�I�����A��]";
			mes "�������A�����É����c�c���^�N�V��";
			mes "�f�U�[�g���ᖡ���Ă����������";
			mes "���Ȃ��Ȃ������́c�c";
			mes "����ȈӖ��̂Ȃ��d����";
			mes "�ɂ��Ԃ����X�ł��c�c�B";
			mes "�����A�ƂĂ��߂������ł�!!";
			next;
			mes "[�V�������E�I�����A��]";
			mes "�����m�Ƃ͎v���܂����A";
			mes "���^�N�V�̑n���Ƃ����̂�";
			mes "�a���̋�ɂ��o�����Ă��犮���ł���";
			mes "���l�Ȃ̂ł��B�ǂ����痈���̂�";
			mes "������Ȃ����K���Ɏ��͂������Ă�����";
			mes "�悤�Ȃ��̂ł͂Ȃ��Ƃ������Ƃł�!!";
			next;
			cutin "orleans_3",0;
			mes "[�V�������E�I�����A��]";
			mes "�͂��A����v���܂����B";
			mes "���Ȃ��ɓ{�����̂ł͂���܂���B";
			mes "�����A�����Ȃ������̗����";
			mes "���C���C�����Ă��܂��āc�c�B";
			mes "���ɐ\���󂲂����܂���B";
			next;
			cutin "orleans_1",0;
			mes "[�V�������E�I�����A��]";
			mes "�܂��̋@�����΁A���^�N�V�̏�����";
			mes "���ӂ𐷂������蕨���������܂��傤�B";
			mes "����͂��Ȃ��̐O�ɏ����̊Â��A";
			mes "�����Ė��c���c�����Ƃł��傤�B";
			mes "�}�h���A�[���A����ł͂�������悤�B";
		}
		close2;
		cutin "orleans_1",255;
		end;
	}
	switch(QUE_COOKING) {
	case 0:
		cutin "orleans_5",0;
		emotion 9;
		mes "[�V�������E�I�����A��]";
		mes "���`�@���`�@�ʓ|�������B";
		mes "����Ȏ��Ԃ�����Ȃ�A";
		mes "�ǂ����ł��������t���[�c�ł�";
		mes "�H�ׂĂ�������";
		mes "�����Ɗy�����̂Ɂc�c�B";
		next;
		mes "[�V�������E�I�����A��]";
		mes "�����Ƃ����̂͑ދ��ȍ�Ɓc�c";
		mes "�ޗ��̐[�����Ȃ�Ăł���߁c�c";
		mes "���ۂ͐V�N�ȍޗ�������";
		mes "���h�ȗ����ɂȂ�c�c�B";
		next;
		mes "[�V�������E�I�����A��]";
		mes "�ق�A���Ȃ��������v���܂���H";
		mes "�����������ɗ����l�Ɍ�������";
		mes "�������Ƃł͂Ȃ��ł��傤���c�c�B";
		next;
		switch(select("���́c�c���ł����H","�����N�����o���Ă܂����H","�I�����A���l�H")) {
			case 1:
				cutin "orleans_7",0;
				mes "[�V�������E�I�����A��]";
				mes "�N�Ɍ����Ă�Ǝv���܂����H";
				mes "�������̃}�h�����ɁH";
				mes "����Ƃ����̉��Ȃ��L�Ǝq���ɁH";
				next;
				cutin "nyuang_4",2;
				mes "[�L�������Ă���q]";
				mes "�E�I�H�H�`!!";
				mes "�i�j���A�A�A��!!�j";
				next;
				emotion 23;
				cutin "orleans_3",0;
				mes "[�V�������E�I�����A��]";
				mes "����I�@�������Ȃ��ł��������B";
				mes "�܂������c�c�Ȃ�Đ��i�B";
				mes "��́A���̎q�͒N��";
				mes "�A��ė����̂ł��傤�c�c�B";
				break;
			case 2:
				mes "[�V�������E�I�����A��]";
				mes "���������O�ɗ������w�тɗ�����";
				mes "�^���Ɋ���Ă�p�����܂�ɐ؂Ȃ��A";
				mes "�󂯓���Ă�����";
				mes "�����t�̎u�]�҂ł��傤�H";
				mes "�������o���Ă܂��I";
				next;
				mes "[�V�������E�I�����A��]";
				mes "���������΂��Ȃ��̖��O�́c�c";
				mes "�����Ɓc�c�@��c�c";
				next;
				mes "[�V�������E�I�����A��]";
				mes "�c�c�c�c";
				next;
				cutin "orleans_7",0;
				mes "[�V�������E�I�����A��]";
				mes "�������Ȏ��͒u���Ă����܂��傤�c�c�B";
				break;
			case 3:
				cutin "orleans_4",0;
				mes "[�V�������E�I�����A��]";
				mes "�m���m���m���`�B";
				mes "���̂悤�ɌĂ΂Ȃ��ł��������B";
				mes "���^�N�V���ĂԎ���";
				mes "�t�@�[�X�g�l�[���ŌĂ�ł��������B";
				next;
				cutin "orleans_1",0;
				mes "[�V�������E�I�����A��]";
				mes "�����c�c";
				mes "�V�������V�F�t";
				mes "�ƌĂ�ł��������B";
				next;
				mes "[�V�������E�I�����A��]";
				mes "�c�c�c�c";
				next;
				cutin "orleans_7",0;
				mes "[�V�������E�I�����A��]";
				mes "��x�ƊԈ��Ȃ��悤�ɁB";
				break;
		}
		next;
		cutin "orleans_5",0;
		mes "[�V�������E�I�����A��]";
		mes "����ł́A";
		mes "����������������܂��傤�B";
		mes "�ƂĂ��ȒP�ȗ������c�c�B";
		mes "���^�N�V�͓����������x�������̂�";
		mes "�匙���ł��̂ŁA";
		mes "�����Ɗo���Ă����悤�ɁI";
		next;
		cutin "orleans_7",0;
		mes "[�V�������E�I�����A��]";
		mes "����ł́A������闿���́c�c";
		next;
		set QUE_COOKING,rand(1,6);
		cutin "orleans_6",0;
		switch(QUE_COOKING) {
			case 1: //�o�b�^���u�ߕ�
				mes "[�V�������E�I�����A��]";
				mes "�c�c";
				mes "�u�o�b�^���u�ߕ��v���������ȁB";
				next;
				emotion 6;
				mes "[�V�������E�I�����A��]";
				mes "���H�@���̌������Ȋ�́H";
				mes "�܂������̃��^�N�V��";
				mes "�H�ׂ�Ȃ��悤�ȗ�����";
				mes "���Ƃł��v���Ă�̂ł����H";
				next;
				mes "[�V�������E�I�����A��]";
				mes "�Ƃɂ����A�ޗ��͎��̒ʂ�I";
				mes "�o�b�^�̑�5�A";
				mes "�Â��t���C�p��1�A";
				mes "�H�p��1�c�c�B";
				mes "�ȏ�I";
				break;
			case 2: //�u�h�E�ʏ`����n�[�u�e�B�[
				mes "[�V�������E�I�����A��]";
				mes "�c�c";
				mes "�u�u�h�E�ʏ`����n�[�u�e�B�[�v";
				mes "�ɂ��悤���ȁc�c�B";
				next;
				emotion 6;
				mes "[�V�������E�I�����A��]";
				mes "���H�@���̊�́H";
				mes "�܂������̃��^�N�V��";
				mes "�ƂĂ��V���v���Ő󔖂ȃe�B�[��";
				mes "���Ƃł��v���Ă�̂ł����H";
				next;
				mes "[�V�������E�I�����A��]";
				mes "�Ƃɂ����A�ޗ��͎��̒ʂ�I";
				mes "�u�h�E3�A";
				mes "�ԃ|�[�V����2�c�c�B";
				mes "�ȏ�I";
				break;
			case 3: //�����K�j
				mes "[�V�������E�I�����A��]";
				mes "�c�c";
				mes "�u�����K�j�v�ɂ��悤�B";
				next;
				emotion 6;
				mes "[�V�������E�I�����A��]";
				mes "���H�@���̊�́H";
				mes "�܂������̃��^�N�V��";
				mes "�ȒP�ȗ����������̂悤��";
				mes "������Ƃł��v���Ă���̂ł����H";
				next;
				mes "[�V�������E�I�����A��]";
				mes "�Ƃɂ����A�ޗ��͎��̒ʂ�I";
				mes "���Ƀj�b�p10�A";
				mes "�΃n�[�u10�A";
				mes "���|�[�V����1�c�c�B";
				mes "�ȏ�I";
				break;
			case 4: //������̗��̖n�`�X�[�v
				mes "[�V�������E�I�����A��]";
				mes "�u������̗��̖n�`�X�[�v�v�ɂ��悤�B";
				next;
				emotion 6;
				mes "[�V�������E�I�����A��]";
				mes "���H�@���̊�H";
				mes "�܂������̃��^�N�V��";
				mes "�N���������߂邨�������";
				mes "���Ƃł��v���Ă�̂ł����H";
				next;
				mes "[�V�������E�I�����A��]";
				mes "�Ƃɂ����A�ޗ��͎��̒ʂ�I";
				mes "����1�A";
				mes "������̗�10�A";
				mes "�n�`1�c�c�B";
				mes "�ȏ�I";
				break;
			case 5: //�n�`���u�h�E�W���[�X
				mes "[�V�������E�I�����A��]";
				mes "�u�n�`���u�h�E�W���[�X�v�ɂ��悤�B";
				next;
				emotion 6;
				mes "[�V�������E�I�����A��]";
				mes "���H�@���̊�́H";
				mes "�܂������̃��^�N�V���A";
				mes "�u�h�E�W���[�X�Ƀn�`���������������B";
				mes "�����ȊȒP�ȃW���[�X��";
				mes "���Ƃł��v���Ă�̂ł����H";
				next;
				mes "[�V�������E�I�����A��]";
				mes "�Ƃɂ����A�ޗ��͎��̒ʂ�I";
				mes "�n�`��1�A";
				mes "�u�h�E2�A";
				mes "�ԃ|�[�V����1�c�c�B";
				mes "�ȏ�I";
				break;
			case 6: //�T���̂������u��
				mes "[�V�������E�I�����A��]";
				mes "�c�c";
				mes "�u�T���̂������u�߁v�ɂ��悤�B";
				next;
				emotion 6;
				mes "[�V�������E�I�����A��]";
				mes "���H�@���̊�́H";
				mes "�܂������̃��^�N�V���A";
				mes "���肦�Ȃ��ޗ���";
				mes "����������Ƃł��v���Ă���̂ł����H";
				next;
				mes "[�V�������E�I�����A��]";
				mes "�Ƃɂ����A�ޗ��͎��̒ʂ�I";
				mes "�T���̂�����5�A";
				mes "�Â��t���C�p��1�A";
				mes "�H�p��1�c�c�B";
				mes "�ȏ�I";
				break;
		}
		close2;
		cutin "orleans_6",255;
		end;
	case 1: //�o�b�^���u�ߕ�
		set .@dishid,12041;
		setarray .@need,940,7031,7457;
		setarray .@amount,5,1,1;
		break;
	case 2: //�u�h�E�ʏ`����n�[�u�e�B�[
		set .@dishid,12046;
		setarray .@need,514,501;
		setarray .@amount,3,2;
		break;
	case 3: //�����K�j
		set .@dishid,12051;
		setarray .@need,960,511,503;
		setarray .@amount,10,10,1;
		break;
	case 4: //������̗��̖n�`�X�[�v
		set .@dishid,12056;
		setarray .@need,577,908,1024;
		setarray .@amount,1,10,1;
		break;
	case 5: //�n�`���u�h�E�W���[�X
		set .@dishid,12061;
		setarray .@need,518,514,501;
		setarray .@amount,1,2,1;
		break;
	case 6: //�T���̂������u��
		set .@dishid,12066;
		setarray .@need,942,7031,7457;
		setarray .@amount,5,1,1;
		break;
	case 7:
		cutin "orleans_7",0;
		mes "[�V�������E�I�����A��]";
		mes "�ӂ��A���܂����ˁB";
		mes "����ȒP���Ȏ��ɏW�����āA";
		mes "���������Ă��܂��������g��";
		mes "���������낵���Ƃ������c�c�B";
		next;
		cutin "orleans_1",0;
		mes "[�V�������E�I�����A��]";
		mes "�t�t�t�B";
		mes "��͂肱�̒��x�ł�";
		mes "���^�N�V�̗~���𖞑��������܂���B";
		close2;
		cutin "orleans_1",255;
		end;
	case 8:
		cutin "orleans_5",0;
		mes "[�V�������E�I�����A��]";
		mes "����ɂ��Ă��c�c";
		mes "���̎q�ƔL��";
		mes "��̂ǂ����痈���̂��c�c�B";
		next;
		cutin "orleans_4",0;
		mes "[�V�������E�I�����A��]";
		mes "���K��!!";
		mes "���̎q�ƔL��";
		mes "�������ǂ��o���Ă�������!!";
		next;
		cutin "nyuang_1",2;
		mes "[�L�������Ă���q]";
		mes "�j���A�H";
		mes "(�j���A��)";
		next;
		switch(select("���O�͉��H","����������Ă����悤���H","�����ˁ`","�������瑁���o�čs��!!")) {
			case 1:
				emotion 33,"�L�������Ă���q#Cooking";
				mes "[�L�������Ă���q]";
				mes "�j���E�`�@�j���A�`";
				mes "�i�t�E�[�[�@�j��!!�j";
				next;
				cutin "orleans_4",0;
				mes "[�V�������E�I�����A��]";
				mes "���O�𕷂��Ƃ͌����ĂȂ��̂Ɂc�c�B";
				mes "���ƌ����Ă���̂�������Ȃ����B";
				break;
			case 2:
				cutin "nyuang_2",2;
				emotion 32,"�L�������Ă���q#Cooking";
				mes "[�L�������Ă���q]";
				mes "�j���n�n�`�@�t�t�`";
				mes "�i�t�E�[�[�j";
				next;
				cutin "orleans_5",0;
				mes "[�V�������E�I�����A��]";
				mes "��������Ă܂��ˁB";
				mes "������������A�����ǂ��o���āI";
				break;
			case 3:
				cutin "nyuang_3",2;
				emotion 18,"�L�������Ă���q#Cooking";
				mes "[�L�������Ă���q]";
				mes "�j���n�n�n�`�@�j���n�n�`";
				mes "�i�j���A�`�@�j���A�`�j";
				next;
				cutin "orleans_4",0;
				mes "[�V�������E�I�����A��]";
				mes "�ꏏ�ɗV��ł�̂ł����c�c�B";
				mes "�����c�c";
				mes "���Ȃ����o�Ă����Ă��������B";
				break;
			case 4:
				emotion 9,"�L�������Ă���q#Cooking";
				mes "[�L�������Ă���q]";
				mes "�c�c";
				mes "�i�j���A���H�j";
				next;
				cutin "nyuang_4",2;
				emotion 6,"�L�������Ă���q#Cooking";
				misceffect 1,"";
				percentheal -10,0;
				mes "[�L�������Ă���q]";
				mes "�t�E�[�[�[!!�@�j��!!";
				mes "�i�j���A�`�j";
				next;
				cutin "orleans_7",0;
				mes "[�V�������E�I�����A��]";
				mes "�������Ă���̂ł����B";
				mes "����Ȏq���ɉ�����Ȃ�āc�c�B";
				break;
		}
		close2;
		cutin "orleans_7",255;
		end;
	case 9:
		cutin "orleans_5",0;
		emotion 6;
		mes "[�V�������E�I�����A��]";
		mes "����ȏ�䖝�ł��܂���B";
		mes "���̃��^�N�V�����̎q��ǂ��o���܂��I";
		next;
		cutin "orleans_6",0;
		mes "[�V�������E�I�����A��]";
		mes "�o�債�āc�c�B";
		next;
		cutin "nyuang_4",2;
		emotion 6,"�L�������Ă���q#Cooking";
		mes "[�L�������Ă���q]";
		mes "�t�E�E�E!!";
		mes "�i�j���A�A�A!!�j";
		next;
		cutin "orleans_6",0;
		mes "[�V�������E�I�����A��]";
		mes "���邳���ł��ˁc�c";
		mes "���A�Â��ɂ��Ă����܂��傤�B";
		mes "��̊O�ɒǂ��o����Ă�";
		mes "������Ȃ��ł��������B�t�t�t�B";
		next;
		cutin "orleans_6",255;
		mes "[�V�������E�I�����A��]";
		mes "�o�債�Ȃ���!!";
		mes "�K�E!!";
		mes "�I�����A���Ɠ`���́c�c";
		mes "�����_�t���r���[�e�B�t��";
		mes "�g���l�[�h�p���`!!";
		next;
		hideoffnpc "�q���b�P#Cooking";
		emotion 23;
		emotion 2,"�L�������Ă���q#Cooking";
		mes "- �V���V���V���b!! -";
		next;
		cutin "job_black_hucke01",1;
		mes "[�q���b�P]";
		mes "�I�����A���I";
		mes "�ǂ�����!?";
		next;
		cutin "orleans_3",0;
		mes "[�V�������E�I�����A��]";
		mes "��b!!";
		mes "�q���A�q���b�P�o����I";
		mes "�����܂�����c�c�B";
		mes "�����ւ͉��̗p����";
		mes "�������������̂ł����H";
		next;
		cutin "job_black_hucke02",1;
		mes "[�q���b�P]";
		mes "���A�j���[�����I";
		mes "�����ŉ������Ă�񂾁H";
		next;
		cutin "nyuang_3",2;
		emotion 18,"�L�������Ă���q#Cooking";
		mes "[�L�������Ă���q]";
		mes "�j���E�`�`�@�j���j���j���A�`�`��";
		mes "�i�j���A�`�@�j���A�`�j";
		next;
		cutin "orleans_3",0;
		mes "[�V�������E�I�����A��]";
		mes "�c�c�c�c!!!";
		next;
		cutin "job_black_hucke03",1;
		mes "[�q���b�P]";
		mes "�c�c�܂����B";
		mes "�����������j���[������";
		mes "�����߂Ă��̂��H";
		next;
		cutin "orleans_3",0;
		emotion 19;
		mes "[�V�������E�I�����A��]";
		mes "�c�c�n�n�n�n!!�@�܂��������!!";
		mes "����Ȃɏ������ĉ������삳���";
		mes "�����߂�Ȃ�āc�c�@�n�n�c�c�B";
		next;
		cutin "orleans_7",0;
		mes "[�V�������E�I�����A��]";
		mes "���^�N�V�͒P�ɗ��������������悤��";
		mes "�v���������ł��B";
		mes "�S�z�Ȃ���Ȃ��ł��������B";
		mes "���o���񂪃��^�N�V��M����";
		mes "����Ȃ��ƒN�����^�N�V���c�c�B";
		next;
		cutin "job_black_hucke01",1;
		emotion 1,"�q���b�P#Cooking";
		mes "[�q���b�P]";
		mes "�{�����H";
		mes "���i�Ƃ�����ƈႤ";
		mes "�I�����A���ȋC�����邼�H";
		next;
		cutin "job_black_hucke02",1;
		mes "[�q���b�P]";
		mes "�܂������B";
		mes "����A�j���[�����𗊂ނ��B";
		next;
		cutin "nyuang_3",2;
		emotion 18,"�L�������Ă���q#Cooking";
		mes "[�L�������Ă���q]";
		mes "�j���n�n�n�`�@�j���n�n�`";
		mes "�i�j���A�`�@�j���A�A�`�j";
		next;
		cutin "nyuang_3",255;
		emotion 2,"�q���b�P#Cooking";
		hideonnpc "�q���b�P#Cooking";
		mes "- �s�J�b -";
		next;
		emotion 9;
		emotion 9,"�L�������Ă���q#Cooking";
		mes "[�V�������E�I�����A��]";
		mes "�c�c�c�c";
		next;
		cutin "orleans_6",0;
		mes "[�V�������E�I�����A��]";
		mes "�c�c����ƍs���܂������c�c�B";
		mes "��Ȃ��Ƃ��낾�����c�c";
		mes "�{���Ɂc�c�B";
		close2;
		cutin "orleans_6",255;
		end;
	case 10:
		cutin "orleans_5",0;
		mes "[�V�������E�I�����A��]";
		mes "�����É������Ȃ��Ȃ���";
		mes "���Ȃ�̎��Ԃ��o���Ă���̂ɁA";
		mes "�N�����R��m��Ȃ��c�c";
		next;
		cutin "orleans_3",0;
		mes "[�V�������E�I�����A��]";
		mes "�܂����A";
		mes "��X���[���~�b�h�K�b�c������";
		mes "�S�������̂Ă��̂ŁH";
		mes "�����łȂ����";
		mes "�����ƃ��^�N�V�ɘA�����Ȃ��Ȃ��";
		mes "���������c�c�B";
		next;
		cutin "orleans_6",0;
		mes "[�V�������E�I�����A��]";
		mes "����c�c";
		mes "����Ȃ킯�Ȃ��ł��傤�c�c�B";
		mes "�����É��͍�����厖�ɂ��A";
		mes "�����Ă����Ȃ̂ł��I";
		close2;
		cutin "orleans_6",255;
		end;
	case 11:
		cutin "orleans_5",0;
		emotion 9;
		mes "[�V�������E�I�����A��]";
		mes "���`���A���ł����H";
		mes "�ʓ|�������c�c�B";
		mes "���A���^�N�V�͈�l�ŐÂ���";
		mes "���Ԃ��߂��������̂ł��I";
		mes "���^�N�V�̋x�����ז�����Ȃ�";
		mes "����Ȃ�̗p�����Ȃ��Ƃ����܂����I";
		next;
		mes "[�V�������E�I�����A��]";
		mes "���ŁA���ł����H";
		next;
		switch(select("���̗����{�����Ă݂����ł�","�N�̂��߂ɗ���������ł����H","���ł��Ȃ��ł�")) {
			case 1:
				cutin "orleans_7",0;
				mes "[�V�������E�I�����A��]";
				mes "�ق��c�c���̗����{�ł����āH";
				mes "����͍������Ă���{��";
				mes "�����Ԃ񊵂ꂽ���Ď��ł��ˁB";
				mes "����A���^�N�V�������Ă�{��݂��āA";
				mes "�݂��Ă����{�͕Ԃ��ĖႢ�܂��B";
				next;
				mes "[�V�������E�I�����A��]";
				mes "�݂��Ă������{�̓��x��5�܂łł��B";
				mes "�������x���̖{������܂����A";
				mes "�����݂͑�����̂ł͂Ȃ��̂ł��B";
				mes "�ǂ̃��x���̗����{��݂��܂��傤���H";
				while(1) {
					next;
					input .@num;
					if(.@num == 0) {
						cutin "orleans_5",0;
						mes "[�V�������E�I�����A��]";
						mes "���x��0�̗����{�Ȃ烏�^�N�V�B��";
						mes "�S�̒��ɂ���͂��ł��B";
						mes "�������炷��Ȃ��Ď��ł���B";
						close2;
						cutin "orleans_5",255;
						end;
					}
					if(.@num < 0 || .@num > 5) {
						cutin "orleans_5",0;
						mes "[�V�������E�I�����A��]";
						mes "�����ł������炷��l�́A";
						mes "�܂Ƃ��Ȑl�ł͂Ȃ���";
						mes "�v���Ă�̂ł����c�c�B";
						close2;
						cutin "orleans_5",255;
						end;
					}
					if(.@rent == 0) {
						set .@rent,7471+.@num;
						mes "[�V�������E�I�����A��]";
						mes .@num;
						mes "�ł́A�ԋp����{�́H";
						continue;
					}
					break;
				}
				set .@back,7471+.@num;
				if(.@back == .@rent) {
					cutin "orleans_4",0;
					mes "[�V�������E�I�����A��]";
					mes "��₩���̂͂�߂Ă��������B";
					mes "�����{����Ȃ��ł����H";
					mes "�Ȃ��ւ��悤�Ƃ���̂ł����H";
					break;
				}
				if(countitem(.@back) < 1) {
					mes "[�V�������E�I�����A��]";
					mes "�c�c�ԋp����{������̂ł����H";
					mes "�{��ǂ݂����C�����͕�����܂����A";
					mes "�{���Ȃ��̂ɂ���ƉR�����悤��";
					mes "��q�̓��^�N�V�̋L���ɂ͂���܂���B";
					break;
				}
				cutin "orleans_2",0;
				mes "[�V�������E�I�����A��]";
				mes getitemname(.@back)+ "�͂ƂĂ��ǂ��{�ł��B";
				switch(.@back) {
					case 7472:
						mes "�ȒP�Ɏ�ɓ������ޗ���";
						mes "�f�ނɂ����ȒP�ȃ��V�s�ł�����B";
						break;
					case 7473:
						mes "�ƒ뎮�������y��������悤��";
						mes "���V�s�̐������ƂĂ����ꂢ�ł��B";
						break;
					case 7474:
						mes "����Ȃ爤�����v�ɂȂ��c�c�B";
						mes "�j�Ɍ����Ă̘b�ł����ǁc�c�B";
						break;
					case 7475:
						mes "�H�ׂ����Ȃ��H�ނł�";
						mes "�H�ׂ����Ȃ�悤�ɂ��Ă����";
						mes "���h�Ȗ{�ł��B";
						break;
					case 7476:
						mes "��������ϋ�肾�������鏭�N��";
						mes "�L���ȃV�F�t�̍������荞��";
						mes "���h�ȗ����l�ɂȂ����قǂł��B";
						break;
				}
				next;
				cutin "orleans_1",0;
				mes "[�V�������E�I�����A��]";
				mes "�킩��܂����B";
				mes "���̖{��݂��Ă����܂��傤�B";
				mes "�����A����������܂��B";
				next;
				cutin "orleans_7",0;
				switch(.@rent) {
					case 7472:
						mes "[�V�������E�I�����A��]";
						mes "���^�N�V������������";
						mes "�ƂĂ��n���������̂ł��B";
						mes "���₨�����������ł͂Ȃ��A";
						mes "�������؂�H�ׂĐ����Ă��܂����B";
						next;
						mes "[�V�������E�I�����A��]";
						mes "�L�\�ȏ��l������������A";
						mes "���͂��납�������̂��������";
						mes "�H�ׂ鎖���ł����A";
						mes "�����������󂢂Ă����̂ł��B";
						next;
						mes "[�V�������E�I�����A��]";
						mes "���̎��ɕ���͂������Ⴂ�܂����B";
						mes "�u�c�c�J�{�`����H�ׂȂ����c�c�v";
						mes "��������͂����������Ă��鎞�͂���";
						mes "�J�{�`����H�ׂ܂����B";
						mes "�������A���^�N�V�̓J�{�`����";
						mes "�匙���������̂ł��B";
						next;
						mes "[�V�������E�I�����A��]";
						mes "���l���Ă݂�ƁA���̍�";
						mes "��ԉh�{�f�������A�����ǂ���";
						mes "������t�H�ׂ�ꂽ�̂�";
						mes "�J�{�`�������������Ǝv���܂��B";
						next;
						mes "[�V�������E�I�����A��]";
						mes "�����͂��̎����v���o���Ȃ���A";
						mes "�J�{�`����H�ׂĂ݂����̂ł��B";
						mes "�����{���x��1��݂������";
						mes "�J�{�`��10�𒸂��܂����H";
						if(countitem(535) < 10) {
							close2;
							cutin "orleans_7",255;
							end;
						}
						next;
						if(select("�J�{�`���Ɨ����{��n��","��߂�")==2) {
							cutin "orleans_7",255;
							mes "[�V�������E�I�����A��]";
							mes "�J�{�`���c�c";
							mes "�ǉ��̃J�{�`���c�c�B";
							close;
						}
						cutin "orleans_6",0;
						mes "[�V�������E�I�����A��]";
						mes "�����A�܂������J�{�`���I";
						mes "���S���Ŕ����Ă����΂���";
						mes "�J�{�`���c�c�B";
						mes "�f�G�ȋ��F�Ŗ{���ɂ����������ł��B";
						next;
						delitem 535,10;
						break;
					case 7473:
						mes "[�V�������E�I�����A��]";
						mes "����ȓ��ɂ͍g�����~�����ł��ˁB";
						mes "����ς�g���ɂ͂悭�Ă��ꂽ";
						mes "�Â��N�b�L�[�ł��傤�c�c�B";
						next;
						mes "[�V�������E�I�����A��]";
						mes "�������g���̊Ô��ȍ��肪";
						mes "�@��������Ǝh�����āA";
						mes "������ޏu�ԊÂ��ăT�N�b�Ƃ���";
						mes "�N�b�L�[�̖�����������Ɓc�c�B";
						next;
						mes "[�V�������E�I�����A��]";
						mes "�ǂ����A�����̓N�b�L�[��";
						mes "�H�ׂȂ��Ă͂����Ȃ��悤�ł��B";
						mes "�����{���x��2��݂������";
						mes "�悭�Ă����N�b�L�[��5�����܂����H";
						if(countitem(538) < 5) {
							close2;
							cutin "orleans_7",255;
							end;
						}
						next;
						if(select("�N�b�L�[�Ɨ����{��n��","��߂�")==2) {
							cutin "orleans_7",255;
							mes "[�V�������E�I�����A��]";
							mes "���^�N�V�ɃN�b�L�[���c�c�B";
							close;
						}
						cutin "orleans_6",0;
						mes "[�V�������E�I�����A��]";
						mes "�����A������������Ȃ��ł����B";
						mes "1�b�ł��������̃N�b�L�[��";
						mes "�H�ׂĂ݂����ł��B";
						mes "�����g�������Ȃ��Ɓc�c�B";
						next;
						delitem 538,5;
						break;
					case 7474:
						mes "[�V�������E�I�����A��]";
						mes "���̉����A�}�c�Ƃ����X�ɂ͔���";
						mes "���Ă̂��тɋ����悹�ĐH�ׂ�";
						mes "�����i�Ƃ�������������̂ł��B";
						mes "���ɃG�r���ڂ��ĐH�ׂ邨���i��";
						mes "���������ƕ������̂ł����c�c�B";
						next;
						mes "[�V�������E�I�����A��]";
						mes "��������t�ɂȂ�܂ł����i���H�ׂ���";
						mes "�Ȃ�܂����B�����z�̓s�����ǂ�����";
						mes "�H�ׂ����Ǝv���������Ȃ��������ǁA";
						mes "����͂Ȃ��������ł��傤�c�c�B";
						next;
						mes "[�V�������E�I�����A��]";
						mes "�����c�c";
						mes "�����͂����i��H�ׂ����Ȃ�܂����B";
						mes "�����{���x��3��݂������";
						mes "�����i��5�����܂����H";
						if(countitem(551) < 5) {
							close2;
							cutin "orleans_7",255;
							end;
						}
						next;
						if(select("�����i�Ɨ����{��n��","��߂�")==2) {
							cutin "orleans_7",255;
							mes "[�V�������E�I�����A��]";
							mes "�����i�̐��ƂɁc�c";
							close;
						}
						cutin "orleans_6",0;
						mes "[�V�������E�I�����A��]";
						mes "�����A���̐V�N�ȋ��̂����i�I";
						mes "�����āA���Ƃ���C�Ɉ�����";
						mes "���o�������h�Ȗ͗l�c�c�B";
						mes "�f�G�ȗ�������Ȃ��ł��傤���B";
						next;
						delitem 551,5;
						break;
					case 7475:
						mes "[�V�������E�I�����A��]";
						mes "���̉����R�������Ƃ����X�ɂ�";
						mes "�����Ɩ�؂������Ղ����č����";
						mes "����q�Ƃ�������������A";
						mes "������H�ׂĂ���������t��";
						mes "�Ȃ邻���ł��B";
						next;
						mes "[�V�������E�I�����A��]";
						mes "�܂��A�Ă��A�����A��ł�A���z����";
						mes "�����Ȃǂ��܂��܂ȕ��@�ŗ�����";
						mes "�ł���Ƃ����̂͑f���炵���ł��ˁB";
						next;
						mes "[�V�������E�I�����A��]";
						mes "�����͑傫���Ĕ���������q��H�ׂ�";
						mes "�݂����ł��B�����{���x��4��݂�";
						mes "����ɏ���q5�𒸂��܂����H";
						if(countitem(553) < 5) {
							close2;
							cutin "orleans_7",255;
							end;
						}
						next;
						if(select("����q�Ɨ����{��n��","��߂�")==2) {
							cutin "orleans_7",255;
							mes "[�V�������E�I�����A��]";
							mes "����q���΂��Ă閲���c�c�B";
							close;
						}
						cutin "orleans_6",0;
						mes "[�V�������E�I�����A��]";
						mes "�����A���ꂪ����q�ł����I";
						mes "������񂾂���̒��ɓ��`��";
						mes "�ӂ���ƍL�����đf�G�ȐH����";
						mes "�������������ł��傤�B";
						next;
						delitem 553,5;
						break;
					case 7476:
						mes "[�V�������E�I�����A��]";
						mes "���ł��B��肪�K�v�Ȃ̂ł��B";
						mes "���ʁA���S�Ɉ������؂Ɖʕ�������";
						mes "�H�ޗ����Ǝv���Ă܂����A�{����";
						mes "���N�H����邽�߂ɂ͈炿�n�߂�";
						mes "�V�N�Ȏ�肪�K�v�Ȃ̂ł��B";
						next;
						mes "[�V�������E�I�����A��]";
						mes "���ɂ͂��ꂩ�����̉\����";
						mes "�����͂����ӂ��̂ł��B";
						mes "���^�N�V�͂��ꂩ����𗘗p����";
						mes "���N�������J�����܂��B";
						mes "�����A�����ɂȂ邾����";
						mes "�����ł͂Ȃ����N���l���闿�����I";
						next;
						mes "[�V�������E�I�����A��]";
						mes "�����������Ŏ�肪�K�v�ƂȂ�܂����B";
						mes "�����{���x��5��݂������";
						mes "���10�𒸂��܂����H";
						if(countitem(711) < 10) {
							close2;
							cutin "orleans_7",255;
							end;
						}
						next;
						if(select("���Ɨ����{��n��","��߂�")==2) {
							cutin "orleans_7",255;
							mes "[�V�������E�I�����A��]";
							//mes "�f�r�A�X�̂悤�Ȃ��̂�"; //�{�I�d�l
							mes "�f�r���`�̂悤�Ȃ��̂�";
							mes "�炽���邽�߂��Ⴀ��܂���B";
							mes "������Ȃ��ł��������B";
							close;
						}
						cutin "orleans_6",0;
						mes "[�V�������E�I�����A��]";
						mes "�����A���̊Ԃ�";
						mes "����ȗǂ����̂���ɓ��ꂽ�̂ł����H";
						mes "���̈ʐV�N�Ȃ�A����������";
						mes "���̂܂ܐH�ׂĂ������͂��ł��B";
						mes "5�͂��̂܂ܐH�ׂāA";
						mes "5�͗����Ɏg���Ă݂܂��傤�B";
						next;
						delitem 711,10;
						break;
				}
				delitem .@back,1;
				getitem .@rent,1;
				mes "[�V�������E�I�����A��]";
				mes "�ł́A�����܂��B�����{��";
				mes "���킭����ɂ�����A�j������A";
				mes "�������肵�Ă͂��߂ł��B";
				mes "�ł́A�撣���Ă��������B";
				break;
			case 2:
				cutin "orleans_3",0;
				mes "[�V�������E�I�����A��]";
				mes "��A�͂��H�@���ł��ƁH";
				mes "�N�̂��߂ł����ƌ����܂����H";
				next;
				mes "[�V�������E�I�����A��]";
				mes "���납�Ȑl�ł��ˁB";
				mes "����͓��R�A�����̂��߂ɁA";
				mes "�����ĊF�̂��߂ɂł��B";
				next;
				cutin "orleans_6",0;
				mes "[�V�������E�I�����A��]";
				mes "�c�c�ł�����c�c";
				next;
				mes "[�V�������E�I�����A��]";
				mes "���ׂȎ��͂��܂�C�ɂ��Ȃ��̂ł��B";
				mes "�l�����Ă���Ȃ��̂ł��傤�B";
				mes "�����̂��߂ɂƂ����l�̂��߂ɂƂ�";
				mes "����Ȃɏd�v����Ȃ��̂ł�����B";
				break;
			case 3:
				mes "[�V�������E�I�����A��]";
				mes "������Ȃ��l�ł��ˁB";
				mes "���Ȃ��ɂ͗����̂悤��";
				mes "���t�����K�v�Ȃ悤�ł��ˁB";
				break;
		}
		close2;
		cutin "orleans_5",255;
		end;
	}
	//1�`6�̑���
	set .@size,getarraysize(.@need);
	for(set .@i,0; .@i<.@size; set .@i,.@i+1) {
		if(countitem(.@need[.@i]) < .@amount[.@i]) {
			if(rand(3)) {
				cutin "orleans_6",0;
				mes "[�V�������E�I�����A��]";
				mes "�u" +getitemname(.@dishid)+ "�v��";
				mes "�ޗ��������ė��Ȃ���!!";
			}
			else {
				cutin "orleans_6",0;
				mes "[�V�������E�I�����A��]";
				switch(QUE_COOKING) {
				case 1: //�o�b�^���u�ߕ�
					mes "�����V��ł��邾���̃o�b�^���P���c�c";
					mes "�c���ɑ����l������̂ł��B";
					break;
				case 2: //�u�h�E�ʏ`����n�[�u�e�B�[
					mes "�����|�|������|������o��A";
					mes "�ƂĂ��������u�h�E���ˁB";
					break;
				case 3: //�����K�j
					mes "�����΂����鏬���ȃo�h����";
					mes "���c�ɂ�����|���A";
					mes "���̏����ȃj�b�p���c�c�B";
					break;
				case 4: //������̗��̖n�`�X�[�v
					mes "���̂˂΂˂΃c���c������";
					mes "�C��������������̗���";
					mes "�N���ɐH�ׂ�����Ɓc�c�B";
					break;
				case 5: //�n�`���u�h�E�W���[�X
					mes "�N�}�̑�D���ł���n�`�����c�c";
					mes "�N�}��|�������ŁI";
					break;
				case 6: //�T���̂������u��
					mes "�Â��ɕ�炵�Ă��郈�[���[��";
					mes "��납��Â��ɋߕt���āc�c";
					mes "��C�ɂ����ۂ��c�c�B";
					break;
				}
			}
			close2;
			cutin "orleans_6",255;
			end;
		}
	}
	emotion 6;
	cutin "orleans_4",0;
	mes "[�V�������E�I�����A��]";
	mes "�x�����܂���!!";
	mes "����Ȃɒx���ƁA";
	mes "�ޗ��̑N�x�������Ȃ��Ă��܂��܂�!!";
	mes "��������鎞�͏��";
	mes "�ޗ��̑N�x��Y��Ȃ��悤��!!";
	next;
	mes "[�V�������E�I�����A��]";
	mes "�Ƃɂ����A";
	mes "�������������ė����̂ł�����A";
	mes "�����������Ă����܂��B";
	mes "�悭���Ċo���Ă��������B";
	next;
	cutin "orleans_6",0;
	switch(QUE_COOKING) {
	case 1: //�o�b�^���u�ߕ�
		mes "[�V�������E�I�����A��]";
		mes "�o�b�^�̑����̂���܂ܐ􂢗����A";
		mes "�Â��t���C�p����";
		mes "�H�p���𔼕��ʓ����B";
		next;
		mes "[�V�������E�I�����A��]";
		mes "�����āA�����ɏ������Ă�����";
		mes "�o�b�^�̑������Ă悭�u�߂�B";
		mes "���Ԃ�����΁A�o�b�^�̎p�����";
		mes "����̂������ł��傤�B";
		break;
	case 2: //�u�h�E�ʏ`����n�[�u�e�B�[
		mes "[�V�������E�I�����A��]";
		mes "�V�N�ȃu�h�E�̔���ނ���";
		mes "����O���B";
		mes "�����āA�ԃ|�[�V������M����";
		mes "����ē����ŉ��߂�B";
		next;
		mes "[�V�������E�I�����A��]";
		mes "�����āA���ޒ��O��";
		mes "�u�h�E�ʏ`�̒���";
		mes "���������ł�����蒍���Ί����I";
		break;
	case 3: //�����K�j
		mes "[�V�������E�I�����A��]";
		mes "���|�[�V�����ɗ΃n�[�u�Ƃ��Ƀj�b�p��";
		mes "����Ē����Ԏς�B";
		mes "�n�[�u�Ƃ��ɂ̊����𓯂��ɁA���ς���";
		mes "�Ȃ�Ȃ��悤��������ς�̂��厖�I";
		mes "�܂��A�H�ׂ鎞�͔�ɋC�����鎖�I";
		break;
	case 4: //������̗��̖n�`�X�[�v
		mes "[�V�������E�I�����A��]";
		mes "�������ׂ����Ђ��ĕ������B";
		mes "�n�`�͓K�����x�Ŏύ��݁A";
		mes "�Ђ��Ă��������������āA";
		mes "�ł��Ȃ��悤�ɂ����񂷁B";
		next;
		mes "[�V�������E�I�����A��]";
		mes "�t�̂����ꗎ���Ȃ���";
		mes "�g���g���ɂȂ�����A";
		mes "������̗������A";
		mes "��΂ł��������ύ��ށB";
		break;
	case 5: //�n�`���u�h�E�W���[�X
		mes "[�V�������E�I�����A��]";
		mes "�V�N�ȃu�h�E�̔���ނ��A";
		mes "����O���ăn�`����������B";
		mes "�����āA�Ƃ��ƂȂ�܂�";
		mes "�����Ԃ��A";
		mes "����ɐԃ|�[�V������������B";
		next;
		mes "[�V�������E�I�����A��]";
		mes "�_�炩���Ȃ�n�߂���A";
		mes "���S�ɗn����܂ł������ƁA";
		mes "�����Ă��񂾂񑁂������񂷁B";
		break;
	case 6: //�T���̂������u��
		mes "[�V�������E�I�����A��]";
		mes "�����ۂ͖т�S�Ĕ�������A";
		mes "�₽�����Ő􂢗����Ă����B";
		mes "�����āA�t���C�p�����Ԃ��Ȃ��";
		mes "���΂ɂ��ĐH�p�������߂Ă����B";
		mes "�������I�������A�Z���Ԃ�";
		mes "�u�ߏo���̂���ԏd�v�ȃ|�C���g�I";
		break;
	}
	next;
	for(set .@i,0; .@i<.@size; set .@i,.@i+1) {
		delitem .@need[.@i],.@amount[.@i];
	}
	set QUE_COOKING,7;
	getitem .@dishid,1;
	mes "[�V�������E�I�����A��]";
	mes "�c�c�c�c";
	next;
	cutin "orleans_7",0;
	mes "[�V�������E�I�����A��]";
	mes "�����̎��Ƃ͂����܂ŁI";
	mes "�ꐶ��������ĂȂ����I";
	close2;
	cutin "orleans_7",255;
	end;
}

prt_castle,45,35,4	script	�}�h�����E�V���[	886,{
	switch(QUE_COOKING) {
	case 0:
		mes "[�}�h�����E�V���[]";
		mes "����ɂ��́I";
		mes "���̓}�h�����E�V���[�A";
		mes "���K���̗����t�ł��B";
		mes "���̓V�������V�F�t�̈�Ԓ�q�Ƃ���";
		mes "�F��ȗ����������Ē����Ă��܂��B";
		next;
		switch(select("�����t���ĉ��ł����H","�ǂ�ȗ���������ł����H","�����������w��ł݂����ł�")) {
			case 1:
				mes "[�}�h�����E�V���[]";
				mes "�n�n�n�A����Ȃӂ��ɕ�������";
				mes "�������ςȋC�����ɂȂ�܂��ˁB";
				mes "���͂܂������t�ł͂Ȃ��āA";
				mes "�������w��ł��錩�K���ł��B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "�N�ł������Ɋ֐S�������āA";
				mes "�M�S�ɕ׋����āA";
				mes "���ۂɍ���Ă���΁A";
				mes "�������l���痧�h�ȗ����t����";
				mes "�_�߂Ă��炦���������Ǝv���܂��B";
				mes "���͂����M���Ă܂��B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "�����Ƃ͉΂Ƃ̐킢!!";
				mes "�΂𐧈�����l���������邻���ł��I";
				next;
				mes "[�}�h�����E�V���[]";
				mes "����������ƍ��΂����Ȃ�悤��!!";
				mes "����������ƃJ�����Ƃ���悤��!!";
				mes "���͂��ꂩ��΂��x�z���܂�!!";
				close;
			case 2:
				mes "[�}�h�����E�V���[]";
				mes "���͊�b�I�ȗ�������";
				mes "��邱�Ƃ��ł��܂���B";
				mes "�ł��A�V�������V�F�t�͂���";
				mes "����������Ă܂��B";
				mes "�N�����ł��鎖�����܂��ł���l��";
				mes "��������Ɓc�c�B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "���������������́A";
				mes "�Ɠ��̗�������肽����ł��B";
				mes "�H�ׂ�l�������ł��Ȃ�����";
				mes "�K���Ɉ͂܂��悤�ȗ�����";
				mes "����Ă݂�����ł��B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "���������Ӗ��ł́A";
				mes "�V�������V�F�t�̃f�U�[�g�͍ō��ł��B";
				mes "������x�H�ׂ�@���������ł����A";
				mes "�ڂ̑O�ɋ���ȃn�[�g���H������";
				mes "�����Ɣ�Ԍ��i���L��������ł��B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "�Ƃ��낪�A�Ȃ����V�������V�F�t��";
				mes "�f�U�[�g�̍����������Ă��ꂸ�A";
				mes "�����ςȗ����΂��苳�����Ă܂��B";
				mes "���̓V�F�t�̓��ӂł���";
				mes "����`���R���[�g�̍�����";
				mes "�����Ē��������̂Ɂc�c";
				next;
				mes "[�}�h�����E�V���[]";
				mes "�܂��A�܂��������n������ł��傤�B";
				mes "�ł��A�����V�F�t���z���闧�h��";
				mes "�����l�ɂȂ肽���ł��B";
				mes "���̓��܂ňꐶ��������΂�܂��B";
				close;
			case 3:
				mes "[�}�h�����E�V���[]";
				mes "����́c�c";
				mes "�������������鎖�͂ł��܂���̂ŁA";
				mes "�V�������V�F�t�ɗ���ł݂ẮH";
				mes "���������z�ȕ��ł����A";
				mes "�����̘r�͊m���ł���B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "�����āA�����Ƃ����̂͒�����";
				mes "�����č�邱�Ƃŏ�B����̂ł��B";
				mes "�����ޗ��Ɠ�����邾����";
				mes "�ȒP�ɍ���̂ł͂���܂���B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "�V�������V�F�t���痿�����w��ŁA";
				mes "�悩�������l�ŗ����̗��K��";
				mes "���Ă݂Ă��������B";
				mes "�����𑱂��Ă���΁A";
				mes "�����͊���Ă���������";
				mes "�C�����Ǝv���܂��B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "�������A�V�������V�F�t��";
				mes "�����Ă����Ƃ͂�����܂��񂪁c�c�B";
				mes "�������w�т����C������";
				mes "���܂��`�����Α��v���Ǝv���܂��B";
				mes "�����t�̖X�q�ł�����Ă݂Ă�";
				mes "�ǂ��ł����H";
				next;
				mes "[�}�h�����E�V���[]";
				mes "�Ō�Ɉꌾ�B";
				mes "�C��t���Ă��������B";
				mes "�ȑO�A���������Ƃɑς����Ȃ���";
				mes "�����������l�����܂�����c�c�B";
				close;
		}
	default: //1�`6�̎�
		mes "[�}�h�����E�V���[]";
		mes "����ɂ��́I";
		mes "�������������̂ł����H";
		mes "�m�肽����������΂ǂ����I";
		next;
		switch(select("�o�b�^���u�ߕ��̍ޗ��́H","�u�h�E�ʏ`����n�[�u�e�B�[�̍ޗ��́H","�n�`���u�h�E�W���[�X�̍ޗ��́H","������̗��̖n�`�X�[�v�̍ޗ��́H","�����K�j�̍ޗ��́H","�T���̂������u�߂̍ޗ��́H")) {
			case 1: //�o�b�^���u�ߕ�
				set .@dishid,12041;
				setarray .@need,940,7031,7457;
				setarray .@amount,5,1,1;
				break;
			case 2: //�u�h�E�ʏ`����n�[�u�e�B�[
				set .@dishid,12046;
				setarray .@need,514,501;
				setarray .@amount,3,2;
				break;
			case 3: //�n�`���u�h�E�W���[�X
				set .@dishid,12061;
				setarray .@need,518,514,501;
				setarray .@amount,1,2,1;
				break;
			case 4: //������̗��̖n�`�X�[�v
				set .@dishid,12056;
				setarray .@need,577,908,1024;
				setarray .@amount,1,10,1;
				break;
			case 5: //�����K�j
				set .@dishid,12051;
				setarray .@need,960,511,503;
				setarray .@amount,10,10,1;
				break;
			case 6: //�T���̂������u��
				set .@dishid,12066;
				setarray .@need,942,7031,7457;
				setarray .@amount,5,1,1;
				break;
		}
		mes "[�}�h�����E�V���[]";
		mes "�u" +getitemname(.@dishid)+ "�v";
		mes "�̍ޗ��ł����H";
		for(set .@i,0; .@i<getarraysize(.@need)-1; set .@i,.@i+1) {
			mes "^0000FF�u" +getitemname(.@need[.@i])+"�v^000000" +.@amount[.@i]+ "�A";
		}
		mes "^0000FF�u" +getitemname(.@need[.@i])+"�v^000000" +.@amount[.@i]+ "�ł��B";
		next;
		mes "[�}�h�����E�V���[]";
		mes "��{�̍ޗ���";
		mes "�悭�o���Ă����Ă��������B";
		mes "�����@�̓V�������V�F�t����";
		mes "�����΂����Ǝv���܂��B";
		close;
	case 7:
		mes "[�}�h�����E�V���[]";
		mes "�n�n�B";
		mes "���������������݂����ł��ˁB";
		mes "�V�������V�F�t���K����";
		mes "�����Ă��ꂽ�悤�Ɍ����Ă��A";
		mes "�������Ă����̂�";
		mes "�l�̔\�͂ɂ����̂ł��B";
		next;
		mes "[�}�h�����E�V���[]";
		mes "�w�͂��Ă����������Ă���΁A";
		mes "�����͗��h�ȗ���������悤��";
		mes "�Ȃ�Ǝv���܂��B";
		next;
		mes "[�}�h�����E�V���[]";
		mes "���A�������I";
		mes "���������Ă��闿���{��";
		mes "����݂��Ă����܂�����A";
		mes "����ŗ���������Ă݂Ă��������B";
		next;
		mes "[�}�h�����E�V���[]";
		mes "����������g���O�ɁA";
		mes "�ǂ̗�������邩�I��ŁA";
		mes "�ޗ�������Ȃ��悤��";
		mes "�������Ă����̂��d�v�ł��B";
		mes "�������A�����{�����Ȃ���";
		mes "��������͓̂�����O�ł��ˁB";
		next;
		mes "[�}�h�����E�V���[]";
		mes "�������ł�����A���������";
		mes "�g���ė������Ă��������B";
		mes "�ŏ��͗������܂Ƃ��ɂł��Ȃ�����";
		mes "�m��܂��񂪁A�����č���Ă����";
		mes "�ǂ�����������悤�ɂȂ�܂��B";
		next;
		set QUE_COOKING,8;
		getitem 7472,1;
		mes "[�}�h�����E�V���[]";
		mes "��Ԋ�b�I�Ȗ{�A�����{���x��1�ł��B";
		mes "���̖{�̗��������ɂȂ�����A";
		mes "�܂���ɗ��Ă��������B";
		mes "���A���Ɓc�c�B";
		next;
		getitem 12125,10;
		mes "[�}�h�����E�V���[]";
		mes "����ŗ�������K���Ă݂Ă��������B";
		mes "�܂��K�v�ɂȂ�����A";
		mes "���ł����Ă��������B";
		close;
	case 8:
		mes "[�}�h�����E�V���[]";
		mes "����ɂ��́B";
		mes "�����͂����ς�����Ă݂܂����H";
		mes "�������ԃR�c�R�c��";
		mes "�w�͂���̂���ԑ厖�ł��B";
		next;
		switch(select("�������K�v�ł�","���̗��������Ă���܂����H","���̗������ǂ��v���܂����H")) {
			case 1:
				mes "[�}�h�����E�V���[]";
				mes "�ǂ̒������K�v�ł��傤���H";
				next;
				switch(select("��O�p�������-500z","�ƒ�p�������-1000z","��߂�")) {
				case 1:
					mes "[�}�h�����E�V���[]";
					mes "�����K�v�ł����H";
					mes "�������߂����ꍇ��";
					mes "�u0�v����͂��Ă��������B";
					while(1) {
						next;
						input .@num;
						if(.@num == 0)
							break;
						if(.@num > 100 || .@num < 0) {
							mes "[�}�h�����E�V���[]";
							mes "100�ȉ��ł��肢���܂��B";
							continue;
						}
						if(Zeny < .@num*500) {
							mes "[�}�h�����E�V���[]";
							mes "����������Ȃ��ł��ˁB";
							mes "���������m���߂Ă��������B";
							close;
						}
						if(checkweight(12125,.@num) == 0) {
							mes "[�}�h�����E�V���[]";
							mes "�S���͎��Ă������Ȃ��ł��ˁB";
							mes "�ו����m���߂Ă��������B";
							close;
						}
						set Zeny,Zeny-.@num*500;
						getitem 12125,.@num;
						mes "[�}�h�����E�V���[]";
						mes "������������������Ă��������I";
						close;
					}
				case 2:
					mes "[�}�h�����E�V���[]";
					mes "�܂��ƒ�p��������";
					mes "�g���i�K�ł͂Ȃ������ł��ˁB";
					mes "��O�p�������Ŋ�{�I�ȗ�����";
					mes "�����ƍ���Ă݂Ă��������B";
					close;
				case 3:
					break;
				}
				mes "[�}�h�����E�V���[]";
				mes "�ł́A�܂���Ő��������Ă��������B";
				close;
			case 2:
				if(countitem(12041) < 1 || countitem(12046) < 1 || countitem(12051) < 1 ||
					countitem(12056) < 1 || countitem(12061) < 1 || countitem(12066) < 1) {
					mes "[�}�h�����E�V���[]";
					mes "���[��c�c";
					mes "���������]������ɂ�";
					mes "��{�I��6�̗�����S������āA";
					mes "�܂Ƃ߂Ď��Ɍ����Ă��ꂽ����";
					mes "�悳�����ł��ˁB";
					next;
					mes "[�}�h�����E�V���[]";
					mes "�������A���������I��";
					mes "����̂��ǂ��ł����A";
					mes "���̈����邽�߂ɂ�";
					mes "��{�I�Ȏ����ł��ĂȂ���";
					mes "�����Ȃ��Ǝv���܂��B";
					next;
					mes "[�}�h�����E�V���[]";
					mes "�����݂����{�����������";
					mes "�ǂ�ł��������B";
					mes "�����āA�{�ɏ����Ă��闿����";
					mes "�S������悤�ɂȂ�����A";
					mes "����������ɗ��Ă��������B";
					close;
				}
				mes "[�}�h�����E�V���[]";
				mes "���`";
				mes "����S������Ă݂���ł��ˁB";
				mes "�������g�̘r���オ���Ă���̂�";
				mes "�C�Â��Ă���Ǝv���܂��B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "�������H���ĕ]����������";
				mes "�v���܂����c�c";
				mes "��������肢������܂��B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "�t�F�C�������痿�����w�ڂ���";
				mes "�v�����e���ɗ����F�B�����܂��B";
				mes "���͗����̎��Ƃɔ���";
				mes "�A��������Ă����ł����c�c�B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "���̗F�B�Ɏ��H�����肢���Ă�";
				mes "�ǂ��ł����H";
				mes "�������������ł����܂�����A";
				mes "�t�F�C�����܂Ŏ����čs����";
				mes "���̗F�B�ɓn���Ă��������B";
				next;
				delitem 12041,1;
				delitem 12046,1;
				delitem 12051,1;
				delitem 12056,1;
				delitem 12061,1;
				delitem 12066,1;
				set QUE_COOKING,9;
				getitem 12111,1;
				mes "[�}�h�����E�V���[]";
				mes "-�S�\�S�\�S�\-";
				mes "-�K�T�S�\�K�T�S�\-";
				mes "-�S�\�S�\�S�\-";
				next;
				mes "[�}�h�����E�V���[]";
				mes "������ɂȂ�܂��B";
				mes "���������݂܂������ǁA";
				mes "�J�����肵�Ȃ��ł��������B";
				mes "�������A��������";
				mes "�Y�ꂿ������肵�Ȃ��ł���������B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "�t�F�C�����̎��ꂩ�A";
				mes "���ď��̋߂��ɂ���͂��ł��B";
				mes "�����������Ƃ����b��";
				mes "�Y��Ȃ��ł��������B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "���O�́u�E���`�v�ł��B";
				mes "���͑����A���͂��ł�";
				mes "�H�ׂĂ���Ǝv���܂��B";
				close;
			case 3:
				getinventorylist;
				for(set .@i,0; .@i<@inventorylist_count; set .@i,.@i+1) {
					if(@inventorylist_id[.@i] >= 12041 && @inventorylist_id[.@i] <= 12100) {
						mes "[�}�h�����E�V���[]";
						mes "�������Ă����������c�c";
						mes "�ǂ��ł��ˁB";
						mes "�H�~��������܂��c�c";
						next;
						mes "[�}�h�����E�V���[]";
						mes "���A�����B���ł��Ȃ��ł��c�c";
						close;
					}
				}
				mes "[�}�h�����E�V���[]";
				mes "���`��c�c";
				mes "���ꂾ������";
				mes "�悭�킩��܂���ˁB";
				close;
		}
	case 9:
		if(countitem(12111)) {
			mes "[�}�h�����E�V���[]";
			mes "�t�F�C�����ɍs���Ă��������B";
			mes "�u�E���`�v�Ƃ����F�B��";
			mes "�H����݂�n���Ă��Ă��������B";
			close;
		}
		mes "[�}�h�����E�V���[]";
		mes "����ɂ��́B";
		mes "���݂܂��񂪁A�����҂��Ă��������B";
		mes "���A�������Ȃ�ł��B";
		next;
		mes "[�}�h�����E�V���[]";
		mes "�c�c���҂������܂����B";
		mes "�Ƃ���ŁA�H����݂͓͂��܂������H";
		mes "�E���`����A�������Ȃ��̂ł����A";
		mes "�܂��n���Ă��Ȃ��̂ł́H";
		mes "�Y��Ă��።��܂���B";
		next;
		if(select("����Ȗ�Ȃ�����Ȃ��ł���","�H����݂�Y��Ă��܂��܂���")==1) {
			mes "[�}�h�����E�V���[]";
			mes "�n�n�n�A�������Ă܂��B";
			mes "����Ȗ�Ȃ��ł���ˁB";
			mes "�t�F�C�����ɍs���r����";
			mes "�����������Ă��H�ׂĂ͂����܂���B";
			mes "�����ł��ˁH";
			next;
			mes "[�}�h�����E�V���[]";
			mes "����ł́A�s���Ă�����Ⴂ�B";
			close;
		}
		if(countitem(7472) < 1) {
			mes "[�}�h�����E�V���[]";
			mes "�n�n�n�A��k�������ł��B";
			mes "�܂��������Y���Ȃ�āc�c�B";
			mes "�����A��k�͂�߂�";
			mes "�����s���Ă��������B";
			close;
		}
		mes "[�}�h�����E�V���[]";
		mes "�c�c�����������H";
		next;
		mes "[�}�h�����E�V���[]";
		mes "�����Y��Ăǂ������ł����H";
		next;
		mes "[�}�h�����E�V���[]";
		mes "����́A�����ȑO�̖��ł��ˁB";
		next;
		delitem 7472,1;
		set QUE_COOKING,0;
		mes "[�}�h�����E�V���[]";
		mes "��x�A�����{��Ԃ��Ă��������B";
		mes "���΂炭���̎��ɂ���";
		mes "�l���Ă݂Ă��������B";
		next;
		mes "[�}�h�����E�V���[]";
		mes "�������������Ȃ������̂��킩������A";
		mes "�V�������V�F�t�̏���";
		mes "�܂��ŏ�����w��ł��������B";
		close;
	case 10:
		mes "[�}�h�����E�V���[]";
		mes "���A��Ȃ����B�E���`����";
		mes "���肪�Ƃ����ĘA�������܂����B";
		mes "���̈ʂ��Ȃ��̗�����";
		mes "�F�߂�ꂽ���Ď��ł��B";
		next;
		mes "[�}�h�����E�V���[]";
		mes "���ꂩ��͂����������";
		mes "�ǂ����������g���Ă݂�̂�";
		mes "�����ł��ˁB";
		mes "������񒲗������d�v�Ȃ̂�";
		mes "�{�l�̎��͂ł����ǂˁB";
		next;
		set QUE_COOKING,11;
		getitem 12126,10;
		mes "[�}�h�����E�V���[]";
		mes "���ꂩ��͂�����g���Ă݂Ă��������B";
		mes "��O�p���������g���₷���ł��B";
		mes "��莿�̍���������";
		mes "���̂ɂ��ǂ��ł��傤�B";
		next;
		mes "[�}�h�����E�V���[]";
		mes "�����������ƕK�v�ɂȂ�����A";
		mes "���ł����������Ă��������B";
		mes "�܂��A���̗���������Ă݂�����΁A";
		mes "�V�������V�F�t�ɗ����";
		mes "���̗����{��������Ă��������B";
		close;
	case 11:
		mes "[�}�h�����E�V���[]";
		mes "����ɂ��́I";
		mes "�����͂����������Ă݂܂������H";
		mes "�r�O���オ�����̂��C�ɂȂ�܂��ˁB";
		next;
		switch(select("�������K�v�ł�","�I�����A���l�͌��C�ł����H","���������΂��̎q�͒N�ł����H")) {
			case 1:
				mes "[�}�h�����E�V���[]";
				mes "�ǂ̒������K�v�ł��傤���H";
				next;
				switch(select("��O�p�������-500z","�ƒ�p�������-1000z","���̒������͂Ȃ���ł����H","��߂�")) {
				case 1:
					set .@gain,12125;
					set .@zeny,500;
					break;
				case 2:
					set .@gain,12126;
					set .@zeny,1000;
					break;
				case 3:
					mes "[�}�h�����E�V���[]";
					mes "���`��c�c";
					mes "�����g����������";
					mes "���̓�����Ȃ��ł��ˁB";
					mes "�n�����ꂽ�����l��";
					mes "�u�����������v�����g����";
					mes "��������ł����ǁc�c";
					next;
					mes "[�}�h�����E�V���[]";
					mes "���������΁A�V�������V�F�t��";
					mes "�����Ⴄ���������g���Ă��悤��";
					mes "�C�����܂��B�ł��A���S�҂ɂ�";
					mes "����ς菉�S�҂ɍ�����������";
					mes "�����ǂ��Ǝv���܂���H";
					next;
					mes "[�}�h�����E�V���[]";
					mes "���A���̐��̒��̂ǂ����ɂ�";
					mes "�Ƃ�ł��Ȃ����������邻���ł��B";
					mes "�ǂ�ȓ�������ł��A";
					mes "�ޗ������[���Ɏ����Ă�΁A";
					mes "�����ɗ������鎖��";
					mes "�ł��邻���ł��B";
					next;
					mes "[�}�h�����E�V���[]";
					mes "�͂́B";
					mes "���΂ɂ���Ȃ��̂͂Ȃ��ł��ˁB";
					mes "����ς蒲�������{�l�̗���";
					mes "���͂������Əd�v���Ǝv���܂��B";
					close;
				case 4:
					mes "[�}�h�����E�V���[]";
					mes "�ł́A�܂���Ő��������Ă��������B";
					close;
				}
				mes "[�}�h�����E�V���[]";
				mes "�����Ȃ�ǂ��ł����H";
				mes "�������߂����ꍇ��";
				mes "�u0�v����͂��Ă��������B";
				while(1) {
					next;
					input .@num;
					if(.@num == 0) {
						mes "[�}�h�����E�V���[]";
						mes "�ł́A�܂���Ő��������Ă��������B";
						close;
					}
					if(.@num > 100 || .@num < 0) {
						mes "[�}�h�����E�V���[]";
						mes "100�ȉ��ł��肢���܂��B";
						continue;
					}
					if(Zeny < .@num*.@zeny) {
						mes "[�}�h�����E�V���[]";
						mes "����������Ȃ��ł��ˁB";
						mes "���������m���߂Ă��������B";
						close;
					}
					if(checkweight(.@gain,.@num) == 0) {
						mes "[�}�h�����E�V���[]";
						mes "�S���͎��Ă������Ȃ��ł��ˁB";
						mes "�ו����m���߂Ă��������B";
						close;
					}
					set Zeny,Zeny-.@num*.@zeny;
					getitem .@gain,.@num;
					mes "[�}�h�����E�V���[]";
					mes "������������������Ă��������I";
					close;
				}
			case 2:
				mes "[�}�h�����E�V���[]";
				mes "���H�@�����`�B";
				mes "�V�������V�F�t�͑��ς�炸�ł��B";
				mes "�ŋ߂͎d���ɕs���ł�����̂��A";
				mes "���܂ɓ{�����肵�܂����A���C�ł���B";
				mes "�����������Ƌ����Ă���܂����B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "���i�̓`���R���[�g��J�������̂悤��";
				mes "�Â��̂�������Ă��l���A";
				mes "�����{�i�I�ȗ��������n�߂��";
				mes "�������r�O�������܂�����I";
				next;
				mes "[�}�h�����E�V���[]";
				mes "���������΁A�f�U�[�g�̑����";
				mes "�������n�߂��̂͊m���c�c";
				mes "�����A�����É���";
				mes "�ŋ߂����������Ȃ��̂�";
				mes "�����֘A������̂ł��傤���B";
				close;
			case 3:
				mes "[�}�h�����E�V���[]";
				mes "�������̔L�������Ă�q�̎��ł����H";
				mes "���ɂ��킩��܂��񂪁A";
				mes "�����Ă݂���u�����̉����v�A";
				mes "�q���b�P�l�̖�����炵���ł���H";
				next;
				mes "[�}�h�����E�V���[]";
				mes "���������΁A�V�������V�F�t��";
				mes "�q���b�P�l���N��Ȃ̂ɁA";
				mes "�ǂ����Ďo����ƌĂԂ̂�";
				mes "�C�ɂȂ�܂��񂩁H";
				next;
				cutin "orleans_6",0;
				mes "[�}�h�����E�V���[]";
				mes "�u�}�h���A�[���v�ł��Ȃ��u�o����v��";
				mes "�ĂԂɂ͗��R�����邻���ł���B";
				mes "�n�n�A���ɂ����̗��R�͂킩��܂���B";
				mes "���R�𕷂�����A�������{����";
				mes "�S�R�b���Ă���܂��񂩂�B";
				next;
				mes "[�}�h�����E�V���[]";
				mes "�c�c�c�c�n�b�I";
				close2;
				cutin "orleans_6",255;
				end;
		}
	}
}

prt_castle,45,28,3	script	�L�������Ă���q#Cooking	877,{
	if(rand(3)) {
		cutin "nyuang_3",2;
		emotion 2;	//��
		mes "[�L�������Ă���q]";
		mes "�j���n�n�n�`�@�j���n�n�`";
		mes "(�j���A�`�@�j���A�`)";
	}
	else {
		cutin "nyuang_1",2;
		emotion 1;	//�H
		mes "[�L�������Ă���q]";
		mes "�c�c�j���A�H";
		mes "(�j���A�`)";
	}
	close2;
	cutin "nyuang_3",255;
	end;
}

prt_castle,44,30,4	script	�q���b�P#Cooking	725,{
OnInit:
	hideonnpc;
	end;
}

payon,209,127,3	script	���K�������l	88,{
	switch(QUE_COOKING) {
	default:
		mes "[�E���`]";
		mes "���͂��͂������ł����`";
		mes "���200Zeny�ł���B";
		next;
		if(QUE_COOKING == 9)
			set .@word$,"�v�����e�����炨�͂����ł�";
		else
			set .@word$,"";
		switch(select("���͂����������I","���\�ł�",.@word$)) {
		case 1:
			if(Zeny < 200) {
				mes "[�E���`]";
				mes "���200Zeny�ł����Ă΁I";
				close;
			}
			set Zeny,Zeny-200;
			getitem 555,1;
			mes "[�E���`]";
			mes "���肪�Ƃ��������܂�!!";
			mes "�����ł����݂Ȃ���";
			mes "�����������肭������!!";
			close;
		case 2:
			mes "[�E���`]";
			mes "����Ȃ��Ȃ�";
			mes "���������Ȃ��ł���������B";
			mes "����Ȃ����������͂��͓�x��";
			mes "�H�ׂ��܂����H";
			mes "�܂��A����Ȃ炻���";
			mes "�����S���H�ׂ��Ⴂ�܂����ǂˁB";
			close;
		case 3:
			if(countitem(12111) < 1) {
				mes "[�E���`]";
				mes "���H�@���ł����H";
				mes "�v�����e�����玄��";
				mes "�͂��悤�Ȃ��̂͂Ȃ��Ǝv���܂���H";
				close;
			}
			mes "[�E���`]";
			mes "�ւ��`����́c�c";
			mes "����c�c";
			mes "�}�h�����������Ă��������ł����H";
			mes "�ւ��A����ȁc�c�B";
			next;
			mes "[�E���`]";
			mes "���Ɏ莆�������Ă܂��ˁB";
			mes "������Ɓc�c";
			mes "�ǂ�ł݂܂��c�c";
			mes "�ӂށc�c���ށc�c";
			next;
			mes "-�V�F�t�͂��O������ȗ�����";
			mes "����悤�Ɋ���Ă��c�c";
			mes "���̗����͓͂��Ă����������l��";
			mes "�ꐶ������������̂���I";
			mes "��x�H�ׂāA���O��������";
			mes "�����Ƃ��Ăق�����-";
			next;
			mes "[�E���`]";
			mes "�c�c�c�c";
			next;
			mes "[�E���`]";
			mes "�����c�c�������������I";
			mes "�����̊�b���Ȃ�āc�c";
			mes "���͎����̎��͂��킩�炸��";
			mes "�{���Ă΂��肢����ł��ˁB";
			mes "�p���������ł��c�c�B";
			next;
			mes "[�E���`]";
			mes "�����܂ŗ��Ă����";
			mes "���肪�Ƃ��������܂��B";
			mes "�ꐶ��������������ł�����A";
			mes "������薡�킢�Ȃ���A";
			mes "�搶�̌������Ƃ�������";
			mes "�l���Ă݂܂��B";
			next;
			delitem 12111,1;
			set QUE_COOKING,10;
			getitem 555,1;
			mes "[�E���`]";
			mes "����͎�����������͂��ł��B";
			mes "�A��ɐH�ׂĂ��������B";
			mes "�����v�����e���ɍs����";
			mes "�搶�ɂ܂�������Ă݂܂�!!";
			close;
		}
	case 8:
		mes "[�E���`]";
		mes "���`���B";
		mes "���͂����悭����Ȃ����A";
		mes "���̘b�ł������Ă���܂��񂩁H";
		mes "���͈ȑO�A";
		mes "�v�����e���̉��{�ɍs���܂����B";
		next;
		mes "[�E���`]";
		mes "�����������ȁH";
		mes "�f�U�[�g�����������l��";
		mes "���̂��͂������߂č��������";
		mes "��`���Ă���܂��āc�c�B";
		mes "��������悤�ƍs������ł���B";
		next;
		mes "[�E���`]";
		mes "����������A�Ȃ��";
		mes "���ɗ����������Ă��������";
		mes "�����܂����B";
		mes "�������A�����狳���Ă���";
		mes "���񂾂킯����Ȃ��ł���B";
		next;
		mes "[�E���`]";
		mes "����͂��肪������Ăł����A";
		mes "���͂����̂���l�ɂ���������";
		mes "����������Ă������������̂ŁA";
		mes "���ŋ����Ă��炨���Ƃ�����ł��B";
		next;
		mes "[�E���`]";
		mes "�Ƃ��낪�A���������c�c";
		mes "������̗���o�b�^�̑��A";
		mes "�n�`�Ȃ񂩂ŗ�����";
		mes "�����悤�Ƃ��Ă�����ł��I";
		next;
		mes "[�E���`]";
		mes "����Ȃ��̂��ǂ������";
		mes "�H�ׂ����悤�Ƃ���̂�";
		mes "�S�R�����ł��Ȃ��̂Ɂc�c";
		mes "����ɂ��ĕ����Ă��A";
		mes "�S�R�����Ă���܂���ł����c�c";
		next;
		mes "[�E���`]";
		mes "���ꂪ���������ɂ��āA";
		mes "�������N�����ē����Ă��܂����B";
		mes "�}���œ����Ă��܂�������A";
		mes "���̌�ǂ��Ȃ����̂��킩��܂��񂪁A";
		mes "���l���Ă݂��";
		mes "�{���ɒp���������������܂����B";
		next;
		mes "[�E���`]";
		mes "����ŁA�������ɂł�";
		mes "�߂��ĎӍ߂��������̂ł����c�c";
		mes "�搶���ǂ�����";
		mes "����ȗ����������悤�Ƃ����̂��A";
		mes "�����ɗ����ł��܂���c�c";
		mes "����Ȃ��́A�{���ɐH�ׂ���ł����H";
		close;
	case 10:
		mes "[�E���`]";
		mes "�ւցB";
		mes "�}�h�����ɂ��肪�Ƃ�����";
		mes "�`���Ă��������B";
		mes "����������x�搶���c�c";
		mes "����A�V�F�t�ɉ�ɍs���܂��ˁB";
		close;
	}
}