package org.koreait.exam;

public class Greet2 {
	public void init() {
		System.out.println("init!");
	}
	
	public void hello(String name) {
		System.out.printf("%s님, 안녕하세요%n", name);
	}
	
	public void close() {
		System.out.println("close!");
	}
}
