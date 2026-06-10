package MovieTicketBookingApp;


import java.util.List;

public class Booking {
    int id;
    Show show;
    User user;
    List<Integer> seats;
    Payment payment;

    public Booking(int id, Show show, User user, List<Integer> seats, Payment payment) {
        this.id = id;
        this.show = show;
        this.user = user;
        this.seats = seats;
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
