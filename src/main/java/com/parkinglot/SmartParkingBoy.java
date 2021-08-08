package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        return parkingLots.get(0).park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return null;
    }
}
