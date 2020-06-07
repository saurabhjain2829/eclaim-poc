//package com.nagarro.eclaim.aspect;
//
//import java.lang.invoke.MethodHandles;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class EclaimServiceAspect {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
//
//
//    @Before(value = "execution(* com.nagarro.eclaim.service.impl.EclaimServiceImpl.*(..))")
//    public void beforeAdvice(JoinPoint joinPoint) {
//        LOGGER.debug("<{}>", joinPoint.getSignature());
//
//    }
//
//
//    @After(value = "execution(* com.nagarro.eclaim.service.impl.EclaimServiceImpl.*(..))")
//    public void afterAdvice(JoinPoint joinPoint) {
//        LOGGER.debug("</{}", joinPoint.getSignature());
//    }
//}
