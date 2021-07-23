package com.simpleCartSystem;

//Purpose: To carry data related to an item

public class Item {
	// properties
	private String itemName;// name of the item
	private String itemDesc;// item's description
	private Double itemPrice;// item's price
	private Integer quantity;// number of items the user has added to the cart
	private Integer availableQuantity;// the number of items of a type available in the system

	// constructors
	

	public Item() {
		// Your code here
		quantity = 1;
	}

	public Item(String itemName, String itemDesc, Double itemPrice, Integer availableQuantity) {

		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
		this.availableQuantity = availableQuantity;
		quantity = 1;
	}
	// Getters and Setters

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
}


