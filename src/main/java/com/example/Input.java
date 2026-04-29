package com.example;

import java.util.Scanner;

public class Input {

    public static String input(String msg) {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print(msg);
            return sc.nextLine();
        }
    }
}
