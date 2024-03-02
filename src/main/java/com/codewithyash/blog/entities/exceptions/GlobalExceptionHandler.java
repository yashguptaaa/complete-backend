package com.codewithyash.blog.entities.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codewithyash.blog.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
   
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity <ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String mssg=ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(mssg,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity <Map<String,String>> handleMethodArgsNotValiDException(MethodArgumentNotValidException ex){
		Map<String,String> response=new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach(error->{
			String fieldName = ((FieldError)error).getField();
			String message=error.getDefaultMessage();
			response.put(fieldName, message);
		});
		return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
	}
}