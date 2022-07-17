package com.micropatient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ResponseStatus annotation provide us the response status of controller methods.
 * If request return successfully then Spring provide HTTP 200 (OK) response otherwise it provide error message.
 * We can write our custom error message here by providing another parameter in @ResponseStatus. "@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Your error message"))"
 * 
 * RuntimeException is class for exception that can produce exception.
 * RuntimeException class extends Exception class.
 * @author POD4
 *
 */

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	/**
	 * serialVersionUID is a unique ID for each class.	
	 */
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
