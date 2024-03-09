package org.ecom.app.service;

import java.util.Optional;

import org.ecom.app.dao.merchant_dao;
import org.ecom.app.dto.ResponseStructure;
import org.ecom.app.exception.IdNotFoundException;
import org.ecom.app.exception.InvalidCredentilalsException;
import org.ecom.app.model.merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class merchant_service {

	@Autowired
	public merchant_dao m_dao;
	
	public ResponseStructure<merchant> save_merchant(merchant m)
	{
	    ResponseStructure<merchant> str=new ResponseStructure<>();
	    str.setMessage("Merchant saved sucessfully");
	    str.setData(m_dao.save_merchant(m));
	    str.setStatuscode(HttpStatus.CREATED.value());
	    
	    return str;
	}
	public ResponseEntity<ResponseStructure<merchant>> find_by_id(int id)
	{
		ResponseStructure<merchant> str=new ResponseStructure<>();
		Optional<merchant> opt=m_dao.find_by_id(id);
		if(opt.isPresent())
		{
			str.setMessage("Merchant found");
			str.setData(opt.get());
			str.setStatuscode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<merchant>>(str,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<merchant>> update_merchant(merchant m)
	{
		ResponseStructure<merchant> str=new ResponseStructure<>();
		Optional<merchant> opt=m_dao.find_by_id(m.getId());
		if(opt.isPresent())
		{
			merchant mm=opt.get();
			mm.setId(m.getId());
			mm.setName(m.getName());
			mm.setGst_number(m.getGst_number());
			mm.setPassword(m.getPassword());
			mm.setPhone(m.getPhone());
			mm.setEmail(m.getEmail());
			str.setMessage("merchant updated");
			str.setData(m_dao.save_merchant(mm));
			str.setStatuscode(HttpStatus.ACCEPTED.value());
			
			return new ResponseEntity<ResponseStructure<merchant>>(str,HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<merchant>> find_merchant_by_email_password(String emauil,String password)
	{
		ResponseStructure<merchant> str=new ResponseStructure<>();
		merchant m=m_dao.find_merchant_by_email_password(emauil, password);
		if(m!=null)
		{
			str.setMessage("Merchant found with the credentials");
			str.setData(m);
			str.setStatuscode(HttpStatus.OK.value());
			 return new ResponseEntity<ResponseStructure<merchant>>(str,HttpStatus.OK);
		}
		throw new InvalidCredentilalsException("no merchant found with the creedentilas");
	}
	public ResponseEntity<ResponseStructure<merchant>> find_merchant_by_phone_password(long phone,String password)
	{
		ResponseStructure<merchant> str=new ResponseStructure<>();
		merchant m=m_dao.find_merchant_by_phone_password(phone, password);
		if(m!=null)
		{
			str.setMessage("Merchant found with the credentials");
			str.setData(m);
			str.setStatuscode(HttpStatus.OK.value());
			 return new ResponseEntity<ResponseStructure<merchant>>(str,HttpStatus.OK);
		}
		throw new InvalidCredentilalsException("no merchant found with the creedentilas");
	}
	public ResponseEntity<ResponseStructure<Boolean>> delete_merchant(int id)
	{
		ResponseStructure<Boolean> str=new ResponseStructure<>();
		Optional<merchant> opt=m_dao.find_by_id(id);
		if(opt.isPresent())
		{
			merchant m=opt.get();
			str.setMessage("Merchant deleted");
			str.setData(m_dao.delete_merchant(m));
			str.setStatuscode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<Boolean>>(str,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
}
