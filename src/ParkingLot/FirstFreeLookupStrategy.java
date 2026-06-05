package ParkingLot;

import java.util.List;

public class FirstFreeLookupStrategy implements ParkingSpotLookStrategy{

    public ParkingSpot findSpot(List<ParkingSpot> parkingSpotList) {
        int randomIndex = (int) (Math.random() * parkingSpotList.size());
        return parkingSpotList.get(randomIndex);
    }
}
