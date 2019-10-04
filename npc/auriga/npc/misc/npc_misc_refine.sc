//=====================================================================
//武具精錬NPCセリフパターン1
//	（プロンテラ・アルベルタ・アインブロック）
//  callfunc "Refine1","NPCName",SuccessEmotion,FalureEmotion;
//--------------------------------------------------------------------

function	script	Refine1	{
	mes "["+getarg(0)+"]";
	mes "俺は武器と防具を精錬する鍛冶屋だ。";
	mes "君が装備しているアイテムの中で";
	mes "好きなものを精錬できるのだ。";
	mes "どの装備アイテムを";
	mes "精錬したいのかい？";
	next;
	set .@i,select(getequipname2(1),getequipname2(2),getequipname2(3),getequipname2(4),getequipname2(5),
				getequipname2(6),getequipname2(7),getequipname2(8),getequipname2(9),getequipname2(10));
	mes "["+getarg(0)+"]";
	if(getequipisequiped2(.@i)==0) {
		switch(.@i) {
		case 1:
			mes "君の足りない脳みそを";
			mes "精錬してあげようか？";
			break;
		case 2:
			mes "俺の熱い体で君の体を";
			mes "精錬してあげるわ！";
			break;
		case 3:
			mes "君の左手をロケットパンチに";
			mes "する腕はないな。";
			break;
		case 4:
			mes "現代科学技術でも君の右手を";
			mes "ドリルにすることは";
			mes "できないね。";
			break;
		case 5:
			mes "ローブを持ってないじゃないか！";
			break;
		case 6:
			mes "君の足の臭いすごいぜ！";
			break;
		case 7:
		case 8:
			mes "どこにアクセサリーがあるのかい？";
			break;
		case 9:
		case 10:
			mes "何を精錬しろと言うんだ？";
			mes "他のアイテムの事かい？";
			break;
		}
		return;
	}
	if(getequipisenableref2(.@i)==0) {
		mes "このアイテムは精錬不可能だ。";
		return;
	}
	if(getequipisidentify(.@i)==0) {
		mes "これは未鑑定だから精錬できない。";
		return;
	}
	if(getequiprefinerycnt2(.@i)>=10) {
		mes "これ以上は精錬できないぞ。";
		return;
	}
	//初回呼び出し時のみ料金とアイテムIDをそれぞれ格納
	if(.price[0]==0) {
		setarray .price,5000,100,500,5000,10000;
		setarray .itemid,985,1010,1011,984,984;
	}
	set .@wlv,getequipweaponlv2(.@i);
	switch(.@wlv) {
	case 0:
		mes "君が選んだ装備を精錬するには";
		mes "^ff9999エルニウム^000000と";
		mes "手数料5000Zenyが必要だな。";
		mes "続けるかい？";
		break;
	case 1:
		mes "レベル1の武器を精錬したいのかい？";
		mes "精錬するため、 ^ff9999プラコン^000000と";
		mes "手数料100Zenyが必要だな。";
		mes "続けるのか？";
		break;
	case 2:
		mes "レベル2の武器を精錬したいのかい？";
		mes "精錬するため、 ^ff9999エンベルタコン^000000と";
		mes "手数料500Zenyが必要だな。";
		mes "続けるのか？";
		break;
	case 3:
		mes "レベル3の武器を精錬したいのかい？";
		mes "精錬するため、 ^ff9999オリデオコン^000000と";
		mes "手数料5000Zenyが必要だな。";
		mes "続けるのか？";
		break;
	case 4:
		mes "レベル4の武器を精錬したいのかい？";
		mes "精錬するため、 ^ff9999オリデオコン^000000と";
		mes "手数料10000Zenyが必要だな。";
		mes "続けるのか？";
		break;
	}
	next;
	if(select("はい","いいえ")==2) {
		mes "["+getarg(0)+"]";
		mes "君が嫌なら仕方がないだろう…";
		return;
	}
	if(getequippercentrefinery2(.@i) < 100) {
		mes "["+getarg(0)+"]";
		if(.@wlv==0) {	//防具のとき
			mes "おおっと！この防具はもうたくさんの";
			mes "精錬をしてきたみたいだな…これ以上";
			mes "精錬したら防具が壊れるかも";
			mes "しれないぞ。防具が壊れたら";
		}
		else {		//武器のとき
			mes "おおっと！この武器はもうたくさんの";
			mes "精錬をしてきたみたいだな…これ以上";
			mes "精錬したら武器が壊れるかも";
			mes "しれないぞ。武器が壊れたら";
		}
		mes "2度と使えなくなる…それでも";
		mes "精錬をする気なのかい？";
		next;
		if(select("はい","いいえ")==2) {
			mes "["+getarg(0)+"]";
			mes "良い選択だな。";
			mes "俺も無理して他人の武器を壊したら";
			mes "気分が悪くなるからさ…";
			return;
		}
	}
	if(countitem(.itemid[.@wlv])<1 || Zeny<.price[.@wlv]) {
		mes "["+getarg(0)+"]";
		mes "それが君が持ってる全部かい？";
		mes "残念だが、材料が足りないんじゃ";
		mes "仕方がないな。";
		mes "俺はただでやってやるほど";
		mes "心が広くないからな。";
		return;
	}
	delitem .itemid[.@wlv],1;
	set Zeny,Zeny-.price[.@wlv];
	mes "["+getarg(0)+"]";
	mes "カン！ カン！ カン!!";
	if(getequippercentrefinery2(.@i) > rand(100)) {
		successrefitem2 .@i;
		next;
		emotion getarg(1);
		mes "["+getarg(0)+"]";
		mes "さあ、出来上ったよ！";
		mes "久々に良い物ができた。";
		mes "武具が強くなって君も嬉しいだろ？";
	}
	else {
		failedrefitem2 .@i;
		next;
		emotion getarg(2);
		mes "["+getarg(0)+"]";
		mes "クホホホホ…";
		next;
		mes "["+getarg(0)+"]";
		mes "すまん！";
		mes "精錬中に武具が壊れてしまったな…";
		mes "ほ、ほら、俺がやめろって";
		mes "最初に言っただろう？";
	}
	return;
	//closeで終了
}

//=====================================================================
//武具精錬NPCセリフパターン2
//	（フェイヨン・ジュノー）
//  callfunc "Refine2","NPCName",SuccessEmotion,FalureEmotion;
//--------------------------------------------------------------------

