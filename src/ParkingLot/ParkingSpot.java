package ParkingLot;

import java.util.UUID;

public class ParkingSpot {
    String spotId;
    boolean isFree;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
        this.isFree = Boolean.TRUE;
    }

    public void occupySpot() {
        this.isFree = Boolean.FALSE;
    }

    public void freeSpot() {
        this.isFree = Boolean.TRUE;
    }
}
