package org.koreait.models.member;

public class UserJoinFailException extends RuntimeException {
	public UserJoinFailException(String message) {
		super(message);
	}
}
