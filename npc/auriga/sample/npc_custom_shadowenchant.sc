prt_in,94,65,3	script	�����炢�̓��t::ShadowEnchant	514,{
	if (!SHA_ENC_INTRODUCE) {
		mes "[�~�[��]";
		mes "���͓��t�̃~�[���Ɛ\���܂��B";
		mes "�B���p������߂邽�߂�";
		mes "���E���𗷂��Ă��܂��B";
		next;
		mes "[�~�[��]";
		mes "���̐��B���͍��܂Ō��Ă�������";
		mes "�����Ƃ��ݔ����[�����Ă��܂��ˁB";
		mes "����������҂ɂ͍ō��̊��ł��B";
		next;
		if (BaseLevel < 99) {
			mes "[�~�[��]";
			mes "���͓����̂����������ɑ؍݂���";
			mes "�����ɖv�����悤�Ǝv���Ă��܂��B";
			close;
		}
		mes "[�~�[��]";
		mes "���͎��ɂ͓��Z�������ł���B";
		mes "�����悩�����炠�Ȃ��������Ă���";
		mes "����������Ă��炦�܂��񂩁H";
		next;
		if (select("�����������", "�f��") == 2) {
			mes "[�~�[��]";
			mes "������񖳗��ɂƂ͌����܂���B";
			mes "����������Ƌ������킢�����̂ŁB";
			close;
		}
		mes "[�~�[��]";
		mes "�ł͔q�����܂��B";
		next;
		mes "-�~�[���͎�ɂ��������";
		mes "�@�^���ȕ\��Ō��߂Ă���B-";
		next;
		mes "[�~�[��]";
		mes "�ӂށc�c�ǂ������肪�Ƃ��B";
		mes "�Ȃ��Ȃ��̑㕨�̂悤�ł���";
		mes "�܂��������݂����ł��ˁB";
		next;
		mes "[�~�[��]";
		mes "�����J����������B���@�ł���";
		mes "^4040FF�V���h�[�G���`�����g^000000�Ȃ�";
		mes "����ɋ������邱�Ƃ��\�ł��B";
		next;
		set SHA_ENC_INTRODUCE, 1;
	} else {
		mes "[�~�[��]";
		mes "�܂�������܂����ˁB";
		mes "^4040FF�V���h�[�G���`�����g^000000��";
		mes "������������܂��傤���H";
		next;
	}
	set .@men, select("���͂����ł�", "�����𕷂�", "�G���`�����g���s��", "�G���`�����g�̏��������s��") - 1;
	if (.@men == 1) {
		mes "[�~�[��]";
		mes "���͂���܂Ő��E�e�n������";
		mes "�����̕����ڂɂ��Ă��܂�����";
		mes "���̂قƂ�ǂ�^4040FF�V���h�[�X���b�g^000000��";
		mes "������Ă��邱�Ƃ𔭌����܂����B";
		next;
		mes "[�~�[��]";
		mes "^4040FF�V���h�[�X���b�g^000000�ƒʏ�̃X���b�g��";
		mes "���݂��ɔ������������߁A����̐���";
		mes "�����قǁA��������͏��Ȃ��Ȃ�܂��B";
		next;
		mes "[�~�[��]";
		mes "������^4040FF�V���h�[�X���b�g^0000001��1�ɑ΂���";
		mes "�J�[�h���璊�o�����l�X�Ȍ��ʂ�";
		mes "�t�^���邱�Ƃ��ł��܂��B";
		next;
		mes "[�~�[��]";
		mes "^4040FF�V���h�[�G���`�����g^000000�͔���";
		mes "���肵�Ă���A�K���������܂��B";
		mes "���������ł�����A�ޗ������ʂ�";
		mes "�Ȃ邱�Ƃ͐�΂ɂ���܂���B";
		next;
		mes "[�~�[��]";
		mes "�܂�^4040FF�V���h�[�G���`�����g^000000�̌��ʂ�";
		mes "���������邱�Ƃ��ł��܂��B";
		mes "���̍ہA�ʏ�X���b�g�ɕt���Ă���";
		mes "�J�[�h�̌��ʂƐ��B�l�ɂ��Ă�";
		mes "���������܂���̂ł����S���������B";
		next;
		mes "[�~�[��]";
		mes "�������ł̓G���`�����g�̍ۂ�";
		mes "�ޗ��Ƃ��Ďg�p�����J�[�h��";
		mes "�������邱�Ƃ��ł��܂��B";
		mes "�������t�^�ς݂̌���1�ɂ�";
		mes "^FF4040" + printzeny(.ini_fee) + "Zeny^000000���K�v�ł��B";
		next;
	} else if (.@men) {
		set .@wep, getequipid2(4);
		if (!.@wep) {
			mes "[�~�[��]";
			mes "�E��ɕ���𑕔����Ă��������B";
			close;
		}
		set .@slos, 4 - getitemslots(.@wep);
		for (set .@i, 0; .@i < 4; ++.@i)
			set .@cars[.@i], getequipcardid2(4, .@i);
		if (!.@slos ||
			.@cars[0] == CARD0_FORGE
		) {
			mes "[�~�[��]";
			mes "���̕���ɃG���`�����g�ł���";
			mes "^4040FF�V���h�[�X���b�g^000000�͂���܂���B";
			close;
		}
		if (.@men == 2) {
			for (set .@slo, 0; .@slo < .@slos; ++.@slo) {
				if (!.@cars[3 - .@slo]) break;
			}
			if (.@slo >= .@slos) {
				mes "[�~�[��]";
				mes "���̕����^4040FF�V���h�[�X���b�g^000000��";
				mes "���ׂăG���`�����g�ς݂ł���B";
				close;
			}
			mes "[�~�[��]";
			mes "�ǂ̌��ʂ��G���`�����g���܂����H";
			next;
			set .@effs_siz, getarraysize(.effs) / 2;
			for (set .@i, 0; .@i < .@effs_siz; ++.@i)
				set .@eff_lis$[getarraysize(.@eff_lis$)], getitemname(.effs[2 * .@i + 0]);
			set .@eff_lis$[getarraysize(.@eff_lis$)], "��߂�";
			set .@eff_ind, select(printarray(.@eff_lis$)) - 1;
			if (.@eff_ind < .@effs_siz) {
				set .@eff_nam$, .@eff_lis$[.@eff_ind];
				set .@eff, .effs[2 * .@eff_ind + 0];
				set .@fee, .effs[2 * .@eff_ind + 1];
				set .@ore, .ores[2 * .@eff_ind + 0];
				set .@ore_nam$, getitemname(.@ore);
				set .@ore_amo, .ores[2 * .@eff_ind + 1];
				if (.@eff_ind) set .@eff_car_fir, .eff_car_bous[.@eff_ind - 1];
				set .@eff_cars_siz, .eff_car_bous[.@eff_ind] - .@eff_car_fir;
				for (set .@i, 0; .@i < .@eff_cars_siz; ++.@i) {
					set .@eff_car_bas, 2 * (.@eff_car_fir + .@i);
					set .@eff_cars[.@i], .eff_cars[.@eff_car_bas + 0];
					set .@eff_car_nams$[.@i], getitemname(.@eff_cars[.@i]);
					set .@eff_car_amos[.@i], .eff_cars[.@eff_car_bas + 1];
				}
				mes "[�~�[��]";
				mes "^4040FF" + .@eff_nam$ + "^000000�ł��ˁB";
				mes "���̌��ʂ��G���`�����g����ɂ�";
				mes "�萔���Ƃ���^FF4040" + printzeny(.@fee) + "Zeny^000000��";
				mes "^4040FF" + .@ore_nam$ + "^000000 ^FF4040" + .@ore_amo + "��^000000�ɉ���";
				mes "�ȉ��̃J�[�h���K�v�ɂȂ�܂��B";
				next;
				mes "------ �K�v�ȃJ�[�h ------";
				for (set .@i, 0; .@i < .@eff_cars_siz; ++.@i)
					mes "^4040FF" + .@eff_car_nams$[.@i] + "^000000 ^FF4040" + .@eff_car_amos[.@i] + "��^000000";
				next;
				mes "[�~�[��]";
				mes "�G���`�����g���s���܂����H";
				next;
				if (select("��߂�", "����") == 2) {
					mes "[�~�[��]";
					mes "�ł͂����������|����܂��傤�B";
					mes "���X���҂����������c�c";
					next;
					
					// �A�g�~�b�N
					if (Zeny < .@fee) set .@lac, 1;
					else if (countitem(.@ore) < .@ore_amo) set .@lac, 1;
					else {
						for (set .@i, 0; .@i < .@eff_cars_siz; ++.@i) {
							if (countitem(.@eff_cars[.@i]) < .@eff_car_amos[.@i]) {
								set .@lac, 1;
								break;
							}
						}
					}
					if (.@lac) {
						mes "[�~�[��]";
						mes "���������ޗ�������܂���B";
						close;
					}
					if (getequipid2(4) != .@wep) set .@dif, 1;
					for (set .@i, 0; .@i < 4; ++.@i) {
						if (getequipcardid2(4, .@i) != .@cars[.@i]) {
							set .@dif, 1;
							break;
						}
					}
					if (.@dif) {
						debugmes "�V���h�E�G���`�����g�Ń`�[�g�����m ";
						mes "[�~�[��]";
						mes "���킪�ύX����Ă��܂��B";
						mes "�C�J�T�}�͂����܂���ˁc�c";
						close;
					}
					set .@cars[3 - .@slo], .@eff;
					set .@ref, getequiprefinerycnt2(4);
					set Zeny, Zeny - .@fee;
					delitem .@ore, .@ore_amo;
					for (set .@i, 0; .@i < .@eff_cars_siz; ++.@i)
						delitem .@eff_cars[.@i], .@eff_car_amos[.@i];
					delequip2 4;
					getitem2 .@wep, 1, 1, .@ref, 0, .@cars[0], .@cars[1], .@cars[2], .@cars[3];
					misceffect EF_REPAIRWEAPON;
					mes "[�~�[��]";
					mes "�c�c���҂������܂����B";
					mes "�V����^4040FF" + .@eff_nam$ + "^000000���t�^����";
					mes "�ƂĂ����͂ɂȂ�܂�����B";
					mes "�����A�ǂ������������������B";
					close;
					
				}
			}
		} else {
			for (set .@slo, 0; .@slo < .@slos; ++.@slo) {
				set .@car, .@cars[3 - .@slo];
				if (.@car >= .eff_fir &&
					.@car < .eff_las
				) set .@res_slos[getarraysize(.@res_slos)], .@slo + 1;
			}
			if (!getarraysize(.@res_slos)) {
				mes "[�~�[��]";
				mes "���̕���͏�����Ԃł���B";
				close;
			}
			mes "[�~�[��]";
			mes "�G���`�����g�̍ۂɍޗ��Ƃ���";
			mes "�g�p�����J�[�h�𕜌����܂����H";
			next;
			set .@res, select("��������", "�������Ȃ�") == 1;
			mes "[�~�[��]";
			if (.@res) {
				set .@fee, .ini_fee * getarraysize(.@res_slos);
				mes "�������Ɠ����ɃJ�[�h�𕜌����܂��B";
				mes "�萔����^FF4040" + printzeny(.@fee) + "Zeny^000000�ɂȂ�܂��B";
			} else {
				mes "�������Ɠ����ɃJ�[�h�͂��ׂ�";
				mes "^FF4040����^000000���܂��̂ł����ӂ��������B";
			}
			mes "�{���ɏ��������܂����H";
			next;
			if (select("��߂�", "����") == 2) {
				
				// �A�g�~�b�N
				if (Zeny < .@fee) {
					mes "[�~�[��]";
					mes "������������܂���B";
					close;
				}
				if (getequipid2(4) != .@wep) set .@dif, 1;
				for (set .@i, 0; .@i < 4; ++.@i) {
					if (getequipcardid2(4, .@i) != .@cars[.@i]) {
						set .@dif, 1;
						break;
					}
				}
				if (.@dif) {
					debugmes "�V���h�E�G���`�����g�̏������Ń`�[�g�����m ";
					mes "[�~�[��]";
					mes "���킪�ύX����Ă��܂��B";
					mes "�C�J�T�}�͂����܂���ˁc�c";
					close;
				}
				set .@ref, getequiprefinerycnt2(4);
				set Zeny, Zeny - .@fee;
				for (set .@i, 0; .@i < getarraysize(.@res_slos); ++.@i) {
					set .@slo, 4 - .@res_slos[.@i];
					if (.@res) {
						set .@eff, .@cars[.@slo];
						set .@effs_siz, getarraysize(.effs) / 2;
						for (set .@eff_ind, 0; .@eff_ind < .@effs_siz; ++.@eff_ind) {
							if (.effs[2 * .@eff_ind + 0] == .@eff) {
								set .@eff_car_fir, 0;
								if (.@eff_ind) set .@eff_car_fir, .eff_car_bous[.@eff_ind - 1];
								set .@eff_cars_siz, .eff_car_bous[.@eff_ind] - .@eff_car_fir;
								for (set .@j, 0; .@j < .@eff_cars_siz; ++.@j) {
									set .@eff_car_bas, 2 * (.@eff_car_fir + .@j);
									set .@eff_car, .eff_cars[.@eff_car_bas + 0];
									set .@eff_car_amo, .eff_cars[.@eff_car_bas + 1];
									getitem .@eff_car, .@eff_car_amo;
								}
								break;
							}
						}
					}
					set .@cars[.@slo], 0;
				}
				delequip2 4;
				getitem2 .@wep, 1, 1, .@ref, 0, .@cars[0], .@cars[1], .@cars[2], .@cars[3];
				misceffect EF_REPAIRWEAPON;
				mes "[�~�[��]";
				mes "^4040FF�V���h�[�X���b�g^000000�ɕt�^����Ă���";
				mes "���ׂĂ̌��ʂ������܂����B";
				close;
				
			}
		}
	}
	mes "[�~�[��]";
	mes "�`���҂ɂ͗ǂ����킪�K�v�ł��B";
	mes "���ɂ��Ȃ��̂悤�ȕ��ɂ͂ˁB";
	close;
OnInit:
	set .eff_fir, 29600;
	set .eff_las, 29900;
	setarray .effs[getarraysize(.effs)], 29600,5000000; // Atk + 15
	setarray .ores[getarraysize(.ores)], 6240,5; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4043,2, // �A���h���J�[�h
		4337,2, // �|���Z���I�J�[�h
		4410,2, // �G�L�I�J�[�h
		4453,2, // �q���X���I���J�[�h
		4508,2; // �b��X�J���o�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29601,5000000; // �K�� + 25%
	setarray .ores[getarraysize(.ores)], 6240,5; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4106,2, // �}�~�[�J�[�h
		4225,2, // �t���C���V���[�^�[�J�[�h
		4248,2, // �G���V�F���g�}�~�[�J�[�h
		4312,2, // �I�b�g�[�J�[�h
		4428,2; // �{�E�K�[�f�B�A���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29602,5000000; // Def25%����
	setarray .ores[getarraysize(.ores)], 6240,5; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4061,2, // �J�i�g�E�X�J�[�h
		4220,2, // �\���b�h�^�[�g���J�[�h
		4226,2, // �X�e�B���O�J�[�h
		4339,2, // �~�l�����J�[�h
		4417,2; // �A�C�X�^�C�^���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29603,5000000; // Mdef5%����
	setarray .ores[getarraysize(.ores)], 6240,5; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4240,2, // �A�N���E�X�J�[�h
		4278,2, // �W�r�b�g�J�[�h
		4290,2, // �L���b�g�i�C���e�C���J�[�h
		4405,2, // �v���X�J�[�h
		4414,2; // �V�[�J�[�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29604,1000000; // ���` + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4156,2, // �S�u�������C�_�[�J�[�h
		4239,2, // �A�C�A���t�B�X�g�J�[�h
		4308,2, // �O�t峃J�[�h
		4434,2, // �m�b�J�[�J�[�h
		4475,2; // �R�o���g�~�l�����J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29605,1000000; // �s���` + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4157,2, // �S�u�����A�[�`���[�J�[�h
		4190,2, // ���C�X�J�[�h
		4274,2, // �]���r�}�X�^�[�J�[�h
		4275,2, // �]���r�v���Y�i�[�J�[�h
		4473,2; // �G���V�F���g�c���[�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29606,1000000; // �����` + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4188,2, // ���C�u�I���}�C�J�[�h
		4224,2, // �X�e�����[���J�[�h
		4297,2, // �N���[�U�[�J�[�h
		4355,2, // �O���������J�[�h
		4472,2; // �u���f�B�E���S�[�����J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29607,1000000; // �A���` + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4151,2, // �K�W���}�[�g�J�[�h
		4177,2, // �h���A�[�h�J�[�h
		4289,2, // �L���^�s���[�J�[�h
		4292,2, // �R�{���h�A�[�`���[�J�[�h
		4470,2; // �l�y���e�X�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29608,1000000; // �����` + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4149,2, // �K�[�S�C���J�[�h
		4152,2, // �K���p�S�J�[�h
		4165,2, // �M�O�J�[�h
		4214,2, // �u���b�f�B�}�[�_�[�J�[�h
		4476,2; // �s���M�L�����J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29609,1000000; // ���L�` + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4192,2, // ���[�^�[�W���C���J�[�h
		4195,2, // ���[�t�L���b�g�J�[�h
		4326,2, // �V�[�I�b�^�[�J�[�h
		4422,2, // ���E�B�[���J�[�h
		4469,2; // �i�[�K�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29610,1000000; // �����` + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4124,2, // ���f���[�T�J�[�h
		4182,2, // �f�B�A�{���b�N�J�[�h
		4249,2, // �G���V�F���g���[���J�[�h
		4310,2, // �p���c�@�[�S�u�����J�[�h
		4406,2; // �X�P�S���g�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29611,1000000; // �l�Ԍ` + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4245,2, // �A�����g�J�[�h
		4246,2, // �A�T���g�^�[�g���J�[�h
		4329,2, // �t�F���_�[�N�J�[�h
		4360,2, // �G�����X=�K�C���J�[�h
		4474,2; // �U�N�_���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29612,1000000; // �V�g�` + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4241,2, // �A�[�N�G���W�F�����O�J�[�h
		4265,2, // �Րl�J�[�h
		4316,2, // �t�F�C�N�G���W�F���J�[�h
		4391,2, // ���s����҃J�[�h
		4398,2; // �^�i�g�X�̋�Y�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29613,1000000; // ���` + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4176,2, // �f�����n���J�[�h
		4180,2, // �h�����[�J�[�h
		4267,2, // �G�N�X�v���[�W�����J�[�h
		4385,2, // �h���S���̗��J�[�h
		4471,2; // �h���R�̗��J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29614,1000000; // ������ + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4089,2, // �\�[�h�t�B�b�V���J�[�h
		4095,2, // �}���X�J�[�h
		4105,2, // �}���N�J�[�h
		4423,2, // �K���I���J�[�h
		4443,2; // �A�N�A�G�������^���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29615,1000000; // �n���� + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4087,2, // �K�C�A�X�J�[�h
		4081,2, // �z�[�h�J�[�h
		4101,2, // �T���h�}���J�[�h
		4432,2, // �}�O�}�����J�[�h
		4444,2; // �h���R�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29616,1000000; // �Α��� + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4099,2, // �p�T�i�J�[�h
		4109,2, // �W���b�N�J�[�h
		4203,2, // �~���[�^���g�h���S���J�[�h
		4380,2, // ���b�h�y���X�J�[�h
		4431,2; // �J�[�T�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29617,1000000; // ������ + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4042,2, // �X�`�[���`�����`�����J�[�h
		4056,2, // �_�X�e�B�l�X�J�[�h
		4098,2, // �h�P�r�J�[�h
		4178,2, // �h���S���e�C���J�[�h
		4445,2; // ���V�I�����F�X�p�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29618,1000000; // �ő��� + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4108,2, // �~�X�g�J�[�h
		4114,2, // �A���M�I�y�J�[�h
		4333,2, // �x�m�}�X�J�[�h
		4447,2, // �Z���`�s�[�h�J�[�h
		4468,2; // �_�[�N�s���M�L�����J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29619,1000000; // ������ + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4311,2, // �p�[���b�g�^�[�g���J�[�h
		4319,2, // �t���[�Y�^�[�g���J�[�h
		4331,2, // �q�[�g�^�[�g���J�[�h
		4371,2, // �A�[�N�_���J�[�h
		4448,2; // �R���k�X�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29620,1000000; // �ő��� + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4116,2, // �C�V�X�J�[�h
		4119,2, // �o�[�X���[�J�[�h
		4169,2, // �_�[�N�C�����[�W�����J�[�h
		4170,2, // �_�[�N�t���[���J�[�h
		4449,2; // �_�[�N�V���h�[�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29621,1000000; // �O���� + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4113,2, // �}���I�l�b�g�J�[�h
		4127,2, // �i�C�g���A�J�[�h
		4295,2, // �N���x���J�[�h
		4334,2, // �m�N�V���X�J�[�h
		4439,2; // �t���[���X�J���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29622,1000000; // �s������ + 20%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4071,2, // �I�[�N�]���r�J�[�h
		4141,2, // �C�r���h���C�h�J�[�h
		4189,2, // �f�b�h���[���C�X�J�[�h
		4221,2, // �W�F�l�����X�P���g���J�[�h
		4328,2; // �q�F�O���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29623,3000000; // ���^ + 15%
	setarray .ores[getarraysize(.ores)], 6240,3; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4204,2, // �~�j�f���J�[�h
		4298,2, // �N���[�~�[�t�B�A�[�J�[�h
		4452,2, // �Z���`�s�[�h�c���J�[�h
		4467,2, // �w�r�B���^�����J�[�h
		4511,2; // ���g���t�@�[�g�D���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29624,3000000; // ���^ + 15%
	setarray .ores[getarraysize(.ores)], 6240,3; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4301,2, // �L���[�}���e�B�X�J�[�h
		4426,2, // �r�����O�J�[�h
		4450,2, // �o���V�[�}�X�^�[�J�[�h
		4465,2, // �t�@�i�g�J�[�h
		4466,2; // �r�z���_�[�}�X�^�[�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29625,3000000; // ��^ + 15%
	setarray .ores[getarraysize(.ores)], 6240,3; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4164,2, // �O�����u���X�e�B�J�[�h
		4270,2, // �W���C�A���g�X�p�C�_�[�J�[�h
		4271,2, // �W���C�A���g�z�[�l�b�g�J�[�h
		4303,2, // ����E�B�X�p�[�J�[�h
		4477,2; // �w���A�|�J���v�X�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29626,4000000; // �{�X + 10%
	setarray .ores[getarraysize(.ores)], 6240,4; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4163,2, // �O���t�H���J�[�h
		4171,2, // �_�[�N�v���[�X�g�J�[�h
		4198,2, // �}���p�[�v���J�[�h
		4300,2, // �L�����J�[�h
		4384,2; // �n�C�h�������T�[�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29627,5000000; // �ߐ�Atk + 25
	setarray .ores[getarraysize(.ores)], 6240,5; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4043,2, // �A���h���J�[�h
		4337,2, // �|���Z���I�J�[�h
		4410,2, // �G�L�I�J�[�h
		4453,2, // �q���X���I���J�[�h
		4508,2; // �b��X�J���o�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29628,5000000; // �ߐڕK�� + 50%
	setarray .ores[getarraysize(.ores)], 6240,5; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4106,2, // �}�~�[�J�[�h
		4225,2, // �t���C���V���[�^�[�J�[�h
		4248,2, // �G���V�F���g�}�~�[�J�[�h
		4312,2, // �I�b�g�[�J�[�h
		4428,2; // �{�E�K�[�f�B�A���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29629,5000000; // �ߐ�Def50%����
	setarray .ores[getarraysize(.ores)], 6240,5; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4061,2, // �J�i�g�E�X�J�[�h
		4220,2, // �\���b�h�^�[�g���J�[�h
		4226,2, // �X�e�B���O�J�[�h
		4339,2, // �~�l�����J�[�h
		4417,2; // �A�C�X�^�C�^���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29630,1000000; // �ߐږ��` + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4156,2, // �S�u�������C�_�[�J�[�h
		4239,2, // �A�C�A���t�B�X�g�J�[�h
		4308,2, // �O�t峃J�[�h
		4434,2, // �m�b�J�[�J�[�h
		4475,2; // �R�o���g�~�l�����J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29631,1000000; // �ߐڕs���` + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4157,2, // �S�u�����A�[�`���[�J�[�h
		4190,2, // ���C�X�J�[�h
		4274,2, // �]���r�}�X�^�[�J�[�h
		4275,2, // �]���r�v���Y�i�[�J�[�h
		4473,2; // �G���V�F���g�c���[�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29632,1000000; // �ߐړ����` + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4188,2, // ���C�u�I���}�C�J�[�h
		4224,2, // �X�e�����[���J�[�h
		4297,2, // �N���[�U�[�J�[�h
		4355,2, // �O���������J�[�h
		4472,2; // �u���f�B�E���S�[�����J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29633,1000000; // �ߐڐA���` + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4151,2, // �K�W���}�[�g�J�[�h
		4177,2, // �h���A�[�h�J�[�h
		4289,2, // �L���^�s���[�J�[�h
		4292,2, // �R�{���h�A�[�`���[�J�[�h
		4470,2; // �l�y���e�X�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29634,1000000; // �ߐڍ����` + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4149,2, // �K�[�S�C���J�[�h
		4152,2, // �K���p�S�J�[�h
		4165,2, // �M�O�J�[�h
		4214,2, // �u���b�f�B�}�[�_�[�J�[�h
		4476,2; // �s���M�L�����J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29635,1000000; // �ߐڋ��L�` + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4192,2, // ���[�^�[�W���C���J�[�h
		4195,2, // ���[�t�L���b�g�J�[�h
		4326,2, // �V�[�I�b�^�[�J�[�h
		4422,2, // ���E�B�[���J�[�h
		4469,2; // �i�[�K�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29636,1000000; // �ߐڈ����` + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4124,2, // ���f���[�T�J�[�h
		4182,2, // �f�B�A�{���b�N�J�[�h
		4249,2, // �G���V�F���g���[���J�[�h
		4310,2, // �p���c�@�[�S�u�����J�[�h
		4406,2; // �X�P�S���g�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29637,1000000; // �ߐڐl�Ԍ` + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4245,2, // �A�����g�J�[�h
		4246,2, // �A�T���g�^�[�g���J�[�h
		4329,2, // �t�F���_�[�N�J�[�h
		4360,2, // �G�����X=�K�C���J�[�h
		4474,2; // �U�N�_���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29638,1000000; // �ߐړV�g�` + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4241,2, // �A�[�N�G���W�F�����O�J�[�h
		4265,2, // �Րl�J�[�h
		4316,2, // �t�F�C�N�G���W�F���J�[�h
		4391,2, // ���s����҃J�[�h
		4398,2; // �^�i�g�X�̋�Y�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29639,1000000; // �ߐڗ��` + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4176,2, // �f�����n���J�[�h
		4180,2, // �h�����[�J�[�h
		4267,2, // �G�N�X�v���[�W�����J�[�h
		4385,2, // �h���S���̗��J�[�h
		4471,2; // �h���R�̗��J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29640,1000000; // �ߐڐ����� + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4089,2, // �\�[�h�t�B�b�V���J�[�h
		4095,2, // �}���X�J�[�h
		4105,2, // �}���N�J�[�h
		4423,2, // �K���I���J�[�h
		4443,2; // �A�N�A�G�������^���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29641,1000000; // �ߐڒn���� + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4087,2, // �K�C�A�X�J�[�h
		4081,2, // �z�[�h�J�[�h
		4101,2, // �T���h�}���J�[�h
		4432,2, // �}�O�}�����J�[�h
		4444,2; // �h���R�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29642,1000000; // �ߐډΑ��� + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4099,2, // �p�T�i�J�[�h
		4109,2, // �W���b�N�J�[�h
		4203,2, // �~���[�^���g�h���S���J�[�h
		4380,2, // ���b�h�y���X�J�[�h
		4431,2; // �J�[�T�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29643,1000000; // �ߐڕ����� + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4042,2, // �X�`�[���`�����`�����J�[�h
		4056,2, // �_�X�e�B�l�X�J�[�h
		4098,2, // �h�P�r�J�[�h
		4178,2, // �h���S���e�C���J�[�h
		4445,2; // ���V�I�����F�X�p�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29644,1000000; // �ߐړő��� + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4108,2, // �~�X�g�J�[�h
		4114,2, // �A���M�I�y�J�[�h
		4333,2, // �x�m�}�X�J�[�h
		4447,2, // �Z���`�s�[�h�J�[�h
		4468,2; // �_�[�N�s���M�L�����J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29645,1000000; // �ߐڐ����� + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4311,2, // �p�[���b�g�^�[�g���J�[�h
		4319,2, // �t���[�Y�^�[�g���J�[�h
		4331,2, // �q�[�g�^�[�g���J�[�h
		4371,2, // �A�[�N�_���J�[�h
		4448,2; // �R���k�X�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29646,1000000; // �ߐڈő��� + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4116,2, // �C�V�X�J�[�h
		4119,2, // �o�[�X���[�J�[�h
		4169,2, // �_�[�N�C�����[�W�����J�[�h
		4170,2, // �_�[�N�t���[���J�[�h
		4449,2; // �_�[�N�V���h�[�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29647,1000000; // �ߐڔO���� + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4113,2, // �}���I�l�b�g�J�[�h
		4127,2, // �i�C�g���A�J�[�h
		4295,2, // �N���x���J�[�h
		4334,2, // �m�N�V���X�J�[�h
		4439,2; // �t���[���X�J���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29648,1000000; // �ߐڕs������ + 25%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4071,2, // �I�[�N�]���r�J�[�h
		4141,2, // �C�r���h���C�h�J�[�h
		4189,2, // �f�b�h���[���C�X�J�[�h
		4221,2, // �W�F�l�����X�P���g���J�[�h
		4328,2; // �q�F�O���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29649,3000000; // �ߐڏ��^ + 20%
	setarray .ores[getarraysize(.ores)], 6240,3; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4204,2, // �~�j�f���J�[�h
		4298,2, // �N���[�~�[�t�B�A�[�J�[�h
		4452,2, // �Z���`�s�[�h�c���J�[�h
		4467,2, // �w�r�B���^�����J�[�h
		4511,2; // ���g���t�@�[�g�D���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29650,3000000; // �ߐڒ��^ + 20%
	setarray .ores[getarraysize(.ores)], 6240,3; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4301,2, // �L���[�}���e�B�X�J�[�h
		4426,2, // �r�����O�J�[�h
		4450,2, // �o���V�[�}�X�^�[�J�[�h
		4465,2, // �t�@�i�g�J�[�h
		4466,2; // �r�z���_�[�}�X�^�[�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29651,3000000; // �ߐڑ�^ + 20%
	setarray .ores[getarraysize(.ores)], 6240,3; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4164,2, // �O�����u���X�e�B�J�[�h
		4270,2, // �W���C�A���g�X�p�C�_�[�J�[�h
		4271,2, // �W���C�A���g�z�[�l�b�g�J�[�h
		4303,2, // ����E�B�X�p�[�J�[�h
		4477,2; // �w���A�|�J���v�X�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29652,4000000; // �ߐڃ{�X + 15%
	setarray .ores[getarraysize(.ores)], 6240,4; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4163,2, // �O���t�H���J�[�h
		4171,2, // �_�[�N�v���[�X�g�J�[�h
		4198,2, // �}���p�[�v���J�[�h
		4300,2, // �L�����J�[�h
		4384,2; // �n�C�h�������T�[�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29653,1000000; // �����@ + 100%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4185,2, // ���C�h���[�h�J�[�h
		4219,2, // �Z�[�W���[���J�[�h
		4251,2, // �G���_�[�J�[�h
		4262,2, // �V�א�l�J�[�h
		4387,2; // �G���V�F���g�~�~�b�N
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29654,3000000; // �����@ + 5%
	setarray .ores[getarraysize(.ores)], 6240,3; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4208,2, // ��l�`�J�[�h
		4323,2, // �n�e�B�[�x�x�J�[�h
		4354,2, // �W�F�~�j-S58�J�[�h
		4416,2, // �V���}�J�[�h
		4418,2; // �Q�C�Y�e�B�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29655,2000000; // �n���@ + 10%
	setarray .ores[getarraysize(.ores)], 6240,2; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4259,2, // �E�h�D���S�[�����J�[�h
		4280,2, // �W�I�O���t�@�[�J�[�h
		4282,2, // ��V��J�[�h
		4335,2, // �s�b�g�}���J�[�h
		4347,2; // �A���}�C�A=�f�����[
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29656,3000000; // �Ζ��@ + 5%
	setarray .ores[getarraysize(.ores)], 6240,3; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4320,2, // �u���b�f�B�i�C�g�J�[�h
		4327,2, // �p�s�����J�[�h
		4346,2, // �C�O�j�[��=�Z�j�A�J�[�h
		4429,2, // �T���}���_�[�J�[�h
		4433,2; // �C���v�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29657,3000000; // �����@ + 5%
	setarray .ores[getarraysize(.ores)], 6240,3; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4237,2, // �I�E���f���[�N�J�[�h
		4238,2, // �I�E���o�����J�[�h
		4264,2, // �E�B���h�S�[�X�g�J�[�h
		4345,2, // �q���E�B���h�J�[�h
		4351,2; // �J���@�N=�C�J���X
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29658,2000000; // �O���@ + 10%
	setarray .ores[getarraysize(.ores)], 6240,2; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4070,2, // �G�M���J�[�h
		4325,2, // �n�[�s�[�J�[�h
		4350,2, // ���E����=���B���_�[�J�[�h
		4388,2, // �f�X���[�h
		4438,2; // �o���V�[�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29659,4000000; // �G�X�} + 5%
	setarray .ores[getarraysize(.ores)], 6240,4; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4358,2, // �Z�C����=�E�B���U�[
		4362,2, // �n���[�h=�A���g�A�C�[��
		4364,2, // �}�[�K���b�^=�\����
		4366,2, // �J�g���[�k=�P�C�����J�[�h
		4368,2; // �Z�V��=�f�B����
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29660,1000000; // ���E�@ + 15%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4208,2, // ��l�`�J�[�h
		4323,2, // �n�e�B�[�x�x�J�[�h
		4354,2, // �W�F�~�j-S58�J�[�h
		4416,2, // �V���}�J�[�h
		4418,2; // �Q�C�Y�e�B�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29661,1000000; // �ΔE�@ + 15%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4320,2, // �u���b�f�B�i�C�g�J�[�h
		4327,2, // �p�s�����J�[�h
		4346,2, // �C�O�j�[��=�Z�j�A�J�[�h
		4429,2, // �T���}���_�[�J�[�h
		4433,2; // �C���v�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29662,1000000; // ���E�@ + 15%
	setarray .ores[getarraysize(.ores)], 6240,1; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4237,2, // �I�E���f���[�N�J�[�h
		4238,2, // �I�E���o�����J�[�h
		4264,2, // �E�B���h�S�[�X�g�J�[�h
		4345,2, // �q���E�B���h�J�[�h
		4351,2; // �J���@�N=�C�J���X
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29663,5000000; // �q�[�� + 5%
	setarray .ores[getarraysize(.ores)], 6240,5; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4191,2, // ���������J�[�h
		4217,2, // �l�ʓ����J�[�h
		4420,2, // �}�X�L�v���[�J�[�h
		4460,2, // �����R�J�[�h
		4512,2; // �p���X�J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29664,5000000; // Aspd + 0.5
	setarray .ores[getarraysize(.ores)], 6240,5; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4172,2, // �ꔽ�ؖȃJ�[�h
		4210,2, // �f�r���҃J�[�h
		4230,2, // �J�u�L�E�҃J�[�h
		4257,2, // ���C���h���[�Y�J�[�h
		4272,2; // �������J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29665,5000000; // �ߐ�Aspd + 1
	setarray .ores[getarraysize(.ores)], 6240,5; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4172,2, // �ꔽ�ؖȃJ�[�h
		4210,2, // �f�r���҃J�[�h
		4230,2, // �J�u�L�E�҃J�[�h
		4257,2, // ���C���h���[�Y�J�[�h
		4272,2; // �������J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	setarray .effs[getarraysize(.effs)], 29666,5000000; // Cri + 6
	setarray .ores[getarraysize(.ores)], 6240,5; // ���ǌ^�Z�k�I���f�I�R��
	setarray .eff_cars[getarraysize(.eff_cars)],
		4086,10; // �\���W���[�X�P���g���J�[�h
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .ini_fee, 1000000;
}
