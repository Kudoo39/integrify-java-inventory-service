package com.example.exception.customException;

public class Conflict extends RuntimeException {
    Conflict(String message) {
        super(message);
    }
}