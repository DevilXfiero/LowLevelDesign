package ParkingLot;

import java.util.List;

public interface ParkingSpotLookStrategy {
    ParkingSpot findSpot(List<ParkingSpot> parkingSpotList);
}
