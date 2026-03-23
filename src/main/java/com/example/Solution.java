package com.example;

import java.time.LocalDate;
import java.util.List;

public class Solution {

    static List<Vehicle> vehicleList;

    public static void readContent() {
        vehicleList = Storage.readFile();
    }

    public static void printVehicleList() {
        vehicleList.forEach(vehicle -> {
            System.out.println(vehicle.getBrand());
        });
    }

    public static void printPetrolDatas() {
        vehicleList.forEach(vehicle -> {
            if (vehicle.fuel.equals("benzin")) {
                System.out.printf("%s %s %d %s %d %s %s\n", 
                vehicle.getPlate(),
                vehicle.getBrand(),
                vehicle.getYear(),
                vehicle.getFuel(),
                vehicle.getPrice(),
                vehicle.getClimate() ? "van" : "nincs",
                vehicle.getPermission());
            }
        });
    }

    public static void printLeastThanOneMillion() {
        System.out.println("\nOlcsóbb mint 1 millió forint:");
        vehicleList.forEach(vehicle -> {
            if (vehicle.price < 1000000) {
                System.out.printf("%s %s %d %s %d %s %s\n", 
                vehicle.getPlate(),
                vehicle.getBrand(),
                vehicle.getYear(),
                vehicle.getFuel(),
                vehicle.getPrice(),
                vehicle.getClimate() ? "van" : "nincs",
                vehicle.getPermission());
            }
        });
    }

    public static void printMoreThanOneYearPermission() {
        System.out.println("\nTöbb mint egy évig van műszakija:");
        vehicleList.forEach(vehicle -> {
            if (vehicle.permission.isAfter(LocalDate.now().minusYears(1))) {
                System.out.printf("%s %s %d %s %d %s %s\n", 
                vehicle.getPlate(),
                vehicle.getBrand(),
                vehicle.getYear(),
                vehicle.getFuel(),
                vehicle.getPrice(),
                vehicle.getClimate() ? "van" : "nincs",
                vehicle.getPermission());
            }
        });
    }

    public static void printHondas() {
        System.out.println("\nHonda autok:");
        vehicleList.forEach(vehicle -> {
            if (vehicle.brand.equals("Honda")) {
                System.out.printf("%s %s %d %s %d %s %s\n", 
                vehicle.getPlate(),
                vehicle.getBrand(),
                vehicle.getYear(),
                vehicle.getFuel(),
                vehicle.getPrice(),
                vehicle.getClimate() ? "van" : "nincs",
                vehicle.getPermission());
            }
        });
    }


}