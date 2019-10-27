package com.product.myretail.exception;

import org.springframework.http.HttpStatus;

public class RetailAppGenericException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
		/**
		 * statuscode will be used to set the status code like 200,500
		 */
		private final HttpStatus statusCode;
		/**
		 * Set the exception errorMessage
		 */
		private final String errorMessage;
		
		public RetailAppGenericException(HttpStatus statusCode, String errorMessage) {
			super();
			this.statusCode = statusCode;
			this.errorMessage = errorMessage;
		}


		public HttpStatus getStatusCode() {
			return statusCode;
		}


		public String getErrorMessage() {
			return errorMessage;
		}


		@Override
		public String toString() {
			return "ProductNotFoundException [statusCode=" + statusCode + ", errorMessage=" + errorMessage + "]";
		}

		
		

}
