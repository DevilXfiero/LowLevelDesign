package CarRentalSystem.Reservation;

import java.time.LocalDate;

public class Reservation {
    int id;
    int vehicleId;
    int userId;
    LocalDate dateBookedFrom;
    LocalDate dateBookedTo;
    ReservationStatus reservationStatus;
    ReservationType reservationType;

    public Reservation(int reservationId, int vehicleId, int userId, LocalDate dateBookedFrom, LocalDate dateBookedTo, ReservationType reservationType) {
        this.id = reservationId;
        this.vehicleId = vehicleId;
        this.userId = userId;
        this.dateBookedFrom = dateBookedFrom;
        this.dateBookedTo = dateBookedTo;
        this.reservationStatus = ReservationStatus.SCHEDULED;
        this.reservationType = reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public LocalDate getDateBookedFrom() {
        return dateBookedFrom;
    }

    public void setDateBookedFrom(LocalDate dateBookedFrom) {
        this.dateBookedFrom = dateBookedFrom;
    }

    public LocalDate getDateBookedTo() {
        return dateBookedTo;
    }

    public void setDateBookedTo(LocalDate dateBookedTo) {
        this.dateBookedTo = dateBookedTo;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
}
