/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ds.project;

/**
 *
 * @author DELL
 */
import java.text.SimpleDateFormat;
import java.util.*;
public class DSProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Create a sample Flight with a total of 3 seats
            Flight flight = new Flight("ABX123", "2024-1-1", 2);

            Passenger passenger1 = new Passenger("Lee", "P12345678", "lee123@gmail.com", "012-3456789", "Batu Pahat, Johor");
            Passenger passenger2 = new Passenger("Ali", "P23456789", "ali123@gmail.com", "011-23456789", "Ipoh, Perak");
            Passenger passenger3 = new Passenger("Muthu", "P34567890", "muthu123@gmail.com", "014-1234567", "Rawang, Selangor");
            Passenger passenger4 = new Passenger("Jen", "P45678901", "jen123@gmail.com", "6561234567", "Orchard Road, Singapore");

            // Attempt to book tickets
            System.out.println("Booking tickets...\n");
            BookTicket.book(flight, passenger1);  
            BookTicket.book(flight, passenger2);  
            BookTicket.book(flight, passenger3);  
            BookTicket.book(flight, passenger4);  

            System.out.println("\nBooked Passengers:");
            if (flight.getBooked().isEmpty()) {
                System.out.println("No passengers booked.");
            } else {
                for (Passenger p : flight.getBooked()) {
                    System.out.println("Name: " + p.getName());
                    System.out.println("Passport Number: " + p.getPassportNumber());
                    System.out.println("Email: " + p.getEmail());
                    System.out.println("Phone: " + p.getPhoneNumber());
                    System.out.println("Address: " + p.getAddress());
                    System.out.println();
                }
            }

            // Display the waiting list in a structured format
            System.out.println("\nWaiting List:");
            if (flight.getWaitingList().isEmpty()) {
                System.out.println("No passengers on the waiting list.");
            } else {
                for (Passenger p : flight.getWaitingList()) {
                    System.out.println("Name: " + p.getName());
                    System.out.println("Passport Number: " + p.getPassportNumber());
                    System.out.println("Email: " + p.getEmail());
                    System.out.println("Phone: " + p.getPhoneNumber());
                    System.out.println("Address: " + p.getAddress());
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}