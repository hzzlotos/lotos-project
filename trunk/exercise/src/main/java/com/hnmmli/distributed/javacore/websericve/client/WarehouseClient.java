package com.hnmmli.distributed.javacore.websericve.client;

import java.rmi.RemoteException;

import javax.naming.NamingException;

/**
 * The client for the warehouse program.
 * 
 * @version 1.0 2007-10-09
 * @author Cay Horstmann
 */
public class WarehouseClient
{
    public static void main(String[] args) throws NamingException, RemoteException
    {
        // 该包下面的其他类都是由wsimpot生成
        // wsimport -keep -d g:/classpath -p com.hnmmli.distributed.javacore.websericve
        // http://localhost:8080/WebServices/warehouse?wsdl
        WarehouseService service = new WarehouseService();
        Warehouse port = service.getPort(Warehouse.class);

        String descr = "啊哈";// 测试中文
        double price = port.getPrice(descr);
        System.out.println(descr + ": " + price);
    }
}
