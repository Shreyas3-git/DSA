package com.example.dsa_practice2025.array.twopointer;

public class ContainerWithMostWater
{
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea1(new int[] {1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] container) {
        /**
         *  BRUTE FORCE APPROACH - O(N^2)
         */
        int n = container.length,maxWater = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int height = Math.min(container[i],container[j]);
                int width = (j-i);
                int currentWater = (width*height);
                maxWater = Math.max(maxWater,currentWater);
            }
        }
        return maxWater;
    }

    public static int maxArea1(int[] container) {
        /**
         *   OPTIMAL SOLUTION - O(N)
         */
        int maxWater = 0,left = 0,right = container.length-1;
        while(left < right) {
            int height = Math.min(container[left],container[right]);
            int width = right-left;
            int currentWater = (width*height);
            maxWater = Math.max(maxWater,currentWater);
            if(container[left] < container[right])
                left++;
            else
                right--;
        }
        return maxWater;
    }
}
