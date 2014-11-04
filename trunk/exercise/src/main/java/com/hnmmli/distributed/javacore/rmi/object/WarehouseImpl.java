package com.hnmmli.distributed.javacore.rmi.object;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is the implementation for the remote Warehouse interface.
 * 
 * @version 1.0 2007-10-09
 * @author Cay Horstmann
 */
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse
{
    private Warehouse            backup;

    private Map<String, Product> products;

    /**
     * Constructs a warehouse implementation.
     */
    public WarehouseImpl(Warehouse backup) throws RemoteException
    {
        this.products = new HashMap<String, Product>();
        this.backup = backup;
    }

    public void add(String keyword, Product product)
    {
        product.setLocation(this);
        this.products.put(keyword, product);
    }

    @Override
    public double getPrice(String description) throws RemoteException
    {
        for (Product p : this.products.values())
        {
            if (p.getDescription().equals(description))
            {
                return p.getPrice();
            }
        }
        if (this.backup == null)
        {
            return 0;
        }
        else
        {
            return this.backup.getPrice(description);
        }
    }

    @Override
    public Product getProduct(List<String> keywords) throws RemoteException
    {
        for (String keyword : keywords)
        {
            Product p = this.products.get(keyword);
            if (p != null)
            {
                return p;
            }
        }
        if (this.backup != null)
        {
            return this.backup.getProduct(keywords);
        }
        else
            if (this.products.values().size() > 0)
            {
                return this.products.values().iterator().next();
            }
            else
            {
                return null;
            }
    }
}
