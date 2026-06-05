package ParkingLot.Pricing;

import ParkingLot.Ticket;

import java.time.Duration;
import java.time.Instant;

public class HourlyPriceStrategy implements PricingStrategy{
    private static final double PRICE_PER_HOUR = 5.0;

    @Override
    public double calculatePrice(Ticket ticket) {

        Duration duration = Duration.between(ticket.getEntryTime(), Instant.now());

        long seconds = duration.getSeconds();
        long hours = (seconds + 3599) / 3600;

        return hours * PRICE_PER_HOUR;
    }
}
