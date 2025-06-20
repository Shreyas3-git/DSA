package com.example.dsa_practice2025.array.slidingwindow;

import java.util.HashMap;

public class SubarraySumEqualsK
{
    //https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1
    //how many number of subarrays whos sum equals k
    public static void main(String[] args) {
//        System.out.println(largestSubarrayOfSum1(new int[] {-42,12,20,15,31,-4,0,15},0));
        System.out.println(largestSubarrayOfSum1(new int[] {2, -1, 3, 1, 4, -2, -1, 2, 1, -3},5));    }


    public static int largestSubarrayOfSum(int[] arr, int n, int k) {
        /**
         *  TC - O(N^3)
         */
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int t = i; t <= j; t++) {     // compute sum of arr[i..j]
                    sum += arr[t];
                }
                if (sum == k) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }


    public static int largestSubarrayOfSum1(int[] arr,int k) {
        /**
         *  arr = [4,1,1,1,2,3,5]
         *  TC - O(N) * O(N*I)
         *  algorithm:
         *
         */
        int left = 0, right = 0, n = arr.length, sum = 0, maxlen = 0;
        while(right < n) {
            sum += arr[right];
            if(sum < k) {
                right++;
            } else if(sum == k) {
                maxlen = Math.max(maxlen,right-left+1);
                right++;
            } else {
                while(sum > k && left <= right) {
                    sum -= arr[left];
                    left++;
                }
                if(sum == k && maxlen < right-left+1) {
                    maxlen = right-left+1;
                }
                right++;
            }
        }
        return maxlen;
    }
}
