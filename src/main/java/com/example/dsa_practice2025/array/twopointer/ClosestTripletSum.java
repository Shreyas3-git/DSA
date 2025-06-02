package com.example.dsa_practice2025.array.twopointer;

import java.util.Arrays;

public class ClosestTripletSum
{
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {-1,2,1,-4},1));
    }

    static int threeSumClosest(int[] arr, int target) {
        /**
         *  algorithm:
         *  1)sort array to apply two pointer approach
         *  2)declare minDiff = int_max_value,closestSum = int_max_value
         *  3)iterate 0 to n-2
         *  4)check i > 0 and previous is same then continue
         *  5)declare left = i+1,right=n-1
         *  6)iterate left<right
         *      cal currentSum of triplet
         *      cal absolute difference between target and current-sum
         *  7)check diff < minDiff or diff == mindiff and currentSum < closestSum
         *      update closestSum
         *      update minDiff
         *  8)check closestsum == target
         *      return closestSum
         *  9)otherwise closestSum < target
         *      left++
         *  10)otherwise
         *      right--
         *  11)end loop
         *  12)end loop
         *  13)return answer
         */
        Arrays.sort(arr);
        int closestSum = Integer.MIN_VALUE,mindiff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length-2; i++) {
            int left = i+1,right = arr.length-1;

            while(left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                int diff = Math.abs(currentSum-target);
                if(diff < mindiff || diff == mindiff && currentSum > closestSum) {
                    closestSum = currentSum;
                    mindiff = diff;
                }
                if(currentSum == target)
                    return currentSum;
                else if(currentSum < target)
                    left++;
                else
                    right--;
            }
        }
        return closestSum;
    }
}
