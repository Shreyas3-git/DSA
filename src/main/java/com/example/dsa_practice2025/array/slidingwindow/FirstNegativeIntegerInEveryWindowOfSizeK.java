package com.example.dsa_practice2025.array.slidingwindow;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FirstNegativeIntegerInEveryWindowOfSizeK
{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(firstNegativeInteger(new long[] {12,-1,-7,8,-15,30,16,28},8,3)));
    }


    public static long[] firstNegativeInteger(long arr[], int n,int k) {
        /**
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
        int i = 0,j = 0;
        Queue<Long> queue = new ArrayDeque<>();
        long[] result = new long[n-k+1];
        while(j < n) {
            if(arr[j] < 0)
                queue.add(arr[j]);
            if(j-i+1 < k)
                j++;
            else if(j-i+1 == k) {
                if(queue.isEmpty())
                    result[i] = 0;
                else if(queue.peek() == arr[i])
                    result[i] = queue.poll();
                else
                    result[i] = queue.peek();
                i++;
                j++;
            }
        }
        return result;
    }

}
