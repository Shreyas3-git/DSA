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
         *  2)iterate array from 1 to n
         *      -check arr[CI] != arr[i]
         *         duplicate = 0
         *      -otherwise
         *          duplicate++
         *      -duplicate <= 1
         *          currentIndex++
         *          arr[currentIndex] = arr[i]
         *   5)end loop
         *   6)return array copy from 0th index to currentIndex+1
         */
        int currentIndex = 0,duplicate = 0, n= arr.length;
        for(int i = 1; i < n; i++) {
            if( arr[currentIndex] != arr[i])
                duplicate = 0;
            else
                duplicate++;
            if(duplicate <= 1) {
                currentIndex++;
                arr[currentIndex] = arr[i];
            }
        }
        return Arrays.copyOfRange(arr,0,currentIndex+1);
    }
}

