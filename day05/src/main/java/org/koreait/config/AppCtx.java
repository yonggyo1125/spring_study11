package org.koreait.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan("org.koreait")
public class AppCtx {
	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		String url = "jdbc:mysql://localhost:3306/spring5";
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl(url);
		ds.setUsername("root");
		ds.setPassword("aA!123456");
		ds.setInitialSize(2);
		ds.setMaxActive(5);
		ds.setTestWhileIdle(true);
		ds.setTimeBetweenEvictionRunsMillis(1000 * 10); // 10초 주기마다 연결 체크
		ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3); // 최소 유휴시간 3분
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		
		return jdbcTemplate;	
	}
}
