package javaconcurrency.chapter1;

//UnsafeSequence
//NotThreadSafe 非线程安全的数值序列生成器
public class E1_1
{
    private int value;

    public int getNext()
    {
        return this.value++;
    }
}