package org.koreait.exam;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Greet greet = ctx.getBean(Greet.class);
		greet.hello("이이름");
		
		ctx.close(); 
	}

}
