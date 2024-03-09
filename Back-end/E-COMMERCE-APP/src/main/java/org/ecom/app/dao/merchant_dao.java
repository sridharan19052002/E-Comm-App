package org.ecom.app.dao;

import java.util.Optional;

import org.ecom.app.model.merchant;
import org.ecom.app.repository.merchant_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class merchant_dao {

	@Autowired
	public merchant_repo m_repo;
	public merchant save_merchant(merchant m)
	{
		return m_repo.save(m);
	}
	public Optional<merchant> find_by_id(int id)
	{
		return m_repo.findById(id);
	}
	public merchant find_merchant_by_email_password(String email,String password)
	{
		return m_repo.find_merchant_by_email_password(email, password);
	}
	public merchant find_merchant_by_phone_password(long phone,String password)
	{
		return m_repo.find_merchant_by_phone_password(phone, password);
	}
	public boolean delete_merchant(merchant m)
	{
		 m_repo.delete(m);
		 return true;
	}
}
