package org.koreait.member;

import java.time.LocalDateTime;

public class Member {
	private int userNo;
	private String userId;
	private String userPw;
	private String userNm;
	private LocalDateTime regDt;
	private LocalDateTime modDt;
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
	public LocalDateTime getModDt() {
		return modDt;
	}
	public void setModDt(LocalDateTime modDt) {
		this.modDt = modDt;
	}
	
	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userNm=" + userNm
				+ ", regDt=" + regDt + ", modDt=" + modDt + "]";
	}
}
