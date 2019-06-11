//====================================================================
//Ragnarok Online Priest Jobchange Script
//
//@¡ CHANGE_PR     -> 0`9
//     @priest_check -> 0`8A‘Þ–‚C—û‚ÌŽO’iŠK–Ú—pƒtƒ‰ƒO
//====================================================================

//==========================================
// ŽŽŒ±Žó•t‚¨‚æ‚Ñ“]E
//------------------------------------------

prt_church,16,41,4	script	Ži‹³	60,{
	if(Upper == UPPER_HIGH) {
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "¶‚Ü‚ê•Ï‚í‚èAV‚½‚Èl¶‚ð";
		mes "•à‚Þ•û‚Å‚·‚ËH";
		mes "ƒvƒƒ“ƒeƒ‰‘å¹“°‚à";
		mes "‹M•û‚ÌŠˆ–ô‚ðŒ©Žç‚Á‚Ä‚¢‚Ü‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "¢‚É–ž‚¿ˆì‚ê‚éŽŽ—û‚ð‹°‚ê‚¸‚ÉB";
		mes "‹M•û‚É‚Í‚»‚ê‚É‘Å‚¿Ž‚Â—E‹C‚Æ";
		mes "—Í‚ª‚ ‚è‚Ü‚·B";
		mes "‹M•û‚É_‚Ì‚²‰ÁŒì‚ ‚ç‚ñ‚±‚Æ‚ðcc";
		close;
	}
	if(Job == Job_Novice) {
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚ç‚ñ‚±‚Æ‚ðc";
		mes "‚±‚¿‚ç‚Íƒvƒƒ“ƒeƒ‰‘å¹“°‚Å‚·B";
		mes "‰½‚Ì‚²—p‚Å–K‚Ë‚È‚³‚Á‚½H";
		next;
		switch (select("ƒAƒRƒ‰ƒCƒg‚É“]E‚µ‚½‚¢‚ñ‚Å‚·","ƒvƒŠ[ƒXƒg‚É“]E‚µ‚½‚¢‚ñ‚Å‚·","Œ©•¨‚É—ˆ‚½‚ñ‚Å‚·")) {
		case 1:
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚Ù‚ÙcƒAƒRƒ‰ƒCƒg‚Ö‚Ì“]E‚ð‚µ‚É";
			mes "—ˆ‚È‚·‚Á‚½‚©B";
			mes "ƒAƒRƒ‰ƒCƒg‚Ö‚Ì“]E‚Í”½‘Î‘¤‚Ì•”‰®‚É";
			mes "‚¨s‚«‚È‚³‚¢cB";
			break;
		case 2:
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚Ù‚ÙcƒvƒŠ[ƒXƒg‚É‚È‚é‘O‚É";
			mes "‚Ü‚¸ƒAƒRƒ‰ƒCƒg‚É‚È‚è‚È‚³‚¢B";
			mes "ƒAƒRƒ‰ƒCƒg‚Ö‚Ì“]E‚Í”½‘Î‘¤‚Ì•”‰®‚É";
			mes "‚¨s‚«‚È‚³‚¢cB";
			break;
		case 3:
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‰Æ‚Ì‚æ‚¤‚ÉŽv‚Á‚ÄŠy‚É‚µ‚È‚³‚¢B";
			mes "¹“°‚Í‚±‚Ì¢‚Ì‚Ç‚±‚æ‚è‚à";
			mes "ˆÀ‘S‚Å‚·‚©‚ç‚ÈB";
			break;
		}
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚ç‚ñ‚±‚Æ‚ðB";
		close;
	}
	if(Job == Job_Priest) {
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "M‹ÂŒú‚«ŒZ’í‚É";
		mes "_‚Ì‚²‰ÁŒì‚ ‚ç‚ñ‚±‚Æ‚ðc";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "_‚Ì‹³‚¦‚ðŽç‚ès‚¢‚ð³‚µ‚Ä";
		mes "‚¢‚é‚æ‚¤‚Å‚·‚ËB";
		mes "¡“ú‚Í‚Ç‚ñ‚ÈŒä—p‚Å‚±‚¿‚ç‚Ö";
		mes "•‹‚¢‚½‚Ì‚Å‚·H";
		next;
		switch (select("‹ß‚­‚É—ˆ‚½‚Â‚¢‚Å‚É—lŽq‚ðŽf‚¢‚É","Ž„‚ª˜A‚ê‚éƒAƒRƒ‰ƒCƒg‚ð•‚¯‚æ‚¤‚Æ","Å‹ß¶‚«‚Ä‚¢‚­‚Ì‚ª‘å•Ï‚Å")) {
		case 1:
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚Ù‚ÙA‚»‚¤‚Å‚µ‚½‚©B";
			mes "Ž„‚Í‘Š•Ï‚í‚ç‚¸Œ³‹C‚Å‚·B";
			mes "‘¼‚ÌŒZ’í’B‚É‚à“`‚¦‚Ä‚â‚Á‚Ä‚­‚¾‚³‚¢B";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "Ž„’BƒvƒŠ[ƒXƒg‚ÍA_‚Ì‘ã•ÙŽÒ‚Æ‚µ‚Ä";
			mes "‚±‚Ì’n‚ÉÝ‚é‚Ì‚Å‚·B";
			mes "¢‚Á‚½l‚É‚Í‹~‚¢‚ÌŽè‚ð‚³‚µ‚Ì‚×‚Ä";
			mes "‚ ‚°‚é‚æ‚¤‚ÉcB";
			close;
		case 2:
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚»‚¤‚Å‚·‚©A—Ç‚¢l‚¦‚Å‚·B";
			mes "‘¼‚ÌƒAƒRƒ‰ƒCƒg‚ð—Ç‚«“¹‚É“±‚­‚±‚Æ‚à";
			mes "ƒvƒŠ[ƒXƒg‚Ì‘åØ‚È–ð–Ú‚Å‚·‚©‚ç‚ËB";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚½‚¾A‘S‚Ä‚ðŽè“`‚¤‚±‚Æ‚Í‚Å‚«‚Ü‚¹‚ñB";
			mes "ƒAƒRƒ‰ƒCƒg‚Æ‚µ‚Ä‚Ç‚¤‚µ‚Ä‚àŽó‚¯‚È";
			mes "‚¯‚ê‚Î‚È‚ç‚È‚¢ŽŽ—û‚à‚ ‚è‚Ü‚·‚©‚ç‚ËB";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "“ñ‚Â–Ú‚ÌŽŽ—û‚Å‚ ‚éu‘Þ–‚C—ûv";
			mes "‚ÍŽè“`‚Á‚Ä‚ ‚°‚ç‚ê‚é‚Å‚µ‚å‚¤B";
			mes "‚ ‚È‚½‚àˆê‚És‚­‚½‚ß‚É‚Í";
			mes "^3051FDƒƒUƒŠ[^000000‚ª•K—v‚Å‚·B";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "ƒAƒRƒ‰ƒCƒg‚Ì‘Þ–‚C—û‚ðŽè“`‚¢‚Ü‚·‚©H";
			next;
			if(select("‚Í‚¢AŽè“`‚¢‚Ü‚·","‚Ü‚½Œã‚Å—ˆ‚Ü‚·")==2) {
				mes "[ƒg[ƒ}ƒXŽi‹³]";
				mes "‚Í‚¢A‚ä‚Á‚­‚è€”õ‚ð®‚¦‚Ä‚­‚¾‚³‚¢B";
				mes "^3051FDƒƒUƒŠ[^000000‚ð•K‚¸g‚É‚Â‚¯‚Ä";
				mes "—ˆ‚Ä‚­‚¾‚³‚¢‚ËB";
				close;
			}
			if(countitem(2608)<1) {
				mes "[ƒg[ƒ}ƒXŽi‹³]";
				mes "‚¤‚ñc^3051FDƒƒUƒŠ[^000000‚ð‚¨Ž‚¿‚Å‚È‚¢‚©B";
				next;
				mes "[ƒg[ƒ}ƒXŽi‹³]";
				mes "C—ûê‚É“ü‚è‚½‚©‚Á‚½‚ç";
				mes "^3051FDƒƒUƒŠ[^000000‚ðg‚É‚Â‚¯‚Ä‚©‚ç";
				mes "‚¢‚ç‚µ‚Ä‚­‚¾‚³‚¢B";
				close;
			}
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚»‚ê‚Å‚ÍAƒAƒRƒ‰ƒCƒg‚ÌC—û’n‚Ö";
			mes "‘—‚Á‚Ä‚ ‚°‚Ü‚·B";
			mes "ƒs[ƒ^[C“¹Žm‚É‚æ‚ë‚µ‚­";
			mes "‚¨“`‚¦‚­‚¾‚³‚¢B";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "—Ç‚¢ƒvƒŠ[ƒXƒg‚É‚È‚ê‚é‚æ‚¤‚É";
			mes "‚æ‚­“±‚¢‚Ä‚ ‚°‚Ä‚­‚¾‚³‚¢‚ËB";
			close2;
			warp "job_prist",24,180;
			end;
		case 3:
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "—Í‚ðo‚·‚Ì‚Å‚·B‚ ‚È‚½‚Í_‚Ì";
			mes "‚²‰ÁŒì‚ðŽó‚¯‚éŽq‚È‚Ì‚Å‚·‚©‚çc";
			mes "Ž„‚ª‚ ‚È‚½‚Ì‚Â‚¢‚½g‚ÆS‚ð";
			mes "–ü‚µ‚Ü‚µ‚å‚¤B";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "_‚æc‰ä‚ç‚ðŒ©Žç‚èA•‚¯‚½‚Ü‚¦c";
			mes "‹ê“ï‚Æ‹t‹«‚É‘Î‚µ‚½ŽžA‰ä‚ç‚Ì‹F‚è";
			mes "‚ª“Í‚©‚ñ‚±‚Æ‚ðc";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚±‚±‚É‚ ‚È‚½‚ÌŽq‚ª‹ê‚µ‚ñ‚Å‚¨‚è‚Ü‚·c";
			mes "‚Ç‚¤‚©‚±‚ÌŽq‚Ì”æ•¾‚µ‚½S‚ð‚ ‚È‚½‚Ì";
			mes "‰·‚©‚¢S‚Å•ï‚ñ‚Å‚ ‚°‚Ä‚­‚¾‚³‚¢c";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "­‚µ—Ç‚­‚È‚Á‚½‚Í‚¸‚Å‚·B";
			mes "‚±‚ê‚©‚ç‚à‹F‚é‚±‚Æ‚ð–Y‚ê‚¸‚Éc";
			mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ ‚ç‚ñ‚±‚Æ‚ðc";
			close;
		}
	}
	if(Job != Job_Acolyte) {
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚ç‚ñ‚±‚Æ‚ðB";
		mes "‚±‚¿‚ç‚Íƒvƒƒ“ƒeƒ‰‘å¹“°‚Å‚·B";
		mes "‰½‚Ì‚²—p‚Å–K‚Ë‚È‚³‚Á‚½H";
		next;
		if(select("ƒvƒŠ[ƒXƒg‚É‚Â‚¢‚Ä‹³‚¦‚Ä‚­‚¾‚³‚¢","Œ©•¨‚É—ˆ‚½‚ñ‚Å‚·")==2) {
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‰Æ‚Ì‚æ‚¤‚ÉŽv‚Á‚ÄŠy‚É‚µ‚È‚³‚¢B";
			mes "¹“°‚Í‚±‚Ì¢‚Ì‚Ç‚±‚æ‚è‚à";
			mes "ˆÀ‘S‚Å‚·‚©‚ç‚ÈB";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚»‚ê‚Å‚ÍA‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì";
			mes "‚ ‚ç‚ñ‚±‚Æ‚ðc";
			close;
		}
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "ƒvƒŠ[ƒXƒg‚ÍA_‚Ì‘ã—‚Æ‚µ‚Ä";
		mes "_‚ÌˆÓŽv‚ðŒ»¢‚É“`‚¦‚éŽÒ‚Å‚·B";
		mes "ƒAƒRƒ‰ƒCƒg‚É‚È‚èA‘½‚­‚ÌCs‚ð";
		mes "Ï‚ñ‚¾ŽÒ‚É‚Ì‚Ý‚»‚ÌŽ‘Ši‚ª";
		mes "—^‚¦‚ç‚ê‚é‚Ì‚Å‚·c";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "ƒAƒRƒ‰ƒCƒg‚ÌJobLv‚ª40ˆÈã‚È‚çA";
		mes "‚¢‚­‚Â‚©‚ÌŽŽ—û‚ðŽó‚¯AƒvƒŠ[ƒXƒg‚É";
		mes "‚È‚é‚±‚Æ‚ª‚Å‚«‚é‚Å‚µ‚å‚¤B";
		mes "ˆ«–‚‚ÆƒAƒ“ƒfƒbƒh‚É‘Î‚·‚é—Í‚ª‹­‚Ü‚èA";
		mes "•â•ƒXƒLƒ‹‚à‘‚¦‚é‚Å‚µ‚å‚¤cB";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚»‚µ‚ÄAŠXEƒtƒB[ƒ‹ƒhEƒ_ƒ“ƒWƒ‡ƒ“";
		mes "”@‰½‚È‚éêŠ‚É‚¨‚¢‚Ä‚àAd—v‚È";
		mes "–ðŠ„‚ð‚±‚È‚³‚È‚­‚Ä‚Í‚È‚è‚Ü‚¹‚ñB";
		mes "Ž„’BƒvƒŠ[ƒXƒg‚ÍAl‚És‚­‚µA";
		mes "l‚ð•‚¯‚é‚Ì‚ª—^‚¦‚ç‚ê‚½";
		mes "Žg–½‚¾‚©‚ç‚Å‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚µ‚©‚µA‘¼‚ÌƒvƒŠ[ƒXƒg‚É‰ï‚Á‚½ŽžA";
		mes "‚»‚ê‚ð‹­—v‚µ‚Ä‚Í‚È‚è‚Ü‚¹‚ñB";
		mes "‚ ‚­‚Ü‚Å‚»‚ê‚ÍŽ©”­“I‚Ès“®‚É‚æ‚Á‚Ä";
		mes "ˆÓ–¡‚ð¬‚·‚à‚Ì‚È‚Ì‚Å‚·‚©‚çcB";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "•‚¯‚É‚È‚éŽž‚Í•ñV‚ð–]‚ñ‚Å‚Í";
		mes "‚È‚è‚Ü‚¹‚ñ‚µA•‚¯‚ðŽó‚¯‚é‘¤‚à";
		mes "‚¢‚Â‚à—ç‹V‚ð³‚µŠ´ŽÓ‚Ì‹CŽ‚¿‚ð";
		mes "–Y‚ê‚Ä‚Í‚¢‚¯‚Ü‚¹‚ñB";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚±‚ê‚Åà–¾‚É‚È‚Á‚½‚©‚Í‚í‚©‚è‚Ü‚¹‚ñB";
		mes "’¼ÚƒvƒŠ[ƒXƒg‚½‚¿‚É‰ï‚Á‚Ä˜b‚µ‚ð";
		mes "•·‚¢‚Ä‚Ý‚é‚Ì‚à—Ç‚¢‚Å‚µ‚å‚¤B‚Ù‚Ù‚Ùc";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚»‚ê‚Å‚ÍA‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì";
		mes "‚ ‚ç‚ñ‚±‚Æ‚ðc";
		close;
	}
	switch(CHANGE_PR) {
	case 0:
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‰½‚Ì—p‚Å–K‚Ë‚Ä—ˆ‚½‚Ì‚Å‚·‚©H";
		next;
		if(select("ƒvƒŠ[ƒXƒg‚É“]E‚µ‚É—ˆ‚Ü‚µ‚½","‚²ˆ¥ŽA‚ÉŽf‚¢‚Ü‚µ‚½")==2) {
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚»‚¤‚Å‚·‚©cŽ„‚Í‚±‚Ì’Ê‚èŒ³‹C‚Å‚·B";
			mes "‚ ‚È‚½‚àƒAƒRƒ‰ƒCƒg‚Æ‚µ‚Ä‚ÌŽg–½‚ð";
			mes "–Y‚ê‚¸‚ÉA³‚µ‚­¶‚«‚Ä‚­‚¾‚³‚¢B";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚»‚ê‚Å‚ÍA‚Ü‚½—ˆ‚éŽž‚Í‘¼‚Ì";
			mes "ƒAƒRƒ‰ƒCƒg’B‚Ì—lŽq‚à‹³‚¦‚Ä‚­‚¾‚³‚¢B";
			mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ ‚ç‚ñ‚±‚Æ‚ðc";
			close;
		}
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚»‚¤‚Å‚·‚©cƒvƒŠ[ƒXƒg‚Ö‚Ì“]E‚ð";
		mes "‚¨–]‚Ý‚Å‚·‚©c";
		mes "_‚à‚ ‚È‚½‚ÌŒˆS‚ðS‚©‚ç‚¨Šì‚Ñ‚É";
		mes "‚È‚é‚Å‚µ‚å‚¤B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "Ž„‚Íƒvƒƒ“ƒeƒ‰‘å¹“°‚ÌŽi‹³‚ð";
		mes "‹Â‚¹‚Â‚©‚Á‚Ä‚¢‚é";
		mes "ƒg[ƒ}ƒX=ƒZƒ‹ƒoƒ“ƒeƒX‚Æ‚¢‚¢‚Ü‚·B";
		mes "ŒÅ‚­‚È‚ç‚¸AŠy‚É‚µ‚Ä‚­‚¾‚³‚¢B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "ƒvƒŠ[ƒXƒg‚Ö‚Ì“]E‚ðŒˆS‚µ‚½‚Ì‚È‚çA";
		mes "‚¢‚­‚Â‚©‚ÌŽŽ—û‚ðæ‚è‰z‚¦‚Ä‚¢‚½‚¾";
		mes "‚©‚È‚­‚Ä‚Í‚È‚è‚Ü‚¹‚ñB";
		mes "‚Ü‚¸‚»‚Ì‘O‚ÉAJobLv‚ª40ˆÈã";
		mes "‚Å‚ ‚é‚±‚Æ‚ª‘O’ñ‚Æ‚È‚è‚Ü‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚³‚ÄA‚ ‚È‚½‚Ì“]E‚Ì‚¨Žè“`‚¢‚ð‚·‚é";
		mes "‚½‚ß‚ÉA‚±‚¿‚ç‚Ì\ž‘‚ðì‚ç‚È‚¯‚ê‚Î";
		mes "‚È‚è‚Ü‚¹‚ñB";
		mes "¡A\‚µž‚Ý‚ð‚³‚ê‚Ü‚·‚©H";
		next;
		if(select("‚Í‚¢A\‚µž‚Ý‚Ü‚·","‚à‚¤­‚µl‚¦‚Ä‚Ý‚Ü‚·")==2) {
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚»‚¤‚Å‚·‚©B‚»‚ê‚Å‚Í‚ä‚Á‚­‚è";
			mes "l‚¦‚Ä—ˆ‚Ä‰º‚³‚¢B";
			mes "ƒvƒŠ[ƒXƒg‚É“]E‚·‚éŒˆS‚ª‚Â‚¢‚½‚ç";
			mes "‚Ü‚½–K‚Ë‚Ä‚¢‚ç‚Á‚µ‚á‚¢B";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ ‚ç‚ñ‚±‚Æ‚ðB";
			close;
		}
		if(JobLevel < 40) {
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚ ‚È‚½‚Í‚Ü‚¾ƒvƒŠ[ƒXƒg‚É‚È‚é‚É‚Í";
			mes "‘‚¢‚Å‚·‚Ëc";
			mes "¢‚Ì’†‚ÅA‚à‚Á‚Æ‚½‚­‚³‚ñ‚ÌŒoŒ±‚ð";
			mes "Ï‚ñ‚Å‚«‚Ä‚­‚¾‚³‚¢B";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "ƒvƒŠ[ƒXƒg‚É‚ÍƒvƒŠ[ƒXƒg‚Ìc";
			mes "ƒAƒRƒ‰ƒCƒg‚É‚ÍƒAƒRƒ‰ƒCƒg‚ÌŽg–½‚ª";
			mes "‚ ‚é‚Ì‚Å‚·cB";
			mes "Žž‚ª—ˆ‚½‚çA‚Ü‚½–K‚Ë‚Ä‚¢‚ç‚Á‚µ‚á‚¢B";
			close;
		}
		if(SkillPoint) {
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚Þc‚ ‚È‚½‚É‚Í‚Ü‚¾ƒXƒLƒ‹ƒ|ƒCƒ“ƒg‚ª";
			mes "Žc‚Á‚Ä‚¢‚Ü‚·‚Ëc";
			mes "Žæ“¾‚Å‚«‚éƒXƒLƒ‹‚ðK“¾‚µ‚Ä‚©‚ç";
			mes "—ˆ‚È‚³‚¢cB";
			close;
		}
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes strcharinfo(0)+ " ‚æc";
		mes "ƒvƒŠ[ƒXƒg“]E‚Ö‚ÌŽŽ—û‚ðŒ¾‚¢“n‚µ";
		mes "‚Ü‚·cB‘å•Ï‚ÈŽŽ—û‚Å‹ê’É‚ð”º‚¤";
		mes "‚ÆŽv‚¢‚Ü‚·‚ªAæ‚è‰z‚¦‚Ä‚­‚¾‚³‚¢B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "ƒvƒŠ[ƒXƒg‚Ö‚Ì“]E‚É‚ÍA‚Ü‚¸„—ç‚ð";
		mes "s‚í‚È‚¯‚ê‚Î‚È‚è‚Ü‚¹‚ñB";
		mes "ƒtƒB[ƒ‹ƒh‚ÅCs’†‚ÌŽO–¼‚ÌC“¹Žm";
		mes "‚É‡‚É‰ï‚Á‚Ä—ˆ‚Ä‚­‚¾‚³‚¢B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "ŽŸ‚É‘Þ–‚C—û‚Å‚·B";
		mes "‘Þ–‚‚Æ‚ÍAˆ«–‚‚ÆƒAƒ“ƒfƒbƒh‚ð‘Þ‚¯A";
		mes "‘S‚Ä‚Ì—U˜f‚â”Ï”YEˆ«‚µ‚«—Í‚ð";
		mes "–Å‚·‚é‚±‚Æ‚Å‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚»‚µ‚Ä•òŽd‚Ì¾–ñB";
		mes "ƒvƒŠ[ƒXƒg‚Æ‚µ‚ÄŽã‚«ŽÒ‚ð•‚¯A";
		mes "M‹Â‚ðL‚ß‚é‚½‚ß‚Ì¾–ñ‚ð";
		mes "‚µ‚Ä‚¢‚½‚¾‚«‚Ü‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚Ü‚½AJobLv50‚Ü‚ÅCs‚ð‚µ‚½";
		mes "ƒAƒRƒ‰ƒCƒg‚É‚Â‚¢‚Ä‚ÍA„—ç‚ð";
		mes "s‚í‚È‚­‚Ä‚à‚æ‚ë‚µ‚¢‚Å‚µ‚å‚¤B";
		mes "‚±‚ê‚Ü‚Å‚É‘½‚­‚Ì„—ç‚ð‚µ‚Ä‚«‚½";
		mes "‚Å‚µ‚å‚¤‚©‚çcB";
		next;
		if(JobLevel < 50) {
			set CHANGE_PR,1;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚»‚ê‚Å‚Í„—ç‚ÌŽè‡‚ðà–¾‚µ‚Ü‚µ‚å‚¤B";
			mes "‰‚ß‚Íƒvƒƒ“ƒeƒ‰–k“Œ•û–Ê‚ÌˆâÕ‚Å";
			mes "Cs’†‚Ìƒ‹ƒoƒ‹ƒJƒoƒ‰_•ƒ‚É";
			mes "‰ï‚Á‚Ä‚«‚Ä‚­‚¾‚³‚¢B";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "ŽŸ‚Éƒ}ƒ`ƒ‹ƒ_ƒVƒXƒ^[‚É‰ï‚Á‚Ä‚­‚¾‚³‚¢";
			mes "B";
			mes "”Þ—‚Íƒvƒƒ“ƒeƒ‰“ì¼ˆÊ’u‚µ‚½ƒ‚ƒƒN";
			mes "ƒtƒB[ƒ‹ƒh‚Ì‚Ç‚±‚©‚É‚¢‚é‚Í‚¸‚Å‚·B";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "ÅŒã‚É—m‰î_•ƒ‚É‰ï‚Á‚Ä‚­‚¾‚³‚¢B";
			mes "—m‰î_•ƒ‚Íƒvƒƒ“ƒeƒ‰–k¼‚Ì";
			mes "ƒtƒB[ƒ‹ƒh‚ÅCs’†‚Å‚µ‚å‚¤B";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚»‚ê‚Å‚Í‹C‚ð‚Â‚¯‚ÄB";
			mes "‚à‚µêŠ‚ª‚æ‚­‚í‚©‚ç‚È‚©‚Á‚½‚ç";
			mes "ƒZƒVƒ‹C“¹—‚É•·‚¢‚Ä‚Ý‚Ä‚­‚¾‚³‚¢B";
			mes "„—ç‚ªI‚í‚Á‚½‚çŽŸ‚ÌŽŽ—û‚ð—^‚¦‚Ü‚·B";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ ‚ç‚ñ‚±‚Æ‚ðc";
			close;
		}
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚ ‚È‚½‚ÍJobLv‚ª50‚Å‚·‚ËB";
		mes "—§”h‚Å‚·B¡‚Ü‚Å”MS‚ÉCs‚ð";
		mes "Ï‚ñ‚Å‚«‚½‚±‚Æ‚ª‰M‚¦‚Ü‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚Å‚ÍA‘Þ–‚C—û‚Öi‚ñ‚Å‚­‚¾‚³‚¢B";
		mes "‘Þ–‚C—û‚É‚ÍA‘¼‚ÌƒvƒŠ[ƒXƒg‚ð";
		mes "‚¨‹Ÿ‚É˜A‚ê‚é‚±‚Æ‚ª‚Å‚«‚Ü‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚ ‚È‚½‚Ì—Í‚È‚ç‚±‚ê‚ð‚±‚È‚·‚Ì‚Í";
		mes "‚½‚â‚·‚¢‚ÆŽv‚¢‚Ü‚·‚ªA";
		mes "ƒvƒŠ[ƒXƒg’B‚Æˆê‚È‚ç‚Î‚à‚Á‚Æ";
		mes "ŠÈ’P‚É‚È‚é‚Å‚µ‚å‚¤B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚»‚ê‚Å‚Í‘Þ–‚C—û‚ðŽn‚ß‚Ü‚µ‚å‚¤‚©B";
		break;
	case 1:
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚¨H‚ ‚È‚½‚Í‚È‚º‚±‚¿‚ç‚É‹‚é‚Ì";
		mes "‚Å‚µ‚å‚¤‚©H";
		mes "‚Ü‚³‚©„—ç‚ð–Y‚ê‚Ä‚µ‚Ü‚Á‚½‚í‚¯‚Å‚Í";
		mes "‚ ‚è‚Ü‚¹‚ñ‚æ‚ËH";
		next;
		if(select("\‚µ–ó‚È‚¢‚Å‚·‚ª‡”Ô‚ð‹³‚¦‚Ä‚­‚¾‚³‚¢","‚¢‚¢‚¦I‚Ü‚³‚©‚»‚Ì‚æ‚¤‚È‚±‚Æ‚ÍI")==2) {
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚»‚¤‚Å‚·‚©BÚ‚µ‚¢êŠ‚ð‚¨’m‚è‚É";
			mes "‚È‚è‚½‚©‚Á‚½‚çA“ü‚èŒû‚É‚¨‚è‚Ü‚·";
			mes "ƒZƒVƒ‹C“¹—‚É•·‚¢‚Ä‚Ý‚é‚Ì‚à";
			mes "‚æ‚ë‚µ‚¢‚Å‚µ‚å‚¤B";
			next;
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚»‚ê‚Å‚Í‹C‚ð‚Â‚¯‚Äs‚Á‚Ä‚ç‚Á‚µ‚á‚¢B";
			mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚ç‚ñ‚±‚Æ‚ðB";
			close;
		}
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚³‚Ä‚³‚Äc‰‚ß‚©‚ç‚±‚Ì’²Žq‚¾‚ÆA";
		mes "­‚µæ‚ªS”z‚Å‚·‚¼c";
		mes "‚Ü‚½“`‚¦‚Ü‚·‚©‚çA¡“x‚Í‚æ‚­•·‚¢‚Ä";
		mes "‚µ‚Á‚©‚èŠo‚¦‚Ä‚­‚¾‚³‚¢B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "ƒ‹ƒoƒ‹ƒJƒoƒ‰_•ƒ‚É‚¨‰ï‚¢‚È‚³‚¢B";
		mes "ƒvƒƒ“ƒeƒ‰–k“Œ•û–Ê‚ÌˆâÕ‚Å";
		mes "Cs’†‚Å‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "ŽŸ‚Éƒ}ƒ`ƒ‹ƒ_ƒVƒXƒ^[‚É‰ï‚Á‚Ä‚­‚¾‚³‚¢";
		mes "B";
		mes "”Þ—‚Íƒvƒƒ“ƒeƒ‰“ì¼ˆÊ’u‚µ‚½ƒ‚ƒƒN";
		mes "ƒtƒB[ƒ‹ƒh‚Ì‚Ç‚±‚©‚É‚¢‚é‚Í‚¸‚Å‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "ÅŒã‚É—m‰î_•ƒ‚É‚¨‰ï‚¢‚È‚³‚¢B";
		mes "—m‰î_•ƒ‚Íƒvƒƒ“ƒeƒ‰–k¼‚Ì";
		mes "ƒtƒB[ƒ‹ƒh‚ÅCs’†‚Å‚µ‚å‚¤B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚»‚ê‚Å‚Í‹C‚ð‚Â‚¯‚ÄB";
		mes "‚à‚µêŠ‚ª‚æ‚­‚í‚©‚ç‚È‚©‚Á‚½‚çA";
		mes "ƒZƒVƒ‹C“¹—‚É•·‚¢‚Ä‚Ý‚Ä‚­‚¾‚³‚¢B";
		mes "„—ç‚ªI‚í‚Á‚½‚çŽŸ‚ÌŽŽ—û‚ð—^‚¦‚Ü‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ ‚ç‚ñ‚±‚Æ‚ðc";
		close;
	case 2:
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "ƒ‹ƒoƒ‹ƒJƒoƒ‰_•ƒ‚É‚¨‰ï‚¢‚µ‚Ä";
		mes "‚«‚Ü‚µ‚½‚ËB";
		mes "‰“‚¢‚Æ‚±‚ë‚²‹ê˜J—l‚Å‚µ‚½B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚Å‚ÍŽŸ‚Íƒ}ƒ`ƒ‹ƒ_ƒVƒXƒ^[‚Ì‚Æ‚±‚ë‚ÖB";
		mes "ƒ‚ƒƒN•û–Ê‚Ü‚Å’·‚¢—·‚É‚È‚è‚Ü‚·‚ªA";
		mes "Šæ’£‚Á‚Ä‚­‚¾‚³‚¢B";
		close;
	case 3:
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "ƒ}ƒ`ƒ‹ƒ_ƒVƒXƒ^[‚É‰ï‚Á‚Ä‚«‚Ü‚µ‚½‚Ë";
		mes "»”™‚Ì‹‚¢’†‚Å‚à•Ï‚í‚ç‚¸Cs’†";
		mes "‚Å‚µ‚½‚©c";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚»‚ê‚Å‚ÍÅŠúA—m‰î_•ƒ‚É‚¨‰ï‚¢";
		mes "‚µ‚Ä‚«‚È‚³‚¢B";
		mes "Œ¯‚µ‚¢–k¼‚ÌƒtƒB[ƒ‹ƒh‚Ì‚Ç‚±‚©‚É";
		mes "‚¢‚ç‚Á‚µ‚á‚é‚Í‚¸‚Å‚·‚©‚çA";
		mes "‹C‚ð‚Â‚¯‚Äs‚Á‚Ä‚«‚È‚³‚¢B";
		close;
	case 4:
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "—m‰î_•ƒ‚É‚¨‰ï‚¢‚µ‚Ä‚«‚Ü‚µ‚½‚ËB";
		mes "ˆê‚Â–Ú‚ÌŽŽ—ûu„—çv‚ð–³Ž–I‚¦‚½";
		mes "‚±‚Æ‚ð‚¨j‚¢‚µ‚Ü‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "ŽŸ‚ÌŽŽ—û‚Å‚ ‚é‘Þ–‚C—û‚É“ü‚è‚Ü‚·B";
		mes "‰‚ß‚É\‚µã‚°‚½‚æ‚¤‚ÉA‘Þ–‚C—û‚É‚Í";
		mes "‹Ÿ‚ÌƒvƒŠ[ƒXƒg‚ð˜A‚ê‚Äs‚­‚±‚Æ‚ª";
		mes "‚Å‚«‚Ü‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚·‚×‚Ä‚ÌŽŽ—û‚ð•‚¯‚Ä‚à‚ç‚¤‚±‚Æ‚Í";
		mes "‚Å‚«‚Ü‚¹‚ñ‚ªAƒvƒŠ[ƒXƒg‚É‚æ‚­“±‚¢‚Ä";
		mes "‚à‚ç‚Á‚Ä‚­‚¾‚³‚¢B";
		mes "‚»‚ê‚Å‚ÍA‚·‚®‚É‘Þ–‚C—û‚ðŽn‚ß‚Ü";
		mes "‚µ‚å‚¤‚©B";
		break;
	case 5:
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‘Þ–‚C—û‚Ö‚Ì€”õ‚ª®‚Á‚½‚æ‚¤‚Å‚·‚ËB";
		mes "‚»‚ê‚Å‚Í‚·‚®Žn‚ß‚Ü‚µ‚å‚¤‚©B";
		next;
		if(select("‚Í‚¢A‚¨‚Ë‚ª‚¢‚µ‚Ü‚·","‚Ü‚¾€”õ‚ª‚Å‚«‚Ä‚È‚¢‚Å‚·")==2) {
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚í‚©‚è‚Ü‚µ‚½B‚ä‚Á‚­‚è€”õ‚ð®‚¦‚Ä";
			mes "‚«‚È‚³‚¢B‚ ‚È‚½‚ªŽŽ—û‚ð–³Ž–";
			mes "æ‚è‰z‚¦‚ç‚ê‚Ü‚·‚æ‚¤‚ÉB";
			close;
		}
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚»‚ê‚Å‚ÍAC—û‚Ì’n‚Ö‘—‚Á‚Ä";
		mes "‚³‚µ‚ ‚°‚Ü‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚ ‚¿‚ç‚É’…‚¢‚½‚çAC—û‚ð’S“–";
		mes "‚µ‚Ä‚¢‚éƒs[ƒ^[_•ƒ‚É‚¨˜b‚ð";
		mes "•·‚¢‚Ä‚Ý‚Ä‚­‚¾‚³‚¢B";
		next;
		warp "job_prist",24,180;
		end;
	case 6:
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚æ‚Ù‚Ç‘å•Ï‚¾‚Á‚½—lŽq‚Å‚·‚ËcB";
		mes "‚µ‚©‚µAƒvƒŠ[ƒXƒg‚É‚È‚Á‚½Œã‚É‚Í";
		mes "‚à‚Á‚Æ‘å‚«‚ÈŽŽ—û‚ª‘Ò‚¿Žó‚¯‚Ä";
		mes "‚¢‚é‚©‚à‚µ‚ê‚Ü‚¹‚ñB";
		mes "‚±‚Ì’ö“x‚ÌŽŽ—û‚É•‰‚¯‚Ä‚Í‚È‚è‚Ü‚¹‚ñB";
		mes "‚à‚¤ˆê“x’§í‚µ‚Ä‚Ý‚Ü‚·‚©H";
		next;
		if(select("’§í‚µ‚Ü‚·","‚à‚¤­‚µ€”õ‚ð®‚¦‚Ü‚·")==2) {
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚í‚©‚è‚Ü‚µ‚½B‚ä‚Á‚­‚è€”õ‚ð®‚¦‚Ä";
			mes "‚«‚È‚³‚¢B‚ ‚È‚½‚ªŽŽ—û‚ð–³Ž–";
			mes "æ‚è‰z‚¦‚ç‚ê‚Ü‚·‚æ‚¤‚ÉB";
			close;
		}
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚»‚ê‚Å‚Í‚¨‘—‚è‚µ‚Ü‚·B";
		mes "–³Ž–Š®‹‚³‚ê‚é‚±‚Æ‚ð‹F‚è‚Ü‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "ƒs[ƒ^[_•ƒ‚É‚à•Œ¾‚ð‚¢‚½‚¾‚­‚Æ";
		mes "—Ç‚¢‚Å‚µ‚å‚¤B";
		next;
		warp "job_prist",24,180;
		end;
	case 7:
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‘Þ–‚C—û‚ð–³Ž–‚ÉI‚¦‚Ü‚µ‚½‚ËB";
		mes "—Ç‚­Šæ’£‚è‚Ü‚µ‚½B";
		mes "‚·‚×‚Ä‚Ì—U˜f‚â”Ï”Y‚É‘Å‚¿Ÿ‚Â";
		mes "—Í‚ð”õ‚¦‚½‚ ‚È‚½‚ÍA‚·‚Å‚É";
		mes "ƒvƒŠ[ƒXƒg‚Ì‘fŽ¿‚ðŽ‚Â‚Å‚µ‚å‚¤B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚»‚ê‚Å‚ÍAƒZƒVƒ‹C“¹—‚Ì‚Æ‚±‚ë‚Ö";
		mes "s‚«A•òŽd‚Ì¾–ñ‚ðÏ‚Ü‚¹‚Ä‚­‚¾‚³‚¢B";
		mes "“ª‚Ì‰œ‚É‹¿‚­º‚É‘Î‚µ‚ÄAŽ©•ª‚Ì";
		mes "Žv‚¤‚Ü‚Ü‚É“š‚¦‚é‚¾‚¯‚Å—Ç‚¢‚Å‚·‚©‚çB";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚»‚ê‚Å‚ÍA‚ ‚È‚½‚Ì“]E‚ÌŽž‚ð";
		mes "Šy‚µ‚Ý‚É‚¨‘Ò‚¿‚µ‚Ä‚¨‚è‚Ü‚·cB";
		close;
	case 8:
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚È‚º‚Å‚µ‚å‚¤‚©c‚ ‚È‚½‚Í•òŽd‚Ì¾–ñ‚ð";
		mes "ÅŒã‚Ü‚Å‹‚°‚ç‚ê‚Ü‚¹‚ñ‚Å‚µ‚½B";
		mes "ƒvƒŠ[ƒXƒg‚Æ‚µ‚ÄŠî–{“I‚ÈS\‚¦‚ª";
		mes "‚Å‚«‚Ä‚¢‚È‚¯‚ê‚ÎA‚¢‚Âˆ«‚Ì—U˜f‚É";
		mes "ˆù‚Ýž‚Ü‚ê‚Ä‚µ‚Ü‚¤‚©‚í‚©‚è‚Ü‚¹‚ñcB";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚à‚¤ˆê“xƒZƒVƒ‹C“¹—‚Ì‚Æ‚±‚ë‚Ö";
		mes "s‚«A¾–ñ‚ðÅŒã‚Ü‚Å‹‚°‚Ä‚­‚¾‚³‚¢B";
		mes "‚³‚à‚È‚­‚ÎA‚ ‚È‚½‚ÌS‚ðÅ‰‚©‚ç’b‚¦";
		mes "’¼‚·‚½‚ß‚ÉAÄ“x„—ç‚ð‚µ‚Ä‚¢‚½‚¾‚­";
		mes "‚±‚Æ‚É‚È‚é‚Å‚µ‚å‚¤B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "s‚Á‚Ä‚ç‚Á‚µ‚á‚¢B";
		mes "Ž¨‚Å•·‚­‚Ì‚Å‚Í‚È‚­S‚Å•·‚­‚Ì‚Å‚·‚æc";
		close;
	case 9:
		if(SkillPoint) {
			mes "[ƒg[ƒ}ƒXŽi‹³]";
			mes "‚Þc‚ ‚È‚½‚É‚Í‚Ü‚¾ƒXƒLƒ‹ƒ|ƒCƒ“ƒg‚ª";
			mes "Žc‚Á‚Ä‚¢‚Ü‚·‚Ëc";
			mes "Žæ“¾‚Å‚«‚éƒXƒLƒ‹‚ðK“¾‚µ‚Ä‚©‚ç";
			mes "—ˆ‚È‚³‚¢cB";
			close;
		}
		set .@itemid,(JobLevel >= 50)? 1551: 1550;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚¨‚ß‚Å‚Æ‚¤‚²‚´‚¢‚Ü‚·B";
		mes "‚ ‚È‚½‚Í‘S‚Ä‚ÌŽŽ—û‚ðæ‚è‰z‚¦‚Ü‚µ‚½B";
		mes "ƒvƒŠ[ƒXƒg‚É‚È‚éŽ‘Ši‚ð—^‚¦‚Ü‚·B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "_‚æc‚ ‚È‚½‚ÌŒõ‚ð‚±‚ÌŽÒ‚ÉÆ‚ç‚µA";
		mes "‚»‚Ì—Í‚ðŽö‚¯‚æc";
		mes "‚±‚Ì¢‚É‚ ‚È‚½‚ÌˆÓŽv‚ð“`‚¦‚éŽÒ";
		mes "¡‚±‚±‚É¶‚Ü‚ê‚éc";
		next;
		nude;
		jobchange Job_Priest;
		set CHANGE_PR,0;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚±‚ê‚Å‚ ‚È‚½‚àˆêl‚ÌƒvƒŠ[ƒXƒg";
		mes "‚Æ‚µ‚Ä¶‚Ü‚ê•Ï‚í‚è‚Ü‚µ‚½B";
		mes "‚¨j‚¢‚ð\‚µã‚°‚é‚Æ“¯Žž‚ÉA";
		mes "V‚½‚ÈS\‚¦‚Æ‚Æ‚à‚É¢‹‡‚·‚é";
		mes "lX‚ð—Ç‚­“±‚«‹~‚Á‚Ä‚ ‚°‚Ä‚­‚¾‚³‚¢B";
		next;
		getitem .@itemid,1;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚»‚µ‚Ä“]E‹L”O‚É‚±‚ê‚ð‚³‚µ‚ ‚°‚Ü‚·B";
		mes "M‹`‚É‚Â‚¢‚Ä‹L‚³‚ê‚Ä‚¨‚èA‚±‚ê‚©‚ç‚Ì";
		mes "“¹‚ði‚Þ‚ ‚È‚½‚É‚Í•K—v‚È‚à‚Ì‚Æ‚È‚é";
		mes "‚Å‚µ‚å‚¤B";
		next;
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚±‚ê‚É‚Ä‚·‚×‚Ä‚Ì“]E‚Ì‹V‚ð";
		mes "I‚í‚è‚Ü‚·B‚¨”æ‚ê—l‚Å‚µ‚½cB";
		mes "V‚µ‚«“¹‚ð•à‚ñ‚Å‚¢‚«‚È‚³‚¢cB";
		close;
	}
	//‘Þ–‚C—ûs‚«
	next;
	set CHANGE_PR,5;
	if(select("‚Í‚¢A‚¨Šè‚¢‚µ‚Ü‚·","­‚µ€”õ‚ð‚µ‚Ä—ˆ‚Ü‚·")==2) {
		mes "[ƒg[ƒ}ƒXŽi‹³]";
		mes "‚í‚©‚è‚Ü‚µ‚½B‚ä‚Á‚­‚è€”õ‚ð®‚¦‚Ä";
		mes "‚«‚È‚³‚¢B‚ ‚È‚½‚ªŽŽ—û‚ð–³Ž–";
		mes "æ‚è‰z‚¦‚ç‚ê‚Ü‚·‚æ‚¤‚ÉB";
		close;
	}
	mes "[ƒg[ƒ}ƒXŽi‹³]";
	mes "‚»‚ê‚Å‚ÍAC—û‚Ì’n‚Ö‘—‚Á‚Ä";
	mes "‚³‚µ‚ ‚°‚Ü‚·B";
	next;
	mes "[ƒg[ƒ}ƒXŽi‹³]";
	mes "‚ ‚¿‚ç‚É’…‚¢‚½‚çAC—û‚ð’S“–";
	mes "‚µ‚Ä‚¢‚éƒs[ƒ^[_•ƒ‚É‚¨˜b‚ð";
	mes "•·‚¢‚Ä‚Ý‚Ä‚­‚¾‚³‚¢B";
	next;
	warp "job_prist",24,180;
	end;
}


//==========================================
// ˆêŽŸŽŽŒ±i¹’n„—çj
//------------------------------------------

// npc_job_04acolyte.txtŽQÆ


//==========================================
// “ñŽŸŽŽŒ±i‘Þ–‚C—ûj
//------------------------------------------

job_prist,24,187,4	script	ƒ^ƒt‚È_•ƒ::PR_Timer	110,{
	if(.flag) {	//’§í’†‚ÌƒƒbƒN
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "‚ c‚¿‚å‚Á‚Æ‘Ò‚Á‚Ä‚­‚êB";
		mes "¡‘¼‚ÌƒAƒRƒ‰ƒCƒg‚ªC—û’†‚¾B";
		next;
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "‚µ‚Î‚ç‚­‚µ‚Ä‚Ü‚½º‚ð‚©‚¯‚Ä‚­‚êB";
		mes "I‚í‚Á‚Ä‚¢‚½‚ç‘—‚Á‚Ä‚ ‚°‚é‚©‚çB";
		close;
	}
	if(Job != Job_Acolyte) {
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "ŒN‚É_‚Ì‚²‰ÁŒì‚ ‚ç‚ñ‚±‚Æ‚ðB";
		next;
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "ƒvƒŠ[ƒXƒg‚¾‚ÈcŽè“`‚Á‚Ä‚ ‚°‚é";
		mes "ƒAƒRƒ‰ƒCƒg‚Å‚à‚¢‚é‚Ì‚©‚ÈH";
		mes "‚Ü‚Á‚½‚­—D‚µ‚¢‚ËB‚Ç‚êAŒN‚È‚ç";
		mes "‚»‚ê‚à‚½‚â‚·‚¢‚¾‚ë‚¤B";
		next;
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "‚µ‚©‚µ‚±‚ê‚¾‚¯‚ÍŠo‚¦‚Ä‚¨‚¢‚Ä";
		mes "‚Ù‚µ‚¢B‚ ‚­‚Ü‚ÅŒN‚ÌŽó‚¯‚éŽŽ—û";
		mes "‚Å‚Í‚È‚¢‚Æ‚¢‚¤‚±‚Æ‚ðB";
		mes "Žè“`‚Á‚Ä‚ ‚°‚é‚Æ‚¢‚¤‚¾‚¯‚ÅA";
		mes "‘S‚Ä‚ð‰ðŒˆ‚·‚é‚í‚¯‚¶‚á‚È‚¢‚¼B";
		next;
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "‚»‚ê‚Å‚Íæ‚Éi‚Þ‚©‚ÈH";
		next;
		switch (select("‚Í‚¢As‚«‚Ü‚·","­‚µ‚¨‘Ò‚¿‚­‚¾‚³‚¢","‚â‚Í‚èŠX‚É‹A‚è‚Ü‚·")) {
		case 1:
			mes "[ƒs[ƒ^[_•ƒ]";
			mes "‚æ‚µAƒAƒRƒ‰ƒCƒg‚ª“ü‚ê‚ÎŽn‚Ü‚éI";
			mes "ŒN‚à‚«‚Á‚ÆAƒAƒRƒ‰ƒCƒg‚¾‚Á‚½ ‚ð";
			mes "Žv‚¢o‚·‚¾‚ë‚¤B";
			close2;
			warp "job_prist",24,44;
			end;
		case 2:
			mes "[ƒs[ƒ^[_•ƒ]";
			mes "‚Ó‚Þc‚½‚µ‚©‚É€”õ‚Í®‚¦‚È‚¢‚Æ‚ÈB";
			mes "‚æ‚µA—Ç‚¢Žž‚É‚Ü‚½º‚ð‚©‚¯‚È‚³‚¢B";
			close;
		case 3:
			mes "[ƒs[ƒ^[_•ƒ]";
			mes "‚Ó‚Þc‚»‚ê‚Å‚Í‹A‚è‚È‚³‚¢B";
			mes "‰‚ª‚ ‚ê‚Î‚Ü‚½‰ï‚¤‚¾‚ë‚¤B";
			mes "ŒN‚É_‚Ì‚²‰ÁŒì‚ ‚ç‚ñ‚±‚Æ‚ðB";
			close2;
			warp "prontera",234,318;
			end;
		}
	}
	if(CHANGE_PR < 6) {
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "ŒN‚É_‚Ì‚²‰ÁŒì‚ ‚ç‚ñ‚±‚Æ‚ðB";
		mes "‚Ü‚¸Aˆê‚Â–Ú‚ÌŽŽ—û‚ð–³Ž–æ‚è‰z‚¦‚½";
		mes "‚±‚Æ‚ðj‚¨‚¤B‚æ‚­Šæ’£‚Á‚½B";
		next;
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "Ž„‚Ì–¼‘O‚Íƒs[ƒ^[ESEƒAƒ‹ƒxƒ‹ƒg";
		mes "‚Æ‚¢‚¤Bƒg[ƒ}ƒX‚ÍŒ³‹C‚¾‚Á‚½‚©‚¢H";
		next;
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "ˆê‰ž“z‚ÍŽi‹³‚¾‚©‚çA–{“–‚Íƒg[ƒ}ƒX";
		mes "Ži‹³—l‚ÆŒÄ‚Î‚È‚¯‚ê‚Î‚È‚ç‚È‚¢‚ñ‚¾";
		mes "‚ë‚¤‚ªc";
		mes "ˆê¶_•ƒ‚Å‰ß‚²‚·Ž„‚Æ‚Íˆá‚¤‚ñ‚¾‚æ";
		mes "ƒnƒnƒnI";
		next;
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "‚³‚ÄA‘Þ–‚C—û‚É‚Â‚¢‚ÄŠÈ’P‚Éà–¾";
		mes "‚µ‚æ‚¤‚©BŒN‚Í‚±‚ÌC—û‚É‚Â‚¢‚Ä";
		mes "‚Ç‚ñ‚È‚à‚Ì‚©‚í‚©‚Á‚Ä‚¢‚é‚©‚ËH";
		next;
		if(select("‚Í‚¢A‚í‚©‚Á‚Ä‚¢‚Ü‚·","‚æ‚­•ª‚©‚ç‚È‚¢‚Å‚·c")==1) {
			mes "[ƒs[ƒ^[_•ƒ]";
			mes "—˜Œû‚¾‚ËB‚ÜAˆê‰žŠÈ’P‚Éà–¾‚µ‚Ä";
			mes "‚¨‚±‚¤‚©B";
			mes "‚æ‚­‚í‚©‚Á‚Ä‚¢‚é‚Ì‚ÆA‚Å‚«‚é‚Ì‚Æ‚Å‚Í";
			mes "ˆá‚¤‚©‚ç‚ËB";
		}
		else {
			mes "[ƒs[ƒ^[_•ƒ]";
			mes "‚»‚¤‚©A‚»‚ê‚¶‚á‚ Ú‚µ‚¢à–¾‚ª";
			mes "•K—v‚¾‚ËB";
			mes "‚µ‚Á‚©‚è•·‚¢‚Ä‚¢‚¯‚ÎAŒN‚à‚¢‚Â‚Ì";
			mes "ŠÔ‚É‚©‘Þ–‚C—û‚ð‚±‚È‚¹‚Ä‚¢‚é‚¾‚ë‚¤B";
		}
		next;
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "‘Þ–‚C—û‚Æ‚¢‚¤‚Ì‚ÍA•¶Žš’Ê‚è–‚•¨‚ð";
		mes "‘ÞŽ¡‚·‚é‚±‚Æ‚ð‚¢‚¤B";
		mes "–‚•¨‚Æ‚ÍAƒAƒ“ƒfƒbƒg‚Æˆ«–‚‚Ì‘Ì‚¾B";
		next;
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "¢‚Ì’†‚É‚ÍAM‹`‚É”½‚µ‚½ƒ‚ƒm‚ª";
		mes "‚ ‚Ü‚è‚É‚à‘½‚¢B‚»‚¤‚¢‚¤–‚•¨‚ç‚Í";
		mes "‘P—Ç‚È_‚Ì–¯c‚Â‚Ü‚èŽ„’B‚ÉŠQ‚ðˆ×‚·B";
		next;
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "Ž„’BƒvƒŠ[ƒXƒg‚É‚Í‚»‚¤‚¢‚Á‚½–‚•¨’B‚ð";
		mes "‘S‚Ä‘ÞŽ¡‚·‚é‚Ü‚ÅˆÀ‘§‚Ì“ú‚Í–K‚ê‚È‚¢B";
		next;
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "‘Þ–‚C—û‚ª‚Ç‚ñ‚È‚±‚Æ‚ð‚·‚é‚Ì‚©‚ª";
		mes "‚¾‚¢‚½‚¢‚±‚ê‚Å‚í‚©‚Á‚½‚©‚ÈH";
		mes "ƒvƒŠ[ƒXƒg‚É‚È‚Á‚½‚Â‚à‚è‚ÅŽ©•ª‚Ì";
		mes "—Í‚ðŽŽ‚·‚ñ‚¾B";
		mes "‚»‚±‚ÅA‚±‚ÌŽŽ—û‚Í‚©‚È‚è“ï‚µ‚¢‚à‚Ì‚Æ";
		mes "‚È‚é‚©‚çA•‚¯‚ð‚Â‚¯‚é‚±‚Æ‚ª‚Å‚«‚éB";
		next;
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "‚æ‚­’m‚éæ”yƒvƒŠ[ƒXƒg‚ª‚¢‚é‚È‚çA";
		mes "‚¨Šè‚¢‚·‚é‚Ì‚à—Ç‚¢‚¾‚ë‚¤B";
		mes "‚»‚ê‚Å‚ÍA‚»‚ë‚»‚ëŽn‚ß‚æ‚¤‚©B";
		next;
		set CHANGE_PR,6;
		set .@word$,"­‚µ‚¨‘Ò‚¿‚­‚¾‚³‚¢";
	}
	else {
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "¡“x‚Í‚µ‚Á‚©‚è€”õ‚µ‚Ä‚«‚½‚©‚ÈH";
		mes "‚³‚ ‚³‚ A‘‚­I‚í‚ç‚¹‚ÄƒvƒŠ[ƒXƒg‚É";
		mes "‚È‚ë‚¤B";
		next;
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "‚»‚ê‚Å‚Í‚·‚®‚ÉŽn‚ß‚æ‚¤B";
		next;
		//ƒZƒŠƒt‚ª”÷–­‚Éˆá‚¤
		set .@word$,"‚à‚¤­‚µ‘Ò‚Á‚Ä‚­‚¾‚³‚¢";
	}
	switch (select("‚¨‚Ë‚ª‚¢‚µ‚Ü‚·",.@word$,"ŠX‚É‹A‚è‚Ü‚·")) {
	case 1:
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "‚»‚ê‚Å‚ÍA‘Þ–‚C—û‚ðŽn‚ß‚éB";
		mes "“à—e‚Í‚¢‚½‚Á‚Ä’Pƒco‚Ä‚­‚é";
		mes "ƒ‚ƒ“ƒXƒ^[‚ð‘S‚Ä“|‚¹‚Î—Ç‚¢B";
		next;
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "‰½’iŠK‚©‚ ‚é‚©‚çA‹C‚ð‚Â‚¯‚È‚³‚¢B";
		mes "Šæ’£‚Á‚Ä‚ÈI";
		next;
		if(.flag) {	//‚±‚±‚Å‚àƒƒbƒNƒ`ƒFƒbƒN
			mes "[ƒs[ƒ^[_•ƒ]";
			mes "‚ c‚¿‚å‚Á‚Æ‘Ò‚Á‚Ä‚­‚êB";
			mes "¡‘¼‚ÌƒAƒRƒ‰ƒCƒg‚ªC—û’†‚¾B";
			next;
			mes "[ƒs[ƒ^[_•ƒ]";
			mes "‚µ‚Î‚ç‚­‚µ‚Ä‚Ü‚½º‚ð‚©‚¯‚Ä‚­‚êB";
			mes "I‚í‚Á‚Ä‚¢‚½‚ç‘—‚Á‚Ä‚ ‚°‚é‚©‚çB";
			close;
		}
		set @priest_check,0;
		set getvariableofnpc(.count,"PR_Summon"),0;	//mobƒJƒEƒ“ƒ^‚ð‰Šú‰»
		set .flag,getcharid(3);				//ƒAƒJƒEƒ“ƒgID‚ðŽg‚Á‚ÄƒƒbƒN‚·‚é
		initnpctimer;
		warp "job_prist",24,44;
		end;
	case 2:
		mes "[ƒs[ƒ^[_•ƒ]";
		mes "‚Ó‚Þc‚½‚µ‚©‚É€”õ‚Í•K—v‚¾B";
		mes "‚æ‚µA‚æ‚©‚Á‚½‚ç‚Ü‚½º‚ð‚©‚¯‚Ä‚­‚êB";
		close;
	case 3:
		if(CHANGE_PR < 6) {
			mes "[ƒs[ƒ^[_•ƒ]";
			mes "‰½A‚±‚±‚Ü‚Å—ˆ‚Ä‹A‚é‚Ì‚©B";
			mes "Ž„‚Í\‚í‚È‚¢‚ªc";
			next;
			mes "[ƒs[ƒ^[_•ƒ]";
			mes "‚Ü‚ Žn‚ß‚Ä‚ÌŒoŒ±‚¾‚©‚çA•|‚ª‚é‚Ì‚à";
			mes "–³—‚Í‚È‚¢‚ÈB—E‹C‚ªo‚½‚ç‚Ü‚¾";
			mes "—ˆ‚È‚³‚¢B";
		}
		else {
			mes "[ƒs[ƒ^[_•ƒ]";
			mes "‚Ü‚½ŠX‚É‹A‚é‚Æc";
			mes "‚»‚ñ‚È‚±‚Æ‚Å‚Í‚¢‚Â‚Ü‚ÅŒo‚Á‚Ä‚à";
			mes "ƒvƒŠ[ƒXƒg‚É‚È‚é‚±‚Æ‚Í‚Å‚«‚È‚¢‚¼B";
			next;
			mes "[ƒs[ƒ^[_•ƒ]";
			mes "ŒN‚É‚Í‚Ü‚¾‚±‚±‚Í‘‚¢‚ÈB";
			mes "¢‚Ì’†‚ð‚à‚¤­‚µŒ©‚Ä‚©‚ç‚Ü‚½";
			mes "—ˆ‚È‚³‚¢B";
		}
		close2;
		warp "prontera",234,318;
		end;
	}
OnTimer350000:
	stopnpctimer;
	if(attachrid(.flag)) {	//‘ÎÛ‚ÍƒAƒR‚Ì‚Ý
		set .@d,distance2(.flag);
		if(.@d < 0 || .@d > 23)		//‘Ò‹@ƒGƒŠƒAˆÈŠO‚È‚çƒ[ƒv
			warp "prontera",234,318;
	}
	set .flag,0;
	killmonster "job_prist","All";
	end;
}

//==============================================================
job_prist,24,109,4	script	#PR_Warp1	45,2,2,{
	if(Job != Job_Acolyte || getvariableofnpc(.count,"PR_Summon") >= 13)
		warp "job_prist",168,17;
	end;
}

job_prist,168,180,4	script	#PR_Warp2	45,2,2,{
	warp "job_prist",98,40;
	end;
}

