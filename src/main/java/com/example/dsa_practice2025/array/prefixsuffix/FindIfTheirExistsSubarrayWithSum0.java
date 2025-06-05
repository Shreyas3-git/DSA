package com.example.dsa_practice2025.array.prefixsuffix;

import java.util.*;

public class FindIfTheirExistsSubarrayWithSum0
{
    public static void main(String[] args) {
        List<int[]> result = subarraySumZero1(new int[]{1, 2, -3, 4, 5, -6, 7, -7, 3, -6});
        for(int i = 0; i < result.size(); i++) {
            System.out.print(Arrays.toString(result.get(i)));
        }
    }

    public static List<int[]> subarraySumZero(int[] arr) {
        /**
         *  BRUTE FORCE APPROACH
         *  TC - O(N^2)
         *  SC - O(N)
         */
        List<int[]> result = new ArrayList<>();
        int sum, n = arr.length;
        for(int i = 0; i < n; i++) {
            sum = arr[i];
            for(int j = i+1; j < n; j++) {
                sum += arr[j];
                if(sum == 0) {
                    int[] nums = Arrays.copyOfRange(arr,i,j+1);
                    result.add(nums);
                }
            }
        }
        return result;
    }
    public static List<int[]> subarraySumZero1(int[] arr) {
        /**
         *  TC - O(N)
         *  SC - O(N)
         *  algorithm:
         *  1)delcare map of int,int
         *  2)put default 0 with -1 index which is out of bound to count 0 got anywhere in sum pick array from -1+1
         *      which index 0
         *  3)declare prefixSum init 0
         *  4)iterate array from 0 to n
         *  5)cal prefixSum
         *  6)declare result list of int[]
         *  6)check prefixSum present in map
         *      add that subarray into result
         *  7)otherwise
         *      add into map key as prefixSum,index
         *  8)end loop
         *  9)return result
         */
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int prefix = 0, n = arr.length;
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            prefix += arr[i];
            if(map.containsKey(prefix))
                result.add(Arrays.copyOfRange(arr,(map.get(prefix)+1),i+1));
            else
                map.put(prefix,i);
        }
        return result;
    }
}
