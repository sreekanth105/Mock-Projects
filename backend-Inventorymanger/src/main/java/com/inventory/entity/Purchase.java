package com.inventory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long purchaseId;
	private long itemId;
	private String itemName;
	private int purchaseQuantity;
	private String purchaseDate;
	private double totalPrice;
	private double pricePerItem;
	private long customerId;
	private String customerName;
	
////	Customer Can Purchase Many Items
//	@ManyToOne
//	private Customer customer;
////	One Purchase Details Belongs to only One Purchase Transaction
//	@OneToOne
//	private PurchaseDetails purchaseDetails;
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	public Purchase() {}
	public Purchase(long itemId, String itemName, int purchaseQuantity, String purchaseDate, double totalPrice,
			double pricePerItem, long customerId, String customerName) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.purchaseQuantity = purchaseQuantity;
		this.purchaseDate = purchaseDate;
		this.totalPrice = totalPrice;
		this.pricePerItem = pricePerItem;
		this.customerId = customerId;
		this.customerName = customerName;
	}
	
}

//Many Purchases Belongs to one User{Customer}
