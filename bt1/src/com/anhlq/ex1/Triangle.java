package com.anhlq.ex1;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        System.out.println("Enter 3 edge of the triangle: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        checkTriangle(arr);
    }

    private static void checkTriangle(int[] arr) {
        //if 3 edge make a triangle
        if (arr[0] + arr[1] > arr[2]
                && arr[1] + arr[2] > arr[0]
                && arr[0] + arr[2] > arr[1]) {
            // calculate half perimeter
            float hp = (float) (arr[0] + arr[1] + arr[2]) / 2;
            // calculate area
            float area = (float) Math.sqrt(hp * (hp - arr[0]) * (hp - arr[1]) * (hp - arr[2]));
            System.out.println("Area of the triangle is " + String.format("%.2f", area));
            // 3 edge not make a triangle
        } else {
            throw new ArithmeticException("not a triangle");
        }
    }
}
