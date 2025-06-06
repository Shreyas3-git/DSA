package com.example.dsa_practice2025.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurencesOfAnagram
{
    public static void main(String[] args) {
        System.out.println(occurencesOfAnagram("for","forxxorfxdofr"));
    }


    public static int occurencesOfAnagram(String pat,String txt) {
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

}
