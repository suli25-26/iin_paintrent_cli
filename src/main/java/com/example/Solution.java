package com.example;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static void task04() {
        //Legdrágább bérlés
        Rent maxRent = rentList.get(0);
        for(Rent rent : rentList) {
            if(rent.getTotalPrice()> maxRent.getTotalPrice()) {
                maxRent = rent;
            }
        }
        System.out.printf("Legdrágább bérlés: %s (%,d Ft)\n", 
        maxRent.getTitle(), maxRent.getTotalPrice());
    }

    public static void task05() {
        List<Integer> painingidList = new ArrayList<>();
        for(Rent rent: rentList) {
            if(!painingidList.contains(rent.getPaintingid())) {
                painingidList.add(rent.getPaintingid());
            }
        }
        int count = painingidList.size();
        System.out.printf("Különböző festmények száma: %d\n", count);
    }

    public static void task06() {
        //Leggyakrabban bérelt festmény
        Map<String, Integer> stat = new HashMap<>();
        for(Rent rent: rentList) {
            String title = rent.getTitle();
            stat.put(title, stat.getOrDefault(title, 0) + 1);
        }
        String maxTitle = "";
        int maxCount = -1;

        for(Map.Entry<String, Integer> entry:stat.entrySet()) {
            if(entry.getValue()> maxCount) {
                maxCount = entry.getValue();
                maxTitle = entry.getKey();
            }
        }
        System.out.printf("Legtöbbször bérelt festmény: %s (%d alkalom)\n",
            maxTitle, maxCount
        );

    }

    public static void task07() {
        //Bérlések száma festőnként
        Map<String, Integer> stat = new HashMap<>();

        for(Rent rent: rentList) {
            stat.put(rent.getArtist(), stat.getOrDefault(rent.getArtist(), 0) + 1);
        }

        System.out.println("\nBérlések száma festőnként:");
        for(Map.Entry<String, Integer> entry : stat.entrySet()) {
            System.out.printf("%s: %d db\n", entry.getKey(), entry.getValue());
        }
    }

    public static void task08() {
        //Átlagos bérlési időtartam
        int sumDay = 0;
        for(Rent rent: rentList) {
            sumDay += ChronoUnit.DAYS.between(rent.getStartDate(), rent.getEndDate());
        }
        double average = (double) sumDay / rentList.size();
        System.out.printf("Átlagos bérlési időtartam: %.1f nap\n", average);
    }
}
