package com.example.dsa_practice2025.array;

public class MagicSquare
{
    public static void main(String[] args) {
        System.out.println(checkMagicSquare(3,new int[][]{{4,9,2},{3,5,7},{8,1,6}}));
    }

    public static String checkMagicSquare(int size, int[][] grid) {
        /**
         * Sample Input 1
         * 3
         *
         * 4 9 2        00  01  02
         *
         * 3 5 7        10  11  12
         *
         * 8 1 6        20  21  22
         *
         * Sample Output 1
         * Yes
         *
         * algorithm:
         * 1)declare diagonalSum1=0,diagonalSum2 = 0
         * 2)iterate i from 0 to n
         *      1]cal dia1 += arr[i][i]
         *      2]cal dia2 += arr[i][n-i-1];
         * 3)end loop
         * 4)check diagonalSum1 != diagonalSum2 return 'NO'
         * 5)iterate i from 0 to n
         * 6)declare rowSum init 0
         * 7)iterate j from 0 to n
         * 8)rowSum += arr[j][i]
         * 9)end loop
         * 10)check diagonalSum1 != rowSum return 'NO'
         * 11)iterate i from 0 to n
         * 12)declare columnSum init 0
         * 13)iterate j from 0 to n
         * 14)colmnSum += arr[i][j]
         * 15)end loop
         * 16)check diagonalSum != columnSum return 'NO'
         * 17)end
         */
        int diagonalSum1 = 0,diagonalSum2 = 0,n = grid.length;
        for(int i = 0; i < n; i++) {
            diagonalSum1 += grid[i][i];
            diagonalSum2 += grid[i][n-i-1];
        }
        if(diagonalSum1 != diagonalSum2)
            return "NO";
        for(int i = 0; i < n; i++) {
            int rowSum = 0;
            for(int j = 0; j < n; j++) {
                rowSum += grid[j][i];
            }
            if(diagonalSum1 != rowSum)
                return "NO";
        }
        for(int i = 0; i < n; i++) {
            int columnSum = 0;
            for(int j = 0; j < n; j++) {
                columnSum += grid[i][j];
            }
            if(diagonalSum1 != columnSum)
                return "NO";
        }
        return "YES";
    }
}
