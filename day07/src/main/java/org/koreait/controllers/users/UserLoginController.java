package org.koreait.controllers.users;

import javax.validation.Valid;

import org.koreait.models.member.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/login")
public class UserLoginController {
	
	@Autowired
	private UserLoginService userLoginService;
	
	@GetMapping
	public String login(Model model, @CookieValue(name="savedId", required=false) String sId) {
			
		MemberLogin memberLogin = new MemberLogin();
		if (sId != null) {
			memberLogin.setSavedId(true);
			memberLogin.setUserId(sId);
		}
		
		model.addAttribute("memberLogin", memberLogin);
		
		return "user/login";
	}
	
	@PostMapping
	public String loginPs(@Valid MemberLogin memberLogin, Errors errors) {
		try {
			userLoginService.login(memberLogin, errors);
		} catch (RuntimeException e) {
			errors.reject("loginError", e.getMessage());
		}
		
		if (errors.hasErrors()) {
			return "user/login";
		}
		
		return "redirect:/";
	}
}
