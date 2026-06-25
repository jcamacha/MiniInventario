FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw
COPY src src
RUN ./mvnw package -DskipTests
COPY startup.sh .
RUN chmod +x startup.sh
EXPOSE 8085
CMD ["./startup.sh"]