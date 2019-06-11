prontera,146,232,5	script	発明家::Inventor	923,{
	mes "[ナカガワ博士]";
	mes "ウオッホン！";
	mes "ワシの名はナカガワ博士。";
	mes "発明の天才と呼ばれておる。";
	next;
	mes "[ナカガワ博士]";
	mes "そして隣にあるのが長年の研究の末に";
	mes "ついに完成させた夢のマシーン……";
	mes "カードコンバーターじゃ！";
	next;
	if (select("どういうものなんですか？", "興味ありません") == 1) {
		mes "[ナカガワ博士]";
		mes "よくぞ聞いてくれた。";
		mes "お前さん、若いのに見る目があるな。";
		next;
		mes "[ナカガワ博士]";
		mes "このマシーンにカードを投入すると";
		mes "……";
		mes "属性石を触媒としてγ粒子が発生し";
		mes "……";
		mes "得られた波形をω関数で解析して";
		mes "……";
		next;
		mes "-真剣に説明してくれているようだが";
		mes "　いかんせん話が意味不明でまったく";
		mes "　理解できない-";
		next;
		mes "[ナカガワ博士]";
		mes "……その結果、な な なんと！";
		mes "元のカードとは異なる別のカードに";
		mes "変換されるんじゃ！";
		next;
		mes "[ナカガワ博士]";
		mes "ただし不確定性原理によりどのカードに";
		mes "変換されるかは未知数じゃがな……";
		next;
		select("はぁ……");
		mes "[ナカガワ博士]";
		mes "わからんかね？";
		mes "倉庫でホコリをかぶっているカードを";
		mes "使い道のあるカードに変換できれば";
		mes "冒険の大きな助けになるじゃろ。";
		next;
		select("それはすごいかも！");
		mes "[ナカガワ博士]";
		mes "当たり前じゃ。";
		mes "なんせワシの発明じゃからな！";
		mes "ガッハッハ……";
		next;
		mes "[ナカガワ博士]";
		mes "もし余っているカードがあったら";
		mes "このマシーンで変換してみなされ。";
		next;
		mes "[ナカガワ博士]";
		mes "しかしあらかじめ断っておくが";
		mes "変換したあとで文句は言いっこ";
		mes "なしじゃぞい。";
		close;
	}
	mes "[ナカガワ博士]";
	mes "ふむ、天才の発明はなかなか";
	mes "理解されんもんじゃからな。";
	close;
}

prontera,144,230,5	script	謎の機械::CardConverter	564,{
	if (checkitemblank() < 1) {
		soundeffect "effect\\warning.wav", 0;
		mes "[カードコンバーター]";
		mes "^FF4040(ビー ビー)^000000";
		mes "アイテム オーバー フロー";
		mes "ヘンカン フカノウ";
		close;
	}
	soundeffect "effect\\analyze.wav", 0;
	mes "[カードコンバーター]";
	mes "^00FF00(ピポ パポ ピポパ)^000000";
	mes "カード ヲ トウニュウ";
	mes "シテ クダサイ";
	next;
	setcardlist .@car_ids;
	set .@cars_siz, getarraysize(.@car_ids);
	if (.@cars_siz) {
		for (set .@i, 0; .@i < .@cars_siz; set .@i, .@i + 1)
			set .@car_nams$[.@i], getitemname(.@car_ids[.@i]);
		set .@car_nams$[.@i], "やめる";
		set .@car_ind, select(printarray(.@car_nams$)) - 1;
		if (.@car_ind < .@cars_siz) {
			set .@old_car_id, .@car_ids[.@car_ind];
			set .@old_car_nam$, .@car_nams$[.@car_ind];
			mes "[カードコンバーター]";
			mes "^00FF00(ピー ガガガガ)^000000";
			mes "タダイマ ニンシキ チュウ";
			mes "シバラク オマチ クダサイ";
			next;
			mes "[カードコンバーター]";
			mes "^00FF00(ピコーン ピコーン)^000000";
			mes "ニンシキ カンリョウ";
			next;
			mes "[カードコンバーター]";
			mes "ターゲット カクニン";
			mes ">>> ^4040FF" + .@old_car_nam$ + "^000000 <<<";
			mes "コノ カード ヲ";
			mes "ヘンカン シマスカ？";
			next;
			if (select("はい", "いいえ") == 1) {
				soundeffect "se_machine.wav", 0;
				mes "[カードコンバーター]";
				mes "^00FF00(グワン グワン ガタン ガタン)^000000";
				mes "タダイマ ヘンカン チュウ";
				mes "シバラク オマチ クダサイ";
				next;
				specialeffect EF_WARP;
				soundeffect "effect\\hovering.wav", 0;
				mes "[カードコンバーター]";
				mes "^00FF00(キュイーン)^000000";
				mes "エネルギー ジュウテン";
				mes "１２０ パーセント";
				mes "アツリョク ジョウショウ";
				next;
				specialeffect EF_SUI_EXPLOSION;
				mes "[カードコンバーター]";
				mes "^FF4040(ボンッ)^000000";
				next;
				if (countitem(.@old_car_id)) {
					
					// アトミック
					set .@new_car_id, convertcard(.@old_car_id);
					delitem .@old_car_id, 1;
					getitem .@new_car_id, 1;
					
					soundeffect "rsx_0806_stand.wav", 0;
					mes "[カードコンバーター]";
					mes "^00FF00(プシューーー)^000000";
					mes "ヘンカン カンリョウ";
					mes "カード ヲ オウケトリ クダサイ";
					close;
				}
			}
		}
		soundeffect "effect\\warning.wav", 0;
		mes "[カードコンバーター]";
		mes "^FF4040(ビー ビー)^000000";
		mes "ヘンカン チュウシ";
		close;
	}
	mes "-カードを1枚も持っていないので";
	mes "　この機械を使うことはできない。-";
	close;
}
