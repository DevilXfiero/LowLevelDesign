package CarRentalSystem.Bill;

import CarRentalSystem.Reservation.Reservation;

import java.util.concurrent.ConcurrentHashMap;

public class BillManager {
    ConcurrentHashMap<Integer, Bill> bills;
    BillingStrategy billingStrategy;

    public BillManager(BillingStrategy billingStrategy) {
        this.bills = new ConcurrentHashMap<>();
        this.billingStrategy = billingStrategy;
    }

    public Bill generateBill(Reservation reservation) {
        Bill bill = billingStrategy.generateBill(reservation);
        bills.put(bill.getId(), bill);
        return bill;
    }
}
