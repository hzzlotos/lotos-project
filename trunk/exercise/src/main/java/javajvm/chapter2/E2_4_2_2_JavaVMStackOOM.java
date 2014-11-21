package javajvm.chapter2;

/**
 * VM Args：-Xss2M （这时候不妨设大些）
 * 直接跑死机了，不要实验了！
 */
public class E2_4_2_2_JavaVMStackOOM
{

    private void dontStop()
    {
        while (true)
        {
        }
    }

    public void stackLeakByThread()
    {
        while (true)
        {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run()
                {
                    E2_4_2_2_JavaVMStackOOM.this.dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable
    {
        E2_4_2_2_JavaVMStackOOM oom = new E2_4_2_2_JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
