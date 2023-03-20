package org.koreait.restcontrollers;

import org.koreait.controllers.users.MemberJoin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiMemberJoinController {
	
	@PostMapping("/member/join")
	public void join(MemberJoin memberJoin) {
		System.out.println(memberJoin);
	}
}
