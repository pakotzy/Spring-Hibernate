package com.pakotzy.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class Metrics {
	@Before("com.pakotzy.springaop.aspect.Pointcuts.everything()")
	public void writeMetrics(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("=====> Spying @Before " + signature);
	}
}
