package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandller {
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> resourceHandller
            (ResourceNotFoundException resourceNotFoundException){
        ResourceException resourceException = new ResourceException(
                resourceNotFoundException.getMessage()
        );
        return new ResponseEntity<>(resourceException,HttpStatus.NOT_FOUND);
    }
}
