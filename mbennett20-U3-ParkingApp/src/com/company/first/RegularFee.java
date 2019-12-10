package com.company.first;

/**
 * STRATEGY PATTERN
 * This represents a regular fee in the FeeStrategy
 */
public class RegularFee {
    public static double calcBill(double duration) {
        double bill = 5;
        if (duration > 3){
            double timeOverThree = duration - 3;
            bill = bill + timeOverThree;
        }

        return bill;
    }
}
