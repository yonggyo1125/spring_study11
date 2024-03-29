package org.koreait.controllers.users;

import javax.validation.constraints.NotBlank;

public class MemberLogin {
	@NotBlank
	private String userId;
	
	@NotBlank
	private String userPw;
	
	private boolean savedId;
	
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
	
	public boolean isSavedId() {
		return savedId;
	}
	
	public void setSavedId(boolean savedId) {
		this.savedId = savedId;
	}

	@Override
	public String toString() {
		return "MemberLogin [userId=" + userId + ", userPw=" + userPw + ", savedId=" + savedId + "]";
	}
}
