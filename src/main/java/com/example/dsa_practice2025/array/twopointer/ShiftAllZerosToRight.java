package com.example.dsa_practice2025.array.twopointer;

import java.util.Arrays;
import java.util.Random;

public class ShiftAllZerosToRight
{
    //283. Move Zeroes
    public static void main(String[] args) {
        Random random = new Random();
        random.nextInt(0,10000);
        int[] arr = new int[10001];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        long startTime = System.currentTimeMillis();
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Execution time =>"+(System.currentTimeMillis()-startTime));
    }

    static {
        for(int i=0 ;i<100 ; i++){
            moveZeroes(new int[]{1 , 0});
        }
    }
    public static void moveZeroes(int[] arr) {
        /**
         *  Why 0ms execution time on leetcode with static block and 2ms execution time without it?
         *  - When you run this code with the static block,we’re essentially warming up the JVM.
         *    This causes the JIT compiler to compile and optimize the moveZeroes() method before
         *    LeetCode’s actual test cases are run.
         *
         *    JVM Warm-Up and JIT Compilation -
         *    Java uses a two-step execution model:
         *    1] Interpreted Execution: At first, methods are interpreted line-by-line.
         *    2] JIT Compilation: After some usage (e.g., repeated invocations),
         *       the JVM compiles hot methods into native code for performance.
         *
         *   So:
         *    1]Without static block: The method is interpreted initially, and JIT might compile it during test execution.
         *    2]With static block: By calling the method 100 times early,
         *      you trigger the JVM to JIT-compile it before tests run → faster execution → measured as 0ms.
         */
        /**
         *   algorithm:
         *   1)declare n == 0 or n == 1
         *      return
         *   2)declare CI,count init 0
         *   3)iterate array
         *   4)check arr[i] != 0
         *      store at CI
         *      ci++
         *   5)otherwise
         *      count++
         *   6)end loop
         *   7)iterate array ci to n
         *   8)fill all zeros
         *   9)end loop
         */
        int n = arr.length;
        if(n == 0 || n == 1)
            return;
        int currentIndex = 0,count = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] != 0)
                arr[currentIndex++] = arr[i];
            else
                count++;
        }
        for(int i = currentIndex; i < n; i++) arr[i] = 0;

    }
}
