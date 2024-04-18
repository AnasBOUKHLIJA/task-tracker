package com.taskTracker.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDetails errorDetails = new ErrorDetails( status, ex.getMessage());
        return new ResponseEntity<>(errorDetails, status);
    }

    class ErrorDetails {
        
		private HttpStatus status;
        private String message;
        
        public ErrorDetails(HttpStatus status, String message) {
        	this.status = status;
        	this.message = message;
		}

		public HttpStatus getStatus() {
			return status;
		}
		public void setStatus(HttpStatus status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
    }
}
