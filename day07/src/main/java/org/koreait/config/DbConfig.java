package org.koreait.config;

import javax.swing.text.DefaultStyledDocument;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DbConfig {
	
	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		String url = "jdbc:mysql://localhost:3306/springdb";
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl(url);
		ds.setUsername("root");
		ds.setPassword("aA!123456");
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
