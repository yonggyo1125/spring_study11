package org.koreait.member;

public class MemberServiceManager {
	
	public MemberDao memberDao() {
		return new CachedMemberDao();
	}
	
	public MemberRegisterService getMemberRegisterService() {
		
		MemberRegisterService service = new MemberRegisterService(memberDao());
		
		return service;
	}
	
	public MemberListService getMemberListService() {
		MemberListService service = new MemberListService(memberDao());
		
		return service;
	}
}
