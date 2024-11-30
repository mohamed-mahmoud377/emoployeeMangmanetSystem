
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/employee-management-api.jar /app/employee-management-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/employee-management-api.jar"]
