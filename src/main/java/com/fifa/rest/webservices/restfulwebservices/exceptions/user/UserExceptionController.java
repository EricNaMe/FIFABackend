package com.fifa.rest.webservices.restfulwebservices.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exceptionUserNotFound(UserNotFoundException exception) {
		return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserWrongPassword.class)
	public ResponseEntity<Object> exceptionWrongPassword(UserWrongPassword exception) {
		return new ResponseEntity<>("Wrong password", HttpStatus.UNAUTHORIZED);
	}
	

	@ExceptionHandler(value = UserErrorCreatingNewUserException.class)
	public ResponseEntity<Object> exceptionCreatingUser(UserErrorCreatingNewUserException exception) {
		return new ResponseEntity<>("Error creating user", HttpStatus.EXPECTATION_FAILED);
	}
	
	
	

}
