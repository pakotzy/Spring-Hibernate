package com.pakotzy.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Pointcuts {
	@Pointcut("execution(* com.pakotzy.springaop.dao.*.*(..))")
	public void everything(){}

	@Pointcut("execution(* com.pakotzy.springaop.dao.*.get*(..))")
	public void reads(){}

	@Pointcut("execution(* com.pakotzy.springaop.dao.AccountDAO.calculate*(..))")
	public void calculations() {}

	@Pointcut("everything() && !(reads() || calculations())")
	public void everythingExceptReadsOrCalculations(){}
}