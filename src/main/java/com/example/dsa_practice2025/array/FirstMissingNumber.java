package com.example.dsa_practice2025.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingNumber
{


    public static void main(String[] args) {
        int[] arr = {2, -3, 4, 1, 1, 7};
//        int[] arr1 = {9,12,4,1,2,-1,8};
        System.out.println(firstMissingPositive(arr));
    }

    static int missingNumber(int[] arr) {
        /**
         *  TIME COMPLEXITY - O(NlogN)
         *  SPACE COMPLEXITY - O(1)
         */
        Arrays.sort(arr);
        //[-3,1,1,2,4,7]
        int res = 1,n = arr.length;
        for(int i = 0; i < n; i++) {
            if(arr[i] == res)
                res++;
            else if(arr[i] > res )
                return res;
        }
        return n+1;
    }

    static int missingNumber1(int[] arr) {
        /**
         *  TIME COMPLEXITY - O(N)
         *  SPACE COMPLEXITY - O(N)
         */
        Set<Integer> set = new HashSet<>();
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        for(int i = 1;i <= n; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return n+1;
    }


    public static int firstMissingPositive(int[] arr) {
        /**
         *   HARD TAG QUESTION ON LEETCODE
         *   THIS IS OPTIMUM SOLUTION WITH
         *   TIME COMPLEXITY - O(N)
         *   SPACE COMPLEXITY - O(1)
         *   algorithm:
         *   1)declare size of array
         *   2)iterate array from 0 to n
         *   3)check and iterate when element lies in range 1 to n and a[a[i]-1] != a[i]
         *      swap element
         *   4)end loop
         *   5)iterate array from 0 to n
         *   6)check i+1 not present in current index
         *      return i+1 as first missing positive integer
         *   7)end loop
         *   8)return n+1
         */
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            while(arr[i] >= 1 && arr[i] <= n && arr[arr[i]-1] != arr[i]) {
                swap(arr[i]-1,i,arr);
            }
        }
        for(int i = 0; i < n; i++) {
            if(arr[i] != i+1)
                return i+1;
        }
        return n+1;
    }


    public static void swap(int a,int b,int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
