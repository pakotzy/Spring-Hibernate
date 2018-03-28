package com.pakotzy.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class Backups {
	@Before("com.pakotzy.springaop.aspect.Pointcuts.everythingExceptReadsOrCalculations()")
	public void backUpChanges(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("=====> Backing up @Before " + signature);
	}
}
