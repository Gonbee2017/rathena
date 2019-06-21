//= Auriga Script ==============================================================
// Ragnarok Online Moscovia Town Script	by Blaze
//==============================================================================

//============================================================
// Shop
//------------------------------------------------------------
mosk_in,21,254,5	shop	����l	968,611,501,502,503,504,506,645,656,601,602,1065,1750
mosk_in,31,180,3	shop	���폤�l	968,1207,1216,1107,1122,1116,1154,1407,1457,1354,1519
mosk_in,79,177,1	shop	�h��l	961,2211,2401,2403,2501,2503,2101,2103,2305,2321,2332,2328,2627
moscovia,152,71,4	shop	�ʕ����l	968,512,513,515,516
moscovia,199,110,3	shop	�������l	959,519

//============================================================
// �A���x���^�̃��X�R�r�A�]��NPC
//------------------------------------------------------------
alberta,245,66,3	script	���X�R�r�A�L���g	960,{
//alberta,246,51,3	script	���X�R�r�A�L���g	960,{
	mes "[���X�R�r�A�L���g]";
	mes "���X�R�r�A��m���Ă��܂����H";
	mes "�ʂĂ��Ȃ��C�ɕ����Ă���y��!!";
	mes "�`���Ɛ_��ɖ����Ă���";
	mes "���X�R�r�A�����Ȃ���҂��Ă��܂��I";
	next;
	switch(select("���X�R�r�A�Ƃ́H","���X�R�r�A�֍s��","�b����߂�")) {
	case 1:
		mes "[���X�R�r�A�L���g]";
		mes "���R�̐_��ɖ�������i�I";
		mes "��������q���Ɖ��{������΁A";
		mes "���Ȃ������X�R�r�A��";
		mes "�S��D����ł��傤�B";
		next;
		mes "[���X�R�r�A�L���g]";
		mes "���������~���I���A";
		mes "�������ĉ䂪���X�R�r�A��";
		mes "�F����ɏЉ�o����悤�ɂȂ�A";
		mes "�{���Ɋ������ł��B";
		mes "���X�R�r�A�̓~�́c�c";
		mes "�z����₷����A�������̂ł��B";
		next;
		mes "[���X�R�r�A�L���g]";
		mes "�����A���������X�R�r�A�ɍs���ɂ�";
		mes "�����`�����X�ł��I";
		mes "�����Ƒf�G�Ȏv���o���c����ł��傤�I";
		close;
	case 2:
		mes "[���X�R�r�A�L���g]";
		mes "���X�R�r�A�܂ł̈ړ�������";
		mes "10,000 zeny�ł��B";
		mes "���A��͂�����񖳗��ł��I";
		next;
		mes "[���X�R�r�A�L���g]";
		mes "���āA�o�����܂��傤���H";
		next;
		if(select("�o���I","��߂�")==2) {
			mes "[���X�R�r�A�L���g]";
			mes "���͂����ɂ��܂��̂ŁA";
			mes "�s�������Ȃ�܂�����";
			mes "���ł��b�������Ă��������I";
			close;
		}
		if(Zeny < 10000) {
			mes "[���X�R�r�A�L���g]";
			mes "�\���󂠂�܂��񂪁A";
			mes "�ړ�������10,000 zeny";
			mes "�𒸂��Ȃ��ƑD�͏o���܂���B";
			mes "������x�A���������m���߂Ă��������B";
			close;
		}
		mes "[���X�R�r�A�L���g]";
		mes "�ł́A�o�����܂��I";
		close2;
		set Zeny,Zeny-10000;
		warp "moscovia",163,55;
		end;
	case 3:
		mes "[���X�R�r�A�L���g]";
		mes "���͂����ɂ��܂��̂ŁA";
		mes "�s�������Ȃ�܂�����";
		mes "���ł��b�������Ă��������I";
		close;
	}
OnInit:
	waitingroom "���X�R�r�A�s��",0;
	end;
}

moscovia,166,53,3	script	���X�R�r�A�L���g	960,{
	mes "[���X�R�r�A�L���g]";
	mes "�A���x���^�ɖ߂�D��";
	mes "���ł��o���ł��܂��B";
	mes "�����ɏ���܂����H";
	next;
	if(select("�A���x���^�ɋA��","��߂�")==2) {
		mes "[���X�R�r�A�L���g]";
		mes "���X�R�r�A�����X�܂ŁA";
		mes "�������Ɗy�����";
		mes "�����Ă��������B";
		close;
	}
	mes "[���X�R�r�A�L���g]";
	mes "�܂��̂��z����";
	mes "���҂����Ă��܂��I";
	close2;
	//warp "alberta",243,67;
	warp "alberta",241,87;
	end;
}

//============================================================
// ���X�R�r�ANPC
//------------------------------------------------------------
moscovia,253,166,3	script	���m	966,{
	mes "[���m]";
	mes "���{�ɂ́A���̃��X�R�r�A��";
	mes "�x�z����u�`���[���l�v��";
	mes "����������B���ꂮ������炪";
	mes "�Ȃ��l�A�C�������܂��B";
	close;
}

//============================================================
// ���X�R�r�A����NPC
//------------------------------------------------------------
mosk_in,118,66,5	script	���m#mosk	966,{
	mes "[���m]";
	mes "���{�ł͐Â��ɂ��Ă��������B";
	mes "�`���[���l����������Ⴂ�܂��I";
	close;
}
mosk_in,118,66,5	duplicate(���m#mosk)	���m	966
mosk_in,113,124,5	duplicate(���m#mosk)	���m	966
mosk_in,133,110,3	duplicate(���m#mosk)	���m	966
mosk_in,133,73,3	duplicate(���m#mosk)	���m	966

//============================================================
// ���X�R�r�A�_���W����NPC
//------------------------------------------------------------
mosk_dun01,194,43,0	script	�Δ�#mosk1	111,{
	mes "-�l�p���`�̊�̕\�ʂ�";
	mes "�@���������܂�Ă���-";
	next;
	mes "^3131FF-���ɂ����Ȃ����";
	mes "�@�߂邪�ǂ�-^000000";
	close;
}

mosk_dun01,170,164,0	script	�Δ�#mosk2	111,{
	mes "-�l�p���`�̊�̕\�ʂ�";
	mes "�@���������܂�Ă���-";
	next;
	mes "^3131FF-���z�Ɏd����ҁA����";
	mes "�@����o�傪����̂Ȃ�A";
	mes "�@�k�֐i�ނ��ǂ�-^000000";
	close;
}

mosk_dun01,207,276,0	script	�Δ�#mosk3	111,{
	mes "-�l�p���`�̊�̕\�ʂ�";
	mes "�@���������܂�Ă���-";
	next;
	mes "^3131FF-�i�ގҁA�����������";
	mes "�@�E�C��Ⴄ�A�߂�҂͉����܂ł�";
	mes "�@���S�ł��낤�B";
	mes "�@���d�ȗE�C�����҂͐i�݁A";
	mes "�@�����łȂ��҂͖߂邪�ǂ�-^000000";
	next;
	if(select("�i��","�߂�") == 2) {
		mes "-�߂邱�Ƃ�I��-";
		close;
	}
	mes "-�i�ނ��Ƃ�I��-";
	close2;
	warp "mosk_dun02",165,30;
	end;
}

mosk_dun02,168,28,0	script	�Δ�#mosk4	111,{
	mes "-�l�p���`�̊�̕\�ʂ�";
	mes "�@���������܂�Ă���-";
	next;
	mes "^3131FF-�i�ގҁA���������";
	mes "�@�E�C��Ⴄ�B";
	mes "�@�߂�҂͉����܂ł�";
	mes "�@���S�ł��낤�B";
	mes "�@�E�C����҂͐i�݁A";
	mes "�@�����łȂ��҂͖߂邪�ǂ�-^000000";
	next;
	if(select("�i��","�߂�") == 2) {
		mes "-�߂邱�Ƃ�I��-";
		close;
	}
	mes "-�i�ނ��Ƃ�I��-";
	close2;
	warp "mosk_dun01",201,269;
	end;
}

mosk_dun02,268,117,0	script	�Δ�#mosk5	111,{
	mes "-�l�p���`�̊�̕\�ʂ�";
	mes "�@���������܂�Ă���-";
	next;
	mes "^3131FF-�i�ގҁA���ʑ����";
	mes "�@���_��Ⴄ�B";
	mes "�@�߂�҂͗E�C�𓾂邪";
	mes "�@���𕉂����낤�B";
	mes "�@���d�ȗE�C�̂���҂͐i�݁A";
	mes "�@�����łȂ��҂͖߂邪�ǂ�-^000000";
	next;
	if(select("�i��","�߂�") == 2) {
		mes "-�߂邱�Ƃ�I��-";
		close;
	}
	mes "-�i�ނ��Ƃ�I��-";
	close2;
	warp "mosk_dun03",32,135;
	end;
}

mosk_dun03,27,131,0	script	�Δ�#mosk6	111,{
	mes "-�l�p���`�̊�̕\�ʂ�";
	mes "�@���������܂�Ă���-";
	next;
	mes "^3131FF-���܂�ҁA���������";
	mes "�@���_��Ⴄ�B";
	mes "�@�߂�҂͑傫�����𕉂��A";
	mes "�@�E�C���w�Ԃ��낤�B";
	mes "�@�E�C����҂͖߂�A";
	mes "�@�����łȂ��҂͐i�ނ��ǂ�-^000000";
	next;
	if(select("�߂�","�i��") == 2) {
		mes "-�i�ނ��Ƃ�I��-";
		close;
	}
	mes "-�댯�������A�߂邱�Ƃ�I��-";
	close2;
	warp "mosk_dun02",262,118;
	end;
}

mosk_dun01,264,191,0	script	�Δ�#mosk7	111,{
	mes "-�l�p���`�̊�̕\�ʂ�";
	mes "�@���������܂�Ă���-";
	next;
	mes "^3131FF-�i�ގҁA���ʑ����";
	mes "�@���_��Ⴄ�B";
	mes "�@�߂�҂͉����܂ł�";
	mes "�@���S�ł��낤�B";
	mes "�@��������Ȃ��҂͐i�݁A";
	mes "�@�����łȂ��҂͖߂邪�ǂ�-^000000";
	next;
	if(select("�i��","�߂�") == 2) {
		mes "-�߂邱�Ƃ�I��-";
		close;
	}
	mes "-�i�ނ��Ƃ�I��-";
	close2;
	warp "mosk_dun03",117,36;
	end;
}

mosk_dun03,119,46,0	script	�Δ�#mosk8	111,{
	mes "-�l�p���`�̊�̕\�ʂ�";
	mes "�@���������܂�Ă���-";
	next;
	mes "^3131FF-���܂�ҁA���ʑ����";
	mes "�@���_��Ⴄ�B";
	mes "�@�߂�҂͉����܂ł�";
	mes "�@���S���낤�B";
	mes "�@��������ʎ҂͖߂�A";
	mes "�@�����łȂ��҂͐i�ނ��ǂ�-^000000";
	next;
	if(select("�߂�","�i��") == 2) {
		mes "-�i�ނ��Ƃ�I��-";
		close;
	}
	mes "-�댯�������A�߂邱�Ƃ�I��-";
	close2;
	warp "mosk_dun01",257,190;
	end;
}

//============================================================
// �N�W�����������˂ăN�G�X�gNPC
//- Registry -------------------------------------------------
// MOSK_1QUE -> 0�`41
//------------------------------------------------------------
moscovia,171,71,3	script	�x���o�C�F�t	968,{
	switch(MOSK_1QUE) {
	case 0:
		mes "[�x���o�C�F�t]";
		mes "�c�c";
		next;
		emotion 6;
		mes "[�x���o�C�F�t]";
		mes "���Łc�c";
		mes "���ł݂�ȉ��̌�������";
		mes "�M���Ă���Ȃ��񂾁c�c";
		mes "�{���Ȃ̂Ɂc�c";
		next;
		menu "�ǂ������܂������H",-;
		mes "[�x���o�C�F�t]";
		mes "�����ƁA�N�́c�c";
		mes "���̊X�̐l�ł͂Ȃ��ˁB";
		mes "���̊i�D���ƁA�`���҂��ȁB";
		next;
		mes "-" +strcharinfo(0)+ "��";
		mes "�@���Ȃ�����-";
		next;
		mes "[�x���o�C�F�t]";
		mes "���E�𗷂��Ă���`���҂̌N�Ȃ�A";
		mes "���̘b��M���Ă���邩���c�c";
		mes "�݂�ȁA�N���M���Ă���Ȃ��񂾁B";
		mes "���̘b�𕷂��Ă���Ȃ����ȁH";
		next;
		if(select("��������܂���","�b���Ă�������") == 1) {
			mes "[�x���o�C�F�t]";
			mes "�����c�c�����Ȃ����c�c";
			mes "�܂��A�d���Ȃ��ȁB";
			next;
			mes "[�x���o�C�F�t]";
			mes "�����A�C���ς������";
			mes "�܂��b�������ė~�����ȁB";
			close;
		}
		emotion 21;
		mes "[�x���o�C�F�t]";
		mes "�����I���肪�Ƃ��I";
		mes "���̘b�𕷂��Ă����񂾂ˁI";
		next;
		mes "[�x���o�C�F�t]";
		mes "�N�́A^FF0000������^000000�̘b��";
		mes "���������Ƃ��邩���H";
		next;
		mes "[�x���o�C�F�t]";
		mes "�̂��炱�̒n�ɓ`���";
		mes "�`���Ȃ񂾂��ǁA";
		mes "���̋ߊC�̂ǂ����ɁA";
		mes "������������Ƃ����񂾁B";
		next;
		mes "[�x���o�C�F�t]";
		mes "�ł��A���܂ł��̓���";
		mes "�����l�͂��Ȃ��B";
		mes "�����̊Ԃ܂ł�";
		mes "���̓`����M����l�Ȃ��";
		mes "���̊X�ɂ͒N�����Ȃ������B";
		next;
		mes "[�x���o�C�F�t]";
		mes "���̉����A�����̊Ԃ܂ł�";
		mes "����ȓ`���Ȃ��";
		mes "�S���M���Ă��Ȃ�������B";
		next;
		mes "[�x���o�C�F�t]";
		mes "�ł��A���͌��Ă��܂����񂾁B";
		mes "�D�ɏ���Ă��鎞�A";
		mes "���̖ڂŃn�b�L����";
		mes "���̓����������I";
		next;
		mes "[�x���o�C�F�t]";
		mes "�{���ɋ���������I";
		mes "�`���Ƃ΂�����v���Ă���";
		mes "���������˔@�A";
		mes "���̑O�Ɍ��ꂽ�񂾂���ˁI";
		next;
		mes "[�x���o�C�F�t]";
		mes "���͕K���ɂ��̓��ɋ߂Â�����";
		mes "�D�̑��x���グ���񂾁I";
		next;
		mes "[�x���o�C�F�t]";
		mes "�ł����͋߂Â��ǂ��납�A";
		mes "�ǂ�ǂ񗣂�Ă����Ă��܂��񂾁B";
		next;
		mes "[�x���o�C�F�t]";
		mes "���͕K���ɓ���ǂ������ǁA";
		mes "�c�c���ǂ�";
		mes "�C�̌��������ɏ����Ă��܂����񂾁B";
		next;
		mes "[�x���o�C�F�t]";
		mes "�ł��N�����̘b��";
		mes "�M���Ă���Ȃ��񂾁I";
		next;
		mes "[�x���o�C�F�t]";
		mes "�܂��A�N�����ĉ��̌�������";
		mes "���̂܂ܐM����͖̂������낤�ȁc�c";
		next;
		mes "[�x���o�C�F�t]";
		mes "�������̓���ڌ������̂́A��������";
		mes "��̊C�݂̂ǐ^�񒆂̕ӂ肾������B";
		mes "�ŏ��͉������āA�����̖ڂ�";
		mes "�^�������ǂˁB";
		next;
		menu "���̌�A�����������́H",-;
		mes "[�x���o�C�F�t]";
		mes "������A���ꂪ";
		mes "���ꂩ���x�����Ă��Ȃ���B";
		next;
		mes "[�x���o�C�F�t]";
		mes "�ł��{���Ȃ񂾁I";
		mes "���͌����񂾁I";
		mes "^FF0000������^000000�͎��݂���񂾁I";
		next;
		mes "[�x���o�C�F�t]";
		mes "���ꂩ�牴�̐S��";
		mes "�������̂��Ƃł����ς�����B";
		mes "���͂��̓��̓���𖾂������I";
		next;
		mes "[�x���o�C�F�t]";
		mes "�{���͍������ɂł�";
		mes "��������T���ɍs�������񂾂���";
		mes "���̑D���̏Ⴕ�Ă��܂��ĂˁB";
		mes "���͖{���ɂ��ĂȂ���c�c";
		next;
		mes "[�x���o�C�F�t]";
		mes "����Ŏd���Ȃ�";
		mes "�D�������Ă���";
		mes "^FF0000�C���m�t�ꂳ��^000000��";
		mes "�D��݂��Ă���A�Ɨ��񂾂񂾁B";
		next;
		mes "[�x���o�C�F�t]";
		mes "�ł��A";
		mes "�f���Ă��܂����񂾂�c�c";
		next;
		mes "[�x���o�C�F�t]";
		mes "���܂��͂킵�̘b�𕷂��񂩂�";
		mes "�ʖڂ��I�Ɩ�̂킩��Ȃ����Ƃ�";
		mes "�����ĂˁB";
		next;
		mes "[�x���o�C�F�t]";
		mes "�C���m�t�ꂳ��Ƃ͂ǂ���";
		mes "�������ݍ���Ȃ��Ƃ������c�c";
		next;
		mes "[�x���o�C�F�t]";
		mes "�C���m�t�ꂳ�񂩂�";
		mes "�D���؂����΂Ȃ��B";
		mes "�؂���Ȃ��ȏ��";
		mes "���̑D�̏C����";
		mes "�I���܂ő҂����Ȃ����c�c";
		mes "������������T��������B";
		next;
		mes "[�x���o�C�F�t]";
		mes "���������΁A�C���m�t�ꂳ���";
		mes "�Ⴂ���A�N�̂悤��";
		mes "�`�������Ă����炵�����B";
		mes "���������āA�N�Ȃ�C�������āA";
		mes "�D��݂��Ă��ꂽ�肵�ĂˁB";
		mes "�܂��A�����������낤���ǁB";
		next;
		mes "[�x���o�C�F�t]";
		mes "���Ȃ݂�";
		mes "�C���m�t�ꂳ���";
		mes "�������炷���쐼�̕��ɂ����B";
		set MOSK_1QUE,1;
		close;
	case 1:
		mes "[�x���o�C�F�t]";
		mes "�C���m�t�ꂳ�񂩂�";
		mes "�D���؂����΂Ȃ��B";
		mes "�؂���Ȃ��ȏ��";
		mes "���̑D�̏C����";
		mes "�I���܂ő҂����Ȃ����c�c";
		mes "������������T��������B";
		next;
		mes "[�x���o�C�F�t]";
		mes "���������΁A�C���m�t�ꂳ���";
		mes "�Ⴂ���A�N�̂悤��";
		mes "�`�������Ă����炵�����B";
		mes "���������āA�N�Ȃ�C�������āA";
		mes "�D��݂��Ă��ꂽ�肵�ĂˁB";
		mes "�܂��A�����������낤���ǁB";
		next;
		mes "[�x���o�C�F�t]";
		mes "���Ȃ݂�";
		mes "�C���m�t�ꂳ���";
		mes "�������炷���쐼�̕��ɂ����B";
		close;
	default:
		if(MOSK_1QUE > 12 && MOSK_1QUE < 42) {
			emotion 23;
			mes "[�x���o�C�F�t]";
			mes "�{��!?��������";
			mes "�������̂����H";
			mes "���������ɏ㗤�������Č�����!?";
			next;
			emotion 21;
			mes "[�x���o�C�F�t]";
			mes "��͂蓮�����͎��݂����I";
			mes "�N���ؖ����Ă��ꂽ�񂾂�I";
			mes "���肪�Ƃ��I";
			mes "�D���Ȃ�������";
			mes "���������ɂł���������";
			mes "�T���ɍs����I";
			close;
		}
		mes "[�x���o�C�F�t]";
		mes "���X�R�r�A�ɂ悤�����I";
		mes "���X�R�r�A��";
		mes "�Y��ȏ��ł��傤�H";
		mes "�y����ł����Ă��������ˁB";
		close;
	}
}

moscovia,135,49,5	script	�C���m�t	964,{
	switch(MOSK_1QUE) {
	case 1:
	case 2:
		mes "[�C���m�t]";
		mes "�O���̖`���҂����B";
		next;
		mes "[�C���m�t]";
		mes "�����́A�`���҂����Ă����񂾁B";
		mes "�̂Ɍ��E�������܂�������";
		mes "�����Ⴀ�A�`����";
		mes "��߂��܂��Ă��邪�ˁB";
		next;
		mes "[�C���m�t]";
		mes "��������20�N�Ⴏ��΁A";
		mes "�ԈႢ�Ȃ��A���񂽂̂悤��";
		mes "�`�������Ă��邺�c�c";
		mes "�����߂���̂͑�������B";
		next;
		if(select("�`���b�𕷂����Ă�������","�D��݂��Ă�������") == 1) {
			emotion 2;
			mes "[�C���m�t]";
			mes "���̖`���b�𕷂��������āH";
			mes "�ӂӂӁc�c";
			mes "�܂��A������肵�Ă����ȁB";
			next;
			mes "[�C���m�t]";
			mes "�����āA������b�������ȁB";
			mes "�������ȁc�c";
			mes "�������[���~�b�h�K�b�c��";
			mes "�]�X�Ƃ��Ă������̘b�����悤���ȁB";
			next;
			mes "[�C���m�t]";
			mes "���������΁A���̎��͂��񂽂�";
			mes "�������炢�̔N�������ȁc�c";
			next;
			mes "[�C���m�t]";
			mes "�ӂӂӁA";
			mes "���ꂾ����������������";
			mes "���ł�";
			mes "�������ĊC�𒭂߂Ȃ���";
			mes "�̂��v���o�����肷�邾���c�c";
			next;
			mes "[�C���m�t]";
			mes "�Ⴂ���̉���";
			mes "���̉�������";
			mes "�ǂ��v���̂��낤���c�c";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�i���̂������b������";
			mes "�@�\��������c�c�j";
			next;
			mes "[�C���m�t]";
			mes "�����A���܂Ȃ��B";
			mes "�O�u���������Ȃ��Ă��܂����ȁB";
			next;
			mes "[�C���m�t]";
			mes "����ɂ��Ă��A����";
			mes "���̘b�𑊓��y���݂ɂ��Ă���ȁI";
			next;
			mes "[�C���m�t]";
			mes "�����`���b�������Ղ��";
			mes "�������Ă����A";
			mes "����Ȋ�����Ă��邼�I";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�c�c";
			next;
			mes "[�C���m�t]";
			mes "�����܂ŁA�y���݂ɂ���Ă�";
			mes "�����ō��̖`���b��";
			mes "���Ȃ��Ă͂Ȃ�܂��B";
			next;
			mes "[�C���m�t]";
			mes "�����ށA";
			mes "�������ɘb���I��邾�낤���c�c";
			next;
			mes "[�C���m�t]";
			mes "�܂��A�������ɏI���Ȃ�������";
			mes "�����ɑ�����b���΂����ȁB";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�c�c";
			next;
			mes "[�C���m�t]";
			mes "�܂��A����|�����̌Q��Ƃ�";
			mes "�����̘b�����邩�I";
			next;
			mes "[�C���m�t]";
			mes "����24�΂ɂȂ������A";
			mes "���ƒ��ԒB�̓t�F�C�����̐X��";
			mes "�����Ă����񂾁B";
			next;
			mes "�c�c";
			next;
			mes "�c�c�c�c";
			next;
			mes "�c�c�c�c�c�c";
			next;
			mes "�c�c�c�c�c�c�c�c";
			next;
			mes "[�C���m�t]";
			mes "�����āA����������";
			mes "���̊���ɂ��";
			mes "�݂�Ȗ����ɋA�����킯���I";
			mes "�ǂ����A�������낤�H";
			next;
			mes "[�C���m�t]";
			mes "���́A�������ȁI";
			mes "�S�u�����B�Ƃ�";
			mes "�����̘b�����悤���ȁI";
			next;
			mes "[�C���m�t]";
			mes "���̃S�u�����̘b�͂�������!!";
			mes "���Ɍ㔼�̉��̊����";
			mes "���S�ɕ����ė~�����B";
			next;
			mes "[�C���m�t]";
			mes "���̘b�̉�����A";
			mes "�����̂��Ƃ��w��ŗ~�����B";
			mes "�ǂ����A������������H";
			next;
			if(select("���A���ƁA�܂����x�Ɂc�c","�͂��A�����܂��I") == 1) {
				mes "[�C���m�t]";
				mes "�������A�c�O���B";
				mes "����Ƙb�����ɏ����";
				mes "�����̂����c�c";
				next;
				mes "[�C���m�t]";
				mes "���������A���񂽂Ƃ�";
				mes "�b�������������ȁB";
				next;
				mes "[�C���m�t]";
				mes "����ł́A�܂��b��";
				mes "���������Ȃ����痈�Ă���B";
				close;
			}
			emotion 2;
			mes "[�C���m�t]";
			mes "�ӂӂӁA";
			mes "���񂽂͍ō����I";
			mes "���Ƃ͋C���������������I";
			next;
			mes "[�C���m�t]";
			mes "����A�S�u�����B�Ƃ�";
			mes "������b�����I";
			next;
			mes "�c�c";
			next;
			mes "�c�c�c�c";
			next;
			mes "�c�c�c�c�c�c";
			next;
			mes "�c�c�c�c�c�c�c�c";
			next;
			mes "[�C���m�t]";
			mes "�����āA�����������퓬��";
			mes "�����ɏI������񂾁c�c";
			mes "�ӂ��B";
			next;
			mes "[�C���m�t]";
			mes "�c�c";
			next;
			mes "[�C���m�t]";
			mes "�ӂӂӁB";
			next;
			mes "[�C���m�t]";
			mes "����ɂ��Ă��A��������";
			mes "���̘b�𕷂��Ă����l�́A";
			mes "�{���ɋv���Ԃ肾�ȁc�c";
			next;
			mes "[�C���m�t]";
			mes "���肪�Ƃ��B";
			mes "����������B";
			next;
			mes "[�C���m�t]";
			mes "���񂽂Ƃ�";
			mes "�ǂ��F�B�ɂȂ肻�����ȁB";
			next;
			mes "[�C���m�t]";
			mes "���񂽂̖��O�������Ă���B";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes strcharinfo(0)+ "�ł��B";
			next;
			mes "[�C���m�t]";
			mes strcharinfo(0)+ "���B";
			mes "�͋����A�������O���B";
			next;
			mes "[�C���m�t]";
			mes "���́A�N�̖`���b�𕷂����Ă���I";
			mes "����Ɂc�c";
			mes "^FF0000�������Ɏ�`���鎖��";
			mes "����΁A���ł������Ă���I";
			set MOSK_1QUE,2;
			close;
		}
		if(MOSK_1QUE != 2) {
			emotion 7;
			mes "[�C���m�t]";
			mes "������D���؂肽���̂��H";
			mes "���܂Ȃ����A����͖������B";
			mes "���́A�F�ƌĂׂ���̂ɂ���";
			mes "���͂͂������͂Ȃ��ȁB";
			next;
			mes "[�C���m�t]";
			mes "���Ƃ��񂽂�";
			mes "�܂��F�ƌĂׂ钇�ł͂Ȃ���ȁB";
			close;
		}
		mes "[�C���m�t]";
		mes "������D���؂肽���̂��B";
		mes "���񂽂̂��߂Ȃ�";
		mes "���ł��̑D��݂���!!";
		next;
		mes "[�C���m�t]";
		mes "�Ƃ����";
		mes "�D�ŉ����������Ȃ񂾁A";
		mes "�����Ă���Ȃ����H";
		next;
		mes "-" +strcharinfo(0)+ "��";
		mes "�@�`���̓������̘b������-";
		next;
		mes "[�C���m�t]";
		mes "���񂽁A�x���o�C�F�t�������Ƃ���";
		mes "���̓`���̓���";
		mes "�T���ƌ����̂��B";
		next;
		mes "[�C���m�t]";
		mes "�ӂӂӁA";
		mes "���񂽂͍��������";
		mes "�`���҂��ȁI";
		mes "�ō������I";
		next;
		mes "[�C���m�t]";
		mes "����ɒ��킷�邻�̈ӎu�I";
		mes "�܂��܂��C�ɓ������I";
		mes "�ł͑����s�����I";
		next;
		mes "[�C���m�t]";
		mes "�c�c";
		next;
		mes "[�C���m�t]";
		mes "�c�c������Ƒ҂��Ă���B";
		mes "�D�̒��q�����������B";
		mes "�c�c�Ȃ�قǁB";
		mes "�����������Ƃ��B";
		next;
		mes "[�C���m�t]";
		mes "���܂Ȃ��B";
		mes "�ŋ߁A�D���o���ĂȂ���������A";
		mes "���̑D�͏��������̕K�v��";
		mes "����悤���B";
		next;
		mes "[�C���m�t]";
		mes "���`�ށA��͂肻�����B";
		mes "�D�̓��͕����̐������K�v���B�B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "��`���܂��傤���H";
		next;
		mes "[�C���m�t]";
		mes "���񂽁A��`���Ă����̂��I";
		mes "�ŋ߂̎�҂ɂ��Ă͒������B";
		mes "���񂽂͂�͂�ō�����I";
		mes "�ō��̖`���҂���I";
		next;
		mes "[�C���m�t]";
		mes "����ł͂��܂Ȃ����A";
		mes "�����ɕK�v�ȍޗ���";
		mes "�W�߂Ă��Ă���Ȃ����H";
		next;
		mes "[�C���m�t]";
		mes "�K�v�ȍޗ��́A";
		mes "^3131FF��̃`���b�N 10�A";
		mes "�K�т��l�W 10�A";
		mes "�`���[�u 5�A";
		mes "�W���r���[ 10��^000000���B";
		next;
		mes "[�C���m�t]";
		mes "�ޗ�����������A";
		mes "�����ė��Ă���B";
		mes "���܂Ȃ�����낵�����ނ��B";
		set MOSK_1QUE,3;
		close;
	case 3:
		mes "[�C���m�t]";
		mes "�ޗ��͑S�����������H";
		mes "�ޗ���������΁A";
		mes "�D���o�������ł��邼�B";
		next;
		if(countitem(7167) < 10 || countitem(7317) < 10 || countitem(7325) < 5 || countitem(7312) < 10) {
			mes "[�C���m�t]";
			mes "�ޗ�������Ȃ����B";
			mes "�ޗ���������x��������ȁB";
			next;
			mes "[�C���m�t]";
			mes "�K�v�ȍޗ��́A";
			mes "^3131FF��̃`���b�N 10�A";
			mes "�K�т��l�W 10�A";
			mes "�`���[�u 5�A";
			mes "�W���r���[ 10��^000000���B";
			close;
		}
		delitem 7167,10;
		delitem 7317,10;
		delitem 7325,5;
		delitem 7312,10;
		set MOSK_1QUE,4;
		mes "[�C���m�t]";
		mes "���[!!�S���������ȁI";
		mes "����ł΂����肾!!";
		next;
		mes "[�C���m�t]";
		mes "�����҂��ĂĂ���B";
		mes "�����ɐ������邩��ȁB";
		next;
		mes "[�C���m�t]";
		mes "�c�c";
		next;
		mes "[�C���m�t]";
		mes "�����͂ł������I";
		mes "�����A����őD�̏�����";
		mes "���v���B";
		next;
		mes "[�C���m�t]";
		mes "���񂽂̏������o������";
		mes "�����Ă���I";
		close;
	case 4:
		mes "[�C���m�t]";
		mes "���I�������ł����̂��H";
		next;
		mes "[�C���m�t]";
		mes "�ł͍s�����I";
		mes "�N�W�����A�҂��Ă��₪����Ă񂾁I";
		close2;
		warp "mosk_ship",94,110;
		end;
	case 5:
	case 6:
	case 7:
	case 8:
	case 9:
	case 10:
	case 11:
	case 12:
	case 13:
	case 14:
		mes "[�C���m�t]";
		mes "���̑O�̍q�C�͑�ς������ȁc�c";
		mes "���������I";
		mes "�ō��ɋ����M���Ȃ�����B";
		next;
		mes "[�C���m�t]";
		mes "�܂��D���o���C�Ȃ�A";
		mes "�����Ă���B";
		mes "���͂��ł����v�����I";
		mes "�ނ��둁���s�����������I";
		next;
		mes "[�C���m�t]";
		mes "�N�W�����ɍs�����H";
		next;
		if(select("�������܂��c�c","�o�����Ă�������") == 1) {
			mes "[�C���m�t]";
			mes "���������A�c�O��!!";
			mes "�������o������";
			mes "���ł��b�������Ă���B";
			mes "����܂菀�����x���悤����";
			mes "���񂽂�߂܂���";
			mes "�������ł��A��čs������ȁI";
			close;
		}
		mes "[�C���m�t]";
		mes "�悵�A�s�����I";
		set MOSK_1QUE,4;
		close2;
		warp "mosk_ship",94,110;
		end;
	case 15:
		mes "[�C���m�t]";
		mes "���񂽁c�c";
		mes "�����Ă����̂�!!";
		mes "���́A���񂽂��g�Ɉ��܂��";
		mes "�����A���ė���Ȃ����Ɓc�c";
		next;
		mes "[�C���m�t]";
		mes "�������A";
		mes "�����Ă��Ă悩�����c�c";
		mes "�{���ɂ悩�����I";
		next;
		mes "[�C���m�t]";
		mes "����ŁA���܂łǂ��ɂ����񂾁H";
		mes "�C�ɗ�������A�ǂ������";
		mes "�A���Ă����񂾁H";
		next;
		menu "���܂ł̘b������",-;
		mes "[�C���m�t]";
		mes "���I";
		mes "���܂œ������ɂ�������!?";
		next;
		mes "[�C���m�t]";
		mes "�������������̐��̂�";
		mes "�N�W�������Č����̂��I";
		next;
		mes "[�C���m�t]";
		mes "���̃N�W���̏�ɂ͐�������A";
		mes "�؂������Ă��āA�Ɖ�������";
		mes "�V�l���Z��ł���c�c";
		next;
		mes "[�C���m�t]";
		mes "�������ȁc�c";
		mes "���܂ŉ����������b�̂����A";
		mes "��ԕs�v�c�Șb���B";
		next;
		mes "[�C���m�t]";
		mes "���ɘV�l���Z��ł�����Ă����̂�";
		mes "�������ȁB";
		mes "����ɂ��Ă��N�W�������񂾂�";
		mes "�ǂ��������Ȃ񂾂낤�ȁB";
		next;
		mes "[�C���m�t]";
		mes "�Ƃɂ����������b�Ȃ̂�";
		mes "�ԈႢ�Ȃ����I";
		mes "����͉��{�ɂ���`���[���l��";
		mes "�񍐂��������������B";
		next;
		mes "[�C���m�t]";
		mes "�`���[���l�͂��������s�v�c��";
		mes "�b���D���Ȃ񂾂�B";
		mes "���̘b�𕷂�����A";
		mes "����ȖJ�܂�";
		mes "���炦�邩������Ȃ����B";
		next;
		mes "[�C���m�t]";
		mes "���{�̏ꏊ�́A�����k���ɂ���";
		mes "���X�R�r�A�K�C�h�ɕ����Ƃ����B";
		next;
		mes "[�C���m�t]";
		mes "�F��I";
		mes "��͂�A���񂽂�";
		mes "�������`���҂������I";
		set MOSK_1QUE,16;
		close;
	case 16:
	case 17:
		mes "[�C���m�t]";
		mes "�N�W�����̘b�����{�ɂ���";
		mes "�`���[���l�ɕ񍐂��������������B";
		next;
		mes "[�C���m�t]";
		mes "�`���[���l�͂��������s�v�c��";
		mes "�b���D���Ȃ񂾂�B";
		mes "���̘b�𕷂�����A";
		mes "����ȖJ�܂�";
		mes "���炦�邩������Ȃ����B";
		next;
		mes "[�C���m�t]";
		mes "���{�̏ꏊ�́A�����k���ɂ���";
		mes "���X�R�r�A�K�C�h�ɕ����Ƃ����B";
		close;
	case 18:
		mes "[�C���m�t]";
		mes "�ǂ������H";
		next;
		mes "-" +strcharinfo(0)+ "��";
		mes "�@�����b����-";
		next;
		mes "[�C���m�t]";
		mes "�`���[���l�̓N�W�����̏؋���";
		mes "�v�����ꂽ�̂��c�c";
		mes "�b�����ł͐M���Ă���Ȃ��������B";
		next;
		mes "[�C���m�t]";
		mes "�������F��I";
		next;
		mes "[�C���m�t]";
		mes "���͐�΂ɂ��񂽂̘b��";
		mes "�M���邺�B";
		mes "�Ⴆ�ǂ�Ȃ��Ƃ������Ă��ȁB";
		next;
		mes "[�C���m�t]";
		mes "�c�c";
		mes "���ꂩ��ǂ�����H";
		mes "�؋��ƌ����Ă��A����Șb����B";
		mes "�N�W�����ɍĂэs���邩";
		mes "�킩��Ȃ����c�c";
		next;
		mes "[�C���m�t]";
		mes "�������A���񂽂̂��Ƃ��B";
		mes "�����ƒ��߂Ȃ����낤�H";
		next;
		mes "[�C���m�t]";
		mes "�F��I";
		mes "���񂽂��]�ނȂ�";
		mes "���͉��x�ł���`�����B";
		next;
		if(select("������x�N�W������T��","���߂�") == 2) {
			mes "[�C���m�t]";
			mes "�������c�c";
			mes "�m����";
			mes "������x���ǂ蒅���邩";
			mes "�킩��Ȃ��N�W������";
			mes "�T���͖̂��������m��Ȃ��B";
			next;
			mes "[�C���m�t]";
			mes "�������A����䂦��";
			mes "���킷�鉿�l������Ɖ��͎v���B";
			mes "�N�W������T���C�ɂȂ�����";
			mes "�܂��b�������Ă���B";
			close;
		}
		mes "[�C���m�t]";
		mes "���������c�c";
		mes "�ǂ�ȍ���ɂ������������B";
		mes "��͂�A�����F�߂�";
		mes "�`���҂��������!!";
		next;
		mes "[�C���m�t]";
		mes "�������ł�����";
		mes "�b�������Ă���I";
		set MOSK_1QUE,19;
		close;
	case 19:
		mes "[�C���m�t]";
		mes "���I�������ł����̂��H";
		mes "������Ƒ҂��Ă���c�c";
		next;
		mes "[�C���m�t]";
		mes "�ł͍s�����I";
		close2;
		warp "mosk_ship",94,110;
		end;
	case 20:
	case 21:
	case 22:
	case 23:
	case 24:
	case 25:
	case 26:
	case 27:
	case 28:
	case 29:
	case 30:
	case 31:
		mes "[�C���m�t]";
		mes "���̑O�̍q�C�͑�ς������ȁc�c";
		mes "���������I";
		mes "�ō��ɋ����M���Ȃ�����B";
		next;
		mes "[�C���m�t]";
		mes "�܂��D���o���C�Ȃ�A";
		mes "�����Ă���B";
		mes "���͂��ł����v�����I";
		mes "�ނ��둁���s�����������I";
		next;
		mes "[�C���m�t]";
		mes "�N�W�����ɍs�����H";
		next;
		if(select("�������܂��c�c","�o�����Ă�������") == 1) {
			mes "[�C���m�t]";
			mes "���������A�c�O��!!";
			mes "�������o������";
			mes "���ł��b�������Ă���B";
			mes "����܂菀�����x���悤����";
			mes "���񂽂�߂܂���";
			mes "�������ł��A��čs������ȁI";
			close;
		}
		mes "[�C���m�t]";
		mes "�悵�A�s�����I";
		set MOSK_1QUE,19;
		close2;
		warp "mosk_ship",94,110;
		end;
	case 32:
		mes "[�C���m�t]";
		mes "�N�W���������̖ڂ�";
		mes "�������ǁA���܂��M�����Ȃ����B";
		mes "�{���ɋ������c�c";
		next;
		mes "-" +strcharinfo(0)+ "��";
		mes "�@�����b����-";
		next;
		mes "[�C���m�t]";
		mes "�ޗ����W�߂Ă���΁A";
		mes "���̊y��������";
		mes "�����Ɩ񑩂����̂��B";
		next;
		mes "[�C���m�t]";
		mes "�K�v�ȍޗ���";
		mes "^3131FF�ۑ� 30�A";
		mes "��v�Ȗ� 20�A";
		mes "�R�r�̊p 20�A";
		mes "���b�R�̖є� 10��^000000���B";
		next;
		mes "[�C���m�t]";
		mes "�N�W�����͂��̏ꏊ�ɂ��Ă����Ȃ�";
		mes "�ꏊ�͉����o���Ă��邩��A";
		mes "���񂽂̏������o������A";
		mes "�o�����悤���I";
		set MOSK_1QUE,33;
		close;
	case 33:
	case 34:
	case 35:
	case 36:
	case 37:
	case 38:
		mes "[�C���m�t]";
		mes "�N�W�����ɍs�����H";
		next;
		if(select("�܂��A����������Ȃ��ł�","�o�����܂��傤") == 1) {
			mes "[�C���m�t]";
			mes "�ł͑҂��Ă��邼�B";
			close;
		}
		mes "[�C���m�t]";
		mes "���ꂶ�Ⴀ�A�o�����悤�I";
		close2;
		warp "mosk_fild01",93,94;
		end;
	case 39:
	case 40:
		mes "[�C���m�t]";
		mes "�F��I";
		mes "���񂽂Əo���";
		mes "�{���ɂ悩�����B";
		next;
		mes "[�C���m�t]";
		mes "�����ł��Ȃ��Ǝv���Ă���";
		mes "�`�����ł����񂾂���ȁI";
		next;
		mes "[�C���m�t]";
		mes "�N�W�����̖`����";
		mes "�{���ɂ��΂炵�����̂������B";
		mes "���ł������������܂�Ȃ��I";
		next;
		mes "[�C���m�t]";
		mes "�v�X���A����ȏ[�����́B";
		mes strcharinfo(0)+ "��";
		mes "�o��Ė{���ɂ悩�������I";
		close;
	case 41:
		mes "[�C���m�t]";
		mes strcharinfo(0)+ "!!";
		mes "�`���[���l�̑O��";
		mes "�������t�������炵���ȁI";
		next;
		mes "[�C���m�t]";
		mes "�J�܂܂ł�������炵������Ȃ����I";
		mes "��͂肠�񂽂͂������c�c";
		mes "�������`���҂���I";
		next;
		mes "[�C���m�t]";
		mes "�܂��A���񂽂�";
		mes "�`�����������ăE�Y�E�Y���邺�I";
		close;
	default:
		if(MOSK_1QUE > 90) {
			mes "[�C���m�t]";
			mes "���񂽁A�͂₭�N�W������";
			mes "�T���ɍs�������I";
			mes "�������ł�����";
			mes "�b�������Ă���I";
			if(MOSK_1QUE > 90 && MOSK_1QUE < 100)
				set MOSK_1QUE,4;
			else if(MOSK_1QUE > 200 && MOSK_1QUE < 300)
				set MOSK_1QUE,19;
			close;
		}
		mes "[�C���m�t]";
		mes "���̊i�D���炷���";
		mes "���񂽂́A�O���̖`���҂��ȁH";
		next;
		mes "[�C���m�t]";
		mes "�����́A�`���҂����Ă����񂾁B";
		mes "�̂Ɍ��E�������܂�������";
		mes "�����Ⴀ�A�`����";
		mes "��߂��܂��Ă��邪�ˁB";
		next;
		mes "[�C���m�t]";
		mes "��������20�N�Ⴏ��΁A";
		mes "�ԈႢ�Ȃ��A���񂽂̂悤��";
		mes "�`�����������낤�Ɂc�c";
		mes "�����߂���̂͑������邺�B";
		close;
	}
}

