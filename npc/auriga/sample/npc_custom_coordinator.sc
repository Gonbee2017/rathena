prontera,164,153,2	script	シニアコーディネーター	878,{
	mes "[シニアコーディネーター]";
	mes "こんにちは、僕はエレミヤだ。";
	mes "希望のカラーを教えてくれれば";
	mes "その色で服を染めてあげるよ。";
	mes "カラーは1～" + .max_col + "番まであるぞ。";
	next;
	input .@col;
	if (!.@col) {
		mes "[エレミヤ]";
		mes "そうかい？";
		mes "また興味が湧いたら来てくれよ。";
		close;
	}
	if (.@col < 1 ||
		.@col > .max_col
	) {
		mes "[エレミヤ]";
		mes "おや？";
		mes "1～" + .max_col + "の番号を入力してくれないか？";
		close;
	}
	setlook LOOK_CLOTHES_COLOR, .@col;
	mes "[エレミヤ]";
	mes "さあ、できたよ。";
	mes "うん、よく似合ってる。";
	mes "気分を変えたくなったら";
	mes "是非また利用してくれ。";
	close;
OnInit:
	set .max_col, 35;
}
