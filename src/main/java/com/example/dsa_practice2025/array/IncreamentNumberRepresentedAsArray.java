package com.example.dsa_practice2025.array;

import java.util.Arrays;

public class IncreamentNumberRepresentedAsArray
{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(incrementNumber(4, new int[]{9, 9, 9, 9})));
    }


    static int[] incrementNumber(int n, int arr[]) {
        /**
         *  algorithm:
         *  1)add 1 in n-1 place
         *  2)declare sum to 0,carry init 1
         *  3)iterate n-1 to 0
         *      1]cal sum = carry + arr[i]
         *      2]update arr[i] = sum % 10
         *      3]cal carry = sum / 10
         *      4]check carry == 0
         *          return arr;
         *  4)end loop
         *  5)create new array with n+1 size
         *  6)system.arraycopy(old_array,start_position,new_arr,1,n)
         *  7)new_arr[0] = carry
         *  8)return new_arr
         */
        int sum = 0,carry = 1;
        for(int i = n-1; i >= 0; i--) {
            sum = carry + arr[i];
            arr[i] = sum % 10;
            carry = sum / 10;
            if(carry == 0)
                return arr;
        }
        int[] result = new int[n+1];
        System.arraycopy(arr,0,result,1,n);
        result[0] = carry;
        return result;
    }
}
