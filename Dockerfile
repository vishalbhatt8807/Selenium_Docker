FROM openjdk:11

#Workspace
WORKDIR /usr/share/udemy

#Add .jar under taeget from host
#into this image.

ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs 						libs
ADD SearchModule.xml 					SearchModule.xml

ENTRYPOINT java -cp ".\target\selenium-docker.jar;.\target\selenium-docker-tests.jar;.\target\libs\*;" -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TesTNG $MODULE

