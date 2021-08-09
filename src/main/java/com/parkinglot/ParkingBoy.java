package com.parkinglot;

import java.util.List;
import java.util.Optional;

public abstract class ParkingBoy {
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots){this.parkingLots = parkingLots;}

    public ParkingTicket park(Car car){
        return findSuitableParkingLot()
                .orElseThrow(() -> new ParkingException("No Available Position!"))
                .park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLots
                .stream()
                .findFirst()
                .get().fetch(parkingTicket);
    }

    abstract protected Optional<ParkingLot> findSuitableParkingLot();
}
