package com.example.dsa_practice2025.hashing;

import java.util.*;

public class GroupAnagram
{
    public static void main(String[] args) {
        System.out.println(groupAnagrams1(new String[] {"eat","tea","tan","ate","nat","bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        /**
         *  OPTIMUM APPROACH
         *  TC - N * O(MLOGM)
         *  SC - O(N*M)
         *  algorithm:
         *  1)declare map of str,list<str>
         *  2)iterate str array
         *  3)declare char array from current string
         *  4)sort char array,convert to string
         *  5)check sortedStr is present in map
         *      -current current str into map value
         *  6)otherwise
         *      -create new list<string>
         *      -add str into list
         *      -put sortedStr,list into map
         *  7)end loop
         *  8)create list<list<string>> assign map.values
         *  9)return result
         */
        Map<String,List<String>> hMap = new HashMap<>();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(hMap.containsKey(sortedStr)) {
                List<String> list = new ArrayList<>(hMap.get(sortedStr));
                list.add(str);
                hMap.put(sortedStr,list);
            } else {
                hMap.put(sortedStr,List.of(str));
            }
        }
        List<List<String>> answer = new ArrayList<>(hMap.values());
        return answer;
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        /**
         *  better approach -
         *  TC - O(N*M)
         *  SC - O(N*M)
         */
        Map<String,List<String>> freqMap = new HashMap<>();
        for(String str : strs) {
            String strFrequency = getFrequencyString(str);
            if(freqMap.containsKey(strFrequency)) {
                List<String> list = new ArrayList<>(freqMap.get(strFrequency));
                list.add(str);
                freqMap.put(strFrequency,list);
            } else {
                freqMap.put(strFrequency,List.of(str));
            }
        }
        List<List<String>> answer = new ArrayList<>(freqMap.values());
        return answer;

    }

    private static String getFrequencyString(String str) {
        int[] freqArr = new int[26];
        for(char ch : str.toCharArray())
            freqArr[ch-'a']++;
        StringBuilder strFrequency = new StringBuilder("");
        for(int freq : freqArr) {
            int ascii = freq + 97;
            char ch = (char) ascii;
            strFrequency.append(ch);
            strFrequency.append(freq);
        }
        return strFrequency.toString();
    }
}
