package com.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.task.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundHandlerMethod(ResourceNotFoundException ex)
	{
		String msg = ex.getMessage();
		ApiResponse api = new ApiResponse(msg,false);
		return new ResponseEntity<ApiResponse>(api, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadCredentials.class)
	public ResponseEntity<ApiResponse> BadcredentialsHandlerMethod(BadCredentials ex)
	{
		String msg = ex.getMessage();
		ApiResponse api = new ApiResponse(msg,false);
		return new ResponseEntity<ApiResponse>(api, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiResponse> handleApiException(ApiException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, true);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
	}
}
