# JAX-WS Integracion con Spring

Este es un ejemplo de Hola mundo de un Web service SOAP con Jax-Ws y Spring en Tomcat

## Como iniciar la aplicacion

Estas son las instrucciones para levantar el proyecto de manera correcta


### 1.- Agregamos las dependencias necesarias pom.xml

```
<project xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
  http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.mkyong</groupId>
  <artifactId>WebServicesExample</artifactId>
  <packaging>war</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>WebServicesExample Maven Webapp</name>
  <url>http://maven.apache.org</url>
  <repositories>
    <repository>
      <id>java.net</id>
      <url>http://download.java.net/maven/2</url>
    </repository>
  </repositories>
  <dependencies>
        <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>3.8.1</version>
                <scope>test</scope>
        </dependency>
	<!-- Spring framework -->
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring</artifactId>
		<version>2.5.6</version>
	</dependency>
    <!-- JAX-WS -->
	<dependency>
	  	<groupId>com.sun.xml.ws</groupId>
	        <artifactId>jaxws-rt</artifactId>
	        <version>2.2.3</version>
	</dependency>
 	<!-- Library from java.net, integrate Spring with JAX-WS -->
	<dependency>
		<groupId>org.jvnet.jax-ws-commons.spring</groupId>
		<artifactId>jaxws-spring</artifactId>
		<version>1.8</version>
		<exclusions>
		  <exclusion>
           		<groupId>org.springframework</groupId>
      			<artifactId>spring-core</artifactId>
        	  </exclusion>
        	  <exclusion>
           		<groupId>org.springframework</groupId>
      			<artifactId>spring-context</artifactId>
        	  </exclusion>
        	  <exclusion>
           		<groupId>com.sun.xml.stream.buffer</groupId>
      			<artifactId>streambuffer</artifactId>
        	  </exclusion>
        	  <exclusion>
           		<groupId>org.jvnet.staxex</groupId>
      			<artifactId>stax-ex</artifactId>
        	  </exclusion>
		</exclusions>
	</dependency>
  </dependencies>
  <build>
    <finalName>web services</finalName>
    <plugins>
       <plugin>
           <groupId>org.apache.maven.plugins</groupId>
           <artifactId>maven-compiler-plugin</artifactId>
           <version>2.3.1</version>
           <configuration>
               <source>1.6</source>
               <target>1.6</target>
           </configuration>
       </plugin>
    </plugins>
  </build>
</project>
```

### 2.- Creamos un simple servicio web JAX-WS con inyeccion de dependencias (DI) HelloWorldBo.java via Spring.

Archivo: HelloWorldWS.java

```
package com.mkyong.ws;
import javax.jws.WebMethod;
import javax.jws.WebService;
import com.mkyong.bo.HelloWorldBo;

@WebService
public class HelloWorldWS{
	//DI via Spring
	HelloWorldBo helloWorldBo;

	@WebMethod(exclude=true)
	public void setHelloWorldBo(HelloWorldBo helloWorldBo) {
		this.helloWorldBo = helloWorldBo;
	}

	@WebMethod(operationName="getHelloWorld")
	public String getHelloWorld() {

		return helloWorldBo.getHelloWorld();

	}

}
```

### 3.- Creamos los Beans HelloWorldBo.java y HelloWorldBoImpl.java

Archivo: HelloWorldBo.java

```
package com.mkyong.bo;

public interface HelloWorldBo{

	String getHelloWorld();

}
```
Archivo: HelloWorldBoImpl.java

```
package com.mkyong.bo.impl;

import com.mkyong.bo.HelloWorldBo;

public class HelloWorldBoImpl implements HelloWorldBo{

	public String getHelloWorld(){
		return "Ejemplo de JAX-WS + Spring!";
	}
	
}
```

### 4.- Creamos el Spring Beans Configuration

Archivo: applicationContext.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:ws="http://jax-ws.dev.java.net/spring/core"
       xmlns:wss="http://jax-ws.dev.java.net/spring/servlet"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
       http://jax-ws.dev.java.net/spring/core
        http://jax-ws.dev.java.net/spring/core.xsd
        http://jax-ws.dev.java.net/spring/servlet
        http://jax-ws.dev.java.net/spring/servlet.xsd">
    <wss:binding url="/hello">
        <wss:service>
            <ws:service bean="#helloWs"/>
        </wss:service>
    </wss:binding>
    <!-- Web service methods -->
    <bean id="helloWs" class="com.mkyong.ws.HelloWorldWS">
    	<property name="helloWorldBo" ref="HelloWorldBo" />
    </bean>
    <bean id="HelloWorldBo" class="com.mkyong.bo.impl.HelloWorldBoImpl" />
</beans>

```

### 5.- Agregamos el servlet WSSpringServlet y el link /hello

Archivo: web.xml

```
<web-app id="WebApp_ID" version="2.4"
	xmlns="http://java.sun.com/xml/ns/j2ee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
	http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
	<display-name>Spring + JAX-WS</display-name>
	<servlet>
   	        <servlet-name>jaxws-servlet</servlet-name>
   	       <servlet-class>
   		          com.sun.xml.ws.transport.http.servlet.WSSpringServlet
   	        </servlet-class>
  	</servlet>
	<servlet-mapping>
                <servlet-name>jaxws-servlet</servlet-name>
                <url-pattern>/hello</url-pattern>
         </servlet-mapping>
         <!-- Register Spring Listener -->
  	<listener>
    	        <listener-class>
    		     org.springframework.web.context.ContextLoaderListener
    	        </listener-class>
  	</listener>
</web-app>

```

### 6.- Descarga el zip de la libreria [jax-ws](https://jax-ws.java.net/)

Descomprime el zip y mueve las librerias de jax-ws a la carpeta de tu TOMCAT_HOME/lib

### 7.- Verifica que el WSDL este arriba http://localhost:8080/web%20services/hello?wsdl


## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*