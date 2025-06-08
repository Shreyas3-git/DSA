package com.example.dsa_practice2025.array.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithKUniqueCharacters
{
    public static void main(String[] args) {
        String s = "aabacfebebebe";
        System.out.println(longestSubstringKUniqueChar(s.length(),s,4));
    }

    public static int longestSubstringKUniqueCharBrute(int n, String s, int k) {
        /**
         *  TC - O(N*N)
         *  SC - O(N)
         */
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> uniqueChars = new HashSet<>();
            for (int j = i; j < n; j++) {
                uniqueChars.add(s.charAt(j));
                if (uniqueChars.size() == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else if (uniqueChars.size() > k) {
                    break; // No point in going further
                }
            }
        }

        return maxLength;
    }

    public static int longestSubstringKUniqueChar(int n,String s,int k) {
        /**
         *   TC - O(N)
         *   SC - O(N)
         *   s = aabacebebebe
         *   algorithm:
         *   1)declare map
         *   2)declare i,j,max init 0
         *   3)iterate j < n
         *   4)put char along with freq
         *   5)check map.size() < k
         *      j++
         *   6)check map.size == k
         *      cal max
         *      j++
         *   7)check map.size > k
         *      iterate till map.size > k
         *      reduce freq by 1
         *       -check freq of current char == 0
         *          remove current char
         *      i++
         *      end loop
         *      j++
         *   8)end loop
         *   9)return max
         */
        Map<Character,Integer> freqMap = new HashMap<>();
        int i = 0, j = 0,max = 0;
        while(j < n) {
            char curr = s.charAt(j);
            freqMap.put(curr,freqMap.getOrDefault(curr,0)+1);
            if(freqMap.size() < k)
                j++;
            else if(freqMap.size() == k) {
                max = Math.max(max,j-i+1);
                j++;
            } else {
                while (freqMap.size() > k) {
                    char cur = s.charAt(i);
                    freqMap.put(cur, freqMap.get(cur)-1);
                    if(freqMap.get(cur) == 0)
                        freqMap.remove(cur);
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}
