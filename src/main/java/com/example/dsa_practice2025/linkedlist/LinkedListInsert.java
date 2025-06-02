package com.example.dsa_practice2025.linkedlist;

public class LinkedListInsert
{
    static ListNode head = new ListNode(5);

    public static void main(String[] args) {
        insertAtBeginning(4);
        insertAtBeginning(3);
        insertAtBeginning(2);
        insertAtBeginning(1);
        insertAtEnd(6);
        insertAtEnd(7);
        insertAtEnd(8);
        insertAtEnd(9);
        insertAtEnd(10);
        traverse(head);
    }

    public static void insertAtBeginning(int data) {
        ListNode newNode = new ListNode(data);
        if(head == null)
            head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public static void insertAtEnd(int data) {
        //1->2->null
        ListNode newNode = new ListNode(data);
        if(head == null) {
            head = newNode;
            return;
        } else {
            ListNode current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public static void traverse(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("NULL");
    }


}
