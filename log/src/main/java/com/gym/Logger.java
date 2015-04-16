package com.gym;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.sql.Array;
import java.util.Arrays;

/**
 * Created by anni0913 on 16.04.2015.
 */
@Aspect
public class Logger {

    @AfterReturning(pointcut = "execution(* com.gym.service.AbstractGenericService.*(..))", returning = "PK")
    public void abstractGenericServiceLog(JoinPoint joinPoint, Object PK) throws Throwable {
        System.out.println(joinPoint.getSignature() + " " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("PK = " + PK.toString());
    }
}
