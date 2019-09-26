prontera,152,192,5	script	リセット職員	860,{
	set .@fee, 1000000;
	if (RESET_FEE_RATE) set .@fee, .@fee * RESET_FEE_RATE;
	
	cutin "kafra_08",2;
	mes "[リゼッタ]";
	mes "いらっしゃいませ。";
	mes "こちらではスキルとステータスの";
	mes "リセットを行えます。";
	next;
	mes "[リゼッタ]";
	mes "リセット料金は";
	mes "^4040FF" + .@fee + "Zeny^000000です。";
	mes "リセットなさいますか？";
	next;
	if (select("お願いします", "必要ないです") == 1) {
		if (Zeny < .@fee) {
			mes "[カプラ職員]";
			mes "お客様、お金が足りません。";
			mes "所持金をお確かめください。";
		}
		else {
			set Zeny, Zeny - .@fee;
			sc_end_class;
			resetskill;
			resetstatus;
			specialeffect2 EF_DISPELL;
			soundeffect "_heal_effect.wav", 0;
			mes "[リゼッタ]";
			mes "リセット完了しました。";
			mes "ご利用ありがとうございます。";
		}
	} else {
		mes "[リゼッタ]";
		mes "またのご利用をお待ちしております。";
	}
	close2;
	cutin "",255;
	end;
}
