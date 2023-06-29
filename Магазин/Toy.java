package org.example;

public class Toy extends Product {

    public Toy (String name, int cost, int age) {

        super(name, cost);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    private int age;

}