package com.example.Grocery.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Grocery.model.Admin;
import com.example.Grocery.service.ProductService;


@RestController
@CrossOrigin("http://localhost:4200")
public class AdminRestController {
	
	@Autowired
	ProductService service;
	
	
	@PostMapping("/register")
	public Admin saveAdmin(@RequestBody Admin admin) throws Exception {
		String tempEmail=admin.getEmail();
		if(tempEmail != null && !"".equals(tempEmail)) {
			Admin adminObj= service.findByEmail(tempEmail);
			if(adminObj != null)
				throw new Exception("Email already exists");
		}		
		Admin adminObj1= service.saveAdmin(admin);
		return adminObj1;
	}
	
	@PostMapping("/login")
	public Admin loginAdmin(@RequestBody Admin admin) throws Exception {
		String email=admin.getEmail();
		String password=admin.getPassword();
		if(email != null && password != null){
			Admin fetchByAdmin = service.fetchByAdmin(email,password);
			if(fetchByAdmin != null) {
				return fetchByAdmin;	
			}else {
				throw new Exception("Invalid credential");
			}
		}else
			throw new Exception("please enter email and password");
	}
	
	

}
