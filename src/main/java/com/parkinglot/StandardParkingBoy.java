package com.parkinglot;

import java.util.List;
import java.util.Optional;

public class StandardParkingBoy extends ParkingBoy{

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    protected Optional<ParkingLot> findSuitableParkingLot() {
        return parkingLots
                .stream()
                .filter(parkingLot -> parkingLot.getCurrentCapacity() != 10)
                .findFirst();
    }
}
