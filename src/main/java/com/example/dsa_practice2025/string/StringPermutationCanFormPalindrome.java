package com.example.dsa_practice2025.string;

import java.util.HashMap;
import java.util.Map;

public class StringPermutationCanFormPalindrome
{
    public static void main(String[] args) {
        System.out.println(isPermutationPalindrome("nnaamm"));
    }


    public static boolean isPermutationPalindrome(String s ) {
        /**
         * Sample input -
         * nnaamm
         * hello
         * Aab
         * Sample Output 1
         * True
         * False
         * False
         *
         * Explanation 1
         * nnaamm is a permutation of namman, which is a palindrome
         * hello is not a permutation of any palindrome
         * Aab is not a permutation of any palindrome
         */
        Map<Character,Integer> map = new HashMap<>();
        for(Character chars : s.toCharArray())
            map.put(chars,map.getOrDefault(chars,0)+1);

        int oddCount = 0;
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 != 0)
                oddCount++;
            if(oddCount  > 1)
                return false;
        }
        return true;
    }
}
