package com.objectorientatedsystem.repository;

import com.objectorientatedsystem.model.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventRepository {
    private final List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event getEventById(String eventId) {
        Optional<Event> event = events.stream()
                .filter(e -> e.getEventId().equals(eventId))
                .findFirst();
        return event.orElse(null);
    }

    public List<Event> getAllEvents() {
        return new ArrayList<>(events);
    }

    public void updateEvent(Event event) {
        Event existingEvent = getEventById(event.getEventId());
        if (existingEvent != null) {
            existingEvent.setName(event.getName());
            existingEvent.setStartDate(event.getStartDate());
            existingEvent.setEndDate(event.getEndDate());
            existingEvent.setVenue(event.getVenue());
            existingEvent.setDescription(event.getDescription());
            existingEvent.setSeatingCapacity(event.getSeatingCapacity());
            existingEvent.setShows(event.getShows());
        }
    }

    public void deleteEvent(String eventId) {
        events.removeIf(event -> event.getEventId().equals(eventId));
    }
}
