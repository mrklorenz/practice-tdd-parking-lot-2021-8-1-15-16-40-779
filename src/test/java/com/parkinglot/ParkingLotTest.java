package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {

    @Test
    void should_return_parkingTicket_when_park_given_parking_lot_and_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_car_when_fetch_given_parked_car_and_parking_lot(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);

        //when
        Car actualCar = parkingLot.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    void should_return_right_car_when_fetch_twice_given_two_parked_car_and_two_parking_tickets_and_parking_lot(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingTicket firstCarTicket = parkingLot.park(firstCar);
        ParkingTicket secondCarTicket = parkingLot.park(secondCar);

        //when
        Car actualFirstCar = parkingLot.fetch(firstCarTicket);
        Car actualSecondCar = parkingLot.fetch(secondCarTicket);

        //then
        assertEquals(firstCar, actualFirstCar);
        assertEquals(secondCar, actualSecondCar);
    }




}
