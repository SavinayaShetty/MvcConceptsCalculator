package com.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.allservices.Calci;
import com.allservices.CalciA;
import com.allservices.Check;
import com.allservices.DbOperations;
import com.allservices.MathOperations;
import com.allservices.SignupService;


@Configuration
@ComponentScan({"com.controller"})
public class PageConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	public Check check() {
		return new Check();
	}
	
	@Bean
	public MathOperations cal() {
		return new Calci();
	}
	
	@Bean
	public DbOperations signup() {
		return new SignupService();
	}
}
