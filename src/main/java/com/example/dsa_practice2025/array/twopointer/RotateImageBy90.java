package com.example.dsa_practice2025.array.twopointer;

public class RotateImageBy90
{
    public static void main(String[] args) {
        int[][] mat = rotateImage(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
//        int mat[][] = rotateImage(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]+"\t\t");
            }
            System.out.println();
        }
    }


    public static int[][] rotateImage(int[][] mat) {
        /**
         *  algorithm:
         *  step - 1,2,3 is transpose of matrix
         *  1)iterate row 0 to n
         *  2)iterate col i+1 to n
         *  3)swap mat with row,col to col,row
         *  4)end loop
         *  5)declare left init 0,right init n-1,row init 0
         *  6)iterate till left < right
         *  7)swap mat row,left with row,right
         *  8)left++,right--
         *  9)check row < n-1 and left >= right
         *      row++,left = 0,right=n-1
         *  10)end loop
         */
        transpose(mat);
        reverse(mat,mat.length);
        return mat;
    }

    public static void transpose(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = i+1; j < mat[0].length; j++) {
                swap(mat,i,j,j,i);
            }
        }
    }

    public static void swap(int[][] mat,int r1,int c1,int r2,int c2) {
        int temp = mat[r1][c1];
        mat[r1][c1] = mat[r2][c2];
        mat[r2][c2] = temp;
    }


    public static void reverse(int[][] mat,int n) {
        int left = 0, right = n-1,row = 0;
        while(left < right) {
            swap(mat,row,left,row,right);
            left++;
            right--;
            if(row < n-1 && left >= right) {
                row++;
                left = 0;
                right = n-1;
            }
        }
    }
}
