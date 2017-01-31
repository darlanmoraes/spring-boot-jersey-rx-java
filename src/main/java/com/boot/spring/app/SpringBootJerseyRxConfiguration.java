package com.boot.spring.app;

import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by darlan on 25/01/17.
 */
@Configuration
public class SpringBootJerseyRxConfiguration {

    @Bean
    MongoClient mongoClient() {
        return MongoClients.create("mongodb://127.0.0.1:27017");
    }

}