#FROM ubuntu:latest AS ubuntu
#RUN apt-get update
#RUN apt-get install openjdk-17-jdk -y
#COPY . .
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080