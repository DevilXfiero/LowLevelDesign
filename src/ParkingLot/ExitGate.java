package ParkingLot;

import ParkingLot.Payment.Payment;
import ParkingLot.Pricing.PricingStrategy;

public class ExitGate {
    PricingStrategy pricingStrategy;

    public ExitGate(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void vehicleExit(ParkingBuilding building, Ticket ticket, Payment payment) {
        double price = pricingStrategy.calculatePrice(ticket);

        boolean success = payment.pay(price);
        if(!success) {
            throw new RuntimeException("Payment failed");
        }

        building.releaseSpot(ticket);
    }

}
