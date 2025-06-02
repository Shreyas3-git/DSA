package com.example.dsa_practice2025.array.twopointer;

import java.util.Arrays;

public class SortColors
{
    public static void main(String[] args) {
        int[] colors = {2,0,2,1,1,0};
        sortColors2(colors);
        System.out.println(Arrays.toString(colors));
    }

    public static void sortColors(int[] nums) {
        /**
         *   BRUTE FORCE
         *   TIME COMPLEXITY = O(N^2)
         */
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    public static void sortColors1(int[] arr) {
        /**
         *   BETTER SOLUTION
         *   TIME COMPLEXITY - O(N)+O(N)+O(N)+O(N)
         */
        int n = arr.length;
        int zeros = 0,ones = 0,twos = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0)
                zeros++;
            else if(arr[i] == 1)
                ones++;
            else
                twos++;
        }
        for(int i = 0; i < zeros; i++) {
            arr[i] = 0;
        }
        n = zeros+ones;
        for(int i = zeros; i < n; i++) {
            arr[i] = 1;
        }
        n = zeros+ones+twos;
        for(int i = ones; i < n; i++) {
            arr[i] = 2;
        }
    }

    public static void sortColors2(int[] arr) {
        /**
         *   DUTCH NATIONAL FLAG ALGORITHM , TWO POINTER APPROACH
         *   algorithm:
         *   1)declare start = 0,mid = 0,end = 0
         *   2)iterate itll mid <= end
         *   3)arr[mid] == 0
         *      swap star,mid
         *      move start,mid
         *   4)arr[mid] == 1
         *      move mid
         *   5)arr[mid] == 2
         *      swap star,end
         *      move end
         *   6)end loop
         *
         */
        int start = 0,mid = 0,end = arr.length-1;
        while(mid <= end) {
            switch (arr[mid]) {
                case 0 -> {
                    swap(arr,start,mid);
                    start++;mid++;
                }
                case 1 -> mid++;
                case 2 -> {
                    swap(arr,start,end);
                    end--;
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
