# Spring Core Desacoplar Clases

Este es un ejemplo donde se desacoplan las clases con spring para su mejor 

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

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.mkyong.output</groupId>
  <artifactId>spring-core-loosely-coupled</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>spring-core-loosely-coupled</name>
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

### Creas la interfaz IOutputGenerator.java

```
package com.mkyong.output;

public interface IOutputGenerator
{
	public void generateOutput();
}
``` 

### Creas dos clases que implementen la anterior

```
package com.mkyong.output.impl;

import com.mkyong.output.IOutputGenerator;

public class CsvOutputGenerator implements IOutputGenerator
{
	public void generateOutput(){
		System.out.println("Csv Output Generator");
	}
}


y 


package com.mkyong.output.impl;

import com.mkyong.output.IOutputGenerator;

public class JsonOutputGenerator implements IOutputGenerator
{
	public void generateOutput(){
		System.out.println("Json Output Generator");
	}
}
``` 

### Crea una clase para invocar mas facilmente  

OutputHelper.java 

```
package com.mkyong.output;

import com.mkyong.output.IOutputGenerator;

public class OutputHelper
{
	IOutputGenerator outputGenerator;

	public void generateOutput(){
		outputGenerator.generateOutput();
	}

	public void setOutputGenerator(IOutputGenerator outputGenerator){
		this.outputGenerator = outputGenerator;
	}
}

```

###Creas un bean de Spring como archivo de configuracion y declara aqui tus objetos de java

```
<!-- Spring-Common.xml -->
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">
	<bean id="OutputHelper" class="com.mkyong.output.OutputHelper">
		<property name="outputGenerator" ref="CsvOutputGenerator" />
	</bean>
	<bean id="CsvOutputGenerator" class="com.mkyong.output.impl.CsvOutputGenerator" />
	<bean id="JsonOutputGenerator" class="com.mkyong.output.impl.JsonOutputGenerator" />
</beans>
```
### Ejecutalo desde la clase principal ../src/main/java/App.java

```
package com.mkyong.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.output.OutputHelper;

public class App
{
    public static void main( String[] args )
    {
    	ApplicationContext context =
    	   new ClassPathXmlApplicationContext(new String[] {"Spring-Common.xml"});

    	OutputHelper output = (OutputHelper)context.getBean("OutputHelper");
    	output.generateOutput();

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

