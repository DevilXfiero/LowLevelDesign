package ParkingLot;

import java.util.List;

public class ParkingBuilding {
    List<ParkingLevel> parkingLevels;

    public ParkingBuilding(List<ParkingLevel> parkingLevels) {
        this.parkingLevels = parkingLevels;
    }

    public Ticket allocateSpot(Vehicle vehicle) {

        for(ParkingLevel parkingLevel: parkingLevels) {
            if(parkingLevel.hasAvailability(vehicle.type)) {
                ParkingSpot spot = parkingLevel.allocateSpot(vehicle);
                Ticket ticket = new Ticket(vehicle, parkingLevel, spot);
                System.out.println("Allocated parking spot: " + spot.spotId + " for vehicle: " + vehicle.vehicleNumber);
                return ticket;
            }
        }

        throw new RuntimeException("Parking Full");
    }

    public void releaseSpot(Ticket ticket) {
        ticket.parkingLevel.releaseSpot(ticket.vehicle, ticket.parkingSpot);
        System.out.println("Released parking spot: " + ticket.parkingSpot.spotId + " for vehicle: " + ticket.vehicle.vehicleNumber);
    }
}
