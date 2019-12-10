package com.company.first;

/**
 * FACTORY PATTERN
 * This class is used for the creation of different ticket types
 */
public class TicketFactory {
    public TicketType ticket(String ticketType) {
        switch (ticketType) {
            case "regular":
                return new RegularTicket();
            case "lost":
                return new LostTicket();
            case "special":
                return new SpecialTicket();
            default:
                return null;
        }
    }
}
