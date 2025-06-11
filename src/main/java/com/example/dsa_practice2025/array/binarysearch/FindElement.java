package com.example.dsa_practice2025.array.binarysearch;

public class FindElement
{
    public static void main(String[] args) {
        System.out.println(findElement(5,new int[]{1,2,3,4,5},1));
    }


    // TODO: Implement this method
    static int findElement(int n, int[] arr, int x) {
        /**
         *  Array is in sorted form
         */
        int left = 0,right = n-1;
        while(left <= right) {
            int mid = left + (right-left) / 2;
            if(arr[mid] == x)
                return mid;
            else if(arr[mid] < x)
                left++;
            else
                right--;
        }
        return -1;
    }
}
