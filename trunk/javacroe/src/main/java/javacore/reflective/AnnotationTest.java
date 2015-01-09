package javacore.reflective;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javacore.enumtest.EnumTest;

//注解@Retention可以用来修饰注解,是注解的注解,称为元注解
//RetentionPolicy.CLASS修饰注解,表示注解的信息被保留在class文件(字节码文件)中;当程序编译时,但不会被虚拟机读取在运行的时候
//RetentionPolicy.SOURCE修饰注解,表示注解的信息会被编译器抛弃,不会留在class文件中,注解的信息只会留在源文件中
//RetentionPolicy.RUNTIME修饰注解,表示注解的信息被保留在class文件(字节码文件)中当程序编译时,会被虚拟机保留在运行时
//RetentionPolicy.RUNTIME可以让你从JVM中读取Annotation注解的信息,以便在分析程序的时候使用.
@Retention(RetentionPolicy.RUNTIME)
// 限定注解的使用,使用@Target。
// ElementType.TYPE //接口、类、枚举、注解
// ElementType.FIELD //字段、枚举的常量
// ElementType.METHOD //方法
// ElementType.PARAMETER //方法参数
// ElementType.CONSTRUCTOR //构造函数
// ElementType.LOCAL_VARIABLE //局部变量
// ElementType.ANNOTATION_TYPE //注解
// ElementType.PACKAGE //包
@Target(ElementType.TYPE)
// 在javadoc中添加该注解
@Documented
// 用@interface来定义注解
public @interface AnnotationTest {
    // default表示默认值
    String hello() default "hehe";

    int[] array() default { 2, 4, 5, 6 };

    EnumTest lamp() default EnumTest.Id;

    Class clazz() default String.class;
}
