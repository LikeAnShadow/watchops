FROM alpine:3.21 AS build_backend

# Install the necessary build tools
RUN apk add openjdk21-jdk bash mariadb-client maven
# Go to the build directory
WORKDIR /build
# Create the /app directory for later use
RUN mkdir /app
# Copy the current directory contents into the container at /build
COPY ./src ./src
# Copy the pom.xml file into the container at /build
COPY ./pom.xml ./pom.xml

# Build the backend
RUN mvn clean package -DskipTests

FROM alpine:3.21

# Install OpenJDK-21 JRE for running the application
WORKDIR /app
RUN apk add --no-cache openjdk21-jre
COPY --from=build_backend /build/target/backend.jar ./backend.jar

#Define the entrypoint
#COPY ./entrypoint.sh /entrypoint.sh
#RUN chmod +x /entrypoint.sh

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
# ENTRYPOINT [ "/entrypoint.sh" ]
# CMD ["java", "-jar", "/app/app.jar"]
