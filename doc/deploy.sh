#!/bin/sh
proj=helper-web
echo  "deploy start" 

echo  "stop tomcat" 
service tomcat stop

echo  "clear webapp" 
rm /usr/local/tomcat/webapps/${proj}.war
rm  -rf /usr/local/tomcat/webapps/${proj}

cd /usr/local/git_work/${proj}

echo  "update from git" 

git pull
echo  "install war" 

mvn clean install -Dmaven.test.skip=true
echo   "copy to tomcat" 
cp /usr/local/git_work/xxm/target/${proj}-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/${proj}.war

echo   "start tomcat" 

service tomcat start

echo "clear apache's static resource"
rm  -rf /var/www/html/xxm
echo "copy static resources to apache"
cp  -rf /usr/local/git_work/xxm/target/${proj}-1.0-SNAPSHOT.war  /var/www/html/${proj}
rm  -rf /var/www/html/${proj}/WEB-INF/classes
rm  -rf /var/www/html/${proj}/WEB-INF/lib


echo   "deploy end" 