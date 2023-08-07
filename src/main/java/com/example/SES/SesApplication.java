package com.example.SES;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

public class SesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SesApplication.class, args);
	}



}