job_prist,98,105,0	script	#PR_Warp3	45,2,2,{
	if(Job == Job_Acolyte) {
		if(@priest_check < 8)	//”O‚Ì‚½‚ßƒ`ƒFƒbƒN‚·‚é
			end;
		set CHANGE_PR,7;
		set @priest_check,0;
		stopnpctimer "PR_Timer";
		set getvariableofnpc(.flag,"PR_Timer"),0;
		killmonster "job_prist","All";
	}
	warp "prt_church",15,36;
	end;
}

//==============================================================
job_prist,168,45,4	script	ƒfƒrƒ‹ƒ`	1109,5,0,{
	end;
OnTouch:
	if(Job != Job_Acolyte) {
		mes "[ƒfƒrƒ‹ƒ`]";
		mes "‚Ó‚ñcƒvƒŠ[ƒXƒg‚ª‚±‚ñ‚È‚Æ‚±‚ë‚É";
		mes "‚È‚º—ˆ‚½HŠX‚Å‹F“˜‚Å‚à‚µ‚Ä‚¢‚é";
		mes "‚Í‚¸‚¾‚ë‚¤HƒLƒLƒLƒLƒLc";
		mes "ŽžŠÔ‚ð–³‘Ê‚É‚·‚é‚Ì‚ªD‚«‚È‚æ‚¤‚¾‚ÈB";
		next;
		mes "[ƒfƒrƒ‹ƒ`]";
		mes "¡“ú‚Í‘½‚ß‚ÉŒ©‚Ä‚â‚é‚©‚ç";
		mes "‚³‚Á‚³‚Æ—§‚¿‹Ž‚êB";
		mes "“ñ“x‚Í–³‚¢‚¼cƒLƒLƒƒƒLƒƒI";
		close;
	}
	mes "[ƒfƒrƒ‹ƒ`]";
	mes "‚Ù‚¤AƒAƒRƒ‰ƒCƒg‚Í‹v‚µ‚Ô‚è‚ÉŒ©‚é‚¼B";
	mes "Œ©‚é‚©‚ç‚ÉƒvƒŠ[ƒXƒg‚Ö‚Ì“]E‚Å‚à";
	mes "l‚¦‚Ä‚»‚¤‚¾‚ÈcƒLƒƒƒLƒƒƒLƒƒI";
	next;
	mes "[ƒfƒrƒ‹ƒ`]";
	mes "‚µ‚©‚µA‚í‚µ‚É‚Í‚¨‚Ü‚¦‚ª‚±‚±‚Ü‚Å";
	mes "—ˆ‚ê‚½‚±‚Æ‚ª•sŽv‹c‚Å‚È‚ç‚ñB";
	next;
	mes "[ƒfƒrƒ‹ƒ`]";
	mes "‚ ‚¦‚Ä‚±‚ñ‚È‘å•Ï‚È“¹‚ði‚Þ‚Ì‚©H";
	mes "‚à‚Á‚Æ‘¼‚ÌŠy‚ÈE‹Æ‚à‚ ‚Á‚½‚¾‚ë‚¤I";
	next;
	mes "[ƒfƒrƒ‹ƒ`]";
	mes "ŠX‚Å‚àƒ_ƒ“ƒWƒ‡ƒ“‚Å‚à‚¨‚Ü‚¦‚É•‚¯‚ð";
	mes "‹‚ß‚é‚â‚Â‚ç‚Î‚©‚è‚¾‚ë‚¤H";
	mes "ˆê‚Â‚à‚¨‚Ü‚¦‚Ì‚½‚ß‚É‚µ‚Ä‚­‚ê‚é‚±‚Æ‚ª";
	mes "–³‚¢‚Æ‚¢‚¤‚Ì‚É‚ÈI";
	next;
	mes "[ƒfƒrƒ‹ƒ`]";
	mes "‚±‚ê‚Í‚í‚µ‚ª‘PˆÓ‚Å’‰‚µ‚Ä‚â‚Á‚Ä‚¢‚é";
	mes "‚Ì‚¾‚¼BŽŽ—û‚à‘å•Ï‚¾‚ªA‚±‚Ì‚Ü‚Ü";
	mes "¶‚«‚Ä‚¢‚­‚Ì‚Í‚à‚Á‚Æh‚¢‚¼H";
	mes "•Ê‚Ì¶‚«•û‚ð’T‚»‚¤‚Å‚Í‚È‚¢‚©B";
	next;
	if(select("‚Í‚¢c‚»‚¤‚µ‚Ü‚·","ˆ«–‚‚ßI‘Þ‚«‚È‚³‚¢I")==1) {
		mes "[ƒfƒrƒ‹ƒ`]";
		mes "ƒLƒLƒLƒbA‚æ‚­‘I‚ñ‚¾B";
		mes "“ñ“x‚Æ‚±‚±‚É—ˆ‚é‚È‚æI";
		mes "“]E‚ð’ú‚ß‚½‚¨‚Ü‚¦‚ÉA‚í‚µ‚©‚ç";
		mes "—Ç‚¢ƒvƒŒƒ[ƒ“ƒg‚ð‚â‚ë‚¤I";
		next;
		mes "[ƒfƒrƒ‹ƒ`]";
		mes "ƒ^ƒ_‚Å‚í‚µ‚Ì—F’B‚É‰ï‚¦‚é‹@‰ï‚ð";
		mes "‚â‚é‚¼IƒLƒƒƒLƒƒƒLƒƒƒLƒƒƒLƒƒI";
		next;
		warp "c_tower2",168,33;
		end;
	}
	mes "[ƒfƒrƒ‹ƒ`]";
	mes "ƒLƒLƒLƒLƒLc";
	mes "‚»‚¤Œ¾‚í‚¸‚É‚í‚µ‚Ì˜b‚ð‚à‚Á‚Æ•·‚¯B";
	next;
	mes "[ƒfƒrƒ‹ƒ`]";
	mes "¡“]E‚ð’ú‚ß‚ê‚ÎA‚í‚µ‚ª—Ç‚¢‚à‚Ì‚ð";
	mes "ƒvƒŒƒ[ƒ“ƒg‚µ‚æ‚¤B";
	mes "‚¨‚Ü‚¦‚ªˆê¶‚Éˆê“x‚¨–Ú‚É‚©‚©‚ê‚é‚©";
	mes "‚Ç‚¤‚©‚Æ‚¢‚¤‘ã•¨‚¾‚¼BƒLƒƒƒLƒƒƒLƒƒ";
	next;
	cutin "¹Ì½ºÆ®·¹½ºÄ«µå.bmp",4; // Mistress Card
	mes "[ƒfƒrƒ‹ƒ`]";
	mes "‚¨‚Ü‚¦‚ªŽ©—Í‚Å‚±‚ñ‚ÈƒJ[ƒh‚ðŽè‚É";
	mes "“ü‚ê‚ç‚ê‚é‚©‚ÈH‚æ‚­l‚¦‚Ä‚Ý‚ëB";
	next;
	if(select("ƒJ[ƒh‚ðŽó‚¯Žæ‚é","ˆ«–‚‚ßI‘Þ‚«‚È‚³‚¢I")==1) {
		mes "[ƒfƒrƒ‹ƒ`]";
		mes "ƒLƒLƒLƒb ‚â‚Í‚èlŠÔ‚æ‚Ì‚¤I";
		mes "‚¨‚Ü‚¦‚É‚±‚Ì‹Md‚ÈƒJ[ƒh‚ð";
		mes "‚â‚é‚íI";
		next;
		mes "[ƒfƒrƒ‹ƒ`]";
		mes "‚Å‚à‚í‚µ‚ª‚â‚é‚í‚¯‚Å‚Í‚È‚¢B";
		mes "Šæ’£‚Á‚ÄŽè‚É“ü‚ê‚Ä‚±‚¢I";
		next;
		warp "mjolnir_05",200,200;
		end;
	}
	cutin "dummy",255;
	mes "[ƒfƒrƒ‹ƒ`]";
	mes "‚«‚«c‚È‚©‚È‚©‹­‚¢¸_‚ðŽ‚Â‚ÈB";
	mes "‚¨‚Ü‚¦‚ªŒÈ‚ª—Í‚ÅŽè‚É“ü‚ê‚ç‚ê‚é‚©";
	mes "Œ©‚Ä‚¢‚Ä‚â‚éc";
	next;
	mes "[ƒfƒrƒ‹ƒ`]";
	mes "‚¢‚Â‚©Œã‰÷‚µ‚È‚ª‚ç‚í‚µ‚ÌŒ³‚É";
	mes "–ß‚Á‚Ä‚­‚é‚¾‚ë‚¤‚ª‚ÈIƒLƒƒƒLƒƒI";
	close;
}

