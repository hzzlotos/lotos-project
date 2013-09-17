package cn.newtouch.Topic.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ArithmeticReflec
{

    @SuppressWarnings("unchecked")
    public Object doMethod(String classNmae, String methodName, Object[] param)
    {

        Class c = null;

        Method[] ms;

        Method m = null;

        Object sss = null;

        try
        {
            c = Class.forName(classNmae);

            Object obj = c.newInstance();

            ms = c.getMethods();

            for (Method mm : ms)
            {

                if (methodName.equals(mm.getName()))
                {

                    m = mm;
                }
            }

            if (null != m)
            {

                sss = m.invoke(obj, param);
            }

        }
        catch (ClassNotFoundException e)
        {

            e.printStackTrace();

        }
        catch (SecurityException e)
        {

            e.printStackTrace();

        }
        catch (InstantiationException e)
        {

            e.printStackTrace();

        }
        catch (IllegalAccessException e)
        {

            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {

            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }

        return sss;
    }
}
