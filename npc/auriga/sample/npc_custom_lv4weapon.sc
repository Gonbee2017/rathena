prt_in,85,72,4	script	無口な鍛冶屋::Lv4Weapon	63,{
	mes "[イーサン]";
	mes "…………";
	next;
	if (!LV4_WEAPON_INTRODUCE &&
		countitem(2268)
	) {
		set .@tab_nam$, getitemname(2268);
		if (select("^4040FF" + .@tab_nam$ + "^000000をすすめてみる", "やめる") == 1) {
			mes "[" + strcharinfo(0) + "]";
			mes "あの……よかったら";
			mes "これ差し上げます。";
			next;
			mes "[イーサン]";
			mes "…………！";
			next;
			mes "[イーサン]";
			mes "あんた……";
			next;
			mes "[イーサン]";
			mes "気が利くじゃねえか。";
			next;
			
			// アトミック
			if (countitem(2268)) {
				delitem 2268, 1;
				set LV4_WEAPON_INTRODUCE, 1;
			}
			
		}
	}
	if (LV4_WEAPON_INTRODUCE) {
		mes "[イーサン]";
		mes "何か入り用かい？";
		next;
		for (set .@i, 0; .@i < getarraysize(.weas); ++.@i) {
			set .@wea_nam$, getitemname(.weas[.@i]);
			set .@wea_slos, getitemslots(.weas[.@i]);
			if (.@wea_slos) set .@wea_nam$, .@wea_nam$ + " [" + .@wea_slos + "]";
			set .@wea_lis$[.@i], .@wea_nam$;
		}
		set .@wea_lis$[getarraysize(.@wea_lis$)], "やめる";
		set .@wea_ind, select(printarray(.@wea_lis$)) - 1;
		if (.@wea_ind < getarraysize(.weas)) {
			set .@wea, .weas[.@wea_ind];
			set .@wea_nam$, .@wea_lis$[.@wea_ind];
			set .@ore_fir, 0;
			if (.@wea_ind) set .@ore_fir, .ore_bous[.@wea_ind - 1];
			set .@ores_siz, .ore_bous[.@wea_ind] - .@ore_fir;
			for (set .@i, 0; .@i < .@ores_siz; ++.@i) {
				set .@ore_bas, 2 * (.@ore_fir + .@i);
				set .@ore, .ores[.@ore_bas + 0];
				set .@ore_cou, .ores[.@ore_bas + 1];
				set .@ores[.@i], .@ore;
				set .@ore_nams$[.@i], getitemname(.@ore);
				set .@ore_cous[.@i], .@ore_cou;
			}
			
			// アトミック
			set .@hav_ores, 1;
			for (set .@i, 0; .@i < .@ores_siz; ++.@i) {
				if (countitem(.@ores[.@i]) < .@ore_cous[.@i]) {
					set .@hav_ores, 0;
					break;
				}
			}
			if (.@hav_ores) {
				for (set .@i, 0; .@i < .@ores_siz; ++.@i)
					delitem .@ores[.@i], .@ore_cous[.@i];
				getitem .@wea, 1;
				
				misceffect EF_REFINEOK;
				mes "[イーサン]";
				mes "そぉら、できたぜ。";
				mes "持っていきな。";
				close;
			} else {
				mes "[イーサン]";
				mes "^4040FF" + .@wea_nam$ + "^000000";
				mes "を作るには";
				for (set .@i, 0; .@i < .@ores_siz; ++.@i)
					mes "^FF4040" + .@ore_nams$[.@i] + " " + .@ore_cous[.@i] + "個^000000";
				mes "が必要になるぜ。";
				next;
				mes "[イーサン]";
				mes "どれも簡単には入手できねえ";
				mes "希少な鉱石ばかりだ。";
				mes "ま、がんばんな。";
				close;
			}
		}
		mes "[イーサン]";
		mes "じゃあな。";
		close;
	} else {
		mes "-男は黙って仕事をしている。-";
		mes "-タバコのニオイがする。-";
		close;
	}
OnInit:
	set .weas[getarraysize(.weas)], 1141; // 無形剣
	setarray .ores[getarraysize(.ores)],
		7295, 10; // 黄水晶
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 16024; // カドリール [2]
	setarray .ores[getarraysize(.ores)],
		7291, 30; // めのう
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1526; // スラッシュ
	setarray .ores[getarraysize(.ores)],
		7294, 30; // トルコ石
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 13031; // ソードブレイカー [3]
	setarray .ores[getarraysize(.ores)],
		7297, 30; // 黒雲母
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 13032; // メイルブレイカー [3]
	setarray .ores[getarraysize(.ores)],
		7292, 30; // 白雲母
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1367; // スローター
	setarray .ores[getarraysize(.ores)],
		7296, 30; // 輝石
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1134; // シザーズソード
	setarray .ores[getarraysize(.ores)],
		7290, 30; // 金雲母
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1365; // サバス
	setarray .ores[getarraysize(.ores)],
		7293, 10; // 薔薇水晶
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1139; // テイルフィング
	setarray .ores[getarraysize(.ores)],
		7289, 30; // かんらん石
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1364; // グレイトアックス
	setarray .ores[getarraysize(.ores)],
		7289, 10, // かんらん石
		7294, 10, // トルコ石
		7291, 10; // めのう
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1369; // ギロチン
	setarray .ores[getarraysize(.ores)],
		7289, 10, // かんらん石
		7294, 10, // トルコ石
		7291, 10; // めのう
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1469; // ロンギヌスの槍
	setarray .ores[getarraysize(.ores)],
		7290, 10, // 金雲母
		7296, 10, // 輝石
		7293, 10; // 薔薇水晶
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1470; // ブリューナク
	setarray .ores[getarraysize(.ores)],
		7290, 10, // 金雲母
		7296, 10, // 輝石
		7293, 10; // 薔薇水晶
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1132; // エッジ
	setarray .ores[getarraysize(.ores)],
		7294, 10, // トルコ石
		7297, 10, // 黒雲母
		7293, 10; // 薔薇水晶
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1137; // エクスキャリバー
	setarray .ores[getarraysize(.ores)],
		7294, 30, // トルコ石
		7297, 30, // 黒雲母
		7293, 30; // 薔薇水晶
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1180; // ドラゴンスレイヤー [2]
	setarray .ores[getarraysize(.ores)],
		7295, 30, // 黄水晶
		7296, 30, // 輝石
		7290, 30; // 金雲母
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1178; // シュバイチェルサーベル [2]
	setarray .ores[getarraysize(.ores)],
		7295, 30, // 黄水晶
		7296, 30, // 輝石
		7290, 30; // 金雲母
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1816; // ベルセルク [1]
	setarray .ores[getarraysize(.ores)],
		7292, 30, // 白雲母
		7293, 30, // 薔薇水晶
		7289, 30; // かんらん石
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1720; // ルドラの弓
	setarray .ores[getarraysize(.ores)],
		7292, 10, // 白雲母
		7293, 10, // 薔薇水晶
		7289, 10; // かんらん石
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1416; // テュングレティー
	setarray .ores[getarraysize(.ores)],
		7297, 30, // 黒雲母
		7291, 30, // めのう
		7295, 30; // 黄水晶
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1415; // 串
	setarray .ores[getarraysize(.ores)],
		7297, 10, // 黒雲母
		7291, 10, // めのう
		7295, 10; // 黄水晶
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1140; // 別雲剣
	setarray .ores[getarraysize(.ores)],
		7292, 10, // 白雲母
		7291, 10, // めのう
		7295, 10; // 黄水晶
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1228; // コンバットナイフ
	setarray .ores[getarraysize(.ores)],
		7292, 10, // 白雲母
		7291, 10, // めのう
		7295, 10; // 黄水晶
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1233; // エキサーサイズ
	setarray .ores[getarraysize(.ores)],
		7296, 10, // 輝石
		7294, 10, // トルコ石
		7290, 10; // 金雲母
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
	
	set .weas[getarraysize(.weas)], 1540; // グランドクロス [1]
	setarray .ores[getarraysize(.ores)],
		7296, 30, // 輝石
		7294, 30, // トルコ石
		7290, 30; // 金雲母
	set .ore_bous[getarraysize(.ore_bous)], getarraysize(.ores) / 2;
}
