package com.example.dsa_practice2025.array;

public class Factorial
{
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    static int factorial(int n) {
        int fact = 1;
        for(int i = n; i > 0; i--) {
            fact *= i;
        }
        return fact;
    }
}
