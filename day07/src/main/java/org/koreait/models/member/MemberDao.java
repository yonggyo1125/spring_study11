package org.koreait.models.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insert(Member member) {
		String sql = "INSERT INTO member (userId, userPw, userNm, email, mobile) VALUES (?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int cnt = jdbcTemplate.update(c -> {
				
				PreparedStatement pstmt = c.prepareStatement(sql, new String[] {"userNo"});
				pstmt.setString(1, member.getUserId());
				pstmt.setString(2, member.getUserPw());
				pstmt.setString(3, member.getUserNm());
				pstmt.setString(4, member.getEmail());
				pstmt.setString(5, member.getMobile());
				return pstmt;
			}, keyHolder);
		
		if (cnt > 0) {
			Number key = keyHolder.getKey();
			return key.intValue();
		}
		
		return 0;
	}
	
	/**
	public boolean insert(Member member) {
		String sql = "INSERT INTO member (userId, userPw, userNm) VALUES (?,?,?)";
		
		int cnt = jdbcTemplate.update(sql, member.getUserId(),
											member.getUserPw(),
											member.getUserNm());
		return cnt > 0;
		
	}
	*/
	
	public List<Member> gets() {
		String sql = "SELECT * FROM member";
		List<Member> members = jdbcTemplate.query(sql,this::mapper);
		
		return members;
	}
	
	
	public Member get(String userId) {
		try {
			String sql = "SELECT * FROM member WHERE userId = ?";
			Member member = jdbcTemplate.queryForObject(sql, this::mapper, userId);
			
			return member;
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean isExists(String userId) {
		String sql = "SELECT COUNT(*) FROM member WHERE userId = ?";
		int cnt = jdbcTemplate.queryForObject(sql, Integer.class, userId);
		
		return cnt > 0;
	}
	
	public int getTotal() {
		String sql = "SELECT COUNT(*) FROM member";
		int total = jdbcTemplate.queryForObject(sql, Integer.class);
		return total;
	}
	
	public boolean delete(String userId) {
		String sql = "DELETE FROM member WHERE userId = ?";
		int cnt = jdbcTemplate.update(sql, userId);
		
		return cnt > 0;
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
