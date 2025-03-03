FROM alpine:3.21

# Set the working directory
WORKDIR /app

#COPY ./schema.sqlite /opt/database/schema.sqlite
#Copy the jar file into the container at /app
COPY ./backend.jar /app/app.jar

#Define the entrypoint
#COPY ./entrypoint.sh /entrypoint.sh
#RUN chmod +x /entrypoint.sh

# Expose the port the application runs on
EXPOSE 8080

# Install OpenJDK-21
RUN apk add openjdk21-jre bash

# Command to run the application
# ENTRYPOINT [ "/entrypoint.sh" ]
# CMD ["java", "-jar", "/app/app.jar"]