package org.koreait.member;

public class MemberRegisterService {
	
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void join(Member member) {
		
		memberDao.add(member);
	}
}
