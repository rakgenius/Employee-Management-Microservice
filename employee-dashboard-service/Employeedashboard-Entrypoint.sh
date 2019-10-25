#!/bin/sh
while ! nc -z config-server 8888 ; do
    echo "Waiting for the Config Server"
    sleep 3
done
while ! nc -z eureka-server 8761 ; do
    echo "Waiting for the Eureka Server"
    sleep 3
done

java -Xdebug -Djava.security.egd=file:/dev/./urandom -jar /employee-dashboard-service.jar