mosk_ship,98,110,3	script	�C���m�t	964,{
	switch(MOSK_1QUE){
	case 4:
		mes "[�C���m�t]";
		mes "�n�@�c�c";
		mes "�����͂�͂肢���ȁB";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�ꏏ�ɗ��Ē�����";
		mes "���肪�Ƃ��������܂��B";
		next;
		mes "[�C���m�t]";
		mes "�F��A";
		mes "�݂����������������ȁB";
		mes "���ł��C�̏�Ȃ�";
		mes "���񂽂̗͂ɂȂ�邾�낤�B";
		next;
		mes "[�C���m�t]";
		mes "�������A�D�̑����";
		mes "���񂽂ɂ�";
		mes "��`���Ă��炢�����񂾂��B";
		next;
		mes "-" +strcharinfo(0)+ "��";
		mes "�@���Ȃ�����-";
		next;
		mes "[�C���m�t]";
		mes "�����C���̗����ǂ��";
		mes "���񂽂Ɏw������������A";
		mes "���̎w���ɏ]���āA";
		mes "�D�̑ǂ̕����𒲐߂��Ă���I";
		next;
		mes "[�C���m�t]";
		mes "^FF0000�C���̗��ꂪ�Ȃ��ꍇ��";
		mes "���܂߂ɉ��ɘb�������Ă���B^000000";
		mes "���ꂪ�ς������";
		mes "�����Ɏw������������ȁB";
		next;
		mes "[�C���m�t]";
		mes "�܂��́A���ɐi�������I";
		mes "�D�𓌂̕����ɕς��Ă���I";
		set MOSK_1QUE,5;
		close;
	case 5:
	case 20:
		mes "[�C���m�t]";
		mes "�܂��́A���ɐi�������I";
		mes "�D�𓌂̕����ɕς��Ă���I";
		close;
	case 6:
	case 21:
		if(rand(4)) {
			mes "[�C���m�t]";
			mes "�܂����ȁc�c�܂��C����";
			mes "�����������c�c";
			mes "���ʂȕω��������Ȃ��ȁc�c";
			next;
			mes "[�C���m�t]";
			mes "���΂炭�A���̂܂�";
			mes "�i��ł݂悤���B";
			next;
			mes "[�C���m�t]";
			mes "�܂����ɘb�������Ă���B";
			close;
		}
		mes "[�C���m�t]";
		mes "�C���̗��ꂪ�ς�����c�c";
		mes "�ǂ�k�̕�����";
		mes "�ς��Ă���Ȃ����H";
		set MOSK_1QUE,MOSK_1QUE+1;
		close;
	case 7:
	case 22:
		if(getvariableofnpc(.mob,"��#mosk")) {
			mes "[�C���m�t]";
			mes "���̓����X�^�[��|���̂�";
			mes "�挈�ۑ肾�I";
			close;
		}
		mes "[�C���m�t]";
		mes "�k�ɐi�߂�񂾂�!?";
		mes "�����ǂ̕������C������񂾁I";
		close;
	case 8:
	case 10:
	case 23:
	case 25:
		if(getvariableofnpc(.mob,"��#mosk")) {
			mes "[�C���m�t]";
			mes "���̓����X�^�[��|���̂�";
			mes "�挈�ۑ肾�I";
			close;
		}
		if(rand(4)) {
			mes "[�C���m�t]";
			mes "�܂����ȁc�c�܂��C����";
			mes "�����������c�c";
			mes "���ʂȕω��������Ȃ��ȁc�c";
			next;
			mes "[�C���m�t]";
			mes "���΂炭�A���̂܂�";
			mes "�i��ł݂悤���B";
			next;
			mes "[�C���m�t]";
			mes "�܂����ɘb�������Ă���B";
			close;
		}
		if(MOSK_1QUE == 8 || OSK_1QUE == 10)
			set MOSK_1QUE,rand(91,94);
		else
			set MOSK_1QUE,rand(241,244);
		mes "[�C���m�t]";
		mes "�C���̗��ꂪ�ς�����c�c";
		mes "�ǂ�" +((MOSK_1QUE%10 == 1)? "��": (MOSK_1QUE%10 == 2)? "��": (MOSK_1QUE%10 == 3)? "��": "�k")+ "�̕�����";
		mes "�ς��Ă���Ȃ����H";
		close;
	case 91:
	case 92:
	case 93:
	case 94:
	case 241:
	case 242:
	case 243:
	case 244:
		mes "[�C���m�t]";
		mes ((MOSK_1QUE%10 == 1)? "��": (MOSK_1QUE%10 == 2)? "��": (MOSK_1QUE%10 == 3)? "��": "�k")+ "�ɐi�߂�񂾂�!?";
		mes "�����ǂ̕������C������񂾁I";
		close;
	case 11:
		emotion 5;
		mes "[�C���m�t]";
		mes "����!!";
		mes "�C�̌���������";
		mes "�������ȕ��������Ȃ����H";
		next;
		mes "[�C���m�t]";
		mes "����͈��!?";
		mes "���A���񂽁I";
		mes "�D��̕��֍s����";
		mes "���ꂪ�������Ă���I";
		mes "����!!";
		set MOSK_1QUE,12;
		close;
	case 12:
		mes "[�C���m�t]";
		mes "����͈��!?";
		mes "���A���񂽁I";
		mes "�D��̕��֍s����";
		mes "���ꂪ�������Ă���I";
		mes "����!!";
		close;
	case 19:
		mes "[�C���m�t]";
		mes "�����N�W������";
		mes "�����ł���Ƃ����ȁB";
		next;
		mes "[�C���m�t]";
		mes "���̑D�̊�{�I��";
		mes "������@�͑O��Ɠ������B";
		mes "�����ŁA�������񂽂Ɏw�����o���B";
		mes "���񂽂͉��̎w���ɏ]���āA";
		mes "�D�̑ǂ̕����𒲐߂���Ηǂ��B";
		next;
		mes "[�C���m�t]";
		mes "^FF0000�C���̗��ꂪ�Ȃ��ꍇ��";
		mes "���܂߂ɉ��ɘb�������Ă���B^000000";
		mes "���ꂪ�ς������";
		mes "�����Ɏw������������ȁB";
		next;
		mes "[�C���m�t]";
		mes "�܂��́A���ɐi�������I";
		mes "�D�𓌂̕����ɕς��Ă���I";
		set MOSK_1QUE,20;
		close;
	case 26:
		mes "[�C���m�t]";
		mes "�����A���������!!";
		next;
		mes "-�C���m�t���w����������";
		mes "�@����ȓ����������B";
		mes "�@�N�W�������I-";
		next;
		mes "[�C���m�t]";
		mes "���A���ꂪ�N�W�����c�c";
		next;
		mes "[�C���m�t]";
		mes "���̖ڂŎ��ۂɌ��邱�Ƃ�";
		mes "�ł���Ȃ�āc�c";
		next;
		mes "-�C���m�t�̑̂������̂��܂�";
		mes "�@�k���Ă���-";
		next;
		mes "[�C���m�t]";
		mes "�����A�{���ɉƂ����邼�I";
		mes "���󕨂܂Ŋ����Ă���I";
		next;
		mes "[�C���m�t]";
		mes "�������c�c";
		mes "���������c�c";
		mes "�������������܂������B";
		mes "�c�c";
		next;
		mes "[�C���m�t]";
		mes "�����ƁA";
		mes "���񂽂͑����N�W�����ɍs���ȁB";
		next;
		mes "[�C���m�t]";
		mes "���́A���̑O�݂����ɏՓ˂�����A";
		mes "���x�����D����ꂻ��������A";
		mes "���������������ăN�W������";
		mes "���Ă��������B";
		next;
		mes "[�C���m�t]";
		mes "�߂�Ƃ��͎��U���Ă���I";
		mes "���񂽂��悹�ɍs�������B";
		set MOSK_1QUE,30;
		close2;
		warp "mosk_fild01",93,94;
		end;
	default:	//������
		mes "[�C���m�t]";
		mes "�N���A���񂽂́H";
		mes "�ǂ����Ă��̑D�ɏ���Ă���H";
		mes "����͊X�܂ő����Ă�邪�A";
		mes "���͂Ȃ����B";
		close2;
		warp "moscovia",163,55;
		end;
	}
}

mosk_ship,100,110,0	script	��#mosk	111,{
	if(.mob) {
		mes "[�C���m�t]";
		mes "���̓����X�^�[��|������";
		mes "�W�����Ă���I";
		close;
	}
	if(MOSK_1QUE != 5 && MOSK_1QUE != 7 && MOSK_1QUE != 20 && MOSK_1QUE != 22 &&
		(MOSK_1QUE < 91 || MOSK_1QUE > 94) && (MOSK_1QUE < 241 || MOSK_1QUE > 244)) {
		mes "[�C���m�t]";
		mes "���͑ǂ𓮂����Ȃ��ł���I";
		mes "�ǂ̒��߂͉�����̎w����";
		mes "���������݂̂ɂ��Ă���I";
		close;
	}
	mes "�ǂ���ɐi�݂܂��傤���H";
	next;
	set @menu,select("��","��","��","�k");
	if(MOSK_1QUE == 5 || MOSK_1QUE == 20) {
		if(@menu != 1) {
			mes "[�C���m�t]";
			mes "���ɐi�߂�񂾂�!!";
			mes "�������ɕ�����ς��Ă���!!";
			close;
		}
		mes "[�C���m�t]";
		mes "�悵�I���̂܂ܓ��ɍs�����I";
		mes "�����牽�炩�̎w������������";
		mes "���₩�ɑǂ𒲐߂��Ă���!!";
		set MOSK_1QUE,MOSK_1QUE+1;
		close;
	}
	if(MOSK_1QUE == 7 && @menu != 4 || MOSK_1QUE == 22 && @menu != 4 ||
		MOSK_1QUE%30 == 1 && @menu != 1 || MOSK_1QUE%30 == 2 && @menu != 2 || MOSK_1QUE%30 == 3 && @menu != 3 || MOSK_1QUE%30 == 4 && @menu != 4) {
		mes "[�C���m�t]";
		mes ((MOSK_1QUE%30 == 1)? "��": (MOSK_1QUE%30 == 2)? "��": (MOSK_1QUE%30 == 3)? "��": "�k")+ "�ɐi�߂�񂾂�!?";
		mes "�����ǂ̕������C������񂾁I";
		if(rand(4))
			close;
		next;
		if(rand(2)) {
			set .mob,2;
			monster "mosk_ship",89,112,"�C�̉�����",1579,1,"��#mosk::OnKilled";
			monster "mosk_ship",85,110,"�C�̉�����",1579,1,"��#mosk::OnKilled";
		}
		else {
			set .mob,4;
			monster "mosk_ship",89,112,"�C�̉�����",1551,1,"��#mosk::OnKilled";
			monster "mosk_ship",82,110,"�C�̉�����",1579,1,"��#mosk::OnKilled";
			//monster "mosk_ship",82,114,"�C�̉�����",1579,1,"��#mosk::OnKilled";
			monster "mosk_ship",83,113,"�C�̉�����",1579,1,"��#mosk::OnKilled";
			monster "mosk_ship",85,110,"�C�̉�����",1551,1,"��#mosk::OnKilled";

		}
		mes "[�C���m�t]";
		mes "�����X�^�[�����ꂽ��!!";
		mes "�퓬�̏��������Ă���!!";
		close;
	}
	mes "[�C���m�t]";
	mes "�悵�I���΂炭�͂��̂܂�";
	mes ((MOSK_1QUE%30 == 1)? "��": (MOSK_1QUE%30 == 2)? "��": (MOSK_1QUE%30 == 3)? "��": "�k")+ "�ɐi�����I";
	mes "�����牽���w��������������";
	mes "�܂��ǂ𒲐߂��Ă���!!";
	if(MOSK_1QUE == 7 || MOSK_1QUE == 22) {
		set MOSK_1QUE,MOSK_1QUE+1;
		close;
	}
	if(rand(4)) {
		set MOSK_1QUE,(MOSK_1QUE < 100)? 8: 23;
		close;
	}
	next;
	mes "[�C���m�t]";
	mes "���܂����c�c";
	mes "�O�ɉ��������ꂽ��!!";
	mes "���A�����X�^�[��!!";
	next;
	mes "[�C���m�t]";
	mes "����̃����X�^�[�͍��܂ł�";
	mes "�����X�^�[�ƈႤ�C������c�c";
	mes "�C��t���������悳������!!";
	next;
	set .mob,3;
	monster "mosk_ship",85,111,"�C�̉�����",1425,1,"��#mosk::OnKilled";
	monster "mosk_ship",89,112,"�C�̉�����",1445,1,"��#mosk::OnKilled";
	monster "mosk_ship",90,106,"�C�̉�����",1445,1,"��#mosk::OnKilled";
	mes "[�C���m�t]";
	mes "^FF0000�K���A���̃����X�^�[��";
	mes "�����̗͂œ|���Ă���I^000000";
	set MOSK_1QUE,(MOSK_1QUE < 100)? 10: 25;
	close;
OnKilled:
	set .mob,.mob-1;
	if(.mob)
		end;
	mes "[�C���m�t]";
	mes "����ƃ����X�^�[���Еt�����ȁI";
	mes "����ŁA����Ɠ�����c�c";
	if(MOSK_1QUE == 10 || MOSK_1QUE == 25)
		set MOSK_1QUE,MOSK_1QUE+1;
	close;
OnTimer300000:
	stopnpctimer;
	killmonster "mosk_ship","��#mosk::Onkilled";
	set .mob,0;
	end;
}

mosk_ship,81,110,0	script	�D��#mosk	139,5,5,{
	if(MOSK_1QUE != 12)
		end;
	mes "[�C���m�t]";
	mes "����I";
	mes strcharinfo(0)+ "�I";
	mes "�O������!!";
	mes "��Ȃ�!!";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "�i���c�c����́c�c�H�j";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "�i�������߂Â��Ă���c�c�j";
	next;
	mes "[�C���m�t]";
	mes "��Ȃ�!!";
	mes strcharinfo(0)+ "�c�c";
	mes "����́c�c";
	mes "���A��́c�c?!";
	next;
	mes "-����ȉ������ڂ̑O�܂�";
	mes "�@���܂��Ă����B";
	mes "�@���܂����������A";
	mes "�@�D���h���Ԃ�ꂽ-";
	set MOSK_1QUE,13;
	close2;
	warp "mosk_fild01",95,93;
	end;
}

mosk_fild01,86,104,3	script	��ȘV�l	963,{
	switch(MOSK_1QUE) {
	case 13:
		mes "[��ȘV�l]";
		mes "�����A";
		mes "�C���t�����悤���ȁB";
		mes "�ǂ����ˁA";
		mes "�ɂ��Ƃ���͂Ȃ����H";
		next;
		mes "[��ȘV�l]";
		mes "���܂Ȃ������ˁB";
		mes "�N�̏���Ă����D��";
		mes "�Փ˂������ɂȂ��Ă��܂����B";
		mes "�S���炨�l�т����B";
		next;
		mes "[��ȘV�l]";
		mes "����ɂ��Ă�";
		mes "���̐l�������ɗ����̂�";
		mes "���N�Ԃ肾�낤���c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�����͂ǂ��ł����H";
		mes "���Ȃ��͒N�ł����H";
		next;
		mes "[��ȘV�l]";
		mes "�����́c�c";
		mes "�ӂށc�c";
		next;
		mes "[��ȘV�l]";
		mes "�킵�͂��̓����N�W�����ƌĂ�ł���B";
		mes "�킵��l�������Ȃ�";
		mes "������������B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�������A�\�̓������ł����B";
		mes "�N�W�����c�c";
		mes "���������Ă��̓��́c�c�H";
		next;
		mes "[��ȘV�l]";
		mes "�C�t�������B";
		mes "�����A���̓��́A";
		mes "����ȃN�W���̔w���Ȃ񂾂�B";
		next;
		mes "-" +strcharinfo(0)+ "��";
		mes "�@��������-";
		next;
		mes "[��ȘV�l]";
		mes "�����̂������͂Ȃ��ȁB";
		mes "�����̓N�W���̔w�������A";
		mes "�����؂������Ă���B";
		next;
		mes "[��ȘV�l]";
		mes "�����ł���悤��";
		mes "�킵�͉Ƃ܂Ō��Ă���B";
		mes "����ɑD������B";
		next;
		mes "[��ȘV�l]";
		mes "���̃N�W����";
		mes "�킵���Z��ł��邱�Ƃ�";
		mes "�m���Ă��ĂȁB";
		mes "�C�ɒ��ނ��Ƃ�";
		mes "�Ȃ��񂶂��B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "���A���Ȃ��͈�́H";
		next;
		mes "[��ȘV�l]";
		mes "�킵�͕��ʂ̘V�l����B";
		mes "�����������Ɖ���؂�A������";
		mes "�������߂����Ă��邾������B";
		next;
		mes "[��ȘV�l]";
		mes "���āA�N�����C��";
		mes "���߂����悤�����A";
		mes "���n�ɑ����Ă����悤�B";
		mes "�N�̎���S�z���Ă���l��";
		mes "���邾�낤�H";
		next;
		soundeffect "mos_gusli1.wav",0;
		mes "-�V�l�͔w�����Ă����y���";
		mes "�@���o���A���t���n�߂�-";
		next;
		mes "-���t���n�܂�ƁA";
		mes "�@����ɂ��킹��";
		mes "�@����������蓮���o����-";
		next;
		mes "[��ȘV�l]";
		mes "�����́A�N�Ƙb����";
		mes "�y����������B";
		next;
		mes "[��ȘV�l]";
		mes "���������ŁA���n�ɒ�������";
		mes "���S���đ҂��Ȃ����B";
		next;
		mes "[��ȘV�l]";
		mes "�X�̐l�ɋC�t����Ȃ��悤��";
		mes "�X�ɋ߂Â��Ȃ��Ă͂ȁB";
		next;
		mes "-�V�l�͖ڂ��ނ�A�y���";
		mes "�@���t�𑱂���-";
		set MOSK_1QUE,14;
		close;
	case 14:
		soundeffect "mos_gusli1.wav",0;
		mes "-�V�l�͖ڂ��ނ�A�y���";
		mes "�@���t�𑱂��Ă���-";
		next;
		mes "-�V�l�͖ڂ��ނ�A�y���";
		mes "�@���t�𑱂���-";
		set MOSK_1QUE,15;
		close;
	case 15:
		mes "[��ȘV�l]";
		mes "�����������悤���ȁB";
		mes "���n���N�ɂ������邾�낤�B";
		mes "�C�����ċA�邪�����B";
		next;
		mes "[��ȘV�l]";
		mes "���������";
		mes "�܂�����Ƃ����邾�낤�B";
		mes "���悤�Ȃ�A�`���҂�B";
		close2;
		warp "moscovia",163,54;
		end;
	case 30:
		mes "[��ȘV�l]";
		mes "�����A�N�́c�c";
		next;
		mes "[��ȘV�l]";
		mes "�ӂӂӁB���������";
		mes "�N�ɂ܂����Ƃ́B";
		mes "�ĉ���������v����B";
		mes "�����͉����p�����肻�����ȁH";
		next;
		menu "������������",-;
		mes "[��ȘV�l]";
		mes "�ق��A";
		mes "�������������������̂��c�c";
		next;
		mes "[��ȘV�l]";
		mes "�m���ɁA���̓���";
		mes "�M����ƌ����Ă�";
		mes "�������������ȁB";
		next;
		mes "[��ȘV�l]";
		mes "����ɂ��Ă�";
		mes "�킵�͂����ŗ]�����������";
		mes "�߂������������Ȃ񂶂Ⴊ�̂��c�c";
		next;
		mes "[��ȘV�l]";
		mes "����Ȋ������ȁB";
		mes "�N�̂�������Ȃ��B";
		next;
		mes "[��ȘV�l]";
		mes "�N�ɃN�W�����̎���";
		mes "�N�ɂ������Ă͂����Ȃ��Ȃ�";
		mes "�킵�͌����Ă���񂵂ȁB";
		next;
		mes "[��ȘV�l]";
		mes "����ɁA�킵�����̋C�ɂȂ�΁A";
		mes "�N�ɂ�������Ȃ��悤�ȏꏊ��";
		mes "�N�W�������ړ������邱�Ƃ�";
		mes "�\����B";
		next;
		mes "[��ȘV�l]";
		mes "������A�S�z����ȁB";
		next;
		mes "[��ȘV�l]";
		mes "������A";
		mes "�N�̗��ꂪ�����Ȃ����悤����ȁB";
		mes "�ǂ��������̂��ˁH";
		next;
		if(select("���������l���Ă݂܂�","���̊y���݂��Ă���܂��񂩁H") == 1) {
			mes "[��ȘV�l]";
			mes "�������B�l���Ă݂�Ƃ悢�B";
			mes "�l���ɍl�����d�˂�ƁA";
			mes "�����ǂ����@��";
			mes "�����邩�������B";
			mes "�ǂ����Ă��킩��Ȃ����";
			mes "�l�ɕ����̂��悢���B";
			close;
		}
		soundeffect "mos_gusli1.wav",0;
		mes "-�V�l�͖ڂ��ނ�A";
		mes "�@�y�����Ɏ����";
		mes "�@�e���n�߂�-";
		next;
		mes "[��ȘV�l]";
		mes "���̊y��͂��̈�����Ȃ��̂���B";
		mes "������N�ɑ݂��Ă��܂���";
		mes "���̃N�W�����𓮂����Ȃ�";
		mes "�Ȃ��Ă��܂��񂶂��B";
		next;
		mes "[��ȘV�l]";
		mes "�ӂށA�ǂ����悤���̂��c�c";
		next;
		mes "[��ȘV�l]";
		mes "�c�c";
		next;
		mes "[��ȘV�l]";
		mes "��������I�@�������悤�B";
		next;
		mes "[��ȘV�l]";
		mes "���͂ȁA�킵���g���Ă��邱�̊y���";
		mes "�����Â��Ȃ��Ă��܂��ĂȁB";
		mes "���̂̕��������茸����";
		mes "���܂��Ă���񂶂�B";
		mes "��������������������";
		mes "���Ă��܂����������B";
		next;
		mes "[��ȘV�l]";
		mes "�����ł���A���̊y���";
		mes "�V������邽�߂̍ޗ���";
		mes "�W�߂Ă��ė~�����񂶂�B";
		next;
		mes "[��ȘV�l]";
		mes "�ޗ��������";
		mes "�킵���V�����N�̕��Ƃ킵�̕���";
		mes "�y�����낤�B";
		next;
		mes "[��ȘV�l]";
		mes "�N�͊y�����ɓ������B";
		mes "���łɂ킵���V�����y�킪��ɓ���B";
		next;
		mes "[��ȘV�l]";
		mes "�ʓ|�������Ă��܂����A";
		mes "�ō��̊y���";
		mes "��邱�Ƃ�񑩂��邼�B";
		next;
		mes "[��ȘV�l]";
		mes "�ޗ��́A^3131FF�ۑ� 30�A";
		mes "��v�Ȗ� 20�A";
		mes "�R�r�̊p 20�A";
		mes "���b�R�̖є� 10��^000000���K�v����B";
		next;
		mes "[��ȘV�l]";
		mes "�N���ޗ��������ė��鎞�܂ł́A";
		mes "�N���܂������ɗ����悤��";
		mes "�N�W�������ړ��������A";
		mes "���̏ꏊ�ɂƂǂ܂点�Ă������B";
		next;
		mes "[��ȘV�l]";
		mes "����ł́A���ɖ߂鏀����";
		mes "�o������A�܂��b�������ė~�����B";
		set MOSK_1QUE,31;
		close;
	case 31:
		mes "[��ȘV�l]";
		mes "���n�ɖ߂�̂����H";
		next;
		if(select("�ޗ���������x�����Ă�������","���n�ɖ߂�") == 1) {
			mes "[��ȘV�l]";
			mes "�K�v�ȍޗ��́A";
			next;
			mes "[��ȘV�l]";
			mes "^3131FF�ۑ� 30�A";
			mes "��v�Ȗ� 20�A";
			mes "�R�r�̊p 20�A";
			mes "���b�R�̖є� 10��^000000����B";
			close;
		}
		mes "[��ȘV�l]";
		mes "����A����͌N�̒��Ԃ̑D��";
		mes "���n�ɖ߂�̂��B";
		next;
		mes "[��ȘV�l]";
		mes "�C�����Ă������悢�B";
		next;
		mes "-" +strcharinfo(0)+ "�́A";
		mes "�@�C���m�t�̑D�Ɏ��U�����B";
		mes "�@�C���m�t�̑D���߂Â��Ă���-";
		set MOSK_1QUE,32;
		close2;
		warp "moscovia",162,56;
		end;
	case 33:
		mes "[��ȘV�l]";
		mes "�ق��c�c�ޗ���";
		mes "�S���W�߂��̂��H";
		next;
		if(countitem(7201) >= 30 && countitem(7197) >= 20 && countitem(7106) >= 20 && countitem(7065) >= 10) {
			delitem 7201,30;
			delitem 7197,20;
			delitem 7106,20;
			delitem 7065,10;
			set MOSK_1QUE,34;
			mes "[��ȘV�l]";
			mes "�ǂ����̂�I��ŏW�߂�";
			mes "���Ă��ꂽ�ȁI���肪�Ƃ��I";
			next;
			mes "[��ȘV�l]";
			mes "�y�킪��������܂ŁA";
			mes "�����҂��Ă���I";
			close;
		}
		mes "[��ȘV�l]";
		mes "�ӂށc�c�ޗ�������Ȃ��ȁc�c";
		mes "^3131FF�ۑ� 30�A";
		mes "��v�Ȗ� 20�A";
		mes "�R�r�̊p 20�A";
		mes "���b�R�̖є� 10��^000000��";
		mes "�K�v����B";
		next;
		mes "[��ȘV�l]";
		mes "�ǂ����邩�ˁH";
		mes "������x�A�ޗ����W�߂�";
		mes "���n�ɖ߂邩�H";
		next;
		if(select("�ޗ���������x�����Ă�������","���n�ɖ߂�") == 1) {
			mes "[��ȘV�l]";
			mes "�K�v�ȍޗ��́A";
			mes "^3131FF�ۑ� 30�A";
			mes "��v�Ȗ� 20�A";
			mes "�R�r�̊p 20�A";
			mes "���b�R�̖є� 10��^000000����B";
			close;
		}
		mes "[��ȘV�l]";
		mes "�C�����Ă������悢�B";
		next;
		mes "-" +strcharinfo(0)+ "�́A";
		mes "�@�C���m�t�̑D�Ɏ��U�����B";
		mes "�@�C���m�t�̑D���߂Â��Ă���-";
		next;
		soundeffect "mos_gusli1.wav",0;
		mes "[��ȘV�l]";
		mes "�C�����Ă������悢�B";
		mes " ";
		mes "-�V�l�͊y���e����-";
		close2;
		warp "moscovia",162,56;
		end;
	case 34:
		if(rand(3)) {
			mes "[��ȘV�l]";
			mes "�܂��A�������ĂȂ��񂶂�B";
			mes "���������A�҂��ĂĂ���B";
			close;
		}
		mes "[��ȘV�l]";
		mes "�����A�y�킪���������I";
		mes "���ꂪ�N�̕����B";
		set MOSK_1QUE,35;
		getitem 2707,1;
		next;
		mes "[��ȘV�l]";
		mes "���̊y���^FF0000�u�O�X���v^000000��";
		mes "�Ă΂����̂��B";
		mes "���X�R�r�A�̒n��";
		mes "�y�������̂ɏZ��ł�����c�B��";
		mes "�g���Ă����`���y��Ȃ񂶂�B";
		next;
		mes "[��ȘV�l]";
		mes "���̊y��̍Ō�̓`���҂�";
		mes "���̂킵����B";
		mes "���ƂȂ��ẮA���̏�ł�";
		mes "���̊y������邱�Ƃ�";
		mes "�ł��Ȃ�����낤�B";
		next;
		mes "[��ȘV�l]";
		mes "���̊y���������΁A";
		mes "�����M���Ă���邶��낤�B";
		next;
	case 35:
		mes "[��ȘV�l]";
		mes "�����A���ꂩ��";
		mes "�N�͂ǂ����邩�ˁH";
		next;
		switch(select("�܂��A�N�W�����ɗ�����@�́H","�O�X���������āI","���ɖ߂�")){
		case 1:
			mes "[��ȘV�l]";
			mes "�܂��N�W�����ɗ��������";
			mes "���X�R�r�A�̑D�����";
			mes "�O�X����e�����悢�B";
			next;
			mes "[��ȘV�l]";
			mes "�y����K���ĂȂ��N�ł�";
			mes "���t�͖�������낤���A";
			mes "�����炢�o���邶���H";
			next;
			mes "[��ȘV�l]";
			mes "���̓��A";
			mes "����A���̃N�W����";
			mes "�O�X���̉���";
			mes "�q���ɔ�������񂶂�B";
			next;
			mes "[��ȘV�l]";
			mes "�N���O�X����e���΁A";
			mes "�킵�Ƃ��̓��́A";
			mes "�}���ɍs�����B";
			next;
			mes "[��ȘV�l]";
			mes "�������A�l�Ɍ����Ă��܂�";
			mes "�����ꂽ���Ȃ��񂶂�B";
			mes "�l�����Ȃ����ȏꏊ����";
			mes "�N���悹�邼�B";
			close;
		case 2:
			mes "[��ȘV�l]";
			mes "�O�X�����K�������̂��B";
			next;
			mes "[��ȘV�l]";
			mes "�O�X���̉��t�ɋ�����";
			mes "�����Ă���Ċ��������B";
			next;
			mes "[��ȘV�l]";
			mes "���ŋ��������Ă��炤���B";
			next;
			mes "[��ȘV�l]";
			mes "�O�X���𑕔����Ă���";
			mes "�킵�ɘb�������Ă���B";
			set MOSK_1QUE,36;
			close;
		case 3:
			mes "[��ȘV�l]";
			mes "�܂��N�W�����ɗ��������";
			mes "���X�R�r�A�̑D�����";
			mes "�O�X����e�����悢�B";
			next;
			mes "[��ȘV�l]";
			mes "�y����K���ĂȂ��N�ł�";
			mes "���t�͖�������낤���A";
			mes "�����炢�o���邶���H";
			next;
			mes "[��ȘV�l]";
			mes "���̓��A";
			mes "����A���̃N�W����";
			mes "�O�X���̉���";
			mes "�q���ɔ�������񂶂�B";
			next;
			mes "[��ȘV�l]";
			mes "�N���O�X����e���΁A";
			mes "�킵�Ƃ��̓��́A";
			mes "�}���ɍs�����B";
			next;
			mes "[��ȘV�l]";
			mes "�������A�l�Ɍ����Ă��܂�";
			mes "�����ꂽ���Ȃ��񂶂�B";
			mes "�l�����Ȃ����ȏꏊ����";
			mes "�N���悹�邼�B";
			next;
			mes "[��ȘV�l]";
			mes "�C�����Ă������悢�B";
			next;
			mes "-" +strcharinfo(0)+ "�́A";
			mes "�@�C���m�t�̑D�Ɏ��U�����B";
			mes "�@�C���m�t�̑D���߂Â��Ă���-";
			next;
			soundeffect "mos_gusli1.wav",0;
			mes "[��ȘV�l]";
			mes "�C�����Ă������悢�B";
			mes " ";
			mes "-�V�l�͊y���e����-";
			close2;
			warp "moscovia",162,56;
			end;
		}
	case 36:
		mes "[��ȘV�l]";
		mes "�O�X�����K�������͏o�������ȁH";
		mes "�������Ă��痈�Ȃ����B";
		next;
		if(equippeditem(2707) == 0){
			mes "[��ȘV�l]";
			mes "�ӂށc�c";
			mes "�y��������ĂȂ��Ă�";
			mes "���t���ł���ȁB";
			next;
			mes "[��ȘV�l]";
			mes "�O�X����������";
			mes "�������Ȃ����B";
			close;
		}
		mes "[��ȘV�l]";
		mes "�悵�A�������o�����悤����ȁB";
		mes "�킵�̉��t�𕷂�����A";
		mes "�������܂˂��Ă݂Ȃ����B";
		next;
		soundeffect "mos_gusli1.wav",0;
		mes "[��ȘV�l]";
		mes "�ŏ����炤�܂��͏o���Ȃ�����A";
		mes "�ł炸�ɁA��������";
		mes "�킵�̉��t�𕷂��āA�����";
		mes "����Ă݂Ȃ����B";
		next;
		if(getbaseclass(Class,2) == CLASS_BA) {
			emotion 21;
			mes "[��ȘV�l]";
			mes "�ق��c�c";
			mes "�����r�����Ă���c�c";
			next;
			mes "[��ȘV�l]";
			mes "�������c�c";
			mes "�嗤�ł͊y������t��";
			mes "�̂��S���`���ҒB�������";
			mes "���������c�c";
			mes "�N����������";
			mes "�`���҂Ȃ񂾂ˁH";
			next;
			mes "[��ȘV�l]";
			mes "�N�Ȃ�A�����ɏ�B�o����������B";
			mes "�N�̉��t�����Ɋy���݂��B";
			next;
			mes "[��ȘV�l]";
			mes "�����A���x�͌N���e���Ă݂Ȃ����B";
			mes "�������A�킵�����t����";
			mes "�t���[�Y�����̂܂�";
			mes "���t����΂����B";
			set .@rand,3;
			break;
		}
		mes "[��ȘV�l]";
		mes "�����A���x�͌N���e���Č��Ȃ����I";
		mes "�킵�����t�����t���[�Y��";
		mes "���̂܂܉��t����΂����B";
		set .@rand,6;
		break;
	case 37:
		mes "[��ȘV�l]";
		mes "�O�X���̗��K�����鏀���͏o�������ȁH";
		mes "���X�A��B���Ȃ��Ă�";
		mes "������߂Ă͂����Ȃ����B";
		mes "^FF0000�ł���܂ŉ��x�ł�";
		mes "���K����݂̂���B^000000";
		next;
		if(equippeditem(2707) == 0){
			mes "[��ȘV�l]";
			mes "�ӂށc�c";
			mes "�y��������ĂȂ��Ă�";
			mes "���t���ł���ȁB";
			next;
			mes "[��ȘV�l]";
			mes "�O�X����������";
			mes "�������Ȃ����B";
			close;
		}
		mes "[��ȘV�l]";
		mes "�ӂށc�c�����͂����悤����́I";
		next;
		if(getbaseclass(Class,2) == CLASS_BA) {
			mes "[��ȘV�l]";
			mes "�N�̍˔\�Ȃ�A���x��";
			mes "���܂��s���͂����I�撣��!!";
			set .@rand,3;
			next;
		}
		else
			set .@rand,6;
		mes "[��ȘV�l]";
		mes "�����A�e���Ă݂Ȃ����B";
		mes "�����قǁA�킵���e�����t���[�Y��";
		mes "�e���΂悢�񂾂�B";
		break;
	case 38:
		mes "[��ȘV�l]";
		mes "�����A���ꂩ��N��";
		mes "�ǂ�������肩�ˁH";
		next;
		if(select("�N�W�����ɂ܂�������@�́H","���n�ɖ߂�") == 1) {
			mes "[��ȘV�l]";
			mes "�܂��N�W�����ɗ��������";
			mes "���X�R�r�A�̑D�����";
			mes "�O�X����e�����悢�B";
			next;
			mes "[��ȘV�l]";
			mes "���̓��A";
			mes "����A���̃N�W����";
			mes "�O�X���̉���";
			mes "�q���ɔ�������񂶂�B";
			next;
			mes "[��ȘV�l]";
			mes "�N���O�X����e���΁A";
			mes "�킵�Ƃ��̓��́A";
			mes "�}���ɍs�����B";
			next;
			mes "[��ȘV�l]";
			mes "�������A�l�Ɍ����Ă��܂�";
			mes "�����ꂽ���Ȃ��񂶂�B";
			mes "�l�����Ȃ����ȏꏊ����";
			mes "�N���悹�邼�B";
			close;
		}
		mes "[��ȘV�l]";
		mes "�܂��N�W�����ɗ��������";
		mes "���X�R�r�A�̑D�����";
		mes "�O�X����e�����悢�B";
		next;
		mes "[��ȘV�l]";
		mes "���̓��A";
		mes "����A���̃N�W����";
		mes "�O�X���̉���";
		mes "�q���ɔ�������񂶂�B";
		next;
		mes "[��ȘV�l]";
		mes "�N���O�X����e���΁A";
		mes "�킵�Ƃ��̓��́A";
		mes "�}���ɍs�����B";
		next;
		mes "[��ȘV�l]";
		mes "�������A�l�Ɍ����Ă��܂�";
		mes "�����ꂽ���Ȃ��񂶂�B";
		mes "�l�����Ȃ����ȏꏊ����";
		mes "�N���悹�邼�B";
		next;
		mes "[��ȘV�l]";
		mes "�ł́A";
		mes "�C�����Ė߂邪�悢�B";
		close2;
		warp "moscovia",162,56;
		end;
	case 39:
	case 40:
	case 41:
		mes "[��ȘV�l]";
		mes "�N�W�����ւ悤�����B";
		mes "������肵�Ă����Ȃ����B";
		next;
		switch(select("�N�W������������","���n�ɖ߂�","���J�̓���T��������")) {
		case 1:
			mes "[��ȘV�l]";
			mes "�������A";
			mes "�D���Ɍ��Ă܂��Ȃ����B";
			mes "����ȍL���͂Ȃ����ȁB";
			close;
		case 2:
			mes "[��ȘV�l]";
			mes "�킩�����B";
			mes "���ł��V�тɗ��Ȃ����B";
			next;
			soundeffect "mos_gusli1.wav",0;
			mes "-�V�l�͖ڂ��ނ�A";
			mes "�@��Ɏ����Ă���y���";
			mes "�@�e���n�߂�-";
			close2;
			warp "moscovia",162,56;
			end;
		case 3:
			mes "[��ȘV�l]";
			mes "�ق��c�c";
			next;
			mes "[��ȘV�l]";
			mes "���X�R�r�A�̎��ӂɂ�";
			mes "�l�X���K��鎖���Ȃ�";
			mes "���J�̓����������񂠂�񂶂��B";
			next;
			mes "[��ȘV�l]";
			mes "���ʂ̑D�ł́A";
			mes "���X�s���Ȃ��ꏊ����B";
			mes "���̖��J�̓��ɑ����Ă������邪�A";
			mes "�s���Ă݂邩�ˁH";
			next;
			if(select("���������l���Ă݂�","�͂��A�����Ă�������") == 1) {
				mes "[��ȘV�l]";
				mes "�������c�c�B";
				mes "�������l���Ă݂Ȃ����B";
				close;
			}
			mes "[��ȘV�l]";
			mes "���ށA";
			mes "�ł͑��낤�B";
			next;
			mes "[��ȘV�l]";
			mes "�߂鎞�́A";
			mes "�킵�̑D��݂��Ă����邩��A";
			mes "����ł��̃N�W�����܂�";
			mes "�߂��Ă��邪�悢�B";
			next;
			mes "[��ȘV�l]";
			mes "�킵�͌N���`�����Ă���ԁA";
			mes "���ނ�ł����đ҂��Ă����B";
			next;
			soundeffect "mos_gusli1.wav",0;
			mes "-�V�l�͖ڂ��ނ�A";
			mes "�@��Ɏ����Ă���y���";
			mes "�@�e���n�߂�-";
			close2;
			warp "mosk_fild02",204,54;
			end;
		}
	default:	//������
		mes "[��ȘV�l]";
		mes "�N�W�����ւ悤�����B";
		mes "������肵�Ă����Ȃ����B";
		next;
		if(select("�N�W������������","���n�ɖ߂�") == 1) {
			mes "[��ȘV�l]";
			mes "�������A";
			mes "�D���Ɍ��Ă܂��Ȃ����B";
			mes "����ȍL���͂Ȃ����ȁB";
			close;
		}
		mes "[��ȘV�l]";
		mes "�킩�����B";
		mes "���ł��V�тɗ��Ȃ����B";
		next;
		soundeffect "mos_gusli1.wav",0;
		mes "-�V�l�͖ڂ��ނ�A";
		mes "�@��Ɏ����Ă���y���";
		mes "�@�e���n�߂�-";
		close2;
		warp "moscovia",162,56;
		end;
	}
	//���t���K����
	next;
	if(rand(.@rand)) {
		mes "[��ȘV�l]";
		mes "�ӂށc�c�����Ⴄ�ȁc�c";
		mes "�����̒e�������ȁc�c";
		mes "�����A���x�͏W������";
		mes "�e���Ă݂Ȃ����B";
		next;
		mes "[��ȘV�l]";
		mes "�����ށA�����������K���K�v���ȁB";
		mes "�����x�ނ��B";
		mes "�N�̏������ł�����";
		mes "�܂����K���ĊJ���悤�B";
		set MOSK_1QUE,37;
		close;
	}
	soundeffect "mos_gusli1.wav",0;
	emotion 21;
	misceffect 7,"";
	mes "[��ȘV�l]";
	mes "�ق��c�c";
	mes "�����r�����Ă���c�c";
	next;
	mes "[��ȘV�l]";
	mes "�����A�킵���N�ɋ�����K�v�͂Ȃ��B";
	mes "�N�Ȃ�A��l�ŗ��K���d�˂�΁A";
	mes "���ꂾ���ł����ɂȂ��͂��B";
	next;
	mes "[��ȘV�l]";
	mes "����Ȃɑ�����B����ẮA";
	mes "�킵���������Ƃ�";
	mes "�����Ȃ��ȁB�ӂӂӁB";
	next;
	mes "[��ȘV�l]";
	mes "�N�̘r�Ȃ�A�F�𖣗�����";
	mes "���t���o����͂�����B";
	set MOSK_1QUE,38;
	close;
}

