package org.koreait.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.koreait.aopex2.*;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AppCtx {
	
	@Bean
	public CalculatorProxy caculatorProxy() {
		return new CalculatorProxy();
	}
	
	@Bean
	public CachedProxy cachedProxy() {
		return new CachedProxy();
	}
	
	@Bean
	public Calculator implCalculator() {
		return new ImplCalculator();
	}
	
	@Bean
	public Calculator recCalculator() {
		return new RecCalculator();
	}
}