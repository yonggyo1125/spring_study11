package org.koreait.controllers.users;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
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
		String userId = member.getUserId();
		String userPw = member.getUserPw();
		String userPwRe = member.getUserPwRe();
		String mobile = member.getMobile();
		/**
		 * 1. 아이디의 중복여부
		 * 2. 비밀번호, 비밀번호 확인이 일치
		 * 3. 휴대전화번호가 있으면 형식 체크
		 */
		
		// 2. 비밀번호, 비밀번호 확인이 일치
		if (userPw != null && userPwRe != null && !userPw.equals(userPwRe)) {
			errors.rejectValue("userPw", "passwordIncorrect", "비밀번호가 일치하지 않습니다.");
		}
		
	}

}
