package javaconcurrency.chapter1;

//UnsafeSequence
public class E1_1
{
    private int value;

    public int getNext()
    {
        return this.value++;
    }
}