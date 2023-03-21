package org.koreait.config;

import org.koreait.CustomUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.koreait.models")
public class ServiceConfig {
	
	@Bean
	public CustomUtil cUtil() {
		return new CustomUtil();
	}
}
