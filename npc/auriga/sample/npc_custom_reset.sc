prontera,152,192,5	script	リセット職員	860,{
	set .@siz, getarraysize(.fees);
	copyarray .@fees, .fees, .@siz;
	if (RESET_FEE_RATE) {
		for (set .@i, 0; .@i < .@siz; ++.@i)
			set .@fees[.@i], .@fees[.@i] * RESET_FEE_RATE;
	}
	cutin "kafra_08",2;
	mes "[リゼッタ]";
	mes "いらっしゃいませ。";
	mes "こちらではスキルとステータスの";
	mes "リセットを行っております。";
	next;
	mes "[リゼッタ]";
	mes "メニューはこちらです。";
	for (set .@i, 0; .@i < .@siz; ++.@i)
		mes .names$[.@i] + " … ^4040FF" + .@fees[.@i] + "Zeny^000000";
	mes "どれになさいますか？";
	next;
	for (set .@i, 0; .@i < .@siz; ++.@i)
		set .@mens$[getarraysize(.@mens$)], .names$[.@i] + "をリセット";
	set .@mens$[getarraysize(.@mens$)], "必要ないです";
	set .@men, select(printarray(.@mens$)) - 1;
	if (.@men == 3) {
		mes "[リゼッタ]";
		mes "またのご利用をお待ちしております。";
	} else {
		set .@fee, .@fees[.@men];
		if (Zeny < .@fee) {
			mes "[カプラ職員]";
			mes "お客様、お金が足りません。";
			mes "所持金をお確かめください。";
		} else {
			set Zeny, Zeny - .@fee;
			sc_end_class;
			if (.@men == 0 ||
				.@men == 2
			) resetskill;
			if (.@men == 1 ||
				.@men == 2
			) resetstatus;
			specialeffect2 EF_DISPELL;
			soundeffect "_heal_effect.wav", 0;
			mes "[リゼッタ]";
			mes "リセット完了しました。";
			mes "ご利用ありがとうございます。";
		}
	}
	close2;
	cutin "",255;
	end;
OnInit:
	setarray .fees, 1000000, 1000000, 1500000;
	setarray .names$, "スキル", "ステータス", "両方";
}
