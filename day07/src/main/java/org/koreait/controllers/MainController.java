package org.koreait.controllers;

import java.util.List;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String index(Model model) {
		
		List<String> addCss = Arrays.asList("member/test1", "member/test2");
		List<String> addScript = Arrays.asList("order/testjs1", "order/testjs2");
		
		model.addAttribute("addCss", addCss);
		model.addAttribute("addScript", addScript);
		
		return "main/index";
	}
}
