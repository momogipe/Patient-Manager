package com.manager.patient.exceptions;

public class PatientNotFoundException extends Throwable {
    public PatientNotFoundException(String message) {
        super(message);
    }
}
