package com.objectorientatedsystem.service;

import com.objectorientatedsystem.model.Venue;
import com.objectorientatedsystem.repository.VenueRepository;

import java.util.List;

public class VenueService {
    private final VenueRepository venueRepository;

    public VenueService() {
        this.venueRepository = new VenueRepository();
    }

    public void createVenue(Venue venue) {
        venueRepository.addVenue(venue);
    }

    public Venue getVenueById(String venueId) {
        return venueRepository.getVenueById(venueId);
    }

    public List<Venue> getAllVenues() {
        return venueRepository.getAllVenues();
    }

    public void updateVenue(Venue venue) {
        venueRepository.updateVenue(venue);
    }

    public void deleteVenue(String venueId) {
        venueRepository.deleteVenue(venueId);
    }
}
