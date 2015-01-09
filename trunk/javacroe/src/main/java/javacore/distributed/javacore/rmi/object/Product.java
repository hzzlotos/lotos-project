package javacore.distributed.javacore.rmi.object;

import java.io.Serializable;

public class Product implements Serializable
{
    public Product(String description, double price)
    {
        this.description = description;
        this.price = price;
    }

    public String getDescription()
    {
        return this.description;
    }

    public double getPrice()
    {
        return this.price;
    }

    public Warehouse getLocation()
    {
        return this.location;
    }

    public void setLocation(Warehouse location)
    {
        this.location = location;
    }

    private String    description;

    private double    price;

    private Warehouse location;
}
