package com.pakotzy.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class Logging {
	@Before("com.pakotzy.springaop.aspect.Pointcuts.everything()")
	public void logActions(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("=====> Logging @Before " + signature);
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			System.out.println(arg);
		}
	}
}
