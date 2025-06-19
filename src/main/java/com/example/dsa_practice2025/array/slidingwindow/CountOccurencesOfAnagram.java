package com.example.dsa_practice2025.array.slidingwindow;

import java.util.*;

public class CountOccurencesOfAnagram
{
    public static void main(String[] args) {
        System.out.println(search("for","forxxorfxdofr"));
    }



    public static int occurrencesOfAnagram(String pat, String txt) {
        /**
         * Brute Force Approach
         *
         * Time Complexity: O(N * K) - For each substring of length K, we compute its frequency map.
         * Space Complexity: O(K) - For the frequency maps of pat and each substring.
         *
         * Algorithm:
         * 1. Create a frequency map for the pattern string pat.
         * 2. Iterate through each possible substring of txt with length equal to pat.length().
         * 3. For each substring, create a frequency map and compare it with pat's frequency map.
         * 4. If the frequency maps match, increment the count of anagrams.
         * 5. Return the total count of anagrams.
         */
        // Create frequency map for pattern
        Map<Character, Integer> patFreq = new HashMap<>();
        for (char c : pat.toCharArray()) {
            patFreq.put(c, patFreq.getOrDefault(c, 0) + 1);
        }

        int n = txt.length();
        int k = pat.length();
        int ans = 0;

        // Iterate through each possible substring starting index
        for (int i = 0; i <= n - k; i++) {
            // Create frequency map for the current substring
            Map<Character, Integer> windowFreq = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                char c = txt.charAt(j);
                windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            }

            // Compare frequency maps
            if (windowFreq.equals(patFreq)) {
                ans++;
            }
        }

        return ans;
    }



    public static int occurrencesOfAnagram1(String pat,String txt) {
        /**
         *  TC - O(N) + O(N)
         *  SC - O(N)
         */
        Map<Character,Integer> freqMap = new HashMap<>();
        for(int i = 0; i < pat.length(); i++)
            freqMap.put(pat.charAt(i),freqMap.getOrDefault(pat.charAt(i),0)+1);
        int i = 0,j = 0,n = txt.length(),k = pat.length(),count = freqMap.size(),ans = 0;
        while(j < n) {
            char cur = txt.charAt(j);
            if(freqMap.containsKey(cur)) {
                freqMap.put(cur,freqMap.get(cur)-1);
                if(freqMap.get(cur) == 0)
                    count--;
            }
            if(j-i+1 < k)
                j++;
            else if(j-i+1 == k) {
                if(count == 0)
                    ans++;
                char curr = txt.charAt(i);
                if(freqMap.containsKey(curr)) {
                    freqMap.put(curr,freqMap.get(curr)+1);
                    if(freqMap.get(curr) == 1)
                        count++;
                }
                i++;
                j++;
            }
        }
        return ans;
    }


    static int search(String pat, String txt) {
        // code here
        int left = 0,right = 0,k = pat.length(),n = txt.length(),answer = 0;
        Map<Character,Integer> freqMap = new HashMap<>();
        for(int i = 0;i < k; i++)
            freqMap.put(pat.charAt(i),freqMap.getOrDefault(pat.charAt(i),0)+1);
        int count = freqMap.size();
        while(right < n) {
            char ch = txt.charAt(right);
            if(freqMap.containsKey(ch)) {
                if(freqMap.get(ch) > 0) {
                    freqMap.put(ch,freqMap.get(ch)-1);
                    count--;
                }
            }
            if(right-left+1 < k)
                right++;
            else {
                if(count == 0)
                    answer++;
                char cur = txt.charAt(left);
                if(freqMap.containsKey(cur)) {
                    if(freqMap.get(cur) == 0)
                        count++;
                    freqMap.put(cur,freqMap.get(cur)+1);
                }
                left++;
                right++;
            }
        }

        return answer;
    }

}
