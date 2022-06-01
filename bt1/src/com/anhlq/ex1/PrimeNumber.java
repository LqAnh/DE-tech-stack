package com.anhlq.ex1;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        int num = sc.nextInt();
        checkPrime(num);
    }

    private static void checkPrime(int num) {
        boolean flag = false;
        if (num ==0 || num ==1){
            flag = true;
        }
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
