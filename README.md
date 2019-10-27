# Description
Spring boot application to do CRUD.

Tool and Tech stack used.
  1. STS
  2. Spring Boot
  3. Maven
  4. Cassandra
  5. JDK 8
  
Usecase
  • Responds to an HTTP GET request at /products/{id} and delivers product data as
    JSON (where {id} will be a number.
  • Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793)
  • Example response: {"id":13860428,"name":"The Big Lebowski (Blu-ray)
    (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}}
  • Performs an HTTP GET to retrieve the product name from an external API. (For
    this exercise the data will come from redsky.target.com, but let’s just pretend
    this is an internal resource hosted by myRetail)
  • Reads pricing information from a NoSQL data store and combines it with the
    product id and name from the HTTP request into a single response.
  
App Description.
  1. Sample application to do simple crud operations on cassandar database.
  2. Base url http://<ip>:<port>/product
  3. POST api to save product data.
  4. GET api to get all products in the database.
  5. GET/id api to get specific product data.
  6. PUT api to updated the product price data.
  7. DELETE api to delete specfic product
  
Cassandra Installation steps [ For MAC ].
  1. brew install cassandra
  2. Start the cassandra using below command
     - brew services start cassandra
  3. Command to enter cassandra shell
     - /usr/local/bin/cqlsh

