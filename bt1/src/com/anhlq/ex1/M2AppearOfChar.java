package com.anhlq.ex1;

import java.util.*;

public class M2AppearOfChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        characterCount(str);
    }

    private static void characterCount(String inputString) {
        // Creating a HashMap containing char
        // as a key and occurrences as a value
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Remove all space in string
        inputString = inputString.replaceAll("\\s", "");

        // Converting given string to char array
        char[] strArray = inputString.toCharArray();

        System.out.println(strArray);
        // checking each char of strArray
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {

                // If char is present in charCountMap,
                // incrementing it's count by 1
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {

                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                charCountMap.put(c, 1);
            }
        }

        // Printing the charCountMap
        // All char appear
        //noinspection rawtypes
        for (Map.Entry entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        // Most appear char
        Character key = Collections.max(charCountMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Most appearance char is " + key + " appear " + charCountMap.get(key) + " times");
    }
}
