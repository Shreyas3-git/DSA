package com.example.dsa_practice2025.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        /**
         *  TC - O(N)
         *  SC - O(N)
         */
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, start = 0, end = s.length(), n = s.length();
        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        int count = map.size();
        while (right < n) {
            char cur = s.charAt(right);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0)
                    count--;
            }
            if (count > 0)
                right++;
            else {
                while (count == 0) {
                    if (right - left + 1 < end - start + 1) {
                        start = left;
                        end = right;
                    }
                    char curr = s.charAt(left);
                    if (map.containsKey(curr)) {
                        if (map.get(curr) == 0)
                            count++;
                        map.put(curr, map.get(curr) + 1);
                    }
                    left++;
                }
                right++;
            }
        }
        return s.substring(start, end+1);
    }


    int search(String pat, String txt) {
        // code here
        int left = 0,right = 0,k = pat.length(),n = txt.length(),answer = 0;
        Map<Character,Integer> freqMap = new HashMap<>();
        for(int i = 0;i < k; i++)
            freqMap.put(pat.charAt(i),freqMap.getOrDefault(pat.charAt(i),0)+1);
        int count = freqMap.size();
        while(right < n) {
            char ch = txt.charAt(left);
            if(freqMap.containsKey(ch)) {
                freqMap.put(ch,freqMap.get(ch)-1);
                if(freqMap.get(ch) == 0)
                    count--;
            }
            if(right-left+1 < k)
                right++;
            else {
                if(count == 0)
                    answer++;
                if(freqMap.containsKey(txt.charAt(left))) {
                    if(freqMap.get(txt.charAt(left)) == 0)
                        count++;
                    freqMap.put(txt.charAt(left),freqMap.get(txt.charAt(left)+1));
                }
                left++;
                right++;
            }
        }
        return answer;
    }

}