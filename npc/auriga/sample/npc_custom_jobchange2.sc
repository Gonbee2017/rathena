prontera,150,193,5	script	2次転職係	125,{
	mes "[ジェブ]";
	mes "こちらでは2次職への転職を";
	mes "行っております。";
	next;
	mes "[ジェブ]";
	mes "条件を満たした1次職のかたは";
	mes "どなたでも転職が可能です。";
	next;
	if (JobLevel >= 40 &&
		!SkillPoint
	) {
		set .@jobs_siz, getarraysize(.jobs) / 3;
		for (set .@i, 0; .@i < .@jobs_siz; ++.@i) {
			set .@job_os, .@i * 3;
			if (Job == .jobs[.@job_os])
				set .@che_jobs[getarraysize(.@che_jobs)], .jobs[.@job_os + 1 + Sex];
		}
	}
	if (getarraysize(.@che_jobs)) {
		mes "[ジェブ]";
		mes "転職のために料金やアイテムなどは";
		mes "一切いただきません。";
		next;
		mes "[ジェブ]";
		mes "ただし……1つだけ条件があります。";
		next;
		mes "[ジェブ]";
		mes "それはリセットサービスの料金が";
		mes "^FF0000永久に2倍^000000になるというものです。";
		next;
		mes "[ジェブ]";
		mes "転職すれば^FF0000もう元には戻せません^000000ので";
		mes "よくお考えになってお答えください。";
		next;
		mes "[ジェブ]";
		mes "……どうなさいますか？";
		next;
		for (set .@i, 0; .@i < getarraysize(.@che_jobs); ++.@i)
			set .@che_lis$[.@i], "^4040FF" + jobname(.@che_jobs[.@i]) + "^000000に転職する";
		set .@che_lis$[getarraysize(.@che_lis$)], "やめる";
		set .@che_ind, select(printarray(.@che_lis$)) - 1;
		if (.@che_ind < getarraysize(.@che_jobs)) {
			mes "[ジェブ]";
			mes "本当に^4040FF" + jobname(.@che_jobs[.@che_ind]) + "^000000に";
			mes "転職なさいますか？";
			next;
			if (select("はい", "いいえ") == 1) {
				// アトミック
				set RESET_FEE_RATE, 2;
				nude;
				jobchange .@che_jobs[.@che_ind];
				
				mes "[ジェブ]";
				mes "さぁ、転職できましたよ。";
				mes "ご健闘をお祈りします。";
				close;
			}
		}
		mes "[ジェブ]";
		mes "それも1つの選択です。";
		mes "頑張ってください。";
		close;
	}
	mes "[ジェブ]";
	mes "大変失礼ですが、現時点でお客様が";
	mes "このサービスをご利用になることは";
	mes "できません。";
	close;
OnInit:
	setarray .jobs,
		Job_Swordman, Job_Knight, Job_Knight,
		Job_Acolyte, Job_Priest, Job_Priest,
		Job_Magician, Job_Wizard, Job_Wizard,
		Job_Merchant, Job_Blacksmith, Job_Blacksmith,
		Job_Archer, Job_Hunter, Job_Hunter,
		Job_Thief, Job_Assassin, Job_Assassin,
		Job_Swordman, Job_Crusader, Job_Crusader,
		Job_Acolyte, Job_Monk, Job_Monk,
		Job_Magician, Job_Sage, Job_Sage,
		Job_Thief, Job_Rogue, Job_Rogue,
		Job_Merchant, Job_Alchemist, Job_Alchemist,
		Job_Archer, Job_Dancer, Job_Bard,
		Job_Taekwon, Job_Star, Job_Star,
		Job_Taekwon, Job_Linker, Job_Linker;
}
