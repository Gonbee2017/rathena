-	script	::UpdateFever	-1,{
OnClock0000:
OnClock0800:
OnClock1200:
OnClock1600:
OnClock2000:
	updatefever();
	announce "フィーバーマップが更新されました。", 0;
}
