package javacore.chapter11;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
// @Retention这个才能保证runtime时被调用
public @interface AnnotationTest {

    String theString() default "test";
}