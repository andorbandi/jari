package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    public static List<Vehicle> readFile() {
        try {
            return tryReadFile();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            //e.printStackTrace();
            return null;
        }
    }

    private static List<Vehicle> tryReadFile() throws FileNotFoundException {
        List<Vehicle> vehicleList = new ArrayList<>();

        File file = new File("jaribt.txt");
        
        try(Scanner sc = new Scanner(file);) {
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineArray =line.split(":");
                
                Vehicle vehicle = new Vehicle();
                vehicle.setPlate(lineArray[0]);
                vehicle.setBrand(lineArray[1]);
                vehicle.setYear(Integer.parseInt(lineArray[2]));
                vehicle.setFuel(lineArray[3]);
                vehicle.setPrice(Integer.parseInt(lineArray[4]));
                boolean hasClimate = false;
                if(lineArray[5].equals("1")) {
                    hasClimate = true;
                }
                vehicle.setClimate(hasClimate);
                vehicle.setPermission(LocalDate.parse(lineArray[6]));

                vehicleList.add(vehicle);
            }
        }

        return vehicleList;
    }
}
