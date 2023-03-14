package org.koreait.controllers.users;

import java.time.LocalDateTime;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MemberJoin {
	private int userNo;
	
	@NotBlank
	@Size(min=6, message="아이디는 6자리 이상 입력하세요.")
	private String userId;
	
	@NotBlank
	@Size(min=8, max=18, message="비밀번호는 8자리 이상 18이하 입력하세요.")
	private String userPw;
	
	@NotBlank
	private String userPwRe;
	
	@NotBlank
	private String userNm;
	
	@Email(message="이메일 형식이 아닙니다.")
	private String email;
	
	private String mobile;
	private LocalDateTime regDt;
	
	@AssertTrue(message="약관에 동의하세요.")
	private boolean agree;
	
	public int getUserNo() {
		return userNo;
	}
	
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPw() {
		return userPw;
	}
	
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	public String getUserPwRe() {
		return userPwRe;
	}
	
	public void setUserPwRe(String userPwRe) {
		this.userPwRe = userPwRe;
	}
	
	public String getUserNm() {
		return userNm;
	}
	
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public LocalDateTime getRegDt() {
		return regDt;
	}
	
	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}

	@Override
	public String toString() {
		return "MemberJoin [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userPwRe=" + userPwRe
				+ ", userNm=" + userNm + ", email=" + email + ", mobile=" + mobile + ", regDt=" + regDt + "]";
	}
}