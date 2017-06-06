# JAX-RS Hello World Tomcat

Este es un ejemplo de Hola mundo de un Web service REST con Jax-Rs en Tomcat

## Como iniciar la aplicacion

Estas son las instrucciones para levantar el proyecto de manera correcta


### 1.- Creas un arquetipo maven

```
$ mvn archetype:generate -DgroupId=com.jaxrs.rest -DartifactId=jax-rs-hello-world-tomcat -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```

### 2.- Lo conviertes a un proyecto Eclipse

```
$ mvn eclipse:eclipse -Dwtpversion=2.0	
```

### 3.- Agregamos las dependencias al pom.xml

```
<project ...>

	<repositories>
		<repository>
			<id>maven2-repository.java.net</id>
			<name>Java.net Repository for Maven</name>
			<url>http://download.java.net/maven/2/</url>
			<layout>default</layout>
		</repository>
	</repositories>

	<dependencies>

		<dependency>
			<groupId>com.sun.jersey</groupId>
			<artifactId>jersey-server</artifactId>
			<version>1.8</version>
		</dependency>

	</dependencies>

</project>

```

### 4.- Creamos el Servicio Rest

```
package com.mkyong.rest;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/users")
public class UserRestService {

	//@QueryParam example
	//@DefaultValue example
	//localhost:8084/RESTfulExample/rest/users/query?from=110&to=215&orderBy=age&orderBy=name
	@GET
	@Path("/query")
	public Response getUsers(
			@DefaultValue("1000") @QueryParam("from") int from,
			@DefaultValue("999") @QueryParam("to") int to,
			@DefaultValue("name") @QueryParam("orderBy") List<String> orderBy) {

		return Response
				.status(200)
				.entity("Estas llamando el metodo getUsers(), from : " + from + ", to : " + to
						+ ", orderBy" + orderBy.toString()).build();

	}
	
	//Programmatic Query Parameter
	//localhost:8084/RESTfulExample/rest/users/query?from=110&to=215&orderBy=age&orderBy=name
	@GET
	@Path("/query2")
	public Response getUsers2(@Context UriInfo info) {

		String from = info.getQueryParameters().getFirst("from");
		String to = info.getQueryParameters().getFirst("to");
		List<String> orderBy = info.getQueryParameters().get("orderBy");

		return Response
		   .status(200)
		   .entity("Estas llamando el metodo getUsers2(), con Programatic Query from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();

	}

}

```

### 5.- Modificamos el web.xml

```
<web-app id="WebApp_ID" version="2.4"
	xmlns="http://java.sun.com/xml/ns/j2ee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
	http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
	<display-name>Restful Web Application</display-name>

	<servlet>
		<servlet-name>jersey-serlvet</servlet-name>
		<servlet-class>
                     com.sun.jersey.spi.container.servlet.ServletContainer
                </servlet-class>
		<init-param>
		     <param-name>com.sun.jersey.config.property.packages</param-name>
		     <param-value>com.mkyong.rest</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
		<servlet-name>jersey-serlvet</servlet-name>
		<url-pattern>/rest/*</url-pattern>
	</servlet-mapping>

</web-app>

```

### 6.- Verificamos que todo funcione

```
http://localhost:8084/RESTfulExample/rest/users/query

http://localhost:8084/RESTfulExample/rest/users/query?from=110&to=215&orderBy=age&orderBy=quantize

http://localhost:8084/RESTfulExample/rest/users/query2?from=110&to=215&orderBy=age&orderBy=quantize
```

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*