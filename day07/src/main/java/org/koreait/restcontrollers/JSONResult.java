package org.koreait.restcontrollers;

public class JSONResult<T> {
	
	private boolean success;
	private String message; // 실패시 오류 메세지
	T data; // 성공시 데이터 
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JSONResult [success=" + success + ", message=" + message + ", data=" + data + "]";
	}
}
