# Todoist

### Build
#### Build app:
```
./gradlew build
```

#### Run app:
Simple run: 
```
java -jar app/todoist.jar
```
---

### Frontend
Simple frontend is available at the address `http://localhost:8080/`

---

### Swagger

Swagger is available at the address: `swagger-ui.html` for example: `http://localhost:8080/swagger-ui.html`

---

### MongoDB
The application starts by default with embedded version mongodb.
You can change this to standalone version. 

* Change in the file `build.gradle` this line:
```
implementation "de.flapdoodle.embed:de.flapdoodle.embed.mongo:${flapdoodleEmbededMongoVersion}"
```
to:
```
testImplementation "de.flapdoodle.embed:de.flapdoodle.embed.mongo:${flapdoodleEmbededMongoVersion}"
```

* Add information about your database in the file `resources/application-mongodb.properties`

* Run application:
```
java -Dspring.profiles.active=mongodb -jar app/todoist.jar 
```

### Server Smtp
The application starts by default without connection with smtp server.
You can connect application to your smtp server.

* Add information about your smtp server in file `resources/application-email.properties`

* Run application:
```
java -Dspring.profiles.active=email -jar app/todoist.jar 
```

