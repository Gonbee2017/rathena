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
	if(checkweight(.@gain,1)==0) {
		mes "‐所持アイテムの重量が重い為";
		mes "　危険です。";
		mes "　所持アイテムを減らしてから、";
		mes "　再度話しかけてください‐";
		close;
	}
	delitem .@itemid,50;
	getitem .@gain,1;
	mes "["+strnpcinfo(3)+"]";
	mes "ほら、約束の" +getitemname(.@gain)+ "だ。";
	mes "いつでもまた来てくれ。";
	close;
}

prontera,126,62,3	duplicate(ChangeEnrich)	エンリッヒ	84
