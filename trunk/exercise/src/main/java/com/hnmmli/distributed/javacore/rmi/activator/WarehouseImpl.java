package com.hnmmli.distributed.javacore.rmi.activator;

import java.io.IOException;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationID;
import java.util.Map;

/**
 * This class is the implementation for the remote Warehouse interface.
 * 
 * @version 1.0 2007-10-20
 * @author Cay Horstmann
 */
public class WarehouseImpl extends Activatable implements Warehouse
{
    public WarehouseImpl(ActivationID id, MarshalledObject<Map<String, Double>> param) throws RemoteException,
            ClassNotFoundException, IOException
    {
        super(id, 0);
        this.prices = param.get();
        System.out.println("Warehouse implementation constructed.");
    }

    @Override
    public double getPrice(String description) throws RemoteException
    {
        Double price = this.prices.get(description);
        return price == null ? 0 : price;
    }

    private Map<String, Double> prices;
}
