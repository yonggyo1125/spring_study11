package org.koreait.member;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@ComponentScan(value="org.koreait.member",
//	excludeFilters=@Filter(type=FilterType.ASSIGNABLE_TYPE, classes={MemberDao.class}))
//@ComponentScan(value="org.koreait.member",
//		excludeFilters=@Filter(type=FilterType.ANNOTATION, classes= {ManualBean.class}))
/**
@ComponentScan(value="org.koreait.member",
		excludeFilters=@Filter(type=FilterType.ASPECTJ, pattern="org.koreait..*Dao"))
*/
@ComponentScan("org.koreait.member")
public class AppCtx {

	
	@Bean
	public DateTimeFormatter dateTimeFormatter() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		
		return formatter;
	}
}
