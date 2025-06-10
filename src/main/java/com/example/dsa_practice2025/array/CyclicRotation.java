package com.example.dsa_practice2025.array;

import java.util.Arrays;

public class CyclicRotation
{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(cyclicRotate(new int[]{1,2,3,4,5},2)));
    }

    public static int[] cyclicRotate(int[] arr, int k) {
        /**
         *   arr = [1,2,3,4,5] k = 2
         *
         *   algorithm:
         *   1)declare n init arr.len
         *   2)init rotation to reduce duplicate traversal k = k % n
         *   3)check k == 0
         *      return arr
         *   4)iterate i from 1 <= k
         *      1]declare function reverseArr(arr)
         *      2]declare temp init arr[n-1]
         *      3)iterate i from n-1 to 0
         *      4)right shift all the elements of array by 1
         *      5)end loop
         *      6)store arr[0]=temp
         *   5)end loop
         *   6)return arr
         */
        int n = arr.length;
        k = k % n;
        if(k == 0)
            return arr;
        for(int i = 1; i <= k; i++) {
            reverseArr(arr);
        }
        return arr;
    }

    private static void reverseArr(int[] arr) {
        int n = arr.length;
        int temp = arr[n-1];
        for(int i = n-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }

}
