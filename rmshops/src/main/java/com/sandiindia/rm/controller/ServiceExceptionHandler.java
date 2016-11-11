package com.sandiindia.rm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sandiindia.rm.exception.ShopServiceException;

@ControllerAdvice
@RestController
public class ServiceExceptionHandler {
	class ErrorResponse
	{
		public ErrorResponse(String code, String message)
		{
			errorCode = code;
			errorMessage = message;
		}
		public String errorCode;
		public String errorMessage;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ShopServiceException.class)
	@ResponseBody
	public ErrorResponse handleShopServiceException(ShopServiceException se)
	{
		ErrorResponse err = new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), se.getMessage());
		
		return err;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorResponse handleException(Exception e)
	{
		ErrorResponse err = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage());
		
		return err;
	}
	
}
