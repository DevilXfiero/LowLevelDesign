package ParkingLot.Pricing;

import ParkingLot.Ticket;

public interface PricingStrategy {
    public double calculatePrice(Ticket ticket);
}
