@echo off
rem サーバージョブ by GonBee

cd /d %~dp0
set result=normal

:execute
%1-server
if errorlevel 2 (
	timeout /t %recovery_seconds%
	goto execute
)
if errorlevel 1 set result=abnormal
echo %result%>%1-server.result
