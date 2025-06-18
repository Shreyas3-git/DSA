package com.example.dsa_practice2025.array.prefixsuffix;

import java.util.HashMap;
import java.util.Map;

public class GoodSubArray
{
    /**
     *  leetcode - 523. Continuous Subarray Sum
     *  tag - medium
     *
     */
    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23,2,4,6,7},6));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        /**
         *  algorithm:
         *  1)declare hashmap of int,int
         *  2)add 0,-1 index if whole array is mutiple of k
         *  3)declare prefix init 0
         *  4)iterate array from 0 to n
         *  5)cal prefix sum = prefixElement + arr[i]
         *  6)cal isMutiple of k prefix % k
         *  7)check isMutiple == 0
         *      return true
         *  7)otherwise check isMutple present in map and subarray length should be at leat 2
         *      return true
         *  9)check isMultiple not present in map
         *      - add into mat with index
         *  10)end loop
         *  11)return false
         */
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int isMultipleOfK = prefixSum % k;
            if(isMultipleOfK == 0 && i > 0)
                return true;
            else if(map.containsKey(isMultipleOfK) && i- map.get(isMultipleOfK) >= 2)
                return true;
            if(!map.containsKey(isMultipleOfK))
                map.put(isMultipleOfK,i);
        }
        return false;
    }
}
