prt_in,94,65,3	script	さすらいの刀師::ShadowEnchant	514,{
	if (!SHA_ENC_INTRODUCE) {
		mes "[ミーメ]";
		mes "私は刀師のミーメと申します。";
		mes "錬成術をきわめるために";
		mes "世界中を旅しています。";
		next;
		mes "[ミーメ]";
		mes "この精錬所は今まで見てきた中で";
		mes "もっとも設備が充実していますね。";
		mes "武具を扱う者には最高の環境です。";
		next;
		if (BaseLevel < 99) {
			mes "[ミーメ]";
			mes "私は当分のあいだここに滞在して";
			mes "研究に没頭しようと思っています。";
			next;
		} else {
			mes "[ミーメ]";
			mes "実は私には特技があるんですよ。";
			mes "もしよかったらあなたが持っている";
			mes "武器を見せてもらえませんか？";
			next;
			if (select("武器を見せる", "断る") == 2) {
				mes "[ミーメ]";
				mes "もちろん無理にとは言いません。";
				mes "ただちょっと興味がわいたもので。";
				next;
			} else {
				mes "[ミーメ]";
				mes "では拝見します。";
				next;
				mes "-ミーメは手にした武器を";
				mes "　真剣な表情で見つめている。-";
				next;
				mes "[ミーメ]";
				mes "ふむ……どうもありがとう。";
				mes "なかなかの代物のようですが";
				mes "まだ未完成みたいですね。";
				next;
				mes "[ミーメ]";
				mes "私が開発した武器錬成法である";
				mes "^4040FFシャドーエンチャント^000000なら";
				mes "さらに強化することが可能です。";
				next;
				set SHA_ENC_INTRODUCE, 1;
			}
		}
	} else {
		mes "[ミーメ]";
		mes "またお会いしましたね。";
		mes "^4040FFシャドーエンチャント^000000で";
		mes "武器を強化しましょうか？";
		next;
	}
	if (SHA_ENC_INTRODUCE) {
		set .@men, select("今はいいです", "説明を聞く", "エンチャントを行う", "エンチャントの初期化を行う") - 1;
		if (.@men == 1) {
			mes "[ミーメ]";
			mes "私はこれまで世界各地を巡り";
			mes "多くの武器を目にしてきましたが";
			mes "そのほとんどに^4040FFシャドースロット^000000が";
			mes "備わっていることを発見しました。";
			next;
			mes "[ミーメ]";
			mes "^4040FFシャドースロット^000000と通常のスロットは";
			mes "お互いに反発し合うため、一方の数が";
			mes "多いほど、もう一方は少なくなります。";
			next;
			mes "[ミーメ]";
			mes "そして^4040FFシャドースロット^0000001つ1つに対して";
			mes "カードから抽出した様々な効果を";
			mes "付与することができます。";
			next;
			mes "[ミーメ]";
			mes "^4040FFシャドーエンチャント^000000は非常に";
			mes "安定しており、必ず成功します。";
			mes "装備が消滅したり、材料が無駄に";
			mes "なることは絶対にありません。";
			next;
			mes "[ミーメ]";
			mes "また^4040FFシャドーエンチャント^000000の効果は";
			mes "初期化することもできます。";
			mes "その際、通常スロットに付いている";
			mes "カードの効果と精錬値については";
			mes "初期化しませんのでご安心ください。";
			next;
			mes "[ミーメ]";
			mes "初期化ではエンチャントの際に";
			mes "材料として使用したカードを";
			mes "復元することができます。";
			mes "ただし付与済みの効果1個につき";
			mes "^FF4040" + .ini_fee + "Zeny^000000が必要です。";
			next;
		} else if (.@men == 2 ||
			.@men == 3
		) {
			set .@wep, getequipid2(4);
			if (!.@wep) {
				mes "[ミーメ]";
				mes "右手に武器を装備してください。";
				close;
			} else {
				set .@slos, 4 - getitemslots(.@wep);
				for (set .@i, 0; .@i < 4; ++.@i)
					set .@cars[.@i], getequipcardid2(4, .@i);
				if (!.@slos ||
					.@cars[0] == CARD0_FORGE
				) {
					mes "[ミーメ]";
					mes "その武器にエンチャントできる";
					mes "^4040FFシャドースロット^000000はありません。";
					close;
				} else if (.@men == 2) {
					for (set .@slo, 0; .@slo < .@slos; ++.@slo) {
						if (!.@cars[3 - .@slo]) break;
					}
					if (.@slo >= .@slos) {
						mes "[ミーメ]";
						mes "その武器の^4040FFシャドースロット^000000は";
						mes "すべてエンチャント済みですよ。";
						close;
					} else {
						mes "[ミーメ]";
						mes "どの効果をエンチャントしますか？";
						next;
						copyarray .@eff_lis$, .eff_nams$, getarraysize(.eff_nams$);
						set .@eff_lis$[getarraysize(.@eff_lis$)], "やめる";
						set .@eff_ind, select(printarray(.@eff_lis$)) - 1;
						if (.@eff_ind < getarraysize(.eff_nams$)) {
							set .@eff_nam$, .eff_nams$[.@eff_ind];
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
							mes "[ミーメ]";
							mes "^4040FF" + .@eff_nam$ + "^000000ですね。";
							mes "この効果をエンチャントするには";
							mes "手数料として^FF4040" + .@fee + "Zeny^000000と";
							mes "^4040FF" + .@ore_nam$ + "^000000 ^FF4040" + .@ore_amo + "個^000000に加え";
							mes "以下のカードが必要になります。";
							next;
							mes "------ 必要なカード ------";
							for (set .@i, 0; .@i < .@eff_cars_siz; ++.@i)
								mes "^4040FF" + .@eff_car_nams$[.@i] + "^000000 ^FF4040" + .@eff_car_amos[.@i] + "枚^000000";
							next;
							mes "[ミーメ]";
							mes "エンチャントを行いますか？";
							next;
							if (select("やめる", "頼む") == 2) {
								mes "[ミーメ]";
								mes "ではさっそく取り掛かりましょう。";
								mes "少々お待ちください……";
								next;
								
								// アトミック
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
									mes "[ミーメ]";
									mes "所持金か材料が足りません。";
									close;
								} else {
									if (getequipid2(4) != .@wep) set .@dif, 1;
									for (set .@i, 0; .@i < 4; ++.@i) {
										if (getequipcardid2(4, .@i) != .@cars[.@i]) {
											set .@dif, 1;
											break;
										}
									}
									if (.@dif) {
										debugmes "シャドウエンチャントでチートを検知 ";
										mes "[ミーメ]";
										mes "武器が変更されています。";
										mes "イカサマはいけませんね……";
										close;
									} else {
										set .@cars[3 - .@slo], .@eff;
										set .@ref, getequiprefinerycnt2(4);
										set Zeny, Zeny - .@fee;
										delitem .@ore, .@ore_amo;
										for (set .@i, 0; .@i < .@eff_cars_siz; ++.@i)
											delitem .@eff_cars[.@i], .@eff_car_amos[.@i];
										delequip2 4;
										getitem2 .@wep, 1, 1, .@ref, 0, .@cars[0], .@cars[1], .@cars[2], .@cars[3];
										misceffect EF_REPAIRWEAPON;
										mes "[ミーメ]";
										mes "……お待たせしました。";
										mes "新たに^4040FF" + .@eff_nam$ + "^000000が付与され";
										mes "とても強力になりましたよ。";
										mes "さぁ、どうぞお持ちください。";
										close;
									}
								}
								
							}
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
						mes "[ミーメ]";
						mes "その武器は初期状態ですよ。";
						close;
					} else {
						mes "[ミーメ]";
						mes "エンチャントの際に材料として";
						mes "使用したカードを復元しますか？";
						next;
						set .@res, select("復元する", "復元しない") == 1;
						mes "[ミーメ]";
						if (.@res) {
							set .@fee, .ini_fee * getarraysize(.@res_slos);
							mes "初期化と同時にカードを復元します。";
							mes "手数料は^FF4040" + .@fee + "Zeny^000000になります。";
						} else {
							mes "初期化と同時にカードはすべて";
							mes "^FF4040消滅^000000しますのでご注意ください。";
						}
						mes "本当に初期化しますか？";
						next;
						if (select("やめる", "頼む") == 2) {
							
							// アトミック
							if (Zeny < .@fee) {
								mes "[ミーメ]";
								mes "所持金が足りません。";
								close;
							} else {
								if (getequipid2(4) != .@wep) set .@dif, 1;
								for (set .@i, 0; .@i < 4; ++.@i) {
									if (getequipcardid2(4, .@i) != .@cars[.@i]) {
										set .@dif, 1;
										break;
									}
								}
								if (.@dif) {
									debugmes "シャドウエンチャントの初期化でチートを検知 ";
									mes "[ミーメ]";
									mes "武器が変更されています。";
									mes "イカサマはいけませんね……";
									close;
								} else {
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
									mes "[ミーメ]";
									mes "^4040FFシャドースロット^000000に付与されていた";
									mes "すべての効果を消しました。";
									close;
								}
							}
							
						}
					}
				}
			}
		}
	}
	mes "[ミーメ]";
	mes "冒険者には良い武器が必要です。";
	mes "特にあなたのような方にはね。";
	close;
OnInit:
	set .eff_fir, 29600;
	set .eff_las, 30000;
	set .eff_nams$[getarraysize(.eff_nams$)], "Atk + 15";
	setarray .effs[getarraysize(.effs)], 29600,5000000;
	setarray .ores[getarraysize(.ores)], 6240,5; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4043,2, // アンドレカード
		4337,2, // ポルセリオカード
		4410,2, // エキオカード
		4453,2, // ヒルスリオンカード
		4508,2; // 甲帝スカラバカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "必中 + 25%";
	setarray .effs[getarraysize(.effs)], 29601,5000000;
	setarray .ores[getarraysize(.ores)], 6240,5; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4106,2, // マミーカード
		4225,2, // フレイムシューターカード
		4248,2, // エンシェントマミーカード
		4312,2, // オットーカード
		4428,2; // ボウガーディアンカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "Def25%無視";
	setarray .effs[getarraysize(.effs)], 29602,5000000;
	setarray .ores[getarraysize(.ores)], 6240,5; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4061,2, // カナトウスカード
		4220,2, // ソリッドタートルカード
		4226,2, // スティングカード
		4339,2, // ミネラルカード
		4417,2; // アイスタイタンカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "Mdef5%無視";
	setarray .effs[getarraysize(.effs)], 29603,5000000;
	setarray .ores[getarraysize(.ores)], 6240,5; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4240,2, // アクラウスカード
		4278,2, // ジビットカード
		4290,2, // キャットナインテイルカード
		4405,2, // プルスカード
		4414,2; // シーカーカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "無形 + 20%";
	setarray .effs[getarraysize(.effs)], 29604,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4156,2, // ゴブリンライダーカード
		4239,2, // アイアンフィストカード
		4308,2, // 三葉蟲カード
		4434,2, // ノッカーカード
		4475,2; // コバルトミネラルカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "不死形 + 20%";
	setarray .effs[getarraysize(.effs)], 29605,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4157,2, // ゴブリンアーチャーカード
		4190,2, // レイスカード
		4274,2, // ゾンビマスターカード
		4275,2, // ゾンビプリズナーカード
		4473,2; // エンシェントツリーカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "動物形 + 20%";
	setarray .effs[getarraysize(.effs)], 29606,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4188,2, // レイブオルマイカード
		4224,2, // ステムワームカード
		4297,2, // クルーザーカード
		4355,2, // グレムリンカード
		4472,2; // ブラディウムゴーレムカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "植物形 + 20%";
	setarray .effs[getarraysize(.effs)], 29607,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4151,2, // ガジョマートカード
		4177,2, // ドリアードカード
		4289,2, // キャタピラーカード
		4292,2, // コボルドアーチャーカード
		4470,2; // ネペンテスカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "昆虫形 + 20%";
	setarray .effs[getarraysize(.effs)], 29608,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4149,2, // ガーゴイルカード
		4152,2, // ガラパゴカード
		4165,2, // ギグカード
		4214,2, // ブラッディマーダーカード
		4476,2; // ピンギキュラカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "魚貝形 + 20%";
	setarray .effs[getarraysize(.effs)], 29609,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4192,2, // ロータージャイロカード
		4195,2, // リーフキャットカード
		4326,2, // シーオッターカード
		4422,2, // ロウィーンカード
		4469,2; // ナーガカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "悪魔形 + 20%";
	setarray .effs[getarraysize(.effs)], 29610,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4124,2, // メデューサカード
		4182,2, // ディアボリックカード
		4249,2, // エンシェントワームカード
		4310,2, // パンツァーゴブリンカード
		4406,2; // スケゴルトカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "人間形 + 20%";
	setarray .effs[getarraysize(.effs)], 29611,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4245,2, // アムムトカード
		4246,2, // アサルトタートルカード
		4329,2, // フェンダークカード
		4360,2, // エレメス=ガイルカード
		4474,2; // ザクダムカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "天使形 + 20%";
	setarray .effs[getarraysize(.effs)], 29612,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4241,2, // アークエンジェリングカード
		4265,2, // 虎人カード
		4316,2, // フェイクエンジェルカード
		4391,2, // 執行する者カード
		4398,2; // タナトスの苦悩カード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "竜形 + 20%";
	setarray .effs[getarraysize(.effs)], 29613,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4176,2, // デュラハンカード
		4180,2, // ドリラーカード
		4267,2, // エクスプロージョンカード
		4385,2, // ドラゴンの卵カード
		4471,2; // ドラコの卵カード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "水属性 + 20%";
	setarray .effs[getarraysize(.effs)], 29614,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4089,2, // ソードフィッシュカード
		4095,2, // マルスカード
		4105,2, // マルクカード
		4423,2, // ガリオンカード
		4443,2; // アクアエレメンタルカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "地属性 + 20%";
	setarray .effs[getarraysize(.effs)], 29615,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4087,2, // ガイアスカード
		4081,2, // ホードカード
		4101,2, // サンドマンカード
		4432,2, // マグマリンカード
		4444,2; // ドラコカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "火属性 + 20%";
	setarray .effs[getarraysize(.effs)], 29616,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4099,2, // パサナカード
		4109,2, // ジャックカード
		4203,2, // ミュータントドラゴンカード
		4380,2, // レッドペロスカード
		4431,2; // カーサカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "風属性 + 20%";
	setarray .effs[getarraysize(.effs)], 29617,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4042,2, // スチールチョンチョンカード
		4056,2, // ダスティネスカード
		4098,2, // ドケビカード
		4178,2, // ドラゴンテイルカード
		4445,2; // ルシオラヴェスパカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "毒属性 + 20%";
	setarray .effs[getarraysize(.effs)], 29618,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4108,2, // ミストカード
		4114,2, // アルギオペカード
		4333,2, // ベノマスカード
		4447,2, // センチピードカード
		4468,2; // ダークピンギキュラカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "聖属性 + 20%";
	setarray .effs[getarraysize(.effs)], 29619,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4311,2, // パーメットタートルカード
		4319,2, // フリーズタートルカード
		4331,2, // ヒートタートルカード
		4371,2, // アークダムカード
		4448,2; // コルヌスカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "闇属性 + 20%";
	setarray .effs[getarraysize(.effs)], 29620,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4116,2, // イシスカード
		4119,2, // バースリーカード
		4169,2, // ダークイリュージョンカード
		4170,2, // ダークフレームカード
		4449,2; // ダークシャドーカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "念属性 + 20%";
	setarray .effs[getarraysize(.effs)], 29621,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4113,2, // マリオネットカード
		4127,2, // ナイトメアカード
		4295,2, // クラベンカード
		4334,2, // ノクシャスカード
		4439,2; // フレームスカルカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "不死属性 + 20%";
	setarray .effs[getarraysize(.effs)], 29622,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4071,2, // オークゾンビカード
		4141,2, // イビルドルイドカード
		4189,2, // デッドリーレイスカード
		4221,2, // ジェネラルスケルトンカード
		4328,2; // ヒェグンカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "小型 + 15%";
	setarray .effs[getarraysize(.effs)], 29623,3000000;
	setarray .ores[getarraysize(.ores)], 6240,3; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4204,2, // ミニデモカード
		4298,2, // クリーミーフィアーカード
		4452,2, // センチピード幼虫カード
		4467,2, // ヘビィメタリンカード
		4511,2; // リトルファートゥムカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "中型 + 15%";
	setarray .effs[getarraysize(.effs)], 29624,3000000;
	setarray .ores[getarraysize(.ores)], 6240,3; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4301,2, // キラーマンティスカード
		4426,2, // ビョルグカード
		4450,2, // バンシーマスターカード
		4465,2, // ファナトカード
		4466,2; // ビホルダーマスターカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "大型 + 15%";
	setarray .effs[getarraysize(.effs)], 29625,3000000;
	setarray .ores[getarraysize(.ores)], 6240,3; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4164,2, // グリンブルスティカード
		4270,2, // ジャイアントスパイダーカード
		4271,2, // ジャイアントホーネットカード
		4303,2, // 巨大ウィスパーカード
		4477,2; // ヘルアポカリプスカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "ボス + 10%";
	setarray .effs[getarraysize(.effs)], 29626,4000000;
	setarray .ores[getarraysize(.ores)], 6240,4; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4163,2, // グリフォンカード
		4171,2, // ダークプリーストカード
		4198,2, // マヤパープルカード
		4300,2, // キメラカード
		4384,2; // ハイドラランサーカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接Atk + 25";
	setarray .effs[getarraysize(.effs)], 29627,5000000;
	setarray .ores[getarraysize(.ores)], 6240,5; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4043,2, // アンドレカード
		4337,2, // ポルセリオカード
		4410,2, // エキオカード
		4453,2, // ヒルスリオンカード
		4508,2; // 甲帝スカラバカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接必中 + 50%";
	setarray .effs[getarraysize(.effs)], 29628,5000000;
	setarray .ores[getarraysize(.ores)], 6240,5; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4106,2, // マミーカード
		4225,2, // フレイムシューターカード
		4248,2, // エンシェントマミーカード
		4312,2, // オットーカード
		4428,2; // ボウガーディアンカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接Def50%無視";
	setarray .effs[getarraysize(.effs)], 29629,5000000;
	setarray .ores[getarraysize(.ores)], 6240,5; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4061,2, // カナトウスカード
		4220,2, // ソリッドタートルカード
		4226,2, // スティングカード
		4339,2, // ミネラルカード
		4417,2; // アイスタイタンカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接無形 + 25%";
	setarray .effs[getarraysize(.effs)], 29630,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4156,2, // ゴブリンライダーカード
		4239,2, // アイアンフィストカード
		4308,2, // 三葉蟲カード
		4434,2, // ノッカーカード
		4475,2; // コバルトミネラルカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接不死形 + 25%";
	setarray .effs[getarraysize(.effs)], 29631,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4157,2, // ゴブリンアーチャーカード
		4190,2, // レイスカード
		4274,2, // ゾンビマスターカード
		4275,2, // ゾンビプリズナーカード
		4473,2; // エンシェントツリーカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接動物形 + 25%";
	setarray .effs[getarraysize(.effs)], 29632,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4188,2, // レイブオルマイカード
		4224,2, // ステムワームカード
		4297,2, // クルーザーカード
		4355,2, // グレムリンカード
		4472,2; // ブラディウムゴーレムカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接植物形 + 25%";
	setarray .effs[getarraysize(.effs)], 29633,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4151,2, // ガジョマートカード
		4177,2, // ドリアードカード
		4289,2, // キャタピラーカード
		4292,2, // コボルドアーチャーカード
		4470,2; // ネペンテスカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接昆虫形 + 25%";
	setarray .effs[getarraysize(.effs)], 29634,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4149,2, // ガーゴイルカード
		4152,2, // ガラパゴカード
		4165,2, // ギグカード
		4214,2, // ブラッディマーダーカード
		4476,2; // ピンギキュラカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接魚貝形 + 25%";
	setarray .effs[getarraysize(.effs)], 29635,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4192,2, // ロータージャイロカード
		4195,2, // リーフキャットカード
		4326,2, // シーオッターカード
		4422,2, // ロウィーンカード
		4469,2; // ナーガカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接悪魔形 + 25%";
	setarray .effs[getarraysize(.effs)], 29636,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4124,2, // メデューサカード
		4182,2, // ディアボリックカード
		4249,2, // エンシェントワームカード
		4310,2, // パンツァーゴブリンカード
		4406,2; // スケゴルトカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接人間形 + 25%";
	setarray .effs[getarraysize(.effs)], 29637,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4245,2, // アムムトカード
		4246,2, // アサルトタートルカード
		4329,2, // フェンダークカード
		4360,2, // エレメス=ガイルカード
		4474,2; // ザクダムカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接天使形 + 25%";
	setarray .effs[getarraysize(.effs)], 29638,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4241,2, // アークエンジェリングカード
		4265,2, // 虎人カード
		4316,2, // フェイクエンジェルカード
		4391,2, // 執行する者カード
		4398,2; // タナトスの苦悩カード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接竜形 + 25%";
	setarray .effs[getarraysize(.effs)], 29639,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4176,2, // デュラハンカード
		4180,2, // ドリラーカード
		4267,2, // エクスプロージョンカード
		4385,2, // ドラゴンの卵カード
		4471,2; // ドラコの卵カード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接水属性 + 25%";
	setarray .effs[getarraysize(.effs)], 29640,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4089,2, // ソードフィッシュカード
		4095,2, // マルスカード
		4105,2, // マルクカード
		4423,2, // ガリオンカード
		4443,2; // アクアエレメンタルカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接地属性 + 25%";
	setarray .effs[getarraysize(.effs)], 29641,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4087,2, // ガイアスカード
		4081,2, // ホードカード
		4101,2, // サンドマンカード
		4432,2, // マグマリンカード
		4444,2; // ドラコカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接火属性 + 25%";
	setarray .effs[getarraysize(.effs)], 29642,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4099,2, // パサナカード
		4109,2, // ジャックカード
		4203,2, // ミュータントドラゴンカード
		4380,2, // レッドペロスカード
		4431,2; // カーサカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接風属性 + 25%";
	setarray .effs[getarraysize(.effs)], 29643,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4042,2, // スチールチョンチョンカード
		4056,2, // ダスティネスカード
		4098,2, // ドケビカード
		4178,2, // ドラゴンテイルカード
		4445,2; // ルシオラヴェスパカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接毒属性 + 25%";
	setarray .effs[getarraysize(.effs)], 29644,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4108,2, // ミストカード
		4114,2, // アルギオペカード
		4333,2, // ベノマスカード
		4447,2, // センチピードカード
		4468,2; // ダークピンギキュラカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接聖属性 + 25%";
	setarray .effs[getarraysize(.effs)], 29645,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4311,2, // パーメットタートルカード
		4319,2, // フリーズタートルカード
		4331,2, // ヒートタートルカード
		4371,2, // アークダムカード
		4448,2; // コルヌスカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接闇属性 + 25%";
	setarray .effs[getarraysize(.effs)], 29646,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4116,2, // イシスカード
		4119,2, // バースリーカード
		4169,2, // ダークイリュージョンカード
		4170,2, // ダークフレームカード
		4449,2; // ダークシャドーカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接念属性 + 25%";
	setarray .effs[getarraysize(.effs)], 29647,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4113,2, // マリオネットカード
		4127,2, // ナイトメアカード
		4295,2, // クラベンカード
		4334,2, // ノクシャスカード
		4439,2; // フレームスカルカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接不死属性 + 25%";
	setarray .effs[getarraysize(.effs)], 29648,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4071,2, // オークゾンビカード
		4141,2, // イビルドルイドカード
		4189,2, // デッドリーレイスカード
		4221,2, // ジェネラルスケルトンカード
		4328,2; // ヒェグンカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接小型 + 20%";
	setarray .effs[getarraysize(.effs)], 29649,3000000;
	setarray .ores[getarraysize(.ores)], 6240,3; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4204,2, // ミニデモカード
		4298,2, // クリーミーフィアーカード
		4452,2, // センチピード幼虫カード
		4467,2, // ヘビィメタリンカード
		4511,2; // リトルファートゥムカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接中型 + 20%";
	setarray .effs[getarraysize(.effs)], 29650,3000000;
	setarray .ores[getarraysize(.ores)], 6240,3; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4301,2, // キラーマンティスカード
		4426,2, // ビョルグカード
		4450,2, // バンシーマスターカード
		4465,2, // ファナトカード
		4466,2; // ビホルダーマスターカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接大型 + 20%";
	setarray .effs[getarraysize(.effs)], 29651,3000000;
	setarray .ores[getarraysize(.ores)], 6240,3; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4164,2, // グリンブルスティカード
		4270,2, // ジャイアントスパイダーカード
		4271,2, // ジャイアントホーネットカード
		4303,2, // 巨大ウィスパーカード
		4477,2; // ヘルアポカリプスカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "近接ボス + 15%";
	setarray .effs[getarraysize(.effs)], 29652,4000000;
	setarray .ores[getarraysize(.ores)], 6240,4; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4163,2, // グリフォンカード
		4171,2, // ダークプリーストカード
		4198,2, // マヤパープルカード
		4300,2, // キメラカード
		4384,2; // ハイドラランサーカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "無魔法 + 100%";
	setarray .effs[getarraysize(.effs)], 29653,1000000;
	setarray .ores[getarraysize(.ores)], 6240,1; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4185,2, // ライドワードカード
		4219,2, // セージワームカード
		4251,2, // エルダーカード
		4262,2, // 天邪仙人カード
		4387,2; // エンシェントミミック
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "水魔法 + 5%";
	setarray .effs[getarraysize(.effs)], 29654,3000000;
	setarray .ores[getarraysize(.ores)], 6240,3; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4208,2, // 雅人形カード
		4323,2, // ハティーベベカード
		4354,2, // ジェミニ-S58カード
		4416,2, // シロマカード
		4418,2; // ゲイズティカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "地魔法 + 10%";
	setarray .effs[getarraysize(.effs)], 29655,2000000;
	setarray .ores[getarraysize(.ores)], 6240,2; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4259,2, // ウドゥンゴーレムカード
		4280,2, // ジオグラファーカード
		4282,2, // 酒天狗カード
		4335,2, // ピットマンカード
		4347,2; // アルマイア=デュンゼ
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "火魔法 + 5%";
	setarray .effs[getarraysize(.effs)], 29656,3000000;
	setarray .ores[getarraysize(.ores)], 6240,3; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4320,2, // ブラッディナイトカード
		4327,2, // パピヨンカード
		4346,2, // イグニゼム=セニアカード
		4429,2, // サラマンダーカード
		4433,2; // インプカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "風魔法 + 5%";
	setarray .effs[getarraysize(.effs)], 29657,3000000;
	setarray .ores[getarraysize(.ores)], 6240,3; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4237,2, // オウルデュークカード
		4238,2, // オウルバロンカード
		4264,2, // ウィンドゴーストカード
		4345,2, // ヒルウィンドカード
		4351,2; // カヴァク=イカルス
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "念魔法 + 10%";
	setarray .effs[getarraysize(.effs)], 29658,2000000;
	setarray .ores[getarraysize(.ores)], 6240,2; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4070,2, // エギラカード
		4325,2, // ハーピーカード
		4350,2, // ラウレル=ヴィンダーカード
		4388,2, // デスワード
		4438,2; // バンシーカード
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .eff_nams$[getarraysize(.eff_nams$)], "エスマ + 5%";
	setarray .effs[getarraysize(.effs)], 29659,4000000;
	setarray .ores[getarraysize(.ores)], 6240,4; // 改良型濃縮オリデオコン
	setarray .eff_cars[getarraysize(.eff_cars)],
		4358,2, // セイレン=ウィンザー
		4362,2, // ハワード=アルトアイゼン
		4364,2, // マーガレッタ=ソリン
		4366,2, // カトリーヌ=ケイロンカード
		4368,2; // セシル=ディモン
	set .eff_car_bous[getarraysize(.eff_car_bous)], getarraysize(.eff_cars) / 2;
	set .ini_fee, 1000000;
}
