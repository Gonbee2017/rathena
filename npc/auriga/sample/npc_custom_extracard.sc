prt_in,94,61,3	script	カードコレクター::ExtraCard	515,{
	if (!EXT_CAR_INTRODUCE) {
		mes "[ミーモ]";
		mes "あたしはミーメの妹のミーモ。";
		mes "お兄ちゃんを手伝いながら";
		mes "一緒に旅をしてるのよ。";
		next;
		if (BaseLevel < 99) {
			mes "[ミーモ]";
			mes "ここはほんと素敵な街よね。";
			mes "はやく遊びに行きたいなー。";
			close;
		}
		mes "[ミーモ]";
		mes "あたしの趣味はトレードで";
		mes "珍しいカードを集めること。";
		mes "ねえねえ、トレードに興味ない？";
		next;
		if (select("ある", "ない") == 2) {
			mes "[ミーモ]";
			mes "えっ、そうなの？";
			mes "ざんねんー……";
			close;
		}
		mes "[ミーモ]";
		mes "ほんと？";
		mes "じゃ、さっそくトレードしよ。";
		next;
		set EXT_CAR_INTRODUCE, 1;
	} else {
		mes "[ミーモ]";
		mes "こんにちわー。";
		mes "カードをトレードしに来たの？";
		next;
	}
	set .@men, select("また今度", "説明を聞く", "トレードする") - 1;
	if (.@men == 1) {
		mes "[ミーモ]";
		mes "トレードのルールを説明するね。";
		next;
		mes "[ミーモ]";
		mes "-ルール その1-";
		mes "あたしの持ってる^FF40401枚^000000と";
		mes "あなたの持ってる^FF4040" + .pla_cars_siz + "枚^000000を";
		mes "トレードする。";
		next;
		mes "[ミーモ]";
		mes "-ルール その2-";
		mes "あなたが出すカードは";
		mes "あたしが珍しいと思う";
		mes "カードに限られる。";
		next;
		mes "[ミーモ]";
		mes "-ルール その3-";
		mes "どのカードをトレードするかは";
		mes "あなたが全部決められる。";
		next;
		mes "[ミーモ]";
		mes "ルールはこの3つだよ。";
		mes "えっ、よくわかんない？";
		mes "まー、試しにトレードしてみてよ。";
		next;
	} else if (.@men == 2) {
		mes "[ミーモ]";
		mes "まず、あたしのカードの中から";
		mes "あなたが欲しいのを選んでね。";
		next;
		for (set .@i, 0; .@i < getarraysize(.ext_cars); ++.@i)
			set .@ext_car_lis$[getarraysize(.@ext_car_lis$)], getitemname(.ext_cars[.@i]);
		set .@ext_car_lis$[getarraysize(.@ext_car_lis$)], "やめる";
		set .@ext_car_ind, select(printarray(.@ext_car_lis$)) - 1;
		if (.@ext_car_ind < getarraysize(.ext_cars)) {
			set .@ext_car, .ext_cars[.@ext_car_ind];
			set .@ext_car_nam$, .@ext_car_lis$[.@ext_car_ind];
			mes "[ミーモ]";
			mes "^4040FF" + .@ext_car_nam$ + "^000000ね。";
			mes "うん、いいよー。";
			mes "次はあなたのカードを見せて。";
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
				mes "[ミーモ]";
				mes "うーん……あたしが珍しいと";
				mes "思うカードはないかなー。";
				next;
			} else {
				mes "[ミーモ]";
				mes "えっと……珍しいカードは";
				mes "……こんなところかな。";
				mes "じゃ、この中からあなたが出す";
				mes "カードを選んでちょうだい。";
				next;
				for (set .@i, 0; .@i < getarraysize(.@inv_rar_cars); ++.@i)
					set .@inv_rar_car_lis$[getarraysize(.@inv_rar_car_lis$)], getitemname(.@inv_rar_cars[.@i]);
				set .@inv_rar_car_lis$[getarraysize(.@inv_rar_car_lis$)], "やめる";
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
					mes "[ミーモ]";
					mes "^4040FF" + .@pla_car_nam$ + "^000000ね。";
					if (.@i + 1 < .pla_cars_siz)
						mes "次のカードはどれにする？";
					else mes "トレードの内容を確認するよ。";
					next;
				}
				if (.@i >= .pla_cars_siz) {
					mes "[ミーモ]";
					mes "-もらうカード-";
					mes "^4040FF" + .@ext_car_nam$ + "^000000 ^FF40401枚^000000";
					mes "-あげるカード-";
					for (set .@i, 0; .@i < getarraysize(.@pla_cars); ++.@i)
						mes "^4040FF" + .@pla_car_nams$[.@i] + "^000000 ^FF4040" + .@pla_car_amos[.@i] + "枚^000000";
					mes "この内容でトレードしてもいい？";
					next;
					if (select("それでいい", "やっぱりダメ") == 1) {
						
						// アトミック
						for (set .@i, 0; .@i < getarraysize(.@pla_cars); ++.@i) {
							if (countitem(.@pla_cars[.@i]) < .@pla_car_amos[.@i]) {
								mes "[ミーモ]";
								mes "……あれれ？";
								mes "よく見るとカードが";
								mes "足りないみたいだよ？";
								close;
							}
						}
						for (set .@i, 0; .@i < getarraysize(.@pla_cars); ++.@i)
							delitem .@pla_cars[.@i], .@pla_car_amos[.@i];
						getitem .@ext_car, 1;
						emotion ET_DELIGHT;
						mes "[ミーモ]";
						mes "オッケー、交渉成立だね。";
						mes "もらったカードは大事にするよ。";
						close;
						
					}
				}
			}
		}
	}
	mes "[ミーモ]";
	mes "もし珍しいカードが手に入ったら";
	mes "トレードを考えてみてね。";
	close;
