# JAX-WS Hello World Document Style

Este es un ejemplo de Hola mundo de un Web service SOAP con Jax-Ws en modo Document

## Como iniciar la aplicacion

Estas son las instrucciones para levantar el proyecto de manera correcta


### 1.- Creas una Interface del Web Service Endpoint Hello.java

```
package com.mkyong.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface HelloWorld{

	@WebMethod String getHelloWorldAsString(String name);

}

```
### 2.- Creas la implementacion del Web Service Endpoint HelloWorldImpl.java

```
package com.mkyong.ws;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.mkyong.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hola Mundo JAX-WS " + name;
	}

}
	
```

### 3.- Creas la clase que publica el Endpoint HelloWorldPublisher.java

```
package com.mkyong.endpoint;

import javax.xml.ws.Endpoint;
import com.mkyong.ws.HelloWorldImpl;

//Endpoint publisher
public class HelloWorldPublisher{

	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
    }

}

```

### 4.- Ingresa a la carpeta bin del proyecto y ejecuta el wsgen

Esto creara una carpeta con clases (jaxws), copia las clase al paquete com.mkyong.jaxws

```
$ wsgen -keep -cp . com.mkyong.ws.HelloWorldImpl

```
### 5.- Verifica que el WSDL este arriba http://localhost:9999/ws/hello?wsdl

### 6.- Creas el cliente para consumir ese web service HelloWorldClient.java

```
package com.mkyong.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.mkyong.ws.HelloWorld;

public class HelloWorldClient {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:9999/ws/hello?wsdl");
		QName qname = new QName("http://ws.mkyong.com/", "HelloWorldImplService");
		Service service = Service.create(url, qname);
		HelloWorld hello = service.getPort(HelloWorld.class);

		System.out.println(hello.getHelloWorldAsString("Alfredo"));

	}

}
```

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*