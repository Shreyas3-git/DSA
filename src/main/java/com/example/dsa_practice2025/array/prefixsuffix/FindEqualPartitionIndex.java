package com.example.dsa_practice2025.array.prefixsuffix;

public class FindEqualPartitionIndex {
    public static void main(String[] args) {
        System.out.println(equalPartition1(10, new long[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }


    static int equalPartition(int n, long arr[]) {
        /**
         *  BRUTE FORCE SOLUTION
         *  TIME COMPLEXITY - O(N^2)
         *  1,4,7,5
         */
        int prefixSum = 0, suffixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            suffixSum = 0;
            for (int j = arr.length - 1; j >= 0; j--) {
                suffixSum += arr[j];
                if (suffixSum > prefixSum)
                    break;
                else if (prefixSum == suffixSum)
                    return i + 1;
            }
        }
        return -1;
    }

    static int equalPartition1(int n, long arr[]) {
        /**
         *  BETTER APPROACH-
         *  TIME COMPLEXITY - O(N)
         *  SPACE COMPLEXITY - O(N) + O(N)
         *  arr = [1,4,7,5]
         *  algorithm:
         *  1)declare arr prefix of size n
         *  2)declare arr suffix of size n
         *  3)iterate arr from 0 to n
         *      if i == 0 add element into prefix 0 index
         *      otherwise prefix of previous element + currentelement
         *  4)end loop
         *  5)iterate arr from n-1 to n
         *      if i == n-1 add arr[n-1] to suffix[n-1]
         *      otherwise suffix[i+1] + arr[i]
         *  6)iterate arr from 0 to n
         *  7)check prefix[i] == suffix[i]
         *      return i
         *  8)end loop
         *  9)return -1
         */
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) prefix[i] = arr[i];
            else prefix[i] = prefix[i - 1] + arr[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) suffix[n - 1] = arr[i];
            else suffix[i] = suffix[i + 1] + arr[i];
        }

        for (int i = 0; i < n; i++) {
            if (prefix[i] == suffix[i])
                return i;
        }
        return -1;
    }



}
