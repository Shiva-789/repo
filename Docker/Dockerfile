FROM ubuntu:16.04

#=======================================
# Install Java 8 and cassandra.
#=======================================
RUN apt-get update \
   && apt-get install -y openjdk-8-jdk-headless 

RUN echo "deb http://www.apache.org/dist/cassandra/debian 36x main" | tee -a /etc/apt/sources.list.d/cassandra.sources.list

RUN apt install -y curl

RUN curl https://www.apache.org/dist/cassandra/KEYS |  apt-key add -

RUN apt-get update \
    && apt install -y python-pip \
    && apt-get install -y cassandra

RUN pip install cassandra-driver

COPY RetailApp-0.0.1-SNAPSHOT.jar /home/app/

COPY StartService.sh /home/app/

COPY application.properties /home/app/

COPY app.sql /home/app/

RUN chmod -R 770 /home/app/
