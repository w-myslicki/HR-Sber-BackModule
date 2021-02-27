# BUILD

FROM maven:3-jdk-11 AS build

WORKDIR /usr/src/app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -Dmaven.test.skip=true


# RUN

FROM openjdk:11-jre

WORKDIR /usr/src/app

ARG JAR_FILE=target/*.jar
COPY --from=build /usr/src/app/${JAR_FILE} app.jar

RUN apt-get update && apt-get install -y netcat
COPY scripts ./scripts

EXPOSE 8080

ENTRYPOINT [ "/usr/src/app/scripts/entrypoint.sh" ]
