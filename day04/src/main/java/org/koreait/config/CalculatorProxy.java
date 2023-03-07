package org.koreait.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Order(2)
@Aspect
public class CalculatorProxy {
	
	@Around("CommonPointcut.calculatorTarget()")
	public Object calcu(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long startTime = System.nanoTime(); // 공통 기능
		
		Object result = joinPoint.proceed(); // 핵심기능 
		
		long endTime = System.nanoTime(); // 공통 기능 
		System.out.printf("걸린시간=%d%n", endTime - startTime);
		
		return result;
	}
}