function	script	Refine2	{
	mes "["+getarg(0)+"]";
	mes "来たか。まあとにかく";
	mes "精錬したい装備を出せ。";
	next;
	set .@i,select(getequipname2(1),getequipname2(2),getequipname2(3),getequipname2(4),getequipname2(5),
				getequipname2(6),getequipname2(7),getequipname2(8),getequipname2(9),getequipname2(10));
	mes "["+getarg(0)+"]";
	if(getequipisequiped2(.@i)==0) {
		switch(.@i) {
		case 1:
			mes "俺は忙しい！お前の冗談に";
			mes "付き合っている時間など無いんだ。";
			mes "頭を突っ込んでどうするつもりだ？";
			break;
		case 2:
			mes "俺は忙しいと言っているだろう！";
			break;
		case 3:
			mes "くだらない冗談はやめてくれ！";
			break;
		case 4:
			mes "お前、精錬する気あるのか？";
			break;
		case 5:
			mes "かえれ！";
			break;
		case 6:
			mes "くだらない悪戯に付き合う";
			mes "暇は無いんだ！";
			break;
		case 7:
			mes "精錬しないのなら用は無いだろ？";
			break;
		case 8:
			mes "俺は忙しい！";
			break;
		case 9:
			mes "どこを精錬するって？";
			break;
		case 10:
			mes "帰ってくれないか？";
			break;
		}
		return;
	}
	if(getequipisenableref2(.@i)==0) {
		mes "これは精錬できない。";
		mes "他を当たってくれ。";
		return;
	}
	if(getequipisidentify(.@i)==0) {
		mes "わけのわからない物を";
		mes "精錬する趣味は無い…";
		return;
	}
	if(getequiprefinerycnt2(.@i)>=10) {
		mes "これ以上手を加えるところが";
		mes "無いぞ！";
		return;
	}
	//初回呼び出し時のみ料金とアイテムIDをそれぞれ格納
	if(.price[0]==0 || .itemid[0]==0) {
		setarray .price,5000,100,500,5000,10000;
		setarray .itemid,985,1010,1011,984,984;
	}
	set .@wlv,getequipweaponlv2(.@i);
	switch(.@wlv) {
	case 0:
		mes "お前が選んだ装備を精錬するには";
		mes "^ff9999エルニウム^000000と";
		mes "手数料5000Zenyが必要だな。";
		mes "ビタ1Zeny負けられない。";
		break;
	case 1:
		mes "レベル1の武器を精錬したいのか？";
		mes "精錬するため、 ^ff9999プラコン^000000と";
		mes "手数料100Zenyが必要だな。";
		mes "ビタ1Zeny負けられない。";
		break;
	case 2:
		mes "レベル2の武器を精錬したいのか？";
		mes "精錬するため、 ^ff9999エンベルタコン^000000と";
		mes "手数料500Zenyが必要だな。";
		mes "ビタ1Zeny負けられない。";
		break;
	case 3:
		mes "レベル3の武器を精錬したいのか？";
		mes "精錬するため、 ^ff9999オリデオコン^000000と";
		mes "手数料5000Zenyが必要だな。";
		mes "久しぶりに俺の実力を見せてやるか。";
		break;
	case 4:
		mes "レベル4の武器を精錬したいのか？";
		mes "精錬するため、 ^ff9999オリデオコン^000000と";
		mes "手数料10000Zenyが必要だな。";
		mes "レベル4の武器か…興奮するぜ！";
		break;
	}
	next;
	if(select("はい","いいえ")==2) {
		mes "["+getarg(0)+"]";
		mes "遊びじゃないんだよ！";
		return;
	}
	if(getequippercentrefinery2(.@i) < 100) {
		mes "["+getarg(0)+"]";
		mes "く…どこからこんな厄介な物を";
		mes "持ってきたんだ…。";
		mes "これ以上の精錬は危険だ。";
		mes "それを承知でやるというのか？";
		next;
		if(select("はい","いいえ")==2) {
			mes "["+getarg(0)+"]";
			mes "つまらん…";
			mes "俺は忙しい、帰ってくれ。";
			return;
		}
	}
	if(countitem(.itemid[.@wlv])<1 || Zeny<.price[.@wlv]) {
		mes "["+getarg(0)+"]";
		mes "1Zenyも負けられないから";
		mes "精錬したければお金を持ってきな。";
		return;
	}
	delitem .itemid[.@wlv],1;
	set Zeny,Zeny-.price[.@wlv];
	mes "["+getarg(0)+"]";
	mes "カン！ カン！ カン!!";
	if(getequippercentrefinery2(.@i) > rand(100)) {
		successrefitem2 .@i;
		next;
		emotion getarg(1);
		mes "["+getarg(0)+"]";
		mes "バッチリだ！";
		mes "また来てくれ。";
	}
	else {
		failedrefitem2 .@i;
		next;
		emotion getarg(2);
		mes "["+getarg(0)+"]";
		mes "ふ…";
		next;
		mes "["+getarg(0)+"]";
		mes "残念だ…";
		mes "まあ人生こういうこともある。";
		mes "落ち込むなよ…";
	}
	return;
	//closeで終了
}

//=====================================================================
//武具精錬NPCセリフパターン3
//	（モロク）
//  callfunc "Refine3","NPCName",SuccessEmotion,FalureEmotion;
//--------------------------------------------------------------------

function	script	Refine3	{
	mes "["+getarg(0)+"]";
	mes "私は武器と防具を精錬する鍛冶屋。";
	mes "汝が装備しているアイテムの中で";
	mes "好きなものを精錬できる。";
	mes "どの装備アイテムを";
	mes "精錬したいのか？";
	next;
	set .@i,select(getequipname2(1),getequipname2(2),getequipname2(3),getequipname2(4),getequipname2(5),
				getequipname2(6),getequipname2(7),getequipname2(8),getequipname2(9),getequipname2(10));
	mes "["+getarg(0)+"]";
	if(getequipisequiped2(.@i)==0) {
		switch(.@i) {
		case 1:
			mes "汝の足りない脳みそを";
			mes "精錬してさしあげようか？";
			break;
		case 2:
			mes "私の熱い体で汝の体を";
			mes "精錬してあげるわ！";
			break;
		case 3:
			mes "汝の左手を改造する技術は無い。";
			break;
		case 4:
			mes "汝の右手をマシンガンに";
			mes "するのは無理だ。";
			break;
		case 5:
			mes "ローブを持っていないな。";
			break;
		case 6:
			mes "臭い…";
			break;
		case 7:
		case 8:
			mes "どのアクセサリーか？";
			break;
		case 9:
		case 10:
			mes "何を精錬せよと言う？";
			mes "他のアイテムの事か？";
			break;
		}
		return;
	}
	if(getequipisenableref2(.@i)==0) {
		mes "このアイテムは精錬不可能。";
		return;
	}
	if(getequipisidentify(.@i)==0) {
		mes "これは未鑑定だから精錬できない。";
		return;
	}
	if(getequiprefinerycnt2(.@i)>=10) {
		mes "これ以上は精錬できない。";
		return;
	}
	//初回呼び出し時のみ料金とアイテムIDをそれぞれ格納
	if(.price[0]==0 || .itemid[0]==0) {
		setarray .price,5000,100,500,5000,10000;
		setarray .itemid,985,1010,1011,984,984;
	}
	set .@wlv,getequipweaponlv2(.@i);
	switch(.@wlv) {
	case 0:
		mes "汝が選んだ装備を精錬するには";
		mes "^ff9999エルニウム^000000と ";
		mes "手数料5000Zenyが必要だ。";
		mes "続けるか？";
		break;
	case 1:
		mes "レベル1の武器を精錬したいのか？";
		mes "精錬するため、 ^ff9999プラコン^000000と";
		mes "手数料100Zenyが必要だ。";
		mes "続けるか？";
		break;
	case 2:
		mes "レベル2の武器を精錬したいのか？";
		mes "精錬するため、 ^ff9999エンベルタコン^000000と";
		mes "手数料500Zenyが必要だ。";
		mes "続けるか？";
		break;
	case 3:
		mes "レベル3の武器を精錬したいのか？";
		mes "精錬するため、 ^ff9999オリデオコン^000000と";
		mes "手数料5000Zenyが必要だ。";
		mes "続けるか？";
		break;
	case 4:
		mes "レベル4の武器を精錬したいのか？";
		mes "精錬するため、 ^ff9999オリデオコン^000000と";
		mes "手数料10000Zenyが必要だ。";
		mes "続けるか？";
		break;
	}
	next;
	if(select("はい","いいえ")==2) {
		mes "["+getarg(0)+"]";
		mes "汝がやめるなら仕方がない…";
		return;
	}
	if(getequippercentrefinery2(.@i) < 100) {
		mes "["+getarg(0)+"]";
		if(.@wlv==0) {	//防具のとき
			mes "ふむ…この防具はもうたくさんの";
			mes "精錬をしてきたみたいだな…これ以上";
			mes "精錬したら防具が壊れるかも";
			mes "しれない。防具が壊れたら";
		}
		else {		//武器のとき
			mes "ふむ…この武器はもうたくさんの";
			mes "精錬をしてきたみたいだな…これ以上";
			mes "精錬したら武器が壊れるかも";
			mes "しれない。武器が壊れたら";
		}
		mes "2度と使えなくなる…それでも";
		mes "精錬をする気なのか？";
		next;
		if(select("はい","いいえ")==2) {
			mes "["+getarg(0)+"]";
			mes "良い選択だ。";
			mes "私も無理して他人の武器を壊したら";
			mes "気分が悪くなるから…";
			return;
		}
	}
	if(countitem(.itemid[.@wlv])<1 || Zeny<.price[.@wlv]) {
		mes "["+getarg(0)+"]";
		mes "それが汝が持ってる全部か？";
		mes "残念だが、材料が足りないならば";
		mes "仕方がない。";
		mes "私はただでやってさしあげるほど";
		mes "心が広くない。";
		return;
	}
	delitem .itemid[.@wlv],1;
	set Zeny,Zeny-.price[.@wlv];
	mes "["+getarg(0)+"]";
	mes "カン！ カン！ カン!!";
	if(getequippercentrefinery2(.@i) > rand(100)) {
		successrefitem2 .@i;
		next;
		emotion getarg(1);
		mes "["+getarg(0)+"]";
		mes "さあ、出来た！";
		mes "久々に良い物ができたな。";
		mes "武具が強くなって汝も嬉しかろう？";
	}
	else {
		failedrefitem2 .@i;
		next;
		emotion getarg(2);
		mes "["+getarg(0)+"]";
		mes "………";
		next;
		mes "["+getarg(0)+"]";
		mes "すまない…";
		mes "精錬中に武具が壊れてしまった…";
		mes "しかし、最初に忠告はしたぞ？";
	}
	return;
	//closeで終了
}

