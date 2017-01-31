package com.boot.spring.person;

import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import rx.Observable;
import rx.schedulers.Schedulers;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by darlan on 25/01/17.
 */
@Component
public class PersonRepository {

    @Autowired
    private ApplicationContext context;
    private MongoCollection<Document> collection;

    @PostConstruct
    public void onStart() {
        collection = context.getBean(MongoClient.class)
                .getDatabase("db")
                .getCollection("person");
    }

    Observable<List<Person>> list() {
        return Observable.<List<Person>>create(s -> {
            List<Person> list = new ArrayList<>();
            SingleResultCallback<Void> callback = (result, exception) -> {
                if (exception != null)
                    s.onError(exception);
                else
                    s.onNext(list);
                s.onCompleted();
            };
            collection.find().forEach(document -> list.add(new Person(document)), callback);
        }).subscribeOn(Schedulers.io());
    }

    Observable<Person> post(Person person) {
        return Observable.<Person>create(s -> {
            Document document = person.toDocument();
            collection.insertOne(document, (result, exception) -> {
                if(exception != null)
                    s.onError(exception);
                else
                    s.onNext(new Person(document));
                s.onCompleted();
            });
        }).subscribeOn(Schedulers.io());
    }

}
