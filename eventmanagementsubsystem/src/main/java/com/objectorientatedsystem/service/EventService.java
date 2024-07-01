package com.objectorientatedsystem.service;

import com.objectorientatedsystem.model.Event;
import com.objectorientatedsystem.repository.EventRepository;

import java.util.List;

public class EventService {
    private final EventRepository eventRepository;

    public EventService() {
        this.eventRepository = new EventRepository();
    }

    public void createEvent(Event event) {
        eventRepository.addEvent(event);
    }

    public Event getEventById(String eventId) {
        return eventRepository.getEventById(eventId);
    }

    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }

    public void updateEvent(Event event) {
        eventRepository.updateEvent(event);
    }

    public void deleteEvent(String eventId) {
        eventRepository.deleteEvent(eventId);
    }
}
