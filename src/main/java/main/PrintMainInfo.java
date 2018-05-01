package main;

import entity.Airplane;

import java.util.List;

public class PrintMainInfo {

    private static final String BLOCK_SEPARATOR = "--------------------------------------------------------";

    public static void printInfo (String s) {
        System.out.println(s);
    }

    public static void printInfo (int i) {
        System.out.println(i);
    }

    public static void printInfo (List<Airplane> airplaneList) {
        if(airplaneList == null || airplaneList.size() == 0) {
            System.out.println("Airplane not found!");
        } else {
            System.out.println(BLOCK_SEPARATOR);
            for (Airplane airplane : airplaneList) {
                System.out.println(airplane);
            }
        }
    }
}
