package com.example.dsa_practice2025.array.slidingwindow;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FirstNegativeIntegerInEveryWindowOfSizeK
{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(firstNegativeInteger1(new long[] {12,-1,-7,8,-15,30,16,28},8,3)));
    }




    public static long[] firstNegativeInteger(long[] arr, int n, int k) {
        /**
         * Brute Force Approach
         *
         * Time Complexity: O(N * K) - For each window, we iterate through k elements.
         * Space Complexity: O(N-K+1) - For the result array.
         *
         * Algorithm:
         * 1. Initialize result array of size n-k+1.
         * 2. Iterate through each possible starting index i from 0 to n-k.
         * 3. For each window starting at i, iterate through k elements to find the first negative integer.
         * 4. If a negative integer is found, store it in result[i]; otherwise, store 0.
         * 5. Return the result array.
         */
        long[] result = new long[n - k + 1];

        // Iterate through each possible window starting index
        for (int i = 0; i <= n - k; i++) {
            boolean found = false;
            // Check k elements in the current window
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    result[i] = arr[j]; // Store the first negative integer
                    found = true;
                    break; // Exit loop after finding the first negative
                }
            }
            // If no negative integer is found, store 0
            if (!found) {
                result[i] = 0;
            }
        }

        return result;
    }

    public static long[] firstNegativeInteger1(long arr[], int n,int k) {
        /**
         *
         *  TC - O(N)
         *  SC - O(N) + O(N-K+1)
         *  algorithm:
         *  1)declare i,j init 0
         *  2)declare queue of long
         *  3)declare result array of size n-k+1
         *  4)iterate till j < n
         *      check arr[j] < 0
         *          push_back in queue
         *      check current  window < k
         *          j++
         *      check current window hits window size
         *      check queue is empty
         *          - add 0 to result[i]
         *      otherwise check queue.peek equal to arr[i]
         *          poll from queue to result[i]
         *      otherwise
         *          add queue's peek to result[i]
         *      i++
         *      j++
         *  5)end loop
         *  6)return result
         */
        int left = 0,right = 0;
        long[] answer = new long[n-k+1];
        Queue<Long> queue = new ArrayDeque<>();
        while(right < n) {
            if(arr[right] < 0)
                queue.offer(arr[right]);
            if(right-left+1 < k)
                right++;
            else {
                if(queue.isEmpty())
                    answer[left] = 0;
                else if(queue.peek() == arr[left])
                    answer[left] = queue.poll();
                else
                    answer[left] = queue.peek();
                left++;
                right++;
            }
        }
        return answer;
    }




}
