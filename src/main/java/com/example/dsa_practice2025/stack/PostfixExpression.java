package com.example.dsa_practice2025.stack;

import java.util.Stack;

public class PostfixExpression
{
    public static void main(String[] args) {
        System.out.println(evaluatePostfix("231*+9-"));
    }

    public static int evaluatePostfix(String expression) {
        /**
         *  Sample Input 2
         *  2 3 1 * + 9 -
         *
         *  Sample Output 2
         *  -4
         *  [2,3,1,*,+,9,-]
         *
         *  algorithm:
         *  1)declare stack of int
         *  2)convert str into array of char
         *  3)iterate str from 0 to n
         *  4)check current character is not operator
         *      1]push current character in stack
         *  5)otherwise
         *      1]pop top 2 operands from stack
         *      2]perform operation based on current operator
         *      3]store result back in stack
         *  6)end loop
         *  7)return stack peek element
         */
        Stack<Integer> stack = new Stack<>();
        for(char token : expression.toCharArray()) {
            if(!isOperator(token))
                stack.push(Integer.parseInt(String.valueOf(token)));
            else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(evalute(operand1,operand2,token));
            }
        }
        return stack.peek();
    }


    public static int evalute(int operand1,int operand2,char operator) {
        return switch (operator) {
            case '-' -> operand1 - operand2;
            case '+' -> operand1 + operand2;
            case '*' -> operand1 * operand2;
            case '/' -> operand1 / operand2;
            default -> Integer.MIN_VALUE;
        };
    }

    public static boolean isOperator(char ch) {
        return ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }
}