//=====================================================================
//武具精錬NPCセリフパターン4
//	（プロンテラ）
//  callfunc "Refine4","NPCName",SuccessEmotion,FalureEmotion;
//--------------------------------------------------------------------

function	script	Refine4	{
	mes "["+getarg(0)+"]";
	mes "俺は武器と防具を精錬する鍛冶屋だ！";
	mes "お前が装備しているアイテムを";
	mes "精錬できるってわけだ。";
	mes "ただし、濃縮オリデオコンか";
	mes "濃縮エルニウムが必要だぞ。";
	mes "どの装備アイテムを精錬したい？";
	next;
	set .@i,select(getequipname2(1),getequipname2(2),getequipname2(3),getequipname2(4),getequipname2(5),
				getequipname2(6),getequipname2(7),getequipname2(8),getequipname2(9),getequipname2(10));
	mes "["+getarg(0)+"]";
	if(getequipisequiped2(.@i)==0) {
		switch(.@i) {
		case 1:
			mes "お前の悪い頭を精錬してあげようか？";
			break;
		case 2:
			mes "俺の熱い体でお前の体を";
			mes "精錬してあげるぜ。";
			break;
		case 3:
			mes "残念ながら、お前の左手を";
			mes "ロケットパンチにする能力はないね。";
			break;
		case 4:
			mes "現代科学技術でもお前の右手を";
			mes "ロケットパンチにする事はできないぜ。";
			break;
		case 5:
			mes "持っているローブがないじゃないか？";
			break;
		case 6:
			mes "お前、足のにおいがすごいね。";
			break;
		case 7:
		case 8:
			mes "どのアクセサリーを言ってるんだろ？";
			break;
		case 9:
			mes "何を精錬してほしいんだ？";
			mes "もしかして、頭の他の所？";
			break;
		case 10:
			mes "お前の頭蓋骨を精錬してやろうか？";
			break;
		}
		return;
	}
	if(getequipisenableref2(.@i)==0) {
		mes "ふむ、これは精錬できる";
		mes "アイテムじゃないんだぜ……";
		return;
	}
	if(getequipisidentify(.@i)==0) {
		mes "未鑑定だから精錬できないな。";
		return;
	}
	if(getequiprefinerycnt2(.@i)>=10) {
		mes "これ以上は精錬できないな。";
		return;
	}
	set .@id, getequipid2(.@i);
	//初回呼び出し時のみ料金とアイテムIDをそれぞれ格納
	if(.price[0]==0) {
		setarray .price,5000,100,500,5000,10000;
		setarray .itemid,7619,7620,7620,7620,7620;
	}
	set .@wlv,getequipweaponlv2(.@i);
	switch(.@wlv) {
	case 0:
		mes "お前が選んだ装備を";
		mes "精錬するためには";
		mes "^FF9C9C濃縮エルニウム^000000と";
		mes "手数料5000Zenyが必要だぜ？";
		mes "精錬するか？";
		break;
	case 1:
		mes "レベル1の武器を";
		mes "精錬しようとしてるんだね。";
		mes "精錬のためには";
		mes "^FF9C9C濃縮オリデオコン^000000と";
		mes "手数料100Zenyが必要だぜ？";
		mes "精錬するか？";
		break;
	case 2:
		mes "レベル2の武器を";
		mes "精錬しようとしてるんだね。";
		mes "精錬のためには";
		mes "^FF9C9C濃縮オリデオコン^000000と";
		mes "手数料500Zenyが必要だぜ？";
		mes "精錬するか？";
		break;
	case 3:
		mes "レベル3の武器を";
		mes "精錬しようとしてるんだね。";
		mes "精錬のためには";
		mes "^FF9C9C濃縮オリデオコン^000000と";
		mes "手数料5000Zenyが必要だぜ？";
		mes "精錬するか？";
		break;
	case 4:
		mes "レベル4の武器を";
		mes "精錬しようとしてるんだね。";
		mes "精錬のためには";
		mes "^FF9C9C濃縮オリデオコン^000000と";
		mes "手数料10000Zenyが必要だぜ？";
		mes "精錬するか？";
		break;
	}
	next;
	if(select("はい","いいえ")==2) {
		mes "["+getarg(0)+"]";
		mes "お前がいやだったら仕方ないしな。";
		return;
	}
//	// 濃縮課金アイテム精錬テーブル
//	switch(.@wlv) {
//	case 0: setarray .@parcent,100,100,100,100, 90, 60, 60, 30, 30, 10; break;
//	case 1: setarray .@parcent,100,100,100,100,100,100,100, 90, 60, 20; break;
//	case 2: setarray .@parcent,100,100,100,100,100,100, 90, 60, 30, 20; break;
//	case 3: setarray .@parcent,100,100,100,100,100, 90, 75, 30, 30, 20; break;
//	case 4: setarray .@parcent,100,100,100,100, 90, 60, 60, 30, 30, 10; break;
//	}
//	if(.@parcent[getequiprefinerycnt2(.@i)] < 100) {
	while (1) {
		if(getequipid2(.@i) != .@id ||
			getequiprefinerycnt2(.@i)>=10
		) return;
		if(getequippercentrefinery2(.@i, 1) < 100) {
			mes "["+getarg(0)+"]";
			if(.@wlv==0) {	//防具のとき
				mes "あらら！";
				mes "この防具はもう";
				mes "何回も精錬されちゃったね。";
				mes "これ以上精錬すると";
//				mes "防具が壊れちゃう";
				mes "防具が劣化する恐れがある……";
				//next;
				//mes "["+getarg(0)+"]";
				//mes "防具が壊れちゃうと";
				//mes "二度と使えないんだぜ?!";
				//mes "中に打ち込まれたカードも特性も";
				//mes "^FF0000すべてが消えちゃう^000000んだからね。";
				//mes "^FF0000防具自体が消えちゃう^000000ってわけだ。";
				mes "それでも精錬するつもりか？";
			} else {		//武器のとき
				mes "あらら！";
				mes "この武器はもう";
				mes "何回も精錬されちゃったね。";
				mes "これ以上精錬すると";
//				mes "武器が壊れちゃう";
				mes "武器が劣化する恐れがある……";
				//next;
				//mes "["+getarg(0)+"]";
				//mes "武器が壊れちゃうと";
				//mes "二度と使えないんだぜ?!";
				//mes "中に打ち込まれたカードも特性も";
				//mes "^FF0000すべてが消えちゃう^000000んだからね。";
				//mes "^FF0000武器自体が消えちゃう^000000ってわけだ。";
				mes "それでも精錬するつもりか？";
			}
			next;
			if(select("はい","いいえ")==2) {
				mes "["+getarg(0)+"]";
				mes "そうだな、物は大切に扱うべきだからな。";
				return;
			}
		}
		if(getequipid2(.@i) != .@id ||
			getequiprefinerycnt2(.@i)>=10
		) return;
		if(countitem(.itemid[.@wlv])<1 || Zeny<.price[.@wlv]) {
			mes "["+getarg(0)+"]";
			mes "これがお前が持ってるすべてか？";
			mes "残念だけど、材料が足りないと";
			mes "精錬してあげられないぜ。";
			mes "俺も仕事をした代価くらい";
			mes "貰わないとな……。";
			return;
		}
		delitem .itemid[.@wlv],1;
		set Zeny,Zeny-.price[.@wlv];
		mes "["+getarg(0)+"]";
		mes "カン！ カン！ カン！";
//		if(.@parcent[getequiprefinerycnt2(.@i)] > rand(100)) {
		if(getequippercentrefinery2(.@i, 1) > rand(100)) {
			successrefitem2 .@i;
			next;
			emotion getarg(1);
			mes "["+getarg(0)+"]";
			mes "さ！ 無事に精錬が終わったぜ。";
			mes "俺の腕はまだ使えるぜ！";
			mes "自分で言うのもなんだが、";
			mes "なかなか良い出来じゃないか！";
			if(getequiprefinerycnt2(.@i)>=10) return;
		}
		else {
			failedrefitem3 .@i;
			next;
			emotion getarg(2);
			//mes "["+getarg(0)+"]";
			//mes "ウアアアアアアアアアアッ!!!!";
			//next;
			mes "["+getarg(0)+"]";
			mes "あ、あら……";
			mes "失敗しちゃった。ご、ごめん……";
			//mes "装備が壊れちゃったな……";
			//mes "だ、だからさ……";
			//mes "危ないって言ったじゃないか……";
			//mes "俺を恨まないでくれ……";
			mes "ま、まあ、でも……";
			mes "ちょっと劣化しただけで";
			mes "壊れちゃいないからな……";
		}
		mes "まだ精錬するかい？";
		next;
		if(select("はい","いいえ")==2) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "そうかい……";
			mes "また来てくれよ。";
			return;
		}
	}
	return;
	//closeで終了
}

