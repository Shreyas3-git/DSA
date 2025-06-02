package com.example.dsa_practice2025.array.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraversal
{
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        System.out.println((Arrays.toString(new List[]{spiralOrder(mat)})));
    }


    public static List<Integer> spiralOrder(int[][] mat) {
        /**
         *   TIME COMPLEXITY - O(N)
         *   EACH ELEMENT OF MATRIX WE TRAVERSE ONLY ONCE
         */
        List<Integer> answer = new ArrayList<>();
        int n = mat.length,m = mat[0].length;
        int rowStart = 0,rowEnd = n-1,colStart = 0,colEnd = m-1,iterable = 1;
        while (iterable <= n*m) {
            for(int col = colStart; col <= colEnd; col++) {
                answer.add(mat[rowStart][col]);
                iterable++;
            }
            rowStart++;
            for(int row = rowStart; row <= rowEnd; row++) {
                answer.add(mat[row][colEnd]);
                iterable++;
            }
            colEnd--;
            if(rowStart <= rowEnd) {
                for(int col = colEnd; col >= colStart; col--) {
                    answer.add(mat[rowEnd][col]);
                    iterable++;
                }
                rowEnd--;
            }
            if(colStart <= colEnd) {
                for(int row = rowEnd; row >= rowStart; row--) {
                    answer.add(mat[row][colStart]);
                    iterable++;
                }
                colStart++;
            }
        }
        return answer;
    }
}
