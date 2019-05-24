package com.xpf.aop_example

import android.view.View
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature

/**
 * Created by x-sir on 2019-05-24 :)
 * Function:
 */
@Aspect
class SingleClickAspect {

    /**
     * 定义切点，标记切点为所有被 @SingleClick 注解的方法
     * 注意：这里 me.baron.test.annotation.SingleClick 需要替换成
     * 你自己项目中 SingleClick 这个类的全路径哦
     */
    @Pointcut("execution(@com.xpf.aop_example.SingleClick * *(..))")
    fun methodAnnotated() {

    }

    /**
     * 定义一个切面方法，包裹切点方法
     */
    @Around("methodAnnotated()")
    @Throws(Throwable::class)
    fun aroundJoinPoint(joinPoint: ProceedingJoinPoint) {
        // 取出方法的参数
        var view: View? = null
        for (arg in joinPoint.args) {
            if (arg is View) {
                view = arg
                break
            }
        }
        if (view == null) {
            return
        }
        // 取出方法的注解
        val methodSignature = joinPoint.signature as MethodSignature
        val method = methodSignature.method
        if (!method.isAnnotationPresent(SingleClick::class.java)) {
            return
        }
        val singleClick = method.getAnnotation(SingleClick::class.java)
        // 判断是否快速点击
        if (!ClickUtils.isFastDoubleClick(view, singleClick.value)) {
            // 不是快速点击，执行原方法
            joinPoint.proceed()
        }
    }

    companion object {

        private val DEFAULT_TIME_INTERVAL: Long = 5000
    }
}
