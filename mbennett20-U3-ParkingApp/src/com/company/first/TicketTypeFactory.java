package com.company.first;

/**
 * This interface is for the ticket factory pattern
 */
public interface TicketTypeFactory {
    TicketType getTicketType(String ticketType);
}
