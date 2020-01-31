prontera,164,153,2	script	服装染色師	97,{
	mes "[服装染色師]";
	mes "こんにちは！";
	mes "私は皆様に個性的なスタイルを";
	mes "提供すべく、皆様のお召し物を";
	mes "美しく染色させて頂く為に参りました！";
	next;
	if (select("染色する", "やめる") == 1) {
		mes "[服装染色師]";
		mes "どの番号を希望されますか？";
		mes "以下のイメージカラーの中から";
		mes "お好みの色をお選びください。";
		next;
		set .@col, select(printarray(.col_lis$));
		if(.@col < getarraysize(.col_lis$)) {
			mes "[服装染色師]";
			mes "かしこまりました。";
			mes "それでは早速染色準備にかかります！";
			mes "エイッ！";
			next;
			mes "[服装染色師]";
			mes "完成です！";
			mes "どうです？　綺麗でしょう？";
			mes "早く皆に見せびらかしたくて";
			mes "仕方ないんじゃないですか？";
			setlook LOOK_CLOTHES_COLOR, .@col;
			close;
		}
	}
	mes "[服装染色師]";
	mes "そうですか……";
	mes "またの機会をお待ちしております。";
	close;
OnInit:
	set .col_lis$[getarraysize(.col_lis$)], "1(デフォルト)";
	set .col_lis$[getarraysize(.col_lis$)], "2(エクストラ1)";
	set .col_lis$[getarraysize(.col_lis$)], "3(エクストラ2)";
	set .col_lis$[getarraysize(.col_lis$)], "4^E3E3E3●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "5^CECCE0●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "6^D0D6F2●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "7^C2D8AF●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "8^CFEDED●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "9^BCD9F2●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "10^D0F3D0●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "11^DDB9AB●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "12^BBF7F7●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "13^ECCAC6●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "14^FFC4E2●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "15^CCE3FF●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "16^FFE2C4●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "17^D0ADA0●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "18^D6B8C7●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "19^FFF0C2●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "20^EFECCE●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "21^E5E2E2●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "22^FABBAB●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "23^FBB09B●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "24^FFBBD3●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "25^FBC58B●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "26^FFE1CF●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "27^EFC2DE●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "28^FFDEAC●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "29^FFE1B6●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "30^E3C4EC●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "31^EBC4A8●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "32^F9B0AC●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "33^FAE9BC●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "34^DEE6AB●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "35^EEDFD7●^000000";
	set .col_lis$[getarraysize(.col_lis$)], "やめる";
}
