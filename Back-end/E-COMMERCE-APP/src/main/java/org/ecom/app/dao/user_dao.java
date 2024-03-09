package org.ecom.app.dao;

import java.util.Optional;

import org.ecom.app.model.merchant;
import org.ecom.app.model.user;
import org.ecom.app.repository.merchant_repo;
import org.ecom.app.repository.user_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class user_dao {

	@Autowired
	public user_repo u_repo;
	
	public user save_user(user m)
	{
		return u_repo.save(m);
	}
	public Optional<user> find_by_id(int id)
	{
		return u_repo.findById(id);
	}
	public user find_user_by_email_password(String email,String password)
	{
		return u_repo.find_user_by_email_password(email, password);
	}
	public user find_user_by_phone_password(long phone,String password)
	{
		return u_repo.find_user_by_phone_password(phone, password);
	}
	public boolean delete_user(user m)
	{
		 u_repo.delete(m);
		 return true;
	}
}
