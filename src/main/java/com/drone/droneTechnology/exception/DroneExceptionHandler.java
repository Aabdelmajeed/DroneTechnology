package com.drone.droneTechnology.exception;

import com.drone.droneTechnology.model.ErrorRepresentation;
import com.drone.droneTechnology.utils.ExceptionsUtils;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@AllArgsConstructor
public class DroneExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorRepresentation> handleAccessException(Exception ex) {
        ErrorRepresentation errorRepresentation = ErrorRepresentation.builder()
                .reason(ExceptionsUtils.ACCESS_EXCEPTION_MESSAGE)
                .status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        return new ResponseEntity<ErrorRepresentation>(errorRepresentation, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
