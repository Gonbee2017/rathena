@echo off
rem ’âŽ~ƒWƒ‡ƒu by GonBee

cd /d %~dp0
call :kill_server map
exit /b

:kill_server
taskkill /f /im %1-server.exe>nul 2>&1
exit /b
