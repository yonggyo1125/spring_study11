package org.koreait.controllers.members;

public class MemberJoin {
	private String userId;
	private String userPw;
	private String userPwRe;
	private String userNm;
	private boolean agree;
	
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
	
	public boolean isAgree() {
		return agree;
	}
	
	public void setAgree(boolean agree) {
		this.agree = agree;
	}

	@Override
	public String toString() {
		return "MemberJoin [userId=" + userId + ", userPw=" + userPw + ", userPwRe=" + userPwRe + ", userNm=" + userNm
				+ ", agree=" + agree + "]";
	}
}
