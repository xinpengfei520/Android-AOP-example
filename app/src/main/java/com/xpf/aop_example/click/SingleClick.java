package com.xpf.aop_example.click;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by x-sir on 2019-05-25 :)
 * Function:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SingleClick {
    /**
     * 点击间隔时间
     */
    long value() default 1000;
}
