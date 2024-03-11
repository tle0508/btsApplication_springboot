package com.example.btsApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class BtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtsApplication.class, args);
	}

}
