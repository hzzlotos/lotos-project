package cn.newtouch.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = { ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Path {
    public static enum PATH_TYPE {
        FORWARD, REDIRECT
    };

    String value() default "default";

    PATH_TYPE type() default PATH_TYPE.FORWARD;
}
