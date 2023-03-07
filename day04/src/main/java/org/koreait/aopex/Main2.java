package org.koreait.aopex;

public class Main2 {

	public static void main(String[] args) {
		Calculator cal1 = new CalculatorProxy(new ImplCalculator());
		Calculator cal2 = new CalculatorProxy(new RecCalculator());
		
		long result1 = cal1.factorial(10);
		long result2 = cal2.factorial(10);
		
		System.out.printf("cal1=%d%n", result1);
		System.out.printf("cal2=%d%n", result2);
	}

}
