package com.anhlq.ex1;

import java.util.Arrays;

public class M13SortAndSumArr {
    public static void main(String[] args) {
        // input array
        int[] arr = {4, 5, 1, 2, 3, 3, 3,4,5,4,52,12,312,-10,4124,};
        System.out.println(Arrays.toString(arr));
        // sort array
        quickSort(arr, 0, arr.length - 1);
        // sum of element in array
        sumArr(arr);
        // array after sort
        System.out.println(Arrays.toString(arr));

    }

    private static void sumArr(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println("Sum elements of the array is " + sum);
    }

    private static void quickSort(int[] arr, int start, int end) {

        int partition = partition(arr, start, end);

        if (partition - 1 > start) {
            quickSort(arr, start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSort(arr, partition + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];

        for (int i = start; i < end; i++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[i] < pivot) {

                // swap current and smaller element
                // increase start by 1
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }
        // swap start and pivot
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }
}
