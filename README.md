# move_service
Microservice to move a file from the same server, triggered with RabbitMQ messages

# Maven 
First install the [FXP service](https://github.com/viaacode/fxp_service) using maven install in the FXP service directory
```
mvn install
```
Then you can compile or build the move service regularly with a Maven command of you choice (package, compile, ...) like you normally would.

There is also an option to compile as a fat JAR (a JAR file with all of its dependencies packaged inside)

```
mvn clean compile assembly:single
```

# Properties File

The properties file is read from the same folder the program is run from.

Its location can also be set with the '-p' parameter. For example:

```
java -jar move-service.jar -p /etc/delete.d/application.properties
```

Copy the application.properties.example to application.properties

# Example Request

Request:

```json
{
  "source_name": "source.xml",
  "destination_name": "destination.xml",
  "source_path": "/home/sourcepath",
  "destination_path": "/home/destinationpath",
  "host": "host.be",
  "username": "username",
  "password": "password",
  "correlation_id": "some_id"
}
```
