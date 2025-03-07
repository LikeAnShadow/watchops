FROM alpine:3.21

RUN apk add openjdk21-jdk bash mariadb-client maven
# Go to the build directory
WORKDIR /build
# Create the /app directory for later use
RUN mkdir /app
# Copy the current directory contents into the container at /build
COPY ./src ./src
# Copy the pom.xml file into the container at /build
COPY ./pom.xml ./pom.xml

# Build the backend and 
RUN mvn clean package -DskipTests

# Switch to the /app directory
WORKDIR /app
#RUN cp /build/target/backend-0.0.1-SNAPSHOT.jar /app/backend.jar
# Delete the /build directory
RUN rm -rf /build
RUN apk del --purge maven openjdk21-jdk
RUN apk add openjdk21-jre

#Define the entrypoint
#COPY ./entrypoint.sh /entrypoint.sh
#RUN chmod +x /entrypoint.sh

# Expose the port the application runs on
EXPOSE 8080

# Install OpenJDK-21

# Command to run the application
# ENTRYPOINT [ "/entrypoint.sh" ]
# CMD ["java", "-jar", "/app/app.jar"]
