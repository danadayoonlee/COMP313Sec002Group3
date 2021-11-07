package com.curahealthyme.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.curahealthyme.repo.PatientRepository;

@SpringBootApplication   
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.curahealthyme.project", "com.curahealthyme.controller"})
@EnableJpaRepositories(basePackages="com.curahealthyme.repo")
@EnableTransactionManagement
@EntityScan(basePackages="com.curahealthyme.model")
public class CuraHealthyMeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CuraHealthyMeApplication.class, args);
		System.out.println("CuraHealthyMe app is running...");
	}

}
