## Story 1

[1] Given ***Car*** & ***Parking Lot***
    When ***Park***
    Then return ***Parking Ticket***

[2] Given Parking Ticket
    When Fetch
    Then Return Car

[3] Given Wrong Parking Ticket (Empty Ticket)
    When Fetch
    Then Return Nothing.

[4] Given Existing Parking Ticket
    When Fetch
    Then Return Nothing.

[5] Given Full Parking Lot and Car
    When Park
    Then Return Nothing.

[6] Given Existing Car and Parking Lot
    When Park
    Then Return Nothing.

## Story 2

[1] Given Used/Wrong Parking Ticket
    When Fetch
    Then Throw UnrecognizedParkingTicketException

[2] Given Car and Full Parking Lot
    When Fetch
    Then Throw NoAvailablePositionException

    
