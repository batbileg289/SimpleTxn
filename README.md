## Prerequisites
* JDK 1.8
* Maven

## Build and Run 
* Build: 
```
mvn clean package
```
* Run: 
```
java -jar target/batbileg-0.1.jar
```

## Test 
* HTTP GET - Show account information. URL: ([http://localhost:8080/txn](http://localhost:8080/txn))
* HTTP POST - Transaction. URL: ([http://localhost:8080/txn](http://localhost:8080/txn))

Content-Type: application/json

Example request body:
```JSON
{
    "from": "a1",
    "to": "a2",
    "amount": 286.43
}
```

## Test tool
* You can use [Postman](https://www.getpostman.com/downloads/) or any

