FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-11-jdk -y
COPY . .

RUN ./gradlew bootJar --no-daemon

FROM openjdk:11-jdk-slim

EXPOSE 5000

COPY src/main/resources/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
