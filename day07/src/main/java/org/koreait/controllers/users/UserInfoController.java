package org.koreait.controllers.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserInfoController {
	
	@GetMapping("/users/{id}")
	public String info(@PathVariable(name="id", required=false) String userId) {
		System.out.println("userId = " + userId);
		
		return "user/info";
	}
}
