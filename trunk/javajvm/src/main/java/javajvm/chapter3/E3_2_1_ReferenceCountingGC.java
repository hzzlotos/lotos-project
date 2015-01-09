package javajvm.chapter3;

/**
 * testGC()方法执行后，objA和objB会不会被GC呢？
 * VM Args：-Xloggc:g:\eclipse\gc.log
 */
public class E3_2_1_ReferenceCountingGC
{

    public Object            instance = null;

    private static final int _1MB     = 1024 * 1024;

    /**
     * 这个成员属性的唯一意义就是占点内存，以便在能在GC日志中看清楚是否有回收过
     */
    private byte[]           bigSize  = new byte[2 * _1MB];

    public static void testGC()
    {
        E3_2_1_ReferenceCountingGC objA = new E3_2_1_ReferenceCountingGC();
        E3_2_1_ReferenceCountingGC objB = new E3_2_1_ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 假设在这行发生GC，objA和objB是否能被回收？
        System.gc();
    }

    public static void main(String[] args)
    {
        testGC();
    }
}
