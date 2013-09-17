package com.drcl.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class VoEntityInterceptor implements MethodInterceptor
{
    private Object  dest;

    private Object  orig;

    private boolean initial;

    public VoEntityInterceptor(Object dest, Object orig)
    {
        this.orig = orig;
        this.dest = dest;
    }

    /**
     * 创建代理
     * 
     * @param
     * @return
     */
    public Object getInstance()
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(dest.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @SuppressWarnings("unchecked")
    public Object intercept(Object target, Method method, Object[] args,
            MethodProxy proxy) throws Throwable
    {
        String destMethodName = method.getName();
        if ("getId".equals(destMethodName) && !initial)
        {
            return initialObject(target, method, args);
        }
        else
            if (!initial && destMethodName.startsWith("get")
                    && !"getClass".equals(destMethodName))
            {
                Method[] targetMethods = target.getClass().getSuperclass()
                        .getMethods();
                Object result = null;
                String getName = null;
                String fieldName = null;

                for (Method targetMethod : targetMethods)
                {
                    getName = targetMethod.getName();
                    if (getName.startsWith("get")
                            && !"getClass".equals(getName))
                    {
                        fieldName = getName.substring(3, 4).toLowerCase()
                                + getName.substring(4);
                        result = initialObject(target, targetMethod,
                                new Object[0]);
                        BeanAssistor.invokeSet(target, fieldName, result);
                    }
                }
                initial = true;
                return proxy.invokeSuper(target, args);
            }
        return proxy.invokeSuper(target, args);
    }

    @SuppressWarnings("unchecked")
    public Object initialObject(Object target, Method method, Object[] args)
            throws Throwable
    {
        String destMethodName = method.getName();
        try
        {
            if (destMethodName.startsWith("get"))
            {
                Mapper mapper = method.getAnnotation(Mapper.class);
                String origGetMethod = BeanAssistor.getOrigMethodName(method,
                        mapper, orig.getClass().getName());
                if (origGetMethod == null)
                {
                    return null;
                }

                Method origMethod = null;
                try
                {
                    origMethod = orig.getClass().getMethod(origGetMethod);
                }
                catch (Exception e)
                {
                    return null;
                }

                Object value = origMethod.invoke(orig, args);
                int valueType = BeanAssistor.getType(value);
                if (valueType == 0)
                {
                    return null;
                }
                if (valueType == BeanAssistor.FINAL
                        || valueType == BeanAssistor.PRIMITIVE
                        || valueType == BeanAssistor.OBJECT)
                {
                    return value;
                }

                String propName = destMethodName.substring(3, 4).toLowerCase()
                        + destMethodName.substring(4);
                Field field = null;
                try
                {
                    field = target.getClass().getSuperclass().getDeclaredField(
                            propName);
                }
                catch (Exception e)
                {
                    return null;
                }
                Class declareClass = field.getType();
                int typeValue = BeanAssistor.getType(declareClass);
                if (typeValue == BeanAssistor.OTHER)
                {
                    return BeanUtil.copyProperties(declareClass.newInstance(),
                            value);
                }
                else
                    if (typeValue >= BeanAssistor.LIST)
                    {
                        ParameterizedType type = (ParameterizedType) field
                                .getGenericType();
                        Type[] types = type.getActualTypeArguments();
                        Class raw = (Class) type.getRawType();
                        if (types != null && types.length == 1)
                        {
                            Class paramType = (Class) types[0];
                            int genericType = BeanAssistor.getType(raw);
                            if (genericType == BeanAssistor.LIST
                                    && valueType == BeanAssistor.LIST)// 实现list集合
                            {
                                List<Object> list = new ArrayList<Object>();
                                return BeanAssistor.copyCollection(list,
                                        (List) value, paramType);
                            }
                        }
                        else
                            if (types != null && types.length == 2)
                            {
                                Class mapvalueType = (Class) types[1];
                                int genericType = BeanAssistor.getType(raw);
                                if (genericType == BeanAssistor.MAP
                                        && valueType == BeanAssistor.MAP)// 实现map集合
                                {
                                    Map map = new HashMap();
                                    return BeanAssistor.copyCollection(map,
                                            (Map) value, mapvalueType);
                                }
                            }
                    }
                    else
                        if (typeValue == BeanAssistor.ARRAY)// 实现array
                        {
                            Class paramType = field.getType();
                            String paramTypeName = paramType.getName()
                                    .substring(2);
                            paramTypeName = paramTypeName.substring(0,
                                    paramTypeName.length() - 1);
                            return BeanAssistor.copyArray(null,
                                    (Object[]) value, Class
                                            .forName(paramTypeName));
                        }
                return value;
            }
            else
                if (destMethodName.startsWith("set"))
                {
                    return null;
                }
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
