package com.mkyong.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Helloworld obj = (Helloworld) context.getBean("helloBean");
		
		obj.printHelloWorld("SPRING JAVA CONFIG");
	}
}
