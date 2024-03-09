package org.ecom.app.dto;

public class ResponseStructure<t> {

	private String message;
	private t data;
	private int statuscode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public t getData() {
		return data;
	}

	public void setData(t data) {
		this.data = data;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

}