mosk_in,127,89,3	script	������b �h�~�g���[	967,{
	switch(MOSK_3QUE) {
	case 12:
	case 13:
		mes "[������b �h�~�g���[]";
		mes "�N�ɂ͔��t�̋^�����|�����Ă���B";
		mes "�����̍s�����������A";
		mes "�����e�^�������悤��";
		mes "�������ؖ����鎖�ɏW�����Ȃ����I";
		close;
	case 14:
		mes "[������b �h�~�g���[]";
		mes "���t�̋^�������ꂽ�����ŁA";
		mes "�N�̎������S�ɐM�p���Ă���";
		mes "�킯�ł͂Ȃ��B";
		close;
	case 20:
		mes "[������b �h�~�g���[]";
		mes "�N�̎��͂悭�m���Ă���B";
		mes "���́A�N�ɂ���";
		mes "���������Ă����񂾁B";
		next;
		mes "[������b �h�~�g���[]";
		mes "�N���A���{�̒����̍L���";
		mes "�����s�v�c�ȍs����������";
		mes "�񍐂������Ă���A�w�ҒB��";
		mes "�V�C�̌������������̂��B";
		next;
		mes "[������b �h�~�g���[]";
		mes "�V�C���ϑ����Ă݂�ƁA";
		mes "�Œ�C���ƍō��C���̍����k�܂�A";
		mes "���̒������L�тĂ����";
		mes "�񍐂��������B�ǂ�����ĉĂ�";
		mes "���߂����͉���Ȃ����c�c";
		mes "�����͔F�߂鎖�ɂ����B";
		next;
		mes "[������b �h�~�g���[]";
		mes "�`���[���l�ɂ͕񍐂��Ă���B";
		mes "���ꂩ��A�`���[���l�ɉy�����Ȃ����B";
		close;
	default:
		break;
	}
	switch(MOSK_1QUE) {
	case 16:
		mes "[������b �h�~�g���[]";
		mes "���{�ɂ͉��̗p���ȁH";
		next;
		if(select("���{���������ł�","�`���[���l�ɉy���������ł�") == 1) {
			mes "[������b �h�~�g���[]";
			mes "�䂪���X�R�r�A�́A�N�̂悤��";
			mes "�Ⴂ�`���҂����}����B";
			next;
			mes "[������b �h�~�g���[]";
			mes "�������A";
			mes "�`���[���l�Ɏ��炪�Ȃ��悤��";
			mes "�C�����ė~�����B";
			next;
			mes "[������b �h�~�g���[]";
			mes "�`���[���l�͖ʔ����`���b��";
			mes "�D��ł�������B";
			mes "�����b������������������A";
			mes "�܂����邪�悢�B";
			close;
		}
		mes "[������b �h�~�g���[]";
		mes "�É��ɉy���������̂��H";
		mes "�p���͉����ˁH";
		next;
		if(select("���A","�N�W�����̖`���b") == 1) {
			mes "[������b �h�~�g���[]";
			mes "���A�Ȃ�A��������B";
			mes "�����킴�킴�`���[���l��";
			mes "���ڌ����K�v�͂Ȃ��B";
			close;
		}
		mes "[������b �h�~�g���[]";
		mes "�ق��c�c�H";
		mes "�`���b�I";
		mes "���������̓������̘b���I";
		mes "�`���[���l�������ƁA";
		mes "����тɂȂ邾�낤�I";
		next;
		mes "[������b �h�~�g���[]";
		mes "�y�����������B";
		mes "�`���[���l����������悤�Șb��";
		mes "����΁A�傫�ȖJ�܂�^���悤�B";
		set MOSK_1QUE,17;
		close;
	case 17:
		mes "[������b �h�~�g���[]";
		mes "�`���[���l�ɂ͂��`�������B";
		mes "�`���[���l�ɐ\�����悢�B";
		close;
	case 35:
	case 38:
		mes "[������b �h�~�g���[]";
		mes "�����Ƀ`���[���l��";
		mes "�y�����Ȃ����B";
		close;
	case 39:
		mes "[������b �h�~�g���[]";
		mes "�{���ɂЂǂ����t�������B";
		mes "��x�ƕ��������Ȃ��ȁB";
		close;
	case 40:
		mes "[������b �h�~�g���[]";
		mes "�ǂ������̂��ˁH";
		mes "�`���[���l�͂��x�ݒ����B";
		mes "���ʂȗp���ł͂Ȃ��Ȃ�A";
		mes "�������Ă���B";
		close;
	case 41:
		mes "[������b �h�~�g���[]";
		mes "�N�̃O�X�����t�͖{����";
		mes "�����I�������ˁc�c";
		mes "���ł��ǂ�����A���̉��t��";
		mes "������x�������Ă���c�c";
		close;
	default:
		if(MOSK_1QUE < 16) {
			mes "[������b �h�~�g���[]";
			mes "�O���̖`���҂��B";
			mes "�����͍���";
			mes "�`���[���E�A���N�Z�C3���l";
			mes "�̉��{�ł���B";
			mes "���ꂮ������炪�Ȃ��悤��";
			mes "�C������悤�ɁB";
			close;
		}
		if(MOSK_1QUE > 17 && MOSK_1QUE < 35) {
			mes "[������b �h�~�g���[]";
			mes "�`���[���l�͋x�e�����B";
			mes "�N�̓N�W�����T���ɏW�����Ȃ����B";
			close;
		}
		mes "[������b �h�~�g���[]";
		mes "�O������̖`���҂��B�����́A";
		mes "�`���[���E�A���N�Z�C3���l";
		mes "�̂��鉤�{���B";
		mes "���炪�����悤�C�����邪�ǂ��B";
		close;
	}
}

mosk_in,131,92,3	script	�`���[���E�A���N�Z�C3��	965,7,7,{
	switch(MOSK_3QUE) {
	case 12:
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�N���o�o���K�ɉ���Ă���";
		mes "����ڌ������l�X��";
		mes "�����؂�Ȃ����ɂ���̂���B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�����Ɖ�����ł��A";
		mes "�߂ɖ����̂���";
		mes "�N���O�����痈���Ƃ�������";
		mes "�l���A���񂾂��N�ɕى��̋@���";
		mes "���Ă鎖�ɂ����B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�����v����������΁A";
		mes "�������b�����ǂ��B";
		next;
		menu "������������",-;
		mes "-�o�o���K�Ƙb��������";
		mes "�@����̌v��ɂ��Ęb����-";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�o�o���K�����̂悤�Ȍv����c�c";
		mes "�Ă��Ƃǂ߂閂�@���^���Ȃ�΁A";
		mes "��΂������Ƃ��B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�������A���̘b���N��";
		mes "�������ؖ��ł���؋��Ƃ�";
		mes "�Ȃ�Ȃ��B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�o�o���K�B��|���A�ޏ��炪";
		mes "�W�߂Ă���ƌ����o�o���K�̂��˂�";
		mes "�����ė�����A�N�̌�������";
		mes "�M���悤�ł͂Ȃ����B";
		next;
		if(countitem(7762) < 40) {
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "�g�̌������ؖ����邽�߂�";
			mes "�o�o���K�����o�o���K�̂��˂�40��";
			mes "�����ė��邪�悢�B";
			set MOSK_3QUE,13;
			close;
		}
		if(select("�o�o���K�̂��˂�������","�����Ƃ��Ă���") == 2) {
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "�g�̌������ؖ����邽�߂�";
			mes "�o�o���K�����o�o���K�̂��˂�40��";
			mes "�����ė��邪�悢�B";
			set MOSK_3QUE,13;
			close;
		}
		mes "[" +strcharinfo(0)+ "]";
		mes "�͂��A�����ɂ���܂��B";
		next;
		mes "-�o�o���K�̂��˂������-";
		delitem 7762,40;
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�����Ă������B";
		mes "�Ƃ肠�����A�b�̈ꕔ��";
		mes "�M���Ă����悤�B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�Ă��Ƃǂ߂邱�Ƃ�";
		mes "�ł���̂ł����";
		mes "�����͊�Ԃł��낤�B";
		mes "����͂킵�ɂ���΂��������B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�������A�ǂ�Ȃ��Ƃ������Ă�";
		mes "�o�o���K�̗͂��؂��Ȃ�";
		mes "��΂ɂ����Ă͂Ȃ�Ȃ����Ƃ��B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�����ł��B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�N�̎�ŉĂ��Ƃǂ߂�̂��B";
		mes "�o�o���K�̖��O��\�ɏo�����ɂȁB";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "���������āA�N��";
		mes "�o�o���K�̏��ɏo���肷�邱�Ƃ�";
		mes "���ʂɋ�����B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "���񂾂��B";
		set MOSK_3QUE,14;
		close;
	case 13:
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�o�o���K�����o�o���K�̂��˂�40��";
		mes "�����Ă����̂��H";
		next;
		if(select("�͂��A�����ɂ���܂�","���́c�c�Y�ꂿ�Ⴂ�܂���") == 2) {
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "�o�o���K�̎��o�o���K�̂��˂�40��";
			mes "�����ė���悤�ɂ�";
			mes "�킵�͌������͂����B";
			next;
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "�N�͂킵�̌��t�𖳎����Ă���̂��H";
			close;
		}
		if(countitem(7762) < 40) {
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "�o�o���K�̂��˂�����Ȃ��ł͂Ȃ����B";
			mes "�����Ԉ�����̂��H�@����Ƃ��A";
			mes "�킵�ɉR�������̂��H";
			next;
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "���񂾂��́A��k����";
			mes "�󂯎~�߂悤�B";
			close;
		}
		mes "-�o�o���K�̂��˂������-";
		delitem 7762,40;
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�����Ă������B";
		mes "�Ƃ肠�����A�b�̈ꕔ��";
		mes "�M���Ă����悤�B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�Ă��Ƃǂ߂邱�Ƃ�";
		mes "�ł���̂ł����";
		mes "�����͊�Ԃł��낤�B";
		mes "����͂킵�ɂ���΂��������B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�������A�ǂ�Ȃ��Ƃ������Ă�";
		mes "�o�o���K�̗͂��؂��Ȃ�";
		mes "��΂ɂ����Ă͂Ȃ�Ȃ����Ƃ��B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�����ł��B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�N�̎�ŉĂ��Ƃǂ߂�̂��B";
		mes "�o�o���K�̖��O��\�ɏo�����ɂȁB";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "���������āA�N��";
		mes "�o�o���K�̏��ɏo���肷�邱�Ƃ�";
		mes "���ʂɋ�����B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "���񂾂��B";
		set MOSK_3QUE,14;
		close;
	case 14:
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�Ă��i���Ƒ�������";
		mes "�����ׂ̈ɗǂ������B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�������A�o�o���K�����̗͂�";
		mes "����𐬂��Ă͂Ȃ�Ȃ��B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�N���s���̂��B";
		mes "�o�o���K�̖��O��\�ɏo�����ɂȁB";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�Ă��Ƃǂ߂����Ă���I";
		close;
	case 20:
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�����A�҂��Ă������I";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "���ɑ�b����A�񍐂𕷂����B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "���������ł���B";
		mes "�킵�͊��������肾�I";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�����ɑ����āA�킵���N��";
		mes "�J�܂��������悤�I";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�����A�󂯎��Ȃ����I";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�����A�Ă�";
		mes "�y����ł����������I";
		set MOSK_3QUE,21;
		getitem 603,1;
		if(checkre()) {
			for(set .@i,0;.@i<20;set .@i,.@i+1)
				getexp 5000,0;
			for(set .@i,0;.@i<6;set .@i,.@i+1)
				getexp 0,5000;
		}
		else {
			for(set .@i,0;.@i<20;set .@i,.@i+1)
				getexp 50000,0;
			for(set .@i,0;.@i<6;set .@i,.@i+1)
				getexp 0,50000;
		}
		close;
	default:
		break;
	}
	switch(MOSK_1QUE) {
	case 16:
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�O������̖`���҂�B";
		mes "�킵�ɐ\���������ł�����̂��H";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�厖�ȗp������Ȃ��̂Ȃ�A";
		mes "������b�ɉy����";
		mes "�\�������Ȃ����B";
		close;
	case 17:
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�ق��c�c";
		mes "�킵�ɖ`���b��";
		mes "�������Ă����̂��I";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�ǂ�Șb�𕷂����Ă����̂��H";
		next;
		mes "-�����ɃN�W�����ɂ��Ęb����-";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�Ȃ�ƁI";
		mes "���̓`���̓������𔭌�����";
		mes "�ƌ����̂��I";
		mes "�ڂ��������Ă݂������I";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�����A�����b�����܂��I";
		next;
		menu "�ڂ����b��",-;
		mes "�c�c";
		next;
		mes "�c�c�c�c";
		next;
		mes "�c�c�c�c�c�c";
		next;
		mes "�c�c�c�c�c�c�c�c";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�Ȃ�ƁA�N�W���Ƃ́I";
		mes "���ɖʔ����b�����c�c";
		mes "�ǂ��v�����ˁH������b�B";
		next;
		mes "[������b �h�~�g���[]";
		mes "�R�Ƃ͎v���܂��񂪁A";
		mes "���S�ɐM�p���鎖���o���܂���B";
		mes "�N�W�����ƂĂ��Ȃ��傫��������";
		mes "���鎖�͑����Ă���܂����A";
		mes "���̏�ɐ�������A�؂������A";
		mes "�l���Z�ނȂ�āc�c";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "���̒ʂ肾�B";
		mes "�킵�����܂ő����̖`���b��";
		mes "�����Ă������A";
		mes "�������ɐM�����Ȃ��̂��B";
		next;
		mes "[������b �h�~�g���[]";
		mes "�c�c�É��B";
		next;
		mes "[������b �h�~�g���[]";
		mes "�N�W�����ɂ����V�l��";
		mes "�e�����Ƃ����y���";
		mes "���Ȃ̂ł����c�c";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�ǂ������A��b�H";
		mes "�\���Ă݂�B";
		next;
		mes "[������b �h�~�g���[]";
		mes "�Â������ŁA���̊y���";
		mes "��v����y��̐�����";
		mes "�ǂ񂾂��Ƃ�����܂��B";
		next;
		mes "[������b �h�~�g���[]";
		mes "���͂������݂��Ȃ��A";
		mes "���āA���̃��X�R�r�A�̒n��";
		mes "�������Ƃ����`���y��ł��B";
		next;
		mes "[������b �h�~�g���[]";
		mes "�킪���ł��A���̊y���";
		mes "�m���Ă���҂͐����Ȃ��ł��傤�B";
		next;
		mes "[������b �h�~�g���[]";
		mes "�{���ł���΁A";
		mes "���̊O���̖`���҂�";
		mes "�m���Ă���킯������܂���B";
		next;
		mes "[������b �h�~�g���[]";
		mes "���Ȃ킿�A���̖`���҂�";
		mes "���ۂɂ��̊y��������A";
		mes "�ƍl���鎖���ł��܂��B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�����ށc�c";
		mes "�������A���ꂪ�N�W���̓���";
		mes "�s�����Ƃ����؋��ɂ͂Ȃ�܂��B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�`���҂�B";
		mes "�{���Ȃ�A�N�ɑ傫���J�܂�";
		mes "�����������̂����A";
		mes "���܂ʂ��N�̘b���ǂ����Ă�";
		mes "�M���邱�Ƃ��ł��Ȃ��̂��B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�悵�A�킵���N�W�����̑��݂�";
		mes "�M������悤�ȏ؋���������";
		mes "���Ă��炨���I";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "���̘V�l�������Ă����y���";
		mes "�����Ă���̂��B";
		mes "��������΁A�N�̘b��M����";
		mes "�J�܂��������悤�B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�����A���̏؋��������Ă��Ȃ��ꍇ�́A";
		mes "�킵�ɉR��t�����Ɣ��f���A";
		mes "���������I";
		next;
		mes "[������b �h�~�g���[]";
		mes "�ցA�É��c�c";
		next;
		mes "[������b �h�~�g���[]";
		mes "���̎�҂͂킪����";
		mes "�����ł͂���܂���B�É��ɑ΂�";
		mes "�s�h�ȑz��������Ƃ͎v���܂���B";
		mes "�É��̂������́c�c�������܂����A";
		mes "����������Ǝv���܂��c�c";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "����A���ɂ��̎�҂�";
		mes "�R��\���Ă���Ƃ��āA";
		mes "����������Ă��܂��ƁA";
		mes "���ꂩ�炱�̍���K��鑽����";
		mes "�`���҂ɂ킵�̈Ќ��������Ȃ��Ȃ�I";
		next;
		mes "[������b �h�~�g���[]";
		mes "�c�c�c�c�c�c";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�킩��ȁH";
		mes "�N�̐ӔC�͏d���I";
		mes "�����A���̃N�W�����̏؋���";
		mes "�����Ă��āA�킵�����S�����Ă���I";
		set MOSK_1QUE,18;
		close;
	case 35:
	case 38:
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�ق��A�߂��ė������H";
		mes "��̊y��͎����ė����񂾂ȁH";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�ӂށA���ł�";
		mes "�N�W�����ł�����ɓ���Ȃ�";
		mes "�O�X���Ƃ����y�킩�B";
		mes "����������̂��B";
		next;
		if(countitem(2707) < 1) {
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "�ǂ��������肩�ˁH";
			mes "�N�͊y��������Ă��Ȃ��ł͂Ȃ����B";
			next;
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "�y��������Ă��Ă���A";
			mes "�܂����ɘb�������Ȃ����B";
			close;
		}
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�ق��c�c���ꂪ�O�X�����B";
		mes "������b�I���̊y�킪�N��";
		mes "�����Ō����y��ƈ�v���Ă��邩�H";
		next;
		mes "[������b �h�~�g���[]";
		mes "���m�ɂ͂킩��܂��񂪁A";
		mes "���Ɏ��Ă���܂��B";
		mes "�����āA���݁A�킪���ɂ�";
		mes "���̊y��Ɏ����y��͂���܂���B";
		mes "�S���V�����y�킾�Ǝv���܂��B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�ق��c�c�Ȃ�قǁI";
		mes "�M����ɒl����ȁI";
		mes "���̊y��̉��t�͏o����̂��H";
		next;
		if(MOSK_1QUE == 38) {
			mes "[" +strcharinfo(0)+ "]";
			mes "�͂��B�N�W�����Ŋy����K����";
			mes "���܂����B";
			next;
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "�����A�������I";
			mes "����͊y���݂��ȁI";
			mes "�����e���Ă���B";
			next;
			soundeffect "mos_gusli2.wav",0;
			mes "-���t���n�߂�ƁA���{��";
			mes "�F���ڂ��ނ�A�O�X����";
			mes "���F�ɖ������Ă���-";
			next;
			emotion 28;
			emotion 28,"������b �h�~�g���[";
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "�����c�c";
			mes "���Ɣ������Ȃ��c�c";
			next;
			mes "[������b �h�~�g���[]";
			mes "�͂��c�c";
			next;
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "������A�����邼�c�c";
			mes "���X�R�r�A�̗Y��ȑ�n��!!";
			next;
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "���΂炵���c�c";
			mes "���΂炵�����I";
			next;
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "������b��I";
			next;
			mes "[������b �h�~�g���[]";
			mes "�͂��I";
			next;
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "���̖`���҂ɖJ�܂�";
			mes "�^���Ȃ���!!";
			next;
			mes "[������b �h�~�g���[]";
			mes "�J�܂͉���^�����";
			mes "�悢�ł��傤���H";
			next;
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "����͌N�ɔC���B";
			mes "�������A�f���炵�����y��";
			mes "�ʔ����`���b�𕷂����Ă��ꂽ";
			mes "�`���҂̋�J�ɑ�������";
			mes "�ō��̖J�܂�^���Ȃ����B";
			next;
			mes "[������b �h�~�g���[]";
			mes "�`���[���l���J�܂�^����B";
			next;
			mes "[������b �h�~�g���[]";
			mes "�S���N�Ɋ��ӂ���B";
			set MOSK_1QUE,41;
			getitem 617,1;
			if(checkre()) {
				for(set .@i,0;.@i<30;set .@i,.@i+1)
					getexp 5000,0;
				for(set .@i,0;.@i<10;set .@i,.@i+1)
					getexp 0,5000;
			}
			else {
				for(set .@i,0;.@i<30;set .@i,.@i+1)
					getexp 50000,0;
				for(set .@i,0;.@i<10;set .@i,.@i+1)
					getexp 0,50000;
			}
			close;
		}
		if(select("���t�ł���","���t�ł��Ȃ�") == 2) {
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "�ӂށc�c���F�������Ȃ��̂�";
			mes "���Ɏc�O�����A�d���Ȃ��B";
			mes "�N�̌�������M���悤�B";
			next;
			mes "[������b �h�~�g���[]";
			mes "������b�A���̖`���҂ɖJ�܂�";
			mes "�^���Ȃ����B";
			next;
			mes "[������b �h�~�g���[]";
			mes "�J�܂͉����X�����ł��傤���H";
			next;
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "������b�ɔC���B";
			mes "�킵�́A���ꂩ�班���x�ނƂ���B";
			next;
			mes "[������b �h�~�g���[]";
			mes "�`���[���l�̓O�X���̉��t��";
			mes "�������ɂȂ肽�������悤���ȁB";
			mes "���t�ł���΂����Ƒ����̖J�܂�";
			mes "�^�����̂����c�c";
			next;
			mes "[������b �h�~�g���[]";
			mes "����ł͖J�܂��󂯎��Ȃ����B";
			next;
			mes "[������b �h�~�g���[]";
			mes "�������Ă悢���B";
			set MOSK_1QUE,40;
			getitem 603,1;
			if(checkre()) {
				for(set .@i,0;.@i<20;set .@i,.@i+1)
					getexp 5000,0;
				for(set .@i,0;.@i<6;set .@i,.@i+1)
					getexp 0,5000;
			}
			else {
				for(set .@i,0;.@i<20;set .@i,.@i+1)
					getexp 50000,0;
				for(set .@i,0;.@i<6;set .@i,.@i+1)
					getexp 0,50000;
			}
			close;
		}
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "���t���ł���̂��I";
		mes "�Ȃ�΁A�������e���Ă���B";
		mes "���F�𒮂��������B";
		next;
		emotion 6;
		emotion 6,"������b �h�~�g���[";
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "����́A�����ˁH";
		mes "�킵�����炩���Ă���̂��H";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "���܂�ɂЂǂ����t���B";
		mes "�����Ɍx�����͋��Ȃ���!!";
		next;
		mes "[������b �h�~�g���[]";
		mes "�É��I";
		next;
		mes "[������b �h�~�g���[]";
		mes "���������Ă��������B";
		mes "�O�����痈���`���҂ɁA";
		mes "���̂悤�Ȏ��œ{���\���Ɓc�c";
		mes "�É��̈Ќ��ɋ����܂��c�c";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�c�c";
		mes "�ӂށA�m���ɑ�b�̌����Ƃ��肾�B";
		next;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "���܂�Ɋ��҂𗠐؂�ꂽ�̂�";
		mes "�{���}����Ȃ������c�c";
		mes "���̖`���҂ɓK�؂ȖJ�܂�^��";
		mes "�A�点�Ȃ����I";
		next;
		mes "[������b �h�~�g���[]";
		mes "�فA�J�܂͉���^�����";
		mes "��낵���ł��傤���H";
		next;
		emotion 32;
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "������b�ɔC���B";
		mes "���̉��t�𒮂���";
		mes "�����ɂ��Ȃ����c�c";
		next;
		mes "[������b �h�~�g���[]";
		mes "�`���[���l�̊��傳��";
		mes "���ӂ��邪�ǂ��B";
		next;
		mes "[������b �h�~�g���[]";
		mes "���܂ł̋�J���l���āA";
		mes "�킸�������A�J�܂���������B";
		mes "�����邪�����B";
		next;
		mes "[������b �h�~�g���[]";
		mes "�����邪�����B";
		set MOSK_1QUE,39;
		getitem 603,1;
		if(checkre()) {
			for(set .@i,0;.@i<10;set .@i,.@i+1)
				getexp 5000,0;
			for(set .@i,0;.@i<2;set .@i,.@i+1)
				getexp 0,5000;
		}
		else {
			for(set .@i,0;.@i<10;set .@i,.@i+1)
				getexp 50000,0;
			for(set .@i,0;.@i<2;set .@i,.@i+1)
				getexp 0,50000;
		}
		close;
	case 39:
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�p���������Ȃ�A������Ȃ����B";
		close;
	case 40:
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�����A�O�X���������Ă����`���҂��I";
		mes "���������������Ă��ꂽ���Ƃ�";
		mes "����������B";
		close;
	case 41:
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�N��!!";
		mes "�悭���Ă��ꂽ�ȁB";
		mes "���̃O�X���̉��t��";
		mes "���΂炵�������B";
		mes "�܂��@�����΃O�X���̉��t��";
		mes "���ė~�������̂���B";
		close;
	default:
		if(MOSK_1QUE < 16) {
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "���X�R�r�A�ɂ悤�����B";
			mes "�킵�͂����̍����ł���";
			mes "�`���[���E�A���N�Z�C3�����B";
			next;
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "�N�̌̋��ɖ߂�����A";
			mes "���̃��X�R�r�A�̔�������";
			mes "���h�ȓ����҂̎����F��";
			mes "�`���Ă���B";
			close;
		}
		if(MOSK_1QUE > 17 && MOSK_1QUE < 35) {
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "�킵�͔�ꂽ�B";
			mes "���ꂩ��x�e�����B";
			mes "�N�̓N�W�����̏؋�����鎖��";
			mes "�W�����邪�ǂ��B";
			next;
			mes "[�`���[���E�A���N�Z�C3��]";
			mes "�N�W�����ɂ����Ƃ���";
			mes "�V�l�������Ă����y���";
			mes "�����Ă���̂��B";
			mes "��������΁A�N�̘b��M����";
			mes "�J�܂��������悤�B";
			close;
		}
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "���X�R�r�A�ɂ悤�����I";
		mes "�킵�́A������";
		mes "�A���N�Z�C 3�����I";
		close;
	}
OnTouch:
	if(MOSK_3QUE != 12)
		end;
	mes "[�`���[���E�A���N�Z�C3��]";
	mes "�N���o�o���K�ɉ���Ă���";
	mes "����ڌ������l�X��";
	mes "�����؂�Ȃ����ɂ���̂���B";
	next;
	mes "[�`���[���E�A���N�Z�C3��]";
	mes "�����Ɖ�����ł��A";
	mes "�߂ɖ����̂���";
	mes "�N���O�����痈���Ƃ�������";
	mes "�l���A���񂾂��N�ɕى��̋@���";
	mes "���Ă鎖�ɂ����B";
	next;
	mes "[�`���[���E�A���N�Z�C3��]";
	mes "�����v����������΁A";
	mes "�������b�����ǂ��B";
	next;
	menu "������������",-;
	mes "-�o�o���K�Ƙb��������";
	mes "�@����̌v��ɂ��Ęb����-";
	next;
	mes "[�`���[���E�A���N�Z�C3��]";
	mes "�o�o���K�����̂悤�Ȍv����c�c";
	mes "�Ă��Ƃǂ߂閂�@���^���Ȃ�΁A";
	mes "��΂������Ƃ��B";
	next;
	mes "[�`���[���E�A���N�Z�C3��]";
	mes "�������A���̘b���N��";
	mes "�������ؖ��ł���؋��Ƃ�";
	mes "�Ȃ�Ȃ��B";
	next;
	mes "[�`���[���E�A���N�Z�C3��]";
	mes "�o�o���K�B��|���A�ޏ��炪";
	mes "�W�߂Ă���ƌ����o�o���K�̂��˂�";
	mes "�����ė�����A�N�̌�������";
	mes "�M���悤�ł͂Ȃ����B";
	next;
	if(countitem(7762) < 40) {
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�g�̌������ؖ����邽�߂�";
		mes "�o�o���K�����o�o���K�̂��˂�40��";
		mes "�����ė��邪�悢�B";
		set MOSK_3QUE,13;
		close;
	}
	if(select("�o�o���K�̂��˂�������","�����Ƃ��Ă���") == 2) {
		mes "[�`���[���E�A���N�Z�C3��]";
		mes "�g�̌������ؖ����邽�߂�";
		mes "�o�o���K�����o�o���K�̂��˂�40��";
		mes "�����ė��邪�悢�B";
		set MOSK_3QUE,13;
		close;
	}
	mes "[" +strcharinfo(0)+ "]";
	mes "�͂��A�����ɂ���܂��B";
	next;
	mes "-�o�o���K�̂��˂������-";
	delitem 7762,40;
	next;
	mes "[�`���[���E�A���N�Z�C3��]";
	mes "�����Ă������B";
	mes "�Ƃ肠�����A�b�̈ꕔ��";
	mes "�M���Ă����悤�B";
	next;
	mes "[�`���[���E�A���N�Z�C3��]";
	mes "�Ă��Ƃǂ߂邱�Ƃ�";
	mes "�ł���̂ł����";
	mes "�����͊�Ԃł��낤�B";
	mes "����͂킵�ɂ���΂��������B";
	next;
	mes "[�`���[���E�A���N�Z�C3��]";
	mes "�������A�ǂ�Ȃ��Ƃ������Ă�";
	mes "�o�o���K�̗͂��؂��Ȃ�";
	mes "��΂ɂ����Ă͂Ȃ�Ȃ����Ƃ��B";
	next;
	mes "[�`���[���E�A���N�Z�C3��]";
	mes "�����ł��B";
	next;
	mes "[�`���[���E�A���N�Z�C3��]";
	mes "�N�̎�ŉĂ��Ƃǂ߂�̂��B";
	mes "�o�o���K�̖��O��\�ɏo�����ɂȁB";
	next;
	mes "[�`���[���E�A���N�Z�C3��]";
	mes "���������āA�N��";
	mes "�o�o���K�̏��ɏo���肷�邱�Ƃ�";
	mes "���ʂɋ�����B";
	next;
	mes "[�`���[���E�A���N�Z�C3��]";
	mes "���񂾂��B";
	set MOSK_3QUE,14;
	close;
}

