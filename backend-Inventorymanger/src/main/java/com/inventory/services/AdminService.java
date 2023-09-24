package com.inventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.Admin;
import com.inventory.entity.Customer;
import com.inventory.entity.Item;
import com.inventory.entity.Purchase;
import com.inventory.entity.Sales;
import com.inventory.entity.Vendor;
import com.inventory.repository.AdminRepo;
import com.inventory.repository.CustomerRepo;
import com.inventory.repository.ItemRepo;
import com.inventory.repository.SaleRepo;
import com.inventory.repository.VendorRepo;
import com.inventory.repository.purchaseRepo;

@Service
public class AdminService {
	@Autowired
	AdminRepo userRepo;
	@Autowired
	ItemRepo itemRepo;
	@Autowired
	CustomerRepo custRepo;
	@Autowired
	VendorRepo vendorRepo;
	@Autowired
	purchaseRepo purchaseRepo;
	@Autowired
	SaleRepo saleRepo;
	
	
	
	public Admin getAdminByUsername(String ausername) {
		return userRepo.findById(ausername).get();
	}
	
//	Items Section
	
	public Item additem(Item item) {
		return itemRepo.save(item);
	}
	
	public void deleteitem(long id) {
		itemRepo.deleteById(id);
	}
	
	public List<Item> getAllItems(){
		return itemRepo.findAll();
	}
	
	public Item getItemById(long id) {
		return itemRepo.findById(id).get();
	}
	
//	Customer Section
	
	public Customer addCustomer(Customer customer) {
		return custRepo.save(customer);
	}
	
	public void deleteCustomerById(long customerId) {
		custRepo.deleteById(customerId);
	}
	
	public List<Customer> getAllCustomer(){
		return custRepo.findAll();
	}
	
	public Customer getCustomerById(long Id) {
		return custRepo.findById(Id).get();
	}
	
//	Vendor Section
	public Vendor addVendor(Vendor vendor) {
		return vendorRepo.save(vendor);
	}
	
	public void deleteVendorById(long Id) {
		vendorRepo.deleteById(Id);
	}
	
	public List<Vendor> getAllVendors(){
		return vendorRepo.findAll();
	}
	
	public Vendor getVendorById(long id) {
		return vendorRepo.findById(id).get();
	}
	
	public void deleteItemByVendorId(long id) {
		itemRepo.deleteByVendorId(id);
	}
	
//	sales and purchase
	public List<Sales> getSalesByVendorId(long id){
		return saleRepo.findByVendorId(id);
	}
	public List<Sales> getAllSales(){
		return saleRepo.findAll();
	}
	public Sales getSaleById(long id) {
		Optional<Sales> sale = saleRepo.findById(id);
		if(sale.isPresent())
			return sale.get();
		return null;
	}
	
	public List<Purchase> getAllPurchaseByCustomerId(long id){
		return purchaseRepo.findByCustomerId(id);
	}
	public Purchase getPurchaseById(long id) {
		Optional<Purchase> p = purchaseRepo.findById(id);
		if(p.isPresent())
			return p.get();
		return null;
	}
	public List<Purchase> getAllPurchase(){
		return purchaseRepo.findAll();
	}
}
