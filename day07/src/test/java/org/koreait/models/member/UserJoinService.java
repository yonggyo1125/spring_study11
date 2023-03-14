package org.koreait.models.member;

public class UserJoinService {
	
	private MemberDao memberDao;
	
	public boolean join(Member member) {
		if (member == null) {
			throw new UserJoinFailException("잘못된 접근입니다.");
		}
		
		
		// member  null 값이 아니면 db 처리, MemberDao::insert
		int cnt = memberDao.insert(member);
		
		// 회원 가입 성공시
		return cnt > 0;
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
