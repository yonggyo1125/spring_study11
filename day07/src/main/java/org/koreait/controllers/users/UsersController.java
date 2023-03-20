package org.koreait.controllers.users;

import java.util.List;
import javax.validation.Valid;

import org.koreait.models.member.UserJoinFailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.koreait.models.member.*;

@Controller
public class UsersController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/users")
	public String users(@Valid Users users, Errors errors) {
		
		System.out.println(users);
		return "user/users";
	}
	
	@ResponseBody
	@GetMapping("/api/users")
	public List<Member> users2() {
		
		List<Member> members = memberDao.gets();
		
		return members;
	}
	
	@GetMapping("/users/error")
	public String errorExam() {
		boolean isError = true;
		if (isError) {
			throw new UserJoinFailException("예외 테스트!");
		}
		
		return "user/mypage";
	}
	
	@GetMapping("/users/error2")
	public String errorExam2() {
		boolean isError = true;
		if (isError) {
			throw new RuntimeException("예외발생2");
		}
		
		return "user/mypage";
	}
	
	/**
	@ExceptionHandler(UserJoinFailException.class)
	public String errorHandler(UserJoinFailException e, Model model) {
		e.printStackTrace();
		model.addAttribute("errorMessage", e.getMessage());
		
		return "errors/error";
	}
	*/
}
