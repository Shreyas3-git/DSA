package com.example.dsa_practice2025.array.twopointer;

import java.util.*;

public class FourSum
{
    public static void main(String[] args) {
        System.out.println(fourSum2(new int[]{1,0,-1,0,-2,2}));
    }

    public static List<List<Integer>> fourSum(int[] arr) {
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

    public static List<List<Integer>> fourSum1(int[] arr) {
        /**
         *   a+ b + c + d = 0 , 0 is target
         *   c + d = -a - b = target, so -a - b = target
         */
        Arrays.sort(arr);
        int n = arr.length;
        Set<List<Integer>> result = new HashSet<>();
        for(int i = 0; i < n-3; i++) {
            for(int j = i+1; j < n-2; j++) {
                int target = -arr[i]-arr[j]; // target = -a - b
                Set<Integer> set = new HashSet<>();
                for(int k = j+1; k < n; k++) {
                    int fourth = target - arr[k];
                    if(set.contains(fourth)) {
                        List<Integer> list = Arrays.asList(arr[i],arr[j],arr[k],fourth);
                        Collections.sort(list);
                        result.add(list);
                    }
                    set.add(fourth);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static List<List<Integer>> fourSum2(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < n-3; i++) {
            if(i > 0 && arr[i] == arr[i+1]) continue;
            for(int j = i+1; j < n-2; j++) {
                if(arr[j] == arr[j-1]) continue;
                int left = j+1,right = n-1;
                while(left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if(sum < 0)
                        left++;
                    else if(sum > 0)
                        right--;
                    else {
                        result.add(List.of(arr[i],arr[j],arr[left],arr[right]));
                        left++;
                        right--;
                        while(left<right && arr[left] == arr[left-1]) left++;
                        while(left<right && right < n-1 && arr[right] == arr[right+1]) right--;
                    }
                }
            }
        }
        return result;
    }
}
