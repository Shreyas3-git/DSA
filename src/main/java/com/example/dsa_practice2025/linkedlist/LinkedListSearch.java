package com.example.dsa_practice2025.linkedlist;

public class LinkedListSearch
{
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println(linkedListSearch(7,head));

    }


    public static boolean linkedListSearch(int x,ListNode head) {
        ListNode current = head;
        while(current != null) {
            if(current.val == x) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

}
