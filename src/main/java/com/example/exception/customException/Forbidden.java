package com.example.exception.customException;

public class Forbidden extends RuntimeException {
    Forbidden(String message) {
        super(message);
    }
}

