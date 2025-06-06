package com.example.dsa_practice2025.array.slidingwindow;

public class MaximumSumSubarrayOfSizeK
{
    public static void main(String[] args) {
        System.out.println(maximumSumSubarray1(7,new int[] {2,5,1,8,2,9,1},3));
    }

    public static int maximumSumSubarray(int n, int[] arr, int k) {
        /**
         * Brute Force Approach
         *
         * Time Complexity: O(N * K) - For each starting index, we compute the sum of K elements.
         * Space Complexity: O(1) - Only use variables for sum and maxSum.
         *
         * Algorithm:
         * 1. Iterate through each possible starting index i from 0 to n-k (inclusive).
         * 2. For each i, compute the sum of the subarray of size k starting at i.
         * 3. Update maxSum if the current subarray sum is greater.
         * 4. Return maxSum.
         */
        int maxSum = Integer.MIN_VALUE;

        // Iterate through each possible starting index
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            // Compute sum of subarray of size k starting at index i
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            // Update maxSum if current sum is greater
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
    public static int maximumSumSubarray1(int n,int[] arr,int k) {
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
