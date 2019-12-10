package com.company.first.Tests;

import com.company.first.Ticket;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the JUnit testing class for testing ticket, where the values I needed to check are.
 * The checks in the list changed as I modified the codebase, reflecting what was necessary to test at the time.
 * This represents a sample of tests I performed.
 */
class TicketTest {

    /**
     * This tests setting the ticket id
     */
    @org.junit.jupiter.api.Test
    void setTicketIdTest() {
        Ticket ticket = new Ticket();
        ticket.setTicketId(5);

        assertEquals(5, ticket.getTicketId());
    }

    /**
     * This tests setting the check in time for a ticket
     */
    @org.junit.jupiter.api.Test
    void setCheckInTimeTest() {
        Ticket ticket = new Ticket();
        ticket.setCheckInTime();

        System.out.println(ticket.getCheckInTime());
    }

    /**
     * This tests setting the ticket bill
     */
    @org.junit.jupiter.api.Test
    void setBillTest() {
        Ticket ticket = new Ticket();
        ticket.setBill(25);

        assertEquals(25, ticket.getBill());
    }

    /**
     * This tests checking the ticket lost status
     */
    @org.junit.jupiter.api.Test
    void isLostTest() {
        Ticket ticket = new Ticket();
        ticket.ticketGotLost();

        assertEquals(true, ticket.isLost());
    }

    /**
     * This tests checking the ticket special status
     */
    @org.junit.jupiter.api.Test
    void isSpecialTest() {
        Ticket ticket = new Ticket();
        ticket.ticketGotSpecial();

        assertEquals(true, ticket.isSpecial());
    }
}