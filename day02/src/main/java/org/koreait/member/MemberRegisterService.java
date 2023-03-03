package org.koreait.member;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	
	
	private MemberDao memberDao;
	
	public MemberRegisterService() {}
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void process(Member member) {
		
		memberDao.add(member);
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
