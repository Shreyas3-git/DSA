package com.example.dsa_practice2025.array;

import java.util.Arrays;

public class AdditionOfTwoMatrix
{
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(additionOfMatrix(2, 2, new int[][]{{1, 2}, {3, 4}}, new int[][]{{1, 1},{ 1, 1}})));
    }

    static int[][] additionOfMatrix(int n, int m, int[][] gridOne, int[][] gridTwo) {
        int[][] result = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                result[i][j] = gridOne[i][j] + gridTwo[i][j];
            }
        }
        return result;
    }
}
