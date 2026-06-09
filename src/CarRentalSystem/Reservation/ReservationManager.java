package CarRentalSystem.Reservation;

import CarRentalSystem.User;
import CarRentalSystem.Vehicle;
import CarRentalSystem.VehicleInventoryManager;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationManager {

    VehicleInventoryManager vehicleInventoryManager;
    ReservationRepository reservationRepository;
    public final AtomicInteger reservationGenerate = new AtomicInteger(10000);

    public ReservationManager(VehicleInventoryManager vehicleInventoryManager, ReservationRepository reservationRepository) {
        this.vehicleInventoryManager = vehicleInventoryManager;
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(int vehicleId, User user, LocalDate from, LocalDate to, ReservationType type) {
        int reservationId = reservationGenerate.getAndIncrement();
        boolean reserved = vehicleInventoryManager.reserve(vehicleId, reservationId, from, to);

        if(!reserved) {
            throw new RuntimeException("Vehicle not available for selected dates");
        }

        Reservation  reservation = new Reservation(reservationId, vehicleId, user.getId(), from, to, type);
        reservationRepository.addReservation(reservation);

        return reservation;
    }



    public void cancelReservation(int reservationId) {

        Optional<Reservation> resOptional = reservationRepository.getReservation(reservationId);

        if(!resOptional.isPresent())  {
            throw new RuntimeException("Reservation not found for id: " + reservationId);
        }

        Reservation reservation = resOptional.get();

        vehicleInventoryManager.release(reservation.vehicleId, reservation.id);
        reservation.setReservationStatus(ReservationStatus.CANCELLED);
    }

    public void startTrip(int reservationId) {
        Reservation reservation = reservationRepository.getReservation(reservationId).orElseThrow(() -> new RuntimeException("Reservation not found for id: " + reservationId));
        reservation.setReservationStatus(ReservationStatus.IN_USE);
    }

    public void submitVehicle(int reservationId) {
        Reservation reservation = reservationRepository.getReservation(reservationId).orElseThrow(() -> new RuntimeException("Reservation not found for id: " + reservationId));
        reservation.setReservationStatus(ReservationStatus.COMPLETED);

        vehicleInventoryManager.release(reservation.vehicleId, reservation.id);
    }

    public Optional<Reservation> getReservationById(int reservationId) {
        return reservationRepository.getReservation(reservationId);
    }



}
