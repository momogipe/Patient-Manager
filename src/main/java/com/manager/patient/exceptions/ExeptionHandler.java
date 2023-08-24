package com.manager.patient.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ExeptionHandler {
    @ExceptionHandler({PatientNotFoundException.class})
    ResponseEntity<ApiErreur> patientNotFound(PatientNotFoundException ex){
        return new ResponseEntity<>(new ApiErreur(400, ex.getMessage()), HttpStatus.NOT_FOUND);

    };
}
