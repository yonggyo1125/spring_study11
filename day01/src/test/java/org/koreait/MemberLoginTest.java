package org.koreait;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.member.HttpSession;
import org.koreait.member.Member;
import org.koreait.member.MemberLoginService;


class MemberLoginTest {

	@DisplayName("로그인 기능 테스트")
	@Test
	public void loginTest() {
		
		
		MemberLoginService service = new MemberLoginService();
		Member member = new Member();
		// 아이디, 비번이 없으면 RuntimeException 발생
		// 아이디가 없을때 
		RuntimeException e1 = assertThrows(RuntimeException.class, () -> {
			service.login(member);
		});
		
		assertTrue(() -> e1.getMessage().contains("아이디"));
		
		// 비밀번호가 없을때
		member.setUserId("user01");
		RuntimeException e2 = assertThrows(RuntimeException.class, ()-> {
			service.login(member);
		});
		
		assertTrue(() -> e2.getMessage().contains("비밀번호"));
		
		
		// 로그인에 성공하면 true값 반환		
		member.setUserPw("123456");
		boolean result = service.login(member);
		assertEquals(result, true);
		
		// 세션 HttpSession -> getAttribute("member") -> Object
		HttpSession session = mock(HttpSession.class);
		given(session.getAttribute("member")).willReturn(member);
		
		assertSame(session.getAttribute("member"), member);
		
		
		
	}

}
