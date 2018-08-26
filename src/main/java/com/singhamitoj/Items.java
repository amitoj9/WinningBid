package com.singhamitoj;

public class Items {
	
	private String itemName;
	private int id;
	private String description;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Items(String itemName, int id, String description) {
		this.itemName = itemName;
		this.id = id;
		this.description = description;
	}
	
}
