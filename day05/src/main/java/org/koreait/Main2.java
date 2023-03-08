package org.koreait;

import java.util.List;

import org.koreait.config.AppCtx;
import org.koreait.member.Member;
import org.koreait.member.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MemberDao memberDao = ctx.getBean(MemberDao.class);
		
		List<Member> members = memberDao.gets();
		for (Member member : members){
			System.out.println(member);
		}
		 
		
		Member member = memberDao.get("user03");
		System.out.println("user03 : " + member);		
		
		int total = memberDao.getTotal();
		System.out.printf("total=%d%n", total);
		
		ctx.close();
	}

}
