package org.koreait.exam;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Greet g1 = ctx.getBean(Greet.class);
		Greet g2 = ctx.getBean(Greet.class);
		System.out.println(g1 == g2);
		
		ctx.close();
	}

}
