package com.objectorientatedsystem.repository;

import com.objectorientatedsystem.model.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShowRepository {
    private final List<Show> shows = new ArrayList<>();

    public void addShow(Show show) {
        shows.add(show);
    }

    public Show getShowById(String showId) {
        Optional<Show> show = shows.stream()
                .filter(s -> s.getShowId().equals(showId))
                .findFirst();
        return show.orElse(null);
    }

    public List<Show> getAllShows() {
        return new ArrayList<>(shows);
    }

    public void updateShow(Show show) {
        Show existingShow = getShowById(show.getShowId());
        if (existingShow != null) {
            existingShow.setShowDate(show.getShowDate());
            existingShow.setAvailableSeats(show.getAvailableSeats());
        }
    }

    public void deleteShow(String showId) {
        shows.removeIf(show -> show.getShowId().equals(showId));
    }
}
