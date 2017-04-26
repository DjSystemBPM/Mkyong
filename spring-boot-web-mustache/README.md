# Spring Boot Web Thymeleaf	

Este es un Hola Mundo de spring boot con Thymeleaf y Mustache

## Como iniciar la aplicacion

Estas son las instrucciones para levantar el proyecto de manera correcta

### Librerias requeridas

```
1. Spring Boot 1.5.2.RELEASE
2. Spring 4.3.7.RELEASE
3. jmustache 1.13
4. Thymeleaf 2.1.5.RELEASE
5. Tomcat Embed 8.5.11
6. Maven 3
7. Java 8
```
### pom.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
	http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<artifactId>spring-boot-web-mustache</artifactId>
	<packaging>jar</packaging>
	<name>Spring Boot Web Mustache Example</name>
	<description>Spring Boot Web Mustache Example</description>
	<url>https://www.mkyong.com</url>
	<version>1.0</version>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.2.RELEASE</version>
	</parent>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mustache</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<!-- hot swapping, live reload -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<optional>true</optional>
		</dependency>

		<!-- Optional, for bootstrap -->
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
[INFO] Building Spring Boot Web Mustache Example 1.0
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-dependency-plugin:2.10:tree (default-cli) @ spring-boot-web-mustache ---
                               [INFO] org.springframework.boot:spring-boot-web-mustache:jar:1.0
[INFO] +- org.springframework.boot:spring-boot-starter-mustache:jar:1.5.2.RELEASE:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter:jar:1.5.2.RELEASE:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-starter-logging:jar:1.5.2.RELEASE:compile
[INFO] |  |  |  +- ch.qos.logback:logback-classic:jar:1.1.11:compile
[INFO] |  |  |  |  \- ch.qos.logback:logback-core:jar:1.1.11:compile
[INFO] |  |  |  +- org.slf4j:jcl-over-slf4j:jar:1.7.24:compile
[INFO] |  |  |  +- org.slf4j:jul-to-slf4j:jar:1.7.24:compile
[INFO] |  |  |  \- org.slf4j:log4j-over-slf4j:jar:1.7.24:compile
[INFO] |  |  \- org.yaml:snakeyaml:jar:1.17:runtime
[INFO] |  +- org.springframework.boot:spring-boot-starter-web:jar:1.5.2.RELEASE:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-starter-tomcat:jar:1.5.2.RELEASE:compile
[INFO] |  |  |  +- org.apache.tomcat.embed:tomcat-embed-core:jar:8.5.11:compile
[INFO] |  |  |  +- org.apache.tomcat.embed:tomcat-embed-el:jar:8.5.11:compile
[INFO] |  |  |  \- org.apache.tomcat.embed:tomcat-embed-websocket:jar:8.5.11:compile
[INFO] |  |  +- org.hibernate:hibernate-validator:jar:5.3.4.Final:compile
[INFO] |  |  |  +- javax.validation:validation-api:jar:1.1.0.Final:compile
[INFO] |  |  |  +- org.jboss.logging:jboss-logging:jar:3.3.0.Final:compile
[INFO] |  |  |  \- com.fasterxml:classmate:jar:1.3.3:compile
[INFO] |  |  +- com.fasterxml.jackson.core:jackson-databind:jar:2.8.7:compile
[INFO] |  |  |  +- com.fasterxml.jackson.core:jackson-annotations:jar:2.8.0:compile
[INFO] |  |  |  \- com.fasterxml.jackson.core:jackson-core:jar:2.8.7:compile
[INFO] |  |  +- org.springframework:spring-web:jar:4.3.7.RELEASE:compile
[INFO] |  |  |  +- org.springframework:spring-aop:jar:4.3.7.RELEASE:compile
[INFO] |  |  |  \- org.springframework:spring-beans:jar:4.3.7.RELEASE:compile
[INFO] |  |  \- org.springframework:spring-webmvc:jar:4.3.7.RELEASE:compile
[INFO] |  |     \- org.springframework:spring-expression:jar:4.3.7.RELEASE:compile
[INFO] |  \- com.samskivert:jmustache:jar:1.13:compile
[INFO] +- org.springframework.boot:spring-boot-starter-test:jar:1.5.2.RELEASE:test
[INFO] |  +- org.springframework.boot:spring-boot-test:jar:1.5.2.RELEASE:test
[INFO] |  +- org.springframework.boot:spring-boot-test-autoconfigure:jar:1.5.2.RELEASE:test
[INFO] |  +- com.jayway.jsonpath:json-path:jar:2.2.0:test
[INFO] |  |  +- net.minidev:json-smart:jar:2.2.1:test
[INFO] |  |  |  \- net.minidev:accessors-smart:jar:1.1:test
[INFO] |  |  |     \- org.ow2.asm:asm:jar:5.0.3:test
[INFO] |  |  \- org.slf4j:slf4j-api:jar:1.7.24:compile
[INFO] |  +- junit:junit:jar:4.12:test
[INFO] |  +- org.assertj:assertj-core:jar:2.6.0:test
[INFO] |  +- org.mockito:mockito-core:jar:1.10.19:test
[INFO] |  |  \- org.objenesis:objenesis:jar:2.1:test
[INFO] |  +- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO] |  +- org.hamcrest:hamcrest-library:jar:1.3:test
[INFO] |  +- org.skyscreamer:jsonassert:jar:1.4.0:test
[INFO] |  |  \- com.vaadin.external.google:android-json:jar:0.0.20131108.vaadin1:test
[INFO] |  +- org.springframework:spring-core:jar:4.3.7.RELEASE:compile
[INFO] |  \- org.springframework:spring-test:jar:4.3.7.RELEASE:test
[INFO] +- org.springframework.boot:spring-boot-devtools:jar:1.5.2.RELEASE:compile
[INFO] |  +- org.springframework.boot:spring-boot:jar:1.5.2.RELEASE:compile
[INFO] |  |  \- org.springframework:spring-context:jar:4.3.7.RELEASE:compile
[INFO] |  \- org.springframework.boot:spring-boot-autoconfigure:jar:1.5.2.RELEASE:compile
[INFO] \- org.webjars:bootstrap:jar:3.3.7:compile
[INFO]    \- org.webjars:jquery:jar:1.11.1:compile
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.796 s
[INFO] Finished at: 2017-04-19T11:46:09+08:00
[INFO] Final Memory: 22M/437M
[INFO] ------------------------------------------------------------------------

