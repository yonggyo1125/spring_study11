package org.koreait.models.member;

import org.koreait.controllers.users.MemberLogin;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
	
	private MemberDao memberDao;
	
	public UserLoginService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void login(MemberLogin member) {
		
	}
}
