package org.koreait;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
	@Bean
	public Greet greet() {
		return new Greet();
	}
}
