package org.koreait.member;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main3 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class, AppCtx2.class);
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		
		ctx.close();
	}
}
