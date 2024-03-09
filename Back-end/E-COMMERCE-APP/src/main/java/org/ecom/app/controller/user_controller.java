package org.ecom.app.controller;

import org.ecom.app.dto.ResponseStructure;
import org.ecom.app.model.merchant;
import org.ecom.app.model.user;
import org.ecom.app.service.merchant_service;
import org.ecom.app.service.user_service;
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
@RequestMapping(value = "/user")
@CrossOrigin
public class user_controller {

	@Autowired
	public user_service u_service;
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseStructure<user> save_merchant(@RequestBody user m)
	{
		return u_service.save_user(m);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<user>> find_merchant(@PathVariable int id)
	{
		return u_service.find_by_id(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<user>> update_merchant(@RequestBody user m)
	{
		return u_service.update_user(m);
	}
	@GetMapping(value="/find_user_by_email_password")
	public ResponseEntity<ResponseStructure<user>> find_mercahnt(@RequestParam String email,@RequestParam String password)
	{
		return u_service.find_user_by_email_password(email, password);
	}
	@GetMapping(value="/find_user_by_phone_password")
	public ResponseEntity<ResponseStructure<user>> find_mercahn(@RequestParam long phone,@RequestParam String password)
	{
		return u_service.find_user_by_phone_password(phone, password);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<Boolean>> delete_merchant(@PathVariable int id)
	{
		return u_service.delete_user(id);
	}
}