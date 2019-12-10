package com.company.first;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is the driver class for this codebase, RUN THIS
 */
public class Main {

    /**
     * This is the main driver method, RUN THIS
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        int option = 1;
        // Collection for storing the active data from tickets.txt
        List<Ticket> myTickets = new ArrayList<>();

        //populate myTickets list with data from the file at the start of the program running
        myTickets.addAll(TicketReader.readTicketFile("tickets.txt"));

        // initialize a new ticket
        Ticket ticket = Ticket.getInstance();

        // menu
        while (option != 3) {

            //print the check in menu
            screenOne();

            // process user input
            option = Integer.parseInt(keyboard.nextLine());
            switch (option) {
                // Check in a ticket/car
                case 1:
                    screenTwo();
                    option = Integer.parseInt(keyboard.nextLine());

                    int maxId = 0;
                    for (Ticket t: myTickets) {
                        if (t.getTicketId() > maxId) {
                            maxId = t.getTicketId();
                        }
                    }

                    // sets the automatic values that are generated when customer pulls a ticket
                    ticket.setTicketId(maxId + 101);
                    switch (option) {
                        // regular ticket
                        case 1:
                            // this ensures unique ticket ids and maintains a count between different sessions
                            ticket.setCheckInTime();
                            printId(ticket.getTicketId(), ticket.getCheckInTime());
                            break;
                        // special event ticket
                        case 2:
                            ticket.ticketGotSpecial();
                            ticket.setBill(20);
                            break;
                    }
                    break;
                // Check out a ticket/car
                case 2:

                    // user will now checkout from the garage
                    //prints the checkout menu, gets user input
                    screenThree();
                    option = Integer.parseInt(keyboard.nextLine());
                    switch (option) {
                        case 1:
                            screenFour();
                            System.out.println("In case you forgot, your ticket id was: " + ticket.getTicketId());
                            int myTicketId = Integer.parseInt(keyboard.nextLine());


                            if (ticket.getTicketId() == myTicketId) {
                                if (!ticket.isSpecial()) {
                                    ticket.setCheckOutTime();
                                    ticket.calcBill();
                                }
                            } else {
                                System.out.println("Invalid entry, ticket is assumed to be lost");
                                ticket.ticketGotLost();
                                ticket.setBill(25);
                            }
                            break;
                        case 2:
                            ticket.ticketGotLost();
                            ticket.setBill(25);
                            break;
                        default:
                            System.out.println("Invalid entry, ticket is assumed to be lost");
                            ticket.ticketGotLost();
                            ticket.setBill(25);
                    }
                    myTickets.add(ticket);

                    ticket.displayBill();
                    break;
                //close the garage
                case 3:
                    // ends the program
                    break;
            }
        }

        // garage is closed at the end of the program
        Garage garage = new Garage(myTickets);
        garage.closeGarage();
        // saves myTickets list data into a file
        TicketWriter.writeTicketFile("tickets.txt", myTickets);
    }

    /**
     * This prints a basic menu at program launch
     */
    public static void screenOne() {
        System.out.println("Best Value Parking Garage\n");
        System.out.println("=========================");
        System.out.println("1 - Check-In");
        System.out.println("2 - Check-Out");
        System.out.println("3 - Close Garage");
        System.out.print("=> ");

    }

    /**
     * This prints a basic menu for checking in
     */
    public static void screenTwo() {
        System.out.println("Best Value Parking Garage\n");
        System.out.println("Check-In");
        System.out.println("=========================");
        System.out.println("1 - Ticket");
        System.out.println("2 - Special Event");
        System.out.print("=> ");
    }

    /**
     * This prints a basic menu for checking out
     */
    public static void screenThree() {
        System.out.println("Best Value Parking Garage\n");
        System.out.println("Check-Out");
        System.out.println("=========================");
        System.out.println("1 - Ticket");
        System.out.println("2 - Lost Ticket");
        System.out.print("=> ");
    }

    /**
     * This prints a basic menu for inputting the ticket number
     */
    public static void screenFour() {
        System.out.println("Best Value Parking Garage\n");
        System.out.println("Check-Out - Ticket");
        System.out.println("=========================");
        System.out.print("Ticket Number => ");
    }

    /**
     * This prints a basic menu for a receipt
     */
    public static void printId(int vehicleId, LocalTime checkInTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ha");

        System.out.println("Best Value Parking Garage\n");
        System.out.println("=========================");
        System.out.print("Ticket for a vehicle id " + vehicleId);
        System.out.println("");
        System.out.println(checkInTime.format(dtf));
    }
}
