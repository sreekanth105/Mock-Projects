package com.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, String>{
	
}
