package org.koreait.models.member;

public class UserLoginFailException extends RuntimeException {
	public UserLoginFailException(String message) {
		super(message);
	}
}
