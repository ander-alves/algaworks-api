FROM maven:3.8.6-eclipse-temurin-17-alpine
COPY . /home/app
WORKDIR /home/app
USER root

RUN mvn clean install

WORKDIR /home/app/target

ENTRYPOINT ["java", "-jar", "algaworks-api-0.0.1-SNAPSHOT.jar"]