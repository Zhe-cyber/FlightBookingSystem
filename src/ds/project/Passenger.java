/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.project;

/**
 *
 * @author DELL
 */
import java.util.Date;

public class Passenger {
    private String name;             // Passenger's name
    private String passportNumber;   // Passenger's passport number
    private String email;            // Passenger's email
    private String phoneNumber;      // Passenger's phone number
    private String address;          // Passenger's address

    // Constructor
    public Passenger(String name, String passportNumber, String email, String phoneNumber,  String address) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getter and Setter methods for all attributes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Override the toString() method for easier display of passenger information
    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
