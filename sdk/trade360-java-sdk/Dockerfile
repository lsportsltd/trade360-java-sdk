# Use a Maven image with JDK
FROM maven:3.9.5-eclipse-temurin-17 AS builder

WORKDIR /app
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

# Add build argument and environment variable for commit SHA
ARG CODACY_COMMIT_ID
ENV CODACY_COMMIT_ID=${CODACY_COMMIT_ID}

# Run tests and generate JaCoCo XML report
RUN mvn clean test jacoco:report

# Send coverage report to Codacy (with commit SHA)
RUN wget -qO - https://coverage.codacy.com/get.sh | bash -s report -l Java -r target/site/jacoco/jacoco.xml --commit-uuid $CODACY_COMMIT_ID

# Build the SDK module
RUN mvn package

# keep container running
CMD ["tail", "-f", "/dev/null"]
