#!/bin/bash

#Start cassandra
service cassandra start

export CQLSH_NO_BUNDLED=true

cqlsh > /dev/null 2>&1

sleep 15

cqlsh -f /home/app/app.sql

#Start java process
java -Dspring.config.location=/home/app/application.properties -jar /home/app/RetailApp-0.0.1-SNAPSHOT.jar
