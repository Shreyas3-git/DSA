package com.example.dsa_practice2025.string;

public class RemoveAllOccurencesOfString
{
    /**
     *  1910. Remove All Occurrences of a Substring
     *  tag -Medium
     *
     *  youtube video link - https://www.youtube.com/watch?v=dSRFgEs3a6A
     */
    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc","abc"));
    }


    public static String removeOccurrences(String s, String part) {
        /**
         *  BRUTE FORCE
         *  TIME COMPLEXITY - O(N*M) i.e O(N^2)
         */
        int partLen = part.length();
        while(s.contains(part)) {
            s = s.replaceAll(part,"");
        }
        return s;
    }


    public static String removeOccurrences1(String s, String part) {
        /**
         *  TIME COMPLEXITY - O(N)
         *  SPACE COMPLEXITY - O(N)
         *  algorithm:
         *  1)declare string builder
         *  2)declare length of string part
         *  3)iterate str s
         *  3)append character to builder
         *  4)builder.length >= partLen and builder substr start builder.len - partlen
         *       exactly equal partlen
         *  5)builder set length builder.length-partlen
         *  6)end loop
         *  7)return builder.toString
         */
        StringBuilder builder = new StringBuilder();
        int partLen = part.length();
        for(int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i));
            if(builder.length() >= partLen && builder.substring(builder.length() - partLen).equals(part))
                builder.setLength(builder.length()-partLen);
        }
        return builder.toString();
    }

}