moscovia,136,46,0	script	�V��#mosk	139,4,4,{
	if(MOSK_1QUE < 35 || MOSK_1QUE > 41)
		end;
	mes "-�O�X����e����";
	mes "�@�N�W�����ɍs����-";
	next;
	if(select("�N�W�����ɍs��","��߂�") == 2) {
		mes "[" +strcharinfo(0)+ "]";
		mes "�i���͎~�߂Ă������B�j";
		close;
	}
	if(equippeditem(2707) == 0) {
		mes "[" +strcharinfo(0)+ "]";
		mes "�i�O�X���𑕔����Ȃ��ƒe���Ȃ��B";
		mes "�@�O�X���𑕔����悤�B�j";
		close;
	}
	soundeffect "mos_gusli2.wav",0;
	mes "-" +strcharinfo(0)+ "��";
	mes "�@�O�X������Ɏ��A";
	mes "�@�V�l�����t���Ă����t���[�Y��";
	mes "�@�v���o���āA�e���n�߂�-";
	next;
	mes "-�C�̌�������";
	mes "�@��������ƃN�W���������ꂽ-";
	close2;
	warp "mosk_fild01",95,93;
	end;
}

mosk_fild02,198,53,0	script	���D	111,{
	mes "-�V���Ɋ�ȘV�l����؂肽";
	mes "�@���D���┑���Ă���B";
	mes "�@�����ɃN�W������������-";
	mes " ";
	mes "-���X�R�r�A�̊X�ɋA�낤���H-";
	next;
	if(select("���D�𗘗p���ĊX�ɖ߂�","�����ƒT������") == 2) {
		mes "-���̖��J�̓���";
		mes "�@�����ƒT�����邱�Ƃɂ���-";
		close;
	}
	mes "-�N�W�������o�R����";
	mes "�@���X�R�r�A�̊X��";
	mes "�@�߂邱�Ƃɂ���-";
	close2;
	warp "moscovia",140,54;
	end;
}

//============================================================
// �ǂ񂮂�D���̃��X�N�G�X�gNPC
//------------------------------------------------------------
mosk_fild01,113,108,5	script	#�傫�����X	1104,{}
mosk_fild01,113,108,0	script	�傫�����X	111,2,2,{
OnTouch:
	if(MaxWeight - Weight < 2000) {
		mes "-�����A�C�e���̏d�ʂ���������";
		mes "�@�A�C�e�����󂯂Ƃ邱�Ƃ��ł��܂���-";
		mes "-�����A�C�e�������炵�Ă���A�ēx";
		mes "�@�b�������Ă�������-";
		close;
	}
	mes "-���ʂ̃��X�������{��";
	mes "�@�̂��傫�����X������-";
	next;
	mes "-���X�͖ڂ�������";
	mes "�@�@���N���N����������A";
	mes "�@�����𓮂������肵�āA";
	mes "�@���������������Ȃ���-";
	next;
	if(countitem(1026) < 20) {
		mes "-���X�͂��Ȃ���";
		mes "�@�`���`���ƌ��Ă������A";
		mes "�@�₪�ċ������������悤��-";
		close;
	}
	switch(select("�ǂ񂮂��������","�C�ɂ��Ȃ��ł���","���X�̎��𕷂�")) {
	case 1:
		mes "-���Ȃ��͂ǂ񂮂�����o���A";
		mes "�@���X�ɂ�����-";
		next;
		mes "-���X�͈�u�x���������A";
		mes "�@�����ɂǂ񂮂��H�׎n�߂�-";
		next;
		mes "-�J���@�J���@�J���@�J��-";
		mes "-�J���@�J���@�J���@�J��-";
		mes "-�J���@�J���@�J���@�J��-";
		next;
		mes "-�ǂ񂮂�������Ƃ����Ԃ�";
		mes "�@�H�ׂ��������X�́A";
		mes "�@�}�ɑ̂�܂��Č����牽����";
		mes "�@�f���o����-";
		delitem 1026,20;
		set .@rand,rand(1000);
		if (.@rand < 100) getitem 733,1;
		else if (.@rand == 100) {
			set .@rand,rand(150);
			if (.@rand < 10) getitem 718,1;
			else if (.@rand < 20) getitem 719,1;
			else if (.@rand < 30) getitem 720,1;
			else if (.@rand < 40) getitem 721,1;
			else if (.@rand < 50) getitem 722,1;
			else if (.@rand < 60) getitem 723,1;
			else if (.@rand < 70) getitem 725,1;
			else if (.@rand < 80) getitem 728,1;
			else if (.@rand < 90) getitem 729,1;
			else if (.@rand < 100) getitem 730,1;
			else getitem 7289,1;
		}
		else if (.@rand < 200) getitem 733,1;
		else if (.@rand == 200) {
			set .@rand,rand(150);
			if (.@rand < 10) getitem 718,1;
			else if (.@rand < 20) getitem 719,1;
			else if (.@rand < 30) getitem 720,1;
			else if (.@rand < 40) getitem 721,1;
			else if (.@rand < 50) getitem 722,1;
			else if (.@rand < 60) getitem 723,1;
			else if (.@rand < 70) getitem 725,1;
			else if (.@rand < 80) getitem 728,1;
			else if (.@rand < 90) getitem 729,1;
			else if (.@rand < 100) getitem 731,1;
			else {
				switch(rand(10)) {
					case 0:
					case 1:
					case 2: getitem 7292,1; break;
					case 3:
					case 4: getitem 7297,1; break;
					default: getitem 7290,1; break;
				}
			}
		}
		else if (.@rand < 300) getitem 733,1;
		else if (.@rand == 300) {
			set .@rand,rand(150);
			if (.@rand < 10) getitem 718,1;
			else if (.@rand < 20) getitem 719,1;
			else if (.@rand < 30) getitem 720,1;
			else if (.@rand < 40) getitem 721,1;
			else if (.@rand < 50) getitem 722,1;
			else if (.@rand < 60) getitem 723,1;
			else if (.@rand < 70) getitem 725,1;
			else if (.@rand < 80) getitem 728,1;
			else if (.@rand < 90) getitem 729,1;
			else if (.@rand < 100) getitem 732,1;
			else {
				if(rand(2)) getitem 7291,1;
				else getitem 7294,1;
			}
		}
		else if (.@rand < 400) getitem 733,1;
		else if (.@rand == 400) {
			set .@rand,rand(150);
			if (.@rand < 10) getitem 718,1;
			else if (.@rand < 20) getitem 719,1;
			else if (.@rand < 30) getitem 720,1;
			else if (.@rand < 40) getitem 721,1;
			else if (.@rand < 50) getitem 722,1;
			else if (.@rand < 60) getitem 723,1;
			else if (.@rand < 70) getitem 725,1;
			else if (.@rand < 80) getitem 728,1;
			else if (.@rand < 90) getitem 729,1;
			else if (.@rand < 100) getitem 730,1;
			else getitem 7295,1;
		}
		else if (.@rand < 500) getitem 733,1;
		else if (.@rand == 500) {
			set .@rand,rand(150);
			if (.@rand < 10) getitem 718,1;
			else if (.@rand < 20) getitem 719,1;
			else if (.@rand < 30) getitem 720,1;
			else if (.@rand < 40) getitem 721,1;
			else if (.@rand < 50) getitem 722,1;
			else if (.@rand < 60) getitem 723,1;
			else if (.@rand < 70) getitem 725,1;
			else if (.@rand < 80) getitem 728,1;
			else if (.@rand < 90) getitem 729,1;
			else if (.@rand < 100) getitem 731,1;
			else getitem 7293,1;
		}
		else if (.@rand < 600) getitem 724,1;
		else if (.@rand == 600) {
			set .@rand,rand(150);
			if (.@rand < 10) getitem 718,1;
			else if (.@rand < 20) getitem 719,1;
			else if (.@rand < 30) getitem 720,1;
			else if (.@rand < 40) getitem 721,1;
			else if (.@rand < 50) getitem 722,1;
			else if (.@rand < 60) getitem 723,1;
			else if (.@rand < 70) getitem 725,1;
			else if (.@rand < 80) getitem 728,1;
			else if (.@rand < 90) getitem 729,1;
			else if (.@rand < 100) getitem 732,1;
			else getitem 7292,1;
		}
		else if (.@rand < 700) getitem 724,1;
		else if (.@rand == 700) {
			set .@rand,rand(150);
			if (.@rand < 10) getitem 718,1;
			else if (.@rand < 20) getitem 719,1;
			else if (.@rand < 30) getitem 720,1;
			else if (.@rand < 40) getitem 721,1;
			else if (.@rand < 50) getitem 722,1;
			else if (.@rand < 60) getitem 723,1;
			else if (.@rand < 70) getitem 725,1;
			else if (.@rand < 80) getitem 728,1;
			else if (.@rand < 90) getitem 729,1;
			else if (.@rand < 100) getitem 730,1;
			else getitem 7290,1;
		}
		else if (.@rand < 800) getitem 724,1;
		else if (.@rand == 800) {
			set .@rand,rand(150);
			if (.@rand < 10) getitem 718,1;
			else if (.@rand < 20) getitem 719,1;
			else if (.@rand < 30) getitem 720,1;
			else if (.@rand < 40) getitem 721,1;
			else if (.@rand < 50) getitem 722,1;
			else if (.@rand < 60) getitem 723,1;
			else if (.@rand < 70) getitem 725,1;
			else if (.@rand < 80) getitem 728,1;
			else if (.@rand < 90) getitem 729,1;
			else if (.@rand < 100) getitem 731,1;
			else getitem 7296,1;
		}
		else if (.@rand < 900) getitem 724,1;
		else if (.@rand == 900) {
			set .@rand,rand(150);
			if (.@rand < 10) getitem 718,1;
			else if (.@rand < 20) getitem 719,1;
			else if (.@rand < 30) getitem 720,1;
			else if (.@rand < 40) getitem 721,1;
			else if (.@rand < 50) getitem 722,1;
			else if (.@rand < 60) getitem 723,1;
			else if (.@rand < 70) getitem 725,1;
			else if (.@rand < 80) getitem 728,1;
			else if (.@rand < 90) getitem 729,1;
			else if (.@rand < 100) getitem 732,1;
			else getitem 7297,1;
		}
		else if (.@rand < 1000) getitem 724,1;
		else getitem 727,1;
		close;
	case 2:
		mes "[" +strcharinfo(0)+ "]";
		mes "����A���������B";
		close;
	case 3:
		mes "[�V�l]";
		mes "�����傫�����X���낤�H";
		mes "�́A���̃��X���N�W���̔w����";
		mes "�����������͎��ɂ����Ă������A";
		mes "����Ȃɑ傫���Ȃ��Ă��܂����B";
		mes "�ӂӁB";
		next;
		mes "[�V�l]";
		mes "�����A�����Ȃ񂾁B";
		mes "�����͐H������V�łˁB";
		mes "^3131FF�ǂ񂮂��20����^000000�����Ȃ���";
		mes "�����������Ȃ��񂾂�";
		mes "�n�n�n�I";
		mes "������傫���Ȃ����̂��ȁB";
		close;
	}
}

moscovia,208,182,7	script	�ǂ񂮂菤�l	967,{
	mes "[�ǂ񂮂菤�l]";
	mes "�V��j���A�F���D���Ȃǂ񂮂�I";
	mes "�����100zeny�Ɣj�i�ł���!!";
	next;
	if(select("�ǂ񂮂�𔃂�","�ǂ񂮂�H") == 2) {
		mes "[�ǂ񂮂菤�l]";
		mes "�ǂ񂮂�𗿗�������A";
		mes "���X�̉a�ɂ����肵�܂���ˁH";
		mes "�܂��A����l�͂ǂ񂮂��";
		mes "�Ƃ����炵���ł����c�c";
		mes "�ǂ�ȕ��ɍ���Ă��邩��";
		mes "�z�������܂���ˁB";
		close;
	}
	mes "[�ǂ񂮂菤�l]";
	mes "����͍ō����̂ǂ񂮂�ł���I";
	mes "�������ɂ��邩";
	mes "����ɏ����Ă��������B";
	mes "�ő��500�܂ň�x�ɔ����܂��B";
	while(1) {
		next;
		input .@num;
		if(.@num == 0) {
			mes "[�ǂ񂮂菤�l]";
			mes "����A����܂��񂩁H";
			close;
		}
		if(.@num < 0 || .@num > 500) {
			mes "[�ǂ񂮂菤�l]";
			mes "�w���͈�x��500�܂ł�";
			mes "���肢���܂��B";
			continue;
		}
		if(checkweight(1026,.@num) == 0) {
			mes "[�ǂ񂮂菤�l]";
			mes "���q�l�c�c";
			mes "��ו��ň�t�݂����ł���H";
			mes "����؂ꂽ�肵�܂��񂩂�A";
			mes "������菊���i��";
			mes "�������Ă��Ă��������B";
			close;
		}
		if(.@num * 100 > Zeny) {
			mes "[�ǂ񂮂菤�l]";
			mes "���q�l�H�@�ǂ��Ȃ���܂����H";
			mes "�炪�^���Ȃ�ł����c�c";
			mes "���������āA����������Ȃ��Ƃ��c�c�H";
			close;
		}
		set Zeny,Zeny-.@num*100;
		getitem 1026,.@num;
		mes "[�ǂ񂮂菤�l]";
		mes "���肪�Ƃ��������܂��I";
		mes "�ǂ��ł����H";
		mes "�V�N�Ȃǂ񂮂�ł��傤�H";
		close;
	}
}

