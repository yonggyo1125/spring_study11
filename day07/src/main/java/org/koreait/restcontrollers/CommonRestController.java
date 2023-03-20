package org.koreait.restcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonRestController {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<JSONResult<Object>> errorHandler(Exception e) {
		// 상태 코드, 헤더, 바디
		JSONResult<Object> jsonResult = new JSONResult<>();
		jsonResult.setSuccess(false);
		jsonResult.setMessage(e.getMessage());
		
		
		return ResponseEntity
				.internalServerError()	
				.body(jsonResult);
	}
}
