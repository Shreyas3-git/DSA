package com.example.dsa_practice2025.array;

import java.util.Arrays;

public class BubbleSortArray
{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(4,new String[]{"abc","abd","ab","a"})));
    }

    static String[] sortArray(int n, String[] arr) {
        /**
         * 0    1  2  3
         * abc abd ab a
         * abc ab abd a
         * abc ab a abd
         * ab abc a abd
         * ab a abc abd
         * a ab abc abd
         * i = 3, j = 1
         *
         *  BUBBLE SORT algorithm -
         *  TC = O(n)^2
         *
         *  algorithm:
         *  1)iterate i from 0 to n
         *  2)iterate j from 0 to n-1
         *  3)check compare string lexicographically
         *      current element and next element using .compareTo
         *      1]swap both element if next
         *  4)end loop
         *  5)end loop
         *  6)return arr;
         *
         */
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n-1; j++) {
                if(arr[j].compareTo(arr[j+1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