function	script	Refine5	{
	mes "["+getarg(0)+"]";
	mes "俺は武器と防具を精錬する鍛冶屋だ！";
	mes "お前が装備しているアイテムを";
	mes "精錬できるってわけだ。";
	mes "ただし、改良型濃縮オリデオコンか";
	mes "改良型濃縮エルニウムが必要だぞ。";
	mes "どの装備アイテムを精錬したい？";
	next;
	set .@i,select(getequipname2(1),getequipname2(2),getequipname2(3),getequipname2(4),getequipname2(5),
				getequipname2(6),getequipname2(7),getequipname2(8),getequipname2(9),getequipname2(10));
	mes "["+getarg(0)+"]";
	if(getequipisequiped2(.@i)==0) {
		switch(.@i) {
		case 1:
			mes "お前の悪い頭を精錬してあげようか？";
			break;
		case 2:
			mes "俺の熱い体でお前の体を";
			mes "精錬してあげるぜ。";
			break;
		case 3:
			mes "残念ながら、お前の左手を";
			mes "ロケットパンチにする能力はないね。";
			break;
		case 4:
			mes "現代科学技術でもお前の右手を";
			mes "ロケットパンチにする事はできないぜ。";
			break;
		case 5:
			mes "持っているローブがないじゃないか？";
			break;
		case 6:
			mes "お前、足のにおいがすごいね。";
			break;
		case 7:
		case 8:
			mes "どのアクセサリーを言ってるんだろ？";
			break;
		case 9:
			mes "何を精錬してほしいんだ？";
			mes "もしかして、頭の他の所？";
			break;
		case 10:
			mes "お前の頭蓋骨を精錬してやろうか？";
			break;
		}
		return;
	}
	if(getequipisenableref2(.@i)==0) {
		mes "ふむ、これは精錬できる";
		mes "アイテムじゃないんだぜ……";
		return;
	}
	if(getequipisidentify(.@i)==0) {
		mes "未鑑定だから精錬できないな。";
		return;
	}
	if(getequiprefinerycnt2(.@i)>=10) {
		mes "これ以上は精錬できないな。";
		return;
	}
	set .@id, getequipid2(.@i);
	//初回呼び出し時のみ料金とアイテムIDをそれぞれ格納
	if(.price[0]==0) {
		setarray .price,100000,2000,10000,100000,200000;
		setarray .itemid,6241,6240,6240,6240,6240;
	}
	set .@wlv,getequipweaponlv2(.@i);
	switch(.@wlv) {
	case 0:
		mes "お前が選んだ装備を";
		mes "精錬するためには";
		mes "^FF9C9C改良型濃縮エルニウム^000000と";
		mes "手数料100000Zenyが必要だぜ？";
		mes "精錬するか？";
		break;
	case 1:
		mes "レベル1の武器を";
		mes "精錬しようとしてるんだね。";
		mes "精錬のためには";
		mes "^FF9C9C改良型濃縮オリデオコン^000000と";
		mes "手数料2000Zenyが必要だぜ？";
		mes "精錬するか？";
		break;
	case 2:
		mes "レベル2の武器を";
		mes "精錬しようとしてるんだね。";
		mes "精錬のためには";
		mes "^FF9C9C改良型濃縮オリデオコン^000000と";
		mes "手数料10000Zenyが必要だぜ？";
		mes "精錬するか？";
		break;
	case 3:
		mes "レベル3の武器を";
		mes "精錬しようとしてるんだね。";
		mes "精錬のためには";
		mes "^FF9C9C改良型濃縮オリデオコン^000000と";
		mes "手数料100000Zenyが必要だぜ？";
		mes "精錬するか？";
		break;
	case 4:
		mes "レベル4の武器を";
		mes "精錬しようとしてるんだね。";
		mes "精錬のためには";
		mes "^FF9C9C改良型濃縮オリデオコン^000000と";
		mes "手数料200000Zenyが必要だぜ？";
		mes "精錬するか？";
		break;
	}
	next;
	if(select("はい","いいえ")==2) {
		mes "["+getarg(0)+"]";
		mes "お前がいやだったら仕方ないしな。";
		return;
	}
	while (1) {
		if(getequipid2(.@i) != .@id ||
			getequiprefinerycnt2(.@i)>=10
		) return;
		if(getequippercentrefinery2(.@i, 1) < 100) {
			mes "["+getarg(0)+"]";
			if(.@wlv==0) {	//防具のとき
				mes "あらら！";
				mes "この防具はもう";
				mes "何回も精錬されちゃったね。";
				mes "これ以上精錬すると";
				mes "失敗する恐れがある……";
				next;
				mes "["+getarg(0)+"]";
				mes "まあ、たとえ失敗しても";
				mes "防具が壊れちゃうことはないし";
				mes "劣化したりもしないけどな。";
				mes "じゃあ、精錬してもいいか？";
			} else {		//武器のとき
				mes "あらら！";
				mes "この武器はもう";
				mes "何回も精錬されちゃったね。";
				mes "これ以上精錬すると";
				mes "失敗する恐れがある……";
				next;
				mes "["+getarg(0)+"]";
				mes "まあ、たとえ失敗しても";
				mes "武器が壊れちゃうことはないし";
				mes "劣化したりもしないけどな。";
				mes "じゃあ、精錬してもいいか？";
			}
			next;
			if(select("はい","いいえ")==2) {
				mes "["+getarg(0)+"]";
				mes "そうだな、改良型は貴重だからな。";
				return;
			}
		}
		if(getequipid2(.@i) != .@id ||
			getequiprefinerycnt2(.@i)>=10
		) return;
		if(countitem(.itemid[.@wlv])<1 || Zeny<.price[.@wlv]) {
			mes "["+getarg(0)+"]";
			mes "これがお前が持ってるすべてか？";
			mes "残念だけど、材料が足りないと";
			mes "精錬してあげられないぜ。";
			mes "俺も仕事をした代価くらい";
			mes "貰わないとな……。";
			return;
		}
		delitem .itemid[.@wlv],1;
		set Zeny,Zeny-.price[.@wlv];
		mes "["+getarg(0)+"]";
		mes "カン！ カン！ カン！";
		if(getequippercentrefinery2(.@i, 1) > rand(100)) {
			successrefitem2 .@i;
			next;
			emotion getarg(1);
			mes "["+getarg(0)+"]";
			mes "さ！ 無事に精錬が終わったぜ。";
			mes "俺の腕はまだ使えるぜ！";
			mes "自分で言うのもなんだが、";
			mes "なかなか良い出来じゃないか！";
			if(getequiprefinerycnt2(.@i)>=10) return;
		}
		else {
			failedrefitem4 .@i;
			next;
			emotion getarg(2);
			mes "["+getarg(0)+"]";
			mes "あ、あら……";
			mes "失敗しちゃった。ご、ごめん……";
			mes "ま、まあ、でも……";
			mes "装備に変化はないからな……";
		}
		mes "まだ精錬するかい？";
		next;
		if(select("はい","いいえ")==2) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "そうかい……";
			mes "また来てくれよ。";
			return;
		}
	}
	return;
	//closeで終了
}
//==============================================================================
// RagnarokOnline Original Refine Script Ver0.5   by Blaze
//==============================================================================
prt_in,56,56,0	script	レンゾウ#Refine	85,{
//	********** 初期設定 **********
//	各精錬時に必要な物。左から 防具,Lv1武器,Lv2武器,Lv3武器,Lv4武器
	if(.price[0] == 0) {
//		setarray .price,20000,500,2000,25000,50000;	//値段（Zeny）
		setarray .price,5000,100,500,5000,10000;
		setarray .itemid,985,1010,1011,984,984;		//消費アイテム（ID指定）
	}
