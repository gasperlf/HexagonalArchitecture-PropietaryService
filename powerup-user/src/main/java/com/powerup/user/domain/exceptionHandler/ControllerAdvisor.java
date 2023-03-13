package com.powerup.user.domain.exceptionHandler;

import com.powerup.user.domain.exception.EmptyInputException;
import com.powerup.user.domain.exception.RestaurantAlreadyExistsException;
import com.powerup.user.domain.exception.UserAlreadyExistException;
import com.powerup.user.domain.exception.UserDoNotExistException;

import feign.FeignException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "message";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }

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

    @ExceptionHandler(RestaurantAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            RestaurantAlreadyExistsException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, "Restaurant already exists"));
    }


}