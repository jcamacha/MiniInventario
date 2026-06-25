FROM eclipse-temurin:25-jdk-alpine
LABEL authors="juanp"
ARG JAR-FILE=target/*.jar
COPY ${JAR-FILE} app_inventariomini.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "/app_inventariomini.jar"]