//	********** ここまで **********
	mes "[" +strnpcinfo(1)+ "]";
	mes "俺は武器と防具を";
	mes "連続で精錬する鍛冶屋だ。";
	mes "君が装備しているアイテムの中で";
	mes "好きなものを精錬できるのだ。";
	mes "どの装備アイテムを";
	mes "連続で精錬したいんだい？";
	next;
	set .@pos,select(getequipname2(1),getequipname2(2),getequipname2(3),getequipname2(4),getequipname2(5),
				getequipname2(6),getequipname2(7),getequipname2(8),getequipname2(9),getequipname2(10));
	mes "[" +strnpcinfo(1)+ "]";
	if(getequipisequiped2(.@pos) == 0) {
		mes "何も装備してないようだが？";
		mes "装備してからまた来てくれ。";
		close;
	}
	if(getequipisenableref2(.@pos) == 0) {
		mes "このアイテムは精錬不可能だ。";
		close;
	}
	if(getequipisidentify(.@pos) == 0) {
		mes "これは未鑑定だから精錬できない。";
		close;
	}
	if(getequiprefinerycnt2(.@pos) >= 10) {
		mes "これ以上は精錬できないぞ。";
		close;
	}
	set .@wlv,getequipweaponlv2(.@pos);
	mes "君が選んだ装備を精錬するには";
	mes "+1につき、^3131FF" +getitemname(.itemid[.@wlv])+ "^000000と";
	mes "手数料^3131FF" +.price[.@wlv]+ "Zeny^000000が必要だな。";
	mes "どれだけ精錬するんだい？";
	next;
	if(getequippercentrefinery2(.@pos) == 100)
		set .@word$[0],"安全圏まで精錬";
	for(set .@i,10; .@i > getequiprefinerycnt2(.@pos); set .@i,.@i-1)
		set .@word$[.@i],"+" +.@i+ " まで精錬";
	if(select("1回ずつ精錬",.@word$[0],.@word$[1],.@word$[2],.@word$[3],
			.@word$[4],.@word$[5],.@word$[6],.@word$[7],.@word$[8],.@word$[9],.@word$[10]) >= 3)
		set .@cnt,@menu-getequiprefinerycnt2(.@pos)-3;
	else {
		set .@cnt,10;
		if(@menu == 2)
			set .@flag,1;	//安全圏フラグセット
	}
	for(set .@i,0; .@i <= .@cnt; set .@i,.@i+1) {
		if(getequiprefinerycnt2(.@pos) >= 10)
			break;
		if(.@flag && getequippercentrefinery2(.@pos) < 100)	//安全圏フラグの時
			break;
		if(countitem(.itemid[.@wlv]) < 1 || Zeny < .price[.@wlv]) {
			emotion 9;
			mes "[" +strnpcinfo(1)+ "]";
			mes "おっと、材料が足りないな。";
			mes getitemname(.itemid[.@wlv])+ "の数と所持金を";
			mes "ちゃんと確認してくれよ。";
			close;
		}
		mes "[" +strnpcinfo(1)+ "]";
		mes "今の精錬値は ^3131FF+" +getequiprefinerycnt2(.@pos)+ " ^000000だ。";
		if(getequippercentrefinery2(.@pos) < 100) {
			mes "^FF0000これ以上精錬すると";
			mes "装備が壊れるかもしれないが、^000000";
		}
		mes "まだ精錬するかい？";
		next;
		if(select("はい","いいえ")==2) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "そうかい……";
			mes "また来てくれよ。";
			close;
		}
		delitem .itemid[.@wlv],1;
		set Zeny,Zeny-.price[.@wlv];
		if(getequippercentrefinery2(.@pos) > rand(100)) {
			successrefitem2 .@pos;
			continue;
		}
		else {
			failedrefitem2 .@pos;
			emotion 23;
			mes "[" +strnpcinfo(1)+ "]";
			mes "クホホホホ……";
			next;
			mes "[" +strnpcinfo(1)+ "]";
			mes "すまん！";
			mes "装備が壊れてしまったな……";
			mes "……これに懲りずに";
			mes "また来てくれよな、な？";
			close;
		}
	}
	emotion 21;
	mes "[" +strnpcinfo(1)+ "]";
	mes "さあ、出来上ったよ！";
	mes "久々に良い物ができた。";
	mes "武具が強くなって君も嬉しいだろ？";
	close;
}

