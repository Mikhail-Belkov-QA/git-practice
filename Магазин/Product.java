package org.example;

public class Product {
    public String name;
    public int cost;

    public Product(String name, int cost) {
        this.name = name;
        this.cost = cost;

    }


    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

}