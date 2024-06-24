package com.example.exception.customException;

public class BadRequest extends RuntimeException {
    public BadRequest(String message) {
        super(message);
    }
}