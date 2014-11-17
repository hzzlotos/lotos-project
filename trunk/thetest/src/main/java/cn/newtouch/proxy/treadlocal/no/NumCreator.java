package cn.newtouch.proxy.treadlocal.no;

public class NumCreator
{
    private int nextNum; // 当前生成的数字

    public NumCreator()
    {
        this.nextNum = 0;
    }

    public int getNextNum()
    {
        return this.nextNum++;
    }
}
