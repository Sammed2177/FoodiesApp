package com.foodies.model;

public class TotalMenuInfo {

	private int totalCategory;
	private int totalMenuItems;
	
	public TotalMenuInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TotalMenuInfo(int totalCategory, int totalMenuItems) {
		super();
		this.totalCategory = totalCategory;
		this.totalMenuItems = totalMenuItems;
	}
	
	public int getTotalCategory() {
		return totalCategory;
	}
	
	public void setTotalCategory(int totalCategory) {
		this.totalCategory = totalCategory;
	}
	public int getTotalMenuItems() {
		return totalMenuItems;
	}
	public void setTotalMenuItems(int totalMenuItems) {
		this.totalMenuItems = totalMenuItems;
	}
}
