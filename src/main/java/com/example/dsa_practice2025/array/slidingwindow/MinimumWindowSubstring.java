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
}