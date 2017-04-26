# Spring Boot Non Web	

Este es un Hola Mundo de spring boot

## Como iniciar la aplicacion

Estas son las instrucciones para levantar el proyecto de manera correcta

### Spring Boot aplicacion de escritorio

Cuando es una aplicacion de escritorio hecha en spring boot tenemos que implementar la interfaz CommandLineRunner y sobreescribir el metodo run()

```
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(SpringBootConsoleApplication.class, args);

    }

    //access command line arguments
    @Override
    public void run(String... args) throws Exception {

        //do something

    }
}

```
### pom.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
  http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.mkyong</groupId>
    <artifactId>spring-boot-simple</artifactId>
    <packaging>jar</packaging>
    <version>1.0</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.1.RELEASE</version>
    </parent>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
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

### Un servicio regresa el mensaje

```
package com.mkyong.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloMessageService {

    @Value("${name:unknown}")
    private String name;

    public String getMessage() {
        return getMessage(name);
    }

    public String getMessage(String name) {
        return "Hello " + name;
    }

}
``` 

### Archivo de Properties

Este se coloca en /src/main/resources/

``
/src/main/resources/application.properties
``
```
name=Alfredo
```

### Empaquetamos el proyecto y lo corremos

```
$ mvn package 

$ java -jar target/spring-boot-simple-1.0.jar
Hello Alfredo

$ java -jar target/spring-boot-simple-1.0.jar "Donald Trump"
Hello Donald Trump

```


## Construido con:

* [Maven](https://maven.apache.org/) - Manejador de Dependencias
* [Spring y Spring Boot](https://spring.io/) - Contenedor de inversión de control

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*

