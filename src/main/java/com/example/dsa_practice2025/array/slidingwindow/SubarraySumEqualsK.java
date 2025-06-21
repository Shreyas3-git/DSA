package com.example.dsa_practice2025.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK
{
    //https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1
    //how many number of subarrays whos sum equals k
    public static void main(String[] args) {
//        System.out.println(largestSubarrayOfSum1(new int[] {-42,12,20,15,31,-4,0,15},0));
//        System.out.println(largestSubarrayOfSum1(new int[] {2, -1, 3, 1, 4, -2, -1, 2, 1, -3},5));
        System.out.println(largestSubarrayOfSum1(new int[] {-5,8,-14,2,4,4,12},-5));
    }


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
         *  THIS PROBLEM CAN'T solve with sliding window
         *  we can only solve using prefix sum approach it is getting failed when arr elements having positive and negative
         *  integers
         *  example - arr[] = [-5,8,-14,2,4,4,12], k = -5
         *  TC - O(N) * O(N*I)
         *  algorithm:
         *
         */
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int prefix = 0,maxLen = 0;
        for(int i = 0; i < arr.length; i++) {
            prefix += arr[i];
            if(map.containsKey(k-prefix)) {
                maxLen = Math.max(maxLen,i-map.get(k-prefix) );
            }
            if(!map.containsKey(prefix))
                map.put(prefix,i);
        }
        return maxLen;
    }
}
