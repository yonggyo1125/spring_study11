package org.koreait.aopex;


public class CalculatorProxy implements Calculator {
	
	private Calculator calculator;
	
	public CalculatorProxy(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public long factorial(long num) {
		
		long startTime = System.nanoTime(); // 공통기능 
		
		long result = calculator.factorial(num); // 핵심기능 
		
		long endTime = System.nanoTime(); // 공통기능		
		System.out.printf("걸린시간=%d%n", endTime - startTime); // 공통기능
		
		return result;
	}
	
}
