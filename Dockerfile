# BUILD

FROM maven:3-jdk-11-slim AS build

WORKDIR /usr/src/app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -Dmaven.test.skip=true


# RUN

FROM openjdk:11-jre-slim

WORKDIR /usr/src/app

RUN apt-get update && apt-get install -y netcat
COPY scripts ./scripts

ARG JAR_FILE=target/*.jar
COPY --from=build /usr/src/app/${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT [ "./scripts/entrypoint.sh", "java", "-jar", "app.jar" ]
