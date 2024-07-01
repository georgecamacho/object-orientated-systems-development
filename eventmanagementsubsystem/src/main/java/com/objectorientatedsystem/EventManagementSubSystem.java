package com.objectorientatedsystem;

import com.objectorientatedsystem.model.Event;
import com.objectorientatedsystem.model.Show;
import com.objectorientatedsystem.model.Venue;
import com.objectorientatedsystem.service.EventService;
import com.objectorientatedsystem.service.ShowService;
import com.objectorientatedsystem.service.VenueService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EventManagementSubSystem {
    private final EventService eventService = new EventService();
    private final ShowService showService = new ShowService();
    private final VenueService venueService = new VenueService();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        EventManagementSubSystem system = new EventManagementSubSystem();
        system.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=================================================");
            System.out.println("        Event Management Sub-System              ");
            System.out.println("=================================================");
            System.out.println("1. Create Event");
            System.out.println("2. View Event");
            System.out.println("3. View All Events");
            System.out.println("4. Edit Event");
            System.out.println("5. Delete Event");
            System.out.println("6. Create Venue");
            System.out.println("7. View Venue");
            System.out.println("8. View All Venues");
            System.out.println("9. Edit Venue");
            System.out.println("10. Delete Venue");
            System.out.println("11. Exit");
            System.out.println("=================================================");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createEvent(scanner);
                    break;
                case 2:
                    viewEvent(scanner);
                    break;
                case 3:
                    viewAllEvents();
                    break;
                case 4:
                    editEvent(scanner);
                    break;
                case 5:
                    deleteEvent(scanner);
                    break;
                case 6:
                    createVenue(scanner);
                    break;
                case 7:
                    viewVenue(scanner);
                    break;
                case 8:
                    viewAllVenues();
                    break;
                case 9:
                    editVenue(scanner);
                    break;
                case 10:
                    deleteVenue(scanner);
                    break;
                case 11:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createEvent(Scanner scanner) {
        System.out.print("Enter Event ID: ");
        String eventId = scanner.nextLine();
        System.out.print("Enter Event Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Start Date (yyyy-MM-dd): ");
        Date startDate = parseDate(scanner.nextLine());
        System.out.print("Enter End Date (yyyy-MM-dd): ");
        Date endDate = parseDate(scanner.nextLine());
        System.out.print("Enter Venue: ");
        String venue = scanner.nextLine();
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Seating Capacity: ");
        int seatingCapacity = scanner.nextInt();
        scanner.nextLine();

        List<Show> shows = new ArrayList<>();
        System.out.print("Enter Number of Shows: ");
        int numShows = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numShows; i++) {
            System.out.print("Enter Show ID: ");
            String showId = scanner.nextLine();
            System.out.print("Enter Show Date (yyyy-MM-dd): ");
            Date showDate = parseDate(scanner.nextLine());
            System.out.print("Enter Available Seats: ");
            int availableSeats = scanner.nextInt();
            scanner.nextLine();

            Show show = new Show(showId, showDate, availableSeats);
            shows.add(show);
            showService.createShow(show);
        }

        Event event = new Event(eventId, name, startDate, endDate, venue, description, seatingCapacity, shows);
        eventService.createEvent(event);
        System.out.println("Event created successfully.");
    }

    private void viewEvent(Scanner scanner) {
        System.out.print("Enter Event ID: ");
        String eventId = scanner.nextLine();
        Event event = eventService.getEventById(eventId);
        if (event != null) {
            System.out.println(event);
        } else {
            System.out.println("Event not found.");
        }
    }

    private void viewAllEvents() {
        List<Event> events = eventService.getAllEvents();
        for (Event event : events) {
            System.out.println(event);
        }
    }

    private void editEvent(Scanner scanner) {
        System.out.print("Enter Event ID: ");
        String eventId = scanner.nextLine();
        Event event = eventService.getEventById(eventId);
        if (event != null) {
            System.out.print("Enter New Name: ");
            event.setName(scanner.nextLine());
            System.out.print("Enter New Start Date (yyyy-MM-dd): ");
            event.setStartDate(parseDate(scanner.nextLine()));
            System.out.print("Enter New End Date (yyyy-MM-dd): ");
            event.setEndDate(parseDate(scanner.nextLine()));
            System.out.print("Enter New Venue: ");
            event.setVenue(scanner.nextLine());
            System.out.print("Enter New Description: ");
            event.setDescription(scanner.nextLine());
            System.out.print("Enter New Seating Capacity: ");
            event.setSeatingCapacity(scanner.nextInt());
            scanner.nextLine(); 

            List<Show> shows = new ArrayList<>();
            System.out.print("Enter Number of Shows: ");
            int numShows = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numShows; i++) {
                System.out.print("Enter Show ID: ");
                String showId = scanner.nextLine();
                System.out.print("Enter Show Date (yyyy-MM-dd): ");
                Date showDate = parseDate(scanner.nextLine());
                System.out.print("Enter Available Seats: ");
                int availableSeats = scanner.nextInt();
                scanner.nextLine();

                Show show = new Show(showId, showDate, availableSeats);
                shows.add(show);
                showService.updateShow(show);
            }

            event.setShows(shows);
            eventService.updateEvent(event);
            System.out.println("Event updated successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    private void deleteEvent(Scanner scanner) {
        System.out.print("Enter Event ID: ");
        String eventId = scanner.nextLine();
        eventService.deleteEvent(eventId);
        System.out.println("Event deleted successfully.");
    }

    private void createVenue(Scanner scanner) {
        System.out.print("Enter Venue ID: ");
        String venueId = scanner.nextLine();
        System.out.print("Enter Venue Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Location: ");
        String location = scanner.nextLine();
        System.out.print("Enter Seating Capacity: ");
        int seatingCapacity = scanner.nextInt();
        scanner.nextLine(); 

        List<Event> events = new ArrayList<>();
        Venue venue = new Venue(venueId, name, location, seatingCapacity, events);
        venueService.createVenue(venue);
        System.out.println("Venue created successfully.");
    }

    private void viewVenue(Scanner scanner) {
        System.out.print("Enter Venue ID: ");
        String venueId = scanner.nextLine();
        Venue venue = venueService.getVenueById(venueId);
        if (venue != null) {
            System.out.println(venue);
        } else {
            System.out.println("Venue not found.");
        }
    }

    private void viewAllVenues() {
        List<Venue> venues = venueService.getAllVenues();
        for (Venue venue : venues) {
            System.out.println(venue);
        }
    }

    private void editVenue(Scanner scanner) {
        System.out.print("Enter Venue ID: ");
        String venueId = scanner.nextLine();
        Venue venue = venueService.getVenueById(venueId);
        if (venue != null) {
            System.out.print("Enter New Name: ");
            venue.setName(scanner.nextLine());
            System.out.print("Enter New Location: ");
            venue.setLocation(scanner.nextLine());
            System.out.print("Enter New Seating Capacity: ");
            venue.setSeatingCapacity(scanner.nextInt());
            scanner.nextLine();
            venueService.updateVenue(venue);
            System.out.println("Venue updated successfully.");
        } else {
            System.out.println("Venue not found.");
        }
    }

    private void deleteVenue(Scanner scanner) {
        System.out.print("Enter Venue ID: ");
        String venueId = scanner.nextLine();
        venueService.deleteVenue(venueId);
        System.out.println("Venue deleted successfully.");
    }
    
    private Date parseDate(String dateStr) {
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format. Please use yyyy-MM-dd.");
        }
    }
}