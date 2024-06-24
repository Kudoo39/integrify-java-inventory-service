package com.example.exception.customException;

public class Unauthorized extends RuntimeException {
    Unauthorized(String message) {
        super(message);
    }
}
