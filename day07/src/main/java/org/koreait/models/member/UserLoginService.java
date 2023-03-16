package org.koreait.models.member;

import javax.servlet.http.HttpSession;

import org.koreait.controllers.users.MemberLogin;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class UserLoginService {
	
	private MemberDao memberDao;
	
	@Autowired
	private HttpSession session;
	
	public UserLoginService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void login(MemberLogin member) {
		login(member, null);
	}
	
	public void login(MemberLogin member, Errors errors) {
		if (errors != null && errors.hasErrors()) { // 커맨드 객체 @Bean validation 검증 실패시
			return;
		}
		
		if (member == null) {
			throw new UserLoginFailException("잘못된 접근입니다.");
		}
		
		String userId = member.getUserId();
		if (userId == null || userId.isBlank()){
			throw new UserLoginFailException("아이디를 입력하세요.");
		}
		
		String userPw = member.getUserPw();
		if (userPw == null || userPw.isBlank()){
			throw new UserLoginFailException("비밀번호를 입력하세요.");
		}
		
		/** 등록된 아이디인지 체크 */
		Member mem = memberDao.get(userId);
		if (mem == null) { // 등록되지 않은 회원
			throw new UserNotFoundException("등록되지 않은 회원입니다.");
		}
		
		/** 비밀번호 체크 */
		boolean matched = BCrypt.checkpw(userPw, mem.getUserPw());
		if (!matched) {
			throw new UserLoginFailException("비밀번호가 일치하지 않습니다.");
		}
		
		/** 로그인 처리 */
		session.setAttribute("member", mem);
	}
 }
