# Use a lightweight base image with Java runtime
FROM openjdk:17-jdk-slim

# Set environment variable to reduce memory usage if needed
ENV JAVA_OPTS="-Xms256m -Xmx512m"

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file into the container
COPY target/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Start the Spring Boot app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
