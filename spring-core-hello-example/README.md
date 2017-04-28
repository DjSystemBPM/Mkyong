# Spring Core Hello World

Este es un Hola Mundo de spring core

## Como iniciar la aplicacion

Estas son las instrucciones para levantar el proyecto de manera correcta

### Librerias requeridas

```
1. Spring 2.5.6
2. Maven 3.0.3
3. Eclipse 3.6
4. JDK 1.6.0.13
```

### Genera la estructura del proyecto con maven

```
$ mvn archetype:generate -DgroupId=com.mkyong.common -DartifactId=SpringExamples -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
### Convierte tu proyecto a Eclipse

```
$ mvn eclipse:eclipse
```

 
### pom.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
	http://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.mkyong.core</groupId>
	<artifactId>Spring3Example</artifactId>
	<packaging>jar</packaging>
	<version>1.0-SNAPSHOT</version>
	<name>Spring3Example</name>
	<url>http://maven.apache.org</url>
	<properties>
		<spring.version>3.0.5.RELEASE</spring.version>
	</properties>
	<dependencies>
		<!-- Spring 3 dependencies -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.version}</version>
		</dependency>
	</dependencies>
</project>

```

### Spring Bean Simple

Un simple bean de spring con el metodo que pintara el nombre

```
package com.mkyong.core;

/**
 * Spring bean
 *
 */
public class HelloWorld {
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	public void printHello() {
		System.out.println("Spring 3 : Hello ! " + name);
	}
}

``` 

### Archivo de configuracion del Spring Bean

```
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
	<bean id="helloBean" class="com.mkyong.core.HelloWorld">
		<property name="name" value="Mkyong" />
	</bean>
</beans>
```

### Ejecutalo desde la clase principal ../src/main/java/App.java

```
package com.mkyong.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();
	}
}
```

## Construido con:

* [Maven](https://maven.apache.org/) - Manejador de Dependencias
* [Spring](https://spring.io/) - Contenedor de inversión de control

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*

