package com.example.dsa_practice2025.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
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
        if(s.length() != t.length())
            return false;
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for(int i = 0;i < s.length(); i++) {
            if(chars1[i] != chars2[i])
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
        Map<Character,Integer> map = new HashMap<>();
        for(char x : s.toCharArray())
            map.put(x,map.getOrDefault(x,0)+1);
        for(int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))) {
                char cur = t.charAt(i);
                map.put(cur,map.get(cur)-1);
                if(map.get(cur) == 0)
                    map.remove(cur);
            } else
                return false;
        }
        return true;
    }

}