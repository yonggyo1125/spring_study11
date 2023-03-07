package org.koreait.config;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Order(1)
@Aspect
public class CachedProxy {
	
	private Map<Long, Object> cacheData = new HashMap<>();
		
	@Around("CommonPointcut.calculatorTarget()")
	public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// 캐시에 이미 저장된 경우 기존 연산 결과를 반환 
		Object[] args = joinPoint.getArgs();
		Long num = (Long)args[0];
		
		if (cacheData.containsKey(num)) {
			System.out.printf("[%d]캐시 데이터 사용%n", num);
			return cacheData.get(num);
		}
		
		
		Object result = joinPoint.proceed(); // CalculatorProxy proceed()
		
		cacheData.put(num, result);
		System.out.printf("[%d]캐시 데이터 저장%n", num);
		
		return result;
	}
}
