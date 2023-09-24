package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.Item;
import com.inventory.services.ItemService;

@RestController
@CrossOrigin(origins="http://localhost/4200")
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService itemService;
	
	@GetMapping("/items")
	public ResponseEntity<?> getAllItem(){
		List<Item> i = itemService.getAllItems();
		if(i!=null) {
			return ResponseEntity.ok(i);
		}
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	@GetMapping("/item")
	public ResponseEntity<?> getItemByName(@PathVariable("itemName") String itemName)
	{
		List<Item> i = itemService.getItemByName(itemName);
		if(i!=null) {
			return ResponseEntity.ok(i);
		}
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}
	@GetMapping("/item/id")
	public ResponseEntity<?> getItemById(@RequestParam("item_id") long item_id){
		Item i = itemService.getItemById(item_id);
		if(i!=null) {
			return ResponseEntity.ok(i);
		}
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	@PostMapping("/item")
	public ResponseEntity<?> addItem(@RequestBody Item item){
		itemService.addItem(item);
		return (ResponseEntity<?>)ResponseEntity.ok();
	}
	@PutMapping("/item")
	public ResponseEntity<?> updateItem(@RequestBody Item item){
		itemService.updateItem(item);
		return (ResponseEntity<?>)ResponseEntity.ok();
	}
	@DeleteMapping("/item")
	public ResponseEntity<?> deleteUserById(@RequestBody Item item){
		itemService.deleteItemById(item.getItemId());
		return (ResponseEntity<?>)ResponseEntity.ok();
	}
}


/*
 GetMapping - to retrieve data
 PostMapping - to add data
 PutMapping - to Update existing data
 DeleteMapping - to delete data
 
*/