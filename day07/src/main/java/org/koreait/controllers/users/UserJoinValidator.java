package org.koreait.controllers.users;

import org.koreait.models.member.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserJoinValidator implements Validator {
	
	@Autowired
	private MemberDao memberDao;
	
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
		// 1. 아이디의 중복여부
		if (userId != null && !userId.isBlank() && memberDao.isExists(userId)) {
			errors.rejectValue("userId", "dupUserId", "이미 등록된 아이디 입니다.");
		}
		
		// 2. 비밀번호, 비밀번호 확인이 일치
		if (userPw != null && !userPw.isBlank() && userPwRe != null && !userPw.equals(userPwRe)) {
			errors.rejectValue("userPw", "passwordIncorrect", "비밀번호가 일치하지 않습니다.");
		}
		
		// 3. 휴대전화번호가 있으면 형식 체크
		/**
		 * 010-0000-0000
		 * 010.0000.0000
		 * [^0-9]
		 * [^\d]
		 * \D
		 */
		if (mobile != null && !mobile.isBlank()) {
			 mobile = mobile.replaceAll("\\D", "");
			 String pattern = "^01[016]\\d{3,4}\\d{4}$";
			 if (!mobile.matches(pattern)) { // 휴대전화번호 형식 아닌 경우 
				 errors.rejectValue("mobile", "wrongCellPhoneNum", "휴대전화번호 형식이 아닙니다.");
			 }
		}
		
	}

}
