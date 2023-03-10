package org.koreait.controllers.members;

public class Item {
	private String title;
	private String value;
	
	public Item() {}
	
	public Item(String title, String value) {
		this.title = title;
		this.value = value;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
