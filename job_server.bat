@echo off
rem サーバージョブ by GonBee

cd /d %~dp0

echo>%1-server.run
:execute
%1-server
if exist %1-server.stop (
	del %1-server.stop>nul 2>&1
	goto end
)
if errorlevel 1 (
	timeout /t %recovery_seconds%
	goto execute
)
:end
del %1-server.run>nul 2>&1
