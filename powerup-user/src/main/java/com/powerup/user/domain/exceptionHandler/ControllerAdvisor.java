package com.powerup.user.domain.exceptionHandler;

import com.powerup.user.domain.exception.EmptyInputException;
import com.powerup.user.domain.exception.UserAlreadyExistException;
import com.powerup.user.domain.exception.UserDoNotExistException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "message";

//    @ExceptionHandler(NoDataFoundException.class)
//    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
//            NoDataFoundException ignoredNoDataFoundException) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
//    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            UserAlreadyExistException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, "User already exists"));
    }

    @ExceptionHandler(UserDoNotExistException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            UserDoNotExistException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, "User and password are not registered, check your credentials"));
    }

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {
        return new ResponseEntity<String>("Some fields may be empty, please check them all",HttpStatus.BAD_REQUEST);
    }

}