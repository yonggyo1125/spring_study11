package org.koreait.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DbConfig {
	
	@Value("${db.url}")
	private String dbUrl;
	
	@Value("${db.className}")
	private String dbClassName;
	
	@Value("${db.userName}")
	private String dbUserName;
	
	@Value("${db.password}")
	private String dbPassword;
	
	@Bean(destroyMethod="close")
	public DataSource dataSource() {

		DataSource ds = new DataSource();
		ds.setDriverClassName(dbClassName);
		ds.setUrl(dbUrl);
		ds.setUsername(dbUserName);
		ds.setPassword(dbPassword);
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setTimeBetweenEvictionRunsMillis(1000 * 10);
		ds.setMinEvictableIdleTimeMillis(1000 * 30);
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}
