prontera,64,55,4	script	変なタヌキ::PyBotDummyRaccoon	543,{
	mes "[ポン太]";
	mes "オイラはタヌキのポン太ってんだ。";
	mes "モンスターに化けるのがうまいんだぞ。";
	next;
	mes "[ポン太]";
	mes "なんでも好きなモンスターに";
	mes "^4040FF1分間だけ^000000化けてやるぞ？";
	mes "攻撃だってしていいぞ。";
	next;
	if (select("お願いする", "必要ないよ") == 1) {
		mes "[ポン太]";
		mes "イヨッ、そうこなくっちゃ。";
		mes "化けてほしいモンスターの名前は？";
		mes "なんでもこいだぞ。";
		next;
		input .@mob_nam$;
		set .@mob_id, findmobdb(.@mob_nam$);
		if (!.@mob_id) {
			mes "[ポン太]";
			mes "^4040FF" + .@mob_nam$ + "^000000だって？";
			mes "そんなモンスター知らないぞ。";
			close;
		}
		set .@mob_lv, strmobinfo(3, .@mob_id);
		set .@fee, 1000 * .@mob_lv;
		mes "[ポン太]";
		mes "^4040FF" + .@mob_nam$ + "^000000だな？";
		mes "お代は^FF4040" + .@fee + "Zeny^000000だぞ？";
		next;
		if (select("払う", "やめる") == 1) {
			if (Zeny < .@fee) {
				mes "[ポン太]";
				mes "お前……お金が足りないぞ？";
				mes "葉っぱ代もバカにならないんだぞ。";
				close;
			}
			mes "[ポン太]";
			mes "よーし、それじゃ化けるぞ。";
			close2;
			set Zeny, Zeny - .@fee;
			hideonnpc;
			dummymonster "this", 64, 55, "--ja--", .@mob_id, 1, "PyBotDummyRaccoon::OnDead";
			initnpctimer;
			end;
		}
	}
	mes "[ポン太]";
	mes "ちぇー、ケチなやつだぞ。";
	close;
OnDead:
	stopnpctimer;
	hideoffnpc;
	mes "[ポン太]";
	mes "アイタタタ……";
	mes "お前……やりすぎだぞ。";
	close;
OnTimer60000:
	stopnpctimer;
	killmonster "this", "PyBotDummyRaccoon::OnDead";
	hideoffnpc;
	end;
}
