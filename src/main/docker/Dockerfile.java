FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} databaseAPI.jar
ENTRYPOINT ["java","-jar","/databaseAPI.jar"]