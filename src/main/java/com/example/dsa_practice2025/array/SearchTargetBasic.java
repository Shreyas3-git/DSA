package com.example.dsa_practice2025.array;

public class SearchTargetBasic
{
    public static void main(String[] args) {
        System.out.println(searchTarget(new int[]{1,3,5,7,13},7));
    }

    static int searchTarget(int arr[],int x) {
        /**
         *  5  7
         *   0 1 2 3 4
         *  [1,3,5,7,13]
         *  algorithm:
         *  1)declare left = 0,right = n-1;
         *  2)iterate left < right
         *  3)calculate mid = left + (right - left)/2 (to avoid integer overflow)
         *  4)check arr[mid] == x
         *      return mid
         *  5)check arr[mid] < x
         *      left = mid+1
         *  6)else
         *      right = mid-1
         *  7)end loop
         *  8)return -1
         */
        int left = 0,right = arr.length-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == x)
                return mid;
            else if(arr[mid] < x)
                left = mid+1;
            else
                right = mid-1;
        }
        return -1;
    }
}
