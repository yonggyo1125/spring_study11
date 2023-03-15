package org.koreait.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserJoinService {
	
	private MemberDao memberDao;
	
	public boolean join(Member member) {
		
		return true;
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
