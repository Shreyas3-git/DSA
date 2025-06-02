package com.example.dsa_practice2025.string;

import java.util.Arrays;

public class FizzBuzz
{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fizzBuzz(15)));
    }

    public static String[] fizzBuzz(int n) {

        /**
         *   algorithm :
         *   1)declare string[] of size n
         *   2)iterate i from 0 to n
         *   3)check (i + 1 ) % 3 && (i + 1) % 5 == 0
         *      1]store str[i] = fizzbuzz
         *   4)(i+1) % 3 == 0
         *      store str[i] = fizz
         *   5)(i + 1) % 5 == 0
         *      store str[i] = buzz
         *   6)otherwise
         *      store str[i] = i+1
         *   7)end loop
         *   8)return result
         */

        String[] out = new String[n];
        for (int i = 0;i < n; i++) {
            if ((i+1)%3 == 0 && (i+1) % 5 == 0)
                out[i] = "FIZZBUZZ";
            else if ((i+1) % 3 == 0)
                out[i] = "FIZZ";
            else if ((i+1) % 5 == 0)
                out[i] = "BUZZ";
            else
                out[i] = String.valueOf(i+1);
        }
        return out;
    }
}
