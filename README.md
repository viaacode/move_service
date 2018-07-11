# move_service
Microservice to move a file from the same server, triggered with RabbitMQ messages

# Maven 
This service depends on the FXP service [FXP service](https://github.com/viaacode/fxp_service), thus the VIAA nexus repo should be configured correctly.

Then you can compile or build the move service regularly with a Maven command of you choice (package, compile, ...) like you normally would.

`mvn package` creates the same 'fat' jar as `mvn clean compile assembly:single`. Build the project using one of the two following:

- `mvn clean compile assembly:single`
- `mvn clean package`

Once built, the artifact can be deployed to the nexus, assuming credentials for the VIAA repo are set up correctly:
- `mvn deploy`

Consult the [`mvn deploy`](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) documentation.

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
