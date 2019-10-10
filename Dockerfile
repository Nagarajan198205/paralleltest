FROM openjdk:8-jre-slim

#A Directory in the base image to copy our depedencies
WORKDIR /usr/share/tag

# Add the project jar & copy dependencies
ADD  target/containerparalleltest.jar containerparalleltest.jar
ADD  target/libs libs

# Add the suite xmls
ADD suite/testng.xml testng.xml

# Command line to execute the test
# Expects below ennvironment variables
# BROWSER = chrome / firefox
 MODULE  = testng.xml
# SELENIUM_HUB = selenium hub hostname / ipaddress

# ENTRYPOINT java -cp containerparalleltest.jar:libs/* -DseleniumHubHost=$SELENIUM_HUB -Dbrowser=$BROWSER org.testng.TestNG $MODULE

ENTRYPOINT java -cp containerparalleltest.jar:libs/* -Dbrowser=$BROWSER org.testng.TestNG $MODULE