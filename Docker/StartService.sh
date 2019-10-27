#!/bin/bash

#Start cassandra
service cassandra start

export CQLSH_NO_BUNDLED=true
cqlsh > /dev/null 2>&1

# Wait for the cassandra db to come up
sleep 15

#Execute sql file to create required keyspace and tables
cqlsh -f /home/app/app.sql

#Start java process
java -Dspring.config.location=/home/app/application.properties -jar /home/app/RetailApp-0.0.1-SNAPSHOT.jar
