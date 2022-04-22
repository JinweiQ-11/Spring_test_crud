package com.itheima.aop.anno;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/4/20 23:46
 * @description：
 * @modified By：
 * @version: $
 */
public class MyaspectA {
    public void before(){
        System.out.println("前置增强");
    }

    public void after(){
        System.out.println("后置增强");
    }

    public void around(ProceedingJoinPoint pjp) throws Throwable {
       System.out.println("环绕前");
       Object ob = pjp.proceed();
       System.out.println("环绕后");

    }

}
