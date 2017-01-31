package com.boot.spring.person;

import org.bson.Document;

/**
 * Created by darlan on 25/01/17.
 */
public class Person {

    private String id;
    private String name;
    private Integer age;
    private Integer weight;
    private String address;

    public Person() {
    }

    Person(Document document) {
        this.id = document.getObjectId("_id").toString();
        this.name = document.getString("name");
        this.age = document.getInteger("age");
        this.weight = document.getInteger("weight");
        this.address = document.getString("address");
    }

    Document toDocument() {
        Document document = new Document();
        document.put("name", this.name);
        document.put("age", this.age);
        document.put("weight", this.weight);
        document.put("address", this.address);
        return document;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", address='" + address + '\'' +
                '}';
    }

}
