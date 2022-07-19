# Define base docker image
FROM openjdk:11
LABEL maintainer="rrlira96"
ADD target/EstacionaAqui-0.0.1-SNAPSHOT.jar estaciona-aqui.jar
ENTRYPOINT ["java", "-jar", "estaciona-aqui.jar"]