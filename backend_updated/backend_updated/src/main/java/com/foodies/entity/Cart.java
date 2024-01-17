package com.foodies.entity;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cart")
public class Cart extends BaseEntity {

	private int quantity;
	// @ManyToOne
	// @JoinColumn(name = "user_id", nullable = false)
	// @JsonIgnore
	// private User userId;
	//
	// @ManyToOne
	// @JoinColumn(name = "menu_id" ,nullable = false)
	// @JsonIgnore
	// private Menu menuId;

	@ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu selectedMenu;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User currentUser;

	public Cart() {

	}

	// public Cart( int quantity, User userId, Menu menuId) {
	// super();
	// this.quantity = quantity;
	// this.userId = userId;
	// this.menuId = menuId;
	// }

	public Cart(int quantity, Menu selectedMenu, User currentUser) {
		super();
		this.quantity = quantity;
		this.selectedMenu = selectedMenu;
		this.currentUser = currentUser;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Menu getSelectedMenu() {
		return selectedMenu;
	}

	public void setSelectedMenu(Menu selectedMenu) {
		this.selectedMenu = selectedMenu;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	@Override
	public String toString() {
		return "Cart [quantity=" + quantity + ", selectedMenu=" + selectedMenu + ", currentUser=" + currentUser + "]";
	}

	// public User getUser() {
	// return userId;
	// }
	//
	// public void setUser(User userId) {
	// this.userId = userId;
	// }
	//
	//
	// public Menu getMenuId() {
	// return menuId;
	// }
	//
	// public void setMenuId(Menu menuId) {
	// this.menuId = menuId;
	// }

	// @Override
	// public String toString() {
	// return "Cart [ quantity=" + quantity + ", userId=" + userId + ", menuId=" +
	// menuId + "]";
	// }

}
