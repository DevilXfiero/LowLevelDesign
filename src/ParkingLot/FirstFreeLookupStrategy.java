package ParkingLot;

import java.util.List;

public class FirstFreeLookupStrategy implements ParkingSpotLookStrategy{

    public ParkingSpot findSpot(List<ParkingSpot> parkingSpotList) {
        for(ParkingSpot spot: parkingSpotList) {
            if(spot.isFree) {
                return spot;
            }
        }
        return null;
    }
}
