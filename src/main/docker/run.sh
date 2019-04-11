#!/bin/sh
echo "********************************************************"
echo "Starting the Eureka Server"
while ! `nc -z eurekaserver 8761`; do sleep 3; done
echo "******* Eureka Server has started"

echo "********************************************************"
echo "Waiting for the Redis server to start on port 6379"
echo "********************************************************"
while ! `nc -z redisserver 6379`; do sleep 3; done
echo "******** Mongodb Server has started "

echo "********************************************************"
echo "Waiting for the Zipkin server to start on port 9411"
echo "********************************************************"
while ! `nc -z zipkinserver 9411`; do sleep 3; done
echo "******** Zipkin Server has started "

java \
	-Dspring.profiles.active=docker \
	-jar /usr/local/cache_service/@project.build.finalName@.jar
