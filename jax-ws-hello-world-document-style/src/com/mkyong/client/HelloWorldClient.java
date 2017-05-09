package com.mkyong.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.mkyong.ws.HelloWorld;

public class HelloWorldClient {

	public static void main(String[] args) throws Exception {
//      SI QUIERES UTILIZAR EL TCP/IP MONITOR CAMBIAS EL PUERTO POR EL CONFIGURADO EN EL TCP/IP MONITOR
//		URL url = new URL("http://localhost:8888/ws/hello?wsdl");
		URL url = new URL("http://localhost:9999/ws/hello?wsdl");
		QName qname = new QName("http://ws.mkyong.com/", "HelloWorldImplService");
		Service service = Service.create(url, qname);
		HelloWorld hello = service.getPort(HelloWorld.class);

		System.out.println(hello.getHelloWorldAsString("Alfredo"));

	}

}
