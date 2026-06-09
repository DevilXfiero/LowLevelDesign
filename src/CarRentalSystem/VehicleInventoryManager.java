package CarRentalSystem;

import CarRentalSystem.Reservation.Reservation;
import CarRentalSystem.Reservation.ReservationRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class VehicleInventoryManager {
    ConcurrentHashMap<Integer, Vehicle> vehicles;
    // BookingsList for vehicleId -> ReservationIds
    ConcurrentHashMap<Integer, List<Integer>> vehicleBookingList;
    ReservationRepository reservationRepository;


    public VehicleInventoryManager(ReservationRepository reservationRepository) {
        vehicles = new ConcurrentHashMap<>();
        this.reservationRepository = reservationRepository;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.id, vehicle);
    }

    public Vehicle getVehicleById(int vehicleId) {
        return vehicles.get(vehicleId);
    }



    public boolean isAvailable(int vehicleId, LocalDate from, LocalDate to) {
        List<Integer> reservationIds = vehicleBookingList.get(vehicleId);
        if(reservationIds == null || reservationIds.isEmpty()) {
            return true;
        }

        for(Integer reservationId: reservationIds) {
            Reservation reservation = reservationRepository.getReservation(reservationId).orElseThrow(() -> new RuntimeException("Reservation not found for id: " + reservationId));
            if(!(to.isBefore(reservation.getDateBookedFrom()) || from.isAfter(reservation.getDateBookedTo()))) {
                return false;
            }
        }
        return true;
    }

    public boolean reserve(int vehicleId, int reservationId, LocalDate from, LocalDate to) {

        if(!isAvailable(vehicleId, from, to)) {
            return false;
        }

        vehicleBookingList.putIfAbsent(vehicleId, new ArrayList<>());
        vehicleBookingList.get(vehicleId).add(reservationId);

        vehicles.get(vehicleId).status = VehicleStatus.BOOKED;

        return true;
    }

    public void release(int vehicleId, int reservationId) {

        List<Integer> ids = vehicleBookingList.get(vehicleId);
        if(ids != null) {
            ids.remove(Integer.valueOf(reservationId));
        }

        // still booked
        if(ids == null || ids.isEmpty()) {
            vehicles.get(vehicleId).status = VehicleStatus.AVAILABLE;
        }

    }

    public List<Vehicle> getAvailableVehicles(VehicleType type, LocalDate from, LocalDate to) {
        List<Vehicle> availableVehicles = vehicles.values().stream()
                .filter(v -> v.type == type)
                .filter(v -> isAvailable(v.id, from, to))
                .toList();

        return availableVehicles;
    }
}
