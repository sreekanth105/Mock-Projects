package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.Admin;
import com.inventory.entity.Customer;
import com.inventory.entity.Item;
import com.inventory.entity.Purchase;
import com.inventory.entity.Sales;
import com.inventory.entity.Vendor;
import com.inventory.services.AdminService;
@RestController
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
//	To Get The Data
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Admin admin){
		Admin db = adminService.getAdminByUsername(admin.getAusername());
		if(db.getApassword().equals(admin.getApassword()))
			return ResponseEntity.ok(db);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	
//	Item's Related Section
	//To add item
	@PostMapping("/item")
	public ResponseEntity<?> addItem(@RequestBody Item item) {
		return ResponseEntity.ok(adminService.additem(item));
	}
	//to get all items
	@GetMapping("/item")
	public ResponseEntity<?> getAllItems(){
		List<Item> itemList = adminService.getAllItems();
		if(itemList.size()!=0)
			return ResponseEntity.ok(itemList);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	//to get item by id
	@GetMapping("/item/{itemId}")
	public ResponseEntity<?> getItemById(@PathVariable("itemId") Long itemId){
		Item item = adminService.getItemById(itemId);
		if(item!=null)
			return ResponseEntity.ok(item);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	//to delete item by id
	@DeleteMapping("/item/{itemId}")
	public void deleteItemById(@PathVariable("itemId") Long itemId) {
		adminService.deleteitem(itemId);
	}

//	customers related section
	
	//to add customer
	@PostMapping("/customer")
	public ResponseEntity<?> addUser(@RequestBody Customer customer){
		return ResponseEntity.ok(adminService.addCustomer(customer));
	}
	
	//to get all customers
	@GetMapping("/customer")
	public ResponseEntity<?> getAllCustomers(){
		List<Customer> customerList = adminService.getAllCustomer();
		if(customerList.size()!=0)
			return ResponseEntity.ok(customerList);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}

	//to get customer by Id
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable("customerId") Long customerId){
		Customer customer = adminService.getCustomerById(customerId);
		if(customer!=null)
			return ResponseEntity.ok(customer);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	
	//to delete customer by id
	@DeleteMapping("/customer/{customerId}")
	public void deleteCustomerById(@PathVariable("customerId") Long customerId) {
		adminService.deleteCustomerById(customerId);
	}
	
//	vendors related section
	
	//to add vendor
	@PostMapping("/vendor")
	public ResponseEntity<?> addVendor(@RequestBody Vendor vendor){
		return ResponseEntity.ok(adminService.addVendor(vendor));
	}
	
	//to get all vendors
	@GetMapping("/vendor")
	public ResponseEntity<?> getAllVendors(){
		List<Vendor> vendorList = adminService.getAllVendors();
		if(vendorList.size()!=0)
			return ResponseEntity.ok(vendorList);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}

	//to get vendor by Id
	@GetMapping("/vendor/{vendorId}")
	public ResponseEntity<?> getVendorById(@PathVariable("vendorId") Long vendorId){
		Vendor vendor = adminService.getVendorById(vendorId);
		if(vendor!=null)
			return ResponseEntity.ok(vendor);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	
	//to delete vendor by id
	@DeleteMapping("/vendor/{vendorId}")
	public void deleteVendorById(@PathVariable("vendorId") Long vendorId) {
		adminService.deleteVendorById(vendorId);
	}
	
	@DeleteMapping("/vendor/item/{id}")
	public void deleteItemByVendorId(@PathVariable Long id) {
		adminService.deleteItemByVendorId(id);
	}
	
	
//	purchase and sale's
	
	@GetMapping("/purchase")
	public ResponseEntity<?> getAllPurchases(){
		List<Purchase> pList = adminService.getAllPurchase();
		if(pList.size()>0)
			return ResponseEntity.ok(pList);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	@GetMapping("/purchase/{id}")
	public ResponseEntity<?> getPurchaseById(@PathVariable("id") Long id){
		Purchase p = adminService.getPurchaseById(id);
		if(p!=null)
			return ResponseEntity.ok(p);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	
	@GetMapping("/sale")
	public ResponseEntity<?> getAllSales(){
		List<Sales> sList = adminService.getAllSales();
		if(sList.size()>0)
			return ResponseEntity.ok(sList);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	@GetMapping("/sale/{id}")
	public ResponseEntity<?> getSaleById(@PathVariable("id") Long id){
		Sales p = adminService.getSaleById(id);
		if(p!=null)
			return ResponseEntity.ok(p);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
}
