# Use a Maven image with JDK
FROM maven:3.9.5-eclipse-temurin-17 AS builder

# Set the working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the project
RUN mvn package

# keep container running
CMD ["tail", "-f", "/dev/null"]
