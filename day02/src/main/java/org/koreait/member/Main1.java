package org.koreait.member;

import java.time.LocalDateTime;
import java.util.List;

public class Main1 {

	public static void main(String[] args) {
		
		MemberServiceManager manager = new MemberServiceManager();
			
		MemberRegisterService service = manager.getMemberRegisterService();
		Member member = new Member();
		member.setUserId("user01");
		member.setUserPw("123456");
		member.setUserNm("사용자01");
		member.setRegDt(LocalDateTime.now());
		
		service.process(member);
		
		MemberListService listService = manager.getMemberListService();
		List<Member> members = listService.gets();
		for (Member m : members) {
			System.out.println(m);
		}
	}

}
