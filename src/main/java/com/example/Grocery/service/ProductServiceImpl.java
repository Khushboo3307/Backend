package com.example.Grocery.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Grocery.model.Admin;
import com.example.Grocery.model.Product;
import com.example.Grocery.repository.AdminRepository;
import com.example.Grocery.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

	@Override
	public Admin findByEmail(String email) {
		Admin findByEmail = adminRepo.findByEmail(email);
		return findByEmail;
	}

	@Override
	public Product saveProduct(Product product) {
		Product product1 = productRepo.save(product);
		return product1;
	}

	@Override
	public Product findById(Long id) {
		Optional<Product> findById = productRepo.findById(id);
		Product product = findById.get();
		return product;
	}

	@Override
	public void deleteById(Long id) {
		productRepo.deleteById(id);
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> findAll = productRepo.findAll();
		return findAll;
	}

	@Override
	public Admin fetchByAdmin(String email, String password) {
		Admin findByAdmin = adminRepo.findByAdmin(email,password);
		return findByAdmin;
	}

}
