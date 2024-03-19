package org.ecom.app.repository;

import java.util.Optional;

import org.ecom.app.model.merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface merchant_repo extends JpaRepository<merchant, Integer> {

	@Query("select m from merchant m where m.email=?1 and m.password=?2")
	public merchant find_merchant_by_email_password(String email,String password);
	
	@Query("select m from merchant m where m.phone=?1 and m.password=?2")
	public merchant find_merchant_by_phone_password(long phone,String password);
	
	public Optional<merchant> findByToken(String token);
}
