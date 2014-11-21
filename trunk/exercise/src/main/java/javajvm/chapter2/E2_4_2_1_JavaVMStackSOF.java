package javajvm.chapter2;

/**
 * VM Args：-Xss128k
 * 小于128K时 出现错误
 * The stack size specified is too small, Specify at least 104k
 * 这里崩掉是因为方法调用的栈深度不断增加导致的
 */
public class E2_4_2_1_JavaVMStackSOF
{
    private int stackLength = 1;

    public void stackLeak()
    {
        this.stackLength++;
        this.stackLeak();
    }

    public static void main(String[] args) throws Throwable
    {
        E2_4_2_1_JavaVMStackSOF oom = new E2_4_2_1_JavaVMStackSOF();
        try
        {
            oom.stackLeak();
        }
        catch (Throwable e)
        {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}