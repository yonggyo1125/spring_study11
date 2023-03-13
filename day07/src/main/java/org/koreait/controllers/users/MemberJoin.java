package org.koreait.controllers.users;

import java.time.LocalDateTime;

public class MemberJoin {
	private int userNo;
	private String userId;
	private String userPw;
	private String userPwRe;
	private String userNm;
	private String email;
	private String mobile;
	private LocalDateTime regDt;
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