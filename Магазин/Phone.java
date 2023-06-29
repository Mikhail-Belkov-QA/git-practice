package org.example;

public class Phone extends Product {

    public Phone (String name, int cost, String maker) {
        super(name, cost);
        this.maker = maker;

    }

    public String getMaker()
    {
        return maker;
    }

    private String maker;

}
