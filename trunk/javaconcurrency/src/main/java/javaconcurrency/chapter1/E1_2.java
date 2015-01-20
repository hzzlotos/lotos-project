package javaconcurrency.chapter1;

//UnsafeSequence
public class E1_2
{
    private int value;

    public synchronized int getNext()
    {
        return this.value++;
    }
}