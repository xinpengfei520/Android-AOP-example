package com.xpf.aop_example

/**
 * Created by x-sir on 2019/4/26 :)
 * Function:创建一个自定义注解，所有被该注解标识的方法都是接入点
 */
@Retention(AnnotationRetention.RUNTIME) // 存储在编译后的 Class 文件，反射可见
@Target(AnnotationTarget.FUNCTION) // 方法（不包括构造函数）
annotation class CheckLogin

// AnnotationTarget 参数说明：

/**
 * AnnotationTarget.CLASS：类，接口或对象，注解类也包括在内。
 * AnnotationTarget.ANNOTATION_CLASS：只有注解类。
 * AnnotationTarget.TYPE_PARAMETER：Generic type parameter (unsupported yet)通用类型参数（还不支持）。
 * AnnotationTarget.PROPERTY：属性。
 * AnnotationTarget.FIELD：字段，包括属性的支持字段。
 * AnnotationTarget.LOCAL_VARIABLE：局部变量。
 * AnnotationTarget.VALUE_PARAMETER：函数或构造函数的值参数。
 * AnnotationTarget.CONSTRUCTOR：仅构造函数（主函数或者第二函数）。
 * AnnotationTarget.FUNCTION：方法（不包括构造函数）。
 * AnnotationTarget.PROPERTY_GETTER：只有属性的 getter。
 * AnnotationTarget.PROPERTY_SETTER：只有属性的 setter。
 * AnnotationTarget.TYPE：类型使用。
 * AnnotationTarget.EXPRESSION：任何表达式。
 * AnnotationTarget.FILE：文件。
 * AnnotationTarget.TYPEALIAS：@SinceKotlin("1.1") 类型别名，Kotlin1.1已可用。
 */

// AnnotationRetention 参数说明：

/**
 * AnnotationRetention.SOURCE：不存储在编译后的 Class 文件。
 * AnnotationRetention.BINARY：存储在编译后的 Class 文件，但是反射不可见
 * AnnotationRetention.RUNTIME：存储在编译后的 Class 文件，反射可见
 */