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

import com.inventory.entity.Item;
import com.inventory.entity.Sales;
import com.inventory.entity.Vendor;
import com.inventory.services.VendorService;

@RestController
@RequestMapping("/vendor")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class VendorController {

	@Autowired
	VendorService vendorService;
	
	@PostMapping("/login")
	public ResponseEntity<?> loginVendor(@RequestBody Vendor vendor) {
		Vendor db = vendorService.getVendorByEmail(vendor.getVendorEmail());
		if(db.getVendorPassword().equals(vendor.getVendorPassword())) {
			return ResponseEntity.ok(db);
		}
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> addVendor(@RequestBody Vendor vendor){
		return ResponseEntity.ok(vendorService.addVendor(vendor));		
	}
	
	@PostMapping("/forgot")
	public ResponseEntity<?> forgotVendor(@RequestBody Vendor vendor){
		Vendor v = vendorService.getVendorByEmail(vendor.getVendorEmail());
		v.setVendorPassword(vendor.getVendorPassword());
		return ResponseEntity.ok(vendorService.addVendor(v));
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getVendorById(@PathVariable("id") Long id) {
		Vendor vendor = vendorService.getVendorById(id);
		return ResponseEntity.ok(vendor);
	}	
	
	@PostMapping("/item")
	public ResponseEntity<?> addItem(@RequestBody Item item){
		return ResponseEntity.ok(vendorService.addItem(item));
	}
	
	@GetMapping("/item/{id}")
	public ResponseEntity<?> getAllItems(@PathVariable("id") Long id){
		List<Item> itemList = vendorService.getAllItem(id);
		if(itemList.size()>0)
			return ResponseEntity.ok(itemList);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	
	@GetMapping("/item/get/{id}")
	public ResponseEntity<?> getItemById(@PathVariable("id") Long id){
		Item item = vendorService.getItemById(id);
		if(item!=null)
			return ResponseEntity.ok(item);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	
	@DeleteMapping("/item/{id}")
	public void deleteItem(@PathVariable("id") Long id) {
		vendorService.deleteItem(id);
	}
	
	@GetMapping("/sales/{id}")
	public ResponseEntity<?> getSalesByVendorId(@PathVariable("id") Long id){
		List<Sales> sList = vendorService.getSalesByVendorId(id);
		if(sList.size()>0)
			return ResponseEntity.ok(sList);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	
	@GetMapping("/sale/{id}")
	public ResponseEntity<?> getSalesById(@PathVariable("id") Long id){
		Sales sale = vendorService.getSaleById(id);
		if(sale!=null)
			return ResponseEntity.ok(sale);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
}
