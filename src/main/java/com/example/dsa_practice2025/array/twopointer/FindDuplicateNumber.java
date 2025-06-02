package com.example.dsa_practice2025.array.twopointer;

public class FindDuplicateNumber
{
    /**
     *  SLOW-FAST TWO POINTER APPROACH
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] {1,3,4,2,2}));
    }

    public static int findDuplicate(int[] arr) {
        int slow = arr[0], fast = arr[0];
        do {
            slow = arr[slow];
            int x = arr[fast];
            fast = arr[x];
        } while(slow != fast);
        slow = arr[0];
        while(slow!= fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}