//============================================================
// �����ĖX�쐬�N�G�X�gNPC
//------------------------------------------------------------
moscovia,211,93,3	script	�C���[�i	958,{
	if(MaxWeight - Weight < 1500) {
		mes "[�C���[�i]";
		mes "�����A�C�e�����d�����āA";
		mes "�A�C�e���̎󂯓n����";
		mes "�ł��܂���B�ו������炵�Ă���";
		mes "�b�������Ă��������B";
		close;
	}
	mes "[�C���[�i]";
	mes "����ɂ��́B�`���҂���I";
	mes "���X�R�r�A�͊y����ł܂����H";
	next;
	mes "[�C���[�i]";
	mes "���X�R�r�A�̗��s���L�O����";
	mes "���X�R�r�A�̓��Y�i�A";
	mes "�����ĖX������Ă݂Ă�";
	mes "�������ł��傤�B";
	mes "�{���Ɋi�D�����ł���B";
	next;
	if(select("�����ĖX�̐����𕷂�","�����ĖX�����") == 1) {
		mes "[�C���[�i]";
		mes "���X�R�r�A�͒g�����̂�";
		mes "���̕������X�q��";
		mes "���̓��Y�i���킩��܂����H";
		next;
		mes "[�C���[�i]";
		mes "���́A���X�R�r�A�̓~��";
		mes "�ƂĂ��������āA";
		mes "�ƂĂ�������ł��B";
		next;
		mes "[�C���[�i]";
		mes "�����ɏ��߂ė������ɂ�";
		mes "�M�����܂����ˁB";
		next;
		mes "[�C���[�i]";
		mes "���̌������~�ɁA";
		mes "���̖X�q�͕K�{�ƂȂ��ł��B";
		mes "���ꂪ�����ƁA������";
		mes "�ς����Ȃ���ł���B";
		next;
		mes "[�C���[�i]";
		mes "���͉Ăł����A";
		mes "���̂����A�~�ɔ�����";
		mes "�����ĖX������Ă����Ȃ���";
		mes "�����Ȃ��̂ł��B";
		next;
		mes "[�C���[�i]";
		mes "�����ĖX�̖h���\�͂�";
		mes "���ẮA�����ۏႵ�܂���B";
		close;
	}
	mes "[�C���[�i]";
	mes "�����ĖX�����܂����H";
	mes "�������߂ł���B";
	next;
	mes "[�C���[�i]";
	mes "�ޗ��������ė��Ă����΁A";
	mes "�����ɍ��܂��B";
	next;
	mes "[�C���[�i]";
	mes "�ޗ��́A";
	mes "^0000FF�ς̐K�� 20�A";
	mes "�ю� 10�A�_�炩���z 10�A";
	mes "���b�R�̖є� 20�A���� 1��^000000��";
	mes "�K�v�ł���B";
	next;
	if(countitem(1022) < 20 || countitem(7038) < 10 || countitem(7166) < 10 || countitem(7065) < 20 || countitem(7217) < 1) {
		mes "[�C���[�i]";
		mes "����A�ޗ�������܂���ˁB";
		next;
		mes "[�C���[�i]";
		mes "������x�ޗ��������܂�����A";
		mes "�����Ă��������ˁB";
		next;
		mes "[�C���[�i]";
		mes "^0000FF�ς̐K�� 20�A";
		mes "�ю� 10�A�_�炩���z 10�A";
		mes "���b�R�̖є� 20�A���� 1��^000000��";
		mes "�K�v�ł��B";
		close;
	}
	mes "[�C���[�i]";
	mes "�ޗ����S�������܂����ˁB";
	mes "�����҂��ĂĂ��������B";
	mes "�����ɍ��܂��I";
	delitem 1022,20;
	delitem 7038,10;
	delitem 7166,10;
	delitem 7065,20;
	delitem 7217,1;
	getitem 5243,1;
	next;
	mes "[�C���[�i]";
	mes "�ǂ��ł����H";
	mes "�C�ɓ���܂������H";
	next;
	mes "[�C���[�i]";
	mes "�����ĖX���K�v�Ȃ�A";
	mes "�ޗ��������";
	mes "�܂����܂���B";
	next;
	mes "[�C���[�i]";
	mes "����ł́A�ǂ������I";
	close;
}

//============================================================
// �������̃~�n�C���N�G�X�gNPC
//- Registry -------------------------------------------------
// MOSK_2QUE -> 0�`
//------------------------------------------------------------
mosk_in,144,279,5	script	�J���[�i	959,{
	switch(MOSK_2QUE) {
	case 0:
		mes "[�J���[�i]";
		mes "�܂������c�c";
		mes "���̎q�͂ǂ��s�����́H";
		mes "�A�����炨�d�u��������ˁI";
		mes "�����c�c��������ɕςȏ�����";
		mes "���Ă�񂾂���c�c";
		next;
		mes "[�A���i]";
		mes "�~�n�C���͉��a�ҁI";
		mes "�~�n�C���̋������I";
		next;
		mes "[�J���[�i]";
		mes "����I";
		mes "�����͌������Ⴞ�߂���";
		mes "���������Ă���ł���I";
		mes "��T�ԁA�|���̎�`����";
		mes "�o�債�Ă����Ȃ����I";
		next;
		emotion 28,"�A���i#mosk";
		mes "[�A���i]";
		mes "�����`�`�`";
		next;
		if(select("�b��������","�C�ɂ��Ȃ��ł���") == 2) {
			mes "[�J���[�i]";
			mes "�܂������c�c";
			mes "�A���i�͉��x�����Ă�";
			mes "�������ƕ����Ȃ��񂾂���c�c";
			close;
		}
		mes "[" +strcharinfo(0)+ "]";
		mes "���A���́c�c����ɂ��́B";
		next;
		mes "[�J���[�i]";
		mes "����A��������Ⴂ�I";
		mes "���q����ɋC�t���Ȃ���";
		mes "���߂�Ȃ����ˁB";
		mes "�p���P�[�L�𔃂���";
		mes "������ł���ˁH";
		next;
		mes "[�J���[�i]";
		mes "���߂�Ȃ����B";
		mes "�܂��J�X�̏������ł��Ă��Ȃ��āc�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�����A�p���P�[�L��";
		mes "�����ɗ����킯���Ⴀ��܂���B";
		mes "������A�����������݂����ł����c�c";
		mes "���v�ł����H";
		next;
		mes "[�J���[�i]";
		mes "���c�c���ꂪ�c�c";
		mes "�~�n�C���A�����̑��q�Ȃ�ł����A";
		mes "���̑厖�ȃ}�g�����[�V�J�l�`��";
		mes "�󂵂āc�c����œ{����̂�";
		mes "�|���Ȃ����̂��A�A���Ă��Ȃ���ł��B";
		next;
		mes "[�J���[�i]";
		mes "�j�̎q�Ȃ̂Ɏ㒎�Łc�c";
		mes "�悭�������c�c";
		next;
		mes "[�J���[�i]";
		mes "�Ƃɂ����A�����[�т̎��ԂȂ̂�";
		mes "�A���Ă��Ȃ�����c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�S�z�Ȃ�A�������q�����";
		mes "�T���Ă��܂��傤���H";
		next;
		mes "[�J���[�i]";
		mes "�S�z�H�@�Ⴂ�܂��I";
		mes "�����A���q�̎ア���i��";
		mes "���Ƃ������������ł��c�c";
		mes "�����������Ă�肽���̂ɁA";
		mes "���ꂪ�o���Ȃ���";
		mes "�C���C�����Ă��邾���ł��c�c";
		next;
		mes "-�ڂ̑O�̏����͋A���Ă��Ȃ�";
		mes "�@���q�̂��Ƃ��S�z�̂悤��-";
		next;
		mes "[�J���[�i]";
		mes "�ł��c�c";
		mes "���������̂��D�ӂ����c�c";
		mes "�{���ɑ��q��T���Ă����̂ł����H";
		next;
		if(select("�����A�����Ă݂������ł�","�͂��A�C���Ă��������I") == 1) {
			mes "[�J���[�i]";
			mes "�����ł���ˁc�c";
			mes "���l�̂��Ȃ��ɂ�";
			mes "�֌W�Ȃ����Ƃł�����c�c";
			mes "��k��������ł���ˁB";
			close;
		}
		mes "[�J���[�i]";
		mes "�{���ł����H";
		mes "���肪�Ƃ��������܂��I";
		mes "�~�n�C���͉��a�Ȏq�ł�����A";
		mes "�X�̊O�ɂ͍s���Ă��Ȃ��Ǝv���܂��B";
		next;
		mes "[�J���[�i]";
		mes "���������΁A�܂������O��";
		mes "�����Ă��܂���ł����ˁB";
		mes "���Ȃ��́H";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "����";
		mes strcharinfo(0)+ "�ł��B";
		next;
		mes "[�J���[�i]";
		mes strcharinfo(0)+ "����";
		mes "�ł��ˁB";
		mes "���̓J���[�i�B";
		mes "�����ɂ���͖̂���";
		mes "�A���i�ł��B";
		next;
		mes "-�A���i�ƌĂ΂ꂽ���̎q��";
		mes "�@�ڂ�������-";
		next;
		mes "[�A���i]";
		mes "���[�[�[�[�[�����I";
		next;
		mes "-�����C�ɓ���Ȃ��̂��A";
		mes "�@�A���i�͔�������������";
		mes "�@�s���������ɂ��Ă���-";
		next;
		mes "[�J���[�i]";
		mes "�A���i�I";
		mes "���q����Ɏ���ł��傤�I";
		next;
		mes "-�J���[�i�͋�΂���";
		mes "�@���Ȃ���A�b�𑱂���-";
		next;
		mes "[�J���[�i]";
		mes "�ˑR�Ő\���󂠂�܂��񂪁A";
		mes "���q�̃~�n�C����";
		mes "��낵�����肢���܂��B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�i���q�̖��O��";
		mes "�@�~�n�C���ƌ����炵���B";
		mes "�@�܂��́A�Ƃ̒��ŏ���";
		mes "�@�W�߂Ă݂悤�j";
		next;
		mes "[�J���[�i]";
		mes "�����I";
		mes "���̎q������A�ǂ��ɍs�����̂�����I";
		set MOSK_2QUE,1;
		close;
	case 1:
		mes "[�J���[�i]";
		mes "�~�n�C���͉��a�Ȏq�ł��̂Łc�c";
		mes "�X�̉������ɉB��Ă����";
		mes "�v���܂��B";
		mes "�S���A���̐l�Ɏ��āc�c";
		close;
	case 25:
		mes "[�J���[�i]";
		mes "����A�~�n�C�����A���Ă��܂����B";
		mes "�ł��A�܂��o�čs������ł��B";
		mes "�}�g�����[�V�J�l�`�������āc�c";
		next;
		mes "[�J���[�i]";
		mes "�܂��������̂Ɂc�c";
		mes "�������������������m��܂���ˁB";
		mes "�~�n�C���͎����Ȃ��";
		mes "�w�͂����Ă����̂���";
		mes "�m��Ȃ��̂Ɂc�c";
		next;
		mes "-�J���[�i�̓~�n�C����";
		mes "�@�߂��Ă������Ƃ�";
		mes "�@���S���Ă���悤��-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "���ꂩ��D�������Ă������";
		mes "�ǂ��񂶂Ⴀ��܂��񂩁H";
		next;
		mes "[�J���[�i]";
		mes "�͂��A�����ł��ˁB";
		mes "����̎��̓A���i��";
		mes "���������悤�ł��B";
		next;
		mes "[�J���[�i]";
		mes "���������������";
		mes "��̂����ɂ��āc�c";
		mes "�A���i�ɂ͏���������";
		mes "���悤���Ǝv���܂��B";
		next;
		mes "[�J���[�i]";
		mes "����ɂ��Ă��c�c";
		mes "�������̂��߂ɐF�X���Ă���āc�c";
		mes "�{���ɂ��肪�Ƃ��������܂����B";
		mes "�~�n�C������͊댯�ȏ��ɂ�";
		mes "�s���ꂽ�ƕ����܂����c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�Ȃ��ɁA�����̎��ł��B";
		mes "�C�ɂ��Ȃ��ł��������B";
		next;
		mes "[�J���[�i]";
		mes "�����ł����c�c";
		mes "�債������͏o���܂��񂪁c�c";
		mes "����ɔ��������p���P�[�L��";
		mes "���������������Ă�";
		mes "�����ł����H";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�͂��B�@���񂨂˂������܂��I";
		next;
		mes "[�J���[�i]";
		mes "���͂��X�̏���������܂��̂Łc�c";
		mes "����`���̃����T��";
		mes "�����Ă����܂��ˁB";
		next;
		mes "[�J���[�i]";
		mes "�p���P�[�L�̍�����";
		mes "�ޏ��ɋ�����Ă��������B";
		mes "�ޏ��̘r�����ɂ��Ƃ炸�A";
		mes "�Ȃ��Ȃ��̂��̂Ȃ�ł�����B";
		next;
		mes "[�J���[�i]";
		mes "���X�R�r�A�̃p���P�[�L��";
		mes "�Ƃ��Ă����������ł�����I";
		mes "�����ƁA��x�H�ׂ�΁A";
		mes "��݂��ԈႢ�Ȃ��ł���B";
		mes "���ӂӁB";
		set MOSK_2QUE,100;
		if(checkre()) {
			for(set .@i,0;.@i<20;set .@i,.@i+1)
				getexp 5000,0;
			for(set .@i,0;.@i<6;set .@i,.@i+1)
				getexp 0,5000;
		}
		else {
			for(set .@i,0;.@i<20;set .@i,.@i+1)
				getexp 50000,0;
			for(set .@i,0;.@i<6;set .@i,.@i+1)
				getexp 0,50000;
		}
		close;
	default:
		if(MOSK_2QUE < 25) {
			mes "[" +strcharinfo(0)+ "]";
			mes "�~�n�C���N�͂܂��A���Ă���";
			mes "���܂��񂩁H";
			next;
			mes "[�J���[�i]";
			mes "�����A�܂��c�c";
			mes "�܂������A�ǂ��֍s���Ă���̂��c�c";
			close;
		}
		mes "[�J���[�i]";
		mes "���͂����V�������j���[��";
		mes "�l���Ă����ł���B";
		mes "�����Ɓc�c";
		mes "�u���E��h���`���z�b�g�p���P�[�L�v";
		mes "�Ȃ�Ăǂ��ł����H";
		mes "�����A�a�V�ȋC�����܂��񂩁H";
		close;
	}
}

mosk_in,148,274,1	script	�A���i#mosk	958,{
	switch(MOSK_2QUE) {
	case 0:
		mes "[�J���[�i]";
		mes "�܂������c�c";
		mes "���̎q�͂ǂ��s�����́H";
		mes "�A�����炨�d�u��������ˁI";
		mes "�����c�c��������ɕςȏ�����";
		mes "���Ă�񂾂���c�c";
		next;
		mes "[�A���i]";
		mes "�~�n�C���͉��a�ҁI";
		mes "�~�n�C���̋������I";
		next;
		mes "[�J���[�i]";
		mes "����I";
		mes "�����͌������Ⴞ�߂���";
		mes "���������Ă���ł���I";
		mes "��T�ԁA�|���̎�`����";
		mes "�o�債�Ă����Ȃ����I";
		next;
		emotion 28;
		mes "[�A���i]";
		mes "�����`�`�`";
		next;
		if(select("�b��������","�C�ɂ��Ȃ��ł���") == 2) {
			mes "[�J���[�i]";
			mes "�����c�c";
			mes "�ǂ��ɍs�����̂�����I";
			close;
		}
		mes "[" +strcharinfo(0)+ "]";
		mes "���A���́c�c����ɂ��́B";
		next;
		mes "[�J���[�i]";
		mes "����A��������Ⴂ�I";
		mes "���q����ɋC�t���Ȃ���";
		mes "���߂�Ȃ����ˁB";
		mes "�p���P�[�L�𔃂���";
		mes "������ł���ˁH";
		next;
		mes "[�J���[�i]";
		mes "���߂�Ȃ����B";
		mes "�܂��J�X�̏������ł��Ă��Ȃ��āc�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�����A�p���P�[�L��";
		mes "�����ɗ����킯���Ⴀ��܂���B";
		mes "������A�����������݂����ł����c�c";
		mes "���v�ł����H";
		next;
		mes "[�J���[�i]";
		mes "���c�c���ꂪ�c�c";
		mes "�~�n�C���A�����̑��q�Ȃ�ł����A";
		mes "���̑厖�ȃ}�g�����[�V�J�l�`��";
		mes "�󂵂āc�c����œ{����̂�";
		mes "�|���Ȃ����̂��A�A���Ă��Ȃ���ł��B";
		next;
		mes "[�J���[�i]";
		mes "�j�̎q�Ȃ̂Ɏ㒎�Łc�c";
		mes "�悭�������c�c";
		next;
		mes "[�J���[�i]";
		mes "�Ƃɂ����A�����[�т̎��ԂȂ̂�";
		mes "�A���Ă��Ȃ�����c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�S�z�Ȃ�A�������q�����";
		mes "�T���Ă��܂��傤���H";
		next;
		mes "[�J���[�i]";
		mes "�S�z�H�@�Ⴂ�܂��I";
		mes "�����A���q�̎ア���i��";
		mes "���Ƃ������������ł��c�c";
		mes "�����������Ă�肽���̂ɁA";
		mes "���ꂪ�o���Ȃ���";
		mes "�C���C�����Ă��邾���ł��c�c";
		next;
		mes "-�ڂ̑O�̏����͋A���Ă��Ȃ�";
		mes "�@���q�̂��Ƃ��S�z�̂悤��-";
		next;
		mes "[�J���[�i]";
		mes "�ł��c�c";
		mes "���������̂��D�ӂ����c�c";
		mes "�{���ɑ��q��T���Ă����̂ł����H";
		next;
		if(select("�����A�����Ă݂������ł�","�͂��A�C���Ă��������I") == 1) {
			mes "[�J���[�i]";
			mes "�����ł���ˁc�c";
			mes "���l�̂��Ȃ��ɂ�";
			mes "�֌W�Ȃ����Ƃł�����c�c";
			mes "��k��������ł���ˁB";
			close;
		}
		mes "[�J���[�i]";
		mes "�{���ł����H";
		mes "���肪�Ƃ��������܂��I";
		mes "�~�n�C���͉��a�Ȏq�ł�����A";
		mes "�X�̊O�ɂ͍s���Ă��Ȃ��Ǝv���܂��B";
		next;
		mes "[�J���[�i]";
		mes "���������΁A�܂������O��";
		mes "�����Ă��܂���ł����ˁB";
		mes "���Ȃ��́H";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "����";
		mes strcharinfo(0)+ "�ł��B";
		next;
		mes "[�J���[�i]";
		mes strcharinfo(0)+ "����";
		mes "�ł��ˁB";
		mes "���̓J���[�i�B";
		mes "�����ɂ���͖̂���";
		mes "�A���i�ł��B";
		next;
		mes "-�A���i�ƌĂ΂ꂽ���̎q��";
		mes "�@�ڂ�������-";
		next;
		mes "[�A���i]";
		mes "���[�[�[�[�[�����I";
		next;
		mes "-�����C�ɓ���Ȃ��̂��A";
		mes "�@�A���i�͔�������������";
		mes "�@�s���������ɂ��Ă���-";
		next;
		mes "[�J���[�i]";
		mes "�A���i�I";
		mes "���q����Ɏ���ł��傤�I";
		next;
		mes "-�J���[�i�͋�΂���";
		mes "�@���Ȃ���A�b�𑱂���-";
		next;
		mes "[�J���[�i]";
		mes "�ˑR�Ő\���󂠂�܂��񂪁A";
		mes "���q�̃~�n�C����";
		mes "��낵�����肢���܂��B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�i���q�̖��O��";
		mes "�@�~�n�C���ƌ����炵���B";
		mes "�@�܂��́A�Ƃ̒��ŏ���";
		mes "�@�W�߂Ă݂悤�j";
		next;
		mes "[�J���[�i]";
		mes "�����I";
		mes "���̎q������A�ǂ��ɍs�����̂�����I";
		set MOSK_2QUE,1;
		close;
	case 1:
		mes "[�A���i]";
		mes "�����I";
		mes "�~�n�C���Ȃ񂩒m��Ȃ��I";
		mes "�~�n�C���̔n���I�@�|����I";
		close;
	case 2:
		mes "[�A���i]";
		mes "����I";
		mes "�b�����Ƃł�����́H";
		mes " ";
		mes "-�A���i�͋��Ԃ悤�ɕ����Ă���-";
		while(1) {
			next;
			switch(select("�~�n�C�����B�ꂽ�ꏊ","�~�n�C���Ƃ̊֌W","�����̏󋵂ɂ���","���̑��̎���","�b����߂�")) {
			case 1:
				mes "[" +strcharinfo(0)+ "]";
				mes "�~�n�C���͂ǂ��ɉB�ꂽ��";
				mes "�S������͂Ȃ����ȁH";
				next;
				emotion 39;
				mes "[�A���i]";
				mes "�n������Ȃ��H";
				mes "�������玄�������Ă���B";
				next;
				emotion 4,"";
				mes "[" +strcharinfo(0)+ "]";
				mes "���A��������ˁc�c";
				mes "�n�n�n�c�c";
				break;
			case 2:
				mes "[" +strcharinfo(0)+ "]";
				mes "�A���i�̓~�n�C���ƒ����ǂ��́H";
				next;
				mes "[�A���i]";
				mes "�ʂɁB";
				mes "�~�n�C���͂��������̌���";
				mes "�B��Ă�̂�B";
				next;
				mes "[�A���i]";
				mes "�{��ǂ�ŗ~�������Ă��邳�����A";
				mes "�����ɋ����������c�c";
				mes "�����ʓ|�Ȃ́B";
				mes "�F�B�Ȃ񂩐�΂ɂ��Ȃ��񂾂���B";
				next;
				mes "[" +strcharinfo(0)+ "]";
				mes "�i�A���i�͊����Ȑ��i�����ǁA";
				mes "�@�~�n�C���͑�l�������i�Ȃ̂��c�c�j";
				break;
			case 3:
				mes "[" +strcharinfo(0)+ "]";
				mes "�~�n�C�������ꂳ���";
				mes "�}�g�����[�V�J�l�`���󂵂����A";
				mes "�A���i�͉������Ă����́H";
				next;
				mes "[�A���i]";
				mes "���̓~�n�C���ƈꏏ�ɂ�����B";
				next;
				mes "[" +strcharinfo(0)+ "]";
				mes "�����H�@�����Ȃ́H";
				mes "����A�������������ڂ���";
				mes "�����Ă���Ȃ����ȁH";
				next;
				mes "[�A���i]";
				mes "���ꂳ�񂪏o��������A";
				mes "���͖{��ǂ�ł���B";
				mes "�~�n�C���͖{��ǂ�ł��Č�������A";
				mes "�������󂢂����Ă��邳�������́B";
				next;
				mes "[�A���i]";
				mes "���͈�l���ች���o���Ȃ��~�n�C����";
				mes "�ʓ|�Ȃ�Č������Ȃ���������A";
				mes "���̂܂ܖ{��ǂ�ł��̂�c�c";
				next;
				mes "[�A���i]";
				mes "��������A���̊Ԃɂ�";
				mes "�~�n�C�������ꂳ���";
				mes "�}�g�����[�V�J�l�`��";
				mes "�󂵂Ă����̂�I";
				next;
				mes "[�A���i]";
				mes "���̂��Ƌ����o�����̂�B";
				mes "�܂������c�c";
				mes "����Ȃ��ƂɂȂ�Ȃ�";
				mes "�ŏ�����}�g�����[�V�J�l�`��";
				mes "�G��Ȃ���悩�����̂ɁB";
				next;
				mes "[�A���i]";
				mes "�d���Ȃ�����A";
				mes "�~�n�C����^3131FF�ڒ���^000000��";
				mes "�}�g�����[�V�J�l�`�𒼂���";
				mes "���Č����Ă������́B";
				next;
				mes "[�A���i]";
				mes "�~�n�C���͈�ڎU��";
				mes "�ڒ��܂�T���ɏo�Ă�������B";
				mes "���̂܂܋A���Ă��ĂȂ��́B";
				next;
				mes "[" +strcharinfo(0)+ "]";
				mes "�Ȃ�قǁc�c";
				mes "����Ȏ����������񂾁B";
				mes "����A�A���i�͐ڒ��܂�";
				mes "��ɓ��鏊���~�n�C����";
				mes "�����Ă������񂾂ˁB";
				next;
				mes "[" +strcharinfo(0)+ "]";
				mes "�����Ƃ����Ƀ~�n�C����";
				mes "����Ǝv�����ǁc�c";
				next;
				mes "[�A���i]";
				mes "�ڒ��܂��ǂ��ɂ��邩�Ȃ��";
				mes "���͒m��Ȃ���B";
				mes "�~�n�C�����ˁB";
				next;
				mes "[" +strcharinfo(0)+ "]";
				mes "�I�I�I�I�I�I";
				next;
				mes "[�A���i]";
				mes "�~�n�C���͎��̘b����������";
				mes "�s�������������A";
				mes "�ǂ��ɂ������̂��Ȃ�āA";
				mes "�킩��Ȃ��̂�B";
				next;
				mes "[" +strcharinfo(0)+ "]";
				mes "�~�n�C���ƒ��ǂ��F�B��";
				mes "�X�̐l�͋���́H";
				next;
				mes "[�A���i]";
				mes "�n���I�@����Ȃ��";
				mes "�F�B�Ȃ�Ă���킯�Ȃ�����Ȃ��B";
				mes "^3131FF�A�b�v���c���[���ق̂��΂���^000000";
				mes "���炢����Ȃ��́H";
				mes "�~�n�C�����������Ă�̂́B";
				next;
				mes "[�A���i]";
				mes "�t���I";
				mes "�~�n�C���Ȃ�āA�m��Ȃ��񂾂���I";
				next;
				mes "-�A���i�͋������Ęb�𕷂���";
				mes "�@��Ԃł͂Ȃ��Ȃ��Ă��܂���-";
				next;
				mes "[" +strcharinfo(0)+ "]";
				mes "�i�ӂ��c�c�Ƃ肠�����A";
				mes "�@^3131FF�A�b�v���c���[����^000000��";
				mes "�@�s���Ă݂悤���H�j";
				set MOSK_2QUE,3;
				break;
			case 4:
				mes "[" +strcharinfo(0)+ "]";
				mes "�A���i�ɉ��𕷂��Ă݂悤���B";
				next;
				input .@str$;
				mes "[" +strcharinfo(0)+ "]";
				mes "�A���i�B";
				mes "�u" +.@str$+ "�v����";
				mes "�m���Ă�H";
				next;
				if(.@str$ == "�J���[�i") {
					mes "[�A���i]";
					mes "�J���[�i�H";
					mes "���̂��ꂳ��Ɠ������O�ˁB";
					mes "���ꂳ��̓p���P�[�L��";
					mes "���̂��ƂĂ����Ȃ̂�B";
					next;
					mes "[�A���i]";
					mes "�Ƃ��Ă����������񂾂���B";
					mes "�͂��c�c";
					mes "�Â�����Ƃӂ���Ƃ����H���c�c";
					mes "���A�������ĐH�ׂ����B";
					next;
					mes "[�A���i]";
					mes "�X���̐l�������A���ꂳ���";
					mes "�p���P�[�L��J�߂Ă�񂾁`";
					mes "���ւցB";
				}
				else if(.@str$ == "�~�n�C��") {
					mes "[�A���i]";
					mes "�~�n�C���̘b�͕��������Ȃ��I";
					mes "�㒎�����A�����������I";
					mes "�n���Ȃ񂾂���I";
					next;
					mes "[�A���i]";
					mes "�j�̎q�͂����Ƌ����Ȃ�������";
					mes "�����Ȃ���!!";
					mes "�~�n�C���Ȃ�Ēm��Ȃ��I";
				}
				else {
					mes "[�A���i]";
					mes "��`";
					mes "�����낤�H";
					mes "���A�m��ȁ`���B";
				}
				break;
			case 5:
				mes "[�A���i]";
				mes "����I";
				mes "�b�����ƂȂ�Ė����́I";
				next;
				mes "[�A���i]";
				mes "�ׁ[�[�[�[�[�����I";
				next;
				mes "-�A���i�͐���o����";
				mes "�@���Ɍ����Ă���B";
				mes "�@�ǂ����A���̎���";
				mes "�@�C�ɓ���Ȃ��݂�����-";
				close;
			}
		}
	case 3:
		mes "[" +strcharinfo(0)+ "]";
		mes "�A���i�ɕ����鎖�͑S�����������A";
		mes "^3131FF�A�b�v���c���[����^000000�֍s���Ă݂悤�B";
		close;
	case 25:
	case 100:
		mes "[�A���i]";
		mes "�������I�I";
		mes "�����Ȃ��񂾂���I";
		next;
		mes "-�A���i�͋@���������悤��-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�ǂ������́H";
		next;
		mes "[�A���i]";
		mes "�~�n�C�������ꂳ��ɍ����������́I";
		mes "�~�n�C���Ȃ񂩌����I";
		next;
		mes "[�J���[�i]";
		mes "�A���i!!";
		mes "�~�n�C���̂��Ƃ�";
		mes "���������񂶂Ⴀ��܂���I";
		mes "����Ȉ������ƌ����q�ɂ�";
		mes "�p���P�[�L������Ă����܂����I";
		next;
		mes "[�A���i]";
		mes "���I�I�I�I�I�I";
		next;
		emotion 28;
		mes "[�A���i]";
		mes "���`�c�c";
		mes "���߂�Ȃ����c�c";
		close;
	default:
		if(MOSK_2QUE < 12) {
			mes "[�A���i]";
			mes "�~�n�C���͉��a�ҁI";
			mes "�~�n�C���̋������I";
			next;
			mes "[�A���i]";
			mes "���Ȃ��Ȃ�Ȃ�āA";
			mes "���邢����Ȃ��́c�c";
			mes " ";
			mes "-�A���i�͏����Ȑ���";
			mes "�@�������Ԃ₢�Ă���-";
			close;
		}
		mes "[�A���i]";
		mes "��`";
		mes "�Ё`�܁`";
		mes "�܂�ȁ`���I";
		next;
		mes "[�A���i]";
		mes "�����ʔ������Ɩ������ȁ`";
		close;
	}

}

mosk_in,136,279,0	script	�x�b�h#mosk1	111,{
	mes "-�x�b�h�̏�ɂ��Y���";
	mes "�@�z�c���������Ă���B";
	mes "�@�Y��Ńt�J�t�J�Ȗ����B";
	mes "�@���̃x�b�h�Ȃ炷����";
	mes "�@���ꂻ���ȋC������-";
	if(MOSK_2QUE != 11)
		close;
	next;
	if(select("���̕��𒲂ׂ�","�x�b�h���ڂ������ׂ�") == 1) {
		mes "-�x�b�h�𒲂ׂ�̂��~�߂�-";
		close;
	}
	mes "-�x�b�h�̏�𒲂׎n�߂�-";
	next;
	mes "-�܂��͕z�c���璲�ׂ�B";
	mes "�@�t�J�t�J�Ȏ�G�肾�B";
	mes "�@�����f�ނ��g���Ă���";
	mes "�@�̂��낤-";
	next;
	mes "-�z�c�ɂ͓��Ɉُ��";
	mes "�@�����悤��-";
	next;
	mes "-���𒲂׎n�߂�-";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "�I�I�I�I�I�I�I";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "�ō��̎�G��I";
	mes "�ɏ�̎����I";
	mes "�i���̖��͖{����";
	mes "�@�悭���ꂻ�����c�c�j";
	next;
	mes "-�x�b�h�ɂ͓��Ɉُ�͖�������-";
	close;
}
mosk_in,161,279,3	duplicate(�x�b�h#mosk1)	�x�b�h#mosk2	111

mosk_in,205,268,0	script	�Ηq	111,{
	switch(MOSK_2QUE) {
	case 0:
		mes "-�ƒ�p�̐Ηq������B";
		mes "�@�g�[�Ɨ����̋@�\��";
		mes "�@���˔������֗��ȁu���܁v��-";
		close;
	case 1:
		mes "-�J���[�i����";
		mes "�@�p���P�[�L���Ă���";
		mes "�@�g���ƌ����Ηq�B";
		mes "�@���N�g���Ă���ׂ��A";
		mes "�@�N���������Ă���-";
		set MOSK_2QUE,2;
		close;
	case 2:
	case 3:
	case 4:
	case 5:
	case 6:
	case 7:
	case 8:
	case 9:
	case 10:
		mes "-�J���[�i����";
		mes "�@�p���P�[�L���Ă���";
		mes "�@�g���ƌ����Ηq�B";
		mes "�@���N�g���Ă���ׂ��A";
		mes "�@�N���������Ă���-";
		close;
	case 11:
		mes "-�J���[�i����";
		mes "�@�p���P�[�L���Ă���";
		mes "�@�g���ƌ����Ηq�B";
		mes "�@���N�g���Ă���ׂ��A";
		mes "�@�N���������Ă���-";
		next;
		if(select("���̕��𒲂ׂ�","�Ηq���ڂ������ׂ�") == 1) {
			mes "-�Ηq�𒲂ׂ�̂���߂�-";
			close;
		}
		mes "-�Ηq�𒲂׎n�߂�-";
		next;
		mes "-�܂��͐Ηq�̎��ӂ𒲂ׂ�B";
		mes "�@�ۉ������������ȗǂ��΂�";
		mes "�@�g���Ă���悤��-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�c�c��H";
		mes " ";
		mes "-���������̍��肪���Ă���-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�i�ǂ���������Ă���̂��낤�H�j";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�I�I�I�I�I�I�I";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "���̓����́c�c";
		mes "�����̓���!?";
		next;
		mes "-�Ηq�̑O�Ƀp���̌��Ђ�";
		mes "�@�����Ă���I-";
		next;
		mes "-�p���̌��Ђ�͂�-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�����!?";
		next;
		switch(select("�~�n�C���͐Ηq�̒��ɂ���H","�~�n�C���͐Ηq�̋߂��ɂ���H","�p���̌��Ђƃ~�n�C���͊֌W�Ȃ��H")) {
		case 1:
			mes "-�Ηq�̎�����͂݁A";
			mes "�@�����悭�����J�����I-";
			next;
			mes "[�H�H�H�H]";
			mes "�����I";
			next;
			mes "-�Ηq�̉��̕�����";
			mes "�@�r�b�N�������悤��";
			mes "�@������������-";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�������I";
			next;
			mes "-�Ηq�̌��̒��Ɏ��L�΂�-";
			next;
			mes "-�q�̒�����L�΂������";
			mes "�@�����悤�ɑ̂𓮂�������";
			mes "�@�������Ă���-";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�i�|�����Ă���̂��ȁH�j";
			next;
			mes "-�����Ȑ��ł����₢�Ă݂�-";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�����ɂ���̂̓~�n�C���H";
			mes "����" +strcharinfo(0)+ "�B";
			mes "���ꂳ�񂩂�";
			mes "�~�n�C������̑{����";
			mes "���܂ꂽ�񂾂�B";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�~�n�C���ł��傤�H";
			next;
			mes "-���ق��Ԃ��Ă���-";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�~�n�C���B";
			mes "������o�Ă��Ă���Ȃ����ȁH";
			next;
			mes "-�ēx�A���ق��Ԃ��Ă���-";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�i�~�n�C���͋�����";
			mes "�@����̂�������Ȃ��B";
			mes "�@���������ĕ����Ă݂悤�j";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "���o�������A���ꂳ���";
			mes "�S�z���Ă����B";
			mes "��������o�Ă����ŁB";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�i���[��A���̔������������H�j";
			next;
			mes "[�H�H�H�H]";
			mes "�c�c�c�c�c�c����B";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�I�I�I�I�I�I�I�I";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "���Ă������́H";
			mes "�ǂ��������Ȃ���B";
			next;
			mes "[�~�n�C��]";
			mes "�c�c�c�c���߁c�c�c�c����B";
			mes "�{�N�c�c�c�c�{��ꂿ�Ⴄ�c�c�c�c";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "����Ȏ��Ȃ���B";
			mes "���̐S�z���Ă�̂��ȁH";
			next;
			mes "[�~�n�C��]";
			mes "�����āc�c�c�c�c";
			mes "�c�c�c���o����񂪁c�c�c";
			mes "�c�c�c�O�X���B";
			next;
			mes "-�~�n�C���͋����Ă���悤��-";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�F�S�z���Ă���񂾂�B";
			mes "���o����񂾂��ĐS�z���Ă����B";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�}�g�����[�V�J�l�`���󂵂��̂�";
			mes "�킴�Ƃ���Ȃ���ł��傤�H";
			mes "�F�m���Ă��邩����v����I";
			next;
			mes "[�~�n�C��]";
			mes "���`�c�c�O�X���B";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�����������̂��b���Ă����B";
			next;
			mes "[�~�n�C��]";
			mes "�c�c�}�g�����[�V�J�c�c";
			mes "�l�`�c�c";
			mes "�{�N���󂵂��킯����c�c������B";
			next;
			mes "[�~�n�C��]";
			mes "���˂��c�c�����";
			mes "���o����񂪁c�c�󂵂��񂾁B";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "��!?";
			next;
			mes "[�~�n�C��]";
			mes "���o����񂪃{�N��";
			mes "�m��Ȃ�������";
			mes "���ꂳ��̍����";
			mes "�p���P�[�L��H�ׂĂ��񂾁c�c";
			next;
			mes "[�~�n�C��]";
			mes "����Łc�c�{�N�ɂ����傤����";
			mes "���Č�������A";
			mes "���o����񂪓{�肾�����񂾁B";
			next;
			mes "[�~�n�C��]";
			mes "���o����񂾂����H�ׂ�̂�";
			mes "���邢���Č����Ԃ�����A";
			mes "����͎���������񂾂���";
			mes "���Č����āA";
			mes "�߂��̃}�g�����[�V�J�l�`��";
			mes "����ŁA�{�N�ɓ������񂾁c�c";
			next;
			mes "[�~�n�C��]";
			mes "��������A�{�N�ɂ������āA";
			mes "�}�g�����[�V�J�l�`��";
			mes "���ɗ����āc�c";
			mes "�c�c�O�X���B";
			next;
			mes "[�~�n�C��]";
			mes "��ꂿ������c�c";
			mes "���`�c�c�O�X���B";
			next;
			mes "[�~�n�C��]";
			mes "����Ȃ̂Ɂc�c";
			mes "���o�����̓{�N���c�c";
			mes "�{�N���c�c�󂵂�����";
			mes "���ꂳ��Ɍ������񂾂���B";
			mes "�Y�Y�[�c�Y�Y�[�c�O�X���B";
			next;
			mes "-�~�n�C���̊�͋���������";
			mes "�@�N�V���N�V���ɂȂ��Ă���-";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�c�c���o�����ɓ�������";
			mes "��ꂽ�̂ɁA����͌���Ȃ������́H";
			next;
			mes "[�~�n�C��]";
			mes "�c�c����B";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "���ꂶ��A�������ꂳ���";
			mes "�{���̎��������ɍs�����B";
			next;
			mes "-�J���[�i�̏��֍s������";
			mes "�@�Ηq���痣��悤�Ƃ���-";
			next;
			mes "[�~�n�C��]";
			mes "���A�_������I";
			next;
			mes "-�Â��Ηq�̒�����";
			mes "�@�����Ȕ����肪�o�Ă���";
			mes "�@���̘r��͂�-";
			next;
			mes "[�~�n�C��]";
			mes "�_������c�c";
			mes "���ꂳ��c�c��΂ɓ{��B";
			next;
			mes "[�~�n�C��]";
			mes "�}�g�����[�V�J�l�`��";
			mes "���̐l�`�́c�c";
			mes "���΂��c�c������";
			mes "�`���Ȃ񂾂���c�c";
			mes "���`�c�c�O�X���B";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�i�}�g�����[�V�J�l�`��";
			mes "�@���k�����̌`���������̂��c�c";
			mes "�@���Ƃ������Ȃ����ȁH�j";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "���������Ȃ��ŁB";
			mes "�~�n�C���̓}�g�����[�V�J�l�`��";
			mes "�������Ƃ��Ă��񂾂���B";
			next;
			mes "[�~�n�C��]";
			mes "�ł��c�c�{�N����ڒ��܂�";
			mes "���ɂ����Ȃ������񂾂���B";
			mes "�c�c�V�N�V�N�B";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "���ꂶ��A�����ڒ��܂�";
			mes "����Ă��悤���H";
			mes "��������A�~�n�C����";
			mes "�}�g�����[�V�J�l�`�𒼂��āA";
			mes "���ꂳ��Ɏӂ�H";
			next;
			mes "[�~�n�C��]";
			mes "�ڒ��܁c�c";
			mes "�c�c�����ė��Ă����́H";
			next;
			mes "-�~�n�C���͐S�z�����Ȋ��";
			mes "�@���Ȃ�����A�������S�����悤��-";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�S�z���Ȃ��Ă����v!!";
			mes "�����Ɏ����Ă��Ă�����!!";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�i�ڒ��܂��c�c";
			mes "�@�悸�͍ޗ��̊m�F�����Ȃ��Ɓc�c";
			mes "�@^3131FF�u���[�N����̃��B�N�g�[��^000000��";
			mes "�@�ڂ��������Ă݂悤�j";
			set MOSK_2QUE,12;
			close;
		case 2:
			mes "-�p���̌��Ђ͐V�N�ȍ��肪����-";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�����A�N�����H�ׂ��̂��ȁH";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�i�~�n�C���͐Ηq��";
			mes "�@�߂��ɋ���C������";
			mes "�@�ǂ��ɂ���񂾂낤�H�j";
			close;
		case 3:
			mes "-�p���̌��Ђ����";
			mes "�@�����̍��肪���Ă���-";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "���̐Ηq�͍ŋߎg���ĂȂ�";
			mes "�悤�Ɍ����邯�ǁc�c";
			next;
			mes "-�p���̍���͎��ӂɕY���Ă���-";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "���̃p���̌��Ђ�";
			mes "�����̓����͂ǂ�����H";
			close;
		}
	case 12:
		mes "[" +strcharinfo(0)+ "]";
		mes "�ڒ��܂��c�c";
		mes "�i�悸��^3131FF�u���[�N����̃��B�N�g�[��^000000��";
		mes "�@�ڒ��܂̍ޗ���";
		mes "�@�ڂ��������Ă݂悤�j";
		close;
	case 24:
		mes "[" +strcharinfo(0)+ "]";
		mes "�~�n�C���I";
		next;
		mes "-�g���g���ƐΗq��@����";
		mes "�@�����J����-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�ڒ��܂������Ă�����I";
		next;
		mes "[�~�n�C��]";
		mes "�c�c��!?";
		mes "�{���ɁH";
		next;
		mes "-�Ηq�̉��̂ق�����";
		mes "�@�������l�q�̐�����������-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�{������I";
		mes "�����A�S�z����Ȃ�����";
		mes "�o�Ă����ŁI";
		next;
		hideoffnpc "�~�n�C��#mosk";
		mes "-�Ηq����~�n�C�����o�Ă���B";
		mes "�@�����ƐΗq�̒��ɂ������߂��A";
		mes "�@�~�n�C���͊D�܂݂ꂾ-";
		next;
		mes "-�~�n�C���͕s�������Ȋ�ŁA";
		mes "�@���߂Ă���-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�͂��I";
		next;
		mes "-�D�܂݂�̃~�n�C����";
		mes "�@���B�N�g�[������";
		mes "�@������ڒ��܂�n��-";
		next;
		mes "[�~�n�C��]";
		mes "�������[!!";
		mes "���ꂾ��!!";
		mes "���̐ڒ��܂������";
		mes "�������I";
		next;
		mes "-�~�n�C���͖ڂ��L���L��������";
		mes "�@���ł���-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�~�A�~�n�C���B";
		mes "�͂����A�D�������Ă�I";
		next;
		mes "-�~�n�C�����e�[�u����";
		mes "�@��ɂ������^�I����";
		mes "�@�Y��ɐ@��-";
		next;
		mes "-����ƁA�~�n�C����";
		mes "�@�ڒ��܂��I�݂Ɏg���A";
		mes "�@��ꂽ�}�g�����[�V�J�l�`��";
		mes "�@��p�Ɍq�����킹��-";
		next;
		mes "[�~�n�C��]";
		mes "�����!!";
		mes "��������I";
		mes "�{���ɂ��肪�Ƃ�!!";
		next;
		mes "-�~�n�C���͑労���̂悤���B";
		mes "�@������I�@������I�@�ƌ�����";
		mes "�@��ђ��˂Ă���-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�ǂ��v���܂��āB";
		mes "������A��񑩂����悤�B";
		next;
		mes "[�~�n�C��]";
		mes "�₭�����H";
		next;
		mes "-�~�n�C���͂���Ƃ�Ƃ��Ȃ���A";
		mes "�@�������߂�-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�����A�񑩁I";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "���ꂩ���";
		mes "�����ɋ����Ȃ����Ė񑩂��悤�B";
		next;
		mes "[�~�n�C��]";
		mes "�����ɋ����Ȃ��c�c�H";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�����I";
		mes "�}�g�����[�V�J�l�`��";
		mes "�������񂾂���A";
		mes "�����Ȃ�Ȃ�������ˁB";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�~�n�C���Ȃ牽������";
		mes "���Ή����ł���B";
		mes "������~�n�C����";
		mes "�����ɋ������肵�Ȃ����I";
		next;
		mes "[�~�n�C��]";
		mes "�ł��c�c";
		mes "�{�N�������ĂȂ��B";
		mes "�����ł��Ȃ������B";
		mes "�c�c������c�c�c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "����Ȃ��ƂȂ���B";
		mes "�l�`�𒼂��ׂɁA";
		mes "�~�n�C���͕K����";
		mes "���������񂾂���B";
		next;
		mes "-�~�n�C���̓n�b�Ƃ����ڂ�";
		mes "�@�������Ԃ�-";
		next;
		mes "[�~�n�C��]";
		mes "����B";
		mes "�킩�����B";
		mes "�{�N�A�����ɋ������肵�Ȃ���B";
		next;
		mes "-�~�n�C���͏Ί�Ŗ񑩂�����-";
		next;
		mes "[�~�n�C��]";
		mes "���ꂶ��A�{�N�c�c";
		mes "���ꂳ��Ƀ}�g�����[�V�J�l�`��";
		mes "�Ԃ��āA�ӂ��Ă����B";
		next;
		mes "[�~�n�C��]";
		mes strcharinfo(0)+ "�B";
		mes "���낢��Ƃ��肪�Ƃ��I";
		next;
		mes "-�~�n�C���͌��C��t��";
		mes "�@����̌��t�����ɓ��������A";
		mes "�@�J���[�i�̕����̕���";
		mes "�@�����Ă�����-";
		hideonnpc "�~�n�C��#mosk";
		delitem 7764,1;
		set MOSK_2QUE,25;
		next;
	default:
		mes "-�ƒ�p�̐Ηq������B";
		mes "�@�g�[�Ɨ����̋@�\��";
		mes "�@�������˔����Ă���悤��-";
		close;
	}
}

mosk_in,202,269,5	script	�~�n�C��#mosk	962,{
	end;
OnInit:
	hideonnpc;
	end;
}

mosk_in,135,191,5	script	���ق̏�������	961,{
	mes "[���ق̏�������]";
	mes "����A��������Ⴂ�I";
	mes "�����̓��X�R�r�A����̗��فA";
	mes "�A�b�v���c���[��I";
	next;
	switch(MOSK_2QUE) {
	case 3:
		switch(select("�ʒu���Z�[�u����","�x�� - 5000z","�~�n�C���̎��𕷂�")) {
		case 1:
			savepoint "mosk_in",142,189;
			mes "[���ق̏�������]";
			mes "�͂��A�ʒu�Z�[�u�������B";
			mes "�܂���낵�����肢�ˁB";
			close;
		case 2:
			if(Zeny < 5000){
				mes "[���ق̏�������]";
				mes "���ق̗��p���� 5000z ��B";
				mes "���������m���߂Ă��傤�����ˁH";
				close;
			}
			mes "[���ق̏�������]";
			mes "�������Ƌx��ł�������Ⴂ�B";
			close2;
			set Zeny,Zeny-5000;
			percentheal 100,100;
			warp "mosk_in",215,181;
			end;
		case 3:
			emotion 3;
			mes "[���ق̏�������]";
			mes "���炠��A�n���T���Ȃ��Z����ˁB";
			mes "�ł��A���̔��̂����Ȃ̂�����H";
			mes "��F��������ƈ����݂�����B";
			next;
			mes "[���ق̏�������]";
			mes "�ǂ��H�@���q����̔������";
			mes "�ō����̃X�C�[�g���[����������B";
			mes "��Ӕ��܂��Ă����Ȃ��H";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "���́c�c���݂܂���B";
			mes "���܂�ɗ����񂶂�Ȃ��āc�c";
			mes "������ƕ�����������";
			mes "�����ł����ǁc�c";
			next;
			emotion 23;
			mes "[���ق̏�������]";
			mes "���ł�����!?";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "���A�����c�c";
			mes "�����������Ƃ���";
			mes "������ł��B";
			mes "�~�n�C���N�̂��Ƃŏ����c�c";
			next;
			mes "[���ق̏�������]";
			mes "���`��A�����Ȃ́B";
			mes "�~�n�C������̂��ƂȂ̂ˁB";
			next;
			mes "-���ق̏����͈�u����";
			mes "�@�l�����ނ��Ԃ��������-";
			next;
			mes "[���ق̏�������]";
			mes "���𕷂������̂���";
			mes "�킩��Ȃ�����Ǎl���Ă݂���A";
			mes "������΂���̗��l�����";
			mes "�~�n�C������̂��Ƃ�";
			mes "�ȒP�ɋ�����킯�ɂ�";
			mes "�����Ȃ���ˁB";
			next;
			mes "[���ق̏�������]";
			mes "���q����Ȃ�~�n�C������̂��Ƃ�";
			mes "�T�[�r�X���Ă��������Ƃ��낾���ǁA";
			mes "�����̒ʂ肷����̗��l��";
			mes "�����܂Őe�؂ɂ���`���Ȃ��";
			mes "�����Ǝv���܂���H";
			next;
			mes "[���ق̏�������]";
			mes "�����ˁ`";
			mes "���̗��قň�Ӕ��܂�����A";
			mes "�~�n�C������̂��Ƃ�";
			mes "�����Ă����悤������B";
			mes "�ǂ��H�@��Ӕ��܂��Ă݂Ȃ��H";
			next;
			if(select("�f��","��Ӕ��܂��āA�~�n�C���̂��Ƃ𕷂� - 5000z") == 1) {
				emotion 7;
				mes "[���ق̏�������]";
				mes "����H�@���܂��Ă���Ȃ��́H";
				mes "���ł��҂��Ă邩��A";
				mes "��������Ⴂ�ˁB";
				close;
			}
			if(Zeny < 5000){
				mes "[���ق̏�������]";
				mes "����c�c";
				mes "���Ȃ�����������Ȃ�����Ȃ��́B";
				mes "��₩���̓_����B";
				mes "���ł��҂��Ă邩��A";
				mes "��������Ⴂ�ˁB";
				close;
			}
			mes "[���ق̏�������]";
			mes "���`��A�C�O��������ˁI";
			mes "�����A������ւǂ����`";
			next;
			mes "[���ق̏�������]";
			mes "�����オ���Ă��������ˁ`";
			mes "�������A�ו��͎��������܂�����B";
			mes "���ꂶ��A�������x���";
			mes "���������ˁB";
			close2;
			set MOSK_2QUE,4;
			set Zeny,Zeny-5000;
			percentheal 100,100;
			warp "mosk_in",215,181;
			end;
		}
	case 4:
	case 5:
		mes "[���ق̏�������]";
		mes "���`��A���N���Ȃ̂ˁI";
		mes "���Ȃ��Ⴂ���猳�C��";
		mes "����]���Ă���̂�����B";
		mes "�ӂӂӁB";
		while(1) {
			next;
			switch(select("�A�b�v���c���[���قɂ��ĕ���","�~�n�C���ɂ��ĕ���","��b����߂�")) {
			case 1:
				mes "[���ق̏�������]";
				mes "���̗��ق́A�X�̊O�ɂ���";
				mes "�傫�������S�̖؂��疼�O��";
				mes "����Ă�̂�B";
				next;
				mes "[���ق̏�������]";
				mes "���̐X�̒��ŁA�����̑��݊���";
				mes "��������Əo���Ă��郊���S��";
				mes "�؂̗l�ɁA���̃��X�R�r�A��";
				mes "�����ɂȂ��ė~�����Ǝv���āA";
				mes "���Â������O�Ȃ́B";
				mes "�ӂӂӁB";
				break;
			case 2:
				mes "[���ق̏�������]";
				mes "�~�n�C������̘b��������ˁB";
				mes "�������A�C�o�m�b�t�Ƃ�";
				mes "���q�����ˁH";
				mes "���������΁A�ŋߗ��Ă���ˁc�c";
				next;
				mes "[���ق̏�������]";
				mes "�����󂵂��݂����ŁA";
				mes "�ڒ��܂��K�v���Č����Ă����ǁA";
				mes "��F�������ĂˁB";
				next;
				mes "[���ق̏�������]";
				mes "�u���u���k���Ă����̂�c�c";
				mes "���𗎂Ƃ��āA";
				mes "�{���ɉ��z�Ɍ�������B";
				next;
				mes "[" +strcharinfo(0)+ "]";
				mes "����ŁA�ǂ��Ȃ�܂����H";
				mes "�~�n�C���ɐڒ��܂������܂������H";
				next;
				mes "[���ق̏�������]";
				mes "�����A���ꂪ�ˁc�c";
				mes "���͂������������̎���";
				mes "�����ς蕪����Ȃ��āc�c";
				mes "��l�͏ڂ������ǁc�c";
				mes "���́c�c����ł����c�c";
				next;
				mes "[���ق̏�������]";
				mes "����Łc�c";
				next;
				mes "[" +strcharinfo(0)+ "]";
				mes "�c�c����ŁH";
				next;
				mes "[���ق̏�������]";
				mes "���̕����̎����";
				mes "�m���Ă���j�����邩��A";
				mes "�����ŕ����Ă݂�����āA";
				mes "�����Ă������̂�B";
				mes "�������A�~�n�C������͎q��������";
				mes "��������ł̓_�����Ē������ĂˁB";
				next;
				mes "[" +strcharinfo(0)+ "]";
				mes "����ŁA�~�n�C���͎����";
				mes "�s���܂����H";
				next;
				mes "[���ق̏�������]";
				mes "�����ˁB";
				mes "���̎q�c�c�{���ɕK�����������c�c";
				mes "����ɍs�����Ǝv����B";
				mes "����ȕ\��ŗ��܂ꂽ���ƂȂ�āA";
				mes "���܂łȂ������񂾂���B";
				mes "����ۂǂ̂��Ƃ���������ł��傤�ˁB";
				next;
				mes "[" +strcharinfo(0)+ "]";
				mes "�����ł����c�c";
				mes "�킩��܂����B";
				next;
				mes "[���ق̏�������]";
				mes "���Ȃ��ɔ��܂��Ă�������̂�";
				mes "���̂��炢�^���ɂȂ��Ă���l�ɂ���";
				mes "���������Ȃ���������Ȃ̂�B";
				mes "�����m�炸�̐l��";
				mes "�b�����Ƃł͂Ȃ�����B";
				next;
				mes "[���ق̏�������]";
				mes "���������B";
				mes "���܂育�����͗ǂ�����������H";
				mes "�܂��A������ꂽ�痈�Ă��傤�����B";
				mes "���ł��A�҂��Ă���I";
				next;
				mes "[" +strcharinfo(0)+ "]";
				mes "�i�~�n�C���͎����";
				mes "�@�s�����̂��ȁH";
				mes "�@���̕����̎����";
				mes "�@�b�𕷂��Ă݂悤�j";
				set MOSK_2QUE,7;
				close;
			case 3:
				mes "[���ق̏�������]";
				mes "����H�@�x�܂Ȃ��́H";
				next;
				mes "[���ق̏�������]";
				mes "�x�݂����Ȃ�A��΂�����B";
				mes "�A�b�v���c���[���ق�";
				mes "���鏊�͂Ȃ���!!";
				mes "�㎿�ȃT�[�r�X�𐮂��āA";
				mes "�҂��Ă��!!";
				close;
			}
		}
	default:
		if(select("�ʒu�Z�[�u����","�x�� - 5000z") == 1) {
			savepoint "mosk_in",142,189;
			mes "[���ق̏�������]";
			mes "�͂��A�Z�[�u������B";
			mes "�����p���肪�Ƃ��������܂��ˁB";
			close;
		}
		if(Zeny < 5000) {
			mes "[���ق̏�������]";
			mes "���ٗ��p���� 5000z �ł���B";
			mes "���������m���߂Ă��傤�����ˁB";
			close;
		}
		mes "[���ق̏�������]";
		mes "�ł́A���������ǂ����B";
		close2;
		set Zeny,Zeny-5000;
		warp "mosk_in",215,181;
		percentheal 100,100;
		end;
	}
}

mosk_in,215,181,0	script	�h��#mosk	139,1,1,{
	if(MOSK_2QUE != 4)
		end;
	mes "[" +strcharinfo(0)+ "]";
	mes "�O�[�c�c�O�[�c�c";
	mes "�c�c�c�c�c�c�c�c";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "�O�[�c�c�O�[�c�c";
	mes "�c�c�c�c�c�c�c�c";
	mes "���j�����j���c�c";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "�O�[�c�c�O�[�c�c";
	mes "�c�c�c�c�c�c�c�c";
	mes "���j�����j���c�c";
	mes "�E�[���c�c�c�c�c";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "�t�@�A�A�c�c�c�c";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "�t�@�A�A�c�c�c�c";
	mes "�c�c�c�c�c�c���H";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "�Q���������ȁc�c";
	mes "�����Ԃ��炢�Q���񂾂�c�c";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "�~�n�C���̂��Ƃ𕷂����߂�";
	mes "���܂������ǁA�ǂ����قł�";
	mes "�������̂����B";
	mes "��ꂪ��ꂽ�݂��������B";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "�i�Ƃ肠�����A��Ӕ��܂�����";
	mes "�@��������̏��֍s���Ă݂悤���ȁB";
	mes "�@�񑩂����~�n�C���̂��Ƃ�";
	mes "�@�����Ă݂悤�j";
	set MOSK_2QUE,5;
	close;
}

