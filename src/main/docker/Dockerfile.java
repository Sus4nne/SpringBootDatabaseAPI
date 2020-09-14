FROM openjdk:8-jdk-alpine
EXPOSE 7000
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} databaseAPI.jar
ENTRYPOINT ["java","-jar","/databaseAPI.jar"]