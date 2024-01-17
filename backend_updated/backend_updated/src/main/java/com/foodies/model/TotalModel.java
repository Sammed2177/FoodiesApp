package com.foodies.model;

public class TotalModel {

	int totalOrders;
	int totalRevenu;
	int totalDeliveryBoy;
	int totalCustomers;
	
	
	
	public TotalModel(int totalOrders, int totalRevenu, int totalDeliveryBoy, int totalCustomers) {
		super();
		this.totalOrders = totalOrders;
		this.totalRevenu = totalRevenu;
		this.totalDeliveryBoy = totalDeliveryBoy;
		this.totalCustomers = totalCustomers;
	}
	public TotalModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTotalOrders() {
		return totalOrders;
	}
	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}
	public int getTotalRevenu() {
		return totalRevenu;
	}
	public void setTotalRevenu(int totalRevenu) {
		this.totalRevenu = totalRevenu;
	}
	public int getTotalDeliveryBoy() {
		return totalDeliveryBoy;
	}
	public void setTotalDeliveryBoy(int totalDeliveryBoy) {
		this.totalDeliveryBoy = totalDeliveryBoy;
	}
	public int getTotalCustomers() {
		return totalCustomers;
	}
	public void setTotalCustomers(int totalCustomers) {
		this.totalCustomers = totalCustomers;
	}
	
	
}
