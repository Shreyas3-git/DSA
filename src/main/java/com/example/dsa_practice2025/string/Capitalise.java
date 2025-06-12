package com.example.dsa_practice2025.string;

public class Capitalise
{
    public static void main(String[] args) {
        System.out.println(capitalise("the quick Brown fox jumps over The lazy dog."));
    }


    static String capitalise(String str) {
        /**
         * Sample Input 1
         * the quick Brown fox jumps over The lazy dog.
         *
         * Sample Output 1
         * The Quick Brown Fox Jumps Over The Lazy Dog.
         *
         * algorithm:
         * 1)declare stringbuilder
         * 2)capitalise first letter and append to string builder
         * 3)iterate str from 0 to n
         * 4)check lowercase character is preceded by whitespace
         * 6)capitalise first letter and append to string builder
         * 7)otherwise
         * 8)append directly to builder
         * 9)end loop
         * 10)return result
         *
         */

        StringBuilder builder = new StringBuilder();
        int ascci = str.charAt(0) - 32;
        builder.append((char)ascci);
        for(int i = 1; i < str.length()-1; i++) {
            if(str.charAt(i-1) == ' ' && str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                ascci = str.charAt(i) - 32;
                builder.append((char)ascci);
            } else
                builder.append(str.charAt(i));
        }
        return builder.toString();
    }
}
