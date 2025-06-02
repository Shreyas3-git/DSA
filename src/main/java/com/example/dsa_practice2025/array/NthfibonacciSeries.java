package com.example.dsa_practice2025.array;

public class NthfibonacciSeries
{
    public static void main(String[] args) {
        System.out.println(nthFibonacciNumber(6));
    }

    public static int nthFibonacciNumber( int n) {
        /**
         *  Iterative way
         */
//         int n1 = 0, n2 = 1,nth = 0,count = 1;
//
//         while(count < n) {
//             nth = n1 + n2;
//             n1 = n2;
//             n2 = nth;
//             count++;
//         }
//         return nth;

        /**
         *  Recursive way
         */
        if (n == 0 || n == 1)
            return n;
        else
            return nthFibonacciNumber(n-1) + nthFibonacciNumber(n-2);
    }
}
