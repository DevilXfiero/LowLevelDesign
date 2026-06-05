package ParkingLot;

import java.util.List;

public class TwoWheelerParkingSpotManager implements ParkingSpotManager {
    List<ParkingSpot> parkingSpots;
    ParkingSpotLookStrategy parkingSpotStrategy;

    public TwoWheelerParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingSpotLookStrategy parkingSpotStrategy) {
        this.parkingSpots = parkingSpots;
        this.parkingSpotStrategy = parkingSpotStrategy;
    }

    @Override
    public ParkingSpot park() {
        ParkingSpot spot = parkingSpotStrategy.findSpot(parkingSpots);
        spot.occupySpot();
        return spot;
    }

    @Override
    public void unPark(ParkingSpot spot) {
        spot.freeSpot();
    }

    @Override
    public boolean hasFreeSpot() {
        for(ParkingSpot parkingSpot: parkingSpots) {
            if(parkingSpot.isFree) {
                return true;
            }
        }
        return false;
    }
}
