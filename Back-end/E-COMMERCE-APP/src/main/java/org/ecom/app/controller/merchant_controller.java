package org.ecom.app.controller;

import org.ecom.app.dto.ResponseStructure;
import org.ecom.app.model.merchant;
import org.ecom.app.service.merchant_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/merchant")
@CrossOrigin(origins="*")
public class merchant_controller {

	@Autowired
	public merchant_service m_service;
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseStructure<merchant> save_merchant(@RequestBody merchant m)
	{
		return m_service.save_merchant(m);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<merchant>> find_merchant(@PathVariable int id)
	{
		return m_service.find_by_id(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<merchant>> update_merchant(@RequestBody merchant m)
	{
		return m_service.update_merchant(m);
	}
	@GetMapping(value="/find_merchant_by_email_password")
	public ResponseEntity<ResponseStructure<merchant>> find_mercahnt(@RequestParam String email,@RequestParam String password)
	{
		return m_service.find_merchant_by_email_password(email, password);
	}
	@GetMapping(value="/find_merchant_by_phone_password")
	public ResponseEntity<ResponseStructure<merchant>> find_mercahn(@RequestParam long phone,@RequestParam String password)
	{
		return m_service.find_merchant_by_phone_password(phone, password);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<Boolean>> delete_merchant(@PathVariable int id)
	{
		return m_service.delete_merchant(id);
	}
	
}
