FROM maven:3-openjdk-11-slim AS build

RUN mkdir app
COPY pom.xml /app/
RUN mvn validate -f /app

COPY * /app/
RUN mvn clean test -f /app

EXPOSE 8080
RUN mvn -f /app -Prun
