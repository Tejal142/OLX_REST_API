package com.olx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OlxLoginApplication {

	public static void main(String[] args) {
		System.out.println("in........................");
		SpringApplication.run(OlxLoginApplication.class, args);
		System.out.println("........................out");

	}

}
