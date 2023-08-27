package org.example.dsa;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class UtcTimeStampTest {
    public static void main(String[] args) {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Add hours to the current date and time
        int hoursToAdd = 5; // Example: Add 5 hours
        LocalDateTime newDateTime = currentDateTime.plusHours(hoursToAdd);

        // Format the new date and time using a DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = newDateTime.format(formatter);

        System.out.println("Current date and time: " + currentDateTime);
        System.out.println("New date and time with added hours: " + formattedDateTime);


    }
}
