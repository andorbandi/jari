package com.example;

import java.util.List;

public class Solution {

    static List<Vehicle> vehicleList;

    public static void task01() {
        vehicleList = Storage.readFile();
    }

    public static void printList() {
        vehicleList.forEach(item -> {
            System.out.println(item);
        });
    }

}
