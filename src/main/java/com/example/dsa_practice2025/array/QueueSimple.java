package com.example.dsa_practice2025.array;

import java.util.LinkedList;
import java.util.Queue;


public class QueueSimple
{
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}

