package javaconcurrency.chapter1;

//Sequence
//TheadSafe 线程安全的数值序列生成器
public class E1_2
{
    private int value;

    public synchronized int getNext()
    {
        return this.value++;
    }
}