package org.koreait.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.koreait.models.member.*;

@RestController
@RequestMapping("/api")
public class ApiMembersController {
	
	private MemberDao memberDao;
	
	public ApiMembersController(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@GetMapping("/members")
	public List<Member> members() {
		List<Member> members = memberDao.gets();
		
		return members;
	}
	
	
	@GetMapping("/member/{id}")
	public Member member(@PathVariable("id") String userId) {
		Member member = memberDao.get(userId);
		
		return member;
	}
	
}
