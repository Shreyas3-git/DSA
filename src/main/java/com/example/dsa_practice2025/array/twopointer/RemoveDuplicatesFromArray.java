package com.example.dsa_practice2025.array.twopointer;

import java.util.Arrays;

public class RemoveDuplicatesFromArray
{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeDuplicates(new int[] {0,0,1,1,1,1,2,3,3})));
    }

    public static int[] removeDuplicates(int arr[]) {
        int currentIndex = 0, n = arr.length;
        for(int i = 1; i < n; i++) {
            if(arr[currentIndex] != arr[i]) {
                currentIndex++;
                arr[currentIndex] = arr[i];
            }
        }
        return Arrays.copyOfRange(arr,0,currentIndex+1);
    }
}
