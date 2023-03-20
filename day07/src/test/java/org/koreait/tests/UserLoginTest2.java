package org.koreait.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.koreait.config.ControllerConfig;
import org.koreait.config.MvcConfig;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@ContextConfiguration(classes= {MvcConfig.class, ControllerConfig.class})
@WebAppConfiguration
class UserLoginTest2 {
	@Autowired
	private WebApplicationContext webbApplicationContext;
	private MockMvc mockMvc;
	
	@BeforeEach
	public void initMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webbApplicationContext).build();
	}
	
	
	@Test
	@DisplayName("응답 성공했는지")
	public void test1() throws Exception {
		mockMvc.perform(get("/user/login")).andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("테스트2")
	public void test2() throws Exception {
		String data = mockMvc.perform(post("/user/login").param("user01", "test"))
			.andExpect(status().isOk())
			.andReturn().getResponse().getContentAsString();
		
		System.out.println(data);
	}
	
}
