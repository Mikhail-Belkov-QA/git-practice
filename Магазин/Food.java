package org.example;

import java.util.Date;

public class Food extends Product
{
    public Food (String name, int cost, Date date)
    {
        super(name, cost);
        this.date = date;
    }

    protected Date date;

    public Date getDate() {
        return date;
    }
}
