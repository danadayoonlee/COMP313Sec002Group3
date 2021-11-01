package com.curahealthyme.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@ComponentScan(basePackages = {"com.curahealthyme.project", "com.curahealthyme.controller", "com.curahealthyme.model", "com.curahealthyme.repo"})
public class CuraHealthyMeApplication extends SpringBootServletInitializer {
 

	public static void main(String[] args) {
		SpringApplication.run(CuraHealthyMeApplication.class, args);
		System.out.println("CuraHealthyMe app is running...");
	}

}
