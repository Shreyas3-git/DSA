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
        transponse(mat);
        reverse(mat);
        return mat;
    }


    public static void transponse(int[][] mat) {
        for(int row = 0;row < mat.length; row++) {
            for(int col = row; col < mat[0].length; col++) {
                swap(mat,row,col,col,row);
            }
        }
    }

    public static void swap(int[][] mat,int r1,int c1,int r2,int c2) {
        int temp = mat[r1][c1];
        mat[r1][c1] = mat[r2][c2];
        mat[r2][c2] = temp;
    }

    public static void reverse(int[][] mat) {
        int rowSize = mat.length;
        int left = 0,right = rowSize-1,row = 0;
        while(left < right) {
            swap(mat,row,left,row,right);
            left++;
            right--;
            if(row < rowSize-1 && left >= right) {
                row++;
                left = 0;
                right = mat.length-1;
            }
        }
    }

}
