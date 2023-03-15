package org.koreait.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserJoinService {
	
	private MemberDao memberDao;
	
	public boolean join(Member member) {
		if (member == null) {
			throw new UserJoinFailException("잘못된 접근입니다.");
		}
		
		int cnt = memberDao.insert(member);
		
		return cnt > 0;
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
