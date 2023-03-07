package org.koreait.exam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppCtx {
	@Bean
	@Scope("prototype")
	public Greet greet() {
		return new Greet();
	}
	
	@Bean(initMethod="init", destroyMethod="close")
	public Greet2 greet2() {
		return new Greet2();
	}
}
