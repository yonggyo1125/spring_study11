package org.koreait.controllers.users;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/login")
public class UserLoginController {
	
	@GetMapping
	public String login(Model model) {
		
		MemberLogin memberLogin = new MemberLogin();
		model.addAttribute("memberLogin", memberLogin);
		
		return "user/login";
	}
	
	@PostMapping
	public String loginPs(@Valid MemberLogin memberLogin, Errors errors) {
		
		if (errors.hasErrors()) {
			return "user/login";
		}
		
		return "redirect:/";
	}
}
