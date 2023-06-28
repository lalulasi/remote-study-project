package com.jun.springframework.aop;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-28 15:25
 **/
public interface PointcutAdvisor extends Advisor{
    /**
     * Get the Pointcut that drives this advisor.
     */
    Pointcut getPointcut();
}
