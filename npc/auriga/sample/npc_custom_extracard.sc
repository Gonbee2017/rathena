prt_in,94,61,3	script	�J�[�h�R���N�^�[::ExtraCard	515,{
	if (!EXT_CAR_INTRODUCE) {
		mes "[�~�[��]";
		mes "�������̓~�[���̖��̃~�[���B";
		mes "���Z��������`���Ȃ���";
		mes "�ꏏ�ɗ������Ă�̂�B";
		next;
		if (BaseLevel < 99) {
			mes "[�~�[��]";
			mes "�����͂ق�Ƒf�G�ȊX��ˁB";
			mes "�͂₭�V�тɍs�������ȁ[�B";
			close;
		}
		mes "[�~�[��]";
		mes "�������̎�̓g���[�h��";
		mes "�������J�[�h���W�߂邱�ƁB";
		mes "�˂��˂��A�g���[�h�ɋ����Ȃ��H";
		next;
		if (select("����", "�Ȃ�") == 2) {
			mes "[�~�[��]";
			mes "�����A�����Ȃ́H";
			mes "����˂�[�c�c";
			close;
		}
		mes "[�~�[��]";
		mes "�ق�ƁH";
		mes "����A���������g���[�h����B";
		next;
		set EXT_CAR_INTRODUCE, 1;
	} else {
		mes "[�~�[��]";
		mes "����ɂ���[�B";
		mes "�J�[�h���g���[�h���ɗ����́H";
		next;
	}
	set .@men, select("�܂����x", "�����𕷂�", "�g���[�h����") - 1;
	if (.@men == 1) {
		mes "[�~�[��]";
		mes "�g���[�h�̃��[�����������ˁB";
		next;
		mes "[�~�[��]";
		mes "-���[�� ����1-";
		mes "�������̎����Ă�^FF40401��^000000��";
		mes "���Ȃ��̎����Ă�^FF4040" + .pla_cars_siz + "��^000000��";
		mes "�g���[�h����B";
		next;
		mes "[�~�[��]";
		mes "-���[�� ����2-";
		mes "���Ȃ����o���J�[�h��";
		mes "���������������Ǝv��";
		mes "�J�[�h�Ɍ�����B";
		next;
		mes "[�~�[��]";
		mes "-���[�� ����3-";
		mes "�ǂ̃J�[�h���g���[�h���邩��";
		mes "���Ȃ����S�����߂���B";
		next;
		mes "[�~�[��]";
		mes "���[���͂���3����B";
		mes "�����A�悭�킩��Ȃ��H";
		mes "�܁[�A�����Ƀg���[�h���Ă݂Ă�B";
		next;
	} else if (.@men == 2) {
		mes "[�~�[��]";
		mes "�܂��A�������̃J�[�h�̒�����";
		mes "���Ȃ����~�����̂�I��łˁB";
		next;
		for (set .@i, 0; .@i < getarraysize(.ext_cars); ++.@i)
			set .@ext_car_lis$[getarraysize(.@ext_car_lis$)], getitemname(.ext_cars[.@i]);
		set .@ext_car_lis$[getarraysize(.@ext_car_lis$)], "��߂�";
		set .@ext_car_ind, select(printarray(.@ext_car_lis$)) - 1;
		if (.@ext_car_ind < getarraysize(.ext_cars)) {
			set .@ext_car, .ext_cars[.@ext_car_ind];
			set .@ext_car_nam$, .@ext_car_lis$[.@ext_car_ind];
			mes "[�~�[��]";
			mes "^4040FF" + .@ext_car_nam$ + "^000000�ˁB";
			mes "����A������[�B";
			mes "���͂��Ȃ��̃J�[�h�������āB";
			next;
			getinventorylist;
			for (set .@i, 0; .@i < @inventorylist_count; ++.@i) {
				set .@inv_id, @inventorylist_id[.@i];
				if (.@inv_id >= .nor_car_fir &&
					.@inv_id < .nor_car_las
				) {
					if (inarray(.rar_cars, .@inv_id) >= 0)
						set .@inv_rar_cars[getarraysize(.@inv_rar_cars)], .@inv_id;
				}
			}
			if (!getarraysize(.@inv_rar_cars)) {
				mes "[�~�[��]";
				mes "���[��c�c����������������";
				mes "�v���J�[�h�͂Ȃ����ȁ[�B";
				next;
			} else {
				mes "[�~�[��]";
				mes "�����Ɓc�c�������J�[�h��";
				mes "�c�c����ȂƂ��납�ȁB";
				mes "����A���̒����炠�Ȃ����o��";
				mes "�J�[�h��I��ł��傤�����B";
				next;
				for (set .@i, 0; .@i < getarraysize(.@inv_rar_cars); ++.@i)
					set .@inv_rar_car_lis$[getarraysize(.@inv_rar_car_lis$)], getitemname(.@inv_rar_cars[.@i]);
				set .@inv_rar_car_lis$[getarraysize(.@inv_rar_car_lis$)], "��߂�";
				for (set .@i, 0; .@i < .pla_cars_siz; ++.@i) {
					set .@inv_rar_car_ind, select(printarray(.@inv_rar_car_lis$)) - 1;
					if (.@inv_rar_car_ind >= getarraysize(.@inv_rar_cars)) break;
					set .@pla_car, .@inv_rar_cars[.@inv_rar_car_ind];
					set .@pla_car_nam$, .@inv_rar_car_lis$[.@inv_rar_car_ind];
					for (set .@j, 0; .@j < getarraysize(.@pla_cars); ++.@j) {
						if (.@pla_cars[.@j] == .@pla_car) break;
					}
					set .@pla_cars[.@j], .@pla_car;
					++.@pla_car_amos[.@j];
					set .@pla_car_nams$[.@j], .@pla_car_nam$;
					mes "[�~�[��]";
					mes "^4040FF" + .@pla_car_nam$ + "^000000�ˁB";
					if (.@i + 1 < .pla_cars_siz)
						mes "���̃J�[�h�͂ǂ�ɂ���H";
					else mes "�g���[�h�̓��e���m�F�����B";
					next;
				}
				if (.@i >= .pla_cars_siz) {
					mes "[�~�[��]";
					mes "-���炤�J�[�h-";
					mes "^4040FF" + .@ext_car_nam$ + "^000000 ^FF40401��^000000";
					mes "-������J�[�h-";
					for (set .@i, 0; .@i < getarraysize(.@pla_cars); ++.@i)
						mes "^4040FF" + .@pla_car_nams$[.@i] + "^000000 ^FF4040" + .@pla_car_amos[.@i] + "��^000000";
					mes "���̓��e�Ńg���[�h���Ă������H";
					next;
					if (select("����ł���", "����ς�_��") == 1) {
						
						// �A�g�~�b�N
						for (set .@i, 0; .@i < getarraysize(.@pla_cars); ++.@i) {
							if (countitem(.@pla_cars[.@i]) < .@pla_car_amos[.@i]) {
								mes "[�~�[��]";
								mes "�c�c�����H";
								mes "�悭����ƃJ�[�h��";
								mes "����Ȃ��݂�������H";
								close;
							}
						}
						for (set .@i, 0; .@i < getarraysize(.@pla_cars); ++.@i)
							delitem .@pla_cars[.@i], .@pla_car_amos[.@i];
						getitem .@ext_car, 1;
						emotion ET_DELIGHT;
						mes "[�~�[��]";
						mes "�I�b�P�[�A���������ˁB";
						mes "��������J�[�h�͑厖�ɂ����B";
						close;
						
					}
				}
			}
		}
	}
	mes "[�~�[��]";
	mes "�����������J�[�h����ɓ�������";
	mes "�g���[�h���l���Ă݂ĂˁB";
	close;
OnInit:
	set .pla_cars_siz, 2;
	set .ext_cars[getarraysize(.ext_cars)], 29900; // Atk + 50
	set .ext_cars[getarraysize(.ext_cars)], 29901; // �K�� + 50%
	set .ext_cars[getarraysize(.ext_cars)], 29902; // Def50%����
	set .ext_cars[getarraysize(.ext_cars)], 29903; // Mdef10%����
	set .ext_cars[getarraysize(.ext_cars)], 29904; // �ߐ�Atk + 100
	set .ext_cars[getarraysize(.ext_cars)], 29905; // �ߐڕK�� + 100%
	set .ext_cars[getarraysize(.ext_cars)], 29906; // �ߐ�Def100%����
	set .ext_cars[getarraysize(.ext_cars)], 29907; // �����@ + 200%
	set .ext_cars[getarraysize(.ext_cars)], 29908; // �����@ + 10%
	set .ext_cars[getarraysize(.ext_cars)], 29909; // �n���@ + 20%
	set .ext_cars[getarraysize(.ext_cars)], 29910; // �Ζ��@ + 10%
	set .ext_cars[getarraysize(.ext_cars)], 29911; // �����@ + 10%
	set .ext_cars[getarraysize(.ext_cars)], 29912; // �O���@ + 20%
	set .ext_cars[getarraysize(.ext_cars)], 29913; // �G�X�} + 10%
	set .ext_cars[getarraysize(.ext_cars)], 29914; // �}�W�b�N�N���b�V���[
	set .ext_cars[getarraysize(.ext_cars)], 29915; // ���E�@ + 30%
	set .ext_cars[getarraysize(.ext_cars)], 29916; // �ΔE�@ + 30%
	set .ext_cars[getarraysize(.ext_cars)], 29917; // ���E�@ + 30%
	set .ext_cars[getarraysize(.ext_cars)], 29918; // �q�[�� + 10%
	set .ext_cars[getarraysize(.ext_cars)], 29919; // �ߐڃA�X���v�e�B�I����
	set .ext_cars[getarraysize(.ext_cars)], 29920; // �ߐڃI�[�g�J�E���^�[����
	set .ext_cars[getarraysize(.ext_cars)], 29921; // �ߐڃI�[�g�K�[�h����
	set .ext_cars[getarraysize(.ext_cars)], 29922; // �ߐڃX�g�[���X�L������
	set .ext_cars[getarraysize(.ext_cars)], 29923; // �f�����X�g���[�V��������
	set .ext_cars[getarraysize(.ext_cars)], 29924; // �C�[�r�������h����
	set .ext_cars[getarraysize(.ext_cars)], 29925; // �N�@�O�}�C�A����
	set .ext_cars[getarraysize(.ext_cars)], 29926; // �x�i���_�X�g����
	set .ext_cars[getarraysize(.ext_cars)], 29927; // �u�����f�B�b�V���X�s�A����
	set .ext_cars[getarraysize(.ext_cars)], 29928; // �}�O�i���u���C�N����
	set .ext_cars[getarraysize(.ext_cars)], 29929; // �p���X�X�g���C�N����
	set .ext_cars[getarraysize(.ext_cars)], 29930; // ����[��
	set .ext_cars[getarraysize(.ext_cars)], 29931; // Aspd + 1
	set .ext_cars[getarraysize(.ext_cars)], 29932; // �ߐ�Aspd + 2
	set .ext_cars[getarraysize(.ext_cars)], 29933; // Cri + 12
	set .nor_car_fir, 4000;
	set .nor_car_las, 4700;
	set .rar_cars[getarraysize(.rar_cars)], 4054; // �G���W�F�����O�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4047; // �S�[�X�g�����O�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4121; // �t���I�j�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4123; // �G�h�K�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4128; // ����峃J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4131; // ����ԃJ�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4132; // �~�X�g���X�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4134; // �h���L�����J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4135; // �I�[�N���[�h�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4137; // �h���C�N�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4142; // �h�b�y���Q���K�[�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4143; // �I�[�N�q�[���[�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4144; // �I�V���X�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4145; // ���F���[�u�u�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4146; // �}���[�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4147; // �o�t�H���b�g�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4148; // �t�@���I�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4168; // �_�[�N���[�h�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4174; // �f�r�������O�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4236; // �A�������[�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4263; // ���앐�m�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4276; // ���[�h�I�u�f�X�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4302; // �^�I�O���J�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4305; // �^�[�g���W�F�l�����J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4318; // �X�g�[���i�C�g�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4324; // �n�e�B�[�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4330; // ���։��J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4342; // RSX-0806�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4352; // �C�O�j�[��=�Z�j�A�iMVP�j�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4357; // �Z�C����=�E�B���U�[�iMVP�j�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4359; // �G�����X=�K�C���iMVP�j�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4361; // �n���[�h=�A���g�A�C�[���iMVP�j�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4363; // �}�[�K���b�^=�\�����iMVP�j�J�[�h	
	set .rar_cars[getarraysize(.rar_cars)], 4365; // �J�g���[�k=�P�C�����iMVP�j�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4367; // �Z�V��=�f�B�����iMVP�j�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4372; // �y�N�\�W���J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4374; // ���F�X�p�[�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4376; // ���f�B�[�^�j�[�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4386; // �f�[�^���U�E���X�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4399; // �����m�^�i�g�X�̎v�O�̃J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4403; // �L�G��-D-01�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4407; // �����h�O���X�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4408; // �O���[���A���_�[�i�C�g�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4419; // �N�g�����i�b�N�X�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4425; // �A�g���X�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4430; // �C�t���[�g�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4441; // ������_���q�o���J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4451; // �G���g���@�C�G���J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4456; // �j�[�Y�w�b�O�̉e�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4457; // �i�n�g�Y�B�[�K�[�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4462; // �n�[�h���b�N�}�����X�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4463; // �e���h�������I���J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4507; // �����X�J���o�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4509; // ����X�J���o�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4520; // �����b�N�J�[�h
	set .rar_cars[getarraysize(.rar_cars)], 4534; // ���̃^�R�J�[�h
}
