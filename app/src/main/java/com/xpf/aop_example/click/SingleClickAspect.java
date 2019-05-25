package com.xpf.aop_example.click;

import android.view.View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Created by x-sir on 2019-05-25 :)
 * Function:
 */
@Aspect
public class SingleClickAspect {

    private static final long DEFAULT_TIME_INTERVAL = 5000;

    /**
     * 定义切点，标记切点为所有被 @SingleClick 注解的方法
     * 注意：这里 com.xpf.aop_example.click.SingleClick 需要替换成
     * 你自己项目中 SingleClick 这个类的全类名
     */
    @Pointcut("execution(@com.xpf.aop_example.click.SingleClick * *(..))")
    public void methodAnnotated() {}

    /**
     * 定义一个切面方法，包裹切点方法
     */
    @Around("methodAnnotated()")
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        // 取出方法的参数
        View view = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof View) {
                view = (View) arg;
                break;
            }
        }
        if (view == null) {
            return;
        }

        // 此处有 28 非 SDK api 访问限制！！！

        // 取出方法的注解
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        if (!method.isAnnotationPresent(SingleClick.class)) {
            return;
        }
        SingleClick singleClick = method.getAnnotation(SingleClick.class);
        // 判断是否快速点击
        if (!ClickUtils.isFastDoubleClick(view, singleClick.value())) {
            // 不是快速点击，执行原方法
            joinPoint.proceed();
        }
    }
}
