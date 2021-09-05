package com.products.apirest.resource;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.apirest.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.products.apirest.models.Product;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Products")
@CrossOrigin(origins = "*")
public class ProductResource {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	@ApiOperation(value = "Return list of products")
	public List<Product> doListProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	@ApiOperation(value = "Return product for id")
	public Product listUniqueProduct(@PathVariable(value="id") long id) {
		return productRepository.findById(id);
	}
	
	@PostMapping("/saveproduct")
	@ApiOperation(value = "Save product for id")
	public Product saveProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/deleteproduct")
	@ApiOperation(value = "Delete product.")
	public HashMap<String, String> deleteProduct (@RequestBody Product product) {
		productRepository.delete(product);
		  HashMap<String, String> map = new HashMap<>();
		  map.put("message", "file deleted");
		  map.put("status", "ok");
		  return map;
	}
	
	@PutMapping("/alterproduct")
	@ApiOperation(value = "Update product for id and other args in body")
	public HashMap<String, String> putProduct (@RequestBody Product product) {
		productRepository.save(product);
		  HashMap<String, String> map = new HashMap<>();
		  map.put("message", "file updated");
		  map.put("status", "ok");
		  return map;
	}
}
