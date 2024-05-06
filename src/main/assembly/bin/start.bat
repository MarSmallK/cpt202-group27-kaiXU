@echo off
rem ======================================================================
rem windows startup script
rem
rem author: geekidea
rem date: 2018-12-2
rem ======================================================================

rem Open in a browser
start "http://localhost:8010/jsf/swagger-ui/index.html#/"

rem startup jar
java  -Xbootclasspath/a:../config/  -jar ../jsf-0.0.1-SNAPSHOT.jar  --spring.config.location=../config/

pause
