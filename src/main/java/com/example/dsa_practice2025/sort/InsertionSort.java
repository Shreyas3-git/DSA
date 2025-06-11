package com.example.dsa_practice2025.sort;

import java.util.Arrays;

public class InsertionSort
{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5, 4, 3, 2, 1})));
    }

    static int[] sortArray(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key)  {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

}
