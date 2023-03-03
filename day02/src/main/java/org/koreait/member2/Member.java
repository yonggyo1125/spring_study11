package org.koreait.member2;

import java.time.LocalDateTime;

public class Member {
	private String userId;
	private String userPw;
	private String userNm;
	private LocalDateTime regDt;
	private String regDtStr;
	
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
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public LocalDateTime getRegDt() {
		return regDt;
	}
	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}
	
	
	
	public String getRegDtStr() {
		return regDtStr;
	}
	public void setRegDtStr(String regDtStr) {
		this.regDtStr = regDtStr;
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPw=" + userPw + ", userNm=" + userNm + ", regDt=" + regDtStr + "]";
	}
	
	

}
