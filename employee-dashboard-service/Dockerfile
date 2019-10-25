# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="rakeshv.com@gmail.com"

RUN apk --no-cache add netcat-openbsd

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port available to the world outside this container
EXPOSE 8282 8283 8284 8787

ARG JAR_FILE=target/employee-dashboard-service.jar

# Add the application's jar to the container
ADD ${JAR_FILE} employee-dashboard-service.jar

COPY Employeedashboard-Entrypoint.sh /Employeedashboard-Entrypoint.sh

RUN chmod 755 /Employeedashboard-Entrypoint.sh

# Run the jar file
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /employee-dashboard-service.jar"]
