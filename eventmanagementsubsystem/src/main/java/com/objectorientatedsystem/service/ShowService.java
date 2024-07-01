package com.objectorientatedsystem.service;

import com.objectorientatedsystem.model.Show;
import com.objectorientatedsystem.repository.ShowRepository;

import java.util.List;

public class ShowService {
    private final ShowRepository showRepository;

    public ShowService() {
        this.showRepository = new ShowRepository();
    }

    public void createShow(Show show) {
        showRepository.addShow(show);
    }

    public Show getShowById(String showId) {
        return showRepository.getShowById(showId);
    }

    public List<Show> getAllShows() {
        return showRepository.getAllShows();
    }

    public void updateShow(Show show) {
        showRepository.updateShow(show);
    }

    public void deleteShow(String showId) {
        showRepository.deleteShow(showId);
    }
}
