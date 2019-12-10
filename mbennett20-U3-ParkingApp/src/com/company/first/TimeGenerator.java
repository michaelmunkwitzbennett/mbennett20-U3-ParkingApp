package com.company.first;

import java.time.LocalTime;

/**
 * This class contains static methods to be used for generating random morning and evening times
 */
public class TimeGenerator {

    /**
     * generates a random morning value between 8 am and noon
     * @return
     */
    public static LocalTime randomMorning() {
        int randomInt = (int)(6.0 * Math.random()) + 7;
        return LocalTime.of(randomInt, 0);
    }

    /**
     * generates a random evening value
     * @return
     */
    public static LocalTime randomEvening() {
        int randomInt = (int)(11.0 * Math.random()) + 13;
        return LocalTime.of(randomInt, 0);
    }
}
