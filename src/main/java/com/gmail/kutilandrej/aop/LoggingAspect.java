package com.gmail.kutilandrej.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  @Around("execution(* com.gmail.kutilandrej.dao.*.*(..))")
  public Object aroundAllRepositoryMethod(ProceedingJoinPoint point) throws Throwable {
    System.out.println("Started: " + point.getSignature().getName());
    Object proceed = point.proceed();
    System.out.println("Finished: " + point.getSignature().getName());

    return proceed;
  }
}
