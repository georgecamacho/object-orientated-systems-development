package com.objectorientatedsystem.model;

import java.util.List;

public class Venue {
    private String venueId;
    private String name;
    private String location;
    private int seatingCapacity;
    private List<Event> events;

    public Venue(String venueId, String name, String location, int seatingCapacity, List<Event> events) {
        this.venueId = venueId;
        this.name = name;
        this.location = location;
        this.seatingCapacity = seatingCapacity;
        this.events = events;
    }

    // Getters
    public String getVenueId() {
        return venueId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
    
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public List<Event> getEvents() {
        return events;
    }
    // Setters
    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    // toString to read the details
    @Override
    public String toString() {
        return "Venue{" +
                "venueId='" + venueId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", events=" + events +
                '}';
    }
}
