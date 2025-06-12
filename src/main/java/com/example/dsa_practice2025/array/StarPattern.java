package com.example.dsa_practice2025.array;

import java.util.Scanner;

public class StarPattern
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of star pattern");
        int n = sc.nextInt();

        String[] pattern = starPrinting(n);

        for (int i = 0; i < n; i++)
            System.out.println(pattern[i]);
    }


    static String[] starPrinting(int n) {
        /**
         *  algorithm:
         *  1)declare string[] of size n
         *  2)iterate i from 0 to n
         *  3)declare stringbuilder
         *  4)iterate j from 0 to i
         *  5)append star with empty space
         *  6)end inner loop
         *  7)store arr[i] = builder.toString().trim()
         *  8)end loop
         *  9)return result
         */
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < i; j++) {
                builder.append("*"+"\t");
            }
            answer[i] = builder.toString();
        }
        return answer;
    }
}
