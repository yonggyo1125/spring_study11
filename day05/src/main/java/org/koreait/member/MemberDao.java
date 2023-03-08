package org.koreait.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	
	public List<Member> gets() {
		String sql = "SELECT * FROM member";
		List<Member> members = jdbcTemplate.query(sql,this::mapper);
		
		return members;
	}
	

	
	public Member mapper(ResultSet rs, int num) throws SQLException {
		Member member = new Member();
		member.setUserNo(rs.getInt("userNo"));
		member.setUserId(rs.getString("userId"));
		member.setUserPw(rs.getString("userPw"));
		member.setUserNm(rs.getString("userNm"));
		member.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());
		
		return member;
	}
}

