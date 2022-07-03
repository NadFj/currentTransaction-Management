package com.currentTransaction.trm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.currentTransaction.trm"})
public class TransactionsApConfig {
	/*
	@Bean
	public InternalResourceViewResolver viewsResolvers () {
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	viewResolver.setPrefix("/WEB-INF/view/");
	viewResolver.setSuffix(".jsp");
	System.out.println("view "+viewResolver.toString());
	return viewResolver;
	}
	*/
	

	 
	

}
