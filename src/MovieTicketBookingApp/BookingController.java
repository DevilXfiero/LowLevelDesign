package MovieTicketBookingApp;


import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingController {
    Map<Integer, Booking> bookings;

    public BookingController() {
        this.bookings = new HashMap<>();
    }

    public Booking createBooking(Show show, User user, List<Integer> seatIds) {
        if(!show.lockSeats(seatIds)) {
            throw new RuntimeException("Seats are not available for the show : " + show.id);
        }

        Payment payment = new Payment(PaymentStatus.SUCCESS);

        if(payment.getStatus() == PaymentStatus.SUCCESS) {
            show.confirmSeats(seatIds);
            Booking booking = new Booking(bookings.size() + 1, show, user, seatIds, payment);
            bookings.put(booking.id, booking);
            return booking;
        } else {
            show.releaseSeats(seatIds);
            throw new RuntimeException("Payment failed for the booking");
        }

    }

    public Booking getBookingById(int bookingId) {
        return bookings.get(bookingId);
    }

    public List<Booking> getBookingsByUser(User user) {
        return bookings.values().stream().filter(booking -> booking.user.equals(user)).toList();
    }

     public void cancelBooking(int bookingId) {
        Booking booking = bookings.get(bookingId);
        if(booking == null) {
            throw new RuntimeException("Booking not found for id: " + bookingId);
        }
        booking.show.releaseSeats(booking.seats);
        bookings.remove(bookingId);
    }


}
