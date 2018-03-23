package com.pakotzy.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
	@Before("execution(public void addAccount())")
	public void beforeAddAccount() {
		System.out.println("\tExecuting @Before advice on addAccount()");
	}
}
