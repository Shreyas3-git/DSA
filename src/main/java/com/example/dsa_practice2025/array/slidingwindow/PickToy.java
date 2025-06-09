package com.example.dsa_practice2025.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PickToy
{
    public static void main(String[] args) {
        String s = "aabacfebebebe";
        System.out.println(pickToy(s.length(),s,3));
    }

    public static String pickToy(int n,String s,int k) {
        /**
         *  TC - O(N)
         *  SC - o(1)
         */

        Map<Character,Integer> freqMap = new HashMap<>(40);
        int left = 0, right = 0,start = -1,end = -1;
        while( right < n) {
            freqMap.put(s.charAt(right),freqMap.getOrDefault(s.charAt(right),0)+1);
            if(freqMap.size() < k)
                right++;
            else if(freqMap.size() == k) {
                start = left;
                end = right;
                right++;
            } else {
                while(freqMap.size() > k) {
                    freqMap.put(s.charAt(left),freqMap.get(s.charAt(left))-1);
                    if(freqMap.get(s.charAt(left)) == 0)
                        freqMap.remove(s.charAt(left));
                    left++;
                }
                right++;
            }
        }
        return s.substring(start,end);
    }
}
