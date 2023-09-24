package com.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.Item;
import com.inventory.repository.ItemRepo;

@Service
public class ItemService {
	@Autowired
	ItemRepo itemRepo;
	
//	public List<Item> getItemByName(String name){
//		return itemRepo.findByItemName(name);
//	}
	
	public Item getItemById(long id) {
		return itemRepo.findById(id).get();
	}
	
	public void deleteItemById(long id) {
		itemRepo.deleteById(id);
	}
	
	public void addItem(Item item) {
		itemRepo.save(item);
	}
	
	public List<Item> getAllItems(){
		return itemRepo.findAll();
	}
	
	public void updateItem(Item item) {
		Item old = itemRepo.findById(item.getItemId()).get();
		old.setItemCategory(item.getItemCategory());
		old.setItemDescription(item.getItemDescription());
		old.setItemName(item.getItemName());
		old.setItemPrice(item.getItemPrice());
		old.setItemQuantity(item.getItemQuantity());
		itemRepo.save(old);
	}
	public List<Item> getItemByName(String itemName) {
		return itemRepo.findByItemName(itemName);
	}
}