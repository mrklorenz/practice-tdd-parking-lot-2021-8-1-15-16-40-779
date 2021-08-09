package com.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    protected Optional<ParkingLot> findSuitableParkingLot() {
        return parkingLots
                .stream()
                .filter(parkingLot -> parkingLot.getCurrentCapacity() != 10)
                .max(Comparator.comparingInt(ParkingLot::getCurrentCapacity));
    }

}
