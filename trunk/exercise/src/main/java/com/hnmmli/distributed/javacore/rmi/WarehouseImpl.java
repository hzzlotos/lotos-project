package com.hnmmli.distributed.javacore.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is the implementation for the remote Warehouse interface.
 * 
 * @version 1.0 2007-10-09
 * @author Cay Horstmann
 */
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse
{
    /*
     * 如果不想继承UnicastRemoteObject话，则可以在构造方法中调用UnicastRemoteObject.exportObject(this,0);
     * 第二个参数为0表示任意合适的端口都可用来监听客户连接
     */
    public WarehouseImpl() throws RemoteException
    {
        this.prices = new HashMap<String, Double>();
        this.prices.put("Blackwell Toaster", 24.95);
        this.prices.put("ZapXpress Microwave Oven", 49.95);
    }

    @Override
    public double getPrice(String description) throws RemoteException
    {
        Double price = this.prices.get(description);
        return price == null ? 0 : price;
    }

    private Map<String, Double> prices;
}
