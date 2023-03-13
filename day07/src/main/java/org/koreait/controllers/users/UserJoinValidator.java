package org.koreait.controllers.users;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserJoinValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return MemberJoin.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberJoin member = (MemberJoin)target;
		/** 1. 필수 항목 체크 - userId, userPw, userPwRe, userNm */
		String userId = member.getUserId();
		String userPw = member.getUserPw();
		String userPwRe = member.getUserPwRe();
		String userNm = member.getUserNm();
		if (userId == null || userId.isBlank()) {
			errors.rejectValue("userId", "required");
		}
		
		if (userPw == null || userPw.isBlank()) {
			errors.rejectValue("userPw", "required");
		}
		
		if (userPwRe == null || userPwRe.isBlank()) {
			errors.rejectValue("userPwRe", "required");
		}
		
		if (userNm == null || userNm.isBlank()) {
			errors.rejectValue("userNm", "required");
		}
	}

}
