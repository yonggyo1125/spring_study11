package org.koreait.member;

import java.util.List;

public class MemberListService {
	
	private MemberDao memberDao;
	
	public MemberListService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public List<Member> gets() {
		List<Member> members = memberDao.getMembers();
		
		return members;
	}
}
