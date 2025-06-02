package com.example.dsa_practice2025.linkedlist;

public class LinkedListRemove
{
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);

        linkedListRemove(7,head);
        traverse(head);
    }


    public static void linkedListRemove(int x,ListNode head) {
        ListNode current = head;
        if(head == null)
            return;
        else if(current.val == x) {
            current.next = current.next.next;
        } else {
            while(current.next != null) {
                if(current.next.val == x) {
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
            }
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
