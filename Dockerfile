# Use Eclipse Temurin JDK base image
FROM eclipse-temurin:17

# Set working directory
WORKDIR /app

# Copy jar file from target directory (after mvn build)
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
