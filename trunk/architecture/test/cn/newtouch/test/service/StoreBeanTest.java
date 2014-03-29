package cn.newtouch.test.service;

import java.util.List;

import org.junit.Test;

public class StoreBeanTest
{

    @Test
    public void test()
    {
        StoreBean aaa = new StoreBean();
        List<Store> zzz = aaa.getAll();
        System.out.println(zzz.size());
    }
}
