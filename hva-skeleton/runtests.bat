@echo off
setlocal enabledelayedexpansion

set total=0
set correct=0

for %%x in (tests\*.in) do (
    if exist %%~dpnx.import (
        java -cp po-uilib.jar;. -Dimport=%%~dpnx.import -Din=%%x -Dout=%%~dpnx.outhyp hva.app.App
    ) else (
        java -cp po-uilib.jar;. -Din=%%x -Dout=%%~dpnx.outhyp hva.app.App
    )

    fc /w %%~dpnx.out %%~dpnx.outhyp > nul
    set res=!errorlevel!
    if !res! neq 0 (
        fc /w %%~dpnx.out %%~dpnx.outhyp > %%~dpnx.diff
    ) else (
        del %%~dpnx.diff 2>nul
        del %%~dpnx.outhyp 2>nul
    )
    if exist %%~dpnx.diff (
        echo F
        set failures=!failures!Fail: %%x: See file %%~dpnx.diff\n
    ) else (
        set /a correct+=1
        echo .
    )
    set /a total+=1
)

del saved* 2>nul
set /a res=100*correct/total
echo.
echo Total Tests = %total%
echo Passed = %res%%
echo %failures%
echo Done.