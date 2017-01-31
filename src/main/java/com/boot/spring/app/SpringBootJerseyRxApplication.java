package com.boot.spring.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by darlan on 25/01/17.
 */
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = { "com.boot.spring" })
public class SpringBootJerseyRxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJerseyRxApplication.class, args);
	}

}
