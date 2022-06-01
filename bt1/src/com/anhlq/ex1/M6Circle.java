package com.anhlq.ex1;

import java.util.Scanner;

public class M6Circle {

    public static void main(String[] args) {
        // Declare variable for radius and distance
        double distance;
        int rad;
        // Accept data from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Radius: ");
        rad = sc.nextInt();
        // Use for loop for row wise
        for (int row = 0; row <= 2 * rad; row++) {
            // Use for loop for col wise
            for (int col = 0; col <= 2 * rad; col++) {
                distance = Math.sqrt((row - rad) * (row - rad) + (col - rad) * (col - rad));
                // Check whether distance is in the range of (radius - 0.5) and (radius + 0.5)
                // or not to print *
                if (distance > rad - 0.5 && distance < rad + 0.5)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}