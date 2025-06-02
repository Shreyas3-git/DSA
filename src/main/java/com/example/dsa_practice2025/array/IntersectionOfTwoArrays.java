package com.example.dsa_practice2025.array;

import java.util.*;

public class IntersectionOfTwoArrays
{
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(4, 8, 6, 3, 1, 7, 10, 2, 9, 5);
        List<Integer> b = Arrays.asList(6, 12, 4, 15, 3, 17, 8, 19, 21, 23);

        System.out.println(intersectionOfTwoArraysBasic(a.size(),a,b.size(),b));
    }

    static List<Integer> intersectionOfTwoArraysBasic(int n, List<Integer> a, int m, List<Integer> b) {
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
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num : a)
            freq.put(num,freq.getOrDefault(num,0)+1);

        List<Integer> intersection = new ArrayList<>();
        for(int num : b) {
            if(freq.containsKey(num) && freq.get(num) > 0) {
                intersection.add(num);
                freq.put(num,freq.get(num)-1);
            }
        }
        Collections.sort(intersection);
        return intersection;

    }
}
