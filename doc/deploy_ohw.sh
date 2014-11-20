#!/bin/sh

appName=ohw

echo  "deploy start" 

echo  "stop tomcat" 
service tomcat stop

echo  "clear webapp" 
rm /usr/local/tomcat/webapps/$appName.war
rm  -rf /usr/local/tomcat/webapps/$appName 

cd /usr/local/git_work/$appName

echo  "update from git" 

git pull
echo  "install war" 

mvn clean install -Dmaven.test.skip=true
echo   "copy to tomcat" 
cp /usr/local/git_work/$appName/target/$appName.war /usr/local/tomcat/webapps/$appName.war

echo   "start tomcat" 

service tomcat start

echo "clear apache's static resource"
rm  -rf /var/www/html/$appName
echo "copy static resources to apache"
cp  -rf /usr/local/git_work/$appName/target/$appName  /var/www/html/$appName
rm  -rf /var/www/html/$appName/WEB-INF
rm  -rf /var/www/html/$appName/src
rm  -rf /var/www/html/$appName/*.jsp

echo   "deploy end" 