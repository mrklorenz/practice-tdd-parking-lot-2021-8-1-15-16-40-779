package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {

    @Test
    void should_return_parkingTicket_when_park_given_2_parking_lot_and_car_smart_parkingboy(){
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = smartParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_car_when_fetch_given_smart_parking_boy_parking_lot_and_parking_ticket() {
        //given
        ParkingLot firstParkingLot  = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //when
        Car actualCar = parkingBoy.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    void should_return_right_car_when_fetch_twice_given_two_parked_car_and_two_parking_tickets_and_parking_lot_and_smart_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Car secondCar = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        ParkingTicket firstCarTicket = parkingBoy.park(firstCar);
        ParkingTicket secondCarTicket = parkingBoy.park(secondCar);

        //when
        Car actualFirstCar = parkingLot.fetch(firstCarTicket);
        Car actualSecondCar = parkingLot.fetch(secondCarTicket);

        //then
        assertEquals(firstCar, actualFirstCar);
        assertEquals(secondCar, actualSecondCar);
    }

    @Test
    void should_throw_exception_when_fetch_given_parking_lot_and_wrong_parking_ticket_and_standard_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingTicket parkingTicket = new ParkingTicket();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);

        //then
        ParkingException exception = assertThrows(ParkingException.class, () -> parkingBoy.fetch(parkingTicket));
        assertEquals(exception.getMessage(), "Unrecognized Parking Ticket!");
    }

    @Test
    void should_throw_exception_when_fetch_given_parking_lot_and_used_ticket_and_standard_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        ParkingTicket parkingTicket = parkingBoy.park(car);
        parkingBoy.fetch(parkingTicket);

        //when
        ParkingException exception = assertThrows(ParkingException.class, () -> parkingBoy.fetch(parkingTicket));
        assertEquals(exception.getMessage(), "Unrecognized Parking Ticket!");
    }

    






}