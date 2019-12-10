package com.company.first;

import java.text.DecimalFormat;
import java.util.List;

/**
 * This class represents the real world object of the garage
 */
public class Garage {
    public int checkInCount;
    public double moneyFromCheckIns;
    public int lostTicketCount;
    public double moneyFromLostTickets;
    public int specialTicketCount;
    public double moneyFromSpecialTickets;
    public double totalMoney;


    /**
     * constructor creates the garage object,
     * the purpose of the garage class is to process and display the garage's monetary transactions
     * this constructor determines the money from checkins, lost tickets, and the total money generated
     * @param listOfTickets the list of tickets in the garage
     */
    public Garage(List<Ticket> listOfTickets) {
        for (Ticket t: listOfTickets) {
            if (t.isLost()) {
                lostTicketCount++;
                moneyFromLostTickets += t.getBill();
            } else if (t.isSpecial()) {
                specialTicketCount++;
                moneyFromSpecialTickets += t.getBill();
            } else {
                checkInCount++;
                moneyFromCheckIns += t.getBill();
            }
        }

        totalMoney = moneyFromCheckIns + moneyFromLostTickets + moneyFromSpecialTickets;
    }

    /**
     * This closes the garage and processes the tickets
     */
    public void closeGarage() {
        DecimalFormat df = new DecimalFormat("$0.00");

        System.out.println("Best Value Parking Garage\n");
        System.out.println("=========================");
        System.out.println("Activity to Date");
        System.out.println();
        System.out.println(df.format(moneyFromCheckIns) + " was collected from " + checkInCount + " Check Ins");
        System.out.println(df.format(moneyFromLostTickets) + " was collected from " + lostTicketCount + " Lost Tickets");
        System.out.println(df.format(moneyFromSpecialTickets) + " was collected from " + specialTicketCount + " Special Tickets");
        System.out.println();
        System.out.println(df.format(totalMoney) + " was collected overall");
    }
}