mosk_in,141,212,3	script	�p�u�̃}�X�^�[	964,{
	switch(MOSK_2QUE) {
	case 7:
		mes "[�p�u�̃}�X�^�[]";
		mes "��������Ⴂ�I";
		mes "�ǂ�Ȑl�ł����}�ł���I";
		mes "������^3131FF�u���[�N����^000000";
		mes "�A���N�T���h���B";
		mes "���̂��Ƃ́u�V���V���v��";
		mes "�Ă�ł��������B";
		next;
		if(select("�~�n�C���̍s���𕷂�","���ݕ��𗊂�") == 2) {
			mes "[�V���V��]";
			mes "�`���҂̕��ł����c�c";
			mes "�������Ⴂ�ł��ˁB";
			mes "�ӂށc�c���q����ɂ�";
			mes "�����̈��ݕ���";
			mes "�ǂ���������܂���ˁB";
			mes "�ǂ����ɂ��܂����H";
			next;
			switch(select("�~���N - 1000z","�����S�W���[�X - 1000z","�����ł�!!")) {
			case 1:
				set .@itemid,519;
				break;
			case 2:
				set .@itemid,531;
				break;
			case 3:
				mes "[�V���V��]";
				mes "�n�n�b�B";
				mes "�ό��n�Ƃ͂����������̂ł���B";
				mes "����ɁA�����͎���ł����ˁB";
				mes "���q�������t�ǂ��ł��H";
				close;
			}
			if(Zeny < 1000) {
				mes "[�V���V��]";
				mes "���q����B";
				mes "����������Ȃ��݂����ł��ˁc�c";
				mes "�����珤����������āA";
				mes "�������Ă킯�ɂ͍s���܂����B";
				next;
				mes "[�V���V��]";
				mes "�܂��c�c";
				mes "���s��`���ɂ�";
				mes "��������������K�v�Ȃ̂�";
				mes "�킩��܂����ǂˁB";
				close;
			}
			set Zeny,Zeny-1000;
			getitem .@itemid,1;
			set MOSK_2QUE,9;
			mes "[�V���V��]";
			mes "�͂��A��������" +getitemname(.@itemid)+ "�ł��I";
			mes "���X�R�r�A�̈�ۂ͂������ł����H";
			next;
		}
		mes "[" +strcharinfo(0)+ "]";
		mes "�V���V���A";
		mes "�ŋ߃~�n�C���ƌ����j�̎q��";
		mes "�����ɗ��Ȃ������H";
		next;
		mes "[�V���V��]";
		mes "���I�@�������V�����ł���ˁH";
		mes "�͂��A�m���ɗ��Ă܂�����B";
		mes "�K���Ȋ�ŁA���͂Ȑڒ��܂�";
		mes "�K�v���ƌ����Ă܂����ˁB";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "����ŁA�~�n�C���ɂȂ�āH";
		next;
		mes "[�V���V��]";
		mes "�c�O�ł����A���͐ڒ��܂̎���";
		mes "�m��܂���B";
		mes "�ł�����A�ڒ��܂̎���";
		mes "�ڂ����j���Љ�Ă����܂�����B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "����͒N�ł����H";
		next;
		mes "[�V���V��]";
		mes "�����̋��ň���ł���j�A";
		mes "���B�N�g�[���ł��B";
		mes "���\�A�q�X�e���b�N�Ȑl�ł��āA";
		mes "^3131FF�n���l�Y�~�̃��B�N�g�[��^000000��";
		mes "�Ă΂�Ă܂��ˁc�c";
		next;
		mes "[�V���V��]";
		mes "�܂��A�ڒ��܂Ɋւ��ẮA";
		mes "��ԏڂ����Ǝv���܂���B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�V���V���A���肪�Ƃ�!!";
		next;
		mes "[�V���V��]";
		mes "�ǂ��v���܂��ā`";
		if(MOSK_2QUE != 9)
			set MOSK_2QUE,8;
		close;
	case 8:
		mes "[�V���V��]";
		mes "����œ����ƁA�F��Ȃ��q�����";
		mes "�b�������܂��ˁB";
		mes "�F��Ȑl���̗l�X�Șb�c�c";
		mes "������ӂ̏�������";
		mes "�^�ɔ����Ă��Ėʔ����ł���B";
		next;
		mes "[�V���V��]";
		mes "���q���񂽂��̘b�𕷂��Ă���ƁA";
		mes "����Ȃ�āA�����Ƃ����Ԃ�";
		mes "�߂��Ă��܂��܂����ˁB";
		mes "�p�u�̃}�X�^�[��";
		mes "�{���Ɋy�������̂ł���B";
		mes "�n�n�n�B";
		next;
		mes "[�V���V��]";
		mes "���q����̘b��";
		mes "�������Ă���܂��񂩁H";
		mes "����Ƃ��A���������ݕ���";
		mes "��ɏo���܂��傤���H";
		next;
		switch(select("�~���N - 1000z","�����S�W���[�X - 1000z","�������܂��I")) {
		case 1:
			set .@itemid,519;
			break;
		case 2:
			set .@itemid,531;
			break;
		case 3:
			mes "[�V���V��]";
			mes "�n�n�b�B";
			mes "�ό��n�Ƃ͂����������̂ł���B";
			mes "����ɁA�����͎���ł����ˁB";
			mes "���q�������t�ǂ��ł��H";
			close;
		}
		if(Zeny < 1000) {
			mes "[�V���V��]";
			mes "���q����B";
			mes "����������Ȃ��݂����ł��ˁc�c";
			mes "�����珤����������āA";
			mes "�������Ă킯�ɂ͍s���܂����B";
			next;
			mes "[�V���V��]";
			mes "�܂��c�c";
			mes "���s��`���ɂ�";
			mes "��������������K�v�Ȃ̂�";
			mes "�킩��܂����ǂˁB";
			close;
		}
		set Zeny,Zeny-1000;
		getitem .@itemid,1;
		set MOSK_2QUE,9;
		mes "[�V���V��]";
		mes "�����A��������" +getitemname(.@itemid)+ "�ł��B";
		mes "���������ǂ����B";
		close;
	case 9:
		mes "[�V���V��]";
		mes "���B�N�g�[���Ƃ�";
		mes "�b���Ă݂܂������H";
		close;
	default:
		mes "[�p�u�̃}�X�^�[]";
		mes "��������Ⴂ�I";
		mes "������^3131FF�u���[�N����^000000�A���N�T���h���B";
		mes "���̂��Ƃ́u�V���V���v��";
		mes "�Ă�ł��������B";
		next;
		mes "[�p�u�̃}�X�^�[]";
		mes "�����������V�C�ł��ˁB";
		mes "�����O�֔�яo����";
		mes "�s���������炢�ł���B";
		mes "�n�n�n�n�n�B";
		close;
	}
}

mosk_in,147,202,3	script	���B�N�g�[��	968,{
	switch(MOSK_2QUE) {
	case 8:
		mes "[" +strcharinfo(0)+ "]";
		mes "���́c�c";
		mes "�����������������ł����ǁA";
		mes "�������b�𕷂��Ă��������Ă�";
		mes "�����ł����H";
		next;
		mes "[���B�N�g�[��]";
		mes "�N�͒N�����H";
		mes "�l�̋M�d�Ȏ��Ԃ�݂����Ă����́H";
		mes "���Ă̒ʂ�A�l�̓O���X�̒��̎���";
		mes "�����Ɋy����ł���Œ��Ȃ񂾁B";
		mes "�M�d�Ȏ��Ԃ𖳑ʂɎ��Ȃ��ł���B";
		next;
		mes "[���B�N�g�[��]";
		mes "�N�͂����Ɉ��݂�";
		mes "�����񂶂�Ȃ��̂����H";
		next;
		mes "-���B�N�g�[���͎����";
		mes "�@��������ł��Ȃ�����";
		mes "�@�C�ɓ���Ȃ��悤��-";
		close;
	case 9:
		mes "[" +strcharinfo(0)+ "]";
		mes "���́c�c";
		mes "�����������������ł����ǁA";
		mes "�������b�𕷂��Ă��������Ă�";
		mes "�����ł����H";
		next;
		mes "[���B�N�g�[��]";
		mes "�N�͒N�����H";
		mes "�l�̋M�d�Ȏ��Ԃ�݂�����";
		mes "�����̂����H";
		mes "���Ă̒ʂ�A�l�̓O���X�̒��̂�����";
		mes "�����Ɋy����ł���Œ��Ȃ񂾁B";
		mes "�M�d�Ȏ��Ԃ𖳑ʂɎ��Ȃ��ł���B";
		next;
		mes "[���B�N�g�[��]";
		mes "��H";
		mes "�N�������Ɉ��݂ɗ��Ă���̂��H";
		mes "�܂��A�����B";
		mes "��l�ň��ގ��͂܂�������ˁI";
		next;
		mes "[���B�N�g�[��]";
		mes "��[���A���ʂɈ��݂Ȃ���";
		mes "�b�𕷂����B";
		mes "���������ɘb���Ă���I";
		next;
		mes "-���B�N�g�[���͍�����";
		mes "�@�������݂Ȃ���A";
		mes "�@���Ԃ悤�ɘb��؂�o����-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "���[�Ɓc�c";
		mes "�ڒ��܂�T���Ă���q����";
		mes "��܂���ł����H";
		next;
		mes "[���B�N�g�[��]";
		mes "��[�c�c�c�c�c�c�c";
		next;
		mes "[���B�N�g�[��]";
		mes "����́c�c";
		mes "�~�n�C���̎����H";
		mes "�~�n�C�����ǂ��������̂��H";
		next;
		mes "[���B�N�g�[��]";
		mes "�܂��A�ŋ߉�����~�n�C����";
		mes "�����l�q���ς��������ǂȁc�c";
		mes "�l�͉������ĂȂ����H";
		mes "���Ń~�n�C���̂��Ƃ𕷂������񂾁H";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�~�n�C�������ꂳ���";
		mes "�}�g�����[�V�J�l�`��";
		mes "�󂵂��݂����ŁA";
		mes "�l�`�𒼂��ׂɐڒ��܂�T���ɁA";
		mes "���Ȃ��̏��ɂ����Ǝv����ł��B";
		next;
		mes "-���B�N�g�[���͔��������߂�-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�~�n�C���͉Ƃ��o�Ă���";
		mes "�����ɋA���Ă��Ă��܂���B";
		mes "�~�n�C�����ǂ��ɍs�����̂�";
		mes "�킩��Ȃ����āA";
		mes "�Ƒ����S�z���Ă����ł��B";
		next;
		mes "[���B�N�g�[��]";
		mes "�c�c�c�c�c�c���H";
		mes "����́c�c�܂����ȁc�c";
		mes "�܂����c�c�������ɍs�������";
		mes "���ĂȂ���ȁc�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�������c�c�H";
		next;
		mes "[���B�N�g�[��]";
		mes "�����B";
		mes "�o�o���K��|����������";
		mes "�������񐶑����Ă��鏊����B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "���̏ꏊ�͂ǂ��ł����H";
		next;
		mes "[���B�N�g�[��]";
		mes "�������ȁc�c";
		mes "�c�c�Ȃ�Ƃ������B";
		next;
		mes "-���B�N�g�[���ɂ�";
		mes "�@���������ɂ������Ƃ�";
		mes "�@����悤��-";
		next;
		mes "[���B�N�g�[��]";
		mes "�~�n�C���́c�c";
		mes "�����Ȃ���ڒ��܂��K�v���ƁA";
		mes "�����Ă���B";
		mes "�ǂ����Ă������Ȃ��Ⴂ���Ȃ�";
		mes "���Č��������Ăˁc�c";
		next;
		mes "[���B�N�g�[��]";
		mes "�����͌����Ă��q���̂���������H";
		mes "�ŏ��͎q���̂킪�܂܂�";
		mes "�����Ă���񂾂낤����";
		mes "�����Ă��񂾂��ǁc�c";
		next;
		mes "[���B�N�g�[��]";
		mes "�܂��A�~�n�C�������܂��";
		mes "�^������������A";
		mes "�l�����č��f���āc�c";
		mes "�ڒ��܂̍ޗ��̏ꏊ��";
		mes "�����Ă������񂾂�B";
		next;
		mes "[���B�N�g�[��]";
		mes "�c�c�l�͐ڒ��܂ɏڂ������ǁA";
		mes "������������͂��ĂȂ��񂾁B";
		mes "������A�ޗ��������ė���΁A";
		mes "�ڒ��܂�����Ă������";
		mes "�񑩂����̂��B";
		next;
		mes "[���B�N�g�[��]";
		mes "�ڒ��܂̍ޗ��́A";
		mes "���X�R�r�A�̊X����";
		mes "�����Ɖ����ɍs����";
		mes "���J�̓��ɂ���񂾁B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "���J�̓��c�c";
		next;
		mes "[���B�N�g�[��]";
		mes "�����A���J�̓����B";
		mes "�قƂ�ǐl�Ԃ̎肪�����Ă��Ȃ�";
		mes "��t�����̓�������񂾂�B";
		next;
		mes "[���B�N�g�[��]";
		mes "���̓��̒��ɏ���������";
		mes "���̒����ɐڒ��܂�";
		mes "�ޗ�������񂾁B";
		next;
		mes "[���B�N�g�[��]";
		mes "���̓��ɂ͋��낵��";
		mes "�����X�^�[������";
		mes "�������񂢂�B";
		mes "�ƂĂ��댯�ȓ�����B";
		next;
		mes "[���B�N�g�[��]";
		mes "�����āA���ɂ̓o�o���K�Ƃ���";
		mes "�����X�^�[������c�c";
		mes "�ɂ߂��̓o�o���K�̑�D���c�c";
		mes "�c�c�c�c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "��D���́H";
		next;
		mes "[���B�N�g�[��]";
		mes "�o�o���K�̑�D���́c�c";
		mes "�q���Ȃ񂾁c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "����!?";
		next;
		mes "[���B�N�g�[��]";
		mes "�~�n�C���݂�����";
		mes "�����q������ƁA�悾����o����";
		mes "��т����낤�ˁc�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "����ȁc�c";
		next;
		mes "[���B�N�g�[��]";
		mes "�܂��c�c�F�X�|���b�̓~�n�C����";
		mes "���Ă��������c�c";
		mes "����ȋ������������܂ōs���킯��";
		mes "�Ȃ����c�c";
		next;
		mes "[���B�N�g�[��]";
		mes "�܂��A������Ƒ傰���Ɍ��������ǁA";
		mes "�ł��A��Ȃ����ł���̂͊m������H";
		mes "����ɁA�~�n�C���̗l�Ȏq����";
		mes "�����֍s���Ȃ�āA��΂ɖ�������B";
		next;
		mes "[���B�N�g�[��]";
		mes "�������A�ŋ߂͖��J�̓��ɍs��";
		mes "�D�͖����񂾁B";
		mes "���̓��̕t�߂͊C����������";
		mes "�{���ɑ傫�ȑD����Ȃ���";
		mes "�ߊ�邱�Ƃ��ł��Ȃ��̂��B";
		next;
		mes "[���B�N�g�[��]";
		mes "�~�n�C���͎�����";
		mes "�s���Ȃ��������Ă킩���";
		mes "�����̂���߂�";
		mes "�ق荞�񂶂���Ă��B";
		next;
		mes "[���B�N�g�[��]";
		mes "������A�����ɂ�";
		mes "�l�̎��̂܂݂�����";
		mes "�p�������������񂾂�B";
		next;
		mes "[���B�N�g�[��]";
		mes "�ڒ��܂̍ޗ��W�߂͒��߂�";
		mes "�ƂɋA��悤�Ɍ����Ă�������B";
		next;
		mes "[���B�N�g�[��]";
		mes "�}�g�����[�V�J�l�`��";
		mes "�󂵂������ŁA";
		mes "����ȂɕK���ɂȂ�Ȃ�ĂˁB";
		next;
		mes "[���B�N�g�[��]";
		mes "�܂��A�ŋ߂͑D���o�Ă��Ȃ����A";
		mes "�ޗ������߂ɏ��܂ł�";
		mes "�s���Ȃ��Ǝv�����ǂˁc�c";
		next;
		mes "[���B�N�g�[��]";
		mes "�Ƃ͂����A���ꂩ��~�n�C���̎p��";
		mes "�����Ȃ����Ƃ͋C�ɂȂ�ˁc�c";
		mes "�̂̂悤�ɑ傫�ȑD�̂悤��";
		mes "��蕨������ƍs����񂾂낤���ǁc�c";
		mes "�܂����c�c�ȁB";
		next;
		mes "-����������ĕʂ��������-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�i���B�N�g�[���͉Ƃɂ����";
		mes "�@�����Ă��邯�ǁA";
		mes "�@�{���ɉƂɂ���̂��낤���B";
		mes "�@���������āA�~�n�C����";
		mes "�@���J�̓��֌�������";
		mes "�@���܂����̂ł͂Ȃ����낤���H�j";
		next;
		mes "-�s�����悬��-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�i���Ȃ�~�n�C����";
		mes "�@�ǂ����邩������Ȃ��B";
		mes "�@���J�̓��̏��̒��c�c";
		mes "�@�~�n�C�����������Ƃ�����A";
		mes "�@���������Ȃ����ǁA";
		mes "�@�ǂ�����āc�c�j";
		set MOSK_2QUE,10;
		close;
	case 10:
	case 11:
		mes "[���B�N�g�[��]";
		mes "���X�R�r�A�̎���ɂ�";
		mes "�傫�Ȗ��J�̓�������B";
		mes "�̂͒���I�ɑD���łĂ������ǁA";
		mes "���͍s���l�͏��Ȃ��񂶂�Ȃ����ȁB";
		mes "�܂��A�ǂ������킯��";
		mes "���̓��̉\�b�͎��ɓ��邩��ˁc�c";
		next;
		mes "[���B�N�g�[��]";
		mes "���̐X�̉��ɂ͏��������ĂˁB";
		mes "���̏��̒�����";
		mes "�ڒ��܂̍ޗ��ƂȂ�";
		mes "�l�`���l�`�����鑐��";
		mes "�����Ă���񂾁B";
		next;
		mes "[���B�N�g�[��]";
		mes "�܂��A������K���ł��A";
		mes "����Ȃɑ�ςȓ���";
		mes "�~�n�C���̂悤�Ȏq����";
		mes "�s����Ƃ͎v���Ȃ����ǂȁB";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�i�~�n�C���͂܂��������Ă��Ȃ��B";
		mes "�@����ς�A�~�n�C���͖��J�̓���";
		mes "�@���������̂��낤���H";
		mes "�@���J�̓��̏��̒��c�c";
		mes "�@�~�n�C�����������Ƃ�����A";
		mes "�@�������낤���ǁc�c�j";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�i�Ȃ�Ƃ���������";
		mes "�@�݂邵���Ȃ����c�c�j";
		close;
	case 12:
		mes "[���B�N�g�[��]";
		mes "�܂������̂��H";
		mes "�܂����c�c";
		mes "�~�n�C�������Ȃ��Ȃ�������";
		mes "�l�̂����ɂ���C�Ȃ̂����H";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�~�n�C���͌����܂�����B";
		mes "�S�z�ɂ͋y�т܂���B";
		next;
		mes "[���B�N�g�[��]";
		mes "�������A����͗ǂ������B";
		mes "�Ȃ�c�c�l�ɉ��̗p�����H";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�~�n�C���̑����";
		mes "�����ڒ��܂���낤��";
		mes "�v���܂��āA������������";
		mes "����������ł����ǁB";
		next;
		mes "[���B�N�g�[��]";
		mes "�ւ��c�c�������B";
		mes "��ꂽ�}�g�����[�V�J�l�`��";
		mes "�ǂ�ȏ�ԂȂ񂾂��H";
		mes "���������܂ł��Ē����K�v��";
		mes "���镨�Ȃ̂��H";
		mes "�܂��A�l�̒m�������ł͂Ȃ����ǁc�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�c�c�c�c�c�c�c�c";
		next;
		mes "[���B�N�g�[��]";
		mes "�킩�����c�c";
		mes "�����Ă������B";
		mes "���Ȃ�ʁA�~�n�C���̂��Ƃ����B";
		mes "����ȃ~�n�C��������Ă�������A";
		mes "�{���ɂ��̓��֍s�����˂Ȃ����ȁB";
		next;
		mes "-���B�N�g�[���̓~�n�C����";
		mes "�@���Ƃ��v���o�����̂��A";
		mes "�@��΂��Ȃ���ꂢ��-";
		next;
		mes "[���B�N�g�[��]";
		mes "�ڒ��܂̍쐬�ɂ�";
		mes "�l�`���l�`�������K�v���B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�l�`���l�`�����H";
		next;
		mes "[���B�N�g�[��]";
		mes "�����A�l�`���l�`�������B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "����͂ǂ��ɍs���Ύ�ɓ���́H";
		next;
		mes "[���B�N�g�[��]";
		mes "�l�`���l�`������";
		mes "���X�R�r�A�̎���̑傫�ȓ���";
		mes "��ɓ���邱�Ƃ��ł���B";
		mes "�܂��A���܂ł͑D�ōs���̂�";
		mes "�������낤�ˁB";
		next;
		mes "[���B�N�g�[��]";
		mes "���̐X�̉��ɂ͏�������񂾂��ǁA";
		mes "���̒����Ƀl�`���l�`������";
		mes "�����Ă���񂾁B";
		mes "�Ȃ�ɂ��Ă����Ԃ͊|����ȁB";
		mes "���܂ł̓��͌��������ˁc�c";
		mes "�N���s��������Ȃ����Ȃ񂾂�B";
		next;
		mes "[���B�N�g�[��]";
		mes "�ڒ��܂���肽����΁A";
		mes "���̏��̒����ɐ����Ă���";
		mes "^3131FF�u�l�`���l�`���� 10�v^000000��";
		mes "^3131FF�u���� 1�v^000000�������ė��Ă���B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�i���B�N�g�[���������Ă������";
		mes "�@�~�n�C����T���ɍs�����Ƃ���";
		mes "�@���̏ꏊ���낤���H�j";
		set MOSK_2QUE,13;
		close;
	case 13:
	case 14:
	case 15:
	case 16:
	case 17:
	case 18:
	case 19:
	case 20:
	case 21:
	case 22:
		mes "[���B�N�g�[��]";
		mes "�ڒ��܂���肽���Ȃ�A";
		mes "���̒����ɐ����Ă���";
		mes "^3131FF�u�l�`���l�`���� 10�v^000000��";
		mes "^3131FF�u���� 1�v^000000�������ė��Ă���B";
		mes "�܂��A�����댯�����m��Ȃ����ǁA";
		mes "�N�ɂȂ�ȒP���낤�H";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�i���B�N�g�[���������Ă������";
		mes "�@�~�n�C����T���ɍs�����Ƃ���";
		mes "�@���̏ꏊ���낤���H�j";
		close;
	case 23:
		mes "[���B�N�g�[��]";
		mes "���x�͂܂��������H";
		mes "���A�������B";
		mes "�ڒ��܂��K�v�����Č�������ȁ`";
		mes "�S�����b���Ă���c�c";
		next;
		if(countitem(7763) < 10 || countitem(7134) < 1) {
			mes "[���B�N�g�[��]";
			mes "����c�c";
			mes "�ڒ��܂̍ޗ�������Ȃ�����Ȃ����B";
			mes "���������낤�H";
			mes "^3131FF�u�l�`���l�`���� 10�v^000000��";
			mes "^3131FF�u���� 1�v^000000���K�v�Ȃ񂾂�B";
			next;
			mes "[���B�N�g�[��]";
			mes "����ɂ��邩����āA";
			mes "�ɂ��Ǝv����ƍ���񂾂��ǂȁc�c";
			mes "���������Ă��Ȃ��ƁA�l������";
			mes "���ɗp�������邵�c�c";
			next;
			mes "[���B�N�g�[��]";
			mes "�~�n�C���̗��݂����Č�������";
			mes "�����Ă���Č����̂Ɂc�c";
			next;
			mes "[���B�N�g�[��]";
			mes "�c�c�c�c�c�c";
			mes "���̂�т肵�Ă�񂾂�B";
			mes "�����ڒ��܂̍ޗ���";
			mes "�����Ă��Ȃ�I";
			close;
		}
		mes "[���B�N�g�[��]";
		mes "�����ޗ���n���Ă���B";
		mes "����Ă�邩�炳�I";
		next;
		mes "-���B�N�g�[���ɍޗ���";
		mes "�@�n���Ɠ����Ƀl�`���l�`������";
		mes "�@���荞�񂾁B";
		mes "�@�����Đ���������";
		mes "�@�����񂵎n�߂�-";
		next;
		mes "[���B�N�g�[��]";
		mes "�͂��������[�[�[�I";
		next;
		mes "[���B�N�g�[��]";
		mes "�����[�[�[�[�I";
		next;
		mes "[���B�N�g�[��]";
		mes "�₟�[�[�[�[�I";
		next;
		mes "[���B�N�g�[��]";
		mes "�����[�[�[�[�I";
		next;
		mes "-���B�N�g�[���͊��܂݂��";
		mes "�@�Ȃɂ�狩��ł���-";
		next;
		mes "[���B�N�g�[��]";
		mes "�܂����[�[�[�[�I";
		mes "�c�c�����I";
		next;
		mes "-���B�N�g�[����";
		mes "�@���^���Ԃɂ���";
		mes "�@�����񂵂Ă���-";
		next;
		mes "[���B�N�g�[��]";
		mes "�c�c";
		next;
		mes "[���B�N�g�[��]";
		mes "�c�c";
		mes "�c�c�c�c";
		next;
		mes "[���B�N�g�[��]";
		mes "�c�c";
		mes "�c�c�c�c";
		mes "�c�c�c�c�c�c���I";
		next;
		mes "[���B�N�g�[��]";
		mes "����łǂ����[�[�[�[�I";
		next;
		mes "-��ۑ傫�Ȑ��ŋ��񂾂���";
		mes "�@���B�N�g�[���͎���~�߂�-";
		next;
		mes "[���B�N�g�[��]";
		mes "�ӂ��[�[�c�c";
		next;
		mes "[���B�N�g�[��]";
		mes "�����A�o�������I";
		next;
		mes "-���B�N�g�[����";
		mes "�@�^���ԂȊ�̂܂ܖ���������";
		mes "�@�ڒ��܂����ɓn��-";
		next;
		mes "[���B�N�g�[��]";
		mes "�ڒ��܂͊m���ɓn�������I";
		mes "����ŁA�l�ɂ�";
		mes "�\��Ȃ��łق����ȁI";
		mes "�����ƁA�~�n�C����";
		mes "�n���Ă����I";
		delitem 7763,10;
		delitem 7134,1;
		set MOSK_2QUE,24;
		getitem 7764,1;
		close;
	default:
		mes "[���B�N�g�[��]";
		mes "�ӂ��c�c";
		mes "�����ȁH";
		mes "�l�́A�Â��Ɏ������݂���";
		mes "�����Ȃ񂾂��ǂȁB";
		close;
	}
}

mosk_dun03,153,90,0	script	�A����	844,{
	mes "-���������ŁA�����l�܂肻����";
	mes "�@�傫������������-";
	next;
	mes "-���Â��C�A���A����";
	mes "�@�������C���̈������͋C��";
	mes "�@�������o���Ă���-";
	if(MOSK_2QUE == 10) {
		next;
		mes "-���ӂ����n���A";
		mes "�@�q���̋C�z���m�F����-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�����ɒN���������悤��";
		mes "���Ղ͌�������Ȃ����c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�����܂ł̓��̂�ł�";
		mes "�����Ȏq���̑��Ղ�";
		mes "��������Ȃ��������B";
		mes "�Ƃ肠�����A�~�n�C���̉Ƃ�";
		mes "�߂낤�c�c";
		set MOSK_2QUE,11;
	}
	else if(MOSK_2QUE >= 13 && MOSK_2QUE <= 22) {
		next;
		mes "-���̒�Ɏ�����āA";
		mes "�@�l�`���l�`������";
		mes "�@��G��ŒT���Ă݂�-";
		next;
		mes "-�w��ɉ������������������I-";
		if(rand(2)) {
			set MOSK_2QUE,MOSK_2QUE+1;
			getitem 7763,1;
		}
		else {
			getitem 511,1;
		}
	}
	close;
}

mosk_in,211,259,5	script	�����T	960,{
	switch(MOSK_2QUE) {
	case 100:
		mes "[�����T]";
		mes "����`";
		mes "���l�̌����Ă���";
		mes strcharinfo(0)+ "����";
		mes "�ł���ˁH";
		mes "���V������������";
		mes "���������ƕ����܂����B";
		next;
		mes "[�����T]";
		mes "�{���Ɋ��ӂ��Ă��܂��B";
		mes "���V�����͖{���ɉ�����";
		mes "�ǂ��q�ł�����B";
		next;
		mes "[�����T]";
		mes "����ɁA�����̃p���P�[�L��";
		mes "�p�ӂ��܂����B";
		mes "�����ɍ����Ɨǂ��̂ł�����ǁc�c";
		set MOSK_2QUE,101;
		getitem 592,5;
		getitem 593,5;
		next;
		mes "[�����T]";
		mes "�p���P�[�L���H�ׂ���";
		mes "�Ȃ�����A�����Ȃ�";
		mes "���ɂ���������ĉ������ˁB";
		mes "�������`���Ă��Ă����܂���B";
		close;
	case 101:
		mes "[�����T]";
		mes "���̑O�̃p���P�[�L��";
		mes "�������ł������H";
		mes "�������������ł����H";
		mes "�ӂӂ��B";
		mes "����Ƃ��V�����p���P�[�L��";
		mes "�Ă��Ă݂܂��H";
		next;
		if(select("�Ă�","��߂�")==2) {
			mes "[�����T]";
			mes "���ꂶ��A�܂����x�Ă��܂��傤�B";
			mes "���͂��ł����}�ł�����ˁI";
			close;
		}
		if(countitem(7031) < 1 || countitem(519) < 2 || countitem(548) < 1 || countitem(504) < 2 || countitem(1019) < 1 || countitem(518) < 1) {
			mes "[�����T]";
			mes "����ł͏Ă��܂��傤�I";
			mes "�ł��A��{�̍ޗ���";
			mes "�g�b�s���O�̋�͂���܂����ǁc�c";
			mes "����Ȃ��ޗ��͗p�ӂ��Ē����Ȃ���";
			mes "���܂���ˁc�c";
			next;
			mes "[�����T]";
			mes "���`�ƁA�ޗ��́c�c";
			mes "^3131FF�Â��t���C�p�� 1�A";
			mes "�~���N 2�A�`�[�Y 1�A";
			mes "���|�[�V���� 2�A�؋� 1�A";
			mes "�n�`�� 1��^000000���K�v�ł��c�c";
			mes "�ޗ��𑵂��ė��Ă��������ˁI";
			close;
		}
		mes "[�����T]";
		mes "���Ɓc�c�ޗ����m�F���܂��傤�B";
		mes "�t���C�p���Ƀ~���N�c�c";
		mes "���n���_�炩������|�[�V�����A";
		mes "�`�[�Y�A�n�`���A�΂��N�����ׂ̖؋��B";
		mes "�����ł��ˁI";
		next;
		mes "[�����T]";
		mes "�ł́A�����������グ�܂��傤�B";
		mes "���`�ƁA���̏������Ƀx�[�L���O";
		mes "�p�E�_�[�ƍ���������܂���B";
		mes "�ӂ邢����g�����Y���";
		mes "�������ł���B";
		next;
		mes "[�����T]";
		mes "������A�������́c�c�H";
		next;
		switch(select("�S����C�ɓ����","�ӂ邢��Œ��J�ɍ�����","�X�v�[���ō�����")) {
		case 1:
			mes "[�����T]";
			mes "�����`�`��!?";
			mes "���Ă��Ƃ����悤��";
			mes "���Ă��ł���!?";
			mes "�ŏ������蒼���ł��I";
			mes "�������́A�ӂ邢��Œ��J��";
			mes "�������ł���!!";
			break;
		case 2:
			mes "[�����T]";
			mes "�����ł��I";
			mes "�����ƃx�[�L���O�p�E�_�[��";
			mes "�ꏏ�ɂӂ邢��ō�����";
			mes "���������ˁ`";
			break;
		case 3:
			mes "[�����T]";
			mes "�ӂ邢�킪����������";
			mes "�X�v�[�����g���܂����ǁA";
			mes "�ӂ邢�킪����̂ŁA";
			mes "�֗��Ȃӂ邢���";
			mes "�g���č��܂��傤�B";
			break;
		}
		next;
		mes "[�����T]";
		mes "�ӂ邢����g�����Y���";
		mes "���肠���鎖���ł����ł��B";
		mes "�����A�����ɗ��Ƌ����A�|�[�V������";
		mes "�K�ʓ���܂��傤�B";
		mes "���肠���鎞�́A��̕�����";
		mes "���J�ɍ����������ǂ���ł���B";
		next;
		if(select("���������x�ŗ������ō�����","�w���ʂ�ɏ]��") == 1) {
			mes "[�����T]";
			mes "������!!!!!!!";
			mes "�_�A�_���ł��I";
			mes "���\�ɍ�����Ǝd�オ�肪";
			mes "�����Ȃ�܂��I";
			mes "�p�����ł��Ȃ��ł��I";
		}
		else {
			mes "[�����T]";
			mes "����`���ł��ˁI";
		}
		next;
		mes "[�����T]";
		mes "������������ƁA�Ă��Ƃ���";
		mes "�ӂ���Ǝd�オ���ł���B";
		mes "���āA�Ă��Ă݂܂��傤���H";
		mes "�t���C�p���ɓK�ʂ̗����";
		mes "����Ă��������B";
		next;
		mes "[�����T]";
		mes "�΂͎�΂ɂ��āA�Ă����";
		mes "���C�A�̏o�����";
		mes "���Ă��������B";
		mes "�C�A���o���āA�����J������";
		mes "���Ԃ��Ă��������ˁB";
		next;
		if(select("���΂ɂ���","�����Ԃ������H") == 1) {
			mes "[�����T]";
			mes "��!!";
			mes "�_���ł���I";
			mes "�΂��������悤�Ƃ��܂����ˁI";
			mes "���΂ɂ���ƁA���͐��̂܂܂ŁA";
			mes "�\�ʂ����ł��Ă��܂��܂��B";
			mes "�����Ƒ҂��Ă��������B";
		}
		else {
			mes "[�����T]";
			mes "�ӂށB�\�ʂ̏Ă���́c�c";
			mes "�ǂ��ł��ˁB";
			mes "�{���ɏ��Ȏd�オ���";
			mes "�Ȃ��Ă܂���B";
		}
		next;
		mes "[�����T]";
		mes "�����c�c���Ԃ��Ă��������B";
		mes "���񂪂�ϐF�ɂȂ��Ă���̂�";
		mes "�����������ł���ˁ`";
		mes "�g�b�s���O�͉��ɂ��܂��傤���H";
		mes "�`�[�Y�ƃn�`���̃V���b�v�͊�{";
		mes "�g�b�s���O�œ���܂����ǁc�c";
		next;
		switch(select("�L���r�A","�}�b�V�����[��","�n�j�[","�C�`�S�W����","�T���[�N���[��")) {
		case 1:
			mes "[�����T]";
			mes "�L���r�A�ł����H";
			mes "���傤��1�����c���Ă܂���I";
			mes "����́A�ґ�ȃp���P�[�L�ł��ˁI";
			mes "�͂��I�@�o���܂����I";
			set .@itemid,591;
			break;
		case 2:
			mes "[�����T]";
			mes "�}�b�V�����[���ł����H";
			mes "���肪�ǂ��Ȃ�܂���`";
			mes "�͂��I�@�o���܂����I";
			set .@itemid,595;
			break;
		case 3:
			mes "[�����T]";
			mes "�n�j�[�ł��ˁH�@�Â�����";
			mes "�p���P�[�L�Ƃ͑�����";
			mes "�ǂ���ł���B";
			mes "�͂��I�@�o���܂����I";
			set .@itemid,593;
			break;
		case 4:
			mes "[�����T]";
			mes "�C�`�S�W�����̓p���P�[�L��";
			mes "��w�����������Ă���܂���ˁ`";
			mes "�Î_���ς����ǂ��ł���ˁH";
			mes "�͂��I�@�o���܂����I";
			set .@itemid,592;
			break;
		case 5:
			mes "[�����T]";
			mes "�T���[�N���[���ł����H";
			mes "���t���b�V�������Ă����";
			mes "�H�ނł���ˁH�@�ӂӂӁB";
			mes "�͂��I�@�o���܂����I";
			set .@itemid,594;
			break;
		}
		delitem 7031,1;
		delitem 519,2;
		delitem 548,1;
		delitem 504,2;
		delitem 1019,1;
		delitem 518,1;
		getitem .@itemid,1;
		close;
	default:
		mes "[�����T]";
		mes "�A���i����l��";
		mes "������ƈӒn���Ȗʂ�����܂����A";
		mes "�~�n�C�����V������";
		mes "�ƂĂ��D�����q�ł���B";
		next;
		mes "[�����T]";
		mes "�ł��c�c";
		mes "��قǂ��炨�V�����";
		mes "��������Ȃ���ł��c�c";
		close;
	}
}

//============================================================
// �o�o���K�̖��p�N�G�X�gNPC
//- Registry -------------------------------------------------
// MOSK_3QUE -> 0�`
//------------------------------------------------------------
mosk_in,215,46,5	script	�o�o���K	970,7,7,{
	switch(MOSK_3QUE) {
	case 0:
	case 1:
		mes "[�o�o���K]";
		mes "�Ȃ񂾂��H";
		mes "���������|���Ȃ��̂����H";
		mes "�悵�悵�A�������֗��ȁI";
		mes "���傤�Ǘ[�т����ɂ��悤��";
		mes "�l���Ă����Ƃ�����B";
		mes "�q�[�b�q�b�q�b�q�I";
		next;
		mes "-" +strcharinfo(0)+ "�͓����o����-";
		close2;
		warp "mosk_dun02",53,217;
		end;
	case 2:
		mes "[�o�o���K]";
		mes "�Ђ����c�c";
		mes "��A���ȁI";
		mes "�G��ȁI�@�ߊ���!!";
		next;
		mes "[�o�o���K]";
		mes "���A�������I";
		mes "�����������������Ă�Ȃ�A";
		mes "�������̂������悤�I";
		next;
		if(select("�������́H","����Ȃ�") == 1) {
			mes "[�o�o���K]";
			mes "��������B";
			mes "���O���W�߂Ă��邫�˂�";
			mes "�����Ƃ�낤�I";
			mes "�W�߂Ă���񂾂낤�H";
			next;
			menu "���ꂾ������Ώ\������",-;
		}
		mes "[�o�o���K]";
		mes "�����c�c";
		mes "�ȁA�Ȃ�c�c";
		mes "�����ɓh���͂ǂ�����!?";
		mes "�����L�����ǐ����ǂ������񂾂�I";
		mes "��΂ɖ��ɗ���I";
		next;
		menu "�ʂɁc�c����Ȃ����ǁH",-;
		mes "[�o�o���K]";
		mes "���[���[�c�c";
		mes "�������A�Ȃ炱��łǂ������I";
		mes "�������̖��p�ŁA�����ɓ�x�Ɠ~��";
		mes "���Ȃ���������Ă���I";
		next;
		mes "[�o�o���K]";
		mes "�����A�X�̐l�Ԃ���Ԃ��낤���A";
		mes "���̃`���[������J�����Ⴆ�邩��";
		mes "�m��Ȃ���I";
		mes "�ǂ������A�����b����Ȃ���I";
		next;
		if(select("�R����Ȃ��H","�������Ȃ�") == 2) {
			mes "[�o�o���K]";
			mes "���[�����I";
			mes "���񂽂͈�̉��Ȃ񂾂��I";
			mes "���������ǂ�������";
			mes "�������Ă����񂾂��I";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�i���āA�ǂ��������̂��c�c�j";
			set MOSK_3QUE,3;
			close;
		}
		mes "[�o�o���K]";
		mes "���A�ܘ_����I";
		mes "�R����Ȃ���I";
		mes "�܂��c�c���������N�Ȃ�ŁA";
		mes "�ޗ��W�߂�牽���";
		mes "��l����ł��Ȃ����ǁc�c";
		next;
		mes "[�o�o���K]";
		mes "������A���񂽂�������Ƃ���";
		mes "��`���Ă����΂����񂾂�B";
		mes "��������A���������~�̗��Ȃ�";
		mes "�������������Ă���I";
		next;
		if(select("������A�M���Ă�����","�₾��A�߂�ǂ�") == 2) {
			mes "[�o�o���K]";
			mes "���A�������킸�ɁI";
			mes "����Ȃɑ�ς���Ȃ����炳�I";
			next;
			mes "[�o�o���K]";
			mes "������ˁH";
			mes "����ł��������������Ă������I";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�i���āA�ǂ����悤���c�c�j";
			set MOSK_3QUE,4;
			close;
		}
		mes "[�o�o���K]";
		mes "�����A���������I";
		mes "����Ŏ���������ˁI";
		mes "�ӂ��c�c���E�������c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�c�c������Ă������ǁA";
		mes "�ʂɂ��Ȃ����ǂ�����";
		mes "���悤�Ȃ�čl���ĂȂ�������B";
		next;
		mes "[�o�o���K]";
		mes "�c�c�c�c���H";
		next;
		mes "[�o�o���K]";
		mes "���[�c�c�c�c�c�c";
		next;
		mes "[�o�o���K]";
		mes "�������I";
		mes "����Ȃ炻���Ƃ������ƌ����ȁI";
		mes "�����Ƃ炢�P���邩����";
		mes "�r�N�r�N���Ă��񂾂���ˁI";
		next;
		mes "[�o�o���K]";
		mes "�͂��c�c�܂�������B";
		mes "���������ɂ����A";
		mes "���񂽂̋C���ς���ďP��ꂿ��";
		mes "���ꂱ�����܂�Ȃ�����˂��B";
		mes "���������������͖񑩒ʂ�";
		mes "���������Ă������B";
		next;
		mes "[�o�o���K]";
		mes "���Ɓc�c";
		mes "�S�R�g���ĂȂ�����A";
		mes "�ǂ��ɖ��p�̖{��u�����̂�";
		mes "�Y��Ă��܂�����c�c";
		mes "�����T������A";
		mes "������Ƒ҂��ĂĂ�����B";
		set MOSK_3QUE,5;
		close;
	case 3:
		mes "[�o�o���K]";
		mes "�Ђ��I";
		mes "�܁A�܂������I";
		next;
		mes "[�o�o���K]";
		mes "�ق�c�c�˂��H";
		mes "���������������悤�ɁA";
		mes "�~�𖳂����Ă��܂���";
		mes "�`���[�����琦���J����";
		mes "�����ƖႦ��񂾂�I";
		next;
		mes "[�o�o���K]";
		mes "�l���Ă��݂Ă�����I";
		mes "�������ɉ���������A";
		mes "�p�Y�ɂȂ��āA�J������������";
		mes "�����Ǝv��Ȃ�����!?";
		next;
		if(select("�ӂށc�c�Ȃ�ڂ����b����","�ǂ����ȁc�c") == 2) {
			mes "[�o�o���K]";
			mes "�Ђ��[�I�I";
			mes "���肢����I";
			mes "�����ōl���Ă������I";
			next;
			mes "[�o�o���K]";
			mes "������ˁH";
			mes "����ł��������������Ă������I";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�i���āA�ǂ����悤���c�c�j";
			close;
		}
		mes "[�o�o���K]";
		mes "���A���̋C�ɂȂ��Ă��ꂽ�����I";
		mes "�܂��c�c���������N�Ȃ�ŁA";
		mes "�ޗ��W�߂�牽���";
		mes "��l����ł��Ȃ����ǁc�c";
		next;
		mes "[�o�o���K]";
		mes "������A���񂽂�������Ƃ���";
		mes "��`���Ă����΂����񂾂�B";
		mes "��������A���������~�̗��Ȃ�";
		mes "�������������Ă���I";
		next;
		if(select("������A�M���Ă�����","�₾��A�߂�ǂ�") == 2) {
			mes "[�o�o���K]";
			mes "���A�������킸�ɁI";
			mes "����Ȃɑ�ς���Ȃ����炳�I";
			next;
			mes "[�o�o���K]";
			mes "������ˁH";
			mes "����ł��������������Ă������I";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�i���āA�ǂ����悤���c�c�j";
			set MOSK_3QUE,4;
			close;
		}
		mes "[�o�o���K]";
		mes "�����A���������I";
		mes "����Ŏ���������ˁI";
		mes "�ӂ��c�c���E��������c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�c�c������Ă������ǁA";
		mes "�ʂɂ��Ȃ����ǂ�����";
		mes "���悤�Ȃ�čl���ĂȂ�������B";
		next;
		mes "[�o�o���K]";
		mes "�c�c�c�c���H";
		next;
		mes "[�o�o���K]";
		mes "���[�c�c�c�c�c�c";
		next;
		mes "[�o�o���K]";
		mes "�������I";
		mes "����Ȃ炻���Ƃ������ƌ����ȁI";
		mes "�����Ƃ炢�P���邩����";
		mes "�r�N�r�N���Ă��񂾂���ˁI";
		next;
		mes "[�o�o���K]";
		mes "�͂��c�c�܂�������B";
		mes "���������ɂ����A";
		mes "���񂽂̋C���ς���ďP��ꂿ��";
		mes "���ꂱ�����܂�Ȃ�����˂��B";
		mes "���������������͖񑩒ʂ�";
		mes "���������Ă������B";
		next;
		mes "[�o�o���K]";
		mes "���Ɓc�c";
		mes "�S�R�g���ĂȂ�����A";
		mes "�ǂ��ɖ��p�̖{��u�����̂�";
		mes "�Y��Ă��܂�����c�c";
		mes "�����T������A";
		mes "������Ƒ҂��ĂĂ�����B";
		set MOSK_3QUE,5;
		close;
	case 4:
		mes "[�o�o���K]";
		mes "�l�������Ă������I";
		mes "��������؂�邾������I";
		mes "����Ȃɑ�ς���Ȃ��̂�";
		mes "���ꂾ���Ń`���[������J����";
		mes "�����ƖႦ��񂾂�I";
		next;
		if(select("�c�c�܂��c�c�ǂ���","�ǂ���������ȁc�c") == 2) {
			mes "[�o�o���K]";
			mes "���肢����I";
			mes "�����ōl���Ă������I";
			next;
			mes "[�o�o���K]";
			mes "������ˁH";
			mes "����ł��������������Ă������I";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "�i���āA�ǂ����悤���c�c�j";
			close;
		}
		mes "[�o�o���K]";
		mes "�����A���������I";
		mes "����Ŏ���������ˁI";
		mes "�ӂ��c�c���E��������c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�c�c������Ă������ǁA";
		mes "�ʂɂ��Ȃ����ǂ�����";
		mes "���悤�Ȃ�čl���ĂȂ�������B";
		next;
		mes "[�o�o���K]";
		mes "�c�c�c�c���H";
		next;
		mes "[�o�o���K]";
		mes "���[�c�c�c�c�c�c";
		next;
		mes "[�o�o���K]";
		mes "�������I";
		mes "����Ȃ炻���Ƃ������ƌ����ȁI";
		mes "�����Ƃ炢�P���邩����";
		mes "�r�N�r�N���Ă��񂾂���ˁI";
		next;
		mes "[�o�o���K]";
		mes "�͂��c�c�܂�������B";
		mes "���������ɂ����A";
		mes "���񂽂̋C���ς���ďP��ꂿ��";
		mes "���ꂱ�����܂�Ȃ�����˂��B";
		mes "���������������͖񑩒ʂ�";
		mes "���������Ă������B";
		next;
		mes "[�o�o���K]";
		mes "���Ɓc�c";
		mes "�S�R�g���ĂȂ�����A";
		mes "�ǂ��ɖ��p�̖{��u�����̂�";
		mes "�Y��Ă��܂�����c�c";
		mes "�����T������A";
		mes "������Ƒ҂��ĂĂ�����B";
		set MOSK_3QUE,5;
		close;
	case 5:
		mes "[�o�o���K]";
		mes "���₨��A�悭������";
		mes "�������̂������΂�";
		mes "�{����������B";
		mes "�ǂ�ǂ�c�c";
		mes "�m���A�G�߂̖��p�́c�c";
		next;
		mes "[�o�o���K]";
		mes "�ӂށc�c�ӂށc�c";
		next;
		mes "[�o�o���K]";
		mes "��[�c�c�c�c";
		mes "���͂Ƃ�����A�܂��͍ޗ����˂��B";
		mes "���ꂶ�Ⴀ�O�������悤��";
		mes "�ޗ��W�߂͗��񂾂�B";
		next;
		mes "[�o�o���K]";
		mes "�悸�́c�c";
		mes "�o�b�^�̑���20�Łc�c";
		next;
		mes "[�o�o���K]";
		mes "�t���c�c";
		mes "����ɁA�ێ���5�B";
		next;
		mes "[�o�o���K]";
		mes "����Ɂc�c�����Ɓc�c";
		mes "�Ԃ��R�E�����̗���20�B";
		next;
		mes "[�o�o���K]";
		mes "���Ɓc�c���[���Ɓc�c";
		mes "�Ȃ񂾂������˂��c�c����c�c";
		mes "�����I�@���ꂾ�悠��";
		mes "�ׂƂׂƂ���t��10��";
		mes "�K�v���˂��B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�c�c����A�{���ɕK�v�Ȃ́H";
		next;
		mes "[�o�o���K]";
		mes "���c�c��������c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�i�����R�������Ȃ��c�c�j";
		next;
		if(select("�܂��c�c�킩������","�c�c�R���I") == 1) {
			mes "[�o�o���K]";
			mes "�܁A�܂����p�ɂ��F�X�����ĂˁA";
			mes "�s�v�c�Ȃ��̂�F�X�g���̂��ˁI";
			set .@flag,1;
		}
		else {
			mes "[�o�o���K]";
			mes "�q�b�I";
			mes "��A����������c�c";
			mes "������ƍ��؂�Ă�����";
			mes "�ق������������Ȃ񂾂�c�c";
			next;
			mes "[�o�o���K]";
			mes "���A�����x�����Ȃ�Ă��Ȃ�����A";
			mes "�����{��Ȃ��ł������c�c";
			set .@flag,0;
		}
		next;
		mes "[�o�o���K]";
		mes "���A���āc�c";
		mes "���ɕK�v�ȍޗ��́c�c";
		next;
		mes "[�o�o���K]";
		mes "�����̐��̍�10�A";
		mes "���ꂢ�ȏ���10�c�c";
		next;
		mes "[�o�o���K]";
		mes "����Ɂc�c����͗z�C��";
		mes "���ݏo�����̂��ˁB";
		mes "����1�A";
		mes "���b�h�u���b�h5�A";
		mes "�R���Ă���S��10�B";
		next;
		mes "[�o�o���K]";
		mes "�Ō�ɁA�s�ł̃V���{���ł���";
		mes "�_�C�������h1���K�v���ˁB";
		mes "���Ȃ��̂⏝���Ă���̂�";
		mes "���߂����ǁA";
		mes "�J���b�g�͂����ł��������ˁB";
		next;
		mes "[�o�o���K]";
		mes "���Ⴀ�A�������";
		mes "�ޗ����������炿����";
		mes "�o����񂾂�B";
		next;
		mes "[�o�o���K]";
		mes "^FF0000�o�b�^�̑�20�A";
		mes "�ێ�5�A";
		mes "�Ԃ��R�E�����̗�20�A";
		if(.@flag) mes "�ׂƂׂƂ���t��10�A";
		mes "�����̐��̍�10��^000000�Ɓc�c";
		next;
		mes "[�o�o���K]";
		mes "^FF0000���ꂢ�ȏ���10�A";
		mes "����1�A";
		mes "���b�h�u���b�h5�A";
		mes "�R���Ă���S��10��^000000�B";
		next;
		mes "[�o�o���K]";
		mes "�����āA�Ō�ɏ�������";
		mes "���ʂ�^FF0000�_�C�������h1��^000000�B";
		mes "�J���b�g�͂����ł��������ˁB";
		next;
		mes "[�o�o���K]";
		mes "�������͂����ŏ��������Ă��邩��A";
		mes "���񂽂͍ޗ��𗊂񂾂�B";
		set MOSK_3QUE,.@flag? 6: 7;
		close;
	case 6:
	case 7:
		mes "[�o�o���K]";
		mes "���₨��A�ȊO�Ƒ��������˂��B";
		next;
		mes "[�o�o���K]";
		mes "�������̏����͂������ǁA";
		mes "�������͂ǂ������H";
		mes "�ޗ��������Ă��炤��B";
		next;
		if(countitem(940) < 20 || countitem(7119) < 5 || countitem(7006) < 20 || (MOSK_3QUE == 6 && countitem(938) < 10) ||
			countitem(1061) < 10 || countitem(7041) < 10 || countitem(1051) < 5 || countitem(990) < 5 || countitem(7097) < 10 ||
			(countitem(730) < 1 && countitem(731) < 1 && countitem(732) < 1)) {
			mes "[�o�o���K]";
			mes "����H";
			mes "�ޗ�������Ȃ��݂������˂��B";
			next;
			mes "[�o�o���K]";
			mes "�ޗ����Ȃ��Ɖ����n�܂�Ȃ���B";
			mes "������x�ޗ�����������";
			mes "�����Ɗo����񂾂�B";
			next;
			mes "[�o�o���K]";
			mes "^FF0000�o�b�^�̑�20�A";
			mes "�ێ�5�A";
			mes "�Ԃ��R�E�����̗�20�A";
			if(MOSK_3QUE == 6) mes "�ׂƂׂƂ���t��10�A";
			mes "�����̐��̍�10��^000000�Ɓc�c";
			next;
			mes "[�o�o���K]";
			mes "^FF0000���ꂢ�ȏ���10�A";
			mes "����1�A";
			mes "���b�h�u���b�h5�A";
			mes "�R���Ă���S��10��^000000�B";
			next;
			mes "[�o�o���K]";
			mes "�����āA�Ō�ɏ�������";
			mes "���ʂ�^FF0000�_�C�������h1��^000000�B";
			mes "�J���b�g�͂����ł��������ˁB";
			close;
		}
		delitem 940,20;
		delitem 7119,5;
		delitem 7006,20;
		if(MOSK_3QUE == 6) delitem 938,10;
		delitem 1061,10;
		delitem 7041,10;
		delitem 1051,5;
		delitem 990,5;
		delitem 7097,10;
		if(countitem(730)) delitem 730,1;
		else if(countitem(731)) delitem 731,1;
		else if(countitem(732)) delitem 732,1;
		if(MOSK_3QUE == 6) {
			set MOSK_3QUE,8;
			mes "[�o�o���K]";
			mes "�悵�悵�A�S�������Ă���݂����˂��B";
			mes "�t�t�c�c���ꂾ������΁A";
			mes "�����͑��v���˂��c�c";
			next;
			mes "[�o�o���K]";
			mes "���āA�ޗ������������ŁA";
			mes "���͂ǂ�����̂��˂��c�c";
		}
		else {
			set MOSK_3QUE,8;
			mes "[�o�o���K]";
			mes "�悵�悵�A�S�������Ă���݂����˂��B";
			mes "���āA�ޗ������������ŁA";
			mes "���͂ǂ�����̂��˂��c�c";
		}
		next;
		mes "-�o�o���K�͖{��ǂݏo����-";
		next;
		mes "[�o�o���K]";
		mes "�c�c�c�c�ȃb�I";
		mes "����Ȃ̂�����̂���!?";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "��H";
		mes "�����ޗ��������Ă��H";
		next;
		mes "[�o�o���K]";
		mes "�܂��c�c����ȂƂ������ǁc�c";
		mes "����͂�����Ɓc�c�˂��c�c";
		next;
		mes "[�o�o���K]";
		mes "�����Œ����Ԗ����Ă���";
		mes "���̘b�͒m���Ă��邩���H";
		mes "���̗��������������";
		mes "�K�v�݂�������B";
		next;
		mes "[�o�o���K]";
		mes "���̗��̑��ɂ́A�Ђ����c�c";
		mes "�ƌ����Ă��z�������Ȃ������H";
		mes "�܂��A�s�v�c�Ȍ`�������r��";
		mes "����񂾂��ǁA���̕r�ɂ�";
		mes "�l�̌��t�����߂�邻������B";
		next;
		mes "[�o�o���K]";
		mes "���ꂪ�K�v�Ȃ񂾂��ǁc�c";
		mes "���񂽂������狭���Ă�";
		mes "�������ɖ������낤�˂��B";
		next;
		mes "[�o�o���K]";
		mes "��[�A����ɂȂ镨��";
		mes "�Ȃ��̂��˂��c�c";
		mes "�܂������A�����Ȏ��������Ă���";
		mes "�{���˂��I";
		close;
	case 8:
		mes "[�o�o���K]";
		mes "���̑����琶���ċA��Ȃ��";
		mes "�l���Ȃ������������ˁB";
		mes "�����Șr�O�̎��͎҂ł�";
		mes "���Ɋւ��񂾂�B";
		next;
		mes "[�o�o���K]";
		mes "�����ɂ����Ȃ�A";
		mes "���@�̂Ђ����͂�����߂��ق���";
		mes "������������Ȃ��˂��c�c";
		mes "�������A����Ȃ�Ă���̂��˂��c�c";
		close;
	case 9:
		mes "[�o�o���K]";
		mes "����́c�c�܂���!?";
		mes "���̂Ђ����𗳂̑�����";
		mes "�Ƃ��Ă������Ă̂���!?";
		next;
		mes "[�o�o���K]";
		mes "�X�L�����ē��񂾂̂��A";
		mes "����|���Ă����̂�";
		mes "�m��Ȃ����ǁA�ǂ����ɂ���";
		mes "���񂽂͂������˂��c�c";
		next;
		mes "[�o�o���K]";
		mes "���āA���̂Ђ����ɂ�";
		mes "�l�̐������߂鎖���\������";
		mes "�������̂͊o���Ă邩���H";
		next;
		mes "[�o�o���K]";
		mes "���ɂ��鎖�́A";
		mes "�l�X�̖{���𕷂��āA";
		mes "���̂Ђ����ɓ���Ă��鎖���ˁB";
		next;
		mes "[�o�o���K]";
		mes "�������A�����Ɍ��킹���Ⴂ���Ȃ���B";
		mes "�u�~�͂������Ȃ��ŁI�v";
		mes "���Č����Ă��������B";
		mes "�Ȃ�ėU������̂͑ʖڂȂ񂾂�B";
		next;
		mes "[�o�o���K]";
		mes "���R�Ƙb��i�߂Ȃ���@���";
		mes "���������̂��ǂ����ˁB";
		mes "����ɁA��������ӂ��鎖�������B";
		next;
		mes "[�o�o���K]";
		mes "�S���ŎO�l���̐���";
		mes "�W�߂Ȃ���Ȃ�Ȃ��񂾂��ǁA";
		mes "�q���A��ҁA�N����";
		mes "����ʂɕK�v���ˁB";
		mes "�܁A�N���͂�����x";
		mes "��҂��N��Ȃ���v���˂��B";
		next;
		mes "[�o�o���K]";
		mes "�������炪��낤�Ƃ��Ă��閂�p�́A";
		mes "�l�X�̖]�݂�͂ɂ��Ȃ���";
		mes "���܂������Ȃ��񂾂�B";
		mes "������낤����";
		mes "����΂��Ă����ŁB";
		set MOSK_3QUE,10;
		close;
	case 10:
		mes "[�o�o���K]";
		mes "���@�̂Ђ����ɁA";
		mes "�~�����Ȃ��ŗ~�����Ɗ肤";
		mes "���t���̂��l�߂�Ηǂ����ˁB";
		next;
		mes "[�o�o���K]";
		mes "�ł��A�肤���t���l�߂�B";
		mes "����ɂ͏����������B";
		mes "�܂���B";
		mes "�����Ɍ��킹�Ȃ����B";
		next;
		mes "[�o�o���K]";
		mes "���R�Ƙb��i�߂Ȃ���@���";
		mes "���������̂��ǂ����ˁB";
		mes "����ɁA��������ӂ��鎖�������B";
		next;
		mes "[�o�o���K]";
		mes "�����Ă�����B";
		mes "�q���A��ҁA�N����";
		mes "����ʂɈ�l���K�v���ˁB";
		mes "�܁A�N���͂�����x";
		mes "��҂��N��Ȃ���v���˂��B";
		next;
		mes "[�o�o���K]";
		mes "���ꂶ��A����΂��Ă����ŁB";
		close;
	case 14:
		mes "[�o�o���K]";
		mes "�����B";
		mes "��������������Ȃ����ǁA";
		mes "�`���[���̕�������";
		mes "���Ȃ��Ȃ�����c�c";
		mes "���������΁A";
		mes "�����Ɛ��͏W�߂Ă��������H";
		next;
		mes "[�o�o���K]";
		mes "��A���v�݂������˂��B";
		mes "���ꂶ��A���̂Ђ�����";
		mes "�����a�����Ă�����B";
		delitem 7761,1;
		next;
		mes "[�o�o���K]";
		mes "���ꂶ��A���͎��ۂ�";
		mes "����肾��B";
		mes "�悸�͂��������ǂ�ł���";
		mes "���̖{��ǂ݂ȁB";
		next;
		mes "[�o�o���K]";
		mes "���������N�ł˂��A";
		mes "������ƍޗ���g�ݍ��킹��̂�";
		mes "�h���񂾂�B";
		mes "�Ȃ��ɁA�{�̒ʂ���΂�������";
		mes "���񂽂ł��ł��邳�ˁB";
		next;
		mes "[�o�o���K]";
		mes "�{���͂��񂽂ɂᓞ��";
		mes "�ǂ߂Ȃ��{�����ǁA";
		mes "����̖��p�ɕK�v�ȏ���";
		mes "���������󂵂Ă�������B";
		next;
		mes "[�o�o���K]";
		mes "���ꂶ��A�ł����炠������";
		mes "�����ɂ����ŁB";
		set MOSK_3QUE,15;
		close;
	case 15:
	case 16:
		mes "[�o�o���K]";
		mes "���p�ɂ���Ĕ�������������̂́A";
		mes "�s�v�c�ȉ�������Ȃ��񂾂�B";
		next;
		mes "[�o�o���K]";
		mes "�{���ɕK�v�Ȃ̂�";
		mes "�����𐬂������悤�Ƃ���z���B";
		mes "�����]�߂ΕK�������ƌ������낤�H";
		mes "���ꂪ���p�̖{���Ȃ񂾂�B";
		next;
		mes "[�o�o���K]";
		mes "���񂽂͋����z���΂����B";
		mes "���Ƃ́A�{�ɏ����Ă���ʂ�";
		mes "�����̓�ɍޗ�������";
		mes "���΂炭�ς�Δ��̊������ˁB";
		close;
	case 17:
		mes "[�o�o���K]";
		mes "�ӂ�c�c";
		mes "�����ō���ĂāA";
		mes "�������������Ǝv��Ȃ������̂����H";
		next;
		mes "[�o�o���K]";
		mes "���ꂶ��_�����ˁB";
		mes "�ޗ��͂܂����邩��A";
		mes "����������Ă݂ȁI";
		set MOSK_3QUE,16;
		close;
	case 18:
		mes "[�o�o���K]";
		mes "�ǂ�ǂ�c�c";
		next;
		mes "[�o�o���K]";
		mes "�ق��c�c";
		mes "�����Ɩ{�ɏ����Ă���ʂ�";
		mes "�ł����݂������ˁB";
		mes "����Ȃ���v����B";
		next;
		mes "[�o�o���K]";
		mes "����A����Ŗ{���ɍŌゾ��B";
		mes "���̔���r�ɂ߂Ă��Ɓc�c";
		mes "���A���̕r���X�̒�����";
		mes "�󂵂Ă���񂾂�B";
		next;
		mes "[�o�o���K]";
		mes "��������A�l�X�̖]�ݒʂ�A";
		mes "���̊X�ɉĂ������悤�ɂȂ邳�ˁB";
		set MOSK_3QUE,19;
		getitem 7765,1;
		close;
	case 19:
		mes "[�o�o���K]";
		mes "�X�̒����c�c";
		mes "�������˂��A�n�ʂɕςȃ}�[�N��";
		mes "����Ƃ���ւ񂩂˂��B";
		mes "�����ł��̔����󂵂Ă����ŁB";
		mes "��������A�l�X�̖]�ݒʂ�A";
		mes "���̊X�ɉĂ������悤�ɂȂ邳�ˁB";
		next;
		mes "[�o�o���K]";
		mes "���̌�́A";
		mes "�l�X�Ɏ���������Ȃ�A";
		mes "�`���[������J�������炤�Ȃ�";
		mes "�D���ɂ����炢�����ˁB";
		mes "�q�b�q�b�q�B";
		close;
	default:
		mes "[�o�o���K]";
		mes "�Ȃ񂾂��A�������͂���";
		mes "�񑩂͎�����낤�H";
		mes "�����p�͖����͂�����B";
		next;
		mes "[�o�o���K]";
		mes "�������͂��������Ă�";
		mes "�Z�����񂾂���A";
		mes "�������Ȃ��ł�����B";
		close;
	}
OnTouch:
	switch(MOSK_3QUE) {
	case 0:
		if(countitem(7762) < 40) {
			mes "[�o�o���K]";
			mes "���҂��͒m��Ȃ����ǁA";
			mes "�����ɂ���������";
			mes "�������Əo�Ă����ȁI";
			set MOSK_3QUE,1;
			close2;
			warp "mosk_dun02",53,217;
			end;
		}
		else if(BaseLevel < 60) {
			mes "[�o�o���K]";
			mes "�Ȃ񂾂��A����ȏ��ցB";
			mes "�q�b�q�b�q�B";
			mes "�����ɂ����͂Ȃ��̂����H";
			next;
			mes "[�o�o���K]";
			mes "�c�c��H";
			mes "���A����́c�c!?";
			next;
			mes "[�o�o���K]";
			mes "����͂������炪�g��";
			mes "���˂���Ȃ����I";
			mes "�������A����Ȃɑ�R�c�c";
			next;
			mes "[�o�o���K]";
			mes "�c�c���₢��A�܂����ˁB";
			mes "�������炪���O�̂悤��";
			mes "��˂ɂ����킯�����I";
			mes "�ǂ��œ���ł����̂��m��Ȃ����ǁA";
			mes "���̂��˂��������ƕԂ��ȁI";
			delitem 7762,rand(1,20);
			set MOSK_3QUE,1;
			close2;
			warp "mosk_dun02",53,217;
			end;
		}
		set MOSK_3QUE,2;
		mes "[�o�o���K]";
		mes "�Ȃ񂾂��A����ȏ��ցB";
		mes "�q�b�q�b�q�B";
		mes "�����ɂ����͂Ȃ��̂����H";
		next;
		mes "[�o�o���K]";
		mes "�c�c��H";
		mes "���A����́c�c!?";
		next;
		mes "[�o�o���K]";
		mes "����͂������炪�g��";
		mes "���˂���Ȃ����I";
		mes "�������A����Ȃɑ�R�c�c";
		next;
		mes "[�o�o���K]";
		mes "��́c�c";
		mes "���O�́c�c���҂Ȃ񂾂�!?";
		close;
	case 1:
		if(countitem(7762) < 40) {
			mes "[�o�o���K]";
			mes "�Ȃ񂾂��A�܂������̂����H";
			mes "���������|���Ȃ��悤���˂��H";
			mes "�悵�悵�A�������֗��ȁI";
			mes "���傤�Ǘ[�т����ɂ��悤��";
			mes "�l���Ă����Ƃ�����B";
			mes "�q�[�b�q�b�q�b�q�I";
			next;
			mes "-" +strcharinfo(0)+ "�͓����o����-";
			close2;
			warp "mosk_dun02",53,217;
			end;
		}
		else if(BaseLevel < 60) {
			mes "[�o�o���K]";
			mes "���₨��A�܂������̂����B";
			mes "��m�̂����ɐ��ӋC���˂��B";
			next;
			mes "[�o�o���K]";
			if(Sex) {
				mes "���������Ă��ꂩ���H";
				mes "�������ɋC������̂����H";
				mes "����Ȃ炻���Ƒ��������Ȃ�B";
			}
			else {
				mes "�����A�������������B";
				mes "�ŋ߁A�̒��������������ǁA";
				mes "���O��H�ׂ��猳�C�ɂȂ肻�����I";
			}
			mes "�q�[�b�q�b�q�b�q�I";
			next;
			mes "-" +strcharinfo(0)+ "�͓����o����-";
			close2;
			warp "mosk_dun02",53,217;
			end;
		}
		set MOSK_3QUE,2;
		mes "[�o�o���K]";
		mes "���₨��A�܂������̂����B";
		mes "�q�b�q�b�q�B";
		mes "�����ɂ����͂Ȃ��̂����H";
		next;
		mes "[�o�o���K]";
		mes "�c�c��H";
		mes "���A����́c�c!?";
		next;
		mes "[�o�o���K]";
		mes "����͂킵�炪�g��";
		mes "���˂���Ȃ����I";
		mes "���ł���Ȃɂ�������̂��˂�";
		mes "�����Ă���񂾂�!?";
		next;
		mes "[�o�o���K]";
		mes "��́c�c";
		mes "���O�́c�c���҂Ȃ񂾂�!?";
		close;
	default:
		end;
	}
}

mosk_dun03,225,233,0	script	���̎R	111,5,5,{
	if(MOSK_3QUE != 8) {
		mes "[" +strcharinfo(0)+ "]";
		mes "������������ς�ł���c�c";
		close;
	}
	mes "[" +strcharinfo(0)+ "]";
	mes "������������ς�ł���c�c";
	mes "�����ɂ��������肻���ȏ����B";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "����������Ƌߕt����";
	mes "���ׂĂ݂悤�B";
	close;
OnTouch:
	if(MOSK_3QUE != 8)
		end;
	mes "[" +strcharinfo(0)+ "]";
	mes "������������ς�ł���c�c";
	mes "����Ƃ���΂��̕ӂ肩�ȁH";
	mes "�l�̌��t�����߂��";
	mes "�Ђ���������̂́c�c";
	while(1) {
		next;
		if(select("�T���Ă݂�","�܂����x�ɂ���") == 2) {
			mes "[" +strcharinfo(0)+ "]";
			mes "�܂��̋@��ɂ��悤�B";
			close;
		}
		if(getbaseclass(Class) == CLASS_TF) {
			mes "[" +strcharinfo(0)+ "]";
			mes "�܁A�E�ƕ�����Ȃ�";
			mes "�����o���̂͊ȒP���ˁB";
			mes "�c�c�Ӂ[��c�c";
			mes "���ꂪ�l�̌��t��";
			mes "���߂��Ђ������c�c";
			set MOSK_3QUE,9;
			getitem 7761,1;
			close;
		}
		if(rand(20) < 5) {
			mes "[" +strcharinfo(0)+ "]";
			mes "�������I";
			mes "���ꂪ�l�̌��t��";
			mes "���߂��Ђ������c�c";
			set MOSK_3QUE,9;
			getitem 7761,1;
			close;
		}
		mes "�c�c�c�c�c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "��c�c������Ȃ��Ȃ��c�c";
		mes "���������悭�T���Ă݂悤�B";
	}
}

moscovia,252,203,5	script	�q��#mosk1	958,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x01) {
		mes "[�q��]";
		mes "�X�̊O�ɂ́A";
		mes "�l��H�����낵���o�o���K��";
		mes "�Z��ł�񂾂��āI";
		next;
		mes "[�q��]";
		mes "�}�}�����������Ă��񂾂�I";
		mes "�{������I";
		close;
	}
	mes "[" +strcharinfo(0)+ "]";
	mes "�˂��˂��A������Ƃ������ȁH";
	next;
	mes "[�q��]";
	mes "��A�Ȃ��ɁH";
	next;
	menu "�Ă͍D�����ȁH",-;
	if(rand(10) < 7) {
		mes "[�q��]";
		mes "�Ă͍D�������ǁA";
		mes "�V�Ԏ��Ԃ͓~�ƕς��Ȃ��ˁB";
		mes "�܂����邭�Ă��A";
		mes "�����A��Ȃ��Ɠ{��ꂿ�Ⴄ�B";
		next;
		mes "[�q��]";
		mes "�}�}�͂����������́B";
		mes "�Â����ɊO���o���������q��";
		mes "�o�o���K�ɘA��Ă������Ă��B";
		close;
	}
	mes "[�q��]";
	mes "����I�@�|�J�|�J�ő�D��!!";
	mes "�����~�͗��Ȃ��ŗ~�����Ȃ��`";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x01;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,233,204,3	script	�N#mosk2	968,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x02) {
		mes "[�N]";
		mes "�ӂ��c�c";
		mes "�G�߂��ǂ��Ȃ��Ă��A";
		mes "���̐S�͂����Ɠ~�̂܂܁c�c���B";
		close;
	}
	mes "[�N]";
	mes "�ӂ��c�c";
	mes "�G�߂��ǂ��Ȃ��Ă��A";
	mes "���̐S�͂����Ɠ~�̂܂܁c�c���B";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "���́c�c������Ƃ����ł����H";
	next;
	mes "[�N]";
	mes "�c�c���ł����H";
	next;
	menu "�~�́c�c�������ł����H",-;
	if(rand(10) < 7) {
		mes "[�N]";
		mes "���l������΁A�~������";
		mes "�g���������m��Ȃ��c�c";
		mes "�͂́c�c���ɂ͊֌W�Ȃ��b���c�c";
		mes "�c�c�͂��c�c���������H";
		mes "��l�ɂ��Ă���c�c";
		close;
	}
	mes "[�N]";
	mes "�������ˁc�c�����B";
	mes "�������A�g�[���������c�c";
	mes "����ǂ����͂Ȃ���B";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x02;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,219,229,5	script	��������#mosk3	964,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x04) {
		mes "[��������]";
		mes "�����̐l�͋����Ȑg�̂�";
		mes "�������_�͂����肳�I";
		mes "��Ԃ̎�������I";
		next;
		mes "[��������]";
		mes "�����~�����āA";
		mes "��X�ɂ͂ւ��������Ă��񂾁I";
		close;
	}
	mes "[" +strcharinfo(0)+ "]";
	mes "���́c�c������Ƃ����ł����H";
	next;
	mes "[��������]";
	mes "��A�������H";
	next;
	menu "�~�͌����ł����H",-;
	if(rand(10) < 7) {
		mes "[��������]";
		mes "�ӂށA�N�͓~�������Ȃ̂��H";
		mes "���͒b������������";
		mes "�~�ɂ��ς����悤�ɂȂ�����B";
		mes "�ǂ������A�N���b���Ă݂���H";
		close;
	}
	mes "[��������]";
	mes "�܂��ȁc�c";
	mes "�~���Ȃ��Ȃ�ƁA";
	mes "�N�����Ċ�Ԃ��낤�ȁI";
	mes "�������������ɑς���Ȃ��";
	mes "��J��w����Ȃ��Ă�������ȁI";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x04;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,255,203,3	script	�q��#mosk4	962,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x01) {
		mes "[�q��]";
		mes "��[�I�@�O�����痈���l��!!";
		mes "�`���ҁH�@�`���҂���ˁH";
		next;
		mes "[�q��]";
		mes "�����ʔ����b���Ă�!!";
		mes "���Ƃ͐���Ă݂��H";
		mes "���F�Ɍ��錕�⏂�͎����Ă�H";
		mes "�˂��˂��A�����b���Ă�I";
		close;
	}
	mes "[�q��]";
	mes "��[�I�@�O�����痈���l��!!";
	mes "�`���ҁH�@�`���҂���ˁH";
	next;
	mes "[�q��]";
	mes "�����ɂ͉����ɂ����́H";
	mes "�`���ɏo�鎞�ɐႪ�~���Ă���";
	mes "�ǂ�����́H";
	next;
	menu "�`���ɂ͒g�����Ȃ��Ă���s�����ȁH",-;
	if(rand(10) < 7) {
		mes "[�q��]";
		mes "���x�͂ǂ��֍s���́H";
		mes "���A�s���́H";
		next;
		mes "[�q��]";
		mes "������΂𕬂��A";
		mes "���̉H�΂����ŁA";
		mes "10�l��|�����Ă�������";
		mes "�ގ����ɍs���́H";
		close;
	}
	mes "[�q��]";
	mes "�����Ȃ񂾁B";
	mes "�{�N��������";
	mes "�s�J�s�J����Z�𒅂āA";
	mes "���F�Ɍ��錕��������";
	mes "�`���ɏo��񂾂�I";
	next;
	mes "[�q��]";
	mes "���[���A�~�Ȃ�Ă��Ȃ��āA";
	mes "�����ƉĂ̂܂܂�������";
	mes "�����`���ł���񂾂낤�Ȃ��B";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x01;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,204,188,5	script	�Ⴂ���o����#mosk5	959,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x02) {
		mes "[�Ⴂ���o����]";
		mes "�g�����t�����ā`";
		next;
		mes "[�Ⴂ���o����]";
		mes "�Ђ܂�肪�炫�`";
		close;
	}
	mes "[�Ⴂ���o����]";
	mes "�g�����t�����ā`";
	next;
	mes "[�Ⴂ���o����]";
	mes "�Ђ܂�肪�炫�`";
	next;
	menu "���@���ł��ˁ`",-;
	if(rand(10) < 7) {
		mes "[�Ⴂ���o����]";
		mes "�����A�Ƃ��Ă��B";
		mes "�Ђ܂�肪�炢����ł���B";
		mes "���ꂩ�疈�����y���݂ł��B";
		close;
	}
	mes "[�Ⴂ���o����]";
	mes "�����A�Ƃ��Ă��B";
	mes "�����āA�g������ł����́I";
	next;
	mes "[�Ⴂ���o����]";
	mes "�~�͂������Ȃ��ŗ~�����ł��B";
	mes "�����ƂЂ܂��������v���Ă܂���B";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x02;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,167,97,3	script	���΂���#mosk6	961,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x04) {
		mes "[���΂���]";
		mes "�g�����Ȃ���������āA";
		mes "�q�������͕����オ��������āc�c";
		next;
		mes "[���΂���]";
		mes "�����������邵�A";
		mes "���낻��A���Ă��邩�˂��B";
		close;
	}
	mes "[���΂���]";
	mes "�g�����Ȃ���������āA";
	mes "�q�������͕����オ��������āc�c";
	next;
	menu "�{���A�g�����Ȃ�܂����ˁB",-;
	if(rand(10) < 7) {
		mes "[���΂���]";
		mes "�������˂��B";
		mes "�g�����Ȃ��Ďq�������C��";
		mes "�O�ŗV��ł����B";
		next;
		mes "[���΂���]";
		mes "�ł��A�������Ő��󂪑�ς���B";
		mes "�܂��c�c���C�ȏ؋�������";
		mes "���傤���Ȃ����ǂ˂��B";
		close;
	}
	mes "[���΂���]";
	mes "�������˂��B";
	mes "�g�����Ȃ��Ďq�������C��";
	mes "�O�ŗV��ł����B";
	next;
	mes "[���΂���]";
	mes "�~�͊������A�Â��B";
	mes "�ǂ����Ȃ�ĉ��������B";
	mes "�~�Ȃ�ė��Ȃ��Ⴂ����B";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x04;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,202,102,3	script	�q��#mosk7	962,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x01) {
		mes "[�q��]";
		mes "�|�����̘b��m���Ă�H";
		next;
		mes "[�q��]";
		mes "���i�͎����̑��ŐQ�Ă邯�ǁA";
		mes "���܂ɊO�ɏo�āA�ڂɌ�����S�Ă�";
		mes "�Ă��s�����񂾂��āB";
		next;
		mes "[�q��]";
		mes "����́A�����̂��k������";
		mes "���k�����̂��k������";
		mes "���k�����̎����炠����";
		mes "���b�炵����B";
		close;
	}
	mes "[�q��]";
	mes "�|�����̘b��m���Ă�H";
	next;
	mes "[�q��]";
	mes "���i�͎����̑��ŐQ�Ă邯�ǁA";
	mes "���܂ɊO�ɏo�āA�ڂɌ�����S�Ă�";
	mes "�Ă��s�����񂾂��āB";
	next;
	mes "[�q��]";
	mes "����́A�����̂��k������";
	mes "���k�����̂��k������";
	mes "���k�����̎����炠����";
	mes "���b�炵����B";
	next;
	menu "�s�v�c�Șb���D���Ȃ́H",-;
	if(rand(10) < 7) {
		mes "[�q��]";
		mes "����I�@�D������B";
		mes "�����̂��k������";
		mes "�F��Ȃ��b�𕷂����Ă����񂾂�B";
		close;
	}
	mes "[�q��]";
	mes "����I�@�D������B";
	mes "�ł��A�~�ɂȂ�ƁA";
	mes "����܂�O�ɏo�Ȃ��Ȃ邩��A";
	mes "���k�����̒m���Ă邨�b�ȊO��";
	mes "�����Ȃ��Ȃ����Ⴄ�񂾁B";
	next;
	mes "[�q��]";
	mes "�~�����Ȃ�������A";
	mes "�����Ɩʔ����b����������";
	mes "������̂ɂȂ��c�c";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x01;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,220,172,3	script	�N#mosk8	968,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x02) {
		mes "[�N]";
		mes "���`���A�������Ȃ��̗l��";
		mes "�V�������E�ɗ����������ł��I";
		close;
	}
	mes "[�N]";
	mes "���`���A�������Ȃ��̗l��";
	mes "�V�������E�ɗ����������ł��I";
	next;
	menu "����͂����ł����H",-;
	if(rand(10) < 7) {
		mes "[�N]";
		mes "�����ł��ˁc�c";
		mes "�܁A���̂����ł��ˁB";
		close;
	}
	mes "[�N]";
	mes "�����ł��ˁB";
	mes "�����g�����ƍ������ɂł�";
	mes "���ɏo�����Ǝv���܂��B";
	next;
	mes "[�N]";
	mes "�ł��A�����Ȃ�����c�c";
	mes "�����Ȃ����痷�ǂ��납";
	mes "�����������Ȃ��Ȃ�܂���ˁB";
	mes "�܂������c�c�~�͌����ł��B";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x02;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,253,175,3	script	��������#mosk9	964,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x04) {
		mes "[��������]";
		mes "���̃`���[���l�͏�����������";
		mes "�|���������ǁA";
		mes "�����̎����v���Ă����";
		mes "�ƂĂ��ǂ������ˁB";
		close;
	}
	mes "[" +strcharinfo(0)+ "]";
	mes "���́c�c������Ƃ����ł����H";
	next;
	mes "[��������]";
	mes "��A�������H";
	next;
	menu "�~�͉������Ă��܂����H",-;
	if(rand(10) < 7) {
		mes "[��������]";
		mes "�܂��A�Ƃ̒���";
		mes "�Ƒ��ƈꏏ�ɉ߂������ȁB";
		mes "�O�͊�������ˁB";
		close;
	}
	mes "[��������]";
	mes "�~�͊����ĊO�ɂ��o��Ȃ��B";
	mes "�����������~�邵�A";
	mes "�{���ɕs�ւ��B";
	next;
	mes "[��������]";
	mes "�����S�R���₵�Ȃ��c�c";
	mes "�~�Ȃ�Ė����Ȃ�Ηǂ��̂ɂȂ��B";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x04;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,168,135,3	script	���΂���#mosk10	961,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x04) {
		mes "[���΂���]";
		mes "�������ŋ߁A�O���̐l�������ˁB";
		next;
		mes "[���΂���]";
		mes "�����͊ό������ł�������";
		mes "�v���񂾂��ǁc�c";
		mes "�܂��A���키�̂͂������Ƃ��ˁB";
		close;
	}
	mes "[���΂���]";
	mes "�������ŋ߁A�O���̐l�������ˁB";
	next;
	mes "[���΂���]";
	mes "�����͊ό������ł�������";
	mes "�v���񂾂��ǁc�c";
	next;
	menu "�����͒g�����Ă������ł�����",-;
	if(rand(10) < 7) {
		mes "[���΂���]";
		mes "�����͂��͂��́I";
		mes "����Ȏ��Ȃ���I";
		mes "�~�ɂȂ�����{���Ɋ����āA";
		mes "�Ƃ��������o���Ȃ��Ȃ��B";
		close;
	}
	mes "[���΂���]";
	mes "�����͂��͂��́I";
	mes "����Ȃ̍��������ˁI";
	mes "�~�ɂȂ�����{���Ɋ����āA";
	mes "�Ƃ��������o���Ȃ��Ȃ��B";
	next;
	mes "[���΂���]";
	mes "�����~���D���Ȑl��";
	mes "�����ɂ͂��Ȃ����낤�˂��B";
	mes "�܂������c�c�~�Ȃ��";
	mes "�����Ȃ����Ⴆ�΂����̂ɂ˂��H";
	mes "�����͂��͂��́B";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x04;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,192,80,3	script	�Ⴂ���o����#mosk11	959,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x02) {
		mes "[�Ⴂ���o����]";
		mes "�Ђ܂��͗ǂ��ł���B";
		mes "��Ŗ������邵�A";
		mes "�s�ł͖�����܂��B";
		close;
	}
	mes "[�Ⴂ���o����]";
	mes "�Ђ܂��͗ǂ��ł���B";
	mes "��Ŗ������邵�A";
	mes "�s�ł͖�����܂��B";
	next;
	menu "�Ђ܂��͂��炫�܂����H",-;
	if(rand(10) < 7) {
		mes "[�Ⴂ���o����]";
		mes "���ʂ͉Ăɍ炫�܂��ˁB";
		mes "�L�������ɂЂ܂�肪�炢�Ă���";
		mes "���i��ڂɂ�����A���Ȃ���";
		mes "�Ђ܂�肪�D���ɂȂ�܂���B";
		close;
	}
	mes "[�Ⴂ���o����]";
	mes "���ʂ͉Ăɍ炫�܂��ˁB";
	mes "�L�������ɂЂ܂�肪�炢�Ă���";
	mes "���i��ڂɂ�����A���Ȃ���";
	mes "�Ђ܂�肪�D���ɂȂ�܂���B";
	next;
	mes "[�Ⴂ���o����]";
	mes "�Ă������Ƒ����Ă����΁A";
	mes "�����ƔN���Ђ܂�肪";
	mes "�����ł��傤�ˁc�c";
	mes "�����~�����Ȃ��Ƃ����̂Ɂc�c";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x02;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,211,215,5	script	�N#mosk12	967,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x02) {
		mes "[�N]";
		mes "��������l�͌����܂��I";
		mes "�D�@��_����!!";
		next;
		mes "[�N]";
		mes "�g�����Ȃ������I";
		mes "�����̃K�[�h���ɂ��Ȃ������I";
		mes "����������������`�����X�I";
		close;
	}
	mes "[�N]";
	mes "��������l�͌����܂��I";
	mes "�D�@��_����!!";
	next;
	mes "[�N]";
	mes "�g�����Ȃ������I";
	mes "�����̃K�[�h���ɂ��Ȃ������I";
	mes "����������������`�����X�I";
	next;
	menu "�g�����Ȃ��ėǂ������ł���",-;
	if(rand(10) < 7) {
		mes "[�N]";
		mes "�����A���ꂩ�炪���̏o�ԁI";
		mes "��[���A����΂邼�[�I";
		close;
	}
	mes "[�N]";
	mes "�����A���ꂩ�炪���̏o�ԁI";
	next;
	mes "[�N]";
	mes "�n�b�I�@�������I";
	mes "�����Ɠ~�������Ȃ����";
	mes "���̐l���̓o���F�I";
	mes "���[�I�@�~�͂�������ȁ[�I";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x02;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,149,112,3	script	��������#mosk13	964,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x04) {
		mes "[��������]";
		mes "���ɂ��N�̂悤�Ȏ����������B";
		mes "���ꂵ���������ɂȂ�";
		mes "�`���ɏo�Ă��������c�c";
		close;
	}
	mes "[��������]";
	mes "���ɂ��N�̂悤�Ȏ����������B";
	mes "���ꂵ���������ɂȂ�";
	mes "�`���ɏo�Ă��������c�c";
	next;
	menu "���͂��x�ݒ��ł����H",-;
	if(rand(10) < 7) {
		mes "[��������]";
		mes "�������ȁB";
		mes "�����Ƃ���Ȓg������������";
		mes "���тȂ���x��ł��������񂾁B";
		close;
	}
	mes "[��������]";
	mes "�������ȁB";
	mes "�����Ƃ���Ȓg������������";
	mes "���тȂ���x��ł��������񂾁B";
	next;
	mes "[��������]";
	mes "���̒g�����V�C�������Ƒ�����";
	mes "�~������B";
	mes "�����~�����������U���Ȃ��";
	mes "�S�R�ł��Ȃ�����ȁB";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x04;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,196,71,3	script	�N#mosk14	968,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x02) {
		mes "[�N]";
		mes "���̒n�ɐ��܂ꂽ�j��";
		mes "�L���C�̍r���g�𒴂��A";
		mes "��l�ɂȂ�܂��B";
		next;
		mes "[�N]";
		mes "���Ȃ��͑D���D���ł����H";
		close;
	}
	mes "[�N]";
	mes "���̒n�ɐ��܂ꂽ�j��";
	mes "�L���C�̍r���g�𒴂��A";
	mes "��l�ɂȂ�܂��B";
	next;
	menu "�ł��A�~�́c�c",-;
	if(rand(10) < 7) {
		mes "[�N]";
		mes "����A�����m�ł������B";
		mes "�����ł��ˁB�~�ɂȂ��";
		mes "�C�ɗ��X���o���āA";
		mes "�D���o���Ȃ��Ȃ�܂��ˁB";
		mes "�܂��A�����x�e���Ă��Ƃł��B";
		close;
	}
	mes "[�N]";
	mes "����A�����m�ł������B";
	mes "�����ł��ˁB�~�ɂȂ��";
	mes "�C�ɗ��X���o���āA";
	mes "�D���o���Ȃ��Ȃ�܂��ˁB";
	next;
	mes "[�N]";
	mes "�~�����Ȃ��Ɨǂ����ǁc�c";
	mes "���肦�Ȃ��b�ł���ˁB";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x02;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,234,168,5	script	��������#mosk15	964,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x04) {
		mes "[��������]";
		mes "���̉��{�A�i�D�����Ǝv��Ȃ����H";
		mes "���̉��{�͂ȁA���̖ꂳ���";
		mes "�ꂳ�񂪍�����񂾂�B";
		close;
	}
	mes "[��������]";
	mes "���̉��{�A�i�D�����Ǝv��Ȃ����H";
	mes "���̉��{�͂ȁA���̖ꂳ���";
	mes "�ꂳ�񂪍�����񂾂�B";
	next;
	mes "[��������]";
	mes "��������v�����A";
	mes "�~�����Ēg�����񂾂�B";
	mes "�������낤�H";
	next;
	menu "�~�͂���ȂɊ�����ł����H",-;
	if(rand(10) < 7) {
		mes "[��������]";
		mes "�������ȁB";
		mes "�����̒��ɂ��Ȃ���";
		mes "�h���G�߂��Ȃ��c�c";
		close;
	}
	mes "[��������]";
	mes "�������ȁB";
	mes "�����̒��ɂ��Ȃ���";
	mes "�h���G�߂��Ȃ��c�c";
	next;
	mes "[��������]";
	mes "����ϔ������Ȃ���";
	mes "�h���~�݂͂�Ȍ������낤�ȁB";
	mes "�܂������A�~��������΂����񂾂��c�c";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x04;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

