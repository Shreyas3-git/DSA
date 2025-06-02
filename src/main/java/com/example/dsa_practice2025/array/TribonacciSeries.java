package com.example.dsa_practice2025.array;

public class TribonacciSeries
{
    public static void main(String[] args) {
        System.out.println(tribonacciBasic(5));
    }

    static int tribonacciBasic(int n) {
        /**
         *  Iterative way
         */
//        int n1 = 0,n2 = 1,n3 = 1,nth = 0,count = 1;
//        while(count < n-1) {
//            nth = n1 + n2 + n3;
//            n1 = n2;
//            n2 = n3;
//            n3 = nth;
//            count++;
//        }
//        return nth;

        /**
         *  Recursive Way
         */
        if (n == 0 ) {
            return 0;
        } else if(n == 1 || n == 2)
            return 1;
        else
            return tribonacciBasic(n-1) + tribonacciBasic(n-2) + tribonacciBasic(n-3);
    }
}
