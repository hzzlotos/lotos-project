package com.hnmmli.distributed.javacore.websericve;

import javax.xml.ws.Endpoint;

public class WarehouseServer
{
    public static void main(String[] args)
    {
        Endpoint.publish("http://localhost:8080/WebServices/warehouse", new Warehouse());
    }
}
