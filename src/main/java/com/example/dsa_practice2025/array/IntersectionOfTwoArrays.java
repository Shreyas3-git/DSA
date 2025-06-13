package com.example.dsa_practice2025.array;

import java.util.*;

public class IntersectionOfTwoArrays
{

    /**
     * 350. Intersection of Two Arrays II
     */
    public static void main(String[] args) {
        int[] arr1 = {4, 8, 6, 3, 1, 7, 10, 2, 9, 5};
        int[] arr2 = {6, 12, 4, 15, 3, 17, 8, 19, 21, 23};

        System.out.println(Arrays.toString(intersectionOfTwoArraysBasic(arr1.length, arr1, arr2.length, arr2)));
    }

    static int[] intersectionOfTwoArraysBasic(int n, int[] a, int m, int[] b) {
        /**
         *  algorithm:
         *  1)declare map
         *  2)iterate list a and store freq along with number
         *  3)declare list intersection
         *  4)iterate list b
         *      1]check number is present in map && freq > 0
         *        -> add current num into result
         *        -> reduce freq of current num by 1
         *  5)end loop
         *  6)sort and return result
         */
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();
        for(int num : a)
            map.put(num,map.getOrDefault(num,0)+1);

        for(int num : b) {
            if(map.containsKey(num) && map.get(num) > 0) {
                intersection.add(num);
                map.put(num,map.get(num)-1);
            }
        }
        int[] answer = new int[intersection.size()];
        for(int  i = 0; i < intersection.size(); i++) {
            answer[i] = intersection.get(i);
        }
        return answer;
    }
}
