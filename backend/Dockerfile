# Etapa 1: Build da aplicação com Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final com JRE para execução
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
EXPOSE 10000
EXPOSE 10001
ENTRYPOINT ["java", "-jar", "app.jar"]
