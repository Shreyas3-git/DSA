package com.example.dsa_practice2025.array.slidingwindow;

public class LargestSubarrayOfSumK
{
    public static void main(String[] args) {
        System.out.println(largestSubarrayOfSum1(new int[] {4,1,1,1,2,3,5},7,5));
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


    public static int largestSubarrayOfSum1(int[] arr,int n,int k) {
        /**
         *  arr = [4,1,1,1,2,3,5]
         *  TC - O(N) * O(N*I)
         *  algorithm:
         *  1)declare i ,j ,sum,max init 0
         *  2)iterate j < n
         *  3)cal sum
         *  4)check sum < k
         *      j++
         *  5)check sum == k
         *     cal max
         *     j++
         *  6)check sum > k
         *      iterate till sum > k
         *      remove arr[i] from sum
         *      i++
         *      update max
         *      j++
         *  7)end loop
         *  8)return max
         */
        int i = 0,j = 0,sum = 0,max = 0;
        while(j < n) {
            sum += arr[j];
            if(sum < k)
                j++;
            else if(sum == k) {
                max = Math.max(max,j-i+1);
                j++;
            } else {
              while(sum > k) {
                  sum -= arr[i];
                  i++;
              }
              max = Math.max(max,j-i+1);
              j++;
            }
        }
        return max;
    }
}
