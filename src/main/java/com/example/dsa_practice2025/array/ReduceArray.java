package com.example.dsa_practice2025.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class ReduceArray
{
    public static void main(String[] args) {
        System.out.println(reduceArray(5,new int[]{2,1,11,13,7}));
    }

    public static int reduceArray(int n, int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : arr) {
            pq.offer(num);
        }

        while(pq.size() > 1) {
            int largest = pq.poll();
            int secondLargest = pq.poll();
            pq.offer(Math.abs(largest-secondLargest));
        }
        return pq.poll();
    }
}
