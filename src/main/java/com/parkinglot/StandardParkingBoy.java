package com.parkinglot;

import java.util.List;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLots;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car){
        ParkingLot currentParkingLot = parkingLots
                .stream()
                .filter(parkingLot -> parkingLot.getCurrentCapacity() != 10)
                .findFirst()
                .orElseThrow(() -> new ParkingException("No Available Position!"));

        return currentParkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLots
                .stream()
                .findFirst()
                .get().fetch(parkingTicket);
    }
}
