package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int currentCapacity;
    private final Map<ParkingTicket, Car> parkedPosition = new HashMap<>();

    public ParkingLot(){}

    public ParkingLot(int capacity) {
        this.currentCapacity = capacity;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        int fullCapacity = 10;
        if(currentCapacity == fullCapacity) throw new ParkingException("No Available Position!");
        this.parkedPosition.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket){
        Car car = this.parkedPosition.get(parkingTicket);
        if(car == null){
            throw new ParkingException("Unrecognized Parking Ticket!");
        }
        parkedPosition.remove(parkingTicket);
        return car;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }
}
