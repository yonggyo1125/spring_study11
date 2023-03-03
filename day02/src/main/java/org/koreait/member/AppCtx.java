package org.koreait.member;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppCtx2.class)
public class AppCtx {

	@Bean
	public MemberRegisterService memberRegisterService() {
		 return new MemberRegisterService();
		
	}
	
	@Bean
	public MemberListService memberListService() {
		return new MemberListService();
	}

	@Bean
	public DateTimeFormatter dateTimeFormatter() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		return formatter;
	}

}



