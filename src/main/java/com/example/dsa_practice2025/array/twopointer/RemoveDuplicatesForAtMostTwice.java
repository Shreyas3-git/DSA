package com.example.dsa_practice2025.array.twopointer;

import java.util.Arrays;

public class RemoveDuplicatesForAtMostTwice
{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeDuplicatesAtMostTwice(new int[] {0,0,1,1,1,1,2,3,3})));
    }


    public static int[] removeDuplicatesAtMostTwice(int arr[]) {
        /**
         *         0 1 2 3 4 5 6 7 8
         *  arr = [0,0,1,1,1,1,2,3,3]
         *  currentIndex = 4, index = 7,duplicates = 0
         *  result = [0,0,1,1,2,1,2,3,3]
         *  algorithm:
         *  1)declare currentIndex,duplicates init 0
         *  2)iterate array
         *  3)checl arr[CI] != arr[i]
         *      store element at CI
         *      move CI
         *      make duplicates 0
         *   4)otherwise check duplicates <= 1
         *      store element at CI
         *      move CI
         *   5)end loop
         *   6)return array copy from 0th index to currentIndex
         */
        int currentIndex = 0,duplicates = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[currentIndex] != arr[i])
                duplicates = 0;
            else
                duplicates++;
            if(duplicates <= 1) {
                arr[currentIndex] = arr[i];
                currentIndex++;
            }
        }
        return Arrays.copyOfRange(arr,0,currentIndex);
    }
}

