package ParkingLot;

import java.util.List;

public class FourWheelerParkingSpotManager implements ParkingSpotManager {

    List<ParkingSpot> parkingSpots;
    ParkingSpotLookStrategy parkingSpotLookupStrategy;

    public FourWheelerParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingSpotLookStrategy parkingSpotLookupStrategy) {
        this.parkingSpots = parkingSpots;
        this.parkingSpotLookupStrategy = parkingSpotLookupStrategy;
    }

    @Override
    public ParkingSpot park() {
        ParkingSpot spot = parkingSpotLookupStrategy.findSpot(parkingSpots);
        spot.occupySpot();
        return spot;
    }

    @Override
    public void unPark(ParkingSpot spot) {
        spot.freeSpot();
        return;
    }

    @Override
    public boolean hasFreeSpot() {
        for(ParkingSpot parkingSpot: parkingSpots) {;
            if(parkingSpot.isFree) {
                return true;
            }
        }
        return false;
    }
}
