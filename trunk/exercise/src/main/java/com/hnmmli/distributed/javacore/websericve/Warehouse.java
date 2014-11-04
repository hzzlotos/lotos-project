package com.hnmmli.distributed.javacore.websericve;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * This class is the implementation for a Warehouse web service
 * 
 * @version 1.0 2007-10-09
 * @author Cay Horstmann
 */

@WebService
public class Warehouse
{
    public Warehouse()
    {
        this.prices = new HashMap<String, Double>();
        this.prices.put("Blackwell Toaster", 24.95);
        this.prices.put("ZapXpress Microwave Oven", 49.95);
        this.prices.put("啊哈", 49.95);// 测试中文
    }

    public double getPrice(@WebParam(name = "description") String description)
    {
        Double price = this.prices.get(description);
        System.out.println(description + "get server :" + price);// test //测试中文
        return price == null ? 0 : price;
    }

    private Map<String, Double> prices;
}
