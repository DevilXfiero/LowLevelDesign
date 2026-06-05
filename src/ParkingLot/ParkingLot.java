package ParkingLot;

import ParkingLot.Payment.Payment;

public class ParkingLot {
    ParkingBuilding building;
    EntryGate entryGate;
    ExitGate exitGate;

    public ParkingLot(ParkingBuilding building, EntryGate entryGate, ExitGate exitGate) {
        this.building = building;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
    }

    public Ticket vehicleEntry(Vehicle vehicle) {
        return entryGate.vehicleEntry(building, vehicle);
    }

    public void vehicleExit(Ticket ticket, Payment payment) {
        exitGate.vehicleExit(building, ticket, payment);
    }
}
