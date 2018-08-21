package com.zzr.aoptest.aop;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 作者：zzr
 * 创建日期：2018/8/21
 * 描述：切面
 */
@Aspect
public class StatisticsAspact {

    /**
     * 切点
     */
    @Pointcut("execution(@com.zzr.aoptest.aop.StatisticsTrace * *(..))")
    public void annoStatistics() {

    }

    /**
     * 切面
     *
     * @return
     */
    @Around("annoStatistics()")
    public Object dealPoint(ProceedingJoinPoint point) throws Throwable {
        //方法执行前
        MethodSignature signature = (MethodSignature) point.getSignature();
        StatisticsTrace statisticsTrace = signature.getMethod().getAnnotation(StatisticsTrace.class);
        String contentValue = statisticsTrace.value();

        long begin = System.currentTimeMillis();
        //方法执行中
        Object o = null;
        try {
            o = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //方法执行完成
        Log.e("aop--->", "消耗时间：  " + (System.currentTimeMillis() - begin) + "ms");

        return o;
    }
}
