package com.example.Grocery.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Grocery.model.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {

}
