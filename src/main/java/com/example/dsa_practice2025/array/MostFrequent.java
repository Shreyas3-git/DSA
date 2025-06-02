package com.example.dsa_practice2025.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostFrequent
{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mostFrequent("Statements are unique")));
    }

    // TODO: Implement this method
    static Object[] mostFrequent(String s) {
        /**
         *        0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
         *  i/p = S t a t e m e n t s a  r  e  u  n  i  q  u  e
         *  map = [[s,1],[t,2]]
         *  max = 1
         *  maxChar = s
         *  algorithm:
         *  1)declare map<char,int>
         *  2)declare maxChar = \0
         *  3)iterate s for all charac
         *  4)put current character along with freq+1 in map
         *  5)check maxFreq == currentCharFreq && maxChar > currentChar
         *      1] update maxChar with minAscii value
         *  6)check maxFreq < currentCharFreq
         *      maxFreq = currentCharFreq
         *      maxChar = currentChar
         *  7)end loop
         *  8)return result
         */
        Map<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;
        char maxChar = '\0';
        for(Character curr : s.toCharArray()) {
            map.put(curr,map.getOrDefault(curr,0)+1);
            if(maxFreq == map.get(curr) && maxChar > curr) {
                maxChar = curr;
            } else if(maxFreq < map.get(curr)) {
                maxFreq = map.get(curr);
                maxChar = curr;
            }
        }
        return new Object[]{maxChar,maxFreq};
    }
}
