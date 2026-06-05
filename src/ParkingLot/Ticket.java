package ParkingLot;

import java.time.Instant;


public class Ticket {
    String ticketNumber;
    Vehicle vehicle;
    ParkingSpot parkingSpot;
    ParkingLevel parkingLevel;
    Instant entryTime;


    public Ticket(Vehicle vehicle,ParkingLevel parkingLevel, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.parkingLevel = parkingLevel;
        this.entryTime = Instant.now();
    }

    public Instant getEntryTime() {
        return entryTime;
    }
}
