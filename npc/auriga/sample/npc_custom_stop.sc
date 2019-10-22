prontera,0,0,0	script	停止	-1,{
	end;
OnInit:
	announce "1分後にサーバーを停止します。", 0;
	sleep 10000;
	announce "安全な場所に退避してからログアウトしてください。", 0;
	sleep 20000;
	announce "サーバー停止まで残り30秒です。", 0;
	sleep 20000;
	announce "サーバー停止まで残り10秒です。", 0;
	sleep 10000;
	atcommand "@mapexit 2";
}
