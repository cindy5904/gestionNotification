package org.example.gestionnotification.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class AspectPerformance {
    @Pointcut("@annotation(org.example.gestionnotification.annotation.AnnotationPerformance)")
    public void performancePointCut() {

    }
    @Around("performancePointCut()")
    public Object performanceAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Temps d'execution : "+(endTime - startTime) + " ms");
        return result;
    }
}
