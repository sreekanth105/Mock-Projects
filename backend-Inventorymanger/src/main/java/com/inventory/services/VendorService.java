package com.inventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.Item;
import com.inventory.entity.Sales;
import com.inventory.entity.Vendor;
import com.inventory.repository.ItemRepo;
import com.inventory.repository.SaleRepo;
import com.inventory.repository.VendorRepo;

@Service
public class VendorService{
	@Autowired
	VendorRepo vendorRepo;
	@Autowired
	ItemRepo itemRepo;
	@Autowired
	SaleRepo saleRepo;
	
	public Vendor getVendorById(long id) {
		Optional<Vendor> vendor = vendorRepo.findById(id);
		if(vendor.isEmpty())
			return null;
		return vendor.get();
	}
	
	public Vendor getVendorByEmail(String Email) {
		Vendor vendor = vendorRepo.findByVendorEmail(Email);
		return vendor;
	}
	
	public Vendor addVendor(Vendor vendor) {
		return vendorRepo.save(vendor);
	}
	
	public Item addItem(Item item) {
		return itemRepo.save(item); 
	}
	
	public List<Item> getAllItem(long id){
		return itemRepo.findByVendorId(id);
	}
	
	public void deleteItem(long id) {
		itemRepo.deleteById(id);
	}
	
	public Item getItemById(long id) {
		return itemRepo.findById(id).get();
	}
	
	public List<Sales> getSalesByVendorId(long id){
		return saleRepo.findByVendorId(id);
	}
	
	public Sales getSaleById(long id) {
		Optional<Sales> sale = saleRepo.findById(id);
		if(sale.isPresent())
			return sale.get();
		return null;
	}
}