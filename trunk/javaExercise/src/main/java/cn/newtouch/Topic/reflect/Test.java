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
package cn.newtouch.Topic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test
{

    /**
     * Description of this Method
     * 
     * @since 2012-1-6
     * @author zzHe
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException
    {
        Class cla = Class.forName("com.drcl.reflect.Student");
        // 解析属性信息
        Field[] f = cla.getDeclaredFields();
        for (Field field : f)
        {
            System.out.println("属性=" + field.toString());
            System.out.println("数据类型＝" + field.getType());
            System.out.println("属性名＝" + field.getName());
            int mod = field.getModifiers();
            System.out.println("属性修饰符＝" + Modifier.toString(mod));
            System.out.println("===========================");
        }
        // 解析方法信息
        Method[] methodlist = cla.getDeclaredMethods();
        for (Method method : methodlist)
        {
            System.out.println("---------------");
            System.out.println("方法＝" + method.toString());
            System.out.println("方法名＝" + method.getName());
            int mod = method.getModifiers();
            System.out.println("方法修饰符＝" + Modifier.toString(mod));
            System.out.println("方法参数列表");
            Class pts[] = method.getParameterTypes();
            for (int i = 0; i < pts.length; i++)
            {
                Class class1 = pts[i];
                if (i != 0)
                {
                    System.out.println(class1);
                }
                System.out.println("返回类型" + method.getReturnType());
            }
        }

    }

}
