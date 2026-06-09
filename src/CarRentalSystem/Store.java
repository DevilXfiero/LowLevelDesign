package CarRentalSystem;

import CarRentalSystem.Bill.Bill;
import CarRentalSystem.Bill.BillManager;
import CarRentalSystem.Bill.BillingStrategy;
import CarRentalSystem.Reservation.Reservation;
import CarRentalSystem.Reservation.ReservationManager;
import CarRentalSystem.Reservation.ReservationRepository;
import CarRentalSystem.Reservation.ReservationType;

import java.time.LocalDate;
import java.util.List;

public class Store {
    int storeId;
    Location location;
    VehicleInventoryManager vehicleInventoryManager;
    ReservationManager reservationManager;
    BillManager billManager;
    CarRentalSystem.Payment payment;

    public Store(int storeId, Location location, VehicleInventoryManager vehicleInventoryManager, ReservationManager reservationManager) {
        this.storeId = storeId;
        this.location = location;
        this.vehicleInventoryManager = vehicleInventoryManager;
        this.reservationManager = reservationManager;
    }

    public List<Vehicle> getVehicles(VehicleType type, LocalDate from, LocalDate to) {
        return vehicleInventoryManager.getAvailableVehicles(type, from, to);
    }

    public Reservation createReservation(int vehicleId, User user, LocalDate from, LocalDate to, ReservationType type) {
        return  reservationManager.createReservation(vehicleId, user, from, to, type);
    }

    public void cancelReservation(int reservationId) {
        reservationManager.cancelReservation(reservationId);
    }

    public void startTrip(int reservationId) {
        reservationManager.startTrip(reservationId);
    }

    public void submitVehicle(int reservationId) {
        reservationManager.submitVehicle(reservationId);
    }

    public Bill generateBill(int reservationId, BillingStrategy billingStrategy) {
        Reservation reservation = reservationManager.getReservationById(reservationId).orElseThrow(() -> new RuntimeException("Reservation not found for id: " + reservationId));
        return billManager.generateBill(reservation);
    }

    public Payment makePayment(Bill bill) {
        return  payment.makePayment(bill);
    }



}
