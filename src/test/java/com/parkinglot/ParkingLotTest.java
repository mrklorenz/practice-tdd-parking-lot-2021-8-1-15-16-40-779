package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_throw_exception_when_fetch_given_parking_lot_and_wrong_parking_ticket() throws ParkingException {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket();

        //then
        ParkingException exception = assertThrows(ParkingException.class, () -> parkingLot.fetch(parkingTicket));
        assertEquals(exception.getMessage(), "Unrecognized Parking Ticket!");
    }

    @Test
    void should_throw_exception_when_fetch_given_parking_lot_and_used_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        parkingLot.fetch(parkingTicket);

        //when
        ParkingException exception = assertThrows(ParkingException.class, () -> parkingLot.fetch(parkingTicket));
        assertEquals(exception.getMessage(), "Unrecognized Parking Ticket!");
    }

    @Test
    void should_return_null_when_park_given_full_parking_lot_and_car(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();

        //then
        ParkingException exception = assertThrows(ParkingException.class, () -> parkingLot.park(car));
        assertEquals(exception.getMessage(), "No Available Position!");
    }


    @Test
    void should_return_parkingTicket_when_park_given_parking_boy_parking_lot_and_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //
        assertNotNull(parkingTicket);
    }
}