moscovia,228,80,3	script	�q��#mosk16	962,{
	if(MOSK_3QUE != 10 || MOSK_3QUE_SUB & 0x01) {
		mes "[�q��]";
		mes "�����ĂƁB";
		mes "�����͉����ėV�ڂ����ȁ[�H";
		close;
	}
	mes "[�q��]";
	mes "�����ĂƁB";
	mes "�����͉����ėV�ڂ����ȁ[�H";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "���́c�c������Ƃ������ȁH";
	next;
	mes "[�q��]";
	mes "��A�Ȃ��ɁH";
	next;
	menu "�Ă͍D���H",-;
	if(rand(10) < 7) {
		mes "[�q��]";
		mes "�ܘ_�A�Ă͍D������B";
		mes "�ȂɂȂɁH";
		mes "�A���P�[�g�������H";
		close;
	}
	mes "[�q��]";
	mes "�ܘ_�A�Ă͍D������B";
	mes "�������ǂ��ŗV�Ԃ�";
	mes "�Y��ł����炢����I";
	next;
	mes "[�q��]";
	mes "�ł��A������������Ȃ񂾂�Ȃ��B";
	mes "�~�ɂȂ�ƊO�ɗV�тɍs���Ȃ��";
	mes "�ł��Ȃ��Ȃ����Ⴄ����ˁ[";
	mes "���[���A�~�Ȃ��";
	mes "���Ȃ��Ⴂ���̂ɁI";
	misceffect 215,"";
	set MOSK_3QUE_SUB,MOSK_3QUE_SUB | 0x01;
	if(MOSK_3QUE_SUB == 0x07) {
		set MOSK_3QUE,11;
		set MOSK_3QUE_SUB,0;
	}
	close;
}