prt_in,54,56,0	script	カツオ#Refine	85,{
	if(.price[0] == 0) {
		setarray .price,5000,100,500,5000,10000;
		setarray .itemid,985,1010,1011,984,984;		//消費アイテム（ID指定）
	}
	mes "[" +strnpcinfo(1)+ "]";
	mes "俺は武器と防具を";
	mes "一括で精錬する鍛冶屋だ。";
	mes "君が装備しているアイテムの中で";
	mes "好きなものを精錬できるのだ。";
	mes "どの装備アイテムを";
	mes "一括で精錬したいんだい？";
	next;
	set .@pos,select(getequipname2(1),getequipname2(2),getequipname2(3),getequipname2(4),getequipname2(5),
				getequipname2(6),getequipname2(7),getequipname2(8),getequipname2(9),getequipname2(10));
	if(getequipisequiped2(.@pos) == 0) {
		mes "[" +strnpcinfo(1)+ "]";
		mes "何も装備してないようだが？";
		mes "装備してからまた来てくれ。";
		close;
	}
	if(getequipisenableref2(.@pos) == 0) {
		mes "[" +strnpcinfo(1)+ "]";
		mes "このアイテムは精錬不可能だ。";
		close;
	}
	if(getequipisidentify(.@pos) == 0) {
		mes "[" +strnpcinfo(1)+ "]";
		mes "これは未鑑定だから精錬できない。";
		close;
	}
	if(getequiprefinerycnt2(.@pos) >= 10) {
		mes "[" +strnpcinfo(1)+ "]";
		mes "これ以上は精錬できないぞ。";
		close;
	}
	set .@wlv,getequipweaponlv2(.@pos);
	set .@id, getequipid2(.@pos);
	getinventorylist;
	set .@cou, 0;
	for (set .@i, 0; .@i < @inventorylist_count; ++.@i) {
		if (@inventorylist_id[.@i] == .@id &&
			@inventorylist_identify[.@i] &&
			!@inventorylist_attribute[.@i] &&
			@inventorylist_refine[.@i] < 10
		) ++.@cou;
	}
	set .@tot_pri, .price[.@wlv] * .@cou;
	mes "[" +strnpcinfo(1)+ "]";
	mes "君が選んだ装備を一括精錬するには";
	mes "全部で^3131FF" +getitemname(.itemid[.@wlv])+ "^000000が^3131FF" + .@cou + "個^000000と";
	mes "手数料^3131FF" + .@tot_pri + "Zeny^000000が必要だな。";
	mes "じゃあ始めるが、用意はいいか？";
	next;
	if (select("はい", "いいえ") == 2) {
		mes "[" +strnpcinfo(1)+ "]";
		mes "そうかい……";
		mes "また来てくれよ。";
		close;
	}
	
	// アトミック
	getinventorylist;
	set .@cou, 0;
	for (set .@i, 0; .@i < @inventorylist_count; ++.@i) {
		if (@inventorylist_id[.@i] == .@id &&
			@inventorylist_identify[.@i] &&
			!@inventorylist_attribute[.@i] &&
			@inventorylist_refine[.@i] < 10
		) ++.@cou;
	}
	set .@tot_pri, .price[.@wlv] * .@cou;
	if(countitem(.itemid[.@wlv]) < .@cou || 
		Zeny < .@tot_pri
	) {
		emotion 9;
		mes "[" +strnpcinfo(1)+ "]";
		mes "おっと、材料が足りないな。";
		mes getitemname(.itemid[.@wlv])+ "の数と所持金を";
		mes "ちゃんと確認してくれよ。";
		close;
	}
	for (set .@i, 0; .@i < @inventorylist_count; ++.@i) {
		if (@inventorylist_id[.@i] == .@id &&
			@inventorylist_identify[.@i] &&
			!@inventorylist_attribute[.@i] &&
			@inventorylist_refine[.@i] < 10
		) {
			if (equip2(@inventorylist_index[.@i], .@pos)) {
				delitem .itemid[.@wlv], 1;
				set Zeny, Zeny - .price[.@wlv];
				if (getequippercentrefinery2(.@pos) > rand(100)) {
					successrefitem2 .@pos, 0;
					++.@suc;
				} else {
					failedrefitem2 .@pos, 0;
					++.@fai;
				}
			}
		}
	}
	
	if (.@suc) specialeffect2 EF_REFINEOK;
	if (.@fai) specialeffect2 EF_REFINEFAIL;
	mes "[" +strnpcinfo(1)+ "]";
	mes "よし、終わったぞ！";
	mes "成功が^3131FF" + .@suc + "個^000000、失敗が^FF3131" + .@fai + "個^000000だ。";
	mes "あー、疲れた。";
	close;
}

//==============================================================================
//増やしたい時は以下のように設定
//morocc_in,63,39,4	duplicate(連続鍛冶屋#Refine)	連続鍛冶屋	88
//payon,140,174,5	duplicate(連続鍛冶屋#Refine)	連続鍛冶屋	59

// ----- アルベルタ -----
alberta_in,28,58,4	script	フレドリック	85,{
	callfunc "Refine1","フレドリックヘルマンソン",18,4;
	close;
}
// ----- プロンテラ -----
prt_in,63,60,0	script	ホルグレン	85,{
	callfunc "Refine1","ホルグレン",21,23;
	close;
}
// ----- モロク -----
morocc_in,73,38,4	script	アラガム	99,{
	callfunc "Refine3","アラガムサレー",30,16;
	close;
}
// ----- フェイヨン -----
payon,144,173,5	script	アントニオ	88,{
	callfunc "Refine2","アントニオ",0,32;
	close;
}
// ----- ジュノー -----
yuno_in01,171,21,4	script	ディスターブ	85,{
	callfunc "Refine2","ディスターブ",9,0;
	close;
}
// ----- アインブロック -----
ein_in01,24,87,5	script	マンダスマン	826,{
	callfunc "Refine1","マンダスマン",18,4;
	close;
}

// ----- プロンテラ -----
prontera,164,173,2	script	フランツ	85,{
	callfunc "Refine4","フランツ",21,23;
	close;
}

// ----- プロンテラ -----
prontera,164,169,2	script	ヴィルヘルム	85,{
	callfunc "Refine5","ヴィルヘルム",21,23;
	close;
}

//====================================================================
//精錬石販売NPC
//--------------------------------------------------------------------

-	script	BuyStone	-1,{
	if(checkitemblank()==0) {
		mes "- 所持アイテムの種類数が -";
		mes "- 多いため、アイテムを受けとる -";
		mes "- ことができません。 -";
		mes "- 所持アイテムを減らしてから -";
		mes "- 再度話しかけてください。 -";
		close;
	}
	mes "["+strnpcinfo(0)+"]";
	mes "鉄や鋼鉄の武器を精錬する時に";
	mes "使える金属を売っています。";
	mes "1レベルの武器精錬に使える";
	mes "^007777プラコン^000000と";
	mes "2レベルの武器精錬に使える";
	mes "^007777エンベルタコン^000000があります。";
	next;
	mes "["+strnpcinfo(0)+"]";
	mes "プラコンは1個200Zeny、";
	mes "エンベルタコンは";
	mes "1個1000Zenyです。";
	next;
	switch (select("プラコン購入","エンベルタコン購入","他の金属はないか聞いてみる")) {
	case 1:
		set .@price,200;
		set .@itemid,1010;
		break;
	case 2:
		set .@price,1000;
		set .@itemid,1011;
		break;
	case 3:
		mes "["+strnpcinfo(0)+"]";
		mes "1レベルと2レベルの武器より";
		mes "レベルが高い武器を精錬するための";
		mes "金属ですね。";
		mes "もうご存知かもしれませんが、";
		mes "オリデオコンとエルニウムは";
		mes "手に入れるのがすごく難しくてね…";
		close;
	}
	mes "["+strnpcinfo(0)+"]";
	mes "いくつ購入しますか？";
	mes "取り引きを中止したければ";
	mes "「0」でお願いします。";
	while(1) {
		next;
		input .@num;
		if(.@num<=0) {
			mes "["+strnpcinfo(0)+"]";
			mes "取引中止ですね。";
			close;
		}
		if(.@num>500) {
			mes "["+strnpcinfo(0)+"]";
			mes "500個以下で決めてください。";
			continue;
		}
		break;	//while文抜ける
	}
	if(Zeny<.@price*.@num) {
		mes "["+strnpcinfo(0)+"]";
		mes "あれ？お客さん…";
		mes "お金が足りませんね。";
		mes "すみませんが、うちも商売だから";
		mes "損するわけにはいかないんですよ。";
		close;
	}
	if(checkweight(.@itemid,.@num)==0) {
		mes "["+strnpcinfo(0)+"]";
		mes "荷物が多いですね。";
		mes "持ち物を整理してから";
		mes "またおこしください。";
		close;
	}
	set Zeny,Zeny-.@price*.@num;
	getitem .@itemid,.@num;
	mes "["+strnpcinfo(0)+"]";
	mes "ご購入、ありがとうございました。";
	close;
}

