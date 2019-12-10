package com.company.first;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * SINGLETON PATTERN
 * This class handles creating and managing tickets for the system.
 * It represents the real world object of a ticket at a parking garage.
 */
public class Ticket implements Serializable {
    public int ticketId;
    public LocalTime checkInTime;
    public LocalTime checkOutTime;
    public double bill;
    public boolean special = false;
    public boolean lost = false;

    /**
     * This is used to create the singleton instance
     */
    private static Ticket single_instance = null;

    /**
     * This is the default constructor for tickets
     */
    public Ticket() {
        this.ticketId = 1;
        this.checkInTime = LocalTime.now();
        this.checkOutTime = LocalTime.now();
        this.bill = 0;
    }

    /**
     * used as the constructor for the single ticket instance
     * @return single_instance
     */
    public static Ticket getInstance()
    {
        if (single_instance == null)
            single_instance = new Ticket();

        return single_instance;
    }


    /**
     * This returns the ticket id
     * @return ticketId The ticket id
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * This sets the ticket id
     * @param ticketId the ticket id
     */
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * This sets the check in time based on a random value between 8am and noon
     */
    public void setCheckInTime() {
        this.checkInTime = TimeGenerator.randomMorning();
    }

    /**
     * returns the check in time
     * @return checkInTime the check in time
     */
    public LocalTime getCheckInTime() {return checkInTime; }

    /**
     * This sets the check out time by generating a random evening time.
     */
    public void setCheckOutTime() {
        this.checkOutTime = TimeGenerator.randomEvening();
    }

    /**
     * returns the bill
     * @return bill the bill
     */
    public double getBill() { return bill; }

    /**
     * sets the bill to be a new value
     * @param bill the new bill
     */
    public void setBill(double bill) { this.bill = bill; }

    /**
     * sets the flag for a lost ticket
     */
    public void ticketGotLost() { lost = true; }

    /**
     * sets the flag for a special ticket
     */
    public void ticketGotSpecial() { special = true; }

    /**
     * checks if the ticket is lost
     * @return lost boolean value
     */
    public boolean isLost() {
        return lost;
    }

    /**
     * Checks if the ticket is special
     * @return special boolean value
     */
    public boolean isSpecial() { return special; }

    /**
     * Determines the duration of a regular ticket, needed to calculate the price
     * @return timeCheckedIn double representing the duration of hours
     */
    public double calcDuration() {
        double timeCheckedIn = 0;
        Duration d = Duration.between(checkInTime, checkOutTime);
        timeCheckedIn = d.toHours();
        return timeCheckedIn;
    }

    /**
     * Calculates the bill for the ticket
     */
    public void calcBill() {
        bill = 5;
        if (calcDuration() > 3){
            double timeOverThree = calcDuration() - 3;
            bill = bill + timeOverThree;
        }
    }

    /**
     * Prints the contents receipt based on the ticket type
     */
    public void displayBill() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ha");
        DecimalFormat df = new DecimalFormat("$0.00");

        if (lost) {
            System.out.println("Best Value Parking Garage\n");
            System.out.println("=========================");
            System.out.println("Receipt for a vehicle id " + ticketId);
            System.out.println();
            System.out.println("Lost Ticket");
            System.out.println(df.format(bill));
        } else if (special) {
            System.out.println("Best Value Parking Garage\n");
            System.out.println("=========================");
            System.out.println("Receipt for a vehicle id " + ticketId);
            System.out.println();
            System.out.println("Special Event Ticket");
            System.out.println(df.format(bill));
        } else {
            System.out.println("Best Value Parking Garage\n");
            System.out.println("=========================");
            System.out.println("Receipt for a vehicle id " + ticketId);
            System.out.println();
            System.out.println((int)calcDuration() + " hours parked " + checkInTime.format(dtf) + " - " + checkOutTime.format(dtf));
            System.out.println(df.format(bill));
        }
    }

}
