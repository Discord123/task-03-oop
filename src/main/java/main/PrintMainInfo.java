package main;

import entity.Airplane;

import java.util.List;

public class PrintMainInfo {

    public static void printInfo (String s) {
        System.out.println(s);
    }

    public static void printInfo (int i) {
        System.out.println(i);
    }

    public static void printInfo (List<Airplane> airplaneList) {
        if(airplaneList == null || airplaneList.size() == 0) {
            System.out.println("Airplane not found!");
        }

        System.out.println("--------------------------------------------------------");

        for (Airplane airplane : airplaneList) {
            System.out.println(airplane);
        }
    }
}
