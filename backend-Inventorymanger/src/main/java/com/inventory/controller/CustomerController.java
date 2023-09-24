package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.Customer;
import com.inventory.entity.Item;
import com.inventory.entity.Purchase;
import com.inventory.entity.Sales;
import com.inventory.entity.Vendor;
import com.inventory.services.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	Sales sale;
	@Autowired
	CustomerService customerService;
	
//	customer login
	@PostMapping("/login")
	public ResponseEntity<?> getCustomerByUsername(@RequestBody Customer customer){
		Customer cust = customerService.displayCustomerByEmail(customer.getCustomerEmail());
		if(cust!=null) 
			if(cust.getCustomerPassword().equals(customer.getCustomerPassword()))
				return ResponseEntity.ok(cust);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	
	@PostMapping("/forgot")
	public ResponseEntity<?> forgotCustomer(@RequestBody Customer customer){
		Customer c = customerService.displayCustomerByEmail(customer.getCustomerEmail());
		c.setCustomerPassword(customer.getCustomerPassword());
		return ResponseEntity.ok(customerService.updateCustomer(c));
	}

//	to get the customer details by id
	@GetMapping("/get/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable("customerId") Long id){
		Customer customer = customerService.displayCustomerById(id);
		if(customer!=null)
			return ResponseEntity.ok(customer);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	
//	customer can update his/her profile
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Customer customer) {
		Customer old = customerService.displayCustomerById(customer.getCustomerId());
		if(old!=null)
			return ResponseEntity.ok(customerService.updateCustomer(customer));
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	
//	Customer can register himself/herself
	@PostMapping("/register")
	public ResponseEntity<?> add(@RequestBody Customer customer){
		return ResponseEntity.ok(customerService.addCustomer(customer));
	}	
	
	// to get All item's
	@GetMapping("/item")
	public ResponseEntity<?> getAllItems(){
		return ResponseEntity.ok(customerService.getAllItems());
	}
	
	// to get item by id
	@GetMapping("/item/{id}")
	public ResponseEntity<?> getItemById(@PathVariable("id") Long id){
		return ResponseEntity.ok(customerService.getItemById(id));
	}
	
//	purchase Section 
	@PostMapping("/purchase")
	public ResponseEntity<?> addPurchase(@RequestBody Purchase purchase){
		Item item = customerService.getItemById(purchase.getItemId());
		item.setItemQuantity(item.getItemQuantity()-purchase.getPurchaseQuantity());
		purchase.setPricePerItem(item.getItemPrice());
		purchase.setTotalPrice(item.getItemPrice()*purchase.getPurchaseQuantity());
		purchase.setItemName(item.getItemName());
		purchase.setCustomerName(customerService.displayCustomerById(purchase.getCustomerId()).getCustomerName());
		customerService.updateItem(item);
		
//		adding these details to sales
		sale.setCustomerId(purchase.getCustomerId());
		sale.setCustomerName(purchase.getCustomerName());
		sale.setItemId(purchase.getItemId());
		sale.setItemName(purchase.getItemName());
		sale.setPricePerItem(purchase.getPricePerItem());
		sale.setSaleDate(purchase.getPurchaseDate());
		sale.setSaleQuantity(purchase.getPurchaseQuantity());
		sale.setTotalPrice(purchase.getTotalPrice());
		sale.setVendorId(item.getItemId());
		
		customerService.addSales(sale);
		
		return ResponseEntity.ok(customerService.addPurchase(purchase));
	}
	
	//get All purchases with customer id
	@GetMapping("/purchase/get/{id}")
	public ResponseEntity<?> getAllPurchases(@PathVariable("id") Long id){
		List<Purchase> pList = customerService.getAllPurchaseByCustomerId(id);
		if(pList.size()>0)
			return ResponseEntity.ok(pList);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	//get purchase by purchase id
	@GetMapping("/purchase/{id}")
	public ResponseEntity<?> getPurchaseById(@PathVariable("id") Long id){
		Purchase p = customerService.getPurchaseById(id);
		if(p!=null)
			return ResponseEntity.ok(p);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
}
