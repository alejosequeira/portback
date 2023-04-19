FROM amazoncorretto:19-alpine-jdk
MAINTAINER ALE
COPY target\ProyectoPortafolio-0.0.1-SNAPSHOT.jar ale-app.jar
ENTRYPOINT ["java","-jar","/ale-app.jar"]