package org.ecom.app.repository;



import java.util.List;

import org.ecom.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	public List<Product> findByCategory(String category);
	public List<Product> findByBrand(String brand);
	@Query("select p from Product p where p.merchant.id=?1")
	public List<Product> findByMerchantId(int merchant_id);
}
