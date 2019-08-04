prontera,267,48,1	script	MVPマニア::MVPMania	862,{
	if (!MVP_MANIA_INTRODUCTION) {
		mes "[コレット]";
		mes "MVPっていいよね……";
		next;
		mes "[コレット]";
		mes "あの^FF4040＊ＭＶＰ！＊^000000って";
		mes "エフェクトの出る瞬間が";
		mes "たまんないのよねぇ……";
		next;
		mes "[コレット]";
		mes "あなたもそう思うでしょ？";
		next;
		if (select("はい", "いいえ") == 1) {
			emotion ET_SPARK;
			mes "[コレット]";
			mes "やっぱそうだよねー！";
			mes "あなた、見込みあるかも。";
			next;
		} else {
			emotion ET_HUK;
			mes "[コレット]";
			mes "えぇー！？";
			mes "あの良さがわからないなんて";
			mes "絶対損してるよ！";
			next;
		}
		set MVP_MANIA_INTRODUCTION, 1;
		mes "[コレット]";
		mes "ま、それはおいといて……";
		next;
		mes "[コレット]";
		mes "初めまして、私コレット。";
		mes "MVPの記録係をやってるの。";
		next;
		mes "[コレット]";
		mes "今までに獲得したMVPを";
		mes "見たいときは私に言ってね。";
		mes "全部リストに記録してあるから。";
		next;
		mes "[コレット]";
		mes "早速見てみる？";
		next;
	} else {
		mes "[コレット]";
		mes "ごきげんよう、^4040FF" + strcharinfo(0) + "^000000さん。";
		mes "MVPリストを見たいのかな？";
		next;
	}
	querymvpstats .@rou, .@mobs;
	if (select("見る", "見ない") == 1) {
		setarray .@cols$, "^FF4040", "^4040FF";
		setarray .@vals$, "未獲得", "獲得済み";
		setarray .@mids, 
			1038, 1039, 1046, 1059, 1086,
			1087, 1112, 1115, 1147, 1150,
			1157, 1159, 1190, 1251, 1252,
			1272, 1312, 1373, 1389, 1418,
			1492, 1511, 1583, 1623, 1630,
			1646, 1647, 1648, 1649, 1650,
			1651, 1658, 1685, 1688, 1708,
			1719, 1734, 1751, 1768, 1779,
			1785, 1832, 1871, 1874, 1885,
			1917, 2068;
		set .@mids_siz, getarraysize(.@mids);
		for (set .@i, 0; .@i < .@mids_siz; ++.@i) {
			if (!.@ind) mes "------ MVPリスト (" + (.@i / 5 + 1) + ") ------"; 
			set .@acq, pchasacquiredmvp(.@mids[.@i]);
			if (!.@acq) set .@not_all, 1;
			mes .@cols$[.@acq] + strmobinfo(2, .@mids[.@i]) + " " + .@vals$[.@acq] + "^000000";
			set .@ind, .@ind + 1;
			if (.@ind >= 5 ||
				.@i + 1 == .@mids_siz
			) {
				next;
				set .@ind, 0;
			}
		}
		if (!.@not_all) {
			if (.@rou) {
				mes "[コレット]";
				mes "えっ、また全部倒したの？！";
				mes "さすが～、もう楽勝じゃん♪";
				next;
				emotion ET_SMILE;
				mes "[コレット]";
				mes "こんなにMVPを獲得するなんて";
				mes "あなたも立派なMVPマニアだね。";
				next;
			} else {
				mes "[コレット]";
				mes "わっ、すごーい！";
				mes "全部獲得してるじゃん！";
				next;
				emotion ET_THROB;
				mes "[コレット]";
				mes "あなたとっても強かったのね。";
				mes "ちょっと見直しちゃった……";
				next;
			}
			
			set .@pla_rid, getcharid(3);
			mes "[コレット]";
			mes "今回の^4040FFオールMVP^000000達成の報酬として";
			mes "メンバーのうちの誰か^FF40401人だけ^000000を";
			mes "^4040FF強化^000000することができるよ。";
			next;
			mes "[コレット]";
			mes "メンバーの^4040FF強化^000000を行うと";
			mes "まずステータスポイントを";
			mes "^FF4040200ポイント^000000貰えるよ。";
			mes "一気にパワーアップだね。";
			next;
			mes "[コレット]";
			mes "さらにスキルポイントを";
			mes "^FF404010ポイント^000000も貰えちゃう。";
			mes "これで足りなかったスキルを";
			mes "ゲットできるかも？";
			next;
			set .@mem_siz, getmemberlist(.@mem_rids, .@mem_cids, .@mem_nams$, .@mem_clas);
			for (set .@i, 0; .@i < .@mem_siz; ++.@i)
				set .@mem_lis$[.@i], "^4040FF" + .@mem_nams$[.@i] + "^000000";
			set .@mem_lis$[.@i], "やめる";
			while (1) {
				mes "[コレット]";
				mes "^4040FF強化^000000はとても大事なことだから";
				mes "よく考えて慎重に選んでね。";
				mes "どのメンバーを^4040FF強化^000000するの？";
				next;
				set .@mem_ind, select(printarray(.@mem_lis$)) - 1;
				if (.@mem_ind >= .@mem_siz) {
					mes "[コレット]";
					mes "じっくり考えたほうがいいよ。";
					mes "決まったらまた声をかけてね。";
					close;
				}
				if (attachrid(.@mem_rids[.@mem_ind])) {
					set .@mem_enh, MVP_MANIA_ENHANCE;
					attachrid .@pla_rid;
					set .@mem_cla, .@mem_clas[.@mem_ind];
					if (.@mem_enh) {
						mes "[コレット]";
						mes "^4040FF" + .@mem_nams$[.@mem_ind] + "^000000さんは";
						mes "もう^FF4040強化済み^000000だからダメだよ。";
						next;
					} else if (!canenhance(.@mem_cla)) {
						mes "[コレット]";
						mes "^4040FF" + .@mem_nams$[.@mem_ind] + "^000000さんは";
						mes "^FF4040強化できない職業^000000だからダメだよ。";
						next;
					} else {
						mes "[コレット]";
						mes "本当に^4040FF" + .@mem_nams$[.@mem_ind] + "^000000さんを";
						mes "^4040FF強化^000000していいの？";
						next;
						if (select("はい", "いいえ") == 1) break;
					}
				}
			}
			
			// アトミック
			if(checkitemblank() < 6 ||
				(MaxWeight - Weight) < .rews_wei
			) {
				mes "[コレット]";
				mes "……って荷物が多すぎてお祝いを";
				mes "受け取れそうにないみたいだよ。";
				mes "少し倉庫に預けてきてね。";
				close;
			}
			if (attachrid(.@mem_rids[.@mem_ind])) {
				if (!MVP_MANIA_ENHANCE) {
					set MVP_MANIA_ENHANCE, 1;
					addstatuspoint 200;
					addskillpoint 10;
					attachrid .@pla_rid;
					advancemvpround;
					++.@rou;
					for (set .@i, 0; .@i < getarraysize(.rews); ++.@i)
						getitem .rews[.@i], 1;
					
					specialeffect2 EF_POK_JAP;
					emotion ET_CONGRATULATION;
					soundeffect "complete.wav", 0;
					announce "[ " + strcharinfo(0) + " ]さんが" + .@rou + "回目のオールMVPを達成しました。", 0;
					mes "[コレット]";
					mes "^4040FFオールMVP^000000、おめでとう！";
					mes "^4040FF" + strcharinfo(0) + "^000000さんの功績は";
					mes "バッチリ記録しとくからね！";
					next;
					if (.@rou == 1) {
						mes "[コレット]";
						mes "これで全部獲得したわけだけど";
						mes "まだ終わりじゃないよ。";
						next;
						mes "[コレット]";
						mes "MVPが好きで好きでたまらない。";
						mes "そんなあなたならきっと";
						mes "1周じゃ物足りないはず……";
						next;
						mes "[コレット]";
						mes "というわけで、お望みなら";
						mes "何周でもできちゃいます。";
						next;
						emotion ET_SMILE;
						mes "[コレット]";
						mes "MVPマニアの道はどこまでも";
						mes "果てしなく続いていくのよ！";
						mes "なーんてね、ウフフッ♪";
						next;
					}
					mes "[コレット]";
					mes "とりあえず次の周回に向けて";
					mes "リストはクリアしておくね。";
					next;
					mes "[コレット]";
					mes "あと私から今回のお祝いに";
					mes "アイテムを^FF4040" + getarraysize(.rews) + "個^000000プレゼントするよ。";
					next;
					emotion ET_SMILE;
					mes "[コレット]";
					mes "なんでも冒険者なら誰もがよだれを";
					mes "垂らす神装備なんだって。";
					mes "よかったら使ってね。";
					next;
				} else attachrid .@pla_rid;
			}
		}
	}
	emotion ET_WRAP;
	mes "[コレット]";
	if (.@rou) mes "それじゃ、^4040FF" + (.@rou + 1) + "周目^000000も頑張ってね。";
	else mes "それじゃ、頑張ってね。";
	mes "バイバーイ！";
	close;
OnInit:
	setarray .rews,
		 2881, // オルレアンネックレス
		 5389, // 女神の仮面
		18539, // スカルキャップ
		18720, // マジカルブースター
		18937; // メモリーオブラバーズ
	for (set .@i, 0; .@i < getarraysize(.rews); ++.@i)
		set .rews_wei, .rews_wei + getiteminfo(.rews[.@i], 6);
}
