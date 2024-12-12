package Search_Flight;

import java.util.*;

class Ticket {
    private final String name;
    private final String passportNumber;

    // Constructor
    public Ticket(String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Passport Number: " + passportNumber;
    }
}

class Flight {
    private final String flightNumber;
    private final List<Ticket> confirmedTickets;
    private final Queue<Ticket> waitingList;
    private final int capacity;
    private final Date date;

    public Flight(String flightNumber, int capacity, Date date) {
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.date = date;
        this.confirmedTickets = new ArrayList<>();
        this.waitingList = new LinkedList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Date getDate() {
        return date;
    }

    public boolean bookTicket(Ticket ticket) {
        if (confirmedTickets.size() < capacity) {
            confirmedTickets.add(ticket);
            return true;
        } else {
            waitingList.add(ticket);
            return false;
        }
    }

    public void cancelTicket(Ticket ticket) {
        if (confirmedTickets.remove(ticket)) {
            if (!waitingList.isEmpty()) {
                confirmedTickets.add(waitingList.poll());
            }
        } else {
            waitingList.remove(ticket);
        }
    }

    @Override
    public String toString() {
        return "Flight Number: " + flightNumber + ", Date: " + date + ", Confirmed Tickets: "
                + confirmedTickets.size() + ", Waiting List: " + waitingList.size();
    }
}

public class Search {
    private final Map<String, List<Flight>> flights;

    public Search() {
        flights = new HashMap<>();
    }

    public void addFlight(String flightNumber, int capacity, Date date) {
        Flight flight = new Flight(flightNumber, capacity, date);
        String weekKey = getWeekKey(date);
        flights.computeIfAbsent(weekKey, k -> new ArrayList<>()).add(flight);
    }

    public List<Flight> searchFlights(Date startDate, Date endDate) {
        List<Flight> result = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        while (!calendar.getTime().after(endDate)) {
            String weekKey = getWeekKey(calendar.getTime());
            if (flights.containsKey(weekKey)) {
                result.addAll(flights.get(weekKey));
            }
            calendar.add(Calendar.DATE, 1);
        }
        return result;
    }

    public boolean bookTicket(String flightNumber, Ticket ticket, Date date) {
        String weekKey = getWeekKey(date);
        List<Flight> weekFlights = flights.get(weekKey);
        if (weekFlights != null) {
            for (Flight flight : weekFlights) {
                if (flight.getFlightNumber().equals(flightNumber) && flight.getDate().equals(date)) {
                    return flight.bookTicket(ticket);
                }
            }
        }
        return false;
    }

    public void cancelTicket(String flightNumber, Ticket ticket, Date date) {
        String weekKey = getWeekKey(date);
        List<Flight> weekFlights = flights.get(weekKey);
        if (weekFlights != null) {
            for (Flight flight : weekFlights) {
                if (flight.getFlightNumber().equals(flightNumber) && flight.getDate().equals(date)) {
                    flight.cancelTicket(ticket);
                    return;
                }
            }
        }
    }

    private String getWeekKey(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        return year + "-W" + week;
    }

    public static void main(String[] args) {
        Search bookingSystem = new Search();
        Calendar calendar = Calendar.getInstance();

        // Adding flights for a specific week
        calendar.set(2024, Calendar.DECEMBER, 19);
        bookingSystem.addFlight("F123", 2, calendar.getTime());
        calendar.set(2024, Calendar.DECEMBER, 20);
        bookingSystem.addFlight("F124", 2, calendar.getTime());
        calendar.set(2024, Calendar.DECEMBER, 21);
        bookingSystem.addFlight("F125", 2, calendar.getTime());

        Ticket ticket1 = new Ticket("John Doe", "A12345");
        Ticket ticket2 = new Ticket("Jane Smith", "B67890");
        Ticket ticket3 = new Ticket("Alice Brown", "C54321");

        // Booking tickets
        calendar.set(2024, Calendar.DECEMBER, 19);
        boolean booked1 = bookingSystem.bookTicket("F123", ticket1, calendar.getTime());
        boolean booked2 = bookingSystem.bookTicket("F123", ticket2, calendar.getTime());
        boolean booked3 = bookingSystem.bookTicket("F123", ticket3, calendar.getTime()); // This should go to the waiting list.

        // Print booking results
        System.out.println("Ticket 1 booked: " + booked1);
        System.out.println("Ticket 2 booked: " + booked2);
        System.out.println("Ticket 3 booked: " + booked3);

        // Searching for flights in a specific week
        calendar.set(2024, Calendar.DECEMBER, 19);
        Date startDate = calendar.getTime();
        calendar.set(2024, Calendar.DECEMBER, 25);
        Date endDate = calendar.getTime();
        List<Flight> flights = bookingSystem.searchFlights(startDate, endDate);
        for (Flight flight : flights) {
            System.out.println(flight);
        }

        // Canceling a ticket
        calendar.set(2024, Calendar.DECEMBER, 19);
        bookingSystem.cancelTicket("F123", ticket1, calendar.getTime()); // This should move ticket3 from waiting list to confirmed
        flights = bookingSystem.searchFlights(startDate, endDate);
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}

