package com.company.first;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

/**
 * This class represents an object of a ticket, specifically a special event ticket
 */
public class SpecialTicket implements TicketType {
    private double bill = 20;

    /**
     * Displays the ticket
     * @param ticket
     */
    @Override
    public void displayTicketType(Ticket ticket) {
        DecimalFormat df = new DecimalFormat("$0.00");

        System.out.println("Best Value Parking Garage\n");
        System.out.println("=========================");
        System.out.println("Receipt for a vehicle id " + ticket.getTicketId());
        System.out.println();
        System.out.println("Special Event Ticket");
        System.out.println(df.format(bill));
    }
}
