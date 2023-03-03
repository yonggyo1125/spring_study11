package org.koreait.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao {
	private Map<String, Member> members = new HashMap<>();
	
	public void add(Member member) {
		members.put(member.getUserId(), member);
	}
	
	public List<Member> getMembers() {
		System.out.println(members);
		return new ArrayList<Member>(members.values());
	}
}
