FROM amazoncorretto:19
MAINTAINER aleseq
COPY target/ProyectoPortafolio-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
