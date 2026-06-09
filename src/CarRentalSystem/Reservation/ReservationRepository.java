package CarRentalSystem.Reservation;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ReservationRepository {
    ConcurrentHashMap<Integer, Reservation> reservations;

    public ReservationRepository() {
        this.reservations = new ConcurrentHashMap<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.put(reservation.id, reservation);
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return Optional.of(reservations.get(reservationId));
    }


}
