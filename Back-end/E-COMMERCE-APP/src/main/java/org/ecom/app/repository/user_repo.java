package org.ecom.app.repository;

import org.ecom.app.model.merchant;
import org.ecom.app.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface user_repo extends JpaRepository<user, Integer> {

	@Query("select u from user u where u.email=?1 and u.password=?2")
	public user find_user_by_email_password(String email,String password);
	
	@Query("select u from user u where u.phone=?1 and u.password=?2")
	public user find_user_by_phone_password(long phone,String password);
}
