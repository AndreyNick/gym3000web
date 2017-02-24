package com.gym.log;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class CoreLogger {

    public static Logger log = Logger.getLogger(CoreLogger.class);

    @AfterReturning(pointcut = "execution(* com.gym.service.AbstractGenericService.*(..))")
    public void abstractGenericServiceLog(JoinPoint joinPoint) throws Throwable {
        log.info(joinPoint.getSignature() + " " + Arrays.toString(joinPoint.getArgs()));
    }
}
