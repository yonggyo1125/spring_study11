package org.koreait.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
@ManualBean
public class MemberDao {
	private static Map<String, Member> members = new HashMap<>();
	
	public void add(Member member) {
		members.put(member.getUserId(), member);
	}
	
	public List<Member> getMembers() {
		return new ArrayList<Member>(members.values());
	}
}