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

        String[] answer = new String[n];
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0)
                answer[i-1] = "FIZZBUZZ";
            else if(i % 3 == 0)
                answer[i-1] = "FIZZ";
            else if(i % 5 == 0)
                answer[i-1] = "BUZZ";
            else
                answer[i-1] = String.valueOf(i);
        }
        return answer;
    }
}
