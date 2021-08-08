package com.parkinglot;

import java.util.List;

public class SmartParkingBoy extends StandardParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);;
    }

    public ParkingTicket park(Car car) {
        return parkingLots.get(0).park(car);
    }
}
