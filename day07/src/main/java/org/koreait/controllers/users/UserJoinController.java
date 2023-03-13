package org.koreait.controllers.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/join")
public class UserJoinController {
	
	@GetMapping
	public String join(Model model) {
		
		MemberJoin memberJoin = new MemberJoin();
		model.addAttribute("memberJoin", memberJoin);
		
		return "user/join";
	}
	
	@PostMapping
	public String joinPs(MemberJoin memberJoin) {
		
		return "user/join";
	}
}
