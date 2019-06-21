prontera,152,192,5	script	リセット職員	860,{
	setarray .@cou_str$, "初回", "二回目", "三回目以降";
	setarray .@fee, 1000000, 2000000, 3000000;
	if (RESET_FEE_RATE) {
		for (set .@i, 0; .@i < getarraysize(.@fee); ++.@i)
			set .@fee[.@i], .@fee[.@i] * RESET_FEE_RATE;
	}
	
	cutin "kafra_08",2;
	mes "[リゼッタ]";
	mes "いらっしゃいませ。";
	mes "こちらではスキルとステータスの";
	mes "リセットを行えます。";
	next;
	mes "[リゼッタ]";
	mes "リセット料金は";
	mes .@cou_str$[0] + "なら^4040FF" + .@fee[0] + "Zeny^000000、";
	mes .@cou_str$[1] + "なら^4040FF" + .@fee[1] + "Zeny^000000、";
	mes .@cou_str$[2] + "なら^4040FF" + .@fee[2] + "Zeny^000000です。";
	next;
	mes "[リゼッタ]";
	mes "お客様は今回が" + .@cou_str$[RESET_COUNT] + "ですので";
	mes "^4040FF" + .@fee[RESET_COUNT] + "Zeny^000000になります。";
	mes "リセットなさいますか？";
	next;
	if (select("お願いします", "必要ないです") == 1) {
		if (Zeny < .@fee[RESET_COUNT]) {
			mes "[カプラ職員]";
			mes "お客様、お金が足りません。";
			mes "所持金をお確かめください。";
		}
		else {
			set Zeny, Zeny - .@fee[RESET_COUNT];
			resetskill;
			resetstatus;
			specialeffect2 EF_DISPELL;
			soundeffect "_heal_effect.wav", 0;
			if (RESET_COUNT < 3 - 1) set RESET_COUNT, RESET_COUNT + 1;
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
