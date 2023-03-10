package org.koreait.controllers.members;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/join")
public class MemberJoinController {

	@GetMapping
	public String join(Model model) {
		
		MemberJoin memberJoin = new MemberJoin();
		model.addAttribute("memberJoin", memberJoin);
		
		String[] hobbies = { "야구", "축구", "농구", "독서"};
		model.addAttribute("hobbies", hobbies);
		

		model.addAttribute("editors", getEditors());
		model.addAttribute("memberTypes", getMemberTypes());
		
		return "member/join"; 
	}
	
	@PostMapping
	public String joinPs(MemberJoin member, Model model) {
		
		String[] hobbies = { "야구", "축구", "농구", "독서"};
		model.addAttribute("hobbies", hobbies);
		
		model.addAttribute("editors", getEditors());
		model.addAttribute("memberTypes", getMemberTypes());
		
		return "member/join";
	}
	
	public List<Item> getEditors() {
		List<Item> items = new ArrayList<>();
		items.add(new Item("이클립스", "Eclipse"));
		items.add(new Item("VS CODE", "VSCODE"));
		items.add(new Item("인텔리J", "IntelliJ"));
		items.add(new Item("넷빈", "NetBean"));
		return items;
	}
	
	public List<Item> getMemberTypes() {
		List<Item> items = new ArrayList<>();
		items.add(new Item("개인회원", "private"));
		items.add(new Item("사업자회원", "business"));
		
		return items;
	}
}
