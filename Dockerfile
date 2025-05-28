# Use a Maven image with JDK
FROM maven:3.9.5-eclipse-temurin-17 AS builder

# Set the working directory
WORKDIR /app

# Copy project files
COPY . .

# get and set NPM_TOKEN
ARG NPM_TOKEN
ENV NPM_TOKEN=${NPM_TOKEN}

# codacy args
ARG CODACY_TOKEN
ARG SERVICE_NAME=trade360-java-sdk

# assign build arguments to environment variables
ENV CODACY_API_TOKEN=${CODACY_TOKEN}
ENV CODACY_ORGANIZATION_PROVIDER=gh
ENV CODACY_USERNAME=lsportsltd
ENV CODACY_PROJECT_NAME=${SERVICE_NAME}

# Run tests and generate coverage
RUN mvn test

# Generate JaCoCo XML report
RUN mvn clean test jacoco:report -pl sdk/trade360-java-sdk

# send coverage report to Codacy
RUN wget -qO - https://coverage.codacy.com/get.sh | bash -s report -l Java -r target/site/jacoco/jacoco.xml

# Build the project
RUN mvn package

# keep container running
CMD ["tail", "-f", "/dev/null"]
