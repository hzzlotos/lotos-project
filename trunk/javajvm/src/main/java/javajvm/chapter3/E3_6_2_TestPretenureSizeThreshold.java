package javajvm.chapter3;

public class E3_6_2_TestPretenureSizeThreshold
{

    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     * (-XX:+UseSerialGC)//添加该参数指定使用Serial GC收集器
     */
    public static void main(String[] args)
    {
        byte[] allocation;
        allocation = new byte[4 * _1MB]; // 直接分配在老年代中
    }

}