package org.koreait.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.koreait.config.ControllerConfig;
import org.koreait.config.MvcConfig;
import org.koreait.models.member.Member;
import org.koreait.models.member.MemberDao;
import org.koreait.models.member.UserJoinService;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;


@ExtendWith({MockitoExtension.class, SpringExtension.class})
@ContextConfiguration(classes= {MvcConfig.class, ControllerConfig.class})
@WebAppConfiguration
class UserJoinTest {
		
	@Autowired
	private UserJoinService userJoinService;
	
	@Test
	@DisplayName("회원가입 성공시 true 반환")
	public void joinSuccessTest() {
		Member member = new Member();
		boolean result = userJoinService.join(member);
		
		assertEquals(result, true);
	}
}
