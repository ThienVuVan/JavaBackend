package com.springbootsummary.common.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> CatchError(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> CatchErrorRunTime(RuntimeException e){
        return new ResponseEntity<>(e.getMessage() + "runtime", HttpStatus.BAD_REQUEST);
    }
}
