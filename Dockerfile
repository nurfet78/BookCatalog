FROM openjdk:17
LABEL authors="Nuri"
COPY target/*.jar application.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "application.jar"]