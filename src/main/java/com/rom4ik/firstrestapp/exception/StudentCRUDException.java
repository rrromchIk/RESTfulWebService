package com.rom4ik.firstrestapp.exception;

/**
 * @author rom4ik
 */
public class StudentCRUDException extends RuntimeException {
    public StudentCRUDException() {
    }

    public StudentCRUDException(String message) {
        super(message);
    }
}
