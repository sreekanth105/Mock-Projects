package com.inventory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sales {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long saleId;
	private long itemId;
	private long vendorId;
	private long customerId;
	private String itemName;
	private String customerName;
	private long saleQuantity;
	private String saleDate;
	private double totalPrice;
	private double pricePerItem;
	
	public Sales() {}
	
	public Sales(long saleId, long itemId, long vendorId, long customerId, String itemName, String customerName,
			long saleQuantity, String saleDate, double totalPrice, double pricePerItem) {
		super();
		this.saleId = saleId;
		this.itemId = itemId;
		this.vendorId = vendorId;
		this.customerId = customerId;
		this.itemName = itemName;
		this.customerName = customerName;
		this.saleQuantity = saleQuantity;
		this.saleDate = saleDate;
		this.totalPrice = totalPrice;
		this.pricePerItem = pricePerItem;
	}

	public long getSaleId() {
		return saleId;
	}

	public void setSaleId(long saleId) {
		this.saleId = saleId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getSaleQuantity() {
		return saleQuantity;
	}

	public void setSaleQuantity(long saleQuantity) {
		this.saleQuantity = saleQuantity;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
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
}