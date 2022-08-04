package com.qa.firstSpring.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class BeansExample {

	@Bean
	void helloWorld() {

		System.out.println("Hello World 2");
	}

	@Bean
	ModelMap mapper() {
		return new ModelMap();

	}

}
