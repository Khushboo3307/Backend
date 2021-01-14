package com.example.Grocery.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Grocery.model.Product;
import com.example.Grocery.service.ProductService;
@RestController
@CrossOrigin("http://localhost:4200")
public class ProductRestController {
	
	@Autowired
	ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) throws Exception {
		if(product.getPname()!= null && product.getCategory()!= null && product.getWeight()!=null && product.getQuantity() !=0 && product.getDateOfRegistration() != null) {
			Product saveProduct = service.saveProduct(product);
			return saveProduct;
		}else
			throw new Exception("Please enter product details!!");
	}
	
	@GetMapping("/allProducts")
	public List<Product> getAllProducts(){
		List<Product> allProduct = service.getAllProduct();
		return allProduct;
	}
	
	@GetMapping("/editProduct/{id}")
	public Product editProduct(@PathVariable("id") Long id) {
		Product findById = service.findById(id);
		return findById;
	}
	
	@PutMapping("/updatedProduct")
	public Product updatedProduct(@RequestBody Product product) {
		Product saveProduct = service.saveProduct(product);
		return saveProduct;
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProduct(@PathVariable("id") Long id) {
		service.deleteById(id);
	}

	
}
