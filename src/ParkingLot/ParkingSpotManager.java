package ParkingLot;

public interface ParkingSpotManager {
    public ParkingSpot park();
    public void unPark(ParkingSpot spot);
    public boolean hasFreeSpot();
}
