# Etapa 1: build del JAR usando Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final más ligera
FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
WORKDIR /app

# Copia el JAR generado desde el builder
COPY --from=builder /app/target/taskme-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
