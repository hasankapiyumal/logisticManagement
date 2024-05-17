package com.zaviron.ejb.exception;

public class CargoNotFoundException extends RuntimeException{
    public CargoNotFoundException(String message) {
        super(message);
    }
}
