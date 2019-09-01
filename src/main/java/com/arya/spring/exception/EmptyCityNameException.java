package com.arya.spring.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="City name is empty") //404
public class EmptyCityNameException extends Exception {

	private static final long serialVersionUID = -3332292346834265371L;

	public EmptyCityNameException(String errorMsg){
		super(errorMsg);
	}
}