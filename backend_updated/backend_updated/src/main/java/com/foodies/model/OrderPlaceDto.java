package com.foodies.model;


/*
 * Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
		Integer addrId = orderInput.getAddressId();
		String paymentMode = orderInput.getPaymentMode();
 */
public class OrderPlaceDto {
	private int userId;
	private int addressId;
	private String paymentMode;
	
	public OrderPlaceDto() {
		
	}

	public OrderPlaceDto(int userId, int addressId, String paymentMode) {
		this.userId = userId;
		this.addressId = addressId;
		this.paymentMode = paymentMode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	
}
