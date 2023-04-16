FROM amazoncorretto:19
MAINTAINER aleseq
COPY target/ProyectoPortafolio-0.0.1-SNAPSHOT.jar ProyectoPortafolio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/ProyectoPortafolio-0.0.1-SNAPSHOT.jar"]
