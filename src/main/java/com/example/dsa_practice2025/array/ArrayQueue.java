package com.example.dsa_practice2025.array;

public class ArrayQueue
{
    public int queue[];
    public int capacity;
    public int front;
    public int rear;
    public int size;

    public ArrayQueue(int capacity) {
        this.queue = new int[capacity];
        this.capacity = capacity;
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }


    public boolean offer(Integer element) {
        if(size == capacity) {
            System.out.println("Queue is Full");
            return false;
        }
        rear = (rear+1) % capacity;
        queue[rear] = element;
        size++;
        return true;
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front];
    }


    public int poll() {
        if (size == 0) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int removed = queue[front];
        front = (front+1)%capacity;
        size--;
        return removed;
    }

}
