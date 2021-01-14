package com.example.Grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Grocery.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByEmail(String email);
	
	@Query("from Admin where email=:email and password=:password")
	Admin findByAdmin(String email, String password);

}
