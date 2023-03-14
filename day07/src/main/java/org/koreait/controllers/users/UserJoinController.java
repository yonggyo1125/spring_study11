package org.koreait.controllers.users;

import javax.validation.Valid;

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
		
		// 회원가입 성공
		return "redirect:/user/login";
	}
	
	@Autowired
	public void setValidator(UserJoinValidator validator) {
		this.validator = validator;
	}
}
