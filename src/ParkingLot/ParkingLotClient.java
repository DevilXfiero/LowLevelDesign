package ParkingLot;

import ParkingLot.Payment.CashPayment;
import ParkingLot.Payment.UPIPayment;
import ParkingLot.Pricing.FixedPriceStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotClient {
    static void main() {
        ParkingSpotLookStrategy strategy = new FirstFreeLookupStrategy();

        Map<VehicleType, ParkingSpotManager> levelOneManagers = new HashMap<>();
        levelOneManagers.put(VehicleType.TWO_WHEELER,
                new TwoWheelerParkingSpotManager(List.of(new ParkingSpot("L1-S1"),
                        new ParkingSpot("L1-S2")), strategy));

        levelOneManagers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerParkingSpotManager(List.of(new ParkingSpot("L1-S3")), strategy));

        ParkingLevel level1 = new ParkingLevel(
                1, levelOneManagers
        );

        Map<VehicleType, ParkingSpotManager> levelTwoManagers = new HashMap<>();
        levelTwoManagers.put(VehicleType.TWO_WHEELER,
                new TwoWheelerParkingSpotManager(List.of(new ParkingSpot("L2-S1")), strategy));

        levelTwoManagers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerParkingSpotManager(List.of(new ParkingSpot("L2-S2"),
                        new ParkingSpot("L2-S3")), strategy));


        ParkingLevel level2 = new ParkingLevel(
                2, levelTwoManagers
        );

        ParkingBuilding parkingBuilding = new ParkingBuilding(List.of(level1, level2));

        ParkingLot parkingLot = new ParkingLot(
                parkingBuilding,
                new EntryGate(),
                new ExitGate(new FixedPriceStrategy()));



        Vehicle bike = new Vehicle("BIKE-101", VehicleType.TWO_WHEELER);
        Vehicle car = new Vehicle("CAR-201", VehicleType.FOUR_WHEELER);

        Ticket t1 = parkingLot.vehicleEntry(bike);
        Ticket t2 = parkingLot.vehicleEntry(car);

        parkingLot.vehicleExit(t1, new CashPayment());
        parkingLot.vehicleExit(t2, new UPIPayment());

    }
}
