package cn.newtouch.exception;

import java.lang.reflect.InvocationTargetException;

public class BaseException extends Exception
{
    private static final long serialVersionUID     = 1L;

    private int               errorKey;

    public static int         CLASS_NOT_FOUND_KEY  = 1;

    public static int         MOTHED_NOT_FOUND_KEY = 2;

    public BaseException(Throwable e, int errorKey)
    {
        super(e);
        this.errorKey = errorKey;
    }

    public BaseException(Throwable e)
    {
        super(e);
    }

    public BaseException(int errorKey)
    {
        this.errorKey = errorKey;
    }

    public int getErrorKey()
    {
        return this.errorKey;
    }

    @Override
    public Throwable getCause()
    {
        return this.getCause(this);
    }

    private Throwable getCause(Throwable e)
    {
        if (e.getClass() == InvocationTargetException.class)
        {
            return ((InvocationTargetException) e).getTargetException();
        }
        return e.getCause();
    }
}