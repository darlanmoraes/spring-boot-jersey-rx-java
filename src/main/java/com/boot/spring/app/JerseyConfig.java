package com.boot.spring.app;

import com.boot.spring.person.PersonServiceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by darlan on 30/01/17.
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        super.register(PersonServiceImpl.class);
    }

}
