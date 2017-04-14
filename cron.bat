@echo off

pushd
cd D:\hybris-suite\hybris\bin\platform
call setantenv.bat
call ant runcronjob -Dcronjob=organisationMailCronJob
popd

pause
