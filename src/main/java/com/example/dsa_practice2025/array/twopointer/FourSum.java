package com.example.dsa_practice2025.array.twopointer;

import java.util.*;

public class FourSum
{
    public static void main(String[] args) {
        System.out.println(fourSum2(new int[]{1,0,-1,0,-2,2},0));
    }

    public static List<List<Integer>> fourSum(int[] arr,int target) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n-3; i++) {
            for(int j = i+1; j < n-2; j++) {
                for(int k = j+1; k < n-1; k++) {
                    for(int l = k+1; l < n; l++) {
                        if(arr[i] + arr[j] + arr[k] + arr[l] == 0) {
                            List<Integer> list = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            Collections.sort(list);
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }


    public static List<List<Integer>> fourSum2(int[] arr,int target) {
        Arrays.sort(arr);
        List<List<Integer>> answer = new ArrayList<>();
        int n = arr.length;
        for(int i = 0; i < n-3; i++) {
            if(i > 0 && arr[i] == arr[i-1]) continue;
            for(int j = i+1; j < n-2; j++) {
                if(j > i+1 && arr[j] == arr[j-1]) continue;
                int left = j+1,right = n-1;
                while(left < right) {
                    long sum = (long) ((long)arr[i] + (long)arr[j] + (long)arr[left] + (long)arr[right]);
                    if(sum < target)
                        left++;
                    else if(sum > target)
                        right--;
                    else {
                        answer.add(List.of(arr[i],arr[j],arr[left],arr[right]));
                        left++;
                        right--;
                        while(left < right && arr[left] == arr[left-1]) left++;
                        while(left < right && right < n-1 && arr[right] == arr[right+1]) right--;
                    }
                }
            }
        }
        return answer;
    }
}
