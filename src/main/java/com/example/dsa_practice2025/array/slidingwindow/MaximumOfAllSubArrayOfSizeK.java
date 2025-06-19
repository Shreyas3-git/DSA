package com.example.dsa_practice2025.array.slidingwindow;

import java.util.*;

public class MaximumOfAllSubArrayOfSizeK
{
    public static void main(String[] args) {
        System.out.println(Arrays.asList(max_of_subarrays1(new int[]{1,2,3,1,4,5,2,3,6},3)));
    }


    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        /**
         *  TC - O(N*K)
         */
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            int max = arr[i];
            for (int j = i + 1; j < i + k; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            result.add(max);
        }

        return result;
    }

    static ArrayList<Integer> max_of_subarrays1(int arr[], int k) {
        /**
         *  arr = [1,2,3,1,4,5,2,3,6]           Deque = [ 5]      ans = [3,3,4,5,5,5,6]
         *  i = 3
         *  j = 6
         *
         *  TC - O(N)
         */
//        ArrayList<Integer> answer = new ArrayList<>();
//        Deque<Integer> deque = new ArrayDeque<>();
//        int i = 0, j = 0;
//        while(j < n) {
//            while(!deque.isEmpty() && deque.peekLast() < arr[j])
//                deque.removeLast();
//            deque.addLast(arr[j]);
//
//            if(j-i+1 < k)
//                j++;
//            else if(j-i+1 == k) {
//                if(deque.isEmpty())
//                    answer.add(-1);
//                else if(deque.peekFirst() == arr[i])
//                    deque.removeFirst();
//                else
//                    answer.add(deque.peekFirst());
//                i++;
//                j++;
//            }
//        }
//        return answer;
        Deque<Integer> dqueue = new ArrayDeque<>();
        int left = 0,right = 0,n = arr.length;
        ArrayList<Integer> answer = new ArrayList<>();
        while(right < n) {
            while(!dqueue.isEmpty() && dqueue.peekLast() < arr[right]) {
                dqueue.removeLast();
            }
            dqueue.addLast(arr[right]);

            if(right-left+1 < k)
                right++;
            else {
                if(dqueue.peekFirst() == arr[left])
                    answer.add(dqueue.pollFirst());
                else
                    answer.add(dqueue.peekFirst());
                left++;
                right++;
            }
        }
        return answer;

    }
}
