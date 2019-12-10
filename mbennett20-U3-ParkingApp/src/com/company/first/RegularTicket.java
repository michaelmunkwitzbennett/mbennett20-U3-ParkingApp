package com.company.first;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

/**
 * This class represents an object of a ticket, specifically a regular ticket ticket
 */
public class RegularTicket implements TicketType {

    private double duration;
    private double bill = RegularFee.calcBill(duration);

    /**
     * Displays the ticket
     * @param ticket
     */
    @Override
    public void displayTicketType(Ticket ticket) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ha");
        DecimalFormat df = new DecimalFormat("$0.00");

        System.out.println("Best Value Parking Garage\n");
        System.out.println("=========================");
        System.out.println("Receipt for a vehicle id " + ticket.getTicketId());
        System.out.println();
        System.out.println((int)ticket.calcDuration() + " hours parked " + ticket.checkInTime.format(dtf) + " - " + ticket.checkOutTime.format(dtf));
        System.out.println(df.format(ticket.getBill()));
    }
}
