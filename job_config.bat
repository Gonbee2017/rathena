@echo off
rem ジョブの設定 by GonBee

rem MySQLデータベースのユーザー名。
set db_user=pybot
rem MySQLデータベースのパスワード。
set db_password=Password
rem MySQLデータベースの名前。
set db_name=pybot
rem MySQLダンプファイルの保存先ディレクトリ。
set dump_dir=D:\ROEmu\Dump\
rem MySQLダンプファイルの保管日数。
set dump_days=7
rem Apacheログの保存先ディレクトリ。
set web_logs_dir=D:\Apache24\logs\
rem Apacheログファイルの保管日数。
set web_logs_days=7
rem サーバークラッシュから再起動するまでの秒数。
set recovery_seconds=60
