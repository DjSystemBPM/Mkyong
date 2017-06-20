package com.mkyong.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name="helloBean")
	public Helloworld helloWorld(){
		return new HelloWorldImpl();
	}
}
