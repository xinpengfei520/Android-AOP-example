package com.xpf.aop_example

/**
 * Created by x-sir on 2019-05-24 :)
 * Function:自定义单击注解(可传递点击时长，默认为1秒)
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class SingleClick(val value: Long = 1000)
