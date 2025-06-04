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
         *  TIME COMPLEXITY - O(N²), due to O(N/M) iterations with O(N * M) cost each, primarily from string searches and concatenations.
         *  SPACE COMPLEXITY - O(N), for temporary strings created during substring and concatenation operations.
         *
         *  partStartIndex will be start occurence of part in s string
         *  iteration 1
         *  1]partStartIndex will be 2
         *  part.length() 2 so
         *  2]it will assign string start from index 4 to end of string s to str
         *  3]s.substring(0,partStartIndex)+str
         *  here this is inclusive,
         *  str is exclusive
         * beginIndex = 0 (inclusive, starts at 'd').
         * endIndex = 2 (exclusive, stops before index 2, which is 'a').
         */
        while(s.contains(part)){
            int partStartIndex=s.indexOf(part);
            String str = s.substring(partStartIndex + part.length());
            s=s.substring(0,partStartIndex)+str;
        }
        return s;

    }


    public static String removeOccurrences1(String s, String part) {
        /**
         *
         *  BETTER NOT OPTIMAL
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
