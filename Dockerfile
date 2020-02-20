FROM openjdk:12-jdk-alpine
EXPOSE 7001
ARG JAR_FILE=servidor01-capsule.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dserver.port=7001","-jar","/app.jar"]