//==============================================================
job_prist,168,75,4	script	ƒhƒbƒyƒ‹ƒQƒ“ƒK[	1046,5,0,{
	end;
OnTouch:
	if(Job != Job_Acolyte) {
		mes "[ƒhƒbƒyƒ‹ƒQƒ“ƒK[]";
		mes "‹ð‚©‚ÈlŠÔ‚æc‰ä‚Í‹M—l‚É—p‚Í‚È‚¢B";
		mes "–Ê“|‚Å‚Í‚È‚¢‚©HŒÈ‚ÌŽŽ—û‚Å‚±‚±‚É";
		mes "‹‚é‚í‚¯‚Å‚Í‚È‚©‚ë‚¤c";
		next;
		mes "[ƒhƒbƒyƒ‹ƒQƒ“ƒK[]";
		mes "Œ©ž‚Ý‚Ì–³‚¢ƒAƒRƒ‰ƒCƒgˆêl‚Ì‚½‚ß‚É";
		mes "‹ê˜J‚ð‚·‚é‚±‚Æ‚Í‚È‚¢B";
		mes "‚­‚¾‚ç‚Ê‚±‚Æ‚É•t‚«‡‚í‚¸‘¬‚â‚©‚É";
		mes "‹A‚é‚±‚Æ‚¾c";
		close;
	}
	mes "[ƒhƒbƒyƒ‹ƒQƒ“ƒK[]";
	mes "ƒAƒRƒ‰ƒCƒg‚æc­‚µ‰ä‚Ì˜b‚ÉŽ¨‚ðŒX‚¯‚é";
	mes "‚ª‚æ‚¢c";
	next;
	mes "[ƒhƒbƒyƒ‹ƒQƒ“ƒK[]";
	mes "‰½ŒÌƒvƒŠ[ƒXƒg‚É‚È‚ë‚¤‚Æ‚¢‚¤‚Ì‚¾H";
	mes "‰ä‚ªŒ©‚é‚É‹M—l‚É‚Í‚»‚Ì‚æ‚¤‚ÈE‚Í";
	mes "‡‚í‚È‚¢B";
	next;
	mes "[ƒhƒbƒyƒ‹ƒQƒ“ƒK[]";
	mes "Šè‚¤‚È‚ç‚Î‰ä‚ª”\—Í‚ðˆÈ‚Á‚ÄV‚½‚È";
	mes "l¶‚ðŽn‚ß‚³‚¹‚Ä‚â‚é‚¼H";
	mes "¡‚Ì‹­‚³‚ðŽ‚Á‚½‚Ü‚Üƒm[ƒrƒX‚É‚µA";
	mes "‚Ü‚½A–]‚ñ‚¾E‚ÉA‚©‚¹‚Ä‚â‚éB";
	next;
	mes "[ƒhƒbƒyƒ‹ƒQƒ“ƒK[]";
	mes "–³˜_¡‹M—l‚ªŽ‚ÂƒŒƒxƒ‹’ö“x‚Ì”\—Í‚ð";
	mes "Ž‚Á‚½‚Ü‚Ü‚¾B";
	mes "—Ç‚¢ðŒ‚¾‚ÆŽv‚¤‚ªc‚Ç‚¤‚¾H";
	next;
	if(select("‚¨‚Ë‚ª‚¢‚µ‚Ü‚·I","ˆ«–‚‚ßI‘Þ‚«‚È‚³‚¢")==2) {
		mes "[ƒhƒbƒyƒ‹ƒQƒ“ƒK[]";
		mes "‰ä‚Ì˜b‚ð‚æ‚­—‰ð‚Å‚«‚Ê‚æ‚¤‚¾‚Èc";
		mes "l¶‚ðŠª‚«–ß‚¹‚é—Ç‚¢‹@‰ï‚¾‚Á‚½";
		mes "‚Æ‚¢‚¤‚Ì‚É‚Èc";
		next;
		mes "[ƒhƒbƒyƒ‹ƒQƒ“ƒK[]";
		mes "‚½‚¾ƒvƒŠ[ƒXƒg‚É‚È‚ç‚È‚¢‚ÆŒ¾‚¤‚¾‚¯‚Å";
		mes "—Ç‚¢‚Ì‚¾B—á‚¦‚ÎA‰ä‚Ì‚æ‚¤‚ÈŒ•Žm‚É";
		mes "“]E‚·‚é‚±‚Æ‚à‰Â”\‚¾‚¼H";
		next;
		if(select("ƒvƒŠ[ƒXƒg‚É‚Í“]E‚µ‚Ü‚¹‚ñ","ˆ«–‚‚ßI‘Þ‚«‚È‚³‚¢I")==2) {
			mes "[ƒhƒbƒyƒ‹ƒQƒ“ƒK[]";
			mes "c‚È‚ç‚Î¡‚ÍŒ©“¦‚µ‚Ä‚â‚éc";
			next;
			mes "[ƒhƒbƒyƒ‹ƒQƒ“ƒK[]";
			mes "ŽŸ‚É‰ï‚¤ŽžA‹ê’É‚ÌŽ€‚ð—^‚¦‚é‚¼B";
			close;
		}
	}
	mes "[ƒhƒbƒyƒ‹ƒQƒ“ƒK[]";
	mes "‚æ‚­‘I‚ñ‚¾B";
	mes "–]‚Ý’Ê‚èƒm[ƒrƒX‚É–ß‚µ‚Ä‚â‚éB";
	next;
	mes "[ƒhƒbƒyƒ‹ƒQƒ“ƒK[]";
	mes "Ž€‚É¶‚Ü‚ê•Ï‚í‚Á‚Ä‚ÈI";
	next;
	warp "gef_dun02",210,177;
	end;
}

//==============================================================
job_prist,168,115,4	script	ƒ_[ƒNƒ[ƒh	1272,5,0,{
	end;
OnTouch:
	if(Job != Job_Acolyte) {
		mes "[ƒ_[ƒNƒ[ƒh]";
		mes "Š´‚¶‚æI‹ê’É‚Æâ–]‚ðI";
		mes "ˆê”Ô‘åØ‚ÈŽÒ‚©‚ç— Ø‚ç‚ê‚é";
		mes "”ß‚µ‚Ý‚Æ“{‚è‚ðI";
		next;
		mes "[ƒ_[ƒNƒ[ƒh]";
		mes "‚»‚ÌSA‚¢‚Â‚©‰s‚¢n‚Æ‚È‚è";
		mes "S‚Ì‘Ÿ‚É[‚­Žh‚³‚é‚¾‚ë‚¤I";
		close;
	}
	mes "[ƒ_[ƒNƒ[ƒh]";
	mes "Ž~‚Ü‚êclŠÔ‚æc";
	mes "’N‚Ì‹–‚µ‚ð“¾‚Ä‚±‚±‚ð’Ê‚è‰ß‚¬";
	mes "‚æ‚¤‚ÆŽv‚¤‚©H";
	next;
	mes "[ƒ_[ƒNƒ[ƒh]";
	mes "ƒvƒŠ[ƒXƒg‚É‚È‚ë‚¤‚Æ‚·‚é";
	mes "ƒAƒRƒ‰ƒCƒg‚©c";
	mes "‚¨‘O‚Í‚±‚±‚ð’Ê‚è‰ß‚¬‚é‚±‚Æ‚Í";
	mes "‚Å‚«‚È‚¢B";
	mes "‹A‚é‚ª‚æ‚¢c‚Å‚È‚¯‚ê‚ÎŽ„‚ª‚¨‘O‚ð";
	mes "ŽE‚·‚Å‚ ‚ë‚¤B";
	next;
	mes "[ƒ_[ƒNƒ[ƒh]";
	mes "‹a‚Ì‚æ‚¤‚ÈlŠÔ‚æcŽ„‚Ì‹x‘§‚ÌŽž‚ð";
	mes "‰˜‚·‚Å‚È‚¢c";
	next;
	if(select("‚²‚ß‚ñ‚È‚³‚¢c","ˆ«–‚‚ßI‘Þ‚«‚È‚³‚¢I")==2) {
		mes "[ƒ_[ƒNƒ[ƒh]";
		mes "‚Ó‚ñcˆêŠ…‚µ‚½‚Æ‚±‚ë‚Å‚¨‘O‚È‚Ç";
		mes "ŒÍ—t‚ð†‚Þ‚ª‚²‚Æ‚­•²X‚É‚Å‚«‚Ä";
		mes "‚µ‚Ü‚¤‚¼c";
		next;
		mes "[ƒ_[ƒNƒ[ƒh]";
		mes "Ž„‚ª‹ï‚¦‚é–³ŒÀ‚Ì–‚—Í‚É‚æ‚Á‚Ä";
		mes "–Ø’[”÷o‚É‚µ‚Ä‚­‚ê‚æ‚¤I";
		next;
		if(select("–½‚¾‚¯‚Í•‚¯‚Ä‚­‚¾‚³‚¢I","ˆ«–‚‚ßI‘Þ‚«‚È‚³‚¢I")==2) {
			mes "[ƒ_[ƒNƒ[ƒh]";
			mes "Œ©‚©‚¯‚É‚æ‚ç‚¸c‚ª‹­‚¢‚æ‚¤‚¾‚Èc";
			next;
			mes "[ƒ_[ƒNƒ[ƒh]";
			mes "ŽŸ‚ÉŽ„‚Ì‘O‚É—§‚Á‚½Žž‚ÍA";
			mes "•K‚¸’n–‚ðŒ©‚¹‚Ä‚â‚ë‚¤‚¼c";
			close;
		}
	}
	mes "[ƒ_[ƒNƒ[ƒh]";
	mes "“ñ“x‚ÆŒ»‚ê‚é‚ÈI";
	next;
	warp "gl_church",145,170;
	end;
}

//==============================================================
job_prist,168,150,4	script	ƒoƒtƒHƒƒbƒg	736,5,0,{
	end;
OnTouch:
	if(Job != Job_Acolyte) {
		mes "[ƒoƒtƒHƒƒbƒg]";
		mes "lŠÔ‚©c‚»‚µ‚ÄƒvƒŠ[ƒXƒgc";
		next;
		mes "[ƒoƒtƒHƒƒbƒg]";
		mes "—p‚Í–³‚¢c";
		close;
	}
	mes "[ƒoƒtƒHƒƒbƒg]";
	mes "lŠÔ‚æc";
	next;
	mes "[ƒoƒtƒHƒƒbƒg]";
	mes "Žæˆø‚ð‚µ‚È‚¢‚©cH";
	next;
	mes "[ƒoƒtƒHƒƒbƒg]";
	mes "‰ä‚Í‚¨‘O‚É•x‚ÆŒ —Í‚ðŽö‚¯‚éB";
	mes "ˆê¶‚ÌŠÔ‚ÉŽg‚¢s‚­‚·‚±‚Æ‚Ì‚Å‚«‚Ê‹àc";
	mes "lŠÔ‚É‚Íì‚ê‚Ê•Šíc";
	next;
	mes "[ƒoƒtƒHƒƒbƒg]";
	mes "‚»‚µ‚Ä‚¨‘O‚ª–]‚ß‚ÎA‚¢‚Â‚Å‚à‰ä‚ð";
	mes "¢Š«‚·‚é‚±‚Æ‚ª‚Å‚«‚éB";
	mes "ŠF‚Í‚¨‘O‚Æ“G‘Î‚·‚é‚±‚Æ‚ð‹°‚êA";
	mes "‚â‚ª‚Ä‚Ð‚ê•š‚·‚¾‚ë‚¤c";
	next;
	mes "[ƒoƒtƒHƒƒbƒg]";
	mes "ƒvƒŠ[ƒXƒg‚Ö‚Ì“]E‚ð’ú‚ßA‰ä‚ÆŒ_–ñ‚ð";
	mes "Œ‹‚Ú‚¤‚¼B";
	mes "‚³‚·‚ê‚Î‚±‚Ì¢‚Í‚¨‘O‚Ì•¨‚Æ‚È‚éB";
	next;
	if(select("ƒvƒŠ[ƒXƒg‚Ö“]E‚µ‚Ü‚¹‚ñ","ˆ«–‚‚ßI‘Þ‚«‚È‚³‚¢I")==1) {
		mes "[ƒoƒtƒHƒƒbƒg]";
		mes "‚»‚ê‚Å‚ÍŒ_–ñ‚ðŒ‹‚Ú‚¤‚©c";
		mes "‰÷‚¢‚Ì–³‚¢‘I‘ð‚É‚È‚é‚¾‚ë‚¤c";
		next;
		mes "[ƒoƒtƒHƒƒbƒg]";
		mes "Ž„‚Ì‚Æ‚±‚ë‚Ü‚Å—ˆ‚È‚³‚¢c";
		mes "‚»‚±‚ÅŒ_–ñ‚ðŒ‹‚ÔŽ–‚É‚·‚éB";
		next;
		warp "glast_01",200,203;
		end;
	}
	mes "[ƒoƒtƒHƒƒbƒg]";
	mes "‚æ‚µc–]‚Ý‚Ç‚¨‚èÁ‚¦‚Ä‚â‚éc";
	mes "‚µ‚©‚µA‚¨‘O‚ào‚é‚Ì‚Í“ï‚µ‚©‚ë‚¤B";
	next;
	mes "[ƒoƒtƒHƒƒbƒg]";
	mes "“Á•Ê‚É‚¨‘O‚Ì‚½‚ß‚Éƒ‚ƒ“ƒXƒ^[’B‚ð—pˆÓ";
	mes "‚µ‚Ä‚¢‚éB‚Ç‚ê‚Ù‚Ç‚Ì‚à‚Ì‚©";
	mes "Œ©‚¹‚Ä‚à‚ç‚¤‚¼B";
	next;
	mes "[ƒoƒtƒHƒƒbƒg]";
	mes "‚Å‚Í‹A‚êc";
	close;
}

//==============================================================
job_prist,0,0,0	script	PR_Summon	-1,{
	end;
//‘æˆê’iŠK
OnEvent0:
	monster "job_prist",24,52,"•s“¿",1015,1,"PR_Summon::OnKilled";
	monster "job_prist",18,52,"•s’‰",1015,1,"PR_Summon::OnKilled";
	monster "job_prist",30,51,"“i‚Ý",1015,1,"PR_Summon::OnKilled";
	end;
OnEvent1:
	monster "job_prist",21,62,"“{‚è",1015,1,"PR_Summon::OnKilled";
	monster "job_prist",27,62,"‰…ª",1015,1,"PR_Summon::OnKilled";
	end;
OnEvent2:
	monster "job_prist",24,72,"˜ü–",1015,1,"PR_Summon::OnKilled";
	monster "job_prist",18,72,"î—~",1015,1,"PR_Summon::OnKilled";
	monster "job_prist",30,72,"‘Óî",1015,1,"PR_Summon::OnKilled";
	end;
OnEvent3:
	monster "job_prist",21,82,"æÃH",1015,1,"PR_Summon::OnKilled";
	monster "job_prist",27,82,"•n—~",1015,1,"PR_Summon::OnKilled";
	end;
OnEvent4:
	monster "job_prist",24,92,"â–]",1015,1,"PR_Summon::OnKilled";
	monster "job_prist",18,92,"•sM",1015,1,"PR_Summon::OnKilled";
	monster "job_prist",30,92,"‹°•|",1015,1,"PR_Summon::OnKilled";
	end;
//‘æŽO’iŠK
OnEvent5:
	monster "job_prist",90,55,"ƒAƒ‚[ƒY",1041,1;
	monster "job_prist",105,54,"ƒAƒ}ƒVƒX",1041,1;
	end;
OnEvent6:
	monster "job_prist",90,70,"ƒƒlƒg",1041,1;
	monster "job_prist",105,70,"ƒAƒnƒ}ƒh",1041,1;
	end;
OnEvent7:
	monster "job_prist",90,85,"ƒƒlƒX",1041,1;
	monster "job_prist",105,85,"ƒlƒyƒX",1041,1;
	end;
OnKilled:
	set .count,.count+1;
	end;
}

//==============================================================
job_prist,24,51,0	script	PR_Test#0	139,16,0,{
	set .@num,strnpcinfo(2);
	if(Job == Job_Acolyte && @priest_check == .@num) {
		donpcevent "PR_Summon::OnEvent"+.@num;
		set @priest_check,.@num+1;
	}
	end;
}

job_prist,24,61,0	duplicate(PR_Test#0)	PR_Test#1	139,16,0
job_prist,24,71,0	duplicate(PR_Test#0)	PR_Test#2	139,16,0
job_prist,24,81,0	duplicate(PR_Test#0)	PR_Test#3	139,16,0
job_prist,24,91,0	duplicate(PR_Test#0)	PR_Test#4	139,16,0
job_prist,98,54,0	duplicate(PR_Test#0)	PR_Test#5	139,8,0
job_prist,98,69,0	duplicate(PR_Test#0)	PR_Test#6	139,8,0
job_prist,98,84,0	duplicate(PR_Test#0)	PR_Test#7	139,8,0


//==========================================
// ŽOŽŸŽŽŒ±i•òŽd¾–ñj
//------------------------------------------

prt_church,27,24,4	script	C“¹—	79,{
	if(Upper == UPPER_HIGH) {
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚ ‚È‚½‚Í“]¶‚³‚ê‚Ä‚¢‚Ü‚·‚Ì‚Å";
		mes "‚±‚±‚Å‚Í“]EˆÄ“à‚Å‚«‚Ü‚¹‚ñB";
		close;
	}
	if(Job == Job_Novice) {
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚è‚Ü‚·‚æ‚¤‚Éc";
		mes "ƒvƒƒ“ƒeƒ‰‘å¹“°‚Í‚ ‚È‚½‚ðŠ½Œ}‚µ‚Ü‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚Ü‚¾E‹Æ‚ðŒˆ‚ß‚Ä‚¢‚Ü‚¹‚ñ‚©H";
		mes "¹EŽÒ‚É‚È‚é‚Ì‚Í‚¢‚©‚ª‚Å‚µ‚å‚¤B";
		mes "ƒAƒRƒ‰ƒCƒg‚É‚È‚Á‚Ä‘¼‚ÌlX‚ð•‚¯";
		mes "‚È‚ª‚ç¶‚«‚Äs‚­‚±‚Æ‚ÍA–{“–‚É";
		mes "‘f°‚ç‚µ‚¢‚±‚Æ‚Å‚·‚æB";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "ƒAƒRƒ‰ƒCƒg‚Ö‚Ì“]E‚É‚Â‚¢‚Ä‚ÍA";
		mes "”½‘Î‘¤‚Ì•”‰®‚É‚¢‚é_•ƒ‚³‚ñ‚É";
		mes "‚¨˜b‚ð‚µ‚Ä‚Ý‚Ä‚­‚¾‚³‚¢B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "ƒAƒRƒ‰ƒCƒg‚Å”MS‚ÉCs‚ðÏ‚ÝA";
		mes "JobLv40ˆÈã‚É‚È‚ç‚ê‚Ü‚µ‚½‚ç";
		mes "‚±‚¿‚ç‚ÅƒvƒŠ[ƒXƒg“]E‚Ì‹V‚ð";
		mes "Žó‚¯‚é‚±‚Æ‚ª‚Å‚«‚Ü‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚Ü‚¾ƒm[ƒrƒX‚Å‚·‚©‚çA‚ä‚Á‚­‚è‚Æ";
		mes "l‚¦‚é‚Ì‚ª—Ç‚¢‚Å‚µ‚å‚¤B";
		mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚è‚Ü‚·‚æ‚¤‚Éc";
		close;
	}
	if(Job == Job_Priest) {
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚è‚Ü‚·‚æ‚¤‚Éc";
		mes "¡“ú‚à—Ç‚¢ˆê“ú‚É‚È‚Á‚Ä‚Ù‚µ‚¢‚Å‚·‚ËB";
		close;
	}
	if(Job != Job_Acolyte) {
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚±‚¿‚ç‚Íƒvƒƒ“ƒeƒ‰‘å¹“°‚Å‚·B";
		mes "‚Ç‚Ì‚æ‚¤‚È—p‚Å‚¨–K‚Ë‚É‚È‚è‚Ü‚µ‚½‚©H";
		next;
		if(select("ƒvƒŠ[ƒXƒg‚É‚Â‚¢‚Ä‹³‚¦‚Ä‚­‚¾‚³‚¢","­‚µŠñ‚Á‚Ä‚Ý‚Ü‚µ‚½")==2) {
			mes "[ƒZƒVƒ‹C“¹—]";
			mes "‚ä‚Á‚­‚è‹x‚ñ‚Å‚¢‚©‚ê‚Ä‚­‚¾‚³‚¢B";
			mes "_‚Ö‚ÌŠ´ŽÓ‚Í‚Ç‚¤‚©–Y‚ê‚¸‚ÉB";
			next;
			mes "[ƒZƒVƒ‹C“¹—]";
			mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚è‚Ü‚·‚æ‚¤‚Éc";
			close;
		}
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "ƒvƒŠ[ƒXƒg‚Æ‚Æ‚ÍAM‹`‚ðà‚­";
		mes "_‚Ì‘ã•ÙŽÒ‚È‚Ì‚Å‚·B";
		mes "ƒm[ƒrƒX‚©‚ç‚Ü‚¸ƒAƒRƒ‰ƒCƒg‚É‚È‚èA";
		mes "Cs‚ðÏ‚ñ‚¾ŽÒ‚¾‚¯‚ªƒvƒŠ[ƒXƒg‚É";
		mes "‚È‚é‚±‚Æ‚ª‚Å‚«‚Ü‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "¹EŽÒ’B‚É‚ÍA‰s‚¢n‚ðŽ‚Á‚½•Ší‚ð";
		mes "Žg—p‚·‚é‚±‚Æ‚ª‹Ö‚¶‚ç‚ê‚Ä‚¢‚Ü‚·B";
		mes "‰½ŒÌ‚È‚çAƒ‚ƒ“ƒXƒ^[‚ðUŒ‚‚·‚é–Ú“I‚Í";
		mes "ŽE¶‚Å‚Í‚È‚­A‹³‰»‚¾‚©‚ç‚Å‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚à‚¿‚ë‚ñAƒvƒŠ[ƒXƒg’B‚É‰ï‚Á‚Ä’¼Ú";
		mes "‚¨˜b‚ð•·‚­‚Ì‚à—Ç‚¢‚Å‚µ‚å‚¤‚¯‚ÇA";
		mes "‰œ‚É‚¢‚ç‚Á‚µ‚á‚¢‚Ü‚·ƒg[ƒ}ƒXŽi‹³—l‚É";
		mes "Žf‚Á‚Ä‚Ý‚Ä‚Í‚¢‚©‚ª‚Å‚µ‚å‚¤B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "Ž„‚æ‚èÚ‚µ‚­‚¨˜b‚ª•·‚¯‚é‚ÆŽv‚¢‚Ü‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚è‚Ü‚·‚æ‚¤‚Éc";
		close;
	}
	switch(CHANGE_PR) {
	case 0:
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚è‚Ü‚·‚æ‚¤‚Éc";
		mes "‚Ç‚Ì‚æ‚¤‚È—p‚Å‚¨–K‚Ë‚É‚È‚è‚Ü‚µ‚½‚©H";
		next;
		if(select("ƒvƒŠ[ƒXƒg‚É“]E‚µ‚½‚¢‚Ì‚Å‚·","“Á‚É‚²—p‚Í‚ ‚è‚Ü‚¹‚ñ")==2) {
			mes "[ƒZƒVƒ‹C“¹—]";
			mes "‚ä‚Á‚­‚è‹x‚ñ‚Å‚¢‚©‚ê‚Ä‚­‚¾‚³‚¢B";
			mes "¹“°‚Í‚ ‚È‚½•û‚É‚Í‰Æ‚Ì‚æ‚¤‚È";
			mes "‚à‚Ì‚Å‚·B‹CŒ“‚Ë‚È‚­‚¢‚Â‚Å‚à";
			mes "‚¢‚ç‚µ‚Ä‚­‚¾‚³‚¢B";
			next;
			mes "[ƒZƒVƒ‹C“¹—]";
			mes "‚»‚µ‚Ä¡“x‚¢‚ç‚Á‚µ‚á‚éŽž‚ÍA";
			mes "¥”ñ‘¼‚ÌƒAƒRƒ‰ƒCƒg’B‚Ì‚²—lŽq‚à";
			mes "•·‚©‚¹‚Ä‚­‚¾‚³‚¢‚ËB";
			mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚è‚Ü‚·‚æ‚¤‚ÉB";
			close;
		}
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚ AƒvƒŠ[ƒXƒg‚Ö‚Ì“]E‚Å‚·‚©I";
		mes "‚½‚­‚³‚ñ‚ÌƒAƒRƒ‰ƒCƒg—l‚ªƒvƒŠ[ƒXƒg‚É";
		mes "‚È‚ç‚ê‚é‚Ì‚ð“úX–²Œ©‚Ä‚¨‚è‚Ü‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "Ž„‚Ì–¼‘O‚ÍƒZƒVƒ‹=ƒ}ƒ‹ƒKƒŠ[ƒ^B";
		mes "ƒAƒRƒ‰ƒCƒg—l’B‚Ì“]E‚ð‚¨Žè“`‚¢";
		mes "‚µ‚Ä‚¢‚éC“¹—‚Å‚·B";
		mes "‚ ‚È‚½‚Ì‚¨–ð‚É—§‚Ä‚ê‚Î‚ÆŽv‚¢‚Ü‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "Ž„‚Í‚±‚¿‚ç‚Åˆç‚Á‚½‚¹‚¢‚©‘½‚­‚Ì•ûX‚ª";
		mes "ƒvƒŠ[ƒXƒg‚É“]E‚·‚é‚Ì‚ðŒ©‚Ä‚«‚Ü‚µ‚½";
		mes "B";
		mes "‚»‚µ‚Ä¡‚ÍƒvƒŠ[ƒXƒg‚É‚È‚ë‚¤‚Æ‚·‚é";
		mes "•ûX‚ð‚¨Žè“`‚¢‚µ‚Ä‚¢‚Ü‚·c";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "ƒvƒŠ[ƒXƒg“]E‚Ì‚½‚ß‚É‚Í”X‚ÌŽŽ—û‚ð";
		mes "æ‚è‰z‚¦‚È‚¯‚ê‚Î‚È‚è‚Ü‚¹‚ñB";
		mes "¹’n„—çE‘Þ–‚C—ûE•òŽd‚Ì¾–ñc";
		mes "‚»‚ê‚ç‚ð‚·‚×‚Ä‚±‚È‚µ‚Ä‚Í‚¶‚ß‚Ä";
		mes "ƒvƒŠ[ƒXƒg‚É‚È‚é‚±‚Æ‚ª”F‚ß‚ç‚ê‚Ü‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "“]E‚ð‚²Šó–]‚Å‚µ‚½‚ç‰œ‚É‚¢‚ç‚Á‚µ‚á‚é";
		mes "ƒg[ƒ}ƒXŽi‹³—l‚Ì‚Æ‚±‚ë‚Ös‚Á‚ÄA";
		mes "“]E‚·‚é‚½‚ß‚ÌŽŽ—û‚ðŽó‚¯‚Ä‚ç‚µ‚Ä";
		mes "‚­‚¾‚³‚¢B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‰½‚©“ï‚µ‚¢“_‚ª‚²‚´‚¢‚Ü‚µ‚½‚çA";
		mes "Ž„‚Éq‚Ë‚Ä‚­‚¾‚³‚¢‚ËB";
		mes "Ž„‚É‚Å‚«‚é‚±‚Æ‚È‚ç‰½‚Å‚à‚¨Žè“`‚¢";
		mes "’v‚µ‚Ü‚·B";
		close;
	case 1:
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "„—ç‚Ì—·‚ªŽn‚Ü‚è‚Ü‚µ‚½‚ËB";
		mes "‘å•Ï‚Å‚·‚ªAÅŒã‚Ü‚ÅŠæ’£‚Á‚Ä";
		mes "‚­‚¾‚³‚¢B";
		mes "‰‚ß‚ÉŒü‚©‚¤‚Æ‚±‚ë‚Í";
		mes "ƒ‹ƒoƒ‹ƒJƒoƒ‰_•ƒ—l‚Ì‚Æ‚±‚ë‚Å‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚»‚Ì•û‚Ì‚¢‚ç‚Á‚µ‚á‚é‚Æ‚±‚ë‚ÍA";
		mes "ƒvƒƒ“ƒeƒ‰‚©‚ç–k“Œ‚Ì•ûŠp‚É‚ ‚é";
		mes "ˆâÕ‚Ì“ü‚èŒû‚Å‚·B";
		mes "‚»‚±‚ª„—ç’n‚Æ‚È‚è‚Ü‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚»‚Ì•û‚Ì‚¢‚ç‚Á‚µ‚á‚é’nˆæ‚É‚ÍA";
		mes "‰Ž‚½‚¿‚ª‚½‚­‚³‚ñZ‚ñ‚Å‚¢‚Ü‚·B";
		mes "‚½‚Ü‚É‹¥–\‚È‰Ž‚Å‚ ‚éƒ`ƒ‡ƒR‚Æ‚¢‚¤";
		mes "lŠÔ‚ðP‚¤ƒ‚ƒ“ƒXƒ^[‚ª‚¢‚Ü‚·‚©‚ç";
		mes "‚»‚ê‚¾‚¯‚Í‹C‚ð‚Â‚¯‚Ä‚­‚¾‚³‚¢B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "ƒ‹ƒoƒ‹ƒJƒoƒ‰_•ƒ—l‚É‚¨‰ï‚¢‚É";
		mes "‚È‚Á‚Ä‚©‚çAƒ}ƒ`ƒ‹ƒ_ƒVƒXƒ^[—l‚Æ";
		mes "—m‰î_•ƒ—l‚É‰ï‚Á‚Ä‚­‚¾‚³‚ê‚Î";
		mes "—Ç‚¢‚Å‚·B‚à‚¿‚ë‚ñA“r’†‚Å‚±‚¿‚ç‚É";
		mes "‚¨Šñ‚è‚É‚È‚Á‚ÄŠm”F‚³‚ê‚Ä‚à‚æ‚ë‚µ‚¢";
		mes "‚Å‚·‚æB";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚»‚ê‚Å‚ÍA‚¢‚Á‚Ä‚ç‚Á‚µ‚á‚¢‚Ü‚¹B";
		mes "’ú‚ß‚¸AÅŒã‚Ü‚Å‚â‚è‹‚°‚Ä";
		mes "‚­‚¾‚³‚¢B—·‚ÌˆÀ‘S‚ð‚¨‹F‚è‚µ‚Ü‚·B";
		close;
	case 2:
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "ƒ‹ƒoƒ‹ƒJƒoƒ‰_•ƒ—l‚É‚¨‰ï‚¢‚É";
		mes "‚È‚è‚Ü‚µ‚½‚ËB‚»‚¤‚µ‚Ü‚µ‚½‚ç¡“x‚Í";
		mes "ƒ}ƒ`ƒ‹ƒ_ƒVƒXƒ^[—l‚É‚¨‰ï‚¢‚­‚¾‚³‚¢B";
		mes "”Þ—‚Íƒ‚ƒƒN‚Æ‚¢‚¤ŠX‚Ì‹ß‚­‚É";
		mes "‚¢‚ç‚Á‚µ‚á‚¢‚Ü‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "ƒ‚ƒƒN–k‚Ì»”™‚ÅCs’†‚¾‚ÆŽf‚Á‚Ä";
		mes "‚Ü‚·B‚¨‚»‚ç‚­c–k¼‚Ì•û‚ð‚æ‚­‚¨’T‚µ";
		mes "‚É‚È‚ê‚ÎŒ©‚Â‚©‚é‚ÆŽv‚¢‚Ü‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "Ž„‚à‘¼‚Ì•ûX‚Ì‚æ‚¤‚ÉCs‚Éo‚½‚¢";
		mes "‚Ì‚Å‚·‚ªA‚±‚±‚ÅŠF—l‚Ì‚¨Žè“`‚¢‚ð";
		mes "‚·‚é‚±‚Æ‚à‘åŽ–‚È–ð–Ú‚Å‚·‚©‚çA";
		mes "‚±‚ê‚àM‹`‚ÌˆêŠÂ‚Å‚µ‚å‚¤B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚»‚ê‚Å‚ÍA‚¢‚Á‚Ä‚ç‚Á‚µ‚á‚¢‚Ü‚¹B";
		mes "’ú‚ß‚¸AÅŒã‚Ü‚Å‚â‚è‹‚°‚Ä";
		mes "‚­‚¾‚³‚¢B—·‚ÌˆÀ‘S‚ð‚¨‹F‚è‚µ‚Ü‚·B";
		close;
	case 3:
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚Í‚¢A‚ ‚Æ‚Í—m‰î_•ƒ—l‚É‚¨‰ï‚¢‚É";
		mes "‚È‚ê‚Î„—ç‚Ì—·‚ÍI‚í‚è‚Æ‚È‚è‚Ü‚·B";
		mes "ƒvƒƒ“ƒeƒ‰‚©‚ç–k¼•û–Ê‚ÌŒÎ‚Ì‹ß‚­‚É";
		mes "‚¢‚ç‚Á‚µ‚á‚é‚Æ•·‚«‚Ü‚µ‚½B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "æ‚É¼‚Ì•û‚É”²‚¯‚½‚Ù‚¤‚ªA“¹‚Ì‚è‚Í";
		mes "ˆÕ‚µ‚¢‚ÆŽv‚¢‚Ü‚·‚íB";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "„—ç‚ªI‚í‚Á‚Ä‚àŽŽ—û‚Í‚Ü‚¾‘±‚«‚Ü‚·‚ª";
		mes "ÅŠú‚Ü‚Å•K‚¸‚â‚è‹‚°‚é‚±‚Æ‚ð";
		mes "Šè‚Á‚Ä‚¨‚è‚Ü‚·cB";
		close;
	case 4:
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚¨‹A‚è‚È‚³‚¢B";
		mes "’·‚¢—·A‚¨”æ‚ê—l‚Å‚µ‚½B";
		mes "‚»‚ê‚Å‚ÍŽi‹³—l‚Ì‚Æ‚±‚ë‚ÖB";
		mes "ŽŽ—û‚ÍŽŸ‚Ì’iŠK‚Ö‚Æi‚Ý‚Ü‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‘Þ–‚C—û‚Í‘å•Ï‚Å‚·‚ªA";
		mes "‚ ‚È‚½‚È‚ç‚«‚Á‚Æ‘åä•v‚Å‚·I";
		mes "Ž„‚à‚¨Žè“`‚¢‚µ‚½‚¢‚ñ‚Å‚·‚ªA";
		mes "‚±‚±‚Ö—ˆ‚éƒAƒRƒ‰ƒCƒg—l‚Ì•‚¯";
		mes "‚É‚È‚Á‚Ä‚ ‚°‚È‚­‚Ä‚Í‚È‚è‚Ü‚¹‚ñB";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "C—û‚ð•‚¯‚Ä‚­‚ê‚é•û‚ðŒ©‚Â‚¯‚é‚Ì‚à";
		mes "—Ç‚¢‚Å‚µ‚å‚¤B";
		mes "‚»‚ê‚Å‚ÍAˆø‚«‘±‚«Šæ’£‚Á‚Ä‚­‚¾‚³‚¢B";
		close;
	case 5:
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‘Þ–‚C—û‚Í‚Ç‚¤‚µ‚Ü‚µ‚½‚©H";
		mes "‚Ç‚ñ‚ÈŽŽ—û‚É‚È‚é‚©‚ÍŽ„‚Å‚à";
		mes "Ú‚µ‚­Œ¾‚¦‚Ü‚¹‚ñcB";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚½‚¾A€”õ‚ð‚µ‚Á‚©‚è‚µ‚Ä—Õ‚Þ‚±‚Æ‚ÆA";
		mes "”Ï”Y‚â—~–]‚Ég‚ð“Š‚¶‚È‚¢¸_—Í‚ª";
		mes "•K—v‚Æ‚È‚é‚Å‚µ‚å‚¤B";
		mes "Ž©•ªŽ©g‚ð‚µ‚Á‚©‚è‚Æ•Û‚Â‚±‚Æ‚ª";
		mes "‚Å‚«‚ê‚Î‘åä•v‚Å‚µ‚å‚¤B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "Ú‚µ‚¢‚±‚Æ‚ÍAC—ûê‚É‚¢‚ç‚Á‚µ‚á‚é";
		mes "ƒs[ƒ^[_•ƒ—l‚ÉŽf‚Á‚Ä‚­‚¾‚³‚¢B";
		mes "ƒg[ƒ}ƒXŽi‹³—l‚Æ‚àe‚µ‚¢ŠÔ•¿‚Å‚·‚©‚ç";
		mes "‚æ‚­‹³‚¦‚Ä‚­‚ê‚é‚ÆŽv‚¢‚Ü‚·B";
		close;
	case 6:
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‘å•Ï‚Å‚·‚ªA’ú‚ß‚Ä‚Í‚È‚è‚Ü‚¹‚ñB";
		mes "‚Ç‚ñ‚È”Ï”Y‚â—U˜f‚É‚à•‰‚¯‚È‚¢";
		mes "‹­‚¢S‚ª‚ ‚ê‚ÎAƒvƒŠ[ƒXƒg‚É";
		mes "‚È‚ê‚é‚Å‚µ‚å‚¤B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‘¼‚Ìæ”yƒvƒŠ[ƒXƒg—l‚ª’Ê‚ç‚ê‚½‚ç";
		mes "‚¨Šè‚¢‚µ‚Ä•‚¯‚Ä‚¢‚½‚¾‚­‚Ì‚à—Ç‚¢";
		mes "‚Å‚µ‚å‚¤B";
		mes "‘Þ–‚C—û‚Ì‰’iŠK‚Ü‚Å‚ÍŽè“`‚Á‚Ä";
		mes "‚¢‚½‚¾‚­‚±‚Æ‚ª‚Å‚«‚Ü‚·‚µB";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚è‚Ü‚·‚æ‚¤‚Éc";
		mes "‘Þ–‚C—û‚ªI‚í‚è‚Ü‚µ‚½‚çA‚Ü‚½";
		mes "Ž„‚Ì‚Æ‚±‚ë‚É‹A‚Á‚Ä‚«‚Ä‚­‚¾‚³‚¢‚ËB";
		close;
	case 7:
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‹ê˜J‚È‚³‚¢‚Ü‚µ‚½‚ËI";
		mes "‚Å‚àA“]EŽŽ—û‚ÌÅI’iŠK‚Ü‚Å—ˆ‚é";
		mes "‚±‚Æ‚ª‚Å‚«‚Ü‚µ‚½B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚»‚ê‚Å‚ÍA‚ ‚È‚½‚ðƒvƒŠ[ƒXƒg‚É";
		mes "“]E‚³‚¹‚é‚½‚ß‚Ì¾–ñŽ®‚ð";
		mes "Žn‚ß‚½‚¢‚ÆŽv‚¢‚Ü‚·B";
		mes "Ž„‚ÌŽ¿–â‚É‘Î‚µ‚ÄA^Œ•‚É“š‚¦‚Ä";
		mes "‚­‚¾‚³‚¢‚ËB";
		break;
	case 8:
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "cc";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚¨‹A‚è‚É‚È‚ç‚ê‚Ü‚µ‚½‚ËB";
		mes "¡“x‚Í¾–ñ‚ð‚µ‚Á‚©‚è‚ÆŒ‹‚ñ‚Å";
		mes "‚¢‚½‚¾‚«‚½‚¢‚Å‚·c";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚ ‚È‚½‚ÌM‹`‚ª“`‚í‚é‚æ‚¤‚Éc";
		mes "^Œ•‚ÉŽó‚¯“š‚¦‚ð‚µ‚Ä‚­‚¾‚³‚¢B";
		break;
	case 9:
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚·‚×‚Ä‚ÌŽŽ—û‚ªI‚í‚è‚Ü‚µ‚½c";
		mes "ƒg[ƒ}ƒXŽi‹³—l‚ÌŒ³‚Ös‚©‚êA";
		mes "ƒvƒŠ[ƒXƒg‚Æ‚Æ‚µ‚Ä¶‚Ü‚ê•Ï‚í‚Á‚Ä";
		mes "‚­‚¾‚³‚¢B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚è‚Ü‚·‚æ‚¤‚ÉB";
		close;
	}
	//7,8‚Ì‚Æ‚«‘±‚«
	next;
	set CHANGE_PR,8;
	mes "[ƒZƒVƒ‹C“¹—]";
	mes "‚»‚ê‚Å‚ÍŽn‚ß‚Ü‚·B";
	next;
	mes "[ƒZƒVƒ‹C“¹—]";
	mes "‚ ‚È‚½‚ÍAŽc‚è‚Ìl¶‚ð_‚Ì‚½‚ß‚É";
	mes "•ù‚°‚é‚±‚Æ‚ª‚Å‚«‚Ü‚·‚©H";
	next;
	if(select("‚Í‚¢","‚¢‚¢‚¦")==2) {
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚È‚º‚»‚ñ‚È•ÔŽ–‚ðc";
		mes "‚Ü‚¾ƒvƒŠ[ƒXƒg‚É‚È‚é‚½‚ß‚Ì";
		mes "S\‚¦‚ª‘«‚è‚È‚¢‚æ‚¤‚Å‚·c";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚à‚¤­‚µŽ©•ªŽ©g‚ðŒ©‚Â‚ß‚È‚¨‚µ‚Ä";
		mes "‚¢‚ç‚Á‚µ‚á‚Á‚Ä‚­‚¾‚³‚¢B";
		mes "‚»‚¤‚¢‚Á‚½S\‚¦‚Å‚ÍA‚«‚Á‚Æˆ«‚É";
		mes "S‚ð’D‚í‚ê‚Ä‚µ‚Ü‚¤‚Å‚µ‚å‚¤B";
		close;
	}
	mes "[ƒZƒVƒ‹C“¹—]";
	mes "‚ ‚È‚½‚ÍA”\—Í‚ðŽ©•ªŽ©g‚Ì‚½‚ß‚É";
	mes "Žg‚Á‚ÄA—˜‚ð“¾‚æ‚¤‚Æ‚µ‚Ü‚·‚©H";
	next;
	if(select("‚Í‚¢","‚¢‚¢‚¦")==1) {
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚È‚è‚Ü‚¹‚ñB";
		mes "Ž„’B‚ª“¾‚½”\—Í‚ÍA—˜‚Ì‚½‚ß‚É";
		mes "‚ ‚é‚Ì‚Å‚Í‚ ‚è‚Ü‚¹‚ñB";
		mes "‚»‚ñ‚Èl‚¦‚Å‚ ‚È‚½‚ÍƒvƒŠ[ƒXƒg‚É";
		mes "‚È‚ë‚¤‚ÆŽv‚Á‚½‚Ì‚Å‚·‚©B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "ƒvƒŠ[ƒXƒg‚É‚Â‚¢‚ÄA‚à‚Á‚Æ‚æ‚­";
		mes "l‚¦‚Ä‚¢‚ç‚µ‚Ä‚­‚¾‚³‚¢B";
		mes "‚»‚ñ‚ÈS\‚¦‚Å‚ÍA‚½‚¾¢—~‚É";
		mes "õ‚Ü‚Á‚Ä‚µ‚Ü‚¤‚¾‚¯‚Å‚·B";
		close;
	}
	mes "[ƒZƒVƒ‹C“¹—]";
	mes "‚ ‚È‚½‚ÍAí“¬‚Å‹ê‚µ‚ñ‚Å‚¢‚é‘¼l‚ð";
	mes "Ž©•ª‚Ì”\—Í‚Å•‚¯‚æ‚¤‚Æ‚µ‚Ü‚·‚©H";
	next;
	if(select("‚Í‚¢","‚¢‚¢‚¦")==2) {
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚»‚ê‚Å‚Í‚È‚è‚Ü‚¹‚ñB";
		mes "ƒvƒŠ[ƒXƒg‚Ì”\—Í‚ÍAl‚ð•‚¯‚é‚à‚Ì";
		mes "‚Æ‚µ‚Ä‚ ‚é‚Ì‚Å‚·c";
		mes "‚Ç‚ñ‚Èl‚Å‚ ‚ë‚¤‚ÆA•‚¯‚ð‹‚ß‚éŽÒ‚ª";
		mes "‚¢‚½‚ç•‚¯‚é‚Ì‚ª–±‚ß‚È‚Ì‚Å‚·c";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "Žü‚è‚ÌlX‚ð‚æ‚­Œ©‚Ä‚²‚ç‚ñ‚È‚³‚¢c";
		mes "lX‚É‹ê‚µ‚Ý‚ªŒ©‚¦‚é‚Í‚¸‚Å‚·c";
		close;
	}
	mes "[ƒZƒVƒ‹C“¹—]";
	mes "‚ ‚È‚½‚Í‘¼l‚ð•‚¯AŽ©•ª‚ð‹]µ‚É";
	mes "‚·‚é‚±‚Æ‚ª‚Å‚«‚Ü‚·‚©H";
	next;
	if(select("‚Í‚¢","‚¢‚¢‚¦")==2) {
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "c‚¢‚¢‚¦B";
		mes "Ž©•ªŽ©g‚ð‹]µ‚É‚µ‚Ä‚àA";
		mes "‘¼l‚ð•‚¯‚é‚±‚Æ‚Í—§”h‚È‚±‚Æ‚Å‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‹]µ‚Æ‚¢‚¤Œ¾—t‚ð‚æ‚­l‚¦‚Ä‚­‚¾‚³‚¢B";
		mes "‘¼l‚És‚­‚·‚Æ‚¢‚¤ˆÓ–¡‚Å‚Í‚±‚êˆÈã‚Ì";
		mes "sˆ×‚Í‚ ‚è‚Ü‚¹‚ñc";
		close;
	}
	mes "[ƒZƒVƒ‹C“¹—]";
	mes "‚ ‚È‚½‚ÍŠX‚âŠO‚Åu“¯‚¶Œ¾—tv‚ð";
	mes "ŒJ‚è•Ô‚µ‚µ‚á‚×‚è‚È‚ª‚ç•à‚«‚Ü‚·‚©H";
	next;
	if(select("‚Í‚¢","‚¢‚¢‚¦")==1) {
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚È‚è‚Ü‚¹‚ñB‚±‚ê‚ÍƒvƒŠ[ƒXƒg‚É";
		mes "‘Î‚µ‚Ä‚¾‚¯‚Å‚Í‚È‚­A‘¼‚Ì•ûX‚É‚à";
		mes "Œ¾‚¦‚é‚±‚Æ‚Å‚·B";
		mes "‚¤‚é‚³‚­‹©‚ñ‚Å•à‚¢‚Ä‚àA’N‚àU‚è";
		mes "•Ô‚Á‚Ä•·‚¢‚Ä‚­‚ê‚Ü‚¹‚ñB";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "“¹‚ðà‚­‚ÆŒ¾‚Á‚Ä‚à‚»‚Ì‚æ‚¤‚È";
		mes "‚â‚è‚©‚½‚ÍŠÔˆá‚Á‚Ä‚¢‚Ü‚·B";
		mes "Ž©•ªŽ©g‚Ìs“®‚ð‚à‚¤ˆê“x‚æ‚­";
		mes "U‚è•Ô‚Á‚Ä‚Ý‚Ä‚­‚¾‚³‚¢c";
		close;
	}
	mes "[ƒZƒVƒ‹C“¹—]";
	mes "‚ ‚È‚½‚Í‘½‚­‚Ìƒ‚ƒ“ƒXƒ^[‚ðˆø‚«˜A‚ê‚é";
	mes "‚±‚Æ‚É‚æ‚Á‚Ä‘¼l‚ð•‚¯‚Ü‚·‚©H";
	next;
	if(select("‚Í‚¢","‚¢‚¢‚¦")==1) {
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚»‚ê‚Í‘å•ÏŠëŒ¯‚Èsˆ×‚Å‚·B";
		mes "Ž©•ª‚¾‚¯‚Å‚Í‚È‚­A‘¼l‚àŠª‚«ž‚Þ";
		mes "Ž–‘Ô‚É‚È‚è‚©‚Ë‚Ü‚¹‚ñB";
		mes "—Ç‚¢ƒ‚ƒ“ƒXƒ^[Eˆ«‚¢ƒ‚ƒ“ƒXƒ^[‚É";
		mes "ŒÀ‚ç‚¸‚Å‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "Ž©•ª‚Í‘¼l‚ð•‚¯‚½‚Â‚à‚è‚Å‚àA";
		mes "‚»‚Ì•ûA‚à‚µ‚­‚Í‚»‚ÌŽüˆÍ‚Ì•û‚ª";
		mes "•K‚¸‚µ‚à‹~‚í‚ê‚é‚í‚¯‚Å‚Í‚ ‚è‚Ü‚¹‚ñB";
		mes "–{“–‚É‘¼l‚ð•‚¯‚é‚Æ‚¢‚¤sˆ×‚ª";
		mes "‚Ç‚¤‚¢‚¤‚±‚Æ‚È‚Ì‚©‚ð‚à‚¤ˆê“x";
		mes "‚¨l‚¦‚­‚¾‚³‚¢B";
		close;
	}
	mes "[ƒZƒVƒ‹C“¹—]";
	mes "‚ ‚È‚½‚ÍM‹`‚Ì“¹‚ð‚Â‚ç‚Ê‚«A";
	mes "M‹`‚Ì‚½‚ß‚ÉŽ€‚Ê‚±‚Æ‚ª‚Å‚«‚Ü‚·‚©H";
	next;
	if(select("‚Í‚¢","‚¢‚¢‚¦")==2) {
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚»‚¤‚¢‚¤S\‚¦‚Å‚ÍAƒvƒŠ[ƒXƒg‚É";
		mes "‚È‚é‚±‚Æ‚Í‚Å‚«‚Ü‚¹‚ñB";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "Ž„’B‚É‚ÍA‘h¶‚Ì”\—Í‚à‚ ‚è‚Ü‚·B";
		mes "¶‚ÆŽ€‚ª‚ ‚È‚½‚É‚Æ‚Á‚Ä‚Ç‚¤‚¢‚¤";
		mes "ˆÓ–¡‚ð‚È‚·‚©‚æ‚­l‚¦‚Ä‚­‚¾‚³‚¢B";
		close;
	}
	mes "[ƒZƒVƒ‹C“¹—]";
	mes "‚ ‚È‚½‚Ì¾–ñ‚ðŽó‚¯‚Ü‚µ‚½B";
	mes "ÅŒã‚ÉA‚±‚ê‚Ü‚Åq‚×‚½‚±‚Æ‚ð";
	mes "‘S‚Ä¾‚¢‚Ü‚·‚©H";
	next;
	if(select("¾‚¢‚Ü‚·","‚¢‚¢‚¦")==2) {
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "cc";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚Ü‚¾AS\‚¦‚ª•s\•ª‚Ì‚æ‚¤‚Å‚·‚ËB";
		mes "ƒvƒŠ[ƒXƒg‚É‚È‚é‚Ì‚Í‚Ü‚¾‘‚¢‚Å‚·B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "Ä‚Ñ„—ç‚©‚ç‚¨Šè‚¢‚µ‚½‚¢‚Æ‚±‚ë‚Å‚·‚ª";
		mes "‚æ‚­Ž©•ªŽ©g‚ðÈ‚ÝAŒˆˆÓ‚ðŒÅ‚ß‚Ä‚©‚ç";
		mes "Ž„‚Ì‚Æ‚±‚ë‚É‚¨‰z‚µ‚­‚¾‚³‚¢B";
		next;
		mes "[ƒZƒVƒ‹C“¹—]";
		mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚è‚Ü‚·‚æ‚¤‚Éc";
		close;
	}
	set CHANGE_PR,9;
	mes "[ƒZƒVƒ‹C“¹—]";
	mes "‚±‚ê‚É‚¨‚«‚Ü‚µ‚Ä¾–ñŽ®‚ð";
	mes "I‚í‚è‚Ü‚·B";
	mes "ƒg[ƒ}ƒXŽi‹³—l‚Ì‚à‚Æ‚Ös‚©‚ê‚Ä";
	mes "ÅŒã‚Ì‹V‚ðŽó‚¯‚Ä‚­‚¾‚³‚¢B";
	next;
	mes "[ƒZƒVƒ‹C“¹—]";
	mes "‚¢‚Â‚à–Y‚ê‚È‚¢‚Å‚­‚¾‚³‚¢c";
	mes "Ž„’B‚ÍŒZ’íŽo–…‚Æ‚µ‚Ä‹¤‚É‚ ‚é";
	mes "‚±‚Æ‚ðc";
	mes "‚ ‚È‚½‚É_‚Ì‚²‰ÁŒì‚ª‚ ‚è‚Ü‚·‚æ‚¤‚Éc";
	close;
}
