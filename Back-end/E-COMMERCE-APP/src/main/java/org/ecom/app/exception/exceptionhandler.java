package org.ecom.app.exception;

import org.ecom.app.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class exceptionhandler  extends ResponseEntityExceptionHandler{

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIIE(IdNotFoundException e)
	{
		ResponseStructure<String> str=new ResponseStructure<>();
		str.setMessage("Invalid Id");
		str.setData(e.getMessage());
		str.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(InvalidCredentilalsException.class)
	public ResponseEntity<ResponseStructure<String>> handleICE(InvalidCredentilalsException e)
	{
		ResponseStructure<String> str=new ResponseStructure<>();
		str.setData("Invalid credentials");
		str.setMessage(e.getMessage());
		str.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.NOT_FOUND);
	}
}
