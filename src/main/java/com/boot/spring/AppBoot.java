package com.boot.spring;

import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * Created by darlan on 25/01/17.
 */
@EnableAutoConfiguration
@SpringBootApplication
public class AppBoot {

	private static final Logger log = LoggerFactory.getLogger(AppBoot.class);
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(AppBoot.class, args);
	}

	String host() {
		return environment.getProperty("MONGO_HOST");
	}

	String port() {
		return environment.getProperty("MONGO_PORT");
	}

	@Bean
	MongoClient mongoClient() {
		String connectionUrl = "mongodb://" + host() + ":" + port();
		log.info("Trying to connection on -> {}", connectionUrl);
		return MongoClients.create(connectionUrl);
	}

	@Bean
	ResourceConfig jerseyConfig() {
		return new ResourceConfig()
				.register(PersonsImpl.class);
	}

}
