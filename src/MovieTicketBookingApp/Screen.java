package MovieTicketBookingApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Screen {
    int id;
    List<Seat> seats;
    Map<LocalDate, List<Show>> shows;

    public Screen(int id, List<Seat> seats) {
        this.id = id;
        this.seats = seats;
        this.shows = new HashMap<>();
    }

    public void addShow(Show show) {
        LocalDate showDate = show.showDate;
        if (!shows.containsKey(showDate)) {
            shows.put(showDate, new ArrayList<>());
        }
       shows.get(showDate).add(show);
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Show> getShowsByDate(LocalDate date) {
        return shows.getOrDefault(date, List.of());
    }
}
