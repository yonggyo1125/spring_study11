package org.koreait;

import org.koreait.config.AppCtx;
import org.koreait.member.Member;
import org.koreait.member.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MemberDao memberDao = ctx.getBean(MemberDao.class);
		Member member = new Member();
		member.setUserId("user01");
		member.setUserPw("123456");
		member.setUserNm("사용자01");
		
		boolean result = memberDao.insert(member);
		System.out.println(result);
		
		ctx.close();
	}

}
