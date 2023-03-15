package org.koreait.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.koreait.config.ControllerConfig;
import org.koreait.config.MvcConfig;
import org.koreait.models.member.UserLoginService;
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
	
	@BeforeAll
	public static void init() {
		insertMember();
	}
	
	private static void insertMember() {
		
	}
	
	@Test
	@DisplayName("로그인 성공시 예외발생 없음")
	public void loginSuccessTest() {
		assertDoesNotThrow(() -> {
			
		});
	}
}
