package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.entity.Vendor;

@Repository
public interface VendorRepo extends JpaRepository<Vendor, Long>{
	Vendor findByVendorEmail(String vendorEmail);
}
