package org.koreait;

import org.koreait.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.koreait.aopex2.*;

public class Main1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);;
		ImplCalculator cal1 = ctx.getBean("implCalculator", ImplCalculator.class);
		//Calculator cal2 = ctx.getBean("recCalculator", Calculator.class);
	
		long result1 = cal1.factorial(10);
		System.out.printf("cal1=%d%n", result1);
		
		result1 = cal1.factorial(10);
		System.out.printf("cal1=%d%n", result1);
		
		result1 = cal1.factorial(10);
		System.out.printf("cal1=%d%n", result1);
		
		result1 = cal1.factorial(10);
		System.out.printf("cal1=%d%n", result1);
		
		result1 = cal1.factorial(10);
		System.out.printf("cal1=%d%n", result1);
		
		//long result2 = cal2.factorial(10);
		
		
		//System.out.printf("cal2=%d%n", result2);
		
		ctx.close();
	}

}
