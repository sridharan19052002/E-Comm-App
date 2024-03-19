package org.ecom.app.service;

import java.util.Optional;

import org.ecom.app.dao.merchant_dao;
import org.ecom.app.dao.user_dao;
import org.ecom.app.dto.ResponseStructure;
import org.ecom.app.exception.IdNotFoundException;
import org.ecom.app.exception.InvalidCredentilalsException;
import org.ecom.app.model.merchant;
import org.ecom.app.model.user;
import org.ecom.app.util.account_status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

@Service
public class user_service {


	@Autowired
	public user_dao u_dao;
	
	@Autowired
	public email_service es;
	
	public ResponseStructure<user> save_user(user m,HttpServletRequest req)
	{
	    ResponseStructure<user> str=new ResponseStructure<>();
	    
	    m.setStatus(account_status.IN_ACTIVE.toString());
	    m.setToken(RandomString.make(10));
	    String message=es.send_mail(m, req);
	    
	    str.setMessage("user saved sucessfully"+message);
	    str.setData(u_dao.save_user(m));
	    str.setStatuscode(HttpStatus.CREATED.value());
	    
	    return str;
	}
	
	
	public ResponseEntity<ResponseStructure<String>> active(String token)
	{
		Optional<user> opt=u_dao.findByToken(token);
		ResponseStructure<String> str=new ResponseStructure<>();
		if(opt.isPresent())
		{
			user m=opt.get();
			m.setStatus(account_status.ACTIVE.toString());
			m.setToken(null);
			u_dao.save_user(m);
			str.setData("user founded");
			str.setMessage("Account Verified And Activated");
			str.setStatuscode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.ACCEPTED);
		}
		throw new InvalidCredentilalsException("Invalid url");
	}
	
	
	public ResponseEntity<ResponseStructure<user>> find_by_id(int id)
	{
		ResponseStructure<user> str=new ResponseStructure<>();
		Optional<user> opt=u_dao.find_by_id(id);
		if(opt.isPresent())
		{
			str.setMessage("user found");
			str.setData(opt.get());
			str.setStatuscode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<user>>(str,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<user>> update_user(user m)
	{
		ResponseStructure<user> str=new ResponseStructure<>();
		Optional<user> opt=u_dao.find_by_id(m.getId());
		if(opt.isPresent())
		{
			user mm=opt.get();
			mm.setId(m.getId());
			mm.setName(m.getName());
			mm.setAge(m.getAge());
			mm.setGender(m.getGender());
			mm.setPassword(m.getPassword());
			mm.setPhone(m.getPhone());
			mm.setEmail(m.getEmail());
			str.setMessage("user updated");
			str.setData(u_dao.save_user(mm));
			str.setStatuscode(HttpStatus.ACCEPTED.value());
			
			return new ResponseEntity<ResponseStructure<user>>(str,HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<user>> find_user_by_email_password(String emauil,String password)
	{
		ResponseStructure<user> str=new ResponseStructure<>();
		user m=u_dao.find_user_by_email_password(emauil, password);
		if(m!=null)
		{
			if(m.getStatus().equals(account_status.IN_ACTIVE.toString()))
			{
				throw new IllegalStateException("Account Is Not Active");
			}
			str.setMessage("user found with the credentials");
			str.setData(m);
			str.setStatuscode(HttpStatus.OK.value());
			 return new ResponseEntity<ResponseStructure<user>>(str,HttpStatus.OK);
		}
		throw new InvalidCredentilalsException("no user found with the creedentilas");
	}
	public ResponseEntity<ResponseStructure<user>> find_user_by_phone_password(long phone,String password)
	{
		ResponseStructure<user> str=new ResponseStructure<>();
		user m=u_dao.find_user_by_phone_password(phone, password);
		if(m!=null)
		{
			str.setMessage("user found with the credentials");
			str.setData(m);
			str.setStatuscode(HttpStatus.OK.value());
			 return new ResponseEntity<ResponseStructure<user>>(str,HttpStatus.OK);
		}
		throw new InvalidCredentilalsException("no user found with the creedentilas");
	}
	public ResponseEntity<ResponseStructure<Boolean>> delete_user(int id)
	{
		ResponseStructure<Boolean> str=new ResponseStructure<>();
		Optional<user> opt=u_dao.find_by_id(id);
		if(opt.isPresent())
		{
			user m=opt.get();
			str.setMessage("user deleted");
			str.setData(u_dao.delete_user(m));
			str.setStatuscode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<Boolean>>(str,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
}