OnInit:
	set .pla_cars_siz, 2;
	set .ext_cars[getarraysize(.ext_cars)], 29900; // Atk + 50
	set .ext_cars[getarraysize(.ext_cars)], 29901; // 必中 + 50%
	set .ext_cars[getarraysize(.ext_cars)], 29902; // Def50%無視
	set .ext_cars[getarraysize(.ext_cars)], 29903; // Mdef10%無視
	set .ext_cars[getarraysize(.ext_cars)], 29904; // 近接Atk + 100
	set .ext_cars[getarraysize(.ext_cars)], 29905; // 近接必中 + 100%
	set .ext_cars[getarraysize(.ext_cars)], 29906; // 近接Def100%無視
	set .ext_cars[getarraysize(.ext_cars)], 29907; // 無魔法 + 200%
	set .ext_cars[getarraysize(.ext_cars)], 29908; // 水魔法 + 10%
	set .ext_cars[getarraysize(.ext_cars)], 29909; // 地魔法 + 20%
	set .ext_cars[getarraysize(.ext_cars)], 29910; // 火魔法 + 10%
	set .ext_cars[getarraysize(.ext_cars)], 29911; // 風魔法 + 10%
	set .ext_cars[getarraysize(.ext_cars)], 29912; // 念魔法 + 20%
	set .ext_cars[getarraysize(.ext_cars)], 29913; // エスマ + 10%
	set .ext_cars[getarraysize(.ext_cars)], 29914; // マジッククラッシャー
	set .ext_cars[getarraysize(.ext_cars)], 29915; // 水忍法 + 30%
	set .ext_cars[getarraysize(.ext_cars)], 29916; // 火忍法 + 30%
	set .ext_cars[getarraysize(.ext_cars)], 29917; // 風忍法 + 30%
	set .ext_cars[getarraysize(.ext_cars)], 29918; // ヒール + 10%
	set .ext_cars[getarraysize(.ext_cars)], 29919; // 近接アスムプティオ無視
	set .ext_cars[getarraysize(.ext_cars)], 29920; // 近接オートカウンター無視
	set .ext_cars[getarraysize(.ext_cars)], 29921; // 近接オートガード無視
	set .ext_cars[getarraysize(.ext_cars)], 29922; // 近接ストーンスキン無視
	set .ext_cars[getarraysize(.ext_cars)], 29923; // デモンストレーション無効
	set .ext_cars[getarraysize(.ext_cars)], 29924; // イービルランド無効
	set .ext_cars[getarraysize(.ext_cars)], 29925; // クァグマイア無効
	set .ext_cars[getarraysize(.ext_cars)], 29926; // ベナムダスト無効
	set .ext_cars[getarraysize(.ext_cars)], 29927; // ブランディッシュスピア反撃
	set .ext_cars[getarraysize(.ext_cars)], 29928; // マグナムブレイク反撃
	set .ext_cars[getarraysize(.ext_cars)], 29929; // パルスストライク反撃
	set .nor_car_fir, 4000;
	set .nor_car_las, 4700;
	set .rar_cars[getarraysize(.rar_cars)], 4054; // エンジェリングカード
	set .rar_cars[getarraysize(.rar_cars)], 4047; // ゴーストリングカード
	set .rar_cars[getarraysize(.rar_cars)], 4121; // フリオニカード
	set .rar_cars[getarraysize(.rar_cars)], 4123; // エドガカード
	set .rar_cars[getarraysize(.rar_cars)], 4128; // 黄金蟲カード
	set .rar_cars[getarraysize(.rar_cars)], 4131; // 月夜花カード
	set .rar_cars[getarraysize(.rar_cars)], 4132; // ミストレスカード
	set .rar_cars[getarraysize(.rar_cars)], 4134; // ドラキュラカード
	set .rar_cars[getarraysize(.rar_cars)], 4135; // オークロードカード
	set .rar_cars[getarraysize(.rar_cars)], 4137; // ドレイクカード
	set .rar_cars[getarraysize(.rar_cars)], 4142; // ドッペルゲンガーカード
	set .rar_cars[getarraysize(.rar_cars)], 4143; // オークヒーローカード
	set .rar_cars[getarraysize(.rar_cars)], 4144; // オシリスカード
	set .rar_cars[getarraysize(.rar_cars)], 4145; // ヴェルゼブブカード
	set .rar_cars[getarraysize(.rar_cars)], 4146; // マヤーカード
	set .rar_cars[getarraysize(.rar_cars)], 4147; // バフォメットカード
	set .rar_cars[getarraysize(.rar_cars)], 4148; // ファラオカード
	set .rar_cars[getarraysize(.rar_cars)], 4168; // ダークロードカード
	set .rar_cars[getarraysize(.rar_cars)], 4174; // デビルリングカード
	set .rar_cars[getarraysize(.rar_cars)], 4236; // アモンラーカード
	set .rar_cars[getarraysize(.rar_cars)], 4263; // 怨霊武士カード
	set .rar_cars[getarraysize(.rar_cars)], 4276; // ロードオブデスカード
	set .rar_cars[getarraysize(.rar_cars)], 4302; // タオグンカカード
	set .rar_cars[getarraysize(.rar_cars)], 4305; // タートルジェネラルカード
	set .rar_cars[getarraysize(.rar_cars)], 4318; // ストームナイトカード
	set .rar_cars[getarraysize(.rar_cars)], 4324; // ハティーカード
	set .rar_cars[getarraysize(.rar_cars)], 4330; // 黒蛇王カード
	set .rar_cars[getarraysize(.rar_cars)], 4342; // RSX-0806カード
	set .rar_cars[getarraysize(.rar_cars)], 4352; // イグニゼム=セニア（MVP）カード
	set .rar_cars[getarraysize(.rar_cars)], 4357; // セイレン=ウィンザー（MVP）カード
	set .rar_cars[getarraysize(.rar_cars)], 4359; // エレメス=ガイル（MVP）カード
	set .rar_cars[getarraysize(.rar_cars)], 4361; // ハワード=アルトアイゼン（MVP）カード
	set .rar_cars[getarraysize(.rar_cars)], 4363; // マーガレッタ=ソリン（MVP）カード	
	set .rar_cars[getarraysize(.rar_cars)], 4365; // カトリーヌ=ケイロン（MVP）カード
	set .rar_cars[getarraysize(.rar_cars)], 4367; // セシル=ディモン（MVP）カード
	set .rar_cars[getarraysize(.rar_cars)], 4372; // ペクソジンカード
	set .rar_cars[getarraysize(.rar_cars)], 4374; // ヴェスパーカード
	set .rar_cars[getarraysize(.rar_cars)], 4376; // レディータニーカード
	set .rar_cars[getarraysize(.rar_cars)], 4386; // データルザウルスカード
	set .rar_cars[getarraysize(.rar_cars)], 4399; // 魔剣士タナトスの思念体カード
	set .rar_cars[getarraysize(.rar_cars)], 4403; // キエル-D-01カード
	set .rar_cars[getarraysize(.rar_cars)], 4407; // ランドグリスカード
	set .rar_cars[getarraysize(.rar_cars)], 4408; // グルームアンダーナイトカード
	set .rar_cars[getarraysize(.rar_cars)], 4419; // クトルラナックスカード
	set .rar_cars[getarraysize(.rar_cars)], 4425; // アトロスカード
	set .rar_cars[getarraysize(.rar_cars)], 4430; // イフリートカード
	set .rar_cars[getarraysize(.rar_cars)], 4441; // 堕ちた大神官ヒバムカード
	set .rar_cars[getarraysize(.rar_cars)], 4456; // ニーズヘッグの影カード
	set .rar_cars[getarraysize(.rar_cars)], 4457; // ナハトズィーガーカード
	set .rar_cars[getarraysize(.rar_cars)], 4462; // ハードロックマンモスカード
	set .rar_cars[getarraysize(.rar_cars)], 4463; // テンドリルリオンカード
	set .rar_cars[getarraysize(.rar_cars)], 4507; // 女王スカラバカード
	set .rar_cars[getarraysize(.rar_cars)], 4509; // 女帝スカラバカード
}
