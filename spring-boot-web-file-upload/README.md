# Spring Boot Web File Upload	

Este es un ejemplo de como subir un archivo con de spring boot y Thymeleaf

## Como iniciar la aplicacion

Estas son las instrucciones para levantar el proyecto de manera correcta

### Librerias requeridas

```
1. Spring Boot 1.4.2.RELEASE
2. Spring 4.3.4.RELEASE
3. Tomcat Embed 8.5.6
4. Maven 3
5. Thymeleaf

```
### pom.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/maven-v4_0_0.xsd">
         <modelVersion>4.0.0</modelVersion>

    <groupId>com.mkyong</groupId>
    <artifactId>spring-boot-file-upload</artifactId>
    <packaging>jar</packaging>
    <version>1.0</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.3.RELEASE</version>
    </parent>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

        <!-- hot swapping, disable cache for template, enable live reload -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
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

### En el controller indicas donde se va subir el archivo

```
private static String UPLOADED_FOLDER = "F://temp//";

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
 :: Spring Boot ::        (v1.4.3.RELEASE)

2017-01-21 07:48:53 INFO  com.mkyong.SpringBootWebApplication - Starting SpringBootWebApplication on MKYONG-WIN10 with PID 2384 (E:\spring-boot-file-upload\target\classes started by mkyong in E:\spring-boot-file-upload)
2017-01-21 07:48:53 DEBUG com.mkyong.SpringBootWebApplication - Running with Spring Boot v1.4.3.RELEASE, Spring v4.3.5.RELEASE
2017-01-21 07:48:53 INFO  com.mkyong.SpringBootWebApplication - No active profile set, falling back to default profiles: default
2017-01-21 07:48:55 INFO  com.mkyong.SpringBootWebApplication - Started SpringBootWebApplication in 2.54 seconds (JVM running for 2.924)

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

