package com.boot.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rx.schedulers.Schedulers;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 * Created by darlan on 30/01/17.
 */
@Component
public class PersonsImpl implements Persons {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void list(@Suspended AsyncResponse res) {
        personRepository.list()
            .subscribeOn(Schedulers.computation())
            .subscribe(res::resume);
    }

    @Override
    public void post(@Suspended AsyncResponse res,
                     final Person person) {
        personRepository.post(person)
                .subscribeOn(Schedulers.computation())
                .subscribe(res::resume);
    }

}
