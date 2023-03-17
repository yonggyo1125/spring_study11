package org.koreait.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DbConfig2 {
	
	@Configuration
	@Profile("dev")
	public static class DbDevConfig {
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
	
	@Configuration
	@Profile("real")
	public static class DbRealConfig {
		@Bean(destroyMethod="close")
		public DataSource dataSource() {
			String url = "jdbc:mysql://localhost:3306/springdb";
			DataSource ds = new DataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUrl(url);
			ds.setUsername("root");
			ds.setPassword("bB!123456");
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
}