alberta_in,13,71,4	duplicate(BuyStone)	カラマンリス	86
//prt_in,56,68,4	duplicate(BuyStone)	ブルウェル	86
prt_in,62,70,4	duplicate(BuyStone)	ブルウェル	86
morocc_in,63,32,0	duplicate(BuyStone)	サド		99
payon,145,178,4	duplicate(BuyStone)	ベグナド	88
yuno_in01,171,27,4	duplicate(BuyStone)	ティルレマ	86
ein_in01,15,87,4	duplicate(BuyStone)	ティルイハース	86


//====================================================================
//精錬石交換NPC
//--------------------------------------------------------------------

-	script	ChangeStone	-1,{
	if(checkitemblank()==0) {
		mes "- 所持アイテムの種類数が -";
		mes "- 多いため、アイテムを受けとる -";
		mes "- ことができません。 -";
		mes "- 所持アイテムを減らしてから -";
		mes "- 再度話しかけてください。 -";
		close;
	}
	mes "["+strnpcinfo(3)+"]";	//識別子を参照
	mes "オリデオコンやエルニウムの原石を";
	mes "僕に持ってきたら、すぐに";
	mes "オリデオコンとエルニウムにしてあげる。";
	mes "但し、原石は各5つ以上持ってくるように。";
	next;
	switch (select("オリデオコンを作る","エルニウムを作る","属性石について聞く")) {
	case 1:
		set .@itemid,756;
		set .@gain,984;
		break;
	case 2:
		set .@itemid,757;
		set .@gain,985;
		break;
	case 3:
		mes "["+strnpcinfo(3)+"]";
		mes "属性石ねえ…";
		mes "私の金属精錬人生20年で";
		mes "話はよく聞いたけど実際には";
		mes "見たことはないな。";
		mes "聞くところによると、金属が";
		mes "火、水、地、風の属性を持つらしい。";
		next;
		mes "["+strnpcinfo(3)+"]";
		mes "その属性石を武器を作る時に";
		mes "混入すれば、属性を持つ武器を";
		mes "作れるという…";
		mes "はは…そんなことができるのは";
		mes "相当な精錬職人だろうね。";
		close;
	}
	if(countitem(.@itemid)<5) {
		mes "["+strnpcinfo(3)+"]";
		mes "え？冗談でしょ？";
		mes getitemname(.@itemid)+ "が5つ以上無いと";
		mes getitemname(.@gain)+ "が作れないと言ったじゃないか。";
		close;
	}
	mes "["+strnpcinfo(3)+"]";
	mes getitemname(.@gain)+ "を作る量はどうする？";
	next;
	if(select("1個分だけ作る","作れるだけ作る")==1) {
		if(checkweight(.@gain,1)==0) {
			mes "‐所持アイテムの重量が重い為";
			mes "　危険です。";
			mes "　所持アイテムを減らしてから、";
			mes "　再度話しかけてください‐";
			close;
		}
		if(countitem(.@itemid)<5) close;
		delitem .@itemid,5;
		getitem .@gain,1;
		mes "["+strnpcinfo(3)+"]";
		mes "ほら、約束の" +getitemname(.@gain)+ "だ。";
		mes "いつでもまた来てくれ。";
		close;
	}
	set .@num,countitem(.@itemid)/5;
	mes "["+strnpcinfo(3)+"]";
	mes getitemname(.@itemid)+ "^FF0000" +(.@num*5)+ "^000000個で";
	mes getitemname(.@gain)+ "^FF0000" +.@num+ "^000000個作ればいい？";
	next;
	if(select("やっぱりやめます","お願いします")==1) {
		mes "["+strnpcinfo(3)+"]";
		mes "いつでもまた来てくれ。";
		close;
	}
	if(checkweight(.@gain,.@num)==0) {
		mes "‐所持アイテムの重量が重い為";
		mes "　危険です。";
		mes "　所持アイテムを減らしてから、";
		mes "　再度話しかけてください‐";
		close;
	}
	if(countitem(.@itemid)<.@num*5) close;
	delitem .@itemid,.@num*5;
	getitem .@gain,.@num;
	mes "["+strnpcinfo(3)+"]";
	mes "ほら、約束の" +getitemname(.@gain)+ "だ。";
	mes "いつでもまた来てくれ。";
	close;
}

alberta_in,21,63,5	duplicate(ChangeStone)	ゼノフォン::ゼノフォン ゾロタス	84
//prt_in,63,69,4	duplicate(ChangeStone)	ディートリヒ		84
prt_in,64,68,4	duplicate(ChangeStone)	ディートリヒ		84
morocc_in,72,32,0	duplicate(ChangeStone)	アブドゥル		99
payon,137,178,5	duplicate(ChangeStone)	ハキム			88
yuno_in01,164,27,4	duplicate(ChangeStone)	ティルレイ		84
ein_in01,18,82,5	duplicate(ChangeStone)	マティシュタイン	84


//====================================================================
//濃縮精錬アイテム交換NPC
//--------------------------------------------------------------------

