package org.koreait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String hello(@RequestParam(name="name", required=false) String nm, Model model) {
		
		model.addAttribute("name", nm);
		
		return "hello";
	}
}
