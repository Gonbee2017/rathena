@echo off
rem ランナージョブ by GonBee

cd /d %~dp0
call job_config.bat

:run
del *.result>nul 2>&1
echo %date% %time:~0,8% - ログインサーバージョブを起動します。
call :start_server login
echo %date% %time:~0,8% - キャラサーバージョブを起動します。
call :start_server char
echo %date% %time:~0,8% - マップサーバージョブを起動します。
call :start_server map
call :wait_exit_server map
echo %date% %time:~0,8% - マップサーバージョブが終了しました。
call :kill_server char
call :wait_exit_server char
echo %date% %time:~0,8% - キャラサーバージョブが終了しました。
call :kill_server login
call :wait_exit_server login
echo %date% %time:~0,8% - ログインサーバージョブが終了しました。
call :get_server_result map
if "%get_server_result_return%"=="abnormal" (
	del *.result>nul 2>&1
	exit /b
)
set today=%date:~0,4%%date:~5,2%%date:~8,2%
set sql_file=%db_name%_%today%.sql
set zip_file=%db_name%_%today%.zip
if not exist %dump_dir%%zip_file% (
	if not %dump_days%==0 (
		echo %date% %time:~0,8% - %zip_file%を作成します。
		mysqldump -u%db_user% -p%db_password% -r %sql_file% %db_name%>nul 2>&1
		powershell compress-archive %sql_file% %dump_dir%%zip_file%
		del %sql_file%
		echo %date% %time:~0,8% - 保管日数を過ぎたMySQLダンプファイルを削除します。
		forfiles /p %dump_dir% /m %db_name%_*.zip /d -%dump_days% /c "cmd /c del @file && echo @fileを削除しました。" 2>nul
	)
	echo %date% %time:~0,8% - ログテーブルをクリアします。
	mysql -u%db_user% -p%db_password% %db_name%<sql-files\clear_logs.sql>nul 2>&1
)
echo %date% %time:~0,8% - 保管日数を過ぎたApacheログファイルを削除します。
forfiles /p %web_logs_dir% /m access_*.log /d -%web_logs_days% /c "cmd /c del @file && echo @fileを削除しました。" 2>nul
forfiles /p %web_logs_dir% /m error_*.log /d -%web_logs_days% /c "cmd /c del @file && echo @fileを削除しました。" 2>nul
goto run

:get_server_result
set get_server_result_return=
for /f %%i in (%1-server.result) do set get_server_result_return=%%i
exit /b

:kill_server
taskkill /f /im %1-server.exe>nul 2>&1
exit /b

:start_server
start cmd /c job_server.bat %1
exit /b

:wait_exit_server
:wait_exit_server_wait
if not exist %1-server.result (
	timeout /t 1 /nobreak>nul 2>&1
	goto wait_exit_server_wait
)
exit /b