mosk_dun02,53,220,0	script	#�o�o���K�̉�	45,1,1,{
	switch(MOSK_3QUE) {
	case 11:
		hideoffnpc "���m1#mosk";
		hideoffnpc "���m2#mosk";
		hideoffnpc "���m3#mosk";
		mes "[���m]";
		mes "�����̎ҁA�~�܂�I";
		next;
		mes "[���m]";
		mes "���O���o�o���K��";
		mes "�q�����Ă���Ƃ̏��𓾂����߁A";
		mes "�g�����S�������Ă��炤�I";
		next;
		mes "[���m]";
		mes "�ى��̓`���[���l�̑O�ł���B";
		mes "�����A�������Ă����I";
		close2;
		hideonnpc "���m1#mosk";
		hideonnpc "���m2#mosk";
		hideonnpc "���m3#mosk";
		set MOSK_3QUE,12;
		warp "mosk_in",125,92;
		end;
	case 12:
	case 13:
		hideoffnpc "���m1#mosk";
		hideoffnpc "���m2#mosk";
		hideoffnpc "���m3#mosk";
		mes "[���m]";
		mes "�~�܂�I";
		mes "��X�͂����Ńo�o���K��";
		mes "�x���Ď����Ă���B";
		mes "���O�͐�قǑ��̒�������";
		mes "�`���[���l�̌��֘A�s�����͂����B";
		next;
		if(select("������","������������") == 1) {
			mes "[���m]";
			mes "��X�������𓮂��ʂƒm��A";
			mes "���̏�𓦂�����肩�c�c";
			mes "�����o���Ă����B";
			mes "�����Ɏ����̑��Ń`���[���l��";
			mes "���ւ����Ȃ������ꍇ�A";
			mes "���O�͎w����z����邩������񂼁I";
			close2;
			hideonnpc "���m1#mosk";
			hideonnpc "���m2#mosk";
			hideonnpc "���m3#mosk";
			warp "mosk_dun02",100,100;
			end;
		}
		mes "-���܂ł̎���������悤�Ƃ������A";
		mes "�@���t���Ղ�ꂽ-";
		next;
		mes "[���m]";
		mes "�ى��̓`���[���l�̑O�ł���B";
		mes "���O�ɂǂ�ȖړI�����낤���A";
		mes "��X�̔C���͂����Ńo�o���K��";
		mes "�Ď��������鎖���B";
		next;
		mes "[���m]";
		mes "�킩������A�����Ɏ����̑���";
		mes "�`���[���l�̌��֍s���I";
		mes "�łȂ���΁A���O��";
		mes "�w����z����邩������񂼁I";
		close2;
		hideonnpc "���m1#mosk";
		hideonnpc "���m2#mosk";
		hideonnpc "���m3#mosk";
		end;
	default:
		warp "mosk_in",215,41;
		end;
	}
}

mosk_dun02,53,215,3	script	���m1#mosk	966,{
	mes "[���m]";
	mes "��X�̓`���[���l�̒����R���B";
	mes "�����ɋً}�z������Ă���B";
	mes "���ꂮ�����X�̎ז�������ȁI";
	close;
OnInit:
	hideonnpc;
	end;
}
mosk_dun02,50,217,3	duplicate(���m1#mosk)	���m2#mosk	966
mosk_dun02,56,217,5	duplicate(���m1#mosk)	���m3#mosk	966

mosk_in,217,45,0	script	#�{	111,{
	switch(MOSK_3QUE) {
	case 15:
		mes "[" +strcharinfo(0)+ "]";
		mes "�ƂĂ��傫�Ȗ{���u���Ă���B";
		mes "�����͉�ǂł��Ȃ����A";
		mes "���̈Ӗ����킩��Ȃ��}�G������B";
		mes "�ǂ߂�̂̓o�o���K��";
		mes "�󂵂������������c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�悵�A�ǂ�ł݂悤�B";
		next;
		mes "-�c�c�܂�A���̖��p��";
		mes "�@��X���g�����p�̂����A";
		mes "�@�B�ꏃ���Ȗ��p�ƌ�����-";
		next;
		mes "-�ʏ�A���p�͈����Ƃ̌_���";
		mes "�@��Ă�����̂��������A";
		mes "�@���̖��p�͎��R���ۂ�";
		mes "�@�l�Ԃ̎v�O�������������̂ł���A";
		mes "�@�����̗͍͂��݂��Ă��Ȃ�-";
		next;
		mes "-�����āA���̖��p��";
		mes "�@��̓���������-";
		next;
		mes "-��A���R���ۂ֊����鎖-";
		mes "-��ȂȊw�҂̍l���ɔ����A";
		mes "�@���̐��E�͖ڂɂ͌����Ȃ�";
		mes "�@���I�ȃ��[���ɏ]���Ă���-";
		next;
		mes "-���̐��I�ȃ��[����";
		mes "�@�y���h����^���邾���ŁA";
		mes "�@�ʏ�ł͂��肦�Ȃ�";
		mes "�@�s���R�Ȍ��ۂ��N����-";
		mes "-�Ȍ��Ɍ����΁A��Ղ��������-";
		next;
		mes "-�����̓V�󖂏p��";
		mes "�@����ɓ��Ă͂܂�-";
		mes "-�������A���R���ۂɑ΂���m����";
		mes "�@�\���ɖ�����΁A���[����";
		mes "�@�G��鎖�͕s�\��-";
		next;
		mes "-�Ȃ��Ȃ�A���̐��E���\�����Ă���";
		mes "�@���[���͕��G�ɁA";
		mes "�@���Ɍq�����Ă��邩�炾-";
		mes "-���̃��[���̍\����S�ė�������̂�";
		mes "�@����̋ƂƂ�����-";
		next;
		mes "-�������A���ɑ��݂��Ă��閂�p��";
		mes "�@���̂܂܍Č�����̂͗e�Ղł���-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "��������������ȁc�c";
		next;
		mes "-��ڂ̓����́A";
		mes "�@���̖��p���l�Ԃ̗~�]��";
		mes "�@��ق��Ă��鎖-";
		next;
		mes "-�l�Ԃ̗~�]��z���͌����Čy���Ȃ�-";
		mes "-�����A�l�̎v�O�������ۂ�A";
		mes "�@���ۂ̃G�l���M�[�Ƃ���";
		mes "�@����鎖������-";
		next;
		mes "-�ł́A���ۂɓV��𑀂�";
		mes "�@���p���L�q����-";
		next;
		mes "-���C������A�l�C�̖�����Ԃɂ�";
		mes "�@�ޗ����ς鎖���ł���e���u��-";
		mes "-�Ō�ɕK�v�ƂȂ�̂�";
		mes "�@�p�҂̋����ӎu-";
		next;
		mes "-�ޗ��͐������H���𓥂݁A";
		mes "�@�����H����������ꍇ��";
		mes "�@�����ɒ��f����-";
		next;
		mes "-���p�̘R�k��h���ׁA";
		mes "�@�ޗ��̖��̂��Í������邪�A";
		mes "�@���̖{��ǂ߂�҂Ȃ�A";
		mes "�@���������̂������ł��邾�낤-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "����Ɩ��p�̐������c�c";
		mes "�悵�A�����ɉ�������ł������B";
		mes "��������΁A���x�����";
		mes "�ޗ��̏�����ǂ߂�B";
		set MOSK_3QUE,16;
		next;
		mes "-^0000FF�G�ߖ��p^000000�F^FF0000���g��^000000-";
		mes "-�܂��A���M�����e��ɂ�";
		mes "�@���̎O������������-";
		next;
		mes "-���������𗊂�ɔ�Ԏ҂�";
		mes "�@�@�Ԃ��F�̉H";
		mes "�@�������������A���̑̂�";
		mes "�@�@�\������g�D";
		mes "�@����ɒ��ˑ����Ă���҂̑�-";
		next;
		mes "-�����O����������킹��ƁA";
		mes "�@��ɏ�����̂����܂낤�Ƃ���-";
		mes "-���ꂾ���ł��V��ɕω��͂��邪�A";
		mes "�@�܂��C�t�����ł͂Ȃ�-";
		next;
		mes "-���ɁA���̐��E�̑啔����";
		mes "�@�\�����镨������-";
		mes "-�����āA20�񍬂��Ă��΂炭�҂�-";
		mes "-�Z���ԂŐF�Ɠ����̕ω���";
		mes "�@�C���t���͂��ł���-";
		next;
		mes "-������������A";
		mes "�@�S�Ă̍H���͐��m�Ȏ菇��";
		mes "�@�s��Ȃ���΂Ȃ�Ȃ�-";
		mes "-�����ł��^����������A";
		mes "�@�����ɂ�蒼������������-";
		next;
		mes "-�����āA���̓����X�ɓ����-";
		mes "-������������";
		mes "�@���Y��ȍ����ł߂���-";
		mes "-��������ꂽ��A";
		mes "�@�t�̂̓������ς�����̂��m�F����-";
		next;
		mes "-�����̕ω����m�F������A";
		mes "�@15�񍬂���-";
		mes "-����ƁA�t�̂̐F���ω�����̂ŁA";
		mes "�@�X�ɎO��̍ޗ�������-";
		next;
		mes "-�܂��A���z�Ɏ�����-";
		mes "-���ɁA�N���܂ƂȂ镨-";
		mes "-�����āA�΂ł���Ȃ���A";
		mes "�@�M�������A�ۓ����Ă��镨-";
		mes "-���������Ԃǂ���ɓ�����";
		mes "�@�V��ɕω��������邾�낤-";
		next;
		mes "-�Ō�ɁA�����������������߁A";
		mes "�@�ω�����ȂɎ󂯓���Ȃ�";
		mes "�@�u�i���̏ے��v������-";
		next;
		mes "-���������t�̂�l�Ԃ̗~�]��";
		mes "�@�l�܂����r�Ɉꎞ�I�ɓ���A";
		mes "�@�V��̕ω����肤�҂��W���n���";
		mes "�@�قڒ����ŎU�z�����";
		mes "�@���p�͊�������-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "����ȏ�̓o�o���K��";
		mes "�|�󂵂Ă��Ȃ��c�c";
		close;
	case 16:
		if(select("�O��������ǂ�","�������������������ǂ�") == 1) {
			mes "-�c�c�܂�A���̖��p��";
			mes "�@��X���g�����p�̂����A";
			mes "�@�B�ꏃ���Ȗ��p�ƌ�����-";
			next;
			mes "-�ʏ�A���p�͈����Ƃ̌_���";
			mes "�@��Ă�����̂��������A";
			mes "�@���̖��p�͎��R���ۂ�";
			mes "�@�l�Ԃ̎v�O�������������̂ł���A";
			mes "�@�����̗͍͂��݂��Ă��Ȃ�-";
			next;
			mes "-�����āA���̖��p��";
			mes "�@��̓���������-";
			next;
			mes "-��A���R���ۂ֊����鎖-";
			mes "-��ȂȊw�҂̍l���ɔ����A";
			mes "�@���̐��E�͖ڂɂ͌����Ȃ�";
			mes "�@���I�ȃ��[���ɏ]���Ă���-";
			next;
			mes "-���̐��I�ȃ��[����";
			mes "�@�y���h����^���邾���ŁA";
			mes "�@�ʏ�ł͂��肦�Ȃ�";
			mes "�@�s���R�Ȍ��ۂ��N����-";
			mes "-�Ȍ��Ɍ����΁A��Ղ��������-";
			next;
			mes "-�����̓V�󖂏p��";
			mes "�@����ɓ��Ă͂܂�-";
			mes "-�������A���R���ۂɑ΂���m����";
			mes "�@�\���ɖ�����΁A���[����";
			mes "�@�G��鎖�͕s�\��-";
			next;
			mes "-�Ȃ��Ȃ�A���̐��E���\�����Ă���";
			mes "�@���[���͕��G�ɁA";
			mes "�@���Ɍq�����Ă��邩�炾-";
			mes "-���̃��[���̍\����S�ė�������̂�";
			mes "�@����̋ƂƂ�����-";
			next;
			mes "-�������A���ɑ��݂��Ă��閂�p��";
			mes "�@���̂܂܍Č�����̂͗e�Ղł���-";
			next;
			mes "-��ڂ̓����́A";
			mes "�@���̖��p���l�Ԃ̗~�]��";
			mes "�@��ق��Ă��鎖-";
			next;
			mes "-�l�Ԃ̗~�]��z���͌����Čy���Ȃ�-";
			mes "-�����A�l�̎v�O�������ۂ�A";
			mes "�@���ۂ̃G�l���M�[�Ƃ���";
			mes "�@����鎖������-";
			next;
			mes "-�ł́A���ۂɓV��𑀂�";
			mes "�@���p���L�q����-";
			next;
			mes "-���C������A�l�C�̖�����Ԃɂ�";
			mes "�@�ޗ����ς鎖���ł���e���u��-";
			mes "-�Ō�ɕK�v�ƂȂ�̂�";
			mes "�@�p�҂̋����ӎu-";
			next;
			mes "-�ޗ��͐������H���𓥂݁A";
			mes "�@�����H����������ꍇ��";
			mes "�@�����ɒ��f����-";
			next;
			mes "-���p�̘R�k��h���ׁA";
			mes "�@�ޗ��̖��̂��Í������邪�A";
			mes "�@���̖{��ǂ߂�҂Ȃ�A";
			mes "�@���������̂������ł��邾�낤-";
			next;
		}
		mes "-^0000FF�G�ߖ��p^000000�F^FF0000���g��^000000-";
		mes "-�܂��A���M�����e��ɂ�";
		mes "�@���̎O������������-";
		next;
		mes "-���������𗊂�ɔ�Ԏ҂�";
		mes "�@�@�Ԃ��F�̉H";
		mes "�@�������������A���̑̂�";
		mes "�@�@�\������g�D";
		mes "�@����ɒ��ˑ����Ă���҂̑�-";
		next;
		mes "-�����O����������킹��ƁA";
		mes "�@��ɏ�����̂����܂낤�Ƃ���-";
		mes "-���ꂾ���ł��V��ɕω��͂��邪�A";
		mes "�@�܂��C�t�����ł͂Ȃ�-";
		next;
		mes "-���ɁA���̐��E�̑啔����";
		mes "�@�\�����镨������-";
		mes "-�����āA20�񍬂��Ă��΂炭�҂�-";
		mes "-�Z���ԂŐF�Ɠ����̕ω���";
		mes "�@�C���t���͂��ł���-";
		next;
		mes "-������������A";
		mes "�@�S�Ă̍H���͐��m�Ȏ菇��";
		mes "�@�s��Ȃ���΂Ȃ�Ȃ�-";
		mes "-�����ł��^����������A";
		mes "�@�����ɂ�蒼������������-";
		next;
		mes "-�����āA���̓����X�ɓ����-";
		mes "-������������";
		mes "�@���Y��ȍ����ł߂���-";
		mes "-��������ꂽ��A";
		mes "�@�t�̂̓������ς�����̂��m�F����-";
		next;
		mes "-�����̕ω����m�F������A";
		mes "�@15�񍬂���-";
		mes "-����ƁA�t�̂̐F���ω�����̂ŁA";
		mes "�@�X�ɎO��̍ޗ�������-";
		next;
		mes "-�܂��A���z�Ɏ�����-";
		mes "-���ɁA�N���܂ƂȂ镨-";
		mes "-�����āA�΂ł���Ȃ���A";
		mes "�@�M�������A�ۓ����Ă��镨-";
		mes "-���������Ԃǂ���ɓ�����";
		mes "�@�V��ɕω��������邾�낤-";
		next;
		mes "-�Ō�ɁA�����������������߁A";
		mes "�@�ω�����ȂɎ󂯓���Ȃ�";
		mes "�@�u�i���̏ے��v������-";
		next;
		mes "-���������t�̂�l�Ԃ̗~�]��";
		mes "�@�l�܂����r�Ɉꎞ�I�ɓ���A";
		mes "�@�V��̕ω����肤�҂��W���n���";
		mes "�@�قڒ����ŎU�z�����";
		mes "�@���p�͊�������-";
		close;
	default:
		if(MOSK_3QUE < 14) {
			mes "-�ƂĂ��傫�Ȗ{���u���Ă���-";
			close;
		}
		mes "[" +strcharinfo(0)+ "]";
		mes "���̍������ڂ��Ă���{���B";
		mes "�c�c�܂������낤�Ƃ��Ȃ�����";
		mes "�K�v�Ȃ����낤�B";
		close;
	}
}

mosk_in,221,43,0	script	#��	111,{
	if(MOSK_3QUE != 16)
		end;
	mes "[" +strcharinfo(0)+ "]";
	mes "���Ȃ�������炪����B";
	mes "���������łɓ����Ă��邪�c�c";
	mes "���Ȃ��������Ƃɂ��悤�c�c";
	mes "���炭�o�o���K�����n����";
	mes "���Ă��������̂��낤�B";
	mes "���āA��Ƃ��n�߂Ă݂悤���B";
	setarray .@itemname$,"�Ԃ��R�E�����̗�","�ێ�","�o�b�^�̑�","�����̐��̍�","���ꂢ�ȏ���";
	while(.@count < 3) {
		next;
		mes "-�������܂����H-";
		next;
		switch(select("�ޗ�������","��������","������","�I���")) {
		case 1:
			set .@num,select(printarray(.@itemname$))-1;
			mes "-" +.@itemname$[.@num]+ "����ꂽ-";
			mes "-�����������ς�����悤��-";
			if(.@num < 4 && (.@flag & (1 << .@num)) == 0) {
				misceffect 44;
				set .@flag,.@flag | (1 << .@num);
				set .@success,.@success+1;
			}
			else {
				misceffect 53;
			}
			break;
		case 2:
			mes "-���ŏ��������Ȃ����悤�����A";
			mes "�@���ɕω��͖���������-";
			misceffect 53;
			break;
		case 3:
			mes "-�_���g���ĉ���";
			mes "�@���������Ă݂�-";
			mes "-�������A���ɕω��͖����悤��-";
			misceffect 53;
			break;
		case 4:
			mes "[" +strcharinfo(0)+ "]";
			mes "����ő��v���ȁH";
			mes "�o�o���K�ɕ����Ă݂悤�B";
			misceffect 192;
			set MOSK_3QUE,17;
			close;
		}
		set .@count,.@count+1;
	}
	next;
	misceffect 109;
	mes "-�C�A���o�Ă��āA";
	mes "�@�t�̂̎����ς���Ă��Ă���̂�";
	mes "�@�ڂɌ����Ă���-";
	while(.@count < 7) {
		next;
		mes "-���͂ǂ����܂����H-";
		next;
		switch(select("�ޗ�������","��������","������","�I���")) {
		case 1:
			set .@num,select(printarray(.@itemname$))-1;
			mes "-" +.@itemname$[.@num]+ "����ꂽ-";
			mes "-�����������ς�����悤��-";
			if((.@count == 5 || .@count == 6) && .@num > 3 && (.@flag & (1 << .@num)) == 0) {
				misceffect 44;
				set .@flag,.@flag | (1 << .@num);
				set .@success,.@success+1;
			}
			else {
				misceffect 53;
			}
			break;
		case 2:
			if(.@count == 3) {
				mes "-�������������ƁA";
				mes "�@�����ɔ��������̂��A";
				mes "�@�����Ǝς��鉹��";
				mes "�@�r�[�ɑ傫���Ȃ���-";
				misceffect 373;
				set .@success,.@success+1;
			}
			else {
				mes "-���ŏ��������Ȃ����悤�����A";
				mes "�@���ɕω��͖���������-";
				misceffect 53;
			}
			break;
		case 3:
			if(.@count == 4) {
				mes "[" +strcharinfo(0)+ "]";
				mes "���񍬂���񂾂������ȁH";
				next;
				input .@num;
				if(.@num == 0) {
					mes "-������̂��~�߂�-";
					continue;
				}
				else if(.@num < 0 || .@num > 100) {
					mes "[" +strcharinfo(0)+ "]";
					mes "����c�c����Ȃ�";
					mes "�����Ȃ��Ă悩�����C���c�c";
					mes "������x�v���o���Ă݂悤�B";
					continue;
				}
				else if(.@num == 20) {
					mes "[" +strcharinfo(0)+ "]";
					mes "�m��20�񂾂����I";
					next;
					mes "-20�񍬂���ƁA";
					mes "�@�F���Y��ɂȂ�A�������ǂ��Ȃ���-";
					misceffect 224;
					set .@success,.@success+1;
				}
				else {
					mes "-�_���g���ĉ���";
					mes "�@���������Ă݂�-";
					mes "-�������A���ɕω��͖����悤��-";
				}
			}
			else {
				mes "-�_���g���ĉ���";
				mes "�@���������Ă݂�-";
				mes "-�������A���ɕω��͖����悤��-";
				misceffect 53;
			}
			break;
		case 4:
			mes "[" +strcharinfo(0)+ "]";
			mes "����ő��v���ȁH";
			mes "�o�o���K�ɕ����Ă݂悤�B";
			misceffect 192;
			set MOSK_3QUE,17;
			close;
		}
		set .@count,.@count+1;
	}
	mes "[" +strcharinfo(0)+ "]";
	mes "�m���A���̌��";
	mes "�����҂񂾂������ȁc�c";
	next;
	mes "�c�c�c�c�c�c�c�c";
	next;
	mes "�c�c�c�c�c�c�c�c";
	next;
	mes "-��̒��g�̓����������ǂ��Ȃ���-";
	setarray .@itemname$,"�����̐��̍�","���ꂢ�ȏ���","����","���b�h�u���b�h","�R���Ă���S��";
	while(1) {
		next;
		mes "-���͂ǂ����܂����H-";
		next;
		switch(select("�ޗ�������","��������","������","�I���")) {
		case 1:
			if(.@count == 11)
				set .@itemname$[5],"�_�C�������h";
			else
				set .@itemname$[5],"";
			set .@num,select(printarray(.@itemname$))-1;
			mes "-" +.@itemname$[.@num]+ "����ꂽ-";
			mes "-�����������ς�����悤��-";
			if((.@count == 8 && .@num == 3) || (.@count == 9 && .@num == 2) || (.@count == 10 && .@num == 4) || (.@count == 11 && .@num == 5)) {
				misceffect 44;
				set .@flag,.@flag | (1 << .@num);
				set .@success,.@success+1;
			}
			else {
				misceffect 53;
			}
			break;
		case 2:
			mes "-���ŏ��������Ȃ����悤�����A";
			mes "�@���ɕω��͖���������-";
			misceffect 53;
			break;
		case 3:
			if(.@count == 7) {
				mes "[" +strcharinfo(0)+ "]";
				mes "���񍬂���񂾂������ȁH";
				next;
				input .@num;
				if(.@num == 0) {
					mes "-������̂��~�߂�-";
					continue;
				}
				else if(.@num < 0 || .@num > 100) {
					mes "[" +strcharinfo(0)+ "]";
					mes "����c�c����Ȃ�";
					mes "�����Ȃ��Ă悩�����C���c�c";
					mes "������x�v���o���Ă݂悤�B";
					continue;
				}
				else if(.@num == 15) {
					mes "[" +strcharinfo(0)+ "]";
					mes "�m��15�񂾂����I";
					next;
					mes "-15�񍬂���ƁA";
					mes "�@�����Ő��񂾐F�ɂȂ���-";
					misceffect 224;
					set .@success,.@success+1;
				}
				else {
					mes "-�_���g���ĉ���";
					mes "�@���������Ă݂�-";
					mes "-�������A���ɕω��͖����悤��-";
				}
			}
			else {
				mes "-�_���g���ĉ���";
				mes "�@���������Ă݂�-";
				mes "-�������A���ɕω��͖����悤��-";
				misceffect 53;
			}
			break;
		case 4:
			mes "[" +strcharinfo(0)+ "]";
			mes "����ő��v���ȁH";
			mes "�o�o���K�ɕ����Ă݂悤�B";
			if(.@success < 12) {
				misceffect 192;
				set MOSK_3QUE,17;
			}
			else {
				misceffect 110;
				set MOSK_3QUE,18;
			}
			close;
		}
		set .@count,.@count+1;
	}
}

moscovia,224,190,0	script	#�X�̒���	844,{
	if(MOSK_3QUE != 19)
		end;
	mes "[" +strcharinfo(0)+ "]";
	mes "���̕ӂ肩�ȁc�c";
	mes "���̊X�̒��S�́c�c";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "�悵�A����Ă݂悤�I";
	next;
	mes "-�o�o���K�̔���";
	mes "�@�n�ʂɗ��Ƃ��Ċ�����-";
	misceffect 63,"";
	delitem 7765,1;
	set MOSK_3QUE,20;
	next;
	mes "-�����g�������ɐ����ꂽ";
	mes "�@�C������-";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "����Łc�c�ς�������ȁH";
	mes "�������ɋG�߂�������";
	mes "�m�F����͖̂������ȁc�c";
	next;
	mes "[" +strcharinfo(0)+ "]";
	mes "�Ƃ肠�����A";
	mes "�`���[�����ɕ񍐂��Ă݂悤�B";
	close;
}