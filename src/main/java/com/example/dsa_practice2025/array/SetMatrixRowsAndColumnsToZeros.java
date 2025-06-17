package com.example.dsa_practice2025.array;

public class SetMatrixRowsAndColumnsToZeros {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 0}, {6, 7, 8}};
        new SetMatrixRowsAndColumnsToZeros().setMatrixZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }

    }


    public void setMatrixZeroes(int[][] mat) {
        boolean[] rowFlag = new boolean[mat.length];
        boolean[] colFlag = new boolean[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }

        for (int row = 0; row < rowFlag.length; row++) {
            if (rowFlag[row])
                setRowsToZero(mat, row);
        }

        for (int col = 0; col < colFlag.length; col++) {
            if (colFlag[col])
                setcolsToZero(mat,col);
        }
    }

    public void setRowsToZero(int[][] mat, int row) {
        for (int col = 0; col < mat[0].length; col++) {
            mat[row][col] = 0;
        }
    }

    public void setcolsToZero(int[][] mat, int col) {
        for(int row = 0; row < mat.length; row++) {
            mat[row][col] = 0;
        }
    }

}
