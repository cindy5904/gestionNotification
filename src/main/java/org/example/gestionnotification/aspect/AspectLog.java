package org.example.gestionnotification.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

public class AspectLog {
    @Pointcut("@annotation(org.example.gestionnotification.annotation)")
    public void logPointCut() {

    }

    @Before("logPointCut()")
    public void logBefore() {

        System.out.println("avant la méthode");
    }
    @After("logPointCut()")
    public void logAfter(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("après la méthode" + joinPoint.getSignature().getName() + Arrays.stream(args).toList());
    }

    @AfterReturning(value = "logPointCut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        System.out.println("retour de la méthode" + result);
    }


}
