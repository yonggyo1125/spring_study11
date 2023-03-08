package org.koreait.member;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public boolean insert(Member member) {
		String sql = "INSERT INTO member (userId, userPw, userNm) VALUES (?,?,?)";
		
		int cnt = jdbcTemplate.update(sql, member.getUserId(),
											member.getUserPw(),
											member.getUserNm());
		return cnt > 0;
		
	}
}

