package com.example.dsa_practice2025.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupAnagram {
    public static void main(String[] args) {
        System.out.println(validAnagram2("anagram","nagaram"));
    }


    public static boolean validAnagram(String s, String t) {
        /**
         *  BRUTE FORCE APPROACH
         *  O(N^2)
         *  s = anagram
         *  t = 0000000
         */
        if (s.length() != t.length())
            return false;
        char[] chars = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            for (int j = 0; j < t.length(); j++) {
                if (chars[j] == cur)
                    chars[j] = '/';
                else
                    return false;
            }
        }
        return true;
    }


    public static boolean validAnagram1(String s, String t) {
        /**
         *  BETTER APPROACH - O(NlogN)
         */
        if (s.length() != t.length())
            return false;
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i])
                return false;
        }
        return true;
    }

    public static boolean validAnagram2(String s, String t) {
        /**
         *  OPTIMAL SOLUTION -
         *  TIME COMPLEXITY - O(N)
         *  SPACE COMPLEXITY - O(N)
         */
        if(s.length() != t.length())
            return false;
        Map<Character,Integer> freqMap = new HashMap<>();
        for(char chars : s.toCharArray())
            freqMap.put(chars, freqMap.getOrDefault(chars,0)+1);

        for(int i = 0; i < t.length(); i++) {
            char cur = t.charAt(i);
            if(freqMap.containsKey(cur)) {
                freqMap.put(cur, freqMap.get(cur)-1);
                if(freqMap.get(cur) == 0)
                    freqMap.remove(cur);
            } else
                return false;
        }
        return freqMap.isEmpty();
    }

}