package com.example;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class Solution {
    static List<Rent> rentList = Storage.readContent();
    public static void task01() {
        // rentList.forEach(System.out::println);
    }
    public static void task02() {
        int month = Integer.parseInt(Input.input("Adjon meg egy hónapot (1-12): "));
        int sum = 0;
        for(Rent rent : rentList) {
            if(rent.getStartDate().getMonth().getValue() == month || 
                rent.getEndDate().getMonth().getValue() == month ) {                
                sum += rent.getTotalPrice();
            }
        }
        System.out.printf("\nA(z) %d. havi bevétel: %,d\n", month, sum );
    }

    public static void task03() {
        //Összes bevétel
        int sum = 0;
        for(Rent rent: rentList) {            
            sum += rent.getTotalPrice();
        }
        System.out.printf("\nTeljes éves bevétel: %,d Ft\n", sum);
    }
}
