package com.parkinglot;

public class ParkingException extends RuntimeException{

    public ParkingException(String message){
        super(message);
    }

    public ParkingException() {
    }
}
