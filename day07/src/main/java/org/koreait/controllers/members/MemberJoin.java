package org.koreait.controllers.members;

import java.util.List;

public class MemberJoin {
	private String memberType;
	private String userId;
	private String userPw;
	private String userPwRe;
	private String userNm;
	private List<String> hobby;
	private List<String> editor;
	
 	private boolean agree;
	
	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
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
	
	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	public List<String> getEditor() {
		return editor;
	}

	public void setEditor(List<String> editor) {
		this.editor = editor;
	}

	public boolean isAgree() {
		return agree;
	}
	
	public void setAgree(boolean agree) {
		this.agree = agree;
	}

	@Override
	public String toString() {
		return "MemberJoin [memberType=" + memberType + ", userId=" + userId + ", userPw=" + userPw + ", userPwRe="
				+ userPwRe + ", userNm=" + userNm + ", hobby=" + hobby + ", editor=" + editor + ", agree=" + agree
				+ "]";
	}
}
