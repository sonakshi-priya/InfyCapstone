package com.simactivation.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.simactivation.Error.ErrorMessage;
import com.simactivation.Exception.SimCardNotValidatedException;

@RestControllerAdvice
@EnableWebMvc
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(SimCardNotValidatedException.class)
	public ResponseEntity<Object> simcardValidation(SimCardNotValidatedException e){
		
		ErrorMessage e1 = new ErrorMessage();

		
		e1.setStatusCode(HttpStatus.BAD_REQUEST.value());
		e.printStackTrace();
		e1.setMessage(e.getMessage());
		System.out.println("VALUE1");
		return ResponseEntity.badRequest().body(e1);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> simcardValidation(Exception e){
		
		ErrorMessage e1 = new ErrorMessage();

		
		e1.setStatusCode(HttpStatus.BAD_REQUEST.value());
		
		e1.setMessage(e.getMessage());
		
		e.printStackTrace();
		System.out.println("VALUE2");
		
		return ResponseEntity.badRequest().body(e1);
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> simcardValidation(MethodArgumentNotValidException e){
		
		ErrorMessage e1 = new ErrorMessage();
         e.printStackTrace();
		String bindMsg = "";
		for(ObjectError err:e.getAllErrors()) {
			  bindMsg += err.getDefaultMessage()+",";
		}
		e1.setStatusCode(HttpStatus.BAD_REQUEST.value());
		
		e1.setMessage(bindMsg);
		System.out.println("VALUE3");
		return ResponseEntity.badRequest().body(e1);
		
	}


}
