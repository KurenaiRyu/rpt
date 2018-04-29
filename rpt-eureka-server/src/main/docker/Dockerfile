FROM docker.io/lwieske/java-8:latest
MAINTAINER    kurenai233@yahoo.com
VOLUME /home/rpt/
ADD *.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
