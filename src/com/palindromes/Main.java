package com.palindromes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        printBonusDatesBetween(2000, 2015);
    }

    static void printBonusDatesBetween(int fromYear, int toYear) {
        // Create start and end dates
        LocalDate startYear = LocalDate.of(fromYear, 1, 1);
        LocalDate endYear = LocalDate.of(toYear, 1, 1);
        // Create a list of dates
        List<LocalDate> dateList = startYear.datesUntil(endYear)
                .collect(Collectors.toList());
        // Loop through dates to get palindromes
        dateList.forEach(date -> {

            // Convert to String and remove dashes ('-')
            String newDate = date.toString().replaceAll("[-]", "");

            // Convert back into Integer
            int intNewDate = Integer.parseInt(newDate);

            // Calculus variables
            int sum = 0, r;

            // Create temporary copy of date
            int temp = intNewDate;

            // Reverse int
            while (intNewDate > 0) {
                r = intNewDate % 10;
                sum = (sum * 10) + r;
                intNewDate = intNewDate / 10;
            }

            // Check if reversed int is a palindrome of a int
            if (temp == sum) {
                String success = Integer.toString(sum);
                String palindromeDate = success.substring(0, 4) + "-" + success.substring(4, 6) + "-" + success.substring(6, 8
                );
                System.out.println(palindromeDate);
            }
        });
    }
}

// Java isn't my strong language, so this code looks chaotic. Thank you for reading.