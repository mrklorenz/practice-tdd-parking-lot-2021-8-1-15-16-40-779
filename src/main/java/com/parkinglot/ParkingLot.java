package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int currentCapacity;
    private int totalCapacity;
    private final Map<ParkingTicket, Car> parkedPosition = new HashMap<>();

    public ParkingLot(int capacity, int totalCapacity) {
        this.currentCapacity = capacity;
        this.totalCapacity = totalCapacity;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        if(currentCapacity == getTotalCapacity()) throw new ParkingException("No Available Position!");
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

    public int getTotalCapacity() {
        return this.totalCapacity;
    }
}
