package com.example.dsa_practice2025.hashing;

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
        Map<Character,Integer> freqMap = new HashMap<>();
        for(Character ch : s.toCharArray())
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        int oddCount = 0;
        for(Map.Entry<Character,Integer> map : freqMap.entrySet()) {
            if(map.getValue() % 2 != 0) {
                oddCount++;
                if(oddCount > 1)
                    return false;
            }

        }
        return true;
    }
}
