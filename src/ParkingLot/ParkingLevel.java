package ParkingLot;

import java.util.Map;

public class ParkingLevel {
    int levelNumber;
    Map<VehicleType, ParkingSpotManager> managers;

    public ParkingLevel(int levelNumber, Map<VehicleType, ParkingSpotManager> managers) {
        this.levelNumber = levelNumber;
        this.managers = managers;
    }

    public ParkingSpot allocateSpot(Vehicle vehicle) {
        ParkingSpotManager parkingSpotManager = managers.get(vehicle.type);
        if(parkingSpotManager == null) {
            throw new IllegalArgumentException("No available managers for vehicleType: " + vehicle.type);
        }
        ParkingSpot spot = parkingSpotManager.park();
        return spot;
    }

    public void releaseSpot(Vehicle vehicle, ParkingSpot spot) {
        ParkingSpotManager parkingSpotManager = managers.get(vehicle.type);
        parkingSpotManager.unPark(spot);
    }

    public boolean hasAvailability(VehicleType vehicleType) {
        ParkingSpotManager manager = managers.get(vehicleType);
        return  manager.hasFreeSpot();
    }
}
