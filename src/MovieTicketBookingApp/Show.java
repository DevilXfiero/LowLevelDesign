package MovieTicketBookingApp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Show {
    int id;
    Movie movie;
    LocalDate showDate;
    LocalTime showTime;
    Map<Integer, SeatStatus> seatStatusMap;
    Map<Integer, ReentrantLock> seatLocks;


    public Show(int id, Movie movie, Screen screen, LocalDate showDate, LocalTime showTime) {
        this.id = id;
        this.movie = movie;
        this.showDate = showDate;
        this.showTime = showTime;

        seatStatusMap = new HashMap<>();
        seatLocks = new HashMap<>();
        for(Seat seat: screen.getSeats()) {
            seatStatusMap.put(seat.id, SeatStatus.AVAILABLE);
            seatLocks.put(seat.id, new ReentrantLock());
        }
    }

    public boolean lockSeats(List<Integer> seatIds) {

        // sort seatIds to prevent deadlock condition
        List<Integer> sortedSeatIds = new ArrayList<>(seatIds);
        Collections.sort(sortedSeatIds);
        List<ReentrantLock> acquiredLocks = new ArrayList<>();

        try {

            // Lock the requested seats
            for(Integer seatId: sortedSeatIds) {
                ReentrantLock lock = seatLocks.get(seatId);
                lock.lock();
                acquiredLocks.add(lock);
            }

            // Validate if all seats are available after acquiring lock
            for (Integer seatId: sortedSeatIds) {
                if(seatStatusMap.get(seatId) != SeatStatus.AVAILABLE) {
                    return false;
                }
            }

            // mark locked
            for(Integer seatId: sortedSeatIds) {
                // want to lock seats for few mins for particular request
                seatStatusMap.put(seatId, SeatStatus.LOCKED);
            }

            return true;
        } finally {
            // release locks
            for(ReentrantLock lock: acquiredLocks) {
                lock.unlock();
            }
        }
    }

    public void confirmSeats(List<Integer> seatIds) {
       for(Integer seatId: seatIds) {
           seatStatusMap.put(seatId, SeatStatus.BOOKED);
       }
    }

    public void releaseSeats(List<Integer> seatIds) {
        for(Integer seatId: seatIds) {
            seatStatusMap.put(seatId, SeatStatus.AVAILABLE);
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }
}
