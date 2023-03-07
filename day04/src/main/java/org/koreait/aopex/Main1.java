package org.koreait.aopex;

public class Main1 {

	public static void main(String[] args) {
		ImplCalculator cal = new ImplCalculator();
		long result1 = cal.factorial(10);
		System.out.printf("Result1=%d%n", result1);
		
		RecCalculator cal2 = new RecCalculator();
		long result2 = cal2.factorial(10);
		System.out.printf("Result2=%d%n", result2);
	}

}
