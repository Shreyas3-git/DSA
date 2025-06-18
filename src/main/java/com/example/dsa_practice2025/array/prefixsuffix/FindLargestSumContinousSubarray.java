package com.example.dsa_practice2025.array.prefixsuffix;

public class FindLargestSumContinousSubarray
{
    public static void main(String[] args) {
        System.out.println(contigiousSequence1(new int[]{-2,-3,4,-1,-2,1,5,-3},8));
    }

    public static  long contigiousSequence(int arr[] , int n) {
        /**
         *  arr = [-2,-3,4,-1,-2,1,5,-3]
         *  BRUTE FORCE APPROACH
         *  TC - O(N^2)
         *  SC - O(1)
         */
        int maxSum = 0;
        for(int i = 0; i < n; i++) {
            int sum = arr[i];
            for(int j = i+1; j < n; j++) {
                sum+= arr[j];
                if(sum > maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }

    public static  long contigiousSequence1(int arr[] , int n) {
        /**
         *  OPTIMAL SOLUTION USING KADANE'S ALGORITHM
         *  arr = [-2,-3,4,-1,-2,1,5,-3]
         *  algorithm:
         *  1)declare maxSofar with integer min_value,maxendinghere with 0
         *  2)iterate array from 0 to n
         *  3)cal maxendinghere
         *  4)check maxending_here < current element
         *      update maxending_here with current
         *  5)check maxSofar < maxEndingHere
         *      update maxSofar with maxEndingHere
         *  6)end loop
         *  7)return maxSoFar
         */
        int maxSoFar = Integer.MIN_VALUE,maxEndingHere = 0;
        for(int i = 0; i < n; i++) {
            maxEndingHere += arr[i];
            if(maxEndingHere < arr[i])
                maxEndingHere = arr[i];
            if(maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
        }
        return maxSoFar;
    }
}
