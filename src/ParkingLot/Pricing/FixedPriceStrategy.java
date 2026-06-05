package ParkingLot.Pricing;

import ParkingLot.Ticket;

public class FixedPriceStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(Ticket ticket) {
        return 100;
    }
}
