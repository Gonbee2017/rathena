// �l��Ԃ��Ȃ��֐�
function	script	func001	{
	mes "���[�U�[��`�֐�";
	next;
	return;		// �ȗ��ł��Ȃ�
}

// �l��Ԃ��֐�
function	script	func002	{
	return "���[�U�[��`�֐��Q";
}

// �֐��̌Ăяo���ƃT�u���[�e�B���̃e�X�g
prontera,168,189,1	script	�֐��e�X�g	112,{
	callfunc "func001";		// ���[�U�[��`�֐��͕�����Ŏw��
	mes callfunc("func002");
	next;
	callsub L_SUB001;	// �T�u���[�e�B���̓��x���𒼐ڎw��
	close;
	end;

L_SUB001:
	mes "�T�u���[�e�B��";
	return;		// �ȗ��ł��Ȃ�
}