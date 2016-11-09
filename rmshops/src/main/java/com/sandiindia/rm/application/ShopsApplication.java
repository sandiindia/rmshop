package com.sandiindia.rm.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = { "com.sandiindia" })
@Configuration
public class ShopsApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ShopsApplication.class, args);
	}
}
