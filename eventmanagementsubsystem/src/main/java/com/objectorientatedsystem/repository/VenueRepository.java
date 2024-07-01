package com.objectorientatedsystem.repository;

import com.objectorientatedsystem.model.Venue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VenueRepository {
    private final List<Venue> venues = new ArrayList<>();

    public void addVenue(Venue venue) {
        venues.add(venue);
    }

    public Venue getVenueById(String venueId) {
        Optional<Venue> venue = venues.stream()
                .filter(v -> v.getVenueId().equals(venueId))
                .findFirst();
        return venue.orElse(null);
    }

    public List<Venue> getAllVenues() {
        return new ArrayList<>(venues);
    }

    public void updateVenue(Venue venue) {
        Venue existingVenue = getVenueById(venue.getVenueId());
        if (existingVenue != null) {
            existingVenue.setName(venue.getName());
            existingVenue.setLocation(venue.getLocation());
            existingVenue.setSeatingCapacity(venue.getSeatingCapacity());
            existingVenue.setEvents(venue.getEvents());
        }
    }

    public void deleteVenue(String venueId) {
        venues.removeIf(venue -> venue.getVenueId().equals(venueId));
    }
}