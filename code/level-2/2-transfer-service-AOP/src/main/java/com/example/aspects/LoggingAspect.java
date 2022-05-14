package com.example.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger("transfer-service");
//
//    @Before("execution(void transfer(double,String,String))")
//    public void doLogBefore(JoinPoint joinPoint){
//        logger.info("BEFORE - "+joinPoint.toShortString());
//    }
//
//    @AfterReturning(pointcut = "execution(void transfer(double,String,String))",returning = "r")
//    public void doLogAfterReturning(JoinPoint joinPoint,Object r){
////        System.out.println(r);
//        logger.info("AFTER-RETURNING - "+joinPoint.toShortString());
//    }
//
//
//    @AfterThrowing(pointcut = "execution(void transfer(double,String,String))",throwing = "e")
//    public void doLogAfterThrowing(JoinPoint joinPoint,Throwable e){
//        System.out.println(e);
//        logger.info("AFTER-THROWING - "+joinPoint.toShortString());
//    }
//
//
//    @After("execution(void transfer(double,String,String))")
//    public void doLogAfter(JoinPoint joinPoint){
//        logger.info("AFTER - "+joinPoint.toShortString());
//    }


    @Around("execution(void transfer(double,String,String))")
    public Object doLogAround(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            logger.info("BEFORE - " + proceedingJoinPoint.toShortString());
            proceedingJoinPoint.proceed();
            logger.info("AFTER-RETURNING - " + proceedingJoinPoint.toShortString());
        } catch (Throwable e) {
            logger.info("AFTER-THROWING - " + proceedingJoinPoint.toShortString());
        } finally {
            logger.info("AFTER - " + proceedingJoinPoint.toShortString());
        }
        return null;
    }


}
