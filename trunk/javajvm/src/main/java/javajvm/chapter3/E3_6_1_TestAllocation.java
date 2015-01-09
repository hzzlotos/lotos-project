package javajvm.chapter3;

public class E3_6_1_TestAllocation
{
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * (-XX:+UseSerialGC)//添加该参数指定使用Serial GC收集器
     */
    public static void main(String[] args)
    {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];// 出现一次Minor GC
    }
}