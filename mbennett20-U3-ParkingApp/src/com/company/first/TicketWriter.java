package com.company.first;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.io.FileOutputStream;

/**
 * This class is for writing the ticket objects to a .txt file
 */
public class TicketWriter {

    /**
     * This method loops through the list of tickets and writes the objects to a txt file
     * @param fileName the file name of the storage file
     * @param ticketList the list of tickets loaded in the actively running program
     * @throws IOException
     */
    public static void writeTicketFile(String fileName, List<Ticket> ticketList) throws IOException {
        //try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);

            for (Ticket ticket : ticketList) {
                objOutputStream.writeObject(ticket);
            }

            outputStream.close();
            objOutputStream.close();
        //} catch (Exception e){
            //System.out.println("There was an error");
        //}
    }
}
