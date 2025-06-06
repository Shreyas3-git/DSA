package com.example.dsa_practice2025.array.slidingwindow;

public class MaximumSumSubarrayOfSizeK
{
    public static void main(String[] args) {
        System.out.println(maximumsumSubarray(7,new int[] {2,5,1,8,2,9,1},3));
    }


    public static int maximumsumSubarray(int n,int[] arr,int k) {
        /**
         *  fix size sliding window approach
         *
         *  TC - O(N)
         *  SC - O(1)
         */
        int i = 0, j = 0,sum = 0,maxSum = Integer.MIN_VALUE;
        while(j < n) {
            sum += arr[j];
            if(j-i+1 < k) {
                j++;
            } else if(j-i+1 == k) {
                maxSum = Math.max(maxSum,sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }
}
