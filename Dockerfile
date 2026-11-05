FROM eclipse-temurin:26-jdk
WORKDIR /app
COPY EmployeePayroll.jar app.jar
CMD ["java", "-jar", "app.jar"]
