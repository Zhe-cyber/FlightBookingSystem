/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.project;

/**
 *
 * @author DELL
 */
import java.util.*;

public class Flight {
    private String flightId;
    private String date;
    private int totalSeats;
    private int bookedCount; 
    private List<Passenger> booked;
    private Queue<Passenger> waitingList;

    public Flight(String flightId, String date, int totalSeats) {
        this.flightId = flightId;
        this.date = date;
        this.totalSeats = totalSeats;
        this.bookedCount = 0; 
        this.booked = new ArrayList<>();
        this.waitingList = new LinkedList<>();
    }

    public boolean hasVacantSeat() {
        return bookedCount < totalSeats;
    }

    public void incrementBookedCount() {
        bookedCount++;
    }

    public void decrementBookedCount() {
        bookedCount--;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getDate() {
        return date;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public List<Passenger> getBooked() {
        return booked;
    }

    public Queue<Passenger> getWaitingList() {
        return waitingList;
    }
}
