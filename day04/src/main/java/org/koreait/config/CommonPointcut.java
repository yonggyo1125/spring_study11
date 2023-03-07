package org.koreait.config;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcut {
	
	@Pointcut("execution(* org.koreait.aopex2..*(..))")
	public void calculatorTarget() {}
}
