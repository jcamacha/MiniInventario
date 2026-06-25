FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw
COPY src src
RUN ./mvnw package -DskipTests -q
EXPOSE 8085
CMD ["java", "-jar", "target/MiniInventario-0.0.1-SNAPSHOT.jar"]
