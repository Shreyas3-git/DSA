package com.example.dsa_practice2025.array;

import java.util.Scanner;

public class PyramidPriting
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of star pattern");
        int n = sc.nextInt();

        String[] pattern = pyramidPrinting(n);
        for (int i = 0; i < n; i++)
            System.out.println("\t"+pattern[i]);

    }



    public static String[] pyramidPrinting(int n) {
        /**
         *
         *               *
         *             *   *
         *            *  *   *
         *           *  *  *   *
         *          *  *  *  *   *
         *
         *  algorithm:
         *  1)declare str array of size n
         *  2)iterate i 0 to n
         *  3)declare stringbuilder
         *      1]iterate for adding leading whitespaces from space 0 to n-i-1
         *      add two leading whitespaces
         *      2]end loop
         *      3]iterate for pyramid print from j from 0 to j <= i
         *      4]append star
         *      5]check j < i
         *          I} add 3 trial whitespaces
         *      6]str[i] = builder.toString()
         *      7]end loop
         *  4)end loop
         *  5)return str
         */
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            int spaceLen = n-i-1;
            for(int space = 0;space < spaceLen; space++) {
                builder.append("  ");
            }
            for(int j = 0; j <= i; j++) {
                builder.append("*");
                if(j < i)
                    builder.append("   ");
            }
            answer[i] = builder.toString();
        }
        return answer;
    }

}
