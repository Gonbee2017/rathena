// Card removal NPC by TyrNemesis^ 日本語訳：胡蝶蘭
prt_in,28,73,4	script	賢い老女	78,{
	mes "[賢い老女]";
	mes "いい天気だね、若いの。";
	mes "ところで、アタシは武具に装着している";
	mes "カードを取り外す力を持っているけど、";
	mes "力を貸そうかね？";
	next;
	if (select("お願いします", "必要ないです") == 1) {
		mes "[賢い老女]";
		mes "よしよし。";
		mes "どの武具のカードを取り外すんだね？";
		next;
		set .@part, 
			select(
				"やっぱりやめます",
				getequipname2(1),
				getequipname2(2),
				getequipname2(3),
				getequipname2(4),
				getequipname2(5),
				getequipname2(6),
				getequipname2(7),
				getequipname2(8),
				getequipname2(9),
				getequipname2(10)
			) - 1;
		if (.@part) {
			set .@count, getequipcardcnt(.@part);
			if(.@count <= 0) {
				mes "[賢い老女]";
				mes "若いの、カードがついてないよ。";
				mes "それじゃアタシの出番はないさ。";
				close;
			}
			mes "[賢い老女]";
			mes "おっと言い忘れるところだったね。";
			mes "この魔法はとても難しいから、";
			mes "^FF4040失敗するかもしれない^000000のさ。";
			mes "失敗したらカードか武具、あるいは";
			mes "その両方が^FF4040破壊されてしまう^000000かも";
			mes "しれないんだよ。";
			next;
			mes "[賢い老女]";
			mes "一応聞いて置くけど、比べるなら";
			mes "カードと武具のどっちが大切だい？";
			next;
			set .@failtype, select("それならやめます","武具の方が大切です","カードの方が大切です") - 1;
			if(.@failtype) {
				mes "[賢い老女]";
				mes "よし、始めるよ。";
				next;
				set .@rate, rand(100);
				if(.@rate <= 1) {
					failedremovecards .@part,0;
					mes "[賢い老女]";
					mes "残念だけど完全に失敗したよ。";
					mes "武具もカードも壊れてしまった。";
					close;
				}
				if(.@rate <= 1 + 2) {
					failedremovecards .@part, .@failtype;
					if(.@failtype == 1) {
						mes "[賢い老女]";
						mes "頑張ったけどね、";
						mes "カードのほうは全部壊れてしまったよ。";
						mes "でも武具の方は無事だったよ。";
					}
					else {
						mes "[賢い老女]";
						mes "不運だったね。";
						mes "カードを取り外すのはうまくいったけど";
						mes "武具が壊れてしまったよ。";
					}
					close;
				}
				if(.@rate <= 1 + 2 + 4) {
					failedremovecards .@part, 3;
					mes "[賢い老女]";
					mes "カードを取り外すのに失敗したよ。";
					mes "でも、不幸中の幸いさ。";
					mes "武具もカードも無事だよ。";
					close;
				}
				successremovecards .@part;
				mes "[賢い老女]";
				mes "うまくいったよ。";
				mes "これらが武具とアイテムさ。じゃあね。";
				close;
			}
		}
	}
	mes "[賢い老女]";
	mes "わかったよ。";
	mes "アタシの力が必要ならいつでも来な。";
	close;
}
