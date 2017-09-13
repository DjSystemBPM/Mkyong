package com.mkyong.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mkyong.config.AppConfig;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		CustomerBo customer = (CustomerBo) context.getBean("customer");
		customer.printMsg("HOLA CUSTOMER CONFIG");
		
		SchedulerBo scheduler = (SchedulerBo) context.getBean("scheduler");
		scheduler.printMsg("HOLA SCHEDULER CONFIG");
	}
}