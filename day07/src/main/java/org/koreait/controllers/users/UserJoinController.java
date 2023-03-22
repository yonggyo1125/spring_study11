package org.koreait.controllers.users;

import javax.validation.Valid;

import org.koreait.models.member.Member;
import org.koreait.models.member.UserJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/join")
public class UserJoinController {
	
	private UserJoinValidator validator;
	private UserJoinService service;
	
	public UserJoinController(UserJoinService service) {
		this.service = service;
	}
	
	@GetMapping
	public String join(Model model) {
		
		MemberJoin memberJoin = new MemberJoin();
		model.addAttribute("memberJoin", memberJoin);
		
		return "user/join"; 
 	}
	
	@PostMapping
	public String joinPs(@Valid MemberJoin memberJoin, Errors errors) {
		validator.validate(memberJoin, errors);
		if (errors.hasErrors()) {
			return "user/join";
		}
		
		try {
			Member member = new Member();
			member.setUserId(memberJoin.getUserId());
			member.setUserPw(memberJoin.getUserPw());
			member.setUserNm(memberJoin.getUserNm());
			member.setEmail(memberJoin.getEmail());
			member.setMobile(memberJoin.getMobile());
			
			service.join(member);
			
		} catch (RuntimeException e) {
			errors.reject("joinError", e.getMessage());
			return "user/join";
		}
		
		// 회원가입 성공
		return "redirect:/user/login";
	}
	
	@Autowired
	public void setValidator(UserJoinValidator validator) {
		this.validator = validator;
	}
}
