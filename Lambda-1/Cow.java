package org.example;
public class Cow implements Main.Animal {
    private String talk;

    public Cow(String talk) {
        this.talk = talk;
    }

    public String Talk() {
        return talk;
    }
}