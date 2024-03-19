package org.ecom.app.dao;



import java.util.List;
import java.util.Optional;

import org.ecom.app.model.Product;
import org.ecom.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product p) {
		return repository.save(p);
	}
	public Optional<Product> findById(int id){
		return repository.findById(id);
	}
	public List<Product> findByBrand(String brand){
		return repository.findByBrand(brand);
	}
	public List<Product> findByCategory(String category){
		return repository.findByCategory(category);
	}
	public List<Product> findByMerchantId(int id){
		return repository.findByMerchantId(id);
	}
	public List<Product> findAll(){
		return repository.findAll();
	}
	public boolean deleteById(int id) {
		Optional<Product> p=repository.findById(id);
		if(p.isPresent()) {
			repository.delete(p.get());
			return true;
		}
		return false;
	}
	
	
}
