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
            if (vehicle.getFuel().equals("benzin")) {
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
            if (vehicle.getPrice() < 1000000) {
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
            if (vehicle.getPermission().isAfter(LocalDate.now().minusYears(1))) {
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
            if (vehicle.getBrand().equals("Honda")) {
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

    public static void printIncomeSum() {
        int sum = 0;
        for(Vehicle vehicle : vehicleList) {
            sum += vehicle.getPrice();
        }

        System.out.printf("Összes bevétel: %d Ft\n", sum);
    }

    public static void printIfHasHonda() {
        String ker = "Honda";
        int n = vehicleList.size();
        int i = 0;
        while( i < n && !vehicleList.get(i).equals(ker)) {
            i++;
        }
        if(i<n) {
            System.out.println("Van: " + ker);
        }else {
            System.err.println("Nincsen Honda");
        }
    }

    public static void printCheapest() {
        int min = vehicleList.get(0).getPrice();
        for(Vehicle vehicle : vehicleList) {
            if(vehicle.getPrice() < min) {
                min = vehicle.getPrice();
            }
        }
        
        System.out.printf("Legolcsobb: %d Ft\n", min);
    }

}