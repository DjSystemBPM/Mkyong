# JAX-WS Hello World en Tomcat

Este es un ejemplo de Hola mundo de un Web service SOAP con Jax-Ws en Tomcat

## Como iniciar la aplicacion

Estas son las instrucciones para levantar el proyecto de manera correcta


### 1.- Creas un simple web service llamado HelloWorld.java

```
package com.mkyong.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorld{

	@WebMethod(operationName="getHelloWorld")
	public String getHelloWorld(String name) {
		return "Hello World JAX-WS " + name;
	}

}
```
### 2.- Creamos un descriptor de despliegue	para el web service llamado sun-jaxws.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<endpoints
  xmlns="http://java.sun.com/xml/ns/jax-ws/ri/runtime"
  version="2.0">
  <endpoint
      name="HelloWorldWs"
      implementation="com.mkyong.ws.HelloWorld"
      url-pattern="/hello"/>
</endpoints>
```

### 3.- Creamos un descriptor de despliegue	para la aplicacion web llamado web.xml

```
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
	<display-name>Archetype Created Web Application</display-name>

	<listener>
		<listener-class>
			com.sun.xml.ws.transport.http.servlet.WSServletContextListener
                </listener-class>
	</listener>
	<servlet>
		<servlet-name>hello</servlet-name>
		<servlet-class>
			com.sun.xml.ws.transport.http.servlet.WSServlet
                </servlet-class>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>hello</servlet-name>
		<url-pattern>/hello</url-pattern>
	</servlet-mapping>

</web-app>
```

### 4.- Descarga el zip de la libreria [jax-ws](https://jax-ws.java.net/)

Descomprime el zip y mueve las librerias de jax-ws a la carpeta de tu TOMCAT_HOME/lib

### 5.- Verifica que el WSDL este arriba http://localhost:8080/webservices/hello


## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*