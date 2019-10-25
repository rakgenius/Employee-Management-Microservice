# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="rakeshv.com@gmail.com"

RUN apk --no-cache add netcat-openbsd

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port available to the world outside this container
EXPOSE 9092 9093 9094 8787

#ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8787,suspend=n"

ARG JAR_FILE=target/employee-search-service.jar

# Add the application's jar to the container
ADD ${JAR_FILE} employee-search-service.jar

COPY EmployeeSearch-Entrypoint.sh /EmployeeSearch-Entrypoint.sh

RUN chmod 755 /EmployeeSearch-Entrypoint.sh
# Run the jar file
ENTRYPOINT ["sh", "-c", "java  -Djava.security.egd=file:/dev/./urandom -jar /employee-search-service.jar"]
