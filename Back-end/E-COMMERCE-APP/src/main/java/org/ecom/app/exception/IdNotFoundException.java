package org.ecom.app.exception;

public class IdNotFoundException  extends RuntimeException{

	@Override
	public String getMessage() {
		
		return "Invalid ID Exceptiion";
		
	}
}
