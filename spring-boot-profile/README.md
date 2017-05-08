# Spring Boot Profiles 	

Este es un ejemplo de Spring boot profiles

## Como iniciar la aplicacion

Estas son las instrucciones para levantar el proyecto de manera correcta

### Librerias requeridas

```
1. Spring Boot 1.5.1.RELEASE
2. Maven 3
```
### pom.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
	http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <artifactId>spring-boot-profile</artifactId>
    <packaging>jar</packaging>
    <name>Spring Boot Profiles Example</name>
    <description>Spring Boot Profiles Example</description>
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

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
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

### Creamos una interfaz

```
package com.mkyong.service;

public interface WeatherService {

    String forecast();

}
``` 	

### Creamos un profile de dia soleado y default
```
package com.mkyong.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"sunny", "default"})
public class SunnyDayService implements WeatherService {

    @Override
    public String forecast() {
        return "Today is sunny day!";
    }

}

```

### Y tambien un profile de dia lluvioso

```
package com.mkyong.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("raining")
public class RainingDayService implements WeatherService {

    @Override
    public String forecast() {
        return "Today is raining day!";
    }

}
```

### Lo empaquetamos y lo ejecutamos

```
$ mvn package

/#default profile, sunny day!
$ java -jar target/spring-boot-profile-1.0.jar
Today is sunny day!

/# set a profile
$ java -jar -Dspring.profiles.active=raining target/spring-boot-profile-1.0.jar
Today is raining day!
```

## Construido con:

* [Maven](https://maven.apache.org/) - Manejador de Dependencias
* [Spring y Spring Boot](https://spring.io/) - Contenedor de inversión de control

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*