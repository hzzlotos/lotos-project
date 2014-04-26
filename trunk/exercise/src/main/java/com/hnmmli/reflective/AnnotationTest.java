//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: Administrator
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
package com.hnmmli.reflective;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.hnmmli.enumtest.EnumTest;

//注解@Retention可以用来修饰注解,是注解的注解,称为元注解
//RetentionPolicy.CLASS修饰注解,表示注解的信息被保留在class文件(字节码文件)中;当程序编译时,但不会被虚拟机读取在运行的时候
//RetentionPolicy.SOURCE修饰注解,表示注解的信息会被编译器抛弃,不会留在class文件中,注解的信息只会留在源文件中
//RetentionPolicy.RUNTIME修饰注解,表示注解的信息被保留在class文件(字节码文件)中当程序编译时,会被虚拟机保留在运行时
//RetentionPolicy.RUNTIME可以让你从JVM中读取Annotation注解的信息,以便在分析程序的时候使用.
@Retention(RetentionPolicy.RUNTIME)
// 用@interface来定义注解
public @interface AnnotationTest {
    // default表示默认值
    String hello() default "hehe";

    int[] array() default { 2, 4, 5, 6 };

    EnumTest lamp() default EnumTest.Id;

    Class clazz() default String.class;
}
