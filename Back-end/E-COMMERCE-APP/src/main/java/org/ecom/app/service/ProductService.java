package org.ecom.app.service;


import java.util.List;
import java.util.Optional;

import org.ecom.app.dao.ProductDao;
import org.ecom.app.dao.merchant_dao;
import org.ecom.app.dto.ResponseStructure;
import org.ecom.app.exception.ProductNotFoundException;
import org.ecom.app.model.Product;
import org.ecom.app.model.merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
	@Autowired
	private ProductDao dao;
	@Autowired
	private merchant_dao mdao;
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product,int merchantId){
		Optional<merchant> m=mdao.find_by_id(merchantId);
		ResponseStructure<Product> structure=new ResponseStructure<>();
		if(m.isPresent()) {
			merchant m1=m.get();
			product.setMerchant(m1);
			m1.getProducts().add(product);
			structure.setMessage("product is add to merchant"+m1.getName());
			structure.setData(dao.saveProduct(product));
			structure.setStatuscode(merchantId);
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
		}
		throw new ProductNotFoundException("merchant not found to add the product");
	}
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product){
		Optional<Product> p=dao.findById(product.getId());
		ResponseStructure<Product> structure=new ResponseStructure<>();
		if(p.isPresent()) {
			Product p1=p.get();
			p1.setBrand(product.getBrand());
			p1.setCategory(product.getCategory());
			p1.setCost(product.getCost());
			p1.setDescription(product.getDescription());
			p1.setImage_Url(product.getImage_Url());
			p1.setName(product.getName());
			structure.setMessage("product is updated");
			structure.setData(dao.saveProduct(p1));
			structure.setStatuscode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.ACCEPTED);	
		}
		throw new ProductNotFoundException("Product id not found");
	}
	public ResponseEntity<ResponseStructure<Product>> findById(int id){
		Optional<Product> p=dao.findById(id);
		ResponseStructure<Product> structure=new ResponseStructure<>();
		if(p.isPresent()) {
			Product p1=p.get();
			structure.setMessage("product found");
			structure.setData(dao.findById(id).get());
			structure.setStatuscode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.ACCEPTED);	
		}
		throw new ProductNotFoundException("Product id not found");
	}
	public ResponseEntity<ResponseStructure<List<Product>>> findByBrand(String brand){
		List<Product> p=dao.findByBrand(brand);
		ResponseStructure<List<Product>> structure=new ResponseStructure<>();
		if(p.isEmpty()) {
			throw new ProductNotFoundException("Product id not found");
			
		}
		structure.setMessage("there are no products with brand "+brand);
		structure.setData(dao.findByBrand(brand));
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);	
	}
	public ResponseEntity<ResponseStructure<List<Product>>> findByCatagory(String catogary){
		List<Product> p=dao.findByCategory(catogary);
		ResponseStructure<List<Product>> structure=new ResponseStructure<>();
		if(p.isEmpty()) {
			throw new ProductNotFoundException("there are no products with catogary "+catogary);
			
		}
		structure.setMessage("products list for catagory");
		structure.setData(p);
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);	
	}
	public ResponseEntity<ResponseStructure<List<Product>>> findAll(){
		List<Product> p=dao.findAll();
		ResponseStructure<List<Product>> structure=new ResponseStructure<>();
		if(p.isEmpty()) {
			throw new ProductNotFoundException("there are no products");
		}
		structure.setMessage("total products");
		structure.setData(p);
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);	
	}
	public ResponseEntity<ResponseStructure<String>> deleteById(int id){
		ResponseStructure<String> structure=new ResponseStructure<>();
		if(dao.deleteById(id)){
			structure.setMessage("product FOUND");	
			structure.setData("PRODUCT DELETED");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		throw new ProductNotFoundException("product not deleted");
	}
	public ResponseEntity<ResponseStructure<List<Product>>> findByMerchantId(int id){
		List<Product> p=dao.findByMerchantId(id);
		ResponseStructure<List<Product>> structure=new ResponseStructure<>();
		if(p.isEmpty()) {
			throw new ProductNotFoundException("there are no products");
		}
		structure.setMessage("products that merchant won");
		structure.setData(p);
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);	
	}
	


}
