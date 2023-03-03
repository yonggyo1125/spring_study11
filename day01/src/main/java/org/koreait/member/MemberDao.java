package org.koreait.member;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private Map<String, Member> members = new HashMap<>();
	
	public void add(Member member) {
		members.put(member.getUserId(), member);
	}
}
