package org.koreait.controllers.users;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Users {
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate sdate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate edate;
	
	public LocalDate getSdate() {
		return sdate;
	}
	
	public void setSdate(LocalDate sdate) {
		this.sdate = sdate;
	}
	
	public LocalDate getEdate() {
		return edate;
	}
	
	public void setEdate(LocalDate edate) {
		this.edate = edate;
	}

	@Override
	public String toString() {
		return "Users [sdate=" + sdate + ", edate=" + edate + "]";
	}
}
