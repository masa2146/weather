# Simple Weather App
You can dynamically add cities and show the weather. 

## Build and Run
```shell script
mvn clean install
```

```shell script
java -jar weather-0.0.1-SNAPSHOT.jar
```

Run on the **http://localhost:8081**

##End-Points
* http://localhost:8081/api/v1/city/all with GET method: Get all cities.
* http://localhost:8081/api/v1/city/{id} with GET method: Get city by city id.
* http://localhost:8081/api/v1/city/ with post method: Create or update city. 
<br>Sample POST data :
```json 
{"name":"Malatya","country":"Turkey"} 
```
for update

```json 
{"id": 5, "name":"Elazig","country":"Turkey"} 
```
* http://localhost:8081/api/v1/city/{id} with DELETE method: Delete city by city id.
* http://localhost:8081/api/v1/weather/{cityName} with GET method: Get city weather by city name.

## Used
- H2 Database
- Spring boot
- Hibernate
