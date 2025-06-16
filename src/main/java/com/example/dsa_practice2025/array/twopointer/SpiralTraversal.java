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
         *
         *   00 01 02 03 04
         *   10 11 12 13 14
         *   20 21 22 23 24
         *   30 31 32 33 34
         *   40 41 42 43 44
         *
         *   rs = 1,rn = 4,cs = 0,ce = 3
         */
        int rs = 0,re = mat.length-1,cs = 0,ce = mat[0].length-1,iterator = 1,n = mat.length;
        List<Integer> answer = new ArrayList<>();
        while (iterator <= n * n) {
            for(int col = cs; col <= ce; col++) {
//                mat[rs][col] = iterator++;
                answer.add(iterator);
                iterator++;            }
            rs++;
            for(int row = rs; row <= re; row++) {
//                mat[row][ce] = iterator++;
                answer.add(iterator);
                iterator++;
            }
            ce--;
            if(rs <= re) {
                for(int col = ce; col >= 0; col--) {
//                    mat[re][col] = iterator++;
                    answer.add(iterator);
                    iterator++;
                }
                re--;
            }
            if(cs <= ce) {
                for(int row = re; row >= 0; row--) {
//                    mat[row][cs] = iterator++;
                    answer.add(iterator);
                    iterator++;
                }
                cs++;
            }
        }
        return answer;
    }
}