``` 

### La anotacion @SpringBootApplication en la clase: SpringBootWebApplication.java

Es la encargada de correr el proyecto como un proyecto web de Spring Boot


```
package com.mkyong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebApplication {

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
app.welcome.message: Hola Alfredo
app.welcome.title: Spring Boot Mustache Hola Mundo Ejemplo
```

### Inicia el proyecto desde Maven 
```
$ mvn spring-boot:run

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.4.2.RELEASE)

2016-12-03 14:04:07.203  INFO 7180 --- [  restartedMain] com.mkyong.SpringBootWebApplication      : Starting SpringBootWebApplication on MKYONG-WIN10 with PID 7180 (C:\spring-boot\spring-boot-examples\spring-boot-web-thymeleaf\target\classes started by mkyong in C:\spring-boot\spring-boot-examples\spring-boot-web-thymeleaf)
2016-12-03 14:04:07.205  INFO 7180 --- [  restartedMain] com.mkyong.SpringBootWebApplication      : No active profile set, falling back to default profiles: default
2016-12-03 14:04:07.392  INFO 7180 --- [  restartedMain] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@67af925a: startup date [Sat Dec 03 14:04:07 SGT 2016]; root of context hierarchy
2016-12-03 14:04:08.739  INFO 7180 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
2016-12-03 14:04:08.754  INFO 7180 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service Tomcat
2016-12-03 14:04:08.755  INFO 7180 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.6
2016-12-03 14:04:08.827  INFO 7180 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2016-12-03 14:04:08.827  INFO 7180 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1439 ms
2016-12-03 14:04:08.969  INFO 7180 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
2016-12-03 14:04:08.976  INFO 7180 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2016-12-03 14:04:08.977  INFO 7180 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2016-12-03 14:04:08.978  INFO 7180 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2016-12-03 14:04:08.980  INFO 7180 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2016-12-03 14:04:09.196  INFO 7180 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@67af925a: startup date [Sat Dec 03 14:04:07 SGT 2016]; root of context hierarchy
2016-12-03 14:04:09.242  INFO 7180 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/]}" onto public java.lang.String com.mkyong.WelcomeController.welcome(java.util.Map<java.lang.String, java.lang.Object>)
2016-12-03 14:04:09.247  INFO 7180 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2016-12-03 14:04:09.247  INFO 7180 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2016-12-03 14:04:09.277  INFO 7180 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2016-12-03 14:04:09.277  INFO 7180 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2016-12-03 14:04:09.319  INFO 7180 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2016-12-03 14:04:09.687  INFO 7180 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2016-12-03 14:04:09.724  INFO 7180 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2016-12-03 14:04:09.781  INFO 7180 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2016-12-03 14:04:09.787  INFO 7180 --- [  restartedMain] com.mkyong.SpringBootWebApplication      : Started SpringBootWebApplication in 2.943 seconds (JVM running for 3.325)
```



### Accede a tu http://localhost:8080
### Accede a una URL que no exista http://localhost:8080/uri-not-exist
### Accede a http://localhost:8080/5xx

### Construye un ejecutable JAR

```
$ mvn clean package

...
[INFO] ------------------------------------------------------------------------
[INFO] Building Spring Boot Web Thymeleaf Example 1.0
[INFO] ------------------------------------------------------------------------
...
[INFO] --- maven-jar-plugin:2.6:jar (default-jar) @ spring-boot-web-thymeleaf ---
[INFO] Building jar: C:\spring-boot\spring-boot-examples\spring-boot-web-thymeleaf\target\spring-boot-web-thymeleaf-1.0.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:1.4.2.RELEASE:repackage (default) @ spring-boot-web-thymeleaf ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.797 s
[INFO] Finished at: 2016-12-03T14:06:45+08:00
[INFO] Final Memory: 21M/437M
[INFO] ------------------------------------------------------------------------
```

### Ejecuta el siguiente comando y vuelve a ingresar a tu http://localhost:8080

```
$ java -jar target/spring-boot-web-mustache-1.0.jar
```


## Construido con:

* [Maven](https://maven.apache.org/) - Manejador de Dependencias
* [Spring y Spring Boot](https://spring.io/) - Contenedor de inversión de control

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*

