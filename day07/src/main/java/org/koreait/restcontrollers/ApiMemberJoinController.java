package org.koreait.restcontrollers;

import javax.validation.Valid;

import org.koreait.controllers.users.MemberJoin;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiMemberJoinController {
	
	@PostMapping("/member/join")
	public void join(@RequestBody @Valid MemberJoin memberJoin, Errors errors) {
		boolean result = false;
		if (!result) {
			throw new RuntimeException("예외 발생!!!!");
		}
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<JSONResult<Object>> errorHandler(Exception e) {
		// 상태 코드, 헤더, 바디
		JSONResult<Object> jsonResult = new JSONResult<>();
		jsonResult.setSuccess(false);
		jsonResult.setMessage(e.getMessage());
		
		
		return ResponseEntity.status(500).body(jsonResult);
	}
 }


