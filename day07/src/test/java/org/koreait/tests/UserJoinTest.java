package org.koreait.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.koreait.controllers.users.MemberJoin;
import org.koreait.models.member.Member;
import org.koreait.models.member.MemberDao;
import org.koreait.models.member.UserJoinFailException;
import org.koreait.models.member.UserJoinService;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserJoinTest {
	
	@Mock
	public MemberDao memberDao;
	
	@Test
	@DisplayName("회원가입 성공하면 true값을 반환")
	void joinSuccessTest() {
		Member member = new Member();
		member.setUserId("user01");
		member.setUserPw("123456");
		member.setUserNm("사용자01");
		member.setEmail("user01@test.org");
		member.setMobile("01000000000");
		given(memberDao.insert(member)).willReturn(1);
		
		UserJoinService service = new UserJoinService();
		service.setMemberDao(memberDao);
		
		boolean result = service.join(member);
		 
		assertEquals(result, true);
	}
	
	
	@Test
	@DisplayName("MemberJoin 객체가 null이면 UserJoinFailException")
	void joinValidationTest1() {
		
		UserJoinService service = new UserJoinService();
		UserJoinFailException thrown = assertThrows(UserJoinFailException.class, () -> {
			service.join(null);
		});
		
		String message = thrown.getMessage();
		assertEquals(message.contains("잘못된 접근입니다."), true);
	}
	
	@Test
	@DisplayName("Member userPw 비번이 해시가 안되어 있는 경우는 예외발생")
	void joinValidationTest2() {
		Member member = new Member();
		member.setUserId("user01");
		member.setUserPw("123456"); // 해시가 안되어 있는 비번 -> 예외발생 
		
		UserJoinService service = new UserJoinService();
		assertThrows(UserJoinFailException.class, () -> {
			service.join(member);
		});
		
	}
}
