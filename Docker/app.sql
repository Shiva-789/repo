CREATE KEYSPACE IF NOT EXISTS retailspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE retailspace;

CREATE TABLE IF NOT EXISTS product ( id INT PRIMARY KEY, productname TEXT , currencyvalue double, currencycode TEXT);
