package org.ecom.app.service;

import java.util.Optional;

import org.ecom.app.dao.merchant_dao;
import org.ecom.app.dto.ResponseStructure;
import org.ecom.app.exception.IdNotFoundException;
import org.ecom.app.exception.InvalidCredentilalsException;
import org.ecom.app.model.merchant;
import org.ecom.app.util.account_status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

@Service
public class merchant_service {

	@Autowired
	public merchant_dao m_dao;
	
	@Autowired
	public email_service es;
	
	public ResponseStructure<merchant> save_merchant(merchant m,HttpServletRequest req)
	{
	    ResponseStructure<merchant> str=new ResponseStructure<>();
	    
	    m.setStatus(account_status.IN_ACTIVE.toString());
	    m.setToken(RandomString.make(10));
	    	
	    String message=es.send_mail(m, req);
	    
	    str.setMessage("Merchant saved sucessfully"+message);
	    str.setData(m_dao.save_merchant(m));
	    str.setStatuscode(HttpStatus.CREATED.value());
	    
	    return str;
	}
	
	
	public ResponseEntity<ResponseStructure<String>> active(String token)
	{
		Optional<merchant> opt=m_dao.findByToken(token);
		ResponseStructure<String> str=new ResponseStructure<>();
		if(opt.isPresent())
		{
			merchant m=opt.get();
			m.setStatus(account_status.ACTIVE.toString());
			m.setToken(null);
			m_dao.save_merchant(m);
			str.setData("merchant founded");
			str.setMessage("Account Verified And Activated");
			str.setStatuscode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.ACCEPTED);
		}
		throw new InvalidCredentilalsException("Invalid url");
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
			if(m.getStatus().equals(account_status.IN_ACTIVE.toString()))
			{
				throw new IllegalStateException("Account Is Not Active");
			}
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
