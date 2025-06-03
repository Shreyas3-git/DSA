package com.example.dsa_practice2025.array;

public class SetMatrixRowsAndColumnsToZeros
{
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,0},{6,7,8}};
        new SetMatrixRowsAndColumnsToZeros().setMatrixZeroes(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0;j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"\t\t");
            }
            System.out.println();
        }

    }




    public void setMatrixZeroes(int[][] mat) {
        int m = mat.length,n = mat[0].length;
        boolean[] rowFlag = new boolean[m];
        boolean[] colFlag = new boolean[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            if(rowFlag[i])
                setRowToZero(mat,i);
        }
        for(int i = 0; i < n; i++) {
            if(colFlag[i])
                setColumnToZero(mat,i);
        }
    }

    public static void setRowToZero(int[][] mat,int row) {
        for(int i = 0; i < mat.length; i++)
            mat[row][i] =  0;
    }


    public static void setColumnToZero(int[][] mat,int col) {
        for(int i = 0; i < mat.length; i++)
            mat[i][col] =  0;
    }

}
