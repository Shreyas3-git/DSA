package com.example.dsa_practice2025.array.twopointer;

import java.util.*;

public class ThreeSumOrTripletWithZeroSum
{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new List[]{threeSum1(new int[]{-1, 0, 1, 2, -1, -4})}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        /**
         *  better approach but not optimized
         */
        int n = nums.length;
        Set<List<Integer>> uniqueTriplets = new HashSet<>();
        // a + b + c = 0
        // b + c = -a = target
        for (int i = 0; i < n-2; i++) {
            int target = -nums[i]; // b + c = -a
            Set<Integer> set = new HashSet<>();
            for(int j = i+1; j < n-1; j++) {
                int third = target - nums[j]; // c = target - b
                if(set.contains(third)) {
                    List<Integer> list = Arrays.asList(nums[i],nums[j],third);
                    Collections.sort(list);
                    uniqueTriplets.add(list);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(uniqueTriplets);
    }

    public static List<List<Integer>> threeSum1(int[] arr) {
        /**
         *  optimized approach using 2 pointer
         *  arr = [-1,0,1,2,-1,-4]
         *  algorithm:
         *  1)sort array
         *  2)declare result list of list
         *  3)iterate arr
         *  4)check i > 0 and arr[i] == arr[i-1] continue
         *  5)declare left = i+1,right = n-1
         *  6)iterate till left < right
         *  7)check triplet sum < 0
         *      left++
         *  8)otherwise triplet sum > 0
         *      right--
         *  9)otherwise
         *      declare list with triplets
         *      add list into result
         *      left++
         *      right--
         *  10)iterate with left < right and arr[left] == arr[left-1] left++
         *  11)iterate with left < right and arr[right] == arr[right+1] right--
         *  12)end loop
         *  13)end loop
         *  14)return result
         *
         */
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(i > 0 && arr[i-1] == arr[i]) continue;
            int left = i+1,right = n-1;
            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0) {
                    List<Integer> list = List.of(arr[i],arr[left],arr[right]);
                    answer.add(list);
                    left++;
                    right--;
                    while(left < right && arr[left] == arr[left+1]) left++;
                    while(left < right && right < n-1 && arr[right] == arr[right+1]) right--;
                } else if(sum < 0)
                    left++;
                else
                    right--;
            }
        }
        return answer;
    }
}
