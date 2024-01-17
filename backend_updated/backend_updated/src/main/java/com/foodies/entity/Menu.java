package com.foodies.entity;

//import java.util.ArrayList;
//import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu")

public class Menu {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name = "menu_name")
	private String menuName;
	private double price;
	@Column(name = "image_name")
	private String imageName;
	private String description;

	@ManyToOne
	@JoinColumn(name = "menu_type_id")
	private MenuType menutype;

	public Menu(int id, String menuName, double price, String imageName, String description, MenuType menutype) {
		super();
		this.id = id;
		this.menuName = menuName;
		this.price = price;
		this.imageName = imageName;
		this.description = description;
		this.menutype = menutype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MenuType getMenutype() {
		return menutype;
	}

	public void setMenutype(MenuType menutype) {
		this.menutype = menutype;
	}

	// @Override
	// public String toString() {
	// return "Menu [id=" + id + ", menuName=" + menuName + ", price=" + price + ",
	// imageName=" + imageName
	// + ", description=" + description + ", menutype=" + menutype + "]";
	// }

	// @ManyToOne
	// @JoinColumn(name = "menu_type_id", nullable = false)
	// private MenuType menutype;
	// //@JsonIgnoreProperties("menuTypeId")
	// @JsonIgnore
	//// private MenuType menuTypeId ;
	//
	// @JsonIgnoreProperties("menu")
	//
	//// @OneToMany(mappedBy = "menu_id" ,cascade = {CascadeType.ALL},orphanRemoval
	// = true)
	//// @JsonIgnoreProperties("Cart")
	//// private Cart cart;
	//
	//
	//
	public Menu() {

	}
	// public Menu(String menuName, double price, String imageName, String
	// description, MenuType menutype) {
	// super();
	// this.menuName = menuName;
	// this.price = price;
	// this.imageName = imageName;
	// this.description = description;
	// this.menutype = menutype;
	// }
	// public String getMenuName() {
	// return menuName;
	// }
	// public void setMenuName(String menuName) {
	// this.menuName = menuName;
	// }
	// public double getPrice() {
	// return price;
	// }
	// public void setPrice(double price) {
	// this.price = price;
	// }
	// public String getImageName() {
	// return imageName;
	// }
	// public void setImageName(String imageName) {
	// this.imageName = imageName;
	// }
	// public String getDescription() {
	// return description;
	// }
	// public void setDescription(String description) {
	// this.description = description;
	// }
	// public MenuType getMenutype() {
	// return menutype;
	// }
	// public void setMenutype(MenuType menutype) {
	// this.menutype = menutype;
	// }
	// @Override
	// public String toString() {
	// return "Menu [menuName=" + menuName + ", price=" + price + ", imageName=" +
	// imageName + ", description="
	// + description + ", menutype=" + menutype + "]";
	// }
	//
	//
	// /**
	// * @param menu_name
	// * @param price
	// * @param imageName
	// * @param description
	// * @param menuTypeId
	// */
	// public Menu(String menuName, double price, String imageName, String
	// description , MenuType menuTypeId) {
	// super();
	// this.menuName = menuName;
	// this.price = price;
	// this.imageName = imageName;
	// this.description = description;
	// this.menuTypeId = menuTypeId;
	// }
	// public Menu(String menuName, double price, String imageName, String
	// description ) {
	// super();
	// this.menuName = menuName;
	// this.price = price;
	// this.imageName = imageName;
	// this.description = description;
	//
	// }
	//
	// public Menu(String menuName, double price) {
	// super();
	// this.menuName = menuName;
	// this.price = price;
	// //this.menuTypeId = new MenuType();
	// }
	//
	// public Menu(String menuName, double price , MenuType menuTypeId) {
	// super();
	// this.menuName = menuName;
	// this.price = price;
	// this.menuTypeId = new MenuType();
	// }
	//
	// public String getMenuName() {
	// return menuName;
	// }
	//
	// public void setMenuName(String menuName) {
	// this.menuName = menuName;
	// }
	//
	// public double getPrice() {
	// return price;
	// }
	//
	// public void setPrice(double price) {
	// this.price = price;
	// }
	//
	// public String getImageName() {
	// return imageName;
	// }
	//
	// public void setImageName(String imageName) {
	// this.imageName = imageName;
	// }
	//
	// public String getDescription() {
	// return description;
	// }
	//
	// public void setDescription(String description) {
	// this.description = description;
	// }
	//
	// @JsonIgnore
	// public MenuType getMenuTypeId() {
	// return menuTypeId;
	// }
	//
	// public void setMenuTypeId(MenuType menuTypeId) {
	// this.menuTypeId = menuTypeId;
	// }
	//
	//// public void setCart(Cart cart) {
	//// this.cart = cart;
	//// }
	//// public Cart getCart() {
	//// return cart;
	//// }
	//
	// @Override
	// public String toString() {
	// return "Menu [menuName=" + menuName + ", price=" + price + ", imageName=" +
	// imageName + ", description="
	// + description +"]";
	// }

}
