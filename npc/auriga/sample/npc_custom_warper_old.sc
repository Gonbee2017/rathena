prontera,161,193,4	script	飛行機乗り	869,{
	mes "[ソニック]";
	mes "どんなに離れた場所でも";
	mes "俺のソニックイーグル号に";
	mes "かかればひとっ飛びさ。";
	mes "どこか行きたいところはあるかい？";
	next;
	for (set .@i, 0; .@i < getarraysize(.des_maps$); ++.@i)
		set .@des_lis$[.@i], getmapnamejapanese(.des_maps$[.@i]);
	set .@des_lis$[getarraysize(.@des_lis$)], "やめる";
	set .@des_ind, select(printarray(.@des_lis$)) - 1;
	if (.@des_ind < getarraysize(.des_maps$)) {
		set .@des_map$, .des_maps$[.@des_ind];
		set .@des_x, .des_xy_fees[.@des_ind * 3 + 0];
		set .@des_y, .des_xy_fees[.@des_ind * 3 + 1];
		set .@des_fee, .des_xy_fees[.@des_ind * 3 + 2];
		mes "[ソニック]";
		mes "^4040FF" + .@des_lis$[.@des_ind] + "^000000か……";
		if ((.@des_map$ == "gefenia01" &&
				countitem(7025)
			) || (.@des_map$ == "kh_dun01" &&
				countitem(7509)
			) || (.@des_map$ == "kh_dun02" &&
				countitem(7509)
			) || (.@des_map$ == "lhz_dun01" &&
				countitem(2657)
			) || (.@des_map$ == "abbey01" &&
				NAME_1QUE >= 20
			) || (.@des_map$ == "ra_san02" &&
				RA_2QUE >= 10
			) || (.@des_map$ == "ama_dun01" &&
				countitem(7160)
			) || (.@des_map$ == "mosk_dun01" &&
				MOSK_1QUE >= 39
			) || (.@des_map$ == "bra_dun01" &&
				BRA_3QUE >= 8
			)
		) set .@des_fee, 0;
		if (.@des_fee) mes "そこなら料金は^4040FF" + .@des_fee + "^000000Zenyだね。";
		else mes "あんたなら^4040FFタダ^000000でいいぜ。";
		next;
		if (select("お願いします", "やめときます") == 1) {
			if (Zeny < .@des_fee) {
				mes "[ソニック]";
				mes "おっと所持金が足りてないぜ。";
				mes "また今度来てくれよな。";
				close;
			}
			emotion ET_DELIGHT;
			mes "[ソニック]";
			if (.@des_fee) mes "毎度ありー。";
			mes "さぁ、乗った乗った！";
			mes "大空に向かってテイクオフだ。";
			close2;
			set Zeny, Zeny - .@des_fee;
			warp .@des_map$, .@des_x, .@des_y;
			end;
		}
	}
	mes "[ソニック]";
	mes "いつでもどうぞ。";
	close;
OnInit:
	setarray .des_maps$[getarraysize(.des_maps$)], "einbroch";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 64,204, 30000;
	setarray .des_maps$[getarraysize(.des_maps$)], "lighthalzen";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 262,75, 30000;
	setarray .des_maps$[getarraysize(.des_maps$)], "hugel";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 181,146, 30000;
	setarray .des_maps$[getarraysize(.des_maps$)], "ra_fild12";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 292,204, 30000;
	
	setarray .des_maps$[getarraysize(.des_maps$)], "anthell01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 35,263, 10000;
	setarray .des_maps$[getarraysize(.des_maps$)], "beach_dun";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 266,67, 20000;
	setarray .des_maps$[getarraysize(.des_maps$)], "c_tower1";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 199,159, 10000;
	setarray .des_maps$[getarraysize(.des_maps$)], "gef_dun00";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 104,99, 10000;
	setarray .des_maps$[getarraysize(.des_maps$)], "gefenia01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 58,169, 2000000;
	setarray .des_maps$[getarraysize(.des_maps$)], "glast_01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 376,304, 20000;
	setarray .des_maps$[getarraysize(.des_maps$)], "in_sphinx1";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 288,9, 10000;
	setarray .des_maps$[getarraysize(.des_maps$)], "iz_dun00";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 168,168, 10000;
	setarray .des_maps$[getarraysize(.des_maps$)], "mjo_dun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 52,17, 20000;
	setarray .des_maps$[getarraysize(.des_maps$)], "moc_pryd01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 192,9, 10000;
	setarray .des_maps$[getarraysize(.des_maps$)], "orcsdun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 32,170, 10000;
	setarray .des_maps$[getarraysize(.des_maps$)], "pay_dun00";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 21,183, 10000;
	setarray .des_maps$[getarraysize(.des_maps$)], "prt_maze01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 99,31, 10000;
	setarray .des_maps$[getarraysize(.des_maps$)], "prt_sewb1";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 131,247, 10000;
	setarray .des_maps$[getarraysize(.des_maps$)], "treasure01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 69,24, 20000;
	setarray .des_maps$[getarraysize(.des_maps$)], "um_dun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 42,30, 30000;
	setarray .des_maps$[getarraysize(.des_maps$)], "niflheim";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 23,154, 50000;
	setarray .des_maps$[getarraysize(.des_maps$)], "xmas_dun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 205,16, 20000;
	setarray .des_maps$[getarraysize(.des_maps$)], "abyss_01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 260,268, 100000;
	setarray .des_maps$[getarraysize(.des_maps$)], "ein_dun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 22,14, 50000;
	setarray .des_maps$[getarraysize(.des_maps$)], "juperos_01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 55,246, 100000;
	setarray .des_maps$[getarraysize(.des_maps$)], "kh_dun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 3,230, 1000000;
	setarray .des_maps$[getarraysize(.des_maps$)], "kh_dun02";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 41,198, 2000000;
	setarray .des_maps$[getarraysize(.des_maps$)], "lhz_dun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 149,285, 500000;
	setarray .des_maps$[getarraysize(.des_maps$)], "mag_dun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 126,69, 50000;
	setarray .des_maps$[getarraysize(.des_maps$)], "odin_tem01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 100,146, 50000;
	setarray .des_maps$[getarraysize(.des_maps$)], "tha_t01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 149,38, 100000;
	setarray .des_maps$[getarraysize(.des_maps$)], "abbey01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 51,15, 2000000;
	setarray .des_maps$[getarraysize(.des_maps$)], "ice_dun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 157,15, 100000;
	setarray .des_maps$[getarraysize(.des_maps$)], "ra_san02";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 213,275, 5000000;
	setarray .des_maps$[getarraysize(.des_maps$)], "thor_v01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 21,229, 200000;
	setarray .des_maps$[getarraysize(.des_maps$)], "ama_dun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 229,10, 200000;
	setarray .des_maps$[getarraysize(.des_maps$)], "ayo_dun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 275,18, 100000;
	setarray .des_maps$[getarraysize(.des_maps$)], "gon_dun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 153,48, 100000;
	setarray .des_maps$[getarraysize(.des_maps$)], "lou_dun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 218,195, 100000;
	setarray .des_maps$[getarraysize(.des_maps$)], "mosk_dun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 201,269, 1000000;
	setarray .des_maps$[getarraysize(.des_maps$)], "tur_dun02";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 148,264, 100000;
	setarray .des_maps$[getarraysize(.des_maps$)], "bra_dun01";
	setarray .des_xy_fees[getarraysize(.des_xy_fees)], 87,47, 500000;
}
