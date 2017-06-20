![Spring Core Tutorials](https://upload.wikimedia.org/wikipedia/en/2/20/Pivotal_Java_Spring_Logo.png)

# Spring Core JAVA Config

Este es un ejemplo de spring core para conocer mas a fondo los siguientes componentes:

* Componente Spring Java Config: para la configuracion de los beans con java


## Como iniciar la aplicacion

Estas son las instrucciones para levantar el proyecto de manera correcta

## Librerias requeridas

```
1. Spring 2.5.6
2. Maven 3.0.3
3. Eclipse 3.6
4. JDK 1.6.0.13
```

## Dependencias pom.xml

```
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

<!-- JavaConfig need this library -->
<dependency>
	<groupId>cglib</groupId>
	<artifactId>cglib</artifactId>
	<version>2.2.2</version>
</dependency>

```


### 1.- CREAS LA INTERFACE HelloWorld.java

```
public interface HelloWorld {

	void printHelloWorld(String msg);

}

```


### 2.- CREAS LA CLASE QUE IMPLEMENTA HelloWorldImpl.java

```
public class HelloWorldImpl implements HelloWorld {

	@Override
	public void printHelloWorld(String msg) {

		System.out.println("Hello : " + msg);
	}

}

```

### 3.- CREAS LA CLASE AppConfig.java CON ANOTACIONES

La cual es el equivalente a tener un xml de configuracion

```
...

@Configuration
public class AppConfig {

    @Bean(name="helloBean")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }

}

...

```


### 4.- CREAMOS LA CLASE App.java PARA CORRER EL PROYECTO

```
public class App {
	public static void main(String[] args) {

            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    HelloWorld obj = (HelloWorld) context.getBean("helloBean");

	    obj.printHelloWorld("Spring3 Java Config");

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

