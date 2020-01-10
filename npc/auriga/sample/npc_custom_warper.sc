prontera,159,192,4	script	ポタガール	721,{
	cutin "kafra_07",2;
	mes "[キャリー]";
	mes "ハイハーイ、次の方ドゾー。";
	mes "どちらまでですかー？";
	mes "一度行ったことのあるマップなら";
	mes "どこでもオッケーですよー？";
	next;
	set .@nat_typs_siz, getarraysize(.nat_typs$);
	set .@nat_typ_lis$[0], "^4040FF最近の履歴^000000";
	for (set .@i, 1; .@i < .@nat_typs_siz; ++.@i)
		set .@nat_typ_lis$[getarraysize(.@nat_typ_lis$)], "^4040FF" + .nat_typs$[.@i] + "^000000";
	set .@nat_typ_lis$[getarraysize(.@nat_typ_lis$)], "やめまーす";
	set .@nat_typ, select(printarray(.@nat_typ_lis$)) - 1;
	if (!.@nat_typ) {
		for (set .@i, 0; .@i < .his_siz; ++.@i)
			set .@map_lis$[getarraysize(.@map_lis$)], WARPER_HIS_ENAMS$[.@i];
		set .@maps_siz, getarraysize(.@map_lis$);
		set .@map_lis$[getarraysize(.@map_lis$)], "やめまーす";
		set .@map_ind, select(printarray(.@map_lis$)) - 1;
		if (.@map_ind < .@maps_siz)
			callsub
				Pay,
				WARPER_HIS_ENAMS$[.@map_ind],
				WARPER_HIS_XS[.@map_ind],
				WARPER_HIS_YS[.@map_ind],
				getmapnamejapanese(WARPER_HIS_ENAMS$[.@map_ind]);
	} else if (.@nat_typ < .@nat_typs_siz) {
		set .@map_typs_siz, getarraysize(.map_typs$);
		for (set .@i, 1; .@i < .@map_typs_siz; ++.@i)
			set .@map_typ_lis$[getarraysize(.@map_typ_lis$)], "^4040FF" + .map_typs$[.@i] + "^000000";
		set .@map_typ_lis$[getarraysize(.@map_typ_lis$)], "やめまーす";
		set .@map_typ, select(printarray(.@map_typ_lis$));
		if (.@map_typ < .@map_typs_siz) {
			set .@maps_siz, queryjournalinfos(.@nat_typ, .@map_typ, .@ids, .@xs, .@ys, .@enams$, .@jnams$);
			if (!.@maps_siz) {
				mes "[キャリー]";
				mes "そちら方面は転送可能なマップが";
				mes "まだひとつもないみたいですねー。";
				next;
				mes "[キャリー]";
				mes "一度マップに足を運んでいただいて";
				mes "ジャーナルを取得していただければ";
				mes "転送できるようになりますよー。";
				next;
			} else {
				for (set .@i, 0; .@i < .@maps_siz; ++.@i)
					set .@map_lis$[getarraysize(.@map_lis$)], .@enams$[.@i];
				set .@map_lis$[getarraysize(.@map_lis$)], "やめまーす";
				set .@map_ind, select(printarray(.@map_lis$)) - 1;
				if (.@map_ind < .@maps_siz)
					callsub
						Pay,
						.@enams$[.@map_ind],
						.@xs[.@map_ind],
						.@ys[.@map_ind],
						.@jnams$[.@map_ind];
			}
		}
	}
	mes "[キャリー]";
	mes "またどうぞー。";
	close2;
	cutin "",255;
	end;
Pay:
	set .@enam$, getarg(0);
	set .@x, getarg(1);
	set .@y, getarg(2);
	set .@jnam$, getarg(3);
	mes "[キャリー]";
	mes "ご注文の転送先は";
	mes "^4040FF" + .@jnam$ + " (" + .@enam$ + ")^000000";
	mes "でよろしいですねー？";
	mes "かしこまりましたー。";
	mes "お会計^4040FF" + printzeny(.fee) + "Zeny^000000になりまーす。";
	next;
	if (select("払いまーす", "やめまーす") == 1) {
		if (Zeny < .fee) {
			mes "[キャリー]";
			mes "お客さまー、大変失礼ですが";
			mes "所持金が足りてませーん。";
			next;
		} else {
			emotion ET_WRAP;
			mes "[キャリー]";
			mes "ちょうだいいたしまーす。";
			mes "それでは転送しますよー。";
			mes "いってらっしゃいませー。";
			close2;
			cutin "",255;
			if (Zeny >= .fee) {
				set Zeny, Zeny - .fee;
				for (set .@i, 0; .@i < .his_siz - 1; ++.@i) {
					if (WARPER_HIS_ENAMS$[.@i] == "" ||
						WARPER_HIS_ENAMS$[.@i] == .@enam$
					) break;
				}
				for (; .@i; --.@i) {
					set .@j, .@i - 1;
					set WARPER_HIS_ENAMS$[.@i], WARPER_HIS_ENAMS$[.@j];
					set WARPER_HIS_XS[.@i], WARPER_HIS_XS[.@j];
					set WARPER_HIS_YS[.@i], WARPER_HIS_YS[.@j];
				}
				set WARPER_HIS_ENAMS$[0], .@enam$;
				set WARPER_HIS_XS[0], .@x;
				set WARPER_HIS_YS[0], .@y;
				specialeffect2 EF_TELEPORTATION2;
				warp .@enam$, .@x, .@y;
			}
			end;
		}
	}
	return;
OnInit:
	setarray .nat_typs$, "不明", "ルーンミッドガッツ王国", "シュバルツバルド共和国", "アルナベルツ教国", "その他の国々";
	setarray .map_typs$, "不明", "街", "フィールド", "ダンジョン";
	set .his_siz, 3;
	set .fee, 10000;
}
prontera,161,193,4	script	遺跡荒らし	448,{
	mes "[レイ]";
	mes "俺様は遺跡荒らしのレイだ。";
	mes "ダンジョン潜入も朝飯前さ。";
	mes "よければいくつか案内するぜ？";
	next;
	for (set .@i, 0; .@i < getarraysize(.maps$); ++.@i)
		set .@map_lis$[getarraysize(.@map_lis$)], "^4040FF" + getmapnamejapanese(.maps$[.@i]) + " (" + .maps$[.@i] + ")^000000";
	set .@map_lis$[getarraysize(.@map_lis$)], "やめる";
	set .@map_ind, select(printarray(.@map_lis$)) - 1;
	if (.@map_ind < getarraysize(.maps$)) {
		set .@x, .xy_fees[.@map_ind * 3 + 0];
		set .@y, .xy_fees[.@map_ind * 3 + 1];
		set .@fee, .xy_fees[.@map_ind * 3 + 2];
		mes "[レイ]";
		mes "^4040FF" + getmapnamejapanese(.maps$[.@map_ind]) + "^000000か……";
		mes "そこなら^4040FF" + printzeny(.@fee) + "^000000Zenyは";
		mes "もらわないと割に合わねーな。";
		next;
		if (select("頼む", "やめる") == 1) {
			if (Zeny < .@fee) {
				mes "[レイ]";
				mes "おっと金が足りてないぜ。";
				mes "また今度来てくれよな。";
				close;
			}
			emotion ET_DELIGHT;
			mes "[レイ]";
			mes "よーし、引き受けたぜ。";
			mes "さっそく出発するぞ。";
			mes "俺様のあとについてきな。";
			close2;
			if (Zeny >= .@fee) {
				set Zeny, Zeny - .@fee;
				specialeffect2 EF_TELEPORTATION2;
				warp .maps$[.@map_ind], .@x, .@y;
			}
			end;
		}
	}
	mes "[レイ]";
	mes "いつでも来なよ。";
	close;
OnInit:
	setarray .maps$[getarraysize(.maps$)], "abbey01";
	setarray .xy_fees[getarraysize(.xy_fees)], 51,15, 5000000;
	setarray .maps$[getarraysize(.maps$)], "ama_dun01";
	setarray .xy_fees[getarraysize(.xy_fees)], 229,10, 500000;
	setarray .maps$[getarraysize(.maps$)], "bra_dun01";
	setarray .xy_fees[getarraysize(.xy_fees)], 87,47, 1000000;
	setarray .maps$[getarraysize(.maps$)], "gefenia01";
	setarray .xy_fees[getarraysize(.xy_fees)], 58,169, 5000000;
	setarray .maps$[getarraysize(.maps$)], "kh_dun02";
	setarray .xy_fees[getarraysize(.xy_fees)], 41,198, 5000000;
	setarray .maps$[getarraysize(.maps$)], "lhz_dun01";
	setarray .xy_fees[getarraysize(.xy_fees)], 149,285, 1000000;
	setarray .maps$[getarraysize(.maps$)], "mosk_dun01";
	setarray .xy_fees[getarraysize(.xy_fees)], 201,269, 2000000;
	setarray .maps$[getarraysize(.maps$)], "ra_san02";
	setarray .xy_fees[getarraysize(.xy_fees)], 213,275, 10000000;
}
