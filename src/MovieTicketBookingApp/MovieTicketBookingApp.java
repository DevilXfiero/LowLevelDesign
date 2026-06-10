package MovieTicketBookingApp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public class MovieTicketBookingApp {
    TheatreController theatreController = new TheatreController();
    BookingController bookingController = new BookingController();

    static void main() {
       MovieTicketBookingApp movieTicketBookingApp = new MovieTicketBookingApp();
       movieTicketBookingApp.initialize();
       movieTicketBookingApp.userFlow();
    }

    public void initialize() {
        Movie m1 = new Movie(1, "Avengers", 120);
        Movie m2 = new Movie(2, "Inception", 150);

        List<Seat> seats = List.of(new Seat(1, SeatCategory.SILVER), new Seat(2, SeatCategory.SILVER), new Seat(3, SeatCategory.GOLD), new Seat(4, SeatCategory.PLATINUM));

        Screen screen1 = new Screen(1, seats);
        Theatre theatre1 = new Theatre("IMAX", City.GHAZIABAD, List.of(screen1));

        Screen screen2 = new Screen(2, seats);
        Theatre theatre2 = new Theatre("PVR", City.GURUGRAM, List.of(screen1, screen2));


        Show show1 = new Show(1, m1, screen1, LocalDate.now(), LocalTime.of(18, 0));
        Show show2 = new Show(2, m2, screen2, LocalDate.now(), LocalTime.of(21, 0));
        Show show3 = new Show(3, m1, screen2, LocalDate.now(), LocalTime.of(18, 0));

        screen1.addShow(show1);
        screen2.addShow(show2);
        screen2.addShow(show3);


        theatreController.addTheatre(theatre1);
        theatreController.addTheatre(theatre2);
    }

    public void userFlow() {
        User user = new User(1, "DevilXfiero");

        City selectedCity = City.GURUGRAM;

        LocalDate selectedDate = LocalDate.now();

        Set<Movie> movies = theatreController.getMovies(selectedCity, selectedDate);
        System.out.println("Movies available:");
        movies.forEach(m -> System.out.println(" - " + m.getName()));

        Movie selectedMovie = movies.iterator().next();


        List<Theatre> theatres = theatreController.getTheatres(selectedCity, selectedMovie, selectedDate);
        System.out.println("Theatres available:");
        theatres.forEach(t -> System.out.println(" - " + t.getName()));

        Theatre selectedTheatre = theatres.get(0);

        List<Show> shows = theatreController.getShows(selectedMovie, selectedDate, selectedTheatre);
        System.out.println("Shows available:");
        shows.forEach(s -> System.out.println(" - " + s.getShowTime()));

        // 8. User selects show
        Show selectedShow = shows.get(0);
        System.out.println("Selected Show Time: " + selectedShow.getShowTime());

        // 9. User selects seats
        List<Integer> selectedSeats = List.of(1, 2, 3);
        System.out.println("Selected Seats: " + selectedSeats);

        // 10. Booking + Payment
        Booking booking =
                bookingController.createBooking(
                        selectedShow,
                        user,
                        selectedSeats
                );

        System.out.println("BOOKING SUCCESSFUL");
        System.out.println("Booking ID: " + booking.getId());

    }

}
