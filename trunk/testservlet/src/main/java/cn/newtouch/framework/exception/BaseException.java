package cn.newtouch.framework.exception;

public class BaseException extends Exception
{
    private static final long serialVersionUID     = 1L;

    private int               key;

    public static int         CLASS_NOT_FOUND_KEY  = 1;

    public static int         MOTHED_NOT_FOUND_KEY = 2;

    public BaseException(int key)
    {
        this.key = key;
    }

    public void setKey(int key)
    {
        this.key = key;
    }

    public int getKey()
    {
        return this.key;
    }
}
