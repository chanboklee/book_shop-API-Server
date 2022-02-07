package com.book.shop.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionAdvice {

	@ExceptionHandler({ ApiException.class })
	public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final ApiException e){
		
		return ResponseEntity.status(e.getError().getStatus())
							 .body(new ApiExceptionEntity(e.getError().getCode()
									 					 ,e.getError().getMessage()));
							 
	}
	
	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final RuntimeException e){
		
		return ResponseEntity.status(ExceptionEnum.RUN_TIME_EXCEPTION.getStatus())
							 .body(new ApiExceptionEntity(ExceptionEnum.RUN_TIME_EXCEPTION.getCode()
									 					 ,e.getMessage()));
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final Exception e){
		
		return ResponseEntity.status(ExceptionEnum.INTERNAL_SERVER_ERROR.getStatus())
							 .body(new ApiExceptionEntity(ExceptionEnum.INTERNAL_SERVER_ERROR.getCode()
									 					 ,e.getMessage()));
	}
	
	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<ApiExceptionEntity> methodValidException(HttpServletRequest request, final MethodArgumentNotValidException e){
		
		return ResponseEntity.status(ExceptionEnum.NOT_BLANK.getStatus())
							 .body(new ApiExceptionEntity(ExceptionEnum.NOT_BLANK.getCode()
									 					 ,e.getBindingResult().getFieldError().getDefaultMessage()));
	}
}
