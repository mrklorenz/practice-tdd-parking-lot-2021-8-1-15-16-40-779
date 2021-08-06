#Story 1

[1] Given Car
    When Park
    Then return Parking Ticket

[2] Given Parking Ticket
    When Fetch
    Then Return Car

[3] Given Wrong Parking Ticket (Empty Ticket)
    When Fetch
    Then Return Nothing.

[4] Given Existing Parking Ticket
    When Fetch
    Then Return Nothing.

[5] Given Full Parking Lot
    When Park
    Then Return Nothing.

[6] Given Existing Car
    When Park
    Then Return Nothing.

[7] Given Null Car
    When Park
    Then Throw NullPointerException

[8] Given Null Parking Ticket
    When Fetch
    Then Throw NullPointer

    
