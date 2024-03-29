package com.foodies.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
  id                    | int         | NO   | PRI | NULL    | auto_increment |
| order_date            | datetime(6) | YES  |     | NULL    |                |
| order_status          | varchar(30) | YES  |     | NULL    |                |
| status_update_date    | datetime(6) | YES  |     | NULL    |                |
| total_price           | double      | NO   |     | NULL    |                |
| user_id               | int         | NO   | MUL | NULL    |                |
| delivery_addresses_id | int         | NO   | MUL | NULL    |                |
| delevery_boy_id
*/
//
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
	
	@Column(name="total_price")
	private double totalPrice;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name="order_date")
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING)
	@Column(length=25,name="order_status")
	private OrderStatus orderStatus;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name="status_update_date")
	private LocalDateTime statusUpdateDate;
	
	@OneToOne
	@JoinColumn(name="delivery_addresses_id")
	private Address deliveryAddress;
	
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable = false)
	private User customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="delevery_boy_id")
	@JsonIgnore
	private User deleveryBoy;
	
	public Order() {
		
	}

	public Order(double totalPrice, LocalDateTime orderDate, OrderStatus orderStatus, LocalDateTime statusUpdateDate,
			Address deliveryAddress, User customer, User deleveryBoy) {
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.statusUpdateDate = statusUpdateDate;
		this.deliveryAddress = deliveryAddress;
		this.customer = customer;
		this.deleveryBoy = deleveryBoy;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDateTime getStatusUpdateDate() {
		return statusUpdateDate;
	}

	public void setStatusUpdateDate(LocalDateTime statusUpdateDate) {
		this.statusUpdateDate = statusUpdateDate;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}
	
	@JsonIgnore
	public User getDeleveryBoy() {
		return deleveryBoy;
	}

	public void setDeleveryBoy(User deleveryBoy) {
		this.deleveryBoy = deleveryBoy;
	}
	
	@Override
	public String toString() {
		return "Order [ID=" + getId() + ",totalPrice=" + totalPrice + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", statusUpdateDate=" + statusUpdateDate + "]";
	}
	
}
