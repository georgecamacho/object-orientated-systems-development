package com.objectorientatedsystem.model;

import java.util.Date;
import java.util.List;

public class Event {
    private String eventId;
    private String name;
    private Date startDate;
    private Date endDate;
    private String venue;
    private String description;
    private int seatingCapacity;
    private List<Show> shows;

    // Constructor
    public Event(String eventId, String name, Date startDate, Date endDate, String venue, String description, int seatingCapacity, List<Show> shows) {
        this.eventId = eventId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.venue = venue;
        this.description = description;
        this.seatingCapacity = seatingCapacity;
        this.shows = shows;
    }

    // Getters
    public String getEventId() {
        return eventId;
    }
    
    public String getName() {
        return name;
    }
    
    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    
    public String getVenue() {
        return venue;
    }

    public String getDescription() {
        return description;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }
    
    public List<Show> getShows() {
        return shows;
    }

    // Setters
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    // toString to read the details
    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", venue='" + venue + '\'' +
                ", description='" + description + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", shows=" + shows +
                '}';
    }
}