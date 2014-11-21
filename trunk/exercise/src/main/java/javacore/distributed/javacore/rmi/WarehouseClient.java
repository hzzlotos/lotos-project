package javacore.distributed.javacore.rmi;

import java.rmi.RemoteException;
import java.util.Enumeration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;

/**
 * A client that invokes a remote method.
 * 
 * @version 1.0 2007-10-09
 * @author Cay Horstmann
 */
public class WarehouseClient
{
    public static void main(String[] args) throws NamingException, RemoteException
    {
        Context namingContext = new InitialContext();

        System.out.println("RMI registry bindings: ");
        Enumeration<NameClassPair> e = namingContext.list("rmi://localhost/");
        System.out.println("-----------------------------------");
        while (e.hasMoreElements())
        {
            System.out.println(e.nextElement().getName());
        }
        System.out.println("-----------------------------------");
        String url = "rmi://localhost/central_warehouse";
        Warehouse centralWarehouse = (Warehouse) namingContext.lookup(url);

        String descr = "Blackwell Toaster";
        double price = centralWarehouse.getPrice(descr);
        System.out.println(descr + ": " + price);
    }
}
