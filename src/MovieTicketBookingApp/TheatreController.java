package MovieTicketBookingApp;

import java.time.LocalDate;
import java.util.*;

public class TheatreController {

    Map<City, List<Theatre>> theatresByCity;

    public TheatreController() {
        this.theatresByCity = new HashMap<>();
    }

    public void  addTheatre(Theatre theatre) {
        City city = theatre.getCity();
        if(!theatresByCity.containsKey(city)) {
            theatresByCity.put(city, new ArrayList<>());
        }
        theatresByCity.get(city).add(theatre);
    }

    public Set<Movie> getMovies(City city, LocalDate date) {
        Set<Movie> movies = new HashSet<>();
        List<Theatre> theatres = theatresByCity.getOrDefault(city, List.of());

        for (Theatre theatre : theatres) {
            for (Screen screen : theatre.getScreens()) {
                for (Show show : screen.getShowsByDate(date)) {
                    movies.add(show.getMovie());
                }
            }
        }
        return movies;
    }

    public List<Theatre> getTheatresByCity(City city) {
        if(!theatresByCity.containsKey(city)) {
            throw new RuntimeException("No theatres found for the city : " + city);
        }

        return theatresByCity.get(city);
    }

    public List<Theatre> getTheatres(City city, Movie movie, LocalDate date) {
        List<Theatre> theatres = theatresByCity.getOrDefault(city, List.of());

        return theatres.stream()
                .filter(t -> t.getScreens().stream()
                        .anyMatch(s -> s.getShowsByDate(date).stream()
                                .anyMatch(show -> show.getMovie().equals(movie))))
                .toList();
    }

    public List<Show> getShows(Movie movie, LocalDate date, Theatre theatre) {
        List<Show> result = new ArrayList<>();

        for (Screen screen : theatre.getScreens()) {
            for (Show show : screen.getShowsByDate(date)) {
                if (show.getMovie().equals(movie)) {
                    result.add(show);
                }
            }
        }
        return result;
    }
}


