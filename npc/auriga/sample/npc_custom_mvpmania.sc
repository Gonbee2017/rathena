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
			1917;
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
				mes "あなたも立派なMVPマニアだね。";
				mes "それじゃ、いつものやついくよ。";
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
			
			// アトミック
			if(gympassmemory >= 10 &&
				(checkitemblank() < 3 ||
					(MaxWeight - Weight) < .rews_wei
				)
			) {
				mes "[コレット]";
				mes "……って荷物が多すぎてお祝いを";
				mes "受け取れそうにないみたいだよ。";
				mes "少し倉庫に預けてからまた来てね。";
				close;
			}
			advancemvpround;
			if (++.@rou == 1) {
				for (; gympassmemory < 10; ++gympassmemory)
					skill "ALL_INCCARRY", gympassmemory, SKILL_PERM_GRANT;
			} else {
				for (set .@i, 0; .@i < getarraysize(.rews); ++.@i)
					getitem .rews[.@i], 1;
			}
			
			specialeffect2 EF_POK_JAP;
			emotion ET_CONGRATULATION;
			soundeffect "complete.wav", 0;
			announce "[" + strcharinfo(0) + "]さんが" + .@rou + "回目のオールMVPを達成しました。", 0;
			mes "[コレット]";
			mes "^FF4040オールMVP^000000、おめでとう！";
			mes "^4040FF" + strcharinfo(0) + "^000000さんの功績は";
			mes "バッチリ記録しとくからね！";
			next;
			if (.@rou == 1) {
				mes "[コレット]";
				mes "これで全部獲得したわけだけど";
				mes "まだ終わりじゃないよ。";
				next;
				mes "[コレット]";
				mes "MVPが好きで好きでたまらない";
				mes "そんな冒険者さんならきっと";
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
			mes "リストをクリアしとこっか。";
			next;
			if (.@rou == 1) {
				mes "[コレット]";
				mes "あと私から今回のお祝いに";
				mes "^4040FF" + strcharinfo(0) + "^000000さんが持てる";
				mes "アイテムの重量を増やしとくよ。";
				next;
				emotion ET_SMILE;
				mes "[コレット]";
				mes "アイテムはいっぱい持てたほうが";
				mes "絶対うれしいよねー。";
				next;
			} else {
				mes "[コレット]";
				mes "あと私から今回のお祝いに";
				mes "装備を^4040FF6個^000000プレゼントするよ。";
				next;
				emotion ET_SMILE;
				mes "[コレット]";
				mes "なんでもブルレム兄弟イチオシの";
				mes "神装備なんだってー。";
				next;
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
		 1191, // アルカブリンガー
		 1636, // 茨の杖
		13039, // アイボリーナイフ
		 1385, // ブラディウムハンマー
		 2450, // セフィロトシューズ
		 2481; // ルーンブーツ
	for (set .@i, 0; .@i < getarraysize(.rews); ++.@i)
		set .rews_wei, .rews_wei + getiteminfo(.rews[.@i], 6);
}
