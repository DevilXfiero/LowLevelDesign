package CarRentalSystem.Bill;

import CarRentalSystem.Reservation.Reservation;
import CarRentalSystem.VehicleInventoryManager;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DailyBillingStrategy implements BillingStrategy {

    VehicleInventoryManager vehicleInventoryManager;

    private final AtomicInteger billIdGenerator = new AtomicInteger(5000);

    public DailyBillingStrategy(VehicleInventoryManager vehicleInventoryManager) {
        this.vehicleInventoryManager = vehicleInventoryManager;
    }

    @Override
    public Bill generateBill(Reservation reservation) {
        long days = ChronoUnit.DAYS.between(
                reservation.getDateBookedFrom(),
                reservation.getDateBookedTo()
        ) + 1;

        double dailyRate = vehicleInventoryManager.getVehicleById(reservation.getVehicleId()).getDailyRentalCost();

        double amount = days*dailyRate;

        Bill bill = new Bill(
                billIdGenerator.getAndIncrement(),
                reservation.getId(),
                amount
        );

        return bill;
    }
}
