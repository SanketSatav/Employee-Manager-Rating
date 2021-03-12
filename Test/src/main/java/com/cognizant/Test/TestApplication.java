package com.cognizant.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//
//@EnableJpaRepositories(basePackages = "com.cognizant.Test.repository")
//@ComponentScan(basePackages = "com.cognizant.Test")
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		System.out.println("hg");
	}

}
