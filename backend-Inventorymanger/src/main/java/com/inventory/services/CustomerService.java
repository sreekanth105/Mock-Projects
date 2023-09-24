package com.inventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.Customer;
import com.inventory.entity.Item;
import com.inventory.entity.Purchase;
import com.inventory.entity.Sales;
import com.inventory.repository.CustomerRepo;
import com.inventory.repository.ItemRepo;
import com.inventory.repository.SaleRepo;
import com.inventory.repository.purchaseRepo;

@Service
public class CustomerService {
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	ItemRepo itemRepo;
	@Autowired
	purchaseRepo purchaseRepo;
	@Autowired
	SaleRepo saleRepo;
//	Add Customer
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
//	Delete Customer
	public void deleteCustomerById(long customer_id) {
		customerRepo.deleteById(customer_id);
	}
	
//	Update Customer
	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
//	Display Customer
	public Customer displayCustomerById(long customer_id) {
		return customerRepo.findById(customer_id).get();
	}
	
//	Display Customer By name
	public Customer displayCustomerByName(String customer_name) {
		return customerRepo.findByCustomerName(customer_name);
	}
	
//	Display Customer By email
	public Customer displayCustomerByEmail(String customer_email) {
		return customerRepo.findByCustomerEmail(customer_email);
	}
	
//	Display All Customer
	public List<Customer> displayAllCustomer(){
		return customerRepo.findAll();
	}
	
//	get all items
	public List<Item> getAllItems(){
		return itemRepo.findAll();
	}
	
	public Item getItemById(long id) {
		return itemRepo.findById(id).get();
	}
	
	public void updateItem(Item item) {
		itemRepo.save(item);
	}
	
//	purchase data
	public Purchase addPurchase(Purchase purchase) {
		return purchaseRepo.save(purchase);
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
	public void addSales(Sales sale) {
		saleRepo.save(sale);
	}
}
