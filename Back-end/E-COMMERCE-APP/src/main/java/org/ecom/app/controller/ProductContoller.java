package org.ecom.app.controller;

import org.ecom.app.dto.ResponseStructure;
import org.ecom.app.model.Product;
import org.ecom.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



@Controller
@CrossOrigin
@RequestMapping(value="/products")
public class ProductContoller {
	@Autowired
	private ProductService service;
	@PostMapping(value="/{merchant_id}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product,@PathVariable int merchant_id){
		return service.saveProduct(product, merchant_id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product){
		return service.updateProduct(product);
	}
	@GetMapping(value="/find-by-merchantId/{merchant_id}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByMerchantId(@PathVariable int merchant_id){
		return service.findByMerchantId(merchant_id);
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteProductById(@PathVariable int id){
		return service.deleteById(id);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Product>>> findAll(){
		return service.findAll();
	}
	@GetMapping(value="/find-by-category/{category}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByCategory(@PathVariable String category){
		return service.findByCatagory(category);
	}
	@GetMapping(value="/find-by-brand/{brand}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByBrnd(@PathVariable String brand){
		return service.findByBrand(brand);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<ResponseStructure<Product>> findById(@PathVariable int id){
		return service.findById(id);
	}
	
	

}
