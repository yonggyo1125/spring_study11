package org.koreait.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.mindrot.jbcrypt.BCrypt;

@Service
public class UserJoinService {
	
	private MemberDao memberDao;
	
	public boolean join(Member member) {
		if (member == null) {
			throw new UserJoinFailException("잘못된 접근입니다.");
		}
		
		// 비밀번호 해시 처리
		String userPw = member.getUserPw();
		String hash = BCrypt.hashpw(userPw, BCrypt.gensalt(12));
		member.setUserPw(hash);
		
		int cnt = memberDao.insert(member);
		
		return cnt > 0;
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
