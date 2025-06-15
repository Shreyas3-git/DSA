package com.example.dsa_practice2025.array.twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum
{
    public static void main(String[] args) {
        int[] arr = {2,7,11,13,15};
        System.out.println(Arrays.toString(twoSum(arr,9)));
        System.out.println(Arrays.toString(twoSum1(arr,9)));
        int[] arr2 = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum2(arr2,9)));
    }

    public static int[] twoSum(int[] arr,int target) {
        /**
         *  BRUTE FORCE SOLUTION
         *  TIME COMPLEXITY - O(N^2)
         */
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == target)
                    return new int[] {i,j};
            }
        }
        return arr;
    }

    public static int[] twoSum1(int[] arr,int target) {
        /**
         *  BETTER SOLUTION
         *  USED TWO POINTER APPROCH
         */
        /**
         *  algorithm:
         *  1)sort array
         *  2)declare start init 0 end n-1
         *  3)iterate till start < end
         *  4)cal sum using start and end pointers
         *  5)check sum == target
         *      return start,end
         *  6)sum < target
         *      start++
         *  7)sum > target
         *      end--
         *  8)end loop
         *  9)return -1,-1 default index
         *
         *  TIME COMPLEXITY - O(nlogn) + O(n) i.e -> O(nlogn)
         */
        Arrays.sort(arr);
        int start = 0,end = arr.length-1;
        while(start < end) {
            int sum = arr[start] + arr[end];
            if(sum == target)
                return new int[] {start,end};
            else if(sum < target)
                start++;
            else
                end--;
        }
        return arr;
    }

    public static int[] twoSum2(int[] nums, int target) {
        /**
         *  OPTIMIZED SOLUTION
         *  TIME COMPLEXITY - O(N)
         *  algorithm:
         *  1)declare map
         *  2)iterate array
         *  3)cal diff target - num[i]
         *  4)check diff key contains in map
         *      return map.get,i
         *  5)otherwise
         *      put elements in map
         *  6)end loop
         *  7)return num (because there is always solution present of 2 two mentioned in leetcode problem)
         */
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int diff = target- nums[i];
            if(map.containsKey(diff)) {
                return new int[] {map.get(diff),i};
            } else {
                map.put(nums[i],i);
            }
        }
        return nums;
    }
}
