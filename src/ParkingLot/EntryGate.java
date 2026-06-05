package ParkingLot;

public class EntryGate {

    public Ticket vehicleEntry(ParkingBuilding building, Vehicle vehicle) {
        Ticket ticket = building.allocateSpot(vehicle);
        return ticket;
    }
}
