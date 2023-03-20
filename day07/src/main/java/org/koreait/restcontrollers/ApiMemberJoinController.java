package org.koreait.restcontrollers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.koreait.controllers.users.MemberJoin;
import org.koreait.models.member.Member;
import org.koreait.models.member.MemberDao;
import org.koreait.models.member.UserJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiMemberJoinController {
	
	@Autowired
	private UserJoinService service;
	
	@Autowired
	private MemberDao memberDao;
	
	@PostMapping("/member/join")
	public ResponseEntity<JSONResult<Member>> join(@RequestBody @Valid MemberJoin memberJoin, Errors errors) {
		
		if (errors.hasErrors()) {
			List<ObjectError> errs = errors.getAllErrors();
			String msg = errs.stream().map(e -> {
				String message = e.getDefaultMessage();
				
				return message == null ? e.getCode() : message;  
			}).collect(Collectors.joining(","));
			
			throw new RuntimeException(msg);
		}
		
		Member member = new Member();
		member.setUserId(memberJoin.getUserId());
		member.setUserPw(memberJoin.getUserPw());
		member.setUserNm(memberJoin.getUserNm());
		member.setEmail(memberJoin.getEmail());
		member.setMobile(memberJoin.getMobile());
		
		boolean result = service.join(member);
		if (!result) { // 가입 실패 
			throw new RuntimeException("가입 실패!");
		}
		
		JSONResult<Member> jsonResult = new JSONResult<>();
		jsonResult.setSuccess(true);
		jsonResult.setData(member);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(jsonResult);
 	}
 }


