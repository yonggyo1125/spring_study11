package org.koreait.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.koreait.config.ControllerConfig;
import org.koreait.config.MvcConfig;
import org.koreait.controllers.users.MemberLogin;
import org.koreait.models.member.Member;
import org.koreait.models.member.MemberDao;
import org.koreait.models.member.UserLoginFailException;
import org.koreait.models.member.UserLoginService;
import org.koreait.models.member.UserNotFoundException;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@ContextConfiguration(classes= {MvcConfig.class, ControllerConfig.class})
@WebAppConfiguration
class UserLoginTest {
	
	@Autowired
	private UserLoginService service;
	
	@Autowired
	private MemberDao memberDao;
	
	private Member member;
	private String userPw = "test123456";
	
	@BeforeEach
	public void insertMember() {
		String hash = BCrypt.hashpw(userPw, BCrypt.gensalt(12));
		member = new Member();
		member.setUserId("userTest");
		member.setUserPw(hash);
		member.setUserNm("테스트계정");
		member.setEmail("userTest@test.org");
		member.setMobile("01000000000");
		
		memberDao.delete("userTest");
		int userNo = memberDao.insert(member);
		member.setUserNo(userNo);
	}
	
	@Test
	@DisplayName("로그인 성공시 예외발생 없음")
	public void loginSuccessTest() {
		assertDoesNotThrow(() -> {
			MemberLogin memberLogin = new MemberLogin();
			memberLogin.setUserId(member.getUserId());
			memberLogin.setUserPw(userPw);
			service.login(memberLogin);
		});
	}
	
	@Test
	@DisplayName("아이디,비번 필수항목 체크 - 0. null이면 - 잘못된 접근입니다. ")
	public void requiredFieldsTest1() {
		UserLoginFailException thrown = assertThrows(UserLoginFailException.class, ()-> {
			service.login(null);
		});
		
		assertEquals(thrown.getMessage().contains("잘못된 접근"), true);
	}
	
	@Test
	@DisplayName("아이디,비번 필수항목 체크 - 1. 아이디가 없는 경우 - 아이디를 입력하세요.")
	public void requiredFieldsTest2() {
		UserLoginFailException thrown = assertThrows(UserLoginFailException.class, () -> {
			service.login(new MemberLogin());
		});
		
		assertEquals(thrown.getMessage().contains("아이디를 입력"), true);
	}
	
	@Test
	@DisplayName("아이디,비번 필수항목 체크 - 2. 비밀번호가 없는 경우 - 비밀번호를 입력하세요. ")
	public void requiredFieldsTest3() {
		UserLoginFailException thrown = assertThrows(UserLoginFailException.class, () -> {
			MemberLogin memberLogin = new MemberLogin();
			memberLogin.setUserId(member.getUserId());
			service.login(memberLogin);
		});
		
		assertEquals(thrown.getMessage().contains("비밀번호를 입력"), true);
	}
	
	@Test
	@DisplayName("아이디가 없으면 UserNotFoundException을 발생시키는지 테스트")
	public void UserIdExistsTest() {
		String userId="test" + System.currentTimeMillis();
		MemberLogin memberLogin = new MemberLogin();
		memberLogin.setUserId(userId);
		memberLogin.setUserPw(userPw);
		
		assertThrows(UserNotFoundException.class, () -> {
			service.login(memberLogin);
		});
	}
	
	@Test
	@DisplayName("등록된 회원이지만 비밀번호가 다를 경우 UserLoginFailException 발생 - 비밀번호가 일치하지 않습니다.")
	public void userPasswordCheckTest() {
		UserLoginFailException thrown = assertThrows(UserLoginFailException.class, ()-> {
			MemberLogin memberLogin = new MemberLogin();
			memberLogin.setUserId(member.getUserId());
			memberLogin.setUserPw("1111");
			service.login(memberLogin);
		});
		
		assertEquals(thrown.getMessage().contains("비밀번호가 일치하지"), true);
	}	
}
