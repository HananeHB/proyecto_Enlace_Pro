#imagen base con Java 21
FROM eclipse-temurin:21-jdk-alpine
#carpeta dentro del conteendor 
WORKDIR /app
#copiar el jar generado por maven
COPY target/*.jar app.jar
#puerto que usa spring boot
EXPOSE 8080 
#para arrancar la app
ENTRYPOINT ["java", "-jar", "app.jar"]