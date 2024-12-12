/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.project;

/**
 *
 * @author DELL
 */
public class BookTicket {
    public static void book(Flight flight, Passenger passenger) {
        // Check for vacant seats
        if (flight.hasVacantSeat()) {
            flight.getBooked().add(passenger);  // Add passenger to booked list
            flight.incrementBookedCount();     // Increment booked count
            System.out.println(passenger.getName() + " has successfully booked a ticket!");
        } else {
            flight.getWaitingList().add(passenger); // Add passenger to waiting list
            System.out.println("No seats available. " + passenger.getName() + " is added to the waiting list.");
        }
    }
}

