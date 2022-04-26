package com.drone.droneTechnology.exception;

import com.drone.droneTechnology.model.ErrorRepresentation;
import com.drone.droneTechnology.utils.ExceptionsUtils;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@AllArgsConstructor
public class DroneExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorRepresentation> handleAccessException(DataAccessException ex) {
        ErrorRepresentation errorRepresentation = ErrorRepresentation.builder()
                .reason(ExceptionsUtils.ACCESS_EXCEPTION_MESSAGE)
                .status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        return new ResponseEntity<ErrorRepresentation>(errorRepresentation, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorRepresentation>> handleArgumentException(MethodArgumentNotValidException ex) {
        final List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        final List<ErrorRepresentation> customFieldErrors = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            final String message = fieldError.getDefaultMessage();

            final ErrorRepresentation customFieldError = ErrorRepresentation.builder()
                                                     .reason(message)
                                                     .status(HttpStatus.INTERNAL_SERVER_ERROR).build();

            customFieldErrors.add(customFieldError);
        }

        return new ResponseEntity<List<ErrorRepresentation>>(customFieldErrors, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
