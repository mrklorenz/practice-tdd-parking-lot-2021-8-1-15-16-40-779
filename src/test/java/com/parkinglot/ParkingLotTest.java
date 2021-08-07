package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    void should_throw_exception_when_fetch_given_parking_lot_and_wrong_parking_ticket(){
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
    void should_return_parkingTicket_when_park_given_standard_parking_boy_parking_lot_and_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_car_when_fetch_given_standard_parking_boy_parking_lot_and_parking_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //when
        Car actualCar = parkingBoy.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    void should_return_right_car_when_fetch_twice_given_two_parked_car_and_two_parking_tickets_and_parking_lot_and_standard_parking_boy(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car firstCar = new Car();
        Car secondCar = new Car();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
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
    void should_throw_exception_when_fetch_given_parking_lot_and_wrong_parking_ticket_and_standard_parking_boy(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);

        //then
        ParkingException exception = assertThrows(ParkingException.class, () -> parkingBoy.fetch(parkingTicket));
        assertEquals(exception.getMessage(), "Unrecognized Parking Ticket!");
    }

    @Test
    void should_throw_exception_when_fetch_given_parking_lot_and_used_ticket_and_standard_parking_boy(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket parkingTicket = parkingBoy.park(car);
        parkingBoy.fetch(parkingTicket);

        //when
        ParkingException exception = assertThrows(ParkingException.class, () -> parkingBoy.fetch(parkingTicket));
        assertEquals(exception.getMessage(), "Unrecognized Parking Ticket!");
    }

    @Test
    void should_throw_exception_when_park_given_full_parking_lot_and_car_and_standard_parking_boy(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //then
        ParkingException exception = assertThrows(ParkingException.class, () -> parkingBoy.park(car));
        assertEquals(exception.getMessage(), "No Available Position!");
    }

    @Test
    void should_return_first_parking_lot_when_park_given_2_parking_lots_car_and_parking_boy(){
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        Car car = new Car();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
        assertEquals(parkingLots.get(0).fetch(parkingTicket), car);
    }


}
