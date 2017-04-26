# Spring Boot Web JSP	

Este es un Hola Mundo de spring boot con JSPs

## Como iniciar la aplicacion

Estas son las instrucciones para levantar el proyecto de manera correcta

### Librerias requeridas

```
1. Spring Boot 1.4.2.RELEASE
2. Spring 4.3.4.RELEASE
3. Tomcat Embed 8.5.6
4. Maven 3
5. Java 8
```
### pom.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
	http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<artifactId>spring-boot-web-jsp</artifactId>
	<packaging>war</packaging>
	<name>Spring Boot Web JSP Example</name>
	<description>Spring Boot Web JSP Example</description>
	<url>https://www.mkyong.com</url>
	<version>1.0</version>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.4.2.RELEASE</version>
	</parent>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>

		<!-- This is a web application -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<!-- Tomcat embedded container-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>

		<!-- JSTL for JSP -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
		</dependency>

		<!-- Need this to compile JSP -->
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
		</dependency>

		<!-- Need this to compile JSP,
			tomcat-embed-jasper version is not working, no idea why -->
		<dependency>
			<groupId>org.eclipse.jdt.core.compiler</groupId>
			<artifactId>ecj</artifactId>
			<version>4.6.1</version>
			<scope>provided</scope>
		</dependency>

		<!-- Optional, test for static content, bootstrap CSS-->
		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>bootstrap</artifactId>
			<version>3.3.7</version>
		</dependency>

	</dependencies>
	<build>
		<plugins>
			<!-- Package as an executable jar/war -->
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
</project>

```

### Despliega las dependencias necesarias

En la carpeta donde se encuentra el pom.xml ejecuta:


```
$ mvn dependency:tree

[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Spring Boot Web JSP Example 1.0
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-dependency-plugin:2.10:tree (default-cli) @ spring-boot-web-jsp ---
[INFO] org.springframework.boot:spring-boot-web-jsp:war:1.0
[INFO] +- org.springframework.boot:spring-boot-starter-web:jar:1.4.2.RELEASE:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter:jar:1.4.2.RELEASE:compile
[INFO] |  |  +- org.springframework.boot:spring-boot:jar:1.4.2.RELEASE:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-autoconfigure:jar:1.4.2.RELEASE:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-starter-logging:jar:1.4.2.RELEASE:compile
[INFO] |  |  |  +- ch.qos.logback:logback-classic:jar:1.1.7:compile
[INFO] |  |  |  |  +- ch.qos.logback:logback-core:jar:1.1.7:compile
[INFO] |  |  |  |  \- org.slf4j:slf4j-api:jar:1.7.21:compile
[INFO] |  |  |  +- org.slf4j:jcl-over-slf4j:jar:1.7.21:compile
[INFO] |  |  |  +- org.slf4j:jul-to-slf4j:jar:1.7.21:compile
[INFO] |  |  |  \- org.slf4j:log4j-over-slf4j:jar:1.7.21:compile
[INFO] |  |  +- org.springframework:spring-core:jar:4.3.4.RELEASE:compile
[INFO] |  |  \- org.yaml:snakeyaml:jar:1.17:runtime
[INFO] |  +- org.hibernate:hibernate-validator:jar:5.2.4.Final:compile
[INFO] |  |  +- javax.validation:validation-api:jar:1.1.0.Final:compile
[INFO] |  |  +- org.jboss.logging:jboss-logging:jar:3.3.0.Final:compile
[INFO] |  |  \- com.fasterxml:classmate:jar:1.3.3:compile
[INFO] |  +- com.fasterxml.jackson.core:jackson-databind:jar:2.8.4:compile
[INFO] |  |  +- com.fasterxml.jackson.core:jackson-annotations:jar:2.8.4:compile
[INFO] |  |  \- com.fasterxml.jackson.core:jackson-core:jar:2.8.4:compile
[INFO] |  +- org.springframework:spring-web:jar:4.3.4.RELEASE:compile
[INFO] |  |  +- org.springframework:spring-aop:jar:4.3.4.RELEASE:compile
[INFO] |  |  +- org.springframework:spring-beans:jar:4.3.4.RELEASE:compile
[INFO] |  |  \- org.springframework:spring-context:jar:4.3.4.RELEASE:compile
[INFO] |  \- org.springframework:spring-webmvc:jar:4.3.4.RELEASE:compile
[INFO] |     \- org.springframework:spring-expression:jar:4.3.4.RELEASE:compile
[INFO] +- org.springframework.boot:spring-boot-starter-tomcat:jar:1.4.2.RELEASE:provided
[INFO] |  +- org.apache.tomcat.embed:tomcat-embed-core:jar:8.5.6:provided
[INFO] |  +- org.apache.tomcat.embed:tomcat-embed-el:jar:8.5.6:provided
[INFO] |  \- org.apache.tomcat.embed:tomcat-embed-websocket:jar:8.5.6:provided
[INFO] +- javax.servlet:jstl:jar:1.2:compile
[INFO] +- org.apache.tomcat.embed:tomcat-embed-jasper:jar:8.5.6:provided
[INFO] +- org.eclipse.jdt.core.compiler:ecj:jar:4.6.1:provided
[INFO] \- org.webjars:bootstrap:jar:3.3.7:compile
[INFO]    \- org.webjars:jquery:jar:1.11.1:compile
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.327 s
[INFO] Finished at: 2016-11-28T16:57:00+08:00
[INFO] Final Memory: 20M/309M
[INFO] ------------------------------------------------------------------------

``` 

### La anotacion @SpringBootApplication en la clase: SpringBootWebApplication.java

Es la encargada de correr el proyecto como un proyecto web de Spring Boot


```
package com.mkyong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}
```

### Archivo de Properties

Este se coloca en /src/main/resources/

``
/src/main/resources/application.properties
``
```
spring.mvc.view.prefix: /WEB-INF/jsp/
spring.mvc.view.suffix: .jsp

