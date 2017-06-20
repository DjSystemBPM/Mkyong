![Spring Core Tutorials](https://upload.wikimedia.org/wikipedia/en/2/20/Pivotal_Java_Spring_Logo.png)

# Spring Core JAVA Config @Import

Este es un ejemplo de spring core para conocer mas a fondo los siguientes componentes:

* Componente Spring Java Config @Import: para importar la configuracion de los beans con java


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


### 1.- CREAS LAS CLASES CustomerBo.java Y Scheduler.java

```
package com.mkyong.core;

public class CustomerBo {

	public void printMsg(String msg) {

		System.out.println("CustomerBo : " + msg);
	}

}



Y 


package com.mkyong.core;

public class SchedulerBo {

	public void printMsg(String msg) {

		System.out.println("SchedulerBo : " + msg);
	}

}

```


### 2.- DECLARAMOS LOS SIGUIENTES BEANS CustomerConfig.java Y SchedulerConfig.java

```
package com.mkyong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mkyong.core.CustomerBo;

@Configuration
public class CustomerConfig {

	@Bean(name="customer")
	public CustomerBo customerBo(){

		return new CustomerBo();

	}
}


Y

package com.mkyong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mkyong.core.SchedulerBo;

@Configuration
public class SchedulerConfig {

	@Bean(name="scheduler")
	public SchedulerBo suchedulerBo(){

		return new SchedulerBo();

	}

}

```

### 3.- CREAS LA CLASE AppConfig.java CON ANOTACIONES

La cual es el equivalente a tener un xml de configuracion

```
package com.mkyong.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ CustomerConfig.class, SchedulerConfig.class })
public class AppConfig {

}

```


### 4.- CREAMOS LA CLASE App.java PARA CORRER EL PROYECTO

```
package com.mkyong.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.mkyong.config.AppConfig;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		CustomerBo customer = (CustomerBo) context.getBean("customer");
		customer.printMsg("Hello 1");

		SchedulerBo scheduler = (SchedulerBo) context.getBean("scheduler");
		scheduler.printMsg("Hello 2");

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

