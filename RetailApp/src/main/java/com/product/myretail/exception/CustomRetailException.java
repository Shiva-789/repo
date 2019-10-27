package com.product.myretail.exception;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.product.myretail.dto.ErrorMessageDTO;

@ControllerAdvice
public class CustomRetailException extends ResponseEntityExceptionHandler{
	
 
    @ExceptionHandler(RetailAppGenericException.class)
    public final ResponseEntity<Object> productNotFoundException(RetailAppGenericException ex, WebRequest request) {
    		ErrorMessageDTO errorMessage = new ErrorMessageDTO();
    		errorMessage.setErrorMessage(ex.getErrorMessage());
		return ResponseEntity.status(ex.getStatusCode()).contentType(MediaType.APPLICATION_JSON).body(errorMessage);

    }

}
