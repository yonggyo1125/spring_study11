package org.koreait.member;

public class MemberLoginService {
	public boolean login(Member member) {
		String userId = member.getUserId();
		if (userId == null || userId.isBlank()) {
			throw new RuntimeException("아이디를 입력하세요.");
		}
		
		String userPw = member.getUserPw();
		if (userPw == null || userPw.isBlank()) {
			throw new RuntimeException("비밀번호를 입력하세요.");
		}
 		
		return true;
	}
}
