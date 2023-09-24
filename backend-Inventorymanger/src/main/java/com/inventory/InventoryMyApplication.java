package com.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.inventory.entity.Sales;

@SpringBootApplication
public class InventoryMyApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryMyApplication.class, args);
	}
	
	@Bean
	public Sales getSales() {
		return new Sales();
	}

}
