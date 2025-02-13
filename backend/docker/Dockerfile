FROM openjdk:21-jdk

# Set the working directory
WORKDIR /app

RUN mkdir -p /opt/database

COPY ./schema.sqlite /opt/database/schema.sqlite
COPY ./backend.jar /app/app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/app.jar"]