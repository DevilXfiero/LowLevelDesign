package CarRentalSystem.Bill;

import CarRentalSystem.Reservation.Reservation;

public interface BillingStrategy {
    public Bill generateBill(Reservation reservation);
}
