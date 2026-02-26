FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests


#imagen base con Java 21
FROM eclipse-temurin:21-jdk-alpine
#carpeta dentro del conteendor 
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

#puerto que usa spring boot
EXPOSE 8080 
#para arrancar la app
ENTRYPOINT ["java", "-jar", "app.jar"]