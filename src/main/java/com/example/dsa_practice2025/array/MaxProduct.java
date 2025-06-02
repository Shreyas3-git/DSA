package com.example.dsa_practice2025.array;

public class MaxProduct
{
    public static void main(String[] args) {
        System.out.println(maxProduct2(4,new int[]{3,4,5,2}));
    }

    public static int maxProduct2(int n,int nums[]) {
        /**
         *   arr = [3,4,5,2]
         *                 0 1 2 3
         *   after sort = [2,3,4,5]
         *   i=2, j=3
         *   max = 12,maxSoFar = 12
         *
         */
        mergeSort(n,nums);
        int left = 0,right = 1,maxSoFar = Integer.MIN_VALUE;
        while(right < n) {
            int max = (nums[left]-1)*(nums[right]-1);
            maxSoFar = Math.max(max,maxSoFar);
            left++;
            right++;
        }
        return maxSoFar;
    }

    public static void mergeSort(int n,int[] arr) {
        if (n < 2) {
            return;
        }
        int midIndex = n / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[n-midIndex];

        for(int i = 0; i < midIndex; i++)
            leftHalf[i] = arr[i];
        for(int i = midIndex; i < n; i++)
            rightHalf[i-midIndex] = arr[i];

        mergeSort(midIndex,leftHalf);
        mergeSort(n-midIndex,rightHalf);
        merge(arr,leftHalf,rightHalf);
    }

    public static void merge(int[] originalArr,int[] leftHalf,int[] rightHalf) {
        int leftSize = leftHalf.length, rightSize = rightHalf.length;
        int i = 0, j = 0, k = 0;
        while(i < leftSize && j < rightSize) {
            if(leftHalf[i] <= rightHalf[j]) {
                originalArr[k] = leftHalf[i];
                i++;
            } else {
                originalArr[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while(i < leftSize) {
            originalArr[k] = leftHalf[i];
            i++;
            k++;
        }
        while(j < rightSize) {
            originalArr[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}
