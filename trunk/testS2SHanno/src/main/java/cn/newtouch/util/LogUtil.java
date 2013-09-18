//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: zzHe
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
// SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package cn.newtouch.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 
 * 打印log类
 * 
 * @author zzHe
 * @version 1.0
 * @since 2011-11-9
 */
public class LogUtil
{
    public static final String START = "start !";

    public static final String END   = "end !";

    /**
     * 
     * 打印类/方法的调用情况
     * 
     * @since 2011-11-9
     * @author zzHe
     * @param action
     */
    public static void printlnLog(String action)
    {
        StackTraceElement element = new Exception().getStackTrace()[1];
        System.out.println("-----------类名:" + element.getClassName()
                + "------方法名:" + element.getMethodName() + "()------" + action);
    }

    /**
     * 
     * 打印obj所有属性信息， map不适用
     * 
     * @since 2012-2-10
     * @author zzHe
     * @param obj
     * @throws Exception
     */
    public static void getMethodValue(Object obj) throws Exception
    {
        Class clazz = obj.getClass();
        Field[] fields = obj.getClass().getDeclaredFields();// 获得属性
        for (Field field : fields)
        {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
                    clazz);
            Method getMethod = pd.getReadMethod();// 获得get方法
            if (getMethod.getReturnType().equals(List.class)
                    || getMethod.getReturnType().equals(Set.class))
            {
                Collection<Object> obj1 = (Collection<Object>) getMethod
                        .invoke(obj);
                for (Object obj2 : obj1)
                {
                    getMethodValue(obj2);
                }
            }
            else
            {
                System.out.println("=====" + getMethod.getName() + "====="
                        + getMethod.invoke(obj));
            }
        }
    }
}
