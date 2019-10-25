# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="rakeshv.com@gmail.com"

RUN apk --no-cache add netcat-openbsd

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port available to the world outside this container
EXPOSE 5000 8787

ENV JAVA_OPTS=""

ARG JAR_FILE=target/api-gateway.jar

# Add the application's jar to the container
ADD ${JAR_FILE} api-gateway.jar

# Run the jar file
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /api-gateway.jar"]