-	script	::ChangeEnrich	-1,{
	if(checkitemblank()==0) {
		mes "- 所持アイテムの種類数が -";
		mes "- 多いため、アイテムを受けとる -";
		mes "- ことができません。 -";
		mes "- 所持アイテムを減らしてから -";
		mes "- 再度話しかけてください。 -";
		close;
	}
	mes "["+strnpcinfo(3)+"]";	//識別子を参照
	mes "オリデオコンやエルニウムを";
	mes "僕に持ってきたら、すぐに";
	mes "濃縮オリデオコンや濃縮エルニウムに";
	mes "してあげる。";
	mes "但し、オリデオコンやエルニウムは";
	mes "各50個持ってくるように。";
	next;
	switch (select("濃縮オリデオコンを作る","濃縮エルニウムを作る","やめる")) {
	case 1:
		set .@itemid,984;
		set .@gain,7620;
		break;
	case 2:
		set .@itemid,985;
		set .@gain,7619;
		break;
	case 3:
		mes "["+strnpcinfo(3)+"]";
		mes "いつでもまた来てくれ。";
		close;
	}
	if(countitem(.@itemid)<50) {
		mes "["+strnpcinfo(3)+"]";
		mes "え？冗談でしょ？";
		mes getitemname(.@itemid)+ "が50個無いと";
		mes getitemname(.@gain)+ "が作れないと";
		mes "言ったじゃないか。";
		close;
	}
	mes "["+strnpcinfo(3)+"]";
	mes getitemname(.@gain)+ "を作る量はどうする？";
	next;
	if(select("1個分だけ作る","作れるだけ作る")==1) {
		if(checkweight(.@gain,1)==0) {
			mes "‐所持アイテムの重量が重い為";
			mes "　危険です。";
			mes "　所持アイテムを減らしてから、";
			mes "　再度話しかけてください‐";
			close;
		}
		if(countitem(.@itemid)<50) close;
		delitem .@itemid,50;
		getitem .@gain,1;
		mes "["+strnpcinfo(3)+"]";
		mes "ほら、約束の" +getitemname(.@gain)+ "だ。";
		mes "いつでもまた来てくれ。";
		close;
	}
	set .@num,countitem(.@itemid)/50;
	mes "["+strnpcinfo(3)+"]";
	mes getitemname(.@itemid)+ "^FF0000" +(.@num*50)+ "^000000個で";
	mes getitemname(.@gain)+ "^FF0000" +.@num+ "^000000個作ればいい？";
	next;
	if(select("やっぱりやめます","お願いします")==1) {
		mes "["+strnpcinfo(3)+"]";
		mes "いつでもまた来てくれ。";
		close;
	}
	if(checkweight(.@gain,.@num)==0) {
		mes "‐所持アイテムの重量が重い為";
		mes "　危険です。";
		mes "　所持アイテムを減らしてから、";
		mes "　再度話しかけてください‐";
		close;
	}
	if(countitem(.@itemid)<.@num*50) close;
	delitem .@itemid,.@num*50;
	getitem .@gain,.@num;
	mes "["+strnpcinfo(3)+"]";
	mes "ほら、約束の" +getitemname(.@gain)+ "だ。";
	mes "いつでもまた来てくれ。";
	close;
}

prontera,164,165,2	duplicate(ChangeEnrich)	エンリッヒ	84


//====================================================================
//オリデオコン/エルニウム交換NPC
//--------------------------------------------------------------------

-	script	TradeOriElu	-1,{
	if(checkitemblank()==0) {
		mes "- 所持アイテムの種類数が -";
		mes "- 多いため、アイテムを受けとる -";
		mes "- ことができません。 -";
		mes "- 所持アイテムを減らしてから -";
		mes "- 再度話しかけてください。 -";
		close;
	}
	mes "["+strnpcinfo(3)+"]";	//識別子を参照
	mes "オリデオコンとエルニウムを";
	mes "交換してあげようか？";
	mes "但し、君の2個を僕の1個と";
	mes "交換するという条件だけどね。";
	next;
	switch (select("オリデオコンをエルニウムに","エルニウムをオリデオコンに","やめる")) {
	case 1:
		set .@itemid,984;
		set .@gain,985;
		break;
	case 2:
		set .@itemid,985;
		set .@gain,984;
		break;
	case 3:
		mes "["+strnpcinfo(3)+"]";
		mes "いつでもまた来てくれ。";
		close;
	}
	if(countitem(.@itemid)<2) {
		mes "["+strnpcinfo(3)+"]";
		mes "え？冗談でしょ？";
		mes getitemname(.@itemid)+ "が少なくとも";
		mes "2つ必要だよ。";
		close;
	}
	mes "["+strnpcinfo(3)+"]";
	mes "交換する量はどうする？";
	next;
	if(select("1回分だけ交換する","全部交換する")==1) {
		if(checkweight(.@gain,1)==0) {
			mes "‐所持アイテムの重量が重い為";
			mes "　危険です。";
			mes "　所持アイテムを減らしてから、";
			mes "　再度話しかけてください‐";
			close;
		}
		if(countitem(.@itemid)<2) close;
		delitem .@itemid,2;
		getitem .@gain,1;
		mes "["+strnpcinfo(3)+"]";
		mes "ほら、約束の" +getitemname(.@gain)+ "だ。";
		mes "いつでもまた来てくれ。";
		close;
	}
	set .@num,countitem(.@itemid)/2;
	mes "["+strnpcinfo(3)+"]";
	mes "君の" + getitemname(.@itemid)+ "^FF0000" +(.@num*2)+ "^000000個を";
	mes "僕の" + getitemname(.@gain)+ "^FF0000" +.@num+ "^000000個と交換するよ？";
	next;
	if(select("やっぱりやめます","お願いします")==1) {
		mes "["+strnpcinfo(3)+"]";
		mes "いつでもまた来てくれ。";
		close;
	}
	if(checkweight(.@gain,.@num)==0) {
		mes "‐所持アイテムの重量が重い為";
		mes "　危険です。";
		mes "　所持アイテムを減らしてから、";
		mes "　再度話しかけてください‐";
		close;
	}
	if(countitem(.@itemid)<.@num*2) close;
	delitem .@itemid,.@num*2;
	getitem .@gain,.@num;
	mes "["+strnpcinfo(3)+"]";
	mes "ほら、約束の" +getitemname(.@gain)+ "だ。";
	mes "いつでもまた来てくれ。";
	close;
}

prontera,164,161,2	duplicate(TradeOriElu)	マッシモ	84

//====================================================================
//武具修理NPC
//--------------------------------------------------------------------

-	script	Repairer	-1,{
	mes "[修理工]";
	mes "そこの旅人、";
	mes "修理したいアイテムはあるか？";
	mes "アイテムの修理は俺に任せてくれ！";
	next;
	if(select("実は修理して欲しいアイテムが……","今は特に無いです")==2) {
		mes "[修理工]";
		mes "ふむ……";
		mes "なら俺に用は無いな。";
		close;
	}
	set .@num,getrepairableitemcount();
	if(.@num==0) {
		mes "[修理工]";
		mes "おいおい……";
		mes "修理する必要のあるものなんて";
		mes "一つも持っていないじゃないか。";
		mes "はぁ……";
		mes "お前のようなヤツが増えると";
		mes "俺の商売もあがったりだよ……";
		close;
	}
	set .@price,.@num*5000;
	mes "[修理工]";
	mes "ふむ……";
	mes "お前が持っているアイテムで";
	mes "損傷しているアイテムは";
	mes .@num+ "だな。";
	next;
	mes "[修理工]";
	mes "一つ修理するのに 5000 Zenyだから";
	mes "全て直すと" +.@price+ "Zenyとなる。";
	mes "修理するか？";
	next;
	if(select("お願いします","いいえ")==2) {
		mes "[修理工]";
		mes "俺は、アイテムが傷ついたまま";
		mes "放って置かれるのが";
		mes "たまらなく嫌いなんだ。";
		mes "損傷したアイテムはすぐ直そうぜ。";
		close;
	}
	if(Zeny<.@price) {
		mes "[修理工]";
		mes "お金が足りないようだ";
		close;
	}
	set Zeny,Zeny-.@price;
	repairitem;
	mes "[修理工]";
	mes "OK！";
	mes "直ったな。";
	mes "アイテムにも寿命があるってことを";
	mes "覚えておくんだな。";
	close;
}

alberta_in,31,65,4	duplicate(Repairer)	修理工	84
prt_in,63,54,2	duplicate(Repairer)	修理工	86
//morocc_in,71,41,4	duplicate(Repairer)	修理工	99
moc_ruins,107,94,4	duplicate(Repairer)	修理工	99
payon,143,165,7	duplicate(Repairer)	修理工	88
geffen_in,34,166,2	duplicate(Repairer)	修理工	86
aldeba_in,38,60,2	duplicate(Repairer)	修理工	86
yuno_in01,175,28,2	duplicate(Repairer)	修理工	86
