# Build stage
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /workspace

# Copy Maven wrapper and settings
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN chmod +x mvnw

# Copy sources and build
COPY src ./src
RUN ./mvnw -DskipTests package -DskipTests -B

# Run stage
FROM eclipse-temurin:17-jre
ARG JAR_FILE=target/carrito-0.0.1-SNAPSHOT.jar
COPY --from=build /workspace/${JAR_FILE} /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
