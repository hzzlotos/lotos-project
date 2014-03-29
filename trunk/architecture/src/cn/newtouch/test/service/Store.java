package cn.newtouch.test.service;

public class Store implements Comparable<Store>
{
    private int storeID;

    public int getStoreID()
    {
        return this.storeID;
    }

    public void setStoreID(int storeID)
    {
        this.storeID = storeID;
    }

    @Override
    public int compareTo(Store arg0)
    {
        return 0;
    }

}
