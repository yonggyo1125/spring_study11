package org.koreait;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Greet g1 = ctx.getBean("greet", Greet.class);
		g1.hello("이름1");
		
		Greet g2 = ctx.getBean("greet", Greet.class);
		System.out.println(g1 == g2);
		
		ctx.close();
	}
}
