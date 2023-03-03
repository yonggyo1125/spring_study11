package org.koreait.member;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx2 {
	
	@Bean
	@Qualifier("mdao")
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberDao memberDao2() {
		return new MemberDao();
	}
}
