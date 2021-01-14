package com.example.Grocery.service;
import java.util.List;

import com.example.Grocery.model.Admin;
import com.example.Grocery.model.Product;
public interface ProductService {

	Admin saveAdmin(Admin admin);

	Admin findByEmail(String email);

	Product saveProduct(Product product);

	Product findById(Long id);

	void deleteById(Long id);

	List<Product> getAllProduct();

	Admin fetchByAdmin(String email, String password);

}
