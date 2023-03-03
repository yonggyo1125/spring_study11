package org.koreait.member;

public class MemberRegisterService {
	
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void process(Member member) {
		
		memberDao.add(member);
	}
}
