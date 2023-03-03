package org.koreait.member;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegisterService() {
		 return new MemberRegisterService();
		
	}
	
	@Bean
	public MemberListService memberListService() {
		return new MemberListService();
	}
	/**
	@Bean
	public DateTimeFormatter dateTimeFormatter() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		return formatter;
	}
	*/
}



