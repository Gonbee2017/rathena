prontera,147,153,6	script	ギルドマネージャー	109,{
	mes "[チェン]";
	mes "こちらでは冒険者ギルドの";
	mes "管理を行っております。";
	next;

	set .@gui_id, getcharid(2);
	if (.@gui_id) {
		set .@gui_mas_id, getguildmasterid(.@gui_id);
		if (.@gui_mas_id == getcharid(0)) {
			set .@gui_nam$, getguildname(.@gui_id);
			getguildmember(.@gui_id, 1);
			getguildmember(.@gui_id, 0);
			set .@gui_mem_siz, $@guildmembercount;
			copyarray .@gui_mem_id, $@guildmembercid, .@gui_mem_siz;
			copyarray .@gui_mem_nam$, $@guildmembername$, .@gui_mem_siz;
		}
	}
	if (!.@gui_id ||
		.@gui_mas_id != getcharid(0)
	) {
		mes "[チェン]";
		mes "本サービスはギルドマスターの";
		mes "方のみがご利用になれます。";
		close;
	}
	
	mes "[チェン]";
	mes "[ ^4040FF" + .@gui_nam$ + "^000000 ]の";
	mes "ギルドマスターを他のメンバーに";
	mes "変更なさいますか？";
	next;
	if (select("はい", "いいえ") == 1) {
		mes "[チェン]";
		mes "それではこちらのリストから";
		mes "新しくギルドマスターにする";
		mes "メンバーをお選びください。";
		next;
		for (set .@i, 0; .@i < .@gui_mem_siz; ++.@i) {
			if (.@gui_mem_id[.@i] != .@gui_mas_id) {
				set .@mem_ids[getarraysize(.@mem_ids)], .@gui_mem_id[.@i];
				set .@mem_lis$[getarraysize(.@mem_lis$)], .@gui_mem_nam$[.@i];
			}
		}
		set .@mem_lis$[getarraysize(.@mem_lis$)], "やめる";
		set .@mem_ind, select(printarray(.@mem_lis$)) - 1;
		if (.@mem_ind < getarraysize(.@mem_ids)) {
			set .@new_mas_id, .@mem_ids[.@mem_ind];
			set .@new_mas_nam$, .@mem_lis$[.@mem_ind];
			if (guildchangegm2(.@gui_id, .@new_mas_id)) {
				mes "[チェン]";
				mes "[ ^4040FF" + .@gui_nam$ + "^000000 ]の";
				mes "ギルドマスターを";
				mes "[ ^4040FF" + .@new_mas_nam$ + "^000000 ]様に";
				mes "変更しました。";
				mes "それでは失礼いたします。";
				close;
			}
		}
	}
	mes "[チェン]";
	mes "いつでもお申しつけください。";
	close;
}
