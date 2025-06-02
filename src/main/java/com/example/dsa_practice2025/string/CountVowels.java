package com.example.dsa_practice2025.string;

public class CountVowels
{
    public static void main(String[] args) {
        System.out.println(countVowels("language"));
    }

    public static int countVowels(String s) {
        int count = 0;
        for(char ch : s.toCharArray()) {
            if(isVowels(ch))
                count++;
        }
        return count;
    }

    public static boolean isVowels(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u';
    }
}