welcome.message: Hola Alfredo
```

### Inicia el proyecto desde Maven 
```
$ mvn spring-boot:run

//...
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.4.2.RELEASE)

2016-11-28 17:25:24.809  INFO 4696 --- [           main] com.mkyong.SpringBootWebApplication      : Starting SpringBootWebApplication on MKYONG-WIN10 with PID 4696 (C:\spring-boot\spring-boot-examples\spring-boot-web-jsp\target\classes started by mkyong in C:\spring-boot\spring-boot-examples\spring-boot-web-jsp)
2016-11-28 17:25:24.812  INFO 4696 --- [           main] com.mkyong.SpringBootWebApplication      : No active profile set, falling back to default profiles: default
2016-11-28 17:25:24.861  INFO 4696 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@69410cd3: startup date [Mon Nov 28 17:25:24 SGT 2016]; root of context hierarchy
2016-11-28 17:25:25.950  INFO 4696 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
2016-11-28 17:25:25.965  INFO 4696 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
2016-11-28 17:25:25.966  INFO 4696 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.6
2016-11-28 17:25:26.171  INFO 4696 --- [ost-startStop-1] org.apache.jasper.servlet.TldScanner     : At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
2016-11-28 17:25:26.180  INFO 4696 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2016-11-28 17:25:26.180  INFO 4696 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1322 ms
2016-11-28 17:25:26.304  INFO 4696 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
2016-11-28 17:25:26.312  INFO 4696 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2016-11-28 17:25:26.313  INFO 4696 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2016-11-28 17:25:26.313  INFO 4696 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2016-11-28 17:25:26.314  INFO 4696 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]

//...

2016-11-28 17:25:26.841  INFO 4696 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2016-11-28 17:25:26.846  INFO 4696 --- [           main] com.mkyong.SpringBootWebApplication      : Started SpringBootWebApplication in 2.403 seconds (JVM running for 5.08)

```



### Accede a tu http://localhost:8080

### Construye un ejecutable JAR

```
$ mvn clean package

...
[INFO] Building war: ...\spring-boot-web-jsp\target\spring-boot-web-jsp-1.0.war
[INFO]
[INFO] --- spring-boot-maven-plugin:1.4.2.RELEASE:repackage (default) @ spring-boot-web-jsp ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

### Ejecuta el siguiente comando y vuelve a ingresar a tu http://localhost:8080

```
$ java -jar target/spring-boot-web-jsp-1.0.war
```


## Construido con:

* [Maven](https://maven.apache.org/) - Manejador de Dependencias
* [Spring y Spring Boot](https://spring.io/) - Contenedor de inversión de control

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*

