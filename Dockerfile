FROM openjdk:11-jre-slim
# Set the working directory in the container
WORKDIR /app
# Copy the packaged Spring Boot application JAR file into the container
COPY target/your-application.jar /app/apprunner001-0.0.1-SNAPSHOT.jar
# Expose the port that the Spring Boot application uses
EXPOSE 8080
# Define the command to run your application when the container starts
CMD ["java", "-jar", "CleanCheck-0.0.1-SNAPSHOT.jar"]
