package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    public static List<Rent> readContent() {
        try {
            return tryReadContent();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static List<Rent> tryReadContent() throws FileNotFoundException {
        List<Rent> rentList = new ArrayList<>();
        File file = new File("festmeny_berlesek_2024.csv");
        try(Scanner sc = new Scanner(file, "utf-8")) {
            sc.nextLine();
            while(sc.hasNext()) {
                String line = sc.nextLine();
                String[] lineArray = line.split(",");
                Rent rent = new Rent();
                rent.setUid(Integer.parseInt(lineArray[0]));
                rent.setPaintingid(Integer.parseInt(lineArray[1]));
                rent.setStartDate(LocalDate.parse(lineArray[2]));
                rent.setEndDate(LocalDate.parse(lineArray[3]));
                rent.setDailyPrice(Integer.parseInt(lineArray[4]));
                rent.setArtist(lineArray[5]);
                rent.setTitle(lineArray[6]);
                rent.calcAndSetTotalPrice();
                rentList.add(rent);
            }
        }
        return rentList;
    }
}
