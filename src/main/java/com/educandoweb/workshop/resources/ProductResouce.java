package com.educandoweb.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResouce {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
	//	Product u = new Product(1L,"maria","maria@gmail.com","99999","123456");
		
		List<Product> list = service.findAll();
		 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
