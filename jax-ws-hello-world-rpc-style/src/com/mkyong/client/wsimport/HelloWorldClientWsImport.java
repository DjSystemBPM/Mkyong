package com.mkyong.client.wsimport;

public class HelloWorldClientWsImport {

	public static void main(String[] args) {

		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld hello = helloService.getHelloWorldImplPort();

		System.out.println(hello.getHelloWorldAsString("Alfred"));

	}

}
