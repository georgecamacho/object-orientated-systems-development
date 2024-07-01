package com.objectorientatedsystem.model;

import java.util.Date;

public class Show {
    private String showId;
    private Date showDate;
    private int availableSeats;

    public Show(String showId, Date showDate, int availableSeats) {
        this.showId = showId;
        this.showDate = showDate;
        this.availableSeats = availableSeats;
    }

    // Getters
    public String getShowId() {
        return showId;
    }

    public Date getShowDate() {
        return showDate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Setters
    public void setShowId(String showId) {
        this.showId = showId;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    
    // toString to read the details
    @Override
    public String toString() {
        return "Show{" +
                "showId='" + showId + '\'' +
                ", showDate=" + showDate +
                ", availableSeats=" + availableSeats +
                '}';
    }
}