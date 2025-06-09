package com.example.dsa_practice2025.array.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters
{
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }


    public static int lengthOfLongestSubstringBrute(String s) {
        /**
         *  TC - O(N^2)
         *  SC - O(N)
         */
        int maxLength = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    break;
                } else {
                    set.add(c);
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }


    public static int lengthOfLongestSubstring(String s) {
        /**
         *  TC - O(N)
         *  SC - O(1) - MAXIMUM CHAR STORED IN WORST CASE 26
         *
         */
        int left = 0, right = 0,maxlen = 0,n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        while(right < n) {
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            if(right-left+1 == map.size()) {
                maxlen = Math.max(maxlen,right-left+1);
                right++;
            } else {
                while(map.size() < right-left+1) {
                    char cur = s.charAt(left);
                    map.put(cur,map.get(cur)-1);
                    if(map.get(cur) == 0)
                        map.remove(cur);
                    left++;
                }
                right++;
            }
        }
        return maxlen;
    }
}
